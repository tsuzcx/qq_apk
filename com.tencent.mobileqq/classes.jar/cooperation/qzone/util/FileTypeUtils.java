package cooperation.qzone.util;

public class FileTypeUtils
{
  /* Error */
  public static boolean a(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 13	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 20	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: new 22	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 25	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 29	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: astore_0
    //   32: bipush 6
    //   34: newarray byte
    //   36: astore_3
    //   37: aload_0
    //   38: lconst_0
    //   39: invokevirtual 35	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   42: pop
    //   43: aload_0
    //   44: aload_3
    //   45: invokestatic 41	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   48: invokevirtual 45	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   51: pop
    //   52: aload_3
    //   53: iconst_0
    //   54: baload
    //   55: bipush 55
    //   57: if_icmpne +45 -> 102
    //   60: aload_3
    //   61: iconst_1
    //   62: baload
    //   63: bipush 122
    //   65: if_icmpne +37 -> 102
    //   68: aload_3
    //   69: iconst_2
    //   70: baload
    //   71: bipush 188
    //   73: if_icmpne +29 -> 102
    //   76: aload_3
    //   77: iconst_3
    //   78: baload
    //   79: bipush 175
    //   81: if_icmpne +21 -> 102
    //   84: aload_3
    //   85: iconst_4
    //   86: baload
    //   87: bipush 39
    //   89: if_icmpne +13 -> 102
    //   92: aload_3
    //   93: iconst_5
    //   94: baload
    //   95: istore_1
    //   96: iload_1
    //   97: bipush 28
    //   99: if_icmpeq +13 -> 112
    //   102: aload_2
    //   103: ifnull -87 -> 16
    //   106: aload_2
    //   107: invokevirtual 48	java/io/FileInputStream:close	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 48	java/io/FileInputStream:close	()V
    //   120: iconst_1
    //   121: ireturn
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 48	java/io/FileInputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -11 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramString	java.lang.String
    //   95	5	1	i	int
    //   26	104	2	localFileInputStream	java.io.FileInputStream
    //   36	57	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	27	122	finally
    //   27	52	135	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.FileTypeUtils
 * JD-Core Version:    0.7.0.1
 */