package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticonview.IQQMessageFacadeProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class QQMessageFacadeProxy
  extends AbsManagerProxy<QQMessageFacade>
  implements IQQMessageFacadeProxy
{
  public static final String ACTION_QQMESSAGEFACADE_CURRCHATUIN = "qqmessagefacade_currchatuin";
  public static final String ACTION_QQMESSAGEFACADE_GETCURRCHATTYPE = "qqmessagefacade_getcurrchattype";
  private static final String CURR_CHAT_TYPE = "currchat_type";
  private static final String CURR_CHAT_UIN = "currchat_uin";
  public static final String TAG = "QQMessageFacadeProxy";
  
  public QQMessageFacadeProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.MGR_MSG_FACADE);
  }
  
  public static EIPCResult onGetCurrChatType(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = paramQQAppInterface.getMessageFacade().a();
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("currchat_type", paramInt);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public static EIPCResult onGetCurrChatUin(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a();
    paramString = new Bundle();
    paramString.putString("currchat_uin", paramQQAppInterface);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public int getCurrChatType()
  {
    if (this.manager != null) {
      return ((QQMessageFacade)this.manager).a();
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
      return ((QQMessageFacade)this.manager).a();
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