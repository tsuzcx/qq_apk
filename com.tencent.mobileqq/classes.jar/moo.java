import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyViewLayer;

public class moo
  implements View.OnClickListener
{
  public moo(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    if (ReadinjoyTabFrame.a(this.a) != null)
    {
      if ((ReadinjoyTabFrame.a(this.a) != null) && (ReadinjoyTabFrame.a(this.a).getParent() != null) && ((ReadinjoyTabFrame.a(this.a).getParent().getParent() instanceof FrameLayout))) {
        ReadinjoyTabFrame.a(this.a).a((ViewGroup)ReadinjoyTabFrame.a(this.a).getParent().getParent());
      }
      if (ReadinjoyTabFrame.a(this.a).a()) {
        ReadinjoyTabFrame.a(this.a).a(null);
      }
    }
    else
    {
      return;
    }
    if (ReadinjoyTabFrame.a(this.a) != null)
    {
      ReadinjoyTabFrame.a(this.a).a(ReadinjoyTabFrame.a(this.a).mChannelCoverId);
      return;
    }
    ReadinjoyTabFrame.a(this.a).a(ReadInJoyNaviController.a().mChannelCoverId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moo
 * JD-Core Version:    0.7.0.1
 */