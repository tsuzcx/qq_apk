package com.tencent.mobileqq.ptt;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.wstt.SSCM.SSCM;

public class PttSSCM
  extends SSCM
{
  protected int a(long paramLong)
  {
    if (!this.a)
    {
      int i = this.b;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              this.c = 4096;
            } else {
              this.c = 32768;
            }
          }
          else {
            this.c = 16384;
          }
        }
        else {
          this.c = 8192;
        }
      }
      else {
        this.c = 32768;
      }
    }
    if (paramLong < 102400L) {
      this.c *= 4;
    }
    if (paramLong - this.c <= this.c / 2) {
      this.c = ((int)paramLong);
    }
    return this.c;
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.b = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    return a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttSSCM
 * JD-Core Version:    0.7.0.1
 */