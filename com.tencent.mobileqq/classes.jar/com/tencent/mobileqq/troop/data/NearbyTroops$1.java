package com.tencent.mobileqq.troop.data;

import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.text.QQText;

final class NearbyTroops$1
  implements TextUtils.EllipsizeCallback
{
  NearbyTroops$1(NearbyTroops.CustomViewHolder paramCustomViewHolder, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.a.e.setText(this.b);
      return;
    }
    String str = this.b.substring(0, paramInt1);
    TextView localTextView = this.a.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("...");
    localTextView.setText(new QQText(HttpUtil.unEscape(HttpUtil.removeHtmlTags(localStringBuilder.toString())), 3, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.NearbyTroops.1
 * JD-Core Version:    0.7.0.1
 */