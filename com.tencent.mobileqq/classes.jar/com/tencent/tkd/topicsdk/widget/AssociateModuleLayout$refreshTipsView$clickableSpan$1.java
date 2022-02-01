package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/AssociateModuleLayout$refreshTipsView$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AssociateModuleLayout$refreshTipsView$clickableSpan$1
  extends ClickableSpan
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    TLog.a("AssociateModuleLayout", "click user protocal url=" + this.a.b());
    paramView = this.a.b();
    if (paramView != null)
    {
      Context localContext = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      Object localObject = this.a.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getString(R.string.T);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…(R.string.protocol_title)");
      TopicSDKHelperKt.a(localContext, (String)localObject, paramView);
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
    paramTextPaint.setColor(this.a.getResources().getColor(R.color.c));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AssociateModuleLayout.refreshTipsView.clickableSpan.1
 * JD-Core Version:    0.7.0.1
 */