package dov.com.qq.im.ae.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bmbx;

final class AEResUtil$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bmbx.d("AEResUtil", "【Camera is in Prepareing】toast show: choose cancel");
    paramDialogInterface.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.AEResUtil.2
 * JD-Core Version:    0.7.0.1
 */