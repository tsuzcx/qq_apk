package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCardContainer
  extends BaseCardContainer
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691479 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839507 };
  private static final int[] c = { 2131370801 };
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected OpenAuthorityAccountView a;
  private OpenCardContainer.UpdateStatusBarListener jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener;
  public OpenCardContainer.VirtualAccountAdapter a;
  private INewAuthorityContract.Presenter jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public OpenCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject = null;
    URLDrawable localURLDrawable;
    try
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840321);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SSOLog.c("OpenCardContainer", "-->create color drawable oom.", localOutOfMemoryError);
      localURLDrawable = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localURLDrawable;
    localURLDrawableOptions.mFailedDrawable = localURLDrawable;
    try
    {
      localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString = localURLDrawable;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SSOLog.b("OpenCardContainer", new Object[] { "setVirtualIcon exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
      paramString = localObject;
    }
    if (paramString != null)
    {
      paramString.setDecodeHandler(QQLiteStatusUtil.a());
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      if (paramString.getStatus() != 2)
      {
        paramImageView.setImageDrawable(paramString);
        return;
      }
      SSOLog.a("OpenCardContainer", new Object[] { "getImageError: " });
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof QBaseActivity)) {
      ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity)this.jdField_a_of_type_AndroidContentContext).getWindow());
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK))
    {
      OpenCardContainer.UpdateStatusBarListener localUpdateStatusBarListener = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener;
      if (localUpdateStatusBarListener != null)
      {
        localUpdateStatusBarListener.a();
        break label104;
      }
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
      ((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext).a();
    } else if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
      ((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext).h();
    }
    label104:
    int i = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels * 0.6426666F);
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
    a(this.jdField_a_of_type_ComTencentImageURLImageView, i, i - j, null);
  }
  
  public long a()
  {
    if ((OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter) != null) && (OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).size() > 0))
    {
      Iterator localIterator = OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).iterator();
      while (localIterator.hasNext())
      {
        VirtualAccountInfo localVirtualAccountInfo = (VirtualAccountInfo)localIterator.next();
        if (localVirtualAccountInfo.jdField_a_of_type_Boolean) {
          return localVirtualAccountInfo.jdField_a_of_type_Long;
        }
      }
    }
    return 0L;
  }
  
  protected void a()
  {
    SSOLog.b("OpenCardContainer", new Object[] { "displayCoverContainer " });
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      d();
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToMode -->mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mMode=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    SSOLog.a("OpenCardContainer", new Object[] { localStringBuilder.toString() });
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramBitmap != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public boolean a(List<Permission> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (((List)localObject).isEmpty())
    {
      SSOLog.a("OpenCardContainer", new Object[] { "authList isEmpty" });
    }
    else
    {
      paramList = new StringBuilder(((List)localObject).size() * 128);
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (Permission)paramString.next();
        Permission localPermission = new Permission();
        localPermission.jdField_b_of_type_JavaLangString = ((Permission)localObject).jdField_b_of_type_JavaLangString;
        localPermission.jdField_a_of_type_Int = ((Permission)localObject).jdField_a_of_type_Int;
        localPermission.jdField_b_of_type_Int = ((Permission)localObject).jdField_b_of_type_Int;
        localPermission.jdField_a_of_type_Boolean = ((Permission)localObject).jdField_a_of_type_Boolean;
        localPermission.jdField_a_of_type_JavaLangString = ((Permission)localObject).jdField_a_of_type_JavaLangString;
        paramList.append(localPermission.toString());
        paramList.append("\n");
        this.jdField_a_of_type_JavaUtilList.add(localPermission);
      }
      SSOLog.a("OpenCardContainer", new Object[] { paramList.toString() });
    }
    boolean bool;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramList = this.jdField_a_of_type_ComTencentImageURLImageView;
      a(1);
      SSOLog.a("OpenCardContainer", new Object[] { "--> has been authority." });
      a(paramList, a(this.jdField_a_of_type_JavaLangString));
      return bool;
    }
    a(0);
    SSOLog.a("OpenCardContainer", new Object[] { "--> has not been authority." });
    return bool;
  }
  
  public void b()
  {
    OpenAuthorityAccountView localOpenAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView;
    if (localOpenAuthorityAccountView != null) {
      localOpenAuthorityAccountView.c();
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      OpenAuthorityAccountView localOpenAuthorityAccountView = this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView;
      if (localOpenAuthorityAccountView != null) {
        localOpenAuthorityAccountView.a(paramString);
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      d();
      return;
    }
    catch (Exception localException)
    {
      SSOLog.c("OpenCardContainer", "Exception", localException);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFinishInflate ");
    ((StringBuilder)localObject).append(Log.getStackTraceString(new Throwable()));
    SSOLog.a("OpenCardContainer", new Object[] { ((StringBuilder)localObject).toString() });
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView = ((OpenAuthorityAccountView)super.findViewById(2131361935));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setOnClickListener(new OpenCardContainer.1(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362847));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362849));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362853));
    localObject = super.findViewById(2131362846);
    ((View)localObject).setFocusable(true);
    ((View)localObject).setFocusableInTouchMode(true);
    ((View)localObject).requestFocus();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365326);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131380956);
    localObject = (SwipListView)super.findViewById(2131380957);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter = new OpenCardContainer.VirtualAccountAdapter(this, this.jdField_a_of_type_AndroidContentContext);
    ((SwipListView)localObject).setAdapter(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter);
    ((SwipListView)localObject).setDragEnable(true);
    ((SwipListView)localObject).setOverScrollFlingMode(2);
    ((SwipListView)localObject).setOnItemClickListener(new OpenCardContainer.2(this));
  }
  
  public void setCurrentAppId(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnUpdateStatusBarListener(OpenCardContainer.UpdateStatusBarListener paramUpdateStatusBarListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener = paramUpdateStatusBarListener;
  }
  
  public void setPresenter(INewAuthorityContract.Presenter paramPresenter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPresenter ");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    SSOLog.a("OpenCardContainer", new Object[] { localStringBuilder.toString() });
    this.jdField_a_of_type_ComTencentOpenAgentAuthINewAuthorityContract$Presenter = paramPresenter;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new OpenCardContainer.3(this));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setAccountEventListener(new OpenCardContainer.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer
 * JD-Core Version:    0.7.0.1
 */