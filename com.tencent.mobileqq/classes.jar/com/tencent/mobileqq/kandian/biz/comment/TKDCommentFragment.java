package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenCommentUtil;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment;", "Lcom/tencent/mobileqq/kandian/biz/viola/view/ViolaFragment;", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleOwner;", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/ITKDHippyEventDispatcherOwner;", "()V", "adTag", "", "getAdTag", "()I", "setAdTag", "(I)V", "anchorData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;", "getAnchorData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;", "setAnchorData", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;)V", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "biuType", "getBiuType", "setBiuType", "commentEventListener", "com/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment$commentEventListener$1", "Lcom/tencent/mobileqq/kandian/biz/comment/TKDCommentFragment$commentEventListener$1;", "commentState", "getCommentState", "setCommentState", "commentTopGestureLayout", "Lcom/tencent/mobileqq/kandian/biz/comment/FlingExitLayout;", "getCommentTopGestureLayout", "()Lcom/tencent/mobileqq/kandian/biz/comment/FlingExitLayout;", "setCommentTopGestureLayout", "(Lcom/tencent/mobileqq/kandian/biz/comment/FlingExitLayout;)V", "container", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "setContainer", "(Landroid/view/ViewGroup;)V", "contentSrc", "getContentSrc", "setContentSrc", "dispatcher", "Lcom/tencent/hippy/qq/fragment/HippyActivityLifecycleDispatcher;", "eventDispatcher", "Lcom/tencent/mobileqq/kandian/biz/hippy/interfaces/dispatcher/ITKDHippyEventDispatcher;", "hippyCommentPageListener", "Lcom/tencent/mobileqq/kandian/biz/comment/HippyCommentPageListener;", "getHippyCommentPageListener", "()Lcom/tencent/mobileqq/kandian/biz/comment/HippyCommentPageListener;", "setHippyCommentPageListener", "(Lcom/tencent/mobileqq/kandian/biz/comment/HippyCommentPageListener;)V", "isEdit", "", "()Z", "setEdit", "(Z)V", "getActivityLifecycleDispatcher", "getHippyListView", "Lcom/tencent/mtt/hippy/views/list/HippyListView;", "viewGroup", "getJsPropsMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "getPropsMap", "getTKDHippyEventDispatcher", "initAfterVisible", "", "bundle", "Landroid/os/Bundle;", "contentView", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCreateFragment", "onDestroy", "onDestroyView", "onHippyPageLoad", "isSuccess", "errMsg", "", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "setGestureLayout", "shouldFinishActivity", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDCommentFragment
  extends ViolaFragment
  implements HippyActivityLifecycleOwner, ITKDHippyEventDispatcherOwner
{
  public static final TKDCommentFragment.Companion a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "TKDCommentFragment";
  @NotNull
  private static final String jdField_b_of_type_JavaLangString = "TKDComment";
  private static final int e = -1;
  private static final int f = 0;
  private static final int g = 1;
  private int jdField_a_of_type_Int;
  @Nullable
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final HippyActivityLifecycleDispatcher jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher = new HippyActivityLifecycleDispatcher();
  @Nullable
  private FlingExitLayout jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout;
  @Nullable
  private HippyCommentPageListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentHippyCommentPageListener;
  private final TKDCommentFragment.commentEventListener.1 jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment$commentEventListener$1 = new TKDCommentFragment.commentEventListener.1(this);
  @Nullable
  private AnchorData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData;
  private ITKDHippyEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher = (ITKDHippyEventDispatcher)new TKDHippyEventDispatcher();
  @Nullable
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = f;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment$Companion = new TKDCommentFragment.Companion(null);
  }
  
  @JvmStatic
  @NotNull
  public static final TKDCommentFragment a(@Nullable String paramString, @Nullable SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment$Companion.a(paramString, paramSerializableMap, paramBoolean);
  }
  
  public final int a()
  {
    return this.c;
  }
  
  @Nullable
  public final FlingExitLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout;
  }
  
  @Nullable
  public final AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  @NotNull
  public final HippyMap a()
  {
    return getPropsMap();
  }
  
  @Nullable
  public final HippyListView a(@Nullable ViewGroup paramViewGroup)
  {
    return (HippyListView)TKDTuWenCommentUtil.rFindView((View)paramViewGroup, HippyListView.class);
  }
  
  public final void a()
  {
    FlingExitLayout localFlingExitLayout = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout;
    if (localFlingExitLayout != null) {
      localFlingExitLayout.setRecyclerView((RecyclerView)a((ViewGroup)localFlingExitLayout), this.jdField_b_of_type_Int);
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable FlingExitLayout paramFlingExitLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentFlingExitLayout = paramFlingExitLayout;
  }
  
  public final void a(@Nullable HippyCommentPageListener paramHippyCommentPageListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentHippyCommentPageListener = paramHippyCommentPageListener;
  }
  
  public final void a(@Nullable AnchorData paramAnchorData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityAnchorData = paramAnchorData;
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.jsCloseComment();
    return this.jdField_b_of_type_Int == g;
  }
  
  public final int b()
  {
    return this.d;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher()
  {
    return this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher;
  }
  
  @NotNull
  public HippyMap getPropsMap()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher;
  }
  
  public void initAfterVisible(@Nullable Bundle paramBundle, @Nullable ViewGroup paramViewGroup)
  {
    Object localObject = this.mPresenter;
    if (localObject != null)
    {
      localObject = ((IViolaFragmentPresenter)localObject).a();
      if (localObject != null) {
        ((IViolaUiDelegate)localObject).a(false);
      }
    }
    super.initAfterVisible(paramBundle, paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.setBackgroundColor(0);
    }
    if ((this.mHippyQQEngine instanceof ITKDHippyEventDispatcherOwner))
    {
      paramBundle = this.mHippyQQEngine;
      if (paramBundle != null)
      {
        paramBundle = ((ITKDHippyEventDispatcherOwner)paramBundle).getTKDHippyEventDispatcher();
        Intrinsics.checkExpressionValueIsNotNull(paramBundle, "(mHippyQQEngine as ITKDH…).tkdHippyEventDispatcher");
        paramBundle.merge(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.register((ITKDHippyEventReceiver)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentTKDCommentFragment$commentEventListener$1);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner");
    }
    ReadInJoyHelper.a(jdField_a_of_type_JavaLangString, (Throwable)new IllegalStateException("initAfterVisible: not find tkdHippyEventDispatcher"));
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityCreated((Activity)getQBaseActivity(), paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityResult((Activity)getQBaseActivity(), paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreateFragment(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    super.onCreateFragment(paramViewGroup);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesDispatcherITKDHippyEventDispatcher.clear();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityDestroyed((Activity)getQBaseActivity());
  }
  
  public boolean onHippyPageLoad(boolean paramBoolean, @Nullable String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onHippyPageLoad] isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentHippyCommentPageListener;
    if (paramString != null) {
      paramString.a(paramBoolean);
    }
    return !paramBoolean;
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityPaused((Activity)getQBaseActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityResumed((Activity)getQBaseActivity());
  }
  
  public void onSaveInstanceState(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivitySaveInstanceState((Activity)getQBaseActivity(), paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityStarted((Activity)getQBaseActivity());
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyActivityLifecycleDispatcher.onActivityStopped((Activity)getQBaseActivity());
  }
  
  public boolean shouldFinishActivity()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragment
 * JD-Core Version:    0.7.0.1
 */