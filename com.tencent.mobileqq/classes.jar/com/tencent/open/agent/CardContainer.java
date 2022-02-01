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
  protected AuthorityAccountView k;
  private ImageView l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  private RelativeLayout s;
  private TextView t;
  
  public CardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a()
  {
    SSOLog.b("CardContainer", new Object[] { "displayCoverContainer" });
    if (!this.d)
    {
      this.d = true;
      this.g.setVisibility(0);
      if ((this.a instanceof QBaseActivity)) {
        ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity)this.a).getWindow());
      }
      if ((this.a instanceof AuthorityActivity)) {
        ((AuthorityActivity)this.a).a();
      } else if ((this.a instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.a).i();
      }
      int i = (int)(this.b / 1.307692F);
      int j = this.f.getHeight();
      a(this.h, i, i - j, new CardContainer.1(this));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToMode -->mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mMode=");
    localStringBuilder.append(this.e);
    SSOLog.a("CardContainer", new Object[] { localStringBuilder.toString() });
    b(paramString);
    if (paramInt == this.e) {
      return;
    }
    if (paramInt == 0) {
      this.s.setVisibility(0);
    } else if (paramInt == 1) {
      this.s.setVisibility(8);
    }
    this.e = paramInt;
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
      localObject = (TextView)findViewById(2131427901);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899683));
      localStringBuilder.append(paramString);
      localStringBuilder.append(HardCodeUtil.a(2131899682));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    localObject = this.k;
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
      this.n.setText((CharSequence)localObject1);
      this.o.setText((CharSequence)localObject1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = String.format(super.getContext().getString(2131886452), new Object[] { paramString1 });
      this.p.setText(paramString2);
      this.q.setText(paramString2);
      if (this.r.getVisibility() == 0) {
        this.r.setVisibility(8);
      }
    }
    if (paramBitmap != null)
    {
      this.l.setImageBitmap(paramBitmap);
      this.m.setImageBitmap(paramBitmap);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = this.k;
      if (paramString2 != null) {
        paramString2.a(paramString1);
      }
    }
  }
  
  public boolean a(SdkAuthorize.GetAuthApiListResponse paramGetAuthApiListResponse, String paramString)
  {
    this.c.clear();
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
        localPermission.d = localAuthItem.api_list.get();
        localPermission.a = localAuthItem.default_flag.get();
        localPermission.e = localAuthItem.id.get();
        if (localAuthItem.is_new.get() == 0) {
          bool1 = false;
        }
        localPermission.c = bool1;
        localPermission.b = localAuthItem.title.get();
        paramGetAuthApiListResponse.append(localPermission.toString());
        paramGetAuthApiListResponse.append("\n");
        this.c.add(localPermission);
      }
    }
    SSOLog.a("CardContainer", new Object[] { paramGetAuthApiListResponse.toString() });
    if (this.c.size() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      paramGetAuthApiListResponse = this.h;
      a(1, paramString);
      this.r.setVisibility(0);
      SSOLog.a("CardContainer", new Object[] { "--> has been authority." });
      a(paramGetAuthApiListResponse, a(paramString));
      return bool1;
    }
    a(0, paramString);
    SSOLog.a("CardContainer", new Object[] { "--> has not been authority." });
    paramGetAuthApiListResponse = "";
    while (i < this.c.size())
    {
      paramString = (Permission)this.c.get(i);
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
        ((StringBuilder)localObject).append(paramString.b);
        paramGetAuthApiListResponse = ((StringBuilder)localObject).toString();
      }
      paramString = new StringBuilder();
      paramString.append(paramGetAuthApiListResponse);
      paramString.append("\n");
      paramGetAuthApiListResponse = paramString.toString();
      i += 1;
    }
    this.t.setText(paramGetAuthApiListResponse);
    return bool1;
  }
  
  public void b()
  {
    this.k.a();
  }
  
  public void c()
  {
    AuthorityAccountView localAuthorityAccountView = this.k;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.f();
    }
  }
  
  public List<Permission> getAuthList()
  {
    return this.c;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.l = ((ImageView)super.findViewById(2131427899));
    this.n = ((TextView)super.findViewById(2131427903));
    this.p = ((TextView)super.findViewById(2131427905));
    this.m = ((ImageView)super.findViewById(2131427900));
    this.o = ((TextView)super.findViewById(2131427904));
    this.q = ((TextView)super.findViewById(2131427906));
    this.r = ((TextView)super.findViewById(2131427902));
    this.r.setVisibility(8);
    this.t = ((TextView)super.findViewById(2131439604));
    this.k = ((AuthorityAccountView)super.findViewById(2131427489));
    this.s = ((RelativeLayout)super.findViewById(2131428888));
    FixedBounceScrollView localFixedBounceScrollView = (FixedBounceScrollView)super.findViewById(2131428903);
    localFixedBounceScrollView.setMaxHeight(DisplayUtil.a(this.a, 102.0F));
    localFixedBounceScrollView.setNeedDisallowIntercept(true);
  }
  
  public void setAppType(String paramString)
  {
    AuthorityAccountView localAuthorityAccountView = this.k;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setAppType(paramString);
    }
  }
  
  public void setChangeAccountListener(AuthorityAccountView.IChangeAccountListener paramIChangeAccountListener)
  {
    AuthorityAccountView localAuthorityAccountView = this.k;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setChangeAccountListener(paramIChangeAccountListener);
    }
  }
  
  public void setDeleteLastAccountListener(AuthorityAccountView.IDeleteLastAccountListener paramIDeleteLastAccountListener)
  {
    AuthorityAccountView localAuthorityAccountView = this.k;
    if (localAuthorityAccountView != null) {
      localAuthorityAccountView.setDeleteLastAccountListener(paramIDeleteLastAccountListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer
 * JD-Core Version:    0.7.0.1
 */