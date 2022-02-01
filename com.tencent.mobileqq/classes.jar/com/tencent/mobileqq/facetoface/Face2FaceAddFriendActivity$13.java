package com.tencent.mobileqq.facetoface;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class Face2FaceAddFriendActivity$13
  implements DialogInterface.OnClickListener
{
  Face2FaceAddFriendActivity$13(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.g = false;
    paramDialogInterface.doOnBackPressed();
    ReportController.b(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_quit", 0, 0, this.a.f, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.13
 * JD-Core Version:    0.7.0.1
 */