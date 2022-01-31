package dov.com.qq.im.ptv;

import bbgu;
import bjpo;
import bjpp;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bjpo localbjpo = new bjpo(this);
    bjpp localbjpp = new bjpp(this);
    bbgu.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbjpo, localbjpo, localbjpp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */