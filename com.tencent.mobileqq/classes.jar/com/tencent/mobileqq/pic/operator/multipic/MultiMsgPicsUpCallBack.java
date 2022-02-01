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
  final int a;
  final PicResult b;
  final PicFowardInfo c;
  final Rect d;
  
  public MultiMsgPicsUpCallBack(MultiPicsOperator.MultiPicsUploadTask paramMultiPicsUploadTask, WeakReference<AppInterface> paramWeakReference, int paramInt, String paramString)
  {
    super(paramMultiPicsUploadTask, paramWeakReference);
    this.a = paramInt;
    this.b = ((PicResult)this.h.get(this.a));
    this.c = ((PicFowardInfo)this.i.get(paramInt));
    this.d = a(paramString);
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
          ???.uint32_thumb_width.set(this.d.right);
          ???.uint32_thumb_height.set(this.d.bottom);
          if ((this.c.c.c != 1) && (this.c.c.c != 3000)) {
            synchronized (this.h)
            {
              this.b.a = 0;
              this.b.d = ???;
              ??? = this.f;
              localObject3 = this.e;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.a);
              localStringBuilder.append("] OK, ");
              localStringBuilder.append(b(???));
              Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
              if (!QLog.isColorLevel()) {
                break label918;
              }
              ??? = new StringBuilder();
              ???.append("[uploadForwardMultiMsgPics] upload [");
              ???.append(this.a);
              ???.append("] OK");
              QLog.d("MultiPicsOperator", 2, ???.toString());
            }
          }
          ??? = this.f;
          localObject3 = this.e;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("convert2CustomFace for [");
          localStringBuilder.append(this.a);
          localStringBuilder.append("] ");
          Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
          ??? = a(???);
          synchronized (this.h)
          {
            this.b.a = 0;
            this.b.d = ???;
            ??? = this.f;
            localObject3 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.a);
            localStringBuilder.append("] OK, ");
            localStringBuilder.append(b(???));
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            if (!QLog.isColorLevel()) {
              break label918;
            }
            ??? = new StringBuilder();
            ???.append("[uploadForwardMultiMsgPics] upload [");
            ???.append(this.a);
            ???.append("] OK");
            QLog.d("MultiPicsOperator", 2, ???.toString());
          }
        }
        if (???.custom_face.has())
        {
          ??? = (im_msg_body.CustomFace)???.custom_face.get();
          ???.uint32_thumb_width.set(this.d.right);
          ???.uint32_thumb_height.set(this.d.bottom);
          if ((this.c.c.c != 1) && (this.c.c.c != 3000))
          {
            ??? = this.f;
            localObject3 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("convert2NotOnlineImage for [");
            localStringBuilder.append(this.a);
            localStringBuilder.append("] ");
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            ??? = a(???);
            synchronized (this.h)
            {
              this.b.a = 0;
              this.b.d = ???;
              ??? = this.f;
              localObject3 = this.e;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append(this.a);
              localStringBuilder.append("] OK, ");
              localStringBuilder.append(b(???));
              Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ???.append("[uploadForwardMultiMsgPics] upload [");
                ???.append(this.a);
                ???.append("] OK");
                QLog.d("MultiPicsOperator", 2, ???.toString());
              }
            }
          }
          synchronized (this.h)
          {
            this.b.a = 0;
            this.b.d = ???;
            ??? = this.f;
            localObject3 = this.e;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[");
            localStringBuilder.append(this.a);
            localStringBuilder.append("] OK, ");
            localStringBuilder.append(b(???));
            Logger.a((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder();
              ???.append("[uploadForwardMultiMsgPics] upload [");
              ???.append(this.a);
              ???.append("] OK");
              QLog.d("MultiPicsOperator", 2, ???.toString());
            }
            label918:
            i = 1;
          }
        }
        ??? = this.f;
        ??? = this.e;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append("] failed, elem.not_online_image and elem.custom_face are null");
        Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
      }
      else
      {
        ??? = this.f;
        ??? = this.e;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append("] failed, richText.elems is null");
        Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      ??? = this.f;
      ??? = this.e;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[");
      ((StringBuilder)localObject3).append(this.a);
      ((StringBuilder)localObject3).append("] failed, richText is null or richText.elems is null");
      Logger.b(???, (String)???, "uploadForwardMultiMsgPics.attachRichText2Msg", ((StringBuilder)localObject3).toString());
    }
    if (i == 0) {
      synchronized (this.h)
      {
        this.b.a = -1;
        this.b.b = new PicInfoInterface.ErrInfo();
        this.b.b.c = -1;
        ??? = this.b.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Get target pic filepath of [");
        ((StringBuilder)localObject3).append(this.a);
        ((StringBuilder)localObject3).append("] failed");
        ((PicInfoInterface.ErrInfo)???).b = ((StringBuilder)localObject3).toString();
        if ((this.c.c.c != 1) && (this.c.c.c != 3000)) {
          this.b.d = a(null, null, this.a);
        } else {
          this.b.d = a(null, null, this.a);
        }
        ??? = this.f;
        localObject3 = this.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] failed, errDec ＝ ");
        localStringBuilder.append(this.b.b.b);
        Logger.b((String)???, (String)localObject3, "uploadForwardMultiMsgPics.attachRichText2Msg", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("[uploadForwardMultiMsgPics] upload [");
          ((StringBuilder)???).append(this.a);
          ((StringBuilder)???).append("] failed, errDec ＝ ");
          ((StringBuilder)???).append(this.b.b.b);
          QLog.e("MultiPicsOperator", 2, ((StringBuilder)???).toString());
        }
      }
    }
    a();
    if (c() == 0) {
      b();
    }
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    synchronized (this.h)
    {
      if (paramSendResult.a != 0)
      {
        this.b.a = -1;
        this.b.b = new PicInfoInterface.ErrInfo();
        this.b.b.b = paramSendResult.c;
        this.b.b.c = paramSendResult.b;
        if ((this.c.c.c != 1) && (this.c.c.c != 3000)) {
          this.b.d = a(null, null, this.a);
        } else {
          this.b.d = a(null, null, this.a);
        }
        paramSendResult = this.f;
        String str = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("] failed, errDec = ");
        localStringBuilder.append(this.b.b.b);
        Logger.a(paramSendResult, str, "uploadForwardMultiMsgPics.onSend", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          paramSendResult = new StringBuilder();
          paramSendResult.append("[uploadForwardMultiMsgPics] upload [");
          paramSendResult.append(this.a);
          paramSendResult.append("] failed, errDec ＝ ");
          paramSendResult.append(this.b.b.b);
          QLog.e("MultiPicsOperator", 2, paramSendResult.toString());
        }
        a();
        if (c() == 0) {
          b();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiMsgPicsUpCallBack
 * JD-Core Version:    0.7.0.1
 */