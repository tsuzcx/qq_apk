package dov.com.qq.im.ptv;

import bdfq;
import bmcg;
import bmch;
import bmci;
import bmcv;

public class LightWeightSoDownloadUnit$4
  implements Runnable
{
  public LightWeightSoDownloadUnit$4(bmcg parambmcg, String paramString) {}
  
  public void run()
  {
    bmch localbmch = new bmch(this);
    bmci localbmci = new bmci(this);
    bdfq.showPermissionSettingDialog(bmcg.a(this.this$0).a(), null, this.a, localbmch, localbmch, localbmci);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4
 * JD-Core Version:    0.7.0.1
 */