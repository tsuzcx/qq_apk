package com.tencent.mobileqq.fragment;

import admv;
import admw;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import tencent.im.oidb.cmd0x91f.oidb_0x91f.ReqBody;

public class MineFragment
{
  public static void a(NearbyAppInterface paramNearbyAppInterface)
  {
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "nearby_enter_time", Long.valueOf(0L));
    if ((NearbyHandler)paramNearbyAppInterface.a(3) != null)
    {
      oidb_0x91f.ReqBody localReqBody = new oidb_0x91f.ReqBody();
      localReqBody.uint32_state.set(0);
      ProtoUtils.a(paramNearbyAppInterface, new admv(paramNearbyAppInterface), localReqBody.toByteArray(), "OidbSvc.0x91f", 2335, 5, null, 0L);
    }
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), false);
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false));
    paramNearbyAppInterface.c = false;
    ThreadManager.post(new admw(paramNearbyAppInterface), 10, null, true);
  }
  
  public static void b(NearbyAppInterface paramNearbyAppInterface)
  {
    File localFile = BaseApplicationImpl.getContext().getFileStreamPath(paramNearbyAppInterface.getCurrentAccountUin() + "v5.3.nb");
    if (localFile.exists())
    {
      localFile.delete();
      NearbyUtils.a("Q.nearby", "clearNearbyCache", new Object[0]);
    }
    NearbySPUtil.a(paramNearbyAppInterface.getAccount(), "history_valid", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MineFragment
 * JD-Core Version:    0.7.0.1
 */