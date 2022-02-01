package com.tencent.tkd.topicsdk.entry.square;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.tkd.topicsdk.entry.IEntryViewBridge;
import com.tencent.tkd.topicsdk.entry.R.id;
import com.tencent.tkd.topicsdk.entry.R.layout;
import com.tencent.tkd.topicsdk.widget.SquareProgressView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/entry/square/SquareEntryView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/tkd/topicsdk/entry/square/ISquareEntryView;", "context", "Landroid/content/Context;", "bridge", "Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "innerBundle", "Landroid/os/Bundle;", "outerBundle", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;Landroid/os/Bundle;Landroid/os/Bundle;)V", "getBridge", "()Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;", "setBridge", "(Lcom/tencent/tkd/topicsdk/entry/IEntryViewBridge;)V", "cancelView", "Landroid/view/View;", "value", "Landroid/view/View$OnClickListener;", "cancelViewClickListener", "getCancelViewClickListener", "()Landroid/view/View$OnClickListener;", "setCancelViewClickListener", "(Landroid/view/View$OnClickListener;)V", "coverImageView", "Landroid/widget/ImageView;", "currentStatus", "", "getCurrentStatus", "()I", "setCurrentStatus", "(I)V", "entryLayout", "firstSubDraftView", "firstSubEntryLayout", "firstSubViewClickListener", "getFirstSubViewClickListener", "setFirstSubViewClickListener", "getInnerBundle", "()Landroid/os/Bundle;", "setInnerBundle", "(Landroid/os/Bundle;)V", "isFirstSubViewShowing", "", "isSecondSubViewShowing", "mainEntryDraftView", "mainEntryView", "mainViewClickListener", "getMainViewClickListener", "setMainViewClickListener", "Landroid/view/View$OnLongClickListener;", "mainViewLongClickListener", "getMainViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMainViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "getOuterBundle", "setOuterBundle", "progressLayout", "progressView", "Lcom/tencent/tkd/topicsdk/widget/SquareProgressView;", "retryLayout", "retryView", "retryViewClickListener", "getRetryViewClickListener", "setRetryViewClickListener", "secondSubEntryLayout", "secondSubViewClickListener", "getSecondSubViewClickListener", "setSecondSubViewClickListener", "secondSubViewLongClickListener", "getSecondSubViewLongClickListener", "setSecondSubViewLongClickListener", "successLayout", "successView", "uploadLayout", "getCancelViewAnimation", "Landroid/view/animation/AnimationSet;", "getMainViewAnimation", "Landroid/view/animation/RotateAnimation;", "isReverse", "postDelayMs", "", "getProgressLayoutAnimation", "Landroid/view/animation/ScaleAnimation;", "animationCallback", "Lkotlin/Function0;", "", "getSubViewAnimationSet", "view", "translateStartY", "", "translateEndY", "durationMs", "hideMainEntryView", "hidePublishLayout", "needAnimation", "hideSubEntryView", "reset", "resetProgressView", "showMainEntryView", "showPublishLayout", "showRetryStatus", "showSubEntryView", "showFirstSubView", "showSecondSubView", "showSuccessStatus", "updateData", "updateProgress", "progress", "updatePublishCover", "coverPath", "", "Companion", "topicsdk-entryview_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public class SquareEntryView
  extends RelativeLayout
  implements ISquareEntryView
{
  public static final SquareEntryView.Companion a;
  private int jdField_a_of_type_Int;
  @Nullable
  private Bundle jdField_a_of_type_AndroidOsBundle;
  @Nullable
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  @Nullable
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  @NotNull
  private IEntryViewBridge jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge;
  private SquareProgressView jdField_a_of_type_ComTencentTkdTopicsdkWidgetSquareProgressView;
  @Nullable
  private Bundle jdField_b_of_type_AndroidOsBundle;
  @Nullable
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  @Nullable
  private View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  @Nullable
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  @Nullable
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  @Nullable
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private RelativeLayout f;
  private RelativeLayout g;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkEntrySquareSquareEntryView$Companion = new SquareEntryView.Companion(null);
  }
  
  public SquareEntryView(@NotNull Context paramContext, @NotNull IEntryViewBridge paramIEntryViewBridge, @Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge = paramIEntryViewBridge;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
    LayoutInflater.from(paramContext).inflate(R.layout.b, (ViewGroup)this, true);
    paramContext = findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_entry)");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_main_entry)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.k);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_main_entry_draft)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_first_sub_entry)");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_first_sub_entry_draft)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.s);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_second_sub_entry)");
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.u);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_upload)");
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.A);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_layout)");
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.t);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_success)");
    this.f = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_success)");
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.layout_retry)");
    this.g = ((RelativeLayout)paramContext);
    paramContext = findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_retry)");
    this.jdField_b_of_type_AndroidViewView = paramContext;
    paramContext = findViewById(R.id.o);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_upload)");
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    paramContext = findViewById(R.id.B);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSquareProgressView = ((SquareProgressView)paramContext);
    paramContext = findViewById(R.id.g);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.iv_cancel)");
    this.jdField_c_of_type_AndroidViewView = paramContext;
  }
  
  public void a(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle1;
    this.jdField_b_of_type_AndroidOsBundle = paramBundle2;
  }
  
  public void setBridge(@NotNull IEntryViewBridge paramIEntryViewBridge)
  {
    Intrinsics.checkParameterIsNotNull(paramIEntryViewBridge, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkEntryIEntryViewBridge = paramIEntryViewBridge;
  }
  
  public final void setCancelViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_e_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setFirstSubViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
  }
  
  public final void setInnerBundle(@Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public final void setMainViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public final void setMainViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
  }
  
  public final void setOuterBundle(@Nullable Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidOsBundle = paramBundle;
  }
  
  public final void setRetryViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_d_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSecondSubViewClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
  }
  
  public final void setSecondSubViewLongClickListener(@Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.square.SquareEntryView
 * JD-Core Version:    0.7.0.1
 */