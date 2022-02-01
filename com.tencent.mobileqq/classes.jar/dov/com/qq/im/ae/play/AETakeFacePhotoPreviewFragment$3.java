package dov.com.qq.im.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class AETakeFacePhotoPreviewFragment$3
  implements DialogInterface.OnDismissListener
{
  AETakeFacePhotoPreviewFragment$3(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    AETakeFacePhotoPreviewFragment.access$300(this.this$0);
    AEVideoShelfEditFragment.keepScreenOn(this.this$0.getActivity(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */