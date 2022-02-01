package cooperation.qzone;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class ShareElfFile$ElfHeader
{
  public static final int EI_CLASS = 4;
  public static final int EI_DATA = 5;
  private static final int EI_NINDENT = 16;
  public static final int EI_VERSION = 6;
  public static final int ELFCLASS32 = 1;
  public static final int ELFCLASS64 = 2;
  public static final int ELFDATA2LSB = 1;
  public static final int ELFDATA2MSB = 2;
  public static final int ET_CORE = 4;
  public static final int ET_DYN = 3;
  public static final int ET_EXEC = 2;
  public static final int ET_HIPROC = 65535;
  public static final int ET_LOPROC = 65280;
  public static final int ET_NONE = 0;
  public static final int ET_REL = 1;
  public static final int EV_CURRENT = 1;
  public final short eEhSize;
  public final long eEntry;
  public final int eFlags;
  public final byte[] eIndent = new byte[16];
  public final short eMachine;
  public final short ePhEntSize;
  public final short ePhNum;
  public final long ePhOff;
  public final short eShEntSize;
  public final short eShNum;
  public final long eShOff;
  public final short eShStrNdx;
  public final short eType;
  public final int eVersion;
  
  private ShareElfFile$ElfHeader(FileChannel paramFileChannel)
  {
    paramFileChannel.position(0L);
    paramFileChannel.read(ByteBuffer.wrap(this.eIndent));
    if ((this.eIndent[0] != 127) || (this.eIndent[1] != 69) || (this.eIndent[2] != 76) || (this.eIndent[3] != 70)) {
      throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.eIndent[0]), Byte.valueOf(this.eIndent[1]), Byte.valueOf(this.eIndent[2]), Byte.valueOf(this.eIndent[3]) }));
    }
    ShareElfFile.access$300(this.eIndent[4], 1, 2, "bad elf class: " + this.eIndent[4]);
    ShareElfFile.access$300(this.eIndent[5], 1, 2, "bad elf data encoding: " + this.eIndent[5]);
    int i;
    label222:
    ByteBuffer localByteBuffer;
    if (this.eIndent[4] == 1)
    {
      i = 36;
      localByteBuffer = ByteBuffer.allocate(i);
      if (this.eIndent[5] != 1) {
        break label382;
      }
    }
    label382:
    for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      ShareElfFile.readUntilLimit(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
      this.eType = localByteBuffer.getShort();
      this.eMachine = localByteBuffer.getShort();
      this.eVersion = localByteBuffer.getInt();
      ShareElfFile.access$300(this.eVersion, 1, 1, "bad elf version: " + this.eVersion);
      switch (this.eIndent[4])
      {
      default: 
        throw new IOException("Unexpected elf class: " + this.eIndent[4]);
        i = 48;
        break label222;
      }
    }
    this.eEntry = localByteBuffer.getInt();
    this.ePhOff = localByteBuffer.getInt();
    for (this.eShOff = localByteBuffer.getInt();; this.eShOff = localByteBuffer.getLong())
    {
      this.eFlags = localByteBuffer.getInt();
      this.eEhSize = localByteBuffer.getShort();
      this.ePhEntSize = localByteBuffer.getShort();
      this.ePhNum = localByteBuffer.getShort();
      this.eShEntSize = localByteBuffer.getShort();
      this.eShNum = localByteBuffer.getShort();
      this.eShStrNdx = localByteBuffer.getShort();
      return;
      this.eEntry = localByteBuffer.getLong();
      this.ePhOff = localByteBuffer.getLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile.ElfHeader
 * JD-Core Version:    0.7.0.1
 */