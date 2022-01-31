import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class okk
  implements bbgn
{
  public okk(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = ReadInJoySelfFragment.a(this.a).getScrollY();
    if ((this.a.getActivity() != null) && ((this.a.getActivity() instanceof ReadInJoyNewFeedsActivity))) {}
    do
    {
      return;
      if (paramInt1 >= ReadInJoySelfFragment.a(this.a))
      {
        ReadInJoySelfFragment.a(this.a).setBackgroundColor(Color.parseColor("#FFFFFF"));
        if (paramInt1 >= ReadInJoySelfFragment.a(this.a) * 3) {}
        for (float f = 1.0F;; f = paramInt1 * 0.33F / ReadInJoySelfFragment.a(this.a))
        {
          ReadInJoySelfFragment.a(this.a).setAlpha(f);
          ReadInJoySelfFragment.a(this.a).setBackgroundResource(2130842344);
          ReadInJoySelfFragment.a(this.a).setVisibility(0);
          if ((this.a.getActivity() == null) || (!(this.a.getActivity() instanceof ReadInJoySelfActivity))) {
            break;
          }
          ImmersiveUtils.a(true, this.a.getActivity().getWindow());
          return;
        }
      }
      ReadInJoySelfFragment.a(this.a).setBackgroundColor(Color.parseColor("#00FFFFFF"));
      ReadInJoySelfFragment.a(this.a).setBackgroundResource(2130842345);
      ReadInJoySelfFragment.a(this.a).setVisibility(8);
    } while ((this.a.getActivity() == null) || (!(this.a.getActivity() instanceof ReadInJoySelfActivity)));
    ImmersiveUtils.a(false, this.a.getActivity().getWindow());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okk
 * JD-Core Version:    0.7.0.1
 */