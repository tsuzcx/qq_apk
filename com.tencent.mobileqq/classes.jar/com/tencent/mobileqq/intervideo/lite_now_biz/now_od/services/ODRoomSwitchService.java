package com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services;

import android.content.Context;
import android.os.Bundle;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.ilivesdk.service.RoomSwitchServiceAdapter;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.odroom.ODRoomSwitchProto.RcmdRoomSwitchReq;
import com.tencent.odroom.ODRoomSwitchProto.RcmdRoomSwitchRsp;
import com.tencent.odroom.ODRoomSwitchProto.SwitchRoomInfo;
import java.util.ArrayList;
import java.util.List;

public class ODRoomSwitchService
  implements RoomSwitchInterface
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RoomSwitchInterface.IRoomList jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$IRoomList;
  private RoomSwitchInterface.QueryRoomListTrigger jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger;
  private RoomSwitchServiceAdapter jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter;
  private ODRoomSwitchService.IGetNeighborRoomListener jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_odServicesODRoomSwitchService$IGetNeighborRoomListener = new ODRoomSwitchService.2(this);
  private List<SwitchRoomInfo> jdField_a_of_type_JavaUtilList;
  
  private List<SwitchRoomInfo> a(ODRoomSwitchProto.RcmdRoomSwitchRsp paramRcmdRoomSwitchRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramRcmdRoomSwitchRsp.front_list.get();
    paramRcmdRoomSwitchRsp = paramRcmdRoomSwitchRsp.after_list.get();
    int i = 0;
    while (i < paramRcmdRoomSwitchRsp.size())
    {
      SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
      localSwitchRoomInfo.roomId = ((ODRoomSwitchProto.SwitchRoomInfo)paramRcmdRoomSwitchRsp.get(i)).roomid.get();
      localSwitchRoomInfo.videoType = VideoType.LIVE;
      localSwitchRoomInfo.extData = new Bundle();
      localSwitchRoomInfo.extData.putInt("content_type", 1);
      localArrayList.add(localSwitchRoomInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  private List<SwitchRoomInfo> a(List<SwitchRoomInfo> paramList1, List<SwitchRoomInfo> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList1);
    int i = 0;
    while (i < paramList2.size())
    {
      SwitchRoomInfo localSwitchRoomInfo = (SwitchRoomInfo)paramList2.get(i);
      int j;
      if ((paramList1.size() > 0) && (((SwitchRoomInfo)paramList1.get(0)).roomId == localSwitchRoomInfo.roomId)) {
        j = 1;
      } else {
        j = 0;
      }
      if (j == 0) {
        localArrayList.add(localSwitchRoomInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(int paramInt, ODRoomSwitchService.IGetNeighborRoomListener paramIGetNeighborRoomListener)
  {
    ODRoomSwitchProto.RcmdRoomSwitchReq localRcmdRoomSwitchReq = new ODRoomSwitchProto.RcmdRoomSwitchReq();
    localRcmdRoomSwitchReq.curr_roomid.set(paramInt);
    localRcmdRoomSwitchReq.gender.set(1);
    localRcmdRoomSwitchReq.source.set(10015);
    localRcmdRoomSwitchReq.latitude.set(0.0F);
    localRcmdRoomSwitchReq.longitude.set(0.0F);
    this.jdField_a_of_type_ComTencentIlivesdkServiceRoomSwitchServiceAdapter.getChannel().send(21857, 1, localRcmdRoomSwitchReq.toByteArray(), new ODRoomSwitchService.1(this, paramIGetNeighborRoomListener));
  }
  
  private boolean a(List<SwitchRoomInfo> paramList, int paramInt)
  {
    paramList.size();
    return false;
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
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$IRoomList = paramIRoomList;
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (!a(paramList, paramInt2)) {
      return;
    }
    BusinessManager.a.a();
    a((int)((SwitchRoomInfo)paramList.get(paramInt2)).roomId, this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_odServicesODRoomSwitchService$IGetNeighborRoomListener);
  }
  
  public void setQueryRoomListTrigger(RoomSwitchInterface.QueryRoomListTrigger paramQueryRoomListTrigger)
  {
    this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$QueryRoomListTrigger = paramQueryRoomListTrigger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODRoomSwitchService
 * JD-Core Version:    0.7.0.1
 */