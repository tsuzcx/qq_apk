package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.style.DynamicDrawableSpan;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DisplayUtils;

public class ReplyedMessageSpan
  extends DynamicDrawableSpan
{
  public int a;
  public long a;
  protected Context a;
  public Drawable a;
  protected View.OnClickListener a;
  public String a;
  protected int b;
  public long b;
  public long c;
  
  private ReplyedMessageSpan(Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    super(0);
    this.jdField_a_of_type_Long = paramSourceMsgInfo.mSourceMsgSeq;
    this.jdField_a_of_type_JavaLangString = paramSourceMsgInfo.mSourceMsgText;
    this.jdField_b_of_type_Long = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.c = paramSourceMsgInfo.mSourceMsgTime;
    this.jdField_a_of_type_Int = paramSourceMsgInfo.mSourceSummaryFlag;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramOnClickListener);
    a(paramPaint);
  }
  
  public static ReplyedMessageSpan a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramSourceMsgInfo == null) || (paramInt <= 0)) {
      return null;
    }
    return new ReplyedMessageSpan(paramContext, paramSourceMsgInfo, paramInt, paramPaint, paramOnClickListener);
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {}
    do
    {
      do
      {
        return;
        paramPaint = new QQText("“" + this.jdField_a_of_type_JavaLangString, 7);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setBackgroundColor(218103808);
        ((TextView)localObject).setGravity(16);
        ((TextView)localObject).setTextColor(-5855578);
        ((TextView)localObject).setText(paramPaint);
        ((TextView)localObject).setTextSize(1, 13.0F);
        i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
        ((TextView)localObject).setPadding(i, i, i, i);
        ((TextView)localObject).setMaxWidth(this.jdField_b_of_type_Int);
        ((TextView)localObject).setWidth(this.jdField_b_of_type_Int);
        ((TextView)localObject).measure(this.jdField_b_of_type_Int, View.MeasureSpec.makeMeasureSpec(0, 0));
        ((TextView)localObject).layout(0, 0, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getMeasuredHeight());
        ((TextView)localObject).setDrawingCacheEnabled(true);
        paramPaint = ((TextView)localObject).getDrawingCache();
      } while (paramPaint == null);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramPaint);
    } while (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null);
    int i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = paramPaint.getWidth();
    if (i > 0) {}
    for (;;)
    {
      ((Drawable)localObject).setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(TextView paramTextView)
  {
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramTextView);
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.ReplyedMessageSpan
 * JD-Core Version:    0.7.0.1
 */