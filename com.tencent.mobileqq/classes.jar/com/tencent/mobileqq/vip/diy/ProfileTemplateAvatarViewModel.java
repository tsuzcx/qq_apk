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
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    int i = UIUtils.b(this.jdField_a_of_type_AndroidViewView.getContext());
    paramLayoutParams.width = Math.max((int)(i * 108.0F / 360.0F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 108.0F));
    paramLayoutParams.height = Math.max((int)(i * 126.0F / 360.0F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 126.0F));
    return paramLayoutParams;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ("border".equals(paramString1))
    {
      if ((ViewModel)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1) != null) {}
      return;
    }
    super.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateAvatarViewModel
 * JD-Core Version:    0.7.0.1
 */