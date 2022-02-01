package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.moment.data.TextMomentFeedInfo;
import com.tencent.mobileqq.utils.TopicHelper;

public class TextMomentItemBuilder
  extends BaseMomentItemBuilder
{
  public TextMomentItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public View a(ViewGroup paramViewGroup, BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramViewGroup = (TextMomentItemBuilder.TextViewHolder)paramMomentViewHolder;
    paramMomentViewHolder = new TextView(this.a);
    paramMomentViewHolder.setTextColor(this.a.getResources().getColor(2131165564));
    paramMomentViewHolder.setTextSize(1, 16.0F);
    paramMomentViewHolder.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.t = paramMomentViewHolder;
    return paramMomentViewHolder;
  }
  
  public BaseMomentItemBuilder.MomentViewHolder a()
  {
    return new TextMomentItemBuilder.TextViewHolder(this);
  }
  
  public void f(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    paramMomentViewHolder = (TextMomentItemBuilder.TextViewHolder)paramMomentViewHolder;
    Object localObject = (TextMomentFeedInfo)paramMomentViewHolder.a;
    String str = ((TextMomentFeedInfo)localObject).s;
    localObject = TopicHelper.a(this.a, ((TextMomentFeedInfo)localObject).y, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMomentViewHolder.t.setVisibility(8);
      return;
    }
    paramMomentViewHolder.t.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramMomentViewHolder.t.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramMomentViewHolder.t.setText((CharSequence)localObject);
  }
  
  public int g(BaseMomentItemBuilder.MomentViewHolder paramMomentViewHolder)
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.TextMomentItemBuilder
 * JD-Core Version:    0.7.0.1
 */