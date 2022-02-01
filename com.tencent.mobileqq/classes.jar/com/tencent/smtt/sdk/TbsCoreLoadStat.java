package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d = null;
  public static volatile int mLoadErrorCode = -1;
  private TbsCoreLoadStat.TbsSequenceQueue a = null;
  private boolean b = false;
  private final int c = 3;
  
  public static TbsCoreLoadStat getInstance()
  {
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    return d;
  }
  
  void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
    this.b = false;
  }
  
  void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    TbsLog.e("loaderror", "" + paramInt);
  }
  
  void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        if (mLoadErrorCode == -1)
        {
          mLoadErrorCode = paramInt;
          TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
          if (paramThrowable != null) {
            TbsLogReport.getInstance(paramContext).setLoadErrorCode(paramInt, paramThrowable);
          }
        }
        else
        {
          paramContext = new StringBuilder("setLoadErrorCode :: error(");
          paramContext.append(mLoadErrorCode);
          paramContext.append(") was already reported; ");
          paramContext.append(paramInt);
          paramContext.append(" is duplicated. Try to remove it!");
          TbsLog.w("TbsCoreLoadStat", paramContext.toString());
          continue;
        }
        TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + paramInt + "; Check & correct it!");
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */