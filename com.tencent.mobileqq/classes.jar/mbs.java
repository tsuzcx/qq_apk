import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.mobileqq.widget.QQToast;
import org.json.JSONException;
import org.json.JSONObject;

public class mbs
  implements View.OnClickListener
{
  public mbs(VideoFeedsAppJumpManager paramVideoFeedsAppJumpManager) {}
  
  public void onClick(View paramView)
  {
    label34:
    int i;
    JSONObject localJSONObject;
    if (VideoFeedsAppJumpManager.a(this.a) == 0)
    {
      paramView = "video_type_videoguid";
      if (!VideoFeedsAppJumpManager.a(this.a)) {
        break label161;
      }
      VideoFeedsWeiShiUtils.a(VideoFeedsAppJumpManager.a(this.a), paramView);
      i = VideoFeedsAppJumpManager.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        if (!VideoFeedsAppJumpManager.a(this.a)) {
          continue;
        }
        paramView = "0";
        localJSONObject.put("download", paramView);
      }
      catch (JSONException paramView)
      {
        label161:
        paramView.printStackTrace();
        continue;
        PublicAccountReportUtils.a(null, null, "0X8009034", "0X8009034", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, VideoFeedsAppJumpManager.a(this.a).a, VideoFeedsAppJumpManager.a(this.a).g, localJSONObject), false);
      }
      if (!VideoFeedsAppJumpManager.b(this.a)) {
        continue;
      }
      PublicAccountReportUtils.a(null, null, "0X80092A0", "0X80092A0", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, VideoFeedsAppJumpManager.a(this.a).a, VideoFeedsAppJumpManager.a(this.a).g, localJSONObject), false);
      return;
      if (VideoFeedsAppJumpManager.a(this.a) == 9)
      {
        paramView = "video_type_videopublic";
        break;
      }
      paramView = "video_type_videocard";
      break;
      QQToast.a(VideoFeedsAppJumpManager.a(this.a), -1, "正在下载，请稍候。", 0).b(VideoFeedsAppJumpManager.a(this.a).getResources().getDimensionPixelSize(2131558448));
      VideoFeedsWeiShiUtils.b(VideoFeedsAppJumpManager.a(this.a), paramView);
      break label34;
      paramView = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbs
 * JD-Core Version:    0.7.0.1
 */