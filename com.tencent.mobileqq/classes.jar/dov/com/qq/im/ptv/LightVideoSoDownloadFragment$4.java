package dov.com.qq.im.ptv;

import bhpc;
import bpyl;
import bpym;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bpyl localbpyl = new bpyl(this);
    bpym localbpym = new bpym(this);
    bhpc.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbpyl, localbpyl, localbpym);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */