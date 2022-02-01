package cooperation.ilive.lite.rommswitch;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListReq;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListRsp;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.GetFeedsListRsp.Feeds;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.KV;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.Room;
import com.tencent.mobileqq.ilive.pb.LiveRoomList.Stream;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class LiveLiteRoomSwitchService
  implements RoomSwitchInterface
{
  public static LiveRoomList.GetFeedsListRsp a;
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
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilList.size())
    {
      if (paramString.equals(String.valueOf(((SwitchRoomInfo)jdField_a_of_type_JavaUtilList.get(i)).roomId))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_JavaUtilList.size())) {
      return ((SwitchRoomInfo)jdField_a_of_type_JavaUtilList.get(paramInt)).roomId;
    }
    return 0L;
  }
  
  @NotNull
  private String a()
  {
    Object localObject1 = LiteLiveSDKFactory.a().a();
    if ((localObject1 != null) && (((BusinessConfig)localObject1).jdField_a_of_type_JavaLangString.equals("1037"))) {
      localObject1 = (String)((BusinessConfig)localObject1).jdField_a_of_type_JavaUtilHashMap.get("recom_info");
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  public static void a()
  {
    QLog.i("LiveLiteRoomSwitchService", 1, "onDestroyRoom");
    Object localObject = jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp;
    if (localObject != null)
    {
      ((LiveRoomList.GetFeedsListRsp)localObject).clear();
      jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp = null;
    }
    localObject = jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  private void a(LiveRoomList.GetFeedsListReq paramGetFeedsListReq)
  {
    if (paramGetFeedsListReq == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" queryRoomList recomInfo :");
    localStringBuilder.append(paramGetFeedsListReq.recom_info.get());
    localStringBuilder.append(" fromId = ");
    localStringBuilder.append(paramGetFeedsListReq.source_type.get());
    QLog.d("LiveLiteRoomSwitchService", 1, localStringBuilder.toString());
  }
  
  private static void a(LiveRoomList.GetFeedsListRsp.Feeds paramFeeds, SwitchRoomInfo paramSwitchRoomInfo)
  {
    paramFeeds = (ArrayList)paramFeeds.room.report_info.get();
    if ((paramFeeds != null) && (paramFeeds.size() > 0))
    {
      paramFeeds = paramFeeds.iterator();
      while (paramFeeds.hasNext())
      {
        LiveRoomList.KV localKV = (LiveRoomList.KV)paramFeeds.next();
        if ((localKV.key.get() != null) && (localKV.value.get() != null))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("processFeedList extdata key = ");
            localStringBuilder.append(localKV.key.get());
            localStringBuilder.append(" value = ");
            localStringBuilder.append(localKV.value.get());
            QLog.i("LiveLiteRoomSwitchService", 2, localStringBuilder.toString());
          }
          paramSwitchRoomInfo.extData.putString(localKV.key.get(), localKV.value.get());
        }
      }
    }
  }
  
  private static void a(List<SwitchRoomInfo> paramList, List<LiveRoomList.GetFeedsListRsp.Feeds> paramList1)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      LiveRoomList.GetFeedsListRsp.Feeds localFeeds = (LiveRoomList.GetFeedsListRsp.Feeds)paramList1.next();
      if ((localFeeds != null) && (localFeeds.room != null) && (localFeeds.stream != null))
      {
        long l = localFeeds.room.room_id.get();
        SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
        localSwitchRoomInfo.logoUrl = localFeeds.room.cover_url.get();
        localSwitchRoomInfo.videoUrl = localFeeds.stream.rtmp.get();
        localSwitchRoomInfo.roomId = l;
        localSwitchRoomInfo.videoType = VideoType.LIVE;
        localSwitchRoomInfo.extData = new Bundle();
        localSwitchRoomInfo.extData.putInt("content_type", 1);
        a(localFeeds, localSwitchRoomInfo);
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramList.size()) {
            break;
          }
          if (((SwitchRoomInfo)paramList.get(i)).roomId == l)
          {
            j = 1;
            break;
          }
          i += 1;
        }
        if (j == 0) {
          paramList.add(localSwitchRoomInfo);
        }
      }
      else
      {
        QLog.e("LiveLiteRoomSwitchService", 1, "processFeedList feed / room / stream = null");
      }
    }
  }
  
  private static ArrayList<SwitchRoomInfo> b(ArrayList<LiveRoomList.GetFeedsListRsp.Feeds> paramArrayList, List<SwitchRoomInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      Bundle localBundle = ((SwitchRoomInfo)paramList.get(i)).extData;
      if (!localBundle.getBoolean("read"))
      {
        k = j;
        if (localBundle.getBoolean("is_preload"))
        {
          k = j;
          if (paramInt == 0) {}
        }
      }
      else
      {
        k = i;
      }
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    a(localArrayList, paramArrayList);
    paramArrayList = jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp;
    if ((paramArrayList != null) && (paramArrayList.feeds.get() != null)) {
      a(localArrayList, jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp.feeds.get());
    }
    if (paramInt == 0)
    {
      paramArrayList = null;
      paramInt = j + 1;
      if (paramInt < localArrayList.size()) {
        paramArrayList = (SwitchRoomInfo)localArrayList.get(paramInt);
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
    LiveRoomList.GetFeedsListReq localGetFeedsListReq = new LiveRoomList.GetFeedsListReq();
    localGetFeedsListReq.source_type.set(IliveLiteDataReport.a());
    localGetFeedsListReq.page_size.set(10);
    Object localObject = jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp;
    if ((localObject != null) && (((LiveRoomList.GetFeedsListRsp)localObject).penetrate_info.has()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" sCacheLastRsp livepageInfo :");
      ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp.penetrate_info.get());
      QLog.d("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject).toString());
      localGetFeedsListReq.penetrate_info.set(jdField_a_of_type_ComTencentMobileqqIlivePbLiveRoomList$GetFeedsListRsp.penetrate_info.get());
    }
    localGetFeedsListReq.recom_info.set(a());
    a(localGetFeedsListReq);
    try
    {
      ((ILiveDelivery)RemoteProxy.getProxy(LiveDelivery.class)).requestPbMsfSSO("QQLive.GetFeedsList", new String(localGetFeedsListReq.toByteArray(), "ISO8859_1"), null, -1, new LiveLiteRoomSwitchService.1(this, paramIRoomList, paramList, paramInt1));
      return;
    }
    catch (Exception paramList)
    {
      paramIRoomList = new StringBuilder();
      paramIRoomList.append("queryRoomList Exception");
      paramIRoomList.append(paramList);
      QLog.d("LiveLiteRoomSwitchService", 1, paramIRoomList.toString());
    }
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */