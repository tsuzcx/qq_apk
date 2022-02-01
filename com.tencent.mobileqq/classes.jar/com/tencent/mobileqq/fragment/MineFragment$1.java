package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class MineFragment$1
  extends ProtoUtils.AppProtocolObserver
{
  MineFragment$1(INearbyAppInterface paramINearbyAppInterface) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool1;
    if (paramInt == 0)
    {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setVisibilityForPeople(this.b.getCurrentAccountUin(), false);
      bool1 = false;
    }
    else
    {
      bool1 = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getLocVisiblityForPeople(this.b.getCurrentAccountUin());
    }
    paramArrayOfByte = new HashMap();
    paramArrayOfByte.put("param_reason", String.valueOf(paramInt));
    paramBundle = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    String str = this.b.getCurrentAccountUin();
    boolean bool2;
    if (paramInt == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramBundle.collectPerformance(str, "oidb_0x91f", bool2, 0L, 0L, paramArrayOfByte, "");
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("oidb_0x91f| visible:");
      paramArrayOfByte.append(bool1);
      paramArrayOfByte.append("replyCode:");
      paramArrayOfByte.append(paramInt);
      QLog.d("Q.nearby", 2, paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MineFragment.1
 * JD-Core Version:    0.7.0.1
 */