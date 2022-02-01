package com.tencent.mobileqq.richstatus;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.SignatureHandler.RspGetHistorySig;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class SignatureHistoryFragment$MySignatureObserver
  extends SignatureObserver
{
  private SignatureHistoryFragment$MySignatureObserver(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  protected void d(boolean paramBoolean, Object arg2)
  {
    int i;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      ??? = (Bundle)???;
      i = 0;
      paramBoolean = ???.getBoolean("firstFlag", false);
      localObject1 = ???.getString("feedid");
      boolean bool = ???.getBoolean("overFlag", true);
      localObject3 = ???.getStringArrayList("uins");
      SignatureHistoryFragment.p(this.a).put(localObject1, Boolean.valueOf(bool));
      ??? = (ArrayList)SignatureHistoryFragment.q(this.a).get(localObject1);
      if (localObject3 == null) {
        return;
      }
      SignatureHistoryFragment.q(this.a).put(localObject1, ???);
    }
    for (;;)
    {
      synchronized (SignatureHistoryFragment.g(this.a))
      {
        if (i < SignatureHistoryFragment.g(this.a).size())
        {
          RichStatus localRichStatus = ((HistorySignItem)SignatureHistoryFragment.g(this.a).get(i)).richStatus;
          if (!localRichStatus.feedsId.equals(localObject1)) {
            break label303;
          }
          if (paramBoolean) {
            localRichStatus.mUins = null;
          }
          if (localRichStatus.mUins != null)
          {
            localObject1 = ((ArrayList)localObject3).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (String)((Iterator)localObject1).next();
              if (localRichStatus.mUins.contains(localObject3)) {
                continue;
              }
              localRichStatus.mUins.add(localObject3);
              continue;
            }
          }
          else
          {
            localRichStatus.mUins = ((List)localObject3);
          }
        }
        if (SignatureHistoryFragment.d(this.a) != null)
        {
          SignatureHistoryFragment.d(this.a).removeMessages(1);
          localObject1 = SignatureHistoryFragment.d(this.a).obtainMessage(1);
          SignatureHistoryFragment.d(this.a).sendMessageDelayed((Message)localObject1, 500L);
        }
        return;
      }
      return;
      label303:
      i += 1;
    }
  }
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if (SignatureHistoryFragment.d(this.a) != null)
    {
      SignatureHistoryFragment.d(this.a).removeMessages(3);
      paramObject = SignatureHistoryFragment.d(this.a).obtainMessage(3);
      paramObject.arg1 = i;
      SignatureHistoryFragment.d(this.a).sendMessageDelayed(paramObject, 500L);
    }
  }
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    if ((SignatureHistoryFragment.e(this.a) != null) && (SignatureHistoryFragment.e(this.a).isShowing())) {
      SignatureHistoryFragment.e(this.a).dismiss();
    }
    if (paramBoolean)
    {
      long l = ((Long)paramObject).longValue();
      if (SignatureHistoryFragment.n(this.a) != null)
      {
        SignatureHistoryFragment.n(this.a).id = l;
        SignatureHistoryFragment.n(this.a).timeStamp = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
        paramObject = this.a;
        SignatureHistoryFragment.c(paramObject, SignatureHistoryFragment.n(paramObject));
        SignatureHistoryFragment.a(this.a, null);
        if (SignatureHistoryFragment.t(this.a) != null) {
          SignatureHistoryFragment.t(this.a).notifyDataSetChanged();
        }
      }
    }
    else
    {
      paramObject = SignatureHistoryFragment.d(this.a).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 1;
      SignatureHistoryFragment.d(this.a).sendMessage(paramObject);
    }
  }
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    if ((SignatureHistoryFragment.e(this.a) != null) && (SignatureHistoryFragment.e(this.a).isShowing())) {
      SignatureHistoryFragment.e(this.a).dismiss();
    }
    if (paramBoolean)
    {
      paramObject = this.a;
      paramBoolean = SignatureHistoryFragment.b(paramObject, SignatureHistoryFragment.n(paramObject));
      SignatureHistoryFragment.a(this.a, null);
      if ((SignatureHistoryFragment.t(this.a) != null) && (paramBoolean)) {
        SignatureHistoryFragment.t(this.a).notifyDataSetChanged();
      }
    }
    else
    {
      paramObject = SignatureHistoryFragment.d(this.a).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 2;
      SignatureHistoryFragment.d(this.a).sendMessage(paramObject);
    }
  }
  
  protected void j(boolean paramBoolean, Object paramObject)
  {
    SignatureHistoryFragment.d(this.a, paramBoolean);
    int i = 3;
    if (paramBoolean) {
      SignatureHistoryFragment.a(this.a, (SignatureHandler.RspGetHistorySig)paramObject);
    } else if (SignatureHistoryFragment.r(this.a)) {
      SignatureHistoryFragment.a(this.a, 3);
    }
    if (SignatureHistoryFragment.g(this.a).size() == 0)
    {
      paramObject = this.a;
      if (!paramBoolean) {
        i = 2;
      }
      SignatureHistoryFragment.b(paramObject, i);
    }
    else
    {
      SignatureHistoryFragment.s(this.a).setVisible(false, false);
    }
    if (SignatureHistoryFragment.t(this.a) != null) {
      SignatureHistoryFragment.t(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.MySignatureObserver
 * JD-Core Version:    0.7.0.1
 */