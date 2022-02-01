package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileTemplateBase
{
  private static ArrayList<String> q = new ArrayList();
  protected ProfileTemplateBase.TemplateDecoderHandler a;
  protected String b;
  protected String c;
  protected String d;
  protected int e = -1;
  protected String f;
  protected String g;
  protected int h;
  protected LayoutInflater i;
  protected Activity j;
  protected JSONObject k;
  protected int l = -1;
  protected String m = "";
  protected int n = 0;
  protected ProfileCardInfo o;
  private Map<String, JSONObject> p = null;
  
  static
  {
    q.add("map_key_personal_sign");
    q.add("map_key_account_level");
    q.add("map_key_diamond");
    q.add("map_key_troop_mem_info");
    q.add("map_key_present");
  }
  
  public ProfileTemplateBase(Activity paramActivity, JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo)
  {
    this.j = paramActivity;
    this.k = paramJSONObject;
    this.o = paramProfileCardInfo;
    this.i = LayoutInflater.from(paramActivity);
    try
    {
      this.l = Color.parseColor(paramJSONObject.optString("c"));
    }
    catch (IllegalArgumentException paramActivity)
    {
      label69:
      break label69;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("DIYProfileTemplate.ProfileTemplateBase default main color is illegal! ");
    paramActivity.append(paramJSONObject.optString("c"));
    AssertUtils.fail(paramActivity.toString(), new Object[0]);
    this.l = -16777216;
    this.b = paramJSONObject.optString("sbg");
    this.c = paramJSONObject.optString("t_bg");
    this.d = paramJSONObject.optString("arr");
    this.f = paramJSONObject.optString("f");
    this.g = paramJSONObject.optString("cbg", "");
    this.h = paramJSONObject.optInt("cpd", 0);
    this.a = new ProfileTemplateBase.TemplateDecoderHandler();
    try
    {
      this.e = Color.parseColor(paramJSONObject.optString("line"));
    }
    catch (Exception paramActivity)
    {
      label202:
      break label202;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("DIYProfileTemplate.ProfileTemplateBase default line color is illegal! ");
    paramActivity.append(paramJSONObject.optString("c"));
    AssertUtils.fail(paramActivity.toString(), new Object[0]);
    this.e = -1;
    a();
  }
  
  private JSONObject a(Map<String, JSONObject> paramMap, String paramString)
  {
    if (paramMap != null) {
      paramMap = (JSONObject)paramMap.get(paramString);
    } else {
      paramMap = null;
    }
    if (paramMap == null)
    {
      paramMap = new StringBuilder();
      paramMap.append(":json illegal : it don't have ");
      paramMap.append(paramString);
      paramMap.append(" module");
      SLog.e("DIYProfileTemplate.ProfileTemplateBase", paramMap.toString());
    }
    try
    {
      paramMap = new JSONObject("{}");
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      label73:
      break label73;
    }
    paramMap = new StringBuilder();
    paramMap.append("DIYProfileTemplate.ProfileTemplateBase:json error : it can not generate default ");
    paramMap.append(paramString);
    paramMap.append(" module");
    AssertUtils.fail(paramMap.toString(), new Object[0]);
    return null;
    return paramMap;
  }
  
  private void a()
  {
    JSONArray localJSONArray = this.k.optJSONArray("module");
    int i1 = 0;
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      this.p = new HashMap();
      while (i1 < localJSONArray.length())
      {
        Object localObject = localJSONArray.optJSONObject(i1);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("module array[");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append("] is null");
          SLog.e("DIYProfileTemplate.ProfileTemplateBase", ((StringBuilder)localObject).toString());
        }
        else
        {
          String str = ((JSONObject)localObject).optString("type");
          this.p.put(str, localObject);
        }
        i1 += 1;
      }
      return;
    }
    AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
    this.p = null;
  }
  
  private void i(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.c(this.j) - UIUtils.a(this.j, 30.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public int a(float paramFloat)
  {
    return (int)(paramFloat * this.j.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("line");
    int i1 = this.e;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return i1;
    }
    try
    {
      int i2 = Color.parseColor((String)localObject);
      return i2;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DIYProfileTemplate.ProfileTemplateBase story line color is illegal module=");
    ((StringBuilder)localObject).append(paramJSONObject.optString("type"));
    ((StringBuilder)localObject).append(" value=");
    ((StringBuilder)localObject).append(paramJSONObject.optString("line"));
    AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
    return i1;
  }
  
  public <T extends View> T a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    paramQQAppInterface = new TemplatePhotoWall(this.j, paramQQAppInterface, paramProfileCardInfo.allInOne.uin);
    paramProfileCardInfo = (ProfileCardDiyPhotoWallView)paramQQAppInterface.findViewById(2131440217).findViewById(2131440217);
    paramProfileCardInfo.setMargin(UIUtils.a(this.j, 8.0F));
    paramProfileCardInfo.setBorderWidth(this.n);
    paramProfileCardInfo = a(this.j);
    paramProfileCardInfo.setTitle(HardCodeUtil.a(2131906275));
    paramProfileCardInfo.setVisibility(8);
    paramProfileCardInfo.addView(paramQQAppInterface);
    return paramProfileCardInfo;
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    QZoneLayoutTemplateBase localQZoneLayoutTemplateBase = (QZoneLayoutTemplateBase)paramView.findViewById(2131435738);
    localQZoneLayoutTemplateBase.setBorderColor(a(paramJSONObject));
    localQZoneLayoutTemplateBase.setBorderWidth(c(paramJSONObject));
    localQZoneLayoutTemplateBase.setItemBg(a(paramJSONObject, a(70.0F), a(70.0F)));
    a(paramJSONObject, paramView.findViewById(2131435219), (TextView)paramView.findViewById(2131447238), (ImageView)paramView.findViewById(2131435403));
    return paramView;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    paramString = c(paramString);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      localURLDrawableOptions.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  protected URLDrawable a(JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramJSONObject == null) {
      paramJSONObject = this.g;
    } else {
      paramJSONObject = paramJSONObject.optString("cbg", this.g);
    }
    if (TextUtils.isEmpty(paramJSONObject)) {
      return null;
    }
    return a(paramJSONObject, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1, paramInt2));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131628431);
  }
  
  public void a(View paramView)
  {
    Map localMap = this.p;
    if (localMap == null) {
      return;
    }
    a(a(localMap, "qz"), paramView);
  }
  
  public void a(String paramString)
  {
    this.m = paramString;
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (("map_key_phone".equals(paramString)) || ("map_key_personal_sign".equals(paramString)) || ("map_key_mine_weishi".equals(paramString)) || ("map_key_favor".equals(paramString)) || ("map_key_account_info_vas".equals(paramString)))
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.l);
      }
      if ((paramView instanceof TextView))
      {
        ((TextView)paramView).setTextColor(this.l);
        return;
      }
      if ((paramView instanceof SingleLineTextView))
      {
        ((SingleLineTextView)paramView).setTextColor(this.l);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setColorFilter(this.l);
      }
    }
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.i.inflate(2131628439, null));
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, int paramInt1, int paramInt2)
  {
    String str;
    if (paramJSONObject == null) {
      str = this.b;
    } else {
      str = paramJSONObject.optString("bg", this.b);
    }
    if (paramJSONObject == null) {
      paramJSONObject = "null module";
    } else {
      paramJSONObject = paramJSONObject.optString("type");
    }
    if (TextUtils.isEmpty(str))
    {
      paramView = new StringBuilder();
      paramView.append("setModuleBackground ");
      paramView.append(paramJSONObject);
      paramView.append(" ,but it is null.");
      SLog.d("DIYProfileTemplate.ProfileTemplateBase", paramView.toString());
      return;
    }
    if (paramView == null)
    {
      paramView = new StringBuilder();
      paramView.append("setModuleBackground cant find ");
      paramView.append(paramJSONObject);
      paramView.append(" view");
      AssertUtils.fail(paramView.toString(), new Object[0]);
      return;
    }
    try
    {
      localObject = a(str, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1, paramInt2));
      paramView.setBackgroundDrawable((Drawable)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new ProfileTemplateBase.BackGroundUpdateListener(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setModuleBackground ");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" url illegal:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" \ne:");
      ((StringBuilder)localObject).append(paramView);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
    }
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if (paramView != null)
    {
      Object localObject = d(paramJSONObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView.setBackgroundDrawable(b((String)localObject));
      }
      else
      {
        if (paramJSONObject != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramJSONObject.optString("type"));
          ((StringBuilder)localObject).append(" bind title icon is null!");
          QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, ((StringBuilder)localObject).toString());
        }
        paramView.setVisibility(8);
      }
    }
    if (paramImageView != null)
    {
      paramView = e(paramJSONObject);
      if (!TextUtils.isEmpty(paramView))
      {
        try
        {
          paramImageView.setImageDrawable(b(paramView));
        }
        catch (IllegalArgumentException paramJSONObject)
        {
          paramImageView.setImageResource(2130839446);
          if (!QLog.isColorLevel()) {
            break label212;
          }
        }
        paramView = new StringBuilder();
        paramView.append("get arrow drawable failed ");
        paramView.append(paramJSONObject);
        QLog.d("DIYProfileTemplate.ProfileTemplateBase", 2, paramView.toString());
      }
      else
      {
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
    label212:
    if (paramTextView != null) {
      paramTextView.setTextColor(this.l);
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
    int i1;
    if (paramImageView != null)
    {
      i1 = a(18.0F);
      paramTextView = paramImageView.getLayoutParams();
      paramTextView.width = i1;
      paramTextView.height = i1;
      paramImageView.setLayoutParams(paramTextView);
      paramTextView = e(paramJSONObject);
      if (!TextUtils.isEmpty(paramTextView)) {
        paramImageView.setImageDrawable(b(paramTextView));
      } else {
        paramImageView.setImageDrawable(null);
      }
    }
    if (paramView2 != null)
    {
      paramTextView = d(paramJSONObject);
      if (!TextUtils.isEmpty(paramTextView))
      {
        paramView2.setBackgroundDrawable(b(paramTextView));
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
      i1 = a(10.0F);
      paramView3.setPadding(i1, i1, i1, i1);
      c(paramJSONObject, paramView3);
    }
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, View paramView)
  {
    paramJSONObject = paramJSONObject.optString(paramString);
    if (TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("setBaseInfoIcon ");
      paramJSONObject.append(paramString);
      paramJSONObject.append(" icon,but it is null.");
      SLog.d("DIYProfileTemplate.ProfileTemplateBase", paramJSONObject.toString());
      return;
    }
    if (paramView == null)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("setBaseInfoIcon cant find ");
      paramJSONObject.append(paramString);
      paramJSONObject.append(" view");
      SLog.e("DIYProfileTemplate.ProfileTemplateBase", paramJSONObject.toString());
      return;
    }
    try
    {
      localObject = b(paramJSONObject);
      paramView.setBackgroundDrawable((Drawable)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new ProfileTemplateBase.BackGroundUpdateListener(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBaseInfoIcon ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" url illegal:");
      ((StringBuilder)localObject).append(paramJSONObject);
      ((StringBuilder)localObject).append(" \ne:");
      ((StringBuilder)localObject).append(paramView);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
    }
  }
  
  public View b(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {
      return paramView;
    }
    Object localObject = (ProfileCardFavorShowView)paramView;
    PhotoWallView localPhotoWallView = (PhotoWallView)((ProfileCardFavorShowView)localObject).getViewInContainer(0);
    ProfileCardDiyPhotoWallView localProfileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView)localPhotoWallView.findViewById(2131440217).findViewById(2131440217);
    localProfileCardDiyPhotoWallView.setItemViewBorderColor(a(paramJSONObject));
    localProfileCardDiyPhotoWallView.setBorderImgUrl(b(paramJSONObject));
    localProfileCardDiyPhotoWallView.setBorderWidth(c(paramJSONObject));
    a(paramJSONObject, ((ProfileCardFavorShowView)localObject).findViewById(2131435219), (TextView)((ProfileCardFavorShowView)localObject).findViewById(2131447238), (ImageView)((ProfileCardFavorShowView)localObject).findViewById(2131435403));
    localObject = localPhotoWallView.findViewById(2131440209);
    if (((View)localObject).getVisibility() == 0)
    {
      ((View)localObject).setPadding(a(10.0F), a(15.0F), a(10.0F), a(10.0F));
      i(localPhotoWallView);
      a(paramJSONObject, (View)localObject, localPhotoWallView.getMeasuredWidth(), localPhotoWallView.getMeasuredHeight());
    }
    return paramView;
  }
  
  protected URLDrawable b(String paramString)
  {
    return a(paramString, null);
  }
  
  protected String b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return this.g;
    }
    return paramJSONObject.optString("cbg", this.g);
  }
  
  public void b(View paramView)
  {
    Map localMap = this.p;
    if (localMap != null)
    {
      if (paramView == null) {
        return;
      }
      b(a(localMap, "photo"), paramView);
    }
  }
  
  protected int c(JSONObject paramJSONObject)
  {
    int i1;
    if (paramJSONObject == null) {
      i1 = this.h;
    } else {
      i1 = paramJSONObject.optInt("cpd", this.h);
    }
    if (i1 == 0) {
      return this.n;
    }
    return a(i1 / 2);
  }
  
  protected String c(@NonNull String paramString)
  {
    if (paramString.startsWith("http")) {
      return paramString;
    }
    if (!TextUtils.isEmpty(this.m))
    {
      if (this.m.startsWith("http"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.m);
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("it have the illegal url prefix=");
      localStringBuilder.append(this.m);
      QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, localStringBuilder.toString());
    }
    return paramString;
  }
  
  public void c(View paramView)
  {
    JSONObject localJSONObject = a(this.p, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      paramView.setPadding(a(10.0F), a(12.0F), a(10.0F), a(12.0F));
      c(localJSONObject, paramView);
      if (this.o.isTroopMemberCard)
      {
        paramView = paramView.findViewById(2131427431);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  protected void c(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return;
    }
    i(paramView);
    a(paramJSONObject, paramView, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected String d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = this.c;
    } else {
      paramJSONObject = paramJSONObject.optString("t_bg");
    }
    Object localObject = paramJSONObject;
    if (TextUtils.isEmpty(paramJSONObject)) {
      localObject = this.c;
    }
    return localObject;
  }
  
  public void d(View paramView)
  {
    Object localObject = a(this.p, "info");
    if (localObject != null)
    {
      if (paramView == null) {
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131427428);
      if (localViewGroup.getChildAt(0) != null) {
        a((JSONObject)localObject, "qq", localViewGroup.getChildAt(0).findViewById(2131435219));
      }
      if (localViewGroup.getChildAt(1) != null) {
        a((JSONObject)localObject, "p", localViewGroup.getChildAt(1).findViewById(2131435219));
      }
      localObject = (TextView)paramView.findViewById(2131427432);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.l);
      }
      paramView = (ImageView)paramView.findViewById(2131428774);
      if (paramView != null) {
        paramView.setColorFilter(this.l);
      }
    }
  }
  
  protected String e(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = this.d;
    } else {
      paramJSONObject = paramJSONObject.optString("arr");
    }
    Object localObject = paramJSONObject;
    if (TextUtils.isEmpty(paramJSONObject)) {
      localObject = this.d;
    }
    return localObject;
  }
  
  public void e(View paramView)
  {
    JSONObject localJSONObject = a(this.p, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "sign", paramView.findViewById(2131435219));
    }
  }
  
  public void f(View paramView)
  {
    JSONObject localJSONObject = a(this.p, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "lv", paramView.findViewById(2131435219));
      if (this.o.isTroopMemberCard) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void g(View paramView)
  {
    JSONObject localJSONObject = a(this.p, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "metal", paramView.findViewById(2131435219));
      if (this.o.isTroopMemberCard) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void h(View paramView)
  {
    if (!this.o.isTroopMemberCard) {
      return;
    }
    if ((paramView != null) && (paramView.getParent() == null))
    {
      int i1 = 0;
      for (;;)
      {
        Object localObject = (ViewGroup)paramView;
        if (i1 >= ((ViewGroup)localObject).getChildCount()) {
          break;
        }
        localObject = ((ViewGroup)localObject).getChildAt(i1);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131436051);
        if (localTextView != null) {
          localTextView.setTextColor(this.l);
        }
        localObject = (ImageView)((View)localObject).findViewById(2131435219);
        if (localObject != null)
        {
          ((ImageView)localObject).clearColorFilter();
          ((ImageView)localObject).setColorFilter(this.l);
        }
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
 * JD-Core Version:    0.7.0.1
 */