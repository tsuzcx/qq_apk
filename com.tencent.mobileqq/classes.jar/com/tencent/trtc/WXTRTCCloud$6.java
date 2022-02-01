package com.tencent.trtc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class WXTRTCCloud$6
  implements Runnable
{
  WXTRTCCloud$6(WXTRTCCloud paramWXTRTCCloud, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.a;
    Object localObject3;
    int i;
    Object localObject4;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
    {
      localObject3 = this.a;
      Collections.sort((List)localObject3, new WXTRTCCloud.6.1(this));
      localObject2 = new HashMap();
      localObject3 = ((ArrayList)localObject3).iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
        if (i >= 10) {
          break;
        }
        if (((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume > 10)
        {
          i += 1;
          ((HashMap)localObject2).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
          ((ArrayList)localObject1).add(localObject4);
        }
      }
      localObject3 = WXTRTCCloud.access$100(this.b).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!((HashMap)localObject2).containsKey(localObject4))
        {
          TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
          localTRTCVolumeInfo.userId = ((String)localObject4);
          localTRTCVolumeInfo.volume = 0;
          ((ArrayList)localObject1).add(localTRTCVolumeInfo);
        }
      }
      WXTRTCCloud.access$100(this.b).clear();
      WXTRTCCloud.access$100(this.b).putAll((Map)localObject2);
    }
    else if (WXTRTCCloud.access$100(this.b).size() > 0)
    {
      localObject2 = WXTRTCCloud.access$100(this.b).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = new TRTCCloudDef.TRTCVolumeInfo();
        ((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId = ((String)localObject3);
        ((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume = 0;
        ((ArrayList)localObject1).add(localObject4);
      }
      WXTRTCCloud.access$100(this.b).clear();
    }
    localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject2).next();
      localObject3 = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).userId;
      i = ((TRTCCloudDef.TRTCVolumeInfo)localObject1).volume;
      if (WXTRTCCloud.access$000(this.b).keySet().contains(localObject3))
      {
        localObject3 = (WXTRTCCloud.a)WXTRTCCloud.access$000(this.b).get(localObject3);
        if ((localObject3 != null) && (i != ((WXTRTCCloud.a)localObject3).a))
        {
          ((WXTRTCCloud.a)localObject3).a = i;
          localObject1 = null;
          if (((WXTRTCCloud.a)localObject3).b != null) {
            localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((WXTRTCCloud.a)localObject3).b.get();
          } else if (((WXTRTCCloud.a)localObject3).c != null) {
            localObject1 = (WXTRTCCloud.ITXAudioVolumeEvaluationListener)((WXTRTCCloud.a)localObject3).c.get();
          }
          if (localObject1 != null) {
            ((WXTRTCCloud.ITXAudioVolumeEvaluationListener)localObject1).onAudioVolumeEvaluationNotify(i);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.WXTRTCCloud.6
 * JD-Core Version:    0.7.0.1
 */