package com.tencent.open.agent;

import aljg;
import aljh;
import alji;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthItem;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainer
  extends RelativeLayout
{
  protected int a;
  protected Context a;
  public Drawable a;
  public Handler a;
  protected LayoutInflater a;
  public View a;
  protected ImageView a;
  protected ListView a;
  protected RelativeLayout a;
  protected TextView a;
  protected URLDrawableDownListener.Adapter a;
  public AnyScaleTypeImageView a;
  public AuthorityLoginView a;
  protected CardLargeView a;
  protected List a;
  public boolean a;
  protected final int b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  public AnyScaleTypeImageView b;
  protected final int c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  protected ImageView e;
  protected RelativeLayout e;
  protected TextView e;
  protected ImageView f;
  protected TextView f;
  protected TextView g;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new aljg(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new aljh(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Int = paramAttributeSet.widthPixels;
    this.jdField_c_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public String a()
  {
    String str = AuthorityActivity.f;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    int n = str.length();
    if (n >= 8) {}
    StringBuilder localStringBuilder;
    for (Object localObject = str.substring(n - 8);; localObject = str)
    {
      localStringBuilder = new StringBuilder("http://i.gtimg.cn/open/app_icon");
      int m = 2;
      n = 0;
      while (n < 8)
      {
        localStringBuilder.append("/");
        localStringBuilder.append(((String)localObject).substring(n, m));
        n += 2;
        m += 2;
      }
      localObject = new StringBuilder();
      m = 0;
      while (m < 8 - n)
      {
        ((StringBuilder)localObject).append("0");
        m += 1;
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
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a();
    this.j.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new alji(this));
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (paramInt == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsPic = " + paramBitmap);
    }
    if (paramBitmap != null)
    {
      if ((this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (!TextUtils.isEmpty(this.h.getText().toString()))) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (!TextUtils.isEmpty(this.i.getText().toString()))) {
        this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityActivity", 2, "showAdsInfo adsTxt = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.h.setText(paramString);
      this.i.setText(paramString);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(paramString))
    {
      if (getTag() != null) {
        ((TextView)findViewById(2131365769)).setText("该服务由" + paramString + "提供，提供以下权限即可继续操作");
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int n;
    if (!TextUtils.isEmpty(paramString2))
    {
      n = 0;
      m = 0;
      if (n >= paramString2.length()) {
        break label228;
      }
      if (String.valueOf(paramString2.charAt(n)).getBytes().length <= 1) {
        break label210;
      }
      m += 2;
      label45:
      if (m <= 10) {
        break label219;
      }
    }
    label210:
    label219:
    label228:
    for (int m = 1;; m = 0)
    {
      String str = paramString2.substring(0, n);
      paramString2 = str;
      if (m != 0) {
        paramString2 = str + "...";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString2);
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = String.format(super.getContext().getString(2131428663), new Object[] { paramString1 });
        this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString2);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString2);
        if (this.g.getVisibility() == 0) {
          this.g.setVisibility(8);
        }
      }
      if (paramBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.a(paramString1);
      }
      return;
      m += 1;
      break label45;
      n += 1;
      break;
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse)
  {
    int m = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = paramGetAuthApiListResponse.authorized_form_list.get();
    paramGetAuthApiListResponse = new StringBuilder(((List)localObject).size() * 128);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SdkAuthorize.AuthItem localAuthItem = (SdkAuthorize.AuthItem)((Iterator)localObject).next();
      if (localAuthItem.is_new.get() != 0)
      {
        CardContainer.Permission localPermission = new CardContainer.Permission();
        localPermission.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localPermission.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localPermission.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {}
        for (bool = false;; bool = true)
        {
          localPermission.jdField_a_of_type_Boolean = bool;
          localPermission.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
          if (QLog.isColorLevel()) {
            paramGetAuthApiListResponse.append("--> Permission p, api: ").append(localPermission.jdField_b_of_type_JavaLangString).append(" | flag: ").append(localPermission.jdField_a_of_type_Int).append(" | id: ").append(localPermission.jdField_b_of_type_Int).append(" | isNew: ").append(localPermission.jdField_a_of_type_Boolean).append(" | title: ").append(localPermission.jdField_a_of_type_JavaLangString).append("\n");
          }
          this.jdField_a_of_type_JavaUtilList.add(localPermission);
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
      paramGetAuthApiListResponse = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(1);
      this.g.setVisibility(0);
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
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject = (CardContainer.Permission)this.jdField_a_of_type_JavaUtilList.get(m);
      if (getTag() != null) {}
      for (paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· 获得你与QQ通讯录绑定的电话号码";; paramGetAuthApiListResponse = paramGetAuthApiListResponse + "· " + ((CardContainer.Permission)localObject).jdField_a_of_type_JavaLangString)
      {
        paramGetAuthApiListResponse = paramGetAuthApiListResponse + "\n";
        m += 1;
        break;
      }
    }
    this.k.setText(paramGetAuthApiListResponse);
    return bool;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365764));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365765));
    this.jdField_a_of_type_ComTencentOpenAgentCardLargeView = ((CardLargeView)super.findViewById(2131365735));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131365753));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131365739));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365736);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365751));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365758));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365752));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365759));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365760));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365737));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365744));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365738));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365746));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365747));
    this.g = ((TextView)super.findViewById(2131365748));
    this.g.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131365771));
    this.k = ((TextView)super.findViewById(2131365770));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365754));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365740));
    this.h = ((TextView)super.findViewById(2131365756));
    this.i = ((TextView)super.findViewById(2131365742));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365755));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365741));
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView = ((AuthorityLoginView)super.findViewById(2131365766));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131365768));
    this.j = ((TextView)super.findViewById(2131365767));
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity))) {
      this.j.setOnClickListener((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
    }
    while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity))) {
      return;
    }
    this.j.setOnClickListener((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.jdField_b_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
      for (paramAnyScaleTypeImageView = new ColorDrawable(0);; paramAnyScaleTypeImageView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, paramAnyScaleTypeImageView, paramAnyScaleTypeImageView);
        paramAnyScaleTypeImageView.setAutoDownload(true);
        if (QLog.isColorLevel()) {
          QLog.d("CardContainer", 2, "-->url drawabel status: " + paramAnyScaleTypeImageView.getStatus());
        }
        if (paramAnyScaleTypeImageView.getStatus() != 1) {
          break;
        }
        localAnyScaleTypeImageView.setVisibility(0);
        localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
        return;
      }
    }
    catch (OutOfMemoryError paramAnyScaleTypeImageView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
        }
        paramAnyScaleTypeImageView = null;
        continue;
        localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */