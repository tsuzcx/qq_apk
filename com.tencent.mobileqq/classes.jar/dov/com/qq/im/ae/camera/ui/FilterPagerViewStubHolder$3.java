package dov.com.qq.im.ae.camera.ui;

import bnip;
import bojv;
import bolb;
import bpyf;
import bpyg;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(bnip parambnip, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((bolb)bojv.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = bnip.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((bpyf)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((bpyg)localObject).c);
      }
      if (!this.a) {
        bnip.a(this.this$0).a(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      bnip.a(this.this$0).a();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */