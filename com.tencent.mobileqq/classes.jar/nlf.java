import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;

public class nlf
  implements qmz
{
  public nlf(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.a).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a() != null)) {
      ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a().k();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      rvf.a(false);
    }
    if (paramInt2 == 1) {
      this.a.getIntent().putExtra("channel_from", 7);
    }
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.a.a() instanceof ReadInJoySubChannelFragment)))
    {
      this.a.a().f();
      return;
    }
    this.a.a(paramInt2, 256, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlf
 * JD-Core Version:    0.7.0.1
 */