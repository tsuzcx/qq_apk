package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WebLauncher
  implements ILauncher
{
  private Bundle a;
  
  public WebLauncher() {}
  
  public WebLauncher(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
    localIntent.putExtra("url", paramColorNote.getSubType());
    if (paramColorNote.getReserve() != null) {}
    try
    {
      localIntent.putExtra("key_scroll_y", new JSONObject(new String(paramColorNote.getReserve())).getInt("key_scroll_y"));
      localIntent.putExtra("subType", paramColorNote.mSubType);
      localIntent.addFlags(268435456);
      if (this.a != null) {
        localIntent.putExtra("isFromFavourite", this.a.getBoolean("isFromFavourite", false));
      }
      paramContext.startActivity(localIntent);
      ReportUtil.c(paramColorNote);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebLauncher", 1, localJSONException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.WebLauncher
 * JD-Core Version:    0.7.0.1
 */