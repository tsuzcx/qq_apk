package com.tencent.timi.game.expand.hall.api.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/api/data/GMChangeRoomInfo;", "", "whiteFlag", "", "userRoomList", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "(ILjava/util/List;)V", "", "getUserRoomList", "()Ljava/util/List;", "setUserRoomList", "(Ljava/util/List;)V", "isWhiteUser", "", "listToJson", "Lorg/json/JSONArray;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GMChangeRoomInfo
{
  public static final GMChangeRoomInfo.Companion a = new GMChangeRoomInfo.Companion(null);
  private static final int d = 1;
  private int b;
  @NotNull
  private List<RecommendProxyOuterClass.KuolieRoomInfo> c = (List)new ArrayList();
  
  public GMChangeRoomInfo(int paramInt, @NotNull List<RecommendProxyOuterClass.KuolieRoomInfo> paramList)
  {
    this.b = paramInt;
    this.c.addAll((Collection)paramList);
  }
  
  @NotNull
  public final List<RecommendProxyOuterClass.KuolieRoomInfo> a()
  {
    return this.c;
  }
  
  public final boolean b()
  {
    return this.b == d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo
 * JD-Core Version:    0.7.0.1
 */