package com.tencent.mobileqq.kandian.biz.skin.api.impl;

import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelper;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelperFactory;
import com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoySkinHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/impl/ReadInJoySkinHelperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoySkinHelperFactory;", "()V", "createReadInJoySkinHelper", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoySkinHelper;", "app", "Lmqq/app/AppRuntime;", "service", "Ljava/lang/Object;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoySkinHelperFactoryImpl
  implements IReadInJoySkinHelperFactory
{
  @Nullable
  public IReadInJoySkinHelper createReadInJoySkinHelper(@Nullable AppRuntime paramAppRuntime, @Nullable Object paramObject)
  {
    if (paramObject != null) {
      return (IReadInJoySkinHelper)new ReadInJoySkinHelper(paramAppRuntime, (TroopMemberApiService)paramObject);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.troop.TroopMemberApiService");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.impl.ReadInJoySkinHelperFactoryImpl
 * JD-Core Version:    0.7.0.1
 */