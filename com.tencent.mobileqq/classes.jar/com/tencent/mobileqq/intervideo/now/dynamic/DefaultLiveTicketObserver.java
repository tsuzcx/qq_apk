package com.tencent.mobileqq.intervideo.now.dynamic;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DefaultLiveTicketObserver
  implements APICallback
{
  public void a()
  {
    QLog.i("DefaultLiveTicketObserver", 1, "DefaultLiveTicketObserver----request Doraemon onComplete");
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultLiveTicketObserver----request Doraemon onPermission, code = ");
    localStringBuilder.append(paramInt);
    QLog.i("DefaultLiveTicketObserver", 1, localStringBuilder.toString());
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DefaultLiveTicketObserver----request Doraemon failed, errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QLog.i("DefaultLiveTicketObserver", 1, localStringBuilder.toString());
  }
  
  public void a(JSONObject paramJSONObject)
  {
    QLog.i("DefaultLiveTicketObserver", 1, "DefaultLiveTicketObserver----request Doraemon success");
  }
  
  public void b(JSONObject paramJSONObject)
  {
    QLog.i("DefaultLiveTicketObserver", 1, "DefaultLiveTicketObserver----request Doraemon onTrigger");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DefaultLiveTicketObserver
 * JD-Core Version:    0.7.0.1
 */