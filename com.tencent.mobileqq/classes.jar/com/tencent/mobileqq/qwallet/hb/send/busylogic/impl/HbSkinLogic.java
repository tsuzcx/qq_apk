package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class HbSkinLogic
{
  private static final String b = HardCodeUtil.a(R.string.aW);
  List<HbSkinLogic.ItemSelectListener> a = new ArrayList();
  private List<HbSkinInfo> c = new ArrayList();
  private SendHbActivity d;
  private QwAdapter e;
  private List<LinearLayout> f = new ArrayList();
  private boolean g;
  private int h = -1;
  private int i = -1;
  private IIndividualRedPacket j = null;
  private HbSkinInfo k = HbSkinInfo.HbSkinFactory.a(b);
  private boolean l = false;
  private BusinessObserver m = new HbSkinLogic.1(this);
  private IRedPacket.OnGetSkinListener n = new HbSkinLogic.2(this);
  private AdapterView.OnItemClickListener o = new HbSkinLogic.3(this);
  
  public HbSkinLogic(SendHbActivity paramSendHbActivity)
  {
    this.d = paramSendHbActivity;
    g();
  }
  
  private void a(List<HbSkinInfo> paramList)
  {
    paramList.add(HbSkinInfo.HbSkinFactory.b(b));
    if ((h()) && (!paramList.contains(this.k)))
    {
      QLog.d("HbSkinLogic", 2, "add vip info to list!");
      paramList.add(this.k);
    }
  }
  
  private void b(List<HbSkinInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinInfo localSkinInfo = ((HbSkinInfo)paramList.next()).f;
      RedPacketInfoBase localRedPacketInfoBase = new RedPacketInfoBase();
      localRedPacketInfoBase.skinType = 1;
      localRedPacketInfoBase.skinId = localSkinInfo.skin_id;
      localRedPacketInfoBase.isCache = HbSkinInfo.e;
      ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getSkin(localRedPacketInfoBase, this.n);
    }
  }
  
  private void g()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    this.e = new QwAdapter(this.d, localArrayList, R.layout.b, new HbSkinLogic.HbSkinHolder(this));
    this.j = ((IIndividualRedPacket)((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface().getRuntimeService(IIndividualRedPacket.class));
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).registRedPacketSkinListObserver(this.m);
    ApngImage.playByTag(0);
  }
  
  private boolean h()
  {
    IIndividualRedPacket localIIndividualRedPacket = this.j;
    if (localIIndividualRedPacket != null) {
      return localIIndividualRedPacket.getIndividualRedPacketEnable();
    }
    return false;
  }
  
  public void a()
  {
    QLog.i("HbSkinLogic", 2, "onDestroy called...");
    this.d = null;
    this.f.clear();
    this.a.clear();
    this.e.getList().clear();
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).unregistRedPacketSkinListObserver(this.m);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    if (((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isRiskSwitchOpen()) {
      return;
    }
    b(0);
    if (!this.l)
    {
      QLog.i("HbSkinLogic", 2, "request skin list...");
      String str = paramBundle.getString("hb_from_type", "");
      if ("100".equals(str))
      {
        paramBundle = paramBundle.getString("hb_from", "");
        ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).requestRedPacketSkinList(str, paramBundle, this.h);
      }
      else
      {
        ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).requestRedPacketSkinList();
      }
      this.l = true;
    }
  }
  
  public void a(View paramView)
  {
    this.f.remove(paramView);
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.f.add(paramLinearLayout);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this.d, 226.0F));
    HorizontalListView localHorizontalListView = new HorizontalListView(this.d);
    localHorizontalListView.setDividerWidth(DisplayUtil.a(this.d, 12.0F));
    paramLinearLayout.addView(localHorizontalListView, localLayoutParams);
    localHorizontalListView.setAdapter(this.e);
    localHorizontalListView.setOnItemClickListener(this.o);
    this.e.notifyDataSetChanged();
  }
  
  public void a(HbSkinLogic.ItemSelectListener paramItemSelectListener)
  {
    this.a.add(paramItemSelectListener);
  }
  
  public void b()
  {
    int i1 = e();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set select skin: ");
    ((StringBuilder)localObject).append(i1);
    QLog.i("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
    if (this.i != i1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set select skin id : ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" serverSkinId = ");
      ((StringBuilder)localObject).append(this.i);
      QLog.i("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
      ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).setSelectedSkin(i1, this.m);
    }
    if (-2 != i1)
    {
      QLog.i("HbSkinLogic", 2, "clear vip info...");
      localObject = this.j;
      if (localObject != null) {
        ((IIndividualRedPacket)localObject).setRedPacketFlags(((IIndividualRedPacket)localObject).IndividualRedPacketManager$FLAG_REDPACKET_CANNOT_USE(), this.j.IndividualRedPacketManager$FLAG_REDPACKET_ENABLE(), true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((ViewGroup)((LinearLayout)localIterator.next()).getParent()).setVisibility(paramInt);
    }
  }
  
  public void c()
  {
    List localList = this.e.getList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is vip: ");
    localStringBuilder.append(h());
    QLog.d("HbSkinLogic", 2, localStringBuilder.toString());
    if (h())
    {
      if (!localList.contains(this.k))
      {
        QLog.d("HbSkinLogic", 2, "add vip info to list!");
        localList.add(this.k);
        HbSkinInfo.d = this.k.f.skin_id;
        HbSkinInfo.a(localList);
        this.e.notifyDataSetChanged();
      }
    }
    else if (localList.contains(this.k))
    {
      QLog.d("HbSkinLogic", 2, "remove vip info to list!");
      localList.remove(this.k);
      HbSkinInfo.d = 0;
      HbSkinInfo.a(localList);
      this.e.notifyDataSetChanged();
    }
  }
  
  public boolean d()
  {
    return this.g;
  }
  
  public int e()
  {
    return HbSkinInfo.b(this.e.getList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic
 * JD-Core Version:    0.7.0.1
 */