package dov.com.qq.im.ptv;

import bafb;
import bhxf;
import bhxg;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bhxf localbhxf = new bhxf(this);
    bhxg localbhxg = new bhxg(this);
    bafb.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbhxf, localbhxf, localbhxg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */