package com.tencent.timi.game.expand.hall.impl.gm;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo;
import com.tencent.timi.game.expand.hall.impl.gm.net.GetTopKuolieRoomListRequest;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager;", "", "()V", "TAG", "", "gmChangeRoomInfo", "Lcom/tencent/timi/game/expand/hall/api/data/GMChangeRoomInfo;", "itemClickListener", "com/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager$itemClickListener$1", "Lcom/tencent/timi/game/expand/hall/impl/gm/ExpandHallGMManager$itemClickListener$1;", "launchParam", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "userRoomList", "", "Ltrpc/yes/common/RecommendProxyOuterClass$KuolieRoomInfo;", "onChangeRoomClick", "", "view", "Landroid/view/View;", "showGMChangeRoom", "changeRoomView", "param", "info", "showGMChangeRoomFromFlag", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallGMManager
{
  private final String a = "ExpandHallGMManager";
  private List<RecommendProxyOuterClass.KuolieRoomInfo> b;
  private ExpandHallLaunchParam c;
  private GMChangeRoomInfo d;
  private final ExpandHallGMManager.itemClickListener.1 e = new ExpandHallGMManager.itemClickListener.1(this);
  
  private final void a(View paramView)
  {
    List localList = this.b;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      localList = this.b;
      if (localList == null) {
        Intrinsics.throwNpe();
      }
      paramView = paramView.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "view.context");
      paramView = new GMChangeRoomOperateDialog(localList, paramView);
      paramView.a((GMChangeRoomOperateDialog.ItemClickListener)this.e);
      paramView.show();
    }
  }
  
  public final void a(@Nullable View paramView, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "param");
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showGMChangeRoomFromFlag ");
    localStringBuilder.append(paramExpandHallLaunchParam.j);
    Logger.a(str, localStringBuilder.toString());
    boolean bool = paramExpandHallLaunchParam.j;
    paramView = new WeakReference(paramView);
    if (bool)
    {
      paramView = new ExpandHallGMManager.showGMChangeRoomFromFlag.listener.1(this, paramView, paramExpandHallLaunchParam);
      GetTopKuolieRoomListRequest.a.a((IResultListener)paramView);
    }
  }
  
  public final void a(@Nullable View paramView, @NotNull ExpandHallLaunchParam paramExpandHallLaunchParam, @Nullable GMChangeRoomInfo paramGMChangeRoomInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandHallLaunchParam, "param");
    boolean bool3 = false;
    if (paramView != null) {
      ViewExKt.a(paramView, false);
    }
    if (paramExpandHallLaunchParam.a == 1)
    {
      this.d = paramGMChangeRoomInfo;
      this.c = paramExpandHallLaunchParam;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showGMChangeRoom show ");
      localStringBuilder.append(paramExpandHallLaunchParam.j);
      Logger.a(str, localStringBuilder.toString());
      boolean bool1;
      if (paramGMChangeRoomInfo != null) {
        bool1 = paramGMChangeRoomInfo.b();
      } else {
        bool1 = false;
      }
      if (paramGMChangeRoomInfo != null) {
        paramExpandHallLaunchParam = paramGMChangeRoomInfo.a();
      } else {
        paramExpandHallLaunchParam = null;
      }
      this.b = paramExpandHallLaunchParam;
      paramExpandHallLaunchParam = this.b;
      int i;
      if (paramExpandHallLaunchParam != null) {
        i = paramExpandHallLaunchParam.size();
      } else {
        i = 0;
      }
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramView != null)
      {
        boolean bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (i != 0) {
            bool2 = true;
          }
        }
        ViewExKt.a(paramView, bool2);
      }
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new ExpandHallGMManager.showGMChangeRoom.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager
 * JD-Core Version:    0.7.0.1
 */