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
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected int a;
  protected Activity a;
  protected LayoutInflater a;
  protected ProfileCardInfo a;
  protected ProfileTemplateBase.TemplateDecoderHandler a;
  protected String a;
  private Map<String, JSONObject> jdField_a_of_type_JavaUtilMap = null;
  protected JSONObject a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  protected int d;
  protected String d;
  protected String e;
  protected String f = "";
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add("map_key_personal_sign");
    jdField_a_of_type_JavaUtilArrayList.add("map_key_account_level");
    jdField_a_of_type_JavaUtilArrayList.add("map_key_diamond");
    jdField_a_of_type_JavaUtilArrayList.add("map_key_troop_mem_info");
    jdField_a_of_type_JavaUtilArrayList.add("map_key_present");
  }
  
  public ProfileTemplateBase(Activity paramActivity, JSONObject paramJSONObject, ProfileCardInfo paramProfileCardInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    try
    {
      this.jdField_c_of_type_Int = Color.parseColor(paramJSONObject.optString("c"));
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
    this.jdField_c_of_type_Int = -16777216;
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sbg");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("t_bg");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("arr");
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("f");
    this.e = paramJSONObject.optString("cbg", "");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("cpd", 0);
    this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateProfileTemplateBase$TemplateDecoderHandler = new ProfileTemplateBase.TemplateDecoderHandler();
    try
    {
      this.jdField_a_of_type_Int = Color.parseColor(paramJSONObject.optString("line"));
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
    this.jdField_a_of_type_Int = -1;
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
    JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("module");
    int i = 0;
    if ((localJSONArray != null) && (localJSONArray.length() != 0))
    {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      while (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.optJSONObject(i);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("module array[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("] is null");
          SLog.e("DIYProfileTemplate.ProfileTemplateBase", ((StringBuilder)localObject).toString());
        }
        else
        {
          String str = ((JSONObject)localObject).optString("type");
          this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
        }
        i += 1;
      }
      return;
    }
    AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
    this.jdField_a_of_type_JavaUtilMap = null;
  }
  
  private void i(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.b(this.jdField_a_of_type_AndroidAppActivity) - UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public int a(float paramFloat)
  {
    return (int)(paramFloat * this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("line");
    int i = this.jdField_a_of_type_Int;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return i;
    }
    try
    {
      int j = Color.parseColor((String)localObject);
      return j;
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
    return i;
  }
  
  public <T extends View> T a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    paramQQAppInterface = new TemplatePhotoWall(this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface, paramProfileCardInfo.allInOne.uin);
    paramProfileCardInfo = (ProfileCardDiyPhotoWallView)paramQQAppInterface.findViewById(2131372671).findViewById(2131372671);
    paramProfileCardInfo.setMargin(UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    paramProfileCardInfo.setBorderWidth(this.jdField_d_of_type_Int);
    paramProfileCardInfo = a(this.jdField_a_of_type_AndroidAppActivity);
    paramProfileCardInfo.setTitle(HardCodeUtil.a(2131708489));
    paramProfileCardInfo.setVisibility(8);
    paramProfileCardInfo.addView(paramQQAppInterface);
    return paramProfileCardInfo;
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    QZoneLayoutTemplateBase localQZoneLayoutTemplateBase = (QZoneLayoutTemplateBase)paramView.findViewById(2131368817);
    localQZoneLayoutTemplateBase.setBorderColor(a(paramJSONObject));
    localQZoneLayoutTemplateBase.setBorderWidth(b(paramJSONObject));
    localQZoneLayoutTemplateBase.setItemBg(a(paramJSONObject, a(70.0F), a(70.0F)));
    a(paramJSONObject, paramView.findViewById(2131368343), (TextView)paramView.findViewById(2131378609), (ImageView)paramView.findViewById(2131368501));
    return paramView;
  }
  
  protected URLDrawable a(String paramString)
  {
    return a(paramString, null);
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    paramString = a(paramString);
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
      paramJSONObject = this.e;
    } else {
      paramJSONObject = paramJSONObject.optString("cbg", this.e);
    }
    if (TextUtils.isEmpty(paramJSONObject)) {
      return null;
    }
    return a(paramJSONObject, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1, paramInt2));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562005);
  }
  
  protected String a(@NonNull String paramString)
  {
    if (paramString.startsWith("http")) {
      return paramString;
    }
    if (!TextUtils.isEmpty(this.f))
    {
      if (this.f.startsWith("http"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.f);
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("it have the illegal url prefix=");
      localStringBuilder.append(this.f);
      QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, localStringBuilder.toString());
    }
    return paramString;
  }
  
  protected String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return this.e;
    }
    return paramJSONObject.optString("cbg", this.e);
  }
  
  public void a(View paramView)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap == null) {
      return;
    }
    a(a(localMap, "qz"), paramView);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (("map_key_phone".equals(paramString)) || ("map_key_personal_sign".equals(paramString)) || ("map_key_mine_weishi".equals(paramString)) || ("map_key_favor".equals(paramString)) || ("map_key_account_info_vas".equals(paramString)))
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.jdField_c_of_type_Int);
      }
      if ((paramView instanceof TextView))
      {
        ((TextView)paramView).setTextColor(this.jdField_c_of_type_Int);
        return;
      }
      if ((paramView instanceof SingleLineTextView))
      {
        ((SingleLineTextView)paramView).setTextColor(this.jdField_c_of_type_Int);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setColorFilter(this.jdField_c_of_type_Int);
      }
    }
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562013, null));
  }
  
  protected void a(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return;
    }
    i(paramView);
    a(paramJSONObject, paramView, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, int paramInt1, int paramInt2)
  {
    String str;
    if (paramJSONObject == null) {
      str = this.jdField_a_of_type_JavaLangString;
    } else {
      str = paramJSONObject.optString("bg", this.jdField_a_of_type_JavaLangString);
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
      Object localObject = b(paramJSONObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView.setBackgroundDrawable(a((String)localObject));
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
      paramView = c(paramJSONObject);
      if (!TextUtils.isEmpty(paramView))
      {
        try
        {
          paramImageView.setImageDrawable(a(paramView));
        }
        catch (IllegalArgumentException paramJSONObject)
        {
          paramImageView.setImageResource(2130839270);
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
      paramTextView.setTextColor(this.jdField_c_of_type_Int);
    }
  }
  
  public void a(JSONObject paramJSONObject, TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3)
  {
    if (paramTextView != null) {
      paramTextView.setTextColor(this.jdField_c_of_type_Int);
    }
    if ((paramView1 instanceof TextView)) {
      ((TextView)paramView1).setTextColor(this.jdField_c_of_type_Int);
    } else if ((paramView1 instanceof SingleLineTextView)) {
      ((SingleLineTextView)paramView1).setTextColor(this.jdField_c_of_type_Int);
    }
    int i;
    if (paramImageView != null)
    {
      i = a(18.0F);
      paramTextView = paramImageView.getLayoutParams();
      paramTextView.width = i;
      paramTextView.height = i;
      paramImageView.setLayoutParams(paramTextView);
      paramTextView = c(paramJSONObject);
      if (!TextUtils.isEmpty(paramTextView)) {
        paramImageView.setImageDrawable(a(paramTextView));
      } else {
        paramImageView.setImageDrawable(null);
      }
    }
    if (paramView2 != null)
    {
      paramTextView = b(paramJSONObject);
      if (!TextUtils.isEmpty(paramTextView))
      {
        paramView2.setBackgroundDrawable(a(paramTextView));
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
      i = a(10.0F);
      paramView3.setPadding(i, i, i, i);
      a(paramJSONObject, paramView3);
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
      localObject = a(paramJSONObject);
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
  
  protected int b(JSONObject paramJSONObject)
  {
    int i;
    if (paramJSONObject == null) {
      i = this.jdField_b_of_type_Int;
    } else {
      i = paramJSONObject.optInt("cpd", this.jdField_b_of_type_Int);
    }
    if (i == 0) {
      return this.jdField_d_of_type_Int;
    }
    return a(i / 2);
  }
  
  public View b(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {
      return paramView;
    }
    Object localObject = (ProfileCardFavorShowView)paramView;
    PhotoWallView localPhotoWallView = (PhotoWallView)((ProfileCardFavorShowView)localObject).getViewInContainer(0);
    ProfileCardDiyPhotoWallView localProfileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView)localPhotoWallView.findViewById(2131372671).findViewById(2131372671);
    localProfileCardDiyPhotoWallView.setItemViewBorderColor(a(paramJSONObject));
    localProfileCardDiyPhotoWallView.setBorderImgUrl(a(paramJSONObject));
    localProfileCardDiyPhotoWallView.setBorderWidth(b(paramJSONObject));
    a(paramJSONObject, ((ProfileCardFavorShowView)localObject).findViewById(2131368343), (TextView)((ProfileCardFavorShowView)localObject).findViewById(2131378609), (ImageView)((ProfileCardFavorShowView)localObject).findViewById(2131368501));
    localObject = localPhotoWallView.findViewById(2131372663);
    if (((View)localObject).getVisibility() == 0)
    {
      ((View)localObject).setPadding(a(10.0F), a(15.0F), a(10.0F), a(10.0F));
      i(localPhotoWallView);
      a(paramJSONObject, (View)localObject, localPhotoWallView.getMeasuredWidth(), localPhotoWallView.getMeasuredHeight());
    }
    return paramView;
  }
  
  protected String b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = this.jdField_b_of_type_JavaLangString;
    } else {
      paramJSONObject = paramJSONObject.optString("t_bg");
    }
    Object localObject = paramJSONObject;
    if (TextUtils.isEmpty(paramJSONObject)) {
      localObject = this.jdField_b_of_type_JavaLangString;
    }
    return localObject;
  }
  
  public void b(View paramView)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null)
    {
      if (paramView == null) {
        return;
      }
      b(a(localMap, "photo"), paramView);
    }
  }
  
  protected String c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = this.jdField_c_of_type_JavaLangString;
    } else {
      paramJSONObject = paramJSONObject.optString("arr");
    }
    Object localObject = paramJSONObject;
    if (TextUtils.isEmpty(paramJSONObject)) {
      localObject = this.jdField_c_of_type_JavaLangString;
    }
    return localObject;
  }
  
  public void c(View paramView)
  {
    JSONObject localJSONObject = a(this.jdField_a_of_type_JavaUtilMap, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      paramView.setPadding(a(10.0F), a(12.0F), a(10.0F), a(12.0F));
      a(localJSONObject, paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.isTroopMemberCard)
      {
        paramView = paramView.findViewById(2131361877);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
  }
  
  public void d(View paramView)
  {
    Object localObject = a(this.jdField_a_of_type_JavaUtilMap, "info");
    if (localObject != null)
    {
      if (paramView == null) {
        return;
      }
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131361874);
      if (localViewGroup.getChildAt(0) != null) {
        a((JSONObject)localObject, "qq", localViewGroup.getChildAt(0).findViewById(2131368343));
      }
      if (localViewGroup.getChildAt(1) != null) {
        a((JSONObject)localObject, "p", localViewGroup.getChildAt(1).findViewById(2131368343));
      }
      localObject = (TextView)paramView.findViewById(2131361878);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.jdField_c_of_type_Int);
      }
      paramView = (ImageView)paramView.findViewById(2131362975);
      if (paramView != null) {
        paramView.setColorFilter(this.jdField_c_of_type_Int);
      }
    }
  }
  
  public void e(View paramView)
  {
    JSONObject localJSONObject = a(this.jdField_a_of_type_JavaUtilMap, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "sign", paramView.findViewById(2131368343));
    }
  }
  
  public void f(View paramView)
  {
    JSONObject localJSONObject = a(this.jdField_a_of_type_JavaUtilMap, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "lv", paramView.findViewById(2131368343));
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.isTroopMemberCard) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void g(View paramView)
  {
    JSONObject localJSONObject = a(this.jdField_a_of_type_JavaUtilMap, "info");
    if (localJSONObject != null)
    {
      if (paramView == null) {
        return;
      }
      a(localJSONObject, "metal", paramView.findViewById(2131368343));
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.isTroopMemberCard) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void h(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.isTroopMemberCard) {
      return;
    }
    if ((paramView != null) && (paramView.getParent() == null))
    {
      int i = 0;
      for (;;)
      {
        Object localObject = (ViewGroup)paramView;
        if (i >= ((ViewGroup)localObject).getChildCount()) {
          break;
        }
        localObject = ((ViewGroup)localObject).getChildAt(i);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131369087);
        if (localTextView != null) {
          localTextView.setTextColor(this.jdField_c_of_type_Int);
        }
        localObject = (ImageView)((View)localObject).findViewById(2131368343);
        if (localObject != null)
        {
          ((ImageView)localObject).clearColorFilter();
          ((ImageView)localObject).setColorFilter(this.jdField_c_of_type_Int);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
 * JD-Core Version:    0.7.0.1
 */