package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.UniBusinessItem;
import QC.UniCheckReq;
import QC.UniCheckRsp;
import android.content.Context;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.JceProtocol;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/TroopNickAuthRequest;", "Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/IAuthRequest;", "()V", "localAuth", "", "authType", "", "requestAuth", "", "appId", "itemId", "feeType", "listener", "Lcom/tencent/mobileqq/vas/troopnick/shop/adapter/AuthRequest$AuthListener;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopNickAuthRequest
  implements IAuthRequest
{
  public static final TroopNickAuthRequest.Companion a = new TroopNickAuthRequest.Companion(null);
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext)
  {
    a.a(paramContext);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable AuthRequest.AuthListener paramAuthListener)
  {
    if ((a(paramInt3)) && (paramAuthListener != null))
    {
      paramAuthListener.a(true, null);
      return;
    }
    JceProtocol localJceProtocol = new JceProtocol("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.uniCheck", "stReq", "rsp");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new UniBusinessItem(paramInt1, paramInt2, ""));
    localJceProtocol.a("uniCheck", (JceStruct)new UniCheckReq(JceProtocol.a(), localArrayList), (JceStruct)new UniCheckRsp(), (BusinessObserver)new TroopNickAuthRequest.requestAuth.1(paramAuthListener), false);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    localObject = (QQAppInterface)localObject;
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
      return true;
    case 4: 
      return VipUtils.c((QQAppInterface)localObject);
    case 5: 
      return VipUtils.b((QQAppInterface)localObject);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickAuthRequest
 * JD-Core Version:    0.7.0.1
 */