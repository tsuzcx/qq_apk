package cooperation.ilive.manager;

import NS_KING_PUBLIC.stAuth;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThreeDes;
import common.config.service.QzoneConfig;
import cooperation.ilive.pb.QQALive.GetOpenInfoReq;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;
import cooperation.ilive.servlet.IliveAuthServlet;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class IliveAuthManager
{
  public static final long AUTH_EXPIRATION_DATE = 6000000L;
  public static final int AUTH_TYPE_QQ_OPEN_ID = 1;
  public static final String KEY_QQ_CONNECT_ACCESS_TOKEN = "key_qq_ilive_connect_access_token";
  public static final String KEY_QQ_CONNECT_AUTH_TIME = "key_qq_ilive_connect_auth_time";
  public static final String KEY_QQ_CONNECT_OPEN_ID = "key_qq_ilive_connect_open_id";
  private static final String TAG = "IliveAuthManager";
  private static IliveAuthManager mInstance = null;
  private Map<String, IliveAuthManager.QQConnectData> mCache = new HashMap();
  private List<WeakReference<IliveAuthManager.Callback>> mWeakCallBackList = null;
  
  private IliveAuthManager()
  {
    syncQQConnectDataFromSP();
  }
  
  public static AppRuntime getAppRuntime()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  private IliveAuthManager.QQConnectData getCurrentAccountMemoryData()
  {
    if (this.mCache != null) {
      return (IliveAuthManager.QQConnectData)this.mCache.get(getStringUin());
    }
    return null;
  }
  
  public static IliveAuthManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new IliveAuthManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static long getLongUin()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  private long getQQAuthTime()
  {
    long l = QzoneConfig.getInstance().getConfig("qqLive", "qqAuthTime", 6000000L);
    QLog.i("IliveAuthManager", 1, "getQQAuthTime time = " + l);
    return l;
  }
  
  public static String getStringUin()
  {
    Object localObject = getAppRuntime();
    if (localObject != null)
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    return "";
  }
  
  private void sendQQAuthRequest()
  {
    if (IlivePluginManager.getInstance().getPluginCallback() != null) {
      IlivePluginManager.getInstance().getPluginCallback().onPluginLoginStart();
    }
    TimeMonitorManager.a().a("AUTH_PROCESS").a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QQALive.GetOpenInfoReq localGetOpenInfoReq = new QQALive.GetOpenInfoReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), IliveAuthServlet.class);
    localNewIntent.putExtra("data", WupUtil.a(localGetOpenInfoReq.toByteArray()));
    localNewIntent.putExtra("cmd", "qqvalivelogin.GetOpenInfo");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private boolean syncQQConnectDataFromSP()
  {
    boolean bool = true;
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      try
      {
        String str1 = getStringUin();
        try
        {
          localObject3 = Long.valueOf(Long.parseLong(str1));
          localObject2 = this.mCache.get(str1);
          if (localObject2 == null) {
            continue;
          }
        }
        catch (Exception localException)
        {
          QLog.e("IliveAuthManager", 1, "parse uin error ");
          bool = false;
          continue;
          localObject2 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_open_id", "", ((Long)localObject3).longValue());
          localObject3 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_access_token", "", ((Long)localObject3).longValue());
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label218;
          }
        }
        return bool;
      }
      finally {}
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        String str2 = ThreeDes.b((String)localObject2, getStringUin());
        String str3 = ThreeDes.b((String)localObject3, getStringUin());
        QLog.d("IliveAuthManager", 1, "use sp openId and accessToken encrypted:" + (String)localObject2 + " , " + (String)localObject3 + ", decrypt:" + str2 + " , " + str3);
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          this.mCache.put(localException, new IliveAuthManager.QQConnectData(str2, str3));
        }
      }
      else
      {
        label218:
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  public stAuth getLocalIliveAuth(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = LocalMultiProcConfig.getLong4Uin("key_qq_ilive_connect_auth_time", 0L, getLongUin());
    QLog.e("IliveAuthManager", 1, "getLocalIliveAuth : offest = " + (l1 - l2));
    int j = 0;
    int i;
    if ((paramBoolean) && (LiteLiveSDKFactory.a().a() == null))
    {
      i = 1;
      if ((i == 0) || (l1 - l2 <= getQQAuthTime())) {
        break label109;
      }
    }
    label109:
    IliveAuthManager.QQConnectData localQQConnectData;
    do
    {
      do
      {
        return null;
        i = j;
        if (paramBoolean) {
          break;
        }
        i = j;
        if (!TextUtils.isEmpty(IlivePluginManager.getInstance().getLiveToken())) {
          break;
        }
        i = 1;
        break;
        localQQConnectData = getCurrentAccountMemoryData();
        if (localQQConnectData != null) {
          return new stAuth(1, localQQConnectData.openId, localQQConnectData.accessToken);
        }
      } while (!syncQQConnectDataFromSP());
      localQQConnectData = getCurrentAccountMemoryData();
    } while (localQQConnectData == null);
    return new stAuth(1, localQQConnectData.openId, localQQConnectData.accessToken);
  }
  
  @NotNull
  public void getStAuth(IliveAuthManager.Callback paramCallback, boolean paramBoolean)
  {
    stAuth localstAuth = getLocalIliveAuth(paramBoolean);
    if (localstAuth != null)
    {
      if (paramCallback != null) {
        paramCallback.onGetAuthInfo(true, localstAuth);
      }
      QLog.e("IliveAuthManager", 1, "getStAuth use local");
      return;
    }
    paramCallback = new WeakReference(paramCallback);
    this.mWeakCallBackList.add(paramCallback);
    QLog.e("IliveAuthManager", 1, "getStAuth ");
    sendQQAuthRequest();
  }
  
  public void onGetStCallback(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAuthManager", 2, " auth callback , success = " + paramBoolean + " openId = " + paramString1 + " token = " + paramString2);
    }
    Object localObject2 = new HashMap();
    if (paramBoolean) {}
    for (Object localObject1 = "success";; localObject1 = "fail")
    {
      ((HashMap)localObject2).put("status", localObject1);
      TimeMonitorManager.a().a("AUTH_PROCESS").a("auth_process", (HashMap)localObject2);
      if (paramBoolean)
      {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
          this.mCache.put(getStringUin(), new IliveAuthManager.QQConnectData(paramString1, paramString2));
        }
        localObject1 = ThreeDes.a(paramString1, getStringUin());
        localObject2 = ThreeDes.a(paramString2, getStringUin());
        LocalMultiProcConfig.putString4Uin("key_qq_ilive_connect_open_id", (String)localObject1, getLongUin());
        LocalMultiProcConfig.putString4Uin("key_qq_ilive_connect_access_token", (String)localObject2, getLongUin());
        LocalMultiProcConfig.putLong4Uin("key_qq_ilive_connect_auth_time", System.currentTimeMillis(), getLongUin());
      }
      localObject1 = this.mWeakCallBackList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (IliveAuthManager.Callback)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((IliveAuthManager.Callback)localObject2).onGetAuthInfo(paramBoolean, new stAuth(1, paramString1, paramString2));
          }
        }
      }
    }
    this.mWeakCallBackList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.manager.IliveAuthManager
 * JD-Core Version:    0.7.0.1
 */