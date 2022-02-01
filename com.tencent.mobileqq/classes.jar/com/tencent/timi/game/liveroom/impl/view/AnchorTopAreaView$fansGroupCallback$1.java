package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorFansGroupCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorTopAreaView$fansGroupCallback$1", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorFansGroupCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "fansGroupList", "", "Lcom/tencent/mobileqq/qqlive/data/anchor/sso/QQLiveAnchorFansGroupItem;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorTopAreaView$fansGroupCallback$1
  implements IQQLiveAnchorFansGroupCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAnchorFansGroupList error ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , ");
    localStringBuilder.append(paramString);
    Logger.c("AnchorTopAreaView_", localStringBuilder.toString());
  }
  
  public void a(@Nullable List<QQLiveAnchorFansGroupItem> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAnchorFansGroupList success ");
    Object localObject;
    if (paramList != null) {
      localObject = Integer.valueOf(paramList.size());
    } else {
      localObject = null;
    }
    localStringBuilder.append(localObject);
    Logger.a("AnchorTopAreaView_", localStringBuilder.toString());
    if ((!AnchorTopAreaView.i(this.a)) && (AnchorTopAreaView.j(this.a) == AnchorTopAreaView.f(this.a)))
    {
      if (paramList != null) {
        AnchorTopAreaView.e(this.a).put(Long.valueOf(AnchorTopAreaView.f(this.a)), paramList);
      }
      localObject = (FrameLayout)this.a.a(2131433919);
      if (localObject != null)
      {
        localObject = (View)localObject;
        boolean bool;
        if (((paramList != null) && (paramList.size() > 0)) || (AnchorTopAreaView.c(this.a))) {
          bool = true;
        } else {
          bool = false;
        }
        ViewExKt.a((View)localObject, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.fansGroupCallback.1
 * JD-Core Version:    0.7.0.1
 */