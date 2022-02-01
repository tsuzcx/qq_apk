package com.tencent.mobileqq.shortvideo;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

public class AioShortVideoSendOperator
  extends BaseShortVideoUpOperator
{
  public AioShortVideoSendOperator() {}
  
  public AioShortVideoSendOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    long l = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.a, paramShortVideoForwardInfo.e, paramShortVideoForwardInfo.f, paramShortVideoForwardInfo.c);
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.p;
    Object localObject1 = paramShortVideoForwardInfo.a;
    Object localObject2 = "";
    if (localObject1 == null) {
      paramShortVideoForwardInfo.a = "";
    }
    localMessageForShortVideo.uuid = paramShortVideoForwardInfo.a;
    if (paramShortVideoForwardInfo.i == null) {
      paramShortVideoForwardInfo.i = "";
    }
    localMessageForShortVideo.md5 = paramShortVideoForwardInfo.i;
    localMessageForShortVideo.mLocalMd5 = paramShortVideoForwardInfo.j;
    localMessageForShortVideo.videoFileName = paramShortVideoForwardInfo.y;
    localMessageForShortVideo.videoFileFormat = paramShortVideoForwardInfo.z;
    localMessageForShortVideo.videoFileSize = paramShortVideoForwardInfo.t;
    localMessageForShortVideo.videoFileTime = paramShortVideoForwardInfo.u;
    localMessageForShortVideo.thumbWidth = paramShortVideoForwardInfo.r;
    localMessageForShortVideo.thumbHeight = paramShortVideoForwardInfo.s;
    localMessageForShortVideo.videoFileStatus = 999;
    int i = 0;
    localMessageForShortVideo.videoFileProgress = 0;
    if (paramShortVideoForwardInfo.c == 0) {
      localMessageForShortVideo.fileType = 6;
    } else if (paramShortVideoForwardInfo.c == 3000) {
      localMessageForShortVideo.fileType = 17;
    } else if (paramShortVideoForwardInfo.c == 1) {
      localMessageForShortVideo.fileType = 9;
    } else if (paramShortVideoForwardInfo.c == 10014) {
      localMessageForShortVideo.fileType = 67;
    }
    localMessageForShortVideo.thumbMD5 = paramShortVideoForwardInfo.k;
    if (paramShortVideoForwardInfo.x == null) {
      paramShortVideoForwardInfo.x = "";
    }
    localMessageForShortVideo.fileSource = paramShortVideoForwardInfo.x;
    localMessageForShortVideo.lastModified = 0L;
    localMessageForShortVideo.thumbFileSize = paramShortVideoForwardInfo.A;
    localMessageForShortVideo.busiType = paramShortVideoForwardInfo.o;
    localMessageForShortVideo.fromChatType = paramShortVideoForwardInfo.l;
    localMessageForShortVideo.toChatType = paramShortVideoForwardInfo.m;
    localMessageForShortVideo.uiOperatorFlag = 2;
    localMessageForShortVideo.supportProgressive = paramShortVideoForwardInfo.D;
    localMessageForShortVideo.fileWidth = paramShortVideoForwardInfo.E;
    localMessageForShortVideo.fileHeight = paramShortVideoForwardInfo.F;
    if (paramShortVideoForwardInfo.U != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForShortVideo.msgseq = paramShortVideoForwardInfo.U.a;
      localMessageForShortVideo.shmsgseq = paramShortVideoForwardInfo.U.b;
      localMessageForShortVideo.msgUid = paramShortVideoForwardInfo.U.c;
    }
    if (localMessageForShortVideo.busiType == 2) {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
    } else {
      localMessageForShortVideo.msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
    }
    if (paramShortVideoForwardInfo.H == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.H;
    }
    localMessageForShortVideo.hotVideoIconUrl = ((String)localObject1);
    if (paramShortVideoForwardInfo.J == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.J;
    }
    localMessageForShortVideo.hotVideoTitle = ((String)localObject1);
    if (paramShortVideoForwardInfo.K == null) {
      localObject1 = "";
    } else {
      localObject1 = paramShortVideoForwardInfo.K;
    }
    localMessageForShortVideo.hotVideoUrl = ((String)localObject1);
    if (paramShortVideoForwardInfo.I == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = paramShortVideoForwardInfo.I;
    }
    localMessageForShortVideo.hotVideoSubIconUrl = ((String)localObject1);
    localMessageForShortVideo.specialVideoType = paramShortVideoForwardInfo.L;
    localMessageForShortVideo.msgTailType = paramShortVideoForwardInfo.M;
    localMessageForShortVideo.redBagType = paramShortVideoForwardInfo.N;
    localMessageForShortVideo.shortVideoId = paramShortVideoForwardInfo.O;
    localMessageForShortVideo.isStoryVideo = paramShortVideoForwardInfo.Q;
    if (!TextUtils.isEmpty(paramShortVideoForwardInfo.S))
    {
      localMessageForShortVideo.templateId = paramShortVideoForwardInfo.S;
      localMessageForShortVideo.templateName = paramShortVideoForwardInfo.T;
    }
    localMessageForShortVideo.serial();
    paramShortVideoForwardInfo.g = localMessageForShortVideo.uniseq;
    paramShortVideoForwardInfo = this.e;
    localObject1 = this.d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("cost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoForwardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
    paramShortVideoForwardInfo = this.e;
    localObject1 = this.d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mr: ");
    ((StringBuilder)localObject2).append(localMessageForShortVideo.toString());
    Logger.a(paramShortVideoForwardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
    return localMessageForShortVideo;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramShortVideoUploadInfo.B;
    int i = 0;
    Object localObject1;
    if (bool)
    {
      localObject1 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_BlessPTV(this.a, paramShortVideoUploadInfo.e, paramShortVideoUploadInfo.f, paramShortVideoUploadInfo.c);
      ((MessageForShortVideo)localObject1).subBusiType = 1;
      ((MessageForShortVideo)localObject1).videoFileName = paramShortVideoUploadInfo.l;
    }
    else if (paramShortVideoUploadInfo.C)
    {
      localObject2 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.a, paramShortVideoUploadInfo.e, paramShortVideoUploadInfo.f, paramShortVideoUploadInfo.c);
      ((MessageForShortVideo)localObject2).subBusiType = 0;
      ((MessageForShortVideo)localObject2).hotVideoIconUrl = paramShortVideoUploadInfo.E;
      ((MessageForShortVideo)localObject2).hotVideoTitle = paramShortVideoUploadInfo.G;
      ((MessageForShortVideo)localObject2).hotVideoUrl = paramShortVideoUploadInfo.H;
      ((MessageForShortVideo)localObject2).hotVideoSubIconUrl = paramShortVideoUploadInfo.F;
      ((MessageForShortVideo)localObject2).videoFileName = paramShortVideoUploadInfo.I;
      ((MessageForShortVideo)localObject2).videoAttr = 0;
      ((MessageForShortVideo)localObject2).videoKandianType = 0;
      if (((MessageForShortVideo)localObject2).videoFileName != null)
      {
        localObject1 = localObject2;
        if (((MessageForShortVideo)localObject2).videoFileName.length() != 0) {}
      }
      else
      {
        localObject3 = new StringBuilder();
        if ((paramShortVideoUploadInfo.i != null) && (paramShortVideoUploadInfo.i.length() != 0)) {
          localObject1 = paramShortVideoUploadInfo.i;
        } else {
          localObject1 = "HotVideo";
        }
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(".mp4");
        ((MessageForShortVideo)localObject2).videoFileName = ((StringBuilder)localObject3).toString();
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = (MessageForShortVideo)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_ShortVideo(this.a, paramShortVideoUploadInfo.e, paramShortVideoUploadInfo.f, paramShortVideoUploadInfo.c);
      ((MessageForShortVideo)localObject1).subBusiType = 0;
      ((MessageForShortVideo)localObject1).videoFileName = paramShortVideoUploadInfo.l;
    }
    ((MessageForShortVideo)localObject1).specialVideoType = paramShortVideoUploadInfo.J;
    ((MessageForShortVideo)localObject1).msgTailType = paramShortVideoUploadInfo.L;
    ((MessageForShortVideo)localObject1).redBagType = paramShortVideoUploadInfo.N;
    ((MessageForShortVideo)localObject1).shortVideoId = paramShortVideoUploadInfo.O;
    if (paramShortVideoUploadInfo.a == null) {
      paramShortVideoUploadInfo.a = "";
    }
    ((MessageForShortVideo)localObject1).uuid = paramShortVideoUploadInfo.a;
    if (paramShortVideoUploadInfo.i == null) {
      paramShortVideoUploadInfo.i = "";
    }
    ((MessageForShortVideo)localObject1).md5 = paramShortVideoUploadInfo.i;
    ((MessageForShortVideo)localObject1).videoFileFormat = 2;
    ((MessageForShortVideo)localObject1).videoFileSize = paramShortVideoUploadInfo.q;
    ((MessageForShortVideo)localObject1).videoFileTime = paramShortVideoUploadInfo.r;
    ((MessageForShortVideo)localObject1).thumbWidth = paramShortVideoUploadInfo.o;
    ((MessageForShortVideo)localObject1).thumbHeight = paramShortVideoUploadInfo.p;
    ((MessageForShortVideo)localObject1).mThumbFilePath = paramShortVideoUploadInfo.n;
    ((MessageForShortVideo)localObject1).mVideoFileSourceDir = paramShortVideoUploadInfo.u;
    ((MessageForShortVideo)localObject1).videoFileStatus = 999;
    ((MessageForShortVideo)localObject1).videoFileProgress = 0;
    ((MessageForShortVideo)localObject1).extraflag = 32772;
    ((MessageForShortVideo)localObject1).thumbMD5 = paramShortVideoUploadInfo.k;
    if ((paramShortVideoUploadInfo.v == null) || (paramShortVideoUploadInfo.v.length() == 0)) {
      paramShortVideoUploadInfo.v = "camera";
    }
    ((MessageForShortVideo)localObject1).fileSource = paramShortVideoUploadInfo.v;
    ((MessageForShortVideo)localObject1).lastModified = 0L;
    ((MessageForShortVideo)localObject1).mediacodecEncode = paramShortVideoUploadInfo.A;
    if (((MessageForShortVideo)localObject1).istroop == 0) {
      ((MessageForShortVideo)localObject1).fileType = 6;
    } else if (((MessageForShortVideo)localObject1).istroop == 3000) {
      ((MessageForShortVideo)localObject1).fileType = 17;
    } else if (((MessageForShortVideo)localObject1).istroop == 1) {
      ((MessageForShortVideo)localObject1).fileType = 9;
    } else if (((MessageForShortVideo)localObject1).istroop == 10014) {
      ((MessageForShortVideo)localObject1).fileType = 9;
    }
    if (paramShortVideoUploadInfo.c == 1008) {
      ((MessageForShortVideo)localObject1).busiType = 1007;
    } else if (2 == paramShortVideoUploadInfo.b) {
      ((MessageForShortVideo)localObject1).busiType = 1;
    } else if (3 == paramShortVideoUploadInfo.b) {
      ((MessageForShortVideo)localObject1).busiType = 2;
    } else {
      ((MessageForShortVideo)localObject1).busiType = 0;
    }
    if (((MessageForShortVideo)localObject1).istroop == 10014)
    {
      if (((MessageForShortVideo)localObject1).busiType == 1) {
        ((MessageForShortVideo)localObject1).subBusiType = 4602;
      } else if (((MessageForShortVideo)localObject1).busiType == 0) {
        ((MessageForShortVideo)localObject1).subBusiType = 4601;
      }
      ((MessageForShortVideo)localObject1).busiType = 4601;
      ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR((MessageRecord)localObject1, ((IGPSService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildIdOf(((MessageForShortVideo)localObject1).frienduin));
    }
    if (paramShortVideoUploadInfo.c == 0) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo(this.a, (MessageRecord)localObject1, paramShortVideoUploadInfo.e);
    } else if (paramShortVideoUploadInfo.c == 1) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo(this.a, (MessageRecord)localObject1, paramShortVideoUploadInfo.e);
    }
    ((MessageForShortVideo)localObject1).fromChatType = -1;
    ((MessageForShortVideo)localObject1).toChatType = -1;
    ((MessageForShortVideo)localObject1).uiOperatorFlag = 1;
    ((MessageForShortVideo)localObject1).supportProgressive = paramShortVideoUploadInfo.x;
    ((MessageForShortVideo)localObject1).fileWidth = paramShortVideoUploadInfo.y;
    ((MessageForShortVideo)localObject1).fileHeight = paramShortVideoUploadInfo.z;
    ((MessageForShortVideo)localObject1).syncToStory = paramShortVideoUploadInfo.M;
    Object localObject3 = MessageConstants.n;
    if (((MessageForShortVideo)localObject1).syncToStory) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    ((MessageForShortVideo)localObject1).saveExtInfoToExtStr((String)localObject3, (String)localObject2);
    ((MessageForShortVideo)localObject1).sendRawVideo = paramShortVideoUploadInfo.P;
    if (paramShortVideoUploadInfo.P) {
      ((MessageForShortVideo)localObject1).saveExtInfoToExtStr(MessageConstants.C, "1");
    }
    if (paramShortVideoUploadInfo.T != null) {
      i = 1;
    }
    if (i != 0)
    {
      ((MessageForShortVideo)localObject1).msgseq = paramShortVideoUploadInfo.T.a;
      ((MessageForShortVideo)localObject1).shmsgseq = paramShortVideoUploadInfo.T.b;
      ((MessageForShortVideo)localObject1).msgUid = paramShortVideoUploadInfo.T.c;
    }
    if (((MessageForShortVideo)localObject1).busiType == 2) {
      ((MessageForShortVideo)localObject1).msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
    } else {
      ((MessageForShortVideo)localObject1).msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
    }
    if (!TextUtils.isEmpty(paramShortVideoUploadInfo.R))
    {
      ((MessageForShortVideo)localObject1).templateId = paramShortVideoUploadInfo.R;
      ((MessageForShortVideo)localObject1).templateName = paramShortVideoUploadInfo.S;
    }
    ((MessageForShortVideo)localObject1).serial();
    paramShortVideoUploadInfo.g = ((MessageForShortVideo)localObject1).uniseq;
    paramShortVideoUploadInfo = this.e;
    Object localObject2 = this.d;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("cost:");
    ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoUploadInfo, (String)localObject2, "packmsg", ((StringBuilder)localObject3).toString());
    paramShortVideoUploadInfo = this.e;
    localObject2 = this.d;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("mr: ");
    ((StringBuilder)localObject3).append(((MessageForShortVideo)localObject1).toLogString());
    ((StringBuilder)localObject3).append("-");
    ((StringBuilder)localObject3).append(((MessageForShortVideo)localObject1).toString());
    Logger.a(paramShortVideoUploadInfo, (String)localObject2, "packMsg", ((StringBuilder)localObject3).toString());
    return localObject1;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.e, this.d, "attachRichText2Msg", "");
    if ((this.f instanceof MessageForRichText)) {
      ((MessageForRichText)this.f).richText = paramRichText;
    }
    return this.f;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.e, this.d, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    boolean bool1 = paramObject instanceof Intent;
    Object localObject4 = "0";
    Object localObject6 = "";
    Object localObject16;
    Object localObject3;
    int m;
    long l1;
    int n;
    int k;
    Object localObject5;
    Object localObject7;
    Object localObject2;
    int i;
    int j;
    Object localObject1;
    Object localObject8;
    int i1;
    int i2;
    boolean bool3;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    Object localObject13;
    long l2;
    int i3;
    Object localObject14;
    int i4;
    boolean bool4;
    Object localObject15;
    boolean bool2;
    if (bool1)
    {
      localObject16 = (Intent)paramObject;
      localObject4 = ((Intent)localObject16).getStringExtra("uin");
      localObject3 = ((Intent)localObject16).getStringExtra("troop_uin");
      m = ((Intent)localObject16).getIntExtra("uintype", 1003);
      l1 = ((Intent)localObject16).getLongExtra("file_send_size", 0L);
      n = ((Intent)localObject16).getIntExtra("file_send_business_type", 0);
      k = ((Intent)localObject16).getIntExtra("file_send_duration", -1);
      localObject5 = ((Intent)localObject16).getStringExtra("file_send_path");
      localObject7 = ((Intent)localObject16).getStringExtra("thumbfile_send_path");
      localObject2 = ((Intent)localObject16).getStringExtra("file_shortvideo_md5");
      i = ((Intent)localObject16).getIntExtra("thumbfile_send_width", 0);
      j = ((Intent)localObject16).getIntExtra("thumbfile_send_height", 0);
      localObject1 = ((Intent)localObject16).getStringExtra("thumbfile_md5");
      localObject6 = ((Intent)localObject16).getStringExtra("file_source");
      localObject8 = ((Intent)localObject16).getStringExtra("file_video_source_dir");
      bool1 = ((Intent)localObject16).getBooleanExtra("support_progressive", false);
      i1 = ((Intent)localObject16).getIntExtra("file_width", 0);
      i2 = ((Intent)localObject16).getIntExtra("file_height", 0);
      bool3 = ((Intent)localObject16).getBooleanExtra("mediacodec_encode_enable", false);
      localObject9 = ((Intent)localObject16).getStringExtra("hot_video_icon");
      localObject10 = ((Intent)localObject16).getStringExtra("hot_video_title");
      localObject11 = ((Intent)localObject16).getStringExtra("hot_video_url");
      localObject12 = ((Intent)localObject16).getStringExtra("hot_video_icon_sub");
      localObject13 = ((Intent)localObject16).getStringExtra("file_uuid");
      l2 = ((Intent)localObject16).getLongExtra("file_thumb_Size", 0L);
      i3 = ((Intent)localObject16).getIntExtra("special_video_type", 0);
      localObject14 = ((Intent)localObject16).getStringExtra("hot_video_name");
      i4 = ((Intent)localObject16).getIntExtra("short_video_msg_tail_type", 0);
      bool4 = ((Intent)localObject16).getBooleanExtra("file_raw_size", false);
      localObject15 = ((Intent)localObject16).getStringExtra("widgetinfo");
      localObject16 = ((Intent)localObject16).getStringExtra("key_camera_material_name");
      bool2 = false;
    }
    else if ((paramObject instanceof MessageForShortVideo))
    {
      localObject9 = (MessageForShortVideo)paramObject;
      String str2 = ((MessageForShortVideo)localObject9).frienduin;
      String str3 = ((MessageForShortVideo)localObject9).frienduin;
      m = ((MessageForShortVideo)localObject9).istroop;
      l1 = ((MessageForShortVideo)localObject9).videoFileSize;
      n = paramShortVideoReq.b;
      k = ((MessageForShortVideo)localObject9).videoFileTime;
      localObject10 = ((MessageForShortVideo)localObject9).videoFileName;
      String str1 = SVUtils.a(((MessageForShortVideo)localObject9).thumbMD5, "jpg");
      localObject17 = ((MessageForShortVideo)localObject9).md5;
      i = ((MessageForShortVideo)localObject9).thumbWidth;
      j = ((MessageForShortVideo)localObject9).thumbHeight;
      String str4 = ((MessageForShortVideo)localObject9).thumbMD5;
      localObject7 = ((MessageForShortVideo)localObject9).fileSource;
      localObject8 = ((MessageForShortVideo)localObject9).mVideoFileSourceDir;
      bool1 = ((MessageForShortVideo)localObject9).supportProgressive;
      i1 = ((MessageForShortVideo)localObject9).fileWidth;
      i2 = ((MessageForShortVideo)localObject9).fileHeight;
      bool2 = ((MessageForShortVideo)localObject9).syncToStory;
      bool3 = ((MessageForShortVideo)localObject9).mediacodecEncode;
      if (((MessageForShortVideo)localObject9).checkIsHotVideo())
      {
        localObject6 = ((MessageForShortVideo)localObject9).hotVideoIconUrl;
        localObject5 = ((MessageForShortVideo)localObject9).hotVideoTitle;
        localObject4 = ((MessageForShortVideo)localObject9).hotVideoUrl;
        localObject3 = ((MessageForShortVideo)localObject9).hotVideoSubIconUrl;
        localObject2 = ((MessageForShortVideo)localObject9).videoFileName;
        localObject1 = ((MessageForShortVideo)localObject9).uuid;
      }
      else
      {
        localObject6 = "";
        localObject5 = localObject6;
        localObject4 = localObject5;
        localObject3 = localObject4;
        localObject2 = localObject3;
        localObject1 = null;
      }
      i3 = ((MessageForShortVideo)localObject9).specialVideoType;
      i4 = ((MessageForShortVideo)localObject9).msgTailType;
      bool4 = ((MessageForShortVideo)localObject9).sendRawVideo;
      localObject15 = ((MessageForShortVideo)localObject9).templateId;
      localObject16 = ((MessageForShortVideo)localObject9).templateName;
      localObject9 = localObject6;
      localObject6 = localObject10;
      localObject10 = localObject5;
      localObject11 = localObject4;
      localObject12 = localObject3;
      localObject14 = localObject2;
      localObject13 = localObject1;
      l2 = -1L;
      localObject1 = str4;
      localObject2 = localObject17;
      localObject3 = str3;
      localObject4 = str2;
      localObject5 = localObject6;
      localObject6 = localObject7;
      localObject7 = str1;
    }
    else
    {
      l1 = 0L;
      localObject3 = "0";
      localObject1 = "";
      localObject2 = localObject1;
      localObject5 = localObject2;
      localObject7 = localObject5;
      localObject8 = localObject7;
      localObject9 = localObject8;
      localObject10 = localObject9;
      localObject11 = localObject10;
      localObject12 = localObject11;
      localObject14 = localObject12;
      localObject15 = localObject14;
      localObject16 = localObject15;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      bool1 = false;
      i1 = 0;
      i2 = 0;
      bool2 = false;
      bool3 = false;
      localObject13 = null;
      l2 = -1L;
      i3 = 0;
      i4 = 0;
      bool4 = false;
    }
    Object localObject17 = new ShortVideoUploadInfo();
    ((ShortVideoUploadInfo)localObject17).e = ((String)localObject4);
    ((ShortVideoUploadInfo)localObject17).l = ((String)localObject5);
    ((ShortVideoUploadInfo)localObject17).n = ((String)localObject7);
    ((ShortVideoUploadInfo)localObject17).c = m;
    ((ShortVideoUploadInfo)localObject17).f = ((String)localObject3);
    ((ShortVideoUploadInfo)localObject17).q = ((int)l1);
    ((ShortVideoUploadInfo)localObject17).r = k;
    ((ShortVideoUploadInfo)localObject17).i = ((String)localObject2);
    ((ShortVideoUploadInfo)localObject17).o = i;
    ((ShortVideoUploadInfo)localObject17).p = j;
    ((ShortVideoUploadInfo)localObject17).t = paramShortVideoReq.a;
    ((ShortVideoUploadInfo)localObject17).s = paramObject;
    ((ShortVideoUploadInfo)localObject17).k = ((String)localObject1);
    ((ShortVideoUploadInfo)localObject17).v = ((String)localObject6);
    ((ShortVideoUploadInfo)localObject17).u = ((String)localObject8);
    ((ShortVideoUploadInfo)localObject17).b = n;
    ((ShortVideoUploadInfo)localObject17).x = bool1;
    ((ShortVideoUploadInfo)localObject17).y = i1;
    ((ShortVideoUploadInfo)localObject17).z = i2;
    ((ShortVideoUploadInfo)localObject17).M = bool2;
    ((ShortVideoUploadInfo)localObject17).A = bool3;
    ((ShortVideoUploadInfo)localObject17).E = ((String)localObject9);
    ((ShortVideoUploadInfo)localObject17).G = ((String)localObject10);
    ((ShortVideoUploadInfo)localObject17).H = ((String)localObject11);
    ((ShortVideoUploadInfo)localObject17).F = ((String)localObject12);
    ((ShortVideoUploadInfo)localObject17).a = ((String)localObject13);
    ((ShortVideoUploadInfo)localObject17).K = l2;
    ((ShortVideoUploadInfo)localObject17).J = i3;
    ((ShortVideoUploadInfo)localObject17).I = ((String)localObject14);
    ((ShortVideoUploadInfo)localObject17).L = i4;
    ((ShortVideoUploadInfo)localObject17).P = bool4;
    ((ShortVideoUploadInfo)localObject17).R = ((String)localObject15);
    ((ShortVideoUploadInfo)localObject17).S = ((String)localObject16);
    Logger.a(this.e, this.d, "createShortVideoUploadInfo", "");
    return localObject17;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Object localObject = this.e;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resut:");
    localStringBuilder.append(paramSendResult);
    Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
    if (paramSendResult != null)
    {
      localObject = (MessageForShortVideo)this.f;
      ((MessageForShortVideo)localObject).videoFileSize = ((int)paramSendResult.e);
      ((MessageForShortVideo)localObject).uuid = paramSendResult.f;
      ((MessageForShortVideo)localObject).md5 = paramSendResult.g;
      ((MessageForShortVideo)localObject).thumbFileSize = ((int)paramSendResult.i);
      ((MessageForShortVideo)localObject).videoAttr = paramSendResult.j;
      ((MessageForShortVideo)localObject).videoKandianType = paramSendResult.k;
      ((MessageForShortVideo)localObject).serial();
      paramSendResult = (IMessageFacade)this.a.getRuntimeService(IMessageFacade.class);
      if (paramSendResult != null) {
        paramSendResult.updateMsgContentByUniseq(this.f.frienduin, this.f.istroop, this.f.uniseq, ((MessageForShortVideo)localObject).msgData);
      }
    }
  }
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.b = paramShortVideoReq;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public ShortVideoForwardInfo b(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.b("AioShortVideoOperator", this.d, "createShortVideoForwardInfo", "input == null");
      return null;
    }
    if (paramShortVideoReq == null)
    {
      Logger.b("AioShortVideoOperator", this.d, "createShortVideoForwardInfo", "ShortVideoReq == null");
      return null;
    }
    boolean bool5 = paramObject instanceof Intent;
    String str4 = "";
    Object localObject7;
    String str2;
    String str3;
    int i4;
    Object localObject14;
    int i2;
    Object localObject5;
    int n;
    int i1;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject8;
    int i3;
    String str1;
    Object localObject12;
    Object localObject13;
    int i5;
    int i6;
    int i7;
    int i8;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    int i9;
    int i10;
    long l;
    boolean bool2;
    boolean bool1;
    Object localObject6;
    boolean bool3;
    int i;
    if (bool5)
    {
      localObject7 = (Intent)paramObject;
      str2 = ((Intent)localObject7).getStringExtra("uin");
      str3 = ((Intent)localObject7).getStringExtra("troop_uin");
      i4 = ((Intent)localObject7).getIntExtra("uintype", -1);
      localObject14 = ((Intent)localObject7).getStringExtra("from_uin");
      i2 = ((Intent)localObject7).getIntExtra("from_uin_type", -1);
      localObject5 = ((Intent)localObject7).getStringExtra("from_session_uin");
      ((Intent)localObject7).getIntExtra("from_busi_type", -1);
      n = ((Intent)localObject7).getIntExtra("file_send_size", 0);
      i1 = ((Intent)localObject7).getIntExtra("file_send_duration", -1);
      localObject9 = ((Intent)localObject7).getStringExtra("file_send_path");
      localObject10 = ((Intent)localObject7).getStringExtra("thumbfile_send_path");
      localObject11 = ((Intent)localObject7).getStringExtra("file_shortvideo_md5");
      localObject8 = ((Intent)localObject7).getStringExtra("file_shortvideo_local_md5");
      i3 = ((Intent)localObject7).getIntExtra("thumbfile_send_width", 0);
      m = ((Intent)localObject7).getIntExtra("thumbfile_send_height", 0);
      str1 = ((Intent)localObject7).getStringExtra("thumbfile_md5");
      str4 = ((Intent)localObject7).getStringExtra("file_source");
      localObject12 = ((Intent)localObject7).getStringExtra("file_uuid");
      localObject13 = ((Intent)localObject7).getStringExtra("file_name");
      i5 = ((Intent)localObject7).getIntExtra("file_format", 2);
      i6 = ((Intent)localObject7).getIntExtra("file_thumb_Size", 0);
      boolean bool4 = ((Intent)localObject7).getBooleanExtra("support_progressive", false);
      i7 = ((Intent)localObject7).getIntExtra("file_width", 0);
      i8 = ((Intent)localObject7).getIntExtra("file_height", 0);
      localObject4 = ((Intent)localObject7).getStringExtra("hot_video_icon");
      localObject3 = ((Intent)localObject7).getStringExtra("hot_video_title");
      localObject2 = ((Intent)localObject7).getStringExtra("hot_video_url");
      localObject1 = ((Intent)localObject7).getStringExtra("hot_video_icon_sub");
      i9 = ((Intent)localObject7).getIntExtra("special_video_type", 0);
      i10 = ((Intent)localObject7).getIntExtra("short_video_msg_tail_type", 0);
      l = ((Intent)localObject7).getLongExtra("from_msg_uniseq", 0L);
      bool2 = ((Intent)localObject7).getBooleanExtra("key_story_video_to_recent", false);
      if (((Intent)localObject7).getIntExtra("forward_source_business_type", -1) == 100200) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject6 = ((Intent)localObject7).getStringExtra("widgetinfo");
      localObject7 = ((Intent)localObject7).getStringExtra("key_camera_material_name");
      bool3 = bool1;
      j = 0;
      i = 0;
      k = 0;
      bool1 = bool4;
    }
    else if ((paramObject instanceof MessageForShortVideo))
    {
      localObject5 = (MessageForShortVideo)paramObject;
      str2 = ((MessageForShortVideo)localObject5).frienduin;
      str3 = ((MessageForShortVideo)localObject5).frienduin;
      i4 = ((MessageForShortVideo)localObject5).istroop;
      n = ((MessageForShortVideo)localObject5).videoFileSize;
      i1 = ((MessageForShortVideo)localObject5).videoFileTime;
      localObject9 = ((MessageForShortVideo)localObject5).videoFileName;
      localObject10 = SVUtils.a(((MessageForShortVideo)localObject5).thumbMD5, "jpg");
      localObject11 = ((MessageForShortVideo)localObject5).md5;
      localObject8 = ((MessageForShortVideo)localObject5).mLocalMd5;
      i3 = ((MessageForShortVideo)localObject5).thumbWidth;
      m = ((MessageForShortVideo)localObject5).thumbHeight;
      str1 = ((MessageForShortVideo)localObject5).thumbMD5;
      str4 = ((MessageForShortVideo)localObject5).fileSource;
      localObject12 = ((MessageForShortVideo)localObject5).uuid;
      i5 = ((MessageForShortVideo)localObject5).videoFileFormat;
      i6 = ((MessageForShortVideo)localObject5).thumbFileSize;
      j = ((MessageForShortVideo)localObject5).fromChatType;
      k = ((MessageForShortVideo)localObject5).toChatType;
      i = ((MessageForShortVideo)localObject5).busiType;
      localObject14 = SVUtils.a((MessageForShortVideo)localObject5);
      bool1 = ((MessageForShortVideo)localObject5).supportProgressive;
      i7 = ((MessageForShortVideo)localObject5).fileWidth;
      i8 = ((MessageForShortVideo)localObject5).fileHeight;
      i9 = ((MessageForShortVideo)localObject5).specialVideoType;
      i10 = ((MessageForShortVideo)localObject5).msgTailType;
      l = ((MessageForShortVideo)localObject5).uniseq;
      bool2 = ((MessageForShortVideo)localObject5).isStoryVideo;
      if (((MessageForShortVideo)localObject5).checkIsHotVideo())
      {
        localObject2 = ((MessageForShortVideo)localObject5).hotVideoIconUrl;
        localObject4 = ((MessageForShortVideo)localObject5).hotVideoTitle;
        localObject3 = ((MessageForShortVideo)localObject5).hotVideoUrl;
        localObject1 = ((MessageForShortVideo)localObject5).hotVideoSubIconUrl;
      }
      else
      {
        localObject2 = "";
        localObject4 = localObject2;
        localObject3 = localObject4;
        localObject1 = localObject3;
      }
      localObject6 = ((MessageForShortVideo)localObject5).templateId;
      String str5 = ((MessageForShortVideo)localObject5).templateName;
      localObject13 = localObject9;
      localObject7 = localObject4;
      localObject15 = localObject3;
      bool3 = false;
      i2 = -1;
      localObject5 = "0";
      localObject4 = localObject2;
      localObject3 = localObject7;
      localObject2 = localObject15;
      localObject7 = str5;
    }
    else
    {
      l = 0L;
      str2 = "0";
      str3 = str2;
      localObject5 = str3;
      localObject14 = localObject5;
      str1 = "";
      localObject8 = str1;
      localObject9 = localObject8;
      localObject10 = localObject9;
      localObject11 = localObject10;
      localObject4 = localObject11;
      localObject3 = localObject4;
      localObject2 = localObject3;
      localObject1 = localObject2;
      localObject12 = localObject1;
      localObject13 = localObject12;
      localObject6 = localObject13;
      localObject7 = localObject6;
      m = 0;
      n = 0;
      i1 = 0;
      i3 = 0;
      i4 = 0;
      j = 0;
      i = 0;
      i5 = 2;
      i6 = 0;
      bool1 = false;
      i7 = 0;
      i8 = 0;
      bool2 = false;
      i9 = 0;
      i10 = 0;
      bool3 = false;
      i2 = -1;
      k = 0;
    }
    if (TextUtils.isEmpty((CharSequence)localObject11))
    {
      Logger.b(paramShortVideoReq.d, paramShortVideoReq.c, "createShortVideoForwardInfo", "md5 shouldn't be empty ");
      return null;
    }
    Object localObject15 = new ShortVideoForwardInfo();
    ((ShortVideoForwardInfo)localObject15).e = str2;
    ((ShortVideoForwardInfo)localObject15).p = ((String)localObject9);
    ((ShortVideoForwardInfo)localObject15).q = ((String)localObject10);
    ((ShortVideoForwardInfo)localObject15).c = i4;
    ((ShortVideoForwardInfo)localObject15).f = str3;
    ((ShortVideoForwardInfo)localObject15).t = n;
    ((ShortVideoForwardInfo)localObject15).u = i1;
    ((ShortVideoForwardInfo)localObject15).i = ((String)localObject11);
    ((ShortVideoForwardInfo)localObject15).j = ((String)localObject8);
    ((ShortVideoForwardInfo)localObject15).r = i3;
    ((ShortVideoForwardInfo)localObject15).s = m;
    ((ShortVideoForwardInfo)localObject15).w = paramShortVideoReq.a;
    ((ShortVideoForwardInfo)localObject15).v = paramObject;
    ((ShortVideoForwardInfo)localObject15).k = str1;
    ((ShortVideoForwardInfo)localObject15).x = str4;
    ((ShortVideoForwardInfo)localObject15).a = ((String)localObject12);
    ((ShortVideoForwardInfo)localObject15).y = ((String)localObject13);
    ((ShortVideoForwardInfo)localObject15).z = i5;
    ((ShortVideoForwardInfo)localObject15).A = i6;
    ((ShortVideoForwardInfo)localObject15).D = bool1;
    ((ShortVideoForwardInfo)localObject15).E = i7;
    ((ShortVideoForwardInfo)localObject15).F = i8;
    ((ShortVideoForwardInfo)localObject15).B = ((String)localObject14);
    if (localObject5 == null) {
      localObject5 = "0";
    }
    ((ShortVideoForwardInfo)localObject15).C = ((String)localObject5);
    ((ShortVideoForwardInfo)localObject15).P = l;
    ((ShortVideoForwardInfo)localObject15).Q = bool2;
    if (localObject4 == null) {
      localObject4 = "";
    }
    ((ShortVideoForwardInfo)localObject15).H = ((String)localObject4);
    if (localObject3 == null) {
      localObject3 = "";
    }
    ((ShortVideoForwardInfo)localObject15).J = ((String)localObject3);
    if (localObject2 == null) {
      localObject2 = "";
    }
    ((ShortVideoForwardInfo)localObject15).K = ((String)localObject2);
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((ShortVideoForwardInfo)localObject15).I = ((String)localObject1);
    ((ShortVideoForwardInfo)localObject15).L = i9;
    ((ShortVideoForwardInfo)localObject15).M = i10;
    if (2 == paramShortVideoReq.b)
    {
      ((ShortVideoForwardInfo)localObject15).N = 0;
      ((ShortVideoForwardInfo)localObject15).O = "";
    }
    ((ShortVideoForwardInfo)localObject15).R = bool3;
    ((ShortVideoForwardInfo)localObject15).S = ((String)localObject6);
    ((ShortVideoForwardInfo)localObject15).T = ((String)localObject7);
    if (bool5) {
      k = a(i2);
    }
    for (int j = a(i4);; j = m)
    {
      m = j;
      break label1341;
      if ((!(paramObject instanceof MessageForShortVideo)) || (k != -1)) {
        break;
      }
      m = a(i4);
      k = j;
    }
    int m = k;
    int k = j;
    label1341:
    if (i2 == 1008)
    {
      n = 1007;
      j = i;
      i = n;
    }
    else
    {
      n = paramShortVideoReq.b;
      j = 2;
      if (2 == n)
      {
        i = 1;
        j = 1;
      }
      else if (3 == paramShortVideoReq.b)
      {
        i = 2;
      }
      else if (5 == paramShortVideoReq.b)
      {
        j = i;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
    ((ShortVideoForwardInfo)localObject15).l = k;
    ((ShortVideoForwardInfo)localObject15).m = m;
    ((ShortVideoForwardInfo)localObject15).n = i;
    ((ShortVideoForwardInfo)localObject15).o = j;
    paramObject = paramShortVideoReq.d;
    paramShortVideoReq = paramShortVideoReq.c;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(((ShortVideoForwardInfo)localObject15).a());
    Logger.a(paramObject, paramShortVideoReq, "createShortVideoForwardInfo", ((StringBuilder)localObject1).toString());
    return localObject15;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.AioShortVideoSendOperator
 * JD-Core Version:    0.7.0.1
 */