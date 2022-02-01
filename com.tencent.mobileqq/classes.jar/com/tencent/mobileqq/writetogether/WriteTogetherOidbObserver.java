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
    QLog.d("WriteTogetherOidbObserver", 4, "type:" + paramInt + ", isSuccess: " + paramBoolean + ", data: " + paramCreateDocParam.a);
    WTConstants.d = paramCreateDocParam.a;
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
    QLog.d("WriteTogetherOidbObserver", 4, "type: " + paramInt + ", isSuccess: " + paramBoolean + ", data: " + paramObject);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if ((paramObject instanceof CreateDocParam))
      {
        QLog.d("WriteTogetherOidbObserver", 4, "receive pad id: " + ((CreateDocParam)paramObject).a);
        a(paramInt, paramBoolean, (CreateDocParam)paramObject);
        return;
      }
      QLog.d("WriteTogetherOidbObserver", 4, "data is not String: " + paramObject);
      return;
    case 2: 
      if ((paramObject instanceof OpenDocParam))
      {
        a(paramInt, paramBoolean, (OpenDocParam)paramObject);
        return;
      }
      QLog.d("WriteTogetherOidbObserver", 4, "data is not OpenDocParam: " + paramObject);
      return;
    case 3: 
      a(paramBoolean, paramObject);
      return;
    case 4: 
      a(paramInt, paramBoolean, (Object[])paramObject);
      return;
    }
    QLog.d("WriteTogetherOidbObserver", 4, "error. isSuccess: " + paramBoolean + ", data: " + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver
 * JD-Core Version:    0.7.0.1
 */