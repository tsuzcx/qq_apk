package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;

final class ReadInJoyCommentUtils$11
  extends URLSpan
{
  ReadInJoyCommentUtils$11(String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = getURL();
    localObject = new ActivityURIRequest((Context)localObject, "/base/browser");
    ((ActivityURIRequest)localObject).extra().putString("url", paramView);
    QRoute.startUri((URIRequest)localObject, null);
    ReadInJoyCommentUtils.a(3);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4c9afa"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.11
 * JD-Core Version:    0.7.0.1
 */