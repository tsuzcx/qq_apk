package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PublishFragment;", "Lcom/tencent/mobileqq/fragment/PublicBaseFragment;", "()V", "pageProxy", "Lcom/tencent/tkd/topicsdk/interfaces/PageProxy;", "beforeFinish", "", "needImmersive", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onFinish", "onNewIntent", "intent", "onPause", "onResume", "onSaveInstanceState", "outState", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishFragment
  extends PublicBaseFragment
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
    return localPageProxy.e();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("pageId");
      if (paramBundle != null) {
        if (((CharSequence)paramBundle).length() != 0) {
          break label56;
        }
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label61;
      }
      getActivity().finish();
      return;
      paramBundle = null;
      break;
    }
    try
    {
      label61:
      Object localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      localObject = ((FragmentActivity)localObject).getClassLoader().loadClass(paramBundle).newInstance();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.interfaces.PageProxy");
      }
    }
    catch (Exception localException)
    {
      getActivity().finish();
      new LoggerImpl().b("PublishFragment", "init class " + paramBundle + " error", null);
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy = ((PageProxy)localException);
    PageProxy localPageProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesPageProxy;
    if (localPageProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("pageProxy");
    }
    localPageProxy.a((IPage)new PageImpl((Fragment)this));
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
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if (paramIntent != null)
      {
        if (((Collection)paramIntent).isEmpty()) {
          break label98;
        }
        i = 1;
        label34:
        if (i != 0)
        {
          Object localObject = paramIntent.get(0);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "paths[0]");
          if (((CharSequence)localObject).length() <= 0) {
            break label103;
          }
        }
      }
    }
    label98:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        DispatchManager.a.a((IEvent)new TopicCoverChangeEvent((String)paramIntent.get(0)));
      }
      return;
      paramIntent = null;
      break;
      i = 0;
      break label34;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishFragment
 * JD-Core Version:    0.7.0.1
 */