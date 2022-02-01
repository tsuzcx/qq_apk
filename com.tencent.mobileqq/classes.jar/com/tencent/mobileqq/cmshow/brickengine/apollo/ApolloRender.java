package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.model.ApolloDevInfo;
import com.tencent.mobileqq.apollo.model.ApolloNioSocketInfo;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.render.IRenderRunner;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.view.opengl.Renderer;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.HttpUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.KeyBoardUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.LocationUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaImageUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaLogger;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaNativeMethodUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ScreenUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SensorUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.WebSocketUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.utils.ZipUtil;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.FontUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@Keep
public class ApolloRender
  implements Renderer
{
  public static final int ENGINE_TYPE_ACTION = 0;
  public static final int ENGINE_TYPE_GAME = 1;
  public static final String GAME_RES_PREFIX = "GameRes:";
  public static final String GAME_SAND_BOX_PREFIX = "GameSandBox:";
  public static final int LONG_DRAW_COST = 100;
  private static final String TAG = "[cmshow]sava_ApolloRender";
  private static String qtaTestResult;
  protected static ThreadLocal<WeakReference<ApolloRender>> sLocalRender = new ThreadLocal();
  public static String sNativeVersion;
  private long lastFrame;
  private long lastFrameCost;
  private ApolloRender.IOnAABBChangeListener mAABBChangeListener;
  @NonNull
  public final ApolloTicker mApolloTicker;
  private WeakReference<View> mApolloViewRef;
  private int mCallBackCode;
  private WeakReference<OnApolloViewListener> mCallbackRef;
  private volatile boolean mDestroyed;
  private volatile boolean mDrawTaskRunning;
  public double mDuration;
  public PopupWindow mEditWindow;
  public long mEditorAddr;
  public Button mEditorBtn;
  public String mEditorDefaultText;
  public EditText mEditorPop;
  private List<IApolloRunnableTask> mEventQueue = Collections.synchronizedList(new ArrayList());
  private int mGameId = -1;
  private String mGameName;
  private int mHeight;
  public boolean mIsFrameMode;
  private boolean mIsNeedReport = false;
  private boolean mIsOffscreen;
  private boolean mIsReadyNotify = false;
  @NonNull
  private ReentrantLock mLock;
  private StringBuilder mLogBuffer = new StringBuilder(100);
  private int mLogCount = 0;
  private int mLongCostCount = 0;
  private long mNativeTickerCost;
  public List<ApolloNioSocketInfo> mNioList = new ArrayList();
  private IRecordFrameListener mRecordListener;
  private WeakReference<IRenderCallback> mRenderCallbackRef;
  @NonNull
  private final ApolloEngine mSavaWrapper = new ApolloEngine();
  private float mScale;
  public boolean mShowEditWindow;
  private boolean mSnapShot;
  private ApolloRender.ISnapShotCallback mSnapShotCallback;
  private long mSnapShotSeq;
  private int mTotalDrawCost = 0;
  private int mTotalFrameCount = 0;
  private int mWidth;
  public boolean needRenderFrame = false;
  
  public ApolloRender(float paramFloat, OnApolloViewListener paramOnApolloViewListener, int paramInt)
  {
    float f = FontSettingManager.getFontLevel() / 16.0F;
    if (f != 0.0F) {
      this.mScale = (paramFloat / f);
    } else {
      this.mScale = paramFloat;
    }
    this.mCallbackRef = new WeakReference(paramOnApolloViewListener);
    this.mLock = ApolloActionManager.a().a();
    this.mApolloTicker = new ApolloTicker();
    if (QLog.isColorLevel())
    {
      paramOnApolloViewListener = new StringBuilder();
      paramOnApolloViewListener.append("[ApolloRender] threadId:");
      paramOnApolloViewListener.append(Thread.currentThread().getId());
      QLog.d("[cmshow]sava_ApolloRender", 2, paramOnApolloViewListener.toString());
    }
  }
  
  @Keep
  private static void AABBCallback(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString1, String paramString2, String paramString3, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16, float paramFloat17, float paramFloat18, float paramFloat19, float paramFloat20, int paramInt)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender == null) {
      return;
    }
    localApolloRender.notifyAABBListChange(new ApolloSkeletonBounding(paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16, paramFloat17, paramFloat18, paramFloat19, paramFloat20), paramInt);
  }
  
  @Keep
  private static void callbackFromJniStatic(int paramInt1, int paramInt2, String paramString)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender == null) {
      return;
    }
    localApolloRender.callbackFromJni(paramInt1, paramInt2, paramString);
  }
  
  public static void cancelVibrate(int paramInt)
  {
    SensorUtil.a(paramInt);
  }
  
  private static int correctSizeIfNeed(int paramInt1, int paramInt2)
  {
    if ((CmShowWnsUtils.o()) && (paramInt1 > 0))
    {
      if (paramInt1 == paramInt2) {
        return paramInt2;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("correctSize from recordSize:");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" to viewSize:");
        localStringBuilder.append(paramInt1);
        QLog.w("[cmshow]sava_ApolloRender", 1, localStringBuilder.toString());
      }
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static void createTicker(long paramLong)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender != null) {
      localApolloRender.mApolloTicker.createTicker(paramLong);
    }
  }
  
  @Keep
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    return SavaImageUtil.b(paramArrayOfByte, paramInt);
  }
  
  public static Bitmap decodeJpgBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    return SavaImageUtil.a(paramArrayOfByte, paramInt);
  }
  
  private static void disposeTicker(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("disposeTicker ticker = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",thread=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("[cmshow]sava_ApolloRender", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getCurrentRender();
    if (localObject != null) {
      ((ApolloRender)localObject).mApolloTicker.disposeTicker(paramLong);
    }
  }
  
  public static Bitmap drawTextOnBitmap(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, int paramInt5)
  {
    return FontUtils.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramInt5);
  }
  
  @Keep
  private static void driveFirstFrame(long paramLong)
  {
    ApolloRender localApolloRender = getCurrentRender();
    ApolloTicker localApolloTicker = getApolloTicker(paramLong);
    if ((localApolloTicker != null) && (localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      QLog.d("[cmshow]sava_ApolloRender", 1, new Object[] { "FrameRecorder, driveFirstFrame, ticker:", Long.valueOf(paramLong), ", director:", Long.valueOf(localApolloRender.getSavaWrapper().mDirector) });
      localApolloTicker.nativeCallbackTicker(paramLong, System.currentTimeMillis(), 0.01666666666666667D);
    }
  }
  
  @Keep
  private static void driveForOffScreen(long paramLong, float paramFloat)
  {
    ApolloRender localApolloRender = getCurrentRender();
    ApolloTicker localApolloTicker = getApolloTicker(paramLong);
    if ((localApolloTicker != null) && (localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      QLog.d("[cmshow]sava_ApolloRender", 1, new Object[] { "FrameRecorder, driveForOffScreen, ticker:", Long.valueOf(paramLong), ", interval:", Float.valueOf(paramFloat), ", director:", Long.valueOf(localApolloRender.getSavaWrapper().mDirector) });
      localApolloTicker.setOffscreenFrameInterval(paramFloat);
      localApolloTicker.driveOffScreenFrame(localApolloRender.getSavaWrapper().mDirector);
    }
  }
  
  private void exeEngineJs()
  {
    if (TextUtils.isEmpty(ApolloManagerServiceImpl.sEngineScript)) {
      ApolloManagerServiceImpl.initEngineScript();
    }
    if (TextUtils.isEmpty(ApolloManagerServiceImpl.sEngineScript)) {
      QLog.e("[cmshow]sava_ApolloRender", 1, "exeEngineJs error: sEngineScript is empty!");
    }
    this.mSavaWrapper.execScriptString(ApolloManagerServiceImpl.sEngineScript);
    if (QLog.isColorLevel()) {
      CmShowStatUtil.b("exeBase");
    }
  }
  
  private static Bitmap getApolloBitmap(String paramString, int paramInt)
  {
    return SavaImageUtil.a(paramString, paramInt);
  }
  
  public static ApolloTicker getApolloTicker(long paramLong)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender != null) {
      return localApolloRender.mApolloTicker;
    }
    return null;
  }
  
  public static ApolloRender getCurrentRender()
  {
    Object localObject = sLocalRender;
    if (localObject == null) {
      return null;
    }
    localObject = (WeakReference)((ThreadLocal)localObject).get();
    if (localObject == null) {
      return null;
    }
    localObject = (ApolloRender)((WeakReference)localObject).get();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("[cmshow]sava_ApolloRender", 1, "[getCurrentRender], errInfo->renderObj is null");
      }
      return null;
    }
    return localObject;
  }
  
  public static View getCurrentRenderView()
  {
    try
    {
      Object localObject = getCurrentRender();
      if (localObject != null)
      {
        localObject = ((ApolloRender)localObject).getRenderView();
        return localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]sava_ApolloRender", 1, "[getCurrentRenderView], errInfo->", localOutOfMemoryError);
    }
    return null;
  }
  
  private static void getLocation(long paramLong, int paramInt, String paramString)
  {
    LocationUtil.a(paramLong, paramInt, paramString);
  }
  
  @Keep
  private static String getRscPathStatic(String paramString1, String paramString2)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender == null) {
      return "";
    }
    return localApolloRender.getRscPath(paramString1, paramString2);
  }
  
  private static String getSandBoxPath(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = getCurrentRender();
    if (localObject == null)
    {
      QLog.w("[cmshow]sava_ApolloRender", 1, "render is null.");
      return null;
    }
    if (paramString.startsWith("GameSandBox:"))
    {
      paramString = paramString.substring(14);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      localStringBuilder.append(((ApolloRender)localObject).mGameId);
      localStringBuilder.append("/sandbox");
      localObject = new File(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "NOT_SAND_PATH";
  }
  
  public static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    return FontUtils.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString1, paramString2);
  }
  
  private static Bitmap getTextViewBitmap(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, int paramInt7, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt8)
  {
    return FontUtils.a(paramInt1, paramInt2, paramString1, paramInt3, paramInt4, paramInt5, paramInt6, paramString2, paramInt7, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt8);
  }
  
  public static int[] getTextViewSize(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return FontUtils.a(paramInt1, paramInt2, paramString1, paramString2);
  }
  
  private static int[] getTextViewSize(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2, int paramInt8, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt9)
  {
    return FontUtils.a(paramInt1, paramString1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramString2, paramInt8, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt9);
  }
  
  public static String getUserPath(int paramInt)
  {
    Object localObject = CmGameUtil.a();
    long l;
    if (localObject != null) {
      l = ((AppInterface)localObject).getLongAccountUin();
    } else {
      l = 0L;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/storage/");
    ((StringBuilder)localObject).append(l);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void hideKeyBoard(long paramLong)
  {
    KeyBoardUtil.b(paramLong);
  }
  
  @Deprecated
  private static void httpRequest(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    HttpUtil.a(paramLong, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfString, paramBoolean);
  }
  
  @Deprecated
  private static void httpRequestData(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String[] paramArrayOfString, boolean paramBoolean)
  {
    HttpUtil.a(paramLong, paramString1, paramString2, paramArrayOfByte, paramString3, paramString4, paramArrayOfString, paramBoolean);
  }
  
  public static boolean isGameMode()
  {
    View localView = getCurrentRenderView();
    return ((localView instanceof ApolloSurfaceView)) && (((ApolloSurfaceView)localView).isGameMode());
  }
  
  @Keep
  private static boolean isJavaMethodExist(int paramInt, String paramString1, String paramString2)
  {
    return SavaNativeMethodUtil.a(paramInt, paramString1, paramString2);
  }
  
  @Keep
  private static byte[] jsha1(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      localObject = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("java sha1  Error:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      QLog.e("[cmshow]sava_ApolloRender", 2, ((StringBuilder)localObject).toString());
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      QLog.d("[cmshow]sava_ApolloRender", 2, paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  @Keep
  public static boolean onRecordFrame(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = getCurrentRender();
    if (localObject != null) {
      localObject = ((ApolloRender)localObject).getRecordFrameListener();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      Pair localPair = ((IRecordFrameListener)localObject).a();
      return ((IRecordFrameListener)localObject).a(paramArrayOfByte, correctSizeIfNeed(((Integer)localPair.first).intValue(), paramInt1), correctSizeIfNeed(((Integer)localPair.second).intValue(), paramInt2));
    }
    QLog.w("[cmshow]sava_ApolloRender", 1, "onRecordFrame but recordFrameListener null!!");
    return false;
  }
  
  @Keep
  public static boolean onRecordFrameEnd(long paramLong, boolean paramBoolean)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if ((localApolloRender != null) && (localApolloRender.getRecordFrameListener() != null)) {
      return localApolloRender.getRecordFrameListener().a(paramBoolean);
    }
    QLog.w("[cmshow]sava_ApolloRender", 1, "onRecordFrameEnd but recordFrameListener null!!");
    return false;
  }
  
  @Keep
  public static boolean onRecordFrameStart(long paramLong, float paramFloat)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if ((localApolloRender != null) && (localApolloRender.getRecordFrameListener() != null)) {
      return localApolloRender.getRecordFrameListener().a(paramFloat);
    }
    QLog.w("[cmshow]sava_ApolloRender", 1, "onRecordFrameStart but recordFrameListener null!!");
    return false;
  }
  
  public static void printNativeLog(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    SavaLogger.a(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  private static void printNativeVersion(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]sava_ApolloRender", 2, new Object[] { "version:", paramString });
    }
    sNativeVersion = paramString;
  }
  
  @Keep
  private static ApolloDevInfo queryDevInfo()
  {
    ApolloDevInfo localApolloDevInfo = new ApolloDevInfo();
    localApolloDevInfo.model = DeviceInfoUtil.i();
    localApolloDevInfo.platform = "android";
    localApolloDevInfo.version = DeviceInfoUtil.e();
    localApolloDevInfo.qqVersion = DeviceInfoUtil.c();
    localApolloDevInfo.pixelRatio = DeviceInfoUtil.a();
    localApolloDevInfo.screenHeight = ((float)DeviceInfoUtil.l());
    localApolloDevInfo.screenWidth = ((float)DeviceInfoUtil.k());
    return localApolloDevInfo;
  }
  
  @Keep
  private static void requestRenderView() {}
  
  protected static void selectPhoto(long paramLong, int paramInt1, int paramInt2)
  {
    SavaImageUtil.a(paramLong, paramInt1, paramInt2);
  }
  
  private static void sendHttpRequest(long paramLong, @NonNull String paramString1, @NonNull String paramString2, @NonNull String[] paramArrayOfString, @Nullable byte[] paramArrayOfByte)
  {
    HttpUtil.a(paramLong, paramString1, paramString2, paramArrayOfString, paramArrayOfByte);
  }
  
  private static void setIntervalTicker(long paramLong, int paramInt)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender != null) {
      localApolloRender.mApolloTicker.setInterval(paramLong, paramInt);
    }
  }
  
  private static void setKeepScreenOn(int paramInt)
  {
    ScreenUtil.a(paramInt);
  }
  
  private static void setKeyBoardText(long paramLong, String paramString)
  {
    KeyBoardUtil.a(paramLong, paramString);
  }
  
  private static void setRenderMode(int paramInt)
  {
    Object localObject = getCurrentRenderView();
    if ((localObject != null) && ((localObject instanceof ApolloSurfaceView)))
    {
      localObject = (ApolloSurfaceView)localObject;
      ((ApolloSurfaceView)localObject).mRenderMode = paramInt;
      ((ApolloSurfaceView)localObject).setRenderMode(paramInt);
      localObject = getCurrentRender();
      if (localObject != null)
      {
        if (paramInt == 0)
        {
          tickerResume(((ApolloRender)localObject).mApolloTicker.ticker);
          return;
        }
        if (paramInt == 1) {
          tickerPause(((ApolloRender)localObject).mApolloTicker.ticker);
        }
      }
    }
  }
  
  private void setupDirector()
  {
    if (!ApolloEngine.isEngineReady()) {
      return;
    }
    try
    {
      this.mSavaWrapper.createDirector(0L, 0, 0, this.mScale, 0, ApolloHardWareTester.a());
      exeEngineJs();
      this.mSavaWrapper.setDirectorScreenScale(this.mScale);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]sava_ApolloRender", 1, localOutOfMemoryError.getMessage());
    }
  }
  
  @TargetApi(17)
  public static void showKeyBorad(long paramLong)
  {
    KeyBoardUtil.a(paramLong);
  }
  
  /* Error */
  private boolean snapShot(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 697	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShot	Z
    //   4: ifeq +188 -> 192
    //   7: aload_0
    //   8: getfield 699	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotCallback	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$ISnapShotCallback;
    //   11: ifnull +181 -> 192
    //   14: aload_0
    //   15: getfield 701	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mWidth	I
    //   18: ifle +174 -> 192
    //   21: aload_0
    //   22: getfield 703	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mHeight	I
    //   25: ifle +167 -> 192
    //   28: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +12 -> 43
    //   34: ldc 24
    //   36: iconst_2
    //   37: ldc_w 705
    //   40: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 701	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mWidth	I
    //   47: aload_0
    //   48: getfield 703	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mHeight	I
    //   51: imul
    //   52: newarray int
    //   54: astore_2
    //   55: aload_2
    //   56: invokestatic 711	java/nio/IntBuffer:wrap	([I)Ljava/nio/IntBuffer;
    //   59: astore_3
    //   60: aload_3
    //   61: iconst_0
    //   62: invokevirtual 715	java/nio/IntBuffer:position	(I)Ljava/nio/Buffer;
    //   65: pop
    //   66: aload_1
    //   67: iconst_0
    //   68: iconst_0
    //   69: aload_0
    //   70: getfield 701	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mWidth	I
    //   73: aload_0
    //   74: getfield 703	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mHeight	I
    //   77: sipush 6408
    //   80: sipush 5121
    //   83: aload_3
    //   84: invokeinterface 721 8 0
    //   89: aload_0
    //   90: getfield 699	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotCallback	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$ISnapShotCallback;
    //   93: aload_2
    //   94: aload_0
    //   95: getfield 701	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mWidth	I
    //   98: aload_0
    //   99: getfield 703	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mHeight	I
    //   102: aload_0
    //   103: getfield 723	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mCallBackCode	I
    //   106: aload_0
    //   107: getfield 725	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotSeq	J
    //   110: invokeinterface 730 7 0
    //   115: aload_0
    //   116: iconst_0
    //   117: putfield 697	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShot	Z
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 699	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotCallback	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$ISnapShotCallback;
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: goto +52 -> 180
    //   131: astore_1
    //   132: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +33 -> 168
    //   138: ldc 24
    //   140: iconst_2
    //   141: aload_1
    //   142: invokevirtual 526	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   145: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: goto +20 -> 168
    //   151: astore_1
    //   152: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +13 -> 168
    //   158: ldc 24
    //   160: iconst_2
    //   161: aload_1
    //   162: invokevirtual 731	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_0
    //   169: iconst_0
    //   170: putfield 697	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShot	Z
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 699	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotCallback	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$ISnapShotCallback;
    //   178: iconst_0
    //   179: ireturn
    //   180: aload_0
    //   181: iconst_0
    //   182: putfield 697	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShot	Z
    //   185: aload_0
    //   186: aconst_null
    //   187: putfield 699	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSnapShotCallback	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$ISnapShotCallback;
    //   190: aload_1
    //   191: athrow
    //   192: iconst_0
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	ApolloRender
    //   0	194	1	paramGL10	GL10
    //   54	40	2	arrayOfInt	int[]
    //   59	25	3	localIntBuffer	java.nio.IntBuffer
    // Exception table:
    //   from	to	target	type
    //   43	115	127	finally
    //   132	148	127	finally
    //   152	168	127	finally
    //   43	115	131	java/lang/OutOfMemoryError
    //   43	115	151	java/lang/Exception
  }
  
  public static void startGyroSensor(int paramInt1, long paramLong, int paramInt2)
  {
    SensorUtil.a(paramInt1, paramLong, paramInt2);
  }
  
  public static void stopGyroSensor() {}
  
  public static void tickerPause(long paramLong)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender != null) {
      localApolloRender.mApolloTicker.pauseTicker(paramLong);
    }
  }
  
  public static void tickerResume(long paramLong)
  {
    ApolloRender localApolloRender = getCurrentRender();
    if (localApolloRender != null) {
      localApolloRender.mApolloTicker.resumeTicker(paramLong);
    }
  }
  
  private static int unZip(String paramString1, String paramString2)
  {
    return ZipUtil.a(paramString1, paramString2);
  }
  
  public static void vibrate(int paramInt1, long paramLong, long[] paramArrayOfLong, int paramInt2)
  {
    SensorUtil.a(paramInt1, paramLong, paramArrayOfLong, paramInt2);
  }
  
  private static int websocketClose(long paramLong)
  {
    return WebSocketUtil.a(paramLong);
  }
  
  private static int websocketConnect(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    return WebSocketUtil.a(paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3);
  }
  
  @TargetApi(14)
  private static byte[] websocketRecv(long paramLong, int paramInt)
  {
    return WebSocketUtil.a(paramLong, paramInt);
  }
  
  private static int websocketSend(long paramLong, byte[] paramArrayOfByte)
  {
    return WebSocketUtil.a(paramLong, paramArrayOfByte);
  }
  
  private static int websocketShakeHand(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, Socket paramSocket)
  {
    return WebSocketUtil.a(paramLong, paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramSocket);
  }
  
  /* Error */
  private static void writeTexToDist(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: newarray byte
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: aload_0
    //   15: arraylength
    //   16: if_icmpge +21 -> 37
    //   19: aload 6
    //   21: iload 4
    //   23: aload_0
    //   24: iload 4
    //   26: baload
    //   27: bastore
    //   28: iload 4
    //   30: iconst_1
    //   31: iadd
    //   32: istore 4
    //   34: goto -22 -> 12
    //   37: iload_1
    //   38: iload_2
    //   39: getstatic 789	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   42: invokestatic 795	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   45: astore 10
    //   47: aload 10
    //   49: aload 6
    //   51: invokestatic 800	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   54: invokevirtual 804	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   57: invokestatic 217	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getCurrentRender	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnonnull +4 -> 66
    //   65: return
    //   66: aload_0
    //   67: invokevirtual 294	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getSavaWrapper	()Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloEngine;
    //   70: invokevirtual 807	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloEngine:getLuaState	()J
    //   73: invokestatic 808	com/tencent/mobileqq/apollo/game/process/CmGameUtil:a	(J)I
    //   76: aload_3
    //   77: invokestatic 810	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getSandBoxPath	(ILjava/lang/String;)Ljava/lang/String;
    //   80: astore_0
    //   81: aload_0
    //   82: ifnonnull +4 -> 86
    //   85: return
    //   86: new 428	java/io/File
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 430	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 433	java/io/File:exists	()Z
    //   101: ifeq +9 -> 110
    //   104: aload 6
    //   106: invokevirtual 813	java/io/File:delete	()Z
    //   109: pop
    //   110: aconst_null
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 8
    //   116: aconst_null
    //   117: astore 9
    //   119: aconst_null
    //   120: astore_0
    //   121: new 815	java/io/FileOutputStream
    //   124: dup
    //   125: aload 6
    //   127: invokespecial 818	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   130: astore 6
    //   132: aload_3
    //   133: ldc_w 820
    //   136: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   139: ifne +300 -> 439
    //   142: aload_3
    //   143: ldc_w 825
    //   146: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   149: ifne +290 -> 439
    //   152: aload_3
    //   153: ldc_w 827
    //   156: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   159: ifne +280 -> 439
    //   162: aload_3
    //   163: ldc_w 829
    //   166: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   169: ifeq +6 -> 175
    //   172: goto +267 -> 439
    //   175: iload 5
    //   177: invokestatic 834	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   180: invokevirtual 837	java/lang/Boolean:booleanValue	()Z
    //   183: ifeq +31 -> 214
    //   186: aload 10
    //   188: getstatic 843	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   191: bipush 50
    //   193: aload 6
    //   195: invokevirtual 847	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   198: ifeq +41 -> 239
    //   201: aload 6
    //   203: invokevirtual 850	java/io/FileOutputStream:flush	()V
    //   206: aload 10
    //   208: invokevirtual 853	android/graphics/Bitmap:recycle	()V
    //   211: goto +28 -> 239
    //   214: aload 10
    //   216: getstatic 856	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   219: bipush 100
    //   221: aload 6
    //   223: invokevirtual 847	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   226: ifeq +13 -> 239
    //   229: aload 6
    //   231: invokevirtual 850	java/io/FileOutputStream:flush	()V
    //   234: aload 10
    //   236: invokevirtual 853	android/graphics/Bitmap:recycle	()V
    //   239: aload 6
    //   241: invokevirtual 859	java/io/FileOutputStream:close	()V
    //   244: return
    //   245: astore_0
    //   246: goto +147 -> 393
    //   249: astore_0
    //   250: aload 6
    //   252: astore_3
    //   253: aload_0
    //   254: astore 6
    //   256: goto +37 -> 293
    //   259: astore_0
    //   260: aload 6
    //   262: astore_3
    //   263: aload_0
    //   264: astore 6
    //   266: goto +54 -> 320
    //   269: astore_0
    //   270: aload 6
    //   272: astore_3
    //   273: aload_0
    //   274: astore 6
    //   276: goto +71 -> 347
    //   279: astore_3
    //   280: aload_0
    //   281: astore 6
    //   283: aload_3
    //   284: astore_0
    //   285: goto +108 -> 393
    //   288: astore 6
    //   290: aload 7
    //   292: astore_3
    //   293: aload_3
    //   294: astore_0
    //   295: ldc 24
    //   297: iconst_1
    //   298: aload 6
    //   300: invokevirtual 526	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   303: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload_3
    //   307: ifnull +85 -> 392
    //   310: aload_3
    //   311: invokevirtual 859	java/io/FileOutputStream:close	()V
    //   314: return
    //   315: astore 6
    //   317: aload 8
    //   319: astore_3
    //   320: aload_3
    //   321: astore_0
    //   322: ldc 24
    //   324: iconst_1
    //   325: aload 6
    //   327: invokevirtual 860	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_3
    //   334: ifnull +58 -> 392
    //   337: aload_3
    //   338: invokevirtual 859	java/io/FileOutputStream:close	()V
    //   341: return
    //   342: astore 6
    //   344: aload 9
    //   346: astore_3
    //   347: aload_3
    //   348: astore_0
    //   349: ldc 24
    //   351: iconst_1
    //   352: aload 6
    //   354: invokevirtual 861	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   357: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload_3
    //   361: ifnull +31 -> 392
    //   364: aload_3
    //   365: invokevirtual 859	java/io/FileOutputStream:close	()V
    //   368: return
    //   369: astore_0
    //   370: ldc 24
    //   372: iconst_1
    //   373: aload_0
    //   374: invokevirtual 860	java/io/IOException:getMessage	()Ljava/lang/String;
    //   377: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: return
    //   381: astore_0
    //   382: ldc 24
    //   384: iconst_1
    //   385: aload_0
    //   386: invokevirtual 526	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   389: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: return
    //   393: aload 6
    //   395: ifnull +36 -> 431
    //   398: aload 6
    //   400: invokevirtual 859	java/io/FileOutputStream:close	()V
    //   403: goto +28 -> 431
    //   406: astore_3
    //   407: ldc 24
    //   409: iconst_1
    //   410: aload_3
    //   411: invokevirtual 860	java/io/IOException:getMessage	()Ljava/lang/String;
    //   414: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: goto +14 -> 431
    //   420: astore_3
    //   421: ldc 24
    //   423: iconst_1
    //   424: aload_3
    //   425: invokevirtual 526	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   428: invokestatic 359	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: goto +5 -> 436
    //   434: aload_0
    //   435: athrow
    //   436: goto -2 -> 434
    //   439: iconst_1
    //   440: istore 5
    //   442: goto -267 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramArrayOfByte	byte[]
    //   0	445	1	paramInt1	int
    //   0	445	2	paramInt2	int
    //   0	445	3	paramString	String
    //   10	23	4	i	int
    //   7	434	5	bool	boolean
    //   4	278	6	localObject1	Object
    //   288	11	6	localOutOfMemoryError	OutOfMemoryError
    //   315	11	6	localIOException	java.io.IOException
    //   342	57	6	localFileNotFoundException	java.io.FileNotFoundException
    //   111	180	7	localObject2	Object
    //   114	204	8	localObject3	Object
    //   117	228	9	localObject4	Object
    //   45	190	10	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   132	162	245	finally
    //   162	172	245	finally
    //   175	211	245	finally
    //   214	239	245	finally
    //   132	162	249	java/lang/OutOfMemoryError
    //   162	172	249	java/lang/OutOfMemoryError
    //   175	211	249	java/lang/OutOfMemoryError
    //   214	239	249	java/lang/OutOfMemoryError
    //   132	162	259	java/io/IOException
    //   162	172	259	java/io/IOException
    //   175	211	259	java/io/IOException
    //   214	239	259	java/io/IOException
    //   132	162	269	java/io/FileNotFoundException
    //   162	172	269	java/io/FileNotFoundException
    //   175	211	269	java/io/FileNotFoundException
    //   214	239	269	java/io/FileNotFoundException
    //   121	132	279	finally
    //   295	306	279	finally
    //   322	333	279	finally
    //   349	360	279	finally
    //   121	132	288	java/lang/OutOfMemoryError
    //   121	132	315	java/io/IOException
    //   121	132	342	java/io/FileNotFoundException
    //   239	244	369	java/io/IOException
    //   310	314	369	java/io/IOException
    //   337	341	369	java/io/IOException
    //   364	368	369	java/io/IOException
    //   239	244	381	java/lang/OutOfMemoryError
    //   310	314	381	java/lang/OutOfMemoryError
    //   337	341	381	java/lang/OutOfMemoryError
    //   364	368	381	java/lang/OutOfMemoryError
    //   398	403	406	java/io/IOException
    //   398	403	420	java/lang/OutOfMemoryError
  }
  
  private static int zip(String paramString1, String paramString2)
  {
    return ZipUtil.b(paramString1, paramString2);
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public void callbackFromJni(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (paramInt1 == 0)
    {
      localObject = this.mRenderCallbackRef;
      if (localObject != null)
      {
        localObject = (IRenderCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((IRenderCallback)localObject).a(paramInt2, paramString);
        }
      }
    }
    else if (2 == paramInt1)
    {
      localObject = this.mRenderCallbackRef;
      if (localObject != null)
      {
        localObject = (IRenderCallback)((WeakReference)localObject).get();
        if (localObject != null) {
          ((IRenderCallback)localObject).a(paramInt2, 0, paramString);
        }
      }
    }
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public String getQtaTestResult()
  {
    return qtaTestResult;
  }
  
  public IRecordFrameListener getRecordFrameListener()
  {
    return this.mRecordListener;
  }
  
  public View getRenderView()
  {
    WeakReference localWeakReference = this.mApolloViewRef;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public String getRscPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    StringBuilder localStringBuilder1;
    if (paramString1.startsWith("GameRes:"))
    {
      localStringBuilder1 = new StringBuilder(96);
      paramString1 = paramString1.substring(10);
      localStringBuilder1.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo");
      localStringBuilder1.append("/game/");
      if (TextUtils.isEmpty(this.mGameName))
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getRscPath, mGameName is empty, name:");
        localStringBuilder2.append(paramString1);
        QLog.d("[cmshow]sava_ApolloRender", 2, localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder1.append(this.mGameName);
        localStringBuilder1.append("/");
      }
      StringBuilder localStringBuilder2 = new StringBuilder(200);
      localStringBuilder2.append(paramString1);
      if ("json".equals(paramString2)) {
        localStringBuilder2.append(".json");
      } else if ("atlas".equals(paramString2)) {
        localStringBuilder2.append(".atlas");
      } else if ("lua".equals(paramString2)) {
        localStringBuilder2.append(".lua");
      } else if ("png".equals(paramString2)) {
        localStringBuilder2.append(".png");
      } else if ("jpg".equals(paramString2)) {
        localStringBuilder2.append(".jpg");
      } else if (".js".equals(paramString2)) {
        localStringBuilder2.append(".js");
      } else if ("shp".equals(paramString2)) {
        localStringBuilder2.append(".shp");
      } else if ("bin".equals(paramString2)) {
        localStringBuilder2.append(".bin");
      }
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
    }
    if (paramString1.startsWith("GameSandBox:"))
    {
      paramString1 = paramString1.substring(14);
      paramString2 = new StringBuilder();
      paramString2.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
      paramString2.append(this.mGameId);
      paramString2.append("/sandbox");
      paramString2 = new File(paramString2.toString());
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString2.getAbsolutePath());
      localStringBuilder1.append("/");
      localStringBuilder1.append(paramString1);
      return localStringBuilder1.toString();
    }
    return CMGetResPathUtil.a(paramString1, paramString2);
  }
  
  public ApolloEngine getSavaWrapper()
  {
    return this.mSavaWrapper;
  }
  
  public boolean isDrawTaskRunning()
  {
    return this.mDrawTaskRunning;
  }
  
  public boolean isOffscreen()
  {
    return this.mIsOffscreen;
  }
  
  public native void nativePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public native void nativeRemotePreviewCallback(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString);
  
  public void notifyAABBListChange(ApolloSkeletonBounding paramApolloSkeletonBounding, int paramInt)
  {
    ApolloRender.IOnAABBChangeListener localIOnAABBChangeListener = this.mAABBChangeListener;
    if (localIOnAABBChangeListener == null) {
      return;
    }
    localIOnAABBChangeListener.a(paramApolloSkeletonBounding, paramInt);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc 24
    //   2: iconst_1
    //   3: ldc_w 946
    //   6: invokestatic 383	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 231	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mDestroyed	Z
    //   14: aload_0
    //   15: getfield 172	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   18: invokevirtual 951	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   21: aload_0
    //   22: getfield 145	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mSavaWrapper	Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloEngine;
    //   25: invokevirtual 954	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloEngine:disposeDirector	()V
    //   28: aload_0
    //   29: getfield 172	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   32: invokevirtual 957	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   35: goto +21 -> 56
    //   38: astore_2
    //   39: goto +260 -> 299
    //   42: astore_2
    //   43: ldc 24
    //   45: iconst_1
    //   46: aload_2
    //   47: invokevirtual 526	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   50: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: goto -25 -> 28
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 106	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mIsReadyNotify	Z
    //   61: getstatic 101	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:sLocalRender	Ljava/lang/ThreadLocal;
    //   64: aconst_null
    //   65: invokevirtual 960	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   68: aload_0
    //   69: invokevirtual 390	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:getRenderView	()Landroid/view/View;
    //   72: astore_2
    //   73: aload_2
    //   74: instanceof 962
    //   77: ifeq +19 -> 96
    //   80: new 964	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$3
    //   83: dup
    //   84: aload_0
    //   85: aload_2
    //   86: invokespecial 967	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender$3:<init>	(Lcom/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender;Landroid/view/View;)V
    //   89: bipush 16
    //   91: aconst_null
    //   92: iconst_1
    //   93: invokestatic 973	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   96: aload_0
    //   97: getfield 116	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mIsNeedReport	Z
    //   100: ifeq +194 -> 294
    //   103: aload_0
    //   104: getfield 110	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mTotalDrawCost	I
    //   107: i2f
    //   108: aload_0
    //   109: getfield 112	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mTotalFrameCount	I
    //   112: i2f
    //   113: fdiv
    //   114: fstore_1
    //   115: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +77 -> 195
    //   121: ldc 24
    //   123: iconst_2
    //   124: bipush 8
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: ldc_w 975
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload_0
    //   138: getfield 110	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mTotalDrawCost	I
    //   141: invokestatic 978	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_2
    //   147: ldc_w 980
    //   150: aastore
    //   151: dup
    //   152: iconst_3
    //   153: aload_0
    //   154: getfield 112	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mTotalFrameCount	I
    //   157: invokestatic 978	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: aastore
    //   161: dup
    //   162: iconst_4
    //   163: ldc_w 982
    //   166: aastore
    //   167: dup
    //   168: iconst_5
    //   169: aload_0
    //   170: getfield 114	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mLongCostCount	I
    //   173: invokestatic 978	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: dup
    //   178: bipush 6
    //   180: ldc_w 984
    //   183: aastore
    //   184: dup
    //   185: bipush 7
    //   187: fload_1
    //   188: invokestatic 332	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   191: aastore
    //   192: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   195: new 986	java/util/HashMap
    //   198: dup
    //   199: invokespecial 987	java/util/HashMap:<init>	()V
    //   202: astore_2
    //   203: aload_2
    //   204: ldc_w 989
    //   207: aload_0
    //   208: getfield 131	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mGameId	I
    //   211: invokestatic 991	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   214: invokevirtual 995	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: aload_2
    //   219: ldc_w 997
    //   222: fload_1
    //   223: invokestatic 1000	java/lang/Float:toString	(F)Ljava/lang/String;
    //   226: invokevirtual 995	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload_2
    //   231: ldc_w 1002
    //   234: aload_0
    //   235: getfield 114	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mLongCostCount	I
    //   238: invokestatic 991	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   241: invokevirtual 995	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: aload_2
    //   246: ldc_w 1004
    //   249: aload_0
    //   250: getfield 112	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mTotalFrameCount	I
    //   253: invokestatic 991	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   256: invokevirtual 995	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: invokestatic 463	com/tencent/mobileqq/apollo/game/process/CmGameUtil:a	()Lcom/tencent/common/app/AppInterface;
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull +29 -> 294
    //   268: aload_3
    //   269: invokevirtual 1007	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   272: astore_3
    //   273: invokestatic 1013	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   276: invokestatic 1018	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   279: aload_3
    //   280: ldc_w 1020
    //   283: iconst_1
    //   284: lconst_0
    //   285: lconst_0
    //   286: aload_2
    //   287: ldc_w 405
    //   290: iconst_1
    //   291: invokevirtual 1024	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   294: aconst_null
    //   295: putstatic 584	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:sNativeVersion	Ljava/lang/String;
    //   298: return
    //   299: aload_0
    //   300: getfield 172	com/tencent/mobileqq/cmshow/brickengine/apollo/ApolloRender:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   303: invokevirtual 957	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   306: goto +5 -> 311
    //   309: aload_2
    //   310: athrow
    //   311: goto -2 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	ApolloRender
    //   114	109	1	f	float
    //   38	1	2	localObject1	Object
    //   42	5	2	localOutOfMemoryError	OutOfMemoryError
    //   72	238	2	localObject2	Object
    //   263	17	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	28	38	finally
    //   43	53	38	finally
    //   21	28	42	java/lang/OutOfMemoryError
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mDestroyed)
    {
      QLog.i("[cmshow]sava_ApolloRender", 1, "onDrawFrame mDestroyed, return");
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = l2 - this.lastFrame;
    this.lastFrame = l2;
    if ((ProcessUtil.a()) && (QLog.isColorLevel()))
    {
      this.mLogCount += 1;
      if (this.mLogCount == 1)
      {
        localObject1 = this.mLogBuffer;
        ((StringBuilder)localObject1).append("onDrawFrame now:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append("mInterval:");
        this.mLogBuffer.append(this.mApolloTicker.mInterval);
        this.mLogBuffer.append(" ");
      }
      localObject1 = this.mLogBuffer;
      ((StringBuilder)localObject1).append(l3);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.lastFrameCost);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.mNativeTickerCost);
      ((StringBuilder)localObject1).append("|");
      if (this.mLogCount == 30)
      {
        QLog.d("[cmshow]sava_ApolloRender", 1, this.mLogBuffer.toString());
        localObject1 = this.mLogBuffer;
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
        this.mLogCount = 0;
      }
    }
    long l1 = System.currentTimeMillis();
    if (this.mIsOffscreen) {
      this.mApolloTicker.driveOffScreenFrame(getSavaWrapper().mDirector);
    }
    Object localObject2 = getCurrentRenderView();
    boolean bool1 = isGameMode();
    if (((localObject2 instanceof ApolloTextureView)) || (!bool1)) {
      this.mSavaWrapper.execScriptString(ApolloActionHelperImpl.getAddFrameScript());
    }
    Object localObject1 = null;
    boolean bool2 = localObject2 instanceof ApolloSurfaceView;
    if (bool2) {
      localObject1 = ((ApolloSurfaceView)localObject2).getUIState();
    }
    List localList = this.mEventQueue;
    while (!localList.isEmpty())
    {
      if ((localObject1 != null) && (((AtomicInteger)localObject1).get() != 0))
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("onDrawFrame Runnable return ! UIState:");
        paramGL10.append(((AtomicInteger)localObject1).get());
        paramGL10.append(" runnableList:");
        paramGL10.append(localList.size());
        QLog.e("[cmshow]sava_ApolloRender", 1, paramGL10.toString());
        return;
      }
      IApolloRunnableTask localIApolloRunnableTask = (IApolloRunnableTask)localList.remove(0);
      if (localIApolloRunnableTask != null)
      {
        this.mDrawTaskRunning = true;
        if (localIApolloRunnableTask.a() == 4)
        {
          QLog.i("[cmshow]sava_ApolloRender", 1, "onDrawFrame2 dispose preload task continue");
        }
        else
        {
          System.currentTimeMillis();
          localIApolloRunnableTask.run();
          System.currentTimeMillis();
        }
      }
    }
    if (this.mIsOffscreen) {
      return;
    }
    if ((bool2) && (((ApolloSurfaceView)localObject2).mRenderMode == 1))
    {
      localObject2 = this.mApolloTicker;
      if (l3 < ((ApolloTicker)localObject2).getInterval(((ApolloTicker)localObject2).ticker) * 16)
      {
        localObject2 = this.mApolloTicker;
        long l4 = ((ApolloTicker)localObject2).getInterval(((ApolloTicker)localObject2).ticker) * 16;
        try
        {
          Thread.sleep(l4 - l3);
        }
        catch (Exception localException)
        {
          QLog.e("[cmshow]sava_ApolloRender", 1, localException.getMessage());
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e("[cmshow]sava_ApolloRender", 1, localOutOfMemoryError2.getMessage());
        }
      }
    }
    if ((this.mIsNeedReport) && (l3 < l2) && (l3 > 0L))
    {
      this.mTotalDrawCost = ((int)(this.mTotalDrawCost + l3));
      this.mTotalFrameCount += 1;
      if (l3 > 100L) {
        this.mLongCostCount += 1;
      }
    }
    if ((localObject1 != null) && (((AtomicInteger)localObject1).get() != 0))
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onDrawFrame draw Runnable return ! UIState:");
      paramGL10.append(((AtomicInteger)localObject1).get());
      QLog.e("[cmshow]sava_ApolloRender", 1, paramGL10.toString());
      return;
    }
    if (bool1) {}
    try
    {
      updateNioSocket();
      if ((!this.mDestroyed) && (this.mSavaWrapper.readyDraw("onDrawFrame")))
      {
        l2 = System.currentTimeMillis();
        this.mApolloTicker.nativeCallbackTicker(this.mApolloTicker.ticker, l1, this.mApolloTicker.getDuration(this.mApolloTicker.ticker));
        this.mNativeTickerCost = (System.currentTimeMillis() - l2);
      }
      else
      {
        QLog.i("[cmshow]sava_ApolloRender", 1, "mDestroyed || !mSavaWrapper.readyDraw, return");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]sava_ApolloRender", 1, "[onDrawFrame] error：", localThrowable);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      QLog.e("[cmshow]sava_ApolloRender", 1, localOutOfMemoryError1.getMessage());
    }
    this.lastFrameCost = (System.currentTimeMillis() - l1);
    snapShot(paramGL10);
    this.mDrawTaskRunning = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (this.mDestroyed)
    {
      QLog.i("[cmshow]sava_ApolloRender", 1, "onSurfaceChanged mDestroyed, return");
      return;
    }
    this.mSavaWrapper.setDirectorRenderSize((int)Math.ceil(paramInt1 / this.mScale), (int)Math.ceil(paramInt2 / this.mScale));
    this.needRenderFrame = true;
    if (QLog.isColorLevel())
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("[onSurfaceChanged] width:");
      paramGL10.append(paramInt1);
      paramGL10.append(",height:");
      paramGL10.append(paramInt2);
      paramGL10.append(",mSavaWrapper:");
      paramGL10.append(this.mSavaWrapper);
      QLog.d("[cmshow]sava_ApolloRender", 2, paramGL10.toString());
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    paramGL10 = this.mCallbackRef;
    if ((paramGL10 != null) && (!this.mIsReadyNotify))
    {
      paramGL10 = (OnApolloViewListener)paramGL10.get();
      this.mIsReadyNotify = true;
      ThreadManager.post(new ApolloRender.2(this, paramGL10, paramInt1, paramInt2), 5, null, true);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.mDestroyed)
    {
      QLog.i("[cmshow]sava_ApolloRender", 1, "onSurfaceCreated mDestroyed, return");
      return;
    }
    paramEGLConfig = getRenderView();
    if ((paramEGLConfig instanceof IRenderRunner)) {
      ApolloCmdChannel.getInstance().addRenderRunner((IRenderRunner)paramEGLConfig);
    }
    CmShowStatUtil.b("onSurfaceCreated");
    long l = System.currentTimeMillis();
    if ((WeakReference)sLocalRender.get() == null) {
      sLocalRender.set(new WeakReference(this));
    }
    this.mGameId = CmGameUtil.a(getSavaWrapper().getLuaState());
    paramEGLConfig = CmGameUtil.a();
    if ((paramEGLConfig != null) && (this.mGameId > 0))
    {
      boolean bool;
      if (paramEGLConfig.getLongAccountUin() % 10L == 1L) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIsNeedReport = bool;
    }
    setupDirector();
    if (this.mIsOffscreen) {
      try
      {
        this.mApolloTicker.nativeSetRecorderMode(this.mSavaWrapper.mDirector, true);
      }
      catch (Throwable paramEGLConfig)
      {
        QLog.e("[cmshow]sava_ApolloRender", 1, "nativeSetRecorderMode error=", paramEGLConfig);
      }
    }
    this.mIsReadyNotify = false;
    paramEGLConfig = new int[1];
    paramGL10.glGetIntegerv(3379, paramEGLConfig, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated  GL_MAX_TEXTURE_SIZE: ");
    localStringBuilder.append(paramEGLConfig[0]);
    QLog.i("[cmshow]sava_ApolloRender", 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      paramEGLConfig = new StringBuilder();
      paramEGLConfig.append(" TextureView onSurfaceCreated use:");
      paramEGLConfig.append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]sava_ApolloRender", 2, paramEGLConfig.toString());
    }
    Apollo644ReportUtil.a(this.mSavaWrapper.getLuaState(), paramGL10);
  }
  
  public void queueDestroy()
  {
    queueRenderTask(new ApolloRender.1(this));
  }
  
  public void queueRenderTask(@NonNull IApolloRunnableTask paramIApolloRunnableTask)
  {
    this.mEventQueue.add(paramIApolloRunnableTask);
  }
  
  public void setAABBChangeListener(ApolloRender.IOnAABBChangeListener paramIOnAABBChangeListener)
  {
    this.mAABBChangeListener = paramIOnAABBChangeListener;
  }
  
  public void setBubbleType(int paramInt)
  {
    FontUtils.a = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    this.mGameName = paramString;
  }
  
  public void setOffscreen(boolean paramBoolean)
  {
    this.mIsOffscreen = paramBoolean;
  }
  
  public void setQtaTestResult(String paramString)
  {
    qtaTestResult = paramString;
  }
  
  public void setRecordFrameListener(IRecordFrameListener paramIRecordFrameListener)
  {
    this.mRecordListener = paramIRecordFrameListener;
  }
  
  public void setRenderCallback(IRenderCallback paramIRenderCallback)
  {
    this.mRenderCallbackRef = new WeakReference(paramIRenderCallback);
  }
  
  public void setRenderView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.mApolloViewRef = new WeakReference(paramView);
    this.mApolloTicker.setRenderView(paramView);
  }
  
  public void updateNioSocket()
  {
    int j = -1;
    try
    {
      int i = this.mNioList.size() - 1;
      while (i >= 0)
      {
        j = i;
        localApolloNioSocketInfo = (ApolloNioSocketInfo)this.mNioList.get(i);
        if (localApolloNioSocketInfo != null)
        {
          j = i;
          if (localApolloNioSocketInfo.mState != 1)
          {
            j = i;
            if (localApolloNioSocketInfo.mChannel.finishConnect())
            {
              j = i;
              localApolloNioSocketInfo.mState = 1;
              j = i;
              getSavaWrapper().webSocketSetState(localApolloNioSocketInfo.mSocketStr, 2);
              j = i;
              websocketShakeHand(localApolloNioSocketInfo.mSocketStr, localApolloNioSocketInfo.mAddr, localApolloNioSocketInfo.mPort, localApolloNioSocketInfo.mSslEnable, 0, localApolloNioSocketInfo.mSslInStance, localApolloNioSocketInfo.mSslProtocol, localApolloNioSocketInfo.mChannel.socket());
              j = i;
              this.mNioList.remove(localApolloNioSocketInfo);
            }
          }
        }
        i -= 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ApolloNioSocketInfo localApolloNioSocketInfo;
      if (!QLog.isColorLevel()) {
        break label211;
      }
      QLog.d("[cmshow]sava_ApolloRender", 2, localOutOfMemoryError.getMessage());
      return;
    }
    catch (Exception localException)
    {
      label142:
      break label142;
    }
    if (j >= 0)
    {
      localApolloNioSocketInfo = (ApolloNioSocketInfo)this.mNioList.get(j);
      getSavaWrapper().webSocketSetState(localApolloNioSocketInfo.mSocketStr, 3);
      this.mNioList.remove(j);
      QLog.e("nioCmGame", 2, " exception socket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender
 * JD-Core Version:    0.7.0.1
 */