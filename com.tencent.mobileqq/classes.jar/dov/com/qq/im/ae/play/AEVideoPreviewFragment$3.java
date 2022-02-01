package dov.com.qq.im.ae.play;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class AEVideoPreviewFragment$3
  implements DialogInterface.OnClickListener
{
  AEVideoPreviewFragment$3(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.this$0.getMediaPosition();
    paramDialogInterface = new Intent("AEEDITOR_GENERATE_STATUS_DELETE");
    paramDialogInterface.putExtra("delete_position", paramInt);
    paramDialogInterface.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(paramDialogInterface);
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */