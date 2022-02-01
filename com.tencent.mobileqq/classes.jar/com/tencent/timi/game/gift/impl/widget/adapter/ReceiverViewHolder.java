package com.tencent.timi.game.gift.impl.widget.adapter;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/widget/adapter/ReceiverViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "bindView", "", "receiverInfo", "Lcom/tencent/timi/game/gift/api/ReceiverInfoModel;", "chosen", "", "themeColor", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverViewHolder
  extends RecyclerView.ViewHolder
{
  private final View a;
  
  public ReceiverViewHolder(@NotNull View paramView)
  {
    super(paramView);
    this.a = paramView;
  }
  
  public final void a(@NotNull ReceiverInfoModel paramReceiverInfoModel, boolean paramBoolean, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverInfoModel, "receiverInfo");
    Object localObject = this.a.findViewById(2131430721);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.chosenView");
    int j = 8;
    int i;
    if ((paramBoolean) && (!paramReceiverInfoModel.e())) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.a.findViewById(2131430721);
    if (paramInt == 2) {
      i = 2130853033;
    } else {
      i = 2130853034;
    }
    ((View)localObject).setBackgroundResource(i);
    if (paramBoolean)
    {
      localObject = (TextView)this.a.findViewById(2131429004);
      if (paramInt == 2) {
        paramInt = 2130853035;
      } else {
        paramInt = 2130853036;
      }
      ((TextView)localObject).setBackgroundResource(paramInt);
    }
    else
    {
      localObject = (TextView)this.a.findViewById(2131429004);
      if (paramInt == 2) {
        paramInt = 2130853037;
      } else {
        paramInt = 2130853038;
      }
      ((TextView)localObject).setBackgroundResource(paramInt);
    }
    localObject = (TextView)this.a.findViewById(2131429004);
    if (paramBoolean) {
      paramInt = ResUtils.b(2131168279);
    } else {
      paramInt = Color.parseColor("#FFE99F");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = (TextView)this.a.findViewById(2131429004);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.avatarTv");
    if (((CharSequence)paramReceiverInfoModel.c()).length() == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      paramInt = j;
    } else {
      paramInt = 0;
    }
    ((TextView)localObject).setVisibility(paramInt);
    localObject = (TextView)this.a.findViewById(2131429004);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.avatarTv");
    ((TextView)localObject).setText((CharSequence)paramReceiverInfoModel.c());
    ((AvatarRoundImageView)this.a.findViewById(2131429000)).setUserId(paramReceiverInfoModel.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.widget.adapter.ReceiverViewHolder
 * JD-Core Version:    0.7.0.1
 */