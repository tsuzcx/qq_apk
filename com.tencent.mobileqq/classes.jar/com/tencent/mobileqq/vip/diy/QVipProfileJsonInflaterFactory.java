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
  private HashMap<String, View> a;
  private HashMap<String, ViewModel> b;
  private ProfileNameView c;
  private View d;
  private TemplateLikeView e;
  private String f = "";
  
  public QVipProfileJsonInflaterFactory(HashMap<String, View> paramHashMap, String paramString)
  {
    if (paramHashMap != null)
    {
      this.b = new HashMap();
      this.a = paramHashMap;
      this.f = paramString;
      return;
    }
    throw new RuntimeException("create the QVipProfileJsonInflaterFactory with null profileHeaderViewsMap");
  }
  
  public View a(Context paramContext, String paramString)
  {
    if ("pf_name".equals(paramString))
    {
      if (this.c == null)
      {
        SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了昵称控件");
        this.c = new ProfileNameView(paramContext);
        paramContext = new ProfileTemplateNickNameContainer(paramContext, this.c);
        this.a.put("map_key_profile_nick_name", this.c);
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("It have duplicate ");
      paramContext.append(paramString);
      throw new RuntimeException(paramContext.toString());
    }
    if ("pf_avatar".equals(paramString))
    {
      if (this.d == null)
      {
        SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了头像控件");
        paramContext = LayoutInflater.from(paramContext).inflate(2131628437, null);
        this.d = paramContext.findViewById(2131442951);
        this.a.put("map_key_profile_diy_nick_container", this.d);
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("It have duplicate ");
      paramContext.append(paramString);
      throw new RuntimeException(paramContext.toString());
    }
    if ("pf_like".equals(paramString))
    {
      if (this.e == null)
      {
        SLog.b("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了点赞控件");
        this.e = new TemplateLikeView(paramContext);
        this.e.a(0);
        this.a.put("map_key_like", this.e);
        return this.e;
      }
      paramContext = new StringBuilder();
      paramContext.append("It have duplicate ");
      paramContext.append(paramString);
      throw new RuntimeException(paramContext.toString());
    }
    if ("image_view".equals(paramString)) {
      return new DIYImageView(paramContext);
    }
    return super.a(paramContext, paramString);
  }
  
  public ViewModel a(String paramString, View paramView)
  {
    if ("pf_name".equals(paramString)) {
      return new ProfileTemplateNickNameViewModule(paramString, paramView, this.f);
    }
    if ("pf_avatar".equals(paramString)) {
      return new ProfileTemplateAvatarViewModel(paramString, paramView, this.b);
    }
    if ("pf_like".equals(paramString)) {
      return new ProfileTemplateLikeViewModule(paramString, paramView, this.f);
    }
    if ("image_view".equals(paramString)) {
      return new DIYImageViewModule(paramString, paramView, this.f);
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
        this.a.put("map_key_profile_diy_avatar_sticker", ((ViewModel)localObject).l());
      }
    }
    super.a(paramViewModel, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.QVipProfileJsonInflaterFactory
 * JD-Core Version:    0.7.0.1
 */