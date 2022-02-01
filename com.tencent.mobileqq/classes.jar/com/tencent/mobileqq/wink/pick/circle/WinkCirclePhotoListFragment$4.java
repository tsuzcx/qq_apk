package com.tencent.mobileqq.wink.pick.circle;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.pick.AlbumUtil;

class WinkCirclePhotoListFragment$4
  implements DialogInterface.OnClickListener
{
  WinkCirclePhotoListFragment$4(WinkCirclePhotoListFragment paramWinkCirclePhotoListFragment, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.getActivity() == null) {
      return;
    }
    AEQLog.d("WinkCirclePhotoListFragment", "exit dialog confirm");
    if (!TextUtils.isEmpty(this.a))
    {
      AlbumUtil.clearSelectItemInfo();
      AlbumUtil.a();
      ((IPeakIpcController)QRoute.api(IPeakIpcController.class)).report(this.a, ((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).ACTION_QCIRCLE_PICKER_EXIT_CANCEL());
      AlbumUtil.anim(this.b.getActivity(), false, false);
    }
    this.b.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment.4
 * JD-Core Version:    0.7.0.1
 */