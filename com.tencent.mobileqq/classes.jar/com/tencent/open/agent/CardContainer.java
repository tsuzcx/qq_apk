package com.tencent.open.agent;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import ascz;
import bhgr;
import bjjz;
import bjlq;
import bjlr;
import bjls;
import bjlt;
import bjlu;
import bjlv;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainer
  extends RelativeLayout
{
  protected int a;
  protected Context a;
  public Drawable a;
  protected Handler a;
  protected LayoutInflater a;
  protected ImageView a;
  private LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected URLDrawableDownListener.Adapter a;
  public AnyScaleTypeImageView a;
  protected FixedBounceScrollView a;
  public AuthorityAccountView a;
  protected List<bjlv> a;
  public boolean a;
  protected final int b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  private boolean b;
  protected final int c;
  private ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  protected RelativeLayout d;
  protected TextView d;
  protected TextView e;
  protected TextView f;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new bjlq(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bjlr(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Int = paramAttributeSet.widthPixels;
    this.jdField_c_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private URLDrawable a(String paramString)
  {
    localObject3 = null;
    try
    {
      Object localObject1 = new ascz(0, this.jdField_b_of_type_Int, 100);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      try
      {
        localObject1 = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString = (String)localObject1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("CardContainer", 1, new Object[] { "genGameUrlImg exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
          paramString = localObject3;
        }
      }
      if ((paramString != null) && (paramString.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardContainer", 2, "-->-->genGameUrlImg: failed");
        }
        paramString.restartDownload();
      }
      if (((paramString == null) || (paramString.getStatus() != 1)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        this.jdField_a_of_type_AndroidOsHandler.post(new CardContainer.7(this, paramString));
      }
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardContainer", 2, "-->create empty drawable oom.", localOutOfMemoryError);
        }
        localObject2 = null;
      }
    }
  }
  
  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardContainer", 2, "performAnim height =" + paramInt1 + ", topMargin =" + paramInt2);
    }
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 0, paramInt2 });
    localValueAnimator1.addUpdateListener(new bjls(this, paramImageView));
    localValueAnimator1.addListener(new bjlt(this, paramImageView));
    localValueAnimator2.addUpdateListener(new bjlu(this));
    localValueAnimator1.setDuration(300L);
    localValueAnimator2.setDuration(300L);
    paramImageView = new AnimatorSet();
    paramImageView.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    paramImageView.setDuration(300L);
    paramImageView.start();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardContainer", 2, "displayCoverContainer ");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
        ImmersiveUtils.a(false, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getWindow());
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
        break label111;
      }
      ((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext).l();
    }
    for (;;)
    {
      int i = (int)(this.jdField_b_of_type_Int / 1.307692F);
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView, i, i - j);
      return;
      label111:
      if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext).h();
      }
    }
  }
  
  protected String a()
  {
    String str = AuthorityActivity.e;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int j = str.length();
    if (j >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(j - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int i = 2;
      j = 0;
      while (j < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(j, i));
        j += 2;
        i += 2;
      }
      localObject = new StringBuilder();
      i = 0;
      while (i < 8 - j)
      {
        ((StringBuilder)localObject).append("0");
        i += 1;
      }
    }
    localStringBuilder.append("/").append(str).append("_").append("android").append("_").append("ad").append("_").append("0.jpg");
    localStringBuilder.replace(0, 4, "gamead");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public List<bjlv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "switchToMode -->mode: " + paramInt + ", mMode=" + this.jdField_a_of_type_Int);
    }
    ThreadManager.executeOnSubThread(new CardContainer.3(this));
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    if (paramInt == 0) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt == 1) {
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsPic = " + paramBitmap);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsTxt = " + paramString);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    QLog.i("showAppInfo", 1, "showAppInfo appName = " + paramString, new RuntimeException("ShowAppInfoStack"));
    setVisibility(0);
    if ((!TextUtils.isEmpty(paramString)) && (getTag() != null)) {
      ((TextView)findViewById(2131362305)).setText(anzj.a(2131700360) + paramString + anzj.a(2131700359));
    }
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.setAppInfo(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = 0;
      i = 0;
      if (j >= paramString2.length()) {
        break label276;
      }
      if (String.valueOf(paramString2.charAt(j)).getBytes().length <= 1) {
        break label258;
      }
      i += 2;
      label45:
      if (i <= 10) {
        break label267;
      }
    }
    label258:
    label267:
    label276:
    for (int i = 1;; i = 0)
    {
      String str2 = paramString2.substring(0, j);
      String str1 = str2;
      if (i != 0) {
        str1 = str2 + "...";
      }
      QLog.i("CardContainer", 1, "-->showUserInfo() set nickname ellipsis=" + str1 + ",nick=" + paramString2);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = String.format(super.getContext().getString(2131689811), new Object[] { paramString1 });
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
        if (this.e.getVisibility() == 0) {
          this.e.setVisibility(8);
        }
      }
      if (paramBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a(paramString1);
      }
      return;
      i += 1;
      break label45;
      j += 1;
      break;
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    int i = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = paramGetAuthApiListResponse.authorized_form_list.get();
    paramGetAuthApiListResponse = new StringBuilder(((List)localObject).size() * 128);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      appType.AuthItem localAuthItem = (appType.AuthItem)((Iterator)localObject).next();
      if (localAuthItem.is_new.get() != 0)
      {
        bjlv localbjlv = new bjlv();
        localbjlv.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localbjlv.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localbjlv.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {}
        for (bool = false;; bool = true)
        {
          localbjlv.jdField_a_of_type_Boolean = bool;
          localbjlv.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
          if (QLog.isColorLevel()) {
            paramGetAuthApiListResponse.append("--> Permission p, api: ").append(localbjlv.jdField_b_of_type_JavaLangString).append(" | flag: ").append(localbjlv.jdField_a_of_type_Int).append(" | id: ").append(localbjlv.jdField_b_of_type_Int).append(" | isNew: ").append(localbjlv.jdField_a_of_type_Boolean).append(" | title: ").append(localbjlv.jdField_a_of_type_JavaLangString).append("\n");
          }
          this.jdField_a_of_type_JavaUtilList.add(localbjlv);
          break;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, paramGetAuthApiListResponse.toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    for (boolean bool = true; bool; bool = false)
    {
      paramGetAuthApiListResponse = this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(1);
      this.e.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("CardContainer", 2, "--> has been authority.");
      }
      setAdImageByURL(paramGetAuthApiListResponse, a());
      return bool;
    }
    a(0);
    if (QLog.isColorLevel()) {
      QLog.d("CardContainer", 2, "--> has not been authority.");
    }
    paramGetAuthApiListResponse = "";
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (bjlv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (getTag() != null) {}
      for (paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· 获得你与QQ通讯录绑定的电话号码";; paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· " + ((bjlv)localObject).jdField_a_of_type_JavaLangString)
      {
        paramGetAuthApiListResponse = paramGetAuthApiListResponse + "\n";
        i += 1;
        break;
      }
    }
    this.f.setText(paramGetAuthApiListResponse);
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.b();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362311));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362312));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362303));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362307));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362309));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362304));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362308));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362310));
    this.e = ((TextView)super.findViewById(2131362306));
    this.e.setVisibility(8);
    this.f = ((TextView)super.findViewById(2131372087));
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView = ((AuthorityAccountView)super.findViewById(2131361927));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363038));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)super.findViewById(2131363049));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setMaxHeight(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 102.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setNeedDisallowIntercept(true);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362314));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131367373));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131379023));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379024));
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    Object localObject = null;
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
    }
    try
    {
      paramAnyScaleTypeImageView = new ascz(0, this.jdField_b_of_type_Int, 100);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramAnyScaleTypeImageView;
      localURLDrawableOptions.mFailedDrawable = paramAnyScaleTypeImageView;
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions;
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 2)) {
          paramAnyScaleTypeImageView.restartDownload();
        }
        if ((paramAnyScaleTypeImageView != null) && (paramAnyScaleTypeImageView.getStatus() == 1))
        {
          c();
          if (QLog.isColorLevel()) {
            QLog.d("CardContainer", 2, "getStatus SUCCESSED: ");
          }
          localAnyScaleTypeImageView.setVisibility(0);
          localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
          return;
          paramAnyScaleTypeImageView = paramAnyScaleTypeImageView;
          if (QLog.isColorLevel()) {
            QLog.e("CardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
          }
          paramAnyScaleTypeImageView = null;
        }
      }
      catch (IllegalArgumentException paramAnyScaleTypeImageView)
      {
        for (;;)
        {
          QLog.e("CardContainer", 1, new Object[] { "setAdImageByURL exception url=", paramString, ",excption=", paramAnyScaleTypeImageView.toString() });
          paramAnyScaleTypeImageView = localObject;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("CardContainer", 2, "getStatus OTHERS: ");
          }
          localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        }
      }
    }
  }
  
  public void setAppType(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.setAppType(paramString);
    }
  }
  
  public void setChangeAccountListener(bjjz parambjjz)
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.setChangeAccountListener(parambjjz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */