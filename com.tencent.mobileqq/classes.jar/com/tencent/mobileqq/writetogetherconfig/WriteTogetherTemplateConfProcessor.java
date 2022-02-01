package com.tencent.mobileqq.writetogetherconfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;
import mqq.app.AppRuntime;

public class WriteTogetherTemplateConfProcessor
  extends IQConfigProcessor<WriteTogetherTemplateConfBean>
{
  private static String a = "$time$";
  private static String b = "...";
  
  private static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return i + "年" + (j + 1) + "月" + k + "日";
  }
  
  private static String a(String paramString)
  {
    String str = a();
    return paramString.replace(a, str);
  }
  
  public static String a(String paramString, int paramInt)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (j < arrayOfChar.length)
      {
        int k = Character.codePointAt(arrayOfChar, j);
        if ((k < 0) || (k > 255)) {
          break label80;
        }
        i += 1;
      }
      while (i > paramInt)
      {
        str = paramString.substring(0, j) + b;
        return str;
        label80:
        i += 2;
      }
      j += 1;
    }
  }
  
  public static int[] a(WriteTogetherTemplateConfBean paramWriteTogetherTemplateConfBean, long paramLong)
  {
    WriteTogetherTemplateConfBean.TemplateBean[] arrayOfTemplateBean = paramWriteTogetherTemplateConfBean.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$TemplateBean;
    int k = arrayOfTemplateBean.length;
    int i = 0;
    paramWriteTogetherTemplateConfBean = new int[0];
    for (;;)
    {
      Object localObject = paramWriteTogetherTemplateConfBean;
      long[] arrayOfLong;
      int m;
      int j;
      if (i < k)
      {
        localObject = arrayOfTemplateBean[i];
        arrayOfLong = ((WriteTogetherTemplateConfBean.TemplateBean)localObject).jdField_a_of_type_ArrayOfLong;
        m = arrayOfLong.length;
        j = 0;
      }
      while (j < m)
      {
        long l = arrayOfLong[j];
        if (l == paramLong)
        {
          localObject = ((WriteTogetherTemplateConfBean.TemplateBean)localObject).jdField_a_of_type_ArrayOfInt;
          return localObject;
        }
        if (l == -1L) {
          paramWriteTogetherTemplateConfBean = ((WriteTogetherTemplateConfBean.TemplateBean)localObject).jdField_a_of_type_ArrayOfInt;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static WriteTogetherTemplateConfBean.Template[] a(long paramLong)
  {
    WriteTogetherTemplateConfBean localWriteTogetherTemplateConfBean = (WriteTogetherTemplateConfBean)QConfigManager.a().a(680);
    if ((localWriteTogetherTemplateConfBean == null) || (localWriteTogetherTemplateConfBean.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template.length == 0) || (localWriteTogetherTemplateConfBean.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$TemplateBean.length == 0))
    {
      QLog.d("WriteTogetherTemplateConfProcessor", 1, "getTemplateList: no config" + localWriteTogetherTemplateConfBean);
      return null;
    }
    int[] arrayOfInt = a(localWriteTogetherTemplateConfBean, paramLong);
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = new WriteTogetherTemplateConfBean.Template[arrayOfInt.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      WriteTogetherTemplateConfBean.Template localTemplate = localWriteTogetherTemplateConfBean.jdField_a_of_type_ArrayOfComTencentMobileqqWritetogetherconfigWriteTogetherTemplateConfBean$Template[(arrayOfInt[i] - 1)];
      localTemplate.b = a(localTemplate.b);
      localTemplate.a = a(localTemplate.a, 16);
      arrayOfTemplate[i] = localTemplate;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 2, "getTemplateList: " + Arrays.toString(arrayOfTemplate));
    }
    return arrayOfTemplate;
  }
  
  public static WriteTogetherTemplateConfBean.Template[] a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null) {
      return a(WriteTogetherUtils.a(paramAppRuntime, paramString));
    }
    return null;
  }
  
  @NonNull
  public WriteTogetherTemplateConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new WriteTogetherTemplateConfBean();
  }
  
  @Nullable
  public WriteTogetherTemplateConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherTemplateConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return WriteTogetherTemplateConfBean.a(paramArrayOfQConfItem[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 2, "onParsed no config");
    }
    return null;
  }
  
  public void a(WriteTogetherTemplateConfBean paramWriteTogetherTemplateConfBean) {}
  
  public Class<WriteTogetherTemplateConfBean> clazz()
  {
    return WriteTogetherTemplateConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 680;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfProcessor
 * JD-Core Version:    0.7.0.1
 */