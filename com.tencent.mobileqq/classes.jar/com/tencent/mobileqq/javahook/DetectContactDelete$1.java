package com.tencent.mobileqq.javahook;

import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

final class DetectContactDelete$1
  implements HookMethodCallback
{
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = paramMethodHookParam.args;
    int i = 0;
    paramMethodHookParam = ((Uri)paramMethodHookParam[0]).toString();
    if ((paramMethodHookParam.contains(ContactsContract.RawContacts.CONTENT_URI.toString())) || (paramMethodHookParam.contains(ContactsContract.Data.CONTENT_URI.toString())))
    {
      paramMethodHookParam = new StringBuilder(1000);
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      while (i < arrayOfStackTraceElement.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfStackTraceElement[i]);
        localStringBuilder.append("-");
        paramMethodHookParam.append(localStringBuilder.toString());
        i += 1;
      }
      QLog.d("ContactDelete", 1, paramMethodHookParam.toString());
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.DetectContactDelete.1
 * JD-Core Version:    0.7.0.1
 */