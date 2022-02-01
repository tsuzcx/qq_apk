package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountColorNoteController
  extends WebColorNoteController
{
  public PublicAccountColorNoteController(@NonNull QQBrowserActivity paramQQBrowserActivity)
  {
    super(paramQQBrowserActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    super.f();
    super.a(paramBundle);
    if (this.a.getIntent().getBooleanExtra("KEY_SLIDE_RIGHT_BACK_ENABLE", true))
    {
      super.e();
      a();
      paramBundle = super.a();
      if (paramBundle != null) {
        paramBundle.disablePostTable();
      }
    }
  }
  
  public ColorNote getColorNote()
  {
    ColorNote localColorNote = super.getColorNote();
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianUrl(this.a.getIntent().getStringExtra("url"))) {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(localColorNote.getReserve()));
        localJSONObject.put("h5_type_read_in_joy", true);
        localColorNote.mReserve = localJSONObject.toString().getBytes();
        return localColorNote;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("WebColorNoteController", 1, localJSONException, new Object[0]);
      }
    }
    return localColorNote;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.PublicAccountColorNoteController
 * JD-Core Version:    0.7.0.1
 */