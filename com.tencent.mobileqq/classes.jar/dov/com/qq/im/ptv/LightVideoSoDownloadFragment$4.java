package dov.com.qq.im.ptv;

import bbgg;
import bjox;
import bjoy;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bjox localbjox = new bjox(this);
    bjoy localbjoy = new bjoy(this);
    bbgg.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbjox, localbjox, localbjoy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */