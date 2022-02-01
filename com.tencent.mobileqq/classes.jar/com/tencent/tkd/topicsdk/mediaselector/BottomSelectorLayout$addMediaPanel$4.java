package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addMediaPanel$4
  extends Lambda
  implements Function0<Unit>
{
  BottomSelectorLayout$addMediaPanel$4(BottomSelectorLayout paramBottomSelectorLayout, PanelType paramPanelType, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject;
    Object[] arrayOfObject;
    if (this.$panelType == PanelType.PHOTO)
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getString(R.string.y);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…lect_photo_reach_max_tip)");
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.$maxSelectCount);
      localObject = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
      return;
    }
    if (this.$panelType == PanelType.VIDEO)
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localObject = ((Context)localObject).getResources().getString(R.string.z);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources.getStr…lect_video_reach_max_tip)");
      arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.$maxSelectCount);
      localObject = String.format((String)localObject, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addMediaPanel.4
 * JD-Core Version:    0.7.0.1
 */