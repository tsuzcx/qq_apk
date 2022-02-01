package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class RedTouchManagerProxy
  extends AbsEmoRuntimeServiceProxy<IRedTouchManager>
{
  public static final String ACTION_REDTOUCHMANAGER_GETAPPINFOBYPATH = "redtouchmanager_getappinfobypath";
  public static final String ACTION_REDTOUCHMANAGER_ONREDTOUCHITEMCLICK = "redtouchmanager_onredtouchitemclick";
  private static final String INEWFLAG = "inewflag";
  private static final String PARAM_MYPATH = "param_mypath";
  public static final String TAG = "RedTouchManagerProxy";
  
  public RedTouchManagerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, IRedTouchManager.class);
  }
  
  public static EIPCResult onGetAppInfoNewFlagByPath(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBaseQQAppInterface = ((IRedTouchManager)paramBaseQQAppInterface.getRuntimeService(IRedTouchManager.class)).getAppInfoByPath(paramBundle.getString("param_mypath"));
    paramString = new Bundle();
    if (paramBaseQQAppInterface != null) {
      paramInt = paramBaseQQAppInterface.iNewFlag.get();
    } else {
      paramInt = 0;
    }
    paramString.putInt("inewflag", paramInt);
    return EIPCResult.createSuccessResult(paramString);
  }
  
  public static EIPCResult onOnRedTouchItemClick(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    ((IRedTouchManager)paramBaseQQAppInterface.getRuntimeService(IRedTouchManager.class)).onRedTouchItemClick(paramBundle.getString("param_mypath"));
    return EIPCResult.createSuccessResult(null);
  }
  
  public int getAppInfoNewFlagByPath(String paramString)
  {
    if (this.manager != null)
    {
      paramString = ((IRedTouchManager)this.manager).getAppInfoByPath(paramString);
      if (paramString != null) {
        return paramString.iNewFlag.get();
      }
      return 0;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_mypath", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "redtouchmanager_getappinfobypath", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getInt("inewflag");
    }
    QLog.e("RedTouchManagerProxy", 4, "getAppInfoNewFlagByPath fail.");
    return 0;
  }
  
  public void onRedTouchItemClick(String paramString)
  {
    if (this.manager != null)
    {
      ((IRedTouchManager)this.manager).onRedTouchItemClick(paramString);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_mypath", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "redtouchmanager_onredtouchitemclick", localBundle);
    if ((paramString != null) && (paramString.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchManagerProxy", 4, "onRedTouchItemClick suc.");
      }
    }
    else {
      QLog.e("RedTouchManagerProxy", 4, "onRedTouchItemClick fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.RedTouchManagerProxy
 * JD-Core Version:    0.7.0.1
 */