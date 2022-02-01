import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStressFollowLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
public final class sop
  implements View.OnClickListener
{
  public sop(VideoFeedsStressFollowLayout paramVideoFeedsStressFollowLayout) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = VideoFeedsStressFollowLayout.a(this.a);
    if ((localObject != null) && (((VideoInfo)localObject).q == true)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = VideoFeedsStressFollowLayout.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sor)((Iterator)localObject).next()).a(VideoFeedsStressFollowLayout.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sop
 * JD-Core Version:    0.7.0.1
 */