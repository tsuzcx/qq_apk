package com.tencent.mobileqq.qqlive.prepare;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.live.ILiveReportUtil;
import java.util.Map;

final class QQLiveGamePrepareViewBinderHelper$8
  implements GameListAdapter.OnListItemReactListener
{
  QQLiveGamePrepareViewBinderHelper$8(PrepareFragmentViewModel paramPrepareFragmentViewModel, IGameListView paramIGameListView, Map paramMap) {}
  
  public void a(View paramView, GameItem paramGameItem, int paramInt)
  {
    if (paramView.getId() == 2131442384)
    {
      this.a.h.setValue(paramGameItem);
      this.b.a();
    }
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a("clck", paramView, this.c);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, GameItem paramGameItem, int paramInt)
  {
    ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(paramViewHolder.itemView, true, String.valueOf(paramGameItem.a()), "em_qqlive_content_choice_detail", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper.8
 * JD-Core Version:    0.7.0.1
 */