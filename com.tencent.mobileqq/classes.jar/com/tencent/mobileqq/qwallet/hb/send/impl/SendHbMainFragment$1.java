package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qwallet.QwUtils;
import org.json.JSONObject;

class SendHbMainFragment$1
  implements View.OnClickListener
{
  SendHbMainFragment$1(SendHbMainFragment paramSendHbMainFragment, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    if (QwUtils.a()) {
      return;
    }
    paramView = this.a.optString("url");
    if (!TextUtils.isEmpty(paramView)) {
      this.b.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbMainFragment.1
 * JD-Core Version:    0.7.0.1
 */