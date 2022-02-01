package com.tencent.tkd.topicsdk.mediaselector;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.ViewExtensionsKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage;
import com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.Companion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "position", "", "invoke"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addMediaPanel$3
  extends Lambda
  implements Function1<Integer, Unit>
{
  BottomSelectorLayout$addMediaPanel$3(BottomSelectorLayout paramBottomSelectorLayout, PanelType paramPanelType, MediaSelectorPanel paramMediaSelectorPanel)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    Object localObject1 = ViewExtensionsKt.a(this.this$0);
    if ((this.$panelType == PanelType.PHOTO) && (localObject1 != null))
    {
      localObject2 = PreviewPhotoPage.a;
      str = this.$mediaSelectorView.a();
      localObject3 = (Iterable)this.$mediaSelectorView.c();
      localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add(((Media)((Iterator)localObject3).next()).getFilePath());
      }
      ((PreviewPhotoPage.Companion)localObject2).a((Activity)localObject1, str, paramInt, 3, (List)localCollection, this.$mediaSelectorView.a());
    }
    while ((this.$panelType != PanelType.VIDEO) || (localObject1 == null))
    {
      String str;
      Object localObject3;
      Collection localCollection;
      return;
    }
    Object localObject2 = this.$mediaSelectorView.a().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mediaSelectorView.mediaList[position]");
    if (((Media)localObject2).getDuration() < this.this$0.d())
    {
      localObject1 = this.this$0.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources().getString(R.string.ay);
      if (localObject1 != null) {}
      for (;;)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf(this.this$0.d() / 1000);
        localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        TopicSDKHelperKt.a((String)localObject1, false, null, 6, null);
        return;
        localObject1 = "最少选择%ds哦";
      }
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      VideoCropPage.a.a((Activity)localObject1, ((Media)this.$mediaSelectorView.a().get(paramInt)).getFilePath(), this.this$0.d(), this.this$0.e(), 4);
      return;
    }
    localObject1 = BottomSelectorLayout.a(this.this$0).a(PanelType.VIDEO);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
    }
    ((MediaSelectorPanel)localObject1).a(CollectionsKt.arrayListOf(new String[] { ((Media)this.$mediaSelectorView.a().get(paramInt)).getFilePath() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addMediaPanel.3
 * JD-Core Version:    0.7.0.1
 */