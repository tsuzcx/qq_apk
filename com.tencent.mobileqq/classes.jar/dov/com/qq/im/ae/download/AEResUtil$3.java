package dov.com.qq.im.ae.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bmbx;

final class AEResUtil$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bmbx.d("AEResUtil", "【Camera is in Prepareing】toast show: choose sure");
    AEResUtil.peakRequestAEResAdditionPackage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResUtil.3
 * JD-Core Version:    0.7.0.1
 */