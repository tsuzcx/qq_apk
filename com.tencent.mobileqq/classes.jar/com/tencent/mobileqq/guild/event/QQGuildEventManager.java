package com.tencent.mobileqq.guild.event;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/event/QQGuildEventManager;", "", "()V", "ACTION_DELETE_CHANNEL", "", "actionSelfMarkList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "checkActionSelfMark", "", "guildId", "channelId", "action", "setActionSelfMark", "", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildEventManager
{
  public static final QQGuildEventManager a = new QQGuildEventManager();
  private static final ArrayList<String> b = new ArrayList();
  
  public final boolean a(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('-');
    localStringBuilder.append(paramString2);
    localStringBuilder.append('-');
    localStringBuilder.append(paramInt);
    paramString1 = localStringBuilder.toString();
    if (b.contains(paramString1))
    {
      b.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public final void b(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('-');
    localStringBuilder.append(paramString2);
    localStringBuilder.append('-');
    localStringBuilder.append(paramInt);
    paramString1 = localStringBuilder.toString();
    if (b.contains(paramString1)) {
      b.remove(paramString1);
    }
    b.add(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.event.QQGuildEventManager
 * JD-Core Version:    0.7.0.1
 */