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
    this.e = 0;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    l();
    return paramRichStatus;
  }
  
  protected CharSequence a(RichStatus paramRichStatus, ITopic.OnTopicClickListener paramOnTopicClickListener, int paramInt)
  {
    if (paramRichStatus == null) {
      paramOnTopicClickListener = "";
    }
    do
    {
      return paramOnTopicClickListener;
      localObject1 = paramRichStatus.toSpannableStringWithoutAction(paramOnTopicClickListener);
      paramOnTopicClickListener = (ITopic.OnTopicClickListener)localObject1;
    } while (TextUtils.isEmpty(paramRichStatus.actionText));
    Object localObject2 = paramRichStatus.actionText;
    paramOnTopicClickListener = (ITopic.OnTopicClickListener)localObject2;
    if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
      paramOnTopicClickListener = (String)localObject2 + paramRichStatus.dataText;
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849990);
    localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849983);
    String str = SignatureManagerForTool.a().a(paramRichStatus.actionId);
    paramRichStatus = (RichStatus)localObject1;
    if (!TextUtils.isEmpty(str))
    {
      paramRichStatus = URLDrawable.URLDrawableOptions.obtain();
      paramRichStatus.mLoadingDrawable = ((Drawable)localObject1);
      paramRichStatus.mFailedDrawable = ((Drawable)localObject1);
      paramRichStatus.mRequestWidth = paramInt;
      paramRichStatus.mRequestHeight = paramInt;
      paramRichStatus = URLDrawable.getDrawable(str, paramRichStatus);
      paramRichStatus.setCallback(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
    }
    paramRichStatus.setBounds(0, 0, paramInt, paramInt);
    int i = Color.parseColor("#ffa8a8a8");
    if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {}
    for (paramRichStatus = new SignatureActionSpan(paramRichStatus, 1, paramOnTopicClickListener, i, localDrawable, paramInt);; paramRichStatus = new SignatureActionSpan(paramRichStatus, 0, paramOnTopicClickListener, i, localDrawable, paramInt))
    {
      ((SpannableStringBuilder)localObject2).setSpan(paramRichStatus, 0, "[S]".length(), 17);
      return localObject2;
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected boolean d()
  {
    return false;
  }
  
  protected void e()
  {
    int i = jdField_a_of_type_ArrayOfInt[6];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i, i, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.MySignViewHolder
 * JD-Core Version:    0.7.0.1
 */