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
  private int a = -1;
  private int b = -1;
  private String c = "";
  private String d = "";
  
  public ProfileTemplateNickNameViewModule(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.d = paramString2;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    paramLayoutParams.width = -1;
    paramLayoutParams.height = -2;
    Object localObject = (ViewGroup.MarginLayoutParams)paramLayoutParams;
    int i = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
    if ((this.h instanceof ProfileTemplateNickNameContainer))
    {
      localObject = (ProfileTemplateNickNameContainer)this.h;
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
        this.a = Integer.parseInt(paramString2);
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("parse name font id=");
        paramString1.append(this.a);
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
        this.b = Integer.parseInt(paramString2);
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString1 = new StringBuilder();
        paramString1.append("parse name font type=");
        paramString1.append(this.b);
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
        this.c = paramString2;
        return;
      }
      super.a(paramString1, paramString2);
    }
  }
  
  protected void b()
  {
    super.b();
    if ((this.h instanceof ProfileTemplateNickNameContainer))
    {
      Object localObject = ((ProfileTemplateNickNameContainer)this.h).getTextView();
      if ((this.a > 0) && (this.b > 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("set name font id=");
          localStringBuilder.append(this.a);
          localStringBuilder.append(" type=");
          localStringBuilder.append(this.b);
          QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, localStringBuilder.toString());
        }
        ((ETTextViewPlus)localObject).setFontAsync(this.a, this.b);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("profile nick name set font error because font id=");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" type=");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" is illegal!");
        SLog.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", ((StringBuilder)localObject).toString());
      }
      ((ProfileTemplateNickNameContainer)this.h).setTextBgUrl(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameViewModule
 * JD-Core Version:    0.7.0.1
 */