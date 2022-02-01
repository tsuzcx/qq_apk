package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SVUtils
{
  public static boolean a = false;
  public static String b;
  private static boolean c = true;
  
  public static String a()
  {
    if (b == null) {
      b = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH);
    }
    return b;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 6)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 20)
          {
            switch (paramInt)
            {
            default: 
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(" [TYPE_NONE ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" ]");
              return localStringBuilder.toString();
            case 18: 
              return " [TYPE_VIDEO_THUMB_DISUSS] ";
            case 17: 
              return " [TYPE_VIDEO_DISUSS]";
            }
            return " [TYPE_VIDEO_THUMB_TROOP] ";
          }
          return " [TYPE_VIDEO_FORWARD] ";
        }
        return " [TYPE_VIDEO_TROOP]";
      }
      return " [TYPE_VIDEO_THUMB_C2C] ";
    }
    return " [TYPE_VIDEO_C2C] ";
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop != 1) && (paramMessageForShortVideo.istroop != 3000)) {
      return paramMessageForShortVideo.frienduin;
    }
    return paramMessageForShortVideo.senderuin;
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    String str1 = b(paramMessageForShortVideo, paramString);
    int j = paramMessageForShortVideo.videoFileStatus;
    int i = 0;
    boolean bool1;
    if ((j != 1004) && (j != 2004) && (j != 5001) && (j != 5002)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      bool2 = bool1;
      if (FileUtils.fileExistsAndNotEmpty(str1)) {
        bool2 = false;
      }
    }
    String str2 = a(paramMessageForShortVideo.getMd5());
    paramMessageForShortVideo = new File(str2);
    if (!paramMessageForShortVideo.exists())
    {
      paramMessageForShortVideo.mkdirs();
      paramMessageForShortVideo = new StringBuilder();
      paramMessageForShortVideo.append(str2);
      paramMessageForShortVideo.append(".nomedia");
      FileUtils.createFileIfNotExits(paramMessageForShortVideo.toString());
      return str1;
    }
    String[] arrayOfString = paramMessageForShortVideo.list();
    paramString = null;
    paramMessageForShortVideo = paramString;
    if (arrayOfString != null)
    {
      paramMessageForShortVideo = paramString;
      if (arrayOfString.length > 0)
      {
        int k = arrayOfString.length;
        for (;;)
        {
          paramMessageForShortVideo = paramString;
          if (i >= k) {
            break;
          }
          paramMessageForShortVideo = arrayOfString[i];
          if ((!paramMessageForShortVideo.endsWith(".tmp")) && (!paramMessageForShortVideo.equals(".nomedia")))
          {
            paramString = new StringBuilder();
            paramString.append(str2);
            paramString.append(paramMessageForShortVideo);
            paramMessageForShortVideo = paramString.toString();
            break;
          }
          i += 1;
        }
      }
    }
    if ((bool2) && (paramMessageForShortVideo != null) && (!new File(str1).exists()))
    {
      long l1 = System.currentTimeMillis();
      if (paramMessageForShortVideo.equals(str1)) {
        return str1;
      }
      FileUtils.copyFile(paramMessageForShortVideo, str1);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("copy ");
        paramString.append(paramMessageForShortVideo);
        paramString.append(" to ");
        paramString.append(str1);
        QLog.i("SVUtils", 2, paramString.toString());
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramMessageForShortVideo = new StringBuilder();
        paramMessageForShortVideo.append("getShortVideoSavePath-----time: = ");
        paramMessageForShortVideo.append(l2 - l1);
        paramMessageForShortVideo.append(", videoStatus:");
        paramMessageForShortVideo.append(b(j));
        paramMessageForShortVideo.append(", needCopy=");
        paramMessageForShortVideo.append(bool2);
        QLog.d("SVUtils", 2, paramMessageForShortVideo.toString());
      }
    }
    return str1;
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: astore 10
    //   5: iconst_4
    //   6: newarray byte
    //   8: astore 11
    //   10: bipush 8
    //   12: invokestatic 185	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   15: astore 12
    //   17: new 187	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore 9
    //   27: lconst_0
    //   28: lstore 5
    //   30: iconst_0
    //   31: istore_1
    //   32: iconst_0
    //   33: istore_2
    //   34: lload 5
    //   36: lstore 7
    //   38: iload_1
    //   39: bipush 100
    //   41: if_icmpge +202 -> 243
    //   44: aload 9
    //   46: astore_0
    //   47: aload 9
    //   49: aload 10
    //   51: invokevirtual 196	java/io/InputStream:read	([B)I
    //   54: istore_3
    //   55: iload_3
    //   56: ifgt +10 -> 66
    //   59: lload 5
    //   61: lstore 7
    //   63: goto +180 -> 243
    //   66: aload 9
    //   68: astore_0
    //   69: aload 12
    //   71: iconst_4
    //   72: newarray byte
    //   74: invokevirtual 200	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   77: pop
    //   78: aload 9
    //   80: astore_0
    //   81: aload 12
    //   83: aload 10
    //   85: invokevirtual 200	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   88: pop
    //   89: aload 9
    //   91: astore_0
    //   92: aload 12
    //   94: invokevirtual 204	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   97: pop
    //   98: aload 9
    //   100: astore_0
    //   101: aload 12
    //   103: invokevirtual 207	java/nio/ByteBuffer:getLong	()J
    //   106: lstore 7
    //   108: aload 9
    //   110: astore_0
    //   111: iload_3
    //   112: aload 9
    //   114: aload 11
    //   116: invokevirtual 196	java/io/InputStream:read	([B)I
    //   119: iadd
    //   120: istore 4
    //   122: iload 4
    //   124: istore_3
    //   125: lload 7
    //   127: lstore 5
    //   129: lload 7
    //   131: lconst_1
    //   132: lcmp
    //   133: ifne +210 -> 343
    //   136: aload 9
    //   138: astore_0
    //   139: bipush 8
    //   141: newarray byte
    //   143: astore 13
    //   145: aload 9
    //   147: astore_0
    //   148: iload 4
    //   150: aload 9
    //   152: aload 13
    //   154: invokevirtual 196	java/io/InputStream:read	([B)I
    //   157: iadd
    //   158: istore_3
    //   159: aload 9
    //   161: astore_0
    //   162: aload 12
    //   164: invokevirtual 210	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   167: pop
    //   168: aload 9
    //   170: astore_0
    //   171: aload 12
    //   173: aload 13
    //   175: invokevirtual 200	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   178: pop
    //   179: aload 9
    //   181: astore_0
    //   182: aload 12
    //   184: invokevirtual 204	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   187: pop
    //   188: aload 9
    //   190: astore_0
    //   191: aload 12
    //   193: invokevirtual 207	java/nio/ByteBuffer:getLong	()J
    //   196: lstore 5
    //   198: goto +145 -> 343
    //   201: aload 9
    //   203: astore_0
    //   204: aload 9
    //   206: lload 5
    //   208: iload_3
    //   209: i2l
    //   210: lsub
    //   211: invokevirtual 214	java/io/InputStream:skip	(J)J
    //   214: pop2
    //   215: iload_2
    //   216: i2l
    //   217: lload 5
    //   219: ladd
    //   220: l2i
    //   221: istore_2
    //   222: aload 9
    //   224: astore_0
    //   225: aload 12
    //   227: invokevirtual 210	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   230: pop
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: goto -201 -> 34
    //   238: astore 10
    //   240: goto +53 -> 293
    //   243: aload 9
    //   245: invokevirtual 217	java/io/InputStream:close	()V
    //   248: new 34	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   255: astore_0
    //   256: aload_0
    //   257: iload_2
    //   258: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload_0
    //   263: ldc 219
    //   265: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: lload 7
    //   272: invokevirtual 164	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: areturn
    //   281: astore 9
    //   283: aconst_null
    //   284: astore_0
    //   285: goto +30 -> 315
    //   288: astore 10
    //   290: aconst_null
    //   291: astore 9
    //   293: aload 9
    //   295: astore_0
    //   296: aload 10
    //   298: invokevirtual 222	java/lang/Exception:printStackTrace	()V
    //   301: aload 9
    //   303: ifnull +8 -> 311
    //   306: aload 9
    //   308: invokevirtual 217	java/io/InputStream:close	()V
    //   311: aconst_null
    //   312: areturn
    //   313: astore 9
    //   315: aload_0
    //   316: ifnull +7 -> 323
    //   319: aload_0
    //   320: invokevirtual 217	java/io/InputStream:close	()V
    //   323: goto +6 -> 329
    //   326: aload 9
    //   328: athrow
    //   329: goto -3 -> 326
    //   332: astore_0
    //   333: goto -85 -> 248
    //   336: astore_0
    //   337: aconst_null
    //   338: areturn
    //   339: astore_0
    //   340: goto -17 -> 323
    //   343: aload 11
    //   345: iconst_0
    //   346: baload
    //   347: i2c
    //   348: bipush 109
    //   350: if_icmpne -149 -> 201
    //   353: aload 11
    //   355: iconst_1
    //   356: baload
    //   357: i2c
    //   358: bipush 111
    //   360: if_icmpne -159 -> 201
    //   363: aload 11
    //   365: iconst_2
    //   366: baload
    //   367: i2c
    //   368: bipush 111
    //   370: if_icmpne -169 -> 201
    //   373: aload 11
    //   375: iconst_3
    //   376: baload
    //   377: i2c
    //   378: bipush 118
    //   380: if_icmpne -179 -> 201
    //   383: lload 5
    //   385: lstore 7
    //   387: goto -144 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	paramFile	File
    //   31	204	1	i	int
    //   33	225	2	j	int
    //   54	155	3	k	int
    //   120	38	4	m	int
    //   28	356	5	l1	long
    //   36	350	7	l2	long
    //   25	219	9	localFileInputStream	java.io.FileInputStream
    //   281	1	9	localObject1	Object
    //   291	16	9	localObject2	Object
    //   313	14	9	localObject3	Object
    //   3	81	10	arrayOfByte1	byte[]
    //   238	1	10	localException1	Exception
    //   288	9	10	localException2	Exception
    //   8	366	11	arrayOfByte2	byte[]
    //   15	211	12	localByteBuffer	java.nio.ByteBuffer
    //   143	31	13	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	55	238	java/lang/Exception
    //   69	78	238	java/lang/Exception
    //   81	89	238	java/lang/Exception
    //   92	98	238	java/lang/Exception
    //   101	108	238	java/lang/Exception
    //   111	122	238	java/lang/Exception
    //   139	145	238	java/lang/Exception
    //   148	159	238	java/lang/Exception
    //   162	168	238	java/lang/Exception
    //   171	179	238	java/lang/Exception
    //   182	188	238	java/lang/Exception
    //   191	198	238	java/lang/Exception
    //   204	215	238	java/lang/Exception
    //   225	231	238	java/lang/Exception
    //   17	27	281	finally
    //   17	27	288	java/lang/Exception
    //   47	55	313	finally
    //   69	78	313	finally
    //   81	89	313	finally
    //   92	98	313	finally
    //   101	108	313	finally
    //   111	122	313	finally
    //   139	145	313	finally
    //   148	159	313	finally
    //   162	168	313	finally
    //   171	179	313	finally
    //   182	188	313	finally
    //   191	198	313	finally
    //   204	215	313	finally
    //   225	231	313	finally
    //   296	301	313	finally
    //   243	248	332	java/lang/Exception
    //   306	311	336	java/lang/Exception
    //   319	323	339	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(c());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    ((StringBuilder)localObject).append(".nomedia");
    localObject = ((StringBuilder)localObject).toString();
    if (!new File((String)localObject).exists()) {
      FileUtils.createFileIfNotExits((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 1007)
    {
      if (paramInt != 2008)
      {
        if (paramInt != 5001)
        {
          if (paramInt != 5002)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(" [STATUS_UNKNOW ");
                localStringBuilder.append(paramInt);
                localStringBuilder.append("]");
                return localStringBuilder.toString();
              case 2005: 
                return " [STATUS_RECV_ERROR] ";
              case 2004: 
                return " [STATUS_RECV_CANCEL] ";
              case 2003: 
                return " [STATUS_RECV_FINISHED] ";
              case 2002: 
                return " [STATUS_RECV_PROCESS] ";
              case 2001: 
                return " [STATUS_RECV_START] ";
              }
              return " [STATUS_RECV_REQUEST] ";
            case 1005: 
              return " [STATUS_SEND_ERROR] ";
            case 1004: 
              return " [STATUS_SEND_CANCEL] ";
            case 1003: 
              return " [STATUS_SEND_FINISHED] ";
            case 1002: 
              return " [STATUS_SEND_PROCESS] ";
            case 1001: 
              return " [STATUS_SEND_START] ";
            case 1000: 
              return " [STATUS_SEND_REQUEST] ";
            }
            return " [STATUS_SEND_PREPARE] ";
          }
          return " [STATUS_FILE_EXPIRED] ";
        }
        return " [STATUS_FILE_UNSAFE] ";
      }
      return " [STATUS_RECV_PREPARED] ";
    }
    return " [STATUS_UPLOAD_FINISHED] ";
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    if (paramMessageForShortVideo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(a(paramMessageForShortVideo.getMd5()));
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return " shortvideo_cmd_unknow ";
            }
            return " shortvideo_cmd_reforward ";
          }
          return " shortvideo_cmd_forward ";
        }
        return " shortvideo_cmd_download ";
      }
      return " shortvideo_cmd_resend ";
    }
    return " shortvideo_cmd_send ";
  }
  
  public static boolean d()
  {
    if (!a)
    {
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("needBlockBrokenVideo:");
          localStringBuilder.append((String)localObject);
          QLog.d("SVUtils", 2, localStringBuilder.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 5) {
          c = localObject[5].equals("1");
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("needBlockBrokenVideo e:");
          localStringBuilder.append(localException.toString());
          QLog.d("SVUtils", 2, localStringBuilder.toString());
        }
      }
      a = true;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.SVUtils
 * JD-Core Version:    0.7.0.1
 */