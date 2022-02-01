package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVasEmojiManagerService
  extends QRouteApi
{
  public abstract IVasEmojiManager createVasEmojiManager(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean emoticonPkgNeedUpdate(int paramInt1, int paramInt2);
  
  public abstract boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService
 * JD-Core Version:    0.7.0.1
 */