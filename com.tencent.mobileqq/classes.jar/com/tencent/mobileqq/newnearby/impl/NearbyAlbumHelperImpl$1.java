package com.tencent.mobileqq.newnearby.impl;

import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;

final class NearbyAlbumHelperImpl$1
  implements Runnable
{
  NearbyAlbumHelperImpl$1(NearbyActivity paramNearbyActivity) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(NearbyAlbumHelperImpl.access$000(), 0);
    localCompressInfo.o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(localCompressInfo);
    this.a.app.getNearbyProcManager().b(localCompressInfo.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */