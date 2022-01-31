import android.content.Context;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class mgu
  implements Runnable
{
  public mgu(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = this.a.a;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (localTranslateAnimation != null)
    {
      VideoFeedsPlayActivity.c(this.a).setVisibility(0);
      VideoFeedsPlayActivity.c(this.a).findViewById(2131365659).setVisibility(0);
      VideoFeedsPlayActivity.c(this.a).findViewById(2131365593).setVisibility(0);
      VideoFeedsPlayActivity.c(this.a).findViewById(2131365594).setVisibility(0);
      VideoFeedsPlayActivity.c(this.a).bringToFront();
      localLayoutParams = (RelativeLayout.LayoutParams)VideoFeedsPlayActivity.c(this.a).getLayoutParams();
      if (!VideoFeedsPlayActivity.k(this.a)) {
        break label152;
      }
      i = AIOUtils.a(130.0F, this.a.getApplicationContext().getResources());
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, 0, 0, i);
      VideoFeedsPlayActivity.c(this.a).setLayoutParams(localLayoutParams);
      VideoFeedsPlayActivity.c(this.a).startAnimation(localTranslateAnimation);
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
 * Qualified Name:     mgu
 * JD-Core Version:    0.7.0.1
 */