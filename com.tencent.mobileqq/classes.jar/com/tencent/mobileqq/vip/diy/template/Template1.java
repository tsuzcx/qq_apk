package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class Template1
  extends ProfileTemplateBase
{
  public Template1(Activity paramActivity, JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramActivity, paramJSONObject, paramProfileCardInfo);
    this.n = UIUtils.a(paramActivity, 4.0F);
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    Object localObject = (QZoneLayoutTemplate1)paramView.findViewById(2131435738);
    if (localObject != null)
    {
      ((QZoneLayoutTemplate1)localObject).setBorderWidth(c(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setItemBg(a(paramJSONObject, a(100.0F), a(100.0F)), a(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setLeftView(paramJSONObject.optString("ph"));
      ((QZoneLayoutTemplate1)localObject).setRightView(paramJSONObject.optString("ph"));
    }
    localObject = paramView.findViewById(2131435219);
    TextView localTextView = (TextView)paramView.findViewById(2131447238);
    ImageView localImageView = (ImageView)paramView.findViewById(2131435403);
    String str = localTextView.getText().toString();
    if ((this.o.allInOne.pa != 0) && (str.length() > 4) && (str.substring(str.length() - 4, str.length()).equals("QQ空间")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str.substring(0, str.length() - 4));
      localStringBuilder.append(HardCodeUtil.a(2131912129));
      localTextView.setText(localStringBuilder.toString());
    }
    a(paramJSONObject, (View)localObject, localTextView, localImageView);
    return paramView;
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131628431);
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.i.inflate(2131628440, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.Template1
 * JD-Core Version:    0.7.0.1
 */