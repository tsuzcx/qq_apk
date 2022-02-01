package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadExtra;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashSet;
import java.util.Set;

public class AioQuickSendPicOperator
  extends UploadPicOperator
{
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1042));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1047));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1054));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1044));
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1049));
  }
  
  public static AioQuickSendPicOperator.QuickSendObject a(MessageRecord paramMessageRecord, TransferRequest paramTransferRequest)
  {
    if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramTransferRequest.mBusiType))) {
      try
      {
        long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("quick_send_original_size")).longValue();
        paramTransferRequest = paramMessageRecord.getExtInfoFromExtStr("quick_send_original_md5");
        if ((l > 0L) && (!paramTransferRequest.equals("")))
        {
          AioQuickSendPicOperator.QuickSendObject localQuickSendObject = new AioQuickSendPicOperator.QuickSendObject();
          localQuickSendObject.jdField_a_of_type_JavaLangString = paramTransferRequest;
          localQuickSendObject.jdField_a_of_type_Long = l;
          localQuickSendObject.b = paramMessageRecord.getExtInfoFromExtStr("quick_send_thumb_md5");
          return localQuickSendObject;
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return null;
  }
  
  public PicUploadInfo a(Intent paramIntent)
  {
    PicUploadInfo localPicUploadInfo = super.a(paramIntent);
    if ((paramIntent != null) && (localPicUploadInfo != null))
    {
      AioQuickSendPicOperator.QuickSendObject localQuickSendObject = new AioQuickSendPicOperator.QuickSendObject();
      localQuickSendObject.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("quick_send_original_md5");
      localQuickSendObject.jdField_a_of_type_Long = paramIntent.getLongExtra("quick_send_original_size", 0L);
      localQuickSendObject.b = paramIntent.getStringExtra("quick_send_thumb_md5");
      localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicOperatorAioQuickSendPicOperator$QuickSendObject = localQuickSendObject;
      localPicUploadInfo.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localPicUploadInfo.k = paramIntent.getStringExtra("key_emotion_source_info");
      localPicUploadInfo.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localPicUploadInfo.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localPicUploadInfo.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localPicUploadInfo.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra == null) {
        localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra = new PicUploadExtra();
      }
      localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
      localPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.b = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
    }
    return localPicUploadInfo;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramMessageForPic.imageType == 2000)) {
      return;
    }
    super.a(paramMessageForPic);
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.b;
    a(paramMessageForPic, paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicOperatorAioQuickSendPicOperator$QuickSendObject);
    PicMessageExtraData localPicMessageExtraData = paramMessageForPic.picExtraData;
    if (localPicMessageExtraData == null) {
      localPicMessageExtraData = new PicMessageExtraData();
    }
    for (;;)
    {
      if (i == 1042) {
        if (paramPicUploadInfo.d())
        {
          localPicMessageExtraData.imageBizType = 13;
          localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691358);
          paramMessageForPic.picExtraData = localPicMessageExtraData;
        }
      }
      label319:
      label326:
      do
      {
        do
        {
          return;
          localPicMessageExtraData.imageBizType = 2;
          break;
          if (i == 1047)
          {
            if (paramPicUploadInfo.c())
            {
              localPicMessageExtraData.imageBizType = 9;
              localPicMessageExtraData.setAdEmoJumpUrl(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.c);
              localPicMessageExtraData.setAdEmoDescStr(paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadExtra.d);
            }
            for (;;)
            {
              paramPicUploadInfo = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramPicUploadInfo != null)
              {
                paramPicUploadInfo = paramPicUploadInfo.a();
                if (!TextUtils.isEmpty(paramPicUploadInfo)) {
                  localPicMessageExtraData.textSummary = ("[" + paramPicUploadInfo + "]");
                }
              }
              paramMessageForPic.picExtraData = localPicMessageExtraData;
              return;
              localPicMessageExtraData.imageBizType = 7;
            }
          }
          if (i == 1044)
          {
            localPicMessageExtraData.imageBizType = 3;
            localPicMessageExtraData.textSummary = BaseApplicationImpl.getApplication().getString(2131691358);
            paramMessageForPic.picExtraData = localPicMessageExtraData;
            return;
          }
          if (i != 1049) {
            break label326;
          }
          localPicMessageExtraData.imageBizType = 4;
          paramPicUploadInfo = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramPicUploadInfo instanceof AppInterface)) {
            break label319;
          }
          paramPicUploadInfo = ZhituManager.a((AppInterface)paramPicUploadInfo).b();
        } while (TextUtils.isEmpty(paramPicUploadInfo));
        localPicMessageExtraData.textSummary = ("[" + paramPicUploadInfo + "]");
        paramMessageForPic.picExtraData = localPicMessageExtraData;
        return;
      } while (i != 1054);
      localPicMessageExtraData.imageBizType = 10;
      localPicMessageExtraData.textSummary = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691358);
      paramMessageForPic.picExtraData = localPicMessageExtraData;
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, AioQuickSendPicOperator.QuickSendObject paramQuickSendObject)
  {
    if ((paramQuickSendObject != null) && (paramMessageRecord != null))
    {
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_md5", paramQuickSendObject.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("quick_send_original_size", String.valueOf(paramQuickSendObject.jdField_a_of_type_Long));
      paramMessageRecord.saveExtInfoToExtStr("quick_send_thumb_md5", paramQuickSendObject.b);
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator
 * JD-Core Version:    0.7.0.1
 */