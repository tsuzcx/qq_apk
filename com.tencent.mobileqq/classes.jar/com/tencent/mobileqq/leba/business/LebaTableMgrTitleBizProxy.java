package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.List;

public class LebaTableMgrTitleBizProxy
{
  @ConfigInject(configPath="Business/qqleba-impl/src/main/resources/Inject_LebaBusiness.yml", version=1)
  public static ArrayList<Class<? extends ILebaTableMgrTitleBiz>> a = new ArrayList();
  public List<ILebaTableMgrTitleBiz> b = new ArrayList();
  
  static
  {
    a.add(LebaDiyIconTableMgTitle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.LebaTableMgrTitleBizProxy
 * JD-Core Version:    0.7.0.1
 */