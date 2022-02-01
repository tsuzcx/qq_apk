package com.tencent.timi.game.gift.impl.timi.live;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/live/ReceiverViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "bindView", "", "receiverInfo", "Lcom/tencent/timi/game/gift/impl/timi/live/LiveReceiverInfoModel;", "chosen", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ReceiverViewHolder
  extends RecyclerView.ViewHolder
{
  private final View a;
  
  public ReceiverViewHolder(@NotNull View paramView)
  {
    super(paramView);
    this.a = paramView;
  }
  
  public final void a(@NotNull LiveReceiverInfoModel paramLiveReceiverInfoModel, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramLiveReceiverInfoModel, "receiverInfo");
    Object localObject = this.a.findViewById(2131430721);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.chosenView");
    int j = 8;
    int i;
    if ((paramBoolean) && (!paramLiveReceiverInfoModel.e())) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    this.a.findViewById(2131430721).setBackgroundResource(2130853033);
    if (paramBoolean) {
      ((TextView)this.a.findViewById(2131429004)).setBackgroundResource(2130853035);
    } else {
      ((TextView)this.a.findViewById(2131429004)).setBackgroundResource(2130853037);
    }
    localObject = (TextView)this.a.findViewById(2131429004);
    if (paramBoolean) {
      i = ResUtils.b(2131168279);
    } else {
      i = Color.parseColor("#FFE99F");
    }
    ((TextView)localObject).setTextColor(i);
    localObject = (TextView)this.a.findViewById(2131429004);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.avatarTv");
    if (((CharSequence)paramLiveReceiverInfoModel.f()).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = j;
    } else {
      i = 0;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = (TextView)this.a.findViewById(2131429004);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.avatarTv");
    ((TextView)localObject).setText((CharSequence)paramLiveReceiverInfoModel.f());
    ((RoundCornerImageView)this.a.findViewById(2131429000)).setRadius(CommonExKt.b(15));
    localObject = (RoundCornerImageView)this.a.findViewById(2131429000);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "v.avatarIv");
    localObject = (URLImageView)localObject;
    paramLiveReceiverInfoModel = paramLiveReceiverInfoModel.c();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "URLDrawable.URLDrawableOptions.obtain()");
    CommonExKt.a((URLImageView)localObject, paramLiveReceiverInfoModel, localURLDrawableOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.live.ReceiverViewHolder
 * JD-Core Version:    0.7.0.1
 */