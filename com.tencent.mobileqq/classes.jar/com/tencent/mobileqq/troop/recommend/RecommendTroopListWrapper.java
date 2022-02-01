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
  private AbsListView.OnScrollListener a = new RecommendTroopListWrapper.1(this);
  private TroopMngObserver b = new RecommendTroopListWrapper.2(this);
  private TroopNotificationObserver c = new RecommendTroopListWrapper.3(this);
  private TroopRecommendObserver d = new RecommendTroopListWrapper.4(this);
  protected AppInterface i;
  protected Context j;
  protected XListView k;
  protected TextView l;
  protected RecommendTroopAdapter m;
  protected IRecommendTroopService n;
  protected RecommendTroopListWrapper.RecommendTroopListWrapperCallback o;
  public boolean p = true;
  protected boolean q = true;
  protected boolean r = true;
  
  public RecommendTroopListWrapper() {}
  
  public RecommendTroopListWrapper(AppInterface paramAppInterface, Context paramContext, XListView paramXListView, RecommendTroopListWrapper.RecommendTroopListWrapperCallback paramRecommendTroopListWrapperCallback)
  {
    this.i = paramAppInterface;
    this.j = paramContext;
    this.k = paramXListView;
    this.o = paramRecommendTroopListWrapperCallback;
    b();
  }
  
  private void j()
  {
    k();
    this.m = a();
    this.m.a(null);
    this.k.setAdapter(this.m);
    this.k.setDividerHeight(0);
    if (this.r) {
      this.k.setOnScrollListener(this.a);
    }
  }
  
  private void k()
  {
    this.l = new TextView(this.j);
    this.l.setText(HardCodeUtil.a(2131910740));
    this.l.setGravity(17);
    this.l.setTextSize(1, 14.0F);
    int i1 = Utils.a(10.0F, this.j.getResources());
    this.l.setPadding(i1, i1, i1, i1);
    this.l.setTextColor(this.j.getResources().getColor(2131168122));
    this.k.addFooterView(this.l);
    this.l.setVisibility(4);
  }
  
  private void l()
  {
    d();
    this.l.setVisibility(0);
    if (c()) {
      this.l.setText(HardCodeUtil.a(2131910741));
    }
  }
  
  protected abstract RecommendTroopAdapter a();
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      l();
    }
  }
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void b()
  {
    if (this.k == null) {
      this.k = new XListView(this.j);
    }
    AppInterface localAppInterface = this.i;
    if (localAppInterface == null) {
      return;
    }
    this.n = ((IRecommendTroopService)localAppInterface.getRuntimeService(IRecommendTroopService.class, ""));
    j();
    this.i.addObserver(this.b);
    this.i.addObserver(this.d);
    this.i.addObserver(this.c);
    if ((this.p) && (this.q)) {
      b(false);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    IRecommendTroopService localIRecommendTroopService = this.n;
    if (localIRecommendTroopService != null) {
      localIRecommendTroopService.getNotificationRecommendTroopFromServer(this.i.getLongAccountUin(), h(), 21);
    }
  }
  
  protected boolean c()
  {
    IRecommendTroopService localIRecommendTroopService = this.n;
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
  
  protected void d()
  {
    IRecommendTroopService localIRecommendTroopService = this.n;
    if (localIRecommendTroopService != null) {
      this.m.a(localIRecommendTroopService.getAddedData());
    }
    this.m.notifyDataSetChanged();
  }
  
  public void e()
  {
    this.i.removeObserver(this.c);
    this.i.removeObserver(this.b);
    this.i.removeObserver(this.d);
  }
  
  public void f()
  {
    b(false);
  }
  
  public XListView g()
  {
    return this.k;
  }
  
  protected oidb_0x935.GPS h()
  {
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("recommend_troop");
    double d1;
    int i3;
    double d2;
    String str;
    int i1;
    if (localObject != null)
    {
      d1 = ((SosoLbsInfo)localObject).mLocation.altitude;
      i3 = (int)((SosoLbsInfo)localObject).mLocation.accuracy;
      d2 = ((SosoLbsInfo)localObject).mLocation.locationTime;
      str = ((SosoLbsInfo)localObject).mLocation.cityCode;
      i1 = 0;
    }
    try
    {
      int i2 = Integer.parseInt(str);
      i1 = i2;
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
    ((oidb_0x935.GPS)localObject).uint32_accuracy.set(i3);
    ((oidb_0x935.GPS)localObject).uint32_time.set((int)d2);
    ((oidb_0x935.GPS)localObject).uint32_cityid.set(i1);
    ((oidb_0x935.GPS)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    ((oidb_0x935.GPS)localObject).uint32_client.set(2);
    return localObject;
    return null;
  }
  
  public void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndLoadMoreRecommList isEnd = ");
      localStringBuilder.append(c());
      QLog.d("RecommendTroopListWrapper", 2, localStringBuilder.toString());
    }
    if (!c()) {
      b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper
 * JD-Core Version:    0.7.0.1
 */