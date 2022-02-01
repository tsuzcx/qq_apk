package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService.GameBaseInfo;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="GamePubAccountModule")
public class GamePubAccountModule
  extends QQBaseModule
{
  static final String TAG = "GamePubAccountModule";
  
  public GamePubAccountModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void doPromiseCallback(Promise paramPromise, Object paramObject)
  {
    if ((paramPromise != null) && (paramPromise.isCallback()) && (paramObject != null)) {
      paramPromise.resolve(paramObject);
    }
  }
  
  private void sendEvent(String paramString, HippyMap paramHippyMap)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(paramString, paramHippyMap);
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  @HippyMethod(name="enterSingleGameList")
  public void enterSingleGameList(HippyMap paramHippyMap, Promise paramPromise)
  {
    for (;;)
    {
      try
      {
        paramPromise = paramHippyMap.toJSONObject();
        Object localObject = paramPromise.optString("appId");
        String str = paramPromise.optString("appName");
        if (paramPromise.optInt("subscribe") != 1) {
          break label166;
        }
        bool = true;
        paramPromise = new IQQGameSubscribeService.GameBaseInfo((String)localObject, str, bool);
        localObject = (IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
        ((IQQGameSubscribeService)localObject).putToGameInfoMap(paramPromise.a, paramPromise);
        ((IQQGameSubscribeService)localObject).enterSingleGameMsgPage(MobileQQ.sMobileQQ, paramPromise.a, 2);
        if (QLog.isColorLevel())
        {
          paramPromise = new StringBuilder();
          paramPromise.append("enterSingleGameList,params:");
          paramPromise.append(paramHippyMap);
          QLog.d("GamePubAccountModule", 2, paramPromise.toString());
          return;
        }
      }
      catch (Exception paramHippyMap)
      {
        paramPromise = new StringBuilder();
        paramPromise.append("enterSingleGameList, Exception :");
        paramPromise.append(paramHippyMap);
        QLog.d("GamePubAccountModule", 1, paramPromise.toString());
      }
      return;
      label166:
      boolean bool = false;
    }
  }
  
  /* Error */
  @HippyMethod(name="dsl_get_content")
  public void getDSLContent(HippyMap paramHippyMap, Promise paramPromise)
  {
    // Byte code:
    //   0: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: ldc 157
    //   6: astore 5
    //   8: aload_1
    //   9: invokevirtual 66	com/tencent/mtt/hippy/common/HippyMap:toJSONObject	()Lorg/json/JSONObject;
    //   12: ldc 159
    //   14: invokevirtual 74	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 6
    //   19: ldc 161
    //   21: invokestatic 167	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   24: checkcast 161	com/tencent/mobileqq/qqgamepub/api/IQQGameResService
    //   27: aload 6
    //   29: iconst_0
    //   30: invokeinterface 171 3 0
    //   35: astore 7
    //   37: aload_0
    //   38: aload_2
    //   39: aload 7
    //   41: invokespecial 173	com/tencent/mobileqq/qqgamepub/hippy/module/GamePubAccountModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   44: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +161 -> 208
    //   50: new 125	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   57: astore 6
    //   59: aload 7
    //   61: astore 5
    //   63: aload 6
    //   65: ldc 175
    //   67: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: aload_1
    //   74: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 6
    //   80: ldc 177
    //   82: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   91: lload_3
    //   92: lsub
    //   93: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 6
    //   99: ldc 182
    //   101: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: aload_2
    //   108: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 6
    //   114: ldc 184
    //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 6
    //   122: aload 5
    //   124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 10
    //   130: iconst_2
    //   131: aload 6
    //   133: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: astore 5
    //   142: goto +67 -> 209
    //   145: astore 6
    //   147: new 125	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   154: astore 7
    //   156: aload 7
    //   158: ldc 189
    //   160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload 7
    //   166: aload 6
    //   168: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: ldc 10
    //   174: iconst_1
    //   175: aload 7
    //   177: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload_0
    //   184: aload_2
    //   185: ldc 157
    //   187: invokespecial 173	com/tencent/mobileqq/qqgamepub/hippy/module/GamePubAccountModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   190: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +15 -> 208
    //   196: new 125	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   203: astore 6
    //   205: goto -142 -> 63
    //   208: return
    //   209: aload_0
    //   210: aload_2
    //   211: ldc 157
    //   213: invokespecial 173	com/tencent/mobileqq/qqgamepub/hippy/module/GamePubAccountModule:doPromiseCallback	(Lcom/tencent/mtt/hippy/modules/Promise;Ljava/lang/Object;)V
    //   216: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +88 -> 307
    //   222: new 125	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   229: astore 6
    //   231: aload 6
    //   233: ldc 175
    //   235: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 6
    //   241: aload_1
    //   242: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 6
    //   248: ldc 177
    //   250: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   259: lload_3
    //   260: lsub
    //   261: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 6
    //   267: ldc 182
    //   269: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: aload_2
    //   276: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 6
    //   282: ldc 184
    //   284: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 6
    //   290: ldc 157
    //   292: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc 10
    //   298: iconst_2
    //   299: aload 6
    //   301: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto +6 -> 313
    //   310: aload 5
    //   312: athrow
    //   313: goto -3 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	GamePubAccountModule
    //   0	316	1	paramHippyMap	HippyMap
    //   0	316	2	paramPromise	Promise
    //   3	257	3	l	long
    //   6	117	5	localObject1	Object
    //   140	171	5	localObject2	Object
    //   17	115	6	localObject3	Object
    //   145	22	6	localException	Exception
    //   203	97	6	localStringBuilder	StringBuilder
    //   35	141	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	37	140	finally
    //   147	183	140	finally
    //   8	37	145	java/lang/Exception
  }
  
  @HippyMethod(name="getGameListDataPreload")
  public void getGameListDataPreload(Promise paramPromise)
  {
    try
    {
      paramPromise = new HippyMap();
      GamePAPreloadHelper.a(System.currentTimeMillis());
      if (GamePAPreloadHelper.b() != null)
      {
        paramPromise.pushString("result", GamePAPreloadHelper.b());
        sendEvent("onGameListDataPreload", paramPromise);
        GamePAPreloadHelper.b("2");
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGameListDataPreload,vCost：");
        localStringBuilder.append(System.currentTimeMillis() - GamePAPreloadHelper.d());
        localStringBuilder.append(",hippyMap:");
        localStringBuilder.append(paramPromise);
        QLog.i("feedsPreload_GamePubAccountModule", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable paramPromise)
    {
      QLog.e("GamePubAccountModule", 2, paramPromise, new Object[0]);
    }
  }
  
  @HippyMethod(name="gc_hippy_notify_ark")
  public void notifyArk(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {
      try
      {
        paramPromise = new StringBuilder();
        paramPromise.append("hippy transfer data:");
        paramPromise.append(paramHippyMap);
        QLog.d("GamePubAccountModule", 1, paramPromise.toString());
        String str = paramHippyMap.getString("appName");
        paramPromise = paramHippyMap.getMap("data").toJSONObject().toString();
        paramHippyMap = paramPromise;
        if (TextUtils.isEmpty(paramPromise)) {
          paramHippyMap = "{}";
        }
        if (!TextUtils.isEmpty(str))
        {
          ark.arkNotify(str, "gc_ark_rec_hippy", paramHippyMap, "json");
          return;
        }
      }
      catch (Throwable paramHippyMap)
      {
        paramHippyMap.printStackTrace();
      }
    }
  }
  
  @HippyMethod(name="gc_hippy_notify_ark1111")
  public void notifyArk(String paramString1, String paramString2, Promise paramPromise)
  {
    try
    {
      paramPromise = new StringBuilder();
      paramPromise.append("hippy transfer data:");
      paramPromise.append(paramString2);
      paramPromise.append(",appName:");
      paramPromise.append(paramString1);
      QLog.d("GamePubAccountModule", 1, paramPromise.toString());
      if (!TextUtils.isEmpty(paramString1))
      {
        ark.arkNotify(paramString1, "gc_ark_rec_hippy", paramString2, "json");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  @HippyMethod(name="onHippyFirstScreen")
  public void onHippyFirstScreen(Promise paramPromise)
  {
    QLog.d("GamePubAccountModule", 1, "hippy call onHippyFirstScreen");
    paramPromise = getFragment();
    long l = SystemClock.elapsedRealtime();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).a(l);
    }
  }
  
  @HippyMethod(name="onHippyScrollBegin")
  public void onHippyScrollBegin(Promise paramPromise)
  {
    QLog.d("GamePubAccountModule", 1, "hippy call onHippyScrollBegin");
    paramPromise = getFragment();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountModule.1(this, paramPromise));
    }
  }
  
  @HippyMethod(name="onHippyScrollEnd")
  public void onHippyScrollEnd(Promise paramPromise)
  {
    QLog.d("GamePubAccountModule", 1, "hippy call onHippyScrollEnd");
    paramPromise = getFragment();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ThreadManagerV2.getUIHandlerV2().post(new GamePubAccountModule.2(this, paramPromise));
    }
  }
  
  @HippyMethod(name="onHippyShow")
  public void onHippyShow(Promise paramPromise)
  {
    QLog.d("GamePubAccountModule", 1, "hippy call onHippyShow");
    paramPromise = getFragment();
    long l = SystemClock.elapsedRealtime();
    if ((paramPromise instanceof GamePAHippyBaseFragment)) {
      ((GamePAHippyBaseFragment)paramPromise).b(l);
    }
  }
  
  @HippyMethod(name="pauseVideo")
  public void pauseVideo(Promise paramPromise)
  {
    GameVideoManager.b(1);
  }
  
  @HippyMethod(name="playVideo")
  public void playVideo(Promise paramPromise)
  {
    GameVideoManager.b(2);
  }
  
  @HippyMethod(name="queryMoreMsg")
  public void queryMoreMsg(Promise paramPromise)
  {
    paramPromise = getFragment();
    if ((paramPromise != null) && (paramPromise.getActivity() != null)) {
      ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).enterAIO(paramPromise.getActivity(), true);
    }
  }
  
  @HippyMethod(name="report")
  public void report(String paramString, Promise paramPromise)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        ((IQQGameReportService)QRoute.api(IQQGameReportService.class)).report(paramString, 0);
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @HippyMethod(name="reportTianshu")
  public void reportTianshu(String paramString, Promise paramPromise)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramPromise = new StringBuilder();
        paramPromise.append("reportTianshu json =");
        paramPromise.append(paramString);
        QLog.d("GamePubAccountModule", 1, paramPromise.toString());
        Object localObject = new JSONObject(paramString);
        int i = ((JSONObject)localObject).optInt("itemdid");
        int j = ((JSONObject)localObject).optInt("position");
        paramString = ((JSONObject)localObject).optString("frienduin");
        int k = ((JSONObject)localObject).optInt("uniseq");
        paramPromise = ((JSONObject)localObject).optString("advid");
        String str = ((JSONObject)localObject).optString("triggerInfo");
        localObject = ((JSONObject)localObject).optString("gameAppid");
        QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
        localQQGameMsgInfo.frienduin = paramString;
        localQQGameMsgInfo.uniseq = k;
        localQQGameMsgInfo.advId = paramPromise;
        localQQGameMsgInfo.triggerInfo = str;
        localQQGameMsgInfo.gameAppId = ((String)localObject);
        GamePubAccountHelper.a(i, localQQGameMsgInfo, j);
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.GamePubAccountModule
 * JD-Core Version:    0.7.0.1
 */