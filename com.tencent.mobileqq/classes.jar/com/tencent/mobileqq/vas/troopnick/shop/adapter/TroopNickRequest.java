package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.CGetChiefReq;
import QC.CGetChiefRsp;
import QC.ModuleData;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TroopNickRequest
  implements IRequestData
{
  public static final String a;
  protected ShopAdapter b;
  protected boolean c;
  protected boolean d;
  protected int e;
  private int f;
  private long g;
  private List<Object> h = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("list_cache");
    a = localStringBuilder.toString();
  }
  
  public TroopNickRequest(int paramInt, long paramLong, ShopAdapter paramShopAdapter)
  {
    this.f = paramInt;
    this.b = paramShopAdapter;
    this.g = paramLong;
  }
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof CGetChiefRsp))
    {
      ??? = (CGetChiefRsp)paramObject;
      if ((((CGetChiefRsp)???).ret == 0) && (((CGetChiefRsp)???).modData != null) && (((CGetChiefRsp)???).modData.size() > 0))
      {
        ??? = ((CGetChiefRsp)???).modData;
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext()) {
          this.d = "true".equals(((ModuleData)localIterator.next()).extModParams.get("NoMore"));
        }
        this.e = ((ArrayList)???).size();
      }
    }
    synchronized (this.h)
    {
      this.h.clear();
      this.h.add(paramObject);
      Collections.sort(this.h, new TroopNickRequest.1(this));
      paramObject = this.h.toArray();
      ThreadManagerV2.getUIHandlerV2().post(new TroopNickRequest.2(this, paramObject));
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void b()
  {
    VasUtil.a().getJceRequset().build("QC.MallChiefServer.MallChiefObj", "QCMallChief.getChiefList", 1).request("getChiefList", new CGetChiefReq(IJce.Util.a(), this.f, 3, this.g, null), new CGetChiefRsp(), new TroopNickRequest.3(this), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest
 * JD-Core Version:    0.7.0.1
 */