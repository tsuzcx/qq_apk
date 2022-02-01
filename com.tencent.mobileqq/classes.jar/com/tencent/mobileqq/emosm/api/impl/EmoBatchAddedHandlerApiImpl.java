package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;

public class EmoBatchAddedHandlerApiImpl
  implements IEmoBatchAddedHandlerApi
{
  public IEmoBatchAddedCallback createEmoBatchAddedCallback(BaseQQAppInterface paramBaseQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, int paramInt)
  {
    return new EmoBatchAddedCallback(paramBaseQQAppInterface, (EmoBatchAddedHandler)paramIEmoBatchAddedHandler, paramInt);
  }
  
  public IEmoBatchAddedHandler createEmoBatchAddedHandler(IChatHistoryEmotionBaseFragment paramIChatHistoryEmotionBaseFragment, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return new EmoBatchAddedHandler(paramIChatHistoryEmotionBaseFragment, paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoBatchAddedHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */