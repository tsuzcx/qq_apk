package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.ILogAdapter;

public class ViolaLogAdapter
  implements ILogAdapter
{
  public void callLog(String paramString1, int paramInt, String paramString2)
  {
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (QLog.isColorLevel()) {
            QLog.d(paramString1, 2, paramString2);
          }
        }
        else {
          QLog.e(paramString1, 2, paramString2);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.w(paramString1, 2, paramString2);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void onJSError(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaLogAdapter
 * JD-Core Version:    0.7.0.1
 */