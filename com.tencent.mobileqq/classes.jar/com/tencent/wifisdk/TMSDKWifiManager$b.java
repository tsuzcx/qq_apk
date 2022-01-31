package com.tencent.wifisdk;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import wf7.bn;
import wf7.fr;
import wf7.hj;
import wf7.hm;

class TMSDKWifiManager$b
  implements fr
{
  private TMSDKWifiManager$b(TMSDKWifiManager paramTMSDKWifiManager) {}
  
  public void onScanResult(@NonNull List<bn> paramList)
  {
    Iterator localIterator = TMSDKWifiManager.b(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiListUpdateListener)localIterator.next()).onScanResult(paramList);
    }
  }
  
  public void onUpdateFinish(int paramInt, @Nullable List<bn> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == 0) && (hj.a(paramList)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        bn localbn = (bn)paramList.next();
        if ((localbn != null) && (hm.d(localbn))) {
          localArrayList.add(hm.x(localbn));
        }
      }
    }
    paramList = TMSDKWifiManager.b(this.qs).iterator();
    while (paramList.hasNext()) {
      ((TMSDKWifiListUpdateListener)paramList.next()).onUpdateFinish(paramInt, localArrayList);
    }
  }
  
  public void onUpdateStart()
  {
    Iterator localIterator = TMSDKWifiManager.b(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiListUpdateListener)localIterator.next()).onUpdateStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKWifiManager.b
 * JD-Core Version:    0.7.0.1
 */