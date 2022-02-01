package com.tencent.mobileqq.vas.adv.extfriend.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/extfriend/api/IVasAdExtendFriendApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDeviceInfoByteArray", "", "initDeviceInfo", "", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasAdExtendFriendApi
  extends QRouteApi
{
  @NotNull
  public abstract byte[] getDeviceInfoByteArray();
  
  public abstract void initDeviceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi
 * JD-Core Version:    0.7.0.1
 */