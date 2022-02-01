package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class FontManagerProxy
  extends AbsManagerProxy<FontManager>
{
  public static final String ACTION_FONTMANAGER_ISSUPPORTFONT = "fontmanager_issupportfont";
  private static final String SUPPORT_FONT = "SupportFont";
  public static final String TAG = "FontManagerProxy";
  
  public FontManagerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.CHAT_FONT_MANAGER);
  }
  
  public static EIPCResult onIsSupportFont(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = ((FontManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a;
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("SupportFont", bool);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public boolean isSupportFont()
  {
    if (this.manager != null) {
      return ((FontManager)this.manager).a;
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "fontmanager_issupportfont", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getBoolean("SupportFont");
    }
    QLog.e("FontManagerProxy", 4, "isSupportFont fail.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FontManagerProxy
 * JD-Core Version:    0.7.0.1
 */