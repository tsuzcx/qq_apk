package com.tencent.tkd.topicsdk.entry;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.topicsdk.framework.AppContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IEntryViewBridge$DefaultImpls
{
  @NotNull
  public static Drawable a(IEntryViewBridge paramIEntryViewBridge)
  {
    paramIEntryViewBridge = AppContext.a.a().getResources().getDrawable(R.drawable.c);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "AppContext.instance.reso…drawable.tkdp_entry_icon)");
    return paramIEntryViewBridge;
  }
  
  @NotNull
  public static Drawable b(IEntryViewBridge paramIEntryViewBridge)
  {
    paramIEntryViewBridge = AppContext.a.a().getResources().getDrawable(R.drawable.d);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "AppContext.instance.reso…le.tkdp_entry_icon_draft)");
    return paramIEntryViewBridge;
  }
  
  @NotNull
  public static Drawable c(IEntryViewBridge paramIEntryViewBridge)
  {
    paramIEntryViewBridge = AppContext.a.a().getResources().getDrawable(R.drawable.f);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "AppContext.instance.reso…le.tkdp_entry_icon_night)");
    return paramIEntryViewBridge;
  }
  
  @NotNull
  public static Drawable d(IEntryViewBridge paramIEntryViewBridge)
  {
    paramIEntryViewBridge = AppContext.a.a().getResources().getDrawable(R.drawable.e);
    Intrinsics.checkExpressionValueIsNotNull(paramIEntryViewBridge, "AppContext.instance.reso…p_entry_icon_draft_night)");
    return paramIEntryViewBridge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.entry.IEntryViewBridge.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */