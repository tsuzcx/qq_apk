package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d;
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
    TbsCoreLoadStat.TbsSequenceQueue localTbsSequenceQueue = this.a;
    if (localTbsSequenceQueue != null) {
      localTbsSequenceQueue.clear();
    }
    this.b = false;
  }
  
  void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(paramInt);
    TbsLog.e("loaderror", paramContext.toString());
  }
  
  void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    try
    {
      if (mLoadErrorCode == -1)
      {
        mLoadErrorCode = paramInt;
        TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
        if (paramThrowable != null)
        {
          TbsLogReport.getInstance(paramContext).setLoadErrorCode(paramInt, paramThrowable);
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("setLoadErrorCode :: error is null with errorCode: ");
          paramContext.append(paramInt);
          paramContext.append("; Check & correct it!");
          TbsLog.e("TbsCoreLoadStat", paramContext.toString());
        }
        return;
      }
      paramContext = new StringBuilder("setLoadErrorCode :: error(");
      paramContext.append(mLoadErrorCode);
      paramContext.append(") was already reported; ");
      paramContext.append(paramInt);
      paramContext.append(" is duplicated. Try to remove it!");
      TbsLog.w("TbsCoreLoadStat", paramContext.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreLoadStat
 * JD-Core Version:    0.7.0.1
 */