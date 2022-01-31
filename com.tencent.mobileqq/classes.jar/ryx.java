import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.33;

public class ryx
  implements qfo
{
  public ryx(FastWebActivity.33 param33) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ViewGroup localViewGroup;
    View localView;
    if (paramBoolean)
    {
      localViewGroup = (ViewGroup)this.a.this$0.getWindow().getDecorView();
      localView = localViewGroup.findViewById(2131363422);
      if (localView == null) {
        break label176;
      }
    }
    label176:
    for (int i = localViewGroup.getHeight() - localView.getTop();; i = 0)
    {
      int j = xin.b(this.a.this$0, 16.0F);
      int k = this.a.this$0.getWindow().getDecorView().getHeight();
      int m = xin.b(this.a.this$0, 48.0F);
      FastWebActivity.a(this.a.this$0, FastWebActivity.b(this.a.this$0), j, k - i - m, false, false, paramString, 100000000);
      FastWebActivity.f(this.a.this$0, true);
      FastWebActivity.d(this.a.this$0, paramInt);
      FastWebActivity.b(this.a.this$0).setOnClickListener(new ryy(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryx
 * JD-Core Version:    0.7.0.1
 */