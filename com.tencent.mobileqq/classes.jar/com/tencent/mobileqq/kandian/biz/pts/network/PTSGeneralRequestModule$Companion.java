package com.tencent.mobileqq.kandian.biz.pts.network;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/network/PTSGeneralRequestModule$Companion;", "", "()V", "CMD_PTS_REQUEST_DATA", "", "KEY_PTS_APP_INSTANCE_ID", "SERVICE_TYPE_DEFAULT", "", "TAG", "requestPtsBusinessData", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "businessType", "requestParamsJson", "extendInfoJson", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSGeneralRequestModule$Companion
{
  public final void a(@Nullable PTSComposer paramPTSComposer, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    if (paramPTSComposer == null)
    {
      paramPTSComposer = new StringBuilder();
      paramPTSComposer.append("[requestPtsBusinessData] ptsComposer is null, businessType = ");
      paramPTSComposer.append(paramInt);
      QLog.i("PTSGeneralRequestModule", 1, paramPTSComposer.toString());
      return;
    }
    Object localObject = ReadInJoyUtils.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null)
          {
            if (paramString1 == null) {
              paramString1 = "";
            }
            if (paramString2 == null) {
              paramString2 = "";
            }
            ((PTSGeneralRequestModule)localObject).a(paramPTSComposer, paramInt, paramString1, paramString2);
          }
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule.Companion
 * JD-Core Version:    0.7.0.1
 */