package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoticonFromGroupManagerService
  extends QRouteApi
{
  public abstract IEmoticonFromGroupManager createEmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IEmoticonFromGroupManagerService
 * JD-Core Version:    0.7.0.1
 */