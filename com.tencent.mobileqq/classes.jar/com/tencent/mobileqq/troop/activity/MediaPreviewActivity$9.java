package com.tencent.mobileqq.troop.activity;

import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MediaPreviewActivity$9
  extends AsyncTask<Void, Void, String>
{
  MediaPreviewActivity$9(MediaPreviewActivity paramMediaPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoPreviewActivity", 2, QLog.getStackTraceString(paramVarArgs));
      }
      paramVarArgs = null;
    }
    if (paramVarArgs != null)
    {
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, paramVarArgs);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131694913));
      localStringBuilder.append(" ");
      localStringBuilder.append(paramVarArgs);
      return localStringBuilder.toString();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getString(2131694911);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.9
 * JD-Core Version:    0.7.0.1
 */