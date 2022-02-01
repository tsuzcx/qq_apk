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
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("年");
    ((StringBuilder)localObject).append(j + 1);
    ((StringBuilder)localObject).append("月");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append("日");
    return ((StringBuilder)localObject).toString();
  }
  
  private static String a(String paramString)
  {
    String str = a();
    return paramString.replace(a, str);
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString.toCharArray();
    int j = 0;
    int i = 0;
    while (j < localObject.length)
    {
      int k = Character.codePointAt((char[])localObject, j);
      if ((k >= 0) && (k <= 255)) {
        i += 1;
      } else {
        i += 2;
      }
      if (i > paramInt)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, j));
        ((StringBuilder)localObject).append(b);
        return ((StringBuilder)localObject).toString();
      }
      j += 1;
    }
    return paramString;
  }
  
  public static int[] a(WriteTogetherTemplateConfBean paramWriteTogetherTemplateConfBean, long paramLong)
  {
    WriteTogetherTemplateConfBean.TemplateBean[] arrayOfTemplateBean = paramWriteTogetherTemplateConfBean.a;
    int k = arrayOfTemplateBean.length;
    paramWriteTogetherTemplateConfBean = new int[0];
    int i = 0;
    while (i < k)
    {
      WriteTogetherTemplateConfBean.TemplateBean localTemplateBean = arrayOfTemplateBean[i];
      long[] arrayOfLong = localTemplateBean.a;
      int m = arrayOfLong.length;
      int j = 0;
      while (j < m)
      {
        long l = arrayOfLong[j];
        if (l == paramLong) {
          return localTemplateBean.b;
        }
        if (l == -1L) {
          paramWriteTogetherTemplateConfBean = localTemplateBean.b;
        }
        j += 1;
      }
      i += 1;
    }
    return paramWriteTogetherTemplateConfBean;
  }
  
  private static WriteTogetherTemplateConfBean.Template[] a(long paramLong)
  {
    Object localObject1 = (WriteTogetherTemplateConfBean)QConfigManager.b().b(680);
    if ((localObject1 != null) && (((WriteTogetherTemplateConfBean)localObject1).b.length != 0) && (((WriteTogetherTemplateConfBean)localObject1).a.length != 0))
    {
      int[] arrayOfInt = a((WriteTogetherTemplateConfBean)localObject1, paramLong);
      localObject2 = new WriteTogetherTemplateConfBean.Template[arrayOfInt.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        WriteTogetherTemplateConfBean.Template localTemplate = localObject1.b[(arrayOfInt[i] - 1)];
        localTemplate.c = a(localTemplate.c);
        localTemplate.b = a(localTemplate.b, 16);
        localObject2[i] = localTemplate;
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTemplateList: ");
        ((StringBuilder)localObject1).append(Arrays.toString((Object[])localObject2));
        QLog.d("WriteTogetherTemplateConfProcessor", 2, ((StringBuilder)localObject1).toString());
      }
      return localObject2;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getTemplateList: no config");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.d("WriteTogetherTemplateConfProcessor", 1, ((StringBuilder)localObject2).toString());
    return null;
  }
  
  public static WriteTogetherTemplateConfBean.Template[] a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime != null) {
      return a(WriteTogetherUtils.b(paramAppRuntime, paramString));
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("WriteTogetherTemplateConfProcessor", 2, localStringBuilder.toString());
      }
      return WriteTogetherTemplateConfBean.a(paramArrayOfQConfItem[0].b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfProcessor
 * JD-Core Version:    0.7.0.1
 */