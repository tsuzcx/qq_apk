package com.tencent.mobileqq.vas.adv.qzone.api.impl;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvMetaMsg;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/adv/qzone/api/impl/VasQZoneApiImpl$getRequestAdvBizCallback$1", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "onError", "", "code", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "", "e", "", "onSucceed", "rsp", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasQZoneApiImpl$getRequestAdvBizCallback$1
  implements VasAdvBizCallback<vac_adv_get.VacAdvRsp>
{
  VasQZoneApiImpl$getRequestAdvBizCallback$1(VasAdMetaCallback paramVasAdMetaCallback) {}
  
  public void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramVasAdvServiceCode, "code");
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.b.onGetAdInfoResponse(paramVasAdvServiceCode, paramString, null);
  }
  
  public void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramVacAdvRsp, "rsp");
    try
    {
      List localList = (List)new ArrayList();
      paramVacAdvRsp = paramVacAdvRsp.vac_adv_msgs.get();
      if ((paramVacAdvRsp != null) && (paramVacAdvRsp.size() > 0))
      {
        paramVacAdvRsp = paramVacAdvRsp.iterator();
        while (paramVacAdvRsp.hasNext())
        {
          AlumBasicData localAlumBasicData = AlumBasicData.createFromPb((vac_adv_get.VacAdvMetaMsg)paramVacAdvRsp.next());
          Intrinsics.checkExpressionValueIsNotNull(localAlumBasicData, "AlumBasicData.createFromPb(sigleMsg)");
          localList.add(localAlumBasicData);
        }
        paramVacAdvRsp = VasQZoneApiImpl.access$getCurrentCallback$p(this.a);
        if (paramVacAdvRsp != null)
        {
          paramVacAdvRsp = (VasAdMetaCallback)paramVacAdvRsp.get();
          if (paramVacAdvRsp != null)
          {
            paramVacAdvRsp.onGetAdInfoResponse(VasAdvServiceCode.SUCCEED, null, (AlumBasicData)localList.get(0));
            QZLog.i("VasQZoneApiImpl", "requestAdvASync success");
            return;
          }
        }
        paramVacAdvRsp = (1)this;
        QZLog.i("VasQZoneApiImpl", "requestAdvASync fail, alumBasicDataList is null");
        return;
      }
      QZLog.i("VasQZoneApiImpl", "requestAdvASync fail, advMetaMsg is null");
      return;
    }
    catch (Exception paramVacAdvRsp)
    {
      QZLog.e("VasQZoneApiImpl", "requestAdvASync error", (Throwable)paramVacAdvRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.api.impl.VasQZoneApiImpl.getRequestAdvBizCallback.1
 * JD-Core Version:    0.7.0.1
 */