package com.tencent.mobileqq.transfile;

import aiot;
import aiou;
import aiov;
import aioy;
import aioz;
import aipa;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.doutu.DoutuUtils;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class C2CPicUploadProcessor
  extends BasePicUploadProcessor
{
  private int jdField_a_of_type_Int;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new aipa(this);
  public QQAppInterface a;
  private CSDataHighwayHead.LoginSigHead jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead;
  protected TransFileController a;
  private boolean jdField_a_of_type_Boolean;
  private byte[] b;
  private byte[] c;
  private byte[] d;
  private BaseTransProcessor.StepInfo jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
  private byte[] jdField_e_of_type_ArrayOfByte;
  private BaseTransProcessor.StepInfo f;
  
  public C2CPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo = new BaseTransProcessor.StepInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramTransFileController;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.q = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    this.jdField_a_of_type_Boolean = OpenUpConfig.isOpenUpEnable;
    this.jdField_a_of_type_Int = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
  }
  
  private CSDataHighwayHead.LoginSigHead a()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
    {
      localObject1 = ((TicketManager)localObject1).getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject1 == null) {
        break label102;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        if ((localObject1 == null) || (localObject1.length == 0)) {
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(localUnsupportedEncodingException));
      localLoginSigHead.uint32_loginsig_type.set(8);
      return localLoginSigHead;
      label102:
      Object localObject2 = null;
    }
  }
  
  private im_msg_body.RichText a()
  {
    label977:
    label998:
    label1006:
    label1021:
    label1023:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        try
        {
          localRichText = new im_msg_body.RichText();
          Object localObject1 = new im_msg_body.NotOnlineImage();
          f();
          ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_JavaLangString));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_g_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_g_of_type_JavaLangString));
          }
          ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(this.p);
          ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(this.jdField_o_of_type_Int);
          localObject3 = ((im_msg_body.NotOnlineImage)localObject1).original;
          if (!this.jdField_l_of_type_Boolean) {
            break label1023;
          }
          ((PBUInt32Field)localObject3).set(i);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (MessageForPic.class.isInstance(localObject3))
          {
            localObject4 = (MessageForPic)localObject3;
            ((im_msg_body.NotOnlineImage)localObject1).uint32_show_len.set(((MessageForPic)localObject4).mShowLength);
            ((im_msg_body.NotOnlineImage)localObject1).uint32_download_len.set(((MessageForPic)localObject4).mDownloadLength);
            ((im_msg_body.NotOnlineImage)localObject1).img_type.set(((MessageForPic)localObject4).imageType);
            if (((MessageForPic)localObject4).picExtraData != null)
            {
              localObject4 = ((MessageForPic)localObject4).picExtraData.getOfflineImageResvAttr();
              ((im_msg_body.NotOnlineImage)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject4).get()).toByteArray()), true);
            }
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int)
          {
          case 1008: 
            if (QLog.isColorLevel()) {
              b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject1).biz_type.get());
            }
            localObject4 = new im_msg_body.Elem();
            if (!FlashPicHelper.a((MessageRecord)localObject3)) {
              break label977;
            }
            localObject3 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(3);
            Object localObject5 = new hummer_commelem.MsgElemInfo_servtype3();
            ((hummer_commelem.MsgElemInfo_servtype3)localObject5).flash_c2c_pic.set((MessageMicro)localObject1);
            ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject5).toByteArray()));
            ((im_msg_body.Elem)localObject4).common_elem.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
            }
            localObject1 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8("[闪照]请使用新版手机QQ查看闪照。"));
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            if (!(localObject5 instanceof MessageForStructing)) {
              break label1021;
            }
            localObject3 = (MessageForStructing)localObject5;
            if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))) {
              break label1021;
            }
            StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            localObject4 = localStructMsgForImageShare.getFirstImageElement();
            if (localObject4 == null) {
              break label1021;
            }
            ((StructMsgItemImage)localObject4).w = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_f_of_type_JavaLangString != null) {
              break label998;
            }
            localObject1 = this.jdField_g_of_type_JavaLangString;
            ((StructMsgItemImage)localObject4).v = ((String)localObject1);
            ((StructMsgItemImage)localObject4).d = this.jdField_q_of_type_Long;
            ((StructMsgItemImage)localObject4).jdField_e_of_type_Long = ((MessageRecord)localObject5).time;
            if (!AIOGallerySceneWithBusiness.b(localStructMsgForImageShare.mMsgActionData)) {
              break label1006;
            }
            localObject5 = ((StructMsgItemImage)localObject4).u;
            ((StructMsgItemImage)localObject4).u = "";
            localObject1 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
            ((StructMsgItemImage)localObject4).u = ((String)localObject5);
            if ((TextUtils.isEmpty(((MessageForStructing)localObject3).frienduin)) || (localObject1 == null)) {
              break label1021;
            }
            localObject3 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            break label1021;
            if ((!MessageForStructing.class.isInstance(localObject3)) || (!((MessageForStructing)localObject3).isHotPicsStruct())) {
              continue;
            }
            localObject4 = new NotOnlineImageExtPb.ResvAttr();
            ((NotOnlineImageExtPb.ResvAttr)localObject4).uint32_image_biz_type.set(2);
            ((im_msg_body.NotOnlineImage)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject4).get()).toByteArray()), true);
            continue;
            localException.biz_type.set(2);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        continue;
        localException.biz_type.set(3);
        continue;
        localException.biz_type.set(4);
        continue;
        localException.biz_type.set(5);
        continue;
        localException.biz_type.set(6);
        continue;
        localException.biz_type.set(7);
        continue;
        localException.biz_type.set(8);
        continue;
        localException.biz_type.set(9);
        continue;
        ((im_msg_body.Elem)localObject4).not_online_image.set(localException);
        localRichText.elems.add((MessageMicro)localObject4);
        continue;
        Object localObject2 = this.jdField_f_of_type_JavaLangString;
        continue;
        localObject2 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
      }
      return localRichText;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject).mergeFrom(paramArrayOfByte);
        if (((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.has())
        {
          paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.get().toByteArray();
          localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + paramArrayOfByte.length);
          }
          Cryptor localCryptor = new Cryptor();
          if (this.jdField_d_of_type_ArrayOfByte != null)
          {
            localObject = localCryptor.decrypt((byte[])localObject, 0, paramArrayOfByte.length, this.jdField_d_of_type_ArrayOfByte);
            if ((localObject != null) && (localObject.length > 36))
            {
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + localObject.length);
              }
              paramArrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
              int j = ByteBuffer.wrap(paramArrayOfByte).getShort(34);
              localObject = new char[j];
              while (i < j)
              {
                localObject[i] = ((char)paramArrayOfByte[(i + 36)]);
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
          }
        }
        paramArrayOfByte = String.valueOf((char[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileId_str:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_g_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_f_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_g_of_type_JavaLangString = paramArrayOfByte;
      }
    }
  }
  
  private byte[] a()
  {
    this.jdField_d_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getSessionKey();
    if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
      }
    }
    byte[] arrayOfByte;
    do
    {
      long l1;
      long l2;
      int i;
      int j;
      for (;;)
      {
        return null;
        this.jdField_e_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).getHttpconn_sig_session();
        if ((this.jdField_e_of_type_ArrayOfByte == null) || (this.jdField_e_of_type_ArrayOfByte.length == 0))
        {
          if (QLog.isColorLevel())
          {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            return null;
          }
        }
        else {
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString).longValue();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.jdField_q_of_type_Long;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.jdField_a_of_type_ArrayOfByte;
            if ((localObject1 == null) || (localObject1.length == 0))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
              return null;
            }
          }
          catch (Exception localException)
          {
            QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
            return null;
          }
        }
      }
      localObject2 = ByteBuffer.allocate(localException.length + 56 + 8);
      ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
      localObject2 = ((ByteBuffer)localObject2).array();
      System.arraycopy(localException, 0, localObject2, 28, localException.length);
      arrayOfByte = new Cryptor().encrypt((byte[])localObject2, this.jdField_d_of_type_ArrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
    return null;
    Object localObject2 = new CSDataHighwayHead.NewServiceTicket();
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom(arrayOfByte));
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_e_of_type_ArrayOfByte));
    return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
  }
  
  private byte[] b()
  {
    int j = 6;
    int k = 3;
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    localPicInfoExt.uint32_busi_type.set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = j;
    switch (NetworkCenter.a().a())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = NetworkCenter.a().a();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.jdField_o_of_type_Int);
      localPicInfoExt.uint32_pic_height.set(this.p);
      if (!this.jdField_l_of_type_Boolean) {
        break;
      }
    }
    for (i = k;; i = 1)
    {
      localPicInfoExt.uint32_pic_flag.set(i);
      return localPicInfoExt.toByteArray();
      i = 3;
      break;
      i = 7;
      break;
      i = 8;
      break;
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new aiou(this));
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.jdField_g_of_type_Long = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_h_of_type_Long = 0L;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_q_of_type_Long - paramLong;
    if (!this.jdField_d_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.jdField_s_of_type_Long, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    String str = c();
    if ((str == null) || (str.equals(""))) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_c_of_type_JavaLangString = str;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    if (!this.jdField_g_of_type_Boolean)
    {
      paramArrayOfByte = MD5.toMD5(paramArrayOfByte);
      localStringBuilder.append("?ver=");
      localStringBuilder.append("2");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
      localStringBuilder.append("&filekey=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_q_of_type_Long);
      localStringBuilder.append("&bmd5");
      localStringBuilder.append(paramArrayOfByte);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("cgi-bin/httpconn?htcmd=0x6ff0070&ver=5345");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.jdField_l_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_q_of_type_Long);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("&range=");
      localStringBuilder.append(this.jdField_s_of_type_Long);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_o_of_type_Boolean) || (this.jdField_k_of_type_Boolean)) {}
    for (;;)
    {
      return;
      b("onResp", "result:" + paramNetResp.jdField_a_of_type_Int + " errCode:" + paramNetResp.jdField_b_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      int i = paramNetResp.jdField_c_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      long l3;
      for (;;)
      {
        try
        {
          if (paramNetResp.jdField_a_of_type_Int != 0) {
            break label632;
          }
          this.jdField_l_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
          if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
          {
            l3 = 9223372036854775807L;
            if ((l3 == 0L) || (l3 == 9223372036854775807L)) {
              break;
            }
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            if (C2CPicUpHandler.a((int)l3)) {
              break;
            }
            a(-9527, null, a(i, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
          }
        }
        catch (Exception paramNetResp)
        {
          a(9343, MsfSdkUtils.getStackTraceString(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
      }
      long l1;
      long l2;
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = 9223372036854775807L;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          l2 = l1;
          if (localObject == null) {}
        }
      }
      try
      {
        for (;;)
        {
          i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l2 = i;
          if (l2 == 9223372036854775807L)
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
        for (;;)
        {
          localException2.printStackTrace();
          l2 = 9223372036854775807L;
        }
        b("decodeHttpResp", "from " + this.jdField_s_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 <= this.jdField_s_of_type_Long)
        {
          if (this.jdField_s_of_type_Int < 3)
          {
            b("procHttpRespBody", "server offset rollback");
            this.jdField_s_of_type_Int += 1;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = l2;
          this.jdField_s_of_type_Long = l2;
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l2 >= this.jdField_q_of_type_Long) {
            break label620;
          }
          if (this.jdField_o_of_type_Boolean) {
            continue;
          }
          g();
          r();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l3);
        a(-9527, "", a(this.jdField_i_of_type_JavaLangString, this.jdField_f_of_type_Int), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        label620:
        s();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
    }
    label632:
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
      r();
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    b(paramNetResp.jdField_b_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
    d();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    super.a(paramRichProtoReq, paramRichProtoResp);
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    label97:
    Object localObject;
    String str;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramRichProtoReq.toString());
        }
        this.jdField_j_of_type_Boolean = paramRichProtoReq.jdField_e_of_type_Boolean;
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label726;
        }
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          b(true);
          if (!paramRichProtoReq.jdField_a_of_type_Boolean) {
            break label252;
          }
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          ((FileMsg)localObject).jdField_g_of_type_JavaLangString = str;
          this.jdField_f_of_type_JavaLangString = str;
          localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
          paramRichProtoReq = paramRichProtoReq.jdField_b_of_type_JavaLangString;
          ((FileMsg)localObject).jdField_h_of_type_JavaLangString = paramRichProtoReq;
          this.jdField_g_of_type_JavaLangString = paramRichProtoReq;
          if (!this.jdField_a_of_type_Boolean) {
            break label245;
          }
          if ((!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()))
          {
            this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
            s();
          }
        }
        for (;;)
        {
          i += 1;
          break;
          b(false);
          break label97;
          label245:
          s();
        }
        label252:
        d(1002);
        if (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h) {
          break label284;
        }
        b(9333, "Server MD5 fast forward missed");
        d();
      }
    }
    label284:
    label562:
    label726:
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.p = false;
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "HotPicReSend Requeset");
          }
          q();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.q)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.q = false;
          q();
          return;
        }
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        ((FileMsg)localObject).jdField_g_of_type_JavaLangString = str;
        this.jdField_f_of_type_JavaLangString = str;
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
        str = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        ((FileMsg)localObject).jdField_h_of_type_JavaLangString = str;
        this.jdField_g_of_type_JavaLangString = str;
      }
      boolean bool;
      for (;;)
      {
        this.jdField_l_of_type_JavaLangString = paramRichProtoReq.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_g_of_type_Boolean = paramRichProtoReq.jdField_b_of_type_Boolean;
        bool = paramRichProtoReq.jdField_d_of_type_Boolean;
        this.jdField_r_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
        if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_e_of_type_Boolean) && (!paramRichProtoReq.jdField_c_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
        }
        if (this.v != 2) {
          break label562;
        }
        d("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
        r();
        break;
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
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
          if (this.jdField_a_of_type_Boolean)
          {
            if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) {
              break;
            }
            this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.continueTrans();
            this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
            break;
          }
          an_();
          break;
        }
        d("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.v = 2;
        r();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
        break;
      }
      localObject = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.v == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        d(paramRichProtoReq);
        break;
      }
      d("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.v = 2;
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    d();
  }
  
  protected void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (this.jdField_u_of_type_Int == 1)
      {
        this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Int = 1;
        bool = true;
      }
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    Object localObject = this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(21) + ";" + this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(22);
    if (QLog.isColorLevel())
    {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + str2);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";mStepTrans: " + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";mStepMsg: " + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";mStepTransPre: " + this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";mStepTransLeft: " + this.jdField_f_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.toString() + ";");
    }
    if (!bool)
    {
      if (this.jdField_j_of_type_Int == 9004) {
        break label329;
      }
      if (f()) {}
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int == 1030) {}
    label329:
    while (((!bool) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) || (this.jdField_i_of_type_Boolean) || ((bool) && ((this.m & 0x2) > 0)) || ((!bool) && ((this.m & 0x1) > 0)))
    {
      return;
      str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
      if ("connError_unreachable".equalsIgnoreCase(str1))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        break;
      }
      if (!"connError_noroute".equalsIgnoreCase(str1)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
      break;
    }
    int j = this.m;
    int i;
    if (bool)
    {
      i = 2;
      this.m = (i | j);
      if (this.v != 1) {
        break label1367;
      }
    }
    label1213:
    label1367:
    for (String str1 = "actC2CPicUploadV2";; str1 = "actC2CPicUploadV1")
    {
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      long l3 = System.nanoTime();
      long l2 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
      Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_b_of_type_Long - this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Long) / 1000000L);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_openUpStep", localObject);
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str2 = this.jdField_g_of_type_JavaLangString;
        label601:
        ((HashMap)localObject).put("param_uuid", str2);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_f_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", StatisticConstants.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", NetworkUtil.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_j_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.t));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_openUp", String.valueOf(this.jdField_a_of_type_Boolean));
        if (!bool) {
          break label1213;
        }
        o();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean)
        {
          long l1 = 0L;
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
            QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_j_of_type_Boolean + ",Percent = " + d1);
          }
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        l();
        return;
        i = 1;
        break;
        str2 = this.jdField_f_of_type_JavaLangString;
        break label601;
        if (this.jdField_j_of_type_Int != -9527) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
    }
  }
  
  public void an_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_e_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    }
    while (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    }
    Object localObject = HexUtil.a(this.jdField_l_of_type_JavaLangString);
    aiov localaiov = new aiov(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localaiov, this.jdField_a_of_type_Int, this.jdField_c_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);; this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_a_of_type_ArrayOfByte, localaiov))
    {
      localObject = new aioy(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_g_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
  }
  
  public void ap_()
  {
    super.ap_();
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    Object localObject1 = a();
    if ((localObject1 != null) && (((TransferRequest)localObject1).h))
    {
      this.jdField_o_of_type_Int = ((TransferRequest)localObject1).jdField_l_of_type_Int;
      this.p = ((TransferRequest)localObject1).m;
      this.jdField_q_of_type_Long = ((TransferRequest)localObject1).jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.a(((TransferRequest)localObject1).jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = ((TransferRequest)localObject1).jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      q();
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!e()))
    {
      b(9041, "No Local MD5");
      d();
      return;
    }
    if ((this.p == 0) || (this.jdField_o_of_type_Int == 0))
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      this.p = ((BitmapFactory.Options)localObject1).outHeight;
      this.jdField_o_of_type_Int = ((BitmapFactory.Options)localObject1).outWidth;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_b_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_c_of_type_ArrayOfByte = b();
      if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_b_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        q();
        an_();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.jdField_a_of_type_Boolean = false;
      q();
      return;
    }
    q();
  }
  
  public int b()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.jdField_o_of_type_Boolean = false;
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      if (this.v != 1)
      {
        this.jdField_f_of_type_JavaLangString = null;
        this.jdField_g_of_type_JavaLangString = null;
        this.jdField_s_of_type_Long = 0L;
      }
      this.jdField_l_of_type_JavaLangString = null;
      this.jdField_g_of_type_Boolean = false;
      this.jdField_q_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      v();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new aioz(this));
    }
    return 0;
  }
  
  public int c()
  {
    Object localObject = a();
    if ((localObject != null) && (((TransferRequest)localObject).h))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
        this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_JavaLangString;
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
    localObject = FileUtils.a((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(FileUtils.jdField_a_of_type_JavaLangString)) || (!FileUtils.f((String)localObject)))
      {
        a(9072, (String)localObject, c((String)localObject), null);
        d();
        new Handler(Looper.getMainLooper()).post(new aiot(this));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
      this.jdField_l_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  String c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return "";
    }
    int i = this.jdField_r_of_type_Int;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(i % j);
    String str = "http://" + localServerAddr.jdField_a_of_type_JavaLangString;
    if (localServerAddr.jdField_a_of_type_Int != 80) {
      str = str + ":" + localServerAddr.jdField_a_of_type_Int;
    }
    for (;;)
    {
      return str + "/";
    }
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
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            if (this.jdField_f_of_type_JavaLangString == null) {}
            for (str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.w = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localStructMsgItemImage.v = str;
      localStructMsgItemImage.d = this.jdField_q_of_type_Long;
      localStructMsgItemImage.jdField_e_of_type_Long = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  public void e()
  {
    super.e();
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_g_of_type_JavaLangString;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPicUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPicUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_c_of_type_Int = this.jdField_o_of_type_Int;
    localPicUpReq.jdField_d_of_type_Int = this.p;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localPicUpReq.jdField_c_of_type_Boolean = bool;
      localPicUpReq.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      a(localPicUpReq);
      DoutuUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest, localPicUpReq);
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localPicUpReq.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.t = ((MessageForPic)localMessageRecord).imageType;
      }
      if (c()) {
        break label257;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label257:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localRichProtoReq.toString());
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void r()
  {
    long l1 = 14600L;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l4 = this.jdField_s_of_type_Long;
    long l2 = this.jdField_q_of_type_Long - l4;
    if (!this.jdField_d_of_type_Boolean)
    {
      long l3 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.jdField_s_of_type_Long, -1);
      l1 = l3;
      if (l2 >= l3) {}
    }
    Object localObject2;
    do
    {
      l1 = l2;
      byte[] arrayOfByte;
      for (;;)
      {
        l1 = Math.min(l1, 131072L);
        arrayOfByte = a((int)l4, (int)l1);
        if (arrayOfByte != null) {
          break;
        }
        d();
        return;
        if (l2 < 14600L) {
          l1 = this.jdField_q_of_type_Long - l4;
        }
      }
      b("sendingdata", "pos:" + l4 + "  transferData len:" + arrayOfByte.length);
      localObject2 = a(arrayOfByte);
      Object localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = a((String)localObject2, this.jdField_a_of_type_JavaUtilArrayList);
        BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((HttpNetReq)localObject2).jdField_a_of_type_Int = 1;
      ((HttpNetReq)localObject2).jdField_a_of_type_ArrayOfByte = arrayOfByte;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      ((HttpNetReq)localObject2).jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      ((HttpNetReq)localObject2).jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      ((HttpNetReq)localObject2).jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      ((HttpNetReq)localObject2).jdField_k_of_type_Boolean = true;
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_s_of_type_Long + "-");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      ((HttpNetReq)localObject2).jdField_d_of_type_Boolean = true;
      if (l4 + l1 >= this.jdField_q_of_type_Long) {
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!d());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject2);
  }
  
  public void s()
  {
    if (!d())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.v);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    d(1003);
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
        ((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
      }
      e();
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label472;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label445;
      }
    }
    label445:
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
    label472:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
      if (((MessageForPic)localObject1).isBlessPic)
      {
        ((MessageForPic)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(999, true, ((MessageRecord)localObject1).frienduin);
        return;
      }
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!c())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void t()
  {
    if (this.jdField_o_of_type_Boolean) {
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) || (this.jdField_g_of_type_JavaLangString != null))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        s();
        return;
      }
      u();
      return;
    }
    ap_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */