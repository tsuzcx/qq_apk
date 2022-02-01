package cooperation.ilive.lite.rommswitch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilive.EnterRoomConfig;
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
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery;
import com.tencent.mobileqq.vas.ipc.remote.LiveDelivery;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;>;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class LiveLiteRoomSwitchService
  implements RoomSwitchInterface
{
  public static LiveRoomList.GetFeedsListRsp a;
  private static List<SwitchRoomInfo> b = new ArrayList();
  private Context c;
  private RoomSwitchServiceAdapter d;
  private RoomSwitchInterface.QueryRoomListTrigger e;
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    while (i < b.size())
    {
      if (paramString.equals(String.valueOf(((SwitchRoomInfo)b.get(i)).roomId))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b.size())) {
      return ((SwitchRoomInfo)b.get(paramInt)).roomId;
    }
    return 0L;
  }
  
  private LiveRoomList.KV a(String paramString1, String paramString2)
  {
    LiveRoomList.KV localKV = new LiveRoomList.KV();
    localKV.key.set(paramString1);
    localKV.value.set(paramString2);
    return localKV;
  }
  
  public static void a()
  {
    QLog.i("LiveLiteRoomSwitchService", 1, "onDestroyRoom");
    Object localObject = a;
    if (localObject != null)
    {
      ((LiveRoomList.GetFeedsListRsp)localObject).clear();
      a = null;
    }
    localObject = b;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if ((localObject != null) && (((IQQLiveSDK)localObject).isInited())) {
      ((IQQLiveSDK)localObject).clearFetchRoomList();
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
  
  private static void a(LiveRoomList.GetFeedsListRsp.Feeds paramFeeds, SwitchRoomInfo paramSwitchRoomInfo, String paramString)
  {
    Object localObject = (ArrayList)paramFeeds.room.report_info.get();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LiveRoomList.KV localKV = (LiveRoomList.KV)((Iterator)localObject).next();
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
          if (localKV.key.get().equals("trace_info")) {
            paramSwitchRoomInfo.extData.putString(localKV.key.get(), b(localKV.value.get(), paramString));
          } else {
            paramSwitchRoomInfo.extData.putString(localKV.key.get(), localKV.value.get());
          }
        }
      }
    }
    if (paramFeeds.room.has())
    {
      paramFeeds = paramFeeds.room;
      if (paramFeeds.room_type.has()) {
        paramSwitchRoomInfo.extData.putInt("ext_enter_room_room_type", paramFeeds.room_type.get());
      }
      if (paramFeeds.game_id.has()) {
        paramSwitchRoomInfo.extData.putInt("ext_enter_room_game_id", paramFeeds.game_id.get());
      }
      if (paramFeeds.game_tag_id.has()) {
        paramSwitchRoomInfo.extData.putInt("ext_enter_room_game_tag_id", paramFeeds.game_tag_id.get());
      }
      if (paramFeeds.video_source.has()) {
        paramSwitchRoomInfo.extData.putLong("ext_enter_room_video_source_app_id", paramFeeds.video_source.get());
      }
      if (paramFeeds.cover_url.has()) {
        paramSwitchRoomInfo.extData.putString("ext_cover_url", paramFeeds.cover_url.get());
      }
      if (paramFeeds.title.has()) {
        paramSwitchRoomInfo.extData.putString("ext_title", paramFeeds.title.get());
      }
      if (paramFeeds.popularity.has()) {
        paramSwitchRoomInfo.extData.putLong("ext_popularity", paramFeeds.popularity.get());
      }
      if (paramFeeds.anchor_name.has()) {
        paramSwitchRoomInfo.extData.putString("ext_anchor_nick", paramFeeds.anchor_name.get());
      }
    }
  }
  
  private static void a(List<SwitchRoomInfo> paramList, List<LiveRoomList.GetFeedsListRsp.Feeds> paramList1, String paramString)
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
        a(localFeeds, localSwitchRoomInfo, paramString);
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
  
  public static int b()
  {
    return b.size();
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {
      if (!paramString.contains("session_id")) {
        return "";
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject = new JSONObject(Uri.decode(paramString));
      }
      if (!localJSONObject.has("session_id")) {
        break label74;
      }
      paramString = localJSONObject.getString("session_id");
      return paramString;
    }
    catch (Exception paramString)
    {
      label65:
      label74:
      break label65;
    }
    QLog.e("LiveLiteRoomSwitchService", 1, "");
    return "";
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.contains("session_id"))) {
      return paramString1;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject = new JSONObject(Uri.decode(paramString1));
      }
      localJSONObject.put("session_id", b(paramString2));
      paramString2 = localJSONObject.toString();
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label65:
      break label65;
    }
    QLog.e("LiveLiteRoomSwitchService", 1, "");
    paramString2 = paramString1;
    if (paramString1 == null) {
      paramString2 = "";
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getTraceInfoWithSessionId = ");
      paramString1.append(paramString2);
      QLog.i("LiveLiteRoomSwitchService", 2, paramString1.toString());
    }
    return paramString2;
  }
  
  private static ArrayList<SwitchRoomInfo> b(ArrayList<LiveRoomList.GetFeedsListRsp.Feeds> paramArrayList, List<SwitchRoomInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < paramList.size(); j = k)
    {
      localObject = ((SwitchRoomInfo)paramList.get(i)).extData;
      if (!((Bundle)localObject).getBoolean("read"))
      {
        k = j;
        if (((Bundle)localObject).getBoolean("is_preload"))
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
    i = localArrayList.size();
    Object localObject = "";
    paramList = (List<SwitchRoomInfo>)localObject;
    if (i > 0)
    {
      Bundle localBundle = ((SwitchRoomInfo)localArrayList.get(0)).extData;
      paramList = (List<SwitchRoomInfo>)localObject;
      if (localBundle != null) {
        paramList = localBundle.getString("trace_info", "");
      }
    }
    a(localArrayList, paramArrayList, paramList);
    paramArrayList = a;
    if ((paramArrayList != null) && (paramArrayList.feeds.get() != null)) {
      a(localArrayList, a.feeds.get(), paramList);
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
  
  private void d()
  {
    if (b == null) {
      QLog.e("LiveLiteRoomSwitchService", 1, "recodeFetchRoomList sRoomList is null");
    }
    Object localObject1 = new ArrayList(b);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      Object localObject2 = (SwitchRoomInfo)((List)localObject1).get(i);
      int j = ((SwitchRoomInfo)localObject2).extData.getInt("ext_enter_room_room_type", 0);
      int k = ((SwitchRoomInfo)localObject2).extData.getInt("ext_enter_room_game_id", 0);
      int m = ((SwitchRoomInfo)localObject2).extData.getInt("ext_enter_room_game_tag_id", 0);
      long l1 = ((SwitchRoomInfo)localObject2).extData.getLong("ext_enter_room_video_source_app_id", 0L);
      String str3 = ((SwitchRoomInfo)localObject2).extData.getString("ext_cover_url", "");
      String str4 = ((SwitchRoomInfo)localObject2).extData.getString("ext_title", "");
      long l2 = ((SwitchRoomInfo)localObject2).extData.getLong("ext_popularity", 0L);
      String str5 = ((SwitchRoomInfo)localObject2).extData.getString("ext_anchor_nick", "");
      String str1 = ((SwitchRoomInfo)localObject2).extData.getString("trace_info", "");
      String str2 = ((SwitchRoomInfo)localObject2).videoUrl;
      localObject2 = new QQLiveSwitchRoom(((SwitchRoomInfo)localObject2).roomId, ((SwitchRoomInfo)localObject2).videoUrl, ((SwitchRoomInfo)localObject2).videoId, j, k, m, l1, str3, str4, Long.valueOf(l2), str5);
      ((QQLiveSwitchRoom)localObject2).traceInfo = str1;
      ((QQLiveSwitchRoom)localObject2).rtmpUrl = str2;
      localArrayList.add(localObject2);
      i += 1;
    }
    localObject1 = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if ((localObject1 != null) && (((IQQLiveSDK)localObject1).isInited())) {
      ((IQQLiveSDK)localObject1).recordFetchRoomList(localArrayList);
    }
  }
  
  @NotNull
  private String e()
  {
    Object localObject1 = LiteLiveSDKFactory.a().b();
    if ((localObject1 != null) && (((BusinessConfig)localObject1).a.equals("1037"))) {
      localObject1 = (String)((BusinessConfig)localObject1).m.get("recom_info");
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  private static String f()
  {
    Object localObject1 = BusinessManager.a.c();
    if ((localObject1 != null) && (((EnterRoomConfig)localObject1).extData != null)) {
      localObject1 = ((EnterRoomConfig)localObject1).extData.getString("trace_info", "");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return localObject2;
  }
  
  public void a(RoomSwitchServiceAdapter paramRoomSwitchServiceAdapter)
  {
    this.d = paramRoomSwitchServiceAdapter;
  }
  
  public void clearEventOutput() {}
  
  public boolean closeRoomSwitch()
  {
    return false;
  }
  
  public RoomSwitchInterface.QueryRoomListTrigger getQueryRoomListTrigger()
  {
    return this.e;
  }
  
  public void onCreate(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public void onDestroy() {}
  
  public void queryRoomList(List<SwitchRoomInfo> paramList, int paramInt1, int paramInt2, RoomSwitchInterface.IRoomList paramIRoomList)
  {
    LiveRoomList.GetFeedsListReq localGetFeedsListReq = new LiveRoomList.GetFeedsListReq();
    localGetFeedsListReq.source_type.set(IliveLiteDataReport.g());
    localGetFeedsListReq.page_size.set(10);
    Object localObject = a;
    if (localObject != null)
    {
      if (((LiveRoomList.GetFeedsListRsp)localObject).penetrate_info.has())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" sCacheLastRsp livepageInfo :");
        ((StringBuilder)localObject).append(a.penetrate_info.get());
        QLog.d("LiveLiteRoomSwitchService", 1, ((StringBuilder)localObject).toString());
        localGetFeedsListReq.penetrate_info.set(a.penetrate_info.get());
      }
    }
    else
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(a("src_trace_info", f()));
      localGetFeedsListReq.penetrate_info.set((List)localObject);
    }
    localGetFeedsListReq.recom_info.set(e());
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
    this.e = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */