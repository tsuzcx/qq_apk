package com.tencent.mobileqq.location.util;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class LocationProtoUtil
{
  @NonNull
  public static qq_lbs_share.RoomKey a(AppRuntime paramAppRuntime, int paramInt, long paramLong)
  {
    qq_lbs_share.RoomKey localRoomKey = new qq_lbs_share.RoomKey();
    if (paramInt == 0)
    {
      localRoomKey.aio_type.set(2);
      localRoomKey.id1.set(Math.min(paramLong, paramAppRuntime.getLongAccountUin()));
      localRoomKey.id2.set(Math.max(paramLong, paramAppRuntime.getLongAccountUin()));
    }
    else if (paramInt == 1)
    {
      localRoomKey.aio_type.set(1);
      localRoomKey.id1.set(paramLong);
      localRoomKey.id2.set(0L);
    }
    localRoomKey.setHasFlag(true);
    return localRoomKey;
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return a(paramString);
    }
    if (paramInt == 1) {
      return b(paramString);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    ExtensionInfo localExtensionInfo = ((IFriendExtensionService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendExtensionService.class, "")).getExtensionInfo(paramString);
    boolean bool = false;
    if (localExtensionInfo == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isC2cSharingLocation: invoked. ", " isSharingLocation: ", Integer.valueOf(localExtensionInfo.isSharingLocation), " friendUin: ", paramString });
    }
    if (localExtensionInfo.isSharingLocation == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(qq_lbs_share.ResultInfo paramResultInfo)
  {
    boolean bool = false;
    if (paramResultInfo == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "rspSuccess: invoked. ", " resultInfo.uint32_result: ", Integer.valueOf(paramResultInfo.uint32_result.get()), " resultInfo.bytes_errmsg: ", paramResultInfo.bytes_errmsg.get().toStringUtf8(), " resultInfo.uint64_svr_time: ", Long.valueOf(paramResultInfo.uint64_svr_time.get()) });
    }
    if (paramResultInfo.uint32_result.get() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    paramString = ((ITroopInfoService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
    if (paramString == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isGroupSharingLocation: invoked. ", " ti: ", Boolean.valueOf(paramString.isSharingLocation()) });
    }
    return paramString.isSharingLocation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.util.LocationProtoUtil
 * JD-Core Version:    0.7.0.1
 */