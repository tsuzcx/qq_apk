package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;

public class ComponentHeaderTopicRecommend$SubscribeClickSpan
  extends ClickableSpan
  implements ClickableSpanPressed
{
  protected String a;
  boolean b;
  private int d = -1;
  private TextPaint e;
  
  public ComponentHeaderTopicRecommend$SubscribeClickSpan(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend, String paramString, int paramInt)
  {
    this.a = paramString;
    this.d = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    TextPaint localTextPaint = this.e;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.l);
    paramView.append(Base64Util.encodeToString(this.a.getBytes(), 0));
    paramView = paramView.toString();
    if ((!TextUtils.isEmpty(paramView)) && (ViolaAccessHelper.e(paramView)))
    {
      ViolaAccessHelper.a(this.c.getContext(), null, ViolaAccessHelper.f(paramView), null);
      return;
    }
    Intent localIntent = new Intent(this.c.getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    localIntent.putExtra("url", paramView);
    this.c.getContext().startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.e = paramTextPaint;
    this.e.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.e;
    int i;
    if (this.b) {
      i = this.d;
    } else {
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.e.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.SubscribeClickSpan
 * JD-Core Version:    0.7.0.1
 */