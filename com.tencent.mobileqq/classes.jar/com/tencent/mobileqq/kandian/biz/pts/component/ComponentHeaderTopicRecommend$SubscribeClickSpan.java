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
  private int jdField_a_of_type_Int = -1;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  protected String a;
  boolean jdField_a_of_type_Boolean;
  
  public ComponentHeaderTopicRecommend$SubscribeClickSpan(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (localTextPaint != null) {
      updateDrawState(localTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.k);
    paramView.append(Base64Util.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 0));
    paramView = paramView.toString();
    if ((!TextUtils.isEmpty(paramView)) && (ViolaAccessHelper.c(paramView)))
    {
      ViolaAccessHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend.getContext(), null, ViolaAccessHelper.c(paramView), null);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend.getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
    localIntent.putExtra("url", paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend.getContext().startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_a_of_type_Int;
    } else {
      i = -1;
    }
    paramTextPaint.bgColor = i;
    this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend.SubscribeClickSpan
 * JD-Core Version:    0.7.0.1
 */