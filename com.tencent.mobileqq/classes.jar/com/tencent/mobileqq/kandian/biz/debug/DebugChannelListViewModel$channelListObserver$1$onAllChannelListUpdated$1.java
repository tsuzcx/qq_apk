package com.tencent.mobileqq.kandian.biz.debug;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "lhs", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelInfo;", "kotlin.jvm.PlatformType", "rhs", "compare"}, k=3, mv={1, 1, 16})
final class DebugChannelListViewModel$channelListObserver$1$onAllChannelListUpdated$1<T>
  implements Comparator<ChannelInfo>
{
  public static final 1 a = new 1();
  
  public final int a(ChannelInfo paramChannelInfo1, ChannelInfo paramChannelInfo2)
  {
    String str = paramChannelInfo1.mChannelName;
    Intrinsics.checkExpressionValueIsNotNull(str, "lhs.mChannelName");
    boolean bool = StringsKt.contains$default((CharSequence)str, (CharSequence)".", false, 2, null);
    int i = -1;
    if (bool)
    {
      str = paramChannelInfo2.mChannelName;
      Intrinsics.checkExpressionValueIsNotNull(str, "rhs.mChannelName");
      if (StringsKt.contains$default((CharSequence)str, (CharSequence)".", false, 2, null))
      {
        paramChannelInfo1 = paramChannelInfo1.mChannelName;
        paramChannelInfo2 = paramChannelInfo2.mChannelName;
        Intrinsics.checkExpressionValueIsNotNull(paramChannelInfo2, "rhs.mChannelName");
        return paramChannelInfo1.compareTo(paramChannelInfo2);
      }
      paramChannelInfo1 = paramChannelInfo2.mChannelName;
      Intrinsics.checkExpressionValueIsNotNull(paramChannelInfo1, "rhs.mChannelName");
      StringsKt.contains$default((CharSequence)paramChannelInfo1, (CharSequence)"-", false, 2, null);
      return -1;
    }
    str = paramChannelInfo1.mChannelName;
    Intrinsics.checkExpressionValueIsNotNull(str, "lhs.mChannelName");
    if (StringsKt.contains$default((CharSequence)str, (CharSequence)"-", false, 2, null))
    {
      str = paramChannelInfo2.mChannelName;
      Intrinsics.checkExpressionValueIsNotNull(str, "rhs.mChannelName");
      if (!StringsKt.contains$default((CharSequence)str, (CharSequence)".", false, 2, null))
      {
        str = paramChannelInfo2.mChannelName;
        Intrinsics.checkExpressionValueIsNotNull(str, "rhs.mChannelName");
        if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"-", false, 2, null)) {
          return i;
        }
        paramChannelInfo1 = paramChannelInfo1.mChannelName;
        paramChannelInfo2 = paramChannelInfo2.mChannelName;
        Intrinsics.checkExpressionValueIsNotNull(paramChannelInfo2, "rhs.mChannelName");
        return paramChannelInfo1.compareTo(paramChannelInfo2);
      }
    }
    else
    {
      str = paramChannelInfo2.mChannelName;
      Intrinsics.checkExpressionValueIsNotNull(str, "rhs.mChannelName");
      if (!StringsKt.contains$default((CharSequence)str, (CharSequence)".", false, 2, null)) {
        break label276;
      }
    }
    label276:
    do
    {
      return 1;
      str = paramChannelInfo2.mChannelName;
      Intrinsics.checkExpressionValueIsNotNull(str, "rhs.mChannelName");
    } while (StringsKt.contains$default((CharSequence)str, (CharSequence)"-", false, 2, null));
    paramChannelInfo1 = paramChannelInfo1.mChannelName;
    paramChannelInfo2 = paramChannelInfo2.mChannelName;
    Intrinsics.checkExpressionValueIsNotNull(paramChannelInfo2, "rhs.mChannelName");
    i = paramChannelInfo1.compareTo(paramChannelInfo2);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.DebugChannelListViewModel.channelListObserver.1.onAllChannelListUpdated.1
 * JD-Core Version:    0.7.0.1
 */