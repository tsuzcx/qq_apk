package dov.com.qq.im.ae.camera.ui;

import bkph;
import blmf;
import blnl;
import bncq;
import bncr;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class FilterPagerViewStubHolder$3
  implements Runnable
{
  public FilterPagerViewStubHolder$3(bkph parambkph, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = ((blnl)blmf.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = bkph.a(this.this$0);
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - comboFilterData not null");
      }
      localVideoFilterViewPager.setCaptureScene(0);
      localObject = ((bncq)localObject).a(0);
      if (localObject != null) {
        localVideoFilterViewPager.a(((bncr)localObject).c);
      }
      if (!this.a) {
        bkph.a(this.this$0).a(0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      bkph.a(this.this$0).a();
      return;
    }
    QLog.d("FilterPagerViewStubHolder", 2, "onResourceDownload - updateAndSelectFilter() - filterPager is null or comboFilterData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3
 * JD-Core Version:    0.7.0.1
 */