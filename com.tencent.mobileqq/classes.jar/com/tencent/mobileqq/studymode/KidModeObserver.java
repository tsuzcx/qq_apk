package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class KidModeObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 7)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("KidModeObserver", 1, new Object[] { "unknown type: ", Integer.valueOf(paramInt) });
                }
              }
              else {
                c(paramBoolean, paramBundle);
              }
            }
            else {
              d(paramBoolean, paramBundle);
            }
          }
          else {
            a(paramBoolean, paramBundle);
          }
        }
        else {
          b(paramBoolean, paramBundle);
        }
      }
      else {
        e(paramBoolean, paramBundle);
      }
    }
    else
    {
      paramInt = paramBundle.getInt("advance_setting_field");
      paramBundle.getInt("advance_setting_value");
      a(paramBoolean, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeObserver
 * JD-Core Version:    0.7.0.1
 */