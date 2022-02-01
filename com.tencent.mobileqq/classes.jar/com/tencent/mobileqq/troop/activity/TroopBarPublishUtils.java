package com.tencent.mobileqq.troop.activity;

import abem;
import amtj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import ayfc;
import bcef;
import bdlg;
import bdsa;
import bdsb;
import bdsc;
import bdsd;
import bdse;
import bdsf;
import bdsg;
import bdsh;
import bfaj;
import bfby;
import bfur;
import bfvh;
import bfwv;
import bibs;
import bibw;
import bkwm;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
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
  private static bdsh a;
  public static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new bdsd();
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
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap.getWidth() < 640) || (paramBitmap.getHeight() < 300)) {
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = false;
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130843261, (BitmapFactory.Options)localObject);
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = amtj.a(2131714267);
      if (jdField_a_of_type_JavaLangString.length() > 12) {
        jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaLangString.substring(0, 11) + "...";
      }
      int m = paramBitmap.getWidth();
      i = (int)(36.0D / 750 * m);
      j = (int)(32.0D / 750 * m);
      k = (int)(8.0D / 750 * m);
      m = (int)(24.0D / 750 * m);
      localObject = new Paint();
      ((Paint)localObject).setDither(true);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setFakeBoldText(true);
      ((Paint)localObject).setTextSize(m);
      if (!paramBitmap.isMutable()) {
        break label385;
      }
    }
    for (;;)
    {
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.save();
      localCanvas.drawBitmap(paramContext, new Rect(0, 0, paramContext.getWidth(), paramContext.getHeight()), new Rect(i, localCanvas.getHeight() - i - j, i + j, localCanvas.getHeight() - i), (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localCanvas.translate(i + j + k, localCanvas.getHeight() - i - (i - j));
      localCanvas.drawText(jdField_a_of_type_JavaLangString, 0.0F, 0.0F, (Paint)localObject);
      localCanvas.restore();
      return paramBitmap;
      if (jdField_a_of_type_JavaLangString.endsWith(amtj.a(2131714262))) {
        break;
      }
      jdField_a_of_type_JavaLangString += amtj.a(2131714259);
      break;
      label385:
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  public static Uri a(BaseActivity paramBaseActivity, bdsg parambdsg)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new bdsa(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return null;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0))
    {
      paramBaseActivity.requestPermissions(new bdsb(parambdsg, paramBaseActivity), 1, new String[] { "android.permission.CAMERA" });
      return null;
    }
    return bfaj.a(paramBaseActivity, AppConstants.SDCARD_IMG_SAVE, 1001);
  }
  
  public static ViewGroup a(BaseActivity paramBaseActivity, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    abem.a(paramBaseActivity, paramEditText);
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity, 2131559130, null);
    paramEditText.setCallBack(paramEmoticonCallback);
    paramEditText.onlySysAndEmoji = true;
    paramEditText.init(paramBaseActivity.app, 1008, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null);
    paramEditText.hideAllTabs();
    paramViewGroup.addView(paramEditText, new RelativeLayout.LayoutParams(-1, (int)bfvh.a(paramBaseActivity, 250.0F)));
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    abem.a(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
    paramEditText.setBackgroundResource(2130838034);
    paramEmoticonCallback = new RelativeLayout.LayoutParams(-1, (int)bfvh.a(paramContext, 196.0F));
    int i = (int)bfvh.a(paramContext, 20.0F);
    paramEditText.setPadding(0, i, 0, i);
    paramViewGroup.addView(paramEditText, paramEmoticonCallback);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo)
  {
    return a(paramString, paramArrayList, paramAudioInfo, null);
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo, bdlg parambdlg)
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
          TroopBarPublishActivity.Pic_list localPic_list = (TroopBarPublishActivity.Pic_list)bfaj.a.get(str);
          if (localPic_list == null) {
            break label283;
          }
          paramArrayList.put(localPic_list.getJsonObject());
          if (!ayfc.a(str)) {
            break label283;
          }
          i += 1;
          j += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        localJSONObject.put("gif_num", i);
        label158:
        if (paramAudioInfo != null) {
          paramString = new JSONArray();
        }
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
          if (parambdlg != null) {
            paramString = new JSONArray();
          }
        }
        catch (JSONException paramString)
        {
          try
          {
            do
            {
              paramString.put(parambdlg.a());
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
        break label158;
      }
    }
    catch (JSONException paramString)
    {
      label283:
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
      b(paramActivity);
      String str = paramBundle.getString("bid", "0");
      if ("interestcircle".endsWith(paramBundle.getString("from")))
      {
        paramActivity = "pub_page_new";
        if (paramInt != 3) {
          break label146;
        }
        paramBundle = "Clk_install";
        if (paramInt != 3) {
          break label158;
        }
        if (!"0".endsWith(str)) {
          break label153;
        }
        paramInt = 2;
      }
      for (;;)
      {
        bcef.b(null, "dc00899", "Grp_tribe", "", paramActivity, paramBundle, paramInt, 0, str, "", "", "");
        return;
        if ("0".endsWith(str)) {}
        for (paramActivity = "pub_page_new";; paramActivity = "reply_page_new") {
          break;
        }
        paramBundle = "Clk_update";
        break label77;
        paramInt = 1;
        continue;
        paramInt = 0;
      }
    case 1: 
      label77:
      a(paramActivity, paramBundle);
      label146:
      label153:
      label158:
      return;
    }
    b(paramActivity, paramBundle);
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tencenttribe://open_app/?from=profile"));
      localIntent.addFlags(268435456);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      QQToast.a(paramActivity, amtj.a(2131714256), 0).b(50);
    }
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
    String str = bfwv.a(paramActivity, "com.tencent.tribe");
    jdField_a_of_type_Bdsh = new bdsh(paramActivity, paramInt1, paramInt2, paramBundle);
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
      QQToast.a(paramActivity, amtj.a(2131714251), 0).b(50);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new bdsc(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      localArrayList.addAll(paramArrayList);
    }
    paramArrayList = new Intent();
    paramArrayList.setClass(paramBaseActivity, NewPhotoListActivity.class);
    paramArrayList.putExtra("enter_from", 24);
    paramArrayList.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramBaseActivity.getClass().getName());
    paramArrayList.putExtra("from_tribe_class_name", paramBaseActivity.getClass().getSimpleName());
    paramArrayList.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramArrayList.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramArrayList.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
    paramArrayList.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    paramArrayList.getExtras().remove("forward_type");
    paramArrayList.putExtra("album_enter_directly", true);
    paramArrayList.putExtra("ALBUM_ID", AlbumUtil.sLastAlbumId);
    paramArrayList.putExtra("ALBUM_NAME", AlbumUtil.sLastAlbumName);
    paramArrayList.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramArrayList.putExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", true);
    paramBaseActivity.startActivityForResult(paramArrayList, 1001);
    AlbumUtil.anim(paramBaseActivity, false, true);
  }
  
  public static void a(boolean paramBoolean)
  {
    bkwm.a("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a()
  {
    return ((Boolean)bkwm.a("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(true))).booleanValue();
  }
  
  protected static void b(Activity paramActivity)
  {
    if (bfby.a(paramActivity) != 2)
    {
      QQCustomDialog localQQCustomDialog = bfur.a(paramActivity, 230);
      localQQCustomDialog.setTitle(amtj.a(2131714255));
      paramActivity = new bdsf(paramActivity);
      localQQCustomDialog.setNegativeButton(amtj.a(2131714265), paramActivity);
      localQQCustomDialog.setPositiveButton(amtj.a(2131714261), paramActivity);
      localQQCustomDialog.show();
      return;
    }
    c(paramActivity);
  }
  
  protected static void b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 != 3) && (paramInt1 != 4) && (jdField_a_of_type_Bdsh.a().booleanValue()))
    {
      a(paramInt1, paramActivity, paramBundle);
      return;
    }
    String str2;
    String str1;
    label97:
    String str4;
    Object localObject;
    String str3;
    switch (paramInt2)
    {
    default: 
      str2 = amtj.a(2131714247);
      switch (paramInt1)
      {
      default: 
        str1 = "";
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          str4 = paramBundle.getString("bid", "0");
          if (!"interestcircle".endsWith(paramBundle.getString("from"))) {
            break label340;
          }
          localObject = "pub_page_new";
          if (paramInt1 != 3) {
            break label367;
          }
          str3 = "exp_install";
          label150:
          if (paramInt1 != 4) {
            break label375;
          }
          paramInt2 = 0;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      bcef.b(null, "dc00899", "Grp_tribe", "", (String)localObject, str3, paramInt2, 0, str4, "", "", "");
      localObject = bfur.a(paramActivity, 230);
      ((QQCustomDialog)localObject).setTitle(paramActivity.getString(2131695711, new Object[] { str1, str2 }));
      paramActivity = new bdse(paramBundle, paramInt1, paramInt1, paramActivity);
      ((QQCustomDialog)localObject).setNegativeButton(amtj.a(2131714236), paramActivity);
      ((QQCustomDialog)localObject).setPositiveButton(amtj.a(2131714257) + str1, paramActivity);
      ((QQCustomDialog)localObject).show();
      return;
      str2 = amtj.a(2131714230);
      break;
      str2 = amtj.a(2131714233);
      break;
      str1 = amtj.a(2131714260);
      break label97;
      str1 = amtj.a(2131714243);
      break label97;
      str1 = amtj.a(2131714239);
      break label97;
      label340:
      if ("0".endsWith(str4)) {}
      for (localObject = "pub_page_new";; localObject = "reply_page_new") {
        break;
      }
      label367:
      str3 = "exp_update";
      break label150;
      label375:
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
      QQToast.a(paramActivity, amtj.a(2131714248), 0).b(50);
    }
  }
  
  public static void c(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      Object localObject2 = new JSONObject(HttpUtil.openUrl(paramActivity, "https://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131695710);
      localObject2 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      String str1 = paramActivity.getString(2131695712);
      String str2 = paramActivity.getString(2131695709);
      Bundle localBundle = new Bundle();
      localBundle.putString(bibw.b, (String)localObject1);
      localBundle.putString(bibw.j, (String)localObject2);
      localBundle.putInt(bibw.k, 2);
      localBundle.putString(bibw.l, str2);
      localBundle.putString(bibw.f, str1);
      localBundle.putBoolean(bibw.r, false);
      localBundle.putBoolean(bibw.x, false);
      localBundle.putString(bibw.m, "_" + (String)localObject1);
      bibs.a(paramActivity, localBundle, "biz_src_feeds_buluo", null, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "====tribe app download====" + localException.toString());
      }
      QQToast.a(paramActivity, amtj.a(2131714252), 0).b(50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils
 * JD-Core Version:    0.7.0.1
 */