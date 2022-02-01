package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public final class StudyModePushConfigProcessor$StudyModePushConfigBean
{
  public String a;
  public ArrayList<Integer> a;
  
  public StudyModePushConfigProcessor$StudyModePushConfigBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static StudyModePushConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    StudyModePushConfigBean localStudyModePushConfigBean = new StudyModePushConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfQConfItem.length) {
          break label187;
        }
        String str = paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString;
        try
        {
          str = new JSONObject(str).optString("black_ids");
          ArrayList localArrayList = new ArrayList();
          if (!TextUtils.isEmpty(str))
          {
            String[] arrayOfString = str.split(",");
            int k = arrayOfString.length;
            int j = 0;
            while (j < k)
            {
              localArrayList.add(Integer.valueOf(Integer.parseInt(arrayOfString[j].trim())));
              j += 1;
            }
            localStudyModePushConfigBean.jdField_a_of_type_JavaLangString = str;
            localStudyModePushConfigBean.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.i("StudyModePushConfigProcessor", 2, "[study mode push config], :" + str);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("StudyModePushConfigProcessor", 1, localThrowable, new Object[0]);
          }
        }
        i += 1;
      }
    }
    label187:
    return localStudyModePushConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModePushConfigProcessor.StudyModePushConfigBean
 * JD-Core Version:    0.7.0.1
 */