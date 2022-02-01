package com.tencent.mobileqq.kandian.biz.feeds.api.impl;

import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyBaseFragmentEntryPath;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/api/impl/ReadInJoyBaseFragmentEntryPath;", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IReadInJoyBaseFragmentEntryPath;", "()V", "channelEntryPath", "", "", "clear", "", "get", "key", "(I)Ljava/lang/Integer;", "put", "value", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyBaseFragmentEntryPath
  implements IReadInJoyBaseFragmentEntryPath
{
  public static final ReadInJoyBaseFragmentEntryPath INSTANCE = new ReadInJoyBaseFragmentEntryPath();
  private static final Map<Integer, Integer> channelEntryPath = (Map)new HashMap();
  
  public void clear()
  {
    channelEntryPath.clear();
  }
  
  @Nullable
  public Integer get(int paramInt)
  {
    return (Integer)channelEntryPath.get(Integer.valueOf(paramInt));
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    channelEntryPath.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.api.impl.ReadInJoyBaseFragmentEntryPath
 * JD-Core Version:    0.7.0.1
 */