package com.tencent.mobileqq.qqlive.api.impl.game;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.game.IQQLiveGameListService;
import com.tencent.mobileqq.qqlive.callback.game.IQQLiveGameListCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.GameItem;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.GetGamePanelReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.GetGamePanelRsp;
import java.util.ArrayList;

public class QQLiveGameListServiceImpl
  extends QQLiveBusinessObserver
  implements IQQLiveGameListService
{
  private static final int MSG_NOTIFY_TYPE_GET_GAME = 310;
  private static final String QQ_LIVE_GET_GAME_LIST_CMD = "trpc.qlive.qlive_room_play_svr.QliveRoomPlaySvr";
  private static final String QQ_LIVE_GET_GAME_LIST_METHOD = "GetGamePanel";
  private static final String TAG = "IQQLiveGameListService";
  private IQQLiveGameListCallback gameListCallback;
  private IQQLiveSDK sdk;
  
  private ArrayList<QQLiveAnchorRoomGameInfo> convertGameItem(GetGamePanelRsp paramGetGamePanelRsp)
  {
    ArrayList localArrayList = new ArrayList();
    paramGetGamePanelRsp = paramGetGamePanelRsp.c;
    int j = paramGetGamePanelRsp.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramGetGamePanelRsp[i];
      QQLiveAnchorRoomGameInfo localQQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
      localQQLiveAnchorRoomGameInfo.id = localObject.a;
      localQQLiveAnchorRoomGameInfo.name = localObject.b;
      localQQLiveAnchorRoomGameInfo.icon = localObject.c;
      localQQLiveAnchorRoomGameInfo.secondTagId = localObject.d;
      localArrayList.add(localQQLiveAnchorRoomGameInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean onGetGameListFail(QQLiveRspData paramQQLiveRspData)
  {
    if (this.gameListCallback == null)
    {
      QLog.e("IQQLiveGameListService", 4, "gameListCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        this.gameListCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    this.gameListCallback.a(-1, "the data is null");
    return true;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveGameListService", 4, "IQQLiveGameListService destroy");
    }
    this.gameListCallback = null;
  }
  
  public void getGameList(IQQLiveGameListCallback paramIQQLiveGameListCallback)
  {
    this.gameListCallback = paramIQQLiveGameListCallback;
    paramIQQLiveGameListCallback = this.sdk;
    if (paramIQQLiveGameListCallback == null)
    {
      QLog.e("IQQLiveGameListService", 4, "sdk is null");
      return;
    }
    paramIQQLiveGameListCallback = (IQQLiveSsoModule)paramIQQLiveGameListCallback.getExtModule("sso_module");
    if (paramIQQLiveGameListCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IQQLiveGameListService", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    paramIQQLiveGameListCallback.a("trpc.qlive.qlive_room_play_svr.QliveRoomPlaySvr", "GetGamePanel", GetGamePanelReq.toByteArray(new GetGamePanelReq()), 310, this);
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdk = paramIQQLiveSDK;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (paramInt != 310) {
        return;
      }
      if (onGetGameListFail(paramQQLiveRspData))
      {
        QLog.e("IQQLiveGameListService", 4, "onFollowAnchorFail fail");
        return;
      }
      try
      {
        paramQQLiveRspData = GetGamePanelRsp.a(paramQQLiveRspData.a());
        if (paramQQLiveRspData.a == 0)
        {
          paramQQLiveRspData = convertGameItem(paramQQLiveRspData);
          this.gameListCallback.a(paramQQLiveRspData);
          return;
        }
        this.gameListCallback.a(paramQQLiveRspData.a, paramQQLiveRspData.b);
        return;
      }
      catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
      {
        this.gameListCallback.a(-1, "parse GameItem error");
        paramQQLiveRspData.printStackTrace();
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveGameListService", 4, "IQQLiveGameListService reset");
    }
    this.gameListCallback = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.game.QQLiveGameListServiceImpl
 * JD-Core Version:    0.7.0.1
 */