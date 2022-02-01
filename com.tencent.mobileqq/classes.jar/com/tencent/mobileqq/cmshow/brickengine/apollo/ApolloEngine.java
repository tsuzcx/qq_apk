package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.graphics.RectF;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

@Keep
public class ApolloEngine
{
  private static final long NONE_DIRECTOR = -1L;
  protected static final String TAG = "[cmshow]ApolloManager.Engine";
  private static BufferedReader sLogReader;
  private static boolean sPipeLogDisable;
  private static int sPipeLogFd;
  public long mDirector = -1L;
  private AtomicBoolean mIsInit = new AtomicBoolean(false);
  private ConcurrentHashMap<Integer, Boolean> mLoadedScriptIdMap = new ConcurrentHashMap();
  
  static
  {
    ApolloSoLoaderImpl.loadSo("classLoad");
  }
  
  private void initFileHomeDir()
  {
    new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "slave");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.a);
    ((StringBuilder)localObject1).append("/def/role/0/script/slave/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ApolloConstant.a);
    ((StringBuilder)localObject2).append("/");
    localObject2 = ((StringBuilder)localObject2).toString();
    nativeSetFileHomeDir(ApolloConstant.V, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo", "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/extension/", (String)localObject1, (String)localObject2);
  }
  
  private void initPipeLog()
  {
    if ((sPipeLogFd > 0) && (sLogReader == null)) {
      ThreadManagerV2.newFreeThread(new ApolloEngine.1(this), "Apollo_GL_Log", 1).start();
    }
  }
  
  private boolean isApolloEngineLockEnable()
  {
    Object localObject;
    try
    {
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IApolloManagerService.class, "all");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloManager.Engine", 1, "[isApolloEngineLockEnable] get runtime error!", localThrowable);
      localObject = null;
    }
    if (localObject != null) {
      return localObject.isApolloEngineLockEnable();
    }
    return false;
  }
  
  public static boolean isEngineReady()
  {
    if (!ApolloSoLoaderImpl.isLibReady())
    {
      ApolloSoLoaderImpl.loadSo("other");
      ApolloGameStateMachine.a().a(5, "not load lib");
      return false;
    }
    return ApolloConfigUtils.b();
  }
  
  protected static native int nativeSetPipeLog(int paramInt);
  
  protected static native void nativeSetQLogLevel(int paramInt);
  
  public static void setPipeLog(boolean paramBoolean)
  {
    sPipeLogDisable = paramBoolean;
    if (sPipeLogDisable)
    {
      if (sPipeLogFd > 0) {
        nativeSetPipeLog(0);
      }
      sPipeLogFd = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPipeLog pipeLogDisable:");
    localStringBuilder.append(paramBoolean);
    QLog.i("[cmshow]ApolloManager.Engine", 1, localStringBuilder.toString());
  }
  
  public void audioCallBack(long paramLong)
  {
    nativeAudioCallBack(paramLong);
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public long createDirector(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void createGLContext(long paramLong, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager.Engine", 2, "createGLContext");
    }
    if (readyDraw("createGLContext")) {
      nativeCreateGLContext(paramLong, paramInt1, paramInt2, paramFloat, this.mDirector);
    }
  }
  
  public void disposeDirector()
  {
    if (readyDraw("[disposeDirector]"))
    {
      boolean bool = isApolloEngineLockEnable();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[disposeDirector] tid: ");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(", mDirector: ");
      localStringBuilder.append(this.mDirector);
      localStringBuilder.append(" ApolloManager.sApolloEngineLockEnable:");
      localStringBuilder.append(bool);
      QLog.d("[cmshow]ApolloManager.Engine", 1, localStringBuilder.toString());
      this.mIsInit.set(false);
      try
      {
        nativeDiposeDirector(this.mDirector);
        this.mDirector = -1L;
        return;
      }
      finally {}
    }
  }
  
  public void drawFrame(double paramDouble, int paramInt)
  {
    if (readyDraw("[drawFrame]")) {
      nativeDrawFrame(this.mDirector, paramDouble, paramInt);
    }
  }
  
  public void drawSpecialFrame(double paramDouble)
  {
    execScriptString(String.format(ApolloActionHelperImpl.getAddFrameScript(), new Object[] { Double.valueOf(paramDouble) }));
  }
  
  public void editorOnClickCallBack(long paramLong, String paramString)
  {
    nativeEditorOnClickCallBack(paramLong, paramString);
  }
  
  public void editorTextChangeCallBack(long paramLong, String paramString)
  {
    nativeEditorTextChangeCallBack(paramLong, paramString);
  }
  
  public void execScriptString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (readyDraw("[execScriptString]")) {}
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 100);
        localStringBuilder.append("try{");
        localStringBuilder.append(paramString);
        localStringBuilder.append("}catch(err){BK.Script.log(0, 0, err.message);}");
        try
        {
          if (this.mDirector != -1L)
          {
            long l = this.mDirector;
            if (!QLog.isColorLevel()) {
              break label129;
            }
            i = 1;
            nativeLoadScriptString(l, paramString, i);
          }
          return;
        }
        finally {}
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloManager.Engine", 1, paramString, new Object[0]);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("[cmshow]ApolloManager.Engine", 1, paramString, new Object[0]);
      }
      label129:
      int i = 0;
    }
  }
  
  public RectF getDressRect(String paramString)
  {
    if (readyDraw("[getDressRect]")) {
      return nativeGetDressRect(this.mDirector, paramString);
    }
    return null;
  }
  
  public long getLuaState()
  {
    if (readyDraw("[getLuaState]")) {
      return nativeGetLuaState(this.mDirector);
    }
    return -1L;
  }
  
  public RectF getManRect()
  {
    if (readyDraw("[getManRect]")) {
      return nativeGetManRect(this.mDirector);
    }
    return null;
  }
  
  @Deprecated
  public void httpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("[httpCallBack], errInfo->initErr, mIsLoadSuccess:");
        paramArrayOfByte.append(isEngineReady());
        paramArrayOfByte.append(",mIsInit:");
        paramArrayOfByte.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, paramArrayOfByte.toString());
      }
      return;
    }
    nativeHttpCallBack(paramLong, paramInt, paramArrayOfByte);
  }
  
  public void httpDownloadProgressChange(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[nativeDownloadProgressChange], errInfo->initErr, mIsLoadSuccess:");
        localStringBuilder.append(isEngineReady());
        localStringBuilder.append(",mIsInit:");
        localStringBuilder.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, localStringBuilder.toString());
      }
      return;
    }
    nativeHttpDownloadProgressChange(paramLong, paramInt1, paramInt2);
  }
  
  public void httpResponseCallback(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("[httpResponseCallback], errInfo->initErr, mIsLoadSuccess:");
        paramArrayOfString.append(isEngineReady());
        paramArrayOfString.append(",mIsInit:");
        paramArrayOfString.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, paramArrayOfString.toString());
      }
      return;
    }
    nativeHttpResponseCallback(paramLong, paramInt, paramArrayOfString, paramArrayOfByte);
  }
  
  public void httpUploadProgressChange(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[nativeUploadProgressChange], errInfo->initErr, mIsLoadSuccess:");
        localStringBuilder.append(isEngineReady());
        localStringBuilder.append(",mIsInit:");
        localStringBuilder.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, localStringBuilder.toString());
      }
      return;
    }
    nativeHttpUploadProgressChange(paramLong, paramInt1, paramInt2);
  }
  
  public boolean isScriptLoaded(int paramInt)
  {
    Boolean localBoolean = (Boolean)this.mLoadedScriptIdMap.get(Integer.valueOf(paramInt));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public void locationCallBack(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    nativeLocationCallBack(paramLong, paramInt, paramString2, paramString1, paramDouble2, paramDouble3, paramDouble1, paramDouble5, 0.0D, paramDouble4, paramDouble6);
  }
  
  protected native void nativeAudioCallBack(long paramLong);
  
  protected native long nativeCreateDirector(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  protected native void nativeCreateGLContext(long paramLong1, int paramInt1, int paramInt2, float paramFloat, long paramLong2);
  
  protected native void nativeDiposeDirector(long paramLong);
  
  protected native void nativeDrawFrame(long paramLong, double paramDouble, int paramInt);
  
  protected native void nativeEditorOnClickCallBack(long paramLong, String paramString);
  
  protected native void nativeEditorTextChangeCallBack(long paramLong, String paramString);
  
  protected native RectF nativeGetDressRect(long paramLong, String paramString);
  
  protected native long nativeGetLuaState(long paramLong);
  
  protected native RectF nativeGetManRect(long paramLong);
  
  protected native int nativeGetRoleNum(long paramLong);
  
  protected native String nativeHitestForName(long paramLong, float paramFloat1, float paramFloat2);
  
  protected native int nativeHittest(long paramLong, float paramFloat1, float paramFloat2);
  
  protected native void nativeHttpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  protected native void nativeHttpDownloadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  protected native void nativeHttpResponseCallback(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte);
  
  protected native void nativeHttpUploadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  protected native void nativeLoadScriptFile(long paramLong, String paramString);
  
  protected native void nativeLoadScriptString(long paramLong, String paramString, int paramInt);
  
  protected native void nativeLocationCallBack(long paramLong, int paramInt, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
  
  public native void nativeNotifyScreenModeChange(long paramLong, int paramInt);
  
  protected native int nativeOrganHittest(long paramLong, float paramFloat1, float paramFloat2, String paramString);
  
  protected native String nativeRenderNodeGetExtendString(long paramLong);
  
  protected native void nativeScriptCreate(long paramLong, String paramString, int paramInt);
  
  protected native void nativeSelectPhotoCallBack(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  protected native void nativeSetDirectorHidden(long paramLong, int paramInt);
  
  protected native void nativeSetDirectorRenderSize(long paramLong, float paramFloat1, float paramFloat2);
  
  protected native void nativeSetDirectorScreenScale(long paramLong, float paramFloat);
  
  protected native void nativeSetFileHomeDir(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  protected native void nativeSetNeedRender(long paramLong, int paramInt);
  
  protected native void nativeSetNodeHidden(long paramLong, String paramString, int paramInt);
  
  protected native void nativeSetSkey(byte[] paramArrayOfByte);
  
  protected native void nativeSetSt(byte[] paramArrayOfByte);
  
  protected native void nativeUpdateMouseButton(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  protected native void nativeWebSocketSetSocket(long paramLong, int paramInt);
  
  protected native void nativeWebSocketSetState(long paramLong, int paramInt);
  
  public boolean readyDraw(String paramString)
  {
    if ((this.mIsInit.get()) && (this.mDirector >= 0L)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(paramString);
      paramString.append(" error mIsInit: ");
      paramString.append(this.mIsInit.get());
      paramString.append(", mDirector: ");
      paramString.append(this.mDirector);
      QLog.d("[cmshow]ApolloManager.Engine", 2, paramString.toString());
    }
    return false;
  }
  
  public void selectPhotoCallBack(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[imageselector selectPhoto], errInfo->initErr, mIsLoadSuccess:");
      localStringBuilder.append(isEngineReady());
      localStringBuilder.append(",mIsInit:");
      localStringBuilder.append(this.mIsInit.get());
      QLog.d("[cmshow]ApolloManager.Engine", 2, localStringBuilder.toString());
    }
    nativeSelectPhotoCallBack(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  public void setDirectorRenderSize(float paramFloat1, float paramFloat2)
  {
    if (readyDraw("[setDirectorRenderSize]")) {
      nativeSetDirectorRenderSize(this.mDirector, paramFloat1, paramFloat2);
    }
  }
  
  public void setDirectorScreenScale(float paramFloat)
  {
    if (readyDraw("[setDirectorScreenScale]")) {
      nativeSetDirectorScreenScale(this.mDirector, paramFloat);
    }
  }
  
  public void setScriptLoaded(int paramInt)
  {
    this.mLoadedScriptIdMap.put(Integer.valueOf(paramInt), Boolean.TRUE);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloManager.Engine", 2, new Object[] { "setScriptLoaded scriptId:", Integer.valueOf(paramInt) });
    }
  }
  
  public void setSkey(byte[] paramArrayOfByte)
  {
    nativeSetSkey(paramArrayOfByte);
  }
  
  public void setSt(byte[] paramArrayOfByte)
  {
    nativeSetSt(paramArrayOfByte);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloEngine{, mDirector=");
    localStringBuilder.append(this.mDirector);
    localStringBuilder.append(", hashCode=");
    localStringBuilder.append(hashCode());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void webSocketSetSocket(long paramLong, int paramInt)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[webSocketSetSSLState], errInfo->initErr, mIsLoadSuccess:");
        localStringBuilder.append(isEngineReady());
        localStringBuilder.append(",mIsInit:");
        localStringBuilder.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, localStringBuilder.toString());
      }
      return;
    }
    nativeWebSocketSetSocket(paramLong, paramInt);
  }
  
  public void webSocketSetState(long paramLong, int paramInt)
  {
    if (!this.mIsInit.get())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[webSocketSetState], errInfo->initErr, mIsLoadSuccess:");
        localStringBuilder.append(isEngineReady());
        localStringBuilder.append(",mIsInit:");
        localStringBuilder.append(this.mIsInit.get());
        QLog.d("[cmshow]ApolloManager.Engine", 2, localStringBuilder.toString());
      }
      return;
    }
    nativeWebSocketSetState(paramLong, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine
 * JD-Core Version:    0.7.0.1
 */