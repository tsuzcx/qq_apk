package cooperation.troop_homework;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.InvalidParameterException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopHomeworkHelper$UploadFileTask
{
  OkHttpClient a;
  String b;
  String c;
  String d;
  TroopHomeworkHelper.UploadCallback e;
  AppRuntime f;
  String g;
  JSONObject h;
  int i;
  long j;
  boolean k = false;
  boolean l = true;
  
  public TroopHomeworkHelper$UploadFileTask(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.f = paramAppRuntime;
    this.g = paramString2;
    this.j = 0L;
  }
  
  private String a(int paramInt, JSONArray paramJSONArray)
  {
    int m = 0;
    while (m < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(m);
      if (localJSONObject.optInt("position") == paramInt) {
        return localJSONObject.optString("authorization");
      }
      m += 1;
    }
    paramJSONArray = new InvalidParameterException("not found auth data");
    for (;;)
    {
      throw paramJSONArray;
    }
  }
  
  private void d()
  {
    String str = QQFileManagerUtil.a(QQFileManagerUtil.o(new String(this.d))).toLowerCase();
    int m = NetworkUtil.getNetworkType(MobileQQ.getContext());
    Object localObject3 = new File(this.d);
    Object localObject1 = TroopHomeworkHelper.a(this.f, ((File)localObject3).getName(), this.g, str);
    Object localObject2;
    if ((localObject1 != null) && (((JSONObject)localObject1).optInt("retcode") == 0))
    {
      Object localObject4 = ((JSONObject)localObject1).optJSONObject("data");
      if (localObject4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, dataObject == null");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-1", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
        return;
      }
      localObject2 = ((JSONObject)localObject4).optString("file_url");
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, TextUtils.isEmpty(putUrl)");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-2", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
        return;
      }
      localObject4 = ((JSONObject)localObject4).optString("max_size", "0");
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        try
        {
          long l1 = Long.parseLong((String)localObject4);
          if ((l1 != 0L) && (((File)localObject3).length() > l1))
          {
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("getCosUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:");
              ((StringBuilder)localObject4).append(l1);
              ((StringBuilder)localObject4).append(", filesize:");
              ((StringBuilder)localObject4).append(((File)localObject3).length());
              QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject4).toString());
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(m);
            ((StringBuilder)localObject3).append("");
            TroopReportor.a("grp_hw", "upload_video", "-3", "", ((StringBuilder)localObject3).toString(), "");
            if (this.e != null) {
              this.e.b(3);
            }
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("UploadVideoJob, get MaxSize exception:");
            ((StringBuilder)localObject4).append(localNumberFormatException.getMessage());
            QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
      int n = TroopHomeworkHelper.a((JSONObject)localObject1, this.d, str);
      if (n == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopHomeworkHelper", 2, "doPutCOSData success");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "0", "1", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).a((String)localObject2);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doPutCOSData failed, putResult =");
          ((StringBuilder)localObject1).append(n);
          QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-4", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(5);
        }
      }
    }
    else if (localObject1 != null)
    {
      if (((JSONObject)localObject1).optInt("retcode") != 1006)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getCosUploadAuthSync failed, ret:");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-6", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getCosUploadAuthSync failed, 达到当日上传次数限制, ret:");
          ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
          QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-5", "", ((StringBuilder)localObject1).toString(), "");
        if (this.l) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.2(this));
        }
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(4);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("");
      TroopReportor.a("grp_hw", "upload_video", "-7", "", ((StringBuilder)localObject1).toString(), "");
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
      }
    }
  }
  
  private void e()
  {
    this.k = false;
    int m = NetworkUtil.getNetworkType(MobileQQ.getContext());
    Object localObject2 = new File(this.d);
    Object localObject1 = TroopHomeworkHelper.c(this.d);
    localObject1 = TroopHomeworkHelper.b(this.f, ((File)localObject2).getName(), this.g, (String)localObject1);
    if ((localObject1 != null) && (((JSONObject)localObject1).optInt("retcode") == 0))
    {
      localObject1 = ((JSONObject)localObject1).optJSONObject("data");
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, dataObject == null");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-1", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
        return;
      }
      this.b = ((JSONObject)localObject1).optString("file_url");
      if (TextUtils.isEmpty(this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, TextUtils.isEmpty(appendUrl)");
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-2", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
        return;
      }
      Object localObject3 = ((JSONObject)localObject1).optString("max_size", "0");
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        try
        {
          long l1 = Long.parseLong((String)localObject3);
          if ((l1 != 0L) && (((File)localObject2).length() > l1))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("getAppendUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:");
              ((StringBuilder)localObject3).append(l1);
              ((StringBuilder)localObject3).append(", filesize:");
              ((StringBuilder)localObject3).append(((File)localObject2).length());
              QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(m);
            ((StringBuilder)localObject2).append("");
            TroopReportor.a("grp_hw", "upload_video", "-3", "", ((StringBuilder)localObject2).toString(), "");
            if (this.e != null) {
              this.e.b(3);
            }
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("UploadVideoJob, get MaxSize exception:");
            ((StringBuilder)localObject3).append(localNumberFormatException.getMessage());
            QLog.w("TroopHomeworkHelper", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      this.h = ((JSONObject)localObject1);
      f();
      return;
    }
    if (localObject1 != null)
    {
      StringBuilder localStringBuilder;
      if (((JSONObject)localObject1).optInt("retcode") != 1006)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCosUploadAuthSync failed, ret:");
          localStringBuilder.append(((JSONObject)localObject1).toString());
          QLog.w("TroopHomeworkHelper", 2, localStringBuilder.toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-6", "", ((StringBuilder)localObject1).toString(), "");
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCosUploadAuthSync failed, 达到当日上传次数限制, ret:");
          localStringBuilder.append(((JSONObject)localObject1).toString());
          QLog.w("TroopHomeworkHelper", 2, localStringBuilder.toString());
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append("");
        TroopReportor.a("grp_hw", "upload_video", "-5", "", ((StringBuilder)localObject1).toString(), "");
        if (this.l) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.3(this));
        }
        localObject1 = this.e;
        if (localObject1 != null) {
          ((TroopHomeworkHelper.UploadCallback)localObject1).b(4);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("");
      TroopReportor.a("grp_hw", "upload_video", "-7", "", ((StringBuilder)localObject1).toString(), "");
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TroopHomeworkHelper.UploadCallback)localObject1).b(2);
      }
    }
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: ldc_w 283
    //   3: astore 16
    //   5: ldc_w 285
    //   8: astore 21
    //   10: ldc 130
    //   12: astore 15
    //   14: aload_0
    //   15: getfield 287	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:a	Lokhttp3/OkHttpClient;
    //   18: ifnonnull +47 -> 65
    //   21: aload_0
    //   22: new 289	okhttp3/OkHttpClient
    //   25: dup
    //   26: invokespecial 290	okhttp3/OkHttpClient:<init>	()V
    //   29: invokevirtual 294	okhttp3/OkHttpClient:newBuilder	()Lokhttp3/OkHttpClient$Builder;
    //   32: ldc2_w 295
    //   35: getstatic 302	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   38: invokevirtual 308	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   41: ldc2_w 295
    //   44: getstatic 302	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   47: invokevirtual 311	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   50: ldc2_w 295
    //   53: getstatic 302	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   56: invokevirtual 314	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   59: invokevirtual 318	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   62: putfield 287	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:a	Lokhttp3/OkHttpClient;
    //   65: invokestatic 98	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   68: invokestatic 104	com/tencent/mobileqq/utils/NetworkUtil:getNetworkType	(Landroid/content/Context;)I
    //   71: istore 4
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 270	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:h	Lorg/json/JSONObject;
    //   78: ldc_w 320
    //   81: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: putfield 322	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:c	Ljava/lang/String;
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 270	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:h	Lorg/json/JSONObject;
    //   92: ldc 171
    //   94: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: putfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:b	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 270	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:h	Lorg/json/JSONObject;
    //   104: ldc_w 324
    //   107: invokevirtual 328	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   110: astore 29
    //   112: aload_0
    //   113: iconst_3
    //   114: putfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   117: new 332	java/io/RandomAccessFile
    //   120: dup
    //   121: aload_0
    //   122: getfield 35	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:d	Ljava/lang/String;
    //   125: ldc_w 334
    //   128: invokespecial 337	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: astore 17
    //   133: aload 17
    //   135: astore 19
    //   137: aload 16
    //   139: astore 26
    //   141: aload 15
    //   143: astore 18
    //   145: aload 17
    //   147: astore 23
    //   149: aload 16
    //   151: astore 27
    //   153: aload 15
    //   155: astore 20
    //   157: aload 17
    //   159: astore 24
    //   161: aload 16
    //   163: astore 28
    //   165: aload 15
    //   167: astore 22
    //   169: aload 17
    //   171: astore 25
    //   173: aload 17
    //   175: invokevirtual 338	java/io/RandomAccessFile:length	()J
    //   178: lstore 8
    //   180: aload 17
    //   182: astore 19
    //   184: aload 16
    //   186: astore 26
    //   188: aload 15
    //   190: astore 18
    //   192: aload 17
    //   194: astore 23
    //   196: aload 16
    //   198: astore 27
    //   200: aload 15
    //   202: astore 20
    //   204: aload 17
    //   206: astore 24
    //   208: aload 16
    //   210: astore 28
    //   212: aload 15
    //   214: astore 22
    //   216: aload 17
    //   218: astore 25
    //   220: aload_0
    //   221: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   224: lstore 6
    //   226: aload 17
    //   228: astore 19
    //   230: aload 16
    //   232: astore 26
    //   234: aload 15
    //   236: astore 18
    //   238: aload 17
    //   240: astore 23
    //   242: aload 16
    //   244: astore 27
    //   246: aload 15
    //   248: astore 20
    //   250: aload 17
    //   252: astore 24
    //   254: aload 16
    //   256: astore 28
    //   258: aload 15
    //   260: astore 22
    //   262: aload 17
    //   264: astore 25
    //   266: aload_0
    //   267: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   270: lload 8
    //   272: lcmp
    //   273: ifge +1583 -> 1856
    //   276: aload 17
    //   278: astore 19
    //   280: aload 16
    //   282: astore 26
    //   284: aload 15
    //   286: astore 18
    //   288: aload 17
    //   290: astore 23
    //   292: aload 16
    //   294: astore 27
    //   296: aload 15
    //   298: astore 20
    //   300: aload 17
    //   302: astore 24
    //   304: aload 16
    //   306: astore 28
    //   308: aload 15
    //   310: astore 22
    //   312: aload 17
    //   314: astore 25
    //   316: aload_0
    //   317: getfield 31	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:k	Z
    //   320: istore 14
    //   322: iload 14
    //   324: ifeq +17 -> 341
    //   327: aload 17
    //   329: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   332: return
    //   333: astore 15
    //   335: aload 15
    //   337: invokevirtual 344	java/io/IOException:printStackTrace	()V
    //   340: return
    //   341: aload 17
    //   343: astore 19
    //   345: aload 16
    //   347: astore 26
    //   349: aload 15
    //   351: astore 18
    //   353: aload 17
    //   355: astore 23
    //   357: aload 16
    //   359: astore 27
    //   361: aload 15
    //   363: astore 20
    //   365: aload 17
    //   367: astore 24
    //   369: aload 16
    //   371: astore 28
    //   373: aload 15
    //   375: astore 22
    //   377: aload 17
    //   379: astore 25
    //   381: aload_0
    //   382: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   385: lstore 10
    //   387: lload 8
    //   389: lload 10
    //   391: lsub
    //   392: ldc2_w 345
    //   395: lcmp
    //   396: ifle +63 -> 459
    //   399: aload 16
    //   401: astore 26
    //   403: aload 15
    //   405: astore 18
    //   407: aload 17
    //   409: astore 23
    //   411: aload 16
    //   413: astore 27
    //   415: aload 15
    //   417: astore 20
    //   419: aload 17
    //   421: astore 24
    //   423: aload 16
    //   425: astore 28
    //   427: aload 15
    //   429: astore 22
    //   431: aload 17
    //   433: astore 25
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   440: ldc2_w 347
    //   443: ladd
    //   444: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   447: goto +58 -> 505
    //   450: astore 15
    //   452: aload 17
    //   454: astore 19
    //   456: goto +2027 -> 2483
    //   459: aload 17
    //   461: astore 19
    //   463: aload 16
    //   465: astore 26
    //   467: aload 15
    //   469: astore 18
    //   471: aload 17
    //   473: astore 23
    //   475: aload 16
    //   477: astore 27
    //   479: aload 15
    //   481: astore 20
    //   483: aload 17
    //   485: astore 24
    //   487: aload 16
    //   489: astore 28
    //   491: aload 15
    //   493: astore 22
    //   495: aload 17
    //   497: astore 25
    //   499: aload_0
    //   500: lload 8
    //   502: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   505: aload 17
    //   507: astore 19
    //   509: aload 16
    //   511: astore 26
    //   513: aload 15
    //   515: astore 18
    //   517: aload 17
    //   519: astore 23
    //   521: aload 16
    //   523: astore 27
    //   525: aload 15
    //   527: astore 20
    //   529: aload 17
    //   531: astore 24
    //   533: aload 16
    //   535: astore 28
    //   537: aload 15
    //   539: astore 22
    //   541: aload 17
    //   543: astore 25
    //   545: aload_0
    //   546: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   549: lstore 10
    //   551: lload 10
    //   553: lload 6
    //   555: lsub
    //   556: lstore 10
    //   558: lload 10
    //   560: l2i
    //   561: istore_2
    //   562: aload 17
    //   564: astore 19
    //   566: iload_2
    //   567: newarray byte
    //   569: astore 20
    //   571: aload 17
    //   573: astore 19
    //   575: aload 17
    //   577: lload 6
    //   579: invokevirtual 352	java/io/RandomAccessFile:seek	(J)V
    //   582: aload 17
    //   584: astore 19
    //   586: sipush 4096
    //   589: newarray byte
    //   591: astore 22
    //   593: iconst_0
    //   594: istore_1
    //   595: aload 17
    //   597: astore 18
    //   599: aload 18
    //   601: astore 19
    //   603: aload 18
    //   605: aload 22
    //   607: invokevirtual 356	java/io/RandomAccessFile:read	([B)I
    //   610: istore 5
    //   612: iload 5
    //   614: ifle +1898 -> 2512
    //   617: aload 18
    //   619: astore 17
    //   621: iload_1
    //   622: iload 5
    //   624: iadd
    //   625: istore_3
    //   626: iload_3
    //   627: i2l
    //   628: lload 10
    //   630: lcmp
    //   631: ifgt +27 -> 658
    //   634: aload 17
    //   636: astore 19
    //   638: aload 22
    //   640: iconst_0
    //   641: aload 20
    //   643: iload_1
    //   644: iload 5
    //   646: invokestatic 362	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   649: iload_3
    //   650: istore_1
    //   651: aload 17
    //   653: astore 18
    //   655: goto -56 -> 599
    //   658: aload 17
    //   660: astore 19
    //   662: aload 22
    //   664: iconst_0
    //   665: aload 20
    //   667: iload_1
    //   668: lload 10
    //   670: iload_1
    //   671: i2l
    //   672: lsub
    //   673: l2i
    //   674: invokestatic 362	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   677: iload_2
    //   678: istore_1
    //   679: goto +3 -> 682
    //   682: lload 8
    //   684: lstore 12
    //   686: aload 18
    //   688: astore 17
    //   690: aload 17
    //   692: astore 19
    //   694: ldc_w 364
    //   697: invokestatic 370	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   700: aload 20
    //   702: iconst_0
    //   703: iload_1
    //   704: invokestatic 376	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;
    //   707: astore 20
    //   709: aload 17
    //   711: astore 19
    //   713: new 378	okhttp3/Request$Builder
    //   716: dup
    //   717: invokespecial 379	okhttp3/Request$Builder:<init>	()V
    //   720: astore 22
    //   722: aload 17
    //   724: astore 19
    //   726: new 138	java/lang/StringBuilder
    //   729: dup
    //   730: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   733: astore 23
    //   735: aload 17
    //   737: astore 19
    //   739: aload 23
    //   741: aload_0
    //   742: getfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:b	Ljava/lang/String;
    //   745: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 17
    //   751: astore 19
    //   753: aload 23
    //   755: ldc_w 381
    //   758: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 17
    //   764: astore 19
    //   766: aload 23
    //   768: lload 6
    //   770: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 17
    //   776: astore 19
    //   778: aload 22
    //   780: aload 23
    //   782: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokevirtual 385	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   788: ldc_w 387
    //   791: aload_0
    //   792: getfield 322	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:c	Ljava/lang/String;
    //   795: invokevirtual 391	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   798: ldc_w 393
    //   801: ldc_w 395
    //   804: invokevirtual 391	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   807: ldc_w 397
    //   810: ldc_w 364
    //   813: invokevirtual 391	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   816: ldc_w 399
    //   819: aload_0
    //   820: lload 6
    //   822: l2i
    //   823: aload 29
    //   825: invokespecial 401	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:a	(ILorg/json/JSONArray;)Ljava/lang/String;
    //   828: invokevirtual 391	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   831: aload 20
    //   833: invokevirtual 404	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   836: invokevirtual 407	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   839: astore 20
    //   841: aload_0
    //   842: getfield 287	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:a	Lokhttp3/OkHttpClient;
    //   845: aload 20
    //   847: invokevirtual 411	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   850: invokeinterface 417 1 0
    //   855: astore 20
    //   857: aload 20
    //   859: invokevirtual 422	okhttp3/Response:isSuccessful	()Z
    //   862: istore 14
    //   864: iload 14
    //   866: ifeq +148 -> 1014
    //   869: aload_0
    //   870: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   873: astore 18
    //   875: aload 18
    //   877: ifnull +104 -> 981
    //   880: aload_0
    //   881: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   884: iload_1
    //   885: i2l
    //   886: lload 6
    //   888: ladd
    //   889: ldc2_w 423
    //   892: lmul
    //   893: lload 12
    //   895: ldiv
    //   896: l2i
    //   897: invokeinterface 426 2 0
    //   902: aload_0
    //   903: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   906: lload 12
    //   908: lcmp
    //   909: iflt +72 -> 981
    //   912: new 138	java/lang/StringBuilder
    //   915: dup
    //   916: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   919: astore 18
    //   921: aload 18
    //   923: iload 4
    //   925: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload 18
    //   931: ldc 145
    //   933: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: ldc 150
    //   939: ldc 152
    //   941: ldc 185
    //   943: ldc_w 428
    //   946: aload 18
    //   948: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: ldc 145
    //   953: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   956: aload_0
    //   957: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   960: aload_0
    //   961: getfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:b	Ljava/lang/String;
    //   964: invokeinterface 222 2 0
    //   969: goto +12 -> 981
    //   972: astore 19
    //   974: aload 20
    //   976: astore 18
    //   978: goto +346 -> 1324
    //   981: aload_0
    //   982: iconst_3
    //   983: putfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   986: aload_0
    //   987: getfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   990: lstore 8
    //   992: goto +161 -> 1153
    //   995: astore 19
    //   997: goto +10 -> 1007
    //   1000: astore 18
    //   1002: goto +610 -> 1612
    //   1005: astore 19
    //   1007: aload 20
    //   1009: astore 18
    //   1011: goto +313 -> 1324
    //   1014: aload_0
    //   1015: getfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   1018: iconst_1
    //   1019: isub
    //   1020: istore_1
    //   1021: aload_0
    //   1022: iload_1
    //   1023: putfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   1026: iload_1
    //   1027: ifgt +174 -> 1201
    //   1030: new 138	java/lang/StringBuilder
    //   1033: dup
    //   1034: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1037: astore 19
    //   1039: aload 19
    //   1041: iload 4
    //   1043: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 19
    //   1049: ldc 145
    //   1051: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: ldc 150
    //   1057: ldc 152
    //   1059: ldc_w 430
    //   1062: ldc 145
    //   1064: aload 19
    //   1066: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: ldc 145
    //   1071: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1074: lload 6
    //   1076: lstore 8
    //   1078: aload_0
    //   1079: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1082: ifnull -90 -> 992
    //   1085: aload_0
    //   1086: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1089: aload 20
    //   1091: invokevirtual 433	okhttp3/Response:code	()I
    //   1094: invokeinterface 169 2 0
    //   1099: aload_0
    //   1100: lload 6
    //   1102: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   1105: aload 17
    //   1107: astore 19
    //   1109: aload 20
    //   1111: ifnull +749 -> 1860
    //   1114: aload 17
    //   1116: astore 19
    //   1118: aload 20
    //   1120: invokevirtual 434	okhttp3/Response:close	()V
    //   1123: aload 17
    //   1125: astore 19
    //   1127: goto +733 -> 1860
    //   1130: astore 18
    //   1132: aload 17
    //   1134: astore 19
    //   1136: aload 15
    //   1138: iconst_1
    //   1139: aload 21
    //   1141: aload 18
    //   1143: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1146: aload 17
    //   1148: astore 19
    //   1150: goto +710 -> 1860
    //   1153: lload 8
    //   1155: lstore 10
    //   1157: aload 20
    //   1159: ifnull +120 -> 1279
    //   1162: aload 17
    //   1164: astore 19
    //   1166: aload 20
    //   1168: invokevirtual 434	okhttp3/Response:close	()V
    //   1171: lload 8
    //   1173: lstore 10
    //   1175: goto +104 -> 1279
    //   1178: astore 18
    //   1180: aload 17
    //   1182: astore 19
    //   1184: aload 15
    //   1186: iconst_1
    //   1187: aload 21
    //   1189: aload 18
    //   1191: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1194: lload 8
    //   1196: lstore 10
    //   1198: goto +81 -> 1279
    //   1201: aload_0
    //   1202: lload 6
    //   1204: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   1207: lload 6
    //   1209: lstore 10
    //   1211: aload 20
    //   1213: ifnull +66 -> 1279
    //   1216: aload 17
    //   1218: astore 19
    //   1220: aload 20
    //   1222: invokevirtual 434	okhttp3/Response:close	()V
    //   1225: lload 6
    //   1227: lstore 10
    //   1229: goto +50 -> 1279
    //   1232: aload 15
    //   1234: astore 18
    //   1236: astore 15
    //   1238: goto +553 -> 1791
    //   1241: aload 15
    //   1243: astore 18
    //   1245: astore 15
    //   1247: goto +569 -> 1816
    //   1250: aload 15
    //   1252: astore 18
    //   1254: astore 15
    //   1256: goto +585 -> 1841
    //   1259: astore 18
    //   1261: aload 17
    //   1263: astore 19
    //   1265: aload 15
    //   1267: iconst_1
    //   1268: aload 21
    //   1270: aload 18
    //   1272: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1275: lload 6
    //   1277: lstore 10
    //   1279: goto +307 -> 1586
    //   1282: astore 18
    //   1284: goto +15 -> 1299
    //   1287: astore 19
    //   1289: goto +15 -> 1304
    //   1292: astore 19
    //   1294: goto +10 -> 1304
    //   1297: astore 18
    //   1299: goto +313 -> 1612
    //   1302: astore 19
    //   1304: aload 20
    //   1306: astore 18
    //   1308: goto +16 -> 1324
    //   1311: astore 18
    //   1313: aconst_null
    //   1314: astore 20
    //   1316: goto +296 -> 1612
    //   1319: astore 19
    //   1321: aconst_null
    //   1322: astore 18
    //   1324: aload 21
    //   1326: astore 22
    //   1328: aload 15
    //   1330: astore 20
    //   1332: new 138	java/lang/StringBuilder
    //   1335: dup
    //   1336: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1339: astore 23
    //   1341: aload 23
    //   1343: aload 16
    //   1345: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 23
    //   1351: aload 19
    //   1353: invokevirtual 438	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1356: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 20
    //   1362: iconst_2
    //   1363: aload 23
    //   1365: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: aload 19
    //   1370: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1373: aload_0
    //   1374: getfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   1377: iconst_1
    //   1378: isub
    //   1379: istore_1
    //   1380: aload_0
    //   1381: iload_1
    //   1382: putfield 330	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:i	I
    //   1385: iload_1
    //   1386: ifgt +149 -> 1535
    //   1389: new 138	java/lang/StringBuilder
    //   1392: dup
    //   1393: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1396: astore 19
    //   1398: aload 19
    //   1400: iload 4
    //   1402: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 19
    //   1408: ldc 145
    //   1410: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: pop
    //   1414: ldc 150
    //   1416: ldc 152
    //   1418: ldc_w 440
    //   1421: ldc 145
    //   1423: aload 19
    //   1425: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: ldc 145
    //   1430: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1433: aload_0
    //   1434: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1437: ifnull +68 -> 1505
    //   1440: aload_0
    //   1441: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1444: bipush 6
    //   1446: invokeinterface 169 2 0
    //   1451: aload_0
    //   1452: lload 6
    //   1454: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   1457: aload 17
    //   1459: astore 19
    //   1461: aload 18
    //   1463: ifnull +397 -> 1860
    //   1466: aload 17
    //   1468: astore 19
    //   1470: aload 18
    //   1472: invokevirtual 434	okhttp3/Response:close	()V
    //   1475: aload 17
    //   1477: astore 19
    //   1479: goto +381 -> 1860
    //   1482: astore 18
    //   1484: aload 17
    //   1486: astore 19
    //   1488: aload 20
    //   1490: iconst_1
    //   1491: aload 22
    //   1493: aload 18
    //   1495: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1498: aload 17
    //   1500: astore 19
    //   1502: goto +358 -> 1860
    //   1505: lload 6
    //   1507: lstore 10
    //   1509: aload 18
    //   1511: ifnull +75 -> 1586
    //   1514: aload 17
    //   1516: astore 19
    //   1518: aload 18
    //   1520: invokevirtual 434	okhttp3/Response:close	()V
    //   1523: lload 6
    //   1525: lstore 10
    //   1527: goto +59 -> 1586
    //   1530: astore 18
    //   1532: goto +36 -> 1568
    //   1535: aload_0
    //   1536: lload 6
    //   1538: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   1541: lload 6
    //   1543: lstore 10
    //   1545: aload 18
    //   1547: ifnull +39 -> 1586
    //   1550: aload 17
    //   1552: astore 19
    //   1554: aload 18
    //   1556: invokevirtual 434	okhttp3/Response:close	()V
    //   1559: lload 6
    //   1561: lstore 10
    //   1563: goto +23 -> 1586
    //   1566: astore 18
    //   1568: aload 17
    //   1570: astore 19
    //   1572: aload 20
    //   1574: iconst_1
    //   1575: aload 22
    //   1577: aload 18
    //   1579: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1582: lload 6
    //   1584: lstore 10
    //   1586: lload 12
    //   1588: lstore 8
    //   1590: lload 10
    //   1592: lstore 6
    //   1594: goto -1368 -> 226
    //   1597: astore 19
    //   1599: goto +5 -> 1604
    //   1602: astore 19
    //   1604: aload 18
    //   1606: astore 20
    //   1608: aload 19
    //   1610: astore 18
    //   1612: aload 20
    //   1614: ifnull +31 -> 1645
    //   1617: aload 17
    //   1619: astore 19
    //   1621: aload 20
    //   1623: invokevirtual 434	okhttp3/Response:close	()V
    //   1626: goto +19 -> 1645
    //   1629: astore 20
    //   1631: aload 17
    //   1633: astore 19
    //   1635: aload 15
    //   1637: iconst_1
    //   1638: aload 21
    //   1640: aload 20
    //   1642: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1645: aload 17
    //   1647: astore 19
    //   1649: aload 18
    //   1651: athrow
    //   1652: aload 16
    //   1654: astore 18
    //   1656: aload 15
    //   1658: astore 16
    //   1660: astore 15
    //   1662: goto +294 -> 1956
    //   1665: aload 16
    //   1667: astore 18
    //   1669: aload 15
    //   1671: astore 16
    //   1673: astore 15
    //   1675: goto +462 -> 2137
    //   1678: aload 16
    //   1680: astore 18
    //   1682: aload 15
    //   1684: astore 16
    //   1686: astore 15
    //   1688: goto +630 -> 2318
    //   1691: astore 17
    //   1693: goto +15 -> 1708
    //   1696: astore 17
    //   1698: goto +35 -> 1733
    //   1701: astore 17
    //   1703: goto +55 -> 1758
    //   1706: astore 17
    //   1708: aload 18
    //   1710: astore 19
    //   1712: aload 16
    //   1714: astore 18
    //   1716: aload 15
    //   1718: astore 16
    //   1720: aload 17
    //   1722: astore 15
    //   1724: aload 19
    //   1726: astore 17
    //   1728: goto +228 -> 1956
    //   1731: astore 17
    //   1733: aload 18
    //   1735: astore 19
    //   1737: aload 16
    //   1739: astore 18
    //   1741: aload 15
    //   1743: astore 16
    //   1745: aload 17
    //   1747: astore 15
    //   1749: aload 19
    //   1751: astore 17
    //   1753: goto +384 -> 2137
    //   1756: astore 17
    //   1758: aload 18
    //   1760: astore 19
    //   1762: aload 16
    //   1764: astore 18
    //   1766: aload 15
    //   1768: astore 16
    //   1770: aload 17
    //   1772: astore 15
    //   1774: aload 19
    //   1776: astore 17
    //   1778: goto +540 -> 2318
    //   1781: astore 19
    //   1783: aload 15
    //   1785: astore 18
    //   1787: aload 19
    //   1789: astore 15
    //   1791: aload 16
    //   1793: astore 19
    //   1795: aload 18
    //   1797: astore 16
    //   1799: aload 19
    //   1801: astore 18
    //   1803: goto +153 -> 1956
    //   1806: astore 19
    //   1808: aload 15
    //   1810: astore 18
    //   1812: aload 19
    //   1814: astore 15
    //   1816: aload 16
    //   1818: astore 19
    //   1820: aload 18
    //   1822: astore 16
    //   1824: aload 19
    //   1826: astore 18
    //   1828: goto +309 -> 2137
    //   1831: astore 19
    //   1833: aload 15
    //   1835: astore 18
    //   1837: aload 19
    //   1839: astore 15
    //   1841: aload 16
    //   1843: astore 19
    //   1845: aload 18
    //   1847: astore 16
    //   1849: aload 19
    //   1851: astore 18
    //   1853: goto +465 -> 2318
    //   1856: aload 17
    //   1858: astore 19
    //   1860: aload 19
    //   1862: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   1865: return
    //   1866: astore 15
    //   1868: aload 15
    //   1870: invokevirtual 344	java/io/IOException:printStackTrace	()V
    //   1873: return
    //   1874: astore 15
    //   1876: goto +607 -> 2483
    //   1879: astore 15
    //   1881: aload 23
    //   1883: astore 17
    //   1885: aload 18
    //   1887: astore 16
    //   1889: aload 26
    //   1891: astore 18
    //   1893: goto +63 -> 1956
    //   1896: astore 15
    //   1898: aload 27
    //   1900: astore 18
    //   1902: aload 24
    //   1904: astore 17
    //   1906: aload 20
    //   1908: astore 16
    //   1910: goto +227 -> 2137
    //   1913: astore 15
    //   1915: aload 28
    //   1917: astore 18
    //   1919: aload 25
    //   1921: astore 17
    //   1923: aload 22
    //   1925: astore 16
    //   1927: goto +391 -> 2318
    //   1930: astore 15
    //   1932: aconst_null
    //   1933: astore 19
    //   1935: goto +548 -> 2483
    //   1938: astore 19
    //   1940: ldc_w 283
    //   1943: astore 18
    //   1945: aconst_null
    //   1946: astore 17
    //   1948: aload 15
    //   1950: astore 16
    //   1952: aload 19
    //   1954: astore 15
    //   1956: aload 17
    //   1958: astore 19
    //   1960: new 138	java/lang/StringBuilder
    //   1963: dup
    //   1964: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1967: astore 20
    //   1969: aload 17
    //   1971: astore 19
    //   1973: aload 20
    //   1975: aload 18
    //   1977: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: pop
    //   1981: aload 17
    //   1983: astore 19
    //   1985: aload 20
    //   1987: aload 15
    //   1989: invokevirtual 441	java/security/InvalidParameterException:getMessage	()Ljava/lang/String;
    //   1992: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: pop
    //   1996: aload 17
    //   1998: astore 19
    //   2000: aload 16
    //   2002: iconst_2
    //   2003: aload 20
    //   2005: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2008: aload 15
    //   2010: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2013: aload 17
    //   2015: astore 19
    //   2017: aload_0
    //   2018: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2021: ifnull +18 -> 2039
    //   2024: aload 17
    //   2026: astore 19
    //   2028: aload_0
    //   2029: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2032: bipush 6
    //   2034: invokeinterface 169 2 0
    //   2039: aload 17
    //   2041: astore 19
    //   2043: new 138	java/lang/StringBuilder
    //   2046: dup
    //   2047: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2050: astore 15
    //   2052: aload 17
    //   2054: astore 19
    //   2056: aload 15
    //   2058: iload 4
    //   2060: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2063: pop
    //   2064: aload 17
    //   2066: astore 19
    //   2068: aload 15
    //   2070: ldc 145
    //   2072: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: pop
    //   2076: aload 17
    //   2078: astore 19
    //   2080: ldc 150
    //   2082: ldc 152
    //   2084: ldc_w 443
    //   2087: ldc 145
    //   2089: aload 15
    //   2091: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: ldc 145
    //   2096: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2099: aload 17
    //   2101: astore 19
    //   2103: aload_0
    //   2104: lconst_0
    //   2105: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   2108: aload 17
    //   2110: ifnull +370 -> 2480
    //   2113: aload 17
    //   2115: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   2118: return
    //   2119: astore 19
    //   2121: ldc_w 283
    //   2124: astore 18
    //   2126: aconst_null
    //   2127: astore 17
    //   2129: aload 15
    //   2131: astore 16
    //   2133: aload 19
    //   2135: astore 15
    //   2137: aload 17
    //   2139: astore 19
    //   2141: new 138	java/lang/StringBuilder
    //   2144: dup
    //   2145: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2148: astore 20
    //   2150: aload 17
    //   2152: astore 19
    //   2154: aload 20
    //   2156: aload 18
    //   2158: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2161: pop
    //   2162: aload 17
    //   2164: astore 19
    //   2166: aload 20
    //   2168: aload 15
    //   2170: invokevirtual 438	java/io/IOException:getMessage	()Ljava/lang/String;
    //   2173: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2176: pop
    //   2177: aload 17
    //   2179: astore 19
    //   2181: aload 16
    //   2183: iconst_2
    //   2184: aload 20
    //   2186: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2189: aload 15
    //   2191: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2194: aload 17
    //   2196: astore 19
    //   2198: aload_0
    //   2199: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2202: ifnull +18 -> 2220
    //   2205: aload 17
    //   2207: astore 19
    //   2209: aload_0
    //   2210: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2213: bipush 6
    //   2215: invokeinterface 169 2 0
    //   2220: aload 17
    //   2222: astore 19
    //   2224: new 138	java/lang/StringBuilder
    //   2227: dup
    //   2228: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2231: astore 15
    //   2233: aload 17
    //   2235: astore 19
    //   2237: aload 15
    //   2239: iload 4
    //   2241: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2244: pop
    //   2245: aload 17
    //   2247: astore 19
    //   2249: aload 15
    //   2251: ldc 145
    //   2253: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: pop
    //   2257: aload 17
    //   2259: astore 19
    //   2261: ldc 150
    //   2263: ldc 152
    //   2265: ldc_w 445
    //   2268: ldc 145
    //   2270: aload 15
    //   2272: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2275: ldc 145
    //   2277: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2280: aload 17
    //   2282: astore 19
    //   2284: aload_0
    //   2285: lconst_0
    //   2286: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   2289: aload 17
    //   2291: ifnull +189 -> 2480
    //   2294: aload 17
    //   2296: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   2299: return
    //   2300: astore 19
    //   2302: ldc_w 283
    //   2305: astore 18
    //   2307: aconst_null
    //   2308: astore 17
    //   2310: aload 15
    //   2312: astore 16
    //   2314: aload 19
    //   2316: astore 15
    //   2318: aload 17
    //   2320: astore 19
    //   2322: new 138	java/lang/StringBuilder
    //   2325: dup
    //   2326: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2329: astore 20
    //   2331: aload 17
    //   2333: astore 19
    //   2335: aload 20
    //   2337: aload 18
    //   2339: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2342: pop
    //   2343: aload 17
    //   2345: astore 19
    //   2347: aload 20
    //   2349: aload 15
    //   2351: invokevirtual 446	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   2354: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: pop
    //   2358: aload 17
    //   2360: astore 19
    //   2362: aload 16
    //   2364: iconst_2
    //   2365: aload 20
    //   2367: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: aload 15
    //   2372: invokestatic 437	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2375: aload 17
    //   2377: astore 19
    //   2379: aload_0
    //   2380: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2383: ifnull +18 -> 2401
    //   2386: aload 17
    //   2388: astore 19
    //   2390: aload_0
    //   2391: getfield 164	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:e	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   2394: bipush 6
    //   2396: invokeinterface 169 2 0
    //   2401: aload 17
    //   2403: astore 19
    //   2405: new 138	java/lang/StringBuilder
    //   2408: dup
    //   2409: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2412: astore 15
    //   2414: aload 17
    //   2416: astore 19
    //   2418: aload 15
    //   2420: iload 4
    //   2422: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2425: pop
    //   2426: aload 17
    //   2428: astore 19
    //   2430: aload 15
    //   2432: ldc 145
    //   2434: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: pop
    //   2438: aload 17
    //   2440: astore 19
    //   2442: ldc 150
    //   2444: ldc 152
    //   2446: ldc_w 448
    //   2449: ldc 145
    //   2451: aload 15
    //   2453: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2456: ldc 145
    //   2458: invokestatic 162	com/tencent/mobileqq/utils/TroopReportor:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2461: aload 17
    //   2463: astore 19
    //   2465: aload_0
    //   2466: lconst_0
    //   2467: putfield 41	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:j	J
    //   2470: aload 17
    //   2472: ifnull +8 -> 2480
    //   2475: aload 17
    //   2477: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   2480: return
    //   2481: astore 15
    //   2483: aload 19
    //   2485: ifnull +18 -> 2503
    //   2488: aload 19
    //   2490: invokevirtual 341	java/io/RandomAccessFile:close	()V
    //   2493: goto +10 -> 2503
    //   2496: astore 16
    //   2498: aload 16
    //   2500: invokevirtual 344	java/io/IOException:printStackTrace	()V
    //   2503: goto +6 -> 2509
    //   2506: aload 15
    //   2508: athrow
    //   2509: goto -3 -> 2506
    //   2512: goto -1830 -> 682
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2515	0	this	UploadFileTask
    //   594	792	1	m	int
    //   561	117	2	n	int
    //   625	25	3	i1	int
    //   71	2350	4	i2	int
    //   610	35	5	i3	int
    //   224	1369	6	l1	long
    //   178	1411	8	l2	long
    //   385	1206	10	l3	long
    //   684	903	12	l4	long
    //   320	545	14	bool	boolean
    //   12	297	15	str1	String
    //   333	95	15	localIOException1	java.io.IOException
    //   450	783	15	str2	String
    //   1236	6	15	localInvalidParameterException1	InvalidParameterException
    //   1245	6	15	localIOException2	java.io.IOException
    //   1254	403	15	localFileNotFoundException1	java.io.FileNotFoundException
    //   1660	10	15	localInvalidParameterException2	InvalidParameterException
    //   1673	10	15	localIOException3	java.io.IOException
    //   1686	31	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   1722	118	15	localObject1	Object
    //   1866	3	15	localIOException4	java.io.IOException
    //   1874	1	15	localObject2	Object
    //   1879	1	15	localInvalidParameterException3	InvalidParameterException
    //   1896	1	15	localIOException5	java.io.IOException
    //   1913	1	15	localFileNotFoundException3	java.io.FileNotFoundException
    //   1930	19	15	localObject3	Object
    //   1954	498	15	localObject4	Object
    //   2481	26	15	localObject5	Object
    //   3	2360	16	localObject6	Object
    //   2496	3	16	localIOException6	java.io.IOException
    //   131	1515	17	localObject7	Object
    //   1691	1	17	localInvalidParameterException4	InvalidParameterException
    //   1696	1	17	localIOException7	java.io.IOException
    //   1701	1	17	localFileNotFoundException4	java.io.FileNotFoundException
    //   1706	15	17	localInvalidParameterException5	InvalidParameterException
    //   1726	1	17	localObject8	Object
    //   1731	15	17	localIOException8	java.io.IOException
    //   1751	1	17	localObject9	Object
    //   1756	15	17	localFileNotFoundException5	java.io.FileNotFoundException
    //   1776	700	17	localObject10	Object
    //   143	834	18	localObject11	Object
    //   1000	1	18	localObject12	Object
    //   1009	1	18	localObject13	Object
    //   1130	12	18	localException1	java.lang.Exception
    //   1178	12	18	localException2	java.lang.Exception
    //   1234	19	18	localObject14	Object
    //   1259	12	18	localException3	java.lang.Exception
    //   1282	1	18	localObject15	Object
    //   1297	1	18	localObject16	Object
    //   1306	1	18	localObject17	Object
    //   1311	1	18	localObject18	Object
    //   1322	149	18	localObject19	Object
    //   1482	37	18	localException4	java.lang.Exception
    //   1530	25	18	localException5	java.lang.Exception
    //   1566	39	18	localException6	java.lang.Exception
    //   1610	728	18	localObject20	Object
    //   135	642	19	localObject21	Object
    //   972	1	19	localIOException9	java.io.IOException
    //   995	1	19	localIOException10	java.io.IOException
    //   1005	1	19	localIOException11	java.io.IOException
    //   1037	227	19	localObject22	Object
    //   1287	1	19	localIOException12	java.io.IOException
    //   1292	1	19	localIOException13	java.io.IOException
    //   1302	1	19	localIOException14	java.io.IOException
    //   1319	50	19	localIOException15	java.io.IOException
    //   1396	175	19	localObject23	Object
    //   1597	1	19	localObject24	Object
    //   1602	7	19	localObject25	Object
    //   1619	156	19	localObject26	Object
    //   1781	7	19	localInvalidParameterException6	InvalidParameterException
    //   1793	7	19	localObject27	Object
    //   1806	7	19	localIOException16	java.io.IOException
    //   1818	7	19	localObject28	Object
    //   1831	7	19	localFileNotFoundException6	java.io.FileNotFoundException
    //   1843	91	19	localObject29	Object
    //   1938	15	19	localInvalidParameterException7	InvalidParameterException
    //   1958	144	19	localObject30	Object
    //   2119	15	19	localIOException17	java.io.IOException
    //   2139	144	19	localObject31	Object
    //   2300	15	19	localFileNotFoundException7	java.io.FileNotFoundException
    //   2320	169	19	localObject32	Object
    //   155	1467	20	localObject33	Object
    //   1629	278	20	localException7	java.lang.Exception
    //   1967	399	20	localStringBuilder	StringBuilder
    //   8	1631	21	str3	String
    //   167	1757	22	localObject34	Object
    //   147	1735	23	localObject35	Object
    //   159	1744	24	localObject36	Object
    //   171	1749	25	localObject37	Object
    //   139	1751	26	localObject38	Object
    //   151	1748	27	localObject39	Object
    //   163	1753	28	localObject40	Object
    //   110	714	29	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   327	332	333	java/io/IOException
    //   435	447	450	finally
    //   880	969	972	java/io/IOException
    //   981	992	995	java/io/IOException
    //   869	875	1000	finally
    //   880	969	1000	finally
    //   981	992	1000	finally
    //   869	875	1005	java/io/IOException
    //   1118	1123	1130	java/lang/Exception
    //   1166	1171	1178	java/lang/Exception
    //   1136	1146	1232	java/security/InvalidParameterException
    //   1166	1171	1232	java/security/InvalidParameterException
    //   1184	1194	1232	java/security/InvalidParameterException
    //   1220	1225	1232	java/security/InvalidParameterException
    //   1265	1275	1232	java/security/InvalidParameterException
    //   1136	1146	1241	java/io/IOException
    //   1166	1171	1241	java/io/IOException
    //   1184	1194	1241	java/io/IOException
    //   1220	1225	1241	java/io/IOException
    //   1265	1275	1241	java/io/IOException
    //   1136	1146	1250	java/io/FileNotFoundException
    //   1166	1171	1250	java/io/FileNotFoundException
    //   1184	1194	1250	java/io/FileNotFoundException
    //   1220	1225	1250	java/io/FileNotFoundException
    //   1265	1275	1250	java/io/FileNotFoundException
    //   1220	1225	1259	java/lang/Exception
    //   1201	1207	1282	finally
    //   1201	1207	1287	java/io/IOException
    //   1014	1026	1292	java/io/IOException
    //   1030	1074	1292	java/io/IOException
    //   1078	1105	1292	java/io/IOException
    //   857	864	1297	finally
    //   1014	1026	1297	finally
    //   1030	1074	1297	finally
    //   1078	1105	1297	finally
    //   857	864	1302	java/io/IOException
    //   841	857	1311	finally
    //   841	857	1319	java/io/IOException
    //   1470	1475	1482	java/lang/Exception
    //   1518	1523	1530	java/lang/Exception
    //   1554	1559	1566	java/lang/Exception
    //   1341	1385	1597	finally
    //   1389	1457	1597	finally
    //   1535	1541	1597	finally
    //   1332	1341	1602	finally
    //   1621	1626	1629	java/lang/Exception
    //   1470	1475	1652	java/security/InvalidParameterException
    //   1488	1498	1652	java/security/InvalidParameterException
    //   1518	1523	1652	java/security/InvalidParameterException
    //   1554	1559	1652	java/security/InvalidParameterException
    //   1572	1582	1652	java/security/InvalidParameterException
    //   1621	1626	1652	java/security/InvalidParameterException
    //   1635	1645	1652	java/security/InvalidParameterException
    //   1649	1652	1652	java/security/InvalidParameterException
    //   1470	1475	1665	java/io/IOException
    //   1488	1498	1665	java/io/IOException
    //   1518	1523	1665	java/io/IOException
    //   1554	1559	1665	java/io/IOException
    //   1572	1582	1665	java/io/IOException
    //   1621	1626	1665	java/io/IOException
    //   1635	1645	1665	java/io/IOException
    //   1649	1652	1665	java/io/IOException
    //   1470	1475	1678	java/io/FileNotFoundException
    //   1488	1498	1678	java/io/FileNotFoundException
    //   1518	1523	1678	java/io/FileNotFoundException
    //   1554	1559	1678	java/io/FileNotFoundException
    //   1572	1582	1678	java/io/FileNotFoundException
    //   1621	1626	1678	java/io/FileNotFoundException
    //   1635	1645	1678	java/io/FileNotFoundException
    //   1649	1652	1678	java/io/FileNotFoundException
    //   638	649	1691	java/security/InvalidParameterException
    //   662	677	1691	java/security/InvalidParameterException
    //   694	709	1691	java/security/InvalidParameterException
    //   713	722	1691	java/security/InvalidParameterException
    //   726	735	1691	java/security/InvalidParameterException
    //   739	749	1691	java/security/InvalidParameterException
    //   753	762	1691	java/security/InvalidParameterException
    //   766	774	1691	java/security/InvalidParameterException
    //   778	841	1691	java/security/InvalidParameterException
    //   1118	1123	1691	java/security/InvalidParameterException
    //   638	649	1696	java/io/IOException
    //   662	677	1696	java/io/IOException
    //   694	709	1696	java/io/IOException
    //   713	722	1696	java/io/IOException
    //   726	735	1696	java/io/IOException
    //   739	749	1696	java/io/IOException
    //   753	762	1696	java/io/IOException
    //   766	774	1696	java/io/IOException
    //   778	841	1696	java/io/IOException
    //   1118	1123	1696	java/io/IOException
    //   638	649	1701	java/io/FileNotFoundException
    //   662	677	1701	java/io/FileNotFoundException
    //   694	709	1701	java/io/FileNotFoundException
    //   713	722	1701	java/io/FileNotFoundException
    //   726	735	1701	java/io/FileNotFoundException
    //   739	749	1701	java/io/FileNotFoundException
    //   753	762	1701	java/io/FileNotFoundException
    //   766	774	1701	java/io/FileNotFoundException
    //   778	841	1701	java/io/FileNotFoundException
    //   1118	1123	1701	java/io/FileNotFoundException
    //   603	612	1706	java/security/InvalidParameterException
    //   603	612	1731	java/io/IOException
    //   603	612	1756	java/io/FileNotFoundException
    //   566	571	1781	java/security/InvalidParameterException
    //   575	582	1781	java/security/InvalidParameterException
    //   586	593	1781	java/security/InvalidParameterException
    //   566	571	1806	java/io/IOException
    //   575	582	1806	java/io/IOException
    //   586	593	1806	java/io/IOException
    //   566	571	1831	java/io/FileNotFoundException
    //   575	582	1831	java/io/FileNotFoundException
    //   586	593	1831	java/io/FileNotFoundException
    //   1860	1865	1866	java/io/IOException
    //   2113	2118	1866	java/io/IOException
    //   2294	2299	1866	java/io/IOException
    //   2475	2480	1866	java/io/IOException
    //   173	180	1874	finally
    //   220	226	1874	finally
    //   266	276	1874	finally
    //   316	322	1874	finally
    //   381	387	1874	finally
    //   499	505	1874	finally
    //   545	551	1874	finally
    //   566	571	1874	finally
    //   575	582	1874	finally
    //   586	593	1874	finally
    //   603	612	1874	finally
    //   173	180	1879	java/security/InvalidParameterException
    //   220	226	1879	java/security/InvalidParameterException
    //   266	276	1879	java/security/InvalidParameterException
    //   316	322	1879	java/security/InvalidParameterException
    //   381	387	1879	java/security/InvalidParameterException
    //   435	447	1879	java/security/InvalidParameterException
    //   499	505	1879	java/security/InvalidParameterException
    //   545	551	1879	java/security/InvalidParameterException
    //   173	180	1896	java/io/IOException
    //   220	226	1896	java/io/IOException
    //   266	276	1896	java/io/IOException
    //   316	322	1896	java/io/IOException
    //   381	387	1896	java/io/IOException
    //   435	447	1896	java/io/IOException
    //   499	505	1896	java/io/IOException
    //   545	551	1896	java/io/IOException
    //   173	180	1913	java/io/FileNotFoundException
    //   220	226	1913	java/io/FileNotFoundException
    //   266	276	1913	java/io/FileNotFoundException
    //   316	322	1913	java/io/FileNotFoundException
    //   381	387	1913	java/io/FileNotFoundException
    //   435	447	1913	java/io/FileNotFoundException
    //   499	505	1913	java/io/FileNotFoundException
    //   545	551	1913	java/io/FileNotFoundException
    //   117	133	1930	finally
    //   117	133	1938	java/security/InvalidParameterException
    //   117	133	2119	java/io/IOException
    //   117	133	2300	java/io/FileNotFoundException
    //   638	649	2481	finally
    //   662	677	2481	finally
    //   694	709	2481	finally
    //   713	722	2481	finally
    //   726	735	2481	finally
    //   739	749	2481	finally
    //   753	762	2481	finally
    //   766	774	2481	finally
    //   778	841	2481	finally
    //   1118	1123	2481	finally
    //   1136	1146	2481	finally
    //   1166	1171	2481	finally
    //   1184	1194	2481	finally
    //   1220	1225	2481	finally
    //   1265	1275	2481	finally
    //   1470	1475	2481	finally
    //   1488	1498	2481	finally
    //   1518	1523	2481	finally
    //   1554	1559	2481	finally
    //   1572	1582	2481	finally
    //   1621	1626	2481	finally
    //   1635	1645	2481	finally
    //   1649	1652	2481	finally
    //   1960	1969	2481	finally
    //   1973	1981	2481	finally
    //   1985	1996	2481	finally
    //   2000	2013	2481	finally
    //   2017	2024	2481	finally
    //   2028	2039	2481	finally
    //   2043	2052	2481	finally
    //   2056	2064	2481	finally
    //   2068	2076	2481	finally
    //   2080	2099	2481	finally
    //   2103	2108	2481	finally
    //   2141	2150	2481	finally
    //   2154	2162	2481	finally
    //   2166	2177	2481	finally
    //   2181	2194	2481	finally
    //   2198	2205	2481	finally
    //   2209	2220	2481	finally
    //   2224	2233	2481	finally
    //   2237	2245	2481	finally
    //   2249	2257	2481	finally
    //   2261	2280	2481	finally
    //   2284	2289	2481	finally
    //   2322	2331	2481	finally
    //   2335	2343	2481	finally
    //   2347	2358	2481	finally
    //   2362	2375	2481	finally
    //   2379	2386	2481	finally
    //   2390	2401	2481	finally
    //   2405	2414	2481	finally
    //   2418	2426	2481	finally
    //   2430	2438	2481	finally
    //   2442	2461	2481	finally
    //   2465	2470	2481	finally
    //   2488	2493	2496	java/io/IOException
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.1(this), 8, null, true);
      return;
    }
    Object localObject = new File(this.d);
    if ((!((File)localObject).exists()) || (((File)localObject).length() == 0L))
    {
      TroopHomeworkHelper.UploadCallback localUploadCallback = this.e;
      if (localUploadCallback != null)
      {
        localUploadCallback.b(-1);
        int m = NetworkUtil.getNetworkType(MobileQQ.getContext());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append("");
        TroopReportor.a("grp_hw", "upload_video", "-13", "", ((StringBuilder)localObject).toString(), "");
        return;
      }
    }
    if (((File)localObject).length() > 4096L)
    {
      e();
      return;
    }
    d();
  }
  
  public void a(TroopHomeworkHelper.UploadCallback paramUploadCallback)
  {
    this.e = paramUploadCallback;
  }
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.4(this), 8, null, true);
      return;
    }
    Object localObject = new File(this.d);
    if ((!((File)localObject).exists()) || (((File)localObject).length() == 0L))
    {
      TroopHomeworkHelper.UploadCallback localUploadCallback = this.e;
      if (localUploadCallback != null)
      {
        localUploadCallback.b(-1);
        int m = NetworkUtil.getNetworkType(MobileQQ.getContext());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append("");
        TroopReportor.a("grp_hw", "upload_video", "-13", "", ((StringBuilder)localObject).toString(), "");
        return;
      }
    }
    if (((File)localObject).length() > 4096L)
    {
      if (this.h != null)
      {
        if (this.j >= ((File)localObject).length())
        {
          localObject = this.e;
          if (localObject != null) {
            ((TroopHomeworkHelper.UploadCallback)localObject).a(this.b);
          }
        }
        else
        {
          f();
        }
      }
      else {
        e();
      }
    }
    else {
      d();
    }
  }
  
  public void c()
  {
    this.k = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask
 * JD-Core Version:    0.7.0.1
 */