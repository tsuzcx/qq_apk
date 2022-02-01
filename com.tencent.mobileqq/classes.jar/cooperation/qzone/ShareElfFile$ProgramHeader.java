package cooperation.qzone;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ShareElfFile$ProgramHeader
{
  public static final int PF_R = 4;
  public static final int PF_W = 2;
  public static final int PF_X = 1;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_HIPROC = 2147483647;
  public static final int PT_INTERP = 3;
  public static final int PT_LOAD = 1;
  public static final int PT_LOPROC = 1879048192;
  public static final int PT_NOTE = 4;
  public static final int PT_NULL = 0;
  public static final int PT_PHDR = 6;
  public static final int PT_SHLIB = 5;
  public final long pAlign;
  public final long pFileSize;
  public final int pFlags;
  public final long pMemSize;
  public final long pOffset;
  public final long pPddr;
  public final int pType;
  public final long pVddr;
  
  private ShareElfFile$ProgramHeader(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        this.pType = paramByteBuffer.getInt();
        this.pFlags = paramByteBuffer.getInt();
        this.pOffset = paramByteBuffer.getLong();
        this.pVddr = paramByteBuffer.getLong();
        this.pPddr = paramByteBuffer.getLong();
        this.pFileSize = paramByteBuffer.getLong();
        this.pMemSize = paramByteBuffer.getLong();
        this.pAlign = paramByteBuffer.getLong();
        return;
      }
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("Unexpected elf class: ");
      paramByteBuffer.append(paramInt);
      throw new IOException(paramByteBuffer.toString());
    }
    this.pType = paramByteBuffer.getInt();
    this.pOffset = paramByteBuffer.getInt();
    this.pVddr = paramByteBuffer.getInt();
    this.pPddr = paramByteBuffer.getInt();
    this.pFileSize = paramByteBuffer.getInt();
    this.pMemSize = paramByteBuffer.getInt();
    this.pFlags = paramByteBuffer.getInt();
    this.pAlign = paramByteBuffer.getInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile.ProgramHeader
 * JD-Core Version:    0.7.0.1
 */