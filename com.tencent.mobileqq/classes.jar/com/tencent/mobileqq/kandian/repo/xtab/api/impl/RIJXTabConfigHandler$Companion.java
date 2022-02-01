package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler$Companion;", "", "()V", "RED_DOT_DEFAULT_EXPIRED_TIME_IN_MIN", "", "SP_DEFAULT_TAB_ID", "", "SP_RED_DOT_EXPIRE_TIME_IN_MIN", "SP_TAB_INFO_JSON", "SP_X_TAB_MODE_SWITCH_KEY", "TAG", "instance", "Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler;", "getInstance", "()Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler;", "setInstance", "(Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler;)V", "get", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandler$Companion
{
  private final void a(RIJXTabConfigHandler paramRIJXTabConfigHandler)
  {
    RIJXTabConfigHandler.access$setInstance$cp(paramRIJXTabConfigHandler);
  }
  
  private final RIJXTabConfigHandler b()
  {
    if (RIJXTabConfigHandler.access$getInstance$cp() != null)
    {
      Object localObject = RIJXTabConfigHandler.access$getInstance$cp();
      if (localObject != null) {
        localObject = RIJXTabConfigHandler.access$getAccount$p((RIJXTabConfigHandler)localObject);
      } else {
        localObject = null;
      }
      if (TextUtils.equals((CharSequence)localObject, (CharSequence)RIJQQAppInterfaceUtil.a())) {}
    }
    else
    {
      RIJXTabConfigHandler.Companion.a(new RIJXTabConfigHandler(null));
    }
    return RIJXTabConfigHandler.access$getInstance$cp();
  }
  
  @JvmStatic
  @NotNull
  public final RIJXTabConfigHandler a()
  {
    try
    {
      RIJXTabConfigHandler localRIJXTabConfigHandler = ((Companion)this).b();
      if (localRIJXTabConfigHandler != null) {
        return localRIJXTabConfigHandler;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler");
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler.Companion
 * JD-Core Version:    0.7.0.1
 */