import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoBrightnessControl;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.OnTabChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.Tab;

public class lel
  implements BaseTabbar.OnTabChangeListener
{
  public lel(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.a).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a() != null)) {
      ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a().a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {
      this.a.getIntent().putExtra("channel_from", 7);
    }
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.a.a() instanceof ReadInJoySubChannelFragment))) {
      this.a.a().e();
    }
    for (;;)
    {
      if ((paramInt1 == 1) && (paramInt2 != paramInt1)) {
        VideoBrightnessControl.a().b(this.a);
      }
      return;
      this.a.a(paramInt2, 256, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lel
 * JD-Core Version:    0.7.0.1
 */