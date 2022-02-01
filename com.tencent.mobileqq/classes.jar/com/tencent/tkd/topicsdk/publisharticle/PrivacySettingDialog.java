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
import com.tencent.tkd.topicsdk.bean.PrivacySettingConfig;
import com.tencent.tkd.topicsdk.widget.SlidingUpDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PrivacySettingDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentPrivacy", "", "dialog", "Lcom/tencent/tkd/topicsdk/widget/SlidingUpDialog;", "dismissListener", "Lkotlin/Function1;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function1;", "setDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "extraDescView", "Landroid/widget/TextView;", "extraSelectView", "Landroid/widget/ImageView;", "extraTitleView", "privateDescView", "privateSelectView", "privateTitleView", "publicDescView", "publicSelectView", "publicTitleView", "changePrivacyAuthority", "privacy", "initFromConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/PrivacySettingConfig;", "show", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PrivacySettingDialog
{
  private int jdField_a_of_type_Int = 2;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlidingUpDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog;
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public PrivacySettingDialog(@NotNull Context paramContext)
  {
    View localView = View.inflate(paramContext, R.layout.f, null);
    Intrinsics.checkExpressionValueIsNotNull(localView, "reprintView");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog = new SlidingUpDialog(paramContext, localView, new RelativeLayout.LayoutParams(-1, -2));
    paramContext = localView.findViewById(R.id.R);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.O);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_content)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.Q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_select_view)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.P)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.1(this));
    paramContext = localView.findViewById(R.id.aT);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_title)");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.aQ);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_content)");
    this.d = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.aS);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_select_view)");
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.aR)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.2(this));
    paramContext = localView.findViewById(R.id.aP);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_title)");
    this.e = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.aM);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_content)");
    this.f = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.aO);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_select_view)");
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.aN)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.3(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog.setOnDismissListener((DialogInterface.OnDismissListener)new PrivacySettingDialog.2(this));
  }
  
  private final void a(int paramInt)
  {
    int j = 0;
    this.jdField_a_of_type_Int = paramInt;
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramInt == 1)
    {
      i = 0;
      localImageView.setVisibility(i);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramInt != 2) {
        break label71;
      }
      i = 0;
      label39:
      localImageView.setVisibility(i);
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramInt != 3) {
        break label77;
      }
    }
    label71:
    label77:
    for (paramInt = j;; paramInt = 8)
    {
      localImageView.setVisibility(paramInt);
      return;
      i = 8;
      break;
      i = 8;
      break label39;
    }
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetSlidingUpDialog.show();
  }
  
  public final void a(@NotNull PrivacySettingConfig paramPrivacySettingConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramPrivacySettingConfig, "config");
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramPrivacySettingConfig.getExtraTitle());
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramPrivacySettingConfig.getExtraDesc());
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)paramPrivacySettingConfig.getPublicTitle());
    this.d.setText((CharSequence)paramPrivacySettingConfig.getPublicDesc());
    this.e.setText((CharSequence)paramPrivacySettingConfig.getPrivateTitle());
    this.f.setText((CharSequence)paramPrivacySettingConfig.getPrivacyDesc());
    a(paramPrivacySettingConfig.getPrivacySetting());
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PrivacySettingDialog
 * JD-Core Version:    0.7.0.1
 */