package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import java.util.HashMap;
import org.json.JSONObject;

public class Template1
  extends ProfileTemplateBase
{
  public Template1(Activity paramActivity, JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramActivity, paramJSONObject, paramProfileCardInfo);
    this.d = UIUtils.a(paramActivity, 4.0F);
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    Object localObject = (QZoneLayoutTemplate1)paramView.findViewById(2131369096);
    if (localObject != null)
    {
      ((QZoneLayoutTemplate1)localObject).setBorderWidth(b(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setItemBg(a(paramJSONObject, a(100.0F), a(100.0F)), a(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setLeftView(paramJSONObject.optString("ph"));
      ((QZoneLayoutTemplate1)localObject).setRightView(paramJSONObject.optString("ph"));
    }
    localObject = paramView.findViewById(2131368603);
    TextView localTextView = (TextView)paramView.findViewById(2131379248);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368771);
    String str = localTextView.getText().toString();
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a != 0) && (str.length() > 4) && (str.substring(str.length() - 4, str.length()).equals("QQ空间"))) {
      localTextView.setText(str.substring(0, str.length() - 4) + HardCodeUtil.a(2131714691));
    }
    a(paramJSONObject, (View)localObject, localTextView, localImageView);
    return paramView;
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562168);
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562177, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.Template1
 * JD-Core Version:    0.7.0.1
 */