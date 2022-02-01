package com.tencent.mobileqq.tofumsg;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tofumsg.handlers.AskAnonymouslyHandler;
import com.tencent.mobileqq.tofumsg.handlers.BaseProfileDataHandler;
import com.tencent.mobileqq.tofumsg.handlers.IntimateAnniversaryDataHandler;
import com.tencent.mobileqq.tofumsg.handlers.NewFrdMiniCardHandler;
import com.tencent.mobileqq.tofumsg.handlers.NicePicsDataHandler;

public class TofuDataHandlerFactory
{
  QQAppInterface a;
  SparseArray<ITofuDataHandler> b;
  
  TofuDataHandlerFactory(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new SparseArray(TofuConst.a.length);
  }
  
  ITofuDataHandler a(int paramInt)
  {
    Object localObject = (ITofuDataHandler)this.b.get(paramInt);
    if (localObject != null) {
      return localObject;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              localObject = new AskAnonymouslyHandler(this.a);
            }
          }
          else {
            localObject = new NewFrdMiniCardHandler(this.a);
          }
        }
        else {
          localObject = new NicePicsDataHandler(this.a);
        }
      }
      else {
        localObject = new BaseProfileDataHandler(this.a);
      }
    }
    else {
      localObject = new IntimateAnniversaryDataHandler(this.a);
    }
    if ((this.b.get(paramInt) == null) && (localObject != null)) {
      synchronized (this.b)
      {
        if (this.b.get(paramInt) == null) {
          this.b.put(paramInt, localObject);
        } else {
          localObject = (ITofuDataHandler)this.b.get(paramInt);
        }
        return localObject;
      }
    }
    return localITofuDataHandler;
  }
  
  void a()
  {
    int i;
    synchronized (this.b)
    {
      int j = this.b.size();
      i = 0;
      if (i < j)
      {
        ITofuDataHandler localITofuDataHandler = (ITofuDataHandler)this.b.valueAt(i);
        if (localITofuDataHandler != null) {
          localITofuDataHandler.b();
        }
      }
      else
      {
        this.b.clear();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuDataHandlerFactory
 * JD-Core Version:    0.7.0.1
 */