package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabConfigHandler$_defaultEnterTabId$2
  extends Lambda
  implements Function0<Integer>
{
  public static final 2 INSTANCE = new 2();
  
  RIJXTabConfigHandler$_defaultEnterTabId$2()
  {
    super(0);
  }
  
  public final int invoke()
  {
    Object localObject = RIJXTabConfigHandler.access$get_config$p(RIJXTabConfigHandler.INSTANCE);
    int i = 0;
    int j = ((AladdinConfig)localObject).getIntegerFromString("default_tab", 0);
    if (j == -1)
    {
      localObject = (TabChannelCoverInfo)CollectionsKt.firstOrNull(RIJXTabConfigHandler.access$get_tabsList$p(RIJXTabConfigHandler.INSTANCE));
      if (localObject != null) {
        i = ((TabChannelCoverInfo)localObject).mChannelCoverId;
      }
    }
    else
    {
      i = j;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_defaultEnterTabId: ");
    ((StringBuilder)localObject).append(i);
    QLog.d("RIJXTabConfigHandler", 1, ((StringBuilder)localObject).toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler._defaultEnterTabId.2
 * JD-Core Version:    0.7.0.1
 */