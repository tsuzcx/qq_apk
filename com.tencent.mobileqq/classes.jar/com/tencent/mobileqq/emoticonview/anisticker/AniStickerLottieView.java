package com.tencent.mobileqq.emoticonview.anisticker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottieDrawable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class AniStickerLottieView
  extends AppCompatImageView
{
  protected static final ArrayList<WeakReference<AniStickerLottieView>> PENDING_ACTIONS = new AniStickerLottieView.1(35);
  private static final int PENDING_ACTION_CAPACITY = 30;
  private static final String TAG = "AniStickerLottieView";
  protected static boolean sPaused = false;
  private static ConcurrentHashMap<String, String> sRandomMapResult = new ConcurrentHashMap(8);
  private static HashSet<String> sReloadCacheKeySet;
  protected String cacheKey = null;
  AniStickerAnimationListener defRandomResultPlayListener;
  protected int defaultLoadingRes = 2130852735;
  private boolean isInPendingAction = false;
  protected int localId = -1;
  private AXrLottieDrawable lottieDrawable;
  boolean playFrameFinish = false;
  protected String randomKey = null;
  protected String resutId = null;
  AniStickerAnimationListener secRandomResultPlayListener;
  private AXrLottieDrawable secondLottieDrawable;
  boolean showLastFrame = false;
  private boolean showLoading;
  protected Drawable stickerLoadingDrawable;
  String surpriseId = null;
  private boolean wasAnimatingWhenDetached;
  private boolean wasDetached = false;
  
  public AniStickerLottieView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AniStickerLottieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AniStickerLottieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void addReloadCacheKey(String paramString)
  {
    try
    {
      if (sReloadCacheKeySet == null) {
        sReloadCacheKeySet = new HashSet();
      }
      sReloadCacheKeySet.add(paramString);
      return;
    }
    finally {}
  }
  
  private void addSecAnimatorListener(AXrLottieDrawable paramAXrLottieDrawable)
  {
    paramAXrLottieDrawable.a(new AniStickerLottieView.3(this));
  }
  
  public static void clearReloadCacheKey()
  {
    try
    {
      if (sReloadCacheKeySet != null) {
        sReloadCacheKeySet.clear();
      }
      sRandomMapResult.clear();
      return;
    }
    finally {}
  }
  
  @SuppressLint({"RestrictedApi"})
  private void enableOrDisableHardwareLayer()
  {
    if (this.lottieDrawable == null) {
      return;
    }
    int j = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    int i = 1;
    boolean bool1;
    if (j < 21)
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT != 24) {
        if (Build.VERSION.SDK_INT == 25) {
          bool1 = bool2;
        } else {
          bool1 = true;
        }
      }
    }
    if (bool1) {
      i = 2;
    }
    if (i != getLayerType()) {
      setLayerType(i, null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableOrDisableHardwareLayer useHardwareLayer: ");
    localStringBuilder.append(bool1);
    QLog.d("AniStickerLottieView", 2, localStringBuilder.toString());
  }
  
  private int getFrame()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      return localAXrLottieDrawable.h();
    }
    return 0;
  }
  
  public static boolean isAddPauseCache(AniStickerLottieView paramAniStickerLottieView, String paramString)
  {
    if ((paramAniStickerLottieView != null) && (!paramAniStickerLottieView.getIsEnable()) && (paramString != null) && (TextUtils.isEmpty(paramAniStickerLottieView.surpriseId)) && ((TextUtils.isEmpty(paramAniStickerLottieView.resutId)) || (isAnimationFinish(paramAniStickerLottieView))) && (Build.VERSION.SDK_INT < 26))
    {
      paramAniStickerLottieView.cacheKey = paramString;
      paramAniStickerLottieView.showLoading = true;
      paramAniStickerLottieView.isInPendingAction = false;
      addReloadCacheKey(paramString);
      paramAniStickerLottieView.addToPendingActions(paramAniStickerLottieView);
      return true;
    }
    return false;
  }
  
  static final boolean isAllPause()
  {
    return sPaused;
  }
  
  private static boolean isAnimationFinish(AniStickerLottieView paramAniStickerLottieView)
  {
    return (paramAniStickerLottieView != null) && (!TextUtils.isEmpty(paramAniStickerLottieView.resutId)) && ((paramAniStickerLottieView.playFrameFinish) || (paramAniStickerLottieView.showLastFrame));
  }
  
  public static final void pauseAll()
  {
    sPaused = true;
    QLog.d("AniStickerLottieView", 2, "pauseAll.");
  }
  
  private void pauseAnimation()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      localAXrLottieDrawable.stop();
    }
  }
  
  public static final void resumeAll()
  {
    try
    {
      QLog.d("AniStickerLottieView", 2, "resumeAll.");
      sPaused = false;
      Object localObject1;
      if ((sReloadCacheKeySet != null) && (!sReloadCacheKeySet.isEmpty()))
      {
        localObject1 = sReloadCacheKeySet.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          startReloadDrawable(str);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startReloadDrawable cacheKey : ");
            localStringBuilder.append(str);
            QLog.d("AniStickerLottieView", 2, localStringBuilder.toString());
          }
        }
        sReloadCacheKeySet.clear();
      }
      int i = PENDING_ACTIONS.size() - 1;
      while (i >= 0)
      {
        localObject1 = (AniStickerLottieView)((WeakReference)PENDING_ACTIONS.get(i)).get();
        if (localObject1 == null)
        {
          PENDING_ACTIONS.remove(i);
        }
        else if (((AniStickerLottieView)localObject1).getIsEnable())
        {
          PENDING_ACTIONS.remove(i);
          if (!((AniStickerLottieView)localObject1).wasDetached) {
            ((AniStickerLottieView)localObject1).reDraw();
          }
        }
        i -= 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void resumeAnimation()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      localAXrLottieDrawable.start();
    }
  }
  
  static void setAniStickerRandomResult(AniStickerLottieView paramAniStickerLottieView, String paramString)
  {
    if (paramAniStickerLottieView == null)
    {
      QLog.e("AniStickerLottieView", 2, "setAniStickerRandomResult lottieView is null.");
      return;
    }
    sRandomMapResult.put(paramAniStickerLottieView.randomKey, paramString);
  }
  
  public static void startReloadDrawable(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      Object localObject;
      if (isAllPause())
      {
        addReloadCacheKey(paramString);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addReloadCacheKey cacheKey : ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("AniStickerLottieView", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      int i = PENDING_ACTIONS.size() - 1;
      while (i >= 0)
      {
        localObject = (AniStickerLottieView)((WeakReference)PENDING_ACTIONS.get(i)).get();
        if (localObject == null)
        {
          PENDING_ACTIONS.remove(i);
        }
        else if ((((AniStickerLottieView)localObject).getIsEnable()) && (paramString.equals(((AniStickerLottieView)localObject).cacheKey)))
        {
          PENDING_ACTIONS.remove(i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startReloadDrawable key: ");
            localStringBuilder.append(paramString);
            QLog.d("AniStickerLottieView", 2, localStringBuilder.toString());
          }
          ((AniStickerLottieView)localObject).isInPendingAction = false;
          if (isAnimationFinish((AniStickerLottieView)localObject)) {
            AniStickerHelper.setAniStickerRandomLastFrameResource(new AniStickerHelper.Builder((AniStickerLottieView)localObject).localId(((AniStickerLottieView)localObject).localId).placeholderDrawable(((AniStickerLottieView)localObject).defaultLoadingRes).resultId(((AniStickerLottieView)localObject).resutId).build());
          } else {
            AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder((AniStickerLottieView)localObject).localId(((AniStickerLottieView)localObject).localId).placeholderDrawable(((AniStickerLottieView)localObject).defaultLoadingRes).showLoading(((AniStickerLottieView)localObject).showLoading).build());
          }
        }
        i -= 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void addPreAnimatorListener(AXrLottieDrawable paramAXrLottieDrawable)
  {
    int i;
    if ((this.randomKey != null) && (!this.showLastFrame)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = TextUtils.isEmpty(this.surpriseId);
    if ((i == 0) && (!(true ^ bool)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AniStickerLottieView", 2, "addPreAnimatorListener do nothing");
      }
      return;
    }
    paramAXrLottieDrawable.a(new AniStickerLottieView.2(this, paramAXrLottieDrawable));
  }
  
  void addToPendingActions(AniStickerLottieView paramAniStickerLottieView)
  {
    if (paramAniStickerLottieView == null) {
      return;
    }
    if (!this.isInPendingAction)
    {
      int i = PENDING_ACTIONS.size() - 1;
      while (i >= 0)
      {
        if ((AniStickerLottieView)((WeakReference)PENDING_ACTIONS.get(i)).get() == paramAniStickerLottieView) {
          return;
        }
        i -= 1;
      }
      PENDING_ACTIONS.add(new WeakReference(paramAniStickerLottieView));
      this.isInPendingAction = true;
    }
  }
  
  void cancelAnimation()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null)
    {
      this.wasAnimatingWhenDetached = false;
      localAXrLottieDrawable.stop();
    }
  }
  
  public void cancelLottieAnimation()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      localAXrLottieDrawable.stop();
    }
  }
  
  public void clearLottieDrawable()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null)
    {
      localAXrLottieDrawable.j();
      this.lottieDrawable.a(null);
      this.lottieDrawable = null;
    }
  }
  
  public void clearSecondLottieDrawable()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.secondLottieDrawable;
    if ((localAXrLottieDrawable != null) && (this.lottieDrawable != localAXrLottieDrawable))
    {
      localAXrLottieDrawable.j();
      this.secondLottieDrawable.a(null);
      this.secondLottieDrawable = null;
    }
  }
  
  public void clearSvgLoadingDrawable()
  {
    Drawable localDrawable = this.stickerLoadingDrawable;
    if (localDrawable != null)
    {
      localDrawable.setCallback(null);
      this.stickerLoadingDrawable = null;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.stickerLoadingDrawable != null)
    {
      if ((getLayerType() != 1) && (Build.VERSION.SDK_INT < 28))
      {
        setLayerType(1, null);
        return;
      }
      this.stickerLoadingDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.stickerLoadingDrawable.draw(paramCanvas);
    }
    super.draw(paramCanvas);
    if ((!getIsEnable()) && (this.lottieDrawable != null) && (getFrame() >= 1))
    {
      pauseAnimation();
      addToPendingActions(this);
    }
  }
  
  final boolean getIsEnable()
  {
    return (!sPaused) || (this.surpriseId != null);
  }
  
  public boolean isAnimating()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      return localAXrLottieDrawable.isRunning();
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.wasDetached = false;
    if (!isInEditMode())
    {
      Object localObject = this.lottieDrawable;
      if ((localObject != null) && (this.wasAnimatingWhenDetached))
      {
        if (!((AXrLottieDrawable)localObject).isRunning()) {
          this.lottieDrawable.start();
        }
        this.wasAnimatingWhenDetached = false;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onAttachedToWindow playAnimation : ");
          ((StringBuilder)localObject).append(this.localId);
          QLog.d("AniStickerLottieView", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.wasAnimatingWhenDetached = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDetachedFromWindow cancelAnimation : ");
        localStringBuilder.append(this.localId);
        QLog.d("AniStickerLottieView", 2, localStringBuilder.toString());
      }
    }
    if (((getContext() instanceof Activity)) && (((Activity)getContext()).isFinishing()))
    {
      clearLottieDrawable();
      clearSecondLottieDrawable();
      this.localId = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerLottieView", 2, "onDetachedFromWindow clear res.");
      }
    }
    this.wasDetached = true;
    super.onDetachedFromWindow();
    clearSvgLoadingDrawable();
  }
  
  protected void playAnimation()
  {
    AXrLottieDrawable localAXrLottieDrawable = this.lottieDrawable;
    if (localAXrLottieDrawable != null) {
      localAXrLottieDrawable.start();
    }
  }
  
  protected void playLottieAnimation(AXrLottieDrawable paramAXrLottieDrawable)
  {
    long l = System.currentTimeMillis();
    clearSvgLoadingDrawable();
    enableOrDisableHardwareLayer();
    this.showLoading = false;
    setImageDrawable(paramAXrLottieDrawable);
    this.isInPendingAction = false;
    if (this.showLastFrame)
    {
      paramAXrLottieDrawable.e(paramAXrLottieDrawable.i() - 1);
      playAnimation();
    }
    else if (!getIsEnable())
    {
      addToPendingActions(this);
    }
    else
    {
      playAnimation();
    }
    if (QLog.isColorLevel())
    {
      paramAXrLottieDrawable = new StringBuilder();
      paramAXrLottieDrawable.append("playLottieAnimation cost: ");
      paramAXrLottieDrawable.append(System.currentTimeMillis() - l);
      QLog.d("AniStickerLottieView", 2, paramAXrLottieDrawable.toString());
    }
  }
  
  public void reDraw()
  {
    this.isInPendingAction = false;
    if ((!this.showLastFrame) && (!this.playFrameFinish) && (TextUtils.isEmpty(this.surpriseId)))
    {
      if (!isAnimating())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AniStickerLottieView", 2, "resumeAnimation");
        }
        resumeAnimation();
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reDraw return, showLastFrame:");
      localStringBuilder.append(this.showLastFrame);
      localStringBuilder.append(" playFrameFinish:");
      localStringBuilder.append(this.playFrameFinish);
      localStringBuilder.append(" surpriseId:");
      localStringBuilder.append(this.surpriseId);
      QLog.d("AniStickerLottieView", 2, localStringBuilder.toString());
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      if ((paramDrawable instanceof AXrLottieDrawable))
      {
        if (this.lottieDrawable != paramDrawable) {
          clearLottieDrawable();
        }
        this.lottieDrawable = ((AXrLottieDrawable)paramDrawable);
      }
      else
      {
        clearLottieDrawable();
      }
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setSecondLottieDrawable(AniStickerInfo paramAniStickerInfo, AXrLottieDrawable paramAXrLottieDrawable, int paramInt)
  {
    if (paramAniStickerInfo == null) {
      return;
    }
    if (paramAXrLottieDrawable != null)
    {
      if (this.secondLottieDrawable == paramAXrLottieDrawable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AniStickerLottieView", 2, "secondLottieDrawable composition can reuse");
        }
        return;
      }
      clearSecondLottieDrawable();
      paramAXrLottieDrawable.c(paramInt);
      paramAXrLottieDrawable.a(true);
      if (AniStickerHelper.isChangeAniSticker(this, paramAniStickerInfo))
      {
        paramAXrLottieDrawable = new StringBuilder();
        paramAXrLottieDrawable.append("view load other res. id: ");
        paramAXrLottieDrawable.append(paramAniStickerInfo.localId);
        QLog.d("AniStickerLottieView", 2, paramAXrLottieDrawable.toString());
        return;
      }
      this.secondLottieDrawable = paramAXrLottieDrawable;
      return;
    }
    QLog.e("AniStickerLottieView", 2, "lottie composition is null. ");
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if (!super.verifyDrawable(paramDrawable))
    {
      Drawable localDrawable = this.stickerLoadingDrawable;
      if ((localDrawable == null) || (paramDrawable != localDrawable)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView
 * JD-Core Version:    0.7.0.1
 */