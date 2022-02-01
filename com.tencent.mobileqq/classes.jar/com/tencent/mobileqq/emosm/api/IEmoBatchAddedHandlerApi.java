package com.tencent.mobileqq.emosm.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoBatchAddedHandlerApi
  extends QRouteApi
{
  public abstract IEmoBatchAddedCallback createEmoBatchAddedCallback(BaseQQAppInterface paramBaseQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, int paramInt);
  
  public abstract IEmoBatchAddedHandler createEmoBatchAddedHandler(IChatHistoryEmotionBaseFragment paramIChatHistoryEmotionBaseFragment, BaseQQAppInterface paramBaseQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi
 * JD-Core Version:    0.7.0.1
 */