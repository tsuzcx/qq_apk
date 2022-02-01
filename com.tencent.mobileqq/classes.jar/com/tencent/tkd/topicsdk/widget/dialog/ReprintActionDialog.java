package com.tencent.tkd.topicsdk.widget.dialog;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/dialog/ReprintActionDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowReprintDescView", "Landroid/widget/TextView;", "allowReprintSelectView", "Landroid/widget/ImageView;", "allowReprintTitleView", "currentAllowReprint", "", "dialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/SlidingUpDialog;", "dismissListener", "Lkotlin/Function1;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function1;", "setDismissListener", "(Lkotlin/jvm/functions/Function1;)V", "forbidReprintDescView", "forbidReprintSelectView", "forbidReprintTitleView", "changeReprintAuthority", "allowReprint", "initFromConfig", "config", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/ReprintAuthorityConfig;", "show", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ReprintActionDialog
{
  private SlidingUpDialog a;
  private ImageView b;
  private ImageView c;
  private boolean d;
  @Nullable
  private Function1<? super Boolean, Unit> e;
  
  private final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    ImageView localImageView = this.b;
    int j = 0;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    localImageView = this.c;
    int i = j;
    if (paramBoolean) {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  @Nullable
  public final Function1<Boolean, Unit> a()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.dialog.ReprintActionDialog
 * JD-Core Version:    0.7.0.1
 */