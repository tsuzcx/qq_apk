package dov.com.qq.im.ae.camera.ui.dashboard;

import java.util.Comparator;

final class AEDashboardUtil$4
  implements Comparator<AEDashboardUtil.BinaryInfo>
{
  public int a(AEDashboardUtil.BinaryInfo paramBinaryInfo1, AEDashboardUtil.BinaryInfo paramBinaryInfo2)
  {
    if (paramBinaryInfo1.a) {
      return 1;
    }
    if (paramBinaryInfo2.a) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil.4
 * JD-Core Version:    0.7.0.1
 */