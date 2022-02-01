package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.seamless.SPSeamlessHelper.SeamlessCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "data", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$jumpToColumnPlay$1
  extends Lambda
  implements Function1<String, Unit>
{
  VideoColumnBannerManager$jumpToColumnPlay$1(VideoColumnBannerManager paramVideoColumnBannerManager, ShortVideoItemHolder paramShortVideoItemHolder, VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    super(1);
  }
  
  public final void invoke(@Nullable String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = this.$playingVideoHolder.az;
        JSONObject localJSONObject = null;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).h;
          if (localObject == null) {
            break label215;
          }
          str = ((IVideoPlayerWrapper)localObject).V();
          if (paramString != null) {
            localJSONObject = this.this$0.a(paramString, this.$videoInfo, this.$playingVideoHolder, this.$fromType);
          }
          SPSeamlessHelper.get().jumpScene(str, (SPSeamlessHelper.SeamlessCallback)new VideoColumnBannerManager.jumpToColumnPlay.1.1((IVideoPlayerWrapper)localObject));
          Bundle localBundle = new Bundle();
          localBundle.putString("param", String.valueOf(localJSONObject));
          paramString = new StringBuilder();
          paramString.append("https://viola.qq.com/js/TopicVideo.js?_rij_violaUrl=1&v_bid=3811&v_tid=15&hideNav=1&v_bundleName=TopicVideo&supportNV=1&v_push_animated_disable=1&v_bg_color=00ffffff&v_content_full=1&v_nav_immer=1&v_error_white=1&videoToken=");
          paramString.append(str);
          paramString.append("&rowkey=");
          paramString.append(this.$videoInfo.l);
          localObject = paramString.toString();
          paramString = (String)localObject;
          if (this.$videoFromType == 125)
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append("&pagetype=1");
            paramString = paramString.toString();
          }
          ViolaAccessHelper.a((Context)this.this$0.b(), "", paramString, localBundle, true);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      Object localObject = null;
      continue;
      label215:
      String str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.jumpToColumnPlay.1
 * JD-Core Version:    0.7.0.1
 */