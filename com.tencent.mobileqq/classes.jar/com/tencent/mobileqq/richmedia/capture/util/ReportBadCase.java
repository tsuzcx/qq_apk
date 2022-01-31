package com.tencent.mobileqq.richmedia.capture.util;

import agws;
import agwu;
import agwv;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataItem;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.ReportItemData;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class ReportBadCase
  implements BadcaseReportUtils.ReportItemData
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public static void a()
  {
    ThreadManager.post(new agwu(), 5, null, true);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      a();
      return;
    }
    ThreadManager.post(new agwv(paramAppInterface), 5, null, true);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    paramStringBuilder.append("--").append(paramString1).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=appid\r\n\r\n");
    paramStringBuilder.append(paramInt1);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString1).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=os\r\n\r\n");
    paramStringBuilder.append("Android");
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString1).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=model\r\n\r\n");
    paramStringBuilder.append(Build.MODEL + "|" + Build.VERSION.RELEASE);
    paramStringBuilder.append("\r\n");
    paramStringBuilder.append("--").append(paramString1).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=imei\r\n\r\n");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append("\r\n");
    if (paramInt2 != 0)
    {
      paramStringBuilder.append("--").append(paramString1).append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
      paramStringBuilder.append(paramInt2);
      paramStringBuilder.append("\r\n");
    }
    if (paramInt3 != 0)
    {
      paramStringBuilder.append("--").append(paramString1).append("\r\n");
      paramStringBuilder.append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
      paramStringBuilder.append(paramInt3);
      paramStringBuilder.append("\r\n");
    }
    paramStringBuilder.append("--").append(paramString1).append("\r\n");
    paramStringBuilder.append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
    paramStringBuilder.append(paramString3);
    paramStringBuilder.append("\r\n");
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    Object localObject = "Test: " + paramHttpURLConnection.getResponseMessage();
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils readServerResp repMsg " + (String)localObject + " status=" + i);
    }
    if (i == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      localObject = new byte[1024];
      for (;;)
      {
        i = paramHttpURLConnection.read((byte[])localObject, 0, 1024);
        if (i == -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils readServerResp len1=" + i + " " + new String((byte[])localObject, 0, i));
        }
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
  {
    try
    {
      paramHttpURLConnection.setRequestProperty("Cookie", ("uin=o" + paramString1).concat("; skey=" + paramString2));
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      QLog.e("BadcaseReportUtils", 2, "BadcaseReportUtils setUrlConnCookie error, ", paramHttpURLConnection);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (BadcaseReportUtils.jdField_a_of_type_Boolean = MediaCodecDPC.h();; BadcaseReportUtils.jdField_a_of_type_Boolean = false)
    {
      BadcaseReportUtils.jdField_a_of_type_Int = MediaCodecDPC.c();
      if (QLog.isColorLevel()) {
        QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils dpcBadCaseSetting enable=" + BadcaseReportUtils.jdField_a_of_type_Boolean + " reportNumber=" + BadcaseReportUtils.jdField_a_of_type_Int + " businessEnable=" + paramBoolean);
      }
      return;
    }
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString)
  {
    return a(paramBitmap, paramString, 80);
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: istore_3
    //   15: aload_0
    //   16: ifnull +10 -> 26
    //   19: aload_1
    //   20: ifnonnull +8 -> 28
    //   23: iload 4
    //   25: istore_3
    //   26: iload_3
    //   27: ireturn
    //   28: new 200	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokevirtual 206	java/io/File:exists	()Z
    //   41: ifeq +8 -> 49
    //   44: aload_1
    //   45: invokevirtual 209	java/io/File:delete	()Z
    //   48: pop
    //   49: aload_1
    //   50: invokevirtual 212	java/io/File:createNewFile	()Z
    //   53: pop
    //   54: new 214	java/io/FileOutputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: astore_1
    //   63: aload_1
    //   64: astore 5
    //   66: aload 7
    //   68: astore 6
    //   70: new 219	java/io/BufferedOutputStream
    //   73: dup
    //   74: aload_1
    //   75: sipush 20480
    //   78: invokespecial 222	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   81: astore 7
    //   83: aload_0
    //   84: getstatic 228	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   87: iload_2
    //   88: aload 7
    //   90: invokevirtual 234	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   93: istore_3
    //   94: iload_3
    //   95: istore 4
    //   97: aload 7
    //   99: ifnull +13 -> 112
    //   102: aload 7
    //   104: invokevirtual 239	java/io/OutputStream:flush	()V
    //   107: aload 7
    //   109: invokevirtual 242	java/io/OutputStream:close	()V
    //   112: iload 4
    //   114: istore_3
    //   115: aload_1
    //   116: ifnull -90 -> 26
    //   119: aload_1
    //   120: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   123: iload 4
    //   125: ireturn
    //   126: astore_0
    //   127: iload 4
    //   129: ireturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload 8
    //   135: astore 7
    //   137: aload_1
    //   138: astore 5
    //   140: aload 7
    //   142: astore 6
    //   144: aload_0
    //   145: invokevirtual 246	java/io/FileNotFoundException:printStackTrace	()V
    //   148: aload 7
    //   150: ifnull +13 -> 163
    //   153: aload 7
    //   155: invokevirtual 239	java/io/OutputStream:flush	()V
    //   158: aload 7
    //   160: invokevirtual 242	java/io/OutputStream:close	()V
    //   163: iload 4
    //   165: istore_3
    //   166: aload_1
    //   167: ifnull -141 -> 26
    //   170: aload_1
    //   171: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload 6
    //   184: ifnull +13 -> 197
    //   187: aload 6
    //   189: invokevirtual 239	java/io/OutputStream:flush	()V
    //   192: aload 6
    //   194: invokevirtual 242	java/io/OutputStream:close	()V
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: iconst_0
    //   209: ireturn
    //   210: astore_1
    //   211: goto -6 -> 205
    //   214: astore 5
    //   216: goto -19 -> 197
    //   219: astore_0
    //   220: aload 5
    //   222: astore_1
    //   223: goto -41 -> 182
    //   226: astore_0
    //   227: aload 7
    //   229: astore 6
    //   231: goto -49 -> 182
    //   234: astore_0
    //   235: goto -72 -> 163
    //   238: astore_0
    //   239: aload 8
    //   241: astore 7
    //   243: goto -106 -> 137
    //   246: astore_0
    //   247: goto -110 -> 137
    //   250: astore_0
    //   251: goto -139 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramBitmap	Bitmap
    //   0	254	1	paramString	String
    //   0	254	2	paramInt	int
    //   14	152	3	bool1	boolean
    //   10	154	4	bool2	boolean
    //   64	75	5	str	String
    //   214	7	5	localIOException	IOException
    //   1	229	6	localObject1	Object
    //   4	238	7	localObject2	Object
    //   7	233	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   119	123	126	java/io/IOException
    //   54	63	130	java/io/FileNotFoundException
    //   170	174	176	java/io/IOException
    //   54	63	179	finally
    //   49	54	207	java/io/IOException
    //   201	205	210	java/io/IOException
    //   187	197	214	java/io/IOException
    //   70	83	219	finally
    //   144	148	219	finally
    //   83	94	226	finally
    //   153	163	234	java/io/IOException
    //   70	83	238	java/io/FileNotFoundException
    //   83	94	246	java/io/FileNotFoundException
    //   102	112	250	java/io/IOException
  }
  
  private static void b(BadcaseReportUtils.BadDataFrame paramBadDataFrame, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object localObject = null;
    File localFile = new File(paramBadDataFrame.d);
    HttpURLConnection localHttpURLConnection;
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL("http://qqlog.qq.com/log/active/busreport.jsp").openConnection();
      localObject = localHttpURLConnection;
      localHttpURLConnection.setDoInput(true);
      localObject = localHttpURLConnection;
      localHttpURLConnection.setDoOutput(true);
      localObject = localHttpURLConnection;
      localHttpURLConnection.setUseCaches(false);
      localObject = localHttpURLConnection;
      localHttpURLConnection.setRequestMethod("POST");
      localObject = localHttpURLConnection;
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localObject = localHttpURLConnection;
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + paramString1);
      localObject = localHttpURLConnection;
      a(localHttpURLConnection, paramString2, paramString3);
      localObject = localHttpURLConnection;
      paramString3 = new DataOutputStream(localHttpURLConnection.getOutputStream());
      localObject = localHttpURLConnection;
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = localHttpURLConnection;
      a(localStringBuilder, paramString1, BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0).getString("sp_imei", "000000000000000"), paramInt, 1, 1, paramString2);
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append(localFile.getName());
      localObject = localHttpURLConnection;
      localStringBuilder.append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition: form-data; name=gzip\r\n\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("true");
      localObject = localHttpURLConnection;
      localStringBuilder.append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition: form-data; name=errcode\r\n\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append(paramBadDataFrame.jdField_a_of_type_Int);
      localObject = localHttpURLConnection;
      localStringBuilder.append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition: form-data; name=errmsg\r\n\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append(BadcaseReportUtils.BadDataItem.a(paramBadDataFrame.jdField_a_of_type_Int));
      localObject = localHttpURLConnection;
      localStringBuilder.append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition: form-data; name=buscmd\r\n\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("dance.badcase");
      localObject = localHttpURLConnection;
      localStringBuilder.append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("--").append(paramString1).append("\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Disposition:form-data;name=logFile;filename=\"" + localFile.getName() + "\"\r\n");
      localObject = localHttpURLConnection;
      localStringBuilder.append("Content-Type: application/x-zip-compressed\r\n\r\n");
      localObject = localHttpURLConnection;
      paramString3.write(localStringBuilder.toString().getBytes("UTF-8"));
      localObject = localHttpURLConnection;
      paramBadDataFrame = new FileInputStream(localFile);
      long l1 = 0L;
      try
      {
        paramString2 = new byte[10240];
        for (;;)
        {
          paramInt = paramBadDataFrame.read(paramString2, 0, 10240);
          if (paramInt == -1) {
            break;
          }
          paramString3.write(paramString2, 0, paramInt);
          long l2 = l1 + paramInt;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("BadcaseReportUtils", 2, "send " + l2 + " fileLength=" + localFile.length());
            l1 = l2;
          }
        }
        paramBadDataFrame = finally;
      }
      finally
      {
        localObject = localHttpURLConnection;
        paramBadDataFrame.close();
        localObject = localHttpURLConnection;
      }
      localObject = localHttpURLConnection;
    }
    finally
    {
      if (localObject != null) {
        localObject.disconnect();
      }
    }
    paramBadDataFrame.close();
    localObject = localHttpURLConnection;
    paramString3.write("\r\n".getBytes());
    localObject = localHttpURLConnection;
    paramString3.write(("--" + paramString1 + "--\r\n").getBytes());
    localObject = localHttpURLConnection;
    paramString3.flush();
    localObject = localHttpURLConnection;
    paramString3.close();
    localObject = localHttpURLConnection;
    a(localHttpURLConnection);
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
  }
  
  private static String c()
  {
    Object localObject = new StringBuilder(AppConstants.aJ);
    ((StringBuilder)localObject).append("sv_capture_xx");
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File((String)localObject + ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localObject;
    }
    catch (IOException localIOException) {}
    return localObject;
  }
  
  private static void c()
  {
    Object localObject1 = new File(c());
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getName().equals(".nomedia")) {}
          for (;;)
          {
            i += 1;
            break;
            localObject2.delete();
          }
        }
      }
    }
  }
  
  private static String d()
  {
    String str = c();
    return str + VidUtil.a() + "_jpg";
  }
  
  private static String e()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i = 0;
    while (i < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i += 1;
    }
    return str;
  }
  
  public void a(BadcaseReportUtils.BadDataFrame paramBadDataFrame)
  {
    if (paramBadDataFrame.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      paramBadDataFrame.b = null;
      ThreadManager.post(new agws(this, paramBadDataFrame), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase
 * JD-Core Version:    0.7.0.1
 */