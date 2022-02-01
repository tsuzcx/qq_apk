package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class FontManagerProxy
  extends AbsEmoRuntimeServiceProxy<IFontManagerService>
{
  public static final String ACTION_FONTMANAGER_ISSUPPORTFONT = "fontmanager_issupportfont";
  private static final String SUPPORT_FONT = "SupportFont";
  public static final String TAG = "FontManagerProxy";
  
  public FontManagerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IFontManagerService.class);
  }
  
  public static EIPCResult onIsSupportFont(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((IFontManagerService)paramBaseQQAppInterface.getRuntimeService(IFontManagerService.class)).isSupportFont();
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putBoolean("SupportFont", bool);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public boolean isSupportFont()
  {
    if (this.manager != null) {
      return ((IFontManagerService)this.mApp.getRuntimeService(IFontManagerService.class)).isSupportFont();
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "fontmanager_issupportfont", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("SupportFont");
    }
    QLog.e("FontManagerProxy", 4, "isSupportFont fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy
 * JD-Core Version:    0.7.0.1
 */