package com.tencent.mobileqq.guild.message.db;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/message/db/GuildMsgDBUtils$Companion;", "", "()V", "getAIOMsgListByDeduplication", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "originList", "qqguild-api_release"}, k=1, mv={1, 1, 16})
public final class GuildMsgDBUtils$Companion
{
  @Nullable
  public final List<MessageRecord> a(@Nullable List<? extends MessageRecord> paramList)
  {
    Object localObject2 = (List)null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramList.size() > 0)
      {
        localObject1 = paramList;
        if (paramList.size() > 500) {
          localObject1 = paramList.subList(paramList.size() - 500, paramList.size());
        }
        localObject2 = (Iterable)localObject1;
        paramList = new HashSet();
        localObject1 = new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (paramList.add(((MessageRecord)localObject3).senderuin)) {
            ((ArrayList)localObject1).add(localObject3);
          }
        }
        localObject1 = (List)localObject1;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.db.GuildMsgDBUtils.Companion
 * JD-Core Version:    0.7.0.1
 */