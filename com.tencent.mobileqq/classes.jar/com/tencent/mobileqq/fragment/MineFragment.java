package com.tencent.mobileqq.fragment;

import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x91f.oidb_0x91f.ReqBody;

public class MineFragment
{
  public static void a(INearbyAppInterface paramINearbyAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby", 2, "clearLbsInfoAndExit");
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramINearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L));
    if ((NearbyHandler)paramINearbyAppInterface.getBusinessHandler(NearbyConstants.a) != null)
    {
      oidb_0x91f.ReqBody localReqBody = new oidb_0x91f.ReqBody();
      localReqBody.uint32_state.set(0);
      ProtoUtils.a((AppRuntime)paramINearbyAppInterface, new MineFragment.1(paramINearbyAppInterface), localReqBody.toByteArray(), "OidbSvc.0x91f", 2335, 5, null, 0L);
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(paramINearbyAppInterface.getAccount(), false);
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramINearbyAppInterface.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false));
    paramINearbyAppInterface.setmNeedStoreAnchorage(false);
    ThreadManager.post(new MineFragment.2(paramINearbyAppInterface), 10, null, true);
  }
  
  public static void b(INearbyAppInterface paramINearbyAppInterface)
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramINearbyAppInterface.getCurrentAccountUin());
    localStringBuilder.append("v5.3.nb");
    localObject = ((BaseApplication)localObject).getFileStreamPath(localStringBuilder.toString());
    if (((File)localObject).exists())
    {
      ((File)localObject).delete();
      NearbyUtils.a("Q.nearby", "clearNearbyCache", new Object[0]);
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(paramINearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MineFragment
 * JD-Core Version:    0.7.0.1
 */