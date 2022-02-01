package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import eipc.EIPCResult;
import java.io.Serializable;

public class FavEmoRoamingHandlerProxy
  extends AbsHandlerProxy<FavEmoRoamingHandler>
{
  public static final String ACTION_FAVEMOROAMINGHANDLER_NOTIFYUI = "favhandler_notifyui";
  private static final String PARAM_DATA = "param_data";
  private static final String PARAM_SUCCESS = "param_success";
  private static final String PARAM_TYPE = "param_type";
  public static final String TAG = "FavEmoRoamingHandlerProxy";
  
  public FavEmoRoamingHandlerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
  }
  
  public static EIPCResult onNotifyUI(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((FavEmoRoamingHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER)).notifyUI(paramBundle.getInt("param_type"), paramBundle.getBoolean("param_success"), paramBundle.getSerializable("param_data"));
    return null;
  }
  
  public final void notifyUI(int paramInt, boolean paramBoolean, Serializable paramSerializable)
  {
    if (this.businessHandler != null) {
      ((FavEmoRoamingHandler)this.businessHandler).notifyUI(paramInt, paramBoolean, paramSerializable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy
 * JD-Core Version:    0.7.0.1
 */