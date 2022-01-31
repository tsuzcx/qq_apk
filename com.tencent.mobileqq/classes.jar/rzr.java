import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.10.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;

public class rzr
  implements ViolaInstance.ViolaPageListener
{
  public rzr(ViolaBaseView paramViolaBaseView) {}
  
  public void onComponentTopIndex(View paramView, float paramFloat)
  {
    if (((ViolaBaseView.a(this.a) instanceof ViolaFragment)) && (((ViolaFragment)ViolaBaseView.a(this.a)).a() != null)) {
      ((ViolaFragment)ViolaBaseView.a(this.a)).a().a(paramView, paramFloat);
    }
  }
  
  public void onDispatchTouchEvent(String paramString, int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef())) {
      ViolaBaseView.b(this.a, paramInt2);
    }
  }
  
  public void onScroll(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef()))
    {
      ViolaBaseView.b(this.a, paramInt5);
      ViolaBaseView.b(this.a, true);
      if (ViolaBaseView.a(this.a) != null) {
        ViolaBaseView.a(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
      }
    }
  }
  
  public void onScrollStateChanged(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (ViolaBaseView.a(this.a) != null) {
      ViolaBaseView.a(this.a).a(paramString, paramInt1);
    }
    if (paramString.equals(ViolaBaseView.a(this.a).getMasterListRef()))
    {
      ViolaBaseView.b(this.a, paramInt2);
      ViolaBaseView.b(this.a, true);
    }
  }
  
  public void pageOpenSuccess()
  {
    ViolaBaseView.a(this.a, 3);
    ThreadManager.post(new ViolaBaseView.10.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzr
 * JD-Core Version:    0.7.0.1
 */