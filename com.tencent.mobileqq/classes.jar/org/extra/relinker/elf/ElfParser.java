package org.extra.relinker.elf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ElfParser
  implements Closeable, Elf
{
  private final int MAGIC = 1179403647;
  private final FileChannel channel;
  
  public ElfParser(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      throw new IllegalArgumentException("File is null or does not exist");
    }
    this.channel = new FileInputStream(paramFile).getChannel();
  }
  
  private long offsetFromVma(Elf.Header paramHeader, long paramLong1, long paramLong2)
  {
    for (long l = 0L; l < paramLong1; l += 1L)
    {
      Elf.ProgramHeader localProgramHeader = paramHeader.getProgramHeader(l);
      if ((localProgramHeader.type == 1L) && (localProgramHeader.vaddr <= paramLong2) && (paramLong2 <= localProgramHeader.vaddr + localProgramHeader.memsz)) {
        return paramLong2 - localProgramHeader.vaddr + localProgramHeader.offset;
      }
    }
    throw new IllegalStateException("Could not map vma to file offset!");
  }
  
  public void close()
  {
    this.channel.close();
  }
  
  public Elf.Header parseHeader()
  {
    this.channel.position(0L);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (readWord(localByteBuffer, 0L) != 1179403647L) {
      throw new IllegalArgumentException("Invalid ELF Magic!");
    }
    int i = readByte(localByteBuffer, 4L);
    if (readByte(localByteBuffer, 5L) == 2) {}
    for (boolean bool = true; i == 1; bool = false) {
      return new Elf32Header(bool, this);
    }
    if (i == 2) {
      return new Elf64Header(bool, this);
    }
    throw new IllegalStateException("Invalid class type!");
  }
  
  public List<String> parseNeededDependencies()
  {
    this.channel.position(0L);
    ArrayList localArrayList = new ArrayList();
    Elf.Header localHeader = parseHeader();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    Object localObject;
    long l1;
    if (localHeader.bigEndian)
    {
      localObject = ByteOrder.BIG_ENDIAN;
      localByteBuffer.order((ByteOrder)localObject);
      l2 = localHeader.phnum;
      l1 = l2;
      if (l2 == 65535L) {
        l1 = localHeader.getSectionHeader(0).info;
      }
      l2 = 0L;
      label85:
      if (l2 >= l1) {
        break label329;
      }
      localObject = localHeader.getProgramHeader(l2);
      if (((Elf.ProgramHeader)localObject).type != 2L) {
        break label141;
      }
    }
    label141:
    label329:
    for (long l2 = ((Elf.ProgramHeader)localObject).offset;; l2 = 0L)
    {
      if (l2 == 0L)
      {
        return Collections.unmodifiableList(localArrayList);
        localObject = ByteOrder.LITTLE_ENDIAN;
        break;
        l2 += 1L;
        break label85;
      }
      int i = 0;
      localObject = new ArrayList();
      long l3 = 0L;
      Elf.DynamicStructure localDynamicStructure = localHeader.getDynamicStructure(l2, i);
      long l4;
      if (localDynamicStructure.tag == 1L)
      {
        ((List)localObject).add(Long.valueOf(localDynamicStructure.val));
        l4 = l3;
      }
      for (;;)
      {
        i += 1;
        l3 = l4;
        if (localDynamicStructure.tag != 0L) {
          break;
        }
        if (l4 != 0L) {
          break label265;
        }
        throw new IllegalStateException("String table offset not found!");
        l4 = l3;
        if (localDynamicStructure.tag == 5L) {
          l4 = localDynamicStructure.val;
        }
      }
      l1 = offsetFromVma(localHeader, l1, l4);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(readString(localByteBuffer, ((Long)((Iterator)localObject).next()).longValue() + l1));
      }
      return localArrayList;
    }
  }
  
  protected void read(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    int i;
    for (long l = 0L; l < paramInt; l += i)
    {
      i = this.channel.read(paramByteBuffer, paramLong + l);
      if (i == -1) {
        throw new EOFException();
      }
    }
    paramByteBuffer.position(0);
  }
  
  protected short readByte(ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramByteBuffer, paramLong, 1);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  protected int readHalf(ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramByteBuffer, paramLong, 2);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  protected long readLong(ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramByteBuffer, paramLong, 8);
    return paramByteBuffer.getLong();
  }
  
  protected String readString(ByteBuffer paramByteBuffer, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = readByte(paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    return localStringBuilder.toString();
  }
  
  protected long readWord(ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramByteBuffer, paramLong, 4);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.extra.relinker.elf.ElfParser
 * JD-Core Version:    0.7.0.1
 */