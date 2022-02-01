package dov.com.qq.im.ptv;

import bgpa;
import bowq;
import bowr;

public class LightVideoSoDownloadFragment$4
  implements Runnable
{
  LightVideoSoDownloadFragment$4(LightVideoSoDownloadFragment paramLightVideoSoDownloadFragment, String paramString) {}
  
  public void run()
  {
    bowq localbowq = new bowq(this);
    bowr localbowr = new bowr(this);
    bgpa.showPermissionSettingDialog(this.this$0.getActivity(), null, this.a, localbowq, localbowq, localbowr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment.4
 * JD-Core Version:    0.7.0.1
 */