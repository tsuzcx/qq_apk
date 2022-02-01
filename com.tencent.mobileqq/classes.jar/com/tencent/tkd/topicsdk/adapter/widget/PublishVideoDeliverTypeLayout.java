package com.tencent.tkd.topicsdk.adapter.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.qq_adapter.R.color;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import com.tencent.tkd.topicsdk.qq_adapter.R.string;
import com.tencent.tkd.topicsdk.widget.CommonDialogBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "deliverPermissionCheckBox", "Landroid/widget/CheckBox;", "deliverPermissionLayout", "value", "Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout$DeliverType;", "deliverType", "getDeliverType", "()Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout$DeliverType;", "setDeliverType", "(Lcom/tencent/tkd/topicsdk/adapter/widget/PublishVideoDeliverTypeLayout$DeliverType;)V", "divideLine", "Landroid/view/View;", "", "prohibitReprint", "getProhibitReprint", "()Z", "setProhibitReprint", "(Z)V", "reprintDeliverTypeRadioButton", "Landroid/widget/RadioButton;", "selfDeliverTypeRadioButton", "hideDeliverPermissionLayout", "", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onClick", "v", "setProhibitPrintChecked", "setTypeChecked", "showDeliverPermissionLayout", "showDeliverTypeInfoDialog", "DeliverType", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class PublishVideoDeliverTypeLayout
  extends LinearLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private RadioButton a;
  private RadioButton b;
  private LinearLayout c;
  private CheckBox d;
  private View e;
  private boolean f = true;
  @NotNull
  private PublishVideoDeliverTypeLayout.DeliverType g = PublishVideoDeliverTypeLayout.DeliverType.Default;
  
  public PublishVideoDeliverTypeLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.f, (ViewGroup)this, true);
    paramContext = findViewById(R.id.j);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.deliver_type_info)");
    paramContext = (ImageView)paramContext;
    paramAttributeSet = findViewById(R.id.i);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.deliver_self_type)");
    this.a = ((RadioButton)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.h);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.deliver_reprint_type)");
    this.b = ((RadioButton)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.g);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.deliver_permission_layout)");
    this.c = ((LinearLayout)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.f);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.deliver_permission_checkbox)");
    this.d = ((CheckBox)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.l);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.divide_line)");
    this.e = paramAttributeSet;
    paramAttributeSet = this.d;
    if (paramAttributeSet == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
    }
    paramAttributeSet.setChecked(true);
    a();
    paramAttributeSet = (View.OnClickListener)this;
    paramContext.setOnClickListener(paramAttributeSet);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("reprintDeliverTypeRadioButton");
    }
    paramContext.setOnClickListener(paramAttributeSet);
    paramContext = this.a;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfDeliverTypeRadioButton");
    }
    paramContext.setOnClickListener(paramAttributeSet);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
    }
    paramContext.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)this);
  }
  
  private final void a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionLayout");
    }
    ((LinearLayout)localObject).setVisibility(8);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("divideLine");
    }
    ((View)localObject).setVisibility(8);
  }
  
  private final void b()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionLayout");
    }
    ((LinearLayout)localObject).setVisibility(0);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("divideLine");
    }
    ((View)localObject).setVisibility(0);
  }
  
  private final void c()
  {
    Object localObject = this.g;
    int i = PublishVideoDeliverTypeLayout.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a();
        return;
      }
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("reprintDeliverTypeRadioButton");
      }
      if (!((RadioButton)localObject).isChecked())
      {
        localObject = this.b;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("reprintDeliverTypeRadioButton");
        }
        ((RadioButton)localObject).setChecked(true);
      }
      a();
      return;
    }
    localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("selfDeliverTypeRadioButton");
    }
    if (!((RadioButton)localObject).isChecked())
    {
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("selfDeliverTypeRadioButton");
      }
      ((RadioButton)localObject).setChecked(true);
    }
    b();
  }
  
  private final void d()
  {
    CheckBox localCheckBox;
    if (this.f)
    {
      localCheckBox = this.d;
      if (localCheckBox == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
      }
      if (!localCheckBox.isChecked())
      {
        localCheckBox = this.d;
        if (localCheckBox == null) {
          Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
        }
        localCheckBox.setChecked(true);
      }
    }
    else
    {
      localCheckBox = this.d;
      if (localCheckBox == null) {
        Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
      }
      if (localCheckBox.isChecked())
      {
        localCheckBox = this.d;
        if (localCheckBox == null) {
          Intrinsics.throwUninitializedPropertyAccessException("deliverPermissionCheckBox");
        }
        localCheckBox.setChecked(false);
      }
    }
  }
  
  private final void e()
  {
    Object localObject1 = getResources().getString(R.string.g);
    Object localObject2 = getResources().getString(R.string.f);
    String str = getResources().getString(R.string.e);
    TextView localTextView = new TextView(getContext());
    localTextView.setText((CharSequence)localObject2);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(localTextView.getResources().getColor(R.color.b));
    localObject2 = DisplayUtils.a;
    Context localContext = localTextView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject2).a(25.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = localTextView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int j = ((DisplayUtils)localObject2).a(20.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = localTextView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int k = ((DisplayUtils)localObject2).a(25.0F, localContext);
    localObject2 = DisplayUtils.a;
    localContext = localTextView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localTextView.setPadding(i, j, k, ((DisplayUtils)localObject2).a(15.0F, localContext));
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new CommonDialogBuilder((Context)localObject2).a((String)localObject1).a(getResources().getColor(R.color.c));
    localObject2 = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    CommonDialogBuilder.a(((CommonDialogBuilder)localObject1).c(((DisplayUtils)localObject2).a(25.0F, localContext)).a((View)localTextView).d(0), str, null, 2, null).b(getResources().getColor(R.color.b)).a(false).a().show();
  }
  
  @NotNull
  public final PublishVideoDeliverTypeLayout.DeliverType getDeliverType()
  {
    return this.g;
  }
  
  public final boolean getProhibitReprint()
  {
    return this.f;
  }
  
  public void onCheckedChanged(@NotNull CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCompoundButton, "buttonView");
    if (paramCompoundButton.getId() == R.id.f) {
      setProhibitReprint(paramBoolean);
    }
  }
  
  public void onClick(@Nullable View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    int i = R.id.i;
    if ((paramView != null) && (paramView.intValue() == i))
    {
      setDeliverType(PublishVideoDeliverTypeLayout.DeliverType.SelfDeliverType);
      return;
    }
    i = R.id.h;
    if ((paramView != null) && (paramView.intValue() == i))
    {
      setDeliverType(PublishVideoDeliverTypeLayout.DeliverType.ReprintDeliverType);
      return;
    }
    i = R.id.j;
    if (paramView == null) {
      return;
    }
    if (paramView.intValue() == i) {
      e();
    }
  }
  
  public final void setDeliverType(@NotNull PublishVideoDeliverTypeLayout.DeliverType paramDeliverType)
  {
    Intrinsics.checkParameterIsNotNull(paramDeliverType, "value");
    this.g = paramDeliverType;
    c();
  }
  
  public final void setProhibitReprint(boolean paramBoolean)
  {
    this.f = paramBoolean;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.PublishVideoDeliverTypeLayout
 * JD-Core Version:    0.7.0.1
 */