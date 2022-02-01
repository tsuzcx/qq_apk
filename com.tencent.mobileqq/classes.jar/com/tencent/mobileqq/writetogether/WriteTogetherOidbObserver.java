package com.tencent.mobileqq.writetogether;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.writetogether.data.CreateDocParam;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherOidbObserver
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, CreateDocParam paramCreateDocParam)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramCreateDocParam.a);
    QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
    WTConstants.f = paramCreateDocParam.a;
  }
  
  public void a(int paramInt, boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (!paramBoolean) {
      QLog.d("WriteTogetherOidbObserver", 4, "isSuccess: false");
    }
    if (paramOpenDocParam != null)
    {
      QLog.d("WriteTogetherOidbObserver", 4, paramOpenDocParam.toString());
      return;
    }
    QLog.d("WriteTogetherOidbObserver", 4, "param is null");
  }
  
  public void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramObject);
    QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            a(paramInt, paramBoolean, (Object[])paramObject);
            return;
          }
          a(paramBoolean, paramObject);
          return;
        }
        if ((paramObject instanceof OpenDocParam))
        {
          a(paramInt, paramBoolean, (OpenDocParam)paramObject);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("data is not OpenDocParam: ");
        localStringBuilder.append(paramObject);
        QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
        return;
      }
      if ((paramObject instanceof CreateDocParam))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive pad id: ");
        paramObject = (CreateDocParam)paramObject;
        localStringBuilder.append(paramObject.a);
        QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
        a(paramInt, paramBoolean, paramObject);
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("data is not String: ");
      localStringBuilder.append(paramObject);
      QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("error. isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", data: ");
    localStringBuilder.append(paramObject);
    QLog.d("WriteTogetherOidbObserver", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver
 * JD-Core Version:    0.7.0.1
 */