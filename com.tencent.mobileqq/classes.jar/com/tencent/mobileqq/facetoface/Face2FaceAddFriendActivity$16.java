package com.tencent.mobileqq.facetoface;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$16
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$16(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.U).putExtra("mgid", (byte)this.a.V);
    localIntent.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    this.a.startActivityForResult(localIntent, 100);
    ReportController.b(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.16
 * JD-Core Version:    0.7.0.1
 */