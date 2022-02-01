package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.utils.MachineUtil;
import java.io.Serializable;

public class QQLiveAnchorRoomInfo
  implements Serializable
{
  public static final int GAME_ROOM = 2;
  public static final int NORMAL_ROOM = 1;
  public static final int UNKNOW_ROOM = 0;
  public String machieId = MachineUtil.a();
  public QQLiveAnchorDataMediaInfo mediaData = new QQLiveAnchorDataMediaInfo();
  public QQLiveAnchorDataRoomAttr roomAttr = new QQLiveAnchorDataRoomAttr();
  public QQLiveAnchorDataRoomInfo roomData = new QQLiveAnchorDataRoomInfo();
  public String source;
  public QQLiveAnchorDataPullInfo thirdPullInfo = new QQLiveAnchorDataPullInfo();
  public QQLiveAnchorDataPushInfo thirdPushInfo = new QQLiveAnchorDataPushInfo();
  public QQLiveAnchorDataTrtcInfo trtcData = new QQLiveAnchorDataTrtcInfo();
  public long uid;
  public QQLiveAnchorDataUserInfo userDta = new QQLiveAnchorDataUserInfo();
  
  public QQLiveAnchorRoomInfo() {}
  
  public QQLiveAnchorRoomInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    if (paramQQLiveAnchorRoomInfo == null) {
      return;
    }
    this.uid = paramQQLiveAnchorRoomInfo.uid;
    this.source = paramQQLiveAnchorRoomInfo.source;
    this.machieId = paramQQLiveAnchorRoomInfo.machieId;
    this.roomAttr = new QQLiveAnchorDataRoomAttr(paramQQLiveAnchorRoomInfo.roomAttr);
    this.roomData = new QQLiveAnchorDataRoomInfo(paramQQLiveAnchorRoomInfo.roomData);
    this.userDta = new QQLiveAnchorDataUserInfo(paramQQLiveAnchorRoomInfo.userDta);
    this.mediaData = new QQLiveAnchorDataMediaInfo(paramQQLiveAnchorRoomInfo.mediaData);
    this.trtcData = new QQLiveAnchorDataTrtcInfo(paramQQLiveAnchorRoomInfo.trtcData);
    this.thirdPushInfo = new QQLiveAnchorDataPushInfo(paramQQLiveAnchorRoomInfo.thirdPushInfo);
    this.thirdPullInfo = new QQLiveAnchorDataPullInfo(paramQQLiveAnchorRoomInfo.thirdPullInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo
 * JD-Core Version:    0.7.0.1
 */