package com.tencent.tkd.weibo.atContact;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.tkd.weibo.R.id;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.BasePopupView;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/AtContactView;", "Lcom/tencent/tkd/weibo/framework/BasePopupView;", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Landroid/view/View$OnClickListener;", "parentView", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/view/ViewGroup;Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelView", "Landroid/widget/TextView;", "contactFlagListener", "com/tencent/tkd/weibo/atContact/AtContactView$contactFlagListener$1", "Lcom/tencent/tkd/weibo/atContact/AtContactView$contactFlagListener$1;", "myFansContainer", "Landroid/widget/RelativeLayout;", "myFansListView", "Lcom/tencent/tkd/weibo/atContact/MyFansListView;", "myFansTipsView", "Landroid/view/View;", "myFansView", "myFollowContainer", "myFollowListView", "Lcom/tencent/tkd/weibo/atContact/MyFollowListView;", "myFollowTipsView", "myFollowView", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPagerAdapter", "com/tencent/tkd/weibo/atContact/AtContactView$viewPagerAdapter$1", "Lcom/tencent/tkd/weibo/atContact/AtContactView$viewPagerAdapter$1;", "initColor", "", "initView", "onAttachedToWindow", "onClick", "v", "onDetachedFromWindow", "setCurrentItem", "tabID", "", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class AtContactView
  extends BasePopupView<EditObject>
  implements View.OnClickListener
{
  public static final AtContactView.Companion a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private final AtContactView.contactFlagListener.1 jdField_a_of_type_ComTencentTkdWeiboAtContactAtContactView$contactFlagListener$1;
  private MyFansListView jdField_a_of_type_ComTencentTkdWeiboAtContactMyFansListView;
  private MyFollowListView jdField_a_of_type_ComTencentTkdWeiboAtContactMyFollowListView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboAtContactAtContactView$Companion = new AtContactView.Companion(null);
  }
  
  private final void a(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFollowView");
      }
      ((TextView)localObject).setTextColor(a(UiComponentSdkKt.a().c()));
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFollowTipsView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFansView");
      }
      ((TextView)localObject).setTextColor(a(UiComponentSdkKt.a().d()));
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFansTipsView");
      }
      ((View)localObject).setVisibility(4);
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFollowView");
    }
    ((TextView)localObject).setTextColor(a(UiComponentSdkKt.a().d()));
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFollowTipsView");
    }
    ((View)localObject).setVisibility(4);
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFansView");
    }
    ((TextView)localObject).setTextColor(a(UiComponentSdkKt.a().c()));
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFansTipsView");
    }
    ((View)localObject).setVisibility(0);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DataTransferManager.a.a((Function2)this.jdField_a_of_type_ComTencentTkdWeiboAtContactAtContactView$contactFlagListener$1);
  }
  
  public void onClick(@Nullable View paramView)
  {
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = R.id.h;
      if (paramView != null) {
        break label42;
      }
      label20:
      i = R.id.g;
      if (paramView != null) {
        break label75;
      }
      label28:
      i = R.id.j;
      if (paramView != null) {
        break label108;
      }
    }
    label42:
    label75:
    label108:
    while (paramView.intValue() != i)
    {
      return;
      paramView = null;
      break;
      if (paramView.intValue() != i) {
        break label20;
      }
      a(0);
      paramView = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      paramView.setCurrentItem(0);
      return;
      if (paramView.intValue() != i) {
        break label28;
      }
      a(1);
      paramView = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      paramView.setCurrentItem(1);
      return;
    }
    a(null);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DataTransferManager.a.b((Function2)this.jdField_a_of_type_ComTencentTkdWeiboAtContactAtContactView$contactFlagListener$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtContactView
 * JD-Core Version:    0.7.0.1
 */