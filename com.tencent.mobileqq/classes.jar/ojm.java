import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;

public class ojm
  implements slv
{
  public ojm(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.a).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a() != null)) {
      ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a().k();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      ube.a(false);
    }
    if (paramInt2 == 1) {
      this.a.getIntent().putExtra("channel_from", 7);
    }
    View localView;
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.a.a() instanceof ReadInJoySubChannelFragment)))
    {
      this.a.a().f();
      if (paramInt2 != 3) {
        break label217;
      }
      localView = this.a.b.findViewById(2131378804);
      if (localView.getVisibility() == 0)
      {
        if (paramInt1 != 0) {
          break label167;
        }
        ((TextView)localView.findViewById(2131368994)).setText(anni.a(2131693162));
        label107:
        localView.clearAnimation();
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(250L);
        localAlphaAnimation.setAnimationListener(new ojn(this, localView));
        localView.startAnimation(localAlphaAnimation);
      }
    }
    label167:
    label217:
    do
    {
      return;
      this.a.a(paramInt2, 256, null, true);
      break;
      if (paramInt1 == 1)
      {
        ((TextView)localView.findViewById(2131368994)).setText(anni.a(2131711659));
        break label107;
      }
      if (paramInt1 != 2) {
        break label107;
      }
      ((TextView)localView.findViewById(2131368994)).setText(anni.a(2131711816));
      break label107;
      localView = this.a.b.findViewById(2131378804);
    } while (localView.getVisibility() == 0);
    localView.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new ojo(this, localView));
    localView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojm
 * JD-Core Version:    0.7.0.1
 */