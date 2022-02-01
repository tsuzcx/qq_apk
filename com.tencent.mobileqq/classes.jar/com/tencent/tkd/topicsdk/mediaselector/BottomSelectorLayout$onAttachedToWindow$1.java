package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import android.os.IBinder;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.common.InputMethodUtils;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "oldPanel", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "newPanel", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$onAttachedToWindow$1
  extends Lambda
  implements Function2<PanelType, PanelType, Unit>
{
  BottomSelectorLayout$onAttachedToWindow$1(BottomSelectorLayout paramBottomSelectorLayout)
  {
    super(2);
  }
  
  public final void invoke(@NotNull PanelType paramPanelType1, @NotNull PanelType paramPanelType2)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType1, "oldPanel");
    Intrinsics.checkParameterIsNotNull(paramPanelType2, "newPanel");
    if ((paramPanelType1 == PanelType.PHOTO) && (paramPanelType2 == PanelType.VIDEO))
    {
      paramPanelType1 = BottomSelectorLayout.a(this.this$0).a(PanelType.PHOTO);
      if (paramPanelType1 != null)
      {
        if (((MediaSelectorPanel)paramPanelType1).c().size() > 0)
        {
          paramPanelType1 = this.this$0.getContext();
          Intrinsics.checkExpressionValueIsNotNull(paramPanelType1, "context");
          paramPanelType1 = paramPanelType1.getResources().getString(R.string.H);
          Intrinsics.checkExpressionValueIsNotNull(paramPanelType1, "context.resources.getStr…_video_replace_photo_tip)");
          TopicSDKHelperKt.a(paramPanelType1, false, null, 6, null);
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
      }
    }
    else if ((paramPanelType1 == PanelType.VIDEO) && (paramPanelType2 == PanelType.PHOTO))
    {
      paramPanelType1 = BottomSelectorLayout.a(this.this$0).a(PanelType.VIDEO);
      if (paramPanelType1 != null)
      {
        if (((MediaSelectorPanel)paramPanelType1).c().size() > 0)
        {
          paramPanelType1 = this.this$0.getContext();
          Intrinsics.checkExpressionValueIsNotNull(paramPanelType1, "context");
          paramPanelType1 = paramPanelType1.getResources().getString(R.string.C);
          Intrinsics.checkExpressionValueIsNotNull(paramPanelType1, "context.resources.getStr…_photo_replace_video_tip)");
          TopicSDKHelperKt.a(paramPanelType1, false, null, 6, null);
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
      }
    }
    paramPanelType1 = this.this$0;
    BottomSelectorLayout.a(paramPanelType1, paramPanelType1.getTranslationY(), BottomSelectorLayout.a(this.this$0, paramPanelType2), false, 4, null);
    paramPanelType1 = (TextView)this.this$0.a(R.id.av);
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType1, "recentMediaItem");
    paramPanelType1.setText((CharSequence)BottomSelectorLayout.a(this.this$0).a());
    paramPanelType1 = InputMethodUtils.a;
    paramPanelType2 = this.this$0.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramPanelType2, "context");
    IBinder localIBinder = this.this$0.getWindowToken();
    Intrinsics.checkExpressionValueIsNotNull(localIBinder, "windowToken");
    paramPanelType1.a(paramPanelType2, localIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */