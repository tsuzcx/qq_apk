package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qroute.QRoute;

public class GamePubNav
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CornerImageView jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString;
  
  public GamePubNav(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public GamePubNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public GamePubNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      QQGameHelper.b(paramString);
      return;
    }
    if (paramString.startsWith("mqqapi://miniapp/"))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getContext(), paramString, 2016, null);
      return;
    }
    Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    getContext().startActivity(localIntent);
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131561749, this);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)findViewById(2131368924));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380378));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368898));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368834));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368925));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368966));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368953));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370117));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370092));
    a();
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new GamePubNav.1(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new GamePubNav.2(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    this.jdField_b_of_type_Int = paramInt2;
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mFailedDrawable = getResources().getDrawable(2130844316);
    paramString2.mLoadingDrawable = getResources().getDrawable(2130844316);
    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramString1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new GamePubNav.3(this, paramString3, paramString4));
    ThreadManagerV2.getUIHandlerV2().postDelayed(new GamePubNav.4(this, paramString4), paramInt1 * 1000);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < this.jdField_b_of_type_Int * 1000)) {
      return;
    }
    a();
    d();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.animate().alpha(0.0F).setDuration(500L).setListener(new GamePubNav.5(this)).start();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i = 0;
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramBoolean)
    {
      ((TextView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break label112;
      }
    }
    label112:
    for (localObject = "1";; localObject = "2")
    {
      QQGameHelper.b(QQGameHelper.b()).g("770").e("1").f("160").d("77002").c("207021").a(2, paramString).a(3, (String)localObject).a(4, "8").h(this.jdField_c_of_type_JavaLangString).b(this.jdField_d_of_type_JavaLangString).a();
      return;
      i = 4;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0;
  }
  
  public void setBubbleId(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setBubbleJumpUrl(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setGameAppid(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void setMoreClick(View.OnClickListener paramOnClickListener)
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setReturnClick(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setTabGrayid(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setUrlType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GamePubNav
 * JD-Core Version:    0.7.0.1
 */