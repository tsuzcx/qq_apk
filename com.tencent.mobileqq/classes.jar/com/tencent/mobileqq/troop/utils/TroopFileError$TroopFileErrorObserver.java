package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class TroopFileError$TroopFileErrorObserver
  extends BizTroopObserver
{
  private WeakReference<Context> a;
  int b = 0;
  private long c;
  private QQAppInterface d;
  private TroopFileError.TroopFileErrorFilter e;
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, long paramLong, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramContext);
    this.c = paramLong;
    this.d = paramQQAppInterface;
    this.b = 0;
  }
  
  public TroopFileError$TroopFileErrorObserver(Context paramContext, TroopFileError.TroopFileErrorFilter paramTroopFileErrorFilter, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramContext);
    this.e = paramTroopFileErrorFilter;
    this.d = paramQQAppInterface;
    this.b = 0;
  }
  
  protected void b(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof TroopFileError.SimpleErrorInfo)) {
        return;
      }
      paramObject = (TroopFileError.SimpleErrorInfo)paramObject;
      Context localContext = (Context)this.a.get();
      long l2 = this.c;
      long l1 = l2;
      if (l2 == 0L)
      {
        TroopFileError.TroopFileErrorFilter localTroopFileErrorFilter = this.e;
        l1 = l2;
        if (localTroopFileErrorFilter != null) {
          l1 = localTroopFileErrorFilter.a();
        }
      }
      if (localContext != null) {
        TroopFileError.a(paramObject, l1, this.d, localContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver
 * JD-Core Version:    0.7.0.1
 */