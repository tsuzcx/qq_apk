package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class StudyModeConfigProcessor$StudyModeConfigBean
{
  public int a;
  public boolean a;
  
  public static StudyModeConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    StudyModeConfigBean localStudyModeConfigBean = new StudyModeConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfQConfItem.length)
      {
        Object localObject = paramArrayOfQConfItem[i].a;
        try
        {
          localStudyModeConfigBean.jdField_a_of_type_Int = new JSONObject((String)localObject).optInt("ConfigEnableStudyMode");
          localStudyModeConfigBean.jdField_a_of_type_Boolean = true;
          StudyModeManager.c(a(localStudyModeConfigBean));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[study mode config], mGraySwitch:");
          ((StringBuilder)localObject).append(localStudyModeConfigBean.jdField_a_of_type_Int);
          QLog.i("StudyModeConfigProcessor", 1, ((StringBuilder)localObject).toString());
        }
        catch (Throwable localThrowable)
        {
          QLog.e("StudyModeConfigProcessor", 1, localThrowable, new Object[0]);
        }
        i += 1;
      }
    }
    return localStudyModeConfigBean;
  }
  
  public static boolean a(StudyModeConfigBean paramStudyModeConfigBean)
  {
    return paramStudyModeConfigBean.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeConfigProcessor.StudyModeConfigBean
 * JD-Core Version:    0.7.0.1
 */