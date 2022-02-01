package com.tencent.mobileqq.troop.utils;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.Pic_list;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
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
  protected static final String a;
  protected static SimpleDateFormat a;
  public static final HashMap<String, TroopBarUtils.PublishDataCacheEntity> a;
  public static Hashtable<String, TroopBarPublishUtils.Pic_list> a;
  protected static final String b;
  public static final HashMap<String, TroopBarUtils.PublishDataCacheEntity> b;
  protected static final String c;
  public static final HashMap<String, String> c;
  protected static final String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715009);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131715019);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131715000);
    d = HardCodeUtil.a(2131714996);
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static final Uri a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    paramString = new File(paramString);
    boolean bool;
    if (paramString.exists()) {
      bool = true;
    } else {
      bool = paramString.mkdirs();
    }
    if ((bool) && (paramString.canWrite())) {
      try
      {
        paramString = new Intent();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(".jpg");
        localObject = FileProvider7Helper.setSystemCapture(paramBaseActivity, new File(((StringBuilder)localObject).toString()), paramString);
        paramString.addFlags(3);
        paramBaseActivity.startActivityForResult(paramString, paramInt);
        return localObject;
      }
      catch (Exception paramBaseActivity)
      {
        paramBaseActivity.printStackTrace();
        return null;
      }
    }
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      QQToast.a(paramBaseActivity, 2131696274, 1).b(paramBaseActivity.getTitleBarHeight());
    }
    return null;
  }
  
  public static final String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null)
      {
        int j = localQQTextBuilder.length();
        Object localObject1 = new char[j];
        int i = 0;
        localQQTextBuilder.getChars(0, j, (char[])localObject1, 0);
        paramEditText = new StringBuffer();
        paramEditText.append((char[])localObject1);
        localObject1 = (EmoticonSpan[])localQQTextBuilder.getSpans(0, j, EmoticonSpan.class);
        if (((localQQTextBuilder instanceof Spanned)) && (Build.VERSION.SDK_INT >= 24)) {
          Arrays.sort((Object[])localObject1, new TroopBarUtils.1(localQQTextBuilder));
        }
        int k;
        for (j = 0; i < localObject1.length; j = k)
        {
          Object localObject2 = localObject1[i];
          int m;
          int n;
          if (((EmoticonSpan)localObject2).emojiType == 1)
          {
            m = localQQTextBuilder.getSpanStart(localObject2);
            n = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject2).index & 0x7FFFFFFF);
            paramEditText.replace(m + j, n + j, (String)localObject2);
          }
          for (k = ((String)localObject2).length();; k = ((String)localObject2).length())
          {
            k = j + (k - (n - m));
            break;
            k = j;
            if (((EmoticonSpan)localObject2).emojiType != 2) {
              break;
            }
            m = localQQTextBuilder.getSpanStart(localObject2);
            n = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = ((EmoticonSpan)localObject2).getDescription();
            paramEditText.replace(m + j, n + j, (String)localObject2);
          }
          i += 1;
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i;
    try
    {
      boolean bool = a(paramString);
      String str = paramString;
      if (!bool) {
        break label198;
      }
      i = 0;
      for (;;)
      {
        str = paramString;
        try
        {
          if (i >= EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
            break label198;
          }
          str = paramString;
          if (paramString.indexOf(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]) != -1)
          {
            str = EmotcationConstants.SYS_EMOTICON_SYMBOL[i];
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("\024");
            localStringBuilder.append((char)i);
            str = paramString.replace(str, localStringBuilder.toString());
          }
          i += 1;
          paramString = str;
        }
        catch (Exception localException1) {}
      }
      localException2.printStackTrace();
    }
    catch (Exception localException2) {}
    Object localObject = paramString;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertFaceStringTextToIndex:");
      int j = paramString.length();
      i = 200;
      if (j <= 200) {
        i = paramString.length() - 1;
      }
      ((StringBuilder)localObject).append(paramString.substring(0, i));
      QLog.e("TroopBar", 2, ((StringBuilder)localObject).toString());
      localObject = paramString;
    }
    label198:
    return localObject;
  }
  
  public static final JSONObject a(String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    if (FileUtil.b(paramString2))
    {
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "https://www.qq.com");
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("file", paramString2);
      paramContext = paramMap;
      if (paramMap == null) {
        paramContext = new HashMap();
      }
      paramContext.put("file", paramString2);
      long l = System.currentTimeMillis();
      paramString1 = HttpUtil.uploadImage(paramString1, paramString3, paramString4, paramContext, localHashMap2, localHashMap1);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("singleUploadImage t = ");
        paramContext.append(System.currentTimeMillis() - l);
        paramContext.append(", path = ");
        paramContext.append(paramString2);
        paramContext.append(", size = ");
        paramContext.append(FileUtil.a(paramString2));
        QLog.d("TroopBar", 2, paramContext.toString());
        paramContext = new StringBuilder();
        paramContext.append("urlResult: ");
        paramContext.append(paramString1);
        QLog.d("TroopBar", 2, paramContext.toString());
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
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString4)
  {
    if ((paramBundle1 != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramBundle1.putString("version", "8.7.0");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(";skey=");
      localStringBuilder.append(paramString2);
      paramBundle1.putString("Cookie", localStringBuilder.toString());
      paramBundle1.putString("Referer", "https://buluo.qq.com");
      paramString1 = new HashMap();
      paramString1.put("BUNDLE", paramBundle1);
      paramString1.put("CONTEXT", paramContext.getApplicationContext());
      new HttpWebCgiAsyncTask(paramString3, paramString4, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { paramString1 });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopBar", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
    }
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
    ReportController.b(null, "P_CliOper", paramString1, "", paramString2, paramString3, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (-1 != paramString.indexOf('/'));
  }
  
  public static final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "Grp_tribe", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils
 * JD-Core Version:    0.7.0.1
 */