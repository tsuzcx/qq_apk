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
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
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
    this.d = UIUtils.a(paramActivity, 3.0F);
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562169);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if ((paramView != null) && (paramTextView != null))
    {
      paramTextView.setTextColor(this.c);
      String str = b(paramJSONObject);
      if (TextUtils.isEmpty(str)) {
        break label141;
      }
      int i = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 300.0F);
      int j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
      int k = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
      int m = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F);
      paramView.setBackgroundDrawable(a(str, new Template2.TitleDrawableDecoderHandler(Math.min(j + k, i), m)));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramView = c(paramJSONObject);
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        paramImageView.setImageDrawable(a(paramView));
      }
      return;
      label141:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
      }
      paramView.setVisibility(8);
    }
    if (paramJSONObject != null) {
      QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
    }
    paramImageView.setVisibility(8);
  }
  
  public void a(JSONObject paramJSONObject, TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3)
  {
    if (paramTextView != null) {
      paramTextView.setTextColor(this.c);
    }
    int i;
    if ((paramView1 instanceof TextView))
    {
      ((TextView)paramView1).setTextColor(this.c);
      if (paramImageView != null)
      {
        i = a(25.0F);
        paramView1 = paramImageView.getLayoutParams();
        paramView1.width = i;
        paramView1.height = i;
        paramImageView.setLayoutParams(paramView1);
        paramView1 = c(paramJSONObject);
        if (TextUtils.isEmpty(paramView1)) {
          break label325;
        }
        paramImageView.setImageDrawable(a(paramView1));
      }
      label90:
      if ((paramTextView != null) && (paramView2 != null))
      {
        i = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 6.0F);
        int j = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
        int k = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
        paramView1 = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
        paramView1.bottomMargin = i;
        paramView1.leftMargin = j;
        paramView1.rightMargin = k;
        paramTextView.setLayoutParams(paramView1);
        paramTextView.setTextSize(1, 15.0F);
        paramView1 = b(paramJSONObject);
        if (TextUtils.isEmpty(paramView1)) {
          break label334;
        }
        i = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 300.0F);
        j = (int)paramTextView.getPaint().measureText(paramTextView.getText().toString());
        k = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 23.0F);
        int m = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F);
        paramView2.setBackgroundDrawable(a(paramView1, new Template2.TitleDrawableDecoderHandler(Math.min(j + k, i), m)));
        paramView2.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramView3 != null)
      {
        i = a(10.0F);
        paramView3.setPadding(i, i, i, i);
        a(paramJSONObject, paramView3);
      }
      return;
      if (!(paramView1 instanceof SingleLineTextView)) {
        break;
      }
      ((SingleLineTextView)paramView1).setTextColor(this.c);
      break;
      label325:
      paramImageView.setImageDrawable(null);
      break label90;
      label334:
      paramView2.setBackgroundDrawable(null);
      paramView2.setVisibility(8);
    }
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562178, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.Template2
 * JD-Core Version:    0.7.0.1
 */