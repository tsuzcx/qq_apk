package com.tencent.mobileqq.qqlive.anchor.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAddress;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFrame;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRichTitleElement;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomRichTitle;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.pbexit_heart_list_room.nano.LeaveLiveRoomReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.EnterReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.EnterRsp;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.GameItem;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.LiveMediaInfo;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.MediaInfo;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.PrepareRsp;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.RichTitleElement;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.RoomInfo;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.RoomRichTitle;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.SetReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.ShutLiveReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.StreamInfo;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.Tlv;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.TrtcInfo;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.UserInfo;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.Address;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.Frame;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.GetLiveStreamsRsp;
import com.tencent.qqlive.protobuf.iliveStreamControl.nano.Stream;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.EndNewReq;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.Extinfo;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetRtmpPushUrlReq;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.GetRtmpPushUrlRsp;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.PushUrlParams;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.Resolution;
import com.tencent.qqlive.protobuf.mediaLogic4opensdk.nano.StartNewReq;
import java.util.ArrayList;

public class QQLiveAnchorSSOHelper
{
  private static final QQLiveAnchorRoomGameInfo a(GameItem paramGameItem)
  {
    QQLiveAnchorRoomGameInfo localQQLiveAnchorRoomGameInfo = new QQLiveAnchorRoomGameInfo();
    if (paramGameItem != null)
    {
      localQQLiveAnchorRoomGameInfo.id = paramGameItem.a;
      localQQLiveAnchorRoomGameInfo.icon = paramGameItem.c;
      localQQLiveAnchorRoomGameInfo.name = paramGameItem.b;
      localQQLiveAnchorRoomGameInfo.secondTagId = paramGameItem.d;
    }
    return localQQLiveAnchorRoomGameInfo;
  }
  
  private static final QQLiveAnchorDataAddress a(Address paramAddress)
  {
    QQLiveAnchorDataAddress localQQLiveAnchorDataAddress = new QQLiveAnchorDataAddress();
    if (paramAddress != null)
    {
      localQQLiveAnchorDataAddress.url = paramAddress.a;
      localQQLiveAnchorDataAddress.bitrate = paramAddress.b;
      localQQLiveAnchorDataAddress.format = paramAddress.c;
    }
    return localQQLiveAnchorDataAddress;
  }
  
  public static final QQLiveAnchorDataEnter a(EnterRsp paramEnterRsp)
  {
    QQLiveAnchorDataEnter localQQLiveAnchorDataEnter = new QQLiveAnchorDataEnter();
    boolean bool;
    if (paramEnterRsp.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQQLiveAnchorDataEnter.isSuccess = bool;
    if (!localQQLiveAnchorDataEnter.isSuccess)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6250;
      localQQLiveErrorMsg.bizErrMsg = "enter result error";
      localQQLiveErrorMsg.originErrCode = paramEnterRsp.a;
      localQQLiveErrorMsg.originErrMsg = paramEnterRsp.b;
      localQQLiveAnchorDataEnter.errorMsg = localQQLiveErrorMsg;
    }
    localQQLiveAnchorDataEnter.roomInfo = a(paramEnterRsp.c);
    localQQLiveAnchorDataEnter.userInfo = a(paramEnterRsp.d);
    localQQLiveAnchorDataEnter.mediaInfo = a(paramEnterRsp.e);
    localQQLiveAnchorDataEnter.trtcInfo = a(paramEnterRsp.f);
    return localQQLiveAnchorDataEnter;
  }
  
  private static final QQLiveAnchorDataFrame a(Frame paramFrame)
  {
    QQLiveAnchorDataFrame localQQLiveAnchorDataFrame = new QQLiveAnchorDataFrame();
    if (paramFrame != null)
    {
      localQQLiveAnchorDataFrame.level = paramFrame.a;
      localQQLiveAnchorDataFrame.definition = paramFrame.c;
      localQQLiveAnchorDataFrame.codecType = paramFrame.d;
      localQQLiveAnchorDataFrame.addresses = a(paramFrame.b);
    }
    return localQQLiveAnchorDataFrame;
  }
  
  private static final QQLiveAnchorDataMediaInfo a(MediaInfo paramMediaInfo)
  {
    QQLiveAnchorDataMediaInfo localQQLiveAnchorDataMediaInfo = new QQLiveAnchorDataMediaInfo();
    if (paramMediaInfo != null)
    {
      localQQLiveAnchorDataMediaInfo.sig = paramMediaInfo.a;
      localQQLiveAnchorDataMediaInfo.timeout = paramMediaInfo.b;
      localQQLiveAnchorDataMediaInfo.type = paramMediaInfo.c;
      localQQLiveAnchorDataMediaInfo.serverPat = paramMediaInfo.d;
      localQQLiveAnchorDataMediaInfo.streamParam = paramMediaInfo.e;
    }
    return localQQLiveAnchorDataMediaInfo;
  }
  
  public static final QQLiveAnchorDataPrepare a(PrepareRsp paramPrepareRsp)
  {
    QQLiveAnchorDataPrepare localQQLiveAnchorDataPrepare = new QQLiveAnchorDataPrepare();
    boolean bool;
    if (paramPrepareRsp.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQQLiveAnchorDataPrepare.isSuccess = bool;
    if (!localQQLiveAnchorDataPrepare.isSuccess)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6200;
      localQQLiveErrorMsg.bizErrMsg = "prepare result error";
      localQQLiveErrorMsg.originErrCode = paramPrepareRsp.a;
      localQQLiveErrorMsg.originErrMsg = paramPrepareRsp.b;
      localQQLiveAnchorDataPrepare.errorMsg = localQQLiveErrorMsg;
    }
    localQQLiveAnchorDataPrepare.roomInfo = a(paramPrepareRsp.c);
    localQQLiveAnchorDataPrepare.roomAttr = a(localQQLiveAnchorDataPrepare.roomInfo);
    localQQLiveAnchorDataPrepare.roomAttr.defaultRoomName = paramPrepareRsp.d;
    localQQLiveAnchorDataPrepare.roomAttr.posterNum = paramPrepareRsp.e;
    return localQQLiveAnchorDataPrepare;
  }
  
  public static final QQLiveAnchorDataPullInfo a(GetLiveStreamsRsp paramGetLiveStreamsRsp)
  {
    QQLiveAnchorDataPullInfo localQQLiveAnchorDataPullInfo = new QQLiveAnchorDataPullInfo();
    boolean bool;
    if (paramGetLiveStreamsRsp.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQQLiveAnchorDataPullInfo.isSuccess = bool;
    if (!localQQLiveAnchorDataPullInfo.isSuccess)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6231;
      localQQLiveErrorMsg.bizErrMsg = "pull url result error";
      localQQLiveErrorMsg.originErrCode = paramGetLiveStreamsRsp.a;
      localQQLiveErrorMsg.originErrMsg = paramGetLiveStreamsRsp.b;
      localQQLiveAnchorDataPullInfo.errorMsg = localQQLiveErrorMsg;
    }
    localQQLiveAnchorDataPullInfo.isSwitch = paramGetLiveStreamsRsp.d;
    localQQLiveAnchorDataPullInfo.liveStat = paramGetLiveStreamsRsp.f;
    localQQLiveAnchorDataPullInfo.sugLevel = paramGetLiveStreamsRsp.g;
    localQQLiveAnchorDataPullInfo.avType = paramGetLiveStreamsRsp.i;
    localQQLiveAnchorDataPullInfo.pixelsX = paramGetLiveStreamsRsp.j;
    localQQLiveAnchorDataPullInfo.pixelsY = paramGetLiveStreamsRsp.k;
    localQQLiveAnchorDataPullInfo.streams = a(paramGetLiveStreamsRsp.c);
    localQQLiveAnchorDataPullInfo.levelList = a(paramGetLiveStreamsRsp.e);
    return localQQLiveAnchorDataPullInfo;
  }
  
  public static final QQLiveAnchorDataPushInfo a(GetRtmpPushUrlRsp paramGetRtmpPushUrlRsp)
  {
    QQLiveAnchorDataPushInfo localQQLiveAnchorDataPushInfo = new QQLiveAnchorDataPushInfo();
    boolean bool;
    if (paramGetRtmpPushUrlRsp.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localQQLiveAnchorDataPushInfo.isSuccess = bool;
    if (!localQQLiveAnchorDataPushInfo.isSuccess)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6221;
      localQQLiveErrorMsg.bizErrMsg = "push url result error";
      localQQLiveErrorMsg.originErrCode = paramGetRtmpPushUrlRsp.a;
      localQQLiveAnchorDataPushInfo.errorMsg = localQQLiveErrorMsg;
    }
    localQQLiveAnchorDataPushInfo.rtmpUrl = paramGetRtmpPushUrlRsp.b;
    localQQLiveAnchorDataPushInfo.serverPart = paramGetRtmpPushUrlRsp.c;
    localQQLiveAnchorDataPushInfo.streamParam = paramGetRtmpPushUrlRsp.d;
    localQQLiveAnchorDataPushInfo.expireTs = paramGetRtmpPushUrlRsp.e;
    return localQQLiveAnchorDataPushInfo;
  }
  
  private static final QQLiveAnchorDataRichTitleElement a(RichTitleElement paramRichTitleElement)
  {
    QQLiveAnchorDataRichTitleElement localQQLiveAnchorDataRichTitleElement = new QQLiveAnchorDataRichTitleElement();
    if (paramRichTitleElement != null)
    {
      localQQLiveAnchorDataRichTitleElement.type = paramRichTitleElement.a;
      localQQLiveAnchorDataRichTitleElement.text = paramRichTitleElement.b;
      localQQLiveAnchorDataRichTitleElement.url = paramRichTitleElement.c;
    }
    return localQQLiveAnchorDataRichTitleElement;
  }
  
  public static final QQLiveAnchorDataRoomAttr a(QQLiveAnchorDataRoomInfo paramQQLiveAnchorDataRoomInfo)
  {
    QQLiveAnchorDataRoomAttr localQQLiveAnchorDataRoomAttr = new QQLiveAnchorDataRoomAttr();
    if (paramQQLiveAnchorDataRoomInfo != null)
    {
      localQQLiveAnchorDataRoomAttr.roomId = paramQQLiveAnchorDataRoomInfo.id;
      localQQLiveAnchorDataRoomAttr.roomName = paramQQLiveAnchorDataRoomInfo.name;
      localQQLiveAnchorDataRoomAttr.poster = paramQQLiveAnchorDataRoomInfo.poster;
      boolean bool;
      if (paramQQLiveAnchorDataRoomInfo.giftFlag == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localQQLiveAnchorDataRoomAttr.enableGif = bool;
      localQQLiveAnchorDataRoomAttr.poster3v4 = paramQQLiveAnchorDataRoomInfo.coverUrl3v4;
      localQQLiveAnchorDataRoomAttr.poster16v9 = paramQQLiveAnchorDataRoomInfo.coverUrl16v9;
      localQQLiveAnchorDataRoomAttr.tags = paramQQLiveAnchorDataRoomInfo.tags;
      localQQLiveAnchorDataRoomAttr.liveRoomType = paramQQLiveAnchorDataRoomInfo.liveRoomType;
      localQQLiveAnchorDataRoomAttr.gameInfo = paramQQLiveAnchorDataRoomInfo.gameInfo;
    }
    return localQQLiveAnchorDataRoomAttr;
  }
  
  private static final QQLiveAnchorDataRoomInfo a(RoomInfo paramRoomInfo)
  {
    QQLiveAnchorDataRoomInfo localQQLiveAnchorDataRoomInfo = new QQLiveAnchorDataRoomInfo();
    if (paramRoomInfo != null)
    {
      localQQLiveAnchorDataRoomInfo.id = paramRoomInfo.a;
      localQQLiveAnchorDataRoomInfo.name = paramRoomInfo.b;
      localQQLiveAnchorDataRoomInfo.poster = paramRoomInfo.c;
      localQQLiveAnchorDataRoomInfo.programId = paramRoomInfo.d;
      localQQLiveAnchorDataRoomInfo.giftFlag = paramRoomInfo.e;
      localQQLiveAnchorDataRoomInfo.coverUrl16v9 = paramRoomInfo.i;
      localQQLiveAnchorDataRoomInfo.coverUrl3v4 = paramRoomInfo.j;
      localQQLiveAnchorDataRoomInfo.roomPrepareNotify = paramRoomInfo.k;
      localQQLiveAnchorDataRoomInfo.roomGameType = paramRoomInfo.l;
      localQQLiveAnchorDataRoomInfo.systemNotice = paramRoomInfo.m;
      localQQLiveAnchorDataRoomInfo.continueLiveStatus = paramRoomInfo.n;
      localQQLiveAnchorDataRoomInfo.tags = a(paramRoomInfo.h);
      localQQLiveAnchorDataRoomInfo.liveRoomType = paramRoomInfo.o;
      localQQLiveAnchorDataRoomInfo.gameInfo = a(paramRoomInfo.p);
    }
    return localQQLiveAnchorDataRoomInfo;
  }
  
  private static final QQLiveAnchorDataRoomRichTitle a(RoomRichTitle paramRoomRichTitle)
  {
    QQLiveAnchorDataRoomRichTitle localQQLiveAnchorDataRoomRichTitle = new QQLiveAnchorDataRoomRichTitle();
    if ((paramRoomRichTitle != null) && (paramRoomRichTitle.a != null))
    {
      localQQLiveAnchorDataRoomRichTitle.elements = new ArrayList();
      paramRoomRichTitle = paramRoomRichTitle.a;
      int j = paramRoomRichTitle.length;
      int i = 0;
      while (i < j)
      {
        RichTitleElement localRichTitleElement = paramRoomRichTitle[i];
        localQQLiveAnchorDataRoomRichTitle.elements.add(a(localRichTitleElement));
        i += 1;
      }
    }
    return localQQLiveAnchorDataRoomRichTitle;
  }
  
  private static final QQLiveAnchorDataStream a(Stream paramStream)
  {
    QQLiveAnchorDataStream localQQLiveAnchorDataStream = new QQLiveAnchorDataStream();
    if (paramStream != null)
    {
      localQQLiveAnchorDataStream.name = paramStream.b;
      localQQLiveAnchorDataStream.rawLevel = paramStream.c;
      localQQLiveAnchorDataStream.frames = a(paramStream.a);
    }
    return localQQLiveAnchorDataStream;
  }
  
  private static final QQLiveAnchorDataStreamInfo a(StreamInfo paramStreamInfo)
  {
    QQLiveAnchorDataStreamInfo localQQLiveAnchorDataStreamInfo = new QQLiveAnchorDataStreamInfo();
    if (paramStreamInfo != null)
    {
      localQQLiveAnchorDataStreamInfo.uid = paramStreamInfo.a;
      localQQLiveAnchorDataStreamInfo.roomId = paramStreamInfo.b;
      localQQLiveAnchorDataStreamInfo.mainStreamId = paramStreamInfo.c;
      localQQLiveAnchorDataStreamInfo.auxStreamId = paramStreamInfo.d;
      localQQLiveAnchorDataStreamInfo.isSelfInfo = paramStreamInfo.e;
      localQQLiveAnchorDataStreamInfo.originUid = paramStreamInfo.f;
      localQQLiveAnchorDataStreamInfo.originRoomId = paramStreamInfo.g;
    }
    return localQQLiveAnchorDataStreamInfo;
  }
  
  private static final QQLiveAnchorDataTrtcInfo a(TrtcInfo paramTrtcInfo)
  {
    QQLiveAnchorDataTrtcInfo localQQLiveAnchorDataTrtcInfo = new QQLiveAnchorDataTrtcInfo();
    if (paramTrtcInfo != null)
    {
      localQQLiveAnchorDataTrtcInfo.sig = paramTrtcInfo.a;
      localQQLiveAnchorDataTrtcInfo.timeout = paramTrtcInfo.b;
      localQQLiveAnchorDataTrtcInfo.businessInfo = paramTrtcInfo.d;
      localQQLiveAnchorDataTrtcInfo.trtcStr = paramTrtcInfo.e;
      localQQLiveAnchorDataTrtcInfo.streamInfo = a(paramTrtcInfo.c);
    }
    return localQQLiveAnchorDataTrtcInfo;
  }
  
  private static final QQLiveAnchorDataUserInfo a(UserInfo paramUserInfo)
  {
    QQLiveAnchorDataUserInfo localQQLiveAnchorDataUserInfo = new QQLiveAnchorDataUserInfo();
    if (paramUserInfo != null)
    {
      localQQLiveAnchorDataUserInfo.id = paramUserInfo.a;
      localQQLiveAnchorDataUserInfo.explicitId = paramUserInfo.b;
      localQQLiveAnchorDataUserInfo.nickName = paramUserInfo.c;
      localQQLiveAnchorDataUserInfo.avatarUrl = paramUserInfo.d;
      localQQLiveAnchorDataUserInfo.initialClientType = paramUserInfo.e;
      localQQLiveAnchorDataUserInfo.businessUid = paramUserInfo.f;
      localQQLiveAnchorDataUserInfo.tinyId = paramUserInfo.g;
    }
    return localQQLiveAnchorDataUserInfo;
  }
  
  private static final GameItem a(QQLiveAnchorRoomGameInfo paramQQLiveAnchorRoomGameInfo)
  {
    GameItem localGameItem = new GameItem();
    if (paramQQLiveAnchorRoomGameInfo != null)
    {
      localGameItem.a = paramQQLiveAnchorRoomGameInfo.id;
      localGameItem.c = a(paramQQLiveAnchorRoomGameInfo.icon);
      localGameItem.b = a(paramQQLiveAnchorRoomGameInfo.name);
      localGameItem.d = paramQQLiveAnchorRoomGameInfo.secondTagId;
    }
    return localGameItem;
  }
  
  private static final RoomRichTitle a(QQLiveAnchorDataRoomRichTitle paramQQLiveAnchorDataRoomRichTitle)
  {
    RoomRichTitle localRoomRichTitle = new RoomRichTitle();
    int i = 0;
    if ((paramQQLiveAnchorDataRoomRichTitle != null) && (paramQQLiveAnchorDataRoomRichTitle.elements != null) && (paramQQLiveAnchorDataRoomRichTitle.elements.size() != 0))
    {
      RichTitleElement[] arrayOfRichTitleElement = new RichTitleElement[paramQQLiveAnchorDataRoomRichTitle.elements.size()];
      while (i < paramQQLiveAnchorDataRoomRichTitle.elements.size())
      {
        QQLiveAnchorDataRichTitleElement localQQLiveAnchorDataRichTitleElement = (QQLiveAnchorDataRichTitleElement)paramQQLiveAnchorDataRoomRichTitle.elements.get(i);
        RichTitleElement localRichTitleElement = new RichTitleElement();
        localRichTitleElement.a = localQQLiveAnchorDataRichTitleElement.type;
        localRichTitleElement.b = a(localQQLiveAnchorDataRichTitleElement.text);
        localRichTitleElement.c = a(localQQLiveAnchorDataRichTitleElement.url);
        arrayOfRichTitleElement[i] = localRichTitleElement;
        i += 1;
      }
      localRoomRichTitle.a = arrayOfRichTitleElement;
      return localRoomRichTitle;
    }
    localRoomRichTitle.a = new RichTitleElement[0];
    return localRoomRichTitle;
  }
  
  public static final SetReq a(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr)
  {
    SetReq localSetReq = new SetReq();
    if (paramQQLiveAnchorRoomInfo != null)
    {
      localSetReq.a = paramQQLiveAnchorRoomInfo.roomData.id;
      localSetReq.d = a(paramQQLiveAnchorRoomInfo.source);
      localSetReq.e = a(paramQQLiveAnchorRoomInfo.roomData.programId);
      localSetReq.f = a(paramQQLiveAnchorRoomInfo.machieId);
    }
    if (paramQQLiveAnchorDataRoomAttr != null)
    {
      localSetReq.c = a(paramQQLiveAnchorDataRoomAttr.tags);
      localSetReq.b = a(paramQQLiveAnchorDataRoomAttr);
      localSetReq.j = paramQQLiveAnchorDataRoomAttr.liveRoomType;
      localSetReq.k = a(paramQQLiveAnchorDataRoomAttr.gameInfo);
    }
    return localSetReq;
  }
  
  public static final ShutLiveReq a(long paramLong, String paramString)
  {
    ShutLiveReq localShutLiveReq = new ShutLiveReq();
    localShutLiveReq.a = a(paramString);
    localShutLiveReq.b = 0L;
    paramString = new LiveMediaInfo();
    paramString.a = 4;
    paramString.b = 3;
    paramString.d = 0;
    localShutLiveReq.c = paramString;
    return localShutLiveReq;
  }
  
  private static Tlv a()
  {
    Tlv localTlv = new Tlv();
    localTlv.c = "";
    return localTlv;
  }
  
  public static EndNewReq a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    EndNewReq localEndNewReq = new EndNewReq();
    localEndNewReq.a = paramLong;
    localEndNewReq.b = paramInt;
    localEndNewReq.c = 4;
    localEndNewReq.d = a(paramString1);
    localEndNewReq.e = 3;
    paramString1 = new Extinfo();
    paramString1.b = Build.MODEL;
    paramString1.c = "1.0.0";
    Resolution localResolution = new Resolution();
    localResolution.b = 1280;
    localResolution.a = 720;
    paramString1.d = localResolution;
    localEndNewReq.f = paramString1;
    localEndNewReq.h = 0;
    localEndNewReq.i = 0;
    localEndNewReq.j = 0;
    localEndNewReq.k = a(paramString2);
    return localEndNewReq;
  }
  
  public static final EndNewReq a(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, int paramInt)
  {
    return a(paramQQLiveAnchorRoomInfo.roomData.id, paramQQLiveAnchorRoomInfo.trtcData.sig, paramQQLiveAnchorRoomInfo.roomData.programId, paramInt);
  }
  
  public static final GetRtmpPushUrlReq a(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    GetRtmpPushUrlReq localGetRtmpPushUrlReq = new GetRtmpPushUrlReq();
    localGetRtmpPushUrlReq.a = a(paramQQLiveAnchorRoomInfo.source);
    localGetRtmpPushUrlReq.d = 1;
    localGetRtmpPushUrlReq.b = paramQQLiveAnchorRoomInfo.roomData.id;
    localGetRtmpPushUrlReq.c = new PushUrlParams();
    localGetRtmpPushUrlReq.c.b = a(paramQQLiveAnchorRoomInfo.roomData.programId);
    return localGetRtmpPushUrlReq;
  }
  
  public static final String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  private static final ArrayList<Integer> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static final ArrayList<QQLiveAnchorDataAddress> a(Address[] paramArrayOfAddress)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfAddress != null)
    {
      int j = paramArrayOfAddress.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramArrayOfAddress[i]));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static final ArrayList<QQLiveAnchorDataFrame> a(Frame[] paramArrayOfFrame)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFrame != null)
    {
      int j = paramArrayOfFrame.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramArrayOfFrame[i]));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static final ArrayList<QQLiveAnchorDataStream> a(Stream[] paramArrayOfStream)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfStream != null)
    {
      int j = paramArrayOfStream.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramArrayOfStream[i]));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static final void a(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (paramQQLiveRspData != null)
      {
        if (paramQQLiveRspData.d() == 0)
        {
          if (paramQQLiveRspData.c() == 0)
          {
            if (paramQQLiveRspData.a() != null) {
              return;
            }
            throw new QQLiveAnchorThrowable("data is null");
          }
          throw new QQLiveAnchorThrowable("biz error", paramQQLiveRspData.c(), paramQQLiveRspData.e());
        }
        throw new QQLiveAnchorThrowable("proxy error", paramQQLiveRspData.d(), paramQQLiveRspData.f());
      }
      throw new QQLiveAnchorThrowable("rsp is null");
    }
    throw new QQLiveAnchorThrowable("isSuccess is false");
  }
  
  public static final void a(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    if ((paramQQLiveAnchorDataRoomAttr != null) && (paramQQLiveAnchorRoomInfo != null))
    {
      if (paramQQLiveAnchorRoomInfo.roomData == null) {
        return;
      }
      paramQQLiveAnchorRoomInfo.roomData.name = paramQQLiveAnchorDataRoomAttr.roomName;
      paramQQLiveAnchorRoomInfo.roomData.giftFlag = (paramQQLiveAnchorDataRoomAttr.enableGif ^ true);
      paramQQLiveAnchorRoomInfo.roomData.poster = paramQQLiveAnchorDataRoomAttr.poster;
      paramQQLiveAnchorRoomInfo.roomData.coverUrl3v4 = paramQQLiveAnchorDataRoomAttr.poster3v4;
      paramQQLiveAnchorRoomInfo.roomData.coverUrl16v9 = paramQQLiveAnchorDataRoomAttr.poster16v9;
      paramQQLiveAnchorRoomInfo.roomData.liveRoomType = paramQQLiveAnchorDataRoomAttr.liveRoomType;
      paramQQLiveAnchorRoomInfo.roomData.gameInfo = new QQLiveAnchorRoomGameInfo(paramQQLiveAnchorDataRoomAttr.gameInfo);
      paramQQLiveAnchorRoomInfo.roomData.tags = new QQLiveAnchorDataRoomRichTitle(paramQQLiveAnchorDataRoomAttr.tags);
    }
  }
  
  private static final Tlv[] a(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr)
  {
    if (paramQQLiveAnchorDataRoomAttr == null) {
      return new Tlv[0];
    }
    ArrayList localArrayList = new ArrayList();
    Tlv localTlv = a();
    localTlv.a = 1;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.roomName);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 2;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.locationNG);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 3;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.locationAT);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 4;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.city);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 5;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.phoneModel);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 6;
    long l;
    if (paramQQLiveAnchorDataRoomAttr.enableGif) {
      l = 0L;
    } else {
      l = 1L;
    }
    localTlv.b = l;
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 7;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.poster);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 8;
    localTlv.b = paramQQLiveAnchorDataRoomAttr.posterTime;
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 11;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.poster3v4);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 12;
    localTlv.b = paramQQLiveAnchorDataRoomAttr.posterTime3v4;
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 9;
    localTlv.c = a(paramQQLiveAnchorDataRoomAttr.poster16v9);
    localArrayList.add(localTlv);
    localTlv = a();
    localTlv.a = 10;
    localTlv.b = paramQQLiveAnchorDataRoomAttr.posterTime16v9;
    localArrayList.add(localTlv);
    paramQQLiveAnchorDataRoomAttr = new Tlv[localArrayList.size()];
    localArrayList.toArray(paramQQLiveAnchorDataRoomAttr);
    return paramQQLiveAnchorDataRoomAttr;
  }
  
  public static final int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  public static final LeaveLiveRoomReq b(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    LeaveLiveRoomReq localLeaveLiveRoomReq = new LeaveLiveRoomReq();
    localLeaveLiveRoomReq.b = ((int)paramQQLiveAnchorRoomInfo.roomData.id);
    localLeaveLiveRoomReq.a = ((int)paramQQLiveAnchorRoomInfo.roomData.id);
    paramQQLiveAnchorRoomInfo = paramQQLiveAnchorRoomInfo.trtcData.sig;
    if (paramQQLiveAnchorRoomInfo != null) {
      localLeaveLiveRoomReq.c = paramQQLiveAnchorRoomInfo.getBytes();
    }
    return localLeaveLiveRoomReq;
  }
  
  public static final StartNewReq b(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, int paramInt)
  {
    StartNewReq localStartNewReq = new StartNewReq();
    localStartNewReq.a = paramQQLiveAnchorRoomInfo.roomData.id;
    localStartNewReq.b = paramInt;
    localStartNewReq.c = 4;
    localStartNewReq.d = a(paramQQLiveAnchorRoomInfo.trtcData.sig);
    localStartNewReq.e = 3;
    Extinfo localExtinfo = new Extinfo();
    localExtinfo.b = Build.MODEL;
    localExtinfo.c = "1.0.0";
    Resolution localResolution = new Resolution();
    localResolution.b = 1280;
    localResolution.a = 720;
    localExtinfo.d = localResolution;
    localStartNewReq.f = localExtinfo;
    localStartNewReq.h = 0;
    localStartNewReq.i = 0;
    localStartNewReq.j = 0;
    localStartNewReq.k = a(paramQQLiveAnchorRoomInfo.roomData.programId);
    return localStartNewReq;
  }
  
  public static final EnterReq c(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    EnterReq localEnterReq = new EnterReq();
    localEnterReq.a = paramQQLiveAnchorRoomInfo.roomData.id;
    localEnterReq.c = a(paramQQLiveAnchorRoomInfo.roomData.programId);
    localEnterReq.d = a(paramQQLiveAnchorRoomInfo.machieId);
    return localEnterReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper
 * JD-Core Version:    0.7.0.1
 */