package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.emoticon.IVasEmojiManager;
import com.tencent.mobileqq.emoticon.VasEmojiManager;
import com.tencent.mobileqq.emoticon.api.IVasEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;

public class VasEmojiManagerServiceImpl
  implements IVasEmojiManagerService
{
  public IVasEmojiManager createVasEmojiManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return new VasEmojiManager(paramBaseQQAppInterface);
  }
  
  public boolean emoticonPkgNeedUpdate(int paramInt1, int paramInt2)
  {
    return EmoticonPanelUtils.a(paramInt1, paramInt2);
  }
  
  public boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    if (paramIEmoticonMainPanelApp == null) {
      return false;
    }
    int i = ((SVIPHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
    if (paramInt == 4)
    {
      if (i != 1) {
        return i == 3;
      }
      return true;
    }
    if (paramInt == 5) {
      return i == 3;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.VasEmojiManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */