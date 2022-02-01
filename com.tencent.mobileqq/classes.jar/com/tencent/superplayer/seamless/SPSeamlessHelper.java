package com.tencent.superplayer.seamless;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SPSeamlessHelper
{
  public static ViewGroup.LayoutParams DEFAULT_LAYOUT_PARAM = WRAP_LAYOUT_PARAM;
  public static final long DURATION = 250L;
  public static ViewGroup.LayoutParams MATCH_LAYOUT_PARAM;
  public static final String TAG = "SPSeamlessHelper";
  public static ViewGroup.LayoutParams WRAP_LAYOUT_PARAM;
  private static SPSeamlessHelper mInstance = new SPSeamlessHelper();
  private Activity mAnimActivity;
  private Map<String, Set<SPSeamlessHelper.SeamlessCallback>> mCallbackMap = new HashMap();
  private String mEnterToken;
  private ViewGroup mJumpParentViewGroup;
  
  static
  {
    MATCH_LAYOUT_PARAM = new ViewGroup.LayoutParams(-2, -2);
    WRAP_LAYOUT_PARAM = new ViewGroup.LayoutParams(-2, -2);
  }
  
  private void addSeamlessCallback(String paramString, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogUtil.e("SPSeamlessHelper", "addSeamlessCallback failed for token is empty.");
      return;
    }
    Set localSet = (Set)this.mCallbackMap.get(paramString);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramSeamlessCallback);
    this.mCallbackMap.put(paramString, localObject);
  }
  
  private void clearEnterTokenCallback()
  {
    removeSeamlessCallback(this.mEnterToken);
  }
  
  private void doContentViewAlphaGradientAnimation(View paramView, float paramFloat1, float paramFloat2, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (paramFloat2 == 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
      localAlphaAnimation.setDuration(paramLong);
      localAlphaAnimation.setAnimationListener(new SPSeamlessHelper.3(this, bool, paramView));
      paramView.setAnimation(localAlphaAnimation);
      localAlphaAnimation.start();
      return;
    }
  }
  
  private void doVideoViewAnimation(View paramView, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, long paramLong, SPSeamlessParam paramSPSeamlessParam, Animator.AnimatorListener paramAnimatorListener)
  {
    ViewInfo localViewInfo = getViewInfo(paramView);
    paramView.clearAnimation();
    attachVideoView(paramViewGroup1, paramView);
    new VideoMoveAnimator(paramView, localViewInfo, getViewInfo(paramViewGroup2), paramLong, new SPSeamlessHelper.4(this, paramAnimatorListener, paramView, paramViewGroup2, paramSPSeamlessParam)).start();
  }
  
  public static SPSeamlessHelper get()
  {
    return mInstance;
  }
  
  private ViewGroup getParentView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return (ViewGroup)paramView.getParent();
  }
  
  private View getVideoViewByToken(String paramString)
  {
    paramString = SuperPlayerSDKMgr.getPlayerPool().get(paramString);
    if ((paramString == null) || (paramString.getVideoView() == null))
    {
      LogUtil.e("SPSeamlessHelper", "getVideoViewByToken failed for player/videoView or videoLayout is null.");
      return null;
    }
    return (View)paramString.getVideoView();
  }
  
  private ViewInfo getViewInfo(View paramView)
  {
    ViewInfo localViewInfo = new ViewInfo();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    localViewInfo.x = arrayOfInt[0];
    localViewInfo.y = arrayOfInt[1];
    localViewInfo.width = paramView.getWidth();
    localViewInfo.height = paramView.getHeight();
    return localViewInfo;
  }
  
  private void onSeamlessExitEnd()
  {
    Object localObject = (Set)this.mCallbackMap.get(this.mEnterToken);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SPSeamlessHelper.SeamlessCallback)((Iterator)localObject).next()).onSeamlessExitEnd("", "", null);
      }
    }
    clearEnterTokenCallback();
  }
  
  private void onWindowAnimEnd(Animator paramAnimator, View paramView, ViewGroup paramViewGroup, SPSeamlessParam paramSPSeamlessParam, Animator.AnimatorListener paramAnimatorListener)
  {
    paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new SPSeamlessHelper.5(this, paramViewGroup, paramView, paramSPSeamlessParam, paramAnimatorListener, paramAnimator));
    paramViewGroup.invalidate();
  }
  
  private void removeSeamlessCallback(String paramString)
  {
    this.mCallbackMap.remove(paramString);
  }
  
  public void attachThenDoAnimation(View paramView, ViewGroup paramViewGroup, SPSeamlessParam paramSPSeamlessParam, SPSeamlessHelper.SceneTransformType paramSceneTransformType)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mAnimActivity.getWindow().getDecorView();
    if (paramSceneTransformType == SPSeamlessHelper.SceneTransformType.Exit)
    {
      doVideoViewAnimation(paramView, localViewGroup, paramViewGroup, 250L, paramSPSeamlessParam, new SPSeamlessHelper.1(this));
      doContentViewAlphaGradientAnimation(localViewGroup.findViewById(16908290), 1.0F, 0.0F, 250L);
    }
    while (paramSceneTransformType != SPSeamlessHelper.SceneTransformType.EnterIn) {
      return;
    }
    paramViewGroup.getViewTreeObserver().addOnPreDrawListener(new SPSeamlessHelper.2(this, paramViewGroup, paramView, localViewGroup, paramSPSeamlessParam));
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, View paramView)
  {
    attachVideoView(paramViewGroup, paramView, DEFAULT_LAYOUT_PARAM, -1);
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    attachVideoView(paramViewGroup, paramView, paramLayoutParams, -1);
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    if ((paramViewGroup == null) || (paramView == null))
    {
      LogUtil.e("SPSeamlessHelper", "innerAttachVideoView failed for containerView or videoView is null");
      return;
    }
    if ((paramView instanceof ISPlayerVideoView)) {
      ((ISPlayerVideoView)paramView).disableViewCallback();
    }
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    if (paramInt == -1) {
      paramViewGroup.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      ((ISPlayerVideoView)paramView).enableViewCallback();
      return;
      paramViewGroup.addView(paramView, paramInt, paramLayoutParams);
    }
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView)
  {
    attachVideoView(paramViewGroup, paramISPlayerVideoView, DEFAULT_LAYOUT_PARAM);
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramISPlayerVideoView instanceof View)) {
      attachVideoView(paramViewGroup, (View)paramISPlayerVideoView, paramLayoutParams, -1);
    }
  }
  
  @Deprecated
  public void enterScene(String paramString, ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    if (paramSeamlessCallback != null) {
      addSeamlessCallback(paramString, paramSeamlessCallback);
    }
    paramString = SuperPlayerSDKMgr.getPlayerPool().get(paramString);
    if ((paramString == null) || (paramString.getVideoView() == null) || (paramViewGroup == null))
    {
      LogUtil.e("SPSeamlessHelper", "attachBeforeAnimation failed for player/videoView or videoLayout is null.");
      return;
    }
    attachVideoView(paramViewGroup, paramString.getVideoView(), paramLayoutParams);
  }
  
  public void enterSceneWithAnim(Activity paramActivity, String paramString, ViewGroup paramViewGroup, SPSeamlessParam paramSPSeamlessParam, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    if (paramSeamlessCallback != null) {
      addSeamlessCallback(paramString, paramSeamlessCallback);
    }
    paramString = SuperPlayerSDKMgr.getPlayerPool().get(paramString);
    if ((paramString == null) || (paramString.getVideoView() == null) || (paramViewGroup == null))
    {
      LogUtil.e("SPSeamlessHelper", "attachBeforeAnimation failed for player/videoView or videoLayout is null.");
      return;
    }
    paramString = (View)paramString.getVideoView();
    this.mAnimActivity = paramActivity;
    this.mJumpParentViewGroup = getParentView(paramString);
    attachThenDoAnimation(paramString, paramViewGroup, paramSPSeamlessParam, SPSeamlessHelper.SceneTransformType.EnterIn);
  }
  
  public void exitScene(String paramString1, String paramString2, SPSeamlessParam paramSPSeamlessParam, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    if (paramSeamlessCallback != null) {
      addSeamlessCallback(paramString1, paramSeamlessCallback);
    }
    this.mEnterToken = paramString1;
    paramSeamlessCallback = getVideoViewByToken(paramString2);
    if (paramSeamlessCallback == null)
    {
      LogUtil.e("SPSeamlessHelper", "exitScene failed for videoView is null.");
      return;
    }
    boolean bool = TextUtils.equals(paramString1, paramString2);
    if (!paramSPSeamlessParam.doAnimation)
    {
      attachVideoView(this.mJumpParentViewGroup, paramSeamlessCallback, paramSPSeamlessParam.layoutParams, paramSPSeamlessParam.viewIndex);
      onSeamlessExitEnd();
      return;
    }
    if (bool)
    {
      attachThenDoAnimation(paramSeamlessCallback, this.mJumpParentViewGroup, paramSPSeamlessParam, SPSeamlessHelper.SceneTransformType.Exit);
      return;
    }
    LogUtil.w("SPSeamlessHelper", "exitScene failed for token not equal, enterToken:" + paramString1 + " leftToken:" + paramString2);
  }
  
  public void jumpScene(Activity paramActivity, String paramString, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    paramActivity.overridePendingTransition(0, 0);
    jumpScene(paramString, paramSeamlessCallback);
  }
  
  @Deprecated
  public void jumpScene(String paramString, SPSeamlessHelper.SeamlessCallback paramSeamlessCallback)
  {
    if (paramSeamlessCallback != null) {
      addSeamlessCallback(paramString, paramSeamlessCallback);
    }
    paramSeamlessCallback = (Set)this.mCallbackMap.get(paramString);
    if (paramSeamlessCallback != null)
    {
      paramSeamlessCallback = paramSeamlessCallback.iterator();
      while (paramSeamlessCallback.hasNext()) {
        ((SPSeamlessHelper.SeamlessCallback)paramSeamlessCallback.next()).onSeamlessJump(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper
 * JD-Core Version:    0.7.0.1
 */