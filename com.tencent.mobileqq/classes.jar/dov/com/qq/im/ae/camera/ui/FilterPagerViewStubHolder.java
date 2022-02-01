package dov.com.qq.im.ae.camera.ui;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.SelectCallBack;

public class FilterPagerViewStubHolder
  extends BaseViewStubHolder
{
  private VideoFilterViewPager a;
  
  public FilterPagerViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public CameraViewPagerGesture a()
  {
    CameraViewPagerGesture localCameraViewPagerGesture = new CameraViewPagerGesture(null);
    a(new FilterPagerViewStubHolder.2(this, localCameraViewPagerGesture));
    return localCameraViewPagerGesture;
  }
  
  public void a(int paramInt)
  {
    a(new FilterPagerViewStubHolder.5(this, paramInt));
  }
  
  protected void a(View paramView)
  {
    this.a = ((VideoFilterViewPager)paramView.findViewById(2131367180));
  }
  
  public void a(VideoFilterViewPager.SelectCallBack paramSelectCallBack)
  {
    a(new FilterPagerViewStubHolder.4(this, paramSelectCallBack));
  }
  
  public void a(boolean paramBoolean)
  {
    a();
    a(new FilterPagerViewStubHolder.1(this, paramBoolean));
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    this.a.d();
  }
  
  public void b(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!a())) {
      return;
    }
    a();
    VideoFilterViewPager localVideoFilterViewPager = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localVideoFilterViewPager.setVisibility(i);
      this.a.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    boolean bool2 = true;
    a();
    VideoFilterViewPager localVideoFilterViewPager;
    if (this.a != null)
    {
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label77;
      }
      bool1 = true;
      localVideoFilterViewPager.setDisableScroll(bool1);
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label82;
      }
    }
    label77:
    label82:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoFilterViewPager.a(bool1);
      if (this.a != null)
      {
        this.a.setIsNormalMode(paramBoolean);
        if (paramBoolean) {
          break label87;
        }
        this.a.a(0);
      }
      return;
      bool1 = false;
      break;
    }
    label87:
    this.a.a();
  }
  
  public void d(boolean paramBoolean)
  {
    a();
    this.a.post(new FilterPagerViewStubHolder.3(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder
 * JD-Core Version:    0.7.0.1
 */