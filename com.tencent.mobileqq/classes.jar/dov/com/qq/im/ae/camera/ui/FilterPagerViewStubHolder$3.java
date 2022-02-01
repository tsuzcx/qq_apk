package dov.com.qq.im.ae.camera.ui;

import bojx;
import bplq;
import bpmw;
import braa;
import brab;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(bojx parambojx, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((bpmw)bplq.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = bojx.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((braa)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((brab)localObject).c);
      }
      if (!this.a) {
        bojx.a(this.this$0).a(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      bojx.a(this.this$0).a();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */