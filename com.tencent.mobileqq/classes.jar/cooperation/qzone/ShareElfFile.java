package cooperation.qzone;

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
  public ShareElfFile.ElfHeader elfHeader = null;
  private final FileInputStream fis;
  public ShareElfFile.ProgramHeader[] programHeaders = null;
  public ShareElfFile.SectionHeader[] sectionHeaders = null;
  private final Map<String, ShareElfFile.SectionHeader> sectionNameToHeaderMap = new HashMap();
  
  public ShareElfFile(File paramFile)
  {
    this.fis = new FileInputStream(paramFile);
    Object localObject = this.fis.getChannel();
    this.elfHeader = new ShareElfFile.ElfHeader((FileChannel)localObject, null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.elfHeader.ePhEntSize);
    if (this.elfHeader.eIndent[5] == 1) {
      paramFile = ByteOrder.LITTLE_ENDIAN;
    } else {
      paramFile = ByteOrder.BIG_ENDIAN;
    }
    localByteBuffer.order(paramFile);
    ((FileChannel)localObject).position(this.elfHeader.ePhOff);
    this.programHeaders = new ShareElfFile.ProgramHeader[this.elfHeader.ePhNum];
    int j = 0;
    int i = 0;
    while (i < this.programHeaders.length)
    {
      readUntilLimit((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
      this.programHeaders[i] = new ShareElfFile.ProgramHeader(localByteBuffer, this.elfHeader.eIndent[4], null);
      i += 1;
    }
    ((FileChannel)localObject).position(this.elfHeader.eShOff);
    localByteBuffer.limit(this.elfHeader.eShEntSize);
    this.sectionHeaders = new ShareElfFile.SectionHeader[this.elfHeader.eShNum];
    i = 0;
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
    if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3)) {
      return;
    }
    throw new IOException(paramString);
  }
  
  /* Error */
  public static android.util.Pair<java.lang.Integer, java.lang.Throwable> checkOat(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 2	cooperation/qzone/ShareElfFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 186	cooperation/qzone/ShareElfFile:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokevirtual 189	cooperation/qzone/ShareElfFile:close	()V
    //   15: goto +12 -> 27
    //   18: astore_0
    //   19: ldc 36
    //   21: ldc 191
    //   23: aload_0
    //   24: invokestatic 197	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   27: new 199	android/util/Pair
    //   30: dup
    //   31: iconst_0
    //   32: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aconst_null
    //   36: invokespecial 208	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   39: areturn
    //   40: astore_0
    //   41: goto +147 -> 188
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +122 -> 173
    //   54: aload_2
    //   55: ldc 214
    //   57: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   60: ifeq +8 -> 68
    //   63: iconst_m1
    //   64: istore_1
    //   65: goto +108 -> 173
    //   68: aload_2
    //   69: ldc 222
    //   71: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +9 -> 83
    //   77: bipush 254
    //   79: istore_1
    //   80: goto +93 -> 173
    //   83: aload_2
    //   84: ldc 224
    //   86: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   89: ifeq +9 -> 98
    //   92: bipush 253
    //   94: istore_1
    //   95: goto +78 -> 173
    //   98: aload_2
    //   99: ldc 226
    //   101: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifeq +9 -> 113
    //   107: bipush 252
    //   109: istore_1
    //   110: goto +63 -> 173
    //   113: aload_2
    //   114: ldc 228
    //   116: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   119: ifeq +9 -> 128
    //   122: bipush 251
    //   124: istore_1
    //   125: goto +48 -> 173
    //   128: aload_2
    //   129: ldc 230
    //   131: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   134: ifeq +9 -> 143
    //   137: bipush 250
    //   139: istore_1
    //   140: goto +33 -> 173
    //   143: aload_2
    //   144: ldc 232
    //   146: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   149: ifeq +9 -> 158
    //   152: bipush 249
    //   154: istore_1
    //   155: goto +18 -> 173
    //   158: aload_2
    //   159: ldc 234
    //   161: invokevirtual 220	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   164: ifeq +26 -> 190
    //   167: bipush 248
    //   169: istore_1
    //   170: goto +3 -> 173
    //   173: new 199	android/util/Pair
    //   176: dup
    //   177: iload_1
    //   178: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aload_0
    //   182: invokespecial 208	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   185: astore_0
    //   186: aload_0
    //   187: areturn
    //   188: aload_0
    //   189: athrow
    //   190: sipush -1000
    //   193: istore_1
    //   194: goto -21 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramFile	File
    //   1	193	1	i	int
    //   49	110	2	str	String
    // Exception table:
    //   from	to	target	type
    //   11	15	18	java/io/IOException
    //   2	11	40	finally
    //   45	50	40	finally
    //   54	63	40	finally
    //   68	77	40	finally
    //   83	92	40	finally
    //   98	107	40	finally
    //   113	122	40	finally
    //   128	137	40	finally
    //   143	152	40	finally
    //   158	167	40	finally
    //   173	186	40	finally
    //   2	11	44	java/io/IOException
  }
  
  /* Error */
  public static int getFileTypeByMagic(File paramFile)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: astore_3
    //   4: new 65	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 67	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_3
    //   15: invokevirtual 246	java/io/InputStream:read	([B)I
    //   18: pop
    //   19: aload_3
    //   20: iconst_0
    //   21: baload
    //   22: bipush 100
    //   24: if_icmpne +35 -> 59
    //   27: aload_3
    //   28: iconst_1
    //   29: baload
    //   30: bipush 101
    //   32: if_icmpne +27 -> 59
    //   35: aload_3
    //   36: iconst_2
    //   37: baload
    //   38: bipush 121
    //   40: if_icmpne +19 -> 59
    //   43: aload_3
    //   44: iconst_3
    //   45: baload
    //   46: istore_1
    //   47: iload_1
    //   48: bipush 10
    //   50: if_icmpne +9 -> 59
    //   53: aload_2
    //   54: invokevirtual 247	java/io/InputStream:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_3
    //   60: iconst_0
    //   61: baload
    //   62: bipush 127
    //   64: if_icmpne +33 -> 97
    //   67: aload_3
    //   68: iconst_1
    //   69: baload
    //   70: bipush 69
    //   72: if_icmpne +25 -> 97
    //   75: aload_3
    //   76: iconst_2
    //   77: baload
    //   78: bipush 76
    //   80: if_icmpne +17 -> 97
    //   83: aload_3
    //   84: iconst_3
    //   85: baload
    //   86: bipush 70
    //   88: if_icmpne +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 247	java/io/InputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 247	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore_0
    //   104: goto +6 -> 110
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 247	java/io/InputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_0
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_0
    //   127: iconst_m1
    //   128: ireturn
    //   129: astore_2
    //   130: goto -12 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   46	5	1	i	int
    //   12	103	2	localFileInputStream	FileInputStream
    //   129	1	2	localThrowable	java.lang.Throwable
    //   3	81	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   13	19	103	finally
    //   0	13	107	finally
    //   53	57	120	java/lang/Throwable
    //   91	95	123	java/lang/Throwable
    //   97	101	126	java/lang/Throwable
    //   114	118	129	java/lang/Throwable
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
    if (i == paramByteBuffer.limit())
    {
      paramByteBuffer.flip();
      return;
    }
    paramFileChannel = new StringBuilder();
    paramFileChannel.append(paramString);
    paramFileChannel.append(" Rest bytes insufficient, expect to read ");
    paramFileChannel.append(paramByteBuffer.limit());
    paramFileChannel.append(" bytes but only ");
    paramFileChannel.append(i);
    paramFileChannel.append(" bytes were read.");
    throw new IOException(paramFileChannel.toString());
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
    FileChannel localFileChannel = this.fis.getChannel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed to read section: ");
    localStringBuilder.append(paramSectionHeader.shNameStr);
    readUntilLimit(localFileChannel, localByteBuffer, localStringBuilder.toString());
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
    FileChannel localFileChannel = this.fis.getChannel();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("failed to read segment (type: ");
    localStringBuilder.append(paramProgramHeader.pType);
    localStringBuilder.append(").");
    readUntilLimit(localFileChannel, localByteBuffer, localStringBuilder.toString());
    return localByteBuffer;
  }
  
  public boolean is32BitElf()
  {
    return this.elfHeader.eIndent[4] == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.ShareElfFile
 * JD-Core Version:    0.7.0.1
 */