package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class VideoFeedsShareController$VideoSetAction
  extends ShareAction
{
  VideoFeedsShareController$VideoSetAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    super.a(paramInt, paramVideoInfo, paramString, paramActionSheetItem);
    paramString = new Bundle();
    paramActionSheetItem = new JSONObject();
    for (;;)
    {
      try
      {
        if (VideoFeedsShareController.b(this.a).u()) {
          break label107;
        }
        bool = true;
        paramActionSheetItem.put("autoPlayEnable", bool);
        paramActionSheetItem.put("rowkey", paramVideoInfo.l);
      }
      catch (JSONException paramVideoInfo)
      {
        QLog.w("VideoFeedsShareController", 1, "VideoSetAction's param join failed!", paramVideoInfo);
      }
      paramString.putString("param", paramActionSheetItem.toString());
      ViolaAccessHelper.a(VideoFeedsShareController.f(this.a), "", "https://viola.qq.com/js/RIJVideoSetup.js?_rij_violaUrl=1&hideNav=1&v_content_full=1&v_nav_immer=1&v_tid=15&v_bundleName=RIJVideoSetup&v_bid=3811", paramString);
      return;
      label107:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.VideoSetAction
 * JD-Core Version:    0.7.0.1
 */