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
    Object localObject = this.eIndent;
    if ((localObject[0] == 127) && (localObject[1] == 69) && (localObject[2] == 76) && (localObject[3] == 70))
    {
      int i = localObject[4];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bad elf class: ");
      ((StringBuilder)localObject).append(this.eIndent[4]);
      ShareElfFile.access$300(i, 1, 2, ((StringBuilder)localObject).toString());
      i = this.eIndent[5];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bad elf data encoding: ");
      ((StringBuilder)localObject).append(this.eIndent[5]);
      ShareElfFile.access$300(i, 1, 2, ((StringBuilder)localObject).toString());
      if (this.eIndent[4] == 1) {
        i = 36;
      } else {
        i = 48;
      }
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      if (this.eIndent[5] == 1) {
        localObject = ByteOrder.LITTLE_ENDIAN;
      } else {
        localObject = ByteOrder.BIG_ENDIAN;
      }
      localByteBuffer.order((ByteOrder)localObject);
      ShareElfFile.readUntilLimit(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
      this.eType = localByteBuffer.getShort();
      this.eMachine = localByteBuffer.getShort();
      this.eVersion = localByteBuffer.getInt();
      i = this.eVersion;
      paramFileChannel = new StringBuilder();
      paramFileChannel.append("bad elf version: ");
      paramFileChannel.append(this.eVersion);
      ShareElfFile.access$300(i, 1, 1, paramFileChannel.toString());
      i = this.eIndent[4];
      if (i != 1)
      {
        if (i == 2)
        {
          this.eEntry = localByteBuffer.getLong();
          this.ePhOff = localByteBuffer.getLong();
          this.eShOff = localByteBuffer.getLong();
        }
        else
        {
          paramFileChannel = new StringBuilder();
          paramFileChannel.append("Unexpected elf class: ");
          paramFileChannel.append(this.eIndent[4]);
          throw new IOException(paramFileChannel.toString());
        }
      }
      else
      {
        this.eEntry = localByteBuffer.getInt();
        this.ePhOff = localByteBuffer.getInt();
        this.eShOff = localByteBuffer.getInt();
      }
      this.eFlags = localByteBuffer.getInt();
      this.eEhSize = localByteBuffer.getShort();
      this.ePhEntSize = localByteBuffer.getShort();
      this.ePhNum = localByteBuffer.getShort();
      this.eShEntSize = localByteBuffer.getShort();
      this.eShNum = localByteBuffer.getShort();
      this.eShStrNdx = localByteBuffer.getShort();
      return;
    }
    throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.eIndent[0]), Byte.valueOf(this.eIndent[1]), Byte.valueOf(this.eIndent[2]), Byte.valueOf(this.eIndent[3]) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile.ElfHeader
 * JD-Core Version:    0.7.0.1
 */