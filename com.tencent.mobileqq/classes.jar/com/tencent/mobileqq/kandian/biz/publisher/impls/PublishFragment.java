package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.interfaces.IPage;
import com.tencent.tkd.topicsdk.interfaces.PageProxy;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PublishFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "pageProxy", "Lcom/tencent/tkd/topicsdk/interfaces/PageProxy;", "beforeFinish", "", "isWrapContent", "", "needImmersive", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onFinish", "onNewIntent", "intent", "onPause", "onResume", "onSaveInstanceState", "outState", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishFragment
  extends QPublicBaseFragment
{
  public static final PublishFragment.Companion a;
  private PageProxy a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsPublishFragment$Companion = new PublishFragment.Companion(null);
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.e();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.a(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      DispatchManager.a.a((IEvent)new ClickActionEvent(paramInt1, paramIntent));
    }
  }
  
  public boolean onBackEvent()
  {
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    return localPageProxy.c();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("pageId");
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      int i;
      if (((CharSequence)paramBundle).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {}
    }
    try
    {
      localObject = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
      localObject = ((QBaseActivity)localObject).getClassLoader().loadClass(paramBundle).newInstance();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy = ((PageProxy)localObject);
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
        }
        ((PageProxy)localObject).a((IPage)new PageImpl((QPublicBaseFragment)this));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.interfaces.PageProxy");
    }
    catch (Exception localException)
    {
      Object localObject;
      label134:
      StringBuilder localStringBuilder;
      break label134;
    }
    localObject = getActivity();
    if (localObject != null) {
      ((FragmentActivity)localObject).finish();
    }
    localObject = new LoggerImpl();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("init class ");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(" error");
    ((LoggerImpl)localObject).b("PublishFragment", localStringBuilder.toString(), null);
    return;
    paramBundle = getActivity();
    if (paramBundle != null) {
      paramBundle.finish();
    }
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    return localPageProxy.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.a();
  }
  
  public void onFinish()
  {
    super.onFinish();
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.d();
  }
  
  public void onNewIntent(@Nullable Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } else {
      paramIntent = null;
    }
    if (paramIntent != null)
    {
      boolean bool = ((Collection)paramIntent).isEmpty();
      int i = 1;
      if ((bool ^ true))
      {
        Object localObject = paramIntent.get(0);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "paths[0]");
        if (((CharSequence)localObject).length() <= 0) {
          i = 0;
        }
        if (i != 0) {
          DispatchManager.a.a((IEvent)new TopicCoverChangeEvent((String)paramIntent.get(0)));
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.b();
  }
  
  public void onResume()
  {
    super.onResume();
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.b();
  }
  
  public void onSaveInstanceState(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishFragment
 * JD-Core Version:    0.7.0.1
 */