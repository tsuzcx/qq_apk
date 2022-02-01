package com.tencent.mobileqq.guild.config;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigBean$Companion;", "", "()V", "sBeans", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigBean;", "current", "updateCurrent", "", "bean", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildShareConfigBean$Companion
{
  @JvmStatic
  @NotNull
  public final QQGuildShareConfigBean a()
  {
    String str = QQGuildUtil.f();
    Intrinsics.checkExpressionValueIsNotNull(str, "QQGuildUtil.accountUin()");
    QQGuildShareConfigBean localQQGuildShareConfigBean = (QQGuildShareConfigBean)QQGuildShareConfigBean.c().get(str);
    Object localObject1 = (QQGuildShareConfigBean)null;
    Object localObject2 = localQQGuildShareConfigBean;
    if (localQQGuildShareConfigBean == null)
    {
      localObject2 = (QQGuildShareConfigBean)QConfigManager.b().b(770);
      Objects.requireNonNull(localObject2, "assert that result must be nonnull");
      localObject1 = QQGuildShareConfigBean.c();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (QQGuildShareConfigBean)((ConcurrentHashMap)localObject1).putIfAbsent(str, localObject2);
    }
    if (localObject1 != null) {
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  @JvmStatic
  public final void a(@NotNull QQGuildShareConfigBean paramQQGuildShareConfigBean)
  {
    Intrinsics.checkParameterIsNotNull(paramQQGuildShareConfigBean, "bean");
    String str = QQGuildUtil.f();
    Intrinsics.checkExpressionValueIsNotNull(str, "QQGuildUtil.accountUin()");
    ((Map)QQGuildShareConfigBean.c()).put(str, paramQQGuildShareConfigBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildShareConfigBean.Companion
 * JD-Core Version:    0.7.0.1
 */