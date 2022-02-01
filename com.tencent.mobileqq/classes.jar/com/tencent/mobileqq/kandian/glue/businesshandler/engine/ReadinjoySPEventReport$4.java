package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;

final class ReadinjoySPEventReport$4
  implements Runnable
{
  public void run()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    if ((i != 2) && (i != 3) && (i == 4)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.4
 * JD-Core Version:    0.7.0.1
 */