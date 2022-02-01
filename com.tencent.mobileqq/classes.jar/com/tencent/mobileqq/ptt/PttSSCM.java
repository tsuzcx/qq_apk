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
    if (!this.j)
    {
      int i = this.c;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              this.g = 4096;
            } else {
              this.g = 32768;
            }
          }
          else {
            this.g = 16384;
          }
        }
        else {
          this.g = 8192;
        }
      }
      else {
        this.g = 32768;
      }
    }
    if (paramLong < 102400L) {
      this.g *= 4;
    }
    if (paramLong - this.g <= this.g / 2) {
      this.g = ((int)paramLong);
    }
    return this.g;
  }
  
  public int a(Context paramContext, long paramLong)
  {
    this.c = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    return a(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttSSCM
 * JD-Core Version:    0.7.0.1
 */