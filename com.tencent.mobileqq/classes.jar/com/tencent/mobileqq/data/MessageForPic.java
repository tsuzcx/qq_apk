package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msgbackup.util.MsgBackupRichTextParse;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.multimsg.api.MultiMsgBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicValue;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import localpb.richMsg.RichMsg.ForwardExtra;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public class MessageForPic
  extends MessageForRichText
  implements Parcelable, MsgBackupRichTextParse, LoggerInterface, PicUiInterface
{
  public static final String CHECK_IMAGE_TYPE = "check_image_type";
  public static final Parcelable.Creator<MessageForPic> CREATOR = new MessageForPic.1();
  private static final String TAG = "MessageForPic";
  public static int defaultSuMsgId = -1;
  public long DSKey = 0L;
  public String SpeedInfo;
  public String actMsgContentValue;
  public String action;
  public int aiofileType = -1;
  public boolean bEnableEnc = false;
  public String bigMsgUrl;
  public String bigThumbMsgUrl;
  public int busiType;
  public int fileSizeFlag;
  public Map<PicReq, Integer> forwardId = new HashMap();
  public long groupFileID;
  public long height;
  public int imageType;
  public boolean isBlessPic = false;
  public boolean isInMixedMsg;
  public boolean isMixed;
  public boolean isQzonePic = false;
  public boolean isRead;
  public int isReport = 0;
  public boolean isShareAppActionMsg;
  public boolean isStoryPhoto = false;
  public String localUUID;
  public int mCurrlength;
  public int mDownloadLength;
  public int mNotPredownloadReason = 0;
  public long mPresendTransferedSize;
  public int mShowLength;
  public String md5;
  @RecordForTest
  public msg_ctrl.MsgCtrl msgCtrl;
  public int msgVia;
  public String path;
  public PicMessageExtraData picExtraData;
  public int picExtraFlag;
  public Object picExtraObject;
  public int preDownNetworkType = -1;
  public int preDownState = -1;
  public int previewed;
  public String rawMsgUrl;
  public ReportInfo reportInfo;
  public String serverStoreSource;
  public long shareAppID;
  public long size;
  public int subMsgId = defaultSuMsgId;
  public int subMsgType = -1;
  public int subThumbHeight = -1;
  public int subThumbWidth = -1;
  public int subVersion = 5;
  public boolean sync2Story = false;
  public int thumbHeight;
  public String thumbMsgUrl;
  public int thumbSize = -1;
  public int thumbWidth;
  public ThumbWidthHeightDP thumbWidthHeightDP;
  public int type;
  public String uuid;
  public long width;
  
  public boolean checkGif()
  {
    int i = this.imageType;
    return (i == 3) || (i == 2000);
  }
  
  public void checkType()
  {
    if ((this.imageType == 0) && (!isSendFromLocal()) && (TextUtils.isEmpty(getExtInfoFromExtStr("check_image_type"))))
    {
      File localFile = AbsDownloader.getFile(((IPicHelper)QRoute.api(IPicHelper.class)).getURL(this, 1, null).toString());
      if (localFile != null)
      {
        if (GifDrawable.isGifFile(localFile))
        {
          this.imageType = 2000;
          updateMessage();
        }
        saveExtInfoToExtStr("check_image_type", String.valueOf(true));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    Object localObject1 = new RichMsg.PicRec();
    int i;
    try
    {
      ((RichMsg.PicRec)localObject1).mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      i = 0;
    }
    if (i != 0)
    {
      this.path = ((RichMsg.PicRec)localObject1).localPath.get();
      this.size = ((RichMsg.PicRec)localObject1).size.get();
      this.type = ((RichMsg.PicRec)localObject1).type.get();
      this.isRead = ((RichMsg.PicRec)localObject1).isRead.get();
      this.uuid = ((RichMsg.PicRec)localObject1).uuid.get();
      this.groupFileID = ((RichMsg.PicRec)localObject1).groupFileID.get();
      this.md5 = ((RichMsg.PicRec)localObject1).md5.get();
      this.serverStoreSource = ((RichMsg.PicRec)localObject1).serverStorageSource.get();
      this.thumbMsgUrl = ((RichMsg.PicRec)localObject1).thumbMsgUrl.get();
      this.bigThumbMsgUrl = ((RichMsg.PicRec)localObject1).bigthumbMsgUrl.get();
      this.thumbWidth = ((RichMsg.PicRec)localObject1).uint32_thumb_width.get();
      this.thumbHeight = ((RichMsg.PicRec)localObject1).uint32_thumb_height.get();
      this.width = ((RichMsg.PicRec)localObject1).uint32_width.get();
      this.height = ((RichMsg.PicRec)localObject1).uint32_height.get();
      this.imageType = ((RichMsg.PicRec)localObject1).uint32_image_type.get();
      this.bigMsgUrl = ((RichMsg.PicRec)localObject1).bigMsgUrl.get();
      this.rawMsgUrl = ((RichMsg.PicRec)localObject1).rawMsgUrl.get();
      this.isReport = ((RichMsg.PicRec)localObject1).isReport.get();
      this.subVersion = ((RichMsg.PicRec)localObject1).version.get();
      this.picExtraFlag = ((RichMsg.PicRec)localObject1).uiOperatorFlag.get();
      this.fileSizeFlag = ((RichMsg.PicRec)localObject1).fileSizeFlag.get();
      this.localUUID = ((RichMsg.PicRec)localObject1).localUUID.get();
      this.preDownState = ((RichMsg.PicRec)localObject1).preDownState.get();
      this.preDownNetworkType = ((RichMsg.PicRec)localObject1).preDownNetwork.get();
      this.previewed = ((RichMsg.PicRec)localObject1).previewed.get();
      this.mShowLength = ((RichMsg.PicRec)localObject1).uint32_show_len.get();
      this.mDownloadLength = ((RichMsg.PicRec)localObject1).uint32_download_len.get();
      this.mCurrlength = ((RichMsg.PicRec)localObject1).uint32_current_len.get();
      this.mNotPredownloadReason = ((RichMsg.PicRec)localObject1).notPredownloadReason.get();
      this.bEnableEnc = ((RichMsg.PicRec)localObject1).enableEnc.get();
      this.isStoryPhoto = ((RichMsg.PicRec)localObject1).bool_story_pic_send_to_recent.get();
      Object localObject3;
      if (((RichMsg.PicRec)localObject1).fowardInfo.has())
      {
        localObject3 = (RichMsg.ForwardExtra)((RichMsg.PicRec)localObject1).fowardInfo.get();
        if (localObject3 != null)
        {
          PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
          localPicFowardDbRecordData.fowardOrgId = ((RichMsg.ForwardExtra)localObject3).foward_orgId.get();
          localPicFowardDbRecordData.fowardOrgUin = ((RichMsg.ForwardExtra)localObject3).foward_orgUin.get();
          localPicFowardDbRecordData.fowardOrgUinType = ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.get();
          localPicFowardDbRecordData.fowardOrgFileSizeType = ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.get();
          localPicFowardDbRecordData.fowardOrgUrl = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl.get();
          localPicFowardDbRecordData.fowardThumbPath = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath.get();
          this.picExtraObject = localPicFowardDbRecordData;
        }
      }
      if ((((RichMsg.PicRec)localObject1).bytes_pb_reserved.has()) && (this.picExtraData == null))
      {
        localObject1 = ((RichMsg.PicRec)localObject1).bytes_pb_reserved.get().toByteArray();
        try
        {
          if (this.istroop == 0)
          {
            localObject3 = new NotOnlineImageExtPb.ResvAttr();
            ((NotOnlineImageExtPb.ResvAttr)localObject3).mergeFrom((byte[])localObject1);
            this.picExtraData = new PicMessageExtraData((NotOnlineImageExtPb.ResvAttr)localObject3);
          }
          else
          {
            localObject3 = new CustomFaceExtPb.ResvAttr();
            ((CustomFaceExtPb.ResvAttr)localObject3).mergeFrom((byte[])localObject1);
            this.picExtraData = new PicMessageExtraData((CustomFaceExtPb.ResvAttr)localObject3);
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MessageForPic", 4, "bytes_pb_reserved.has");
        }
      }
    }
    else
    {
      if (this.msg == null) {
        try
        {
          if (this.versionCode > 0) {
            this.msg = new String(this.msgData, "UTF-8");
          }
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MessageForPic", 2, localException1.getMessage());
          }
        }
      }
      this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
      boolean bool;
      if ((!this.isShareAppActionMsg) && (this.msgtype != -3001) && (this.msgtype != -30002) && (this.msgtype != -30003) && (this.msgtype != -1032)) {
        bool = false;
      } else {
        bool = true;
      }
      this.isMixed = bool;
      Object localObject2;
      if (this.isMixed)
      {
        localObject2 = ActionMsgUtil.a(this.msg);
        this.action = ((MsgBody)localObject2).action;
        this.shareAppID = ((MsgBody)localObject2).shareAppID;
        this.actMsgContentValue = ((MsgBody)localObject2).actMsgContentValue;
        localObject2 = ((MsgBody)localObject2).msg;
      }
      else
      {
        localObject2 = this.msg;
      }
      ((IPicHelper)QRoute.api(IPicHelper.class)).parseDbMsgOldVersion(this, (String)localObject2);
      this.subVersion = 0;
    }
    this.mIsParsed = true;
    ((IPicValue)QRoute.api(IPicValue.class)).fillStickInfo(this);
    if ("1".equals(getExtInfoFromExtStr(MessageConstants.m))) {
      this.sync2Story = true;
    } else {
      this.sync2Story = false;
    }
    this.isQzonePic = "1".equals(getExtInfoFromExtStr(MessageConstants.r));
  }
  
  public String getFilePath(String paramString)
  {
    if (isSendFromLocal())
    {
      localObject = getPicUploadInfo();
      ((PicUploadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
      return ((PicUploadInfo)localObject).c();
    }
    Object localObject = getPicDownloadInfo();
    ((PicDownloadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
    return ((PicDownloadInfo)localObject).c();
  }
  
  public PicDownloadInfo getPicDownloadInfo()
  {
    PicDownloadInfo localPicDownloadInfo = new PicDownloadInfo();
    localPicDownloadInfo.jdField_a_of_type_Int = this.busiType;
    localPicDownloadInfo.jdField_a_of_type_Long = this.uniseq;
    processSessionInfo(localPicDownloadInfo);
    localPicDownloadInfo.jdField_c_of_type_Long = this.time;
    localPicDownloadInfo.jdField_g_of_type_JavaLangString = this.uuid;
    localPicDownloadInfo.f = this.md5;
    localPicDownloadInfo.jdField_b_of_type_Long = this.groupFileID;
    localPicDownloadInfo.h = this.thumbMsgUrl;
    localPicDownloadInfo.k = this.bigThumbMsgUrl;
    localPicDownloadInfo.i = this.bigMsgUrl;
    localPicDownloadInfo.j = this.rawMsgUrl;
    localPicDownloadInfo.jdField_g_of_type_Int = this.subMsgId;
    localPicDownloadInfo.jdField_b_of_type_Boolean = this.isMixed;
    if (localPicDownloadInfo.jdField_b_of_type_Boolean)
    {
      localPicDownloadInfo.l = this.action;
      localPicDownloadInfo.m = this.actMsgContentValue;
      localPicDownloadInfo.jdField_e_of_type_Long = this.shareAppID;
    }
    localPicDownloadInfo.jdField_e_of_type_Int = this.fileSizeFlag;
    localPicDownloadInfo.jdField_c_of_type_Int = this.extraflag;
    localPicDownloadInfo.jdField_a_of_type_JavaLangObject = this.picExtraObject;
    localPicDownloadInfo.jdField_d_of_type_Int = this.subVersion;
    localPicDownloadInfo.jdField_a_of_type_JavaLangString = this.localUUID;
    localPicDownloadInfo.jdField_d_of_type_Long = this.size;
    localPicDownloadInfo.jdField_d_of_type_Boolean = this.bEnableEnc;
    if (this.reportInfo == null) {
      this.reportInfo = new ReportInfo();
    }
    localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo = this.reportInfo;
    return localPicDownloadInfo;
  }
  
  public PicUploadInfo getPicUploadInfo()
  {
    PicUploadInfo localPicUploadInfo = new PicUploadInfo();
    localPicUploadInfo.jdField_a_of_type_Int = this.busiType;
    localPicUploadInfo.jdField_a_of_type_Long = this.uniseq;
    localPicUploadInfo.jdField_b_of_type_Int = this.istroop;
    localPicUploadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    localPicUploadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    localPicUploadInfo.jdField_d_of_type_JavaLangString = this.senderuin;
    localPicUploadInfo.f = this.md5;
    localPicUploadInfo.jdField_g_of_type_JavaLangString = this.path;
    localPicUploadInfo.h = this.thumbMsgUrl;
    localPicUploadInfo.jdField_c_of_type_Int = this.picExtraFlag;
    localPicUploadInfo.jdField_a_of_type_JavaLangObject = this.picExtraObject;
    localPicUploadInfo.jdField_a_of_type_JavaLangString = this.localUUID;
    localPicUploadInfo.jdField_d_of_type_Int = this.subVersion;
    localPicUploadInfo.j = ((int)this.width);
    localPicUploadInfo.k = ((int)this.height);
    localPicUploadInfo.jdField_c_of_type_Long = ((int)this.size);
    localPicUploadInfo.m = this.imageType;
    return localPicUploadInfo;
  }
  
  public ReportInfo getReportInfo()
  {
    if (this.reportInfo == null) {
      this.reportInfo = new ReportInfo();
    }
    return this.reportInfo;
  }
  
  public im_msg_body.RichText getRichText()
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject1;
    Object localObject2;
    if ((this.istroop != 1) && (this.istroop != 3000))
    {
      localObject1 = new im_msg_body.NotOnlineImage();
      ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)this.size);
      ((im_msg_body.NotOnlineImage)localObject1).img_type.set(this.imageType);
      ((im_msg_body.NotOnlineImage)localObject1).str_thumb_url.set(this.thumbMsgUrl);
      ((im_msg_body.NotOnlineImage)localObject1).str_400_url.set(this.bigThumbMsgUrl);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_width.set(this.thumbWidth);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_thumb_height.set(this.thumbHeight);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_file_id.set((int)this.groupFileID);
      ((im_msg_body.NotOnlineImage)localObject1).str_big_url.set(this.bigMsgUrl);
      ((im_msg_body.NotOnlineImage)localObject1).str_orig_url.set(this.rawMsgUrl);
      ((im_msg_body.NotOnlineImage)localObject1).pic_width.set((int)this.width);
      ((im_msg_body.NotOnlineImage)localObject1).pic_height.set((int)this.height);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_show_len.set(this.mShowLength);
      ((im_msg_body.NotOnlineImage)localObject1).uint32_download_len.set(this.mDownloadLength);
      ((im_msg_body.NotOnlineImage)localObject1).original.set(this.fileSizeFlag);
      ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
      if (TextUtils.isEmpty(this.uuid)) {
        this.uuid = this.md5;
      }
      ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(this.uuid));
      localObject2 = this.picExtraData;
      if (localObject2 != null)
      {
        localObject2 = ((PicMessageExtraData)localObject2).getOfflineImageResvAttr();
        ((im_msg_body.NotOnlineImage)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
      }
      localElem.not_online_image.set((MessageMicro)localObject1);
    }
    else
    {
      localObject1 = new im_msg_body.CustomFace();
      if (this.uuid != null) {
        ((im_msg_body.CustomFace)localObject1).str_file_path.set(this.uuid);
      } else {
        ((im_msg_body.CustomFace)localObject1).str_file_path.set(this.md5);
      }
      ((im_msg_body.CustomFace)localObject1).str_big_url.set(this.bigMsgUrl);
      ((im_msg_body.CustomFace)localObject1).str_orig_url.set(this.rawMsgUrl);
      ((im_msg_body.CustomFace)localObject1).str_thumb_url.set(this.thumbMsgUrl);
      ((im_msg_body.CustomFace)localObject1).str_400_url.set(this.bigThumbMsgUrl);
      ((im_msg_body.CustomFace)localObject1).uint32_thumb_width.set(this.thumbWidth);
      ((im_msg_body.CustomFace)localObject1).uint32_thumb_height.set(this.thumbHeight);
      ((im_msg_body.CustomFace)localObject1).uint32_show_len.set(this.mShowLength);
      ((im_msg_body.CustomFace)localObject1).uint32_download_len.set(this.mDownloadLength);
      ((im_msg_body.CustomFace)localObject1).uint32_file_id.set((int)this.groupFileID);
      ((im_msg_body.CustomFace)localObject1).uint32_size.set((int)this.size);
      ((im_msg_body.CustomFace)localObject1).image_type.set(this.imageType);
      ((im_msg_body.CustomFace)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.md5)));
      ((im_msg_body.CustomFace)localObject1).uint32_width.set((int)this.width);
      ((im_msg_body.CustomFace)localObject1).uint32_height.set((int)this.height);
      ((im_msg_body.CustomFace)localObject1).uint32_origin.set(this.fileSizeFlag);
      localObject2 = this.picExtraData;
      if (localObject2 != null)
      {
        localObject2 = ((PicMessageExtraData)localObject2).getCustomFaceResvAttr();
        ((im_msg_body.CustomFace)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
      }
      localElem.custom_face.set((MessageMicro)localObject1);
    }
    localRichText.elems.add(localElem);
    return localRichText;
  }
  
  public RichMsg.PicRec getSerialPB()
  {
    RichMsg.PicRec localPicRec = new RichMsg.PicRec();
    localPicRec.setHasFlag(true);
    Object localObject2 = localPicRec.localPath;
    Object localObject1 = this.path;
    String str = "";
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localPicRec.size.set(this.size);
    localPicRec.type.set(this.type);
    localPicRec.isRead.set(this.isRead);
    localObject2 = localPicRec.uuid;
    localObject1 = this.uuid;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localPicRec.groupFileID.set(this.groupFileID);
    localObject2 = localPicRec.md5;
    localObject1 = this.md5;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localPicRec.serverStorageSource;
    localObject1 = this.serverStoreSource;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localPicRec.thumbMsgUrl;
    localObject1 = this.thumbMsgUrl;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localPicRec.bigthumbMsgUrl;
    localObject1 = this.bigThumbMsgUrl;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localPicRec.uint32_thumb_width.set(this.thumbWidth);
    localPicRec.uint32_thumb_height.set(this.thumbHeight);
    localPicRec.uint32_width.set((int)this.width);
    localPicRec.uint32_height.set((int)this.height);
    localPicRec.uint32_image_type.set(this.imageType);
    localObject2 = localPicRec.bigMsgUrl;
    localObject1 = this.bigMsgUrl;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localObject2 = localPicRec.rawMsgUrl;
    localObject1 = this.rawMsgUrl;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localPicRec.uiOperatorFlag.set(this.picExtraFlag);
    localPicRec.version.set(this.subVersion);
    localPicRec.isReport.set(this.isReport);
    localPicRec.fileSizeFlag.set(this.fileSizeFlag);
    localObject2 = localPicRec.localUUID;
    localObject1 = this.localUUID;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localPicRec.preDownState.set(this.preDownState);
    localPicRec.preDownNetwork.set(this.preDownNetworkType);
    localPicRec.previewed.set(this.previewed);
    localPicRec.enableEnc.set(this.bEnableEnc);
    localPicRec.uint32_show_len.set(this.mShowLength);
    localPicRec.uint32_download_len.set(this.mDownloadLength);
    localPicRec.uint32_current_len.set(this.mCurrlength);
    localPicRec.notPredownloadReason.set(this.mNotPredownloadReason);
    localObject1 = this.picExtraObject;
    if ((localObject1 != null) && ((localObject1 instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)localObject1;
      Object localObject3 = (RichMsg.ForwardExtra)localPicRec.fowardInfo.get();
      ((RichMsg.ForwardExtra)localObject3).foward_orgId.set(((PicFowardDbRecordData)localObject2).fowardOrgId);
      PBStringField localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUin;
      if (((PicFowardDbRecordData)localObject2).fowardOrgUin != null) {
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardOrgUin;
      } else {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.set(((PicFowardDbRecordData)localObject2).fowardOrgUinType);
      ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.set(((PicFowardDbRecordData)localObject2).fowardOrgFileSizeType);
      localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl;
      if (((PicFowardDbRecordData)localObject2).fowardOrgUrl != null) {
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardOrgUrl;
      } else {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localObject3 = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath;
      localObject1 = str;
      if (((PicFowardDbRecordData)localObject2).fowardThumbPath != null) {
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardThumbPath;
      }
      ((PBStringField)localObject3).set((String)localObject1);
      localPicRec.fowardInfo.setHasFlag(true);
    }
    if (this.picExtraData != null) {
      if (this.istroop == 0)
      {
        localObject1 = this.picExtraData.getOfflineImageResvAttr();
        localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
      }
      else
      {
        localObject1 = this.picExtraData.getCustomFaceResvAttr();
        localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
      }
    }
    localPicRec.bool_story_pic_send_to_recent.set(this.isStoryPhoto);
    return localPicRec;
  }
  
  public String getSummaryMsg()
  {
    String str = ((IPicHelper)QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic(this);
    if (str != null) {
      return str;
    }
    return HardCodeUtil.a(2131706642);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void processSessionInfo(PicDownloadInfo paramPicDownloadInfo)
  {
    MultiMsgBean localMultiMsgBean = ((IMultiMsg)QRoute.api(IMultiMsg.class)).getMultiMsgValue();
    Object localObject = localMultiMsgBean.jdField_a_of_type_JavaLangObject;
    boolean bool = localMultiMsgBean.jdField_a_of_type_Boolean;
    if ((this.isMultiMsg) && (!bool))
    {
      if (localObject != null) {
        paramPicDownloadInfo.jdField_b_of_type_Int = localMultiMsgBean.jdField_a_of_type_Int;
      } else if (QLog.isColorLevel()) {
        QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
      }
    }
    else {
      paramPicDownloadInfo.jdField_b_of_type_Int = this.istroop;
    }
    paramPicDownloadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
    if (this.isMultiMsg) {}
    try
    {
      paramPicDownloadInfo.jdField_b_of_type_JavaLangString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Exception localException)
    {
      label111:
      break label111;
    }
    if ((this.isMultiMsg) && (!bool))
    {
      if (localObject != null)
      {
        paramPicDownloadInfo.jdField_c_of_type_JavaLangString = localMultiMsgBean.jdField_a_of_type_JavaLangString;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
      }
    }
    else
    {
      paramPicDownloadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
    }
  }
  
  public void serial()
  {
    this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
    boolean bool;
    if ((!this.isShareAppActionMsg) && (this.msgtype != -3001) && (this.msgtype != -30002) && (this.msgtype != -30003) && (this.msgtype != -1032)) {
      bool = false;
    } else {
      bool = true;
    }
    this.isMixed = bool;
    if (this.isMixed)
    {
      this.msgData = this.msg.getBytes();
      return;
    }
    if (this.versionCode < 3) {
      this.subVersion = 0;
    }
    this.msgData = getSerialPB().toByteArray();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("path:");
    localStringBuilder.append(this.path);
    localStringBuilder.append(",uuid:");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(",md5:");
    localStringBuilder.append(this.md5);
    localStringBuilder.append(",size:");
    localStringBuilder.append(this.size);
    localStringBuilder.append(",groupFileID:");
    localStringBuilder.append(this.groupFileID);
    return localStringBuilder.toString();
  }
  
  public void updateMessage()
  {
    if (this.subMsgId == defaultSuMsgId) {
      try
      {
        this.msgData = getSerialPB().toByteArray();
        ((IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void updateMsgExtFiled()
  {
    try
    {
      ((IMessageFacade)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgFieldByUniseq(this.frienduin, this.istroop, this.uniseq, "extStr", this.extStr);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPic
 * JD-Core Version:    0.7.0.1
 */