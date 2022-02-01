package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.lyric.util.Singleton;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Comparator;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

class BeancurdCubeInfoResultComparator
  implements Comparator<oidb_0xe61.BeancurdCubeInfoResult>
{
  private final BeancurdManager jdField_a_of_type_ComTencentMobileqqActivityAioBeancurdManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Singleton<TofuDataHandlerFactory, QQAppInterface> jdField_a_of_type_ComTencentMobileqqLyricUtilSingleton;
  
  public BeancurdCubeInfoResultComparator(QQAppInterface paramQQAppInterface, BeancurdManager paramBeancurdManager, Singleton<TofuDataHandlerFactory, QQAppInterface> paramSingleton)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBeancurdManager = paramBeancurdManager;
    this.jdField_a_of_type_ComTencentMobileqqLyricUtilSingleton = paramSingleton;
  }
  
  private int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    int i = TofuConst.b((int)((oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
    paramBeancurdCubeInfoResult = ((TofuDataHandlerFactory)this.jdField_a_of_type_ComTencentMobileqqLyricUtilSingleton.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).a(i);
    if (paramBeancurdCubeInfoResult != null) {
      return paramBeancurdCubeInfoResult.a();
    }
    return 0;
  }
  
  private boolean a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    return (paramBeancurdCubeInfoResult != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.has()) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.get() != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has());
  }
  
  public int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult1, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult2)
  {
    if ((a(paramBeancurdCubeInfoResult1)) && (a(paramBeancurdCubeInfoResult2)))
    {
      int i = a(paramBeancurdCubeInfoResult1);
      int j = a(paramBeancurdCubeInfoResult2);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioBeancurdManager.b(i) - this.jdField_a_of_type_ComTencentMobileqqActivityAioBeancurdManager.b(j);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.BeancurdCubeInfoResultComparator
 * JD-Core Version:    0.7.0.1
 */