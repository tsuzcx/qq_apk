package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class GameCenterManagerImpProxy
  extends AbsManagerProxy<GameCenterManagerImp>
{
  public static final String ACTION_GAMECENTERMANAGERIMP_CHECKNEWFLAGBYPATH = "gamecentermanagerimp_checknewflagbypath";
  private static final String CHECK_NEWFLAG = "checkNewFlag";
  private static final String PARAM_PATH = "param_path";
  public static final String TAG = "GameCenterManagerImpProxy";
  
  public GameCenterManagerImpProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, QQManagerFactory.GAMECENTER_MANAGER);
  }
  
  public static EIPCResult onCheckNewFlagByPath(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = ((GameCenterManagerImp)paramQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER)).a(paramBundle.getString("param_path"));
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("checkNewFlag", paramInt);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  public int checkNewFlagByPath(String paramString)
  {
    if (this.manager != null) {
      return ((GameCenterManagerImp)this.manager).a(paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("param_path", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("module_emoticon_mainpanel", "gamecentermanagerimp_checknewflagbypath", localBundle);
    if ((paramString != null) && (paramString.isSuccess())) {
      return paramString.data.getInt("checkNewFlag");
    }
    QLog.e("GameCenterManagerImpProxy", 4, "checkNewFlagByPath fail.");
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy
 * JD-Core Version:    0.7.0.1
 */