package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;

public class NavBarQQGamePub
  extends NavBarCommon
{
  private static final String jdField_a_of_type_JavaLangString = NavBarQQGamePub.class.getSimpleName();
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d = "";
  
  public NavBarQQGamePub(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public NavBarQQGamePub(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    Object localObject = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(40.0F, getResources());
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
    localObject = new LinearLayout.LayoutParams(AIOUtils.a(30.0F, getResources()), AIOUtils.a(64.0F, getResources()));
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844557);
    localObject = new RelativeLayout.LayoutParams(AIOUtils.a(24.0F, getResources()), AIOUtils.a(24.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846990);
    int i = AIOUtils.a(1.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, i, i, i);
    localObject = new RelativeLayout.LayoutParams(AIOUtils.a(6.0F, getResources()), AIOUtils.a(6.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(16.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(6.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
    localObject = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new NavBarQQGamePub.1(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void b(String paramString)
  {
    if (paramString.startsWith("mqqapi://miniapp/"))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), paramString, 2016, null);
      return;
    }
    Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    getContext().startActivity(localIntent);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
      QLog.e(jdField_a_of_type_JavaLangString, 0, "[getTitleTextView] titleTv is null");
    }
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844557);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      setmBubbleid("");
      setCurType(1);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844557);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130844316);
      localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130844316);
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_JavaLangString = paramString3;
      setCurType(2);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      paramString1 = paramString2;
      if (paramString2.length() > 5)
      {
        paramString1 = paramString2.substring(0, 5);
        paramString1 = paramString1 + "...";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      if (!paramBoolean) {
        break label22;
      }
    }
    label22:
    for (int i = 0;; i = 4)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
      return;
    }
  }
  
  public void setCurType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void setGamePubType(String paramString)
  {
    this.d = paramString;
  }
  
  public void setRightImage2(Drawable paramDrawable) {}
  
  public void setTitle(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131379432);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setmBubbleid(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub
 * JD-Core Version:    0.7.0.1
 */