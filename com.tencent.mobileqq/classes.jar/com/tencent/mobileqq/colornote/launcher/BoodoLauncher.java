package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class BoodoLauncher
  implements ILauncher
{
  private void a(Context paramContext, ColorNote paramColorNote)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
    localIntent.putExtra("url", paramColorNote.getSubType());
    localIntent.putExtra("subType", paramColorNote.mSubType);
    localIntent.putExtra("fragmentStyle", 1);
    localIntent.putExtra("tabBarStyle", 1);
    localIntent.putExtra("titleBarStyle", 1);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("jumpto", "com.qqcomic.reader.VipComicReadingActivityV2");
      localJSONObject.put("comic", paramJSONObject);
      localJSONObject.put("from", Integer.parseInt("1041001"));
      label37:
      paramContext = new ActivityURIRequest(paramContext, "/base/vipcomic");
      paramContext.extra().putString("options", localJSONObject.toString());
      paramContext.setFlags(268435456);
      QRoute.startUri(paramContext, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label37;
    }
  }
  
  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("jumpto", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
      localJSONObject.put("comic", paramJSONObject);
      label25:
      paramContext = new ActivityURIRequest(paramContext, "/base/vipcomic");
      paramContext.extra().putString("options", localJSONObject.toString());
      paramContext.setFlags(268435456);
      QRoute.startUri(paramContext, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      break label25;
    }
  }
  
  public int getType()
  {
    return 16908292;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    JSONObject localJSONObject;
    try
    {
      Object localObject = paramColorNote.getReserve();
      if (localObject == null)
      {
        QLog.e("BoodoLauncher", 2, "color note reserve is null");
        return;
      }
      localObject = new JSONObject(new String((byte[])localObject));
    }
    catch (JSONException localJSONException)
    {
      QLog.e("BoodoLauncher", 1, localJSONException, new Object[0]);
      localJSONObject = null;
    }
    if (localJSONObject != null)
    {
      int i = localJSONObject.optInt("colorNoteType", 0);
      if (i == 2)
      {
        a(paramContext, paramColorNote);
        return;
      }
      if (i == 1)
      {
        a(paramContext, localJSONObject);
        return;
      }
      if (i == 3) {
        b(paramContext, localJSONObject);
      }
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.BoodoLauncher
 * JD-Core Version:    0.7.0.1
 */