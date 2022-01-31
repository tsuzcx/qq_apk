package com.tencent.mobileqq.transfile;

import aipz;
import aiqa;
import aiqd;
import aiqe;
import aiqf;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.doutu.DoutuUtils;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class GroupPicUploadProcessor
  extends BasePicUploadProcessor
  implements INetEventHandler, VoiceChangeParams.IOnCompressFinish
{
  long jdField_a_of_type_Long;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new aiqf(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = true;
  private long c;
  private long d;
  boolean h = false;
  private boolean q;
  private boolean r;
  private boolean s;
  
  public GroupPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_d_of_type_Long = -1L;
    if (!this.h) {
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM = PttSSCMPool.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private im_msg_body.Elem a()
  {
    Object localObject = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
    if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()) && (((ClassicHeadActivityManager)localObject).a() == 1L))
    {
      localObject = ((ClassicHeadActivityManager)localObject).a();
      if (localObject != null)
      {
        int i = ((Setting)localObject).systemHeadID;
        int j = ((Setting)localObject).bHeadType;
        localObject = new im_msg_body.Elem();
        im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
        localCommonElem.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        ((im_msg_body.Elem)localObject).common_elem.set(localCommonElem);
        return localObject;
      }
    }
    return null;
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_q_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_s_of_type_Long);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(Utils.a(paramMessageForPtt.voiceLength));
    }
  }
  
  private byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(VoiceRedPacketHelper.a(paramMessageForPtt));
      ByteStringMicro localByteStringMicro = VoiceRedPacketHelper.a(paramMessageForPtt);
      if (localByteStringMicro != null) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_redpack_score_id.set(localByteStringMicro);
      }
    }
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    if ((QLog.isColorLevel()) && (paramMessageForPtt != null)) {
      QLog.d("pttchangevoice", 2, "change flag is " + paramMessageForPtt.voiceChangeFlag);
    }
    return localObject;
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.jdField_l_of_type_JavaLangString);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_q_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_s_of_type_Long);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&mType=");
    if (this.jdField_b_of_type_Boolean)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  private void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    Object localObject1 = a();
    if ((localObject1 != null) && (((TransferRequest)localObject1).h))
    {
      this.jdField_o_of_type_Int = ((TransferRequest)localObject1).jdField_l_of_type_Int;
      this.p = ((TransferRequest)localObject1).m;
      this.jdField_q_of_type_Long = ((TransferRequest)localObject1).jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(((TransferRequest)localObject1).f);
      this.jdField_d_of_type_JavaLangString = ((TransferRequest)localObject1).f;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      q();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      d();
      return;
    }
    Object localObject2;
    if ((this.h) && ((this.p == 0) || (this.jdField_o_of_type_Int == 0)))
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      this.p = ((BitmapFactory.Options)localObject1).outHeight;
      this.jdField_o_of_type_Int = ((BitmapFactory.Options)localObject1).outWidth;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
      if ((localObject2 != null) && ((localObject2 instanceof TransferRequest.PicUpExtraInfo)) && (((TransferRequest.PicUpExtraInfo)localObject2).jdField_a_of_type_Boolean) && (RichMediaUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
      {
        this.p = ((BitmapFactory.Options)localObject1).outWidth;
        this.jdField_o_of_type_Int = ((BitmapFactory.Options)localObject1).outHeight;
        if (QLog.isColorLevel()) {
          b("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject1).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject1).outHeight + ",mWidth = " + this.jdField_o_of_type_Int + ",mHeight = " + this.p);
        }
      }
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt;
    int i;
    if (!this.h)
    {
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
      if (localMessageForPtt != null) {
        break label531;
      }
      i = 0;
      if (localMessageForPtt != null) {
        break label540;
      }
    }
    label531:
    label540:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      PttInfoCollector.a((String)localObject2, false, false, i, l);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      q();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  private int d()
  {
    boolean bool = true;
    int j = 0;
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int) {
        bool = false;
      }
      this.h = bool;
      if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
      {
        b(9302, a(new Exception("message null")));
        d();
        i = -1;
      }
      break;
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.jdField_b_of_type_Boolean = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((TransferRequest)localObject).h)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
        this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          b(9302, a(new Exception("filePath null")));
          d();
          return -1;
        }
        File localFile = new File((String)localObject);
        if (!localFile.exists())
        {
          b(9042, a(new Exception("sendFile not exist " + (String)localObject)));
          d();
          return -1;
        }
        if (!localFile.canRead())
        {
          b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString)));
          d();
          return -1;
        }
        long l = localFile.length();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
        this.jdField_q_of_type_Long = l;
        if (l <= 0L)
        {
          b(9071, a(new Exception("file size 0 " + (String)localObject)));
          d();
          return -1;
        }
        if (this.h)
        {
          localObject = FileUtils.a((String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if ((((String)localObject).contains(FileUtils.jdField_a_of_type_JavaLangString)) || (!FileUtils.f((String)localObject)))
            {
              a(9072, (String)localObject, c((String)localObject), null);
              d();
              new Handler(Looper.getMainLooper()).post(new aipz(this));
              return -1;
            }
            this.jdField_e_of_type_JavaLangString = ((String)localObject);
          }
          if (l >= 19922944L)
          {
            a(9063, (String)localObject, c((String)localObject), null);
            d();
            return -1;
          }
        }
        else
        {
          this.jdField_e_of_type_JavaLangString = "amr";
        }
        i = j;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
    this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.h = 0L;
  }
  
  public int a()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.a();
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_q_of_type_Long - paramLong;
    long l;
    if (!this.jdField_a_of_type_Boolean)
    {
      l = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.jdField_s_of_type_Long, -1);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "get sscm size =" + l);
      }
    }
    for (paramLong = Math.min(paramLong, l);; paramLong = Math.min(paramLong, 14600L))
    {
      paramLong = Math.min(paramLong, 131072L);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "real sscm=" + paramLong);
      }
      return paramLong;
    }
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.d = true;
    paramArrayOfByte.d = true;
    return paramArrayOfByte;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject).jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject).jdField_a_of_type_Int);
    }
    if (!this.h) {
      b(paramArrayOfByte);
    }
    for (;;)
    {
      if (!this.h)
      {
        localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramArrayOfByte.append("&voice_codec=" + ((MessageForPtt)localObject).voiceType);
      }
      paramArrayOfByte = a(paramArrayOfByte.toString(), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      return paramArrayOfByte;
      a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 221	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 627	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 630	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_2
    //   17: getfield 634	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 208	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 640	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 645	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_2
    //   34: getfield 648	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 649	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 650	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 653	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 650	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: ldc_w 655
    //   65: invokevirtual 658	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 164	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 661	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 592	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 598	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 600	com/tencent/mobileqq/transfile/ServerAddr
    //   102: astore_3
    //   103: aload_2
    //   104: getfield 664	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_3
    //   108: getfield 603	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 666	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;)I
    //   114: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_2
    //   118: getfield 669	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_3
    //   122: getfield 604	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_Int	I
    //   125: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 61	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 61	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 672	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   139: invokestatic 677	com/tencent/mobileqq/service/message/MessageUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore_1
    //   143: new 126	tencent/im/msg/im_msg_body$Elem
    //   146: dup
    //   147: invokespecial 128	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   150: astore 4
    //   152: new 679	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 680	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_3
    //   160: aload_3
    //   161: getfield 683	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload_1
    //   165: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   168: aload 4
    //   170: getfield 687	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_3
    //   174: invokevirtual 688	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_2
    //   178: getfield 692	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 696	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_2
    //   186: getfield 699	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: aload_0
    //   190: getfield 192	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_q_of_type_Long	J
    //   193: l2i
    //   194: invokevirtual 141	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: aload_2
    //   198: getfield 702	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: aload_0
    //   202: getfield 340	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   205: invokestatic 164	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   208: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   211: aload_2
    //   212: getfield 705	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload_0
    //   216: getfield 342	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokestatic 709	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   222: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   230: getfield 426	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   233: checkcast 226	com/tencent/mobileqq/data/MessageForPtt
    //   236: invokespecial 711	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   239: astore_3
    //   240: aload_3
    //   241: ifnull +14 -> 255
    //   244: aload_2
    //   245: getfield 714	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   248: aload_3
    //   249: invokestatic 164	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 169	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   255: new 215	tencent/im/msg/im_msg_body$RichText
    //   258: dup
    //   259: invokespecial 715	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   262: astore_3
    //   263: aload_3
    //   264: getfield 219	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   267: aload_2
    //   268: invokevirtual 716	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   271: aload_3
    //   272: getfield 720	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   275: aload 4
    //   277: invokevirtual 725	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   280: aload_0
    //   281: invokespecial 727	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	()Ltencent/im/msg/im_msg_body$Elem;
    //   284: astore 4
    //   286: aload_3
    //   287: astore_2
    //   288: aload_3
    //   289: ifnull +48 -> 337
    //   292: aload_3
    //   293: astore_2
    //   294: aload_3
    //   295: getfield 720	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   298: ifnull +39 -> 337
    //   301: aload_3
    //   302: astore_2
    //   303: aload 4
    //   305: ifnull +32 -> 337
    //   308: aload_3
    //   309: getfield 720	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   312: aload 4
    //   314: invokevirtual 725	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   317: aload_3
    //   318: astore_2
    //   319: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +15 -> 337
    //   325: ldc_w 565
    //   328: iconst_2
    //   329: ldc_w 729
    //   332: invokestatic 569	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_3
    //   336: astore_2
    //   337: aload_2
    //   338: areturn
    //   339: astore_3
    //   340: aconst_null
    //   341: astore_2
    //   342: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   345: ifeq -8 -> 337
    //   348: ldc_w 565
    //   351: iconst_2
    //   352: ldc_w 731
    //   355: aload_3
    //   356: invokestatic 734	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   359: aconst_null
    //   360: areturn
    //   361: astore_3
    //   362: goto -288 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	GroupPicUploadProcessor
    //   142	23	1	i	int
    //   7	335	2	localObject1	Object
    //   49	287	3	localObject2	Object
    //   339	17	3	localException	Exception
    //   361	1	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   150	163	4	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	339	java/lang/Exception
    //   54	74	339	java/lang/Exception
    //   74	128	339	java/lang/Exception
    //   128	240	339	java/lang/Exception
    //   244	255	339	java/lang/Exception
    //   255	286	339	java/lang/Exception
    //   294	301	339	java/lang/Exception
    //   308	317	339	java/lang/Exception
    //   319	335	339	java/lang/Exception
    //   54	74	361	java/io/UnsupportedEncodingException
  }
  
  public im_msg_body.RichText a(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = a();
    a(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 742	com/tencent/mobileqq/transfile/BasePicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   8: aload_0
    //   9: getfield 744	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_o_of_type_Boolean	Z
    //   12: ifne +10 -> 22
    //   15: aload_0
    //   16: getfield 746	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_k_of_type_Boolean	Z
    //   19: ifeq +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 749	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   28: aload_1
    //   29: getfield 753	com/tencent/mobileqq/transfile/NetResp:jdField_c_of_type_Int	I
    //   32: istore_2
    //   33: aload_0
    //   34: ldc_w 755
    //   37: new 181	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 757
    //   47: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: getfield 758	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   54: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 760
    //   60: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 761	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   67: invokevirtual 279	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 763
    //   73: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 764	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 409	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: getfield 758	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   93: ifne +670 -> 763
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 765	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_l_of_type_Int	I
    //   101: aload_0
    //   102: getfield 52	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   105: invokevirtual 766	com/tencent/wstt/SSCM/SSCM:b	()V
    //   108: aload_1
    //   109: getfield 769	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: ldc_w 771
    //   115: invokevirtual 776	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: ifnull +779 -> 897
    //   121: aload_1
    //   122: getfield 769	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   125: ldc_w 771
    //   128: invokevirtual 776	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 81	java/lang/String
    //   134: invokestatic 640	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore 7
    //   139: lload 7
    //   141: lconst_0
    //   142: lcmp
    //   143: ifeq +87 -> 230
    //   146: lload 7
    //   148: ldc2_w 777
    //   151: lcmp
    //   152: ifeq +78 -> 230
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   160: aload_1
    //   161: iconst_0
    //   162: invokevirtual 784	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   165: lload 7
    //   167: l2i
    //   168: invokestatic 789	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   171: ifne +59 -> 230
    //   174: aload_0
    //   175: sipush -9527
    //   178: aconst_null
    //   179: iload_2
    //   180: lload 7
    //   182: invokestatic 792	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(IJ)Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   189: invokevirtual 498	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   192: aload_0
    //   193: invokevirtual 362	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: sipush 9343
    //   202: new 77	java/lang/Exception
    //   205: dup
    //   206: ldc_w 794
    //   209: invokespecial 447	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   212: invokestatic 797	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   215: ldc_w 799
    //   218: aload_0
    //   219: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   222: invokevirtual 498	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   225: aload_0
    //   226: invokevirtual 362	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   229: return
    //   230: aload_1
    //   231: getfield 769	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   234: ldc_w 801
    //   237: invokevirtual 776	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: checkcast 81	java/lang/String
    //   243: astore 11
    //   245: aload 11
    //   247: ifnull +658 -> 905
    //   250: aload 11
    //   252: invokestatic 90	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   255: istore_2
    //   256: iload_2
    //   257: i2l
    //   258: lstore_3
    //   259: lload_3
    //   260: lstore 5
    //   262: lload_3
    //   263: ldc2_w 777
    //   266: lcmp
    //   267: ifne +44 -> 311
    //   270: aload_1
    //   271: getfield 769	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   274: ldc_w 803
    //   277: invokevirtual 776	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast 81	java/lang/String
    //   283: astore 10
    //   285: aload 10
    //   287: astore 9
    //   289: lload_3
    //   290: lstore 5
    //   292: aload 10
    //   294: ifnull +17 -> 311
    //   297: aload 10
    //   299: invokestatic 90	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   302: istore_2
    //   303: iload_2
    //   304: i2l
    //   305: lstore 5
    //   307: aload 10
    //   309: astore 9
    //   311: lload 5
    //   313: ldc2_w 777
    //   316: lcmp
    //   317: ifne +124 -> 441
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   325: aload_1
    //   326: iconst_0
    //   327: invokevirtual 784	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   330: aload_0
    //   331: sipush -9527
    //   334: new 181	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 805
    //   344: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 11
    //   349: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 807
    //   355: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload_0
    //   367: getfield 808	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 810	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_g_of_type_Int	I
    //   374: i2l
    //   375: invokestatic 813	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   382: invokevirtual 498	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   385: aload_0
    //   386: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   389: ifnull +18 -> 407
    //   392: aload_0
    //   393: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   396: getfield 442	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   399: iconst_2
    //   400: if_icmpne +7 -> 407
    //   403: iconst_0
    //   404: invokestatic 815	com/tencent/mobileqq/transfile/PttInfoCollector:b	(Z)V
    //   407: aload_0
    //   408: invokevirtual 362	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   411: return
    //   412: astore 10
    //   414: aload 10
    //   416: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   419: goto +486 -> 905
    //   422: astore 9
    //   424: aload 9
    //   426: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   429: ldc2_w 777
    //   432: lstore 5
    //   434: aload 10
    //   436: astore 9
    //   438: goto -127 -> 311
    //   441: aload_0
    //   442: ldc_w 817
    //   445: new 181	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 819
    //   455: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: getfield 199	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Long	J
    //   462: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   465: ldc_w 821
    //   468: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: lload 5
    //   473: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: ldc_w 823
    //   479: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: lload 7
    //   484: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokevirtual 409	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: lload 5
    //   495: aload_0
    //   496: getfield 199	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Long	J
    //   499: lcmp
    //   500: ifgt +31 -> 531
    //   503: aload_0
    //   504: getfield 825	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Int	I
    //   507: iconst_3
    //   508: if_icmpge +74 -> 582
    //   511: aload_0
    //   512: ldc_w 827
    //   515: ldc_w 829
    //   518: invokevirtual 409	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: aload_0
    //   523: getfield 825	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Int	I
    //   526: iconst_1
    //   527: iadd
    //   528: putfield 825	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Int	I
    //   531: aload_0
    //   532: getfield 307	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   535: lload 5
    //   537: putfield 830	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_Long	J
    //   540: aload_0
    //   541: lload 5
    //   543: putfield 199	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_s_of_type_Long	J
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   551: aload_1
    //   552: iconst_1
    //   553: invokevirtual 784	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   556: lload 5
    //   558: aload_0
    //   559: getfield 192	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_q_of_type_Long	J
    //   562: lcmp
    //   563: ifge +92 -> 655
    //   566: aload_0
    //   567: getfield 744	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_o_of_type_Boolean	Z
    //   570: ifne -548 -> 22
    //   573: aload_0
    //   574: invokevirtual 832	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:g	()V
    //   577: aload_0
    //   578: invokevirtual 834	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:r	()V
    //   581: return
    //   582: aload_0
    //   583: aload_0
    //   584: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   587: aload_1
    //   588: iconst_0
    //   589: invokevirtual 784	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   592: aload_0
    //   593: getfield 835	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   596: ldc_w 837
    //   599: new 181	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 799
    //   609: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: lload 7
    //   614: invokevirtual 195	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   617: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 841	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   623: pop
    //   624: aload_0
    //   625: sipush -9527
    //   628: ldc_w 799
    //   631: aload_0
    //   632: getfield 808	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   635: aload_0
    //   636: getfield 843	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_f_of_type_Int	I
    //   639: i2l
    //   640: invokestatic 813	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   643: aload_0
    //   644: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   647: invokevirtual 498	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   650: aload_0
    //   651: invokevirtual 362	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   654: return
    //   655: aload_0
    //   656: monitorenter
    //   657: aload_0
    //   658: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   661: getfield 846	com/tencent/mobileqq/transfile/TransferRequest:jdField_n_of_type_Boolean	Z
    //   664: ifeq +13 -> 677
    //   667: aload_0
    //   668: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   671: getfield 847	com/tencent/mobileqq/transfile/TransferRequest:jdField_o_of_type_Boolean	Z
    //   674: ifeq +62 -> 736
    //   677: aload_0
    //   678: invokevirtual 849	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   681: aload_0
    //   682: getfield 307	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   685: invokevirtual 311	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   688: aload_0
    //   689: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   692: getfield 846	com/tencent/mobileqq/transfile/TransferRequest:jdField_n_of_type_Boolean	Z
    //   695: ifeq +33 -> 728
    //   698: invokestatic 852	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   701: ifeq +13 -> 714
    //   704: ldc_w 854
    //   707: iconst_4
    //   708: ldc_w 856
    //   711: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: aload_0
    //   715: getfield 61	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   718: invokestatic 861	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/ptt/preop/PttPreSendManager;
    //   721: aload_0
    //   722: invokevirtual 863	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	()Ljava/lang/String;
    //   725: invokevirtual 865	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Ljava/lang/String;)V
    //   728: aload_0
    //   729: monitorexit
    //   730: return
    //   731: astore_1
    //   732: aload_0
    //   733: monitorexit
    //   734: aload_1
    //   735: athrow
    //   736: aload_0
    //   737: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   740: iconst_1
    //   741: putfield 847	com/tencent/mobileqq/transfile/TransferRequest:jdField_o_of_type_Boolean	Z
    //   744: invokestatic 852	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   747: ifeq -19 -> 728
    //   750: ldc_w 854
    //   753: iconst_4
    //   754: ldc_w 867
    //   757: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: goto -32 -> 728
    //   763: aload_0
    //   764: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   767: getfield 426	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   770: invokestatic 870	com/tencent/mobileqq/activity/qwallet/voice/VoiceRedPacketHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   773: ifeq +12 -> 785
    //   776: invokestatic 873	com/tencent/mobileqq/activity/qwallet/voice/VoiceRedPacketHelper:a	()Lcom/tencent/mobileqq/activity/qwallet/voice/VoiceRedPacketHelper;
    //   779: ldc_w 875
    //   782: invokevirtual 877	com/tencent/mobileqq/activity/qwallet/voice/VoiceRedPacketHelper:b	(Ljava/lang/String;)V
    //   785: aload_1
    //   786: getfield 761	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   789: sipush 9364
    //   792: if_icmpne +40 -> 832
    //   795: aload_0
    //   796: getfield 765	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_l_of_type_Int	I
    //   799: iconst_3
    //   800: if_icmpge +32 -> 832
    //   803: aload_0
    //   804: ldc_w 879
    //   807: ldc_w 881
    //   810: invokevirtual 409	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload_0
    //   814: aload_0
    //   815: getfield 765	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_l_of_type_Int	I
    //   818: iconst_1
    //   819: iadd
    //   820: putfield 765	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_l_of_type_Int	I
    //   823: aload_0
    //   824: invokevirtual 883	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:m	()V
    //   827: aload_0
    //   828: invokevirtual 358	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:q	()V
    //   831: return
    //   832: aload_1
    //   833: getfield 884	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   836: getfield 887	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_ArrayOfByte	[B
    //   839: arraylength
    //   840: ldc_w 888
    //   843: if_icmplt +27 -> 870
    //   846: aload_1
    //   847: getfield 761	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   850: invokestatic 891	com/tencent/mobileqq/transfile/RichMediaStrategy:a	(I)Z
    //   853: ifeq +17 -> 870
    //   856: aload_0
    //   857: iconst_1
    //   858: putfield 29	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Boolean	Z
    //   861: aload_0
    //   862: invokevirtual 883	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:m	()V
    //   865: aload_0
    //   866: invokevirtual 834	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:r	()V
    //   869: return
    //   870: aload_0
    //   871: aload_0
    //   872: getfield 781	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   875: aload_1
    //   876: iconst_0
    //   877: invokevirtual 784	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   880: aload_0
    //   881: aload_1
    //   882: getfield 761	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Int	I
    //   885: aload_1
    //   886: getfield 764	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   889: invokevirtual 422	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(ILjava/lang/String;)V
    //   892: aload_0
    //   893: invokevirtual 362	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   896: return
    //   897: ldc2_w 777
    //   900: lstore 7
    //   902: goto -763 -> 139
    //   905: ldc2_w 777
    //   908: lstore_3
    //   909: goto -650 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	912	0	this	GroupPicUploadProcessor
    //   0	912	1	paramNetResp	NetResp
    //   32	272	2	i	int
    //   258	651	3	l1	long
    //   260	297	5	l2	long
    //   137	764	7	l3	long
    //   1	358	9	localObject1	Object
    //   422	3	9	localException1	Exception
    //   436	1	9	localObject2	Object
    //   283	25	10	str1	String
    //   412	23	10	localException2	Exception
    //   243	105	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   89	139	197	java/lang/Exception
    //   155	196	197	java/lang/Exception
    //   230	245	197	java/lang/Exception
    //   270	285	197	java/lang/Exception
    //   320	407	197	java/lang/Exception
    //   407	411	197	java/lang/Exception
    //   414	419	197	java/lang/Exception
    //   424	429	197	java/lang/Exception
    //   441	531	197	java/lang/Exception
    //   531	581	197	java/lang/Exception
    //   582	654	197	java/lang/Exception
    //   655	657	197	java/lang/Exception
    //   734	736	197	java/lang/Exception
    //   763	785	197	java/lang/Exception
    //   785	831	197	java/lang/Exception
    //   832	869	197	java/lang/Exception
    //   870	896	197	java/lang/Exception
    //   250	256	412	java/lang/Exception
    //   297	303	422	java/lang/Exception
    //   657	677	731	finally
    //   677	714	731	finally
    //   714	728	731	finally
    //   728	730	731	finally
    //   732	734	731	finally
    //   736	760	731	finally
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    super.a(paramRichProtoReq, paramRichProtoResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null)
    {
      i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_j_of_type_Boolean);
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
          break label605;
        }
        if (!this.jdField_q_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
          this.jdField_q_of_type_Boolean = true;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label562;
        }
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          b(true);
          label178:
          if (!paramRichProtoReq.jdField_a_of_type_Boolean) {
            break label255;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          s();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      b(false);
      break label178;
      label255:
      d(1002);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h)
      {
        b(9333, "Server MD5 fast forward missed");
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p = false;
        q();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_q_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_q_of_type_Boolean = false;
        q();
        return;
      }
      this.jdField_a_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
      this.jdField_l_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_s_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
      this.jdField_t_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
      this.jdField_r_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
      boolean bool = paramRichProtoReq.jdField_c_of_type_Boolean;
      if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_e_of_type_Boolean) && (!paramRichProtoReq.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
      }
      if (this.v == 2)
      {
        d("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
        r();
        continue;
      }
      if (this.v == 0)
      {
        d("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
        if (!bool) {
          d("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
        }
        if (bool)
        {
          d("<BDH_LOG> onBusiProtoResp() select BDH channel");
          this.v = 1;
          an_();
          continue;
        }
        d("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.v = 2;
        r();
        continue;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.v == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        d(paramRichProtoReq);
        break;
      }
      label562:
      d("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.v = 2;
      d();
      return;
      label605:
      if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPttUpResp)) {
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "onBusiProtoResp, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (!this.jdField_q_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
        this.jdField_q_of_type_Boolean = true;
      }
      paramRichProtoReq = (RichProto.RichProtoResp.GroupPttUpResp)paramRichProtoReq;
      if (paramRichProtoReq.jdField_c_of_type_Int == 0) {
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte == null) {}
        }
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
        for (;;)
        {
          try
          {
            label740:
            if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean))
            {
              s();
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("PttPreSendManager", 4, "group group  upResp.isExist, can send msg, direct send");
                }
                PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
              }
              break;
            }
          }
          finally {}
          if (QLog.isDevelopLevel()) {
            QLog.d("PttPreSendManager", 4, "group group  upResp.isExist, can't send msg, wait");
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
        if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) {}
        try
        {
          this.jdField_a_of_type_JavaLangString = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
          label876:
          this.jdField_l_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_s_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_t_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
          b("OnProtoResp", " TryUpload response GrpFileKey:" + this.jdField_a_of_type_JavaLangString);
          r();
          continue;
          d();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          break label876;
        }
      }
      catch (UnsupportedEncodingException paramRichProtoReq)
      {
        break label740;
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 1023	com/tencent/mobileqq/transfile/TransferRequest:jdField_l_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 204	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 426	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 226	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 236	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 230	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 1025	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_r_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 1027	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 1029	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:c	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 1027	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 1029	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:c	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	GroupPicUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_u_of_type_Int == 1))
    {
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Int = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (!this.h) {
        PttSSCMPool.a(this.jdField_a_of_type_ComTencentWsttSSCMSSCM);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.jdField_k_of_type_Long);
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(this.jdField_k_of_type_Long);
      }
      String str1 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        if (this.jdField_j_of_type_Int == 9004) {
          break label198;
        }
        if (f()) {}
      }
      label198:
      Object localObject1;
      while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        localObject1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if ("connError_unreachable".equalsIgnoreCase((String)localObject1)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        } else if ("connError_noroute".equalsIgnoreCase((String)localObject1)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
        }
      }
      if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.jdField_i_of_type_Boolean) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.m;
      int i;
      Object localObject2;
      if (paramBoolean)
      {
        i = 2;
        this.m = (i | j);
        if (!this.jdField_b_of_type_Boolean) {
          break label1261;
        }
        if (!this.h) {
          break label1253;
        }
        localObject2 = "actGroupPicUploadV1";
        label369:
        localObject1 = localObject2;
        if (!this.h) {
          break label1465;
        }
        localObject1 = localObject2;
        if (this.v != 1) {
          break label1465;
        }
        localObject1 = "actGroupPicUploadV2";
      }
      label1322:
      label1332:
      label1465:
      for (;;)
      {
        label446:
        long l1;
        label454:
        long l2;
        if ((!this.h) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString)))
        {
          localObject2 = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
          if (localObject2 == null)
          {
            i = 0;
            if (localObject2 != null) {
              break label1322;
            }
            l1 = 0L;
            PttInfoCollector.a(str2, true, paramBoolean, i, l1);
          }
        }
        else
        {
          this.jdField_l_of_type_Long = System.currentTimeMillis();
          long l3 = System.nanoTime();
          l2 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
          Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str1);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_a_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_f_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", StatisticConstants.a() + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", NetworkUtil.a(BaseApplication.getContext()) + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_t_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int));
          if ((this.jdField_s_of_type_Boolean) && (!this.h))
          {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_b_of_type_Long / 1000000L));
            if (QLog.isColorLevel()) {
              QLog.d("weak_net", 2, String.valueOf(this.jdField_b_of_type_Long / 1000000L));
            }
          }
          if (!this.h) {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
          }
          if (!paramBoolean) {
            break label1332;
          }
          o();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
          {
            l1 = 0L;
            if (this.jdField_u_of_type_Long != 0L) {
              l1 = (l3 - this.jdField_u_of_type_Long) / 1000000L;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean) {
              l1 = l2;
            }
            double d1 = l1 / l2;
            StatisticConstants.a(l1, this.jdField_q_of_type_Long, this.jdField_f_of_type_Boolean, d1);
            if ((d1 >= 0.0D) && (d1 <= 1.0D)) {
              this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d1 + "");
            }
            this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean + ",Percent = " + d1);
            }
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, true, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
        for (;;)
        {
          l();
          AppNetConnInfo.unregisterNetEventHandler(this);
          return;
          i = 1;
          break;
          label1253:
          localObject2 = "actGrpPttUp";
          break label369;
          label1261:
          if (this.h) {}
          for (localObject2 = "actDiscussPicUpload";; localObject2 = "actDisscusPttUp")
          {
            localObject1 = localObject2;
            if (!this.h) {
              break label1465;
            }
            localObject1 = localObject2;
            if (this.v != 1) {
              break label1465;
            }
            localObject1 = "actDiscussPicUploadV2";
            break;
          }
          i = ((MessageForPtt)localObject2).voiceChangeFlag;
          break label446;
          l1 = ((MessageForPtt)localObject2).fileSize;
          break label454;
          if (this.jdField_j_of_type_Int != -9527) {
            this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
          StatisticCollector.a(BaseApplication.getContext()).a(null, (String)localObject1, false, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
      }
    }
  }
  
  public void an_()
  {
    if (this.jdField_d_of_type_Long == -1L) {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      Object localObject = HexUtil.a(this.jdField_l_of_type_JavaLangString);
      aiqa localaiqa = new aiqa(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_a_of_type_ArrayOfByte, localaiqa);
      localObject = new aiqd(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_g_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  public void ap_()
  {
    super.ap_();
    if ((!this.h) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean))
    {
      if (VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, this)) {
        try
        {
          if (this.jdField_r_of_type_Boolean)
          {
            d(1001);
            this.jdField_r_of_type_Boolean = true;
          }
          return;
        }
        finally {}
      }
      if (d() == 0) {
        c(false);
      }
    }
    else
    {
      c(false);
    }
  }
  
  public int b()
  {
    if ((!this.h) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_o_of_type_Boolean))
    {
      g();
      s();
    }
    while (!this.jdField_k_of_type_Boolean) {
      return 0;
    }
    this.jdField_k_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    d(1002);
    if (this.v != 1)
    {
      this.jdField_s_of_type_Long = 0L;
      this.jdField_l_of_type_JavaLangString = null;
    }
    this.jdField_s_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_q_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
    w();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new aiqe(this));
    return 0;
  }
  
  protected im_msg_body.RichText b()
  {
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        Object localObject1 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject1).uint32_file_id.set((int)this.jdField_a_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject3 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject1).uint32_server_ip.set(a(((ServerAddr)localObject3).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject1).uint32_server_port.set(((ServerAddr)localObject3).jdField_a_of_type_Int);
        }
        f();
        ((im_msg_body.CustomFace)localObject1).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject1).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          ((im_msg_body.CustomFace)localObject1).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
        ((im_msg_body.CustomFace)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject1).str_file_path.set(this.jdField_d_of_type_JavaLangString);
        localObject3 = ((im_msg_body.CustomFace)localObject1).uint32_origin;
        if (!this.jdField_l_of_type_Boolean) {
          break label1198;
        }
        i = 1;
        ((PBUInt32Field)localObject3).set(i);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (MessageForPic.class.isInstance(localObject4))
        {
          localObject3 = (MessageForPic)localObject4;
          ((im_msg_body.CustomFace)localObject1).uint32_show_len.set(((MessageForPic)localObject3).mShowLength);
          ((im_msg_body.CustomFace)localObject1).uint32_download_len.set(((MessageForPic)localObject3).mDownloadLength);
          ((im_msg_body.CustomFace)localObject1).image_type.set(((MessageForPic)localObject3).imageType);
          if (((MessageForPic)localObject3).picExtraData != null)
          {
            localObject3 = ((MessageForPic)localObject3).picExtraData.getCustomFaceResvAttr();
            ((im_msg_body.CustomFace)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject3).get()).toByteArray()), true);
          }
          i = 200;
        }
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int)
        {
        case 1008: 
          ((im_msg_body.CustomFace)localObject1).uint32_width.set(this.jdField_o_of_type_Int);
          ((im_msg_body.CustomFace)localObject1).uint32_height.set(this.p);
          ((im_msg_body.CustomFace)localObject1).uint32_size.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.CustomFace)localObject1).uint32_source.set(i);
          if (QLog.isColorLevel()) {
            b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject1).biz_type.get());
          }
          localObject3 = new im_msg_body.RichText();
          localObject5 = new im_msg_body.Elem();
          if (!HotChatHelper.a((MessageRecord)localObject4)) {
            break label1014;
          }
          ((im_msg_body.Elem)localObject5).hc_flash_pic.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject5);
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8("发送了一张[闪照]，请更新版本查看。"));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject1;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)))
            {
              localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg;
              localObject5 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
              if (localObject5 != null)
              {
                ((StructMsgItemImage)localObject5).w = this.jdField_c_of_type_JavaLangString;
                ((StructMsgItemImage)localObject5).v = this.jdField_d_of_type_JavaLangString;
                ((StructMsgItemImage)localObject5).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
                ((StructMsgItemImage)localObject5).jdField_e_of_type_Long = ((MessageRecord)localObject1).time;
                ((StructMsgItemImage)localObject5).jdField_d_of_type_Long = this.jdField_q_of_type_Long;
                if (!AIOGallerySceneWithBusiness.b(((StructMsgForImageShare)localObject6).mMsgActionData)) {
                  break label1181;
                }
                localObject6 = ((StructMsgItemImage)localObject5).u;
                ((StructMsgItemImage)localObject5).u = "";
                localObject1 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
                ((StructMsgItemImage)localObject5).u = ((String)localObject6);
                if ((!TextUtils.isEmpty(((MessageForStructing)localObject4).frienduin)) && (localObject1 != null))
                {
                  localObject4 = new im_msg_body.RichMsg();
                  ((im_msg_body.RichMsg)localObject4).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
                  localObject1 = new im_msg_body.Elem();
                  ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject4);
                  ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
                }
              }
            }
          }
          localObject1 = a();
          if ((localObject3 == null) || (((im_msg_body.RichText)localObject3).elems == null) || (localObject1 == null)) {
            break label1196;
          }
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label1196;
          }
          QLog.e("GroupPicUploadProcessor", 2, "QQ 18 constructPicRichText add richtext common_elem headid and type");
          break label1196;
          if ((!MessageForStructing.class.isInstance(localObject4)) || (!((MessageForStructing)localObject4).isHotPicsStruct())) {
            continue;
          }
          localObject3 = new CustomFaceExtPb.ResvAttr();
          ((CustomFaceExtPb.ResvAttr)localObject3).uint32_image_biz_type.set(2);
          ((im_msg_body.CustomFace)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject3).get()).toByteArray()), true);
          continue;
          localException.biz_type.set(2);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      int i = 105;
      continue;
      localException.biz_type.set(3);
      i = 101;
      continue;
      localException.biz_type.set(4);
      i = 104;
      continue;
      localException.biz_type.set(5);
      i = 103;
      continue;
      localException.biz_type.set(6);
      i = 106;
      continue;
      localException.biz_type.set(7);
      continue;
      localException.biz_type.set(8);
      continue;
      localException.biz_type.set(9);
      continue;
      label1014:
      Object localObject2;
      if (FlashPicHelper.a((MessageRecord)localObject4))
      {
        localObject4 = new im_msg_body.CommonElem();
        ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(3);
        localObject6 = new hummer_commelem.MsgElemInfo_servtype3();
        ((hummer_commelem.MsgElemInfo_servtype3)localObject6).flash_troop_pic.set(localException);
        ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject6).toByteArray()));
        ((im_msg_body.Elem)localObject5).common_elem.set((MessageMicro)localObject4);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject5);
        if (QLog.isColorLevel()) {
          QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
        }
        localObject2 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("[闪照]请使用新版手机QQ查看闪照。"));
        localObject4 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
      }
      else
      {
        ((im_msg_body.Elem)localObject5).custom_face.set((MessageMicro)localObject2);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject5);
        continue;
        label1181:
        localObject2 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
        continue;
        continue;
        label1196:
        return localObject3;
        label1198:
        i = 0;
      }
    }
  }
  
  public int c()
  {
    super.c();
    if ((!this.h) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean)) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if ((this.h) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_l_of_type_Boolean)) {
      return super.c();
    }
    return 7000L;
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1006);
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
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localSendResult.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) {
      PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
    }
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
    Object localObject;
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          b("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            b("updateDb", "is multiMsg");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Boolean) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
            }
            ((MessageForPtt)localObject).fileSize = this.jdField_q_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.w = this.jdField_c_of_type_JavaLangString;
    localStructMsgItemImage.v = this.jdField_d_of_type_JavaLangString;
    localStructMsgItemImage.jdField_d_of_type_Long = this.jdField_q_of_type_Long;
    localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    localStructMsgItemImage.jdField_e_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSendResult.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      if (!this.h) {
        d(1003);
      }
      return;
      d(true);
    }
  }
  
  protected void n()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_Long > 0L) {
        this.jdField_b_of_type_Long += System.nanoTime() - this.jdField_c_of_type_Long;
      }
    }
    for (this.jdField_c_of_type_Long = 0L;; this.jdField_c_of_type_Long = System.nanoTime())
    {
      this.jdField_s_of_type_Boolean = true;
      return;
    }
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject1;
    Object localObject2;
    if (this.h)
    {
      localObject1 = new RichProto.RichProtoReq.PicUpReq();
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_c_of_type_Int = this.jdField_o_of_type_Int;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).d = this.p;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int;
      a((RichProto.RichProtoReq.PicUpReq)localObject1);
      DoutuUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest, (RichProto.RichProtoReq.PicUpReq)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject2))
      {
        ((RichProto.RichProtoReq.PicUpReq)localObject1).jdField_a_of_type_Int = ((MessageForPic)localObject2).imageType;
        this.jdField_t_of_type_Int = ((MessageForPic)localObject2).imageType;
      }
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026)
      {
        ((RichProto.RichProtoReq.ReqCommon)localObject1).jdField_f_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
        }
      }
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      if (!this.h) {
        break label368;
      }
      localObject2 = "grp_pic_up";
      label236:
      localRichProtoReq.jdField_a_of_type_JavaLangString = ((String)localObject2);
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localObject1);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (c()) {
        break label375;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label368:
    label375:
    do
    {
      return;
      localObject1 = new RichProto.RichProtoReq.PttUpReq();
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_b_of_type_Int = ((int)this.jdField_q_of_type_Long);
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      ((RichProto.RichProtoReq.PttUpReq)localObject1).d = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_n_of_type_Int;
      ((RichProto.RichProtoReq.PttUpReq)localObject1).jdField_c_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
      break;
      localObject2 = "grp_ptt_up";
      break label236;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void r()
  {
    if (this.jdField_d_of_type_Long == -1L) {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    }
    super.an_();
  }
  
  public void s()
  {
    if (!d()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.h) {
      d(1003);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      t();
      return;
    }
    u();
  }
  
  void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      label176:
      label203:
      MessageForPtt localMessageForPtt;
      do
      {
        return;
        if (!c())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((localObject1 instanceof MessageForPtt)) {
            break label203;
          }
          localObject2 = new StringBuilder().append("Mr_");
          if (localObject1 != null) {
            break label176;
          }
        }
        for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
        {
          a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          break;
        }
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        a((im_msg_body.RichText)localObject2, localMessageForPtt);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
        }
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
          QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
        }
        if (this.jdField_c_of_type_Boolean)
        {
          if (VoiceRedPacketHelper.a((MessageRecord)localObject1))
          {
            VoiceRedPacketHelper.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack == null);
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
      localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
      localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
      localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        e();
        return;
        if (!c())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label848;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label821;
      }
    }
    label821:
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
    label848:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      label180:
      label207:
      MessageForPtt localMessageForPtt;
      do
      {
        return;
        if (!c())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
            break label207;
          }
          localObject2 = new StringBuilder().append("Mr_");
          if (localObject1 != null) {
            break label180;
          }
        }
        for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
        {
          a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          break;
        }
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        a((im_msg_body.RichText)localObject2, localMessageForPtt);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
        }
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
        if (this.jdField_c_of_type_Boolean)
        {
          if (VoiceRedPacketHelper.a((MessageRecord)localObject1))
          {
            VoiceRedPacketHelper.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack == null);
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString);
      localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
      localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
      localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        e();
        return;
        if (!c())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label823;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label796;
      }
    }
    label796:
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
    label823:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void v()
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    if ((this.jdField_l_of_type_JavaLangString != null) && (this.jdField_a_of_type_Long != 0L))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        s();
        return;
      }
      if ((this.v == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      ap_();
      return;
    }
    ap_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */