package com.tencent.mobileqq.richstatus;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler.RspGetHistorySig;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class SignatureHistoryFragment$MySignatureObserver
  extends SignatureObserver
{
  private SignatureHistoryFragment$MySignatureObserver(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void d(boolean paramBoolean, Object arg2)
  {
    int i = 0;
    Object localObject1;
    Object localObject3;
    if (paramBoolean)
    {
      ??? = (Bundle)???;
      paramBoolean = ???.getBoolean("firstFlag", false);
      localObject1 = ???.getString("feedid");
      boolean bool = ???.getBoolean("overFlag", true);
      localObject3 = ???.getStringArrayList("uins");
      SignatureHistoryFragment.a(this.a).put(localObject1, Boolean.valueOf(bool));
      ??? = (ArrayList)SignatureHistoryFragment.b(this.a).get(localObject1);
      if (localObject3 != null) {}
    }
    else
    {
      return;
    }
    SignatureHistoryFragment.b(this.a).put(localObject1, ???);
    for (;;)
    {
      RichStatus localRichStatus;
      synchronized (SignatureHistoryFragment.b(this.a))
      {
        if (i >= SignatureHistoryFragment.b(this.a).size()) {
          break label246;
        }
        localRichStatus = ((HistorySignItem)SignatureHistoryFragment.b(this.a).get(i)).richStatus;
        if (!localRichStatus.feedsId.equals(localObject1)) {
          break label299;
        }
        if (paramBoolean) {
          localRichStatus.mUins = null;
        }
        if (localRichStatus.mUins != null)
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label246;
          }
          localObject3 = (String)((Iterator)localObject1).next();
          if (localRichStatus.mUins.contains(localObject3)) {
            continue;
          }
          localRichStatus.mUins.add(localObject3);
        }
      }
      localRichStatus.mUins = ((List)localObject3);
      label246:
      if (SignatureHistoryFragment.a(this.a) != null)
      {
        SignatureHistoryFragment.a(this.a).removeMessages(1);
        Message localMessage = SignatureHistoryFragment.a(this.a).obtainMessage(1);
        SignatureHistoryFragment.a(this.a).sendMessageDelayed(localMessage, 500L);
      }
      return;
      label299:
      i += 1;
    }
  }
  
  public void g(boolean paramBoolean, Object paramObject)
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
  
  public void h(boolean paramBoolean, Object paramObject)
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
        SignatureHistoryFragment.a(this.a, SignatureHistoryFragment.a(this.a));
        SignatureHistoryFragment.a(this.a, null);
        if (SignatureHistoryFragment.a(this.a) != null) {
          SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
        }
      }
      return;
    }
    paramObject = SignatureHistoryFragment.a(this.a).obtainMessage();
    paramObject.what = 4;
    paramObject.arg1 = 1;
    SignatureHistoryFragment.a(this.a).sendMessage(paramObject);
  }
  
  public void i(boolean paramBoolean, Object paramObject)
  {
    if ((SignatureHistoryFragment.a(this.a) != null) && (SignatureHistoryFragment.a(this.a).isShowing())) {
      SignatureHistoryFragment.a(this.a).dismiss();
    }
    if (paramBoolean)
    {
      paramBoolean = SignatureHistoryFragment.a(this.a, SignatureHistoryFragment.a(this.a));
      SignatureHistoryFragment.a(this.a, null);
      if ((SignatureHistoryFragment.a(this.a) != null) && (paramBoolean)) {
        SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
      }
      return;
    }
    paramObject = SignatureHistoryFragment.a(this.a).obtainMessage();
    paramObject.what = 4;
    paramObject.arg1 = 2;
    SignatureHistoryFragment.a(this.a).sendMessage(paramObject);
  }
  
  public void j(boolean paramBoolean, Object paramObject)
  {
    SignatureHistoryFragment.c(this.a, paramBoolean);
    int i;
    if (paramBoolean)
    {
      paramObject = (SignatureHandler.RspGetHistorySig)paramObject;
      if ((this.a.getActivity() != null) && (this.a.getActivity().app != null)) {
        this.a.getActivity().app.setVisibilityForStatus(true, true);
      }
      if ((paramObject != null) && (paramObject.historySignItems != null))
      {
        boolean bool = paramObject.over;
        paramObject = paramObject.historySignItems;
        if ((SignatureHistoryFragment.c(this.a)) && (SignatureHistoryFragment.b(this.a).size() > 0)) {
          SignatureHistoryFragment.b(this.a).clear();
        }
        if (SignatureHistoryFragment.b(this.a).size() > 0)
        {
          Iterator localIterator = paramObject.iterator();
          RichStatus localRichStatus1 = ((HistorySignItem)SignatureHistoryFragment.b(this.a).get(SignatureHistoryFragment.b(this.a).size() - 1)).richStatus;
          if (localRichStatus1 != null) {
            while (localIterator.hasNext())
            {
              RichStatus localRichStatus2 = ((HistorySignItem)localIterator.next()).richStatus;
              if ((localRichStatus2.time <= localRichStatus1.time) && ((localRichStatus2.time != localRichStatus1.time) || (!Arrays.equals(localRichStatus2.encode(), localRichStatus1.encode())))) {
                break;
              }
              localIterator.remove();
            }
          }
        }
        SignatureHistoryFragment.b(this.a).addAll(SignatureHistoryFragment.b(this.a).size(), paramObject);
        paramObject = this.a;
        if (!bool)
        {
          i = 1;
          SignatureHistoryFragment.a(paramObject, i);
        }
      }
      else
      {
        label285:
        if (SignatureHistoryFragment.b(this.a).size() != 0) {
          break label367;
        }
        paramObject = this.a;
        if (!paramBoolean) {
          break label362;
        }
        i = 3;
        label309:
        SignatureHistoryFragment.a(paramObject, i);
      }
    }
    for (;;)
    {
      if (SignatureHistoryFragment.a(this.a) != null) {
        SignatureHistoryFragment.a(this.a).notifyDataSetChanged();
      }
      return;
      i = 0;
      break;
      if (!SignatureHistoryFragment.c(this.a)) {
        break label285;
      }
      SignatureHistoryFragment.a(this.a, 3);
      break label285;
      label362:
      i = 2;
      break label309;
      label367:
      SignatureHistoryFragment.a(this.a).setVisible(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.MySignatureObserver
 * JD-Core Version:    0.7.0.1
 */