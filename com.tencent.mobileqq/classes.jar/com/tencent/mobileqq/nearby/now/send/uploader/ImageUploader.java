package com.tencent.mobileqq.nearby.now.send.uploader;

import aevt;
import aevu;
import aevv;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class ImageUploader
{
  public QQAppInterface a;
  
  public ImageUploader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static int a(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static File a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = new File(paramString);
    try
    {
      if (!localFile.exists())
      {
        int i = paramString.lastIndexOf('/');
        if ((i > 0) && (i < paramString.length() - 1))
        {
          paramString = new File(paramString.substring(0, i));
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
        }
      }
      for (;;)
      {
        localFile.createNewFile();
        return localFile;
        localFile.delete();
      }
      return null;
    }
    catch (IOException paramString) {}
  }
  
  private String a(int paramInt, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = HexUtil.hexStr2Bytes(MD5FileUtil.a(new File(paramString)));
    OutBuffer localOutBuffer = new OutBuffer();
    if (2 == paramInt) {
      localOutBuffer.a(4);
    }
    for (;;)
    {
      localOutBuffer.a(paramLong);
      localOutBuffer.a(0L);
      localOutBuffer.a(paramArrayOfByte.length);
      localOutBuffer.a(paramArrayOfByte);
      localOutBuffer.a(arrayOfByte);
      localOutBuffer.a(arrayOfByte);
      localOutBuffer.b(641);
      localOutBuffer.b(641);
      localOutBuffer.a(b(paramString));
      localOutBuffer.b(new File(paramString).getName().getBytes());
      localOutBuffer.b(641);
      localOutBuffer.b(0);
      return a(localOutBuffer.a()).toUpperCase();
      if (1 == paramInt) {
        localOutBuffer.a(5);
      } else {
        localOutBuffer.a(18);
      }
    }
  }
  
  /* Error */
  private String a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: aconst_null
    //   5: astore_1
    //   6: aload_1
    //   7: areturn
    //   8: new 31	java/io/File
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 38	java/io/File:exists	()Z
    //   21: ifne +8 -> 29
    //   24: aload_2
    //   25: invokestatic 105	com/tencent/mobileqq/nearby/now/send/uploader/ImageUploader:a	(Ljava/lang/String;)Ljava/io/File;
    //   28: pop
    //   29: new 107	java/io/FileOutputStream
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload_1
    //   43: getstatic 116	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   46: bipush 100
    //   48: aload 4
    //   50: invokevirtual 122	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   53: pop
    //   54: aload_2
    //   55: astore_1
    //   56: aload 4
    //   58: ifnull -52 -> 6
    //   61: aload 4
    //   63: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   66: aload_2
    //   67: areturn
    //   68: astore_1
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_3
    //   76: aload_2
    //   77: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   80: aload_1
    //   81: ifnull +7 -> 88
    //   84: aload_1
    //   85: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: goto -16 -> 88
    //   107: astore_2
    //   108: goto -7 -> 101
    //   111: astore_1
    //   112: goto -19 -> 93
    //   115: astore_2
    //   116: aload 4
    //   118: astore_1
    //   119: goto -45 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	ImageUploader
    //   0	122	1	paramBitmap	android.graphics.Bitmap
    //   0	122	2	paramString	String
    //   16	82	3	localObject	Object
    //   37	80	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   61	66	68	java/io/IOException
    //   17	29	71	java/io/IOException
    //   29	39	71	java/io/IOException
    //   17	29	90	finally
    //   29	39	90	finally
    //   84	88	103	java/io/IOException
    //   97	101	107	java/io/IOException
    //   42	54	111	finally
    //   76	80	111	finally
    //   42	54	115	java/io/IOException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: new 140	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: astore_0
    //   15: aload_3
    //   16: astore_1
    //   17: aload_2
    //   18: invokevirtual 146	java/io/InputStream:available	()I
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_2
    //   25: astore_0
    //   26: aload_3
    //   27: astore_1
    //   28: aload_2
    //   29: aload_3
    //   30: invokevirtual 150	java/io/InputStream:read	([B)I
    //   33: pop
    //   34: aload_3
    //   35: astore_0
    //   36: aload_2
    //   37: ifnull +9 -> 46
    //   40: aload_2
    //   41: invokevirtual 151	java/io/InputStream:close	()V
    //   44: aload_3
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +11 -> 58
    //   50: ldc 153
    //   52: iconst_1
    //   53: ldc 155
    //   55: invokestatic 161	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: iconst_2
    //   60: invokestatic 167	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   63: areturn
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   69: aload_3
    //   70: astore_0
    //   71: goto -25 -> 46
    //   74: astore_3
    //   75: aconst_null
    //   76: astore_2
    //   77: aload_2
    //   78: astore_0
    //   79: aload_3
    //   80: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: ifnull -40 -> 46
    //   89: aload_2
    //   90: invokevirtual 151	java/io/InputStream:close	()V
    //   93: aload_1
    //   94: astore_0
    //   95: goto -49 -> 46
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   103: aload_1
    //   104: astore_0
    //   105: goto -59 -> 46
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 151	java/io/InputStream:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 128	java/io/IOException:printStackTrace	()V
    //   126: goto -7 -> 119
    //   129: astore_1
    //   130: goto -19 -> 111
    //   133: astore_3
    //   134: goto -57 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   3	101	1	arrayOfByte1	byte[]
    //   108	12	1	localObject1	Object
    //   129	1	1	localObject2	Object
    //   12	78	2	localFileInputStream	java.io.FileInputStream
    //   1	69	3	arrayOfByte2	byte[]
    //   74	6	3	localIOException1	IOException
    //   133	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   40	44	64	java/io/IOException
    //   4	13	74	java/io/IOException
    //   89	93	98	java/io/IOException
    //   4	13	108	finally
    //   115	119	121	java/io/IOException
    //   17	24	129	finally
    //   28	34	129	finally
    //   79	83	129	finally
    //   17	24	133	java/io/IOException
    //   28	34	133	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(ImageUploader.OnResultListener paramOnResultListener, int paramInt, String paramString)
  {
    if (paramOnResultListener != null) {
      ThreadManager.getUIHandler().post(new aevv(this, paramOnResultListener, paramInt, paramString));
    }
  }
  
  private int b(String paramString)
  {
    paramString = c(paramString);
    if (paramString.compareToIgnoreCase("jpg") == 0) {
      return 1;
    }
    if (paramString.compareToIgnoreCase("gif") == 0) {
      return 2;
    }
    if (paramString.compareToIgnoreCase("png") == 0) {
      return 3;
    }
    return 0;
  }
  
  private String b(String paramString)
  {
    int i = 0;
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "JPG";
    arrayOfString[1] = "JPEG";
    arrayOfString[2] = "GIF";
    arrayOfString[3] = "PNG";
    arrayOfString[4] = "BMP";
    paramString = c(paramString);
    while (i < arrayOfString.length)
    {
      if (arrayOfString[i].compareToIgnoreCase(paramString) == 0) {
        return new String[] { "image/jpeg", "image/jpeg", "image/gif", "image/png", "image/x-ms-bmp" }[i];
      }
      i += 1;
    }
    return "";
  }
  
  /* Error */
  private String c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_3
    //   6: anewarray 17	java/lang/String
    //   9: astore 5
    //   11: aload 5
    //   13: iconst_0
    //   14: ldc 245
    //   16: aastore
    //   17: aload 5
    //   19: iconst_1
    //   20: ldc 247
    //   22: aastore
    //   23: aload 5
    //   25: iconst_2
    //   26: ldc 249
    //   28: aastore
    //   29: new 140	java/io/FileInputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: iconst_3
    //   39: newarray byte
    //   41: astore_3
    //   42: aload_1
    //   43: aload_3
    //   44: iconst_0
    //   45: aload_3
    //   46: arraylength
    //   47: invokevirtual 252	java/io/FileInputStream:read	([BII)I
    //   50: pop
    //   51: aload_3
    //   52: invokestatic 255	com/tencent/mobileqq/nearby/now/utils/CommentsUtil:a	([B)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore 4
    //   59: aload 4
    //   61: astore_3
    //   62: aload_1
    //   63: ifnull +10 -> 73
    //   66: aload_1
    //   67: invokevirtual 256	java/io/FileInputStream:close	()V
    //   70: aload 4
    //   72: astore_3
    //   73: aload_3
    //   74: ifnonnull +50 -> 124
    //   77: ldc 169
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_1
    //   83: aload 4
    //   85: astore_3
    //   86: aload_1
    //   87: ifnull -14 -> 73
    //   90: aload_1
    //   91: invokevirtual 256	java/io/FileInputStream:close	()V
    //   94: aload 4
    //   96: astore_3
    //   97: goto -24 -> 73
    //   100: astore_1
    //   101: aload 4
    //   103: astore_3
    //   104: goto -31 -> 73
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 256	java/io/FileInputStream:close	()V
    //   118: aload_3
    //   119: athrow
    //   120: iload_2
    //   121: iconst_1
    //   122: iadd
    //   123: istore_2
    //   124: iload_2
    //   125: aload 5
    //   127: arraylength
    //   128: if_icmpge +36 -> 164
    //   131: aload 5
    //   133: iload_2
    //   134: aaload
    //   135: aload_3
    //   136: invokevirtual 220	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   139: ifne -19 -> 120
    //   142: iconst_3
    //   143: anewarray 17	java/lang/String
    //   146: dup
    //   147: iconst_0
    //   148: ldc 217
    //   150: aastore
    //   151: dup
    //   152: iconst_1
    //   153: ldc 224
    //   155: aastore
    //   156: dup
    //   157: iconst_2
    //   158: ldc 222
    //   160: aastore
    //   161: iload_2
    //   162: aaload
    //   163: areturn
    //   164: ldc 169
    //   166: areturn
    //   167: astore_1
    //   168: aload 4
    //   170: astore_3
    //   171: goto -98 -> 73
    //   174: astore_1
    //   175: goto -57 -> 118
    //   178: astore_3
    //   179: goto -69 -> 110
    //   182: astore_3
    //   183: goto -100 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	ImageUploader
    //   0	186	1	paramString	String
    //   4	158	2	i	int
    //   41	63	3	localObject1	Object
    //   107	29	3	str	String
    //   170	1	3	localObject2	Object
    //   178	1	3	localObject3	Object
    //   182	1	3	localException	java.lang.Exception
    //   1	168	4	localObject4	Object
    //   9	123	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   29	38	80	java/lang/Exception
    //   90	94	100	java/io/IOException
    //   29	38	107	finally
    //   66	70	167	java/io/IOException
    //   114	118	174	java/io/IOException
    //   38	56	178	finally
    //   38	56	182	java/lang/Exception
  }
  
  public boolean a(int paramInt, String paramString, ImageUploader.OnResultListener paramOnResultListener)
  {
    if (paramString == null) {
      a(paramOnResultListener, -2, "");
    }
    TicketManager localTicketManager = (TicketManager)this.a.getManager(2);
    ThreadManager.post(new aevt(this, paramInt, paramString, localTicketManager.getSt(this.a.getCurrentAccountUin(), 16), localTicketManager, paramOnResultListener), 5, null, false);
    return true;
  }
  
  public boolean b(int paramInt, String paramString, ImageUploader.OnResultListener paramOnResultListener)
  {
    if (paramString == null) {
      a(paramOnResultListener, -2, "");
    }
    TicketManager localTicketManager = (TicketManager)this.a.getManager(2);
    byte[] arrayOfByte = localTicketManager.getSt(this.a.getCurrentAccountUin(), 16);
    ThreadManager.post(new aevu(this, paramString, paramInt, this.a.getLongAccountUin(), arrayOfByte, localTicketManager, paramOnResultListener), 5, null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.uploader.ImageUploader
 * JD-Core Version:    0.7.0.1
 */