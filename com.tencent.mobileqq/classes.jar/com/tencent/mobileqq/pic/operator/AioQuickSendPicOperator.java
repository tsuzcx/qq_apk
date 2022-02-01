package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadExtra;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.qroute.QRoute;
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
      localPicUploadInfo.b = localQuickSendObject;
      localPicUploadInfo.r = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localPicUploadInfo.k = paramIntent.getStringExtra("key_emotion_source_info");
      localPicUploadInfo.l = paramIntent.getStringExtra("key_emotion_source_weburl");
      localPicUploadInfo.m = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localPicUploadInfo.n = paramIntent.getStringExtra("key_emotion_source_packagename");
      localPicUploadInfo.s = paramIntent.getIntExtra("key_emotion_source_epid", 0);
      if (localPicUploadInfo.a == null) {
        localPicUploadInfo.a = new PicUploadExtra();
      }
      localPicUploadInfo.a.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("quick_send_is_ad_emo", false);
      localPicUploadInfo.a.c = paramIntent.getStringExtra("quick_send_ad_emo_jump_url");
      localPicUploadInfo.a.d = paramIntent.getStringExtra("quick_send_ad_emo_desc_str");
      localPicUploadInfo.a.b = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
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
    Object localObject1 = paramPicUploadInfo.b;
    if ((localObject1 instanceof AioQuickSendPicOperator.QuickSendObject)) {
      a(paramMessageForPic, (AioQuickSendPicOperator.QuickSendObject)localObject1);
    }
    Object localObject2 = paramMessageForPic.picExtraData;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new PicMessageExtraData();
    }
    if (i == 1042)
    {
      if (paramPicUploadInfo.d()) {
        ((PicMessageExtraData)localObject1).imageBizType = 13;
      } else {
        ((PicMessageExtraData)localObject1).imageBizType = 2;
      }
      ((PicMessageExtraData)localObject1).textSummary = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691279);
      paramMessageForPic.picExtraData = ((PicMessageExtraData)localObject1);
      return;
    }
    if (i == 1047)
    {
      if (paramPicUploadInfo.c())
      {
        ((PicMessageExtraData)localObject1).imageBizType = 9;
        ((PicMessageExtraData)localObject1).setAdEmoJumpUrl(paramPicUploadInfo.a.c);
        ((PicMessageExtraData)localObject1).setAdEmoDescStr(paramPicUploadInfo.a.d);
      }
      else
      {
        ((PicMessageExtraData)localObject1).imageBizType = 7;
      }
      paramPicUploadInfo = ((IStickerRecManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IStickerRecManager.class, "")).getCurrentText();
      if (!TextUtils.isEmpty(paramPicUploadInfo))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(paramPicUploadInfo);
        ((StringBuilder)localObject2).append("]");
        ((PicMessageExtraData)localObject1).textSummary = ((StringBuilder)localObject2).toString();
      }
      paramMessageForPic.picExtraData = ((PicMessageExtraData)localObject1);
      return;
    }
    if (i == 1044)
    {
      ((PicMessageExtraData)localObject1).imageBizType = 3;
      ((PicMessageExtraData)localObject1).textSummary = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691279);
      paramMessageForPic.picExtraData = ((PicMessageExtraData)localObject1);
      return;
    }
    if (i == 1049)
    {
      ((PicMessageExtraData)localObject1).imageBizType = 4;
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof AppInterface))
      {
        paramPicUploadInfo = ((IDep)QRoute.api(IDep.class)).getZhituText();
        if (TextUtils.isEmpty(paramPicUploadInfo)) {
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(paramPicUploadInfo);
        ((StringBuilder)localObject2).append("]");
        ((PicMessageExtraData)localObject1).textSummary = ((StringBuilder)localObject2).toString();
      }
      paramMessageForPic.picExtraData = ((PicMessageExtraData)localObject1);
      return;
    }
    if (i == 1054)
    {
      ((PicMessageExtraData)localObject1).imageBizType = 10;
      ((PicMessageExtraData)localObject1).textSummary = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691279);
      paramMessageForPic.picExtraData = ((PicMessageExtraData)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQuickSendPicOperator
 * JD-Core Version:    0.7.0.1
 */