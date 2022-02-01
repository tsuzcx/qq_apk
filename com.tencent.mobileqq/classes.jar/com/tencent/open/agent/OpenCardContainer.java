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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCardContainer
  extends RelativeLayout
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Handler a;
  protected LayoutInflater a;
  public View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected URLDrawableDownListener.Adapter a;
  public AnyScaleTypeImageView a;
  protected OpenAuthorityAccountView a;
  private OpenCardContainer.OnDeleteVirtualListener jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$OnDeleteVirtualListener = null;
  private OpenCardContainer.UpdateStatusBarListener jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener = null;
  public OpenCardContainer.VirtualAccountAdapter a;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private String jdField_a_of_type_JavaLangString = "";
  protected List<OpenCardContainer.Permission> a;
  public boolean a;
  protected final int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected RelativeLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  protected final int c;
  private View c;
  protected RelativeLayout c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131691558 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130839649 };
    jdField_c_of_type_ArrayOfInt = new int[] { 2131371177 };
  }
  
  public OpenCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new OpenCardContainer.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new OpenCardContainer.2(this);
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
      Object localObject1 = new EmptyDrawable(0, this.jdField_b_of_type_Int, 100);
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
          QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "genGameUrlImg exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
          paramString = localObject3;
        }
      }
      if ((paramString != null) && (paramString.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDK_LOGIN.OpenCardContainer", 2, "-->-->genGameUrlImg: failed");
        }
        paramString.restartDownload();
      }
      if (((paramString == null) || (paramString.getStatus() != 1)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        this.jdField_a_of_type_AndroidOsHandler.post(new OpenCardContainer.8(this, paramString));
      }
      return paramString;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create empty drawable oom.", localOutOfMemoryError);
        }
        localObject2 = null;
      }
    }
  }
  
  private void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SDK_LOGIN.OpenCardContainer", 2, "performAnim height =" + paramInt1 + ", topMargin =" + paramInt2);
    }
    ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 0, paramInt1 });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { 0, paramInt2 });
    localValueAnimator1.addUpdateListener(new OpenCardContainer.6(this, paramImageView));
    localValueAnimator1.addListener(new OpenCardContainer.7(this, paramImageView));
    localValueAnimator1.setDuration(300L);
    localValueAnimator2.setDuration(300L);
    paramImageView = new AnimatorSet();
    paramImageView.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    paramImageView.setDuration(300L);
    paramImageView.start();
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    Object localObject3 = null;
    if (paramImageView == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840452);
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
              QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "setVirtualIcon exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
              paramString = localObject3;
            }
          }
          if (paramString != null)
          {
            paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
            if (paramString.getStatus() == 2) {
              paramString.restartDownload();
            }
            if (paramString.getStatus() != 2)
            {
              paramImageView.setImageDrawable(paramString);
              return;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create color drawable oom.", localOutOfMemoryError);
            }
            localObject2 = null;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getImageError: ");
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 3)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SDK_LOGIN.OpenCardContainer", 2, "displayCoverContainer ");
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      e();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ImmersiveUtils.setStatusTextColor(false, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getWindow());
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK)) && (this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener != null)) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener.a();
    }
    for (;;)
    {
      int i = (int)(this.jdField_b_of_type_Int / 1.307692F);
      int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight();
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView, i, i - j);
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
        ((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext).l();
      } else if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext).h();
      }
    }
  }
  
  public long a()
  {
    if ((OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter) != null) && (OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).size() > 0))
    {
      Iterator localIterator = OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).iterator();
      while (localIterator.hasNext())
      {
        OpenCardContainer.VirtualAccountInfo localVirtualAccountInfo = (OpenCardContainer.VirtualAccountInfo)localIterator.next();
        if (localVirtualAccountInfo.jdField_a_of_type_Boolean) {
          return localVirtualAccountInfo.jdField_a_of_type_Long;
        }
      }
    }
    return 0L;
  }
  
  protected String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
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
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "switchToMode -->mode: " + paramInt + ", mMode=" + this.jdField_a_of_type_Int);
    }
    ThreadManager.executeOnSubThread(new OpenCardContainer.5(this));
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OpenAuthorityActivity", 2, "showAdsInfo adsPic = " + paramBitmap);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OpenAuthorityActivity", 2, "showAdsInfo adsTxt = " + paramString);
    }
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
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, boolean paramBoolean)
  {
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = 0;
      i = 0;
      if (j >= paramString2.length()) {
        break label130;
      }
      if (String.valueOf(paramString2.charAt(j)).getBytes().length <= 1) {
        break label112;
      }
      i += 2;
      label45:
      if (i <= 10) {
        break label121;
      }
    }
    label130:
    for (int i = 1;; i = 0)
    {
      paramString2 = paramString2.substring(0, j);
      if (i != 0) {
        new StringBuilder().append(paramString2).append("...").toString();
      }
      if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView != null)) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.a(paramString1);
      }
      return;
      label112:
      i += 1;
      break label45;
      label121:
      j += 1;
      break;
    }
  }
  
  public boolean a(List<CardContainer.Permission> paramList, String paramString)
  {
    int i = 0;
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
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, "authList isEmpty");
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label336;
      }
    }
    label336:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label342;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
      a(1);
      QLog.d("SDK_LOGIN.OpenCardContainer", 1, "--> has been authority.");
      setAdImageByURL(paramList, a());
      return bool;
      paramList = new StringBuilder(((List)localObject).size() * 128);
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (CardContainer.Permission)paramString.next();
        OpenCardContainer.Permission localPermission = new OpenCardContainer.Permission();
        localPermission.jdField_b_of_type_JavaLangString = ((CardContainer.Permission)localObject).jdField_b_of_type_JavaLangString;
        localPermission.jdField_a_of_type_Int = ((CardContainer.Permission)localObject).jdField_a_of_type_Int;
        localPermission.jdField_b_of_type_Int = ((CardContainer.Permission)localObject).jdField_b_of_type_Int;
        localPermission.jdField_a_of_type_Boolean = ((CardContainer.Permission)localObject).jdField_a_of_type_Boolean;
        localPermission.jdField_a_of_type_JavaLangString = ((CardContainer.Permission)localObject).jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          paramList.append("--> Permission p, api: ").append(localPermission.jdField_b_of_type_JavaLangString).append(" | flag: ").append(localPermission.jdField_a_of_type_Int).append(" | id: ").append(localPermission.jdField_b_of_type_Int).append(" | isNew: ").append(localPermission.jdField_a_of_type_Boolean).append(" | title: ").append(localPermission.jdField_a_of_type_JavaLangString).append("\n");
        }
        this.jdField_a_of_type_JavaUtilList.add(localPermission);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenCardContainer", 2, paramList.toString());
      break;
    }
    label342:
    a(0);
    QLog.d("SDK_LOGIN.OpenCardContainer", 1, "--> has not been authority.");
    paramList = HardCodeUtil.a(2131707837);
    label363:
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramString = (OpenCardContainer.Permission)this.jdField_a_of_type_JavaUtilList.get(i);
      if (i >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label440;
      }
    }
    label440:
    for (paramList = paramList + paramString.jdField_a_of_type_JavaLangString + "、";; paramList = paramList + paramString.jdField_a_of_type_JavaLangString)
    {
      i += 1;
      break label363;
      break;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView != null) {
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.b();
    }
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    try
    {
      e();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenCardContainer", 1, "Exception", localException);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362347));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362348));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView = ((OpenAuthorityAccountView)super.findViewById(2131361929));
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setOnClickListener(new OpenCardContainer.3(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362350));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131367714));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131379520));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379521));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362895));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362897));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362901));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131362894);
    this.jdField_b_of_type_AndroidViewView.setFocusable(true);
    this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
    this.jdField_b_of_type_AndroidViewView.requestFocus();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365463);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131381724);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131381725));
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter = new OpenCardContainer.VirtualAccountAdapter(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOverScrollFlingMode(2);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(new OpenCardContainer.4(this));
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
      paramAnyScaleTypeImageView = new EmptyDrawable(0, this.jdField_b_of_type_Int, 100);
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
          d();
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getStatus SUCCESSED: ");
          }
          localAnyScaleTypeImageView.setVisibility(0);
          if (paramAnyScaleTypeImageView != null) {
            localAnyScaleTypeImageView.setImageDrawable(paramAnyScaleTypeImageView);
          }
          return;
          paramAnyScaleTypeImageView = paramAnyScaleTypeImageView;
          if (QLog.isColorLevel()) {
            QLog.e("SDK_LOGIN.OpenCardContainer", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
          }
          paramAnyScaleTypeImageView = null;
        }
      }
      catch (IllegalArgumentException paramAnyScaleTypeImageView)
      {
        for (;;)
        {
          QLog.e("SDK_LOGIN.OpenCardContainer", 1, new Object[] { "setAdImageByURL exception url=", paramString, ",excption=", paramAnyScaleTypeImageView.toString() });
          paramAnyScaleTypeImageView = localObject;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.OpenCardContainer", 2, "getStatus OTHERS: ");
          }
          localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
        }
      }
    }
  }
  
  public void setCreateVirtualListner(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setCurrentAppid(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnAccountEventListener(OpenCardContainer.AccountEventListener paramAccountEventListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setAccountEventListener(paramAccountEventListener);
  }
  
  public void setOnUpdateStatusBarListener(OpenCardContainer.UpdateStatusBarListener paramUpdateStatusBarListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$UpdateStatusBarListener = paramUpdateStatusBarListener;
  }
  
  public void setOndeleteVirtualListener(OpenCardContainer.OnDeleteVirtualListener paramOnDeleteVirtualListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$OnDeleteVirtualListener = paramOnDeleteVirtualListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer
 * JD-Core Version:    0.7.0.1
 */