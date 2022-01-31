package com.tencent.mobileqq.troop.activity;

import aiym;
import aiyn;
import aiyo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.VideoInfo;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishUtils
{
  public static Editable.Factory a;
  private static TroopBarPublishUtils.UserInvokeAction a;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new aiym();
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return 1;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          j = Integer.parseInt(arrayOfString1[i]);
          k = Integer.parseInt(arrayOfString2[i]);
          if (j < k) {
            return -1;
          }
        }
        else
        {
          if (arrayOfString1.length > i) {
            return 1;
          }
          j = arrayOfString2.length;
          if (j <= i) {
            break;
          }
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      if (j > k) {
        return 1;
      }
      i += 1;
    }
  }
  
  protected static Uri a(BaseActivity paramBaseActivity)
  {
    return TroopBarUtils.a(paramBaseActivity, AppConstants.aP, 1001);
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    DeviceLib.a(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
    paramEditText.setBackgroundResource(2130837571);
    paramEmoticonCallback = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramContext, 196.0F));
    int i = (int)DisplayUtils.a(paramContext, 20.0F);
    paramEditText.setPadding(0, i, 0, i);
    paramViewGroup.addView(paramEditText, paramEmoticonCallback);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList paramArrayList, AudioInfo paramAudioInfo)
  {
    return a(paramString, paramArrayList, paramAudioInfo, null);
  }
  
  public static String a(String paramString, ArrayList paramArrayList, AudioInfo paramAudioInfo, VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      localJSONObject.put("content", str);
      int i;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int j = 0;
        i = 0;
        while (j < paramString.size())
        {
          str = (String)paramString.get(j);
          TroopBarPublishActivity.Pic_list localPic_list = (TroopBarPublishActivity.Pic_list)TroopBarUtils.a.get(str);
          if (localPic_list == null) {
            break label275;
          }
          paramArrayList.put(localPic_list.getJsonObject());
          if (!Utils.a(str)) {
            break label275;
          }
          i += 1;
          j += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        localJSONObject.put("gif_num", i);
        label154:
        if (paramAudioInfo != null) {
          paramString = new JSONArray();
        }
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
          if (paramVideoInfo != null) {
            paramString = new JSONArray();
          }
        }
        catch (JSONException paramString)
        {
          try
          {
            do
            {
              paramString.put(paramVideoInfo.a());
              localJSONObject.put("ugc_video_list", paramString);
              return localJSONObject.toString();
              paramString = paramString;
            } while (!QLog.isColorLevel());
            QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
          }
          catch (JSONException paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        break label154;
      }
    }
    catch (JSONException paramString)
    {
      label275:
      for (;;) {}
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 3: 
    case 4: 
      a(paramActivity);
      String str = paramBundle.getString("bid", "0");
      if ("interestcircle".endsWith(paramBundle.getString("from")))
      {
        paramActivity = "pub_page_new";
        if (paramInt != 3) {
          break label130;
        }
        paramBundle = "Clk_install";
        if (paramInt != 3) {
          break label141;
        }
        if (!"0".endsWith(str)) {
          break label136;
        }
        paramInt = 2;
      }
      for (;;)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", paramActivity, paramBundle, paramInt, 0, str, "", "", "");
        return;
        if ("0".endsWith(str)) {}
        for (paramActivity = "pub_page_new";; paramActivity = "reply_page_new") {
          break;
        }
        paramBundle = "Clk_update";
        break label71;
        paramInt = 1;
        continue;
        paramInt = 0;
      }
    case 1: 
      label71:
      a(paramActivity, paramBundle);
      label130:
      label136:
      label141:
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  protected static void a(Activity paramActivity)
  {
    if (TroopFileUtils.a(paramActivity) != 2)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      localQQCustomDialog.setTitle("你的网络连接不是WIFI，是否继续下载");
      paramActivity = new aiyo(paramActivity);
      localQQCustomDialog.setNegativeButton("取消", paramActivity);
      localQQCustomDialog.setPositiveButton("土豪继续下载", paramActivity);
      localQQCustomDialog.show();
      return;
    }
    b(paramActivity);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://buluo.qq.com/mobile/video_theme.html?_wv=1031&video_theme_id=" + paramInt2);
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = PackageUtil.a(paramActivity, "com.tencent.tribe");
    jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$UserInvokeAction = new TroopBarPublishUtils.UserInvokeAction(paramActivity, paramInt1, paramInt2, paramBundle);
    if (!"0".equals(str))
    {
      if (("interestcircle".endsWith(paramBundle.getString("from"))) && (a(str, "1.5") < 0))
      {
        b(paramActivity, 4, paramInt2, paramBundle);
        return;
      }
      b(paramActivity, paramInt1, paramInt2, paramBundle);
      return;
    }
    b(paramActivity, 3, paramInt2, paramBundle);
  }
  
  protected static void a(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      String str1 = paramBundle.getString("bid", "");
      String str2 = paramBundle.getString("uin");
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://gbar_home/?bid=%s&from=%s&post=true&uin=%s&title=%s&msg=%s&clicktype=%s", new Object[] { str1, paramBundle.getString("from", "qqbuluo"), str2, URLEncoder.encode(paramBundle.getString("title"), "UTF-8"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, "打开应用失败，请重试", 0).b(50);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ArrayList paramArrayList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.addAll(paramArrayList);
    }
    paramArrayList = new Intent();
    paramArrayList.setClass(paramBaseActivity, PhotoListActivity.class);
    paramArrayList.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramBaseActivity.getClass().getName());
    paramArrayList.putExtra("from_tribe_class_name", paramBaseActivity.getClass().getSimpleName());
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramArrayList.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramArrayList.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramArrayList.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramArrayList.getExtras().remove("forward_type");
    paramArrayList.putExtra("album_enter_directly", true);
    paramArrayList.putExtra("ALBUM_ID", AlbumUtil.b);
    paramArrayList.putExtra("ALBUM_NAME", AlbumUtil.c);
    paramArrayList.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramArrayList.putExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", true);
    paramBaseActivity.startActivityForResult(paramArrayList, 1001);
    AlbumUtil.a(paramBaseActivity, false, true);
  }
  
  public static void b(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      Object localObject2 = new JSONObject(HttpUtil.a(paramActivity, "https://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131430354);
      localObject2 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      String str1 = paramActivity.getString(2131430355);
      String str2 = paramActivity.getString(2131430356);
      Bundle localBundle = new Bundle();
      localBundle.putString(DownloadConstants.a, (String)localObject1);
      localBundle.putString(DownloadConstants.i, (String)localObject2);
      localBundle.putInt(DownloadConstants.j, 2);
      localBundle.putString(DownloadConstants.k, str2);
      localBundle.putString(DownloadConstants.e, str1);
      localBundle.putBoolean(DownloadConstants.q, false);
      localBundle.putBoolean(DownloadConstants.w, false);
      localBundle.putString(DownloadConstants.l, "_" + (String)localObject1);
      DownloadApi.a(paramActivity, localBundle, 0, null, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "====tribe app download====" + localException.toString());
      }
      QQToast.a(paramActivity, "下载失败，请重试", 0).b(50);
    }
  }
  
  protected static void b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 != 3) && (paramInt1 != 4) && (jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishUtils$UserInvokeAction.a().booleanValue()))
    {
      a(paramInt1, paramActivity, paramBundle);
      return;
    }
    String str2;
    String str1;
    label92:
    String str4;
    Object localObject;
    String str3;
    switch (paramInt2)
    {
    default: 
      str2 = "文字";
      switch (paramInt1)
      {
      default: 
        str1 = "";
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          str4 = paramBundle.getString("bid", "0");
          if (!"interestcircle".endsWith(paramBundle.getString("from"))) {
            break label303;
          }
          localObject = "pub_page_new";
          if (paramInt1 != 3) {
            break label327;
          }
          str3 = "exp_install";
          label140:
          if (paramInt1 != 4) {
            break label335;
          }
          paramInt2 = 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", (String)localObject, str3, paramInt2, 0, str4, "", "", "");
      localObject = DialogUtil.a(paramActivity, 230);
      ((QQCustomDialog)localObject).setTitle(paramActivity.getString(2131430353, new Object[] { str1, str2 }));
      paramActivity = new aiyn(paramBundle, paramInt1, paramInt1, paramActivity);
      ((QQCustomDialog)localObject).setNegativeButton("取消", paramActivity);
      ((QQCustomDialog)localObject).setPositiveButton("立即" + str1, paramActivity);
      ((QQCustomDialog)localObject).show();
      return;
      str2 = "视频";
      break;
      str2 = "音乐";
      break;
      str1 = "安装";
      break label92;
      str1 = "更新";
      break label92;
      str1 = "使用";
      break label92;
      label303:
      if ("0".endsWith(str4)) {}
      for (localObject = "pub_page_new";; localObject = "reply_page_new") {
        break;
      }
      label327:
      str3 = "exp_update";
      break label140;
      label335:
      if ("0".endsWith(str4)) {
        paramInt2 = 2;
      } else {
        paramInt2 = 1;
      }
    }
  }
  
  protected static void b(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://post_detail/?pid=%s&bid=%s&bar_type=0&from=qqbuluo&post=true&uin=%s&floor=%s&msg=%s&clicktype=%s", new Object[] { paramBundle.getString("pid"), paramBundle.getString("bid", ""), paramBundle.getString("uin"), paramBundle.getString("floor"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "=====invoke proto====" + paramBundle.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QQToast.a(paramActivity, "打开应用失败，请重试", 0).b(50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils
 * JD-Core Version:    0.7.0.1
 */