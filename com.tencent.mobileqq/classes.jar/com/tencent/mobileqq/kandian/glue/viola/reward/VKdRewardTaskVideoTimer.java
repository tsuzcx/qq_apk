package com.tencent.mobileqq.kandian.glue.viola.reward;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.api.IRIJRewardTaskTimer;
import com.tencent.mobileqq.kandian.biz.reward.mvp.RIJRewardTaskTimingPresenter;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VKdRewardTaskVideoTimer
  extends VComponentContainer<VKdRewardTaskLayout>
  implements IRIJRewardTaskTimer
{
  private static final String TAG = "VKdRewardTaskVideoTimer";
  private ReadInJoyObserver mObserver;
  private RIJRewardTaskTimingPresenter rewardTimingPresenter = RIJRewardTaskTimingPresenter.a();
  
  public VKdRewardTaskVideoTimer(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public boolean enabled()
  {
    return (RIJRewardTaskConfig.a()) || (RIJUserLevelTimeUtils.a());
  }
  
  @JSMethod
  public void endTiming()
  {
    if (!enabled()) {
      return;
    }
    stopTiming();
  }
  
  public VKdRewardTaskLayout initComponentHostView(Context paramContext)
  {
    paramContext = new VKdRewardTaskLayout(paramContext);
    paramContext.a(this);
    this.mObserver = new VKdRewardTaskVideoTimer.1(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.mObserver);
    return paramContext;
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.mObserver);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    stopTiming();
  }
  
  public void removedByJs()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.mObserver);
  }
  
  public void startTiming(@NotNull String paramString, int paramInt)
  {
    this.rewardTimingPresenter.a(paramString, paramInt, 2);
  }
  
  @JSMethod
  public void startTiming(JSONObject paramJSONObject)
  {
    if (!enabled()) {
      return;
    }
    if (paramJSONObject == null) {
      return;
    }
    String str = paramJSONObject.optString("rowkey");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    startTiming(str, paramJSONObject.optInt("duration"));
  }
  
  public void stopTiming()
  {
    this.rewardTimingPresenter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.reward.VKdRewardTaskVideoTimer
 * JD-Core Version:    0.7.0.1
 */