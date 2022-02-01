package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;

class CaptureQmcfSoDownloadFragment$7$1
  implements DialogInterface.OnClickListener
{
  CaptureQmcfSoDownloadFragment$7$1(CaptureQmcfSoDownloadFragment.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getActivity();
    if (paramInt == 1)
    {
      CaptureQmcfSoDownloadFragment.a(this.a.this$0).setCameraPermissionResult(false);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramDialogInterface.getPackageName(), null));
      paramDialogInterface.startActivity(localIntent);
      return;
    }
    paramDialogInterface.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.7.1
 * JD-Core Version:    0.7.0.1
 */