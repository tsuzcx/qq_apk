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
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
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
    return BusinessManager.a.a();
  }
  
  private void shareToQQ(Bundle paramBundle)
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), ShareToQQActivity.class);
    localIntent.addFlags(268435456);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", getUin());
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  private void shareToWX(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt)
  {
    if (!WXShareHelper.a().a())
    {
      QRUtils.a(0, 2131720753);
      return;
    }
    if (!WXShareHelper.a().b())
    {
      QRUtils.a(0, 2131720754);
      return;
    }
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new NowQQApiJs.1(this, str));
    WXShareHelper.a().b(str, paramString1, paramBitmap, paramString2, paramString3, paramInt);
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
      Object localObject1;
      try
      {
        QLog.i("NowQQApiJs", 1, "AppJavascriptInterface doShare js fun");
        Object localObject3 = new JSONObject((String)paramMap.get("p"));
        localObject1 = ((JSONObject)localObject3).getString("share_type");
        paramMap = ((JSONObject)localObject3).getString("share_url");
        String str1 = ((JSONObject)localObject3).getString("title");
        String str2 = ((JSONObject)localObject3).getString("desc");
        Object localObject2 = ((JSONObject)localObject3).getString("image_url");
        if (("2".equals(localObject1)) || ("3".equals(localObject1)))
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = 300;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = 300;
          localObject2 = ImageUtil.b(URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3));
          if (!"2".equals(localObject1)) {
            break label312;
          }
          i = 0;
          shareToWX(str1, str2, (Bitmap)localObject2, paramMap, i);
          return;
        }
        if ("0".equals(localObject1))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("title", str1);
          ((Bundle)localObject1).putString("imageurl", (String)localObject2);
          ((Bundle)localObject1).putString("imageUrl", (String)localObject2);
          ((Bundle)localObject1).putString("targeturl", paramMap);
          ((Bundle)localObject1).putString("targetUrl", paramMap);
          ((Bundle)localObject1).putString("summary", str2);
          if (((JSONObject)localObject3).has("sourceName")) {
            ((Bundle)localObject1).putString("sourcename", ((JSONObject)localObject3).getString("sourceName"));
          }
          shareToQQ((Bundle)localObject1);
          return;
        }
      }
      catch (Exception paramMap)
      {
        QLog.e("NowQQApiJs", 1, "share err " + paramMap.getMessage());
        QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131719153), 0).a();
        return;
      }
      boolean bool = "1".equals(localObject1);
      if (bool) {}
      return;
      label312:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs
 * JD-Core Version:    0.7.0.1
 */