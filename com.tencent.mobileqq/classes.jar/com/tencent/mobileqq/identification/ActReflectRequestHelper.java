package com.tencent.mobileqq.identification;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;
import java.util.List;

public class ActReflectRequestHelper
  implements IFaceController
{
  private static final String o;
  private RequestListener a;
  private String b;
  private int c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private int l;
  private String m;
  private long n;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir());
    localStringBuilder.append("/identification/packFile");
    o = localStringBuilder.toString();
  }
  
  public ActReflectRequestHelper(Intent paramIntent, String paramString, RequestListener paramRequestListener)
  {
    paramIntent = (FaceConf)paramIntent.getSerializableExtra("faceConf");
    this.c = paramIntent.getPlatformAppId();
    this.d = paramIntent.getAppId();
    this.e = paramIntent.getOpenId();
    this.f = paramIntent.getIdNum();
    this.g = paramIntent.getName();
    this.h = paramIntent.getKey();
    this.i = paramIntent.getMethod();
    this.j = paramIntent.getUin();
    this.k = paramIntent.getTicket();
    this.l = paramIntent.getServiceType();
    paramIntent = paramIntent.getAppConf();
    if (paramIntent != null) {
      this.b = paramIntent.session;
    }
    String str = this.e;
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.e = paramIntent;
    str = this.f;
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.f = paramIntent;
    str = this.g;
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.g = paramIntent;
    str = this.h;
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.h = paramIntent;
    str = this.b;
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.b = paramIntent;
    this.a = paramRequestListener;
    this.m = paramString;
  }
  
  public static Bundle a(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("needRetry", paramBoolean);
    return localBundle;
  }
  
  protected faceproto.Request a(String paramString1, String paramString2)
  {
    faceproto.Request localRequest = new faceproto.Request();
    localRequest.AppID.set(this.c);
    localRequest.TmpKey.set(this.h);
    Object localObject = new faceproto.App();
    ((faceproto.App)localObject).AppID.set(this.d);
    ((faceproto.App)localObject).OpenID.set(this.e);
    localRequest.SrcApp.set((MessageMicro)localObject);
    localObject = new faceproto.UserInfo();
    if ((this.i == null) || (IdentificationConstant.c.contains(this.i)))
    {
      ((faceproto.UserInfo)localObject).IDCardNumber.set(this.f);
      ((faceproto.UserInfo)localObject).Name.set(this.g);
    }
    localRequest.UserInfo.set((MessageMicro)localObject);
    localObject = new faceproto.FaceInfo();
    faceproto.Media localMedia = new faceproto.Media();
    localMedia.Size.set(paramString1.getBytes().length);
    localMedia.Type.set(3);
    ((faceproto.FaceInfo)localObject).RecMode.set(4);
    localRequest.FaceInfo.set((MessageMicro)localObject);
    localRequest.Session.set(paramString2);
    return localRequest;
  }
  
  /* Error */
  protected String a(faceproto.Request paramRequest, String paramString)
  {
    // Byte code:
    //   0: getstatic 57	com/tencent/mobileqq/identification/ActReflectRequestHelper:o	Ljava/lang/String;
    //   3: astore_3
    //   4: new 29	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   18: invokevirtual 269	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload 4
    //   24: ldc 134
    //   26: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 271	java/io/File
    //   33: dup
    //   34: aload_3
    //   35: aload 4
    //   37: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 271	java/io/File
    //   48: dup
    //   49: getstatic 57	com/tencent/mobileqq/identification/ActReflectRequestHelper:o	Ljava/lang/String;
    //   52: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual 279	java/io/File:exists	()Z
    //   60: ifne +11 -> 71
    //   63: aload_3
    //   64: invokevirtual 282	java/io/File:mkdirs	()Z
    //   67: pop
    //   68: goto +13 -> 81
    //   71: aload_3
    //   72: invokevirtual 285	java/io/File:delete	()Z
    //   75: pop
    //   76: aload_3
    //   77: invokevirtual 282	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: new 287	java/io/BufferedOutputStream
    //   84: dup
    //   85: new 289	java/io/FileOutputStream
    //   88: dup
    //   89: aload 5
    //   91: invokespecial 292	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 295	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: aload 4
    //   104: bipush 40
    //   106: invokevirtual 298	java/io/BufferedOutputStream:write	(I)V
    //   109: aload 4
    //   111: astore_3
    //   112: aload_1
    //   113: invokevirtual 301	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   116: astore_1
    //   117: aload 4
    //   119: astore_3
    //   120: aload 4
    //   122: aload_1
    //   123: arraylength
    //   124: invokestatic 306	com/tencent/mobileqq/util/Utils:d	(I)[B
    //   127: invokevirtual 309	java/io/BufferedOutputStream:write	([B)V
    //   130: aload 4
    //   132: astore_3
    //   133: aload 4
    //   135: aload_2
    //   136: ldc_w 311
    //   139: invokevirtual 314	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   142: arraylength
    //   143: invokestatic 306	com/tencent/mobileqq/util/Utils:d	(I)[B
    //   146: invokevirtual 309	java/io/BufferedOutputStream:write	([B)V
    //   149: aload 4
    //   151: astore_3
    //   152: aload 4
    //   154: aload_1
    //   155: invokevirtual 309	java/io/BufferedOutputStream:write	([B)V
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: aload_2
    //   164: ldc_w 311
    //   167: invokevirtual 314	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   170: invokevirtual 309	java/io/BufferedOutputStream:write	([B)V
    //   173: aload 4
    //   175: astore_3
    //   176: aload 4
    //   178: bipush 41
    //   180: invokevirtual 298	java/io/BufferedOutputStream:write	(I)V
    //   183: aload 4
    //   185: astore_3
    //   186: aload 4
    //   188: invokevirtual 317	java/io/BufferedOutputStream:flush	()V
    //   191: aload 4
    //   193: invokestatic 320	com/tencent/mobileqq/util/Utils:a	(Ljava/io/Closeable;)V
    //   196: aload 5
    //   198: invokevirtual 323	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   201: areturn
    //   202: astore_1
    //   203: goto +17 -> 220
    //   206: astore_1
    //   207: goto +39 -> 246
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_3
    //   213: goto +56 -> 269
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aload 4
    //   222: astore_3
    //   223: ldc_w 325
    //   226: iconst_1
    //   227: aload_1
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   235: aload 4
    //   237: invokestatic 320	com/tencent/mobileqq/util/Utils:a	(Ljava/io/Closeable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore 4
    //   246: aload 4
    //   248: astore_3
    //   249: ldc_w 325
    //   252: iconst_1
    //   253: aload_1
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   261: aload 4
    //   263: invokestatic 320	com/tencent/mobileqq/util/Utils:a	(Ljava/io/Closeable;)V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_1
    //   269: aload_3
    //   270: invokestatic 320	com/tencent/mobileqq/util/Utils:a	(Ljava/io/Closeable;)V
    //   273: aload_1
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ActReflectRequestHelper
    //   0	275	1	paramRequest	faceproto.Request
    //   0	275	2	paramString	String
    //   3	267	3	localObject1	Object
    //   11	251	4	localObject2	Object
    //   43	154	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   102	109	202	java/io/IOException
    //   112	117	202	java/io/IOException
    //   120	130	202	java/io/IOException
    //   133	149	202	java/io/IOException
    //   152	158	202	java/io/IOException
    //   161	173	202	java/io/IOException
    //   176	183	202	java/io/IOException
    //   186	191	202	java/io/IOException
    //   102	109	206	java/io/FileNotFoundException
    //   112	117	206	java/io/FileNotFoundException
    //   120	130	206	java/io/FileNotFoundException
    //   133	149	206	java/io/FileNotFoundException
    //   152	158	206	java/io/FileNotFoundException
    //   161	173	206	java/io/FileNotFoundException
    //   176	183	206	java/io/FileNotFoundException
    //   186	191	206	java/io/FileNotFoundException
    //   81	99	210	finally
    //   81	99	216	java/io/IOException
    //   81	99	242	java/io/FileNotFoundException
    //   102	109	268	finally
    //   112	117	268	finally
    //   120	130	268	finally
    //   133	149	268	finally
    //   152	158	268	finally
    //   161	173	268	finally
    //   176	183	268	finally
    //   186	191	268	finally
    //   223	235	268	finally
    //   249	261	268	finally
  }
  
  public void a()
  {
    Object localObject = a(this.m, this.b);
    boolean bool;
    if (localObject == null) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("ActReflectRequestHelper", 1, new Object[] { "start pack request, request is null ? ", Boolean.valueOf(bool) });
    if (localObject != null)
    {
      localObject = a((faceproto.Request)localObject, this.m);
      if (localObject == null)
      {
        this.a.onRequestFinish(2, a(211, HardCodeUtil.a(2131903988), false));
        return;
      }
      this.n = System.currentTimeMillis();
      byte[] arrayOfByte = MD5.getFileMd5((String)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", (String)localObject);
      localBundle.putByteArray("md5", arrayOfByte);
      localBundle.putInt("srcAppId", this.d);
      localBundle.putInt("serviceType", this.l);
      localBundle.putString("method", this.i);
      localBundle.putString("uin", this.j);
      localBundle.putString("ticket", this.k);
      localBundle.putInt("key_identification_type", 4);
      a(localBundle, (String)localObject);
      return;
    }
    this.a.onRequestFinish(2, null);
  }
  
  protected void a(Bundle paramBundle, String paramString)
  {
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", paramBundle, new ActReflectRequestHelper.1(this, paramString));
  }
  
  protected void a(EIPCResult paramEIPCResult, String paramString)
  {
    long l1 = FileUtils.getFileSizes(paramString) / 1024L;
    int i1 = paramEIPCResult.code;
    if (i1 != -102)
    {
      if (i1 == 0) {
        this.a.onRequestFinish(1, paramEIPCResult.data);
      }
    }
    else {
      this.a.onRequestFinish(2, paramEIPCResult.data);
    }
    ReportController.b(null, "dc00898", "", "", "0X800AC2D", "0X800AC2D", 0, 0, String.valueOf(System.currentTimeMillis() - this.n), String.valueOf(l1), "", "");
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.ActReflectRequestHelper
 * JD-Core Version:    0.7.0.1
 */