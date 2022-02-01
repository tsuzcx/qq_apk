package dov.com.qq.im.ae.biz.qcircle;

import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout.OnTabSelectedCallback;

class AECircleMultiUnit$1
  implements TabLayout.OnTabSelectedCallback
{
  AECircleMultiUnit$1(AECircleMultiUnit paramAECircleMultiUnit) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      AECircleMultiUnit.a(this.a).setCurrentItem(0, true);
      AECircleMultiUnit.a(this.a).b();
      AECircleMultiUnit.a(this.a).k();
      AEBaseDataReporter.a().ac();
    }
    for (;;)
    {
      AECircleMultiUnit.a(AECircleMultiUnit.a(this.a, AECircleMultiUnit.a(this.a)), AECircleMultiUnit.a(this.a));
      return;
      AEReportUtils.a(8, 2);
      AECircleMultiUnit.a(this.a);
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt != 1) || (AECircleMultiUnit.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit.1
 * JD-Core Version:    0.7.0.1
 */