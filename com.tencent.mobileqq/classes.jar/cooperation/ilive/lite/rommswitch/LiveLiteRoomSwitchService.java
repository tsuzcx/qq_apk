package cooperation.ilive.lite.rommswitch;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class LiveLiteRoomSwitchService
  implements RoomSwitchInterface
{
  public static CertifiedAccountRead.StGetFeedListRsp a;
  private static List<SwitchRoomInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Context jdField_a_of_type_AndroidContentContext;
  private RoomSwitchInterface.QueryRoomListTrigger jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  private RoomSwitchServiceAdapter jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter;
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilList.size();
  }
  
  public static int a(String paramString)
  {
    int j;
    if (TextUtils.isEmpty(paramString))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= jdField_a_of_type_JavaUtilList.size()) {
        break label59;
      }
      j = i;
      if (paramString.equals(String.valueOf(((SwitchRoomInfo)jdField_a_of_type_JavaUtilList.get(i)).roomId))) {
        break;
      }
      i += 1;
    }
    label59:
    return -1;
  }
  
  @NotNull
  private COMM.StCommonExt a()
  {
    Object localObject3 = LiteLiveSDKFactory.a().a();
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((BusinessConfig)localObject3).jdField_a_of_type_JavaLangString.equals("1037")) {
        localObject1 = (String)((BusinessConfig)localObject3).jdField_a_of_type_JavaUtilHashMap.get("recom_info");
      }
    }
    QLog.i("LiveLiteRoomSwitchService", 1, "Ilive getStCommonExt info = " + (String)localObject1);
    localObject2 = new COMM.StCommonExt();
    localObject3 = new ArrayList();
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("recom_info");
    PBStringField localPBStringField = localEntry.value;
    if (localObject1 != null) {}
    for (;;)
    {
      localPBStringField.set((String)localObject1);
      ((List)localObject3).add(localEntry);
      ((COMM.StCommonExt)localObject2).mapInfo.set((List)localObject3);
      return localObject2;
      localObject1 = "";
    }
  }
  
  private static String a(List<CertifiedAccountMeta.StLive.RoomIcon> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CertifiedAccountMeta.StLive.RoomIcon localRoomIcon = (CertifiedAccountMeta.StLive.RoomIcon)paramList.next();
      if ((localRoomIcon != null) && (!TextUtils.isEmpty(localRoomIcon.url.get()))) {
        return localRoomIcon.url.get();
      }
    }
    return "";
  }
  
  public static void a()
  {
    QLog.i("LiveLiteRoomSwitchService", 1, "onDestroyRoom");
    if (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp != null)
    {
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.clear();
      jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp = null;
    }
    if (jdField_a_of_type_JavaUtilList != null) {
      jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void a(CertifiedAccountRead.StGetFeedListReq paramStGetFeedListReq)
  {
    if ((paramStGetFeedListReq.extInfo != null) && (paramStGetFeedListReq.extInfo.mapInfo != null) && (paramStGetFeedListReq.extInfo.mapInfo.get() != null))
    {
      paramStGetFeedListReq = paramStGetFeedListReq.extInfo.mapInfo.get();
      if ((paramStGetFeedListReq != null) && (paramStGetFeedListReq.size() > 0))
      {
        paramStGetFeedListReq = (COMM.Entry)paramStGetFeedListReq.get(0);
        if ((paramStGetFeedListReq != null) && (paramStGetFeedListReq.key != null) && (paramStGetFeedListReq.value != null)) {
          QLog.d("LiveLiteRoomSwitchService", 1, " queryRoomList key :" + paramStGetFeedListReq.key.get() + " value = " + paramStGetFeedListReq.value.get());
        }
      }
    }
  }
  
  private static void a(List<SwitchRoomInfo> paramList, List<CertifiedAccountMeta.StFeed> paramList1)
  {
    paramList1 = paramList1.iterator();
    label135:
    label189:
    label192:
    for (;;)
    {
      SwitchRoomInfo localSwitchRoomInfo;
      if (paramList1.hasNext())
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramList1.next();
        if ((localStFeed == null) || (localStFeed.live == null)) {
          continue;
        }
        long l = localStFeed.live.roomId.get();
        localSwitchRoomInfo = new SwitchRoomInfo();
        localSwitchRoomInfo.logoUrl = a(localStFeed.live.roomIcon.get());
        localSwitchRoomInfo.videoUrl = localStFeed.live.rtmpURL.get();
        localSwitchRoomInfo.roomId = l;
        localSwitchRoomInfo.videoType = VideoType.LIVE;
        localSwitchRoomInfo.extData = new Bundle();
        localSwitchRoomInfo.extData.putInt("content_type", 1);
        i = 0;
        if (i >= paramList.size()) {
          break label189;
        }
        if (((SwitchRoomInfo)paramList.get(i)).roomId != l) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label192;
        }
        paramList.add(localSwitchRoomInfo);
        break;
        i += 1;
        break label135;
        return;
      }
    }
  }
  
  private static ArrayList<SwitchRoomInfo> b(ArrayList<CertifiedAccountMeta.StFeed> paramArrayList, List<SwitchRoomInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = 0;
    if (i < paramList.size())
    {
      Bundle localBundle = ((SwitchRoomInfo)paramList.get(i)).extData;
      int j;
      if (localBundle.getBoolean("read")) {
        j = i;
      }
      for (;;)
      {
        localArrayList.add(paramList.get(i));
        i += 1;
        k = j;
        break;
        j = k;
        if (localBundle.getBoolean("is_preload"))
        {
          j = k;
          if (paramInt != 0) {
            j = i;
          }
        }
      }
    }
    a(localArrayList, paramArrayList);
    if ((jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp != null) && (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.hotLive.get() != null)) {
      a(localArrayList, jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.hotLive.get());
    }
    if (paramInt == 0)
    {
      paramArrayList = null;
      if (k + 1 < localArrayList.size()) {
        paramArrayList = (SwitchRoomInfo)localArrayList.get(k + 1);
      }
      if (paramArrayList != null) {
        paramArrayList.extData.putBoolean("force_update", true);
      }
    }
    return localArrayList;
  }
  
  public void a(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter = paramRoomSwitchServiceAdapter;
  }
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    CertifiedAccountRead.StGetFeedListReq localStGetFeedListReq = new CertifiedAccountRead.StGetFeedListReq();
    localStGetFeedListReq.from.set(0);
    localStGetFeedListReq.source.set(3);
    if (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp != null)
    {
      if (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.livePageInfo.has())
      {
        QLog.d("LiveLiteRoomSwitchService", 1, " sCacheLastRsp livepageInfo :" + jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.livePageInfo.get());
        localStGetFeedListReq.livePageInfo.set(jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.livePageInfo.get());
      }
      if (jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.extInfo.has()) {
        localStGetFeedListReq.extInfo.set(jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetFeedListRsp.extInfo);
      }
    }
    for (;;)
    {
      a(localStGetFeedListReq);
      try
      {
        ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).requestPbVSBase("CertifiedAccountSvc.certified_account_read.GetFeedList", new String(localStGetFeedListReq.toByteArray(), "ISO8859_1"), null, -1, new LiveLiteRoomSwitchService.1(this, paramIRoomList, paramList, paramInt1));
        return;
      }
      catch (Exception paramList)
      {
        QLog.d("LiveLiteRoomSwitchService", 1, "queryRoomList Exception" + paramList);
      }
      localStGetFeedListReq.extInfo.set(a());
    }
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */