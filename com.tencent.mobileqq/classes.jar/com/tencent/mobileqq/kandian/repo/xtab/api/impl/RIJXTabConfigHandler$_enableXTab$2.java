package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabConfigHandler$_enableXTab$2
  extends Lambda
  implements Function0<Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  RIJXTabConfigHandler$_enableXTab$2()
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    boolean bool;
    if ((RIJXTabConfigHandler.access$get_config$p(RIJXTabConfigHandler.INSTANCE).getIntegerFromString("use_4_tab_mode", 1) == 1) && ((((Collection)RIJXTabConfigHandler.access$get_tabsList$p(RIJXTabConfigHandler.INSTANCE)).isEmpty() ^ true))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_enableXTab: ");
    localStringBuilder.append(bool);
    QLog.d("RIJXTabConfigHandler", 1, localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler._enableXTab.2
 * JD-Core Version:    0.7.0.1
 */