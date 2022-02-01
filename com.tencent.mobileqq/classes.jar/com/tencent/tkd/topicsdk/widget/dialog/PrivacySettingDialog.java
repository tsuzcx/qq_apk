package com.tencent.tkd.topicsdk.widget.dialog;

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
import com.tencent.tkd.topicsdk.bean.globalconfig.PrivacySettingConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/PrivacySettingDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentPrivacy", "", "dialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/SlidingUpDialog;", "dismissListener", "Lkotlin/Function1;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function1;", "setDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "extraDescView", "Landroid/widget/TextView;", "extraSelectView", "Landroid/widget/ImageView;", "extraTitleView", "privateDescView", "privateSelectView", "privateTitleView", "publicDescView", "publicSelectView", "publicTitleView", "changePrivacyAuthority", "privacy", "initFromConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/PrivacySettingConfig;", "show", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PrivacySettingDialog
{
  private SlidingUpDialog a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private int k = 2;
  @Nullable
  private Function1<? super Integer, Unit> l;
  
  public PrivacySettingDialog(@NotNull Context paramContext)
  {
    View localView = View.inflate(paramContext, R.layout.c, null);
    Intrinsics.checkExpressionValueIsNotNull(localView, "reprintView");
    this.a = new SlidingUpDialog(paramContext, localView, new RelativeLayout.LayoutParams(-1, -2));
    paramContext = localView.findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_title)");
    this.b = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.n);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_content)");
    this.c = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.p);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.extra_select_view)");
    this.d = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.o)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.1(this));
    paramContext = localView.findViewById(R.id.X);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_title)");
    this.e = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.U);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_content)");
    this.f = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.W);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.public_select_view)");
    this.g = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.V)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.2(this));
    paramContext = localView.findViewById(R.id.T);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_title)");
    this.h = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.Q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_content)");
    this.i = ((TextView)paramContext);
    paramContext = localView.findViewById(R.id.S);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.private_select_view)");
    this.j = ((ImageView)paramContext);
    ((RelativeLayout)localView.findViewById(R.id.R)).setOnClickListener((View.OnClickListener)new PrivacySettingDialog..special..inlined.with.lambda.3(this));
    this.a.setOnDismissListener((DialogInterface.OnDismissListener)new PrivacySettingDialog.2(this));
  }
  
  private final void a(int paramInt)
  {
    this.k = paramInt;
    ImageView localImageView = this.d;
    int n = 0;
    int m;
    if (paramInt == 1) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.g;
    if (paramInt == 2) {
      m = 0;
    } else {
      m = 8;
    }
    localImageView.setVisibility(m);
    localImageView = this.j;
    if (paramInt == 3) {
      paramInt = n;
    } else {
      paramInt = 8;
    }
    localImageView.setVisibility(paramInt);
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.l;
  }
  
  public final void a(@NotNull PrivacySettingConfig paramPrivacySettingConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramPrivacySettingConfig, "config");
    this.b.setText((CharSequence)paramPrivacySettingConfig.getExtraTitle());
    this.c.setText((CharSequence)paramPrivacySettingConfig.getExtraDesc());
    this.e.setText((CharSequence)paramPrivacySettingConfig.getPublicTitle());
    this.f.setText((CharSequence)paramPrivacySettingConfig.getPublicDesc());
    this.h.setText((CharSequence)paramPrivacySettingConfig.getPrivateTitle());
    this.i.setText((CharSequence)paramPrivacySettingConfig.getPrivacyDesc());
    a(paramPrivacySettingConfig.getPrivacySetting());
  }
  
  public final void a(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.l = paramFunction1;
  }
  
  public final void b()
  {
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.PrivacySettingDialog
 * JD-Core Version:    0.7.0.1
 */