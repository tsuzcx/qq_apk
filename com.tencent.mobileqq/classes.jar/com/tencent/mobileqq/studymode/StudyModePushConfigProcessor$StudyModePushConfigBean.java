package com.tencent.mobileqq.studymode;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

public final class StudyModePushConfigProcessor$StudyModePushConfigBean
{
  public String a = "";
  public ArrayList<Integer> b = new ArrayList();
  
  public static StudyModePushConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    StudyModePushConfigBean localStudyModePushConfigBean = new StudyModePushConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfQConfItem.length)
      {
        String str = paramArrayOfQConfItem[i].b;
        try
        {
          str = new JSONObject(str).optString("black_ids");
          Object localObject = new ArrayList();
          if (!TextUtils.isEmpty(str))
          {
            String[] arrayOfString = str.split(",");
            int k = arrayOfString.length;
            int j = 0;
            while (j < k)
            {
              ((ArrayList)localObject).add(Integer.valueOf(Integer.parseInt(arrayOfString[j].trim())));
              j += 1;
            }
            localStudyModePushConfigBean.a = str;
            localStudyModePushConfigBean.b.addAll((Collection)localObject);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[study mode push config], :");
            ((StringBuilder)localObject).append(str);
            QLog.i("StudyModePushConfigProcessor", 2, ((StringBuilder)localObject).toString());
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("StudyModePushConfigProcessor", 1, localThrowable, new Object[0]);
        }
        i += 1;
      }
    }
    return localStudyModePushConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModePushConfigProcessor.StudyModePushConfigBean
 * JD-Core Version:    0.7.0.1
 */