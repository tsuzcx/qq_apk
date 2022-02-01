package com.tencent.mobileqq.troop.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopNotificationObserver;
import com.tencent.mobileqq.troop.recommend.api.TroopRecommendObserver;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

public abstract class RecommendTroopListWrapper
{
  protected Context a;
  protected TextView a;
  protected AppInterface a;
  protected RecommendTroopAdapter a;
  protected IRecommendTroopService a;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new RecommendTroopListWrapper.2(this);
  private TroopNotificationObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver = new RecommendTroopListWrapper.3(this);
  protected RecommendTroopListWrapper.RecommendTroopListWrapperCallback a;
  private TroopRecommendObserver jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver = new RecommendTroopListWrapper.4(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RecommendTroopListWrapper.1(this);
  protected XListView a;
  public boolean c = true;
  protected boolean d = true;
  protected boolean e = true;
  
  public RecommendTroopListWrapper() {}
  
  public RecommendTroopListWrapper(AppInterface paramAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper$RecommendTroopListWrapperCallback = paramRecommendTroopListWrapperCallback;
    a();
  }
  
  private void f()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.a(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    if (this.e) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713184));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    int i = Utils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167142));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void h()
  {
    b();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713185));
    }
  }
  
  protected abstract RecommendTroopAdapter a();
  
  public XListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  protected oidb_0x935.GPS a()
  {
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
    double d1;
    int k;
    double d2;
    String str;
    int i;
    if (localObject != null)
    {
      d1 = ((SosoLbsInfo)localObject).mLocation.altitude;
      k = (int)((SosoLbsInfo)localObject).mLocation.accuracy;
      d2 = ((SosoLbsInfo)localObject).mLocation.locationTime;
      str = ((SosoLbsInfo)localObject).mLocation.cityCode;
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      label76:
      double d3;
      double d4;
      break label76;
    }
    d3 = Double.valueOf(((SosoLbsInfo)localObject).mLocation.mLat02 * 1000000.0D).intValue();
    d4 = Double.valueOf(((SosoLbsInfo)localObject).mLocation.mLon02 * 1000000.0D).intValue();
    localObject = new oidb_0x935.GPS();
    ((oidb_0x935.GPS)localObject).uint32_latitude.set((int)d3);
    ((oidb_0x935.GPS)localObject).uint32_longitude.set((int)d4);
    ((oidb_0x935.GPS)localObject).uint32_altitude.set((int)d1);
    ((oidb_0x935.GPS)localObject).uint32_accuracy.set(k);
    ((oidb_0x935.GPS)localObject).uint32_time.set((int)d2);
    ((oidb_0x935.GPS)localObject).uint32_cityid.set(i);
    ((oidb_0x935.GPS)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    ((oidb_0x935.GPS)localObject).uint32_client.set(2);
    return localObject;
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_AndroidContentContext);
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopApiIRecommendTroopService = ((IRecommendTroopService)localAppInterface.getRuntimeService(IRecommendTroopService.class, ""));
    f();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver);
    if ((this.c) && (this.d)) {
      b(false);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      h();
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected boolean a()
  {
    IRecommendTroopService localIRecommendTroopService = this.jdField_a_of_type_ComTencentMobileqqTroopApiIRecommendTroopService;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localIRecommendTroopService != null)
    {
      bool1 = bool2;
      if (localIRecommendTroopService.isEnd() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void b()
  {
    IRecommendTroopService localIRecommendTroopService = this.jdField_a_of_type_ComTencentMobileqqTroopApiIRecommendTroopService;
    if (localIRecommendTroopService != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.a(localIRecommendTroopService.getAddedData());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopAdapterRecommendTroopAdapter.notifyDataSetChanged();
  }
  
  protected void b(boolean paramBoolean)
  {
    IRecommendTroopService localIRecommendTroopService = this.jdField_a_of_type_ComTencentMobileqqTroopApiIRecommendTroopService;
    if (localIRecommendTroopService != null) {
      localIRecommendTroopService.getNotificationRecommendTroopFromServer(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin(), a(), 21);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRecommendApiTroopRecommendObserver);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndLoadMoreRecommList isEnd = ");
      localStringBuilder.append(a());
      QLog.d("RecommendTroopListWrapper", 2, localStringBuilder.toString());
    }
    if (!a()) {
      b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper
 * JD-Core Version:    0.7.0.1
 */