package com.tencent.mobileqq.vas.troopnick.shop.adapter;

import QC.CGetChiefReq;
import QC.CGetChiefRsp;
import QC.ModuleData;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter;
import com.tencent.mobileqq.vip.JceProtocol;
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
  protected int a;
  private long jdField_a_of_type_Long;
  protected ShopAdapter a;
  private List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private int b;
  protected boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "list_cache";
  }
  
  public TroopNickRequest(int paramInt, long paramLong, ShopAdapter paramShopAdapter)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVasTroopnickShopWidgetShopAdapter = paramShopAdapter;
    this.jdField_a_of_type_Long = paramLong;
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
          this.jdField_b_of_type_Boolean = "true".equals(((ModuleData)localIterator.next()).extModParams.get("NoMore"));
        }
        this.jdField_a_of_type_Int = ((ArrayList)???).size();
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.add(paramObject);
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new TroopNickRequest.1(this));
      paramObject = this.jdField_a_of_type_JavaUtilList.toArray();
      ThreadManagerV2.getUIHandlerV2().post(new TroopNickRequest.2(this, paramObject));
      return;
    }
  }
  
  public void b()
  {
    new JceProtocol("QC.MallChiefServer.MallChiefObj", "QCMallChief.getChiefList", 1).a("getChiefList", new CGetChiefReq(JceProtocol.a(), this.jdField_b_of_type_Int, 3, this.jdField_a_of_type_Long, null), new CGetChiefRsp(), new TroopNickRequest.3(this), this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest
 * JD-Core Version:    0.7.0.1
 */