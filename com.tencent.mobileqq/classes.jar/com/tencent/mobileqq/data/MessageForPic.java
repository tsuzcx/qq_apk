package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import agjt;
import amtj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import anlz;
import aqrk;
import avws;
import awcm;
import aydl;
import ayds;
import aydz;
import ayeb;
import bbkv;
import bfti;
import bfwr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
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
import com.tencent.mobileqq.pic.ReportInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  implements Parcelable, avws, aydz
{
  public static final String CHECK_IMAGE_TYPE = "check_image_type";
  public static final Parcelable.Creator<MessageForPic> CREATOR = new aqrk();
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
  public Map<ayds, Integer> forwardId = new HashMap();
  public long groupFileID;
  public long height;
  public int imageType;
  public boolean isBlessPic;
  public boolean isInMixedMsg;
  public boolean isMixed;
  public boolean isQzonePic;
  public boolean isRead;
  public int isReport;
  public boolean isShareAppActionMsg;
  public boolean isStoryPhoto;
  public String localUUID;
  public int mCurrlength;
  public int mDownloadLength;
  public int mNotPredownloadReason = 0;
  public long mPresendTransferedSize;
  public int mShowLength;
  public String md5;
  @anlz
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
  public boolean sync2Story;
  public int thumbHeight;
  public String thumbMsgUrl;
  public int thumbSize = -1;
  public int thumbWidth;
  public ThumbWidthHeightDP thumbWidthHeightDP;
  public int type;
  public String uuid;
  public long width;
  
  private boolean hasFile(String paramString)
  {
    if (isSendFromLocal())
    {
      localObject = getPicUploadInfo();
      ((ayeb)localObject).jdField_e_of_type_JavaLangString = paramString;
      return ((ayeb)localObject).b();
    }
    Object localObject = getPicDownloadInfo();
    ((aydl)localObject).jdField_e_of_type_JavaLangString = paramString;
    return ((aydl)localObject).b();
  }
  
  public boolean checkGif()
  {
    return (this.imageType == 3) || (this.imageType == 2000);
  }
  
  public void checkType()
  {
    if ((this.imageType == 0) && (!isSendFromLocal()) && (TextUtils.isEmpty(getExtInfoFromExtStr("check_image_type"))))
    {
      File localFile = AbsDownloader.getFile(URLDrawableHelper.getURL(this, 1, null).toString());
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
    localObject1 = new RichMsg.PicRec();
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
            this.mIsParsed = true;
            if (((this.extLong & 0x4) <= 0) || (!EmojiStickerManager.e)) {
              break label1043;
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
            if (!"1".equals(getExtInfoFromExtStr(bbkv.m))) {
              break label1093;
            }
            this.sync2Story = true;
            this.isQzonePic = "1".equals(getExtInfoFromExtStr(bbkv.r));
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
          this.isShareAppActionMsg = bfti.a(this.msgtype);
          if ((this.isShareAppActionMsg) || (this.msgtype == -3001) || (this.msgtype == -30002) || (this.msgtype == -30003) || (this.msgtype == -1032))
          {
            bool = true;
            this.isMixed = bool;
            TranDbRecord.PicDbRecord localPicDbRecord = new TranDbRecord.PicDbRecord();
            if (!this.isMixed) {
              break label1032;
            }
            localObject4 = bfti.a(this.msg);
            this.action = ((MsgBody)localObject4).action;
            this.shareAppID = ((MsgBody)localObject4).shareAppID;
            localPicDbRecord.initFromMsg(((MsgBody)localObject4).msg);
            this.actMsgContentValue = ((MsgBody)localObject4).actMsgContentValue;
            this.path = localPicDbRecord.path;
            this.size = localPicDbRecord.size;
            this.type = localPicDbRecord.type;
            this.isRead = localPicDbRecord.isRead;
            this.uuid = localPicDbRecord.uuid;
            this.md5 = localPicDbRecord.md5;
            this.serverStoreSource = localPicDbRecord.serverStoreSource;
            this.thumbMsgUrl = localPicDbRecord.thumbMsgUrl;
            this.bigThumbMsgUrl = localPicDbRecord.bigThumbMsgUrl;
            this.bigMsgUrl = localPicDbRecord.bigMsgUrl;
            this.rawMsgUrl = localPicDbRecord.rawMsgUrl;
            this.picExtraFlag = localPicDbRecord.extraFlag;
            this.picExtraObject = localPicDbRecord.extraObject;
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
              localException1.initFromMsg(this.msg);
            }
          }
        }
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
              continue;
              this.sync2Story = false;
            }
          }
        }
      }
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
      if (((RichMsg.PicRec)localObject1).fowardInfo.has())
      {
        localObject3 = (RichMsg.ForwardExtra)((RichMsg.PicRec)localObject1).fowardInfo.get();
        if (localObject3 != null)
        {
          localPicFowardDbRecordData = new PicFowardDbRecordData();
          localPicFowardDbRecordData.fowardOrgId = ((RichMsg.ForwardExtra)localObject3).foward_orgId.get();
          localPicFowardDbRecordData.fowardOrgUin = ((RichMsg.ForwardExtra)localObject3).foward_orgUin.get();
          localPicFowardDbRecordData.fowardOrgUinType = ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.get();
          localPicFowardDbRecordData.fowardOrgFileSizeType = ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.get();
          localPicFowardDbRecordData.fowardOrgUrl = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl.get();
          localPicFowardDbRecordData.fowardThumbPath = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath.get();
          this.picExtraObject = localPicFowardDbRecordData;
        }
      }
      if ((((RichMsg.PicRec)localObject1).bytes_pb_reserved.has()) && (this.picExtraData == null)) {
        localObject1 = ((RichMsg.PicRec)localObject1).bytes_pb_reserved.get().toByteArray();
      }
    }
  }
  
  public String getBiggestFilePath()
  {
    String str = null;
    if (hasRawFile()) {
      str = getFilePath("chatraw");
    }
    do
    {
      return str;
      if (hasBigFile()) {
        return getFilePath("chatimg");
      }
    } while (!hasThumbFile());
    return getFilePath("chatthumb");
  }
  
  public String getFilePath(String paramString)
  {
    if (isSendFromLocal())
    {
      localObject = getPicUploadInfo();
      ((ayeb)localObject).jdField_e_of_type_JavaLangString = paramString;
      return ((ayeb)localObject).c();
    }
    Object localObject = getPicDownloadInfo();
    ((aydl)localObject).jdField_e_of_type_JavaLangString = paramString;
    return ((aydl)localObject).c();
  }
  
  public aydl getPicDownloadInfo()
  {
    aydl localaydl = new aydl();
    localaydl.jdField_a_of_type_Int = this.busiType;
    localaydl.jdField_a_of_type_Long = this.uniseq;
    SessionInfo localSessionInfo = awcm.a().a();
    boolean bool = bfwr.a(awcm.a().b());
    if ((this.isMultiMsg) && (!bool)) {
      if (localSessionInfo != null) {
        localaydl.jdField_b_of_type_Int = awcm.a().a().curType;
      }
    }
    for (;;)
    {
      localaydl.jdField_b_of_type_JavaLangString = this.selfuin;
      if (this.isMultiMsg) {}
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((localAppRuntime instanceof QQAppInterface)) {
          localaydl.jdField_b_of_type_JavaLangString = localAppRuntime.getAccount();
        }
        label110:
        if ((this.isMultiMsg) && (!bool)) {
          if (localSessionInfo != null) {
            localaydl.jdField_c_of_type_JavaLangString = awcm.a().a().curFriendUin;
          }
        }
        for (;;)
        {
          localaydl.jdField_c_of_type_Long = this.time;
          localaydl.jdField_g_of_type_JavaLangString = this.uuid;
          localaydl.f = this.md5;
          localaydl.jdField_b_of_type_Long = this.groupFileID;
          localaydl.h = this.thumbMsgUrl;
          localaydl.k = this.bigThumbMsgUrl;
          localaydl.i = this.bigMsgUrl;
          localaydl.j = this.rawMsgUrl;
          localaydl.jdField_g_of_type_Int = this.subMsgId;
          localaydl.jdField_b_of_type_Boolean = this.isMixed;
          if (localaydl.jdField_b_of_type_Boolean)
          {
            localaydl.l = this.action;
            localaydl.m = this.actMsgContentValue;
            localaydl.jdField_e_of_type_Long = this.shareAppID;
          }
          localaydl.jdField_e_of_type_Int = this.fileSizeFlag;
          localaydl.jdField_c_of_type_Int = this.extraflag;
          localaydl.jdField_a_of_type_JavaLangObject = this.picExtraObject;
          localaydl.jdField_d_of_type_Int = this.subVersion;
          localaydl.jdField_a_of_type_JavaLangString = this.localUUID;
          localaydl.jdField_d_of_type_Long = this.size;
          localaydl.jdField_d_of_type_Boolean = this.bEnableEnc;
          if (this.reportInfo == null) {
            this.reportInfo = new ReportInfo();
          }
          localaydl.jdField_a_of_type_ComTencentMobileqqPicReportInfo = this.reportInfo;
          return localaydl;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
          break;
          localaydl.jdField_b_of_type_Int = this.istroop;
          break;
          if (QLog.isColorLevel())
          {
            QLog.e("MessageForPic", 2, "currentSessionInfo is null while isMultiMsg is true");
            continue;
            localaydl.jdField_c_of_type_JavaLangString = this.frienduin;
          }
        }
      }
      catch (Exception localException)
      {
        break label110;
      }
    }
  }
  
  public ayeb getPicUploadInfo()
  {
    ayeb localayeb = new ayeb();
    localayeb.jdField_a_of_type_Int = this.busiType;
    localayeb.jdField_a_of_type_Long = this.uniseq;
    localayeb.jdField_b_of_type_Int = this.istroop;
    localayeb.jdField_c_of_type_JavaLangString = this.frienduin;
    localayeb.jdField_b_of_type_JavaLangString = this.selfuin;
    localayeb.jdField_d_of_type_JavaLangString = this.senderuin;
    localayeb.f = this.md5;
    localayeb.jdField_g_of_type_JavaLangString = this.path;
    localayeb.h = this.thumbMsgUrl;
    localayeb.jdField_c_of_type_Int = this.picExtraFlag;
    localayeb.jdField_a_of_type_JavaLangObject = this.picExtraObject;
    localayeb.jdField_a_of_type_JavaLangString = this.localUUID;
    localayeb.jdField_d_of_type_Int = this.subVersion;
    localayeb.j = ((int)this.width);
    localayeb.k = ((int)this.height);
    localayeb.jdField_c_of_type_Long = ((int)this.size);
    localayeb.m = this.imageType;
    return localayeb;
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
    if ((this.istroop == 1) || (this.istroop == 3000))
    {
      localObject1 = new im_msg_body.CustomFace();
      if (this.uuid != null)
      {
        ((im_msg_body.CustomFace)localObject1).str_file_path.set(this.uuid);
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
        if (this.picExtraData != null)
        {
          localObject2 = this.picExtraData.getCustomFaceResvAttr();
          ((im_msg_body.CustomFace)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        }
        localElem.custom_face.set((MessageMicro)localObject1);
      }
    }
    for (;;)
    {
      localRichText.elems.add(localElem);
      return localRichText;
      ((im_msg_body.CustomFace)localObject1).str_file_path.set(this.md5);
      break;
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
      if (this.picExtraData != null)
      {
        localObject2 = this.picExtraData.getOfflineImageResvAttr();
        ((im_msg_body.NotOnlineImage)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
      }
      localElem.not_online_image.set((MessageMicro)localObject1);
    }
  }
  
  public RichMsg.PicRec getSerialPB()
  {
    RichMsg.PicRec localPicRec = new RichMsg.PicRec();
    localPicRec.setHasFlag(true);
    Object localObject2 = localPicRec.localPath;
    Object localObject1;
    if (this.path != null)
    {
      localObject1 = this.path;
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.size.set(this.size);
      localPicRec.type.set(this.type);
      localPicRec.isRead.set(this.isRead);
      localObject2 = localPicRec.uuid;
      if (this.uuid == null) {
        break label663;
      }
      localObject1 = this.uuid;
      label85:
      ((PBStringField)localObject2).set((String)localObject1);
      localPicRec.groupFileID.set(this.groupFileID);
      localObject2 = localPicRec.md5;
      if (this.md5 == null) {
        break label670;
      }
      localObject1 = this.md5;
      label118:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.serverStorageSource;
      if (this.serverStoreSource == null) {
        break label677;
      }
      localObject1 = this.serverStoreSource;
      label140:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.thumbMsgUrl;
      if (this.thumbMsgUrl == null) {
        break label684;
      }
      localObject1 = this.thumbMsgUrl;
      label162:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.bigthumbMsgUrl;
      if (this.bigThumbMsgUrl == null) {
        break label691;
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
        break label698;
      }
      localObject1 = this.bigMsgUrl;
      label263:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localPicRec.rawMsgUrl;
      if (this.rawMsgUrl == null) {
        break label705;
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
        break label712;
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
        Object localObject3 = (RichMsg.ForwardExtra)localPicRec.fowardInfo.get();
        ((RichMsg.ForwardExtra)localObject3).foward_orgId.set(((PicFowardDbRecordData)localObject2).fowardOrgId);
        PBStringField localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUin;
        if (((PicFowardDbRecordData)localObject2).fowardOrgUin == null) {
          break label719;
        }
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardOrgUin;
        label512:
        localPBStringField.set((String)localObject1);
        ((RichMsg.ForwardExtra)localObject3).foward_orgUinType.set(((PicFowardDbRecordData)localObject2).fowardOrgUinType);
        ((RichMsg.ForwardExtra)localObject3).foward_orgFileSizeType.set(((PicFowardDbRecordData)localObject2).fowardOrgFileSizeType);
        localPBStringField = ((RichMsg.ForwardExtra)localObject3).foward_orgUrl;
        if (((PicFowardDbRecordData)localObject2).fowardOrgUrl == null) {
          break label726;
        }
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardOrgUrl;
        label561:
        localPBStringField.set((String)localObject1);
        localObject3 = ((RichMsg.ForwardExtra)localObject3).foward_thumbPath;
        if (((PicFowardDbRecordData)localObject2).fowardThumbPath == null) {
          break label733;
        }
        localObject1 = ((PicFowardDbRecordData)localObject2).fowardThumbPath;
        label586:
        ((PBStringField)localObject3).set((String)localObject1);
        localPicRec.fowardInfo.setHasFlag(true);
      }
      if (this.picExtraData != null)
      {
        if (this.istroop != 0) {
          break label740;
        }
        localObject1 = this.picExtraData.getOfflineImageResvAttr();
        localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
      }
    }
    for (;;)
    {
      localPicRec.bool_story_pic_send_to_recent.set(this.isStoryPhoto);
      return localPicRec;
      localObject1 = "";
      break;
      label663:
      localObject1 = "";
      break label85;
      label670:
      localObject1 = "";
      break label118;
      label677:
      localObject1 = "";
      break label140;
      label684:
      localObject1 = "";
      break label162;
      label691:
      localObject1 = "";
      break label184;
      label698:
      localObject1 = "";
      break label263;
      label705:
      localObject1 = "";
      break label285;
      label712:
      localObject1 = "";
      break label351;
      label719:
      localObject1 = "";
      break label512;
      label726:
      localObject1 = "";
      break label561;
      label733:
      localObject1 = "";
      break label586;
      label740:
      localObject1 = this.picExtraData.getCustomFaceResvAttr();
      localPicRec.bytes_pb_reserved.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
    }
  }
  
  public String getSummaryMsg()
  {
    String str = bfwr.a(this);
    if (str != null) {
      return str;
    }
    return amtj.a(2131705729);
  }
  
  public ThumbWidthHeightDP getThumbWidthHeightDP(boolean paramBoolean)
  {
    if (this.thumbWidthHeightDP == null) {
      if (agjt.a(this)) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      this.thumbWidthHeightDP = ThumbWidthHeightDP.getThumbWidthHeightDPForPicMsg(paramBoolean, bool);
      return this.thumbWidthHeightDP;
    }
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
  
  public void postRead()
  {
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    this.isShareAppActionMsg = bfti.a(this.msgtype);
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
    return "path:" + this.path + ",uuid:" + this.uuid + ",md5:" + this.md5 + ",size:" + this.size + ",groupFileID:" + this.groupFileID;
  }
  
  public void updateMessage()
  {
    Object localObject;
    if (this.subMsgId == defaultSuMsgId)
    {
      localObject = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      return;
    }
    try
    {
      localObject = ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime((String)localObject)).getMessageFacade();
      this.msgData = getSerialPB().toByteArray();
      ((QQMessageFacade)localObject).updateMsgContentByUniseq(this.frienduin, this.istroop, this.uniseq, this.msgData);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void updateMsgExtFiled()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(str)).getMessageFacade().updateMsgFieldByUniseq(this.frienduin, this.istroop, this.uniseq, "extStr", this.extStr);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
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
        break label402;
      }
      i = 1;
      label146:
      paramParcel.writeInt(i);
      if (!this.isShareAppActionMsg) {
        break label407;
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
        break label412;
      }
      paramInt = 1;
      label375:
      paramParcel.writeByte((byte)paramInt);
      if (!this.isQzonePic) {
        break label417;
      }
    }
    label402:
    label407:
    label412:
    label417:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      i = 0;
      break;
      i = 0;
      break label146;
      i = 0;
      break label160;
      paramInt = 0;
      break label375;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPic
 * JD-Core Version:    0.7.0.1
 */