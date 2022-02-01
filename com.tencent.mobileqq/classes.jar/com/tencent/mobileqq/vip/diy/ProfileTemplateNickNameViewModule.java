package com.tencent.mobileqq.vip.diy;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.jsoninflate.model.ViewModel;
import org.json.JSONObject;

public class ProfileTemplateNickNameViewModule
  extends ViewModel
{
  private String a;
  private String b = "";
  private int c = -1;
  private int d = -1;
  
  public ProfileTemplateNickNameViewModule(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.jdField_a_of_type_JavaLangString = "";
    this.b = paramString2;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    paramLayoutParams.width = -1;
    paramLayoutParams.height = -2;
    Object localObject = (ViewGroup.MarginLayoutParams)paramLayoutParams;
    int i = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
    if ((this.jdField_a_of_type_AndroidViewView instanceof ProfileTemplateNickNameContainer))
    {
      localObject = (ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView;
      ((ProfileTemplateNickNameContainer)localObject).setTextViewX(i);
      if ("center_horizontal".equals(paramJSONObject.optString("gravity"))) {
        ((ProfileTemplateNickNameContainer)localObject).setTextCenter();
      }
    }
    return paramLayoutParams;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ("f".equals(paramString1))
    {
      try
      {
        this.c = Integer.parseInt(paramString2);
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("parse name font id=");
        paramString1.append(this.c);
        QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, paramString1.toString());
        return;
      }
      catch (NumberFormatException paramString1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pf_name font id illegal :");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" error=");
        localStringBuilder.append(paramString1);
        SLog.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", localStringBuilder.toString());
        return;
      }
    }
    else if ("ft".equals(paramString1))
    {
      try
      {
        this.d = Integer.parseInt(paramString2);
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("parse name font type=");
        paramString1.append(this.d);
        QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, paramString1.toString());
        return;
      }
      catch (NumberFormatException paramString1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pf_name font type illegal :");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" error=");
        localStringBuilder.append(paramString1);
        SLog.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", localStringBuilder.toString());
        return;
      }
    }
    else
    {
      if ("bg".equals(paramString1))
      {
        this.jdField_a_of_type_JavaLangString = paramString2;
        return;
      }
      super.a(paramString1, paramString2);
    }
  }
  
  protected void b()
  {
    super.b();
    if ((this.jdField_a_of_type_AndroidViewView instanceof ProfileTemplateNickNameContainer))
    {
      Object localObject = ((ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView).a();
      if ((this.c > 0) && (this.d > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("set name font id=");
          localStringBuilder.append(this.c);
          localStringBuilder.append(" type=");
          localStringBuilder.append(this.d);
          QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, localStringBuilder.toString());
        }
        ((ETTextViewPlus)localObject).setFontAsync(this.c, this.d);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("profile nick name set font error because font id=");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" type=");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" is illegal!");
        SLog.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", ((StringBuilder)localObject).toString());
      }
      ((ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView).setTextBgUrl(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameViewModule
 * JD-Core Version:    0.7.0.1
 */