package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import org.json.JSONArray;
import org.json.JSONObject;

class QQViewBridgeImpl$GifUi
{
  HotPicData a;
  private PublicAccountHotPicPanel c;
  private final PublicAccountGifListener d = new QQViewBridgeImpl.GifUi.1(this);
  
  private QQViewBridgeImpl$GifUi(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  private void b()
  {
    this.a = null;
  }
  
  View a(Context paramContext)
  {
    if (this.c == null)
    {
      this.c = ((PublicAccountHotPicPanel)View.inflate(paramContext, 2131625633, null));
      this.c.a(this.b.a(), (BaseActivity)paramContext, null, null);
      this.c.setPublicAccountGifListener(this.d);
    }
    this.c.g();
    return this.c;
  }
  
  void a()
  {
    PublicAccountHotPicPanel localPublicAccountHotPicPanel = this.c;
    if (localPublicAccountHotPicPanel != null) {
      localPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
  }
  
  void a(JSONObject paramJSONObject)
  {
    if (this.a != null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("picType", 3);
      localJSONObject.put("url", this.a.originalUrl);
      localJSONObject.put("md5", this.a.originalMD5);
      localJSONObject.put("width", this.a.originalWidth);
      localJSONObject.put("height", this.a.originalHeight);
      localJSONObject.put("thumbnail_url", this.a.url);
      localJSONObject.put("thumbnail_md5", this.a.md5);
      localJSONObject.put("thumbnail_width", this.a.width);
      localJSONObject.put("thumbnail_height", this.a.height);
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
      paramJSONObject.put("picInfoList", localJSONArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.GifUi
 * JD-Core Version:    0.7.0.1
 */