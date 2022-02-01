package com.tencent.mobileqq.troop.activity;

import acid;
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
import antf;
import anzj;
import asmr;
import azru;
import bdll;
import bfcs;
import bfjj;
import bfjk;
import bfjl;
import bfjm;
import bfjn;
import bfjo;
import bfjp;
import bfjq;
import bgqv;
import bgsk;
import bhkd;
import bhlq;
import bhmg;
import bhny;
import bhpc;
import bjwk;
import bjwo;
import bnrf;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import nnr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishUtils
{
  public static Editable.Factory a;
  private static bfjq a;
  public static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_AndroidTextEditable$Factory = new bfjm();
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
    paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130843199, (BitmapFactory.Options)localObject);
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = anzj.a(2131714035);
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
      if (jdField_a_of_type_JavaLangString.endsWith(anzj.a(2131714030))) {
        break;
      }
      jdField_a_of_type_JavaLangString += anzj.a(2131714027);
      break;
      label385:
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  public static Uri a(BaseActivity paramBaseActivity, bfjp parambfjp)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new bfjj(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      return null;
    }
    if ((Build.VERSION.SDK_INT >= 23) && (paramBaseActivity.checkSelfPermission("android.permission.CAMERA") != 0))
    {
      paramBaseActivity.requestPermissions(new bfjk(parambfjp, paramBaseActivity), 1, new String[] { "android.permission.CAMERA" });
      return null;
    }
    return bgqv.a(paramBaseActivity, antf.bg, 1001);
  }
  
  public static ViewGroup a(BaseActivity paramBaseActivity, ViewGroup paramViewGroup, EditText paramEditText, asmr paramasmr)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    acid.a(paramBaseActivity, paramEditText);
    paramEditText = (EmoticonMainPanel)View.inflate(paramBaseActivity, 2131559123, null);
    paramEditText.setCallBack(paramasmr);
    paramEditText.b = true;
    paramEditText.a(paramBaseActivity.app, 1008, paramBaseActivity, paramBaseActivity.getTitleBarHeight(), null, null);
    paramEditText.k();
    paramViewGroup.addView(paramEditText, new RelativeLayout.LayoutParams(-1, (int)bhmg.a(paramBaseActivity, 250.0F)));
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, asmr paramasmr)
  {
    paramEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
    acid.a(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramasmr);
    paramEditText.setBackgroundResource(2130838009);
    paramasmr = new RelativeLayout.LayoutParams(-1, (int)bhmg.a(paramContext, 196.0F));
    int i = (int)bhmg.a(paramContext, 20.0F);
    paramEditText.setPadding(0, i, 0, i);
    paramViewGroup.addView(paramEditText, paramasmr);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo)
  {
    return a(paramString, paramArrayList, paramAudioInfo, null);
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo, bfcs parambfcs)
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
          TroopBarPublishActivity.Pic_list localPic_list = (TroopBarPublishActivity.Pic_list)bgqv.a.get(str);
          if (localPic_list == null) {
            break label283;
          }
          paramArrayList.put(localPic_list.getJsonObject());
          if (!azru.a(str)) {
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
          if (parambfcs != null) {
            paramString = new JSONArray();
          }
        }
        catch (JSONException paramString)
        {
          try
          {
            do
            {
              paramString.put(parambfcs.a());
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
        bdll.b(null, "dc00899", "Grp_tribe", "", paramActivity, paramBundle, paramInt, 0, str, "", "", "");
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
      QQToast.a(paramActivity, anzj.a(2131714024), 0).b(50);
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
    String str = bhny.a(paramActivity, "com.tencent.tribe");
    jdField_a_of_type_Bfjq = new bfjq(paramActivity, paramInt1, paramInt2, paramBundle);
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
      QQToast.a(paramActivity, anzj.a(2131714019), 0).b(50);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramBaseActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
    {
      paramBaseActivity.requestPermissions(new bfjl(paramBaseActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
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
    paramArrayList.putExtra("ALBUM_ID", bhkd.sLastAlbumId);
    paramArrayList.putExtra("ALBUM_NAME", bhkd.sLastAlbumName);
    paramArrayList.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    paramArrayList.putExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", true);
    paramBaseActivity.startActivityForResult(paramArrayList, 1001);
    bhkd.anim(paramBaseActivity, false, true);
  }
  
  public static void a(boolean paramBoolean)
  {
    bnrf.a("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a()
  {
    return ((Boolean)bnrf.a("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(true))).booleanValue();
  }
  
  protected static void b(Activity paramActivity)
  {
    if (bgsk.a(paramActivity) != 2)
    {
      bhpc localbhpc = bhlq.a(paramActivity, 230);
      localbhpc.setTitle(anzj.a(2131714023));
      paramActivity = new bfjo(paramActivity);
      localbhpc.setNegativeButton(anzj.a(2131714033), paramActivity);
      localbhpc.setPositiveButton(anzj.a(2131714029), paramActivity);
      localbhpc.show();
      return;
    }
    c(paramActivity);
  }
  
  protected static void b(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 != 3) && (paramInt1 != 4) && (jdField_a_of_type_Bfjq.a().booleanValue()))
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
      str2 = anzj.a(2131714015);
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
      bdll.b(null, "dc00899", "Grp_tribe", "", (String)localObject, str3, paramInt2, 0, str4, "", "", "");
      localObject = bhlq.a(paramActivity, 230);
      ((bhpc)localObject).setTitle(paramActivity.getString(2131695572, new Object[] { str1, str2 }));
      paramActivity = new bfjn(paramBundle, paramInt1, paramInt1, paramActivity);
      ((bhpc)localObject).setNegativeButton(anzj.a(2131714004), paramActivity);
      ((bhpc)localObject).setPositiveButton(anzj.a(2131714025) + str1, paramActivity);
      ((bhpc)localObject).show();
      return;
      str2 = anzj.a(2131713998);
      break;
      str2 = anzj.a(2131714001);
      break;
      str1 = anzj.a(2131714028);
      break label97;
      str1 = anzj.a(2131714011);
      break label97;
      str1 = anzj.a(2131714007);
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
      QQToast.a(paramActivity, anzj.a(2131714016), 0).b(50);
    }
  }
  
  public static void c(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      Object localObject2 = new JSONObject(nnr.a(paramActivity, "https://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131695571);
      localObject2 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      String str1 = paramActivity.getString(2131695573);
      String str2 = paramActivity.getString(2131695570);
      Bundle localBundle = new Bundle();
      localBundle.putString(bjwo.b, (String)localObject1);
      localBundle.putString(bjwo.j, (String)localObject2);
      localBundle.putInt(bjwo.k, 2);
      localBundle.putString(bjwo.l, str2);
      localBundle.putString(bjwo.f, str1);
      localBundle.putBoolean(bjwo.r, false);
      localBundle.putBoolean(bjwo.x, false);
      localBundle.putString(bjwo.m, "_" + (String)localObject1);
      bjwk.a(paramActivity, localBundle, "biz_src_feeds_buluo", null, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "====tribe app download====" + localException.toString());
      }
      QQToast.a(paramActivity, anzj.a(2131714020), 0).b(50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils
 * JD-Core Version:    0.7.0.1
 */