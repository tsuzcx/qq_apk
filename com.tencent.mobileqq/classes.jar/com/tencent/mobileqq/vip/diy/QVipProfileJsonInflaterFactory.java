package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.vip.diy.common.DIYImageView;
import com.tencent.mobileqq.vip.diy.common.DIYImageViewModule;
import com.tencent.mobileqq.widget.ProfileNameView;
import cooperation.vip.jsoninflate.model.ViewModel;
import cooperation.vip.jsoninflate.util.JsonInflaterFactory;
import java.util.HashMap;
import org.json.JSONObject;

public class QVipProfileJsonInflaterFactory
  extends JsonInflaterFactory
{
  private View jdField_a_of_type_AndroidViewView;
  private TemplateLikeView jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView;
  private ProfileNameView jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView;
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ViewModel> b;
  
  public QVipProfileJsonInflaterFactory(HashMap<String, View> paramHashMap, String paramString)
  {
    if (paramHashMap == null) {
      throw new RuntimeException("create the QVipProfileJsonInflaterFactory with null profileHeaderViewsMap");
    }
    this.b = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public View a(Context paramContext, String paramString)
  {
    if ("pf_name".equals(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了昵称控件");
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView = new ProfileNameView(paramContext);
      paramContext = new ProfileTemplateNickNameContainer(paramContext, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_ComTencentMobileqqWidgetProfileNameView);
      return paramContext;
    }
    if ("pf_avatar".equals(paramString))
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了头像控件");
      paramContext = LayoutInflater.from(paramContext).inflate(2131562174, null);
      this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131375247);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_diy_nick_container", this.jdField_a_of_type_AndroidViewView);
      return paramContext;
    }
    if ("pf_like".equals(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了点赞控件");
      this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView = new TemplateLikeView(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView.a(0);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView);
      return this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateLikeView;
    }
    if ("image_view".equals(paramString)) {
      return new DIYImageView(paramContext);
    }
    return super.a(paramContext, paramString);
  }
  
  public ViewModel a(String paramString, View paramView)
  {
    if ("pf_name".equals(paramString)) {
      return new ProfileTemplateNickNameViewModule(paramString, paramView, this.jdField_a_of_type_JavaLangString);
    }
    if ("pf_avatar".equals(paramString)) {
      return new ProfileTemplateAvatarViewModel(paramString, paramView, this.b);
    }
    if ("pf_like".equals(paramString)) {
      return new ProfileTemplateLikeViewModule(paramString, paramView, this.jdField_a_of_type_JavaLangString);
    }
    if ("image_view".equals(paramString)) {
      return new DIYImageViewModule(paramString, paramView, this.jdField_a_of_type_JavaLangString);
    }
    return super.a(paramString, paramView);
  }
  
  public void a(ViewModel paramViewModel, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("id");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramViewModel != null)) {
      this.b.put(localObject, paramViewModel);
    }
    if ("pf_avatar".equals(paramJSONObject.optString("type")))
    {
      localObject = paramJSONObject.optString("border", "");
      localObject = (ViewModel)this.b.get(localObject);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_diy_avatar_sticker", ((ViewModel)localObject).a());
      }
    }
    super.a(paramViewModel, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.QVipProfileJsonInflaterFactory
 * JD-Core Version:    0.7.0.1
 */