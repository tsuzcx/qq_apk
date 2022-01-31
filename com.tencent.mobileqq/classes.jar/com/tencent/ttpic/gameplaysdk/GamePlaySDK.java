package com.tencent.ttpic.gameplaysdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLES20;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.openapi.initializer.GamePlayInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.HashSet;
import java.util.Set;

public final class GamePlaySDK
{
  private static final int HEAD_MESH_UPDATE_FRAME_INTERVAL = 10;
  private static final String TAG = GamePlaySDK.class.getSimpleName();
  public static Context context;
  private static GamePlaySDK mInstance;
  private float fov = 60.0F;
  private int headMeshUpdateFrameCount = 0;
  private boolean hideScreen;
  private boolean isSoLoaded = false;
  private int mHeight;
  private int mWidth;
  private ThreadLocal threadLocal = new ThreadLocal();
  
  private void destroyGame()
  {
    if (isInited())
    {
      nativeDestroy();
      this.headMeshUpdateFrameCount = 0;
    }
  }
  
  public static GamePlaySDK getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GamePlaySDK();
      }
      GamePlaySDK localGamePlaySDK = mInstance;
      return localGamePlaySDK;
    }
    finally {}
  }
  
  public static native void nativeClearItemImage();
  
  public static native void nativeDestroy();
  
  public static native String nativeGetFinishAnimationNodeIds();
  
  public static native int nativeGetOutputTexture();
  
  public static native int nativeGetReflectTextureHeight();
  
  public static native int nativeGetReflectTextureID();
  
  public static native int nativeGetReflectTextureWidth();
  
  public static native boolean nativeHasGame();
  
  public static native void nativeInit(AssetManager paramAssetManager, int paramInt, String paramString, GameParams paramGameParams);
  
  public static native void nativeLoadItemImage(String paramString1, String paramString2, boolean paramBoolean);
  
  public static native void nativeOnDrawFrame();
  
  public static native void nativeOnSurfaceChanged(int paramInt1, int paramInt2);
  
  public static native void nativeSetLogLevel(int paramInt);
  
  public static native void nativeSetNodeAlignedHeadPointIndex(String paramString, int paramInt);
  
  public static native void nativeUpdateExpressionWeights(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateEyeEulerAngle(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateEyeRollWeights(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateFlip(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateHeadData(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateQuaternion(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateTransformMatrix(float[] paramArrayOfFloat);
  
  public static native void nativeUpdateTriggerInfo(StickerItem3D[] paramArrayOfStickerItem3D);
  
  private void setIsInited(boolean paramBoolean)
  {
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State)))
    {
      GamePlaySDK.State.access$002((GamePlaySDK.State)localObject, paramBoolean);
      return;
    }
    localObject = new GamePlaySDK.State(this, null);
    GamePlaySDK.State.access$002((GamePlaySDK.State)localObject, paramBoolean);
    this.threadLocal.set(localObject);
  }
  
  public void clear()
  {
    if (isInited())
    {
      destroyGame();
      this.threadLocal.remove();
      this.headMeshUpdateFrameCount = 0;
    }
  }
  
  public void clearItemImage()
  {
    if (isSoLoaded()) {
      nativeClearItemImage();
    }
  }
  
  public Set<String> getFinishAnimationNodeIds()
  {
    HashSet localHashSet = new HashSet();
    String[] arrayOfString = nativeGetFinishAnimationNodeIds().split("-");
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(arrayOfString[i]);
        i += 1;
      }
    }
    return localHashSet;
  }
  
  public float getFov()
  {
    return this.fov;
  }
  
  public int getGameRefTextureHeight()
  {
    return nativeGetReflectTextureHeight();
  }
  
  public int getGameRefTextureID()
  {
    return nativeGetReflectTextureID();
  }
  
  public int getGameRefTextureWidth()
  {
    return nativeGetReflectTextureWidth();
  }
  
  public int getGameTexture()
  {
    return nativeGetOutputTexture();
  }
  
  public void init(AssetManager paramAssetManager, int paramInt1, String paramString, GameParams paramGameParams, int paramInt2, int paramInt3)
  {
    if (!isInited()) {}
    try
    {
      this.mWidth = paramInt2;
      this.mHeight = paramInt3;
      this.fov = paramGameParams.fov;
      nativeSetLogLevel(4);
      nativeInit(paramAssetManager, paramInt1, paramString, paramGameParams);
      setIsInited(true);
      return;
    }
    catch (UnsatisfiedLinkError paramAssetManager)
    {
      paramAssetManager.printStackTrace();
    }
  }
  
  public boolean isHideScreen()
  {
    return this.hideScreen;
  }
  
  public boolean isInited()
  {
    if (!FeatureManager.Features.GAMEPLAY.isFunctionReady())
    {
      LogUtils.e(TAG, "[isInited] ERROR, NOT READY, DO NOTHING");
      return false;
    }
    Object localObject = this.threadLocal.get();
    if ((localObject != null) && ((localObject instanceof GamePlaySDK.State))) {
      return GamePlaySDK.State.access$000((GamePlaySDK.State)localObject);
    }
    return false;
  }
  
  public boolean isSoLoaded()
  {
    return FeatureManager.Features.GAMEPLAY.isFunctionReady();
  }
  
  public void loadItemImage(String paramString1, String paramString2)
  {
    if (isSoLoaded()) {
      loadItemImage(paramString1, paramString2, false);
    }
  }
  
  public void loadItemImage(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (isSoLoaded()) {
      nativeLoadItemImage(paramString1, paramString2, paramBoolean);
    }
  }
  
  public void onDrawFrame()
  {
    if (isInited())
    {
      GLES20.glFlush();
      nativeOnDrawFrame();
    }
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    if ((isInited()) && ((this.mWidth != paramInt1) || (this.mHeight != paramInt2)))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      nativeOnSurfaceChanged(paramInt1, paramInt2);
    }
  }
  
  public void setFov(float paramFloat)
  {
    this.fov = paramFloat;
  }
  
  public void setNodeAlignedHeadPointIndex(String paramString, int paramInt)
  {
    if (isInited()) {
      nativeSetNodeAlignedHeadPointIndex(paramString, paramInt);
    }
  }
  
  public void toggleHideScreen()
  {
    if (!this.hideScreen) {}
    for (boolean bool = true;; bool = false)
    {
      this.hideScreen = bool;
      return;
    }
  }
  
  public void updateExpressionWeights(float[] paramArrayOfFloat)
  {
    if (isInited()) {
      nativeUpdateExpressionWeights(paramArrayOfFloat);
    }
  }
  
  public void updateEyeEulerAngle(float[] paramArrayOfFloat)
  {
    if (isInited()) {
      nativeUpdateEyeEulerAngle(paramArrayOfFloat);
    }
  }
  
  public void updateEyeRollWeights(float[] paramArrayOfFloat)
  {
    if (isInited()) {
      nativeUpdateEyeRollWeights(paramArrayOfFloat);
    }
  }
  
  public void updateFlip(float[] paramArrayOfFloat)
  {
    if (isInited()) {
      nativeUpdateFlip(paramArrayOfFloat);
    }
  }
  
  public void updateHeadData(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (isInited())
    {
      int i = this.headMeshUpdateFrameCount;
      this.headMeshUpdateFrameCount = (i + 1);
      if (i % 10 == 0) {
        nativeUpdateHeadData(paramArrayOfFloat1);
      }
      nativeUpdateTransformMatrix(paramArrayOfFloat2);
    }
  }
  
  public void updateQuaternion(float[] paramArrayOfFloat)
  {
    if ((isInited()) && (paramArrayOfFloat != null)) {
      nativeUpdateQuaternion(paramArrayOfFloat);
    }
  }
  
  public void updateTriggerInfo(StickerItem3D[] paramArrayOfStickerItem3D)
  {
    nativeUpdateTriggerInfo(paramArrayOfStickerItem3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.gameplaysdk.GamePlaySDK
 * JD-Core Version:    0.7.0.1
 */