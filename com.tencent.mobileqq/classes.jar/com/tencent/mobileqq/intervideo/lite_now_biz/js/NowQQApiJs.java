package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONObject;

public class NowQQApiJs
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "QQApi";
  private static final int SHARE_THUMB_SIZE = 300;
  private static final String SHARE_TO_QQ = "0";
  private static final String SHARE_TO_QZONE = "1";
  private static final String SHARE_TO_WECHAT = "2";
  private static final String SHARE_TO_WECHAT_MOMENTS = "3";
  private static final String TAG = "NowQQApiJs";
  
  public NowQQApiJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
  }
  
  private String getUin()
  {
    return BusinessManager.a.f();
  }
  
  private void shareToQQ(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", getUin());
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/share/toqq/activity");
  }
  
  private void shareToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt)
  {
    if (!WXShareHelper.a().b())
    {
      QRUtils.a(0, 2131918154);
      return;
    }
    if (!WXShareHelper.a().c())
    {
      QRUtils.a(0, 2131918155);
      return;
    }
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new NowQQApiJs.1(this, str));
    WXShareHelper.a().a(str, paramString1, paramBitmap, paramString2, paramString3, paramInt);
  }
  
  @NewJavascriptInterface
  public void beginShare() {}
  
  public String getName()
  {
    return "QQApi";
  }
  
  @NewJavascriptInterface
  public void shareMsg(Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        QLog.i("NowQQApiJs", 1, "AppJavascriptInterface doShare js fun");
        Object localObject4 = new JSONObject((String)paramMap.get("p"));
        Object localObject2 = ((JSONObject)localObject4).getString("share_type");
        paramMap = ((JSONObject)localObject4).getString("share_url");
        localObject1 = ((JSONObject)localObject4).getString("title");
        String str = ((JSONObject)localObject4).getString("desc");
        Object localObject3 = ((JSONObject)localObject4).getString("image_url");
        if ((!"2".equals(localObject2)) && (!"3".equals(localObject2)))
        {
          if ("0".equals(localObject2))
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("title", (String)localObject1);
            ((Bundle)localObject2).putString("imageurl", (String)localObject3);
            ((Bundle)localObject2).putString("imageUrl", (String)localObject3);
            ((Bundle)localObject2).putString("targeturl", paramMap);
            ((Bundle)localObject2).putString("targetUrl", paramMap);
            ((Bundle)localObject2).putString("summary", str);
            if (((JSONObject)localObject4).has("sourceName")) {
              ((Bundle)localObject2).putString("sourcename", ((JSONObject)localObject4).getString("sourceName"));
            }
            shareToQQ((Bundle)localObject2);
            return;
          }
          "1".equals(localObject2);
          return;
        }
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = 300;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = 300;
        localObject3 = ImageUtil.b(URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4));
        if ("2".equals(localObject2))
        {
          i = 0;
          shareToWX((String)localObject1, str, (Bitmap)localObject3, paramMap, i);
          return;
        }
      }
      catch (Exception paramMap)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("share err ");
        ((StringBuilder)localObject1).append(paramMap.getMessage());
        QLog.e("NowQQApiJs", 1, ((StringBuilder)localObject1).toString());
        QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131916404), 0).show();
        return;
      }
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs
 * JD-Core Version:    0.7.0.1
 */