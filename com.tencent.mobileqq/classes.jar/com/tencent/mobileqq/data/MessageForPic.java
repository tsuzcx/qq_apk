package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import acck;
import accl;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.LoggerInterface;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import localpb.richMsg.RichMsg.ForwardExtra;
import localpb.richMsg.RichMsg.PicRec;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;

public class MessageForPic
  extends MessageForRichText
  implements Parcelable, LoggerInterface, PicUiInterface
{
  public static final Parcelable.Creator CREATOR = new accl();
  public static final String NOT_GIF_HAS_READ = "not_gif_has_read";
  private static final String TAG = "MessageForPic";
  public static int defaultSuMsgId = -1;
  public long DSKey;
  public String SpeedInfo;
  public String actMsgContentValue;
  public String action;
  public int aiofileType = -1;
  public boolean bEnableEnc;
  public String bigMsgUrl;
  public String bigThumbMsgUrl;
  public int busiType;
  public int fileSizeFlag;
  public long groupFileID;
  public long height;
  public int imageType;
  public boolean isBlessPic;
  public boolean isMixed;
  public boolean isRead;
  public int isReport;
  public boolean isShareAppActionMsg;
  public String localUUID;
  public int mCurrlength;
  public int mDownloadLength;
  public int mNotPredownloadReason = 0;
  public long mPresendTransferedSize;
  public int mShowLength;
  public String md5;
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
  public boolean sync2Story;
  public int thumbHeight;
  public String thumbMsgUrl;
  public int thumbSize = -1;
  public int thumbWidth;
  public int type;
  public String uuid;
  public long width;
  
  private boolean hasFile(String paramString)
  {
    if (isSendFromLocal())
    {
      localObject = getPicUploadInfo();
      ((PicUploadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
      return ((PicUploadInfo)localObject).b();
    }
    Object localObject = getPicDownloadInfo();
    ((PicDownloadInfo)localObject).jdField_e_of_type_JavaLangString = paramString;
    return ((PicDownloadInfo)localObject).b();
  }
  
  public boolean checkGif()
  {
    return (this.imageType == 3) || (this.imageType == 2000);
  }
  
  public void checkIsGIF()
  {
    File localFile = AbsDownloader.a(URLDrawableHelper.a(this, 1, null).toString());
    if (localFile != null)
    {
      if (GifDrawable.isGifFile(localFile)) {
        this.imageType = 2000;
      }
      saveExtInfoToExtStr("not_gif_has_read", "true");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void doParse()
  {
    Object localObject1 = new RichMsg.PicRec();
    try
    {
      ((RichMsg.PicRec)localObject1).mergeFrom(this.msgData);
      i = 1;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        try
        {
          int i;
          Object localObject3;
          PicFowardDbRecordData localPicFowardDbRecordData;
          if (this.istroop == 0)
          {
            localObject3 = new NotOnlineImageExtPb.ResvAttr();
            ((NotOnlineImageExtPb.ResvAttr)localObject3).mergeFrom((byte[])localObject1);
            this.picExtraData = new PicMessageExtraData((NotOnlineImageExtPb.ResvAttr)localObject3);
            if (QLog.isDevelopLevel()) {
              QLog.d("MessageForPic", 4, "bytes_pb_reserved.has");
            }
            if ((this.imageType != 3) && (this.imageType != 2000) && (!isSendFromLocal()) && (TextUtils.isEmpty(getExtInfoFromExtStr("not_gif_has_read"))))
            {
              localObject1 = Looper.getMainLooper();
              if (Thread.currentThread() != ((Looper)localObject1).getThread()) {
                break label1080;
              }
              ThreadManager.post(new acck(this), 5, null, false);
            }
            this.mIsParsed = true;
            if (((this.extLong & 0x4) <= 0) || (!EmojiStickerManager.e)) {
              break label1102;
            }
            System.currentTimeMillis();
            localObject1 = getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (this.msgtype == -2000) {
                this.msgtype = -2058;
              }
              localObject1 = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject1);
              if (localObject1 != null)
              {
                ((EmojiStickerManager.StickerInfo)localObject1).isDisplayed = this.isread;
                this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject1);
                System.currentTimeMillis();
              }
            }
            if (!"1".equals(getExtInfoFromExtStr(MessageConstants.n))) {
              break;
            }
            this.sync2Story = true;
            return;
            localException2 = localException2;
            localException2.printStackTrace();
            i = 0;
            continue;
          }
          localObject4 = new CustomFaceExtPb.ResvAttr();
          ((CustomFaceExtPb.ResvAttr)localObject4).mergeFrom((byte[])localObject1);
          this.picExtraData = new PicMessageExtraData((CustomFaceExtPb.ResvAttr)localObject4);
          continue;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
          continue;
        }
        if (this.msg == null) {}
        try
        {
          if (this.versionCode > 0) {
            this.msg = new String(this.msgData, "UTF-8");
          }
          this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
          if ((this.isShareAppActionMsg) || (this.msgtype == -3001) || (this.msgtype == -30002) || (this.msgtype == -30003) || (this.msgtype == -1032))
          {
            bool = true;
            this.isMixed = bool;
            TranDbRecord.PicDbRecord localPicDbRecord = new TranDbRecord.PicDbRecord();
            if (!this.isMixed) {
              break label1069;
            }
            localObject4 = ActionMsgUtil.a(this.msg);
            this.action = ((MsgBody)localObject4).action;
            this.shareAppID = ((MsgBody)localObject4).shareAppID;
            localPicDbRecord.a(((MsgBody)localObject4).msg);
            this.actMsgContentValue = ((MsgBody)localObject4).actMsgContentValue;
            this.path = localPicDbRecord.jdField_a_of_type_JavaLangString;
            this.size = localPicDbRecord.jdField_a_of_type_Long;
            this.type = localPicDbRecord.jdField_a_of_type_Int;
            this.isRead = localPicDbRecord.jdField_a_of_type_Boolean;
            this.uuid = localPicDbRecord.jdField_b_of_type_JavaLangString;
            this.md5 = localPicDbRecord.jdField_c_of_type_JavaLangString;
            this.serverStoreSource = localPicDbRecord.jdField_d_of_type_JavaLangString;
            this.thumbMsgUrl = localPicDbRecord.jdField_e_of_type_JavaLangString;
            this.bigThumbMsgUrl = localPicDbRecord.h;
            this.bigMsgUrl = localPicDbRecord.f;
            this.rawMsgUrl = localPicDbRecord.jdField_g_of_type_JavaLangString;
            this.picExtraFlag = localPicDbRecord.jdField_c_of_type_Int;
            this.picExtraObject = localPicDbRecord.jdField_a_of_type_JavaLangObject;
            this.subVersion = 0;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            boolean bool;
            if (QLog.isColorLevel())
            {
              QLog.e("MessageForPic", 2, localException1.getMessage());
              continue;
              bool = false;
              continue;
              label1069:
              localException1.a(this.msg);
            }
          }
        }
        label1080:
        if (!Thread.currentThread().getName().equals("MSF-Receiver"))
        {
          checkIsGIF();
          continue;
          label1102:
          if (this.msgtype == -2058)
          {
            Object localObject2 = getExtInfoFromExtStr("sticker_info");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject2);
              if (localObject2 != null)
              {
                ((EmojiStickerManager.StickerInfo)localObject2).isDisplayed = this.isread;
                this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject2);
              }
            }
          }
        }
      }
      this.sync2Story = false;
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
      if (((RichMsg.PicRec)localObject1).fowardInfo.has())
      {
        localObject3 = (RichMsg.ForwardExtra)((RichMsg.PicRec)localObject1).fowardInfo.get();
        if (localObject3 != null)
        {
          localPicFowardDbRecordData = new PicFowardDbRecordData();
          localPicFowardDbRecordData.jdField_a_of_type_Long = ((RichMsg.ForwardExtra)localObject3).foward_orgId.get();
          localPicFowardDbRecordData.jdField_a_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject3).foward_orgUin.get();
          localPicFowardDbRecordData.jdField_a_of_type_Int = ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.get();
          localPicFowardDbRecordData.jdField_b_of_type_Int = ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.get();
          localPicFowardDbRecordData.jdField_b_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl.get();
          localPicFowardDbRecordData.jdField_c_of_type_JavaLangString = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath.get();
          this.picExtraObject = localPicFowardDbRecordData;
        }
      }
      if ((((RichMsg.PicRec)localObject1).bytes_pb_reserved.has()) && (this.picExtraData == null)) {
        localObject1 = ((RichMsg.PicRec)localObject1).bytes_pb_reserved.get().toByteArray();
      }
    }
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
    SessionInfo localSessionInfo = MultiMsgManager.a().a();
    boolean bool = MsgUtils.a(MultiMsgManager.a().d());
    if ((this.isMultiMsg) && (!bool)) {
      if (localSessionInfo != null) {
        localPicDownloadInfo.jdField_b_of_type_Int = MultiMsgManager.a().a().jdField_a_of_type_Int;
      }
    }
    for (;;)
    {
      localPicDownloadInfo.jdField_b_of_type_JavaLangString = this.selfuin;
      if (this.isMultiMsg) {}
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((localAppRuntime instanceof QQAppInterface)) {
          localPicDownloadInfo.jdField_b_of_type_JavaLangString = localAppRuntime.getAccount();
        }
        label110:
        if ((this.isMultiMsg) && (!bool)) {
          if (localSessionInfo != null) {
            localPicDownloadInfo.jdField_c_of_type_JavaLangString = MultiMsgManager.a().a().jdField_a_of_type_JavaLangString;
          }
        }
        for (;;)
        {
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
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
          break;
          localPicDownloadInfo.jdField_b_of_type_Int = this.istroop;
          break;
          if (QLog.isColorLevel())
          {
            QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
            continue;
            localPicDownloadInfo.jdField_c_of_type_JavaLangString = this.frienduin;
          }
        }
      }
      catch (Exception localException)
      {
        break label110;
      }
    }
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
  
  public RichMsg.PicRec getSerialPB()
  {
    RichMsg.PicRec localPicRec = new RichMsg.PicRec();
    localPicRec.setHasFlag(true);
    Object localObject2 = localPicRec.localPath;
    label85:
    label118:
    Object localObject3;
    if (this.path != null)
    {
      localObject1 = this.path;
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.size.set(this.size);
      localPicRec.type.set(this.type);
      localPicRec.isRead.set(this.isRead);
      localObject2 = localPicRec.uuid;
      if (this.uuid == null) {
        break label652;
      }
      localObject1 = this.uuid;
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.groupFileID.set(this.groupFileID);
      localObject2 = localPicRec.md5;
      if (this.md5 == null) {
        break label659;
      }
      localObject1 = this.md5;
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.serverStorageSource;
      if (this.serverStoreSource == null) {
        break label666;
      }
      localObject1 = this.serverStoreSource;
      label140:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.thumbMsgUrl;
      if (this.thumbMsgUrl == null) {
        break label673;
      }
      localObject1 = this.thumbMsgUrl;
      label162:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.bigthumbMsgUrl;
      if (this.bigThumbMsgUrl == null) {
        break label680;
      }
      localObject1 = this.bigThumbMsgUrl;
      label184:
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.uint32_thumb_width.set(this.thumbWidth);
      localPicRec.uint32_thumb_height.set(this.thumbHeight);
      localPicRec.uint32_width.set((int)this.width);
      localPicRec.uint32_height.set((int)this.height);
      localPicRec.uint32_image_type.set(this.imageType);
      localObject2 = localPicRec.bigMsgUrl;
      if (this.bigMsgUrl == null) {
        break label687;
      }
      localObject1 = this.bigMsgUrl;
      label263:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.rawMsgUrl;
      if (this.rawMsgUrl == null) {
        break label694;
      }
      localObject1 = this.rawMsgUrl;
      label285:
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.uiOperatorFlag.set(this.picExtraFlag);
      localPicRec.version.set(this.subVersion);
      localPicRec.isReport.set(this.isReport);
      localPicRec.fileSizeFlag.set(this.fileSizeFlag);
      localObject2 = localPicRec.localUUID;
      if (this.localUUID == null) {
        break label701;
      }
      localObject1 = this.localUUID;
      label351:
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.preDownState.set(this.preDownState);
      localPicRec.preDownNetwork.set(this.preDownNetworkType);
      localPicRec.previewed.set(this.previewed);
      localPicRec.enableEnc.set(this.bEnableEnc);
      localPicRec.uint32_show_len.set(this.mShowLength);
      localPicRec.uint32_download_len.set(this.mDownloadLength);
      localPicRec.uint32_current_len.set(this.mCurrlength);
      localPicRec.notPredownloadReason.set(this.mNotPredownloadReason);
      if ((this.picExtraObject != null) && ((this.picExtraObject instanceof PicFowardDbRecordData)))
      {
        localObject2 = (PicFowardDbRecordData)this.picExtraObject;
        localObject3 = (RichMsg.ForwardExtra)localPicRec.fowardInfo.get();
        ((RichMsg.ForwardExtra)localObject3).foward_orgId.set(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Long);
        PBStringField localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUin;
        if (((PicFowardDbRecordData)localObject2).jdField_a_of_type_JavaLangString == null) {
          break label708;
        }
        localObject1 = ((PicFowardDbRecordData)localObject2).jdField_a_of_type_JavaLangString;
        label512:
        localPBStringField.set((String)localObject1);
        ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.set(((PicFowardDbRecordData)localObject2).jdField_a_of_type_Int);
        ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.set(((PicFowardDbRecordData)localObject2).jdField_b_of_type_Int);
        localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl;
        if (((PicFowardDbRecordData)localObject2).jdField_b_of_type_JavaLangString == null) {
          break label715;
        }
        localObject1 = ((PicFowardDbRecordData)localObject2).jdField_b_of_type_JavaLangString;
        label561:
        localPBStringField.set((String)localObject1);
        localObject3 = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath;
        if (((PicFowardDbRecordData)localObject2).jdField_c_of_type_JavaLangString == null) {
          break label722;
        }
      }
    }
    label652:
    label659:
    label666:
    label673:
    label680:
    label687:
    label694:
    label701:
    label708:
    label715:
    label722:
    for (Object localObject1 = ((PicFowardDbRecordData)localObject2).jdField_c_of_type_JavaLangString;; localObject1 = "")
    {
      ((PBStringField)localObject3).set((String)localObject1);
      localPicRec.fowardInfo.setHasFlag(true);
      if (this.picExtraData != null)
      {
        if (this.istroop != 0) {
          break label729;
        }
        localObject1 = this.picExtraData.getOfflineImageResvAttr();
        localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
      }
      return localPicRec;
      localObject1 = "";
      break;
      localObject1 = "";
      break label85;
      localObject1 = "";
      break label118;
      localObject1 = "";
      break label140;
      localObject1 = "";
      break label162;
      localObject1 = "";
      break label184;
      localObject1 = "";
      break label263;
      localObject1 = "";
      break label285;
      localObject1 = "";
      break label351;
      localObject1 = "";
      break label512;
      localObject1 = "";
      break label561;
    }
    label729:
    localObject1 = this.picExtraData.getCustomFaceResvAttr();
    localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
    return localPicRec;
  }
  
  public String getSummaryMsg()
  {
    return "[图片]";
  }
  
  public boolean hasBigFile()
  {
    return hasFile("chatimg");
  }
  
  public boolean hasRawFile()
  {
    return hasFile("chatraw");
  }
  
  public boolean hasThumbFile()
  {
    return hasFile("chatthumb");
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
  
  public void serial()
  {
    this.isShareAppActionMsg = ActionMsgUtil.a(this.msgtype);
    if ((this.isShareAppActionMsg) || (this.msgtype == -3001) || (this.msgtype == -30002) || (this.msgtype == -30003) || (this.msgtype == -1032)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isMixed = bool;
      if (!this.isMixed) {
        break;
      }
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
    if (isSendFromLocal()) {
      return " loacalpath:" + this.path;
    }
    return " uuid:" + this.uuid + ",md5:" + this.md5;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.path);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.type);
    int i;
    if (this.isRead)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeString(this.uuid);
      paramParcel.writeLong(this.groupFileID);
      paramParcel.writeString(this.md5);
      paramParcel.writeString(this.serverStoreSource);
      paramParcel.writeString(this.thumbMsgUrl);
      paramParcel.writeString(this.bigThumbMsgUrl);
      paramParcel.writeInt(this.thumbWidth);
      paramParcel.writeInt(this.thumbHeight);
      paramParcel.writeString(this.bigMsgUrl);
      paramParcel.writeString(this.rawMsgUrl);
      paramParcel.writeInt(this.fileSizeFlag);
      paramParcel.writeInt(this.picExtraFlag);
      if (!this.isMixed) {
        break label388;
      }
      i = 1;
      label146:
      paramParcel.writeInt(i);
      if (!this.isShareAppActionMsg) {
        break label393;
      }
      i = 1;
      label160:
      paramParcel.writeInt(i);
      paramParcel.writeString(this.action);
      paramParcel.writeLong(this.shareAppID);
      paramParcel.writeString(this.actMsgContentValue);
      paramParcel.writeString(this.localUUID);
      paramParcel.writeInt(this.subMsgId);
      paramParcel.writeInt(this.isReport);
      paramParcel.writeInt(this.subVersion);
      paramParcel.writeInt(this.busiType);
      paramParcel.writeLong(this.width);
      paramParcel.writeLong(this.height);
      paramParcel.writeInt(this.imageType);
      paramParcel.writeString(this.frienduin);
      paramParcel.writeString(this.selfuin);
      paramParcel.writeString(this.senderuin);
      paramParcel.writeInt(this.istroop);
      paramParcel.writeInt(this.versionCode);
      paramParcel.writeLong(this.uniseq);
      paramParcel.writeInt(this.issend);
      paramParcel.writeLong(this.time);
      paramParcel.writeInt(this.msgtype);
      paramParcel.writeInt(this.preDownState);
      paramParcel.writeInt(this.preDownNetworkType);
      paramParcel.writeInt(this.previewed);
      paramParcel.writeInt(this.mNotPredownloadReason);
      paramParcel.writeParcelable(this.reportInfo, paramInt);
      if (!this.sync2Story) {
        break label398;
      }
    }
    label388:
    label393:
    label398:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      i = 0;
      break;
      i = 0;
      break label146;
      i = 0;
      break label160;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPic
 * JD-Core Version:    0.7.0.1
 */