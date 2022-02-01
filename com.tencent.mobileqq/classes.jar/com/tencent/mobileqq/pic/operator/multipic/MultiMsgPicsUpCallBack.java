package com.tencent.mobileqq.pic.operator.multipic;

import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

public class MultiMsgPicsUpCallBack
  extends MultiPicsBaseClass
  implements UpCallBack
{
  final int jdField_a_of_type_Int;
  final Rect jdField_a_of_type_AndroidGraphicsRect;
  final PicFowardInfo jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
  final PicResult jdField_a_of_type_ComTencentMobileqqPicPicResult;
  
  public MultiMsgPicsUpCallBack(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, WeakReference<AppInterface> paramWeakReference, int paramInt, String paramString)
  {
    super(paramMultiPicsUploadTask, paramWeakReference);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPicPicResult = ((PicResult)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo = ((PicFowardInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    this.jdField_a_of_type_AndroidGraphicsRect = a(paramString);
  }
  
  private Rect a(String paramString)
  {
    Rect localRect = new Rect(0, 0, 0, 0);
    if (paramString != null)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int m = localOptions.outWidth;
      int n = localOptions.outHeight;
      int i = Math.min(m, n);
      int k = Math.max(m, n);
      float f1 = k;
      float f2 = i;
      float f3 = f1 / f2;
      int j = 198;
      if (i > 198) {
        if (f3 > 3.0F)
        {
          i = 66;
          break label191;
        }
      }
      for (;;)
      {
        i = (int)(f2 * 198.0F / f1);
        break label191;
        if ((i <= 66) || (i > 198)) {
          break label161;
        }
        if (f3 > 3.0F) {
          break;
        }
        if (k < 198) {
          break label187;
        }
      }
      label161:
      if ((i > 66) || (f3 <= 3.0F) || (k < 198)) {
        label187:
        j = k;
      }
      label191:
      if (m < n)
      {
        localRect.right = i;
        localRect.bottom = j;
        return localRect;
      }
      localRect.right = j;
      localRect.bottom = i;
    }
    return localRect;
  }
  
  public MessageRecord a(im_msg_body.RichText arg1)
  {
    int i = 0;
    Object localObject3;
    StringBuilder localStringBuilder;
    if ((??? != null) && (???.elems.has()))
    {
      ??? = (im_msg_body.Elem)???.elems.get(0);
      if (??? != null)
      {
        if (???.not_online_image.has())
        {
          ??? = (im_msg_body.NotOnlineImage)???.not_online_image.get();
          ???.uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
          ???.uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
          if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 1) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 3000)) {
            synchronized (this.jdField_a_of_type_JavaUtilArrayList)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = ???;
              ??? = this.b;
              localObject3 = this.jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.jdField_a_of_type_Int);
              localStringBuilder.append("] OK, ");
              localStringBuilder.append(a(???));
              Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
              if (!QLog.isColorLevel()) {
                break label918;
              }
              ??? = new StringBuilder();
              ???.append("[uploadForwardMultiMsgPics] upload [");
              ???.append(this.jdField_a_of_type_Int);
              ???.append("] OK");
              QLog.d("MultiPicsOperator", 2, ???.toString());
            }
          }
          ??? = this.b;
          localObject3 = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("convert2CustomFace for [");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          localStringBuilder.append("] ");
          Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
          ??? = a(???);
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = ???;
            ??? = this.b;
            localObject3 = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append("] OK, ");
            localStringBuilder.append(a(???));
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            if (!QLog.isColorLevel()) {
              break label918;
            }
            ??? = new StringBuilder();
            ???.append("[uploadForwardMultiMsgPics] upload [");
            ???.append(this.jdField_a_of_type_Int);
            ???.append("] OK");
            QLog.d("MultiPicsOperator", 2, ???.toString());
          }
        }
        if (???.custom_face.has())
        {
          ??? = (im_msg_body.CustomFace)???.custom_face.get();
          ???.uint32_thumb_width.set(this.jdField_a_of_type_AndroidGraphicsRect.right);
          ???.uint32_thumb_height.set(this.jdField_a_of_type_AndroidGraphicsRect.bottom);
          if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 1) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 3000))
          {
            ??? = this.b;
            localObject3 = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("convert2NotOnlineImage for [");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append("] ");
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            ??? = a(???);
            synchronized (this.jdField_a_of_type_JavaUtilArrayList)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = 0;
              this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = ???;
              ??? = this.b;
              localObject3 = this.jdField_a_of_type_JavaLangString;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.jdField_a_of_type_Int);
              localStringBuilder.append("] OK, ");
              localStringBuilder.append(a(???));
              Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ???.append("[uploadForwardMultiMsgPics] upload [");
                ???.append(this.jdField_a_of_type_Int);
                ???.append("] OK");
                QLog.d("MultiPicsOperator", 2, ???.toString());
              }
            }
          }
          synchronized (this.jdField_a_of_type_JavaUtilArrayList)
          {
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = ???;
            ??? = this.b;
            localObject3 = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.jdField_a_of_type_Int);
            localStringBuilder.append("] OK, ");
            localStringBuilder.append(a(???));
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ???.append("[uploadForwardMultiMsgPics] upload [");
              ???.append(this.jdField_a_of_type_Int);
              ???.append("] OK");
              QLog.d("MultiPicsOperator", 2, ???.toString());
            }
            label918:
            i = 1;
          }
        }
        ??? = this.b;
        ??? = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject3).append("] failed, elem.not_online_image and elem.custom_face are null");
        Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
      }
      else
      {
        ??? = this.b;
        ??? = this.jdField_a_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject3).append("] failed, richText.elems is null");
        Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      ??? = this.b;
      ??? = this.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append("] failed, richText is null or richText.elems is null");
      Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
    }
    if (i == 0) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int = -1;
        ??? = this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Get target pic filepath of [");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject3).append("] failed");
        ((PicInfoInterface.ErrInfo)???).b = ((StringBuilder)localObject3).toString();
        if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 1) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 3000)) {
          this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = a(null, null, this.jdField_a_of_type_Int);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = a(null, null, this.jdField_a_of_type_Int);
        }
        ??? = this.b;
        localObject3 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("] failed, errDec ＝ ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
        Logger.b((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[uploadForwardMultiMsgPics] upload [");
          ((StringBuilder)???).append(this.jdField_a_of_type_Int);
          ((StringBuilder)???).append("] failed, errDec ＝ ");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
          QLog.e("MultiPicsOperator", 2, ((StringBuilder)???).toString());
        }
      }
    }
    a();
    if (a() == 0) {
      b();
    }
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (paramSendResult.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_Int = -1;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = paramSendResult.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int = paramSendResult.b;
        if ((this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 1) && (this.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.a.b != 3000)) {
          this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = a(null, null, this.jdField_a_of_type_Int);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_JavaLangObject = a(null, null, this.jdField_a_of_type_Int);
        }
        paramSendResult = this.b;
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("] failed, errDec = ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
        Logger.a(paramSendResult, str, "uploadForwardMultiMsgPics.onSend", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          paramSendResult = new StringBuilder();
          paramSendResult.append("[uploadForwardMultiMsgPics] upload [");
          paramSendResult.append(this.jdField_a_of_type_Int);
          paramSendResult.append("] failed, errDec ＝ ");
          paramSendResult.append(this.jdField_a_of_type_ComTencentMobileqqPicPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
          QLog.e("MultiPicsOperator", 2, paramSendResult.toString());
        }
        a();
        if (a() == 0) {
          b();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiMsgPicsUpCallBack
 * JD-Core Version:    0.7.0.1
 */