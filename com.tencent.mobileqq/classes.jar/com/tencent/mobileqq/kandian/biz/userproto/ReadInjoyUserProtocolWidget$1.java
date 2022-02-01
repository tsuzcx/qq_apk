package com.tencent.mobileqq.kandian.biz.userproto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import mqq.app.AppRuntime;

class ReadInjoyUserProtocolWidget$1
  extends ClickableSpan
{
  ReadInjoyUserProtocolWidget$1(ReadInjoyUserProtocolWidget paramReadInjoyUserProtocolWidget, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.getContext(), QQBrowserActivity.class);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.b.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_readinjoy_user_protocol_92_jump_url_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "https://kandian.qq.com/mqq/watchspot/extrapage.html ");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramView.putExtra("url", URLUtil.guessUrl((String)localObject));
      this.b.getContext().startActivity(paramView);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.a);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.userproto.ReadInjoyUserProtocolWidget.1
 * JD-Core Version:    0.7.0.1
 */