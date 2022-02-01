package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "nearbyTag", "Lcom/tencent/nowsummarycard/NowSummaryCard$NearbyTag;", "initNearbyTag", "", "byteArray", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onInterestsChanged", "onSaveInstanceState", "outState", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyInterestsChooseDialog
  extends DialogFragment
{
  public static final NearbyInterestsChooseDialog.Companion a = new NearbyInterestsChooseDialog.Companion(null);
  private NowSummaryCard.NearbyTag b;
  private HashMap c;
  
  private final void a(byte[] paramArrayOfByte)
  {
    try
    {
      NowSummaryCard.NearbyTag localNearbyTag = new NowSummaryCard.NearbyTag();
      localNearbyTag.mergeFrom(paramArrayOfByte);
      this.b = localNearbyTag;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label20:
      break label20;
    }
    dismissAllowingStateLoss();
  }
  
  private final void b()
  {
    NewNearbyProfileEditPanel localNewNearbyProfileEditPanel = NewNearbyProfileEditPanel.X.a();
    if (localNewNearbyProfileEditPanel != null)
    {
      NowSummaryCard.NearbyTag localNearbyTag = this.b;
      if (localNearbyTag == null) {
        Intrinsics.throwUninitializedPropertyAccessException("nearbyTag");
      }
      localNewNearbyProfileEditPanel.a(localNearbyTag);
    }
  }
  
  public void a()
  {
    HashMap localHashMap = this.c;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(0, 16973831);
    if (paramBundle == null)
    {
      paramBundle = getArguments();
      if (paramBundle == null)
      {
        dismissAllowingStateLoss();
        return;
      }
      a(paramBundle.getByteArray("ARG_NEARBY_TAG"));
      return;
    }
    a(paramBundle.getByteArray("SP_SAVE_NEARBY_TAG"));
  }
  
  @NotNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    return (Dialog)new NearbyInterestsChooseDialog.onCreateDialog.1(this, requireContext(), getTheme());
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onSaveInstanceState(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    NowSummaryCard.NearbyTag localNearbyTag = this.b;
    if (localNearbyTag == null) {
      Intrinsics.throwUninitializedPropertyAccessException("nearbyTag");
    }
    paramBundle.putByteArray("SP_SAVE_NEARBY_TAG", localNearbyTag.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyInterestsChooseDialog
 * JD-Core Version:    0.7.0.1
 */