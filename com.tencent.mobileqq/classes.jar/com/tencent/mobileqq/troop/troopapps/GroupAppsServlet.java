package com.tencent.mobileqq.troop.troopapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.observer.GroupAppsObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.GroupAppPb.AppInfo;
import tencent.im.oidb.GroupAppPb.AppList;
import tencent.im.oidb.GroupAppPb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GroupAppsServlet
  extends MSFServlet
{
  private AppRuntime a;
  
  @Nullable
  private GroupAppPb.RspBody a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return null;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      Object localObject2 = new byte[((ByteBuffer)localObject1).getInt() - 4];
      ((ByteBuffer)localObject1).get((byte[])localObject2);
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
        int i = paramFromServiceMsg.uint32_result.get();
        localObject1 = paramFromServiceMsg.str_error_msg.get();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(" oidbHeader: ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" errorMsg: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mergeFromPacket: invoked. ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i("GroupAppsServlet", 2, ((StringBuilder)localObject2).toString());
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        localObject1 = new GroupAppPb.RspBody();
        try
        {
          ((GroupAppPb.RspBody)localObject1).mergeFrom(paramFromServiceMsg);
          return localObject1;
        }
        catch (Exception paramFromServiceMsg)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GroupAppPb mergeFromPacket: invoked.  e: ");
          ((StringBuilder)localObject1).append(paramFromServiceMsg);
          QLog.i("GroupAppsServlet", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("oidb mergeFromPacket: invoked.  e: ");
        ((StringBuilder)localObject1).append(paramFromServiceMsg);
        QLog.i("GroupAppsServlet", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void a(long paramLong, GroupAppPb.RspBody paramRspBody)
  {
    Object localObject1 = (GroupAppPb.AppList)paramRspBody.red_point_list.get();
    HashSet localHashSet = new HashSet(20);
    localObject1 = ((GroupAppPb.AppList)localObject1).infos.get().iterator();
    while (((Iterator)localObject1).hasNext()) {
      localHashSet.add(Integer.valueOf(((GroupAppPb.AppInfo)((Iterator)localObject1).next()).appid.get()));
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("redDotAppId: ");
      ((StringBuilder)localObject1).append(Arrays.toString(localHashSet.toArray()));
      QLog.i("GroupAppsServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (GroupAppPb.AppList)paramRspBody.full_list.get();
    paramRspBody = ((GroupAppPb.AppList)localObject2).hash.get();
    localObject1 = new ArrayList(20);
    localObject2 = ((GroupAppPb.AppList)localObject2).infos.get().iterator();
    TroopAIOAppInfo localTroopAIOAppInfo;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (GroupAppPb.AppInfo)((Iterator)localObject2).next();
      localTroopAIOAppInfo = new TroopAIOAppInfo();
      localTroopAIOAppInfo.appid = ((GroupAppPb.AppInfo)localObject3).appid.get();
      localTroopAIOAppInfo.name = ((GroupAppPb.AppInfo)localObject3).name.get();
      localTroopAIOAppInfo.url = ((GroupAppPb.AppInfo)localObject3).url.get();
      localTroopAIOAppInfo.iconUrl = ((GroupAppPb.AppInfo)localObject3).icon.get();
      boolean bool;
      if (((GroupAppPb.AppInfo)localObject3).is_gray.get() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localTroopAIOAppInfo.isGray = bool;
      localTroopAIOAppInfo.simpleDayUrl = ((GroupAppPb.AppInfo)localObject3).icon_simple_day.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseAndStoreFullAppInfos  simpleDayUrl is null?");
      localStringBuilder.append(TextUtils.isEmpty(localTroopAIOAppInfo.simpleDayUrl));
      QLog.d("GroupAppsServlet", 1, localStringBuilder.toString());
      localTroopAIOAppInfo.simpleNightUrl = ((GroupAppPb.AppInfo)localObject3).icon_simple_night.get();
      localTroopAIOAppInfo.iconYouth = ((GroupAppPb.AppInfo)localObject3).icon_youth.get();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parseAndStoreFullAppInfos  simpleNightUrl is null?");
      ((StringBuilder)localObject3).append(TextUtils.isEmpty(localTroopAIOAppInfo.simpleNightUrl));
      QLog.d("GroupAppsServlet", 1, ((StringBuilder)localObject3).toString());
      ((ArrayList)localObject1).add(localTroopAIOAppInfo);
    }
    localObject2 = (ITroopAioAppService)this.a.getRuntimeService(ITroopAioAppService.class, "");
    ((ITroopAioAppService)localObject2).setFullAppListHash(paramRspBody);
    ((ITroopAioAppService)localObject2).saveFullAppListHashInSp();
    if (!GroupUtil.a((Collection)localObject1))
    {
      ((ITroopAioAppService)localObject2).setFullAppsListInfos((List)localObject1);
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("net fullAppInfos");
        paramRspBody.append(LogUtil.a(((ITroopAioAppService)localObject2).getFullAppsListInfos()));
        QLog.i("GroupAppsServlet", 2, paramRspBody.toString());
      }
    }
    else
    {
      paramRspBody = new ArrayList(((ITroopAioAppService)localObject2).getFullAppsListInfos());
      localObject1 = paramRspBody.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject1).next();
        if (localHashSet.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
          localTroopAIOAppInfo.redPoint = true;
        }
      }
      ((ITroopAioAppService)localObject2).setFullAppsListInfos(paramRspBody);
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("cache fullAppInfos");
        paramRspBody.append(LogUtil.a(((ITroopAioAppService)localObject2).getFullAppsListInfos()));
        QLog.i("GroupAppsServlet", 2, paramRspBody.toString());
      }
    }
    paramRspBody = new FullListGroupAppEntity();
    paramRspBody.troopAIOAppInfos = ((ITroopAioAppService)localObject2).getFullAppsListInfos();
    ((ITroopAioAppService)localObject2).fullListGroupAppsDbHelper().a(paramRspBody);
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean a(AppRuntime paramAppRuntime, long paramLong)
  {
    paramAppRuntime = (ITroopAioAppService)paramAppRuntime.getRuntimeService(ITroopAioAppService.class, "");
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)paramAppRuntime.getGrayAppInfoMap().get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return true;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramLong = paramAppRuntime.getRequestIntervalSecond(paramLong);
    return l - localGrayGroupAppEntity.updatedTimestamp > paramLong * 1000L;
  }
  
  private void b(long paramLong, GroupAppPb.RspBody paramRspBody)
  {
    Object localObject3 = (GroupAppPb.AppList)paramRspBody.group_gray_list.get();
    Object localObject2 = ((GroupAppPb.AppList)localObject3).hash.get();
    Object localObject1 = new ArrayList(20);
    localObject3 = ((GroupAppPb.AppList)localObject3).infos.get().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      GroupAppPb.AppInfo localAppInfo = (GroupAppPb.AppInfo)((Iterator)localObject3).next();
      TroopAIOAppInfo localTroopAIOAppInfo = new TroopAIOAppInfo();
      localTroopAIOAppInfo.appid = localAppInfo.appid.get();
      localTroopAIOAppInfo.hashVal = ((String)localObject2);
      ((ArrayList)localObject1).add(localTroopAIOAppInfo);
    }
    localObject2 = new GrayGroupAppEntity();
    ((GrayGroupAppEntity)localObject2).groupUin = paramLong;
    ((GrayGroupAppEntity)localObject2).troopAIOAppInfos = ((List)localObject1);
    ((GrayGroupAppEntity)localObject2).updatedTimestamp = NetConnInfoCenter.getServerTimeMillis();
    ((GrayGroupAppEntity)localObject2).requestIntervalSecond = paramRspBody.cache_interval.get();
    paramRspBody = (ITroopAioAppService)this.a.getRuntimeService(ITroopAioAppService.class, "");
    paramRspBody.getGrayAppInfoMap().put(Long.valueOf(paramLong), localObject2);
    paramRspBody.grayGroupAppsDbHelper().a((GrayGroupAppEntity)localObject2);
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("parseAndStoreGrayAppInfos of ");
      paramRspBody.append(paramLong);
      paramRspBody = paramRspBody.toString();
      localObject1 = LogUtil.a((Collection)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRspBody);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("GroupAppsServlet", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_GROUP_UIN", paramLong);
    paramAppRuntime.notifyObservers(GroupAppsObserver.class, 1, true, localBundle);
  }
  
  private static void c(AppRuntime paramAppRuntime, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_GROUP_UIN", paramLong);
    paramAppRuntime.notifyObservers(GroupAppsObserver.class, 1, false, localBundle);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = getAppRuntime();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive: invoked. ");
      localStringBuilder.append(paramFromServiceMsg);
      QLog.i("GroupAppsServlet", 2, localStringBuilder.toString());
    }
    int j = 0;
    long l = paramIntent.getLongExtra("KEY_GROUP_UIN", 0L);
    int i = j;
    if (paramFromServiceMsg != null) {
      if (!paramFromServiceMsg.isSuccess())
      {
        i = j;
      }
      else
      {
        paramIntent = a(paramFromServiceMsg);
        if (paramIntent == null)
        {
          i = j;
        }
        else
        {
          a(l, paramIntent);
          b(l, paramIntent);
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      b(this.a, l);
      return;
    }
    c(this.a, l);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("KEY_REQ_DATA");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3179);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = new byte[paramIntent.length + 4];
    PkgTools.dWord2Byte((byte[])localObject, 0, paramIntent.length + 4);
    PkgTools.copyData((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xc6b");
    paramPacket.putSendData((byte[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.GroupAppsServlet
 * JD-Core Version:    0.7.0.1
 */