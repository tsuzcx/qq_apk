package com.tencent.tkd.topicsdk.publisharticle;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.bean.ReprintAuthorityConfig;
import com.tencent.tkd.topicsdk.widget.SlidingUpDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/ReprintActionDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowReprintDescView", "Landroid/widget/TextView;", "allowReprintSelectView", "Landroid/widget/ImageView;", "allowReprintTitleView", "currentAllowReprint", "", "dialog", "Lcom/tencent/tkd/topicsdk/widget/SlidingUpDialog;", "dismissListener", "Lkotlin/Function1;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function1;", "setDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "forbidReprintDescView", "forbidReprintSelectView", "forbidReprintTitleView", "changeReprintAuthority", "allowReprint", "initFromConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/ReprintAuthorityConfig;", "show", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ReprintActionDialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlidingUpDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
  @Nullable
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean = true;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public ReprintActionDialog(@NotNull Context paramContext)
  {
    View localView = View.inflate(paramContext, R.layout.g, null);
    Intrinsics.checkExpressionValueIsNotNull(localView, "reprintView");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog = new SlidingUpDialog(paramContext, localView, new RelativeLayout.LayoutParams(-1, -2));
    paramContext = localView.findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.allow_reprint_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.allow_reprint_content)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.allow_reprint_select_view)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.g)).setOnClickListener((View.OnClickListener)new ReprintActionDialog..special..inlined.with.lambda.1(this));
    paramContext = localView.findViewById(R.id.W);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.forbid_reprint_title)");
    this.c = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.T);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.forbid_reprint_content)");
    this.d = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.V);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.forbid_reprint_select_view)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.U)).setOnClickListener((View.OnClickListener)new ReprintActionDialog..special..inlined.with.lambda.2(this));
    a(new ReprintAuthorityConfig());
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog.setOnDismissListener((DialogInterface.OnDismissListener)new ReprintActionDialog.2(this));
  }
  
  private final void a(boolean paramBoolean)
  {
    int j = 8;
    this.jdField_a_of_type_Boolean = paramBoolean;
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = j;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  @Nullable
  public final Function1<Boolean, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog.show();
  }
  
  public final void a(@NotNull ReprintAuthorityConfig paramReprintAuthorityConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramReprintAuthorityConfig, "config");
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramReprintAuthorityConfig.getAllowReprintTitle());
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramReprintAuthorityConfig.getAllowReprintDesc());
    this.c.setText((CharSequence)paramReprintAuthorityConfig.getForbidReprintTitle());
    this.d.setText((CharSequence)paramReprintAuthorityConfig.getForbidReprintDesc());
    a(paramReprintAuthorityConfig.getAllowReprint());
  }
  
  public final void a(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.ReprintActionDialog
 * JD-Core Version:    0.7.0.1
 */