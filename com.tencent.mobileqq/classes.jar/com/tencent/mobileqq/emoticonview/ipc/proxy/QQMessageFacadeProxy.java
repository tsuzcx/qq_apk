package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class QQMessageFacadeProxy
  extends AbsManagerProxy
  implements IQQMessageFacadeProxy
{
  public static final String ACTION_QQMESSAGEFACADE_CURRCHATUIN = "qqmessagefacade_currchatuin";
  public static final String ACTION_QQMESSAGEFACADE_GETCURRCHATTYPE = "qqmessagefacade_getcurrchattype";
  private static final String CURR_CHAT_TYPE = "currchat_type";
  private static final String CURR_CHAT_UIN = "currchat_uin";
  public static final String TAG = "QQMessageFacadeProxy";
  
  public QQMessageFacadeProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ((IEmosmService)QRoute.api(IEmosmService.class)).getManagerID("MGR_MSG_FACADE"));
  }
  
  public static EIPCResult onGetCurrChatType(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = ((IEmosmService)QRoute.api(IEmosmService.class)).getCurrChatType(paramBaseQQAppInterface);
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("currchat_type", paramInt);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public static EIPCResult onGetCurrChatUin(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = ((IEmosmService)QRoute.api(IEmosmService.class)).getCurrChatUin(paramBaseQQAppInterface);
    paramString = new Bundle();
    paramString.putString("currchat_uin", paramBaseQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public int getCurrChatType()
  {
    if (this.manager != null) {
      return ((IEmosmService)QRoute.api(IEmosmService.class)).getCurrChatType(this.mApp);
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "qqmessagefacade_getcurrchattype", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getInt("currchat_type");
    }
    QLog.e("QQMessageFacadeProxy", 4, "getCurrChatType fail.");
    return 0;
  }
  
  public String getCurrChatUin()
  {
    if (this.manager != null) {
      return ((IEmosmService)QRoute.api(IEmosmService.class)).getCurrChatUin(this.mApp);
    }
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "qqmessagefacade_currchatuin", null);
    if ((localEIPCResult != null) && (localEIPCResult.isSuccess())) {
      return localEIPCResult.data.getString("currchat_uin");
    }
    QLog.e("QQMessageFacadeProxy", 4, "getCurrChatType fail.");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.QQMessageFacadeProxy
 * JD-Core Version:    0.7.0.1
 */