package com.tencent.tkd.weibo.utils;

import android.text.Editable;
import com.tencent.tkd.weibo.richEditText.span.RichSpan;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/CollectionUtil;", "", "()V", "sortArrayByStartPosition", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/weibo/richEditText/span/RichSpan;", "spansList", "", "text", "Landroid/text/Editable;", "([Lcom/tencent/tkd/weibo/richEditText/span/RichSpan;Landroid/text/Editable;)Ljava/util/ArrayList;", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class CollectionUtil
{
  public static final CollectionUtil a = new CollectionUtil();
  
  @NotNull
  public final ArrayList<RichSpan> a(@NotNull RichSpan[] paramArrayOfRichSpan, @NotNull Editable paramEditable)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfRichSpan, "spansList");
    Intrinsics.checkParameterIsNotNull(paramEditable, "text");
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfRichSpan.length > 1) {
      ArraysKt.sortWith(paramArrayOfRichSpan, (Comparator)new CollectionUtil.sortArrayByStartPosition..inlined.sortBy.1(paramEditable));
    }
    int j = paramArrayOfRichSpan.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfRichSpan[i]);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.CollectionUtil
 * JD-Core Version:    0.7.0.1
 */