package com.tencent.mobileqq.emoticonview.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommercialDrainageManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.DownloaderFactoryProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.VipComicMqqManagerProxy;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.widget.XPanelContainer;
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
  
  /* Error */
  public static EmoticonMainPanelIpcModule getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 30	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 30	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule
    //   21: dup
    //   22: invokespecial 32	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule:<init>	()V
    //   25: putstatic 30	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 30	com/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule:mInstance	Lcom/tencent/mobileqq/emoticonview/ipc/EmoticonMainPanelIpcModule;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localEmoticonMainPanelIpcModule	EmoticonMainPanelIpcModule
    //   40	5	0	localObject1	java.lang.Object
    //   46	5	0	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
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
    EIPCResult localEIPCResult = CommercialDrainageManagerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = CommonUsedSystemEmojiManagerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = DownloaderFactoryProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmojiManagerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmoticonHandlerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    localEIPCResult = EmoticonManagerProxy.checkMatch(localAppRuntime, paramString, paramBundle, paramInt);
    if (localEIPCResult != null) {
      return localEIPCResult;
    }
    if ("favhandler_notifyui".equals(paramString)) {
      return FavEmoRoamingHandlerProxy.onNotifyUI((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("fontmanager_issupportfont".equals(paramString)) {
      return FontManagerProxy.onIsSupportFont((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("gamecentermanagerimp_checknewflagbypath".equals(paramString)) {
      return GameCenterManagerImpProxy.onCheckNewFlagByPath((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("sendtotarget".equals(paramString)) {
      return MqqHandlerProxy.onSendToTarget((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("redtouchmanager_onredtouchitemclick".equals(paramString)) {
      return RedTouchManagerProxy.onOnRedTouchItemClick((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("redtouchmanager_getappinfobypath".equals(paramString)) {
      return RedTouchManagerProxy.onGetAppInfoNewFlagByPath((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("svip_viptype".equals(paramString)) {
      return SVIPHandlerProxy.onGetCurrentUserVipType((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("vipcomicm_favoremoticons".equals(paramString)) {
      return VipComicMqqHandlerProxy.onGetMyComicFavorEmotIcons((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("vipcomicm_uploadinitcomiceinfo".equals(paramString)) {
      return VipComicMqqManagerProxy.onUploadInitComicEmoStructMsgInfo((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("qqmessagefacade_getcurrchattype".equals(paramString)) {
      return QQMessageFacadeProxy.onGetCurrChatType((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("qqmessagefacade_currchatuin".equals(paramString)) {
      return QQMessageFacadeProxy.onGetCurrChatUin((QQAppInterface)localAppRuntime, paramString, paramBundle, paramInt);
    }
    if ("externalpanel_height".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putInt("height", XPanelContainer.a);
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
  
  public void postChildIPCBundle(Bundle paramBundle)
  {
    if (!QQEmoticonMainPanelApp.isMainProcess()) {}
    while ((TextUtils.isEmpty(this.processName)) || (this.processName.equals(MobileQQ.processName))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule
 * JD-Core Version:    0.7.0.1
 */