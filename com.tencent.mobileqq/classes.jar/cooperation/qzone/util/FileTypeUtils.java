package cooperation.qzone.util;

public class FileTypeUtils
{
  public static final String TAG = "FileTypeUtils";
  
  /* Error */
  public static boolean isSevenZip(String paramString)
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 24	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 26	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 29	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 33	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: astore_2
    //   32: bipush 6
    //   34: newarray byte
    //   36: astore_3
    //   37: aload_2
    //   38: lconst_0
    //   39: invokevirtual 39	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   42: pop
    //   43: aload_2
    //   44: aload_3
    //   45: invokestatic 45	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   48: invokevirtual 49	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   51: pop
    //   52: aload_3
    //   53: iconst_0
    //   54: baload
    //   55: bipush 55
    //   57: if_icmpne +54 -> 111
    //   60: aload_3
    //   61: iconst_1
    //   62: baload
    //   63: bipush 122
    //   65: if_icmpne +46 -> 111
    //   68: aload_3
    //   69: iconst_2
    //   70: baload
    //   71: bipush 188
    //   73: if_icmpne +38 -> 111
    //   76: aload_3
    //   77: iconst_3
    //   78: baload
    //   79: bipush 175
    //   81: if_icmpne +30 -> 111
    //   84: aload_3
    //   85: iconst_4
    //   86: baload
    //   87: bipush 39
    //   89: if_icmpne +22 -> 111
    //   92: aload_3
    //   93: iconst_5
    //   94: baload
    //   95: istore_1
    //   96: iload_1
    //   97: bipush 28
    //   99: if_icmpeq +6 -> 105
    //   102: goto +9 -> 111
    //   105: aload_0
    //   106: invokevirtual 52	java/io/FileInputStream:close	()V
    //   109: iconst_1
    //   110: ireturn
    //   111: aload_0
    //   112: invokevirtual 52	java/io/FileInputStream:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_2
    //   118: goto +6 -> 124
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 52	java/io/FileInputStream:close	()V
    //   132: aload_2
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   95	5	1	i	int
    //   31	13	2	localFileChannel	java.nio.channels.FileChannel
    //   117	1	2	localObject1	Object
    //   121	12	2	localObject2	Object
    //   36	57	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	52	117	finally
    //   18	27	121	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.FileTypeUtils
 * JD-Core Version:    0.7.0.1
 */