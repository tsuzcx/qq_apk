package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.AuthItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public class CardContainer
  extends BaseCardContainer
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected AuthorityAccountView a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public List<Permission> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a()
  {
    SSOLog.b("CardContainer", new Object[] { "displayCoverContainer" });
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
        ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).getWindow());
      }
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
        ((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext).a();
      } else if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext).h();
      }
      int i = (int)(this.jdField_a_of_type_Int / 1.307692F);
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
      a(this.jdField_a_of_type_ComTencentImageURLImageView, i, i - j, new CardContainer.1(this));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToMode -->mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mMode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    SSOLog.a("CardContainer", new Object[] { localStringBuilder.toString() });
    a(paramString);
    if (paramInt == this.jdField_b_of_type_Int) {
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    } else if (paramInt == 1) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showAppInfo appName = ");
    ((StringBuilder)localObject).append(paramString);
    SSOLog.b("CardContainer", ((StringBuilder)localObject).toString());
    setVisibility(0);
    if ((!TextUtils.isEmpty(paramString)) && (getTag() != null))
    {
      localObject = (TextView)findViewById(2131362302);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701661));
      localStringBuilder.append(paramString);
      localStringBuilder.append(HardCodeUtil.a(2131701660));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    localObject = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
    if (localObject != null) {
      ((AuthorityAccountView)localObject).setAppInfo(paramString, paramBitmap);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      int j = 0;
      int i = 0;
      while (j < paramString2.length())
      {
        if (String.valueOf(paramString2.charAt(j)).getBytes().length > 1) {
          i += 2;
        } else {
          i += 1;
        }
        if (i > 10)
        {
          i = 1;
          break label79;
        }
        j += 1;
      }
      i = 0;
      label79:
      Object localObject2 = paramString2.substring(0, j);
      Object localObject1 = localObject2;
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("...");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-->showUserInfo() set nickname ellipsis=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",nick=");
      ((StringBuilder)localObject2).append(paramString2);
      SSOLog.b("CardContainer", ((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = String.format(super.getContext().getString(2131689811), new Object[] { paramString1 });
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.d.setText(paramString2);
      if (this.e.getVisibility() == 0) {
        this.e.setVisibility(8);
      }
    }
    if (paramBitmap != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
      if (paramString2 != null) {
        paramString2.a(paramString1);
      }
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = paramGetAuthApiListResponse.authorized_form_list.get();
    paramGetAuthApiListResponse = new StringBuilder(((List)localObject).size() * 128);
    localObject = ((List)localObject).iterator();
    boolean bool1;
    int i;
    for (;;)
    {
      boolean bool2 = ((Iterator)localObject).hasNext();
      bool1 = true;
      i = 0;
      if (!bool2) {
        break;
      }
      appType.AuthItem localAuthItem = (appType.AuthItem)((Iterator)localObject).next();
      if (localAuthItem.is_new.get() != 0)
      {
        Permission localPermission = new Permission();
        localPermission.jdField_b_of_type_JavaLangString = localAuthItem.api_list.get();
        localPermission.jdField_a_of_type_Int = localAuthItem.default_flag.get();
        localPermission.jdField_b_of_type_Int = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {
          bool1 = false;
        }
        localPermission.jdField_a_of_type_Boolean = bool1;
        localPermission.jdField_a_of_type_JavaLangString = localAuthItem.title.get();
        paramGetAuthApiListResponse.append(localPermission.toString());
        paramGetAuthApiListResponse.append("\n");
        this.jdField_a_of_type_JavaUtilList.add(localPermission);
      }
    }
    SSOLog.a("CardContainer", new Object[] { paramGetAuthApiListResponse.toString() });
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      paramGetAuthApiListResponse = this.jdField_a_of_type_ComTencentImageURLImageView;
      a(1, paramString);
      this.e.setVisibility(0);
      SSOLog.a("CardContainer", new Object[] { "--> has been authority." });
      a(paramGetAuthApiListResponse, a(paramString));
      return bool1;
    }
    a(0, paramString);
    SSOLog.a("CardContainer", new Object[] { "--> has not been authority." });
    paramGetAuthApiListResponse = "";
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramString = (Permission)this.jdField_a_of_type_JavaUtilList.get(i);
      if (getTag() != null)
      {
        paramString = new StringBuilder();
        paramString.append(paramGetAuthApiListResponse);
        paramString.append("· 获得你与QQ通讯录绑定的电话号码");
        paramGetAuthApiListResponse = paramString.toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramGetAuthApiListResponse);
        ((StringBuilder)localObject).append("· ");
        ((StringBuilder)localObject).append(paramString.jdField_a_of_type_JavaLangString);
        paramGetAuthApiListResponse = ((StringBuilder)localObject).toString();
      }
      paramString = new StringBuilder();
      paramString.append(paramGetAuthApiListResponse);
      paramString.append("\n");
      paramGetAuthApiListResponse = paramString.toString();
      i += 1;
    }
    this.f.setText(paramGetAuthApiListResponse);
    return bool1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView.a();
  }
  
  public void c()
  {
    AuthorityAccountView localAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.c();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362300));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362304));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362306));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362301));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362305));
    this.d = ((TextView)super.findViewById(2131362307));
    this.e = ((TextView)super.findViewById(2131362303));
    this.e.setVisibility(8);
    this.f = ((TextView)super.findViewById(2131372132));
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView = ((AuthorityAccountView)super.findViewById(2131361935));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131363055));
    FixedBounceScrollView localFixedBounceScrollView = (FixedBounceScrollView)super.findViewById(2131363068);
    localFixedBounceScrollView.setMaxHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 102.0F));
    localFixedBounceScrollView.setNeedDisallowIntercept(true);
  }
  
  public void setAppType(String paramString)
  {
    AuthorityAccountView localAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setAppType(paramString);
    }
  }
  
  public void setChangeAccountListener(AuthorityAccountView.IChangeAccountListener paramIChangeAccountListener)
  {
    AuthorityAccountView localAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setChangeAccountListener(paramIChangeAccountListener);
    }
  }
  
  public void setDeleteLastAccountListener(AuthorityAccountView.IDeleteLastAccountListener paramIDeleteLastAccountListener)
  {
    AuthorityAccountView localAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setDeleteLastAccountListener(paramIDeleteLastAccountListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */