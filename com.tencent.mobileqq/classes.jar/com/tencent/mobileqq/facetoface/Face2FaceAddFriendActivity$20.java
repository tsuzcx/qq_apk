package com.tencent.mobileqq.facetoface;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Face2FaceAddFriendActivity$20
  implements View.OnClickListener
{
  Face2FaceAddFriendActivity$20(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (NetworkUtil.isNetSupport(this.b))
    {
      Face2FaceAddFriendActivity.c(this.b, this.a);
      this.b.P.f();
      localObject = Face2FaceAddFriendActivity.a(this.b).obtainMessage();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = 2;
      ((Message)localObject).obj = this.a;
      Face2FaceAddFriendActivity.a(this.b).sendMessage((Message)localObject);
      ReportController.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
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
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.20
 * JD-Core Version:    0.7.0.1
 */