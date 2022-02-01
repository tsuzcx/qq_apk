package com.tencent.open.agent;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class BindGroupFragment$3
  implements AdapterView.OnItemClickListener
{
  BindGroupFragment$3(BindGroupFragment paramBindGroupFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((BindGroupAdapter.ViewHolder)paramView.getTag()).a;
    if (paramAdapterView.isThirdAppBind())
    {
      BindGroupFragment.b(this.a, HardCodeUtil.a(2131701202));
      return;
    }
    if (paramAdapterView.isNewTroop())
    {
      BindGroupFragment.a(this.a, HardCodeUtil.a(2131701188), paramAdapterView.troopuin);
      return;
    }
    BindGroupFragment.a(this.a, HardCodeUtil.a(2131701191));
    ((TroopHandler)BindGroupFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue(), Long.valueOf(paramAdapterView.troopuin).longValue(), BindGroupFragment.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.3
 * JD-Core Version:    0.7.0.1
 */