package com.tencent.mobileqq.pic.operator;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class BasePicOperator
  extends AbstractPicOperator
{
  public MessageRecord a;
  
  protected AbstractPicOperator a(PicReq paramPicReq)
  {
    AbstractPicOperator localAbstractPicOperator = PicBusiManager.a(paramPicReq.a, paramPicReq.b);
    localAbstractPicOperator.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAbstractPicOperator.b = this.b;
    localAbstractPicOperator.jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
    return localAbstractPicOperator;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    paramMessageForPic = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null);
    paramMessageForPic.downloadImediatly();
    ThreadManagerV2.getUIHandlerV2().post(new BasePicOperator.1(this, paramMessageForPic));
    Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void a(MessageRecord paramMessageRecord, long paramLong)
  {
    OrderMediaMsgManager localOrderMediaMsgManager = (OrderMediaMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    localOrderMediaMsgManager.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localOrderMediaMsgManager.a(paramMessageRecord, ((MessageForPic)paramMessageRecord).path);
  }
  
  protected void a(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramPicUploadInfo = paramPicUploadInfo.a;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BasePicOperator
 * JD-Core Version:    0.7.0.1
 */