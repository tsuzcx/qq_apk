package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.doutu.DoutuUtils;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class AioPicOperator
  extends BasePicOprerator
{
  public AioPicOperator() {}
  
  public AioPicOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = MD5FileUtil.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramPicUploadInfo = paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
    int i = paramPicUploadInfo.size();
    int j;
    if (i == 10)
    {
      i = 9;
      j = 4;
    }
    for (;;)
    {
      if (i != -1)
      {
        paramMessageForPic.mDownloadLength = ((Integer)paramPicUploadInfo.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramPicUploadInfo.get(j)).intValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "AioPicOperator.loadPgInfo():showLen " + paramMessageForPic.mShowLength + ", downloadLen " + paramMessageForPic.mDownloadLength);
      }
      return;
      if (i == 6)
      {
        i = 5;
        j = 5;
      }
      else
      {
        j = -1;
        i = -1;
      }
    }
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((HotChatHelper.a(paramMessageForPic)) || (FlashPicHelper.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = URLDrawableHelper.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (FlashPicHelper.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.j);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      URLDrawableHelper.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    }
  }
  
  public MessageRecord a(PicFowardInfo paramPicFowardInfo)
  {
    boolean bool = true;
    if ((paramPicFowardInfo == null) || (!paramPicFowardInfo.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    PicUploadInfo localPicUploadInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
    PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
    localPicFowardDbRecordData.c = localPicUploadInfo.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicUploadInfo.c, localPicUploadInfo.jdField_d_of_type_JavaLangString, localPicUploadInfo.jdField_b_of_type_Int);
    localMessageForPic.path = localPicUploadInfo.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localPicUploadInfo.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 3;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localPicUploadInfo.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.a(localPicUploadInfo.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
    }
    localMessageForPic.fileSizeFlag = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l;
    paramPicFowardInfo = paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (paramPicFowardInfo != null)
    {
      localMessageForPic.md5 = paramPicFowardInfo.f;
      localPicFowardDbRecordData.jdField_a_of_type_Long = paramPicFowardInfo.jdField_a_of_type_Long;
      localPicFowardDbRecordData.jdField_a_of_type_JavaLangString = paramPicFowardInfo.c;
      localPicFowardDbRecordData.jdField_a_of_type_Int = paramPicFowardInfo.jdField_b_of_type_Int;
      localPicFowardDbRecordData.b = paramPicFowardInfo.jdField_g_of_type_JavaLangString;
    }
    localMessageForPic.picExtraFlag = TranDbRecord.PicDbRecord.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localPicFowardDbRecordData;
    if (localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
      }
      localMessageForPic.localUUID = localPicUploadInfo.jdField_a_of_type_JavaLangString;
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = PeakUtils.a(localPicUploadInfo.jdField_g_of_type_JavaLangString);
      paramPicFowardInfo = localPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
      if ((paramPicFowardInfo == null) || (paramPicFowardInfo.isEmpty())) {
        break label677;
      }
      a(localPicUploadInfo, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramPicFowardInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramPicFowardInfo != null) {
        paramPicFowardInfo.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new BaseTransProcessor(paramPicFowardInfo));
      }
      b(localMessageForPic);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label677:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(PicUploadInfo paramPicUploadInfo)
  {
    long l = System.currentTimeMillis();
    if ((paramPicUploadInfo != null) && (paramPicUploadInfo.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPicUploadInfo.c, paramPicUploadInfo.jdField_d_of_type_JavaLangString, paramPicUploadInfo.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramPicUploadInfo.jdField_a_of_type_Int;
      localMessageForPic.path = paramPicUploadInfo.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramPicUploadInfo.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label229:
      Object localObject;
      if (paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo.c;
        }
        localMessageForPic.localUUID = paramPicUploadInfo.jdField_a_of_type_JavaLangString;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!GeneralConfigUtils.a()) {
          break label908;
        }
        localMessageForPic.bigThumbMsgUrl = paramPicUploadInfo.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramPicUploadInfo.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramPicUploadInfo.jdField_f_of_type_Int;
        localObject = new File(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramPicUploadInfo.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (RichMediaUtil.a(paramPicUploadInfo.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramPicUploadInfo.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramPicUploadInfo.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramPicUploadInfo.n;
        localMessageForPic.sync2Story = paramPicUploadInfo.jdField_g_of_type_Boolean;
        String str = MessageConstants.n;
        if (!localMessageForPic.sync2Story) {
          break label920;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic, paramPicUploadInfo.c, paramPicUploadInfo.jdField_b_of_type_Int, paramPicUploadInfo.jdField_o_of_type_Int);
        if (paramPicUploadInfo.jdField_b_of_type_Int != 0) {
          break label928;
        }
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic, paramPicUploadInfo.c);
        label557:
        if (paramPicUploadInfo.jdField_a_of_type_Int == 1036) {
          DatingUtil.a(localMessageForPic);
        }
        if (paramPicUploadInfo.jdField_a_of_type_Int == 1039) {
          HotChatHelper.a(localMessageForPic, false);
        }
        if (paramPicUploadInfo.jdField_a_of_type_Int == 1040) {
          FlashPicHelper.a(localMessageForPic, false);
        }
        if (paramPicUploadInfo.jdField_a_of_type_Int == 1042) {
          HotPicHelper.a(localMessageForPic, paramPicUploadInfo.j, paramPicUploadInfo.jdField_d_of_type_Long, paramPicUploadInfo.k);
        }
        if (paramPicUploadInfo.jdField_a_of_type_Int == 1044) {
          DoutuUtils.a(localMessageForPic, paramPicUploadInfo);
        }
        if (paramPicUploadInfo.p == 1)
        {
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramPicUploadInfo.jdField_o_of_type_JavaLangString);
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramPicUploadInfo.jdField_f_of_type_Long));
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramPicUploadInfo.jdField_g_of_type_Int));
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramPicUploadInfo.jdField_g_of_type_Long));
          localMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramPicUploadInfo.jdField_h_of_type_Long));
        }
        localMessageForPic.imageType = PeakUtils.a(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
        localObject = paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label952;
        }
        a(paramPicUploadInfo, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramPicUploadInfo.jdField_a_of_type_Long = localMessageForPic.uniseq;
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        b(localMessageForPic);
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramPicUploadInfo.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramPicUploadInfo.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label908:
        localMessageForPic.thumbMsgUrl = paramPicUploadInfo.jdField_h_of_type_JavaLangString;
        break label229;
        label920:
        localObject = "0";
        break label507;
        label928:
        if (paramPicUploadInfo.jdField_b_of_type_Int != 1) {
          break label557;
        }
        ConfessMsgUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic, paramPicUploadInfo.c);
        break label557;
        label952:
        if (QLog.isColorLevel()) {
          QLog.d("peak_pgjpeg", 2, "Slice infos is null");
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), CompressOperator.a(i), j);
  }
  
  public PicFowardInfo a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      Object localObject2 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str5 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str6 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      String str1 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject3 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
      int j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
      long l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      int k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      String str4 = paramIntent.getStringExtra("forward_photo_md5");
      int m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      long l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      paramIntent = new PicFowardInfo();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a((String)localObject1);
      localBuilder.c(str1);
      localBuilder.c(TranDbRecord.PicDbRecord.jdField_f_of_type_Int);
      localBuilder.g((int)l3);
      localBuilder.h((int)l4);
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localBuilder.a((int)l5);
      localBuilder.i(k);
      localBuilder.j(n);
      localObject3 = AbsDownloader.a((String)localObject3);
      if (localObject3 != null) {
        localBuilder.b(((File)localObject3).getAbsolutePath());
      }
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
      localBuilder.e(i);
      localBuilder.e(str5);
      localBuilder.d(str6);
      localBuilder.f(str4);
      paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
      if (k == 1) {
        paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
        if (PeakUtils.a((String)localObject1)) {
          LogTag.a();
        }
        try
        {
          ((PicUploadInfo)localObject2).jdField_a_of_type_JavaUtilArrayList = PeakUtils.a((String)localObject1);
          LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!FileUtils.b((String)localObject1))
          {
            localObject1 = new PicDownloadInfo.Builder();
            ((PicDownloadInfo.Builder)localObject1).a(1009);
            ((PicDownloadInfo.Builder)localObject1).a(str1);
            ((PicDownloadInfo.Builder)localObject1).b(str2);
            ((PicDownloadInfo.Builder)localObject1).b(j);
            ((PicDownloadInfo.Builder)localObject1).c(str3);
            ((PicDownloadInfo.Builder)localObject1).a(l1);
            ((PicDownloadInfo.Builder)localObject1).d(str4);
            ((PicDownloadInfo.Builder)localObject1).c(m);
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = ((PicDownloadInfo.Builder)localObject1).a();
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = l2;
          }
          Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + FileUtils.a((String)localObject1));
            }
          }
        }
      }
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      PicFowardInfo localPicFowardInfo;
      if (i == 0)
      {
        i = 65537;
        Object localObject = URLDrawableHelper.a(paramMessageForPic, i).toString();
        localPicFowardInfo = new PicFowardInfo();
        localPicFowardInfo.b = paramMessageForPic.isSendFromLocal();
        PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
        localBuilder.d(1009);
        localBuilder.a(paramMessageForPic.path);
        localBuilder.c(paramString3);
        localBuilder.c(TranDbRecord.PicDbRecord.jdField_f_of_type_Int);
        localBuilder.g((int)paramMessageForPic.width);
        localBuilder.h((int)paramMessageForPic.height);
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localBuilder.a((int)paramMessageForPic.size);
        localBuilder.i(paramMessageForPic.fileSizeFlag);
        localBuilder.a(paramMessageForPic.thumbWidth);
        localBuilder.b(paramMessageForPic.thumbHeight);
        localBuilder.j(paramMessageForPic.imageType);
        localObject = AbsDownloader.a((String)localObject);
        if (localObject != null) {
          localBuilder.b(((File)localObject).getAbsolutePath());
        }
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localBuilder.e(paramInt);
        localBuilder.e(paramString1);
        localBuilder.d(paramString2);
        localBuilder.f(paramMessageForPic.md5);
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
        localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
        if ((paramString1.jdField_h_of_type_Int < 0) && (PeakUtils.a(paramMessageForPic.path))) {
          LogTag.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(paramMessageForPic.path);
        LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!FileUtils.b(paramMessageForPic.path)))
        {
          paramString1 = new PicDownloadInfo.Builder();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramString1.a();
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
        {
          bool = true;
          Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localPicFowardInfo;
          i = 0;
          continue;
          i = 1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + FileUtils.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("uin");
      String str1 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      String str2 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool = paramIntent.getBooleanExtra("video_sync_to_story", false);
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d((String)localObject);
      localBuilder.a(str2);
      localBuilder.e(i);
      localBuilder.e(str1);
      localBuilder.d(k);
      localBuilder.f(j);
      localBuilder.l(n);
      localBuilder.k(m);
      localBuilder.a(bool);
      localObject = localBuilder.a();
      HotPicHelper.a((PicUploadInfo)localObject, paramIntent, k);
      DoutuUtils.a(paramIntent, (PicUploadInfo)localObject);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((PicUploadInfo)localObject).p = i;
        ((PicUploadInfo)localObject).jdField_o_of_type_JavaLangString = str1;
        ((PicUploadInfo)localObject).jdField_f_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((PicUploadInfo)localObject).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((PicUploadInfo)localObject).jdField_h_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public ArrayList a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForMixedMsg == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramMessageForMixedMsg.msgElemList == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
      }
    }
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramSendResult.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramSendResult.c;
      localMessageForPic.groupFileID = paramSendResult.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.AioPicOperator
 * JD-Core Version:    0.7.0.1
 */