package com.tencent.mobileqq.vip.diy;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import cooperation.vip.jsoninflate.model.ViewModel;
import java.util.HashMap;
import org.json.JSONObject;

public class ProfileTemplateAvatarViewModel
  extends ViewModel
{
  private HashMap<String, ViewModel> a;
  
  public ProfileTemplateAvatarViewModel(String paramString, View paramView, HashMap<String, ViewModel> paramHashMap)
  {
    super(paramString, paramView);
    this.a = paramHashMap;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    float f = UIUtils.c(this.h.getContext());
    paramLayoutParams.width = Math.max((int)(f * 108.0F / 360.0F), UIUtils.a(this.h.getContext(), 108.0F));
    paramLayoutParams.height = Math.max((int)(f * 126.0F / 360.0F), UIUtils.a(this.h.getContext(), 126.0F));
    return paramLayoutParams;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("border".equals(paramString1))
    {
      paramString1 = (ViewModel)this.a.get(paramString1);
      return;
    }
    super.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateAvatarViewModel
 * JD-Core Version:    0.7.0.1
 */