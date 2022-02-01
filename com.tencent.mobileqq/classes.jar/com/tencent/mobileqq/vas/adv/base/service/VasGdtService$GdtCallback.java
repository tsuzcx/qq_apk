package com.tencent.mobileqq.vas.adv.base.service;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$GdtCallback;", "", "onAdGetRsp", "", "rsp", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface VasGdtService$GdtCallback
{
  public abstract void a(@Nullable qq_ad_get.QQAdGetRsp paramQQAdGetRsp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.service.VasGdtService.GdtCallback
 * JD-Core Version:    0.7.0.1
 */