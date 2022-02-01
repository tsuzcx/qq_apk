package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.DynamicDrawableSpan;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.etrump.mixlayout.VasShieldFont;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReplyedMessageSpan
  extends DynamicDrawableSpan
{
  private static String c = "startPos";
  public int a;
  public long a;
  protected Context a;
  public Drawable a;
  protected View.OnClickListener a;
  public String a;
  protected int b;
  public long b;
  public String b;
  public long c;
  public long d;
  
  private ReplyedMessageSpan(Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    super(0);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_Long = paramSourceMsgInfo.mSourceMsgSeq;
    this.jdField_a_of_type_JavaLangString = paramSourceMsgInfo.mSourceMsgText;
    this.jdField_b_of_type_Long = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.jdField_c_of_type_Long = paramSourceMsgInfo.mSourceMsgTime;
    this.jdField_a_of_type_Int = paramSourceMsgInfo.mSourceSummaryFlag;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramSourceMsgInfo.origUid;
    this.jdField_b_of_type_JavaLangString = a(this.jdField_b_of_type_Long, paramSourceMsgInfo.mAtInfoStr);
    a(paramOnClickListener);
    a(paramPaint);
  }
  
  public static ReplyedMessageSpan a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    if ((paramQQAppInterface != null) && (paramContext != null) && (paramSourceMsgInfo != null) && (paramInt > 0)) {
      return new ReplyedMessageSpan(paramContext, paramSourceMsgInfo, paramInt, paramPaint, paramOnClickListener);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("create reply message span failed: source=");
      paramQQAppInterface.append(paramSourceMsgInfo);
      paramQQAppInterface.append(", width=");
      paramQQAppInterface.append(paramInt);
      QLog.w("ReplyedMessageSpan", 2, paramQQAppInterface.toString());
    }
    return null;
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONArray(paramString);
        JSONArray localJSONArray = new JSONArray();
        i = 0;
        int j = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          if (i == 0)
          {
            if (localJSONObject.optLong("uin") == paramLong) {
              j = localJSONObject.optInt(jdField_c_of_type_JavaLangString);
            } else {
              localJSONArray.put(localJSONObject);
            }
          }
          else
          {
            int k = localJSONObject.optInt(jdField_c_of_type_JavaLangString, 0);
            if (k > j) {
              localJSONObject.put(jdField_c_of_type_JavaLangString, k - j);
            }
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          if (localJSONArray.length() == 0) {
            return null;
          }
          localObject = localJSONArray.toString();
          return localObject;
        }
      }
      catch (JSONException localJSONException)
      {
        return paramString;
      }
      i += 1;
    }
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    paramPaint = new SpannableStringBuilder();
    paramPaint.append(ColorNickManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, ChatTextSizeSettingActivity.a(), null, 7));
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setBackgroundDrawable(((TextView)localObject).getResources().getDrawable(2130838206));
    ((TextView)localObject).setGravity(16);
    int i = ((TextView)localObject).getResources().getColor(2131167158);
    ((TextView)localObject).setTextColor(Color.argb(230, (0xFF0000 & i) >> 16, (0xFF00 & i) >> 8, i & 0xFF));
    ((TextView)localObject).setText(paramPaint);
    ((TextView)localObject).setTextSize(1, 13.0F);
    i = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    int j = (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 23.0F);
    ((TextView)localObject).setPadding(i, 0, i, 0);
    ((TextView)localObject).setMaxWidth(this.jdField_b_of_type_Int);
    ((TextView)localObject).setWidth(this.jdField_b_of_type_Int);
    ((TextView)localObject).setHeight(j);
    ((TextView)localObject).setTypeface(VasShieldFont.a(Long.toString(this.jdField_b_of_type_Long)));
    ((TextView)localObject).measure(this.jdField_b_of_type_Int, View.MeasureSpec.makeMeasureSpec(0, 0));
    ((TextView)localObject).layout(0, 0, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getMeasuredHeight());
    ((TextView)localObject).setDrawingCacheEnabled(true);
    paramPaint = ((TextView)localObject).getDrawingCache();
    if (paramPaint != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramPaint);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject != null)
      {
        i = ((Drawable)localObject).getIntrinsicHeight();
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        j = paramPaint.getWidth();
        if (i <= 0) {
          i = 0;
        }
        ((Drawable)localObject).setBounds(0, 0, j, i);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(TextView paramTextView)
  {
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramTextView);
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.ReplyedMessageSpan
 * JD-Core Version:    0.7.0.1
 */