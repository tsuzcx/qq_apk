package com.tencent.mobileqq.dov.edit.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.dov.edit.api.IStartDovEditPic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class StartDovEditPicImpl
  implements IStartDovEditPic
{
  public static final String TAG = "StartDovEditPicImpl";
  
  public void enterCropActivity(Activity paramActivity, String paramString)
  {
    if ((paramActivity != null) && (!TextUtils.isEmpty(paramString)))
    {
      Intent localIntent = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(paramActivity, paramString, false, false, false, true, false, 2, 99, 9);
      localIntent.putExtra("babyq_ability", 2L);
      localIntent.putExtra("qq_sub_business_id", 103);
      paramActivity.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("StartDovEditPicImpl", 2, String.format("enterCropActivity, path: %s", new Object[] { paramString }));
      }
      ReportController.b(null, "dc00898", "", "", "0X80082DB", "0X80082DB", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("StartDovEditPicImpl", 2, "enterCropActivity error, picture path is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.edit.api.impl.StartDovEditPicImpl
 * JD-Core Version:    0.7.0.1
 */