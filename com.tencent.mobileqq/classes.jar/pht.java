import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

class pht
  implements ViewTreeObserver.OnPreDrawListener
{
  pht(phs paramphs) {}
  
  public boolean onPreDraw()
  {
    View localView = ReadInJoyChannelPanelFragment.a(this.a.a).getChildAt(ReadInJoyChannelPanelFragment.a(this.a.a).getChildCount() - 1);
    Object localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject = this.a.a.a(phs.a(this.a), (int[])localObject);
    ReadInJoyChannelPanelFragment.a(localObject[0], 0.0F, localObject[1], 0.0F, localView);
    ReadInJoyChannelPanelFragment.a(this.a.a).getViewTreeObserver().removeOnPreDrawListener(phs.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pht
 * JD-Core Version:    0.7.0.1
 */