package com.tencent.mobileqq.troop.activity;

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
import android.os.Bundle;
import android.text.Editable.Factory;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.data.VideoInfo;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
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
  public static String a;
  public static boolean b = false;
  public static Editable.Factory c = new TroopBarPublishUtils.4();
  private static TroopBarPublishUtils.UserInvokeAction d;
  
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    if ((paramBitmap.getWidth() >= 640) && (paramBitmap.getHeight() >= 300))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      paramContext = BitmapFactory.decodeResource(paramContext.getResources(), 2130844330, (BitmapFactory.Options)localObject);
      if (TextUtils.isEmpty(a))
      {
        a = HardCodeUtil.a(2131912522);
      }
      else if (!a.endsWith(HardCodeUtil.a(2131912518)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131912515));
        a = ((StringBuilder)localObject).toString();
      }
      if (a.length() > 12)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a.substring(0, 11));
        ((StringBuilder)localObject).append("...");
        a = ((StringBuilder)localObject).toString();
      }
      int i = paramBitmap.getWidth();
      double d2 = 750;
      Double.isNaN(d2);
      double d3 = 36.0D / d2;
      double d1 = i;
      Double.isNaN(d1);
      i = (int)(d3 * d1);
      Double.isNaN(d2);
      d3 = 32.0D / d2;
      Double.isNaN(d1);
      int j = (int)(d3 * d1);
      Double.isNaN(d2);
      d3 = 8.0D / d2;
      Double.isNaN(d1);
      int k = (int)(d3 * d1);
      Double.isNaN(d2);
      d2 = 24.0D / d2;
      Double.isNaN(d1);
      int m = (int)(d2 * d1);
      localObject = new Paint();
      ((Paint)localObject).setDither(true);
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setColor(-1);
      ((Paint)localObject).setFakeBoldText(true);
      ((Paint)localObject).setTextSize(m);
      if (!paramBitmap.isMutable()) {
        paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      }
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.save();
      Rect localRect = new Rect(0, 0, paramContext.getWidth(), paramContext.getHeight());
      m = localCanvas.getHeight();
      int n = i + j;
      localCanvas.drawBitmap(paramContext, localRect, new Rect(i, m - i - j, n, localCanvas.getHeight() - i), (Paint)localObject);
      localCanvas.restore();
      localCanvas.save();
      localCanvas.translate(n + k, localCanvas.getHeight() - i - (i - j));
      localCanvas.drawText(a, 0.0F, 0.0F, (Paint)localObject);
      localCanvas.restore();
      return paramBitmap;
    }
    return null;
  }
  
  @TargetApi(11)
  public static SystemAndEmojiEmoticonPanel a(Context paramContext, ViewGroup paramViewGroup, EditText paramEditText, EmoticonCallback paramEmoticonCallback)
  {
    paramEditText.setEditableFactory(c);
    DeviceLib.a(paramContext, paramEditText);
    paramEditText = new SystemAndEmojiEmoticonPanel(paramContext, paramEmoticonCallback);
    paramEditText.setBackgroundResource(2130837993);
    paramEmoticonCallback = new RelativeLayout.LayoutParams(-1, (int)DisplayUtils.a(paramContext, 196.0F));
    int i = (int)DisplayUtils.a(paramContext, 20.0F);
    paramEditText.setPadding(0, i, 0, i);
    paramViewGroup.addView(paramEditText, paramEmoticonCallback);
    paramEditText.setVisibility(8);
    return paramEditText;
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo)
  {
    return a(paramString, paramArrayList, paramAudioInfo, null);
  }
  
  public static String a(String paramString, ArrayList<String> paramArrayList, AudioInfo paramAudioInfo, VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      localJSONObject.put("content", str);
      label30:
      int j;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        paramString = new ArrayList(paramArrayList);
        paramArrayList = new JSONArray();
        int i = 0;
        int k;
        for (j = 0; i < paramString.size(); j = k)
        {
          str = (String)paramString.get(i);
          TroopBarPublishUtils.Pic_list localPic_list = (TroopBarPublishUtils.Pic_list)TroopBarUtils.f.get(str);
          k = j;
          if (localPic_list != null)
          {
            paramArrayList.put(localPic_list.getJsonObject());
            k = j;
            if (BaseImageUtil.c(str)) {
              k = j + 1;
            }
          }
          i += 1;
        }
      }
      try
      {
        localJSONObject.put("pic_list", paramArrayList);
        localJSONObject.put("gif_num", j);
      }
      catch (JSONException paramString)
      {
        label171:
        break label171;
      }
      if (paramAudioInfo != null)
      {
        paramString = new JSONArray();
        try
        {
          paramString.put(new JSONObject(paramAudioInfo.getJsonText()));
          localJSONObject.put("audio_list", paramString);
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
          }
        }
      }
      if (paramVideoInfo != null)
      {
        paramString = new JSONArray();
        try
        {
          paramString.put(paramVideoInfo.a());
          localJSONObject.put("ugc_video_list", paramString);
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopBarPublishUtils", 2, paramString.getMessage());
          }
        }
      }
      return localJSONObject.toString();
    }
    catch (JSONException paramString)
    {
      break label30;
    }
  }
  
  public static void a(int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if ((paramInt != 3) && (paramInt != 4)) {
          return;
        }
        b(paramActivity);
        String str = paramBundle.getString("bid", "0");
        boolean bool = "interestcircle".endsWith(paramBundle.getString("from"));
        paramActivity = "pub_page_new";
        if (!bool) {
          for (;;)
          {
            if (!"0".endsWith(str)) {
              paramActivity = "reply_page_new";
            }
          }
        }
        if (paramInt == 3) {
          paramBundle = "Clk_install";
        } else {
          paramBundle = "Clk_update";
        }
        if (paramInt == 3)
        {
          if ("0".endsWith(str)) {
            paramInt = 2;
          } else {
            paramInt = 1;
          }
        }
        else {
          paramInt = 0;
        }
        ReportController.b(null, "dc00899", "Grp_tribe", "", paramActivity, paramBundle, paramInt, 0, str, "", "", "");
        return;
      }
      b(paramActivity, paramBundle);
      return;
    }
    a(paramActivity, paramBundle);
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
      label31:
      break label31;
    }
    QQToast.makeText(paramActivity, HardCodeUtil.a(2131912512), 0).show(50);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://buluo.qq.com/mobile/video_theme.html?_wv=1031&video_theme_id=");
    localStringBuilder.append(paramInt2);
    localIntent.putExtra("url", localStringBuilder.toString());
    paramActivity.startActivityForResult(localIntent, paramInt1);
  }
  
  protected static void a(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      Object localObject = paramBundle.getString("bid", "");
      String str = paramBundle.getString("uin");
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://gbar_home/?bid=%s&from=%s&post=true&uin=%s&title=%s&msg=%s&clicktype=%s", new Object[] { localObject, paramBundle.getString("from", "qqbuluo"), str, URLEncoder.encode(paramBundle.getString("title"), "UTF-8"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=====invoke proto====");
        ((StringBuilder)localObject).append(paramBundle.toString());
        QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject).toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      label161:
      break label161;
    }
    QQToast.makeText(paramActivity, HardCodeUtil.a(2131912507), 0).show(50);
  }
  
  public static void a(boolean paramBoolean)
  {
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(paramBoolean));
  }
  
  public static boolean a()
  {
    return ((Boolean)((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInJoySpValue("sp_key_is_open_tribe_pic_watermark", Boolean.valueOf(true))).booleanValue();
  }
  
  protected static void b(Activity paramActivity)
  {
    if (TroopFileUtils.a(paramActivity) != 2)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(paramActivity, 230);
      localQQCustomDialog.setTitle(HardCodeUtil.a(2131912511));
      paramActivity = new TroopBarPublishUtils.6(paramActivity);
      localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131898212), paramActivity);
      localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131912517), paramActivity);
      localQQCustomDialog.show();
      return;
    }
    c(paramActivity);
  }
  
  protected static void b(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(String.format("tencenttribe://post_detail/?pid=%s&bid=%s&bar_type=0&from=qqbuluo&post=true&uin=%s&floor=%s&msg=%s&clicktype=%s", new Object[] { paramBundle.getString("pid"), paramBundle.getString("bid", ""), paramBundle.getString("uin"), paramBundle.getString("floor"), URLEncoder.encode(paramBundle.getString("content"), "UTF-8"), paramBundle.getString("clicktype") })));
      paramBundle.addFlags(268435456);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("=====invoke proto====");
        localStringBuilder.append(paramBundle.toString());
        QLog.d("TroopBarPublishUtils", 2, localStringBuilder.toString());
      }
      paramActivity.startActivity(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      label148:
      break label148;
    }
    QQToast.makeText(paramActivity, HardCodeUtil.a(2131912504), 0).show(50);
  }
  
  protected static void c(Activity paramActivity)
  {
    try
    {
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putString("REFERER", " https://buluo.qq.com/");
      ((Bundle)localObject1).putString("HOST", " buluo.qq.com");
      localObject2 = new JSONObject(HttpUtil.openUrl(paramActivity, "https://buluo.qq.com/cgi-bin/sbar/other/downloadappurl", "POST", null, (Bundle)localObject1));
      localObject1 = paramActivity.getString(2131893995);
      String str1 = ((JSONObject)localObject2).getJSONObject("result").getJSONObject("android").getString("app_url");
      Object localObject3 = paramActivity.getString(2131893997);
      String str2 = paramActivity.getString(2131893994);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString(DownloadConstants.b, (String)localObject1);
      ((Bundle)localObject2).putString(DownloadConstants.j, str1);
      ((Bundle)localObject2).putInt(DownloadConstants.k, 2);
      ((Bundle)localObject2).putString(DownloadConstants.l, str2);
      ((Bundle)localObject2).putString(DownloadConstants.f, (String)localObject3);
      ((Bundle)localObject2).putBoolean(DownloadConstants.s, false);
      ((Bundle)localObject2).putBoolean(DownloadConstants.y, false);
      str1 = DownloadConstants.m;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((Bundle)localObject2).putString(str1, ((StringBuilder)localObject3).toString());
      DownloadApi.a(paramActivity, (Bundle)localObject2, "biz_src_feeds_buluo", null, 0);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2;
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("====tribe app download====");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject2).toString());
      }
      QQToast.makeText(paramActivity, HardCodeUtil.a(2131912508), 0).show(50);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils
 * JD-Core Version:    0.7.0.1
 */