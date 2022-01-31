import android.content.Context;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class mcf
  implements Runnable
{
  public mcf(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = this.a.a;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (localTranslateAnimation != null)
    {
      VideoFeedsPlayActivity.b(this.a).setVisibility(0);
      VideoFeedsPlayActivity.b(this.a).findViewById(2131365627).setVisibility(0);
      VideoFeedsPlayActivity.b(this.a).findViewById(2131365561).setVisibility(0);
      VideoFeedsPlayActivity.b(this.a).findViewById(2131365562).setVisibility(0);
      VideoFeedsPlayActivity.b(this.a).bringToFront();
      localLayoutParams = (RelativeLayout.LayoutParams)VideoFeedsPlayActivity.b(this.a).getLayoutParams();
      if (!VideoFeedsPlayActivity.i(this.a)) {
        break label152;
      }
      i = AIOUtils.a(130.0F, this.a.getApplicationContext().getResources());
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, 0, 0, i);
      VideoFeedsPlayActivity.b(this.a).setLayoutParams(localLayoutParams);
      VideoFeedsPlayActivity.b(this.a).startAnimation(localTranslateAnimation);
      return;
      label152:
      if (((VideoInfo)VideoFeedsPlayActivity.a(this.a).get(0)).a(this.a)) {
        i = AIOUtils.a(65.0F, this.a.getApplicationContext().getResources());
      } else {
        i = AIOUtils.a(25.0F, this.a.getApplicationContext().getResources());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcf
 * JD-Core Version:    0.7.0.1
 */