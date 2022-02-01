import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.36;

public class sww
  implements qyw
{
  public sww(FastWebActivity.36 param36) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ViewGroup localViewGroup;
    View localView;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)this.a.this$0.getWindow().getDecorView();
      localView = localViewGroup.findViewById(2131363616);
      if (localView == null) {
        break label176;
      }
    }
    label176:
    for (int i = localViewGroup.getHeight() - localView.getTop();; i = 0)
    {
      int j = zby.b(this.a.this$0, 16.0F);
      int k = this.a.this$0.getWindow().getDecorView().getHeight();
      int m = zby.b(this.a.this$0, 48.0F);
      FastWebActivity.a(this.a.this$0, FastWebActivity.b(this.a.this$0), j, k - i - m, false, false, paramString, 100000000);
      FastWebActivity.f(this.a.this$0, true);
      FastWebActivity.f(this.a.this$0, paramInt);
      FastWebActivity.b(this.a.this$0).setOnClickListener(new swx(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sww
 * JD-Core Version:    0.7.0.1
 */