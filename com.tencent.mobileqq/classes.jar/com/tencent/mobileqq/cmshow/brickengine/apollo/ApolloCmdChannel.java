package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer;
import com.tencent.mobileqq.apollo.game.process.audio.ICmGameAudioPlayer;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Keep
public class ApolloCmdChannel
{
  private static final String TAG = "[cmshow][scripted]cmgame_process.ApolloDataChannel";
  private static volatile ApolloCmdChannel instance;
  private HashMap<Long, Boolean> mCallJsRuntimeMap = new HashMap();
  private ICmGameAudioPlayer mPlayer;
  private ApolloRenderRunner mRenderRunners = new ApolloRenderRunner();
  private WeakReferenceHandler mRequestHandlerThread;
  private List<IRequestHandler> mRequestHandlers = new ArrayList();
  private volatile boolean mSetNativeObj;
  
  private ApolloCmdChannel()
  {
    init();
  }
  
  private void createRightPlayer(int paramInt)
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(getGameId());
      if (localCmGameLauncher != null) {
        localCmGameLauncher.b(paramInt);
      }
    }
  }
  
  private int getGameId()
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(Thread.currentThread().getId());
      if (localCmGameLauncher == null) {
        return -1;
      }
      return localCmGameLauncher.g();
    }
    return -10000;
  }
  
  public static ApolloCmdChannel getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new ApolloCmdChannel();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private ICmGameAudioPlayer getRightPlayer()
  {
    return getRightPlayer(true);
  }
  
  private ICmGameAudioPlayer getRightPlayer(boolean paramBoolean)
  {
    if (CmGameUtil.a())
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.a(getGameId());
      if (localCmGameLauncher != null) {
        return localCmGameLauncher.h();
      }
      return null;
    }
    if ((this.mPlayer == null) && (paramBoolean)) {
      this.mPlayer = new ApolloGameMusicPlayer(-10000);
    }
    return this.mPlayer;
  }
  
  private void init()
  {
    makesureHasInitObj();
    this.mRequestHandlerThread = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
    synchronized (this.mRequestHandlers)
    {
      Collections.sort(this.mRequestHandlers, new ApolloCmdChannel.1(this));
      return;
    }
  }
  
  private void makesureHasInitObj()
  {
    try
    {
      if (ApolloEngine.isEngineReady())
      {
        if (!this.mSetNativeObj)
        {
          nativeSetDataChannelObj(this);
          this.mSetNativeObj = true;
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "new ApolloCmdChannel nativeSetDataChannelObj");
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "new ApolloCmdChannel ApolloEngineImpl.isEngineReady() false");
      }
      return;
    }
    finally {}
  }
  
  public void addCmdHandler(IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      this.mRequestHandlers.add(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("addCmdHandler handler:");
        ((StringBuilder)???).append(paramIRequestHandler);
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.mRequestHandlers.size());
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void addRenderRunner(IRenderRunner paramIRenderRunner)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addRenderRunner,renderRunner:");
      localStringBuilder.append(paramIRenderRunner);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, localStringBuilder.toString());
    }
    this.mRenderRunners.a(paramIRenderRunner);
  }
  
  public native void callbackEngine(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public native void callbackEngineOld(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramLong == -1L) {
      return;
    }
    if (!ApolloEngine.isEngineReady())
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "callbackEngineWarpper ApolloEngineImpl.isEngineReady() false");
      }
      return;
    }
    Object localObject = (Boolean)this.mCallJsRuntimeMap.get(Long.valueOf(paramLong));
    try
    {
      CmGameLauncher localCmGameLauncher = CmGameUtil.b(paramLong);
      if ((localCmGameLauncher != null) && (localCmGameLauncher.m()))
      {
        if (localObject != null)
        {
          if (((Boolean)localObject).booleanValue())
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("callbackEngineWrapper isCallFromJs callbackEngine,lState:");
              ((StringBuilder)localObject).append(paramLong);
              QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
            }
            callbackEngine(paramLong, paramInt, paramString1, paramString2);
            return;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("callbackEngineWrapper isCallFromJs callbackEngineOld,lState:");
            ((StringBuilder)localObject).append(paramLong);
            QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
          }
          callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("callbackEngineWrapper callbackEngine, jsRuntime lState:");
            ((StringBuilder)localObject).append(paramLong);
            QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
          }
          callbackEngine(paramLong, paramInt, paramString1, paramString2);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callbackEngineWrapper callbackEngineOld, jsRuntime lState:");
          ((StringBuilder)localObject).append(paramLong);
          QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
        }
        callbackEngineOld(paramLong, paramInt, paramString1, paramString2);
        return;
      }
      if (CmGameUtil.a((int)paramLong) != null) {
        return;
      }
      if ((paramBoolean) || (((Boolean)localObject).booleanValue())) {
        callbackEngine(paramLong, paramInt, paramString1, paramString2);
      }
      QLog.e("[cmshow][scripted]cmgame_process.ApolloDataChannel", 1, "can not find h5 launcher");
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      QLog.e("[cmshow][scripted]cmgame_process.ApolloDataChannel", 1, paramString1, new Object[0]);
    }
  }
  
  public void callbackFromRequest(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[callbackFromRequest], luaState:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",errCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",cmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",reqData:");
      localStringBuilder.append(paramString2);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, localStringBuilder.toString());
    }
    this.mRenderRunners.a(this, paramLong, paramInt, paramString1, paramString2);
  }
  
  public void callbackGetHead(Bitmap paramBitmap, String paramString, int paramInt, long paramLong)
  {
    IRenderRunner localIRenderRunner = this.mRenderRunners.a(paramLong);
    if (localIRenderRunner != null)
    {
      if (!ApolloEngine.isEngineReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "callbackGetHead ApolloEngineImpl.isEngineReady() false");
        }
        return;
      }
      localIRenderRunner.runRenderTask(new ApolloCmdChannel.2(this, paramBitmap, paramString, paramInt, paramLong));
    }
  }
  
  public void checkSetNative()
  {
    if (!this.mSetNativeObj)
    {
      nativeSetDataChannelObj(this);
      this.mSetNativeObj = true;
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "checkSetNative nativeSetDataChannelObj");
      }
    }
  }
  
  public void destroyMusic()
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer(false);
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.c();
    }
  }
  
  @Deprecated
  @Keep
  public void getAccountInfo(long paramLong, String paramString, int paramInt) {}
  
  @Keep
  public int getDeviceHeight()
  {
    return (int)DeviceInfoUtil.G();
  }
  
  @Keep
  public int getDeviceWidth()
  {
    return (int)DeviceInfoUtil.F();
  }
  
  @Keep
  public int getDispalyDpi()
  {
    return DeviceInfoUtil.J();
  }
  
  @Keep
  public int getMusicCurPos(int paramInt)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      return localICmGameAudioPlayer.a(paramInt);
    }
    return -1;
  }
  
  @Keep
  public int getMusicDuration(int paramInt)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      return localICmGameAudioPlayer.b(paramInt);
    }
    return -1;
  }
  
  @Keep
  public int getMusicSwitch()
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    AppInterface localAppInterface = CmGameUtil.b();
    if ((localICmGameAudioPlayer != null) && (localAppInterface != null)) {
      return localICmGameAudioPlayer.a(localAppInterface);
    }
    return 1;
  }
  
  @Keep
  public String getNickname(int paramInt, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    Object localObject = paramString2;
    if (localQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString2;
      }
      if (paramInt == 4)
      {
        paramString1 = ContactUtils.a(localQQAppInterface, paramString1, paramString2);
      }
      else if (paramInt == 5)
      {
        paramString1 = ContactUtils.b(localQQAppInterface, paramString2, false);
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt == 1)
        {
          localObject = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString2);
          paramString1 = paramString2;
          if (localObject != null) {
            paramString1 = ((Friends)localObject).getFriendNick();
          }
        }
      }
      localObject = paramString1;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[getNickname], nickName:");
        paramString2.append(paramString1);
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, paramString2.toString());
        localObject = paramString1;
      }
    }
    return localObject;
  }
  
  @Deprecated
  @Keep
  public void getOpenApiHead(long paramLong, String paramString) {}
  
  @Deprecated
  @Keep
  public void getOpenApiNick(long paramLong, String paramString) {}
  
  public void handleWebEvent(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, new Object[] { "[handleWebEvent] data=", paramString });
    }
    if (!ApolloEngine.isEngineReady())
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "handleWebEvent ApolloEngineImpl.isEngineReady() false");
      }
      return;
    }
    IRenderRunner localIRenderRunner;
    if (paramInt != 0) {
      localIRenderRunner = this.mRenderRunners.a(paramInt);
    } else {
      localIRenderRunner = this.mRenderRunners.a();
    }
    if (localIRenderRunner == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "[handleWebEvent], not find renderRunner");
      }
      return;
    }
    localIRenderRunner.runRenderTask(new ApolloCmdChannel.3(this, localIRenderRunner, paramString));
  }
  
  protected native void nativeGetHeadCallback(Bitmap paramBitmap, String paramString, int paramInt, long paramLong);
  
  protected native void nativeGetNickCallback(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public native void nativeOpenApiGetHeadCallBack(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public native void nativeOpenApiGetNickCallBack(long paramLong, String paramString1, int paramInt, String paramString2);
  
  protected native void nativeSetAudioHash(long paramLong, int paramInt);
  
  protected native void nativeSetDataChannelObj(ApolloCmdChannel paramApolloCmdChannel);
  
  @Keep
  public void openWebview(String paramString)
  {
    Object localObject2 = BaseActivity.sTopActivity;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (SplashActivity.sWeakInstance != null) {
        localObject1 = (Activity)SplashActivity.sWeakInstance.get();
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new Intent((Context)localObject1, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("game_busid", "Android.H5");
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.a((Context)localObject1, paramString, -1L, (Intent)localObject2, true, 100);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openWebview activity=");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", url: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i("[cmshow][scripted]cmgame_process.ApolloDataChannel", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void operateNativeUI(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  @Keep
  public void pauseMusic(int paramInt, String paramString)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.a(paramInt, paramString);
    }
  }
  
  @Keep
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[playMusic], type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",count:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",musicPath:");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, localStringBuilder.toString());
    }
    playMusic(paramLong, paramInt1, paramInt2, paramString, -1.0F, 0, 0);
  }
  
  @Keep
  public void playMusic(long paramLong, int paramInt1, int paramInt2, String paramString, float paramFloat, int paramInt3, int paramInt4)
  {
    Object localObject = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",count:", Integer.valueOf(paramInt2), ",musicPath:", "volumn:", Float.valueOf(paramFloat), ",seekTo:", Integer.valueOf(paramInt3), ",audioType:", Integer.valueOf(paramInt4) });
    }
    IRenderRunner localIRenderRunner = this.mRenderRunners.b(Thread.currentThread().getId());
    if (localIRenderRunner == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "[playMusic], not find renderRunner");
      }
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "[playMusic], musicPath is null");
      }
      return;
    }
    paramString = (String)localObject;
    if (((String)localObject).startsWith("actionMusic:")) {
      paramString = ((String)localObject).substring(((String)localObject).indexOf(":") + 1);
    }
    if ((localIRenderRunner instanceof View))
    {
      localObject = (View)localIRenderRunner;
      if ((localObject != null) && (!((View)localObject).isShown()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "DO NOT play music, cause the view is not visible.");
        }
        return;
      }
    }
    createRightPlayer(paramInt4);
    localObject = getRightPlayer();
    if (localObject != null) {
      ThreadManager.post(new ApolloCmdChannel.PlayMusicTask(getGameId(), this, localIRenderRunner, (ICmGameAudioPlayer)localObject, paramLong, paramInt1, paramInt2, paramString, paramFloat, paramInt3), 5, null, true);
    }
  }
  
  public void playMusicInner(IRenderRunner paramIRenderRunner, int paramInt, long paramLong)
  {
    if ((paramIRenderRunner != null) && (paramInt != 0) && (paramLong != 0L))
    {
      if (!ApolloEngine.isEngineReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, "playMusicInner ApolloEngineImpl.isEngineReady() false");
        }
        return;
      }
      paramIRenderRunner.runRenderTask(new ApolloCmdChannel.4(this, paramLong, paramInt));
    }
  }
  
  public void removeCmdHandler(IRequestHandler paramIRequestHandler)
  {
    synchronized (this.mRequestHandlers)
    {
      this.mRequestHandlers.remove(paramIRequestHandler);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("removeCmdHandler handler:");
        ((StringBuilder)???).append(paramIRequestHandler);
        ((StringBuilder)???).append(", size: ");
        ((StringBuilder)???).append(this.mRequestHandlers.size());
        QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  public void removeRenderRunner(IRenderRunner paramIRenderRunner)
  {
    this.mRenderRunners.b(paramIRenderRunner);
  }
  
  public String requestData(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "{}";
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this);
      ((StringBuilder)???).append("[requestData], luaState:");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(",cmd:");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(",async:");
      ((StringBuilder)???).append(paramBoolean1);
      ((StringBuilder)???).append(",isCallFromJsRuntime:");
      ((StringBuilder)???).append(paramBoolean2);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)???).toString());
    }
    if (1 == CmGameToolCmdChannel.a(paramLong, paramString1, paramString2, paramBoolean1)) {
      return "{}";
    }
    this.mCallJsRuntimeMap.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean2));
    ??? = paramString1.trim();
    Object localObject2 = new ApolloCmdChannel.RequestRunnable(this, paramLong, (String)???, paramString2);
    if ((!"cs.close_room.local".equals(???)) && (!"cs.qta_notify_test_result.local".equals(paramString1)))
    {
      if (paramBoolean1) {
        this.mRequestHandlerThread.post((Runnable)localObject2);
      } else {
        synchronized (this.mRequestHandlers)
        {
          localObject2 = this.mRequestHandlers.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HandleResult localHandleResult = ((IRequestHandler)((Iterator)localObject2).next()).a(paramLong, paramString1, paramString2);
            if (localHandleResult != null)
            {
              if (localHandleResult.b) {
                ((Iterator)localObject2).remove();
              }
              paramString1 = localHandleResult.a;
              return paramString1;
            }
          }
        }
      }
    }
    else {
      ThreadManager.post((Runnable)localObject2, 5, null, true);
    }
    return "{}";
  }
  
  @Keep
  public void resumeMusic(int paramInt, String paramString)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.b(paramInt, paramString);
    }
  }
  
  @Keep
  public void seekTo(int paramInt1, int paramInt2)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.a(paramInt1, paramInt2);
    }
  }
  
  @Keep
  public void setMusicSwitch(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setMusicSwitch], switch:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow][scripted]cmgame_process.ApolloDataChannel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getRightPlayer();
    AppInterface localAppInterface = CmGameUtil.b();
    if (localObject != null)
    {
      if (localAppInterface == null) {
        return;
      }
      ((ICmGameAudioPlayer)localObject).a(paramInt, localAppInterface);
    }
  }
  
  @Deprecated
  public void setScreenMode(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setScreenMode] ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",oldWidth:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",oldHeight:");
    localStringBuilder.append(paramInt3);
    QLog.i("[cmshow][scripted]cmgame_process.ApolloDataChannel", 1, localStringBuilder.toString());
  }
  
  @Keep
  public void stopMusic(int paramInt, String paramString)
  {
    ICmGameAudioPlayer localICmGameAudioPlayer = getRightPlayer();
    if (localICmGameAudioPlayer != null) {
      localICmGameAudioPlayer.c(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */