package com.tencent.open.agent;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbvt;
import bbvu;
import bbvv;
import bbvw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CardHeadLayout
  extends RelativeLayout
{
  protected int a;
  protected Context a;
  public Drawable a;
  protected Handler a;
  protected LayoutInflater a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected URLDrawableDownListener.Adapter a;
  public AnyScaleTypeImageView a;
  protected List<Object> a;
  private boolean a;
  protected final int b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  protected final int c;
  protected RelativeLayout c;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  
  public CardHeadLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new bbvt(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bbvu(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    new DisplayMetrics();
    paramAttributeSet = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Int = paramAttributeSet.widthPixels;
    this.jdField_c_of_type_Int = paramAttributeSet.heightPixels;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardHeadLayout", 2, "displayCoverContainer ");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      int i = (int)(this.jdField_b_of_type_Int / 1.307692F);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView, i);
    }
  }
  
  private void a(ImageView paramImageView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CardHeadLayout", 2, "performAnim height =" + paramInt);
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, paramInt });
    localValueAnimator.addUpdateListener(new bbvv(this, paramImageView));
    localValueAnimator.addListener(new bbvw(this, paramImageView));
    localValueAnimator.setDuration(300L);
    localValueAnimator.start();
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
      QLog.d("CardHeadLayout", 2, "--> result: " + (String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296664));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296665));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296656));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296660));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296662));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131296657));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296661));
    this.d = ((TextView)super.findViewById(2131296663));
    this.e = ((TextView)super.findViewById(2131296659));
    this.e.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296667));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)super.findViewById(2131301306));
  }
  
  public void setAdImageByURL(AnyScaleTypeImageView paramAnyScaleTypeImageView, String paramString)
  {
    AnyScaleTypeImageView localAnyScaleTypeImageView = paramAnyScaleTypeImageView;
    if (paramAnyScaleTypeImageView == null) {
      localAnyScaleTypeImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {}
      for (paramAnyScaleTypeImageView = new ColorDrawable(0);; paramAnyScaleTypeImageView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        paramAnyScaleTypeImageView = URLDrawable.getDrawable(paramString, paramAnyScaleTypeImageView, paramAnyScaleTypeImageView);
        paramAnyScaleTypeImageView.setAutoDownload(true);
        if (QLog.isColorLevel()) {
          QLog.d("CardHeadLayout", 2, "-->url drawabel status: " + paramAnyScaleTypeImageView.getStatus() + ", adUrl =" + paramString);
        }
        if (paramAnyScaleTypeImageView.getStatus() != 1) {
          break;
        }
        a();
        if (QLog.isColorLevel()) {
          QLog.d("CardHeadLayout", 2, "getStatus SUCCESSED: ");
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
          QLog.e("CardHeadLayout", 2, "-->create color drawable oom.", paramAnyScaleTypeImageView);
        }
        paramAnyScaleTypeImageView = null;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("CardHeadLayout", 2, "getStatus OTHERS: ");
        }
        localAnyScaleTypeImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CardHeadLayout
 * JD-Core Version:    0.7.0.1
 */