package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class TroopEntranceBar
  extends Observable
  implements View.OnClickListener
{
  private Drawable A;
  private Drawable B;
  private Drawable C;
  public QQAppInterface a;
  public Context b;
  public SessionInfo c;
  public RelativeLayout d;
  protected View e;
  public ChatAdapter1 f;
  public ChatXListView g;
  public Observer h;
  protected IFaceDecoder i = null;
  View j;
  View k;
  TextView l;
  ImageView m;
  public int n;
  public long o = 0L;
  public int p = 0;
  public List<TroopInfo> q = new ArrayList();
  public List<String> r = new ArrayList();
  public Map<String, Integer> s = new HashMap();
  public int t = 0;
  public boolean u = false;
  protected AvatarObserver v = new TroopEntranceBar.StaticFriendListObserver(this, null);
  private int w;
  private int x;
  private LightingColorFilter y;
  private LightingColorFilter z;
  
  public void a()
  {
    deleteObservers();
    this.a.removeObserver(this.v);
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.f = null;
    this.g = null;
    this.h = null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
    localReqBody.uint32_channel.set(1);
    localReqBody.uint64_subscribe_code.set(paramLong);
    ProtoUtils.b(this.a, new TroopEntranceBar.3(this, paramLong), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.p <= 0) && (this.n <= 0))
    {
      this.t = -1;
      return;
    }
    this.q.clear();
    this.r.clear();
    this.s.clear();
    this.o = 0L;
    this.p = 0;
    Object localObject1 = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).h();
    try
    {
      long l1 = Long.valueOf(this.c.b).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l1)
          {
            this.p += 1;
            this.q.add(localObject2);
            if (paramQQAppInterface.getTroopMask(((TroopInfo)localObject2).troopuin) == 3) {
              this.r.add(((TroopInfo)localObject2).troopuin);
            }
            this.s.put(((TroopInfo)localObject2).troopuin, Integer.valueOf(paramQQAppInterface.getConversationFacade().a(((TroopInfo)localObject2).troopuin, 1)));
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label226:
      break label226;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is ");
    ((StringBuilder)localObject1).append(this.c.b);
    QLog.d(".troop.troop_pubaccount", 2, ((StringBuilder)localObject1).toString());
    d();
    e();
    paramQQAppInterface.getMsgHandler().b(this.r);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramSessionInfo;
    this.d = paramRelativeLayout;
    paramSessionInfo = this.d;
    if (paramSessionInfo != null) {
      this.e = paramSessionInfo.findViewById(2131442214);
    }
    this.f = paramChatAdapter1;
    this.g = paramChatXListView;
    this.h = paramObserver;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface.addObserver(this.v);
    this.i = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.w = paramContext.getResources().getColor(2131167008);
    this.x = paramContext.getResources().getColor(2131167009);
    this.y = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.w);
    this.z = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.x);
  }
  
  public void b()
  {
    if (this.d != null)
    {
      if (this.u) {
        return;
      }
      if (this.k == null) {
        this.k = LayoutInflater.from(this.b).inflate(2131626651, null);
      }
      if (this.d.indexOfChild(this.k) == -1)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.b, 18.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131442214);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.b, 41.0F);
        this.d.addView(this.k, (ViewGroup.LayoutParams)localObject);
      }
      if (this.j == null) {
        this.j = this.k.findViewById(2131447879);
      }
      this.l = ((TextView)this.j.findViewById(2131447882));
      this.m = ((ImageView)this.j.findViewById(2131447880));
      Object localObject = (LinearLayout.LayoutParams)this.m.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.b, 4.0F);
      ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.b, 5.0F);
      int i1 = DisplayUtil.a(this.b, 18.0F);
      ((LinearLayout.LayoutParams)localObject).height = i1;
      ((LinearLayout.LayoutParams)localObject).width = i1;
      this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (ThemeUtil.isInNightMode(this.a)) {
        this.j.setBackgroundResource(2130853319);
      } else {
        this.j.setBackgroundResource(2130853320);
      }
      this.C = this.b.getResources().getDrawable(2130844788);
      this.j.setOnClickListener(this);
      this.u = true;
      c();
      this.k.setVisibility(8);
      ThreadManager.post(new TroopEntranceBar.1(this), 8, null, true);
    }
  }
  
  public void c()
  {
    if (!this.u) {
      return;
    }
    ImageView localImageView = (ImageView)this.j.findViewById(2131447881);
    localImageView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    localLayoutParams.height = -2;
    localLayoutParams.width = -2;
    localLayoutParams.leftMargin = DisplayUtil.a(this.b, 3.0F);
    localLayoutParams.rightMargin = DisplayUtil.a(this.b, 8.0F);
    Drawable localDrawable = this.b.getResources().getDrawable(2130844789);
    localLayoutParams.leftMargin = DisplayUtil.a(this.b, 11.0F);
    if (this.A == null) {
      this.A = localDrawable.getConstantState().newDrawable(this.b.getResources()).mutate();
    }
    this.A.setColorFilter(this.y);
    localImageView.setImageDrawable(this.A);
    this.l.setTextColor(this.w);
    if (this.B == null) {
      this.B = this.C.getConstantState().newDrawable(this.b.getResources()).mutate();
    }
    this.B.setColorFilter(this.y);
    this.m.setImageDrawable(this.B);
    this.l.setText(2131895455);
  }
  
  public void d()
  {
    Iterator localIterator = this.s.values().iterator();
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((Integer)localIterator.next()).intValue()) {}
    this.o = l1;
  }
  
  public void e()
  {
    int i1 = this.p;
    String str;
    if (i1 <= 0)
    {
      this.t = 0;
      str = "entry_none";
    }
    for (;;)
    {
      break;
      if (i1 == 1)
      {
        if (this.o <= 0L) {
          this.t = 3;
        } else {
          this.t = 1;
        }
        str = "entry_one";
      }
      else
      {
        if (this.o <= 0L) {
          this.t = 4;
        } else {
          this.t = 2;
        }
        str = "entry_more";
      }
    }
    QQAppInterface localQQAppInterface = this.a;
    Object localObject = this.c;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((SessionInfo)localObject).b;
    }
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_public", "", "oper", str, 0, 0, "", "", "", (String)localObject);
  }
  
  public void f()
  {
    Object localObject1 = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).h();
    try
    {
      long l1 = Long.valueOf(this.c.b).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l1)
          {
            this.p += 1;
            this.q.add(localObject2);
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label108:
      break label108;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is ");
    ((StringBuilder)localObject1).append(this.c.b);
    QLog.d(".troop.troop_pubaccount", 2, ((StringBuilder)localObject1).toString());
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.post(new TroopEntranceBar.2(this), 8, null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar
 * JD-Core Version:    0.7.0.1
 */