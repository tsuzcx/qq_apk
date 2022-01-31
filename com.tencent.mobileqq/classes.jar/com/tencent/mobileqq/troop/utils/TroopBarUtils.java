package com.tencent.mobileqq.troop.utils;

import ajvu;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUtils
{
  protected static SimpleDateFormat a;
  public static final HashMap a;
  public static Hashtable a;
  public static final HashMap b = new HashMap();
  public static final HashMap c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString, char paramChar)
  {
    int j = 0;
    if (paramString != null) {
      for (int i = 0;; i = k)
      {
        k = i;
        if (j >= paramString.length()) {
          break;
        }
        k = i;
        if (paramString.charAt(j) == paramChar) {
          k = i + 1;
        }
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public static final Uri a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    do
    {
      return null;
      paramString = new File(paramString);
      if (paramString.exists()) {}
      for (boolean bool = true; (bool) && (paramString.canWrite()); bool = paramString.mkdirs())
      {
        paramString = Uri.fromFile(new File(AppConstants.aQ + System.currentTimeMillis() + ".jpg"));
        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        localIntent.putExtra("output", paramString);
        localIntent.putExtra("android.intent.extra.videoQuality", 100);
        paramBaseActivity.startActivityForResult(localIntent, paramInt);
        return paramString;
      }
    } while ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()));
    QQToast.a(paramBaseActivity, 2131430355, 1).b(paramBaseActivity.getTitleBarHeight());
    return null;
  }
  
  public static final String a(EditText paramEditText)
  {
    int j = 0;
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null)
      {
        int i = localQQTextBuilder.length();
        Object localObject1 = new char[i];
        localQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
        paramEditText = new StringBuffer();
        paramEditText.append((char[])localObject1);
        localObject1 = (QQText.EmoticonSpan[])localQQTextBuilder.getSpans(0, i, QQText.EmoticonSpan.class);
        if (((localQQTextBuilder instanceof Spanned)) && (Build.VERSION.SDK_INT >= 24)) {
          Arrays.sort((Object[])localObject1, new ajvu(localQQTextBuilder));
        }
        int k = 0;
        if (j < localObject1.length)
        {
          Object localObject2 = localObject1[j];
          int m;
          if (((QQText.EmoticonSpan)localObject2).c == 1)
          {
            i = localQQTextBuilder.getSpanStart(localObject2);
            m = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = com.tencent.mobileqq.text.EmotcationConstants.a[(localObject2.a & 0x7FFFFFFF)];
            paramEditText.replace(i + k, m + k, (String)localObject2);
            i = k + (((String)localObject2).length() - (m - i));
          }
          for (;;)
          {
            j += 1;
            k = i;
            break;
            i = k;
            if (((QQText.EmoticonSpan)localObject2).c == 2)
            {
              i = localQQTextBuilder.getSpanStart(localObject2);
              m = localQQTextBuilder.getSpanEnd(localObject2);
              localObject2 = ((QQText.EmoticonSpan)localObject2).a();
              paramEditText.replace(i + k, m + k, (String)localObject2);
              i = k + (((String)localObject2).length() - (m - i));
            }
          }
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static final JSONObject a(String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (FileUtil.a(paramString2))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "http://www.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("file", paramString2);
      if (paramMap != null) {
        break label229;
      }
    }
    label229:
    for (paramContext = new HashMap();; paramContext = paramMap)
    {
      paramContext.put("file", paramString2);
      long l = System.currentTimeMillis();
      paramString1 = HttpUtil.a(paramString1, paramString3, paramString4, paramContext, localHashMap2, localHashMap1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "singleUploadImage t = " + (System.currentTimeMillis() - l) + ", path = " + paramString2 + ", size = " + FileUtil.a(paramString2));
      }
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString1.optInt("retcode", -1) == 0) || (paramString1.optInt("ret", -1) == 0))
        {
          paramString1 = paramString1.getJSONObject("result");
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramString1.getMessage());
        }
      }
      return null;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    int i = NetworkUtil.b(paramContext);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", paramString1, paramString2, 0, paramInt, "" + i, paramString3, paramString4, paramString5);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString4)
  {
    if ((paramBundle1 != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramBundle1.putString("version", "7.6.8");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      paramBundle1.putString("Cookie", "uin=" + paramString1 + ";skey=" + paramString2);
      paramBundle1.putString("Referer", "https://buluo.qq.com");
      paramString1 = new HashMap();
      paramString1.put("BUNDLE", paramBundle1);
      paramString1.put("CONTEXT", paramContext.getApplicationContext());
      new HttpWebCgiAsyncTask(paramString3, paramString4, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { paramString1 });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopBar", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "GET");
  }
  
  protected static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString1, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString2)
  {
    AppRuntime localAppRuntime = paramBaseActivity.getAppRuntime();
    String str = localAppRuntime.getAccount();
    a(paramBaseActivity, str, ((TicketManager)localAppRuntime.getManager(2)).getSkey(str), paramBundle1, paramString1, paramInt, paramBundle2, paramCallback, paramString2);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a("Grp_tribe", paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString5)) && (paramString1.equals("Grp_tribe")) && (paramString5.equals("sbarindex"))) {
      return;
    }
    ReportController.b(null, "P_CliOper", paramString1, "", paramString2, paramString3, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static void b(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "POST");
  }
  
  public static final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "Grp_tribe", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils
 * JD-Core Version:    0.7.0.1
 */