package com.tencent.tkd.weibo.atContact;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.tkd.weibo.UiComponentSdkKt;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.component.R.id;
import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.BasePopupView;
import com.tencent.tkd.weibo.framework.color.IComponentColorStrategy;
import java.util.HashMap;
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
  public static final AtContactView.Companion a = new AtContactView.Companion(null);
  private TextView c;
  private View d;
  private TextView e;
  private View f;
  private ViewPager g;
  private MyFollowListView h;
  private MyFansListView i;
  private final AtContactView.contactFlagListener.1 j;
  private HashMap k;
  
  private final void setCurrentItem(int paramInt)
  {
    if (paramInt == 0)
    {
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFollowView");
      }
      ((TextView)localObject).setTextColor(b(UiComponentSdkKt.a().d()));
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFollowTipsView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.e;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFansView");
      }
      ((TextView)localObject).setTextColor(b(UiComponentSdkKt.a().e()));
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("myFansTipsView");
      }
      ((View)localObject).setVisibility(4);
      return;
    }
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFollowView");
    }
    ((TextView)localObject).setTextColor(b(UiComponentSdkKt.a().e()));
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFollowTipsView");
    }
    ((View)localObject).setVisibility(4);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFansView");
    }
    ((TextView)localObject).setTextColor(b(UiComponentSdkKt.a().d()));
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("myFansTipsView");
    }
    ((View)localObject).setVisibility(0);
  }
  
  public View a(int paramInt)
  {
    if (this.k == null) {
      this.k = new HashMap();
    }
    View localView2 = (View)this.k.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.k.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    DataTransferManager.a.a((Function2)this.j);
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    int m = R.id.e;
    if ((paramView != null) && (paramView.intValue() == m))
    {
      setCurrentItem(0);
      paramView = this.g;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      paramView.setCurrentItem(0);
      return;
    }
    m = R.id.d;
    if ((paramView != null) && (paramView.intValue() == m))
    {
      setCurrentItem(1);
      paramView = this.g;
      if (paramView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
      }
      paramView.setCurrentItem(1);
      return;
    }
    m = R.id.h;
    if (paramView == null) {
      return;
    }
    if (paramView.intValue() == m) {
      a(null);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    DataTransferManager.a.b((Function2)this.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.AtContactView
 * JD-Core Version:    0.7.0.1
 */