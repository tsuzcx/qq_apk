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
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReplyedMessageSpan
  extends DynamicDrawableSpan
{
  private static String l = "startPos";
  protected Context a;
  public Drawable b;
  public long c;
  public long d;
  public String e;
  public long f;
  public int g;
  protected int h = 0;
  public long i;
  public String j;
  protected View.OnClickListener k = null;
  
  private ReplyedMessageSpan(Context paramContext, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, Paint paramPaint, View.OnClickListener paramOnClickListener)
  {
    super(0);
    this.c = paramSourceMsgInfo.mSourceMsgSeq;
    this.e = paramSourceMsgInfo.mSourceMsgText;
    this.d = paramSourceMsgInfo.mSourceMsgSenderUin;
    this.f = paramSourceMsgInfo.mSourceMsgTime;
    this.g = paramSourceMsgInfo.mSourceSummaryFlag;
    this.h = paramInt;
    this.a = paramContext;
    this.i = paramSourceMsgInfo.origUid;
    this.j = a(this.d, paramSourceMsgInfo.mAtInfoStr);
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
      int m;
      try
      {
        Object localObject = new JSONArray(paramString);
        JSONArray localJSONArray = new JSONArray();
        m = 0;
        int n = 0;
        if (m < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(m);
          if (m == 0)
          {
            if (localJSONObject.optLong("uin") == paramLong) {
              n = localJSONObject.optInt(l);
            } else {
              localJSONArray.put(localJSONObject);
            }
          }
          else
          {
            int i1 = localJSONObject.optInt(l, 0);
            if (i1 > n) {
              localJSONObject.put(l, i1 - n);
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
      m += 1;
    }
  }
  
  private void a(Paint paramPaint)
  {
    if (this.b != null) {
      return;
    }
    paramPaint = new SpannableStringBuilder();
    paramPaint.append(ColorNickManager.a(this.e, this.j, ChatTextSizeSettingActivity.a(), null, 7));
    Object localObject = new TextView(this.a);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setBackgroundDrawable(SimpleModeHelper.c(((TextView)localObject).getResources()));
    ((TextView)localObject).setGravity(16);
    int m = ((TextView)localObject).getResources().getColor(2131168141);
    ((TextView)localObject).setTextColor(Color.argb(230, (0xFF0000 & m) >> 16, (0xFF00 & m) >> 8, m & 0xFF));
    ((TextView)localObject).setText(paramPaint);
    ((TextView)localObject).setTextSize(1, 13.0F);
    m = (int)DisplayUtils.a(this.a, 6.0F);
    int n = (int)DisplayUtils.a(this.a, 23.0F);
    ((TextView)localObject).setPadding(m, 0, m, 0);
    ((TextView)localObject).setMaxWidth(this.h);
    ((TextView)localObject).setWidth(this.h);
    ((TextView)localObject).setHeight(n);
    ((TextView)localObject).setTypeface(VasShieldFont.a(Long.toString(this.d)));
    ((TextView)localObject).measure(this.h, View.MeasureSpec.makeMeasureSpec(0, 0));
    ((TextView)localObject).layout(0, 0, ((TextView)localObject).getMeasuredWidth(), ((TextView)localObject).getMeasuredHeight());
    ((TextView)localObject).setDrawingCacheEnabled(true);
    paramPaint = ((TextView)localObject).getDrawingCache();
    if (paramPaint != null)
    {
      this.b = new BitmapDrawable(this.a.getResources(), paramPaint);
      localObject = this.b;
      if (localObject != null)
      {
        m = ((Drawable)localObject).getIntrinsicHeight();
        localObject = this.b;
        n = paramPaint.getWidth();
        if (m <= 0) {
          m = 0;
        }
        ((Drawable)localObject).setBounds(0, 0, n, m);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.k = paramOnClickListener;
  }
  
  public void a(TextView paramTextView)
  {
    View.OnClickListener localOnClickListener = this.k;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramTextView);
    }
  }
  
  public Drawable getDrawable()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.text.ReplyedMessageSpan
 * JD-Core Version:    0.7.0.1
 */