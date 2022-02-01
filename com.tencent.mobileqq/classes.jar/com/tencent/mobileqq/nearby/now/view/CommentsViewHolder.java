package com.tencent.mobileqq.nearby.now.view;

import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.utils.ICommentsUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class CommentsViewHolder
{
  public ImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  public ImageView e;
  public ImageView f;
  public ImageView g;
  
  public void a(long paramLong)
  {
    this.d.setText(((ICommentsUtil)QRoute.api(ICommentsUtil.class)).simpleFormatTime(paramLong * 1000L));
  }
  
  public void a(MedalInfo paramMedalInfo, int paramInt, Paint paramPaint, boolean paramBoolean)
  {
    paramInt = (int)(paramInt - (int)paramPaint.measureText(this.d.getText().toString()) - ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(this.d.getContext(), 30.0F));
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    if ((paramMedalInfo != null) && (paramMedalInfo.d != null) && (paramMedalInfo.d.size() >= 0))
    {
      this.b.setMaxWidth(paramInt);
      return;
    }
    this.b.setMaxWidth(paramInt);
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append("回复");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), 0, localSpannableStringBuilder.length(), 17);
      int i = localSpannableStringBuilder.length();
      Object localObject = paramString1;
      if (paramString1.length() > 6)
      {
        paramString1 = paramString1.substring(0, 6);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.append(": ");
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), i, ((String)localObject).length() + i, 17);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), i + ((String)localObject).length(), localSpannableStringBuilder.length(), 17);
      this.c.setText(localSpannableStringBuilder);
      return;
    }
    a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsViewHolder
 * JD-Core Version:    0.7.0.1
 */