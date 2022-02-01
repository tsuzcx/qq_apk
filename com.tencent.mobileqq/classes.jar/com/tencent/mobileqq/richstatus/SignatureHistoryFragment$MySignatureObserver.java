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
      SignatureHistoryFragment.a(this.a).put(localObject1, Boolean.valueOf(bool));
      ??? = (ArrayList)SignatureHistoryFragment.b(this.a).get(localObject1);
      if (localObject3 == null) {
        return;
      }
      SignatureHistoryFragment.b(this.a).put(localObject1, ???);
    }
    for (;;)
    {
      synchronized (SignatureHistoryFragment.a(this.a))
      {
        if (i < SignatureHistoryFragment.a(this.a).size())
        {
          RichStatus localRichStatus = ((HistorySignItem)SignatureHistoryFragment.a(this.a).get(i)).richStatus;
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
        if (SignatureHistoryFragment.a(this.a) != null)
        {
          SignatureHistoryFragment.a(this.a).removeMessages(1);
          localObject1 = SignatureHistoryFragment.a(this.a).obtainMessage(1);
          SignatureHistoryFragment.a(this.a).sendMessageDelayed((Message)localObject1, 500L);
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
    if (SignatureHistoryFragment.a(this.a) != null)
    {
      SignatureHistoryFragment.a(this.a).removeMessages(3);
      paramObject = SignatureHistoryFragment.a(this.a).obtainMessage(3);
      paramObject.arg1 = i;
      SignatureHistoryFragment.a(this.a).sendMessageDelayed(paramObject, 500L);
    }
  }
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    if ((SignatureHistoryFragment.a(this.a) != null) && (SignatureHistoryFragment.a(this.a).isShowing())) {
      SignatureHistoryFragment.a(this.a).dismiss();
    }
    if (paramBoolean)
    {
      long l = ((Long)paramObject).longValue();
      if (SignatureHistoryFragment.a(this.a) != null)
      {
        SignatureHistoryFragment.a(this.a).id = l;
        SignatureHistoryFragment.a(this.a).timeStamp = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
        paramObject = this.a;
        SignatureHistoryFragment.a(paramObject, SignatureHistoryFragment.a(paramObject));
        SignatureHistoryFragment.a(this.a, null);
        if (SignatureHistoryFragment.a(this.a) != null) {
          SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
        }
      }
    }
    else
    {
      paramObject = SignatureHistoryFragment.a(this.a).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 1;
      SignatureHistoryFragment.a(this.a).sendMessage(paramObject);
    }
  }
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    if ((SignatureHistoryFragment.a(this.a) != null) && (SignatureHistoryFragment.a(this.a).isShowing())) {
      SignatureHistoryFragment.a(this.a).dismiss();
    }
    if (paramBoolean)
    {
      paramObject = this.a;
      paramBoolean = SignatureHistoryFragment.a(paramObject, SignatureHistoryFragment.a(paramObject));
      SignatureHistoryFragment.a(this.a, null);
      if ((SignatureHistoryFragment.a(this.a) != null) && (paramBoolean)) {
        SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
      }
    }
    else
    {
      paramObject = SignatureHistoryFragment.a(this.a).obtainMessage();
      paramObject.what = 4;
      paramObject.arg1 = 2;
      SignatureHistoryFragment.a(this.a).sendMessage(paramObject);
    }
  }
  
  protected void j(boolean paramBoolean, Object paramObject)
  {
    SignatureHistoryFragment.c(this.a, paramBoolean);
    int i = 3;
    if (paramBoolean) {
      SignatureHistoryFragment.a(this.a, (SignatureHandler.RspGetHistorySig)paramObject);
    } else if (SignatureHistoryFragment.c(this.a)) {
      SignatureHistoryFragment.a(this.a, 3);
    }
    if (SignatureHistoryFragment.a(this.a).size() == 0)
    {
      paramObject = this.a;
      if (!paramBoolean) {
        i = 2;
      }
      SignatureHistoryFragment.a(paramObject, i);
    }
    else
    {
      SignatureHistoryFragment.a(this.a).setVisible(false, false);
    }
    if (SignatureHistoryFragment.a(this.a) != null) {
      SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.MySignatureObserver
 * JD-Core Version:    0.7.0.1
 */