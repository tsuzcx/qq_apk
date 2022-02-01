package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.qphone.base.util.QLog;

class MessageForGrayTips$UrlCenterImageSpan
  extends ImageSpan
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public String a;
  
  public MessageForGrayTips$UrlCenterImageSpan(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public MessageForGrayTips$UrlCenterImageSpan(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    super(paramContext, paramInt1, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      if (((URLDrawable)paramDrawable).getStatus() != 1) {
        return;
      }
      int i = paramDrawable.getIntrinsicWidth() / 2;
      int j = paramDrawable.getIntrinsicHeight() / 2;
      if ((!PaiYiPaiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) && (!TroopLuckyCharacterUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)))
      {
        paramDrawable.setBounds(0, 0, i, j);
        return;
      }
      paramDrawable.setBounds(0, 0, (int)(paramInt * 1.0F / j * i), paramInt);
    }
  }
  
  public void a(Drawable.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = paramCallback;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return;
    }
    paramPaint = paramPaint.getFontMetricsInt();
    a(paramCharSequence, paramPaint.bottom - paramPaint.top);
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - paramCharSequence.getBounds().bottom) / 2 + paramInt3);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas = this.jdField_a_of_type_JavaLangString;
    if ((paramCanvas != null) && ((paramCanvas.endsWith(".gif")) || (this.jdField_a_of_type_JavaLangString.endsWith(".apng"))))
    {
      paramCanvas = paramCharSequence.getCallback();
      if ((paramCanvas instanceof View)) {
        ((View)paramCanvas).invalidate();
      }
    }
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null) {
        return localObject;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
      }
      if (this.jdField_a_of_type_JavaLangString.endsWith(".gif")) {
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      } else if (this.jdField_a_of_type_JavaLangString.endsWith(".apng")) {
        ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UrlCenterImageSpan.getDrawable. url:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" drawable:");
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth());
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = null;
        }
        localStringBuilder.append((String)localObject);
        QLog.e(".troop.send_gift", 2, localStringBuilder.toString());
      }
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if (localObject != null)
      {
        ((URLDrawable)localObject).setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new MessageForGrayTips.UrlCenterImageSpan.1(this));
      }
      return this.jdField_a_of_type_ComTencentImageURLDrawable;
    }
    return super.getDrawable();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable();
    if (paramCharSequence == null) {
      return 0;
    }
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt2 = paramPaint.bottom - paramPaint.top;
    a(paramCharSequence, paramInt2);
    paramPaint = paramCharSequence.getBounds();
    if (paramFontMetricsInt != null)
    {
      paramInt1 = (paramPaint.bottom - paramPaint.top) / 2;
      int i = paramInt2 / 4;
      paramInt2 = paramInt1 - i;
      paramInt1 = -(paramInt1 + i);
      paramFontMetricsInt.ascent = paramInt1;
      paramFontMetricsInt.top = paramInt1;
      paramFontMetricsInt.bottom = paramInt2;
      paramFontMetricsInt.descent = paramInt2;
    }
    return paramPaint.right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.UrlCenterImageSpan
 * JD-Core Version:    0.7.0.1
 */