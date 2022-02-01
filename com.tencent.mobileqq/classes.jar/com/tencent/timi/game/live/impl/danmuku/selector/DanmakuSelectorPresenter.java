package com.tencent.timi.game.live.impl.danmuku.selector;

import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.TextShowInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPresenter;", "", "()V", "danmakuSelectorUpdateListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPresenter$IDanmakuSelectorUpdateListener;", "selectedShowType", "", "textShowInfoList", "", "Ltrpc/yes/common/GameDataServerOuterClass$TextShowInfo;", "getSelectedShowType", "getTextShowInfoList", "", "registerDanmakuSelectorUpdateListener", "", "listener", "selectShowType", "showType", "show", "unregisterDanmakuSelectorUpdateListener", "updateTextShowInfoList", "data", "Companion", "IDanmakuSelectorUpdateListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorPresenter
{
  public static final DanmakuSelectorPresenter.Companion a = new DanmakuSelectorPresenter.Companion(null);
  private int b = -1;
  private final List<GameDataServerOuterClass.TextShowInfo> c = (List)new ArrayList();
  private final CopyOnWriteArrayList<DanmakuSelectorPresenter.IDanmakuSelectorUpdateListener> d = new CopyOnWriteArrayList();
  
  @NotNull
  public final List<GameDataServerOuterClass.TextShowInfo> a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int b()
  {
    int i = this.b;
    int j = -1;
    if (i == -1)
    {
      Object localObject = (GameDataServerOuterClass.TextShowInfo)CollectionsKt.firstOrNull(this.c);
      i = j;
      if (localObject != null)
      {
        localObject = ((GameDataServerOuterClass.TextShowInfo)localObject).show_type;
        i = j;
        if (localObject != null) {
          i = ((PBInt32Field)localObject).get();
        }
      }
      this.b = i;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorPresenter
 * JD-Core Version:    0.7.0.1
 */