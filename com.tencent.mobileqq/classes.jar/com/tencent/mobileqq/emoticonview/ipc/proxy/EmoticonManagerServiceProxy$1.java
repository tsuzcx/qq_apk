package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManagerServiceProxy$1
  implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage>
{
  EmoticonManagerServiceProxy$1(EmoticonManagerServiceProxy paramEmoticonManagerServiceProxy, String paramString, int paramInt) {}
  
  public EmoticonPackage query(Pair<String, Integer> paramPair)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.this$0.em.find(EmoticonPackage.class, this.val$epId);
    paramPair = localEmoticonPackage;
    if (localEmoticonPackage != null)
    {
      int i = this.val$businessType;
      if (i == -1) {
        return localEmoticonPackage;
      }
      if (i == 0)
      {
        if (localEmoticonPackage.aio) {
          return localEmoticonPackage;
        }
        return null;
      }
      paramPair = localEmoticonPackage;
      if (i == 1)
      {
        if (localEmoticonPackage.kandian) {
          return localEmoticonPackage;
        }
        paramPair = null;
      }
    }
    return paramPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy.1
 * JD-Core Version:    0.7.0.1
 */