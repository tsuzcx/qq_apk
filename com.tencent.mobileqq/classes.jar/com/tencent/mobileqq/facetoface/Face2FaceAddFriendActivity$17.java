package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$17
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$17(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (NetworkUtil.isNetSupport(this.b))
    {
      long l = System.currentTimeMillis();
      if ((l - this.b.A < Face2FaceAddFriendActivity.y) && (l > this.b.A))
      {
        if (QLog.isColorLevel()) {
          QLog.e(Face2FaceAddFriendActivity.a, 2, "click too offen,please try again later ");
        }
      }
      else
      {
        localObject = this.b;
        ((Face2FaceAddFriendActivity)localObject).A = l;
        Face2FaceAddFriendActivity.b((Face2FaceAddFriendActivity)localObject, this.a);
        this.b.P.f();
        ReportController.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 1, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = this.b.getResources().getString(2131889124);
      QQToast.makeText(this.b, 0, (CharSequence)localObject, 0).show(this.b.getTitleBarHeight());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.17
 * JD-Core Version:    0.7.0.1
 */