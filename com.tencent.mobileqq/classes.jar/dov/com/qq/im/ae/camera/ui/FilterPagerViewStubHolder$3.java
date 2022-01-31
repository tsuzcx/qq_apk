package dov.com.qq.im.ae.camera.ui;

import biks;
import bjav;
import bjcb;
import bkrg;
import bkrh;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(biks parambiks, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((bjcb)bjav.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = biks.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((bkrg)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((bkrh)localObject).c);
      }
      if (!this.a) {
        biks.a(this.this$0).a(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      biks.a(this.this$0).a();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */