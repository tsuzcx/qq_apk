package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.FormatUtils;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/bean/Media;", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addMediaPanel$5
  extends Lambda
  implements Function1<Media, Unit>
{
  BottomSelectorLayout$addMediaPanel$5(BottomSelectorLayout paramBottomSelectorLayout, PanelType paramPanelType, long paramLong)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Media paramMedia)
  {
    Intrinsics.checkParameterIsNotNull(paramMedia, "it");
    Object[] arrayOfObject;
    if (this.$panelType == PanelType.PHOTO)
    {
      paramMedia = StringCompanionObject.INSTANCE;
      paramMedia = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "context");
      paramMedia = paramMedia.getResources().getString(R.string.r);
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "context.resources.getStr…g.image_limit_size_toast)");
      arrayOfObject = new Object[1];
      arrayOfObject[0] = FormatUtils.a.b(this.$maxSizeInByte);
      paramMedia = String.format(paramMedia, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "java.lang.String.format(format, *args)");
      TopicSDKHelperKt.a(paramMedia, false, null, 6, null);
      return;
    }
    if (this.$panelType == PanelType.VIDEO)
    {
      paramMedia = StringCompanionObject.INSTANCE;
      paramMedia = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "context");
      paramMedia = paramMedia.getResources().getString(R.string.Y);
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "context.resources.getStr…g.video_limit_size_toast)");
      arrayOfObject = new Object[1];
      arrayOfObject[0] = FormatUtils.a.b(this.$maxSizeInByte);
      paramMedia = String.format(paramMedia, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramMedia, "java.lang.String.format(format, *args)");
      TopicSDKHelperKt.a(paramMedia, false, null, 6, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addMediaPanel.5
 * JD-Core Version:    0.7.0.1
 */