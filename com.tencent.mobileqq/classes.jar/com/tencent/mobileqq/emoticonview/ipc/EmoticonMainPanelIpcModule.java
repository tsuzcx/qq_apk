package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerServiceProxy;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EmoticonMainPanelIpcModule
  extends QIPCModule
{
  public static final String ACTION_EXTERNALPANEL_HEIGHT = "externalpanel_height";
  public static final String HEIGHT = "height";
  public static final String NAME = "module_emoticon_mainpanel";
  public static final String TAG = "EmoticonMainPanelIpcModule";
  public static EmoticonMainPanelIpcModule mInstance;
  public String processName;
  
  public EmoticonMainPanelIpcModule()
  {
    super("module_emoticon_mainpanel");
  }
  
  public static EmoticonMainPanelIpcModule getInstance()
  {
    try
    {
      if (mInstance == null) {
        try
        {
          if (mInstance == null) {
            mInstance = new EmoticonMainPanelIpcModule();
          }
        }
        finally {}
      }
      EmoticonMainPanelIpcModule localEmoticonMainPanelIpcModule = mInstance;
      return localEmoticonMainPanelIpcModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!(localAppRuntime instanceof AppInterface)) {
      return EIPCResult.createResult(-105, null);
    }
    if (paramBundle != null) {
      paramBundle.setClassLoader(EmoticonPackage.class.getClassLoader());
    }
    if ("other_rigister_callback".equals(paramString))
    {
      this.processName = paramBundle.getString("process_name");
      return EIPCResult.createSuccessResult(null);
    }
    EIPCResult localEIPCResult = CommercialDrainageManagerServiceProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = CommonUsedSystemEmojiManagerServiceProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmojiManagerServiceProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmoticonHandlerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmoticonManagerServiceProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    if ("favhandler_notifyui".equals(paramString)) {
      return FavEmoRoamingHandlerProxy.onNotifyUI((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("fontmanager_issupportfont".equals(paramString)) {
      return FontManagerProxy.onIsSupportFont((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("gamecentermanagerimp_checknewflagbypath".equals(paramString)) {
      return GameCenterManagerImpProxy.onCheckNewFlagByPath((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("sendtotarget".equals(paramString)) {
      return MqqHandlerProxy.onSendToTarget((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("redtouchmanager_onredtouchitemclick".equals(paramString)) {
      return RedTouchManagerProxy.onOnRedTouchItemClick((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("redtouchmanager_getappinfobypath".equals(paramString)) {
      return RedTouchManagerProxy.onGetAppInfoNewFlagByPath((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("svip_viptype".equals(paramString)) {
      return SVIPHandlerProxy.onGetCurrentUserVipType((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("vipcomicm_favoremoticons".equals(paramString)) {
      return VipComicMqqHandlerProxy.onGetMyComicFavorEmotIcons((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("vipcomicm_uploadinitcomiceinfo".equals(paramString)) {
      return VipComicMqqManagerServiceProxy.onUploadInitComicEmoStructMsgInfo((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("qqmessagefacade_getcurrchattype".equals(paramString)) {
      return QQMessageFacadeProxy.onGetCurrChatType((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("qqmessagefacade_currchatuin".equals(paramString)) {
      return QQMessageFacadeProxy.onGetCurrChatUin((BaseQQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("externalpanel_height".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putInt("height", ((IEmosmService)QRoute.api(IEmosmService.class)).getExternalPanelheight());
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
  
  public void postChildIPCBundle(Bundle paramBundle)
  {
    if (!EmotionUtils.a()) {
      return;
    }
    if (!TextUtils.isEmpty(this.processName))
    {
      if (this.processName.equals(MobileQQ.processName)) {
        return;
      }
      if (!QIPCServerHelper.getInstance().isProcessRunning(this.processName))
      {
        this.processName = null;
        return;
      }
      QIPCServerHelper.getInstance().callClient(this.processName, "module_emoticon_child_mainpanel", "other_process_callback", paramBundle, new EmoticonMainPanelIpcModule.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule
 * JD-Core Version:    0.7.0.1
 */