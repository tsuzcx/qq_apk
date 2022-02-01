package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class WebProteusViewCreator$ProteusItemViewHolder$2$1
  implements View.OnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$2$1(WebProteusViewCreator.ProteusItemViewHolder.2 param2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(this.a.a.c.getString("id_attribute_text"));
      return;
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAsDropDown error,msg:");
      localStringBuilder.append(paramView.toString());
      QLog.d("WebProteusViewCreator", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.2.1
 * JD-Core Version:    0.7.0.1
 */