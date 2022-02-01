package cooperation.qzone;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ShareElfFile$SectionHeader
{
  public static final int SHF_ALLOC = 2;
  public static final int SHF_EXECINSTR = 4;
  public static final int SHF_MASKPROC = -268435456;
  public static final int SHF_WRITE = 1;
  public static final int SHN_ABS = 65521;
  public static final int SHN_COMMON = 65522;
  public static final int SHN_HIPROC = 65311;
  public static final int SHN_HIRESERVE = 65535;
  public static final int SHN_LOPROC = 65280;
  public static final int SHN_LORESERVE = 65280;
  public static final int SHN_UNDEF = 0;
  public static final int SHT_DYNAMIC = 6;
  public static final int SHT_DYNSYM = 11;
  public static final int SHT_HASH = 5;
  public static final int SHT_HIPROC = 2147483647;
  public static final int SHT_HIUSER = -1;
  public static final int SHT_LOPROC = 1879048192;
  public static final int SHT_LOUSER = -2147483648;
  public static final int SHT_NOBITS = 8;
  public static final int SHT_NOTE = 7;
  public static final int SHT_NULL = 0;
  public static final int SHT_PROGBITS = 1;
  public static final int SHT_REL = 9;
  public static final int SHT_RELA = 4;
  public static final int SHT_SHLIB = 10;
  public static final int SHT_STRTAB = 3;
  public static final int SHT_SYMTAB = 2;
  public final long shAddr;
  public final long shAddrAlign;
  public final long shEntSize;
  public final long shFlags;
  public final int shInfo;
  public final int shLink;
  public final int shName;
  public String shNameStr;
  public final long shOffset;
  public final long shSize;
  public final int shType;
  
  private ShareElfFile$SectionHeader(ByteBuffer paramByteBuffer, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IOException("Unexpected elf class: " + paramInt);
    case 1: 
      this.shName = paramByteBuffer.getInt();
      this.shType = paramByteBuffer.getInt();
      this.shFlags = paramByteBuffer.getInt();
      this.shAddr = paramByteBuffer.getInt();
      this.shOffset = paramByteBuffer.getInt();
      this.shSize = paramByteBuffer.getInt();
      this.shLink = paramByteBuffer.getInt();
      this.shInfo = paramByteBuffer.getInt();
      this.shAddrAlign = paramByteBuffer.getInt();
    }
    for (this.shEntSize = paramByteBuffer.getInt();; this.shEntSize = paramByteBuffer.getLong())
    {
      this.shNameStr = null;
      return;
      this.shName = paramByteBuffer.getInt();
      this.shType = paramByteBuffer.getInt();
      this.shFlags = paramByteBuffer.getLong();
      this.shAddr = paramByteBuffer.getLong();
      this.shOffset = paramByteBuffer.getLong();
      this.shSize = paramByteBuffer.getLong();
      this.shLink = paramByteBuffer.getInt();
      this.shInfo = paramByteBuffer.getInt();
      this.shAddrAlign = paramByteBuffer.getLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile.SectionHeader
 * JD-Core Version:    0.7.0.1
 */