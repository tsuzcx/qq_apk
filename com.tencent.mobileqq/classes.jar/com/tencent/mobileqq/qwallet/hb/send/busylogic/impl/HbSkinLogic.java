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
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(R.string.aS);
  private int jdField_a_of_type_Int = -1;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new HbSkinLogic.3(this);
  private IIndividualRedPacket jdField_a_of_type_ComQwalletTempIIndividualRedPacket = null;
  private IRedPacket.OnGetSkinListener jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemIRedPacket$OnGetSkinListener = new HbSkinLogic.2(this);
  private HbSkinInfo jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo = HbSkinInfo.HbSkinFactory.a(jdField_a_of_type_JavaLangString);
  private SendHbActivity jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  List<HbSkinLogic.ItemSelectListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new HbSkinLogic.1(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private List<HbSkinInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private List<LinearLayout> c = new ArrayList();
  
  public HbSkinLogic(SendHbActivity paramSendHbActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity = paramSendHbActivity;
    d();
  }
  
  private void a(List<HbSkinInfo> paramList)
  {
    paramList.add(HbSkinInfo.HbSkinFactory.b(jdField_a_of_type_JavaLangString));
    if ((b()) && (!paramList.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo)))
    {
      QLog.d("HbSkinLogic", 2, "add vip info to list!");
      paramList.add(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo);
    }
  }
  
  private void b(List<HbSkinInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinInfo localSkinInfo = ((HbSkinInfo)paramList.next()).jdField_a_of_type_WalletSkinInfo;
      RedPacketInfoBase localRedPacketInfoBase = new RedPacketInfoBase();
      localRedPacketInfoBase.skinType = 1;
      localRedPacketInfoBase.skinId = localSkinInfo.skin_id;
      localRedPacketInfoBase.isCache = HbSkinInfo.jdField_a_of_type_Boolean;
      ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).getSkin(localRedPacketInfoBase, this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemIRedPacket$OnGetSkinListener);
    }
  }
  
  private boolean b()
  {
    IIndividualRedPacket localIIndividualRedPacket = this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket;
    if (localIIndividualRedPacket != null) {
      return localIIndividualRedPacket.getIndividualRedPacketEnable();
    }
    return false;
  }
  
  private void d()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = new QwAdapter(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, localArrayList, R.layout.jdField_b_of_type_Int, new HbSkinLogic.HbSkinHolder(this));
    this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket = ((IIndividualRedPacket)((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getAppInterface().getRuntimeService(IIndividualRedPacket.class));
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).registRedPacketSkinListObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    ApngImage.playByTag(0);
  }
  
  public int a()
  {
    return HbSkinInfo.a(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList());
  }
  
  public void a()
  {
    QLog.i("HbSkinLogic", 2, "onDestroy called...");
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity = null;
    this.c.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList().clear();
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).unregistRedPacketSkinListObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    if (((IRedPacketManager)QRoute.api(IRedPacketManager.class)).isRiskSwitchOpen()) {
      return;
    }
    b(0);
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.i("HbSkinLogic", 2, "request skin list...");
      String str = paramBundle.getString("hb_from_type", "");
      if ("100".equals(str))
      {
        paramBundle = paramBundle.getString("hb_from", "");
        ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).requestRedPacketSkinList(str, paramBundle, this.jdField_a_of_type_Int);
      }
      else
      {
        ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).requestRedPacketSkinList();
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(View paramView)
  {
    this.c.remove(paramView);
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    this.c.add(paramLinearLayout);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, 226.0F));
    HorizontalListView localHorizontalListView = new HorizontalListView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity);
    localHorizontalListView.setDividerWidth(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplSendHbActivity, 12.0F));
    paramLinearLayout.addView(localHorizontalListView, localLayoutParams);
    localHorizontalListView.setAdapter(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter);
    localHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
  }
  
  public void a(HbSkinLogic.ItemSelectListener paramItemSelectListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramItemSelectListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    int i = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set select skin: ");
    ((StringBuilder)localObject).append(i);
    QLog.i("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
    if (this.jdField_b_of_type_Int != i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set select skin id : ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" serverSkinId = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      QLog.i("HbSkinLogic", 2, ((StringBuilder)localObject).toString());
      ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).setSelectedSkin(i, this.jdField_a_of_type_MqqObserverBusinessObserver);
    }
    if (-2 != i)
    {
      QLog.i("HbSkinLogic", 2, "clear vip info...");
      localObject = this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket;
      if (localObject != null) {
        ((IIndividualRedPacket)localObject).setRedPacketFlags(((IIndividualRedPacket)localObject).IndividualRedPacketManager$FLAG_REDPACKET_CANNOT_USE(), this.jdField_a_of_type_ComQwalletTempIIndividualRedPacket.IndividualRedPacketManager$FLAG_REDPACKET_ENABLE(), true);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ViewGroup)((LinearLayout)localIterator.next()).getParent()).setVisibility(paramInt);
    }
  }
  
  public void c()
  {
    List localList = this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is vip: ");
    localStringBuilder.append(b());
    QLog.d("HbSkinLogic", 2, localStringBuilder.toString());
    if (b())
    {
      if (!localList.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo))
      {
        QLog.d("HbSkinLogic", 2, "add vip info to list!");
        localList.add(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo);
        HbSkinInfo.c = this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id;
        HbSkinInfo.a(localList);
        this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
      }
    }
    else if (localList.contains(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo))
    {
      QLog.d("HbSkinLogic", 2, "remove vip info to list!");
      localList.remove(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendBusylogicImplHbSkinInfo);
      HbSkinInfo.c = 0;
      HbSkinInfo.a(localList);
      this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic
 * JD-Core Version:    0.7.0.1
 */