package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyFragment$getClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class LiveReadyFragment$getClickableSpan$1
  extends ClickableSpan
{
  LiveReadyFragment$getClickableSpan$1(int paramInt) {}
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    paramView = new Intent(this.a.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", URLUtil.guessUrl("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/license/live_ugc.html"));
    Context localContext = this.a.getContext();
    if (localContext == null) {
      Intrinsics.throwNpe();
    }
    localContext.startActivity(paramView);
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
    paramTextPaint.setColor(this.b);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(this.a.getResources().getDimension(2131297610));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyFragment.getClickableSpan.1
 * JD-Core Version:    0.7.0.1
 */