package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyMomentUtils
{
  public static Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static String a(long paramLong)
  {
    paramLong = NetConnInfoCenter.getServerTimeMillis() - paramLong;
    if (paramLong < 3600000L) {
      return paramLong / 60L / 1000L + 1L + "分钟前";
    }
    if (paramLong < 86400000L) {
      return paramLong / 60L / 60L / 1000L + "小时前";
    }
    return paramLong / 24L / 60L / 60L / 1000L + "天前";
  }
  
  public static void a(Context paramContext, PublishVideoEntry paramPublishVideoEntry, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    File localFile1 = new File(paramPublishVideoEntry.mLocalRawVideoDir + "");
    File localFile2 = new File(paramPublishVideoEntry.thumbPath + "");
    paramPublishVideoEntry = new File(paramPublishVideoEntry.doodlePath + "");
    try
    {
      localJSONObject.put("videoUrl", localFile1.toURI() + "");
      localJSONObject.put("coverUrl", localFile2.toURI() + "");
      localJSONObject.put("doodleUrl", paramPublishVideoEntry.toURI() + "");
      localJSONObject.put("is_local", "1");
      paramPublishVideoEntry = new Bundle();
      paramPublishVideoEntry.putString("preLoadParams", localJSONObject.toString());
      paramPublishVideoEntry.putBoolean("scroll_to_comment", false);
      paramPublishVideoEntry.putString("isLocal", "1");
      paramPublishVideoEntry.putString("play_mode", String.valueOf(2));
      paramPublishVideoEntry.putBoolean("is_multi_progress_bar", false);
      paramPublishVideoEntry.putString("feed_type", String.valueOf(paramInt));
      SmallVideoFragment.a(paramContext, paramPublishVideoEntry);
      return;
    }
    catch (JSONException paramPublishVideoEntry)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentUtils", 2, "getPreviewPage, e=" + paramPublishVideoEntry.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentUtils
 * JD-Core Version:    0.7.0.1
 */