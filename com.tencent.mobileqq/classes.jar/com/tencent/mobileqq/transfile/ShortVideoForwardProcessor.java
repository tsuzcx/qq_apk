package com.tencent.mobileqq.transfile;

import aiwc;
import aiwh;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoForwardProcessor
  extends BaseUploadProcessor
{
  protected int a;
  protected long a;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new aiwh(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  protected ShortVideoTransManager a;
  protected ShortVideoUpInfo a;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  protected long b;
  protected RandomAccessFile b;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected byte[] b;
  protected int c;
  private long jdField_c_of_type_Long;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private byte[] d;
  int w = -1;
  int x = 0;
  private int y;
  
  public ShortVideoForwardProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    String[] arrayOfString;
    for (this.w = ((MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.w = 0)
    {
      paramTransFileController = paramTransferRequest.jdField_i_of_type_JavaLangString;
      arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      b(9304, "path =" + paramTransFileController);
      d();
      this.o = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    paramTransferRequest.jdField_i_of_type_JavaLangString = arrayOfString[0];
    this.jdField_a_of_type_JavaLangString = arrayOfString[1];
    this.jdField_c_of_type_Int = Integer.parseInt(arrayOfString[2]);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private RichProto.RichProtoReq.ShortVideoForwardReq a()
  {
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = new RichProto.RichProtoReq.ShortVideoForwardReq();
    localShortVideoForwardReq.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localShortVideoForwardReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoForwardReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoForwardReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoForwardReq.jdField_l_of_type_Int = 0;
    localShortVideoForwardReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoForwardReq.jdField_e_of_type_Int = 2;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoForwardInfo)))
    {
      localObject = (ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      localShortVideoForwardReq.jdField_a_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_c_of_type_Int;
      localShortVideoForwardReq.jdField_b_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_d_of_type_Int;
      localShortVideoForwardReq.jdField_c_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_e_of_type_Int;
      localShortVideoForwardReq.jdField_d_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_f_of_type_Int;
      this.w = localShortVideoForwardReq.jdField_c_of_type_Int;
      int i = ((ShortVideoForwardInfo)localObject).jdField_j_of_type_Int;
      this.jdField_c_of_type_Int = i;
      localShortVideoForwardReq.k = i;
      localShortVideoForwardReq.jdField_f_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).jdField_a_of_type_JavaLangString;
      localShortVideoForwardReq.jdField_a_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).k;
      localShortVideoForwardReq.jdField_j_of_type_Int = ((ShortVideoForwardInfo)localObject).jdField_l_of_type_Int;
      localShortVideoForwardReq.jdField_g_of_type_JavaLangString = ((ShortVideoForwardInfo)localObject).jdField_l_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(localShortVideoForwardReq.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromChatType", String.valueOf(localShortVideoForwardReq.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toChatType", String.valueOf(localShortVideoForwardReq.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromBusiType", String.valueOf(localShortVideoForwardReq.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toBusiType", String.valueOf(localShortVideoForwardReq.jdField_d_of_type_Int));
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
        localShortVideoForwardReq.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      localShortVideoForwardReq.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      localShortVideoForwardReq.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localShortVideoForwardReq.i = this.jdField_a_of_type_Int;
      localShortVideoForwardReq.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      if (localShortVideoForwardReq.jdField_a_of_type_JavaLangString != null) {
        break label414;
      }
    }
    label414:
    for (Object localObject = "";; localObject = localShortVideoForwardReq.jdField_a_of_type_JavaLangString)
    {
      localShortVideoForwardReq.jdField_a_of_type_JavaLangString = ((String)localObject);
      localShortVideoForwardReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localShortVideoForwardReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      return localShortVideoForwardReq;
      b("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        }
        if (this.jdField_f_of_type_JavaLangString != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          if (this.jdField_b_of_type_ArrayOfByte != null) {
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
          }
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_file_size.set((int)this.jdField_c_of_type_Long);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
          }
          Object localObject3 = new videoFile.ResvAttr();
          if ((localObject1 != null) && (((MessageForShortVideo)localObject1).CheckIsHotVideo()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "constructRichText MessageForHotVideo ");
            }
            ((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoIconUrl));
            ((videoFile.ResvAttr)localObject3).bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoTitle));
            ((videoFile.ResvAttr)localObject3).bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoUrl));
            ((videoFile.ResvAttr)localObject3).bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).hotVideoSubIconUrl));
            ((videoFile.ResvAttr)localObject3).uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
          }
          if (localObject1 != null)
          {
            ((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
            if (((MessageForShortVideo)localObject1).CheckIsDanceVideo()) {
              ((videoFile.ResvAttr)localObject3).uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
            }
          }
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(this.y);
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
      }
      catch (Exception localException)
      {
        b("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.c.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = 0L;
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
    paramArrayOfByte = new StringBuilder(512);
    localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject2).jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_Int);
    }
    paramArrayOfByte.append("/qqupload?ver=");
    paramArrayOfByte.append("3615");
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
        QLog.d("ShortVideoForwardProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoForwardProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
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
    b("getConnUrl", "url = " + paramArrayOfByte.toString());
    return paramArrayOfByte.toString();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.o) || (this.jdField_k_of_type_Boolean)) {
      return;
    }
    b("onResp", "result:" + paramNetResp.jdField_a_of_type_Int + " errCode:" + paramNetResp.jdField_b_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
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
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---- HttpMsg.RANGE:" + (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---- userRetCode:" + l2 + "----mUpBrokenTransferRetryCount=" + this.x);
          }
          if ((l2 == 0L) || (l2 == 9223372036854775807L)) {
            break label415;
          }
          if (-5103065L != l2) {
            break label373;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.jdField_s_of_type_Long = 0L;
          if (this.x >= 3) {
            break;
          }
          ap_();
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
    label373:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(-9527, null, a(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    label415:
    long l1;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      this.jdField_l_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = 9223372036854775807L;
        if (l1 != 9223372036854775807L) {
          break label1169;
        }
        Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
        if (localObject == null) {
          break label1169;
        }
      }
    }
    label1169:
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
            QLog.d("ShortVideoForwardProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = l1;
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
          ap_();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l2);
        a(-9527, "", a(this.jdField_i_of_type_JavaLangString, this.jdField_f_of_type_Int), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "sendFile() success.");
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
        f();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.jdField_b_of_type_Int)))
      {
        this.jdField_d_of_type_Boolean = true;
        m();
        ap_();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      b(paramNetResp.jdField_b_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
  }
  
  /* Error */
  public void a(RichProto.RichProtoReq paramRichProtoReq, com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp paramRichProtoResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 788	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;
    //   5: aload_2
    //   6: ifnull +384 -> 390
    //   9: iconst_0
    //   10: istore 4
    //   12: iload 4
    //   14: aload_2
    //   15: getfield 793	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   18: invokeinterface 798 1 0
    //   23: if_icmpge +367 -> 390
    //   26: aload_2
    //   27: getfield 793	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   30: iload 4
    //   32: invokeinterface 799 2 0
    //   37: checkcast 801	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp
    //   40: astore 8
    //   42: aload_0
    //   43: ldc_w 803
    //   46: aload 8
    //   48: invokevirtual 804	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:toString	()Ljava/lang/String;
    //   51: invokevirtual 257	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 806	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   59: aload 8
    //   61: invokevirtual 809	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   64: aload_0
    //   65: aload 8
    //   67: getfield 810	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: putfield 287	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   73: aload_0
    //   74: aload 8
    //   76: getfield 811	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: putfield 562	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   82: aload 8
    //   84: getfield 812	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_c_of_type_Int	I
    //   87: ifne +1558 -> 1645
    //   90: aload_0
    //   91: aload 8
    //   93: getfield 813	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Int	I
    //   96: putfield 438	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:y	I
    //   99: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +33 -> 135
    //   105: ldc 86
    //   107: iconst_2
    //   108: new 88	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 815
    //   118: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 8
    //   123: getfield 813	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Int	I
    //   126: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload 8
    //   137: getfield 816	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Boolean	Z
    //   140: ifeq +44 -> 184
    //   143: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +12 -> 158
    //   149: ldc 86
    //   151: iconst_2
    //   152: ldc_w 818
    //   155: invokestatic 820	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 33	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Boolean	Z
    //   163: aload_0
    //   164: sipush 1007
    //   167: invokevirtual 763	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(I)V
    //   170: aload_0
    //   171: iconst_1
    //   172: invokevirtual 765	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(Z)V
    //   175: iload 4
    //   177: iconst_1
    //   178: iadd
    //   179: istore 4
    //   181: goto -169 -> 12
    //   184: aload_0
    //   185: getfield 29	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:w	I
    //   188: ifne +285 -> 473
    //   191: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +35 -> 229
    //   197: ldc 86
    //   199: iconst_2
    //   200: new 88	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 822
    //   210: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   217: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   220: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 820	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: new 824	android/media/MediaPlayer
    //   232: dup
    //   233: invokespecial 825	android/media/MediaPlayer:<init>	()V
    //   236: astore 7
    //   238: new 827	java/io/FileInputStream
    //   241: dup
    //   242: aload_0
    //   243: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   246: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   249: invokespecial 830	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   252: astore_1
    //   253: aload 7
    //   255: aload_1
    //   256: invokevirtual 834	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   259: invokevirtual 838	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   262: aload 7
    //   264: invokevirtual 841	android/media/MediaPlayer:prepare	()V
    //   267: aload 7
    //   269: ifnull +8 -> 277
    //   272: aload 7
    //   274: invokevirtual 844	android/media/MediaPlayer:release	()V
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 847	java/io/FileInputStream:close	()V
    //   285: iconst_0
    //   286: istore_3
    //   287: iload_3
    //   288: ifeq +185 -> 473
    //   291: invokestatic 851	com/tencent/mobileqq/shortvideo/ShortVideoUtils:d	()Z
    //   294: ifeq +179 -> 473
    //   297: aload_0
    //   298: sipush 9305
    //   301: ldc_w 853
    //   304: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   307: aload_0
    //   308: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   311: new 210	java/util/HashMap
    //   314: dup
    //   315: invokespecial 854	java/util/HashMap:<init>	()V
    //   318: astore_1
    //   319: aload_1
    //   320: getstatic 859	com/tencent/qphone/base/BaseConstants:RDM_NoChangeFailCode	Ljava/lang/String;
    //   323: ldc 246
    //   325: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 861
    //   333: aload_0
    //   334: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   337: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   340: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   343: pop
    //   344: aload_1
    //   345: ldc_w 863
    //   348: aload_0
    //   349: getfield 864	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   355: pop
    //   356: aload_1
    //   357: ldc_w 866
    //   360: aload_0
    //   361: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   364: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   367: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   370: pop
    //   371: invokestatic 528	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   374: invokestatic 871	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   377: aconst_null
    //   378: ldc_w 873
    //   381: iconst_1
    //   382: lconst_0
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc 246
    //   387: invokevirtual 876	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   390: return
    //   391: astore_1
    //   392: iconst_0
    //   393: istore_3
    //   394: goto -107 -> 287
    //   397: astore_1
    //   398: aconst_null
    //   399: astore 7
    //   401: aconst_null
    //   402: astore_1
    //   403: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +12 -> 418
    //   409: ldc 86
    //   411: iconst_2
    //   412: ldc_w 878
    //   415: invokestatic 820	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload 7
    //   420: ifnull +8 -> 428
    //   423: aload 7
    //   425: invokevirtual 844	android/media/MediaPlayer:release	()V
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 847	java/io/FileInputStream:close	()V
    //   436: iconst_1
    //   437: istore_3
    //   438: goto -151 -> 287
    //   441: astore_1
    //   442: iconst_1
    //   443: istore_3
    //   444: goto -157 -> 287
    //   447: astore_2
    //   448: aconst_null
    //   449: astore 7
    //   451: aconst_null
    //   452: astore_1
    //   453: aload 7
    //   455: ifnull +8 -> 463
    //   458: aload 7
    //   460: invokevirtual 844	android/media/MediaPlayer:release	()V
    //   463: aload_1
    //   464: ifnull +7 -> 471
    //   467: aload_1
    //   468: invokevirtual 847	java/io/FileInputStream:close	()V
    //   471: aload_2
    //   472: athrow
    //   473: aload_0
    //   474: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   477: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   480: ifnull +408 -> 888
    //   483: aload_0
    //   484: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   487: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   490: invokevirtual 233	java/lang/String:length	()I
    //   493: ifle +395 -> 888
    //   496: aload_0
    //   497: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   500: ifnull +11 -> 511
    //   503: aload_0
    //   504: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   507: arraylength
    //   508: ifne +20 -> 528
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   516: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokestatic 885	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   522: invokestatic 135	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   525: putfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   528: new 887	java/io/File
    //   531: dup
    //   532: aload_0
    //   533: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   536: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   539: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   542: astore_1
    //   543: aload_1
    //   544: invokevirtual 891	java/io/File:exists	()Z
    //   547: ifeq +326 -> 873
    //   550: aload_1
    //   551: invokevirtual 893	java/io/File:length	()J
    //   554: lconst_0
    //   555: lcmp
    //   556: ifle +317 -> 873
    //   559: aload_0
    //   560: aload_1
    //   561: invokevirtual 893	java/io/File:length	()J
    //   564: putfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   567: aload_0
    //   568: aload_1
    //   569: invokevirtual 896	java/io/File:getName	()Ljava/lang/String;
    //   572: putfield 229	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   575: aload_0
    //   576: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   579: ifnull +339 -> 918
    //   582: aload_0
    //   583: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   586: invokevirtual 233	java/lang/String:length	()I
    //   589: ifle +329 -> 918
    //   592: aload_0
    //   593: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   596: ifnull +11 -> 607
    //   599: aload_0
    //   600: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   603: arraylength
    //   604: ifne +17 -> 621
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   612: invokestatic 885	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   615: invokestatic 135	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   618: putfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   621: new 887	java/io/File
    //   624: dup
    //   625: aload_0
    //   626: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   629: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   632: astore_1
    //   633: aload_1
    //   634: invokevirtual 891	java/io/File:exists	()Z
    //   637: ifeq +266 -> 903
    //   640: aload_1
    //   641: invokevirtual 893	java/io/File:length	()J
    //   644: lconst_0
    //   645: lcmp
    //   646: ifle +257 -> 903
    //   649: aload_0
    //   650: aload_1
    //   651: invokevirtual 893	java/io/File:length	()J
    //   654: putfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   657: aload_0
    //   658: aload_0
    //   659: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   662: invokevirtual 900	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(Ljava/lang/String;)V
    //   665: aload_0
    //   666: aload_0
    //   667: getfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   670: aload_0
    //   671: getfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   674: ladd
    //   675: putfield 517	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_q_of_type_Long	J
    //   678: aload_0
    //   679: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   682: ifnull +251 -> 933
    //   685: aload_0
    //   686: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   689: arraylength
    //   690: ifle +243 -> 933
    //   693: aload_0
    //   694: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   697: ifnull +236 -> 933
    //   700: aload_0
    //   701: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   704: arraylength
    //   705: ifle +228 -> 933
    //   708: aload_0
    //   709: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   712: ifnull +221 -> 933
    //   715: aload_0
    //   716: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   719: arraylength
    //   720: ifle +213 -> 933
    //   723: aload_0
    //   724: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   727: ifnull +206 -> 933
    //   730: aload_0
    //   731: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   734: arraylength
    //   735: ifle +198 -> 933
    //   738: aload_0
    //   739: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   742: aload_0
    //   743: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   746: invokestatic 904	java/util/Arrays:equals	([B[B)Z
    //   749: ifeq +17 -> 766
    //   752: aload_0
    //   753: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   756: aload_0
    //   757: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   760: invokestatic 904	java/util/Arrays:equals	([B[B)Z
    //   763: ifne +170 -> 933
    //   766: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   769: ifeq +83 -> 852
    //   772: ldc 86
    //   774: iconst_2
    //   775: new 88	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 906
    //   785: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_0
    //   789: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   792: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   795: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: ldc_w 911
    //   801: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_0
    //   805: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   808: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   811: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 913
    //   817: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   824: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   827: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: ldc_w 915
    //   833: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_0
    //   837: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   840: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   843: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: aload_0
    //   853: aload_0
    //   854: getfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   857: putfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   860: aload_0
    //   861: aload_0
    //   862: getfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   865: putfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   868: aload_0
    //   869: invokevirtual 776	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:f	()V
    //   872: return
    //   873: aload_0
    //   874: sipush 9042
    //   877: ldc_w 917
    //   880: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   883: aload_0
    //   884: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   887: return
    //   888: aload_0
    //   889: sipush 9302
    //   892: ldc_w 919
    //   895: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   898: aload_0
    //   899: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   902: return
    //   903: aload_0
    //   904: sipush 9042
    //   907: ldc_w 921
    //   910: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   913: aload_0
    //   914: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   917: return
    //   918: aload_0
    //   919: sipush 9302
    //   922: ldc_w 923
    //   925: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   928: aload_0
    //   929: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   932: return
    //   933: aload_0
    //   934: getfield 482	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   937: astore_1
    //   938: aload_0
    //   939: getfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   942: aload_0
    //   943: getfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   946: ladd
    //   947: lstore 5
    //   949: aload_0
    //   950: lload 5
    //   952: putfield 517	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_q_of_type_Long	J
    //   955: aload_1
    //   956: lload 5
    //   958: putfield 924	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   961: aload_0
    //   962: aload 8
    //   964: getfield 925	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Long	J
    //   967: putfield 927	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_r_of_type_Long	J
    //   970: aload_0
    //   971: aload 8
    //   973: getfield 928	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   976: putfield 584	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   979: aload_0
    //   980: getfield 931	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:v	I
    //   983: iconst_2
    //   984: if_icmpne +236 -> 1220
    //   987: aload_0
    //   988: ldc_w 933
    //   991: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   994: aload_0
    //   995: aload 8
    //   997: getfield 936	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Long	J
    //   1000: putfield 739	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Long	J
    //   1003: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1006: ifeq +93 -> 1099
    //   1009: ldc 86
    //   1011: iconst_2
    //   1012: new 88	java/lang/StringBuilder
    //   1015: dup
    //   1016: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1019: ldc_w 938
    //   1022: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: aload_0
    //   1026: getfield 562	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1029: invokevirtual 941	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1032: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1038: ldc 86
    //   1040: iconst_2
    //   1041: new 88	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 943
    //   1051: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload_0
    //   1055: getfield 739	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Long	J
    //   1058: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: ldc 86
    //   1069: iconst_2
    //   1070: new 88	java/lang/StringBuilder
    //   1073: dup
    //   1074: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1077: ldc_w 945
    //   1080: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload_0
    //   1084: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1087: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1090: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: aload_0
    //   1100: aload_0
    //   1101: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1104: bipush 66
    //   1106: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1109: checkcast 664	com/tencent/mobileqq/app/ShortVideoTransManager
    //   1112: putfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1115: aload_0
    //   1116: getfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1119: ifnull +54 -> 1173
    //   1122: aload_0
    //   1123: aload_0
    //   1124: getfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1127: new 88	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1134: aload_0
    //   1135: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1138: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1141: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: aload_0
    //   1145: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1148: getfield 152	com/tencent/mobileqq/transfile/TransferRequest:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1151: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload_0
    //   1155: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1158: getfield 144	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1161: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1164: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: invokevirtual 734	com/tencent/mobileqq/app/ShortVideoTransManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1170: putfield 595	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1173: aload_0
    //   1174: lconst_0
    //   1175: putfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_s_of_type_Long	J
    //   1178: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1181: ifeq +32 -> 1213
    //   1184: ldc 86
    //   1186: iconst_2
    //   1187: new 88	java/lang/StringBuilder
    //   1190: dup
    //   1191: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1194: ldc_w 947
    //   1197: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload_0
    //   1201: getfield 595	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1204: invokevirtual 941	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1213: aload_0
    //   1214: invokevirtual 670	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:ap_	()V
    //   1217: goto -1042 -> 175
    //   1220: aload_0
    //   1221: getfield 931	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:v	I
    //   1224: ifne +371 -> 1595
    //   1227: aload_0
    //   1228: ldc_w 949
    //   1231: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   1234: aload 8
    //   1236: getfield 951	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1239: ifne +10 -> 1249
    //   1242: aload_0
    //   1243: ldc_w 953
    //   1246: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   1249: aconst_null
    //   1250: astore_1
    //   1251: aconst_null
    //   1252: astore 7
    //   1254: ldc_w 955
    //   1257: monitorenter
    //   1258: aload_0
    //   1259: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1262: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1265: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1268: invokevirtual 962	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1271: ifnull +42 -> 1313
    //   1274: aload_0
    //   1275: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1278: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1281: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1284: invokevirtual 962	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1287: arraylength
    //   1288: istore_3
    //   1289: iload_3
    //   1290: newarray byte
    //   1292: astore_1
    //   1293: aload_0
    //   1294: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1297: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1300: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1303: invokevirtual 962	com/tencent/mobileqq/highway/openup/SessionInfo:getHttpconn_sig_session	()[B
    //   1306: iconst_0
    //   1307: aload_1
    //   1308: iconst_0
    //   1309: iload_3
    //   1310: invokestatic 966	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1313: aload_0
    //   1314: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1317: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1320: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1323: invokevirtual 969	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1326: ifnull +44 -> 1370
    //   1329: aload_0
    //   1330: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1333: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1336: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1339: invokevirtual 969	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1342: arraylength
    //   1343: istore_3
    //   1344: iload_3
    //   1345: newarray byte
    //   1347: astore 7
    //   1349: aload_0
    //   1350: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1353: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1356: invokestatic 959	com/tencent/mobileqq/highway/openup/SessionInfo:getInstance	(Ljava/lang/String;)Lcom/tencent/mobileqq/highway/openup/SessionInfo;
    //   1359: invokevirtual 969	com/tencent/mobileqq/highway/openup/SessionInfo:getSessionKey	()[B
    //   1362: iconst_0
    //   1363: aload 7
    //   1365: iconst_0
    //   1366: iload_3
    //   1367: invokestatic 966	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1370: ldc_w 955
    //   1373: monitorexit
    //   1374: aload 8
    //   1376: getfield 951	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1379: ifeq +52 -> 1431
    //   1382: aload_1
    //   1383: ifnull +48 -> 1431
    //   1386: aload_1
    //   1387: arraylength
    //   1388: ifle +43 -> 1431
    //   1391: aload 7
    //   1393: ifnull +38 -> 1431
    //   1396: aload 7
    //   1398: arraylength
    //   1399: ifle +32 -> 1431
    //   1402: aload_0
    //   1403: ldc_w 971
    //   1406: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   1409: aload_0
    //   1410: iconst_1
    //   1411: putfield 931	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:v	I
    //   1414: aload_0
    //   1415: aload_1
    //   1416: aload 7
    //   1418: invokevirtual 974	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	([B[B)V
    //   1421: goto -1246 -> 175
    //   1424: astore_1
    //   1425: ldc_w 955
    //   1428: monitorexit
    //   1429: aload_1
    //   1430: athrow
    //   1431: aload 8
    //   1433: getfield 951	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_b_of_type_Boolean	Z
    //   1436: ifeq +17 -> 1453
    //   1439: aload_0
    //   1440: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1443: aload_0
    //   1444: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1447: getfield 149	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1450: invokestatic 980	com/tencent/mobileqq/highway/config/HwServlet:getConfig	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   1453: aload_0
    //   1454: ldc_w 982
    //   1457: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   1460: aload_0
    //   1461: iconst_2
    //   1462: putfield 931	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:v	I
    //   1465: aload_0
    //   1466: aload 8
    //   1468: getfield 936	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$ShortVideoForwardResp:jdField_a_of_type_Long	J
    //   1471: putfield 739	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Long	J
    //   1474: aload_0
    //   1475: aload_0
    //   1476: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1479: bipush 66
    //   1481: invokevirtual 731	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1484: checkcast 664	com/tencent/mobileqq/app/ShortVideoTransManager
    //   1487: putfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1490: aload_0
    //   1491: getfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1494: ifnull +54 -> 1548
    //   1497: aload_0
    //   1498: aload_0
    //   1499: getfield 661	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager	Lcom/tencent/mobileqq/app/ShortVideoTransManager;
    //   1502: new 88	java/lang/StringBuilder
    //   1505: dup
    //   1506: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1509: aload_0
    //   1510: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1513: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1516: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload_0
    //   1520: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1523: getfield 152	com/tencent/mobileqq/transfile/TransferRequest:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1526: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: aload_0
    //   1530: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1533: getfield 144	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1536: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: invokevirtual 734	com/tencent/mobileqq/app/ShortVideoTransManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1545: putfield 595	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1548: aload_0
    //   1549: lconst_0
    //   1550: putfield 531	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_s_of_type_Long	J
    //   1553: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1556: ifeq +32 -> 1588
    //   1559: ldc 86
    //   1561: iconst_2
    //   1562: new 88	java/lang/StringBuilder
    //   1565: dup
    //   1566: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1569: ldc_w 947
    //   1572: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: aload_0
    //   1576: getfield 595	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo	Lcom/tencent/mobileqq/data/ShortVideoUpInfo;
    //   1579: invokevirtual 941	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1582: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1588: aload_0
    //   1589: invokevirtual 670	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:ap_	()V
    //   1592: goto -1417 -> 175
    //   1595: new 88	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1602: ldc_w 984
    //   1605: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1608: astore 7
    //   1610: aload_0
    //   1611: getfield 931	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:v	I
    //   1614: iconst_1
    //   1615: if_icmpne +23 -> 1638
    //   1618: ldc_w 986
    //   1621: astore_1
    //   1622: aload_0
    //   1623: aload 7
    //   1625: aload_1
    //   1626: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1632: invokevirtual 935	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(Ljava/lang/String;)V
    //   1635: goto -1460 -> 175
    //   1638: ldc_w 988
    //   1641: astore_1
    //   1642: goto -20 -> 1622
    //   1645: ldc_w 989
    //   1648: aload_0
    //   1649: getfield 990	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_j_of_type_Int	I
    //   1652: if_icmpne +43 -> 1695
    //   1655: aload_0
    //   1656: ldc_w 989
    //   1659: new 88	java/lang/StringBuilder
    //   1662: dup
    //   1663: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1666: ldc_w 992
    //   1669: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: aload_0
    //   1673: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1676: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1679: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1685: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   1688: aload_0
    //   1689: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   1692: goto -1517 -> 175
    //   1695: aload_0
    //   1696: sipush 9045
    //   1699: ldc_w 994
    //   1702: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   1705: goto -17 -> 1688
    //   1708: astore_1
    //   1709: goto -1238 -> 471
    //   1712: astore_2
    //   1713: aconst_null
    //   1714: astore_1
    //   1715: goto -1262 -> 453
    //   1718: astore_2
    //   1719: goto -1266 -> 453
    //   1722: astore_2
    //   1723: goto -1270 -> 453
    //   1726: astore_1
    //   1727: aconst_null
    //   1728: astore_1
    //   1729: goto -1326 -> 403
    //   1732: astore 9
    //   1734: goto -1331 -> 403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1737	0	this	ShortVideoForwardProcessor
    //   0	1737	1	paramRichProtoReq	RichProto.RichProtoReq
    //   0	1737	2	paramRichProtoResp	com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp
    //   286	1081	3	i	int
    //   10	170	4	j	int
    //   947	10	5	l	long
    //   236	1388	7	localObject	Object
    //   40	1427	8	localShortVideoForwardResp	com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoForwardResp
    //   1732	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   272	277	391	java/lang/Exception
    //   281	285	391	java/lang/Exception
    //   229	238	397	java/lang/Exception
    //   423	428	441	java/lang/Exception
    //   432	436	441	java/lang/Exception
    //   229	238	447	finally
    //   1258	1313	1424	finally
    //   1313	1370	1424	finally
    //   1370	1374	1424	finally
    //   1425	1429	1424	finally
    //   458	463	1708	java/lang/Exception
    //   467	471	1708	java/lang/Exception
    //   238	253	1712	finally
    //   253	267	1718	finally
    //   403	418	1722	finally
    //   238	253	1726	java/lang/Exception
    //   253	267	1732	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {}
    while ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0))) {
      return;
    }
    int j = this.jdField_m_of_type_Int;
    int i;
    String str1;
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      str1 = "actShortVideoForward";
      if (this.v == 1) {
        str1 = "actShortVideoForwardBDH";
      }
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label502;
      }
      str2 = this.jdField_g_of_type_JavaLangString;
      label194:
      localHashMap.put("param_uuid", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.w + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_a_of_type_Boolean + "");
      if (!paramBoolean) {
        break label511;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L + ", richTag = " + str1);
      return;
      i = 1;
      break;
      label502:
      str2 = this.jdField_f_of_type_JavaLangString;
      break label194;
      label511:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 86
    //   8: iconst_2
    //   9: new 88	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 1107
    //   19: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 941	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 675	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   36: invokevirtual 1108	com/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo:a	()V
    //   39: aload_0
    //   40: getfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   43: ifnull +4 -> 47
    //   46: return
    //   47: aload_0
    //   48: getfield 1113	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   51: ifnonnull +61 -> 112
    //   54: aload_0
    //   55: new 1115	java/io/RandomAccessFile
    //   58: dup
    //   59: aload_0
    //   60: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   63: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   66: ldc_w 1116
    //   69: invokespecial 1118	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: putfield 1113	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   75: aload_0
    //   76: getfield 1113	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   79: ifnonnull +33 -> 112
    //   82: aload_0
    //   83: sipush 9303
    //   86: ldc_w 1120
    //   89: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   96: return
    //   97: astore 11
    //   99: aload 11
    //   101: invokevirtual 1121	java/io/FileNotFoundException:printStackTrace	()V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 1113	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   109: goto -34 -> 75
    //   112: aload_0
    //   113: getfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   116: ifnonnull +58 -> 174
    //   119: aload_0
    //   120: new 1115	java/io/RandomAccessFile
    //   123: dup
    //   124: aload_0
    //   125: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   128: ldc_w 1116
    //   131: invokespecial 1118	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: putfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   137: aload_0
    //   138: getfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   141: ifnonnull +33 -> 174
    //   144: aload_0
    //   145: sipush 9303
    //   148: ldc_w 1125
    //   151: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   154: aload_0
    //   155: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   158: return
    //   159: astore 11
    //   161: aload 11
    //   163: invokevirtual 1121	java/io/FileNotFoundException:printStackTrace	()V
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   171: goto -34 -> 137
    //   174: invokestatic 1130	android/os/SystemClock:uptimeMillis	()J
    //   177: lstore 4
    //   179: aload_0
    //   180: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   183: arraylength
    //   184: aload_0
    //   185: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   188: arraylength
    //   189: iadd
    //   190: newarray byte
    //   192: astore 11
    //   194: aload_0
    //   195: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   198: iconst_0
    //   199: aload 11
    //   201: iconst_0
    //   202: aload_0
    //   203: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   206: arraylength
    //   207: invokestatic 966	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   210: aload_0
    //   211: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   214: iconst_0
    //   215: aload 11
    //   217: aload_0
    //   218: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   221: arraylength
    //   222: aload_0
    //   223: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   226: arraylength
    //   227: invokestatic 966	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   230: new 88	java/lang/StringBuilder
    //   233: dup
    //   234: invokestatic 1132	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   237: invokespecial 1133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 11
    //   242: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   245: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 1135
    //   251: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 16
    //   259: aconst_null
    //   260: astore 12
    //   262: invokestatic 1130	android/os/SystemClock:uptimeMillis	()J
    //   265: lstore 6
    //   267: new 887	java/io/File
    //   270: dup
    //   271: aload 16
    //   273: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: invokevirtual 1138	java/io/File:delete	()Z
    //   279: pop
    //   280: new 887	java/io/File
    //   283: dup
    //   284: aload 16
    //   286: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 11
    //   291: aload 11
    //   293: invokevirtual 891	java/io/File:exists	()Z
    //   296: istore 10
    //   298: iload 10
    //   300: ifne +9 -> 309
    //   303: aload 11
    //   305: invokevirtual 1141	java/io/File:createNewFile	()Z
    //   308: pop
    //   309: new 1143	java/io/FileOutputStream
    //   312: dup
    //   313: aload 11
    //   315: invokespecial 1146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   318: astore 11
    //   320: new 1148	java/io/BufferedOutputStream
    //   323: dup
    //   324: aload 11
    //   326: invokespecial 1151	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   329: astore 12
    //   331: aload 12
    //   333: astore 14
    //   335: aload 11
    //   337: astore 13
    //   339: aload_0
    //   340: getfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   343: invokevirtual 1152	java/io/RandomAccessFile:length	()J
    //   346: l2i
    //   347: newarray byte
    //   349: astore 15
    //   351: aload 12
    //   353: astore 14
    //   355: aload 11
    //   357: astore 13
    //   359: aload_0
    //   360: getfield 1123	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   363: aload 15
    //   365: invokevirtual 1156	java/io/RandomAccessFile:read	([B)I
    //   368: pop
    //   369: aload 12
    //   371: astore 14
    //   373: aload 11
    //   375: astore 13
    //   377: aload 12
    //   379: aload 15
    //   381: invokevirtual 1160	java/io/BufferedOutputStream:write	([B)V
    //   384: aload 12
    //   386: astore 14
    //   388: aload 11
    //   390: astore 13
    //   392: ldc_w 1161
    //   395: newarray byte
    //   397: astore 15
    //   399: aload 12
    //   401: astore 14
    //   403: aload 11
    //   405: astore 13
    //   407: aload_0
    //   408: getfield 1113	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   411: aload 15
    //   413: invokevirtual 1156	java/io/RandomAccessFile:read	([B)I
    //   416: istore_3
    //   417: iload_3
    //   418: iconst_m1
    //   419: if_icmpeq +102 -> 521
    //   422: aload 12
    //   424: astore 14
    //   426: aload 11
    //   428: astore 13
    //   430: aload 12
    //   432: aload 15
    //   434: iconst_0
    //   435: iload_3
    //   436: invokevirtual 1164	java/io/BufferedOutputStream:write	([BII)V
    //   439: goto -40 -> 399
    //   442: astore 13
    //   444: aload 13
    //   446: invokevirtual 1121	java/io/FileNotFoundException:printStackTrace	()V
    //   449: aload 12
    //   451: ifnull +8 -> 459
    //   454: aload 12
    //   456: invokevirtual 1165	java/io/BufferedOutputStream:close	()V
    //   459: aload 11
    //   461: ifnull +8 -> 469
    //   464: aload 11
    //   466: invokevirtual 1166	java/io/FileOutputStream:close	()V
    //   469: aload_0
    //   470: invokespecial 1168	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	()Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq;
    //   473: astore 12
    //   475: aload 12
    //   477: ifnonnull +253 -> 730
    //   480: aload_0
    //   481: sipush 9302
    //   484: ldc_w 1170
    //   487: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   490: aload_0
    //   491: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   494: return
    //   495: astore 13
    //   497: aload 13
    //   499: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   502: goto -193 -> 309
    //   505: astore 13
    //   507: aconst_null
    //   508: astore 14
    //   510: aload 12
    //   512: astore 11
    //   514: aload 14
    //   516: astore 12
    //   518: goto -74 -> 444
    //   521: aload 12
    //   523: astore 14
    //   525: aload 11
    //   527: astore 13
    //   529: invokestatic 1130	android/os/SystemClock:uptimeMillis	()J
    //   532: lstore 8
    //   534: aload 12
    //   536: astore 14
    //   538: aload 11
    //   540: astore 13
    //   542: aload_0
    //   543: getfield 202	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   546: ldc_w 1173
    //   549: lload 8
    //   551: lload 6
    //   553: lsub
    //   554: invokestatic 1036	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   557: invokevirtual 214	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   560: pop
    //   561: aload 12
    //   563: ifnull +8 -> 571
    //   566: aload 12
    //   568: invokevirtual 1165	java/io/BufferedOutputStream:close	()V
    //   571: aload 11
    //   573: ifnull -104 -> 469
    //   576: aload 11
    //   578: invokevirtual 1166	java/io/FileOutputStream:close	()V
    //   581: goto -112 -> 469
    //   584: astore 11
    //   586: aload 11
    //   588: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   591: goto -122 -> 469
    //   594: astore 12
    //   596: aload 12
    //   598: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   601: goto -30 -> 571
    //   604: astore 12
    //   606: aload 12
    //   608: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   611: goto -152 -> 459
    //   614: astore 11
    //   616: aload 11
    //   618: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   621: goto -152 -> 469
    //   624: astore 15
    //   626: aconst_null
    //   627: astore 11
    //   629: aconst_null
    //   630: astore 12
    //   632: aload 12
    //   634: astore 14
    //   636: aload 11
    //   638: astore 13
    //   640: aload 15
    //   642: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   645: aload 12
    //   647: ifnull +8 -> 655
    //   650: aload 12
    //   652: invokevirtual 1165	java/io/BufferedOutputStream:close	()V
    //   655: aload 11
    //   657: ifnull -188 -> 469
    //   660: aload 11
    //   662: invokevirtual 1166	java/io/FileOutputStream:close	()V
    //   665: goto -196 -> 469
    //   668: astore 11
    //   670: aload 11
    //   672: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   675: goto -206 -> 469
    //   678: astore 12
    //   680: aload 12
    //   682: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   685: goto -30 -> 655
    //   688: astore_1
    //   689: aconst_null
    //   690: astore 11
    //   692: aconst_null
    //   693: astore_2
    //   694: aload_2
    //   695: ifnull +7 -> 702
    //   698: aload_2
    //   699: invokevirtual 1165	java/io/BufferedOutputStream:close	()V
    //   702: aload 11
    //   704: ifnull +8 -> 712
    //   707: aload 11
    //   709: invokevirtual 1166	java/io/FileOutputStream:close	()V
    //   712: aload_1
    //   713: athrow
    //   714: astore_2
    //   715: aload_2
    //   716: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   719: goto -17 -> 702
    //   722: astore_2
    //   723: aload_2
    //   724: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   727: goto -15 -> 712
    //   730: new 1175	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   733: dup
    //   734: invokespecial 1176	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   737: astore 13
    //   739: aload 13
    //   741: iconst_1
    //   742: invokevirtual 1177	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   745: aload 13
    //   747: getfield 1181	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   750: aload_0
    //   751: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   754: invokevirtual 1184	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   757: invokestatic 684	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   760: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   763: aload 13
    //   765: getfield 1192	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   768: aload 12
    //   770: getfield 154	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   773: invokestatic 684	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   776: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   779: aload 13
    //   781: getfield 1195	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   784: aload 12
    //   786: getfield 177	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_Int	I
    //   789: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   792: aload 13
    //   794: getfield 1198	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   797: aload 12
    //   799: getfield 166	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_e_of_type_Int	I
    //   802: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   805: aload 12
    //   807: getfield 163	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   810: ifnull +514 -> 1324
    //   813: aload 13
    //   815: getfield 1201	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   818: aload 12
    //   820: getfield 163	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   823: invokestatic 684	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   826: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   829: aload 13
    //   831: getfield 1204	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   834: aload 12
    //   836: getfield 162	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_l_of_type_Int	I
    //   839: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   842: aload 13
    //   844: getfield 1207	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   847: aload 12
    //   849: getfield 181	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_d_of_type_Int	I
    //   852: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   855: new 1209	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   858: dup
    //   859: invokespecial 1210	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   862: astore 14
    //   864: aload 14
    //   866: getfield 1214	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   869: astore 15
    //   871: aload 12
    //   873: getfield 193	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   876: ifnonnull +460 -> 1336
    //   879: ldc 246
    //   881: astore 11
    //   883: aload 15
    //   885: aload 11
    //   887: invokevirtual 1218	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   890: aload 14
    //   892: getfield 1219	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   895: aload 12
    //   897: getfield 249	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_ArrayOfByte	[B
    //   900: invokestatic 280	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   903: invokevirtual 286	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   906: aload 14
    //   908: getfield 1220	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   911: aload 12
    //   913: getfield 250	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_ArrayOfByte	[B
    //   916: invokestatic 280	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   919: invokevirtual 286	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   922: aload 14
    //   924: getfield 1223	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   927: aload 12
    //   929: getfield 236	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_Long	J
    //   932: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   935: aload 14
    //   937: getfield 1226	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   940: aload 12
    //   942: getfield 244	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_h_of_type_Int	I
    //   945: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   948: aload 14
    //   950: getfield 1229	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   953: aload 12
    //   955: getfield 241	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:i	I
    //   958: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   961: aload 14
    //   963: getfield 1230	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   966: aload 12
    //   968: getfield 195	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_j_of_type_Int	I
    //   971: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   974: aload 14
    //   976: getfield 1231	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   979: aload 12
    //   981: getfield 187	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:k	I
    //   984: invokevirtual 308	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   987: aload 14
    //   989: getfield 1234	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   992: aload 12
    //   994: getfield 239	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_Long	J
    //   997: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1000: aload 13
    //   1002: getfield 1238	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   1005: aload 14
    //   1007: invokevirtual 1239	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   1010: aload 13
    //   1012: invokevirtual 1240	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   1015: astore 11
    //   1017: new 1242	com/tencent/qphone/base/util/Cryptor
    //   1020: dup
    //   1021: invokespecial 1243	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   1024: aload 11
    //   1026: aload_2
    //   1027: invokevirtual 1247	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   1030: astore_2
    //   1031: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1034: ifeq +69 -> 1103
    //   1037: ldc 86
    //   1039: iconst_2
    //   1040: new 88	java/lang/StringBuilder
    //   1043: dup
    //   1044: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1047: ldc_w 1249
    //   1050: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload 12
    //   1055: getfield 249	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_ArrayOfByte	[B
    //   1058: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1061: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc_w 1251
    //   1067: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload 12
    //   1072: getfield 250	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_b_of_type_ArrayOfByte	[B
    //   1075: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1078: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc_w 1253
    //   1084: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   1091: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1094: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: new 1255	aiwd
    //   1106: dup
    //   1107: aload_0
    //   1108: lload 4
    //   1110: aload 16
    //   1112: invokespecial 1258	aiwd:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoForwardProcessor;JLjava/lang/String;)V
    //   1115: astore 11
    //   1117: aload_0
    //   1118: new 1260	com/tencent/mobileqq/highway/transaction/Transaction
    //   1121: dup
    //   1122: aload_0
    //   1123: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 1184	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1129: bipush 12
    //   1131: aload 16
    //   1133: aload_0
    //   1134: getfield 927	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_r_of_type_Long	J
    //   1137: l2i
    //   1138: aload_1
    //   1139: aload_0
    //   1140: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   1143: aload 11
    //   1145: aload_2
    //   1146: invokespecial 1263	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   1149: putfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1152: new 1265	aiwg
    //   1155: dup
    //   1156: aload_0
    //   1157: invokespecial 1266	aiwg:<init>	(Lcom/tencent/mobileqq/transfile/ShortVideoForwardProcessor;)V
    //   1160: astore_1
    //   1161: aload_0
    //   1162: getfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1165: aload_1
    //   1166: putfield 1270	com/tencent/mobileqq/highway/transaction/Transaction:cbForReport	Lcom/tencent/mobileqq/highway/api/ITransCallbackForReport;
    //   1169: aload_0
    //   1170: getfield 54	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1173: invokevirtual 1274	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   1176: aload_0
    //   1177: getfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1180: invokevirtual 1280	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   1183: istore_3
    //   1184: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +114 -> 1301
    //   1190: ldc 86
    //   1192: iconst_2
    //   1193: new 88	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 1282
    //   1203: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: iload_3
    //   1207: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1210: ldc_w 1284
    //   1213: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload_0
    //   1217: getfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1220: invokevirtual 1287	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   1223: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1226: ldc_w 1289
    //   1229: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: aload_0
    //   1233: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   1236: getfield 144	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_Long	J
    //   1239: invokevirtual 591	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1242: ldc_w 1291
    //   1245: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload_0
    //   1249: getfield 1292	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1252: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: ldc_w 1294
    //   1258: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: aload_0
    //   1262: getfield 864	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1265: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: ldc_w 1296
    //   1271: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: aload_0
    //   1275: getfield 1111	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   1278: getfield 1298	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   1281: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: ldc_w 1300
    //   1287: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: bipush 12
    //   1292: invokevirtual 577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1295: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1301: iload_3
    //   1302: ifeq -1256 -> 46
    //   1305: aload_0
    //   1306: iload_3
    //   1307: ldc_w 1302
    //   1310: ldc 246
    //   1312: aload_0
    //   1313: getfield 675	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   1316: invokevirtual 678	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   1319: aload_0
    //   1320: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   1323: return
    //   1324: aload 13
    //   1326: getfield 1201	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1329: lconst_0
    //   1330: invokevirtual 1189	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1333: goto -504 -> 829
    //   1336: aload 12
    //   1338: getfield 193	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$ShortVideoForwardReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1341: astore 11
    //   1343: goto -460 -> 883
    //   1346: astore_1
    //   1347: aconst_null
    //   1348: astore_2
    //   1349: goto -655 -> 694
    //   1352: astore_1
    //   1353: aload 14
    //   1355: astore_2
    //   1356: aload 13
    //   1358: astore 11
    //   1360: goto -666 -> 694
    //   1363: astore_1
    //   1364: aload 12
    //   1366: astore_2
    //   1367: goto -673 -> 694
    //   1370: astore 15
    //   1372: aconst_null
    //   1373: astore 12
    //   1375: goto -743 -> 632
    //   1378: astore 15
    //   1380: goto -748 -> 632
    //   1383: astore 13
    //   1385: aconst_null
    //   1386: astore 12
    //   1388: goto -944 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1391	0	this	ShortVideoForwardProcessor
    //   0	1391	1	paramArrayOfByte1	byte[]
    //   0	1391	2	paramArrayOfByte2	byte[]
    //   416	891	3	i	int
    //   177	932	4	l1	long
    //   265	287	6	l2	long
    //   532	18	8	l3	long
    //   296	3	10	bool	boolean
    //   97	3	11	localFileNotFoundException1	FileNotFoundException
    //   159	3	11	localFileNotFoundException2	FileNotFoundException
    //   192	385	11	localObject1	Object
    //   584	3	11	localIOException1	IOException
    //   614	3	11	localIOException2	IOException
    //   627	34	11	localObject2	Object
    //   668	3	11	localIOException3	IOException
    //   690	669	11	localObject3	Object
    //   260	307	12	localObject4	Object
    //   594	3	12	localIOException4	IOException
    //   604	3	12	localIOException5	IOException
    //   630	21	12	localObject5	Object
    //   678	687	12	localIOException6	IOException
    //   1373	14	12	localObject6	Object
    //   337	92	13	localObject7	Object
    //   442	3	13	localFileNotFoundException3	FileNotFoundException
    //   495	3	13	localIOException7	IOException
    //   505	1	13	localFileNotFoundException4	FileNotFoundException
    //   527	830	13	localObject8	Object
    //   1383	1	13	localFileNotFoundException5	FileNotFoundException
    //   333	1021	14	localObject9	Object
    //   349	84	15	arrayOfByte	byte[]
    //   624	17	15	localIOException8	IOException
    //   869	15	15	localPBStringField	com.tencent.mobileqq.pb.PBStringField
    //   1370	1	15	localIOException9	IOException
    //   1378	1	15	localIOException10	IOException
    //   257	875	16	str	String
    // Exception table:
    //   from	to	target	type
    //   54	75	97	java/io/FileNotFoundException
    //   119	137	159	java/io/FileNotFoundException
    //   339	351	442	java/io/FileNotFoundException
    //   359	369	442	java/io/FileNotFoundException
    //   377	384	442	java/io/FileNotFoundException
    //   392	399	442	java/io/FileNotFoundException
    //   407	417	442	java/io/FileNotFoundException
    //   430	439	442	java/io/FileNotFoundException
    //   529	534	442	java/io/FileNotFoundException
    //   542	561	442	java/io/FileNotFoundException
    //   303	309	495	java/io/IOException
    //   262	298	505	java/io/FileNotFoundException
    //   303	309	505	java/io/FileNotFoundException
    //   309	320	505	java/io/FileNotFoundException
    //   497	502	505	java/io/FileNotFoundException
    //   576	581	584	java/io/IOException
    //   566	571	594	java/io/IOException
    //   454	459	604	java/io/IOException
    //   464	469	614	java/io/IOException
    //   262	298	624	java/io/IOException
    //   309	320	624	java/io/IOException
    //   497	502	624	java/io/IOException
    //   660	665	668	java/io/IOException
    //   650	655	678	java/io/IOException
    //   262	298	688	finally
    //   303	309	688	finally
    //   309	320	688	finally
    //   497	502	688	finally
    //   698	702	714	java/io/IOException
    //   707	712	722	java/io/IOException
    //   320	331	1346	finally
    //   339	351	1352	finally
    //   359	369	1352	finally
    //   377	384	1352	finally
    //   392	399	1352	finally
    //   407	417	1352	finally
    //   430	439	1352	finally
    //   529	534	1352	finally
    //   542	561	1352	finally
    //   640	645	1352	finally
    //   444	449	1363	finally
    //   320	331	1370	java/io/IOException
    //   339	351	1378	java/io/IOException
    //   359	369	1378	java/io/IOException
    //   377	384	1378	java/io/IOException
    //   392	399	1378	java/io/IOException
    //   407	417	1378	java/io/IOException
    //   430	439	1378	java/io/IOException
    //   529	534	1378	java/io/IOException
    //   542	561	1378	java/io/IOException
    //   320	331	1383	java/io/FileNotFoundException
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
  
  public void ap_()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
    {
      b(9042, "sendFile=> video file not exists");
      d();
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!FileUtils.a(this.jdField_a_of_type_JavaLangString)))
    {
      b(9303, "sendFile=> thumb file not exists");
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read video file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read thumb file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    super.ap_();
  }
  
  /* Error */
  public void ar_()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:o	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 86
    //   16: iconst_2
    //   17: ldc_w 1334
    //   20: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1336	com/tencent/mobileqq/transfile/BaseUploadProcessor:ar_	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 763	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	(I)V
    //   34: aload_0
    //   35: getfield 482	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   38: invokevirtual 766	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   41: aload_0
    //   42: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   45: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokestatic 1325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   59: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 135	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   68: aload_0
    //   69: getfield 482	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   77: getfield 662	com/tencent/mobileqq/transfile/TransferRequest:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 1337	com/tencent/mobileqq/transfile/FileMsg:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 1292	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   95: getfield 169	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: ifnull +97 -> 195
    //   101: aload_0
    //   102: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   105: getfield 169	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   108: instanceof 171
    //   111: ifeq +84 -> 195
    //   114: aload_0
    //   115: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   118: getfield 169	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   121: checkcast 171	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 1338	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:i	I
    //   130: i2l
    //   131: putfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 1339	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_m_of_type_Int	I
    //   139: i2l
    //   140: putfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 1340	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_g_of_type_Int	I
    //   148: putfield 220	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Int	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 1341	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_h_of_type_Int	I
    //   156: putfield 217	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Int	I
    //   159: aload_0
    //   160: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   163: ifnull +20 -> 183
    //   166: aload_0
    //   167: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   170: arraylength
    //   171: ifeq +12 -> 183
    //   174: aload_0
    //   175: getfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   178: lconst_0
    //   179: lcmp
    //   180: ifgt +78 -> 258
    //   183: aload_0
    //   184: invokevirtual 1343	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:e	()Z
    //   187: ifne +32 -> 219
    //   190: aload_0
    //   191: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   194: return
    //   195: aload_0
    //   196: ldc_w 1345
    //   199: ldc 254
    //   201: invokevirtual 257	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload_0
    //   205: sipush 9302
    //   208: ldc_w 1347
    //   211: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   214: aload_0
    //   215: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   218: return
    //   219: aload_0
    //   220: aload_0
    //   221: getfield 248	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   224: putfield 880	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_ArrayOfByte	[B
    //   227: new 887	java/io/File
    //   230: dup
    //   231: aload_0
    //   232: getfield 57	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   235: getfield 70	com/tencent/mobileqq/transfile/TransferRequest:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   238: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore_1
    //   242: aload_0
    //   243: aload_1
    //   244: invokevirtual 893	java/io/File:length	()J
    //   247: putfield 235	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_c_of_type_Long	J
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 896	java/io/File:getName	()Ljava/lang/String;
    //   255: putfield 229	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   258: aload_0
    //   259: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   262: ifnull +34 -> 296
    //   265: aload_0
    //   266: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   269: arraylength
    //   270: ifeq +26 -> 296
    //   273: aload_0
    //   274: getfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   277: lconst_0
    //   278: lcmp
    //   279: ifle +17 -> 296
    //   282: aload_0
    //   283: getfield 220	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Int	I
    //   286: ifle +10 -> 296
    //   289: aload_0
    //   290: getfield 217	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_Int	I
    //   293: ifgt +132 -> 425
    //   296: new 827	java/io/FileInputStream
    //   299: dup
    //   300: aload_0
    //   301: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: invokespecial 830	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   307: astore_2
    //   308: aload_2
    //   309: astore_1
    //   310: aload_0
    //   311: aload_2
    //   312: lconst_0
    //   313: invokestatic 1350	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   316: putfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   319: aload_2
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   325: ifnonnull +56 -> 381
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: sipush 9041
    //   334: new 88	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 1352
    //   344: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 107	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(ILjava/lang/String;)V
    //   360: aload_2
    //   361: astore_1
    //   362: aload_0
    //   363: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   366: aload_2
    //   367: ifnull -360 -> 7
    //   370: aload_2
    //   371: invokevirtual 847	java/io/FileInputStream:close	()V
    //   374: return
    //   375: astore_1
    //   376: aload_1
    //   377: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   380: return
    //   381: aload_2
    //   382: astore_1
    //   383: aload_0
    //   384: aload_0
    //   385: getfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   388: putfield 898	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_d_of_type_ArrayOfByte	[B
    //   391: aload_2
    //   392: ifnull +7 -> 399
    //   395: aload_2
    //   396: invokevirtual 847	java/io/FileInputStream:close	()V
    //   399: aload_0
    //   400: new 887	java/io/File
    //   403: dup
    //   404: aload_0
    //   405: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   408: invokespecial 888	java/io/File:<init>	(Ljava/lang/String;)V
    //   411: invokevirtual 893	java/io/File:length	()J
    //   414: putfield 237	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_Long	J
    //   417: aload_0
    //   418: aload_0
    //   419: getfield 121	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   422: invokevirtual 900	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:b	(Ljava/lang/String;)V
    //   425: aload_0
    //   426: invokevirtual 776	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:f	()V
    //   429: return
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   435: goto -36 -> 399
    //   438: astore_3
    //   439: aconst_null
    //   440: astore_2
    //   441: aload_2
    //   442: astore_1
    //   443: aload_0
    //   444: aconst_null
    //   445: putfield 137	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   448: aload_2
    //   449: astore_1
    //   450: aload_0
    //   451: aload_3
    //   452: invokevirtual 1319	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:a	(Ljava/io/IOException;)V
    //   455: aload_2
    //   456: astore_1
    //   457: aload_0
    //   458: invokevirtual 109	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:d	()V
    //   461: aload_2
    //   462: ifnull -455 -> 7
    //   465: aload_2
    //   466: invokevirtual 847	java/io/FileInputStream:close	()V
    //   469: return
    //   470: astore_1
    //   471: aload_1
    //   472: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   475: return
    //   476: astore_2
    //   477: aconst_null
    //   478: astore_1
    //   479: aload_1
    //   480: ifnull +7 -> 487
    //   483: aload_1
    //   484: invokevirtual 847	java/io/FileInputStream:close	()V
    //   487: aload_2
    //   488: athrow
    //   489: astore_1
    //   490: aload_1
    //   491: invokevirtual 1171	java/io/IOException:printStackTrace	()V
    //   494: goto -7 -> 487
    //   497: astore_2
    //   498: goto -19 -> 479
    //   501: astore_3
    //   502: goto -61 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	ShortVideoForwardProcessor
    //   72	290	1	localObject1	Object
    //   375	2	1	localIOException1	IOException
    //   382	1	1	localObject2	Object
    //   430	2	1	localIOException2	IOException
    //   442	15	1	localObject3	Object
    //   470	2	1	localIOException3	IOException
    //   478	6	1	localObject4	Object
    //   489	2	1	localIOException4	IOException
    //   80	386	2	localObject5	Object
    //   476	12	2	localObject6	Object
    //   497	1	2	localObject7	Object
    //   438	14	3	localIOException5	IOException
    //   501	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   370	374	375	java/io/IOException
    //   395	399	430	java/io/IOException
    //   296	308	438	java/io/IOException
    //   465	469	470	java/io/IOException
    //   296	308	476	finally
    //   483	487	489	java/io/IOException
    //   310	319	497	finally
    //   321	328	497	finally
    //   330	360	497	finally
    //   362	366	497	finally
    //   383	391	497	finally
    //   443	448	497	finally
    //   450	455	497	finally
    //   457	461	497	finally
    //   310	319	501	java/io/IOException
    //   321	328	501	java/io/IOException
    //   330	360	501	java/io/IOException
    //   362	366	501	java/io/IOException
    //   383	391	501	java/io/IOException
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.jdField_k_of_type_Boolean);
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
      r();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransFileController.a.post(new aiwc(this));
    }
    return 0;
  }
  
  protected void b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.jdField_a_of_type_Int = localOptions.outWidth;
    this.jdField_b_of_type_Int = localOptions.outHeight;
  }
  
  public void b(boolean paramBoolean)
  {
    int k = 2002;
    int i = 0;
    if (!d()) {}
    Object localObject1;
    label211:
    label239:
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label239;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label211;
        }
      }
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
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
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!c())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null))
      {
        super.e();
        localObject2 = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Int = 0;
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        ((UpCallBack.SendResult)localObject2).jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_f_of_type_JavaLangString == null) {}
        for (localObject1 = this.jdField_g_of_type_JavaLangString;; localObject1 = this.jdField_f_of_type_JavaLangString)
        {
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_Int = this.y;
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((UpCallBack.SendResult)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b((UpCallBack.SendResult)localObject2);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof ShortVideoForwardInfo)));
    Object localObject2 = (ShortVideoForwardInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
    DCShortVideo localDCShortVideo = new DCShortVideo(BaseApplication.getContext());
    int j;
    switch (((ShortVideoForwardInfo)localObject2).jdField_c_of_type_Int)
    {
    default: 
      i = 5;
    case 0: 
      j = k;
      switch (((ShortVideoForwardInfo)localObject2).jdField_f_of_type_Int)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      localDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ShortVideoForwardInfo)localObject2).jdField_h_of_type_JavaLangString, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((ShortVideoForwardInfo)localObject2).jdField_m_of_type_JavaLangString, ((ShortVideoForwardInfo)localObject2).jdField_j_of_type_Int, ((ShortVideoForwardInfo)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 1;
      break;
      i = 3000;
      break;
      i = 5;
      break;
      j = 2001;
      continue;
      j = 2003;
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
    super.d();
    if (-5100026 == this.jdField_j_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
      {
        UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
        localSendResult.jdField_a_of_type_Int = -1;
        localSendResult.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
        localSendResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
      return;
      if (9042 == this.jdField_j_of_type_Int) {
        d(5002);
      } else {
        d(1005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
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
    localMessageForShortVideo.videoFileSize = ((int)this.jdField_q_of_type_Long);
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.y;
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
      localSendResult.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_g_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        localSendResult.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localSendResult.jdField_c_of_type_Int = this.y;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      d(1003);
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = a();
    if (localShortVideoForwardReq == null) {}
    do
    {
      return;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_fw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoForwardReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!c())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      b("requestStart", localRichProtoReq.toString());
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void n()
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq)))
    {
      if (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)) {
        break label59;
      }
      str = "videoCf";
    }
    for (;;)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
      label59:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1) {
        str = "videoGf";
      } else if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 3000) {
        str = "videoDf";
      } else {
        str = "videoOf";
      }
    }
  }
  
  public void q()
  {
    if (this.o) {
      return;
    }
    if ((this.jdField_l_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString != null))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        b(false);
        return;
      }
      if ((this.v == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      ar_();
      return;
    }
    ar_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor
 * JD-Core Version:    0.7.0.1
 */