package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;

public class JumpShareUtils
{
  public static volatile boolean a = false;
  
  public static int a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = 0;
    if (localBaseApplication == null) {
      return 0;
    }
    if (a(localBaseApplication, 1)) {
      i = 1;
    }
    int j = i;
    if (a(localBaseApplication, 2)) {
      j = i | 0x2;
    }
    return j;
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Context paramContext, File paramFile)
  {
    if (a) {
      return null;
    }
    a = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramFile.getAbsolutePath());
    paramFile = Uri.parse(localStringBuilder.toString());
    paramContext = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQRCodeFromFile(paramFile, paramContext);
    a = false;
    return paramContext;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 75	java/io/BufferedInputStream
    //   3: dup
    //   4: new 77	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 83	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 10240
    //   19: newarray byte
    //   21: astore_3
    //   22: ldc 85
    //   24: invokestatic 91	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore_2
    //   28: goto +10 -> 38
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 94	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_0
    //   39: aload_3
    //   40: invokevirtual 100	java/io/InputStream:read	([B)I
    //   43: istore_1
    //   44: iload_1
    //   45: ifle +13 -> 58
    //   48: aload_2
    //   49: aload_3
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 104	java/security/MessageDigest:update	([BII)V
    //   55: goto -17 -> 38
    //   58: aload_0
    //   59: invokevirtual 107	java/io/InputStream:close	()V
    //   62: aload_2
    //   63: ifnull +54 -> 117
    //   66: aload_2
    //   67: invokevirtual 111	java/security/MessageDigest:digest	()[B
    //   70: invokestatic 117	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   73: astore_2
    //   74: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +34 -> 111
    //   80: new 28	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   87: astore_3
    //   88: aload_3
    //   89: ldc 125
    //   91: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: aload_2
    //   97: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: ldc 127
    //   103: iconst_2
    //   104: aload_3
    //   105: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 107	java/io/InputStream:close	()V
    //   115: aload_2
    //   116: areturn
    //   117: aload_0
    //   118: invokevirtual 107	java/io/InputStream:close	()V
    //   121: aconst_null
    //   122: areturn
    //   123: astore_3
    //   124: aload_0
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: goto +6 -> 134
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 107	java/io/InputStream:close	()V
    //   142: aload_0
    //   143: athrow
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull +18 -> 165
    //   150: aload_0
    //   151: invokevirtual 107	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +6 -> 165
    //   162: goto -12 -> 150
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto -12 -> 156
    //   171: astore_0
    //   172: goto -28 -> 144
    //   175: astore_2
    //   176: goto -18 -> 158
    //   179: astore_2
    //   180: goto -34 -> 146
    //   183: astore_3
    //   184: goto -122 -> 62
    //   187: astore_0
    //   188: aload_2
    //   189: areturn
    //   190: astore_0
    //   191: aconst_null
    //   192: areturn
    //   193: astore_2
    //   194: goto -52 -> 142
    //   197: astore_0
    //   198: aconst_null
    //   199: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString	String
    //   43	9	1	i	int
    //   27	1	2	localMessageDigest	java.security.MessageDigest
    //   31	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   37	102	2	str	String
    //   175	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   179	10	2	localThrowable	Throwable
    //   193	1	2	localIOException1	java.io.IOException
    //   21	84	3	localObject1	Object
    //   123	4	3	localObject2	Object
    //   183	1	3	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   22	28	31	java/security/NoSuchAlgorithmException
    //   16	22	123	finally
    //   22	28	123	finally
    //   32	36	123	finally
    //   38	44	123	finally
    //   48	55	123	finally
    //   58	62	123	finally
    //   66	111	123	finally
    //   0	16	131	finally
    //   0	16	167	java/io/FileNotFoundException
    //   0	16	171	java/lang/Throwable
    //   16	22	175	java/io/FileNotFoundException
    //   22	28	175	java/io/FileNotFoundException
    //   32	36	175	java/io/FileNotFoundException
    //   38	44	175	java/io/FileNotFoundException
    //   48	55	175	java/io/FileNotFoundException
    //   58	62	175	java/io/FileNotFoundException
    //   66	111	175	java/io/FileNotFoundException
    //   16	22	179	java/lang/Throwable
    //   22	28	179	java/lang/Throwable
    //   32	36	179	java/lang/Throwable
    //   38	44	179	java/lang/Throwable
    //   48	55	179	java/lang/Throwable
    //   58	62	179	java/lang/Throwable
    //   66	111	179	java/lang/Throwable
    //   58	62	183	java/io/IOException
    //   111	115	187	java/io/IOException
    //   117	121	190	java/io/IOException
    //   138	142	193	java/io/IOException
    //   150	154	197	java/io/IOException
  }
  
  private static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      i = paramString.getBytes("UTF-8").length;
      if (i < paramInt) {
        return paramString;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      StringBuffer localStringBuffer = new StringBuffer();
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i < paramInt)
        {
          char c = paramString.charAt(i);
          localStringBuffer.append(c);
          try
          {
            int k = String.valueOf(c).getBytes("UTF-8").length;
            j += k;
            if (j > paramInt) {
              localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
            } else {
              i += 1;
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      return localStringBuffer.toString();
    }
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject = paramString2;
    if (paramString2 == null)
    {
      if (!TextUtils.isEmpty(paramString1)) {
        localObject = new File(paramString1);
      } else {
        localObject = null;
      }
      if ((localObject != null) && (((File)localObject).exists()))
      {
        if (ZhuoXusManager.a().l())
        {
          localObject = a(BaseApplicationImpl.getContext(), (File)localObject);
          if (localObject == null)
          {
            localObject = paramString2;
            if (!QLog.isColorLevel()) {
              break label172;
            }
            QLog.w("CheckForward.JumpShareUtils", 1, "calc file faild!");
            localObject = paramString2;
            break label172;
          }
          if (((Pair)localObject).first != null)
          {
            localObject = ((StringBuilder)((Pair)localObject).first).toString();
            break label172;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
        }
        localObject = "";
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
        }
        return null;
      }
    }
    label172:
    paramString2 = a((String)localObject, 128);
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(paramString2));
      j = 1;
    }
    else
    {
      j = 0;
    }
    int i;
    if ((ZhuoXusManager.a().n()) && (b()))
    {
      localResvResvInfo.uint32_flag.set(1);
      localResvResvInfo.uint64_reserv2.set(a());
      i = 1;
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
        i = j;
      }
    }
    if (ZhuoXusManager.a().m())
    {
      paramString2 = d(paramString1);
      if (paramString2 != null)
      {
        localResvResvInfo.uint64_reserv3.set(((Integer)paramString2.first).intValue());
        localResvResvInfo.uint32_create_time.set(((Integer)paramString2.second).intValue());
      }
      if (paramInt1 != 0)
      {
        j = paramInt1;
        i = paramInt2;
        if (paramInt2 != 0) {}
      }
      else
      {
        paramString1 = b(paramString1);
        j = paramInt1;
        i = paramInt2;
        if (paramString1 != null)
        {
          j = ((Integer)paramString1.first).intValue();
          i = ((Integer)paramString1.second).intValue();
        }
      }
      localResvResvInfo.uint32_pic_width.set(j);
      localResvResvInfo.uint32_pic_height.set(i);
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = i;
      if (QLog.isColorLevel())
      {
        QLog.i("IMG_FILE_QR", 1, "ZhuoXusManager exif switch is false!");
        paramInt1 = i;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    localMsgCtrl.resv_resv_info.set(localResvResvInfo);
    return localMsgCtrl;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    ZhuoXusManager localZhuoXusManager = ZhuoXusManager.a();
    if (!localZhuoXusManager.f()) {
      return false;
    }
    String str = null;
    if (paramInt == 1) {
      str = localZhuoXusManager.g();
    } else if (paramInt == 2) {
      str = localZhuoXusManager.h();
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 256);
      return paramContext != null;
    }
    catch (PackageManager.NameNotFoundException|Exception paramContext) {}
    return false;
  }
  
  public static Pair<Integer, Integer> b(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getImgFileWH ");
        paramString.append(i);
        paramString.append(" | ");
        paramString.append(j);
        QLog.d("CheckForward.JumpShareUtils", 2, paramString.toString());
      }
      paramString = new Pair(Integer.valueOf(i), Integer.valueOf(j));
      return paramString;
    }
    catch (Throwable paramString)
    {
      label99:
      break label99;
    }
    return null;
  }
  
  public static boolean b()
  {
    Object localObject = ZhuoXusManager.a();
    if (!((ZhuoXusManager)localObject).f()) {
      return false;
    }
    String str = ((ZhuoXusManager)localObject).g();
    localObject = ((ZhuoXusManager)localObject).h();
    if (!TextUtils.isEmpty(str)) {
      return !TextUtils.isEmpty((CharSequence)localObject);
    }
    return false;
  }
  
  /* Error */
  public static msg_ctrl.MsgCtrl c(String paramString)
  {
    // Byte code:
    //   0: new 357	java/util/HashMap
    //   3: dup
    //   4: invokespecial 358	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 174	msf/msgsvc/msg_ctrl$MsgCtrl
    //   12: dup
    //   13: invokespecial 175	msf/msgsvc/msg_ctrl$MsgCtrl:<init>	()V
    //   16: astore 11
    //   18: new 177	msf/msgsvc/msg_ctrl$ResvResvInfo
    //   21: dup
    //   22: invokespecial 178	msf/msgsvc/msg_ctrl$ResvResvInfo:<init>	()V
    //   25: astore 13
    //   27: invokestatic 187	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   30: invokevirtual 360	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:i	()Z
    //   33: ifeq +330 -> 363
    //   36: aload_0
    //   37: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +323 -> 363
    //   43: aload 12
    //   45: ldc_w 362
    //   48: ldc_w 364
    //   51: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload 12
    //   57: ldc_w 370
    //   60: ldc_w 372
    //   63: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: new 37	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: invokevirtual 182	java/io/File:exists	()Z
    //   78: ifeq +268 -> 346
    //   81: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   84: lstore_2
    //   85: invokestatic 20	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   88: new 37	java/io/File
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: invokestatic 192	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	(Landroid/content/Context;Ljava/io/File;)Landroid/util/Pair;
    //   99: astore 9
    //   101: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   104: lload_2
    //   105: lsub
    //   106: lstore_2
    //   107: aload 12
    //   109: ldc_w 380
    //   112: lload_2
    //   113: invokestatic 383	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +39 -> 162
    //   126: new 28	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   133: astore 10
    //   135: aload 10
    //   137: ldc_w 385
    //   140: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 10
    //   146: lload_2
    //   147: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: ldc 127
    //   153: iconst_2
    //   154: aload 10
    //   156: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 9
    //   164: ifnull +19 -> 183
    //   167: aload 9
    //   169: getfield 203	android/util/Pair:first	Ljava/lang/Object;
    //   172: checkcast 28	java/lang/StringBuilder
    //   175: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore 9
    //   180: goto +6 -> 186
    //   183: aconst_null
    //   184: astore 9
    //   186: aload 9
    //   188: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +137 -> 328
    //   194: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +40 -> 237
    //   200: new 28	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   207: astore 10
    //   209: aload 10
    //   211: ldc_w 390
    //   214: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 10
    //   220: aload 9
    //   222: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 127
    //   228: iconst_2
    //   229: aload 10
    //   231: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload 9
    //   239: sipush 128
    //   242: invokestatic 216	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   245: astore 9
    //   247: aload 13
    //   249: getfield 220	msf/msgsvc/msg_ctrl$ResvResvInfo:bytes_reserv1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   252: aload 9
    //   254: invokestatic 226	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 232	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   260: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +40 -> 303
    //   266: new 28	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   273: astore 10
    //   275: aload 10
    //   277: ldc_w 392
    //   280: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 10
    //   286: aload 9
    //   288: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 127
    //   294: iconst_2
    //   295: aload 10
    //   297: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 12
    //   305: ldc_w 370
    //   308: ldc_w 364
    //   311: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: goto +60 -> 375
    //   318: astore 9
    //   320: aload 9
    //   322: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   325: goto +50 -> 375
    //   328: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   331: ifeq +44 -> 375
    //   334: ldc 127
    //   336: iconst_2
    //   337: ldc_w 395
    //   340: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: goto +32 -> 375
    //   346: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +26 -> 375
    //   352: ldc 127
    //   354: iconst_1
    //   355: ldc 214
    //   357: invokestatic 197	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: goto +15 -> 375
    //   363: aload 12
    //   365: ldc_w 362
    //   368: ldc_w 372
    //   371: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   374: pop
    //   375: invokestatic 187	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   378: invokevirtual 398	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:k	()Z
    //   381: ifeq +190 -> 571
    //   384: invokestatic 238	com/tencent/mobileqq/haoliyou/JumpShareUtils:b	()Z
    //   387: ifeq +184 -> 571
    //   390: aload 12
    //   392: ldc_w 400
    //   395: ldc_w 364
    //   398: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: pop
    //   402: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   405: lstore_2
    //   406: invokestatic 253	com/tencent/mobileqq/haoliyou/JumpShareUtils:a	()I
    //   409: istore_1
    //   410: aload 13
    //   412: getfield 242	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   415: iconst_1
    //   416: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   419: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +12 -> 434
    //   425: ldc 127
    //   427: iconst_2
    //   428: ldc_w 402
    //   431: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload 13
    //   436: getfield 251	msf/msgsvc/msg_ctrl$ResvResvInfo:uint64_reserv2	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   439: iload_1
    //   440: i2l
    //   441: invokevirtual 258	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   444: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +39 -> 486
    //   450: new 28	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   457: astore 9
    //   459: aload 9
    //   461: ldc_w 404
    //   464: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 9
    //   470: iload_1
    //   471: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: ldc 127
    //   477: iconst_2
    //   478: aload 9
    //   480: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   489: lstore 4
    //   491: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   494: ifeq +45 -> 539
    //   497: new 28	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   504: astore 9
    //   506: aload 9
    //   508: ldc_w 406
    //   511: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload 9
    //   517: lload 4
    //   519: lload_2
    //   520: lsub
    //   521: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc 127
    //   527: iconst_2
    //   528: aload 9
    //   530: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto +3 -> 539
    //   539: aload 12
    //   541: ldc_w 408
    //   544: lload 4
    //   546: lload_2
    //   547: lsub
    //   548: invokestatic 383	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   551: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: pop
    //   555: aload 12
    //   557: ldc_w 410
    //   560: iload_1
    //   561: invokestatic 413	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   564: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: goto +15 -> 583
    //   571: aload 12
    //   573: ldc_w 400
    //   576: ldc_w 372
    //   579: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   582: pop
    //   583: invokestatic 187	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:a	()Lcom/tencent/mobileqq/haoliyou/orion/ZhuoXusManager;
    //   586: invokevirtual 416	com/tencent/mobileqq/haoliyou/orion/ZhuoXusManager:j	()Z
    //   589: ifeq +939 -> 1528
    //   592: aload 12
    //   594: ldc_w 418
    //   597: ldc_w 364
    //   600: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   603: pop
    //   604: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   607: lstore 6
    //   609: aload_0
    //   610: invokestatic 424	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   613: ifne +851 -> 1464
    //   616: aload_0
    //   617: invokestatic 429	com/tencent/mobileqq/activity/photo/PhotoUtils:isJPEGImage	(Ljava/lang/String;)Z
    //   620: ifeq +844 -> 1464
    //   623: new 431	android/media/ExifInterface
    //   626: dup
    //   627: aload_0
    //   628: invokespecial 432	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   631: astore 14
    //   633: lconst_0
    //   634: lstore_2
    //   635: aload 14
    //   637: ldc_w 434
    //   640: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   643: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   646: ifne +5 -> 651
    //   649: lconst_1
    //   650: lstore_2
    //   651: aload 14
    //   653: ldc_w 439
    //   656: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   659: astore_0
    //   660: lload_2
    //   661: lstore 4
    //   663: aload_0
    //   664: ifnull +20 -> 684
    //   667: lload_2
    //   668: lstore 4
    //   670: aload_0
    //   671: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   674: ifne +10 -> 684
    //   677: lload_2
    //   678: ldc2_w 440
    //   681: lor
    //   682: lstore 4
    //   684: aload 13
    //   686: getfield 267	msf/msgsvc/msg_ctrl$ResvResvInfo:uint64_reserv3	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   689: lload 4
    //   691: invokevirtual 258	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   694: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   697: ifeq +36 -> 733
    //   700: new 28	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   707: astore_0
    //   708: aload_0
    //   709: ldc_w 443
    //   712: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_0
    //   717: lload 4
    //   719: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: ldc 127
    //   725: iconst_2
    //   726: aload_0
    //   727: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: aload 12
    //   735: ldc_w 445
    //   738: lload 4
    //   740: invokestatic 383	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   743: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   746: pop
    //   747: aload 14
    //   749: ldc_w 447
    //   752: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   755: astore_0
    //   756: aload_0
    //   757: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: istore 8
    //   762: iload 8
    //   764: ifne +88 -> 852
    //   767: new 449	java/text/SimpleDateFormat
    //   770: dup
    //   771: ldc_w 451
    //   774: invokespecial 452	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   777: aload_0
    //   778: invokevirtual 455	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   781: invokevirtual 460	java/util/Date:getTime	()J
    //   784: ldc2_w 461
    //   787: ldiv
    //   788: l2i
    //   789: istore_1
    //   790: aload 13
    //   792: getfield 275	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   795: iload_1
    //   796: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   799: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +35 -> 837
    //   805: new 28	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   812: astore_0
    //   813: aload_0
    //   814: ldc_w 464
    //   817: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: aload_0
    //   822: iload_1
    //   823: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: ldc 127
    //   829: iconst_2
    //   830: aload_0
    //   831: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload 12
    //   839: ldc_w 466
    //   842: ldc_w 364
    //   845: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   848: pop
    //   849: goto +23 -> 872
    //   852: aload 12
    //   854: ldc_w 466
    //   857: ldc_w 372
    //   860: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   863: pop
    //   864: goto +8 -> 872
    //   867: astore_0
    //   868: aload_0
    //   869: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   872: aload 14
    //   874: ldc_w 468
    //   877: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   880: astore_0
    //   881: aload_0
    //   882: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   885: ifne +303 -> 1188
    //   888: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq +39 -> 930
    //   894: new 28	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   901: astore 9
    //   903: aload 9
    //   905: ldc_w 470
    //   908: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload 9
    //   914: aload_0
    //   915: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: ldc 127
    //   921: iconst_2
    //   922: aload 9
    //   924: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: new 472	org/json/JSONObject
    //   933: dup
    //   934: aload_0
    //   935: invokespecial 473	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   938: astore 9
    //   940: aload 9
    //   942: ldc_w 475
    //   945: invokevirtual 478	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   948: astore_0
    //   949: aload 9
    //   951: ldc_w 480
    //   954: invokevirtual 478	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   957: astore 10
    //   959: aload_0
    //   960: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   963: ifne +90 -> 1053
    //   966: aload 13
    //   968: getfield 286	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   971: aload_0
    //   972: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   975: invokevirtual 272	java/lang/Integer:intValue	()I
    //   978: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   981: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   984: istore 8
    //   986: iload 8
    //   988: ifeq +50 -> 1038
    //   991: new 28	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   998: astore 9
    //   1000: aload 9
    //   1002: ldc_w 485
    //   1005: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: pop
    //   1009: aload 9
    //   1011: aload_0
    //   1012: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1015: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: ldc 127
    //   1021: iconst_2
    //   1022: aload 9
    //   1024: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1030: goto +8 -> 1038
    //   1033: astore 9
    //   1035: goto +168 -> 1203
    //   1038: aload 12
    //   1040: ldc_w 490
    //   1043: ldc_w 364
    //   1046: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1049: pop
    //   1050: goto +15 -> 1065
    //   1053: aload 12
    //   1055: ldc_w 490
    //   1058: ldc_w 372
    //   1061: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1064: pop
    //   1065: aload 10
    //   1067: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1070: ifne +80 -> 1150
    //   1073: aload 13
    //   1075: getfield 283	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1078: aload 10
    //   1080: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1083: invokevirtual 272	java/lang/Integer:intValue	()I
    //   1086: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1089: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1092: ifeq +43 -> 1135
    //   1095: new 28	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1102: astore 9
    //   1104: aload 9
    //   1106: ldc_w 492
    //   1109: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 9
    //   1115: aload 10
    //   1117: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1120: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1123: pop
    //   1124: ldc 127
    //   1126: iconst_2
    //   1127: aload 9
    //   1129: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: aload 12
    //   1137: ldc_w 494
    //   1140: ldc_w 364
    //   1143: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1146: pop
    //   1147: goto +15 -> 1162
    //   1150: aload 12
    //   1152: ldc_w 494
    //   1155: ldc_w 372
    //   1158: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1161: pop
    //   1162: goto +46 -> 1208
    //   1165: astore 9
    //   1167: goto +5 -> 1172
    //   1170: astore 9
    //   1172: goto +31 -> 1203
    //   1175: astore 9
    //   1177: aconst_null
    //   1178: astore 10
    //   1180: goto +23 -> 1203
    //   1183: astore 9
    //   1185: goto +13 -> 1198
    //   1188: aconst_null
    //   1189: astore 10
    //   1191: aconst_null
    //   1192: astore_0
    //   1193: goto +15 -> 1208
    //   1196: astore 9
    //   1198: aconst_null
    //   1199: astore 10
    //   1201: aconst_null
    //   1202: astore_0
    //   1203: aload 9
    //   1205: invokevirtual 495	java/lang/Throwable:printStackTrace	()V
    //   1208: ldc_w 490
    //   1211: astore 9
    //   1213: aload_0
    //   1214: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1217: istore 8
    //   1219: iload 8
    //   1221: ifeq +112 -> 1333
    //   1224: aload 14
    //   1226: ldc_w 475
    //   1229: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: astore_0
    //   1233: aload_0
    //   1234: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1237: ifne +77 -> 1314
    //   1240: aload 13
    //   1242: getfield 286	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1245: aload_0
    //   1246: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1249: invokevirtual 272	java/lang/Integer:intValue	()I
    //   1252: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1255: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1258: ifeq +42 -> 1300
    //   1261: new 28	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1268: astore 15
    //   1270: aload 15
    //   1272: ldc_w 497
    //   1275: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: pop
    //   1279: aload 15
    //   1281: aload_0
    //   1282: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1285: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: ldc 127
    //   1291: iconst_2
    //   1292: aload 15
    //   1294: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: aload 12
    //   1302: aload 9
    //   1304: ldc_w 364
    //   1307: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1310: pop
    //   1311: goto +22 -> 1333
    //   1314: aload 12
    //   1316: aload 9
    //   1318: ldc_w 372
    //   1321: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: pop
    //   1325: goto +8 -> 1333
    //   1328: astore_0
    //   1329: aload_0
    //   1330: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   1333: aload 10
    //   1335: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1338: istore 8
    //   1340: iload 8
    //   1342: ifeq +122 -> 1464
    //   1345: aload 14
    //   1347: ldc_w 480
    //   1350: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   1353: astore_0
    //   1354: aload_0
    //   1355: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1358: ifne +78 -> 1436
    //   1361: aload 13
    //   1363: getfield 283	msf/msgsvc/msg_ctrl$ResvResvInfo:uint32_pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1366: aload_0
    //   1367: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1370: invokevirtual 272	java/lang/Integer:intValue	()I
    //   1373: invokevirtual 247	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1376: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1379: ifeq +42 -> 1421
    //   1382: new 28	java/lang/StringBuilder
    //   1385: dup
    //   1386: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1389: astore 9
    //   1391: aload 9
    //   1393: ldc_w 499
    //   1396: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 9
    //   1402: aload_0
    //   1403: invokestatic 483	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1406: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: ldc 127
    //   1412: iconst_2
    //   1413: aload 9
    //   1415: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1418: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1421: aload 12
    //   1423: ldc_w 494
    //   1426: ldc_w 364
    //   1429: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1432: pop
    //   1433: goto +31 -> 1464
    //   1436: aload 12
    //   1438: ldc_w 494
    //   1441: ldc_w 372
    //   1444: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1447: pop
    //   1448: goto +16 -> 1464
    //   1451: astore_0
    //   1452: aload_0
    //   1453: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   1456: goto +8 -> 1464
    //   1459: astore_0
    //   1460: aload_0
    //   1461: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   1464: invokestatic 378	java/lang/System:currentTimeMillis	()J
    //   1467: lstore_2
    //   1468: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1471: ifeq +38 -> 1509
    //   1474: new 28	java/lang/StringBuilder
    //   1477: dup
    //   1478: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   1481: astore_0
    //   1482: aload_0
    //   1483: ldc_w 501
    //   1486: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload_0
    //   1491: lload_2
    //   1492: lload 6
    //   1494: lsub
    //   1495: invokevirtual 388	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1498: pop
    //   1499: ldc 127
    //   1501: iconst_2
    //   1502: aload_0
    //   1503: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1509: aload 12
    //   1511: ldc_w 503
    //   1514: lload_2
    //   1515: lload 6
    //   1517: lsub
    //   1518: invokestatic 383	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1521: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1524: pop
    //   1525: goto +15 -> 1540
    //   1528: aload 12
    //   1530: ldc_w 418
    //   1533: ldc_w 372
    //   1536: invokevirtual 368	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1539: pop
    //   1540: aload 11
    //   1542: getfield 292	msf/msgsvc/msg_ctrl$MsgCtrl:resv_resv_info	Lmsf/msgsvc/msg_ctrl$ResvResvInfo;
    //   1545: aload 13
    //   1547: invokevirtual 295	msf/msgsvc/msg_ctrl$ResvResvInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1550: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1553: ifeq +12 -> 1565
    //   1556: ldc 127
    //   1558: iconst_2
    //   1559: ldc_w 505
    //   1562: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1565: invokestatic 20	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1568: invokestatic 510	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1571: aconst_null
    //   1572: ldc_w 512
    //   1575: iconst_1
    //   1576: lconst_0
    //   1577: lconst_0
    //   1578: aload 12
    //   1580: ldc 212
    //   1582: invokevirtual 516	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1585: aload 11
    //   1587: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1588	0	paramString	String
    //   409	414	1	i	int
    //   84	1431	2	l1	long
    //   489	250	4	l2	long
    //   607	909	6	l3	long
    //   760	581	8	bool	boolean
    //   99	188	9	localObject1	Object
    //   318	3	9	localException	Exception
    //   457	566	9	localObject2	Object
    //   1033	1	9	localThrowable1	Throwable
    //   1102	26	9	localStringBuilder1	StringBuilder
    //   1165	1	9	localThrowable2	Throwable
    //   1170	1	9	localThrowable3	Throwable
    //   1175	1	9	localThrowable4	Throwable
    //   1183	1	9	localThrowable5	Throwable
    //   1196	8	9	localThrowable6	Throwable
    //   1211	203	9	localObject3	Object
    //   133	1201	10	localObject4	Object
    //   16	1570	11	localMsgCtrl	msg_ctrl.MsgCtrl
    //   7	1572	12	localHashMap	java.util.HashMap
    //   25	1521	13	localResvResvInfo	msg_ctrl.ResvResvInfo
    //   631	715	14	localExifInterface	android.media.ExifInterface
    //   1268	25	15	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   237	303	318	java/lang/Exception
    //   303	315	318	java/lang/Exception
    //   747	762	867	java/lang/Exception
    //   767	837	867	java/lang/Exception
    //   837	849	867	java/lang/Exception
    //   852	864	867	java/lang/Exception
    //   991	1030	1033	java/lang/Throwable
    //   1038	1050	1165	java/lang/Throwable
    //   1053	1065	1165	java/lang/Throwable
    //   1065	1135	1165	java/lang/Throwable
    //   1135	1147	1165	java/lang/Throwable
    //   1150	1162	1165	java/lang/Throwable
    //   959	986	1170	java/lang/Throwable
    //   949	959	1175	java/lang/Throwable
    //   940	949	1183	java/lang/Throwable
    //   872	930	1196	java/lang/Throwable
    //   930	940	1196	java/lang/Throwable
    //   1224	1300	1328	java/lang/Exception
    //   1300	1311	1328	java/lang/Exception
    //   1314	1325	1328	java/lang/Exception
    //   1345	1421	1451	java/lang/Exception
    //   1421	1433	1451	java/lang/Exception
    //   1436	1448	1451	java/lang/Exception
    //   623	633	1459	java/lang/Exception
    //   635	649	1459	java/lang/Exception
    //   651	660	1459	java/lang/Exception
    //   670	677	1459	java/lang/Exception
    //   684	733	1459	java/lang/Exception
    //   733	747	1459	java/lang/Exception
    //   868	872	1459	java/lang/Exception
    //   872	930	1459	java/lang/Exception
    //   930	940	1459	java/lang/Exception
    //   940	949	1459	java/lang/Exception
    //   949	959	1459	java/lang/Exception
    //   959	986	1459	java/lang/Exception
    //   991	1030	1459	java/lang/Exception
    //   1038	1050	1459	java/lang/Exception
    //   1053	1065	1459	java/lang/Exception
    //   1065	1135	1459	java/lang/Exception
    //   1135	1147	1459	java/lang/Exception
    //   1150	1162	1459	java/lang/Exception
    //   1203	1208	1459	java/lang/Exception
    //   1213	1219	1459	java/lang/Exception
    //   1329	1333	1459	java/lang/Exception
    //   1333	1340	1459	java/lang/Exception
    //   1452	1456	1459	java/lang/Exception
  }
  
  /* Error */
  private static Pair<Integer, Integer> d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 424	com/tencent/image/JpegExifReader:isCrashJpeg	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 429	com/tencent/mobileqq/activity/photo/PhotoUtils:isJPEGImage	(Ljava/lang/String;)Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: iconst_0
    //   19: istore 5
    //   21: new 431	android/media/ExifInterface
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 432	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc_w 434
    //   34: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: istore 6
    //   42: iload 6
    //   44: iconst_1
    //   45: ixor
    //   46: istore_3
    //   47: iload_3
    //   48: istore_1
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: ldc_w 439
    //   55: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +7 -> 68
    //   64: iload_3
    //   65: iconst_2
    //   66: ior
    //   67: istore_1
    //   68: iload_1
    //   69: istore_2
    //   70: aload_0
    //   71: ldc_w 447
    //   74: invokevirtual 437	android/media/ExifInterface:getAttribute	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_0
    //   78: iload_1
    //   79: istore_2
    //   80: iload 5
    //   82: istore_3
    //   83: iload_1
    //   84: istore 4
    //   86: aload_0
    //   87: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifne +75 -> 165
    //   93: iload_1
    //   94: istore_2
    //   95: new 449	java/text/SimpleDateFormat
    //   98: dup
    //   99: ldc_w 451
    //   102: invokespecial 452	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   105: astore 9
    //   107: aload 9
    //   109: aload_0
    //   110: invokevirtual 455	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   113: invokevirtual 460	java/util/Date:getTime	()J
    //   116: ldc2_w 461
    //   119: ldiv
    //   120: lstore 7
    //   122: lload 7
    //   124: l2i
    //   125: istore_3
    //   126: iload_1
    //   127: istore 4
    //   129: goto +36 -> 165
    //   132: astore_0
    //   133: iload_1
    //   134: istore_2
    //   135: aload_0
    //   136: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   139: iload 5
    //   141: istore_3
    //   142: iload_1
    //   143: istore 4
    //   145: goto +20 -> 165
    //   148: astore_0
    //   149: goto +6 -> 155
    //   152: astore_0
    //   153: iconst_0
    //   154: istore_2
    //   155: aload_0
    //   156: invokevirtual 393	java/lang/Exception:printStackTrace	()V
    //   159: iload_2
    //   160: istore 4
    //   162: iload 5
    //   164: istore_3
    //   165: new 199	android/util/Pair
    //   168: dup
    //   169: iload 4
    //   171: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: iload_3
    //   175: invokestatic 349	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: invokespecial 352	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   181: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   48	95	1	i	int
    //   50	110	2	j	int
    //   46	129	3	k	int
    //   84	86	4	m	int
    //   19	144	5	n	int
    //   40	6	6	bool	boolean
    //   120	3	7	l	long
    //   105	3	9	localSimpleDateFormat	java.text.SimpleDateFormat
    // Exception table:
    //   from	to	target	type
    //   107	122	132	java/lang/Exception
    //   51	64	148	java/lang/Exception
    //   70	78	148	java/lang/Exception
    //   86	93	148	java/lang/Exception
    //   95	107	148	java/lang/Exception
    //   135	139	148	java/lang/Exception
    //   21	42	152	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpShareUtils
 * JD-Core Version:    0.7.0.1
 */