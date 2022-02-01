package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.topicsdk.bean.Media;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dirName", "", "dirPath", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "invoke", "com/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout$handleOpenRecentMediaItem$1$1"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$handleOpenRecentMediaItem$$inlined$let$lambda$1
  extends Lambda
  implements Function3<String, String, ArrayList<Media>, Unit>
{
  BottomSelectorLayout$handleOpenRecentMediaItem$$inlined$let$lambda$1(BottomSelectorLayout paramBottomSelectorLayout, View paramView)
  {
    super(3);
  }
  
  public final void invoke(@NotNull String paramString1, @NotNull String paramString2, @NotNull ArrayList<Media> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "dirName");
    Intrinsics.checkParameterIsNotNull(paramString2, "dirPath");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    BottomSelectorLayout.a(this.this$0).a(paramString1);
    paramString1 = (TextView)this.this$0.a(R.id.av);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "recentMediaItem");
    paramString1.setText((CharSequence)BottomSelectorLayout.a(this.this$0).a());
    ((MediaSelectorPanel)this.$mediaPanel$inlined).a(paramString2, paramArrayList);
    BottomSelectorLayout.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.handleOpenRecentMediaItem..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */