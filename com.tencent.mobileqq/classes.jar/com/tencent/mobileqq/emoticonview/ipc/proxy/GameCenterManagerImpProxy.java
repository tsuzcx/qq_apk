package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class GameCenterManagerImpProxy
  extends AbsManagerProxy
{
  public static final String ACTION_GAMECENTERMANAGERIMP_CHECKNEWFLAGBYPATH = "gamecentermanagerimp_checknewflagbypath";
  private static final String CHECK_NEWFLAG = "checkNewFlag";
  private static final String PARAM_PATH = "param_path";
  public static final String TAG = "GameCenterManagerImpProxy";
  
  public GameCenterManagerImpProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, ((IEmosmService)QRoute.api(IEmosmService.class)).getManagerID("GAMECENTER_MANAGER"));
  }
  
  public static EIPCResult onCheckNewFlagByPath(BaseQQAppInterface paramBaseQQAppInterface, String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = ((IEmosmService)QRoute.api(IEmosmService.class)).checkNewFlagByPath(paramBaseQQAppInterface, paramBundle.getString("param_path"));
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("checkNewFlag", paramInt);
    return EIPCResult.createSuccessResult(paramBaseQQAppInterface);
  }
  
  public int checkNewFlagByPath(String paramString)
  {
    if (this.manager != null) {
      return ((IEmosmService)QRoute.api(IEmosmService.class)).checkNewFlagByPath(this.mApp, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.GameCenterManagerImpProxy
 * JD-Core Version:    0.7.0.1
 */