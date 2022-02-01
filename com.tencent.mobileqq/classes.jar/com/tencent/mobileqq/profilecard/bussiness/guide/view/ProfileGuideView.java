package com.tencent.mobileqq.profilecard.bussiness.guide.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.utils.ProfileUIUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "closeButton", "Landroid/widget/ImageView;", "contentView", "Landroid/view/View;", "fillButton", "Landroid/widget/Button;", "fillLayout", "fillMainMsgView", "Landroid/widget/TextView;", "fillSecondaryMsgView", "updateArrow", "updateLayout", "updateMainMsgView", "initViews", "", "onClick", "view", "setClickListener", "setFillGuide", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "setUpdateGuide", "updateProfileGuide", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideView
  extends FrameLayout
  implements View.OnClickListener
{
  public static final ProfileGuideView.Companion Companion = new ProfileGuideView.Companion(null);
  @NotNull
  public static final String TAG = "ProfileGuideView";
  private HashMap _$_findViewCache;
  private ProfileGuideClickListener clickListener;
  private ImageView closeButton;
  private View contentView;
  private Button fillButton;
  private View fillLayout;
  private TextView fillMainMsgView;
  private TextView fillSecondaryMsgView;
  private ImageView updateArrow;
  private View updateLayout;
  private TextView updateMainMsgView;
  
  public ProfileGuideView(@NotNull Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public ProfileGuideView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  public ProfileGuideView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initViews();
  }
  
  private final void initViews()
  {
    LayoutInflater.from(getContext()).inflate(2131627675, (ViewGroup)this, true);
    Object localObject1 = findViewById(2131431322);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.content)");
    this.contentView = ((View)localObject1);
    localObject1 = findViewById(2131433153);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.fill_layout)");
    this.fillLayout = ((View)localObject1);
    localObject1 = findViewById(2131433154);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.fill_main_msg)");
    this.fillMainMsgView = ((TextView)localObject1);
    localObject1 = findViewById(2131433155);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.fill_secondary_msg)");
    this.fillSecondaryMsgView = ((TextView)localObject1);
    localObject1 = findViewById(2131433151);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "findViewById(R.id.fill_btn)");
    this.fillButton = ((Button)localObject1);
    localObject1 = this.fillButton;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillButton");
    }
    ((Button)localObject1).setOnTouchListener((View.OnTouchListener)ProfileUIUtils.ALPHA_TOUCH_LISTENER);
    Object localObject2 = this.fillButton;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillButton");
    }
    localObject1 = (View.OnClickListener)this;
    ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = findViewById(2131449140);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "findViewById(R.id.update_layout)");
    this.updateLayout = ((View)localObject2);
    localObject2 = this.updateLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    ((View)localObject2).setOnTouchListener((View.OnTouchListener)ProfileUIUtils.ALPHA_TOUCH_LISTENER);
    localObject2 = this.updateLayout;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = findViewById(2131449141);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "findViewById(R.id.update_main_msg)");
    this.updateMainMsgView = ((TextView)localObject2);
    localObject2 = findViewById(2131449138);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "findViewById(R.id.update_arrow)");
    this.updateArrow = ((ImageView)localObject2);
    localObject2 = findViewById(2131435536);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "findViewById(R.id.img_close)");
    this.closeButton = ((ImageView)localObject2);
    localObject2 = this.closeButton;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeButton");
    }
    ((ImageView)localObject2).setOnTouchListener((View.OnTouchListener)ProfileUIUtils.ALPHA_TOUCH_LISTENER);
    localObject2 = this.closeButton;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeButton");
    }
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)localObject1);
  }
  
  private final void setFillGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject = this.contentView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentView");
    }
    ((View)localObject).setBackgroundResource(2130847402);
    localObject = this.fillLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillLayout");
    }
    int i = 0;
    ((View)localObject).setVisibility(0);
    localObject = this.fillMainMsgView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillMainMsgView");
    }
    ((TextView)localObject).setText((CharSequence)paramProfileGuide.getGuideMainMsg());
    if (TextUtils.isEmpty((CharSequence)paramProfileGuide.getGuideSecondaryMsg())) {
      i = 8;
    }
    localObject = this.fillSecondaryMsgView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillSecondaryMsgView");
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.fillSecondaryMsgView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillSecondaryMsgView");
    }
    ((TextView)localObject).setText((CharSequence)paramProfileGuide.getGuideSecondaryMsg());
    paramProfileGuide = this.updateLayout;
    if (paramProfileGuide == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    paramProfileGuide.setVisibility(8);
  }
  
  private final void setUpdateGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject = this.contentView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentView");
    }
    ((View)localObject).setBackgroundResource(2130847403);
    localObject = this.fillLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillLayout");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.updateLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.updateMainMsgView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateMainMsgView");
    }
    ((TextView)localObject).setText((CharSequence)paramProfileGuide.getGuideMainMsg());
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this._$_findViewCache;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject;
    if (paramView != null) {
      localObject = Integer.valueOf(paramView.getId());
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Integer)localObject).intValue() == 2131433151))
    {
      localObject = this.clickListener;
      if (localObject != null) {
        ((ProfileGuideClickListener)localObject).onFillClick();
      }
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 2131449140))
    {
      localObject = this.clickListener;
      if (localObject != null) {
        ((ProfileGuideClickListener)localObject).onUpdateClick();
      }
    }
    else if ((localObject != null) && (((Integer)localObject).intValue() == 2131435536))
    {
      localObject = this.clickListener;
      if (localObject != null) {
        ((ProfileGuideClickListener)localObject).onCloseClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public final void setClickListener(@NotNull ProfileGuideClickListener paramProfileGuideClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileGuideClickListener, "clickListener");
    this.clickListener = paramProfileGuideClickListener;
  }
  
  public final void updateProfileGuide(@NotNull ProfileGuide paramProfileGuide)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileGuide, "profileGuide");
    if (paramProfileGuide.getGuideType() == 1)
    {
      setFillGuide(paramProfileGuide);
      return;
    }
    if (paramProfileGuide.getGuideType() == 2) {
      setUpdateGuide(paramProfileGuide);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideView
 * JD-Core Version:    0.7.0.1
 */