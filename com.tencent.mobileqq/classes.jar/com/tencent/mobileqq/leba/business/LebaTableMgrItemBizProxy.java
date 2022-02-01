package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.qcircle.mgr.LebaQCircleTableMgrItem;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.List;

public class LebaTableMgrItemBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaTableMgrItemBiz>> a = new ArrayList();
  public List<ILebaTableMgrItemBiz> b = new ArrayList();
  
  static
  {
    a.add(LebaQCircleTableMgrItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaTableMgrItemBizProxy
 * JD-Core Version:    0.7.0.1
 */