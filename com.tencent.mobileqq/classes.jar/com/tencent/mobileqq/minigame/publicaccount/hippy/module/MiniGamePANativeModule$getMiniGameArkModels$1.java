package com.tencent.mobileqq.minigame.publicaccount.hippy.module;

import android.os.Bundle;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k=3, mv={1, 1, 16})
final class MiniGamePANativeModule$getMiniGameArkModels$1
  implements EIPCResultCallback
{
  MiniGamePANativeModule$getMiniGameArkModels$1(Promise paramPromise) {}
  
  public final void onCallback(EIPCResult paramEIPCResult)
  {
    Object localObject2 = (String)null;
    Object localObject1 = localObject2;
    if (paramEIPCResult != null)
    {
      localObject1 = localObject2;
      if (paramEIPCResult.code == 0)
      {
        localObject2 = new JSONArray();
        localObject1 = paramEIPCResult.data.getSerializable("key_msg_list");
        paramEIPCResult = (EIPCResult)localObject1;
        if (!(localObject1 instanceof List)) {
          paramEIPCResult = null;
        }
        paramEIPCResult = (List)paramEIPCResult;
        if (paramEIPCResult != null)
        {
          paramEIPCResult = (Iterable)paramEIPCResult;
          localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramEIPCResult, 10));
          Iterator localIterator1 = paramEIPCResult.iterator();
          while (localIterator1.hasNext())
          {
            paramEIPCResult = (QQGameMsgInfo)localIterator1.next();
            JSONObject localJSONObject = new JSONObject(paramEIPCResult.arkMetaList);
            long l = new JSONObject(paramEIPCResult.arkAppConfig).optLong("ctime", -1L);
            if (l != -1L)
            {
              Iterator localIterator2 = ((Iterable)CollectionsKt.listOf(new String[] { "xmodal", "qqgame_model" })).iterator();
              while (localIterator2.hasNext())
              {
                paramEIPCResult = localIterator2.next();
                if (localJSONObject.has((String)paramEIPCResult)) {
                  break label222;
                }
              }
              paramEIPCResult = null;
              label222:
              paramEIPCResult = (String)paramEIPCResult;
              if (paramEIPCResult != null)
              {
                paramEIPCResult = localJSONObject.optJSONObject(paramEIPCResult);
                if (paramEIPCResult != null) {
                  paramEIPCResult.put("msgTime", l);
                }
              }
            }
            ((Collection)localObject1).add(localJSONObject);
          }
          paramEIPCResult = ((Iterable)localObject1).iterator();
          while (paramEIPCResult.hasNext()) {
            ((JSONArray)localObject2).put((JSONObject)paramEIPCResult.next());
          }
        }
        paramEIPCResult = ((JSONArray)localObject2).toString();
        localObject1 = paramEIPCResult;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getMiniGameArkModels models=");
          ((StringBuilder)localObject1).append(paramEIPCResult);
          QLog.i("MiniGamePANativeModule", 2, ((StringBuilder)localObject1).toString());
          localObject1 = paramEIPCResult;
        }
      }
    }
    this.$promise.resolve(localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule.getMiniGameArkModels.1
 * JD-Core Version:    0.7.0.1
 */