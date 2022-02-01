package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack.Stub;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DESUtil;
import com.tencent.qphone.base.util.QLog;

class HotChatFlashPicActivity$1
  extends IAIOImageProviderCallBack.Stub
{
  HotChatFlashPicActivity$1(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void a() {}
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyImageProgress progress:");
      localStringBuilder.append(paramInt3);
      QLog.d("Q.hotchat", 4, localStringBuilder.toString());
    }
    if ((HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Long == paramLong1) && (HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Int == paramInt1)) {
      HotChatFlashPicActivity.a(this.a, paramInt3 / 100);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyImageResult type:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",resultStr:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",result:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",isPart:");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.hotchat", 4, localStringBuilder.toString());
    }
    if ((HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Long == paramLong) && (HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Int == paramInt1) && (paramInt2 == 2))
    {
      HotChatFlashPicActivity.a(this.a, false);
      if (paramInt3 == 1)
      {
        HotChatFlashPicActivity.a(this.a).jdField_b_of_type_JavaLangString = paramString;
        HotChatFlashPicActivity.a(this.a).d = paramBoolean;
        HotChatFlashPicActivity.a(this.a).jdField_b_of_type_Boolean = false;
      }
      else
      {
        HotChatFlashPicActivity.a(this.a).jdField_b_of_type_Boolean = true;
      }
      paramString = this.a;
      HotChatFlashPicActivity.a(paramString, HotChatFlashPicActivity.a(paramString));
      if ((HotChatFlashPicActivity.b(this.a) != null) && (!HotChatFlashPicActivity.b(this.a).equals("I:E")))
      {
        DESUtil.b(HotChatFlashPicActivity.b(this.a), HotChatFlashPicActivity.c(this.a));
        HotChatFlashPicActivity.b(this.a, true);
        paramString = this.a;
        HotChatFlashPicActivity.a(paramString, HotChatFlashPicActivity.b(paramString));
        return;
      }
      if (HotChatFlashPicActivity.b(this.a) != null) {
        HotChatFlashPicActivity.a(this.a).sendEmptyMessage(1);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.1
 * JD-Core Version:    0.7.0.1
 */