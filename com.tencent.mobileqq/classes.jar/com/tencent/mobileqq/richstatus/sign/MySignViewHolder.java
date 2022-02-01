package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;

public class MySignViewHolder
  extends BaseSignViewHolder
{
  public MySignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.u = 0;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    w();
    return paramRichStatus;
  }
  
  protected CharSequence a(RichStatus paramRichStatus, ITopic.OnTopicClickListener paramOnTopicClickListener, int paramInt)
  {
    if (paramRichStatus == null) {
      return "";
    }
    Object localObject2 = paramRichStatus.toSpannableStringWithoutAction(paramOnTopicClickListener);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      Object localObject1 = paramRichStatus.actionText;
      paramOnTopicClickListener = (ITopic.OnTopicClickListener)localObject1;
      if (!TextUtils.isEmpty(paramRichStatus.dataText))
      {
        paramOnTopicClickListener = new StringBuilder();
        paramOnTopicClickListener.append((String)localObject1);
        paramOnTopicClickListener.append(paramRichStatus.dataText);
        paramOnTopicClickListener = paramOnTopicClickListener.toString();
      }
      Drawable localDrawable = this.v.getResources().getDrawable(2130851616);
      localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
      ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
      localObject1 = this.v.getResources().getDrawable(2130851609);
      paramRichStatus = SignatureManagerForTool.a().b(paramRichStatus.actionId);
      if (!TextUtils.isEmpty(paramRichStatus))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        localURLDrawableOptions.mRequestWidth = paramInt;
        localURLDrawableOptions.mRequestHeight = paramInt;
        paramRichStatus = URLDrawable.getDrawable(paramRichStatus, localURLDrawableOptions);
        paramRichStatus.setCallback(this.p);
      }
      else
      {
        paramRichStatus = (RichStatus)localObject1;
      }
      paramRichStatus.setBounds(0, 0, paramInt, paramInt);
      int i = Color.parseColor("#ffa8a8a8");
      if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 1, paramOnTopicClickListener, i, localDrawable, paramInt);
      } else {
        paramRichStatus = new SignatureActionSpan(paramRichStatus, 0, paramOnTopicClickListener, i, localDrawable, paramInt);
      }
      ((SpannableStringBuilder)localObject2).setSpan(paramRichStatus, 0, 3, 17);
      return localObject2;
    }
    return localObject2;
  }
  
  protected void i()
  {
    int i = N[6];
    this.j.setPadding(i, i, i, i);
  }
  
  protected boolean m()
  {
    return false;
  }
  
  protected boolean o()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.MySignViewHolder
 * JD-Core Version:    0.7.0.1
 */