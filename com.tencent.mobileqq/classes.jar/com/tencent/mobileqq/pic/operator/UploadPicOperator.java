package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBaseDecorator;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PicUploadExtra;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

public class UploadPicOperator
  extends BasePicOperator
  implements UpCallBack, IPicInfoBuilder.UploadInfoBuilder
{
  public MessageRecord a(PicUploadInfo paramPicUploadInfo)
  {
    long l = System.currentTimeMillis();
    if (paramPicUploadInfo != null)
    {
      MessageForPic localMessageForPic = (MessageForPic)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramPicUploadInfo.jdField_c_of_type_JavaLangString, paramPicUploadInfo.jdField_d_of_type_JavaLangString, paramPicUploadInfo.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramPicUploadInfo.jdField_a_of_type_Int;
      localMessageForPic.path = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramPicUploadInfo.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      localMessageForPic.localUUID = paramPicUploadInfo.jdField_a_of_type_JavaLangString;
      Object localObject = this.jdField_b_of_type_JavaLangString;
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMessageForPic.localUUID);
      localStringBuilder.append("|");
      localStringBuilder.append(localMessageForPic.uniseq);
      Logger.a((String)localObject, str, "bindUrlKeyAndUniseq", localStringBuilder.toString());
      localMessageForPic.md5 = a(localMessageForPic.path);
      c(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.thumbWidth = paramPicUploadInfo.jdField_e_of_type_Int;
      localMessageForPic.thumbHeight = paramPicUploadInfo.jdField_f_of_type_Int;
      a(paramPicUploadInfo, localMessageForPic);
      localMessageForPic.extLong = paramPicUploadInfo.jdField_i_of_type_Int;
      localMessageForPic.extStr = paramPicUploadInfo.jdField_i_of_type_JavaLangString;
      localMessageForPic.msgVia = paramPicUploadInfo.jdField_n_of_type_Int;
      localMessageForPic.sync2Story = paramPicUploadInfo.jdField_g_of_type_Boolean;
      str = MessageConstants.m;
      if (localMessageForPic.sync2Story) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
      a(localMessageForPic, paramPicUploadInfo);
      localObject = paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        b(paramPicUploadInfo, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
      localMessageForPic.serial();
      paramPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
      localObject = this.jdField_b_of_type_JavaLangString;
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cost:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      Logger.a((String)localObject, str, "packMsg", localStringBuilder.toString());
      a(localMessageForPic);
      localMessageForPic.DSKey = paramPicUploadInfo.jdField_b_of_type_Long;
      return localMessageForPic;
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  protected PicUploadInfo.Builder a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("uin");
    String str2 = paramIntent.getStringExtra("troop_uin");
    int i = paramIntent.getIntExtra("uintype", 1003);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    String str3 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
    int m = paramIntent.getIntExtra("entrance", 0);
    int n = paramIntent.getIntExtra("key_confess_topicid", 0);
    boolean bool = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
    String str1 = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.d((String)localObject);
    localBuilder.a(str3);
    localBuilder.e(i);
    localBuilder.e(str2);
    localBuilder.d(k);
    localBuilder.f(j);
    localBuilder.l(n);
    localBuilder.k(m);
    localBuilder.a(bool);
    if (!TextUtils.isEmpty(str1))
    {
      localObject = new PicUploadExtra();
      ((PicUploadExtra)localObject).jdField_a_of_type_JavaLangString = str1;
      ((PicUploadExtra)localObject).jdField_b_of_type_JavaLangString = paramIntent;
      localBuilder.a((PicUploadExtra)localObject);
    }
    return localBuilder;
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = a(paramIntent);
      if (localObject == null) {
        return null;
      }
      localObject = ((PicUploadInfo.Builder)localObject).a();
      int i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        String str = paramIntent.getStringExtra("key_qzone_album_id");
        ((PicUploadInfo)localObject).p = i;
        ((PicUploadInfo)localObject).j = str;
        ((PicUploadInfo)localObject).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((PicUploadInfo)localObject).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((PicUploadInfo)localObject).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      boolean bool1 = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
      boolean bool2 = paramIntent.getBooleanExtra("HOT_PIC_SEND_PIC", false);
      i = paramIntent.getIntExtra("key_pic_send_source", 0);
      if (((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra == null) {
        ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra = new PicUploadExtra();
      }
      ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_Int = i;
      ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_b_of_type_Boolean = bool1;
      ((PicUploadInfo)localObject).jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_c_of_type_Boolean = bool2;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  protected PicUploadInfo a(PicUploadInfo paramPicUploadInfo)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramPicUploadInfo.jdField_g_of_type_JavaLangString, 0);
    CompressOperator.b(localCompressInfo);
    if (localCompressInfo.jdField_e_of_type_JavaLangString != null)
    {
      paramPicUploadInfo.h = localCompressInfo.jdField_e_of_type_JavaLangString;
      paramPicUploadInfo.jdField_e_of_type_Int = localCompressInfo.d;
      paramPicUploadInfo.jdField_f_of_type_Int = localCompressInfo.jdField_e_of_type_Int;
    }
    return paramPicUploadInfo;
  }
  
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    b();
    Object localObject1 = a(a(paramPicUploadInfo));
    if (localObject1 == null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, "doSendPic", "error, mr==null, return");
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doSendPic, entrance: ");
      ((StringBuilder)localObject2).append(((MessageForPic)localObject1).msgVia);
      QLog.d("MsgVia", 2, ((StringBuilder)localObject2).toString());
    }
    a((MessageRecord)localObject1, paramPicReq);
    if (MessageForPic.class.isInstance(localObject1))
    {
      a(paramPicReq, (MessageRecord)localObject1, paramPicUploadInfo);
      b((MessageForPic)localObject1);
    }
    if ((((MessageRecord)localObject1).istroop == 1) && (paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo == null)) {
      ((IDep)QRoute.api(IDep.class)).bindAnonymousInfo((MessageRecord)localObject1);
    }
    if (paramPicUploadInfo.jdField_c_of_type_Boolean) {
      try
      {
        paramPicUploadInfo.jdField_a_of_type_JavaLangObject = localObject1;
        paramPicUploadInfo.notifyAll();
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("PresendStatus: destPath:");
        ((StringBuilder)localObject3).append(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
        ((StringBuilder)localObject3).append(",uuid:");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject3).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true");
        Logger.a(localObject2, "doSendPic ", ((StringBuilder)localObject3).toString());
        if (paramPicUploadInfo.jdField_c_of_type_Int == 3)
        {
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic ", "FLAG_NOT_UPLOAD,do not upload!");
          paramPicReq = this.jdField_b_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PresendStatus: destPath:");
          ((StringBuilder)localObject1).append(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(",uuid:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, FLAG_NOT_UPLOAD,do not upload!");
          Logger.a(paramPicReq, "doSendPic", ((StringBuilder)localObject1).toString());
          return null;
        }
      }
      finally {}
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject1);
    long l = System.currentTimeMillis();
    paramPicReq = a(paramPicReq, paramPicUploadInfo, (MessageRecord)localObject1);
    if (paramPicUploadInfo.jdField_c_of_type_Boolean) {
      try
      {
        if (paramPicUploadInfo.jdField_d_of_type_Boolean)
        {
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic cancel transferAsync!", "");
          paramPicReq = this.jdField_b_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("PresendStatus: destPath:");
          ((StringBuilder)localObject1).append(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(",uuid:");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:false");
          Logger.a(paramPicReq, "doSendPic ", ((StringBuilder)localObject1).toString());
          return null;
        }
        Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "PresendPic doSendPic start transferAsync!", "");
        ((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "")).transferAsync(paramPicReq);
        localObject2 = this.jdField_b_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("PresendStatus: destPath:");
        ((StringBuilder)localObject3).append(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
        ((StringBuilder)localObject3).append(",uuid:");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject3).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        Logger.a(localObject2, "doSendPic ", ((StringBuilder)localObject3).toString());
      }
      finally {}
    } else {
      ((ITransFileController)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITransFileController.class, "")).transferAsync(paramPicReq);
    }
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    Object localObject3 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a((String)localObject2, (String)localObject3, "sendReq", localStringBuilder.toString());
    if ((paramPicUploadInfo.jdField_b_of_type_Boolean) && (!paramPicUploadInfo.jdField_c_of_type_Boolean))
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic", "@#addMsg");
      a((MessageRecord)localObject1, paramPicUploadInfo.jdField_g_of_type_Long);
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "getSendTask.start", "");
    return paramPicReq;
  }
  
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo, MessageRecord paramMessageRecord)
  {
    paramPicReq = new TransferRequest();
    paramPicReq.mSelfUin = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    paramPicReq.mPeerUin = paramMessageRecord.frienduin;
    paramPicReq.mSecondId = paramMessageRecord.senderuin;
    paramPicReq.mUinType = paramMessageRecord.istroop;
    boolean bool = true;
    paramPicReq.mFileType = 1;
    paramPicReq.mUniseq = paramMessageRecord.uniseq;
    paramPicReq.mIsUp = true;
    paramPicReq.mBusiType = paramPicUploadInfo.jdField_a_of_type_Int;
    paramPicReq.mLocalPath = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
    paramPicReq.mMd5 = paramPicUploadInfo.jdField_f_of_type_JavaLangString;
    paramMessageRecord = new TransferRequest.PicUpExtraInfo();
    if (paramPicUploadInfo.a() != 1) {
      bool = false;
    }
    paramMessageRecord.mIsRaw = bool;
    paramPicReq.mExtraObj = paramMessageRecord;
    paramPicReq.mUpCallBack = this;
    paramPicReq.mRec = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    paramPicReq.mIsPresend = paramPicUploadInfo.jdField_c_of_type_Boolean;
    paramPicReq.myPresendInvalid = paramPicUploadInfo.jdField_e_of_type_Boolean;
    if (paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) {
      paramPicReq.mPicSendSource = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_Int;
    }
    return paramPicReq;
  }
  
  String a(String paramString)
  {
    str = "";
    long l = System.currentTimeMillis();
    try
    {
      try
      {
        localObject = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
        paramString = (String)localObject;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject;
      label34:
      break label34;
    }
    localObject = new File(paramString);
    paramString = str;
    if (((File)localObject).exists()) {}
    try
    {
      paramString = MD5FileUtil.a((File)localObject);
      if (paramString == null) {
        paramString = "";
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        paramString = str;
      }
    }
    str = this.jdField_b_of_type_JavaLangString;
    localObject = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("md5:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(str, (String)localObject, "calcMD5", localStringBuilder.toString());
    return paramString;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq);
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindConfessInfo((BaseQQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString, paramPicUploadInfo.jdField_b_of_type_Int, paramPicUploadInfo.o);
    if (paramPicUploadInfo.jdField_b_of_type_Int == 0) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo((BaseQQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString);
    } else if (paramPicUploadInfo.jdField_b_of_type_Int == 1) {
      ((IConfessMsgUtil)QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo((BaseQQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageForPic, paramPicUploadInfo.jdField_c_of_type_JavaLangString);
    }
    if (paramPicUploadInfo.p == 1)
    {
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramPicUploadInfo.j);
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramPicUploadInfo.jdField_d_of_type_Long));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramPicUploadInfo.jdField_g_of_type_Int));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramPicUploadInfo.jdField_e_of_type_Long));
      paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramPicUploadInfo.jdField_f_of_type_Long));
    }
    if (paramPicUploadInfo.jdField_i_of_type_Boolean) {
      paramMessageForPic.isStoryPhoto = true;
    }
    PicMessageExtraData localPicMessageExtraData2 = paramMessageForPic.picExtraData;
    PicMessageExtraData localPicMessageExtraData1 = localPicMessageExtraData2;
    if (localPicMessageExtraData2 == null) {
      localPicMessageExtraData1 = new PicMessageExtraData();
    }
    if (paramPicUploadInfo.d()) {
      localPicMessageExtraData1.imageBizType = 13;
    } else if (paramPicUploadInfo.e()) {
      localPicMessageExtraData1.imageBizType = 2;
    }
    paramMessageForPic.picExtraData = localPicMessageExtraData1;
  }
  
  protected void a(MessageRecord paramMessageRecord, PicReq paramPicReq)
  {
    ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(paramMessageRecord.uniseq, 0L, paramPicReq.jdField_c_of_type_Int);
  }
  
  public void a(PicReq paramPicReq)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo))
    {
      b(paramPicReq);
      return;
    }
    a(3, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  protected void a(PicReq paramPicReq, MessageRecord paramMessageRecord, PicUploadInfo paramPicUploadInfo)
  {
    Object localObject1;
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData != null)
    {
      localObject1 = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject1).picExtraData = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      localObject2 = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
      ((IDep)QRoute.api(IDep.class)).fillStickInfo((MessageForPic)localObject1, (PicMessageExtraData)localObject2);
    }
    Object localObject2 = (MessageForPic)paramMessageRecord;
    if (((MessageForPic)localObject2).checkGif())
    {
      localObject1 = ((MessageForPic)localObject2).picExtraData;
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject1 == null) {
        paramMessageRecord = new PicMessageExtraData();
      }
      if (TextUtils.isEmpty(paramMessageRecord.textSummary)) {
        paramMessageRecord.textSummary = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691279);
      }
      paramMessageRecord.emojiPkgId = String.valueOf(paramPicUploadInfo.s);
      paramMessageRecord.from = paramPicUploadInfo.r;
      paramMessageRecord.source = paramPicUploadInfo.k;
      paramMessageRecord.webUrl = paramPicUploadInfo.l;
      paramMessageRecord.iconUrl = paramPicUploadInfo.m;
      paramMessageRecord.packageName = paramPicUploadInfo.jdField_n_of_type_JavaLangString;
      if ((paramMessageRecord.imageBizType <= 0) && ((paramPicReq.jdField_b_of_type_Int == 1050) || (paramPicReq.jdField_b_of_type_Int == 1051) || (paramPicReq.jdField_b_of_type_Int == 1052))) {
        paramMessageRecord.imageBizType = 11;
      }
      ((MessageForPic)localObject2).picExtraData = paramMessageRecord;
    }
    if ((paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra != null) && (!TextUtils.isEmpty(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_JavaLangString)))
    {
      localObject1 = ((MessageForPic)localObject2).picExtraData;
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject1 == null) {
        paramMessageRecord = new PicMessageExtraData();
      }
      paramMessageRecord.mTemplateId = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_JavaLangString;
      paramMessageRecord.mTemplateName = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_b_of_type_JavaLangString;
      ((MessageForPic)localObject2).picExtraData = paramMessageRecord;
    }
    if (paramPicReq.jdField_b_of_type_Int == 1053)
    {
      paramMessageRecord = ((MessageForPic)localObject2).picExtraData;
      paramPicReq = paramMessageRecord;
      if (paramMessageRecord == null) {
        paramPicReq = new PicMessageExtraData();
      }
      paramPicReq.imageBizType = 14;
      ((MessageForPic)localObject2).picExtraData = paramPicReq;
    }
  }
  
  void a(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    Object localObject = new File(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        paramMessageForPic.imageType = 2000;
      } else {
        paramMessageForPic.imageType = PicBusUtil.a(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(paramPicUploadInfo.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      paramMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(paramPicUploadInfo.jdField_g_of_type_JavaLangString))
      {
        paramMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        paramMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel())
        {
          paramPicUploadInfo = this.jdField_b_of_type_JavaLangString;
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" pic is Landscape,swap w,h; options.outWidth = ");
          localStringBuilder.append(((BitmapFactory.Options)localObject).outWidth);
          localStringBuilder.append(",options.outHeight = ");
          localStringBuilder.append(((BitmapFactory.Options)localObject).outHeight);
          localStringBuilder.append(",mr.width = ");
          localStringBuilder.append(paramMessageForPic.width);
          localStringBuilder.append(",mr.height = ");
          localStringBuilder.append(paramMessageForPic.height);
          Logger.a(paramPicUploadInfo, str, "packMsg", localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Object localObject = this.jdField_b_of_type_JavaLangString;
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resut:");
      localStringBuilder.append(paramSendResult);
      Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
      localObject = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((MessageForPic)localObject).size = paramSendResult.jdField_a_of_type_Long;
      ((MessageForPic)localObject).uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      ((MessageForPic)localObject).groupFileID = paramSendResult.jdField_b_of_type_Long;
      ((MessageForPic)localObject).md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      ((MessageForPic)localObject).serial();
      c((MessageForPic)localObject);
    }
  }
  
  protected boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      String str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicUploadInfo);
      Logger.a(str1, str2, "checkPicUploadInfo", localStringBuilder.toString());
      if ((paramPicUploadInfo.a()) && (b(paramPicUploadInfo))) {
        return true;
      }
    }
    else
    {
      Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    }
    return false;
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().preConnect();
  }
  
  protected void b(MessageForPic paramMessageForPic)
  {
    ((IPicHelper)QRoute.api(IPicHelper.class)).cachePicToDisk(paramMessageForPic);
  }
  
  protected void b(PicReq paramPicReq)
  {
    PicUploadInfo localPicUploadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManagerV2.excute(new UploadPicOperator.2(this, paramPicReq, localPicUploadInfo), 16, null, false);
      return;
    }
    a(paramPicReq, localPicUploadInfo);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(3, null);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_Int == 4)))
    {
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        a(paramSendResult);
        c(paramSendResult);
        localObject = new PicResult();
        ((PicResult)localObject).jdField_a_of_type_Int = 0;
        ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
        a(3, (PicResult)localObject);
        return;
      }
      Object localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
      a(3, (PicInfoInterface.ErrInfo)localObject);
    }
  }
  
  protected boolean b(PicUploadInfo paramPicUploadInfo)
  {
    Object localObject = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
    int i = paramPicUploadInfo.jdField_g_of_type_Int;
    int j = paramPicUploadInfo.jdField_a_of_type_Int;
    localObject = PhotoIncompatibleBase.a((String)localObject);
    boolean bool2 = true;
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = new PhotoIncompatibleBaseDecorator((PhotoIncompatibleBase)localObject);
      if (i == 1)
      {
        localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
        if (localObject != null)
        {
          paramPicUploadInfo.jdField_g_of_type_JavaLangString = ((String)localObject);
          break label165;
        }
        paramPicUploadInfo.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
      }
      else if (j == 1006)
      {
        localObject = ((PhotoIncompatibleBaseDecorator)localObject).a();
        if (localObject != null)
        {
          paramPicUploadInfo.jdField_g_of_type_JavaLangString = ((String)localObject);
          break label165;
        }
        paramPicUploadInfo.a("PicBaseInfo.check", "incompatible photo generate jpg fail");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("incompatible file,and not PROTOCOL_RAW_PIC:");
        ((StringBuilder)localObject).append(i);
        paramPicUploadInfo.a("PicBaseInfo.check", ((StringBuilder)localObject).toString());
      }
      bool1 = false;
      label165:
      bool2 = bool1;
      if (!bool1)
      {
        ThreadManagerV2.getUIHandlerV2().post(new UploadPicOperator.1(this));
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  void c(MessageForPic paramMessageForPic)
  {
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, paramMessageForPic.msgData);
  }
  
  void c(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramMessageForPic.thumbMsgUrl = paramPicUploadInfo.h;
  }
  
  void c(UpCallBack.SendResult paramSendResult)
  {
    PicStatisticsManager localPicStatisticsManager = ((PicPreDownloadImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
    if (localPicStatisticsManager != null) {
      localPicStatisticsManager.a(13057, paramSendResult.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.UploadPicOperator
 * JD-Core Version:    0.7.0.1
 */