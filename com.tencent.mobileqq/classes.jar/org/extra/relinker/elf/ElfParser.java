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
    if ((paramFile != null) && (paramFile.exists()))
    {
      this.channel = new FileInputStream(paramFile).getChannel();
      return;
    }
    throw new IllegalArgumentException("File is null or does not exist");
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
    paramHeader = new IllegalStateException("Could not map vma to file offset!");
    for (;;)
    {
      throw paramHeader;
    }
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
    if (readWord(localByteBuffer, 0L) == 1179403647L)
    {
      int i = readByte(localByteBuffer, 4L);
      boolean bool;
      if (readByte(localByteBuffer, 5L) == 2) {
        bool = true;
      } else {
        bool = false;
      }
      if (i == 1) {
        return new Elf32Header(bool, this);
      }
      if (i == 2) {
        return new Elf64Header(bool, this);
      }
      throw new IllegalStateException("Invalid class type!");
    }
    throw new IllegalArgumentException("Invalid ELF Magic!");
  }
  
  public List<String> parseNeededDependencies()
  {
    this.channel.position(0L);
    ArrayList localArrayList = new ArrayList();
    Elf.Header localHeader = parseHeader();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (localHeader.bigEndian) {
      localObject = ByteOrder.BIG_ENDIAN;
    } else {
      localObject = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order((ByteOrder)localObject);
    long l1 = localHeader.phnum;
    int i = 0;
    long l2 = l1;
    if (l1 == 65535L) {
      l2 = localHeader.getSectionHeader(0).info;
    }
    for (l1 = 0L; l1 < l2; l1 += 1L)
    {
      localObject = localHeader.getProgramHeader(l1);
      if (((Elf.ProgramHeader)localObject).type == 2L)
      {
        l1 = ((Elf.ProgramHeader)localObject).offset;
        break label138;
      }
    }
    l1 = 0L;
    label138:
    if (l1 == 0L) {
      return Collections.unmodifiableList(localArrayList);
    }
    Object localObject = new ArrayList();
    long l3 = 0L;
    for (;;)
    {
      Elf.DynamicStructure localDynamicStructure = localHeader.getDynamicStructure(l1, i);
      if (localDynamicStructure.tag == 1L) {
        ((List)localObject).add(Long.valueOf(localDynamicStructure.val));
      } else if (localDynamicStructure.tag == 5L) {
        l3 = localDynamicStructure.val;
      }
      i += 1;
      if (localDynamicStructure.tag == 0L)
      {
        if (l3 != 0L)
        {
          l1 = offsetFromVma(localHeader, l2, l3);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(readString(localByteBuffer, ((Long)((Iterator)localObject).next()).longValue() + l1));
          }
          return localArrayList;
        }
        throw new IllegalStateException("String table offset not found!");
      }
    }
  }
  
  protected void read(ByteBuffer paramByteBuffer, long paramLong, int paramInt)
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    long l = 0L;
    while (l < paramInt)
    {
      int i = this.channel.read(paramByteBuffer, paramLong + l);
      if (i != -1) {
        l += i;
      } else {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.extra.relinker.elf.ElfParser
 * JD-Core Version:    0.7.0.1
 */