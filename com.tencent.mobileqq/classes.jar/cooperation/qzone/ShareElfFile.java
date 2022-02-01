package cooperation.qzone;

import android.util.Pair;
import cooperation.qzone.util.QZLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile
  implements Closeable
{
  public static final int ERROR_CODE_BAD_ELF_CLASS = -2;
  public static final int ERROR_CODE_BAD_ELF_ENCODING = -3;
  public static final int ERROR_CODE_BAD_ELF_VERSION = -5;
  public static final int ERROR_CODE_BAD_MAGIC = -1;
  public static final int ERROR_CODE_FAIL_READ_PHDR = -7;
  public static final int ERROR_CODE_FAIL_READ_REST_EHDR = -4;
  public static final int ERROR_CODE_FAIL_READ_SHDR = -8;
  public static final int ERROR_CODE_FILE_NOT_EXISTS = -9;
  public static final int ERROR_CODE_UNEXPECTED_ELF_CALSS = -6;
  public static final int ERROR_CODE_UNKOWN = -1000;
  public static final int FILE_TYPE_ELF = 1;
  public static final int FILE_TYPE_ODEX = 0;
  public static final int FILE_TYPE_OTHERS = -1;
  private static final String TAG = "ShareElfFile";
  public ShareElfFile.ElfHeader elfHeader;
  private final FileInputStream fis;
  public ShareElfFile.ProgramHeader[] programHeaders;
  public ShareElfFile.SectionHeader[] sectionHeaders;
  private final Map<String, ShareElfFile.SectionHeader> sectionNameToHeaderMap = new HashMap();
  
  public ShareElfFile(File paramFile)
  {
    this.fis = new FileInputStream(paramFile);
    Object localObject = this.fis.getChannel();
    this.elfHeader = new ShareElfFile.ElfHeader((FileChannel)localObject, null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.elfHeader.ePhEntSize);
    if (this.elfHeader.eIndent[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.elfHeader.ePhOff);
      this.programHeaders = new ShareElfFile.ProgramHeader[this.elfHeader.ePhNum];
      i = 0;
      while (i < this.programHeaders.length)
      {
        readUntilLimit((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.programHeaders[i] = new ShareElfFile.ProgramHeader(localByteBuffer, this.elfHeader.eIndent[4], null);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.elfHeader.eShOff);
    localByteBuffer.limit(this.elfHeader.eShEntSize);
    this.sectionHeaders = new ShareElfFile.SectionHeader[this.elfHeader.eShNum];
    int i = 0;
    while (i < this.sectionHeaders.length)
    {
      readUntilLimit((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.sectionHeaders[i] = new ShareElfFile.SectionHeader(localByteBuffer, this.elfHeader.eIndent[4], null);
      i += 1;
    }
    if (this.elfHeader.eShStrNdx > 0)
    {
      paramFile = getSection(this.sectionHeaders[this.elfHeader.eShStrNdx]);
      localObject = this.sectionHeaders;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.shName);
        localByteBuffer.shNameStr = readCString(paramFile);
        this.sectionNameToHeaderMap.put(localByteBuffer.shNameStr, localByteBuffer);
        i += 1;
      }
    }
  }
  
  private static void assertInRange(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new IOException(paramString);
    }
  }
  
  public static Pair<Integer, Throwable> checkOat(File paramFile)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramFile = new ShareElfFile(paramFile);
        if (paramFile == null) {}
      }
      catch (IOException localIOException1)
      {
        paramFile = localIOException1.getMessage();
        if (paramFile == null) {
          continue;
        }
        if (!paramFile.startsWith("bad elf magic")) {
          continue;
        }
        i = -1;
        Pair localPair = new Pair(Integer.valueOf(i), localIOException1);
        paramFile = localPair;
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramFile)
        {
          QZLog.e("ShareElfFile", "", paramFile);
          return localPair;
        }
        if (!paramFile.startsWith("bad elf class")) {
          continue;
        }
        i = -2;
        continue;
        if (!paramFile.startsWith("bad elf data encoding")) {
          continue;
        }
        i = -3;
        continue;
        if (!paramFile.startsWith("failed to read rest part of ehdr")) {
          continue;
        }
        i = -4;
        continue;
        if (!paramFile.startsWith("bad elf version")) {
          continue;
        }
        i = -5;
        continue;
        if (!paramFile.startsWith("Unexpected elf class")) {
          continue;
        }
        i = -6;
        continue;
        if (!paramFile.startsWith("failed to read phdr")) {
          continue;
        }
        i = -7;
        continue;
        boolean bool = paramFile.startsWith("failed to read shdr");
        if (!bool) {
          continue;
        }
        i = -8;
        continue;
        i = -1000;
        continue;
      }
      finally
      {
        if (0 == 0) {
          break label232;
        }
      }
      try
      {
        paramFile.close();
        paramFile = new Pair(Integer.valueOf(0), null);
        return paramFile;
      }
      catch (IOException paramFile)
      {
        QZLog.e("ShareElfFile", "", paramFile);
      }
    }
    try
    {
      throw new NullPointerException();
      label232:
      throw paramFile;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        QZLog.e("ShareElfFile", "", localIOException2);
      }
    }
  }
  
  /* Error */
  public static int getFileTypeByMagic(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_4
    //   3: newarray byte
    //   5: astore 4
    //   7: new 59	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_3
    //   17: aload 4
    //   19: invokevirtual 249	java/io/InputStream:read	([B)I
    //   22: pop
    //   23: aload 4
    //   25: iconst_0
    //   26: baload
    //   27: bipush 100
    //   29: if_icmpne +46 -> 75
    //   32: aload 4
    //   34: iconst_1
    //   35: baload
    //   36: bipush 101
    //   38: if_icmpne +37 -> 75
    //   41: aload 4
    //   43: iconst_2
    //   44: baload
    //   45: bipush 121
    //   47: if_icmpne +28 -> 75
    //   50: aload 4
    //   52: iconst_3
    //   53: baload
    //   54: istore_1
    //   55: iload_1
    //   56: bipush 10
    //   58: if_icmpne +17 -> 75
    //   61: iload_2
    //   62: istore_1
    //   63: aload_3
    //   64: ifnull +9 -> 73
    //   67: aload_3
    //   68: invokevirtual 250	java/io/InputStream:close	()V
    //   71: iload_2
    //   72: istore_1
    //   73: iload_1
    //   74: ireturn
    //   75: aload 4
    //   77: iconst_0
    //   78: baload
    //   79: bipush 127
    //   81: if_icmpne +40 -> 121
    //   84: aload 4
    //   86: iconst_1
    //   87: baload
    //   88: bipush 69
    //   90: if_icmpne +31 -> 121
    //   93: aload 4
    //   95: iconst_2
    //   96: baload
    //   97: bipush 76
    //   99: if_icmpne +22 -> 121
    //   102: aload 4
    //   104: iconst_3
    //   105: baload
    //   106: bipush 70
    //   108: if_icmpne +13 -> 121
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 250	java/io/InputStream:close	()V
    //   119: iconst_1
    //   120: ireturn
    //   121: iconst_m1
    //   122: istore_1
    //   123: aload_3
    //   124: ifnull -51 -> 73
    //   127: aload_3
    //   128: invokevirtual 250	java/io/InputStream:close	()V
    //   131: iconst_m1
    //   132: ireturn
    //   133: astore_0
    //   134: iconst_m1
    //   135: ireturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: ifnull +7 -> 147
    //   143: aload_3
    //   144: invokevirtual 250	java/io/InputStream:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_0
    //   153: goto -34 -> 119
    //   156: astore_3
    //   157: goto -10 -> 147
    //   160: astore_0
    //   161: goto -22 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramFile	File
    //   54	69	1	i	int
    //   1	71	2	j	int
    //   15	129	3	localFileInputStream	FileInputStream
    //   156	1	3	localThrowable	Throwable
    //   5	98	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/lang/Throwable
    //   2	16	136	finally
    //   67	71	149	java/lang/Throwable
    //   115	119	152	java/lang/Throwable
    //   143	147	156	java/lang/Throwable
    //   16	23	160	finally
  }
  
  public static String readCString(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void readUntilLimit(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  public void close()
  {
    this.fis.close();
    this.sectionNameToHeaderMap.clear();
    this.programHeaders = null;
    this.sectionHeaders = null;
  }
  
  public FileChannel getChannel()
  {
    return this.fis.getChannel();
  }
  
  public ByteOrder getDataOrder()
  {
    if (this.elfHeader.eIndent[5] == 1) {
      return ByteOrder.LITTLE_ENDIAN;
    }
    return ByteOrder.BIG_ENDIAN;
  }
  
  public ByteBuffer getSection(ShareElfFile.SectionHeader paramSectionHeader)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramSectionHeader.shSize);
    this.fis.getChannel().position(paramSectionHeader.shOffset);
    readUntilLimit(this.fis.getChannel(), localByteBuffer, "failed to read section: " + paramSectionHeader.shNameStr);
    return localByteBuffer;
  }
  
  public ShareElfFile.SectionHeader getSectionHeaderByName(String paramString)
  {
    return (ShareElfFile.SectionHeader)this.sectionNameToHeaderMap.get(paramString);
  }
  
  public ByteBuffer getSegment(ShareElfFile.ProgramHeader paramProgramHeader)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramProgramHeader.pFileSize);
    this.fis.getChannel().position(paramProgramHeader.pOffset);
    readUntilLimit(this.fis.getChannel(), localByteBuffer, "failed to read segment (type: " + paramProgramHeader.pType + ").");
    return localByteBuffer;
  }
  
  public boolean is32BitElf()
  {
    return this.elfHeader.eIndent[4] == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile
 * JD-Core Version:    0.7.0.1
 */