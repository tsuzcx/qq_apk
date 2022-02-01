package com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine;

class TKDTuWenHippyCommentAdapter$ActivityLifecycleCallbacks
  implements BaseActivityLifecycleCallbacks
{
  private static final int CREATE = 1;
  private static final int DESTROY = 6;
  private static final int INITIAL = 0;
  private static final int PAUSE = 4;
  private static final int RESUME = 3;
  private static final int START = 2;
  private static final int STOP = 5;
  private int state = 0;
  
  private TKDTuWenHippyCommentAdapter$ActivityLifecycleCallbacks(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  public void doOnActivityCreate(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityDestroyed(Activity paramActivity)
  {
    if (this.state == 6) {
      return;
    }
    this.state = 6;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityDestroyed(paramActivity);
    }
    this.this$0.destroy();
  }
  
  public void doOnActivityOnStart(Activity paramActivity)
  {
    int i = this.state;
    if (i == 2) {
      return;
    }
    if (i < 1) {
      doOnActivityPostCreated(paramActivity, null);
    }
    this.state = 2;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityStarted(paramActivity);
    }
  }
  
  public void doOnActivityPause(Activity paramActivity)
  {
    if (this.state == 4) {
      return;
    }
    this.state = 4;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityPaused(paramActivity);
    }
  }
  
  public void doOnActivityPostCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (this.state == 1) {
      return;
    }
    this.state = 1;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityCreated(paramActivity, paramBundle);
    }
  }
  
  public void doOnActivityPostPaused(Activity paramActivity) {}
  
  public void doOnActivityPostResumed(Activity paramActivity)
  {
    int i = this.state;
    if (i == 3) {
      return;
    }
    if (i < 2) {
      doOnActivityOnStart(paramActivity);
    }
    this.state = 3;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityResumed(paramActivity);
    }
  }
  
  public void doOnActivityPreCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void doOnActivityPrePaused(Activity paramActivity) {}
  
  public void doOnActivityPreResumed(Activity paramActivity) {}
  
  public void doOnActivityResume(Activity paramActivity) {}
  
  public void doOnActivityStopped(Activity paramActivity)
  {
    if (this.state == 5) {
      return;
    }
    this.state = 5;
    if (TKDTuWenHippyCommentAdapter.access$1400(this.this$0) != null) {
      TKDTuWenHippyCommentAdapter.access$1400(this.this$0).getActivityLifecycleDispatcher().onActivityStopped(paramActivity);
    }
  }
  
  public void doOnNewIntent(Activity paramActivity, Intent paramIntent) {}
  
  public void doOnWindowFocusChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onAccountChanged(Activity paramActivity) {}
  
  public void onMultiWindowModeChanged(Activity paramActivity, boolean paramBoolean) {}
  
  public void onPostThemeChanged(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.adapter.TKDTuWenHippyCommentAdapter.ActivityLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */