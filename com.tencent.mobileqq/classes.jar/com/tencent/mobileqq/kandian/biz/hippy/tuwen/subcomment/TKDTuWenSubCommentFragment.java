package com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.mobileqq.kandian.biz.comment.HippyCommentPageListener;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class TKDTuWenSubCommentFragment
  extends ViolaFragment
  implements HippyActivityLifecycleOwner, ITKDHippyEventDispatcherOwner
{
  private static final String TAG = "TKDTuWenSubCommentFragment";
  private static final String URL = "https://viola.qq.com/js/TKDSubCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDSubCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private int adTag;
  private AnchorData anchorData;
  private AbsBaseArticleInfo articleInfo;
  private int biuType;
  private int contentSrc;
  private ITKDHippyEventDispatcher eventDispatcher = new TKDHippyEventDispatcher();
  private final ITKDHippyEventReceiver hippyCommentEventListener = new TKDTuWenSubCommentFragment.MyHippyCommentEventListener(this, null);
  private HippyCommentPageListener hippyCommentPageListener;
  private boolean isVisibleToUser;
  private final HippyActivityLifecycleDispatcher lifecycleDispatcher = new HippyActivityLifecycleDispatcher();
  private String mainCommentId;
  private boolean openCommentEditor;
  
  private void initEventDispatcher()
  {
    if ((this.mHippyQQEngine instanceof ITKDHippyEventDispatcherOwner))
    {
      ITKDHippyEventDispatcher localITKDHippyEventDispatcher = ((ITKDHippyEventDispatcherOwner)this.mHippyQQEngine).getTKDHippyEventDispatcher();
      localITKDHippyEventDispatcher.merge(this.eventDispatcher);
      this.eventDispatcher.clear();
      this.eventDispatcher = localITKDHippyEventDispatcher;
      this.eventDispatcher.register(this.hippyCommentEventListener);
    }
  }
  
  public static TKDTuWenSubCommentFragment newInstance()
  {
    TKDTuWenSubCommentFragment localTKDTuWenSubCommentFragment = new TKDTuWenSubCommentFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", "https://viola.qq.com/js/TKDSubCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDSubCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react");
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    localTKDTuWenSubCommentFragment.setArguments(localBundle);
    return localTKDTuWenSubCommentFragment;
  }
  
  private void setVisibleToUser(boolean paramBoolean)
  {
    if (this.isVisibleToUser == paramBoolean) {
      return;
    }
    this.isVisibleToUser = paramBoolean;
    if (paramBoolean)
    {
      this.lifecycleDispatcher.onActivityResumed(getActivity());
      return;
    }
    this.lifecycleDispatcher.onActivityPaused(getActivity());
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher()
  {
    return this.lifecycleDispatcher;
  }
  
  public HippyMap getPropsMap()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    return this.eventDispatcher;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.mPresenter.a().a(false);
    super.initAfterVisible(paramBundle, paramViewGroup);
    paramViewGroup.setBackgroundColor(0);
    initEventDispatcher();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.lifecycleDispatcher.onActivityCreated(getActivity(), paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.lifecycleDispatcher.onActivityResult(getActivity(), paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.eventDispatcher.jsCloseComment();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      QLog.d("TKDTuWenSubCommentFragment", 1, "onCreate savedInstanceState not null");
      getActivity().finish();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.lifecycleDispatcher.onActivityDestroyed(getActivity());
    this.eventDispatcher.clear();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    setVisibleToUser(isVisible());
  }
  
  public boolean onHippyPageLoad(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onHippyPageLoad isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    QLog.d("TKDTuWenSubCommentFragment", 1, localStringBuilder.toString());
    paramString = this.hippyCommentPageListener;
    if (paramString != null) {
      paramString.a(paramBoolean);
    }
    return paramBoolean ^ true;
  }
  
  public void onPause()
  {
    super.onPause();
    setVisibleToUser(false);
  }
  
  public void onResume()
  {
    super.onResume();
    setVisibleToUser(isVisible());
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.lifecycleDispatcher.onActivitySaveInstanceState(getActivity(), paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.lifecycleDispatcher.onActivityStarted(getActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    this.lifecycleDispatcher.onActivityStopped(getActivity());
  }
  
  public void setAnchorData(AnchorData paramAnchorData)
  {
    this.anchorData = paramAnchorData;
  }
  
  public void setArticleInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.articleInfo = paramAbsBaseArticleInfo;
  }
  
  public void setContentSrc(int paramInt)
  {
    this.contentSrc = paramInt;
  }
  
  public void setHippyCommentPageListener(HippyCommentPageListener paramHippyCommentPageListener)
  {
    this.hippyCommentPageListener = paramHippyCommentPageListener;
  }
  
  public void setMainCommentId(String paramString)
  {
    this.mainCommentId = paramString;
  }
  
  public void setOpenCommentEditor(boolean paramBoolean)
  {
    this.openCommentEditor = paramBoolean;
  }
  
  public boolean shouldFinishActivity()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment.TKDTuWenSubCommentFragment
 * JD-Core Version:    0.7.0.1
 */