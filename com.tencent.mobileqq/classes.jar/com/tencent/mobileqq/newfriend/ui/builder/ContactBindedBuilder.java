package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class ContactBindedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  ArrayList<PhoneContact> a = new ArrayList();
  ArrayList<PhoneContact> b = new ArrayList();
  private IPhoneContactService i;
  private NewFriendServiceImpl j;
  private int k;
  
  public ContactBindedBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.i = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.j = ((NewFriendServiceImpl)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    paramContext = this.i;
    paramContext.asyncInitContactBindedData(paramContext.getBindAllFriendList());
    if (this.d.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {
      m = 5;
    } else {
      m = 4;
    }
    this.k = m;
    this.b = this.i.generateRandomList();
    this.a = ((ArrayList)this.b.clone());
    int n = this.k - this.a.size();
    int m = n;
    if (n < 0) {
      m = 0;
    }
    this.i.fillToMaxCountIfNeeded(this.a, m);
  }
  
  private void a(ContactBindedBuilder.ContactBindedHolder paramContactBindedHolder)
  {
    int m = this.i.getRecommendUnreadCount();
    if ((m != 0) && (!this.g.b()))
    {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).updateCustomNoteTxt(paramContactBindedHolder.b, m, 0);
      return;
    }
    paramContactBindedHolder.b.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactBindedBuilder.ContactBindedHolder localContactBindedHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof ContactBindedBuilder.ContactBindedHolder)))
    {
      localContactBindedHolder = (ContactBindedBuilder.ContactBindedHolder)paramView.getTag();
    }
    else
    {
      localContactBindedHolder = new ContactBindedBuilder.ContactBindedHolder();
      paramView = LayoutInflater.from(this.c).inflate(2131627597, null);
      localContactBindedHolder.b = ((TextView)paramView.findViewById(2131449123));
      localContactBindedHolder.a = ((TextView)paramView.findViewById(2131440075));
      localContactBindedHolder.c = paramView.findViewById(2131440078);
      localContactBindedHolder.d = paramView.findViewById(2131440079);
      localContactBindedHolder.e = paramView.findViewById(2131440080);
      localContactBindedHolder.f = paramView.findViewById(2131440081);
      localContactBindedHolder.g = paramView.findViewById(2131440082);
      localContactBindedHolder.h = ((ImageView)paramView.findViewById(2131434909));
      localContactBindedHolder.i = ((ImageView)paramView.findViewById(2131434910));
      localContactBindedHolder.j = ((ImageView)paramView.findViewById(2131434911));
      localContactBindedHolder.k = ((ImageView)paramView.findViewById(2131434912));
      localContactBindedHolder.l = ((ImageView)paramView.findViewById(2131434913));
      localContactBindedHolder.m = ((TextView)paramView.findViewById(2131439304));
      localContactBindedHolder.n = ((TextView)paramView.findViewById(2131439305));
      localContactBindedHolder.o = ((TextView)paramView.findViewById(2131439306));
      localContactBindedHolder.p = ((TextView)paramView.findViewById(2131439307));
      localContactBindedHolder.q = ((TextView)paramView.findViewById(2131439308));
      b(localContactBindedHolder.h);
      b(localContactBindedHolder.i);
      b(localContactBindedHolder.j);
      b(localContactBindedHolder.k);
      b(localContactBindedHolder.l);
      paramView.setTag(localContactBindedHolder);
    }
    Object localObject1 = (ArrayList)this.i.getBindAllFriendList();
    int n = ((ArrayList)localObject1).size();
    localContactBindedHolder.a.setText(String.format(HardCodeUtil.a(2131900617), new Object[] { Integer.valueOf(n) }));
    Object localObject2 = this.a.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (this.i.queryPhoneContactByMobile(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
        ((Iterator)localObject2).remove();
      }
    }
    paramInt = this.a.size();
    int m = paramInt;
    if (paramInt < this.k)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      do
      {
        m = paramInt;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        m = paramInt;
        if (!this.a.contains(localObject2))
        {
          m = paramInt;
          if (((PhoneContact)localObject2).uin.equals("0"))
          {
            this.a.add(localObject2);
            m = paramInt + 1;
          }
        }
        paramInt = m;
      } while (m != this.k);
    }
    if (m != 1)
    {
      if (m != 2)
      {
        if (m != 3)
        {
          if (m != 4)
          {
            if (m == 5)
            {
              localContactBindedHolder.c.setVisibility(0);
              localContactBindedHolder.d.setVisibility(0);
              localContactBindedHolder.e.setVisibility(0);
              localContactBindedHolder.f.setVisibility(0);
              localContactBindedHolder.g.setVisibility(0);
              localObject1 = (PhoneContact)this.a.get(0);
              localContactBindedHolder.r = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.h.setImageBitmap(this.e.a(11, localContactBindedHolder.r));
              localContactBindedHolder.m.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.a.get(1);
              localContactBindedHolder.s = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.i.setImageBitmap(this.e.a(11, localContactBindedHolder.s));
              localContactBindedHolder.n.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.a.get(2);
              localContactBindedHolder.t = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.j.setImageBitmap(this.e.a(11, localContactBindedHolder.t));
              localContactBindedHolder.o.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.a.get(3);
              localContactBindedHolder.u = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.k.setImageBitmap(this.e.a(11, localContactBindedHolder.u));
              localContactBindedHolder.p.setText(((PhoneContact)localObject1).name);
              localObject1 = (PhoneContact)this.a.get(4);
              localContactBindedHolder.v = ((PhoneContact)localObject1).unifiedCode;
              localContactBindedHolder.l.setImageBitmap(this.e.a(11, localContactBindedHolder.v));
              localContactBindedHolder.q.setText(((PhoneContact)localObject1).name);
            }
          }
          else
          {
            localContactBindedHolder.c.setVisibility(0);
            localContactBindedHolder.d.setVisibility(0);
            localContactBindedHolder.e.setVisibility(0);
            localContactBindedHolder.f.setVisibility(0);
            if (this.k == 4) {
              localContactBindedHolder.g.setVisibility(8);
            } else {
              localContactBindedHolder.g.setVisibility(4);
            }
            localObject1 = (PhoneContact)this.a.get(0);
            localContactBindedHolder.r = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.h.setImageBitmap(this.e.a(11, localContactBindedHolder.r));
            localContactBindedHolder.m.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.a.get(1);
            localContactBindedHolder.s = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.i.setImageBitmap(this.e.a(11, localContactBindedHolder.s));
            localContactBindedHolder.n.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.a.get(2);
            localContactBindedHolder.t = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.j.setImageBitmap(this.e.a(11, localContactBindedHolder.t));
            localContactBindedHolder.o.setText(((PhoneContact)localObject1).name);
            localObject1 = (PhoneContact)this.a.get(3);
            localContactBindedHolder.u = ((PhoneContact)localObject1).unifiedCode;
            localContactBindedHolder.k.setImageBitmap(this.e.a(11, localContactBindedHolder.u));
            localContactBindedHolder.p.setText(((PhoneContact)localObject1).name);
          }
        }
        else
        {
          localContactBindedHolder.c.setVisibility(0);
          localContactBindedHolder.d.setVisibility(0);
          localContactBindedHolder.e.setVisibility(0);
          localContactBindedHolder.f.setVisibility(4);
          if (this.k == 4) {
            localContactBindedHolder.g.setVisibility(8);
          } else {
            localContactBindedHolder.g.setVisibility(4);
          }
          localObject1 = (PhoneContact)this.a.get(0);
          localContactBindedHolder.r = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.h.setImageBitmap(this.e.a(11, localContactBindedHolder.r));
          localContactBindedHolder.m.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.a.get(1);
          localContactBindedHolder.s = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.i.setImageBitmap(this.e.a(11, localContactBindedHolder.s));
          localContactBindedHolder.n.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.a.get(2);
          localContactBindedHolder.t = ((PhoneContact)localObject1).unifiedCode;
          localContactBindedHolder.j.setImageBitmap(this.e.a(11, localContactBindedHolder.t));
          localContactBindedHolder.o.setText(((PhoneContact)localObject1).name);
        }
      }
      else
      {
        localContactBindedHolder.c.setVisibility(0);
        localContactBindedHolder.d.setVisibility(0);
        localContactBindedHolder.e.setVisibility(4);
        localContactBindedHolder.f.setVisibility(4);
        if (this.k == 4) {
          localContactBindedHolder.g.setVisibility(8);
        } else {
          localContactBindedHolder.g.setVisibility(4);
        }
        localObject1 = (PhoneContact)this.a.get(0);
        localContactBindedHolder.r = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.h.setImageBitmap(this.e.a(11, localContactBindedHolder.r));
        localContactBindedHolder.m.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.a.get(1);
        localContactBindedHolder.s = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.i.setImageBitmap(this.e.a(11, localContactBindedHolder.s));
        localContactBindedHolder.n.setText(((PhoneContact)localObject1).name);
      }
    }
    else
    {
      localContactBindedHolder.c.setVisibility(0);
      localContactBindedHolder.d.setVisibility(4);
      localContactBindedHolder.e.setVisibility(4);
      localContactBindedHolder.f.setVisibility(4);
      if (this.k == 4) {
        localContactBindedHolder.g.setVisibility(8);
      } else {
        localContactBindedHolder.g.setVisibility(4);
      }
      localObject1 = (PhoneContact)this.a.get(0);
      localContactBindedHolder.r = ((PhoneContact)localObject1).unifiedCode;
      localContactBindedHolder.h.setImageBitmap(this.e.a(11, localContactBindedHolder.r));
      localContactBindedHolder.m.setText(((PhoneContact)localObject1).name);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(String.format(HardCodeUtil.a(2131900623), new Object[] { Integer.valueOf(n) }));
    }
    NewFriendUtil.a(paramView, this.g.b() ^ true);
    a(localContactBindedHolder);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131440076)
    {
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof ContactBindedBuilder.ContactBindedHolder)))
      {
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).startContactBindFromOther(this.d, 222, this.b);
        this.j.markRecommendReaded();
        ReportController.b(this.d, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.ContactBindedBuilder
 * JD-Core Version:    0.7.0.1
 */