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
import cooperation.ilive.lite.IliveLiteMonitorUtil;
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
  private static IliveAuthManager mInstance;
  private Map<String, IliveAuthManager.QQConnectData> mCache = new HashMap();
  private List<WeakReference<IliveAuthManager.Callback>> mWeakCallBackList = null;
  
  private IliveAuthManager()
  {
    syncQQConnectDataFromSP();
  }
  
  public static AppRuntime getAppRuntime()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  private IliveAuthManager.QQConnectData getCurrentAccountMemoryData()
  {
    Map localMap = this.mCache;
    if (localMap != null) {
      return (IliveAuthManager.QQConnectData)localMap.get(getStringUin());
    }
    return null;
  }
  
  public static IliveAuthManager getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new IliveAuthManager();
        }
      }
      finally {}
    }
    return mInstance;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getQQAuthTime time = ");
    localStringBuilder.append(l);
    QLog.i("IliveAuthManager", 1, localStringBuilder.toString());
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
    TimeMonitorManager.a().d("AUTH_PROCESS").a();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    QQALive.GetOpenInfoReq localGetOpenInfoReq = new QQALive.GetOpenInfoReq();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), IliveAuthServlet.class);
    localNewIntent.putExtra("data", WupUtil.a(localGetOpenInfoReq.toByteArray()));
    localNewIntent.putExtra("cmd", "qqvalivelogin.GetOpenInfo");
    localAppRuntime.startServlet(localNewIntent);
  }
  
  private boolean syncQQConnectDataFromSP()
  {
    String str1;
    Object localObject3;
    Object localObject2;
    label227:
    try
    {
      str1 = getStringUin();
    }
    finally {}
    try
    {
      localObject3 = Long.valueOf(Long.parseLong(str1));
      localObject2 = this.mCache.get(str1);
      if (localObject2 != null) {
        return true;
      }
      localObject2 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_open_id", "", ((Long)localObject3).longValue());
      localObject3 = LocalMultiProcConfig.getString4Uin("key_qq_ilive_connect_access_token", "", ((Long)localObject3).longValue());
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
      {
        String str2 = ThreeDes.b((String)localObject2, getStringUin());
        String str3 = ThreeDes.b((String)localObject3, getStringUin());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("use sp openId and accessToken encrypted:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" , ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", decrypt:");
        localStringBuilder.append(str2);
        localStringBuilder.append(" , ");
        localStringBuilder.append(str3);
        QLog.d("IliveAuthManager", 1, localStringBuilder.toString());
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
        {
          this.mCache.put(str1, new IliveAuthManager.QQConnectData(str2, str3));
          return true;
        }
        return false;
      }
      return false;
    }
    catch (Exception localException)
    {
      break label227;
    }
    QLog.e("IliveAuthManager", 1, "parse uin error ");
    return false;
  }
  
  public stAuth getLocalIliveAuth(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = LocalMultiProcConfig.getLong4Uin("key_qq_ilive_connect_auth_time", 0L, getLongUin());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getLocalIliveAuth : offest = ");
    l1 -= l2;
    ((StringBuilder)localObject).append(l1);
    QLog.e("IliveAuthManager", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (LiteLiveSDKFactory.a().d() == null)) {}
    while ((!paramBoolean) && (TextUtils.isEmpty(IlivePluginManager.getInstance().getLiveToken())))
    {
      i = 1;
      break;
    }
    int i = 0;
    if ((i != 0) && (l1 > getQQAuthTime())) {
      return null;
    }
    localObject = getCurrentAccountMemoryData();
    if (localObject != null) {
      return new stAuth(1, ((IliveAuthManager.QQConnectData)localObject).openId, ((IliveAuthManager.QQConnectData)localObject).accessToken);
    }
    if (syncQQConnectDataFromSP())
    {
      localObject = getCurrentAccountMemoryData();
      if (localObject != null) {
        return new stAuth(1, ((IliveAuthManager.QQConnectData)localObject).openId, ((IliveAuthManager.QQConnectData)localObject).accessToken);
      }
    }
    return null;
  }
  
  @NotNull
  public void getStAuth(IliveAuthManager.Callback paramCallback, boolean paramBoolean)
  {
    IliveLiteMonitorUtil.e();
    stAuth localstAuth = getLocalIliveAuth(paramBoolean);
    if (localstAuth != null)
    {
      if (paramCallback != null)
      {
        IliveLiteMonitorUtil.a(true);
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" auth callback , success = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" openId = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" token = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.i("IliveAuthManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new HashMap();
    if (paramBoolean) {
      localObject1 = "success";
    } else {
      localObject1 = "fail";
    }
    ((HashMap)localObject2).put("status", localObject1);
    TimeMonitorManager.a().d("AUTH_PROCESS").a("auth_process", (HashMap)localObject2);
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
    Object localObject1 = this.mWeakCallBackList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = (IliveAuthManager.Callback)((WeakReference)localObject2).get();
        if (localObject2 != null)
        {
          IliveLiteMonitorUtil.a(false);
          ((IliveAuthManager.Callback)localObject2).onGetAuthInfo(paramBoolean, new stAuth(1, paramString1, paramString2));
        }
      }
    }
    this.mWeakCallBackList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.manager.IliveAuthManager
 * JD-Core Version:    0.7.0.1
 */