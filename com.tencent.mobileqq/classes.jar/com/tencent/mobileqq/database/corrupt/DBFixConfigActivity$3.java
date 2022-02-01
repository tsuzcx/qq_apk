package com.tencent.mobileqq.database.corrupt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class DBFixConfigActivity$3
  implements View.OnClickListener
{
  DBFixConfigActivity$3(DBFixConfigActivity paramDBFixConfigActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(".db");
    localObject1 = ((DBFixConfigActivity)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getExternalCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".db");
    boolean bool = FileUtils.copyFile((File)localObject1, new File((File)localObject2, localStringBuilder.toString()));
    localObject1 = DBFixConfigActivity.jdField_a_of_type_JavaLangString;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("copy ");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.3
 * JD-Core Version:    0.7.0.1
 */