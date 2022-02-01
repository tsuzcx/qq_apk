package cooperation.troop_homework;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.InvalidParameterException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopHomeworkHelper$UploadFileTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  TroopHomeworkHelper.UploadCallback jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback;
  String jdField_a_of_type_JavaLangString;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String c;
  String d;
  
  public TroopHomeworkHelper$UploadFileTask(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.d = paramString2;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a(int paramInt, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject.optInt("position") == paramInt) {
        return localJSONObject.optString("authorization");
      }
      i += 1;
    }
    throw new InvalidParameterException("not found auth data");
  }
  
  private void d()
  {
    String str1 = FileHttpUtils.a(FileManagerUtil.a(new String(this.c))).toLowerCase();
    int i = NetworkUtil.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    JSONObject localJSONObject = TroopHomeworkHelper.a(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, str1);
    Object localObject;
    if ((localJSONObject != null) && (localJSONObject.optInt("retcode") == 0))
    {
      localObject = localJSONObject.optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, dataObject == null");
        }
        TroopTechReportUtils.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null) {
          this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            String str2;
            int j;
            do
            {
              for (;;)
              {
                return;
                str2 = ((JSONObject)localObject).optString("file_url");
                if (TextUtils.isEmpty(str2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, TextUtils.isEmpty(putUrl)");
                  }
                  TroopTechReportUtils.a("grp_hw", "upload_video", "-2", "", i + "", "");
                  if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null) {
                    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
                  }
                }
                else
                {
                  localObject = ((JSONObject)localObject).optString("max_size", "0");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    try
                    {
                      long l = Long.parseLong((String)localObject);
                      if ((l != 0L) && (localFile.length() > l))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                        }
                        TroopTechReportUtils.a("grp_hw", "upload_video", "-3", "", i + "", "");
                        if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null) {
                          continue;
                        }
                        this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(3);
                      }
                    }
                    catch (NumberFormatException localNumberFormatException)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                      }
                    }
                  }
                }
              }
              j = TroopHomeworkHelper.a(localJSONObject, this.c, str1);
              if (j != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopHomeworkHelper", 2, "doPutCOSData success");
              }
              TroopTechReportUtils.a("grp_hw", "upload_video", "0", "1", i + "", "");
            } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
            this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.a(str2);
            return;
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "doPutCOSData failed, putResult =" + j);
            }
            TroopTechReportUtils.a("grp_hw", "upload_video", "-4", "", i + "", "");
          } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
          this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(5);
          return;
          if (localJSONObject == null) {
            break;
          }
          switch (localJSONObject.optInt("retcode"))
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + localJSONObject.toString());
            }
            TroopTechReportUtils.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
        this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + localJSONObject.toString());
        }
        TroopTechReportUtils.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.2(this));
        }
      } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      TroopTechReportUtils.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    int i = NetworkUtil.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    Object localObject = TroopHomeworkHelper.c(this.c);
    localObject = TroopHomeworkHelper.b(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, (String)localObject);
    if ((localObject != null) && (((JSONObject)localObject).optInt("retcode") == 0))
    {
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, dataObject == null");
        }
        TroopTechReportUtils.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null) {
          this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("file_url");
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, TextUtils.isEmpty(appendUrl)");
              }
              TroopTechReportUtils.a("grp_hw", "upload_video", "-2", "", i + "", "");
              if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null) {
                this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
              }
            }
            else
            {
              String str = ((JSONObject)localObject).optString("max_size", "0");
              if (!TextUtils.isEmpty(str)) {
                try
                {
                  long l = Long.parseLong(str);
                  if ((l != 0L) && (localFile.length() > l))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                    }
                    TroopTechReportUtils.a("grp_hw", "upload_video", "-3", "", i + "", "");
                    if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null) {
                      continue;
                    }
                    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(3);
                  }
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                  }
                }
              }
            }
          }
          this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject);
          f();
          return;
          if (localObject == null) {
            break;
          }
          switch (((JSONObject)localObject).optInt("retcode"))
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + ((JSONObject)localObject).toString());
            }
            TroopTechReportUtils.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
        this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + ((JSONObject)localObject).toString());
        }
        TroopTechReportUtils.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.3(this));
        }
      } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      TroopTechReportUtils.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(2);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 278	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   4: ifnonnull +47 -> 51
    //   7: aload_0
    //   8: new 280	okhttp3/OkHttpClient
    //   11: dup
    //   12: invokespecial 281	okhttp3/OkHttpClient:<init>	()V
    //   15: invokevirtual 285	okhttp3/OkHttpClient:newBuilder	()Lokhttp3/OkHttpClient$Builder;
    //   18: ldc2_w 286
    //   21: getstatic 293	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   24: invokevirtual 299	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   27: ldc2_w 286
    //   30: getstatic 293	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: invokevirtual 302	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   36: ldc2_w 286
    //   39: getstatic 293	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   42: invokevirtual 305	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   45: invokevirtual 309	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   48: putfield 278	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   51: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokestatic 96	com/tencent/mobileqq/utils/NetworkUtil:b	(Landroid/content/Context;)I
    //   57: istore_3
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   63: ldc_w 311
    //   66: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: putfield 313	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   77: ldc 163
    //   79: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 258	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: getfield 264	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   89: ldc_w 315
    //   92: invokevirtual 319	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   95: astore 16
    //   97: aload_0
    //   98: iconst_3
    //   99: putfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   102: new 323	java/io/RandomAccessFile
    //   105: dup
    //   106: aload_0
    //   107: getfield 27	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:c	Ljava/lang/String;
    //   110: ldc_w 325
    //   113: invokespecial 328	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: astore 12
    //   118: aload 12
    //   120: astore 13
    //   122: aload 12
    //   124: invokevirtual 329	java/io/RandomAccessFile:length	()J
    //   127: lstore 9
    //   129: aload 12
    //   131: astore 13
    //   133: aload_0
    //   134: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   137: lstore 5
    //   139: aload 12
    //   141: astore 13
    //   143: aload_0
    //   144: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   147: lload 9
    //   149: lcmp
    //   150: ifge +725 -> 875
    //   153: aload 12
    //   155: astore 13
    //   157: aload_0
    //   158: getfield 23	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Boolean	Z
    //   161: istore 11
    //   163: iload 11
    //   165: ifeq +22 -> 187
    //   168: aload 12
    //   170: ifnull +8 -> 178
    //   173: aload 12
    //   175: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   178: return
    //   179: astore 12
    //   181: aload 12
    //   183: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   186: return
    //   187: aload 12
    //   189: astore 13
    //   191: lload 9
    //   193: aload_0
    //   194: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   197: lsub
    //   198: ldc2_w 336
    //   201: lcmp
    //   202: ifle +121 -> 323
    //   205: aload 12
    //   207: astore 13
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   214: ldc2_w 338
    //   217: ladd
    //   218: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   221: aload 12
    //   223: astore 13
    //   225: aload_0
    //   226: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   229: lload 5
    //   231: lsub
    //   232: lstore 7
    //   234: aload 12
    //   236: astore 13
    //   238: lload 7
    //   240: l2i
    //   241: newarray byte
    //   243: astore 14
    //   245: iconst_0
    //   246: istore_1
    //   247: aload 12
    //   249: astore 13
    //   251: aload 12
    //   253: lload 5
    //   255: invokevirtual 343	java/io/RandomAccessFile:seek	(J)V
    //   258: aload 12
    //   260: astore 13
    //   262: sipush 4096
    //   265: newarray byte
    //   267: astore 15
    //   269: aload 12
    //   271: astore 13
    //   273: aload 12
    //   275: aload 15
    //   277: invokevirtual 347	java/io/RandomAccessFile:read	([B)I
    //   280: istore 4
    //   282: iload_1
    //   283: istore_2
    //   284: iload 4
    //   286: ifle +184 -> 470
    //   289: iload_1
    //   290: iload 4
    //   292: iadd
    //   293: i2l
    //   294: lload 7
    //   296: lcmp
    //   297: ifgt +148 -> 445
    //   300: aload 12
    //   302: astore 13
    //   304: aload 15
    //   306: iconst_0
    //   307: aload 14
    //   309: iload_1
    //   310: iload 4
    //   312: invokestatic 353	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   315: iload_1
    //   316: iload 4
    //   318: iadd
    //   319: istore_1
    //   320: goto -51 -> 269
    //   323: aload 12
    //   325: astore 13
    //   327: aload_0
    //   328: lload 9
    //   330: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   333: goto -112 -> 221
    //   336: astore 13
    //   338: ldc 122
    //   340: iconst_2
    //   341: new 138	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 355
    //   351: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 13
    //   356: invokevirtual 356	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: aload 13
    //   367: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   370: aload_0
    //   371: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   374: ifnull +14 -> 388
    //   377: aload_0
    //   378: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   381: bipush 6
    //   383: invokeinterface 161 2 0
    //   388: ldc 130
    //   390: ldc 132
    //   392: ldc_w 361
    //   395: ldc 136
    //   397: new 138	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   404: iload_3
    //   405: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc 136
    //   410: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: ldc 136
    //   418: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload_0
    //   422: lconst_0
    //   423: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   426: aload 12
    //   428: ifnull -250 -> 178
    //   431: aload 12
    //   433: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   436: return
    //   437: astore 12
    //   439: aload 12
    //   441: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   444: return
    //   445: lload 7
    //   447: iload_1
    //   448: i2l
    //   449: lsub
    //   450: l2i
    //   451: istore_2
    //   452: aload 12
    //   454: astore 13
    //   456: aload 15
    //   458: iconst_0
    //   459: aload 14
    //   461: iload_1
    //   462: iload_2
    //   463: invokestatic 353	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   466: lload 7
    //   468: l2i
    //   469: istore_2
    //   470: aload 12
    //   472: astore 13
    //   474: ldc_w 363
    //   477: invokestatic 369	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   480: aload 14
    //   482: iconst_0
    //   483: iload_2
    //   484: invokestatic 375	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;
    //   487: astore 14
    //   489: aload 12
    //   491: astore 13
    //   493: new 377	okhttp3/Request$Builder
    //   496: dup
    //   497: invokespecial 378	okhttp3/Request$Builder:<init>	()V
    //   500: new 138	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   507: aload_0
    //   508: getfield 258	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 380
    //   517: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: lload 5
    //   522: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokevirtual 384	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   531: ldc_w 386
    //   534: aload_0
    //   535: getfield 313	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   538: invokevirtual 390	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   541: ldc_w 392
    //   544: ldc_w 394
    //   547: invokevirtual 390	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   550: ldc_w 396
    //   553: ldc_w 363
    //   556: invokevirtual 390	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   559: ldc_w 398
    //   562: aload_0
    //   563: lload 5
    //   565: l2i
    //   566: aload 16
    //   568: invokespecial 400	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:a	(ILorg/json/JSONArray;)Ljava/lang/String;
    //   571: invokevirtual 390	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   574: aload 14
    //   576: invokevirtual 403	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   579: invokevirtual 406	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   582: astore 14
    //   584: aload_0
    //   585: getfield 278	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   588: aload 14
    //   590: invokevirtual 410	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   593: invokeinterface 416 1 0
    //   598: astore 14
    //   600: aload 14
    //   602: astore 13
    //   604: aload 14
    //   606: invokevirtual 421	okhttp3/Response:isSuccessful	()Z
    //   609: ifeq +152 -> 761
    //   612: aload 14
    //   614: astore 13
    //   616: aload_0
    //   617: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   620: ifnull +97 -> 717
    //   623: aload 14
    //   625: astore 13
    //   627: aload_0
    //   628: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   631: iload_2
    //   632: i2l
    //   633: lload 5
    //   635: ladd
    //   636: ldc2_w 422
    //   639: lmul
    //   640: lload 9
    //   642: ldiv
    //   643: l2i
    //   644: invokeinterface 425 2 0
    //   649: aload 14
    //   651: astore 13
    //   653: aload_0
    //   654: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   657: lload 9
    //   659: lcmp
    //   660: iflt +57 -> 717
    //   663: aload 14
    //   665: astore 13
    //   667: ldc 130
    //   669: ldc 132
    //   671: ldc 177
    //   673: ldc_w 427
    //   676: new 138	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   683: iload_3
    //   684: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: ldc 136
    //   689: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: ldc 136
    //   697: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload 14
    //   702: astore 13
    //   704: aload_0
    //   705: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   708: aload_0
    //   709: getfield 258	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   712: invokeinterface 215 2 0
    //   717: aload 14
    //   719: astore 13
    //   721: aload_0
    //   722: iconst_3
    //   723: putfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   726: aload 14
    //   728: astore 13
    //   730: aload_0
    //   731: getfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   734: lstore 7
    //   736: lload 7
    //   738: lstore 5
    //   740: aload 14
    //   742: ifnull +16 -> 758
    //   745: aload 12
    //   747: astore 13
    //   749: aload 14
    //   751: invokevirtual 428	okhttp3/Response:close	()V
    //   754: lload 7
    //   756: lstore 5
    //   758: goto -619 -> 139
    //   761: aload 14
    //   763: astore 13
    //   765: aload_0
    //   766: getfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   769: iconst_1
    //   770: isub
    //   771: istore_1
    //   772: aload 14
    //   774: astore 13
    //   776: aload_0
    //   777: iload_1
    //   778: putfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   781: iload_1
    //   782: ifgt +261 -> 1043
    //   785: aload 14
    //   787: astore 13
    //   789: ldc 130
    //   791: ldc 132
    //   793: ldc_w 430
    //   796: ldc 136
    //   798: new 138	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   805: iload_3
    //   806: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: ldc 136
    //   811: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: ldc 136
    //   819: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload 14
    //   824: astore 13
    //   826: aload_0
    //   827: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   830: ifnull +805 -> 1635
    //   833: aload 14
    //   835: astore 13
    //   837: aload_0
    //   838: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   841: aload 14
    //   843: invokevirtual 433	okhttp3/Response:code	()I
    //   846: invokeinterface 161 2 0
    //   851: aload 14
    //   853: astore 13
    //   855: aload_0
    //   856: lload 5
    //   858: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   861: aload 14
    //   863: ifnull +12 -> 875
    //   866: aload 12
    //   868: astore 13
    //   870: aload 14
    //   872: invokevirtual 428	okhttp3/Response:close	()V
    //   875: aload 12
    //   877: ifnull -699 -> 178
    //   880: aload 12
    //   882: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   885: return
    //   886: astore 12
    //   888: aload 12
    //   890: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   893: return
    //   894: astore 14
    //   896: aload 12
    //   898: astore 13
    //   900: ldc 122
    //   902: iconst_1
    //   903: ldc_w 435
    //   906: aload 14
    //   908: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   911: goto -36 -> 875
    //   914: astore 14
    //   916: aload 12
    //   918: astore 13
    //   920: ldc 122
    //   922: iconst_2
    //   923: new 138	java/lang/StringBuilder
    //   926: dup
    //   927: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   930: ldc_w 355
    //   933: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 14
    //   938: invokevirtual 436	java/io/IOException:getMessage	()Ljava/lang/String;
    //   941: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: aload 14
    //   949: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   952: aload 12
    //   954: astore 13
    //   956: aload_0
    //   957: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   960: ifnull +18 -> 978
    //   963: aload 12
    //   965: astore 13
    //   967: aload_0
    //   968: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   971: bipush 6
    //   973: invokeinterface 161 2 0
    //   978: aload 12
    //   980: astore 13
    //   982: ldc 130
    //   984: ldc 132
    //   986: ldc_w 438
    //   989: ldc 136
    //   991: new 138	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   998: iload_3
    //   999: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1002: ldc 136
    //   1004: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: ldc 136
    //   1012: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1015: aload 12
    //   1017: astore 13
    //   1019: aload_0
    //   1020: lconst_0
    //   1021: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   1024: aload 12
    //   1026: ifnull -848 -> 178
    //   1029: aload 12
    //   1031: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   1034: return
    //   1035: astore 12
    //   1037: aload 12
    //   1039: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   1042: return
    //   1043: aload 14
    //   1045: astore 13
    //   1047: aload_0
    //   1048: lload 5
    //   1050: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   1053: aload 14
    //   1055: ifnull -916 -> 139
    //   1058: aload 12
    //   1060: astore 13
    //   1062: aload 14
    //   1064: invokevirtual 428	okhttp3/Response:close	()V
    //   1067: goto -928 -> 139
    //   1070: astore 14
    //   1072: aload 12
    //   1074: astore 13
    //   1076: ldc 122
    //   1078: iconst_1
    //   1079: ldc_w 435
    //   1082: aload 14
    //   1084: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1087: goto -948 -> 139
    //   1090: astore 14
    //   1092: aload 12
    //   1094: astore 13
    //   1096: ldc 122
    //   1098: iconst_2
    //   1099: new 138	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 355
    //   1109: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload 14
    //   1114: invokevirtual 439	java/security/InvalidParameterException:getMessage	()Ljava/lang/String;
    //   1117: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1123: aload 14
    //   1125: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1128: aload 12
    //   1130: astore 13
    //   1132: aload_0
    //   1133: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1136: ifnull +18 -> 1154
    //   1139: aload 12
    //   1141: astore 13
    //   1143: aload_0
    //   1144: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1147: bipush 6
    //   1149: invokeinterface 161 2 0
    //   1154: aload 12
    //   1156: astore 13
    //   1158: ldc 130
    //   1160: ldc 132
    //   1162: ldc_w 441
    //   1165: ldc 136
    //   1167: new 138	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1174: iload_3
    //   1175: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1178: ldc 136
    //   1180: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: ldc 136
    //   1188: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1191: aload 12
    //   1193: astore 13
    //   1195: aload_0
    //   1196: lconst_0
    //   1197: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   1200: aload 12
    //   1202: ifnull -1024 -> 178
    //   1205: aload 12
    //   1207: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   1210: return
    //   1211: astore 12
    //   1213: aload 12
    //   1215: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   1218: return
    //   1219: astore 14
    //   1221: aload 12
    //   1223: astore 13
    //   1225: ldc 122
    //   1227: iconst_1
    //   1228: ldc_w 435
    //   1231: aload 14
    //   1233: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1236: lload 7
    //   1238: lstore 5
    //   1240: goto -482 -> 758
    //   1243: astore 12
    //   1245: aload 13
    //   1247: ifnull +8 -> 1255
    //   1250: aload 13
    //   1252: invokevirtual 332	java/io/RandomAccessFile:close	()V
    //   1255: aload 12
    //   1257: athrow
    //   1258: astore 15
    //   1260: aconst_null
    //   1261: astore 14
    //   1263: aload 14
    //   1265: astore 13
    //   1267: ldc 122
    //   1269: iconst_2
    //   1270: new 138	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1277: ldc_w 355
    //   1280: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: aload 15
    //   1285: invokevirtual 436	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1288: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1294: aload 15
    //   1296: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1299: aload 14
    //   1301: astore 13
    //   1303: aload_0
    //   1304: getfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   1307: iconst_1
    //   1308: isub
    //   1309: istore_1
    //   1310: aload 14
    //   1312: astore 13
    //   1314: aload_0
    //   1315: iload_1
    //   1316: putfield 321	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Int	I
    //   1319: iload_1
    //   1320: ifgt +113 -> 1433
    //   1323: aload 14
    //   1325: astore 13
    //   1327: ldc 130
    //   1329: ldc 132
    //   1331: ldc_w 443
    //   1334: ldc 136
    //   1336: new 138	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1343: iload_3
    //   1344: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1347: ldc 136
    //   1349: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1355: ldc 136
    //   1357: invokestatic 154	com/tencent/mobileqq/troop/utils/TroopTechReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1360: aload 14
    //   1362: astore 13
    //   1364: aload_0
    //   1365: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1368: ifnull +112 -> 1480
    //   1371: aload 14
    //   1373: astore 13
    //   1375: aload_0
    //   1376: getfield 156	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback	Lcooperation/troop_homework/TroopHomeworkHelper$UploadCallback;
    //   1379: bipush 6
    //   1381: invokeinterface 161 2 0
    //   1386: aload 14
    //   1388: astore 13
    //   1390: aload_0
    //   1391: lload 5
    //   1393: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   1396: aload 14
    //   1398: ifnull -523 -> 875
    //   1401: aload 12
    //   1403: astore 13
    //   1405: aload 14
    //   1407: invokevirtual 428	okhttp3/Response:close	()V
    //   1410: goto -535 -> 875
    //   1413: astore 14
    //   1415: aload 12
    //   1417: astore 13
    //   1419: ldc 122
    //   1421: iconst_1
    //   1422: ldc_w 435
    //   1425: aload 14
    //   1427: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1430: goto -555 -> 875
    //   1433: aload 14
    //   1435: astore 13
    //   1437: aload_0
    //   1438: lload 5
    //   1440: putfield 33	cooperation/troop_homework/TroopHomeworkHelper$UploadFileTask:jdField_a_of_type_Long	J
    //   1443: aload 14
    //   1445: ifnull -1306 -> 139
    //   1448: aload 12
    //   1450: astore 13
    //   1452: aload 14
    //   1454: invokevirtual 428	okhttp3/Response:close	()V
    //   1457: goto -1318 -> 139
    //   1460: astore 14
    //   1462: aload 12
    //   1464: astore 13
    //   1466: ldc 122
    //   1468: iconst_1
    //   1469: ldc_w 435
    //   1472: aload 14
    //   1474: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1477: goto -1338 -> 139
    //   1480: aload 14
    //   1482: ifnull +150 -> 1632
    //   1485: aload 12
    //   1487: astore 13
    //   1489: aload 14
    //   1491: invokevirtual 428	okhttp3/Response:close	()V
    //   1494: goto -736 -> 758
    //   1497: astore 14
    //   1499: aload 12
    //   1501: astore 13
    //   1503: ldc 122
    //   1505: iconst_1
    //   1506: ldc_w 435
    //   1509: aload 14
    //   1511: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1514: goto -756 -> 758
    //   1517: astore 14
    //   1519: aconst_null
    //   1520: astore 15
    //   1522: aload 15
    //   1524: ifnull +12 -> 1536
    //   1527: aload 12
    //   1529: astore 13
    //   1531: aload 15
    //   1533: invokevirtual 428	okhttp3/Response:close	()V
    //   1536: aload 12
    //   1538: astore 13
    //   1540: aload 14
    //   1542: athrow
    //   1543: astore 15
    //   1545: aload 12
    //   1547: astore 13
    //   1549: ldc 122
    //   1551: iconst_1
    //   1552: ldc_w 435
    //   1555: aload 15
    //   1557: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1560: goto -24 -> 1536
    //   1563: astore 13
    //   1565: aload 13
    //   1567: invokevirtual 335	java/io/IOException:printStackTrace	()V
    //   1570: goto -315 -> 1255
    //   1573: astore 12
    //   1575: aconst_null
    //   1576: astore 13
    //   1578: goto -333 -> 1245
    //   1581: astore 14
    //   1583: aload 12
    //   1585: astore 13
    //   1587: aload 14
    //   1589: astore 12
    //   1591: goto -346 -> 1245
    //   1594: astore 14
    //   1596: aconst_null
    //   1597: astore 12
    //   1599: goto -507 -> 1092
    //   1602: astore 14
    //   1604: aconst_null
    //   1605: astore 12
    //   1607: goto -691 -> 916
    //   1610: astore 13
    //   1612: aconst_null
    //   1613: astore 12
    //   1615: goto -1277 -> 338
    //   1618: astore 14
    //   1620: aload 13
    //   1622: astore 15
    //   1624: goto -102 -> 1522
    //   1627: astore 15
    //   1629: goto -366 -> 1263
    //   1632: goto -874 -> 758
    //   1635: lload 5
    //   1637: lstore 7
    //   1639: goto -903 -> 736
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1642	0	this	UploadFileTask
    //   246	1074	1	i	int
    //   283	349	2	j	int
    //   57	1287	3	k	int
    //   280	39	4	m	int
    //   137	1499	5	l1	long
    //   232	1406	7	l2	long
    //   127	531	9	l3	long
    //   161	3	11	bool	boolean
    //   116	58	12	localRandomAccessFile	java.io.RandomAccessFile
    //   179	253	12	localIOException1	java.io.IOException
    //   437	444	12	localIOException2	java.io.IOException
    //   886	144	12	localIOException3	java.io.IOException
    //   1035	171	12	localIOException4	java.io.IOException
    //   1211	11	12	localIOException5	java.io.IOException
    //   1243	303	12	localObject1	Object
    //   1573	11	12	localObject2	Object
    //   1589	25	12	localObject3	Object
    //   120	206	13	localObject4	Object
    //   336	30	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   454	1094	13	localObject5	Object
    //   1563	3	13	localIOException6	java.io.IOException
    //   1576	10	13	localObject6	Object
    //   1610	11	13	localFileNotFoundException2	java.io.FileNotFoundException
    //   243	628	14	localObject7	Object
    //   894	13	14	localException1	java.lang.Exception
    //   914	149	14	localIOException7	java.io.IOException
    //   1070	13	14	localException2	java.lang.Exception
    //   1090	34	14	localInvalidParameterException1	InvalidParameterException
    //   1219	13	14	localException3	java.lang.Exception
    //   1261	145	14	localObject8	Object
    //   1413	40	14	localException4	java.lang.Exception
    //   1460	30	14	localException5	java.lang.Exception
    //   1497	13	14	localException6	java.lang.Exception
    //   1517	24	14	localObject9	Object
    //   1581	7	14	localObject10	Object
    //   1594	1	14	localInvalidParameterException2	InvalidParameterException
    //   1602	1	14	localIOException8	java.io.IOException
    //   1618	1	14	localObject11	Object
    //   267	190	15	arrayOfByte	byte[]
    //   1258	37	15	localIOException9	java.io.IOException
    //   1520	12	15	localObject12	Object
    //   1543	13	15	localException7	java.lang.Exception
    //   1622	1	15	localFileNotFoundException3	java.io.FileNotFoundException
    //   1627	1	15	localIOException10	java.io.IOException
    //   95	472	16	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   173	178	179	java/io/IOException
    //   122	129	336	java/io/FileNotFoundException
    //   133	139	336	java/io/FileNotFoundException
    //   143	153	336	java/io/FileNotFoundException
    //   157	163	336	java/io/FileNotFoundException
    //   191	205	336	java/io/FileNotFoundException
    //   209	221	336	java/io/FileNotFoundException
    //   225	234	336	java/io/FileNotFoundException
    //   238	245	336	java/io/FileNotFoundException
    //   251	258	336	java/io/FileNotFoundException
    //   262	269	336	java/io/FileNotFoundException
    //   273	282	336	java/io/FileNotFoundException
    //   304	315	336	java/io/FileNotFoundException
    //   327	333	336	java/io/FileNotFoundException
    //   456	466	336	java/io/FileNotFoundException
    //   474	489	336	java/io/FileNotFoundException
    //   493	584	336	java/io/FileNotFoundException
    //   749	754	336	java/io/FileNotFoundException
    //   870	875	336	java/io/FileNotFoundException
    //   900	911	336	java/io/FileNotFoundException
    //   1062	1067	336	java/io/FileNotFoundException
    //   1076	1087	336	java/io/FileNotFoundException
    //   1225	1236	336	java/io/FileNotFoundException
    //   1405	1410	336	java/io/FileNotFoundException
    //   1419	1430	336	java/io/FileNotFoundException
    //   1452	1457	336	java/io/FileNotFoundException
    //   1466	1477	336	java/io/FileNotFoundException
    //   1489	1494	336	java/io/FileNotFoundException
    //   1503	1514	336	java/io/FileNotFoundException
    //   1531	1536	336	java/io/FileNotFoundException
    //   1540	1543	336	java/io/FileNotFoundException
    //   1549	1560	336	java/io/FileNotFoundException
    //   431	436	437	java/io/IOException
    //   880	885	886	java/io/IOException
    //   870	875	894	java/lang/Exception
    //   122	129	914	java/io/IOException
    //   133	139	914	java/io/IOException
    //   143	153	914	java/io/IOException
    //   157	163	914	java/io/IOException
    //   191	205	914	java/io/IOException
    //   209	221	914	java/io/IOException
    //   225	234	914	java/io/IOException
    //   238	245	914	java/io/IOException
    //   251	258	914	java/io/IOException
    //   262	269	914	java/io/IOException
    //   273	282	914	java/io/IOException
    //   304	315	914	java/io/IOException
    //   327	333	914	java/io/IOException
    //   456	466	914	java/io/IOException
    //   474	489	914	java/io/IOException
    //   493	584	914	java/io/IOException
    //   749	754	914	java/io/IOException
    //   870	875	914	java/io/IOException
    //   900	911	914	java/io/IOException
    //   1062	1067	914	java/io/IOException
    //   1076	1087	914	java/io/IOException
    //   1225	1236	914	java/io/IOException
    //   1405	1410	914	java/io/IOException
    //   1419	1430	914	java/io/IOException
    //   1452	1457	914	java/io/IOException
    //   1466	1477	914	java/io/IOException
    //   1489	1494	914	java/io/IOException
    //   1503	1514	914	java/io/IOException
    //   1531	1536	914	java/io/IOException
    //   1540	1543	914	java/io/IOException
    //   1549	1560	914	java/io/IOException
    //   1029	1034	1035	java/io/IOException
    //   1062	1067	1070	java/lang/Exception
    //   122	129	1090	java/security/InvalidParameterException
    //   133	139	1090	java/security/InvalidParameterException
    //   143	153	1090	java/security/InvalidParameterException
    //   157	163	1090	java/security/InvalidParameterException
    //   191	205	1090	java/security/InvalidParameterException
    //   209	221	1090	java/security/InvalidParameterException
    //   225	234	1090	java/security/InvalidParameterException
    //   238	245	1090	java/security/InvalidParameterException
    //   251	258	1090	java/security/InvalidParameterException
    //   262	269	1090	java/security/InvalidParameterException
    //   273	282	1090	java/security/InvalidParameterException
    //   304	315	1090	java/security/InvalidParameterException
    //   327	333	1090	java/security/InvalidParameterException
    //   456	466	1090	java/security/InvalidParameterException
    //   474	489	1090	java/security/InvalidParameterException
    //   493	584	1090	java/security/InvalidParameterException
    //   749	754	1090	java/security/InvalidParameterException
    //   870	875	1090	java/security/InvalidParameterException
    //   900	911	1090	java/security/InvalidParameterException
    //   1062	1067	1090	java/security/InvalidParameterException
    //   1076	1087	1090	java/security/InvalidParameterException
    //   1225	1236	1090	java/security/InvalidParameterException
    //   1405	1410	1090	java/security/InvalidParameterException
    //   1419	1430	1090	java/security/InvalidParameterException
    //   1452	1457	1090	java/security/InvalidParameterException
    //   1466	1477	1090	java/security/InvalidParameterException
    //   1489	1494	1090	java/security/InvalidParameterException
    //   1503	1514	1090	java/security/InvalidParameterException
    //   1531	1536	1090	java/security/InvalidParameterException
    //   1540	1543	1090	java/security/InvalidParameterException
    //   1549	1560	1090	java/security/InvalidParameterException
    //   1205	1210	1211	java/io/IOException
    //   749	754	1219	java/lang/Exception
    //   122	129	1243	finally
    //   133	139	1243	finally
    //   143	153	1243	finally
    //   157	163	1243	finally
    //   191	205	1243	finally
    //   209	221	1243	finally
    //   225	234	1243	finally
    //   238	245	1243	finally
    //   251	258	1243	finally
    //   262	269	1243	finally
    //   273	282	1243	finally
    //   304	315	1243	finally
    //   327	333	1243	finally
    //   456	466	1243	finally
    //   474	489	1243	finally
    //   493	584	1243	finally
    //   749	754	1243	finally
    //   870	875	1243	finally
    //   900	911	1243	finally
    //   920	952	1243	finally
    //   956	963	1243	finally
    //   967	978	1243	finally
    //   982	1015	1243	finally
    //   1019	1024	1243	finally
    //   1062	1067	1243	finally
    //   1076	1087	1243	finally
    //   1096	1128	1243	finally
    //   1132	1139	1243	finally
    //   1143	1154	1243	finally
    //   1158	1191	1243	finally
    //   1195	1200	1243	finally
    //   1225	1236	1243	finally
    //   1405	1410	1243	finally
    //   1419	1430	1243	finally
    //   1452	1457	1243	finally
    //   1466	1477	1243	finally
    //   1489	1494	1243	finally
    //   1503	1514	1243	finally
    //   1531	1536	1243	finally
    //   1540	1543	1243	finally
    //   1549	1560	1243	finally
    //   584	600	1258	java/io/IOException
    //   1405	1410	1413	java/lang/Exception
    //   1452	1457	1460	java/lang/Exception
    //   1489	1494	1497	java/lang/Exception
    //   584	600	1517	finally
    //   1531	1536	1543	java/lang/Exception
    //   1250	1255	1563	java/io/IOException
    //   102	118	1573	finally
    //   338	388	1581	finally
    //   388	426	1581	finally
    //   102	118	1594	java/security/InvalidParameterException
    //   102	118	1602	java/io/IOException
    //   102	118	1610	java/io/FileNotFoundException
    //   604	612	1618	finally
    //   616	623	1618	finally
    //   627	649	1618	finally
    //   653	663	1618	finally
    //   667	700	1618	finally
    //   704	717	1618	finally
    //   721	726	1618	finally
    //   730	736	1618	finally
    //   765	772	1618	finally
    //   776	781	1618	finally
    //   789	822	1618	finally
    //   826	833	1618	finally
    //   837	851	1618	finally
    //   855	861	1618	finally
    //   1047	1053	1618	finally
    //   1267	1299	1618	finally
    //   1303	1310	1618	finally
    //   1314	1319	1618	finally
    //   1327	1360	1618	finally
    //   1364	1371	1618	finally
    //   1375	1386	1618	finally
    //   1390	1396	1618	finally
    //   1437	1443	1618	finally
    //   604	612	1627	java/io/IOException
    //   616	623	1627	java/io/IOException
    //   627	649	1627	java/io/IOException
    //   653	663	1627	java/io/IOException
    //   667	700	1627	java/io/IOException
    //   704	717	1627	java/io/IOException
    //   721	726	1627	java/io/IOException
    //   730	736	1627	java/io/IOException
    //   765	772	1627	java/io/IOException
    //   776	781	1627	java/io/IOException
    //   789	822	1627	java/io/IOException
    //   826	833	1627	java/io/IOException
    //   837	851	1627	java/io/IOException
    //   855	861	1627	java/io/IOException
    //   1047	1053	1627	java/io/IOException
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.1(this), 8, null, true);
      return;
    }
    File localFile = new File(this.c);
    if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null))
    {
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(-1);
      int i = NetworkUtil.b(BaseApplicationImpl.getContext());
      TroopTechReportUtils.a("grp_hw", "upload_video", "-13", "", i + "", "");
      return;
    }
    if (localFile.length() > 4096L)
    {
      e();
      return;
    }
    d();
  }
  
  public void a(TroopHomeworkHelper.UploadCallback paramUploadCallback)
  {
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback = paramUploadCallback;
  }
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.4(this), 8, null, true);
    }
    do
    {
      return;
      File localFile = new File(this.c);
      if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback != null))
      {
        this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.b(-1);
        int i = NetworkUtil.b(BaseApplicationImpl.getContext());
        TroopTechReportUtils.a("grp_hw", "upload_video", "-13", "", i + "", "");
        return;
      }
      if (localFile.length() <= 4096L) {
        break label172;
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label167;
      }
      if (this.jdField_a_of_type_Long < localFile.length()) {
        break;
      }
    } while (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback == null);
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback.a(this.jdField_a_of_type_JavaLangString);
    return;
    f();
    return;
    label167:
    e();
    return;
    label172:
    d();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask
 * JD-Core Version:    0.7.0.1
 */