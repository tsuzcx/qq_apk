package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.util.Pair;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.QueryTask.Query;
import com.tencent.mobileqq.persistence.EntityManager;

class EmoticonManagerProxy$1
  implements QueryTask.Query<Pair<String, Integer>, EmoticonPackage>
{
  EmoticonManagerProxy$1(EmoticonManagerProxy paramEmoticonManagerProxy, String paramString, int paramInt) {}
  
  public EmoticonPackage query(Pair<String, Integer> paramPair)
  {
    paramPair = (EmoticonPackage)this.this$0.em.find(EmoticonPackage.class, this.val$epId);
    if ((paramPair == null) || (this.val$businessType == -1)) {}
    do
    {
      do
      {
        return paramPair;
        if (this.val$businessType != 0) {
          break;
        }
      } while (paramPair.aio);
      return null;
    } while ((this.val$businessType != 1) || (paramPair.kandian));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy.1
 * JD-Core Version:    0.7.0.1
 */