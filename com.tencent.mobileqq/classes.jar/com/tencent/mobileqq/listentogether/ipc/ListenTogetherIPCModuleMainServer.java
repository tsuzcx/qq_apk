package com.tencent.mobileqq.listentogether.ipc;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import eipc.EIPCResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListenTogetherIPCModuleMainServer
  extends QIPCModule
{
  private ListenTogetherIPCModuleMainServer()
  {
    super("ListenTogetherIPCModuleMainServer");
  }
  
  public static ListenTogetherIPCModuleMainServer a()
  {
    return ListenTogetherIPCModuleMainServer.Holder.a();
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_status_changed".equals(paramString))
    {
      if (paramBundle == null) {
        return null;
      }
      paramBundle = paramBundle.getString("data");
      Object localObject;
      try
      {
        paramBundle = new JSONObject(paramBundle);
      }
      catch (JSONException paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("statusChanged error:");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.i("ListenTogetherIPCModuleMainServer", 1, ((StringBuilder)localObject).toString());
        paramBundle = null;
      }
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } else {
        localObject = null;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("statusChanged action:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" data=");
        localStringBuilder.append(paramBundle);
        localStringBuilder.append(" app:");
        localStringBuilder.append(localObject);
        QLog.d("ListenTogetherIPCModuleMainServer", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (paramBundle != null))
      {
        ((ListenTogetherManager)((QQAppInterface)localObject).getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(paramBundle);
        paramString = new EIPCResult();
        paramString.code = 0;
        return paramString;
      }
    }
    return null;
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    boolean bool = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callWebClientStatusChanged data:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append("  isToolRunning:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ListenTogetherIPCModuleMainServer", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("data", paramJSONObject.toString());
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "ListenTogetherIPCModuleWebClient", "action_status_changed", (Bundle)localObject, null);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall, params=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(", action=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", callBackId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ListenTogetherIPCModuleMainServer", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall, param is null, action=");
      paramBundle.append(paramString);
      paramBundle.append(", callBackId=");
      paramBundle.append(paramInt);
      QLog.d("ListenTogetherIPCModuleMainServer", 1, paramBundle.toString());
      return null;
    }
    if ("action_status_changed".equals(paramString)) {
      return a(paramString, paramBundle, paramInt);
    }
    boolean bool2 = "isOpener".equals(paramString);
    int i = 0;
    boolean bool1 = false;
    if (bool2)
    {
      paramString = new Bundle();
      paramString.putBoolean("result", AIOMusicSkin.a().b());
      paramString = EIPCResult.createResult(0, paramString);
      if (paramInt > 0)
      {
        callbackResult(paramInt, paramString);
        return null;
      }
    }
    else if ("isShowAtmosphere".equals(paramString))
    {
      try
      {
        paramString = new JSONObject(paramBundle.getString("data")).optString("uin");
        paramBundle = new Bundle();
        if (AIOMusicSkin.a().b()) {
          break label661;
        }
        if (!AIOMusicSkin.a().a(paramString)) {
          break label655;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_IS_SHOW_ATMOSPHERE: ", paramString);
        return null;
      }
      paramBundle.putBoolean("result", bool1);
      paramString = EIPCResult.createResult(0, paramBundle);
      if (paramInt > 0)
      {
        callbackResult(paramInt, paramString);
        return null;
      }
    }
    else
    {
      if ("setPlayerId".equals(paramString)) {
        try
        {
          paramInt = new JSONObject(paramBundle.getString("data")).optInt("id");
          FloatViewSkin.a().a(paramInt);
          return null;
        }
        catch (JSONException paramString)
        {
          QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_SET_PLAYERID: ", paramString);
          return null;
        }
      }
      if ("setThemeEnabled".equals(paramString)) {
        try
        {
          paramBundle = new JSONObject(paramBundle.getString("data"));
          paramString = paramBundle.optString("uin");
          paramInt = paramBundle.optInt("id");
          paramBundle = AIOMusicSkin.a();
          if (paramInt == 1) {
            bool1 = true;
          }
          paramBundle.a(paramString, bool1);
          return null;
        }
        catch (JSONException paramString)
        {
          QLog.e("ListenTogetherIPCModuleMainServer", 1, "METHOD_SET_THEME_ENABLED: ", paramString);
          return null;
        }
      }
      if ("showFloatView".equals(paramString)) {
        try
        {
          paramBundle = new JSONObject(paramBundle.getString("data"));
          paramString = paramBundle.optString("uin");
          paramBundle = paramBundle.optString("coverUrl");
          ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.1(this, paramString, paramBundle));
          return null;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return null;
        }
      }
      if ("pauseFloatView".equals(paramString))
      {
        ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.2(this));
        return null;
      }
      if (!"changeMusicList".equals(paramString)) {}
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramBundle.getString("data"));
        int j = paramString.optInt("playType");
        int k = paramString.optInt("index");
        paramString = paramString.getJSONArray("songList");
        paramBundle = new SongInfo[paramString.length()];
        paramInt = i;
        if (paramInt < paramString.length())
        {
          localObject = (SongInfo)((IQzoneMusicHelper)QRoute.api(IQzoneMusicHelper.class)).convertSongInfo(paramString.getJSONObject(paramInt));
          if (((SongInfo)localObject).a != 0L) {
            break label667;
          }
          ((SongInfo)localObject).a = paramInt;
          break label667;
        }
        QQPlayerService.a(paramBundle, j, k);
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      if ("stopMusicBox".equals(paramString)) {
        ThreadManagerV2.getUIHandlerV2().post(new ListenTogetherIPCModuleMainServer.3(this));
      }
      return null;
      label655:
      bool1 = false;
      break;
      label661:
      bool1 = true;
      break;
      label667:
      paramBundle[paramInt] = localObject;
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer
 * JD-Core Version:    0.7.0.1
 */