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
  private final QQAppInterface a;
  private final BeancurdManager b;
  private final Singleton<TofuDataHandlerFactory, QQAppInterface> c;
  
  public BeancurdCubeInfoResultComparator(QQAppInterface paramQQAppInterface, BeancurdManager paramBeancurdManager, Singleton<TofuDataHandlerFactory, QQAppInterface> paramSingleton)
  {
    this.a = paramQQAppInterface;
    this.b = paramBeancurdManager;
    this.c = paramSingleton;
  }
  
  private boolean a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    return (paramBeancurdCubeInfoResult != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.has()) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.get() != null) && (paramBeancurdCubeInfoResult.beancurdCubeInfo.uint64_busi_id.has());
  }
  
  private int b(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult)
  {
    int i = TofuConst.c((int)((oidb_0xe61.BeancurdCubeInfo)paramBeancurdCubeInfoResult.beancurdCubeInfo.get()).uint64_busi_id.get());
    paramBeancurdCubeInfoResult = ((TofuDataHandlerFactory)this.c.get(this.a)).a(i);
    if (paramBeancurdCubeInfoResult != null) {
      return paramBeancurdCubeInfoResult.a();
    }
    return 0;
  }
  
  public int a(oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult1, oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult2)
  {
    if ((a(paramBeancurdCubeInfoResult1)) && (a(paramBeancurdCubeInfoResult2)))
    {
      int i = b(paramBeancurdCubeInfoResult1);
      int j = b(paramBeancurdCubeInfoResult2);
      return this.b.b(i) - this.b.b(j);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.BeancurdCubeInfoResultComparator
 * JD-Core Version:    0.7.0.1
 */