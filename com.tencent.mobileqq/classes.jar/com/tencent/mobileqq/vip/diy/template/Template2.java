package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import org.json.JSONObject;

public class Template2
  extends ProfileTemplateBase
{
  public Template2(Activity paramActivity, JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramActivity, paramJSONObject, paramProfileCardInfo);
    this.n = UIUtils.a(paramActivity, 3.0F);
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131628432);
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.i.inflate(2131628441, null));
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if ((paramView != null) && (paramTextView != null))
    {
      paramTextView.setTextColor(this.l);
      String str = d(paramJSONObject);
      if (!TextUtils.isEmpty(str))
      {
        int i = UIUtils.a(this.j, 300.0F);
        int j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
        int k = UIUtils.a(this.j, 23.0F);
        int m = UIUtils.a(this.j, 40.0F);
        paramView.setBackgroundDrawable(a(str, new Template2.TitleDrawableDecoderHandler(Math.min(j + k, i), m)));
      }
      else
      {
        if (paramJSONObject != null)
        {
          paramTextView = new StringBuilder();
          paramTextView.append(paramJSONObject.optString("type"));
          paramTextView.append(" bind title icon is null!");
          QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramTextView.toString());
        }
        paramView.setVisibility(8);
      }
    }
    if (paramImageView != null)
    {
      paramView = e(paramJSONObject);
      if (!TextUtils.isEmpty(paramView))
      {
        paramImageView.setImageDrawable(b(paramView));
        return;
      }
      if (paramJSONObject != null)
      {
        paramView = new StringBuilder();
        paramView.append(paramJSONObject.optString("type"));
        paramView.append(" bind arrow icon is null!");
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramView.toString());
      }
      paramImageView.setVisibility(8);
    }
  }
  
  public void a(JSONObject paramJSONObject, TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3)
  {
    if (paramTextView != null) {
      paramTextView.setTextColor(this.l);
    }
    if ((paramView1 instanceof TextView)) {
      ((TextView)paramView1).setTextColor(this.l);
    } else if ((paramView1 instanceof SingleLineTextView)) {
      ((SingleLineTextView)paramView1).setTextColor(this.l);
    }
    int i;
    if (paramImageView != null)
    {
      i = a(25.0F);
      paramView1 = paramImageView.getLayoutParams();
      paramView1.width = i;
      paramView1.height = i;
      paramImageView.setLayoutParams(paramView1);
      paramView1 = e(paramJSONObject);
      if (!TextUtils.isEmpty(paramView1)) {
        paramImageView.setImageDrawable(b(paramView1));
      } else {
        paramImageView.setImageDrawable(null);
      }
    }
    if ((paramTextView != null) && (paramView2 != null))
    {
      i = UIUtils.a(this.j, 6.0F);
      int j = UIUtils.a(this.j, 12.0F);
      int k = UIUtils.a(this.j, 12.0F);
      paramView1 = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
      paramView1.bottomMargin = i;
      paramView1.leftMargin = j;
      paramView1.rightMargin = k;
      paramTextView.setLayoutParams(paramView1);
      paramTextView.setTextSize(1, 15.0F);
      paramView1 = d(paramJSONObject);
      if (!TextUtils.isEmpty(paramView1))
      {
        i = UIUtils.a(this.j, 300.0F);
        j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
        k = UIUtils.a(this.j, 23.0F);
        int m = UIUtils.a(this.j, 40.0F);
        paramView2.setBackgroundDrawable(a(paramView1, new Template2.TitleDrawableDecoderHandler(Math.min(j + k, i), m)));
        paramView2.setVisibility(0);
      }
      else
      {
        paramView2.setBackgroundDrawable(null);
        paramView2.setVisibility(8);
      }
    }
    if (paramView3 != null)
    {
      i = a(10.0F);
      paramView3.setPadding(i, i, i, i);
      c(paramJSONObject, paramView3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.Template2
 * JD-Core Version:    0.7.0.1
 */