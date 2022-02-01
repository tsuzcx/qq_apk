import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.view.WatchTogetherAdminControlView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nbe
  implements View.OnClickListener
{
  public nbe(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    int m = 1;
    WatchTogetherAdminControlView.a(this.a, 0, 2);
    WatchTogetherAdminControlView.c(this.a);
    lfe locallfe = lbz.a().a();
    mxd localmxd = (mxd)VideoController.a().a.a(15);
    if (localmxd.a(locallfe)) {
      localmxd.d(locallfe);
    }
    int i;
    int j;
    label96:
    label102:
    int k;
    if ((locallfe.j) && (locallfe.k))
    {
      i = 1;
      if ((!locallfe.j) && (!locallfe.k)) {
        break label194;
      }
      j = 1;
      if (i == 0) {
        break label199;
      }
      i = 1;
      if ((WatchTogetherAdminControlView.a(this.a) == null) || (!WatchTogetherAdminControlView.a(this.a).c())) {
        break label213;
      }
      j = 1;
      label129:
      if ((WatchTogetherAdminControlView.a(this.a) == null) || (!WatchTogetherAdminControlView.a(this.a).d())) {
        break label218;
      }
      k = 1;
      label157:
      if (j == 0) {
        break label224;
      }
      j = m;
    }
    for (;;)
    {
      mrr.a("0X800B631", i, 0, String.valueOf(j), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label194:
      j = 0;
      break label96;
      label199:
      if (j != 0)
      {
        i = 2;
        break label102;
      }
      i = 3;
      break label102;
      label213:
      j = 0;
      break label129;
      label218:
      k = 0;
      break label157;
      label224:
      if (k != 0) {
        j = 3;
      } else {
        j = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbe
 * JD-Core Version:    0.7.0.1
 */