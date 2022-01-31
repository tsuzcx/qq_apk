package dov.com.qq.im.ptv;

import bdjz;
import bmfk;
import bmfl;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bmfk localbmfk = new bmfk(this);
    bmfl localbmfl = new bmfl(this);
    bdjz.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbmfk, localbmfk, localbmfl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */