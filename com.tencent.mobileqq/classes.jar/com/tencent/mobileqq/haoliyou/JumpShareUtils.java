package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_ctrl.ResvResvInfo;
import org.json.JSONObject;

public class JumpShareUtils
{
  public static volatile boolean a = false;
  
  public static int a()
  {
    int i = 1;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication == null) {
      return 0;
    }
    if (a(localBaseApplication, 1)) {}
    for (;;)
    {
      int j = i;
      if (a(localBaseApplication, 2)) {
        j = i | 0x2;
      }
      return j;
      i = 0;
    }
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Context paramContext, File paramFile)
  {
    if (a) {
      return null;
    }
    a = true;
    paramContext = ScannerUtils.a(Uri.parse("file://" + paramFile.getAbsolutePath()), paramContext);
    a = false;
    return paramContext;
  }
  
  public static Pair<Integer, Integer> a(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getImgFileWH " + i + " | " + j);
      }
      paramString = new Pair(Integer.valueOf(i), Integer.valueOf(j));
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 118	java/io/BufferedInputStream
    //   3: dup
    //   4: new 120	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 126	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 10240
    //   19: newarray byte
    //   21: astore_3
    //   22: ldc 128
    //   24: invokestatic 134	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_3
    //   30: invokevirtual 140	java/io/InputStream:read	([B)I
    //   33: istore_1
    //   34: iload_1
    //   35: ifle +34 -> 69
    //   38: aload_2
    //   39: aload_3
    //   40: iconst_0
    //   41: iload_1
    //   42: invokevirtual 144	java/security/MessageDigest:update	([BII)V
    //   45: goto -17 -> 28
    //   48: astore_2
    //   49: aload_0
    //   50: ifnull +7 -> 57
    //   53: aload_0
    //   54: invokevirtual 147	java/io/InputStream:close	()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 150	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   64: aconst_null
    //   65: astore_2
    //   66: goto -38 -> 28
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 147	java/io/InputStream:close	()V
    //   77: aload_2
    //   78: ifnull +52 -> 130
    //   81: aload_2
    //   82: invokevirtual 154	java/security/MessageDigest:digest	()[B
    //   85: invokestatic 160	com/tencent/mobileqq/utils/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   88: astore_2
    //   89: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +28 -> 120
    //   95: ldc 86
    //   97: iconst_2
    //   98: new 27	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   105: ldc 162
    //   107: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 147	java/io/InputStream:close	()V
    //   128: aload_2
    //   129: areturn
    //   130: aload_0
    //   131: ifnull -74 -> 57
    //   134: aload_0
    //   135: invokevirtual 147	java/io/InputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_0
    //   147: ifnull -90 -> 57
    //   150: aload_0
    //   151: invokevirtual 147	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 147	java/io/InputStream:close	()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_3
    //   173: goto -96 -> 77
    //   176: astore_0
    //   177: goto -49 -> 128
    //   180: astore_0
    //   181: aconst_null
    //   182: areturn
    //   183: astore_0
    //   184: goto -14 -> 170
    //   187: astore_2
    //   188: goto -26 -> 162
    //   191: astore_2
    //   192: goto -46 -> 146
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_0
    //   198: goto -149 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramString	String
    //   33	9	1	i	int
    //   27	12	2	localMessageDigest	java.security.MessageDigest
    //   48	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   59	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   65	64	2	str	String
    //   159	12	2	localObject1	Object
    //   187	1	2	localObject2	Object
    //   191	1	2	localThrowable	Throwable
    //   21	19	3	arrayOfByte	byte[]
    //   172	1	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	22	48	java/io/FileNotFoundException
    //   22	28	48	java/io/FileNotFoundException
    //   28	34	48	java/io/FileNotFoundException
    //   38	45	48	java/io/FileNotFoundException
    //   60	64	48	java/io/FileNotFoundException
    //   73	77	48	java/io/FileNotFoundException
    //   81	120	48	java/io/FileNotFoundException
    //   22	28	59	java/security/NoSuchAlgorithmException
    //   134	138	140	java/io/IOException
    //   0	16	143	java/lang/Throwable
    //   150	154	156	java/io/IOException
    //   0	16	159	finally
    //   73	77	172	java/io/IOException
    //   124	128	176	java/io/IOException
    //   53	57	180	java/io/IOException
    //   166	170	183	java/io/IOException
    //   16	22	187	finally
    //   22	28	187	finally
    //   28	34	187	finally
    //   38	45	187	finally
    //   60	64	187	finally
    //   73	77	187	finally
    //   81	120	187	finally
    //   16	22	191	java/lang/Throwable
    //   22	28	191	java/lang/Throwable
    //   28	34	191	java/lang/Throwable
    //   38	45	191	java/lang/Throwable
    //   60	64	191	java/lang/Throwable
    //   73	77	191	java/lang/Throwable
    //   81	120	191	java/lang/Throwable
    //   0	16	195	java/io/FileNotFoundException
  }
  
  private static String a(String paramString, int paramInt)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        i = paramString.getBytes("UTF-8").length;
        if (i < paramInt) {}
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        int i;
        for (;;)
        {
          StringBuffer localStringBuffer;
          char c;
          int k;
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    localStringBuffer = new StringBuffer();
    i = 0;
    if (i < paramInt)
    {
      c = paramString.charAt(i);
      localStringBuffer.append(c);
    }
    try
    {
      k = String.valueOf(c).getBytes("UTF-8").length;
      j += k;
      if (j <= paramInt) {
        break label116;
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject2;
    long l2;
    if ((ZhuoXusManager.a().f()) && (!TextUtils.isEmpty(paramString)))
    {
      localHashMap.put("param_qO", "1");
      localHashMap.put("param_hU", "0");
      if (new File(paramString).exists())
      {
        localObject1 = null;
        l1 = System.currentTimeMillis();
        localObject2 = a(BaseApplicationImpl.getContext(), new File(paramString));
        l2 = System.currentTimeMillis();
        localHashMap.put("param_rqC", String.valueOf(l2 - l1));
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, rq tc = " + (l2 - l1));
        }
        if (localObject2 != null) {
          localObject1 = ((StringBuilder)((Pair)localObject2).first).toString();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, qu = " + (String)localObject1);
          }
          try
          {
            localObject1 = a((String)localObject1, 128);
            localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set  r1 = " + (String)localObject1);
            }
            localHashMap.put("param_hU", "1");
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              int i;
              long l3;
              localException1.printStackTrace();
            }
          }
          if ((!ZhuoXusManager.a().h()) || (!a())) {
            break label1273;
          }
          localHashMap.put("param_aPO", "1");
          l1 = System.currentTimeMillis();
          i = a();
          localResvResvInfo.uint32_flag.set(1);
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set f = 1");
          }
          localResvResvInfo.uint64_reserv2.set(i);
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set r2 = " + i);
          }
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, ap t c = " + (l2 - l1));
          }
          localHashMap.put("param_aPC", String.valueOf(l2 - l1));
          localHashMap.put("param_aI", String.valueOf(i));
          label448:
          if (!ZhuoXusManager.a().g()) {
            break label1419;
          }
          localHashMap.put("param_rEO", "1");
          l3 = System.currentTimeMillis();
          if ((JpegExifReader.isCrashJpeg(paramString)) || (!PhotoUtils.isJPEGImage(paramString))) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localExifInterface = new ExifInterface(paramString);
        l1 = 0L;
        if (!TextUtils.isEmpty(localExifInterface.getAttribute("GPSLatitude"))) {
          l1 = 0L | 1L;
        }
        paramString = localExifInterface.getAttribute("Make");
        l2 = l1;
        if (paramString != null)
        {
          l2 = l1;
          if (!TextUtils.isEmpty(paramString)) {
            l2 = l1 | 0x2;
          }
        }
        localResvResvInfo.uint64_reserv3.set(l2);
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set r3  = " + l2);
        }
        localHashMap.put("param_pF", String.valueOf(l2));
      }
      catch (Exception paramString)
      {
        ExifInterface localExifInterface;
        label698:
        paramString.printStackTrace();
        continue;
        localHashMap.put("param_hasPL", "0");
        continue;
      }
      try
      {
        paramString = localExifInterface.getAttribute("DateTime");
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        i = (int)(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(paramString).getTime() / 1000L);
        localResvResvInfo.uint32_create_time.set(i);
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ct  = " + i);
        }
        localHashMap.put("param_hPT", "1");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = localExifInterface.getAttribute("ImageDescription");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("CheckForward.JumpShareUtils", 2, "decrip = " + (String)localObject2);
          }
          localObject1 = new JSONObject((String)localObject2);
          paramString = ((JSONObject)localObject1).getString("ImageLength");
        }
      }
      catch (Throwable localThrowable1)
      {
        label923:
        label929:
        label1022:
        str2 = null;
        paramString = null;
        continue;
      }
      try
      {
        localObject1 = ((JSONObject)localObject1).getString("ImageWidth");
        try
        {
          if (!TextUtils.isEmpty(paramString))
          {
            localResvResvInfo.uint32_pic_height.set(Integer.valueOf(paramString).intValue());
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set _pc  = " + Integer.valueOf(paramString));
            }
            localHashMap.put("param_hasPL", "1");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              continue;
            }
            localResvResvInfo.uint32_pic_width.set(Integer.valueOf((String)localObject1).intValue());
            if (QLog.isColorLevel()) {
              QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set _pw  = " + Integer.valueOf((String)localObject1));
            }
            localHashMap.put("param_hasPW", "1");
            localObject2 = paramString;
            paramString = (String)localObject1;
            bool = TextUtils.isEmpty((CharSequence)localObject2);
            if (!bool) {}
          }
        }
        catch (Throwable localThrowable3)
        {
          boolean bool;
          localObject2 = localException1;
          str1 = paramString;
          paramString = (String)localObject2;
          localObject2 = localThrowable3;
        }
      }
      catch (Throwable localThrowable2)
      {
        str2 = paramString;
        paramString = null;
        continue;
      }
      try
      {
        localObject1 = localExifInterface.getAttribute("ImageLength");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localResvResvInfo.uint32_pic_height.set(Integer.valueOf((String)localObject1).intValue());
        if (QLog.isColorLevel()) {
          QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ph  = " + Integer.valueOf((String)localObject1));
        }
        localHashMap.put("param_hasPL", "1");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        continue;
        localHashMap.put("param_hasPW", "0");
      }
    }
    bool = TextUtils.isEmpty(paramString);
    if (bool) {}
    try
    {
      paramString = localExifInterface.getAttribute("ImageWidth");
      if (TextUtils.isEmpty(paramString)) {
        break label1397;
      }
      localResvResvInfo.uint32_pic_width.set(Integer.valueOf(paramString).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set pw  = " + Integer.valueOf(paramString));
      }
      localHashMap.put("param_hasPW", "1");
    }
    catch (Exception paramString)
    {
      label1397:
      for (;;)
      {
        label1273:
        paramString.printStackTrace();
      }
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, re, t c = " + (l1 - l3));
    }
    localHashMap.put("param_rEC", String.valueOf(l1 - l3));
    for (;;)
    {
      localMsgCtrl.resv_resv_info.set(localResvResvInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, set ri");
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, localHashMap, "");
      return localMsgCtrl;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CheckForward.JumpShareUtils", 2, "getMsgCtrlForPicMsg, u null");
      break;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
      break;
      localHashMap.put("param_qO", "0");
      break;
      localHashMap.put("param_aPO", "0");
      break label448;
      localHashMap.put("param_hPT", "0");
      break label698;
      String str1;
      ((Throwable)localObject2).printStackTrace();
      localObject2 = str1;
      break label929;
      localHashMap.put("param_hasPW", "0");
      break label923;
      localHashMap.put("param_hasPL", "0");
      break label1022;
      label1419:
      localHashMap.put("param_rEO", "0");
    }
  }
  
  public static msg_ctrl.MsgCtrl a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    msg_ctrl.MsgCtrl localMsgCtrl = new msg_ctrl.MsgCtrl();
    msg_ctrl.ResvResvInfo localResvResvInfo = new msg_ctrl.ResvResvInfo();
    Object localObject = paramString2;
    if (paramString2 == null) {
      if (TextUtils.isEmpty(paramString1)) {
        break label455;
      }
    }
    label187:
    label449:
    label455:
    for (localObject = new File(paramString1);; localObject = null)
    {
      if ((localObject == null) || (!((File)localObject).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("CheckForward.JumpShareUtils", 1, "file not exists!");
        }
        return null;
      }
      if (ZhuoXusManager.a().i())
      {
        localObject = a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject == null)
        {
          localObject = paramString2;
          if (QLog.isColorLevel())
          {
            QLog.w("CheckForward.JumpShareUtils", 1, "calc file faild!");
            localObject = paramString2;
          }
          paramString2 = a((String)localObject, 128);
          if (TextUtils.isEmpty(paramString2)) {
            break label449;
          }
          localResvResvInfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(paramString2));
        }
      }
      for (int j = 1;; j = 0)
      {
        int i;
        if ((ZhuoXusManager.a().k()) && (a()))
        {
          localResvResvInfo.uint32_flag.set(1);
          localResvResvInfo.uint64_reserv2.set(a());
          i = 1;
          if (!ZhuoXusManager.a().j()) {
            break label411;
          }
          paramString2 = b(paramString1);
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
            paramString1 = a(paramString1);
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
        for (;;)
        {
          if (paramInt1 != 0) {
            break label436;
          }
          return null;
          if (((Pair)localObject).first != null)
          {
            localObject = ((StringBuilder)((Pair)localObject).first).toString();
            break;
          }
          localObject = "";
          break;
          paramString2 = "";
          localObject = paramString2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
          localObject = paramString2;
          break;
          i = j;
          if (!QLog.isColorLevel()) {
            break label187;
          }
          QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
          i = j;
          break label187;
          paramInt1 = i;
          if (QLog.isColorLevel())
          {
            QLog.i("IMG_FILE_QR", 1, "ZhuoXusManager exif switch is false!");
            paramInt1 = i;
          }
        }
        localMsgCtrl.resv_resv_info.set(localResvResvInfo);
        return localMsgCtrl;
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = ZhuoXusManager.a();
    if (!((ZhuoXusManager)localObject).e()) {}
    String str;
    do
    {
      return false;
      str = ((ZhuoXusManager)localObject).a();
      localObject = ((ZhuoXusManager)localObject).b();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)));
    return true;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return false;
    }
    ZhuoXusManager localZhuoXusManager = ZhuoXusManager.a();
    if (!localZhuoXusManager.e()) {
      return false;
    }
    String str = null;
    if (paramInt == 1) {
      str = localZhuoXusManager.a();
    }
    while (TextUtils.isEmpty(str))
    {
      return false;
      if (paramInt == 2) {
        str = localZhuoXusManager.b();
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 256);
      if (paramContext != null) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label72:
      break label72;
    }
  }
  
  private static Pair<Integer, Integer> b(String paramString)
  {
    m = 0;
    if (JpegExifReader.isCrashJpeg(paramString)) {
      return null;
    }
    if (!PhotoUtils.isJPEGImage(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = new ExifInterface(paramString);
        bool = TextUtils.isEmpty(paramString.getAttribute("GPSLatitude"));
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        int j;
        int k;
        SimpleDateFormat localSimpleDateFormat;
        long l;
        int i = 0;
        continue;
        i = 0;
        continue;
      }
      try
      {
        bool = TextUtils.isEmpty(paramString.getAttribute("Make"));
        if (bool) {
          continue;
        }
        i |= 0x2;
      }
      catch (Exception paramString)
      {
        continue;
        continue;
      }
      try
      {
        paramString = paramString.getAttribute("DateTime");
        j = m;
        k = i;
        if (!TextUtils.isEmpty(paramString)) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j = m;
        k = i;
        continue;
      }
      try
      {
        l = localSimpleDateFormat.parse(paramString).getTime() / 1000L;
        j = (int)l;
        k = i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        j = m;
        k = i;
      }
    }
    return new Pair(Integer.valueOf(k), Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JumpShareUtils
 * JD-Core Version:    0.7.0.1
 */