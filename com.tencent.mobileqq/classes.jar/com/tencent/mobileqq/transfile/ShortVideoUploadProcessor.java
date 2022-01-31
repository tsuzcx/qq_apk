package com.tencent.mobileqq.transfile;

import airg;
import airh;
import airi;
import airn;
import airo;
import airp;
import airq;
import airr;
import airs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoUploadProcessor
  extends BaseUploadProcessor
{
  public static boolean a;
  private volatile int A = 0;
  private volatile int B = 0;
  private int C;
  private volatile int D;
  private int E;
  protected int a;
  public long a;
  private airs jdField_a_of_type_Airs;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new airn(this);
  public QQAppInterface a;
  protected ShortVideoTransManager a;
  protected ShortVideoUpInfo a;
  public Bdh_extinfo.PicInfo a;
  public RequestAck a;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public String a;
  public AtomicBoolean a;
  protected int b;
  protected long b;
  public RandomAccessFile b;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap b;
  public List b;
  public AtomicBoolean b;
  boolean jdField_b_of_type_Boolean = false;
  public byte[] b;
  public int c;
  public long c;
  public List c;
  public AtomicBoolean c;
  private byte[] c;
  public long d;
  private byte[] d;
  public long e;
  public BaseTransProcessor.StepInfo e;
  public long f;
  private long g;
  private volatile boolean h;
  private boolean q;
  int w = -1;
  int x = 0;
  public int y;
  private int z = 1;
  
  public ShortVideoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_g_of_type_Long = 480000L;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    jdField_a_of_type_Boolean = VideoUpConfigInfo.sIsPreSendSignal;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>is preSendAckToBDHServer :" + jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (this.w = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.w = 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
      {
        paramTransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
        paramTransferRequest = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == paramTransferRequest.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        b(9304, "path =" + paramTransFileController);
        d();
        this.o = true;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString = paramTransferRequest[0];
    this.jdField_a_of_type_JavaLangString = paramTransferRequest[1];
    this.jdField_c_of_type_Int = Integer.parseInt(paramTransferRequest[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.jdField_c_of_type_Int);
    }
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramTransferRequest[3]);
  }
  
  private RichProto.RichProtoReq.ShortVideoUpReq a()
  {
    int j = 1;
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localShortVideoUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    String str;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localShortVideoUpReq.jdField_d_of_type_JavaLangString = str;
        localShortVideoUpReq.k = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label462;
        }
        i = ((MessageForBlessPTV)localObject).uinList.size();
        label123:
        localShortVideoUpReq.jdField_l_of_type_Int = i;
        label129:
        localShortVideoUpReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
        localShortVideoUpReq.i = 0;
        if ((localShortVideoUpReq.jdField_f_of_type_Int != 0) && (1008 != localShortVideoUpReq.jdField_f_of_type_Int)) {
          break label547;
        }
        localShortVideoUpReq.jdField_b_of_type_JavaLangString = null;
        label172:
        if (localShortVideoUpReq.jdField_f_of_type_Int != 0) {
          break label562;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 0;
        label186:
        localShortVideoUpReq.jdField_b_of_type_Int = 2;
        localObject = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
        str = ((File)localObject).getName();
        localShortVideoUpReq.jdField_a_of_type_JavaLangString = str;
        localShortVideoUpReq.jdField_a_of_type_Long = ((File)localObject).length();
        localShortVideoUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localShortVideoUpReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        localShortVideoUpReq.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
        localShortVideoUpReq.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        localShortVideoUpReq.h = this.jdField_c_of_type_Int;
        localShortVideoUpReq.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        long l = localShortVideoUpReq.jdField_a_of_type_Long + this.jdField_a_of_type_Long;
        this.jdField_q_of_type_Long = l;
        ((FileMsg)localObject).jdField_a_of_type_Long = l;
        str = str.substring(str.lastIndexOf(".") + 1);
        if (!"avi".equals(str)) {
          break label609;
        }
        i = 2;
      }
    }
    for (;;)
    {
      label344:
      localShortVideoUpReq.jdField_g_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(i));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
      for (localShortVideoUpReq.jdField_j_of_type_Int = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; localShortVideoUpReq.jdField_j_of_type_Int = 0)
      {
        this.w = localShortVideoUpReq.jdField_j_of_type_Int;
        return localShortVideoUpReq;
        str = "0";
        break;
        label462:
        i = 1;
        break label123;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).CheckIsHotVideo()))
        {
          localShortVideoUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
          localShortVideoUpReq.k = 0;
          localShortVideoUpReq.jdField_l_of_type_Int = 1;
          break label129;
        }
        localShortVideoUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        localShortVideoUpReq.k = 0;
        localShortVideoUpReq.jdField_l_of_type_Int = 1;
        break label129;
        label547:
        localShortVideoUpReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
        break label172;
        label562:
        if (1 == localShortVideoUpReq.jdField_f_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 1;
          break label186;
        }
        if (3000 == localShortVideoUpReq.jdField_f_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 2;
          break label186;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 3;
        break label186;
        label609:
        if ("mp4".equals(str))
        {
          i = 3;
          break label344;
        }
        if ("wmv".equals(str))
        {
          i = 4;
          break label344;
        }
        if ("mkv".equals(str))
        {
          i = 5;
          break label344;
        }
        if ("rmvb".equals(str))
        {
          i = 6;
          break label344;
        }
        if ("rm".equals(str))
        {
          i = 7;
          break label344;
        }
        if ("afs".equals(str))
        {
          i = 8;
          break label344;
        }
        if ("mov".equals(str))
        {
          i = 9;
          break label344;
        }
        if ("mod".equals(str))
        {
          i = 10;
          break label344;
        }
        i = j;
        if ("ts".equals(str)) {
          break label344;
        }
        if (!"mts".equals(str)) {
          break label781;
        }
        i = 11;
        break label344;
      }
      label781:
      i = -1;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      im_msg_body.VideoFile localVideoFile;
      videoFile.ResvAttr localResvAttr;
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.jdField_f_of_type_JavaLangString != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) {
          break label913;
        }
        Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          localResvAttr = new videoFile.ResvAttr();
          localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
          if ((localObject1 == null) || (!((MessageForShortVideo)localObject1).CheckIsHotVideo())) {
            break label852;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "constructRichText MessageForHotVideo ");
          }
          localResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoIconUrl));
          localResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoTitle));
          localResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoUrl));
          localResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoSubIconUrl));
          localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
          if (this.jdField_g_of_type_JavaLangString != null)
          {
            localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
            if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() <= 0)) {
              break label816;
            }
            localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_c_of_type_JavaLangString)));
            if ((((MessageForShortVideo)localObject1).md5 == null) || (((MessageForShortVideo)localObject1).md5.length() == 0)) {
              ((MessageForShortVideo)localObject1).md5 = this.jdField_c_of_type_JavaLangString;
            }
            if ((this.jdField_a_of_type_Long == 0L) && (((MessageForShortVideo)localObject1).thumbFileSize != 0)) {
              this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject1).thumbFileSize;
            }
            if ((this.jdField_q_of_type_Long == 0L) && (((MessageForShortVideo)localObject1).videoFileSize != 0)) {
              this.jdField_q_of_type_Long = (((MessageForShortVideo)localObject1).videoFileSize + this.jdField_a_of_type_Long);
            }
            if ((this.jdField_a_of_type_Int == 0) && (((MessageForShortVideo)localObject1).thumbWidth != 0)) {
              this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject1).thumbWidth;
            }
            if ((this.jdField_b_of_type_Int == 0) && (((MessageForShortVideo)localObject1).thumbHeight != 0)) {
              this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject1).thumbHeight;
            }
            if ((((MessageForShortVideo)localObject1).videoFileName == null) || (((MessageForShortVideo)localObject1).videoFileName.length() == 0))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              if (this.jdField_c_of_type_JavaLangString != null) {
                break label844;
              }
              localObject3 = "HotVideo";
              ((MessageForShortVideo)localObject1).videoFileName = ((String)localObject3 + ".mp4");
            }
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.E);
          }
        }
        else
        {
          localVideoFile.uint32_file_format.set(2);
          localVideoFile.uint32_file_size.set((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
          localVideoFile.uint32_file_time.set(this.jdField_c_of_type_Int);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_from_chat_type.set(-1);
          localVideoFile.uint32_to_chat_type.set(-1);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8("你的QQ暂不支持查看视频短片，请期待后续版本。"));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
        if (((MessageForShortVideo)localObject1).uuid == null) {
          continue;
        }
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).uuid));
        continue;
        if (localException.md5 == null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label816:
      localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(localException.md5)));
      continue;
      label844:
      Object localObject3 = this.jdField_c_of_type_JavaLangString;
      continue;
      label852:
      if (localException.CheckIsDanceVideo()) {
        localResvAttr.uint32_special_video_type.set(localException.specialVideoType);
      }
      localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString));
      localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString)));
      continue;
      label913:
      Object localObject2 = null;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!ShortVideoUploadABTest.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString)) {}
    while (!ShortVideoUploadABTest.a()) {
      return;
    }
    for (;;)
    {
      int i;
      synchronized (ShortVideoUploadABTest.jdField_a_of_type_JavaLangObject)
      {
        QLog.d("ShortVideoUploadProcessor", 2, "VideoABTest : uinSeq" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " Switcher:" + this.z + " videoTime:" + this.jdField_c_of_type_Int);
        this.jdField_f_of_type_Long = SystemClock.uptimeMillis();
        ShortVideoUploadABTest.ABTestInfo localABTestInfo = ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        localABTestInfo.jdField_e_of_type_Int = this.C;
        localABTestInfo.jdField_f_of_type_Long = (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long);
        localABTestInfo.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
        localABTestInfo.jdField_g_of_type_Long = (this.jdField_f_of_type_Long - this.jdField_d_of_type_Long);
        localABTestInfo.j = (this.jdField_f_of_type_Long - this.jdField_e_of_type_Long);
        localABTestInfo.jdField_k_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
        if (paramBoolean)
        {
          i = 0;
          localABTestInfo.jdField_c_of_type_Int = i;
          localABTestInfo.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
          localABTestInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
          localABTestInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
          localABTestInfo.jdField_d_of_type_JavaLangString = paramString;
          localABTestInfo.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
          localABTestInfo.jdField_q_of_type_Long = this.jdField_c_of_type_Int;
          localABTestInfo.m = paramLong;
          localABTestInfo.o = this.jdField_q_of_type_Long;
          if (this.z != 3)
          {
            localABTestInfo.jdField_e_of_type_Long = ShortVideoUploadABTest.jdField_a_of_type_Long;
            localABTestInfo.jdField_c_of_type_Long = ShortVideoUploadABTest.jdField_b_of_type_Long;
            localABTestInfo.i = ShortVideoUploadABTest.jdField_c_of_type_Long;
            localABTestInfo.h = ShortVideoUploadABTest.jdField_d_of_type_Long;
          }
          localABTestInfo.jdField_c_of_type_JavaLangString = (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";");
          paramString = new StringBuilder();
          i = 0;
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject1 = (BaseTransProcessor.StepInfo)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject1 == null) {
              break label537;
            }
            paramString.append(String.valueOf(((BaseTransProcessor.StepInfo)localObject1).a()));
            paramString.append("_");
            break label537;
          }
        }
        else
        {
          i = this.jdField_j_of_type_Int;
          continue;
        }
        Object localObject1 = paramString.toString();
        paramString = (String)localObject1;
        if (((String)localObject1).length() > 0) {
          paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        localABTestInfo.jdField_e_of_type_JavaLangString = paramString;
        ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long, this.z);
        return;
      }
      label537:
      i += 1;
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.jdField_g_of_type_Long = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = 0L;
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {}
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long))
    {
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {
        RedBagVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
  }
  
  private void x()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    int i;
    label78:
    Object localObject2;
    long l2;
    if (this.z == 3)
    {
      i = 1;
      ((HashMap)localObject1).put("param_isPreUpload", String.valueOf(i));
      if (this.C != 1) {
        break label514;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", this.C + "_" + this.y);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_sessionID", String.valueOf(this.jdField_c_of_type_Long));
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbMd5", HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
      }
      localObject1 = ShortVideoPresendStats.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_trans", localObject2);
      if (this.z != 3) {
        break label535;
      }
      if ((this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long > 0L) && (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long > 0L) && (this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L - ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long > 0L))
      {
        l1 = this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L;
        l2 = ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
      }
      label296:
      if ((this.z == 3) && (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_c_of_type_Long > 0L)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_comp", String.valueOf(((ShortVideoPresendStats.ReportInfo)localObject1).jdField_c_of_type_Long));
      }
      if ((((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long <= 0L) || (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_d_of_type_Long <= 0L)) {
        break label665;
      }
    }
    label514:
    label535:
    label665:
    for (long l1 = ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Long - ((ShortVideoPresendStats.ReportInfo)localObject1).jdField_d_of_type_Long;; l1 = 0L)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_timeBeforeSend", String.valueOf(l1));
      if (((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_recordTimes", String.valueOf(((ShortVideoPresendStats.ReportInfo)localObject1).jdField_a_of_type_Int));
      }
      ShortVideoPresendStats.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
      if (this.z == 3)
      {
        localObject1 = new StringBuilder();
        i = 0;
        for (;;)
        {
          if (i < this.jdField_b_of_type_JavaUtilList.size() + 1)
          {
            localObject2 = (BaseTransProcessor.StepInfo)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
            if (localObject2 != null)
            {
              ((StringBuilder)localObject1).append(String.valueOf(((BaseTransProcessor.StepInfo)localObject2).a()));
              ((StringBuilder)localObject1).append("_");
            }
            i += 1;
            continue;
            i = 0;
            break;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_rollback", String.valueOf(this.C));
            break label78;
            if ((this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long <= 0L) || (ShortVideoPresendStats.jdField_b_of_type_Long <= 0L) || (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L - ShortVideoPresendStats.jdField_b_of_type_Long <= 0L)) {
              break label296;
            }
            l1 = this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long / 1000000L;
            l2 = ShortVideoPresendStats.jdField_b_of_type_Long;
            this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_wait", String.valueOf(l1 - l2 - 400L));
            break label296;
          }
        }
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {
          localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_s_segs", localObject1);
      }
      return;
    }
  }
  
  private void y()
  {
    u();
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "rollback", "rollBackToSendFileByBDH RollBack with reason:" + this.C + ",mCancelCode = " + this.y);
      s();
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a == null));
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new airh(this));
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_q_of_type_Long - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.jdField_s_of_type_Long, -1));; paramLong = Math.min(paramLong, this.t)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    int j = 0;
    Object localObject2 = MD5.toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (localObject2 != null)
    {
      paramArrayOfByte = "";
      i = 0;
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        if (i >= localObject2.length) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte + MD5.byteHEX(localObject2[i]);
        i += 1;
      }
    }
    Object localObject1 = "";
    paramArrayOfByte = new StringBuilder();
    localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject2).jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_Int);
    }
    paramArrayOfByte.append("/qqupload?ver=");
    paramArrayOfByte.append("3565");
    paramArrayOfByte.append("&ukey=");
    paramArrayOfByte.append(this.jdField_l_of_type_JavaLangString);
    paramArrayOfByte.append("&filekey=");
    paramArrayOfByte.append(this.jdField_f_of_type_JavaLangString);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_q_of_type_Long);
    paramArrayOfByte.append("&bmd5=");
    paramArrayOfByte.append((String)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
      }
      paramArrayOfByte.append("&lastukey=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
      paramArrayOfByte.append("&lastip=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
    }
    paramArrayOfByte.append("&mType=shortVideo");
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        i = j;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) {
          i = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
        }
      }
    }
    paramArrayOfByte.append("&videotype=").append(i);
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV))) {
      paramArrayOfByte.append("&subvideotype=").append(1);
    }
    b("getConnUrl", "url = " + paramArrayOfByte.toString());
    return paramArrayOfByte.toString();
  }
  
  public void a(long paramLong, Bdh_extinfo.PicInfo paramPicInfo, List paramList)
  {
    LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "svrcomp_s", "<BDH_LOG><ShortVideoUploadProcessor>sendAckToBDHServer videoInfos.size : " + paramList.size());
    u();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(3);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l;
    label171:
    int i;
    if (jdField_a_of_type_Boolean)
    {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      paramLong = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      localShortVideoSureReqInfo.uint64_fromuin.set(paramLong);
      localShortVideoSureReqInfo.uint64_touin.set(l);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) && (1008 != this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)) {
        break label390;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) {
        break label403;
      }
      i = 0;
      label184:
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
        break label445;
      }
    }
    label390:
    label403:
    label445:
    for (int j = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; j = 0)
    {
      this.w = j;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(paramPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(paramList);
      localShortVideoReqExtInfo.msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      paramPicInfo = new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      if (ShortVideoUploadABTest.a()) {
        this.jdField_e_of_type_Long = SystemClock.uptimeMillis();
      }
      paramList = new airi(this);
      paramPicInfo = new RequestAck(String.valueOf(paramLong), 16, this.jdField_d_of_type_ArrayOfByte, 30000L, paramList, paramPicInfo, this.jdField_b_of_type_ArrayOfByte, this.D);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().SubmitAckRequest(paramPicInfo);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = paramPicInfo;
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
      break;
      localShortVideoSureReqInfo.uint64_group_code.set(l);
      break label171;
      if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
      {
        i = 1;
        break label184;
      }
      if (3000 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
      {
        i = 2;
        break label184;
      }
      i = 3;
      break label184;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.o) || (this.jdField_k_of_type_Boolean)) {
      return;
    }
    b("onResp", "result:" + paramNetResp.jdField_a_of_type_Int + " errCode:" + paramNetResp.jdField_b_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- result:" + paramNetResp.jdField_a_of_type_Int);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errCode:" + paramNetResp.jdField_b_of_type_Int);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.d("ShortVideoUploadProcessorTest", 2, "onResp mIpList size ==== = 0" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    int i = paramNetResp.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    long l2;
    for (;;)
    {
      try
      {
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
        {
          l2 = 9223372036854775807L;
          if (-5103065L != l2) {
            this.x = 0;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- HttpMsg.RANGE:" + (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- userRetCode:" + l2 + "----mUpBrokenTransferRetryCount=" + this.x);
          }
          if ((l2 == 0L) || (l2 == 9223372036854775807L)) {
            break label542;
          }
          if (-5103065L != l2) {
            break label500;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.jdField_s_of_type_Long = 0L;
          if (this.x >= 3) {
            break;
          }
          an_();
          this.x += 1;
          return;
        }
      }
      catch (Exception paramNetResp)
      {
        a(9343, "decode reponse unknown exception", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      l2 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
    }
    b((int)l2, "续传过期重试超过3次.");
    d();
    return;
    label500:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(-9527, null, a(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    label542:
    long l1;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      this.jdField_l_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = 9223372036854775807L;
        if (l1 != 9223372036854775807L) {
          break label1298;
        }
        Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
        if (localObject == null) {
          break label1298;
        }
      }
    }
    label1298:
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l1 = i;
          if (l1 == 9223372036854775807L)
          {
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            a(-9527, "no header range", a(this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Int), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
            try
            {
              i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
              l1 = i;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              l1 = 9223372036854775807L;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        l1 = 9223372036854775807L;
        continue;
        b("decodeHttpResp", "from " + this.jdField_s_of_type_Long + " to " + l1 + " userReturnCode:" + l2);
        if (l1 <= this.jdField_s_of_type_Long)
        {
          if (this.jdField_s_of_type_Int < 3)
          {
            b("procHttpRespBody", "server offset rollback");
            this.jdField_s_of_type_Int += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = l1;
          this.jdField_s_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l1 >= this.jdField_q_of_type_Long) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null)
          {
            ShortVideoUpInfo localShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            paramNetResp = localShortVideoUpInfo;
            if (localShortVideoUpInfo == null)
            {
              paramNetResp = new ShortVideoUpInfo();
              paramNetResp.key = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              paramNetResp.uKey = this.jdField_l_of_type_JavaLangString;
              paramNetResp.lastIp = this.jdField_b_of_type_Long;
            }
            paramNetResp.transferedSize = this.jdField_s_of_type_Long;
            paramNetResp.timeStamp = (MessageCache.a() * 1000L);
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(paramNetResp);
          }
          if (this.o) {
            break;
          }
          g();
          an_();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l2);
        a(-9527, "", a(this.jdField_i_of_type_JavaLangString, this.jdField_f_of_type_Int), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendFile() success.");
        }
        d(1007);
        b(false);
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
      this.x = 0;
      if ((paramNetResp.jdField_b_of_type_Int == 9364) && (this.jdField_l_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        this.jdField_l_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        m();
        q();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.jdField_b_of_type_Int)))
      {
        this.jdField_d_of_type_Boolean = true;
        m();
        an_();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      b(paramNetResp.jdField_b_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
  }
  
  public void a(VideoSliceInfo paramVideoSliceInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new airp(this, paramVideoSliceInfo));
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        this.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.jdField_a_of_type_Boolean);
          }
          this.E = paramRichProtoReq.jdField_a_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + paramRichProtoReq.jdField_a_of_type_Int);
          }
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            d(1007);
            b(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.jdField_l_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_r_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
          if (this.v == 2)
          {
            d("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
            this.jdField_b_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.jdField_b_of_type_Long);
              QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
            if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            }
            this.jdField_s_of_type_Long = 0L;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
            }
            an_();
          }
          else if (this.v == 0)
          {
            d("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
            if (!paramRichProtoReq.jdField_b_of_type_Boolean) {
              d("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
            }
            if ((paramRichProtoReq.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_d_of_type_ArrayOfByte.length > 0) && (this.jdField_c_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_ArrayOfByte.length > 0))
            {
              d("<BDH_LOG> onBusiProtoResp() select BDH channel");
              this.v = 1;
              a(this.jdField_d_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
            }
            else
            {
              if (paramRichProtoReq.jdField_b_of_type_Boolean) {
                HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
              }
              d("<BDH_LOG> onBusiProtoResp() select HTTP channel");
              this.v = 2;
              this.jdField_b_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
              if (QLog.isColorLevel())
              {
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.jdField_b_of_type_Long);
                QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(66));
              if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
                this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              }
              this.jdField_s_of_type_Long = 0L;
              if (QLog.isColorLevel()) {
                QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
              }
              an_();
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
            if (this.v == 1) {}
            for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
            {
              d(paramRichProtoReq);
              break;
            }
            d();
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new airq(this, paramString, paramInt));
    }
  }
  
  public void a(String paramString, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + paramString + " index :" + paramInt2 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte2) + "fileSize:" + paramInt1);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(this.jdField_c_of_type_Long);
    Bdh_extinfo.VideoInfo localVideoInfo;
    if (jdField_a_of_type_Boolean)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localVideoInfo = new Bdh_extinfo.VideoInfo();
      localVideoInfo.uint32_idx.set(paramInt2);
      localVideoInfo.uint32_size.set(paramInt1);
      localVideoInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
      localVideoInfo.uint32_format.set(2);
      localVideoInfo.uint32_res_len.set(paramInt3);
      localVideoInfo.uint32_res_width.set(paramInt4);
      localVideoInfo.uint32_time.set(paramInt5);
      if (paramInt2 <= 0) {
        break label292;
      }
      this.jdField_b_of_type_JavaUtilList.add(localVideoInfo);
    }
    for (;;)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_videoinfo.set(localVideoInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      u();
      a(paramString, this.jdField_d_of_type_ArrayOfByte, paramArrayOfByte1, (byte[])localObject, paramInt2, paramArrayOfByte2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label292:
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "video seg index is out of bounds !  index : " + paramInt2);
      }
    }
  }
  
  void a(String paramString, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + paramString + " index :" + 0 + " md5:" + HexUtil.bytes2HexStr(paramArrayOfByte3) + " fileSize:" + paramInt);
    }
    this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Bdh_extinfo.ShortVideoReqExtInfo localShortVideoReqExtInfo = new Bdh_extinfo.ShortVideoReqExtInfo();
    localShortVideoReqExtInfo.uint32_cmd.set(1);
    localShortVideoReqExtInfo.uint64_session_id.set(paramLong);
    if (jdField_a_of_type_Boolean) {
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(paramInt);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte3));
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo = localPicInfo;
      localShortVideoReqExtInfo.msg_thumbinfo.set(localPicInfo);
      a(paramString, paramArrayOfByte1, paramArrayOfByte3, new Cryptor().encrypt(localShortVideoReqExtInfo.toByteArray(), paramArrayOfByte2), 0, paramArrayOfByte3);
      return;
      localShortVideoReqExtInfo.bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  /* Error */
  void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, byte[] paramArrayOfByte4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 1376	airt
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 1377	airt:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)V
    //   10: astore 8
    //   12: new 1379	com/tencent/mobileqq/highway/transaction/Transaction
    //   15: dup
    //   16: aload_0
    //   17: getfield 128	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 1382	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   23: bipush 16
    //   25: aload_1
    //   26: iconst_0
    //   27: aload_2
    //   28: aload_3
    //   29: aload 8
    //   31: aload 4
    //   33: invokespecial 1385	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   36: astore_1
    //   37: aload_0
    //   38: getfield 735	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:D	I
    //   41: ifeq +11 -> 52
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 735	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:D	I
    //   49: putfield 1388	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   52: aload 8
    //   54: aload_1
    //   55: putfield 1391	airt:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   58: aload 8
    //   60: iload 5
    //   62: putfield 1392	airt:jdField_a_of_type_Int	I
    //   65: aload_0
    //   66: getfield 128	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   72: aload_1
    //   73: invokevirtual 1396	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   76: istore 7
    //   78: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +83 -> 164
    //   84: ldc 145
    //   86: iconst_2
    //   87: new 147	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 1398
    //   97: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: iload 7
    //   102: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc_w 1400
    //   108: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 1403	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   115: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc_w 1405
    //   121: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_0
    //   125: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   128: getfield 234	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   131: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc_w 1407
    //   137: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: getfield 1410	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   144: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 1412
    //   150: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: bipush 16
    //   155: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   168: getfield 234	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   171: invokestatic 710	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   174: ldc_w 1414
    //   177: new 147	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 1416
    //   187: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload 5
    //   192: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1418
    //   198: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload 6
    //   203: invokestatic 797	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   206: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc_w 1420
    //   212: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 1403	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   219: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 853	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   228: new 86	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo
    //   231: dup
    //   232: invokespecial 87	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:<init>	()V
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 1367	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   240: aload_0
    //   241: getfield 84	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   244: iload 5
    //   246: invokestatic 702	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aload_2
    //   250: invokevirtual 334	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: iload 7
    //   256: ifeq +37 -> 293
    //   259: aload_0
    //   260: iload 7
    //   262: new 147	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 1422
    //   272: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 5
    //   277: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   286: aload_0
    //   287: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   290: aload_0
    //   291: monitorexit
    //   292: return
    //   293: aload_0
    //   294: getfield 79	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   297: aload_1
    //   298: invokeinterface 1346 2 0
    //   303: pop
    //   304: goto -14 -> 290
    //   307: astore_1
    //   308: aload_0
    //   309: monitorexit
    //   310: aload_1
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	ShortVideoUploadProcessor
    //   0	312	1	paramString	String
    //   0	312	2	paramArrayOfByte1	byte[]
    //   0	312	3	paramArrayOfByte2	byte[]
    //   0	312	4	paramArrayOfByte3	byte[]
    //   0	312	5	paramInt	int
    //   0	312	6	paramArrayOfByte4	byte[]
    //   76	185	7	i	int
    //   10	49	8	localairt	airt
    // Exception table:
    //   from	to	target	type
    //   2	52	307	finally
    //   52	164	307	finally
    //   164	254	307	finally
    //   259	290	307	finally
    //   293	304	307	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {
      break label14;
    }
    label14:
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    int i;
    Object localObject1;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      localObject1 = "actShortVideoUpload";
      if (this.v == 1) {
        localObject1 = "actShortVideoUploadBDH";
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 3000)) {
        break label972;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      localObject1 = "actShortVideoDiscussgroupUpload";
      if (this.v == 1) {
        localObject1 = "actShortVideoDiscussgroupUploadBDH";
      }
    }
    label288:
    label972:
    for (;;)
    {
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      long l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.w + "");
      Object localObject3 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        localObject2 = this.jdField_g_of_type_JavaLangString;
        ((HashMap)localObject3).put("param_uuid", localObject2);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_b_of_type_Boolean + "");
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 0) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.jdField_a_of_type_JavaLangBoolean));
        }
        if (this.z != 3) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
        }
        x();
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.h));
        if (!paramBoolean) {
          break label719;
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        l();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
        }
        if (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0) {
          ThreadManager.post(new airo(this, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString), 5, null, true);
        }
        if (!QLog.isColorLevel()) {
          break label844;
        }
        localObject1 = new StringBuilder();
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject3) != null)
          {
            ((StringBuilder)localObject1).append("&");
            ((StringBuilder)localObject1).append((String)localObject3);
            ((StringBuilder)localObject1).append("=");
            ((StringBuilder)localObject1).append((String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3));
          }
        }
        i = 1;
        break;
        localObject2 = this.jdField_f_of_type_JavaLangString;
        break label288;
        label719:
        if (this.jdField_j_of_type_Int != -9527) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
        StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "report", ((StringBuilder)localObject1).toString());
      label844:
      if ((this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) || (this.v != 1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum <= 32L)) {
        break;
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("segNum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum));
      ((HashMap)localObject1).put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "tempVideoUploadBDH", paramBoolean, l, this.jdField_q_of_type_Long, (HashMap)localObject1, "");
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new airr(this, paramBoolean, paramInt));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (!paramBoolean)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
        return;
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("transfer_type", "1");
    localHashMap.put("business_type", this.w + "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("server_ip", paramString1);
    localHashMap.put("server_port", paramString2);
    localHashMap.put("md5", this.jdField_d_of_type_JavaLangString);
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (paramString1 = this.jdField_g_of_type_JavaLangString;; paramString1 = this.jdField_f_of_type_JavaLangString)
    {
      localHashMap.put("uuid", paramString1);
      localHashMap.put("chatType", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int + "");
      localHashMap.put("chatUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actRichMediaNetMonitor_videoUp", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 145
    //   11: iconst_2
    //   12: new 147	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1587
    //   22: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 1275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   39: invokevirtual 1367	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   42: aload_0
    //   43: getfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   46: ifnull +4 -> 50
    //   49: return
    //   50: invokestatic 641	android/os/SystemClock:uptimeMillis	()J
    //   53: lstore 5
    //   55: aload_0
    //   56: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   59: arraylength
    //   60: aload_0
    //   61: getfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   64: arraylength
    //   65: iadd
    //   66: newarray byte
    //   68: astore 12
    //   70: aload_0
    //   71: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   74: iconst_0
    //   75: aload 12
    //   77: iconst_0
    //   78: aload_0
    //   79: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   82: arraylength
    //   83: invokestatic 1591	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   86: aload_0
    //   87: getfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   90: iconst_0
    //   91: aload 12
    //   93: aload_0
    //   94: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   97: arraylength
    //   98: aload_0
    //   99: getfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   102: arraylength
    //   103: invokestatic 1591	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   106: new 147	java/lang/StringBuilder
    //   109: dup
    //   110: invokestatic 1595	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   113: invokespecial 1596	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload 12
    //   118: invokestatic 797	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   121: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 1598
    //   127: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 17
    //   135: invokestatic 641	android/os/SystemClock:uptimeMillis	()J
    //   138: lstore 7
    //   140: new 272	java/io/File
    //   143: dup
    //   144: aload 17
    //   146: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: invokevirtual 1601	java/io/File:delete	()Z
    //   152: pop
    //   153: new 272	java/io/File
    //   156: dup
    //   157: aload 17
    //   159: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore 12
    //   164: aload 12
    //   166: invokevirtual 1604	java/io/File:exists	()Z
    //   169: istore 11
    //   171: iload 11
    //   173: ifne +9 -> 182
    //   176: aload 12
    //   178: invokevirtual 1607	java/io/File:createNewFile	()Z
    //   181: pop
    //   182: new 1609	java/io/FileOutputStream
    //   185: dup
    //   186: aload 12
    //   188: invokespecial 1612	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   191: astore 12
    //   193: new 1614	java/io/BufferedOutputStream
    //   196: dup
    //   197: aload 12
    //   199: invokespecial 1617	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   202: astore 14
    //   204: aload 12
    //   206: astore 15
    //   208: aload 14
    //   210: astore 13
    //   212: aload_0
    //   213: getfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   216: invokevirtual 1622	java/io/RandomAccessFile:length	()J
    //   219: l2i
    //   220: newarray byte
    //   222: astore 16
    //   224: aload 12
    //   226: astore 15
    //   228: aload 14
    //   230: astore 13
    //   232: aload_0
    //   233: getfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   236: aload 16
    //   238: invokevirtual 1626	java/io/RandomAccessFile:read	([B)I
    //   241: pop
    //   242: aload 12
    //   244: astore 15
    //   246: aload 14
    //   248: astore 13
    //   250: aload 14
    //   252: aload 16
    //   254: invokevirtual 1630	java/io/BufferedOutputStream:write	([B)V
    //   257: aload 12
    //   259: astore 15
    //   261: aload 14
    //   263: astore 13
    //   265: ldc_w 1631
    //   268: newarray byte
    //   270: astore 16
    //   272: aload 12
    //   274: astore 15
    //   276: aload 14
    //   278: astore 13
    //   280: aload_0
    //   281: getfield 1633	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   284: aload 16
    //   286: invokevirtual 1626	java/io/RandomAccessFile:read	([B)I
    //   289: istore_3
    //   290: iload_3
    //   291: iconst_m1
    //   292: if_icmpeq +614 -> 906
    //   295: aload 12
    //   297: astore 15
    //   299: aload 14
    //   301: astore 13
    //   303: aload 14
    //   305: aload 16
    //   307: iconst_0
    //   308: iload_3
    //   309: invokevirtual 1636	java/io/BufferedOutputStream:write	([BII)V
    //   312: goto -40 -> 272
    //   315: astore 15
    //   317: aload 14
    //   319: astore 13
    //   321: aload 15
    //   323: astore 14
    //   325: aload 14
    //   327: invokevirtual 1637	java/io/FileNotFoundException:printStackTrace	()V
    //   330: aload 13
    //   332: ifnull +8 -> 340
    //   335: aload 13
    //   337: invokevirtual 1640	java/io/BufferedOutputStream:close	()V
    //   340: aload 12
    //   342: ifnull +8 -> 350
    //   345: aload 12
    //   347: invokevirtual 1641	java/io/FileOutputStream:close	()V
    //   350: aload_0
    //   351: invokespecial 1643	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	()Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq;
    //   354: astore 12
    //   356: new 1645	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   359: dup
    //   360: invokespecial 1646	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   363: astore 13
    //   365: aload 13
    //   367: iconst_1
    //   368: invokevirtual 1647	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   371: aload 13
    //   373: getfield 1648	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   376: aload 12
    //   378: getfield 239	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   381: invokestatic 1000	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   384: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   387: aload 13
    //   389: getfield 1649	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   392: aload 12
    //   394: getfield 250	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   397: invokestatic 1000	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   400: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   403: aload 13
    //   405: getfield 1650	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   408: aload 12
    //   410: getfield 268	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_Int	I
    //   413: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   416: aload 13
    //   418: getfield 1651	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: aload 12
    //   423: getfield 270	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_Int	I
    //   426: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   429: aload 12
    //   431: getfield 267	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   434: ifnull +748 -> 1182
    //   437: aload 13
    //   439: getfield 1652	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   442: aload 12
    //   444: getfield 267	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   447: invokestatic 1000	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   450: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   453: aload 13
    //   455: getfield 1655	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   458: aload 12
    //   460: getfield 266	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:i	I
    //   463: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   466: aload 13
    //   468: getfield 1656	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   471: aload 12
    //   473: getfield 341	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_j_of_type_Int	I
    //   476: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   479: new 1658	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   482: dup
    //   483: invokespecial 1659	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   486: astore 14
    //   488: aload 14
    //   490: getfield 1663	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   493: aload 12
    //   495: getfield 279	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   498: invokevirtual 1667	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   501: aload 14
    //   503: getfield 1668	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   506: aload 12
    //   508: getfield 287	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_ArrayOfByte	[B
    //   511: invokestatic 499	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   514: invokevirtual 400	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   517: aload 14
    //   519: getfield 1669	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   522: aload 12
    //   524: getfield 288	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_ArrayOfByte	[B
    //   527: invokestatic 499	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   530: invokevirtual 400	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   533: aload 14
    //   535: getfield 1672	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   538: aload 12
    //   540: getfield 284	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_a_of_type_Long	J
    //   543: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   546: aload 14
    //   548: getfield 1675	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   551: aload 12
    //   553: getfield 294	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_d_of_type_Int	I
    //   556: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   559: aload 14
    //   561: getfield 1678	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   564: aload 12
    //   566: getfield 291	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_e_of_type_Int	I
    //   569: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   572: aload 14
    //   574: getfield 1679	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   577: aload 12
    //   579: getfield 324	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_g_of_type_Int	I
    //   582: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   585: aload 14
    //   587: getfield 1680	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   590: aload 12
    //   592: getfield 296	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:h	I
    //   595: invokevirtual 417	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   598: aload 14
    //   600: getfield 1683	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   603: aload 12
    //   605: getfield 299	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_b_of_type_Long	J
    //   608: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   611: aload 13
    //   613: getfield 1687	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   616: aload 14
    //   618: invokevirtual 1688	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   621: aload 13
    //   623: invokevirtual 1689	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   626: astore 13
    //   628: new 1037	com/tencent/qphone/base/util/Cryptor
    //   631: dup
    //   632: invokespecial 1038	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   635: aload 13
    //   637: aload_2
    //   638: invokevirtual 1043	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   641: astore_2
    //   642: new 1691	airj
    //   645: dup
    //   646: aload_0
    //   647: lload 5
    //   649: aload 17
    //   651: invokespecial 1694	airj:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;JLjava/lang/String;)V
    //   654: astore 13
    //   656: bipush 12
    //   658: istore_3
    //   659: aload 12
    //   661: getfield 341	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoUpReq:jdField_j_of_type_Int	I
    //   664: ifne +6 -> 670
    //   667: bipush 25
    //   669: istore_3
    //   670: aload_0
    //   671: new 1379	com/tencent/mobileqq/highway/transaction/Transaction
    //   674: dup
    //   675: aload_0
    //   676: getfield 128	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   679: invokevirtual 1382	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   682: iload_3
    //   683: aload 17
    //   685: aload_0
    //   686: getfield 1263	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_r_of_type_Long	J
    //   689: l2i
    //   690: aload_1
    //   691: aload_0
    //   692: getfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   695: aload 13
    //   697: aload_2
    //   698: invokespecial 1385	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   701: putfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   704: new 1696	airm
    //   707: dup
    //   708: aload_0
    //   709: invokespecial 1697	airm:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoUploadProcessor;)V
    //   712: astore_1
    //   713: aload_0
    //   714: getfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   717: aload_1
    //   718: putfield 1701	com/tencent/mobileqq/highway/transaction/Transaction:cbForReport	Lcom/tencent/mobileqq/highway/api/ITransCallbackForReport;
    //   721: aload_0
    //   722: getfield 128	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   725: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   728: aload_0
    //   729: getfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   732: invokevirtual 1396	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   735: istore 4
    //   737: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq +114 -> 854
    //   743: ldc 145
    //   745: iconst_2
    //   746: new 147	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   753: ldc_w 1703
    //   756: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: iload 4
    //   761: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 1400
    //   767: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_0
    //   771: getfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   774: invokevirtual 1403	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   777: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: ldc_w 1405
    //   783: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload_0
    //   787: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   790: getfield 234	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   793: invokevirtual 632	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   796: ldc_w 1705
    //   799: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_0
    //   803: getfield 490	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   806: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 1707
    //   812: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload_0
    //   816: getfield 489	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   819: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: ldc_w 1407
    //   825: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_0
    //   829: getfield 1535	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   832: getfield 1410	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   835: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: ldc_w 1709
    //   841: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: iload_3
    //   845: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: iload 4
    //   856: ifeq -807 -> 49
    //   859: aload_0
    //   860: iload 4
    //   862: ldc_w 1711
    //   865: ldc_w 911
    //   868: aload_0
    //   869: getfield 695	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   872: invokevirtual 1127	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   875: aload_0
    //   876: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   879: return
    //   880: astore 14
    //   882: aload 14
    //   884: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   887: goto -705 -> 182
    //   890: astore 14
    //   892: aconst_null
    //   893: astore 15
    //   895: aload 13
    //   897: astore 12
    //   899: aload 15
    //   901: astore 13
    //   903: goto -578 -> 325
    //   906: aload 12
    //   908: astore 15
    //   910: aload 14
    //   912: astore 13
    //   914: invokestatic 641	android/os/SystemClock:uptimeMillis	()J
    //   917: lstore 9
    //   919: aload 12
    //   921: astore 15
    //   923: aload 14
    //   925: astore 13
    //   927: aload_0
    //   928: getfield 326	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   931: ldc_w 1714
    //   934: lload 9
    //   936: lload 7
    //   938: lsub
    //   939: invokestatic 710	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   942: invokevirtual 334	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   945: pop
    //   946: aload 14
    //   948: ifnull +8 -> 956
    //   951: aload 14
    //   953: invokevirtual 1640	java/io/BufferedOutputStream:close	()V
    //   956: aload 12
    //   958: ifnull -608 -> 350
    //   961: aload 12
    //   963: invokevirtual 1641	java/io/FileOutputStream:close	()V
    //   966: goto -616 -> 350
    //   969: astore 12
    //   971: aload 12
    //   973: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   976: goto -626 -> 350
    //   979: astore 13
    //   981: aload 13
    //   983: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   986: goto -30 -> 956
    //   989: astore 13
    //   991: aload 13
    //   993: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   996: goto -656 -> 340
    //   999: astore 12
    //   1001: aload 12
    //   1003: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1006: goto -656 -> 350
    //   1009: astore 16
    //   1011: aconst_null
    //   1012: astore 12
    //   1014: aconst_null
    //   1015: astore 14
    //   1017: aload 12
    //   1019: astore 15
    //   1021: aload 14
    //   1023: astore 13
    //   1025: aload 16
    //   1027: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1030: aload 14
    //   1032: ifnull +8 -> 1040
    //   1035: aload 14
    //   1037: invokevirtual 1640	java/io/BufferedOutputStream:close	()V
    //   1040: aload 12
    //   1042: ifnull -692 -> 350
    //   1045: aload 12
    //   1047: invokevirtual 1641	java/io/FileOutputStream:close	()V
    //   1050: goto -700 -> 350
    //   1053: astore 12
    //   1055: aload 12
    //   1057: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1060: goto -710 -> 350
    //   1063: astore 13
    //   1065: aload 13
    //   1067: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1070: goto -30 -> 1040
    //   1073: astore 16
    //   1075: aconst_null
    //   1076: astore 12
    //   1078: aconst_null
    //   1079: astore 14
    //   1081: aload 12
    //   1083: astore 15
    //   1085: aload 14
    //   1087: astore 13
    //   1089: aload 16
    //   1091: invokevirtual 1715	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1094: aload 14
    //   1096: ifnull +8 -> 1104
    //   1099: aload 14
    //   1101: invokevirtual 1640	java/io/BufferedOutputStream:close	()V
    //   1104: aload 12
    //   1106: ifnull -756 -> 350
    //   1109: aload 12
    //   1111: invokevirtual 1641	java/io/FileOutputStream:close	()V
    //   1114: goto -764 -> 350
    //   1117: astore 12
    //   1119: aload 12
    //   1121: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1124: goto -774 -> 350
    //   1127: astore 13
    //   1129: aload 13
    //   1131: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1134: goto -30 -> 1104
    //   1137: astore_1
    //   1138: aconst_null
    //   1139: astore 12
    //   1141: aconst_null
    //   1142: astore 13
    //   1144: aload 13
    //   1146: ifnull +8 -> 1154
    //   1149: aload 13
    //   1151: invokevirtual 1640	java/io/BufferedOutputStream:close	()V
    //   1154: aload 12
    //   1156: ifnull +8 -> 1164
    //   1159: aload 12
    //   1161: invokevirtual 1641	java/io/FileOutputStream:close	()V
    //   1164: aload_1
    //   1165: athrow
    //   1166: astore_2
    //   1167: aload_2
    //   1168: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1171: goto -17 -> 1154
    //   1174: astore_2
    //   1175: aload_2
    //   1176: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   1179: goto -15 -> 1164
    //   1182: aload 13
    //   1184: getfield 1652	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1187: lconst_0
    //   1188: invokevirtual 990	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1191: goto -738 -> 453
    //   1194: astore_1
    //   1195: aconst_null
    //   1196: astore 13
    //   1198: goto -54 -> 1144
    //   1201: astore_1
    //   1202: aload 15
    //   1204: astore 12
    //   1206: goto -62 -> 1144
    //   1209: astore_1
    //   1210: goto -66 -> 1144
    //   1213: astore 16
    //   1215: aconst_null
    //   1216: astore 14
    //   1218: goto -137 -> 1081
    //   1221: astore 16
    //   1223: goto -142 -> 1081
    //   1226: astore 16
    //   1228: aconst_null
    //   1229: astore 14
    //   1231: goto -214 -> 1017
    //   1234: astore 16
    //   1236: goto -219 -> 1017
    //   1239: astore 14
    //   1241: aconst_null
    //   1242: astore 13
    //   1244: goto -919 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1247	0	this	ShortVideoUploadProcessor
    //   0	1247	1	paramArrayOfByte1	byte[]
    //   0	1247	2	paramArrayOfByte2	byte[]
    //   289	556	3	i	int
    //   735	126	4	j	int
    //   53	595	5	l1	long
    //   138	799	7	l2	long
    //   917	18	9	l3	long
    //   169	3	11	bool	boolean
    //   68	894	12	localObject1	Object
    //   969	3	12	localIOException1	IOException
    //   999	3	12	localIOException2	IOException
    //   1012	34	12	localObject2	Object
    //   1053	3	12	localIOException3	IOException
    //   1076	34	12	localObject3	Object
    //   1117	3	12	localIOException4	IOException
    //   1139	66	12	localObject4	Object
    //   1	925	13	localObject5	Object
    //   979	3	13	localIOException5	IOException
    //   989	3	13	localIOException6	IOException
    //   1023	1	13	localObject6	Object
    //   1063	3	13	localIOException7	IOException
    //   1087	1	13	localObject7	Object
    //   1127	3	13	localIOException8	IOException
    //   1142	101	13	localObject8	Object
    //   202	415	14	localObject9	Object
    //   880	3	14	localIOException9	IOException
    //   890	62	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   1015	215	14	localObject10	Object
    //   1239	1	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   206	92	15	localObject11	Object
    //   315	7	15	localFileNotFoundException3	java.io.FileNotFoundException
    //   893	310	15	localObject12	Object
    //   222	84	16	arrayOfByte	byte[]
    //   1009	17	16	localIOException10	IOException
    //   1073	17	16	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1213	1	16	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1221	1	16	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1226	1	16	localIOException11	IOException
    //   1234	1	16	localIOException12	IOException
    //   133	551	17	str	String
    // Exception table:
    //   from	to	target	type
    //   212	224	315	java/io/FileNotFoundException
    //   232	242	315	java/io/FileNotFoundException
    //   250	257	315	java/io/FileNotFoundException
    //   265	272	315	java/io/FileNotFoundException
    //   280	290	315	java/io/FileNotFoundException
    //   303	312	315	java/io/FileNotFoundException
    //   914	919	315	java/io/FileNotFoundException
    //   927	946	315	java/io/FileNotFoundException
    //   176	182	880	java/io/IOException
    //   135	171	890	java/io/FileNotFoundException
    //   176	182	890	java/io/FileNotFoundException
    //   182	193	890	java/io/FileNotFoundException
    //   882	887	890	java/io/FileNotFoundException
    //   961	966	969	java/io/IOException
    //   951	956	979	java/io/IOException
    //   335	340	989	java/io/IOException
    //   345	350	999	java/io/IOException
    //   135	171	1009	java/io/IOException
    //   182	193	1009	java/io/IOException
    //   882	887	1009	java/io/IOException
    //   1045	1050	1053	java/io/IOException
    //   1035	1040	1063	java/io/IOException
    //   135	171	1073	java/lang/OutOfMemoryError
    //   176	182	1073	java/lang/OutOfMemoryError
    //   182	193	1073	java/lang/OutOfMemoryError
    //   882	887	1073	java/lang/OutOfMemoryError
    //   1109	1114	1117	java/io/IOException
    //   1099	1104	1127	java/io/IOException
    //   135	171	1137	finally
    //   176	182	1137	finally
    //   182	193	1137	finally
    //   882	887	1137	finally
    //   1149	1154	1166	java/io/IOException
    //   1159	1164	1174	java/io/IOException
    //   193	204	1194	finally
    //   212	224	1201	finally
    //   232	242	1201	finally
    //   250	257	1201	finally
    //   265	272	1201	finally
    //   280	290	1201	finally
    //   303	312	1201	finally
    //   914	919	1201	finally
    //   927	946	1201	finally
    //   1025	1030	1201	finally
    //   1089	1094	1201	finally
    //   325	330	1209	finally
    //   193	204	1213	java/lang/OutOfMemoryError
    //   212	224	1221	java/lang/OutOfMemoryError
    //   232	242	1221	java/lang/OutOfMemoryError
    //   250	257	1221	java/lang/OutOfMemoryError
    //   265	272	1221	java/lang/OutOfMemoryError
    //   280	290	1221	java/lang/OutOfMemoryError
    //   303	312	1221	java/lang/OutOfMemoryError
    //   914	919	1221	java/lang/OutOfMemoryError
    //   927	946	1221	java/lang/OutOfMemoryError
    //   193	204	1226	java/io/IOException
    //   212	224	1234	java/io/IOException
    //   232	242	1234	java/io/IOException
    //   250	257	1234	java/io/IOException
    //   265	272	1234	java/io/IOException
    //   280	290	1234	java/io/IOException
    //   303	312	1234	java/io/IOException
    //   914	919	1234	java/io/IOException
    //   927	946	1234	java/io/IOException
    //   193	204	1239	java/io/FileNotFoundException
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int j;
      try
      {
        if ((!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_a_of_type_JavaLangString)))
        {
          b(9303, "read file error");
          d();
          return null;
        }
        if (paramInt1 >= this.jdField_a_of_type_Long) {
          break label162;
        }
        this.jdField_b_of_type_JavaIoRandomAccessFile.seek(paramInt1);
        if (this.jdField_a_of_type_Long >= paramInt1 + paramInt2) {
          break label244;
        }
        paramInt1 = (int)(this.jdField_a_of_type_Long - paramInt1);
        byte[] arrayOfByte1 = new byte[paramInt1];
        i = 0;
        paramInt2 = paramInt1;
        if (i >= paramInt1) {
          break label159;
        }
        j = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte1, i, paramInt2);
        if (j == -1)
        {
          b(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException);
        localIOException.printStackTrace();
        return null;
      }
      i += j;
      paramInt2 -= j;
      continue;
      label159:
      return localIOException;
      label162:
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1 - this.jdField_a_of_type_Long);
      byte[] arrayOfByte2 = new byte[paramInt2];
      int i = 0;
      paramInt1 = paramInt2;
      while (i < paramInt2)
      {
        j = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte2, i, paramInt1);
        if (j == -1)
        {
          b(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        i += j;
        paramInt1 -= j;
      }
      return arrayOfByte2;
      label244:
      paramInt1 = paramInt2;
    }
  }
  
  /* Error */
  public void ap_()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 202	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 145
    //   16: iconst_2
    //   17: ldc_w 1737
    //   20: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1739	com/tencent/mobileqq/transfile/BaseUploadProcessor:ap_	()V
    //   27: aload_0
    //   28: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   31: getfield 172	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   34: checkcast 174	com/tencent/mobileqq/data/MessageForShortVideo
    //   37: invokevirtual 346	com/tencent/mobileqq/data/MessageForShortVideo:CheckIsHotVideo	()Z
    //   40: ifeq +143 -> 183
    //   43: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +12 -> 58
    //   49: ldc 145
    //   51: iconst_2
    //   52: ldc_w 1741
    //   55: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_0
    //   59: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   62: getfield 1742	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   65: ifnull +16 -> 81
    //   68: aload_0
    //   69: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   72: getfield 1742	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   75: instanceof 1744
    //   78: ifeq +92 -> 170
    //   81: aload_0
    //   82: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   85: getfield 172	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   88: checkcast 174	com/tencent/mobileqq/data/MessageForShortVideo
    //   91: astore_2
    //   92: aload_2
    //   93: getfield 502	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   96: ifnull +21 -> 117
    //   99: aload_2
    //   100: getfield 502	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   103: invokevirtual 492	java/lang/String:length	()I
    //   106: ifle +11 -> 117
    //   109: aload_0
    //   110: aload_2
    //   111: getfield 502	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   114: putfield 490	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   117: aload_2
    //   118: getfield 599	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   121: ifnull +21 -> 142
    //   124: aload_2
    //   125: getfield 599	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   128: invokevirtual 492	java/lang/String:length	()I
    //   131: ifle +11 -> 142
    //   134: aload_0
    //   135: aload_2
    //   136: getfield 599	com/tencent/mobileqq/data/MessageForShortVideo:uuid	Ljava/lang/String;
    //   139: putfield 489	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   142: aload_2
    //   143: getfield 1747	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   146: ifnull +24 -> 170
    //   149: aload_2
    //   150: getfield 1747	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   153: invokevirtual 492	java/lang/String:length	()I
    //   156: ifle +14 -> 170
    //   159: aload_0
    //   160: aload_2
    //   161: getfield 1747	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   164: invokestatic 223	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   167: putfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   170: aload_0
    //   171: sipush 1001
    //   174: invokevirtual 1204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   177: aload_0
    //   178: iconst_0
    //   179: invokevirtual 1206	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Z)V
    //   182: return
    //   183: aload_0
    //   184: sipush 1001
    //   187: invokevirtual 1204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   190: aload_0
    //   191: getfield 302	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   194: invokevirtual 1207	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   197: invokestatic 624	com/tencent/mobileqq/transfile/ShortVideoUploadABTest:a	()Z
    //   200: ifeq +10 -> 210
    //   203: aload_0
    //   204: invokestatic 641	android/os/SystemClock:uptimeMillis	()J
    //   207: putfield 659	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_Long	J
    //   210: aload_0
    //   211: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   214: getfield 180	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_Boolean	Z
    //   217: ifeq +144 -> 361
    //   220: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +12 -> 235
    //   226: ldc 145
    //   228: iconst_2
    //   229: ldc_w 1749
    //   232: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: iconst_3
    //   237: putfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   245: getfield 1750	com/tencent/mobileqq/transfile/TransferRequest:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   248: putfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   256: getfield 1752	com/tencent/mobileqq/transfile/TransferRequest:k	Ljava/lang/String;
    //   259: invokestatic 223	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   262: putfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   265: aload_0
    //   266: invokevirtual 1754	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()V
    //   269: aload_0
    //   270: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   273: ifnonnull +345 -> 618
    //   276: new 1756	java/io/FileInputStream
    //   279: dup
    //   280: aload_0
    //   281: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: invokespecial 1757	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   287: astore_3
    //   288: aload_3
    //   289: astore_2
    //   290: aload_0
    //   291: aload_3
    //   292: lconst_0
    //   293: invokestatic 1760	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   296: putfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   299: aload_3
    //   300: astore_2
    //   301: aload_0
    //   302: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   305: ifnonnull +305 -> 610
    //   308: aload_3
    //   309: astore_2
    //   310: aload_0
    //   311: sipush 9041
    //   314: new 147	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 1762
    //   324: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload_0
    //   328: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   331: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   340: aload_3
    //   341: astore_2
    //   342: aload_0
    //   343: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   346: aload_3
    //   347: ifnull -340 -> 7
    //   350: aload_3
    //   351: invokevirtual 1763	java/io/FileInputStream:close	()V
    //   354: return
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   360: return
    //   361: aload_0
    //   362: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   365: getfield 611	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   368: invokestatic 1769	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +40 -> 411
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   379: getfield 611	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   382: invokestatic 223	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   385: putfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   388: aload_0
    //   389: getfield 302	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   392: astore_2
    //   393: aload_0
    //   394: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   397: getfield 611	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   400: astore_3
    //   401: aload_2
    //   402: aload_3
    //   403: putfield 1770	com/tencent/mobileqq/transfile/FileMsg:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   406: aload_0
    //   407: aload_3
    //   408: putfield 490	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   411: aload_0
    //   412: getfield 286	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   415: ifnonnull +15 -> 430
    //   418: aload_0
    //   419: invokevirtual 1772	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:e	()Z
    //   422: ifne +8 -> 430
    //   425: aload_0
    //   426: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   429: return
    //   430: aload_0
    //   431: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   434: getfield 182	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   437: invokestatic 1720	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   440: ifne +18 -> 458
    //   443: aload_0
    //   444: sipush 9042
    //   447: ldc_w 1774
    //   450: invokevirtual 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   453: aload_0
    //   454: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   457: return
    //   458: aload_0
    //   459: getfield 1633	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   462: ifnonnull +59 -> 521
    //   465: aload_0
    //   466: new 1621	java/io/RandomAccessFile
    //   469: dup
    //   470: aload_0
    //   471: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   474: getfield 182	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   477: ldc_w 1775
    //   480: invokespecial 1777	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: putfield 1633	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   486: aload_0
    //   487: getfield 1633	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   490: ifnonnull +31 -> 521
    //   493: aload_0
    //   494: sipush 9303
    //   497: ldc_w 1779
    //   500: invokevirtual 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   503: aload_0
    //   504: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   507: return
    //   508: astore_2
    //   509: aload_2
    //   510: invokevirtual 1637	java/io/FileNotFoundException:printStackTrace	()V
    //   513: aload_0
    //   514: aconst_null
    //   515: putfield 1633	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   518: goto -32 -> 486
    //   521: aload_0
    //   522: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   525: getfield 172	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   528: checkcast 174	com/tencent/mobileqq/data/MessageForShortVideo
    //   531: getfield 177	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   534: iconst_1
    //   535: if_icmpne +43 -> 578
    //   538: getstatic 1782	com/tencent/mobileqq/highway/utils/VideoUpConfigInfo:sSwitch	I
    //   541: iconst_2
    //   542: if_icmpne +8 -> 550
    //   545: aload_0
    //   546: iconst_2
    //   547: putfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   550: getstatic 1783	com/tencent/mobileqq/transfile/ShortVideoPresendStats:jdField_a_of_type_Long	J
    //   553: lconst_0
    //   554: lcmp
    //   555: ifle -286 -> 269
    //   558: aload_0
    //   559: getfield 326	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   562: ldc_w 818
    //   565: getstatic 1783	com/tencent/mobileqq/transfile/ShortVideoPresendStats:jdField_a_of_type_Long	J
    //   568: invokestatic 710	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   571: invokevirtual 334	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: pop
    //   575: goto -306 -> 269
    //   578: aload_0
    //   579: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   582: getfield 172	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   585: checkcast 174	com/tencent/mobileqq/data/MessageForShortVideo
    //   588: getfield 177	com/tencent/mobileqq/data/MessageForShortVideo:busiType	I
    //   591: iconst_2
    //   592: if_icmpne -42 -> 550
    //   595: getstatic 1786	com/tencent/mobileqq/highway/utils/PTVUpConfigInfo:sSwitch	I
    //   598: iconst_2
    //   599: if_icmpne -49 -> 550
    //   602: aload_0
    //   603: iconst_2
    //   604: putfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   607: goto -57 -> 550
    //   610: aload_3
    //   611: ifnull +7 -> 618
    //   614: aload_3
    //   615: invokevirtual 1763	java/io/FileInputStream:close	()V
    //   618: aload_0
    //   619: getfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   622: ifnonnull +125 -> 747
    //   625: aload_0
    //   626: new 1621	java/io/RandomAccessFile
    //   629: dup
    //   630: aload_0
    //   631: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   634: ldc_w 1775
    //   637: invokespecial 1777	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: putfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   643: aload_0
    //   644: getfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   647: ifnonnull +100 -> 747
    //   650: aload_0
    //   651: sipush 9303
    //   654: ldc_w 1788
    //   657: invokevirtual 197	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(ILjava/lang/String;)V
    //   660: aload_0
    //   661: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   664: return
    //   665: astore_2
    //   666: aload_2
    //   667: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   670: goto -52 -> 618
    //   673: astore 4
    //   675: aconst_null
    //   676: astore_3
    //   677: aload_3
    //   678: astore_2
    //   679: aload_0
    //   680: aconst_null
    //   681: putfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   684: aload_3
    //   685: astore_2
    //   686: aload_0
    //   687: aload 4
    //   689: invokevirtual 1734	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   692: aload_3
    //   693: astore_2
    //   694: aload_0
    //   695: invokevirtual 199	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   698: aload_3
    //   699: ifnull -692 -> 7
    //   702: aload_3
    //   703: invokevirtual 1763	java/io/FileInputStream:close	()V
    //   706: return
    //   707: astore_2
    //   708: aload_2
    //   709: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   712: return
    //   713: astore_3
    //   714: aconst_null
    //   715: astore_2
    //   716: aload_2
    //   717: ifnull +7 -> 724
    //   720: aload_2
    //   721: invokevirtual 1763	java/io/FileInputStream:close	()V
    //   724: aload_3
    //   725: athrow
    //   726: astore_2
    //   727: aload_2
    //   728: invokevirtual 1712	java/io/IOException:printStackTrace	()V
    //   731: goto -7 -> 724
    //   734: astore_2
    //   735: aload_2
    //   736: invokevirtual 1637	java/io/FileNotFoundException:printStackTrace	()V
    //   739: aload_0
    //   740: aconst_null
    //   741: putfield 1619	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   744: goto -101 -> 643
    //   747: aload_0
    //   748: new 272	java/io/File
    //   751: dup
    //   752: aload_0
    //   753: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   756: invokespecial 275	java/io/File:<init>	(Ljava/lang/String;)V
    //   759: invokevirtual 283	java/io/File:length	()J
    //   762: putfield 297	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Long	J
    //   765: aload_0
    //   766: aload_0
    //   767: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   770: invokevirtual 1790	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:b	(Ljava/lang/String;)V
    //   773: ldc_w 1792
    //   776: monitorenter
    //   777: aload_0
    //   778: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   781: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   784: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   787: invokevirtual 1799	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   790: ifnull +48 -> 838
    //   793: aload_0
    //   794: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   797: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   800: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   803: invokevirtual 1799	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   806: arraylength
    //   807: istore_1
    //   808: aload_0
    //   809: iload_1
    //   810: newarray byte
    //   812: putfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   815: aload_0
    //   816: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   819: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   822: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   825: invokevirtual 1799	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   828: iconst_0
    //   829: aload_0
    //   830: getfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   833: iconst_0
    //   834: iload_1
    //   835: invokestatic 1591	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   838: aload_0
    //   839: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   842: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   845: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   848: invokevirtual 1802	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   851: ifnull +48 -> 899
    //   854: aload_0
    //   855: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   858: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   861: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   864: invokevirtual 1802	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   867: arraylength
    //   868: istore_1
    //   869: aload_0
    //   870: iload_1
    //   871: newarray byte
    //   873: putfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   876: aload_0
    //   877: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   880: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   883: invokestatic 1796	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   886: invokevirtual 1802	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   889: iconst_0
    //   890: aload_0
    //   891: getfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   894: iconst_0
    //   895: iload_1
    //   896: invokestatic 1591	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   899: ldc_w 1792
    //   902: monitorexit
    //   903: aload_0
    //   904: getfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   907: ifnull +26 -> 933
    //   910: aload_0
    //   911: getfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   914: arraylength
    //   915: ifeq +18 -> 933
    //   918: aload_0
    //   919: getfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   922: ifnull +11 -> 933
    //   925: aload_0
    //   926: getfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   929: arraylength
    //   930: ifne +45 -> 975
    //   933: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +12 -> 948
    //   939: ldc 145
    //   941: iconst_2
    //   942: ldc_w 1804
    //   945: invokestatic 1361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   948: aload_0
    //   949: getfield 128	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   952: aload_0
    //   953: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   956: getfield 237	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   959: invokestatic 1297	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   962: aload_0
    //   963: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   966: iconst_2
    //   967: if_icmpne +77 -> 1044
    //   970: aload_0
    //   971: iconst_1
    //   972: putfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   975: ldc 145
    //   977: iconst_1
    //   978: new 147	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   985: ldc_w 1806
    //   988: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_0
    //   992: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   995: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   998: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1004: aload_0
    //   1005: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   1008: tableswitch	default:+24 -> 1032, 2:+64->1072, 3:+82->1090
    //   1033: invokevirtual 1216	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:q	()V
    //   1036: return
    //   1037: astore_2
    //   1038: ldc_w 1792
    //   1041: monitorexit
    //   1042: aload_2
    //   1043: athrow
    //   1044: aload_0
    //   1045: getfield 130	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:z	I
    //   1048: iconst_3
    //   1049: if_icmpne -74 -> 975
    //   1052: aload_0
    //   1053: monitorenter
    //   1054: aload_0
    //   1055: iconst_1
    //   1056: putfield 70	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:B	I
    //   1059: aload_0
    //   1060: iconst_3
    //   1061: putfield 648	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:C	I
    //   1064: aload_0
    //   1065: monitorexit
    //   1066: return
    //   1067: astore_2
    //   1068: aload_0
    //   1069: monitorexit
    //   1070: aload_2
    //   1071: athrow
    //   1072: aload_0
    //   1073: iconst_1
    //   1074: putfield 1265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:v	I
    //   1077: aload_0
    //   1078: aload_0
    //   1079: getfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   1082: aload_0
    //   1083: getfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   1086: invokevirtual 1291	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	([B[B)V
    //   1089: return
    //   1090: aload_0
    //   1091: aload_0
    //   1092: getfield 167	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1095: getfield 234	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1098: putfield 791	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_Long	J
    //   1101: aload_0
    //   1102: aload_0
    //   1103: getfield 204	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1106: aload_0
    //   1107: getfield 297	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_Long	J
    //   1110: l2i
    //   1111: aload_0
    //   1112: getfield 730	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   1115: aload_0
    //   1116: getfield 733	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   1119: aload_0
    //   1120: getfield 225	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   1123: aload_0
    //   1124: getfield 791	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_c_of_type_Long	J
    //   1127: invokevirtual 1808	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/lang/String;I[B[B[BJ)V
    //   1130: aload_0
    //   1131: iconst_1
    //   1132: putfield 1265	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:v	I
    //   1135: return
    //   1136: astore_3
    //   1137: goto -421 -> 716
    //   1140: astore 4
    //   1142: goto -465 -> 677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1145	0	this	ShortVideoUploadProcessor
    //   807	89	1	i	int
    //   91	251	2	localObject1	Object
    //   355	2	2	localIOException1	IOException
    //   392	10	2	localFileMsg	FileMsg
    //   508	2	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   665	2	2	localIOException2	IOException
    //   678	16	2	localObject2	Object
    //   707	2	2	localIOException3	IOException
    //   715	6	2	localObject3	Object
    //   726	2	2	localIOException4	IOException
    //   734	2	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   1037	6	2	localObject4	Object
    //   1067	4	2	localObject5	Object
    //   287	416	3	localObject6	Object
    //   713	12	3	localObject7	Object
    //   1136	1	3	localObject8	Object
    //   673	15	4	localIOException5	IOException
    //   1140	1	4	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   350	354	355	java/io/IOException
    //   465	486	508	java/io/FileNotFoundException
    //   614	618	665	java/io/IOException
    //   276	288	673	java/io/IOException
    //   702	706	707	java/io/IOException
    //   276	288	713	finally
    //   720	724	726	java/io/IOException
    //   625	643	734	java/io/FileNotFoundException
    //   777	838	1037	finally
    //   838	899	1037	finally
    //   899	903	1037	finally
    //   1038	1042	1037	finally
    //   1054	1066	1067	finally
    //   1068	1070	1067	finally
    //   290	299	1136	finally
    //   301	308	1136	finally
    //   310	340	1136	finally
    //   342	346	1136	finally
    //   679	684	1136	finally
    //   686	692	1136	finally
    //   694	698	1136	finally
    //   290	299	1140	java/io/IOException
    //   301	308	1140	java/io/IOException
    //   310	340	1140	java/io/IOException
    //   342	346	1140	java/io/IOException
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.jdField_k_of_type_Boolean);
    }
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
      d(1002);
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_q_of_type_Int = 0;
      if (this.v != 1)
      {
        this.jdField_l_of_type_JavaLangString = null;
        this.jdField_s_of_type_Long = 0L;
      }
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      v();
      d(1001);
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new airg(this));
    }
    return 0;
  }
  
  public void b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.jdField_a_of_type_Int = localOptions.outWidth;
    this.jdField_b_of_type_Int = localOptions.outHeight;
  }
  
  public void b(boolean paramBoolean)
  {
    int j = 2002;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!d()) {
      return;
    }
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoUploadInfo)))
    {
      localObject2 = (ShortVideoUploadInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      this.jdField_q_of_type_Boolean = ((ShortVideoUploadInfo)localObject2).jdField_g_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, mNeedSyncStory = " + this.jdField_q_of_type_Boolean);
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, isHotVideo = " + ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_Boolean);
        }
        if (((ShortVideoUploadInfo)localObject2).jdField_e_of_type_Boolean)
        {
          this.jdField_g_of_type_JavaLangString = ((ShortVideoUploadInfo)localObject2).jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_JavaLangString;
          this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(((ShortVideoUploadInfo)localObject2).jdField_e_of_type_JavaLangString);
          this.jdField_q_of_type_Long = (((ShortVideoUploadInfo)localObject2).jdField_e_of_type_Int + ((ShortVideoUploadInfo)localObject2).jdField_b_of_type_Long);
          this.jdField_c_of_type_Int = ((ShortVideoUploadInfo)localObject2).jdField_f_of_type_Int;
          this.jdField_a_of_type_Long = ((ShortVideoUploadInfo)localObject2).jdField_b_of_type_Long;
          this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(((ShortVideoUploadInfo)localObject2).jdField_g_of_type_JavaLangString);
          this.jdField_b_of_type_Int = ((ShortVideoUploadInfo)localObject2).jdField_d_of_type_Int;
          this.jdField_a_of_type_Int = ((ShortVideoUploadInfo)localObject2).jdField_c_of_type_Int;
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "message", "sendMsg() start.");
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      Object localObject3 = a();
      if (localObject3 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject3);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label493;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label464;
        }
      }
      label464:
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label493:
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, subBusiType = " + ((MessageForShortVideo)localObject1).subBusiType);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null))
      {
        e();
        return;
      }
      if ((localObject1 instanceof MessageForBlessPTV))
      {
        ((MessageForBlessPTV)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, ((MessageRecord)localObject1).frienduin);
        Logger.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
        return;
      }
      if ((localObject1 instanceof MessageForDanceMachine))
      {
        ((MessageForDanceMachine)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8034, true, localObject1);
        Logger.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI dance machine data send finished");
        return;
      }
      if (!c())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "message", "sendMsg() []. mr = " + ((MessageRecord)localObject1).toString());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      if (localObject2 == null) {
        break;
      }
      localObject3 = new DCShortVideo(BaseApplication.getContext());
      int i = j;
      switch (((MessageForShortVideo)localObject1).busiType)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        if ((((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString == null) || (((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString.length() <= 0)) {
          ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString = ((ShortVideoUploadInfo)localObject2).h;
        }
        ((DCShortVideo)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ShortVideoUploadInfo)localObject2).jdField_i_of_type_JavaLangString, i, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, false, paramBoolean, -1, null, ((ShortVideoUploadInfo)localObject2).jdField_f_of_type_Int, ((ShortVideoUploadInfo)localObject2).jdField_e_of_type_JavaLangString);
        return;
        i = 2001;
        continue;
        i = 2003;
      }
      localObject2 = null;
    }
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.jdField_m_of_type_Boolean = true;
    }
    return 0;
  }
  
  public void c()
  {
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null))
      {
        UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
        localSendResult.jdField_a_of_type_Int = -1;
        localSendResult.jdField_b_of_type_Int = 9037;
        localSendResult.jdField_a_of_type_JavaLangString = "cancel";
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
    }
    switch (this.v)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        d("<BDH_LOG> pause() BUT current status is INIT");
        return;
        d("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq == null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      d("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    d("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() != 0))
      {
        Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((Transaction)localIterator.next()).cancelTransaction();
        }
        this.jdField_c_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    super.d();
    if ((this.z == 3) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label417;
      }
    }
    label417:
    for (Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long))
    {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject2).md5 = this.jdField_c_of_type_JavaLangString;
      }
      d(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.jdField_j_of_type_Int);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        localObject2 = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Int = -1;
        ((UpCallBack.SendResult)localObject2).jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b((UpCallBack.SendResult)localObject2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, false, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        Logger.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForDanceMachine)))
      {
        ((MessageForDanceMachine)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).errorCode = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(8034, false, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        Logger.a("ShortVideoUploadProcessor", "onError", "notifyUI dance machine send error");
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.b(paramInt));
    }
    if ((this.jdField_k_of_type_Boolean) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      b("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.E;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = (this.jdField_q_of_type_Long - this.jdField_a_of_type_Long);
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_g_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        localSendResult.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localSendResult.jdField_c_of_type_Int = this.E;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onSuccess uuid = " + localSendResult.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 2) {
        w();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  void f()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      try
      {
        l = Long.valueOf(localObject[4]).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> dpcTimeout : " + l);
        }
        if (l > 0L) {
          this.jdField_g_of_type_Long = l;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException);
        }
      }
      long l = 0L;
    }
  }
  
  public void f(int paramInt)
  {
    try
    {
      this.B = 1;
      this.C = paramInt;
      if (this.A == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> handleBDHActError mVideoPreUpStatus = " + this.B + " mVideoRecordStatus = " + this.A);
        }
        LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "handleBDHActError", "mVideoPreUpStatus = " + this.B + " mVideoRecordStatus = " + this.A);
        y();
      }
      return;
    }
    finally {}
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCu";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {
        str = "videoGu";
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 3000) {
        str = "videoDu";
      } else {
        str = "videoOu";
      }
    }
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = a();
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
    localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_up";
    localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoUpReq);
    localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    do
    {
      return;
      if (localShortVideoUpReq.jdField_a_of_type_Long == 0L)
      {
        b(9303, "video filesize is 0");
        d();
        return;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        b(9303, "thumbfile filesize is 0");
        d();
        return;
      }
      if ((localShortVideoUpReq.jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      b("requestStart", localRichProtoReq.toString());
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void r()
  {
    if (this.o) {
      return;
    }
    if ((this.v == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    if ((this.jdField_l_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString != null) && (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long))
    {
      b(false);
      return;
    }
    ap_();
  }
  
  public void s()
  {
    if (NetworkUtil.h(BaseApplication.getContext())) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", i);
      i = ((SharedPreferences)localObject).getInt("key_video_rollback_counts", 0);
      long l1 = ((SharedPreferences)localObject).getLong("key_video_rollback_time", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if ((i == 0) || (l1 == 0L)) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      if (l2 - l1 < 0L) {
        ((SharedPreferences)localObject).edit().putLong("key_video_rollback_time", l2).commit();
      }
      ((SharedPreferences)localObject).edit().putInt("key_video_rollback_counts", i + 1).commit();
      LogTag.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long), "rollback", "recordRollbackCounts ：" + String.valueOf(i + 1));
      return;
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> startTimerForPreUpload");
    }
    if (this.jdField_a_of_type_Airs == null) {
      this.jdField_a_of_type_Airs = new airs(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Airs, this.jdField_g_of_type_Long);
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> stopTimerForPreUpload");
    }
    if (this.jdField_a_of_type_Airs != null)
    {
      this.jdField_a_of_type_Airs.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Airs);
      this.jdField_a_of_type_Airs = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */