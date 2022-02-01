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
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "closeButton", "Landroid/widget/ImageView;", "contentView", "Landroid/view/View;", "fillButton", "Landroid/widget/Button;", "fillLayout", "fillMainMsgView", "Landroid/widget/TextView;", "fillSecondaryMsgView", "updateArrow", "updateLayout", "updateMainMsgView", "initViews", "", "onClick", "view", "setClickListener", "setFillGuide", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "setUpdateGuide", "updateProfileGuide", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    LayoutInflater.from(getContext()).inflate(2131561475, (ViewGroup)this, true);
    Object localObject = findViewById(2131365294);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.content)");
    this.contentView = ((View)localObject);
    localObject = findViewById(2131366969);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.fill_layout)");
    this.fillLayout = ((View)localObject);
    localObject = findViewById(2131366970);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.fill_main_msg)");
    this.fillMainMsgView = ((TextView)localObject);
    localObject = findViewById(2131366971);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.fill_secondary_msg)");
    this.fillSecondaryMsgView = ((TextView)localObject);
    localObject = findViewById(2131366967);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.fill_btn)");
    this.fillButton = ((Button)localObject);
    localObject = this.fillButton;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillButton");
    }
    ((Button)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    localObject = this.fillButton;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillButton");
    }
    ((Button)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = findViewById(2131380956);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.update_layout)");
    this.updateLayout = ((View)localObject);
    localObject = this.updateLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    ((View)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    localObject = this.updateLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("updateLayout");
    }
    ((View)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = findViewById(2131380957);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.update_main_msg)");
    this.updateMainMsgView = ((TextView)localObject);
    localObject = findViewById(2131380954);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.update_arrow)");
    this.updateArrow = ((ImageView)localObject);
    localObject = findViewById(2131368898);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.img_close)");
    this.closeButton = ((ImageView)localObject);
    localObject = this.closeButton;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeButton");
    }
    ((ImageView)localObject).setOnTouchListener((View.OnTouchListener)UITools.a);
    localObject = this.closeButton;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeButton");
    }
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
  }
  
  private final void setFillGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject = this.contentView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentView");
    }
    ((View)localObject).setBackgroundResource(2130846057);
    localObject = this.fillLayout;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillLayout");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.fillMainMsgView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("fillMainMsgView");
    }
    ((TextView)localObject).setText((CharSequence)paramProfileGuide.getGuideMainMsg());
    if (TextUtils.isEmpty((CharSequence)paramProfileGuide.getGuideSecondaryMsg())) {}
    for (int i = 8;; i = 0)
    {
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
      return;
    }
  }
  
  private final void setUpdateGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject = this.contentView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("contentView");
    }
    ((View)localObject).setBackgroundResource(2130846058);
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
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
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
    if (paramView != null)
    {
      localObject = Integer.valueOf(paramView.getId());
      if (localObject != null) {
        break label37;
      }
      label16:
      if (localObject != null) {
        break label64;
      }
      label20:
      if (localObject != null) {
        break label91;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = null;
      break;
      label37:
      if (((Integer)localObject).intValue() != 2131366967) {
        break label16;
      }
      localObject = this.clickListener;
      if (localObject != null)
      {
        ((ProfileGuideClickListener)localObject).onFillClick();
        continue;
        label64:
        if (((Integer)localObject).intValue() != 2131380956) {
          break label20;
        }
        localObject = this.clickListener;
        if (localObject != null)
        {
          ((ProfileGuideClickListener)localObject).onUpdateClick();
          continue;
          label91:
          if (((Integer)localObject).intValue() == 2131368898)
          {
            localObject = this.clickListener;
            if (localObject != null) {
              ((ProfileGuideClickListener)localObject).onCloseClick();
            }
          }
        }
      }
    }
  }
  
  public final void setClickListener(@NotNull ProfileGuideClickListener paramProfileGuideClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileGuideClickListener, "clickListener");
    this.clickListener = paramProfileGuideClickListener;
  }
  
  public final void updateProfileGuide(@NotNull ProfileGuide paramProfileGuide)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileGuide, "profileGuide");
    if (paramProfileGuide.getGuideType() == 1) {
      setFillGuide(paramProfileGuide);
    }
    while (paramProfileGuide.getGuideType() != 2) {
      return;
    }
    setUpdateGuide(paramProfileGuide);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideView
 * JD-Core Version:    0.7.0.1
 */