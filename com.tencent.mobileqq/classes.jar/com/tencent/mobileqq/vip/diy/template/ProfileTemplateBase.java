package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBox;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
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
  protected View a;
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
    jdField_a_of_type_JavaUtilArrayList.add("map_key_sig");
    jdField_a_of_type_JavaUtilArrayList.add("map_key_account_level_info");
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
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramActivity);
    try
    {
      this.jdField_c_of_type_Int = Color.parseColor(paramJSONObject.optString("c"));
      this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sbg");
      this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("t_bg");
      this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("arr");
      this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("f");
      this.e = paramJSONObject.optString("cbg", "");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("cpd", 0);
      this.jdField_a_of_type_ComTencentMobileqqVipDiyTemplateProfileTemplateBase$TemplateDecoderHandler = new ProfileTemplateBase.TemplateDecoderHandler();
    }
    catch (IllegalArgumentException paramActivity)
    {
      try
      {
        this.jdField_a_of_type_Int = Color.parseColor(paramJSONObject.optString("line"));
        a();
        return;
        paramActivity = paramActivity;
        AssertUtils.a("DIYProfileTemplate.ProfileTemplateBase default main color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
        this.jdField_c_of_type_Int = -16777216;
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          AssertUtils.a("DIYProfileTemplate.ProfileTemplateBase default line color is illegal! " + paramJSONObject.optString("c"), new Object[0]);
          this.jdField_a_of_type_Int = -1;
        }
      }
    }
  }
  
  private JSONObject a(Map<String, JSONObject> paramMap, String paramString)
  {
    JSONObject localJSONObject = (JSONObject)paramMap.get(paramString);
    paramMap = localJSONObject;
    if (localJSONObject == null) {
      SLog.e("DIYProfileTemplate.ProfileTemplateBase", ":json illegal : it don't have " + paramString + " module");
    }
    try
    {
      paramMap = new JSONObject("{}");
      return paramMap;
    }
    catch (JSONException paramMap)
    {
      AssertUtils.a("DIYProfileTemplate.ProfileTemplateBase:json error : it can not generate default " + paramString + " module", new Object[0]);
    }
    return null;
  }
  
  private void a()
  {
    int i = 0;
    JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("module");
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      AssertUtils.a("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
      this.jdField_a_of_type_JavaUtilMap = null;
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    label49:
    JSONObject localJSONObject;
    if (i < localJSONArray.length())
    {
      localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject != null) {
        break label103;
      }
      SLog.e("DIYProfileTemplate.ProfileTemplateBase", "module array[" + i + "] is null");
    }
    for (;;)
    {
      i += 1;
      break label49;
      break;
      label103:
      String str = localJSONObject.optString("type");
      this.jdField_a_of_type_JavaUtilMap.put(str, localJSONObject);
    }
  }
  
  private void a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.b(this.jdField_a_of_type_AndroidAppActivity) - UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 30.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  public int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected int a(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("line");
    int i = this.jdField_a_of_type_Int;
    if (TextUtils.isEmpty(str)) {
      return i;
    }
    try
    {
      int j = Color.parseColor(str);
      return j;
    }
    catch (Exception localException)
    {
      AssertUtils.a("DIYProfileTemplate.ProfileTemplateBase story line color is illegal module=" + paramJSONObject.optString("type") + " value=" + paramJSONObject.optString("line"), new Object[0]);
    }
    return i;
  }
  
  public View a(View paramView)
  {
    if ((paramView instanceof ProfileCardFavorShowView))
    {
      localObject = (ProfileCardFavorShowView)paramView;
      ((ProfileCardFavorShowView)localObject).a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      b(null, (ProfileCardFavorShowView)localObject);
    }
    while (paramView == null) {
      return paramView;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(-1, -2);
    }
    ((LinearLayout.LayoutParams)localObject).leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 15.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramView.setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
    a(null, paramView);
    return paramView;
  }
  
  public View a(HashMap<String, View> paramHashMap1, String paramString, HashMap<String, View> paramHashMap2)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {}
    do
    {
      do
      {
        return null;
        if (jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
          return (View)paramHashMap1.get(paramString);
        }
        if (paramString.equals("map_key_account_base_info")) {
          return a(a(this.jdField_a_of_type_JavaUtilMap, "info"), (View)paramHashMap1.get("map_key_account_base_info"), (View)paramHashMap1.get("map_key_sig"), (View)paramHashMap1.get("map_key_account_level_info"), (View)paramHashMap1.get("map_key_diamond"), (View)paramHashMap2.get("map_key_troop_mem_info"));
        }
        if ((paramString.equals("map_key_sig")) || (paramString.equals("map_key_account_level_info")) || (paramString.equals("map_key_diamond")) || (paramString.equals("map_key_troop_mem_info"))) {
          return (View)paramHashMap1.get(paramString);
        }
        if (paramString.equals("map_key_qzone")) {
          return a(a(this.jdField_a_of_type_JavaUtilMap, "qz"), (View)paramHashMap1.get("map_key_qzone"));
        }
        if (paramString.equals("map_key_photo_wall")) {
          return c(a(this.jdField_a_of_type_JavaUtilMap, "photo"), (View)paramHashMap1.get("map_key_photo_wall"));
        }
        if (paramString.equals("map_key_personality_label")) {
          return d(a(this.jdField_a_of_type_JavaUtilMap, "tag"), (View)paramHashMap1.get("map_key_personality_label"));
        }
        if (paramString.equals("map_key_extend_friend")) {
          return e(a(this.jdField_a_of_type_JavaUtilMap, "exp"), (View)paramHashMap1.get("map_key_extend_friend"));
        }
        if (paramString.equals("map_key_favor")) {
          return f(a(this.jdField_a_of_type_JavaUtilMap, "recent"), (View)paramHashMap1.get("map_key_favor"));
        }
      } while (paramString.equals("map_key_present"));
      if (!paramString.equals("map_key_music_box")) {
        break;
      }
      paramString = a(this.jdField_a_of_type_JavaUtilMap, "qz");
    } while ((!ProfileMusicBox.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo)) || (!paramHashMap1.containsKey("map_key_music_box")));
    return b(paramString, (View)paramHashMap1.get("map_key_music_box"));
    if (paramString.equals("map_key_troop_mem_game_info")) {
      return (View)paramHashMap1.get(paramString);
    }
    return a((View)paramHashMap1.get(paramString));
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    QZoneLayoutTemplateBase localQZoneLayoutTemplateBase = (QZoneLayoutTemplateBase)paramView.findViewById(2131369096);
    localQZoneLayoutTemplateBase.setBorderColor(a(paramJSONObject));
    localQZoneLayoutTemplateBase.setBorderWidth(b(paramJSONObject));
    localQZoneLayoutTemplateBase.setItemBg(a(paramJSONObject, a(70.0F), a(70.0F)));
    a(paramJSONObject, paramView.findViewById(2131368603), (TextView)paramView.findViewById(2131379248), (ImageView)paramView.findViewById(2131368771));
    return paramView;
  }
  
  public View a(JSONObject paramJSONObject, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131361868);
    Object localObject;
    if (paramView1 == null)
    {
      localObject = localViewGroup.findViewById(2131361871);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localViewGroup.setVisibility(8);
      if (paramView2 != null) {
        break label412;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131374759).setVisibility(8);
      label67:
      if (paramView3 != null) {
        break label430;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131374761).setVisibility(8);
      label87:
      if (paramView4 != null) {
        break label449;
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131374757).setVisibility(8);
    }
    for (;;)
    {
      if (localViewGroup.getChildAt(0) != null) {
        a(paramJSONObject, "qq", localViewGroup.getChildAt(0).findViewById(2131368603));
      }
      if (localViewGroup.getChildAt(1) != null) {
        a(paramJSONObject, "p", localViewGroup.getChildAt(1).findViewById(2131368603));
      }
      if (paramView1 != null)
      {
        paramView1.setPadding(a(10.0F), a(12.0F), a(10.0F), a(12.0F));
        a(paramJSONObject, paramView1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.b) {
        return paramView1;
      }
      paramJSONObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131361870);
      paramView2 = this.jdField_a_of_type_AndroidViewView.findViewById(2131361871);
      if (paramView2 != null) {
        paramView2.setVisibility(8);
      }
      if (paramView3 != null) {
        paramView3.setVisibility(8);
      }
      if (paramView4 != null) {
        paramView4.setVisibility(8);
      }
      paramJSONObject.removeAllViews();
      if ((paramView5 == null) || (paramView5.getParent() != null)) {
        return paramView1;
      }
      int i = 0;
      while (i < ((ViewGroup)paramView5).getChildCount())
      {
        paramView2 = ((ViewGroup)paramView5).getChildAt(i);
        paramView3 = (TextView)paramView2.findViewById(2131369358);
        if (paramView3 != null) {
          paramView3.setTextColor(this.jdField_c_of_type_Int);
        }
        paramView2 = (ImageView)paramView2.findViewById(2131368603);
        if (paramView2 != null)
        {
          paramView2.clearColorFilter();
          paramView2.setColorFilter(this.jdField_c_of_type_Int);
        }
        i += 1;
      }
      localObject = (TextView)localViewGroup.findViewById(2131361872);
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setTextColor(this.jdField_c_of_type_Int);
      break;
      label412:
      a(paramJSONObject, "sign", paramView2.findViewById(2131368603));
      break label67;
      label430:
      a(paramJSONObject, "lv", paramView3.findViewById(2131368603));
      break label87;
      label449:
      a(paramJSONObject, "metal", paramView4.findViewById(2131368603));
    }
    paramJSONObject.addView(paramView5, 0);
    return paramView1;
  }
  
  protected URLDrawable a(String paramString)
  {
    return a(paramString, null);
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    paramString = a(paramString);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
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
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.e; TextUtils.isEmpty(paramJSONObject); paramJSONObject = paramJSONObject.optString("cbg", this.e)) {
      return null;
    }
    return a(paramJSONObject, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1, paramInt2));
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562168);
  }
  
  protected String a(@NonNull String paramString)
  {
    if (paramString.startsWith("http")) {}
    while (TextUtils.isEmpty(this.f)) {
      return paramString;
    }
    if (this.f.startsWith("http")) {
      return this.f + paramString;
    }
    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, "it have the illegal url prefix=" + this.f);
    return paramString;
  }
  
  protected String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return this.e;
    }
    return paramJSONObject.optString("cbg", this.e);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (("map_key_phone".equals(paramString)) || ("map_key_sig".equals(paramString)) || ("map_key_mine_weishi".equals(paramString)) || ("map_key_favor".equals(paramString)) || ("map_key_account_base_info".equals(paramString)))
    {
      if (paramTextView != null) {
        paramTextView.setTextColor(this.jdField_c_of_type_Int);
      }
      if (!(paramView instanceof TextView)) {
        break label80;
      }
      ((TextView)paramView).setTextColor(this.jdField_c_of_type_Int);
    }
    label80:
    do
    {
      return;
      if ((paramView instanceof SingleLineTextView))
      {
        ((SingleLineTextView)paramView).setTextColor(this.jdField_c_of_type_Int);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setColorFilter(this.jdField_c_of_type_Int);
  }
  
  public void a(HashMap<String, View> paramHashMap)
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562175, null);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    Object localObject = localMarginLayoutParams;
    if (localMarginLayoutParams == null) {
      localObject = new ViewGroup.MarginLayoutParams(-1, -1);
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMargins(a(11.0F), a(11.0F), a(11.0F), a(11.0F));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramHashMap.put("map_key_account_base_info", this.jdField_a_of_type_AndroidViewView);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131374759);
    ((View)localObject).setBackgroundResource(2130839577);
    paramHashMap.put("map_key_sig", localObject);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131374761);
    ((View)localObject).setBackgroundResource(2130839577);
    paramHashMap.put("map_key_account_level_info", localObject);
    ((View)localObject).setClickable(false);
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131374757);
    ((View)localObject).setBackgroundResource(2130839577);
    paramHashMap.put("map_key_diamond", localObject);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    paramQQAppInterface = new TemplatePhotoWall(this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface, paramProfileCardInfo.a.jdField_a_of_type_JavaLangString);
    paramProfileCardInfo = (ProfileCardDiyPhotoWallView)paramQQAppInterface.findViewById(2131373092).findViewById(2131373092);
    paramProfileCardInfo.setMargin(UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F));
    paramProfileCardInfo.setBorderWidth(this.jdField_d_of_type_Int);
    paramProfileCardInfo = a(this.jdField_a_of_type_AndroidAppActivity);
    paramProfileCardInfo.setTitle(HardCodeUtil.a(2131708483));
    paramProfileCardInfo.setVisibility(8);
    paramProfileCardInfo.addView(paramQQAppInterface);
    paramHashMap.put("map_key_photo_wall", paramProfileCardInfo);
  }
  
  public void a(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    paramQQAppInterface = a(this.jdField_a_of_type_AndroidAppActivity);
    paramQQAppInterface.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131691241));
    paramQQAppInterface.setVisibility(8);
    paramQQAppInterface.setOnClickListener(null);
    if (paramBoolean) {
      paramQQAppInterface.setShowArrow(false);
    }
    paramHashMap.put("map_key_extend_friend", paramQQAppInterface);
  }
  
  public void a(HashMap<String, View> paramHashMap, Card paramCard)
  {
    ProfileMusicBox localProfileMusicBox = new ProfileMusicBox(true);
    paramCard = localProfileMusicBox.a(this.jdField_a_of_type_AndroidAppActivity, paramCard.uin);
    localProfileMusicBox.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    paramCard.setTag(2131562187, localProfileMusicBox);
    paramHashMap.put("map_key_music_box", paramCard);
  }
  
  protected void a(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return;
    }
    a(paramView);
    a(paramJSONObject, paramView, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, int paramInt1, int paramInt2)
  {
    String str;
    if (paramJSONObject == null)
    {
      str = this.jdField_a_of_type_JavaLangString;
      if (paramJSONObject != null) {
        break label74;
      }
    }
    label74:
    for (paramJSONObject = "null module";; paramJSONObject = paramJSONObject.optString("type"))
    {
      if (!TextUtils.isEmpty(str)) {
        break label84;
      }
      SLog.d("DIYProfileTemplate.ProfileTemplateBase", "setModuleBackground " + paramJSONObject + " ,but it is null.");
      return;
      str = paramJSONObject.optString("bg", this.jdField_a_of_type_JavaLangString);
      break;
    }
    label84:
    if (paramView == null)
    {
      AssertUtils.a("setModuleBackground cant find " + paramJSONObject + " view", new Object[0]);
      return;
    }
    try
    {
      URLDrawable localURLDrawable = a(str, new ProfileTemplateBase.NinePatchDecoderHandler(paramInt1, paramInt2));
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new ProfileTemplateBase.BackGroundUpdateListener(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      AssertUtils.a("setModuleBackground " + paramJSONObject + " url illegal:" + str + " \ne:" + paramView, new Object[0]);
    }
  }
  
  protected void a(JSONObject paramJSONObject, View paramView, TextView paramTextView, ImageView paramImageView)
  {
    if (paramView != null)
    {
      String str = b(paramJSONObject);
      if (!TextUtils.isEmpty(str)) {
        paramView.setBackgroundDrawable(a(str));
      }
    }
    else if (paramImageView != null)
    {
      paramView = c(paramJSONObject);
      if (TextUtils.isEmpty(paramView)) {
        break label158;
      }
    }
    for (;;)
    {
      try
      {
        paramImageView.setImageDrawable(a(paramView));
        if (paramTextView != null) {
          paramTextView.setTextColor(this.jdField_c_of_type_Int);
        }
        return;
        if (paramJSONObject != null) {
          QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind title icon is null!");
        }
        paramView.setVisibility(8);
      }
      catch (IllegalArgumentException paramJSONObject)
      {
        paramImageView.setImageResource(2130839414);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DIYProfileTemplate.ProfileTemplateBase", 2, "get arrow drawable failed " + paramJSONObject);
        continue;
      }
      label158:
      if (paramJSONObject != null) {
        QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, paramJSONObject.optString("type") + " bind arrow icon is null!");
      }
      paramImageView.setVisibility(8);
    }
  }
  
  public void a(JSONObject paramJSONObject, TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3)
  {
    if (paramTextView != null) {
      paramTextView.setTextColor(this.jdField_c_of_type_Int);
    }
    int i;
    if ((paramView1 instanceof TextView))
    {
      ((TextView)paramView1).setTextColor(this.jdField_c_of_type_Int);
      if (paramImageView != null)
      {
        i = a(18.0F);
        paramTextView = paramImageView.getLayoutParams();
        paramTextView.width = i;
        paramTextView.height = i;
        paramImageView.setLayoutParams(paramTextView);
        paramTextView = c(paramJSONObject);
        if (TextUtils.isEmpty(paramTextView)) {
          break label181;
        }
        paramImageView.setImageDrawable(a(paramTextView));
      }
      label91:
      if (paramView2 != null)
      {
        paramTextView = b(paramJSONObject);
        if (TextUtils.isEmpty(paramTextView)) {
          break label190;
        }
        paramView2.setBackgroundDrawable(a(paramTextView));
        paramView2.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramView3 != null)
      {
        i = a(10.0F);
        paramView3.setPadding(i, i, i, i);
        a(paramJSONObject, paramView3);
      }
      return;
      if (!(paramView1 instanceof SingleLineTextView)) {
        break;
      }
      ((SingleLineTextView)paramView1).setTextColor(this.jdField_c_of_type_Int);
      break;
      label181:
      paramImageView.setImageDrawable(null);
      break label91;
      label190:
      paramView2.setBackgroundDrawable(null);
      paramView2.setVisibility(8);
    }
  }
  
  public void a(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    if (paramProfileCardFavorShowView.b() > 0)
    {
      View localView = paramProfileCardFavorShowView.a(0);
      a(localView);
      a(paramJSONObject, paramProfileCardFavorShowView.a(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
    }
    for (;;)
    {
      a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131368603), (TextView)paramProfileCardFavorShowView.findViewById(2131379248), (ImageView)paramProfileCardFavorShowView.findViewById(2131368771));
      return;
      a(paramJSONObject, paramProfileCardFavorShowView.a());
    }
  }
  
  protected void a(JSONObject paramJSONObject, String paramString, View paramView)
  {
    paramJSONObject = paramJSONObject.optString(paramString);
    if (TextUtils.isEmpty(paramJSONObject))
    {
      SLog.d("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon " + paramString + " icon,but it is null.");
      return;
    }
    if (paramView == null)
    {
      SLog.e("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon cant find " + paramString + " view");
      return;
    }
    try
    {
      URLDrawable localURLDrawable = a(paramJSONObject);
      paramView.setBackgroundDrawable(localURLDrawable);
      localURLDrawable.setURLDrawableListener(new ProfileTemplateBase.BackGroundUpdateListener(paramView));
      return;
    }
    catch (IllegalArgumentException paramView)
    {
      AssertUtils.a("setBaseInfoIcon " + paramString + " url illegal:" + paramJSONObject + " \ne:" + paramView, new Object[0]);
    }
  }
  
  public boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  protected int b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (int i = this.jdField_b_of_type_Int; i == 0; i = paramJSONObject.optInt("cpd", this.jdField_b_of_type_Int)) {
      return this.jdField_d_of_type_Int;
    }
    return a(i / 2);
  }
  
  public View b(JSONObject paramJSONObject, View paramView)
  {
    View localView = paramView.findViewById(2131369072);
    Object localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = a(15.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = a(15.0F);
    ((LinearLayout.LayoutParams)localObject1).height = a(74.0F);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = paramView.findViewById(2131368603);
    Object localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = a(16.0F);
    ((LinearLayout.LayoutParams)localObject2).height = a(28.0F);
    ((LinearLayout.LayoutParams)localObject2).topMargin = 0;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (TextView)paramView.findViewById(2131379248);
    ((TextView)localObject2).setTextSize(1, 20.0F);
    ((TextView)localObject2).setTypeface(((TextView)localObject2).getTypeface(), 1);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368771);
    localImageView.getLayoutParams().width = a(18.0F);
    localImageView.getLayoutParams().height = a(18.0F);
    localImageView.setLayoutParams(localImageView.getLayoutParams());
    Object localObject3 = (TextView)paramView.findViewById(2131378297);
    ((TextView)localObject3).setTextColor(this.jdField_c_of_type_Int);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
    localLayoutParams.topMargin = a(22.0F);
    ((TextView)localObject3).setLayoutParams(localLayoutParams);
    localObject3 = paramView.findViewById(2131378442);
    localLayoutParams = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
    localLayoutParams.topMargin = a(19.0F);
    localLayoutParams.leftMargin = a(19.0F);
    ((View)localObject3).setLayoutParams(localLayoutParams);
    ((TextView)paramView.findViewById(2131366344)).setTextColor(this.jdField_c_of_type_Int);
    localObject3 = (TextView)paramView.findViewById(2131378296);
    ((TextView)localObject3).setTextColor(this.jdField_c_of_type_Int);
    ((TextView)localObject3).setAlpha(0.2509804F);
    a(paramJSONObject, (View)localObject1, (TextView)localObject2, localImageView);
    a(paramJSONObject, localView);
    if (paramView.getTag(2131562187) != null) {
      ((ProfileMusicBox)paramView.getTag(2131562187)).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
    return paramView;
  }
  
  protected String b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.jdField_b_of_type_JavaLangString;; paramJSONObject = paramJSONObject.optString("t_bg"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      return localObject;
    }
  }
  
  public void b(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562176, null));
  }
  
  public void b(HashMap<String, View> paramHashMap, QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    ProfileCardFavorShowView localProfileCardFavorShowView = a(this.jdField_a_of_type_AndroidAppActivity);
    paramQQAppInterface = new PersonalityLabelBoard(this.jdField_a_of_type_AndroidAppActivity, paramQQAppInterface, paramProfileCardInfo.a.jdField_a_of_type_JavaLangString);
    localProfileCardFavorShowView.setTitle(HardCodeUtil.a(2131708482));
    localProfileCardFavorShowView.setVisibility(8);
    localProfileCardFavorShowView.addView(paramQQAppInterface);
    paramHashMap.put("map_key_personality_label", localProfileCardFavorShowView);
  }
  
  public void b(JSONObject paramJSONObject, ProfileCardFavorShowView paramProfileCardFavorShowView)
  {
    if (paramProfileCardFavorShowView == null) {
      return;
    }
    a(paramJSONObject, paramProfileCardFavorShowView.a());
    a(paramJSONObject, paramProfileCardFavorShowView.findViewById(2131368603), (TextView)paramProfileCardFavorShowView.findViewById(2131379248), (ImageView)paramProfileCardFavorShowView.findViewById(2131368771));
  }
  
  public View c(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    Object localObject;
    PhotoWallView localPhotoWallView;
    do
    {
      return paramView;
      localObject = (ProfileCardFavorShowView)paramView;
      localPhotoWallView = (PhotoWallView)((ProfileCardFavorShowView)localObject).a(0);
      ProfileCardDiyPhotoWallView localProfileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView)localPhotoWallView.findViewById(2131373092).findViewById(2131373092);
      localProfileCardDiyPhotoWallView.setItemViewBorderColor(a(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderImgUrl(a(paramJSONObject));
      localProfileCardDiyPhotoWallView.setBorderWidth(b(paramJSONObject));
      a(paramJSONObject, ((ProfileCardFavorShowView)localObject).findViewById(2131368603), (TextView)((ProfileCardFavorShowView)localObject).findViewById(2131379248), (ImageView)((ProfileCardFavorShowView)localObject).findViewById(2131368771));
      localObject = localPhotoWallView.findViewById(2131373084);
    } while (((View)localObject).getVisibility() != 0);
    ((View)localObject).setPadding(a(10.0F), a(15.0F), a(10.0F), a(10.0F));
    a(localPhotoWallView);
    a(paramJSONObject, (View)localObject, localPhotoWallView.getMeasuredWidth(), localPhotoWallView.getMeasuredHeight());
    return paramView;
  }
  
  protected String c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (paramJSONObject = this.jdField_c_of_type_JavaLangString;; paramJSONObject = paramJSONObject.optString("arr"))
    {
      Object localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject)) {
        localObject = this.jdField_c_of_type_JavaLangString;
      }
      return localObject;
    }
  }
  
  public View d(JSONObject paramJSONObject, View paramView)
  {
    if (paramView == null) {
      return null;
    }
    ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
    localProfileCardFavorShowView.a().setPadding(a(24.0F), a(21.0F), a(24.0F), a(21.0F));
    try
    {
      ((PersonalityLabelBoard)localProfileCardFavorShowView.a(0)).a.setTextColor(this.jdField_c_of_type_Int);
      if (localProfileCardFavorShowView.b() > 0)
      {
        View localView = localProfileCardFavorShowView.a(0);
        localView.measure(View.MeasureSpec.makeMeasureSpec(UIUtils.b(this.jdField_a_of_type_AndroidAppActivity) - UIUtils.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        a(paramJSONObject, localProfileCardFavorShowView.a(), localView.getMeasuredWidth(), localView.getMeasuredHeight());
        a(paramJSONObject, localProfileCardFavorShowView.findViewById(2131368603), (TextView)localProfileCardFavorShowView.findViewById(2131379248), (ImageView)localProfileCardFavorShowView.findViewById(2131368771));
        return paramView;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.e("DIYProfileTemplate.ProfileTemplateBase", "getTagView error personalityLabelBoard is null");
        continue;
        a(paramJSONObject, localProfileCardFavorShowView.a());
      }
    }
  }
  
  public View e(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof ProfileCardFavorShowView)) {}
    do
    {
      return paramView;
      ProfileCardFavorShowView localProfileCardFavorShowView = (ProfileCardFavorShowView)paramView;
      localProfileCardFavorShowView.a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      a(paramJSONObject, localProfileCardFavorShowView);
      paramJSONObject = localProfileCardFavorShowView.a(0);
      if (paramJSONObject == null) {
        return null;
      }
    } while (!(paramJSONObject instanceof ProfileCardExtendFriendView));
    paramJSONObject = (ProfileCardExtendFriendView)paramJSONObject;
    return paramView;
  }
  
  public View f(JSONObject paramJSONObject, View paramView)
  {
    if (!(paramView instanceof LinearLayout)) {
      return paramView;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    int i = 0;
    label17:
    Object localObject;
    if (i < localLinearLayout.getChildCount())
    {
      localObject = localLinearLayout.getChildAt(i);
      if ((localObject instanceof ProfileCardFavorShowView)) {
        break label49;
      }
    }
    for (;;)
    {
      i += 1;
      break label17;
      break;
      label49:
      localObject = (ProfileCardFavorShowView)localObject;
      ((ProfileCardFavorShowView)localObject).a().setPadding(a(10.0F), a(10.0F), a(10.0F), a(10.0F));
      b(paramJSONObject, (ProfileCardFavorShowView)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase
 * JD-Core Version:    0.7.0.1
 */