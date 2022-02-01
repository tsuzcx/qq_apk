package com.tencent.superplayer.seamless;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
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
  public static ViewGroup.LayoutParams MATCH_LAYOUT_PARAM;
  private static final String TAG = "SPSeamlessHelper";
  public static ViewGroup.LayoutParams WRAP_LAYOUT_PARAM;
  private static SPSeamlessHelper mInstance = new SPSeamlessHelper();
  private Map<String, Set<SPSeamlessHelper.SeamlessCallback>> mCallbackMap = new HashMap();
  
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
  
  public static SPSeamlessHelper get()
  {
    return mInstance;
  }
  
  private void innerAttachVideoView(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup == null) || (paramISPlayerVideoView == null))
    {
      LogUtil.e("SPSeamlessHelper", "innerAttachVideoView failed for containerView or videoView is null");
      return;
    }
    View localView = (View)paramISPlayerVideoView;
    paramISPlayerVideoView.disableViewCallback();
    ViewGroup localViewGroup = (ViewGroup)localView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(localView);
    }
    paramViewGroup.addView(localView, paramLayoutParams);
    paramISPlayerVideoView.enableViewCallback();
  }
  
  public void attachThenDoAnimation(Activity paramActivity, String paramString, ViewGroup paramViewGroup, SeamlessTransition paramSeamlessTransition)
  {
    paramString = SuperPlayerSDKMgr.getPlayerPool().get(paramString);
    if ((paramString == null) || (paramViewGroup == null)) {
      LogUtil.e("SPSeamlessHelper", "attachBeforeAnimation failed for player or containerView is null.");
    }
    do
    {
      return;
      paramString = paramString.getVideoView();
    } while (!(paramString instanceof View));
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    ((View)paramString).clearAnimation();
    attachVideoView(paramActivity, paramString);
    paramSeamlessTransition.doAnimation((View)paramString, new SPSeamlessHelper.1(this, paramString, paramViewGroup));
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView)
  {
    attachVideoView(paramViewGroup, paramISPlayerVideoView, DEFAULT_LAYOUT_PARAM);
  }
  
  public void attachVideoView(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView, ViewGroup.LayoutParams paramLayoutParams)
  {
    innerAttachVideoView(paramViewGroup, paramISPlayerVideoView, paramLayoutParams);
  }
  
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
  
  public void exitScene(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    Object localObject = (Set)this.mCallbackMap.get(paramString1);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SPSeamlessHelper.SeamlessCallback)((Iterator)localObject).next()).onSeamlessExit(paramString1, paramString2, paramMap);
      }
    }
    this.mCallbackMap.remove(paramString1);
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper
 * JD-Core Version:    0.7.0.1
 */