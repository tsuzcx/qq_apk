package com.tencent.mobileqq.troop.troopnotification.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.DelMenuBuilder;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ApplicantHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

class TroopNotificationFragment$24
  extends SuspiciousAdapter<MessageRecord>
{
  TroopNotificationFragment$24(TroopNotificationFragment paramTroopNotificationFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = new SwipRightMenuBuilder.SwipItemBaseHolder();
    paramViewGroup = this.m.a(paramContext, paramInt, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    paramContext = new SuspiciousHolder(paramContext, paramViewGroup);
    paramContext.s = ((SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    localObject = new NotifyAndRecAdapter.ApplicantHolder();
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).a = paramViewGroup.findViewById(2131441347);
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).b = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).a.findViewById(2131441360));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).d = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).a.findViewById(2131441361));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).c = ((LinearLayout)((NotifyAndRecAdapter.ApplicantHolder)localObject).a.findViewById(2131441357));
    ((NotifyAndRecAdapter.ApplicantHolder)localObject).e = ((TextView)((NotifyAndRecAdapter.ApplicantHolder)localObject).a.findViewById(2131441356));
    paramContext.t = ((NotifyAndRecAdapter.ApplicantHolder)localObject);
    paramContext.i = ((LinearLayout)paramViewGroup.findViewById(2131441363));
    paramContext.j = ((ImageView)paramViewGroup.findViewById(2131441346));
    paramContext.k = ((LinearLayout)paramViewGroup.findViewById(2131441354));
    paramContext.m = ((ImageView)paramViewGroup.findViewById(2131441367));
    paramContext.l = ((TextView)paramViewGroup.findViewById(2131441352));
    paramContext.n = ((TextView)paramViewGroup.findViewById(2131441364));
    paramContext.o = ((TextView)paramViewGroup.findViewById(2131441366));
    paramContext.p = ((TextView)paramViewGroup.findViewById(2131441353));
    paramContext.q = ((Button)paramViewGroup.findViewById(2131441362));
    paramContext.r = ((ShaderAnimLayout)paramViewGroup.findViewById(2131448064));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131448063);
    NotifyAndRecAdapter.a(paramContext.i, false);
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {
      return;
    }
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    this.m.a(this.b, paramViewHolder.itemView, paramInt, paramMessageRecord, localSuspiciousHolder.s, new TroopNotificationFragment.24.1(this), this.a);
    TroopNotificationFragment.a(this.n, paramViewHolder, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.24
 * JD-Core Version:    0.7.0.1
 */