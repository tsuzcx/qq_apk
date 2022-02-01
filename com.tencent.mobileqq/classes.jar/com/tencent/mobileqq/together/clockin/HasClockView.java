package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class HasClockView
  extends ClockView
  implements Observer
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TickerView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  private Rotate3dAnimation jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation;
  private RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView;
  Runnable jdField_a_of_type_JavaLangRunnable = new HasClockView.2(this);
  private List<HasClockView.RotateData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TickerView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TickerView jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
  private int d = 0;
  
  public HasClockView(Context paramContext, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, ClockInData paramClockInData, ClockInCallback paramClockInCallback, ClockAnimController paramClockAnimController)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData = paramClockInData;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new HasClockView.RotateData(this, 90.0F, -10.0F, 300));
    this.jdField_a_of_type_JavaUtilList.add(new HasClockView.RotateData(this, -10.0F, 15.0F, 300));
    this.jdField_a_of_type_JavaUtilList.add(new HasClockView.RotateData(this, 15.0F, 0.0F, 250));
    c();
  }
  
  private String a(int paramInt)
  {
    if (paramInt < 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void a(float paramFloat)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if ((localImageView != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      localImageView.setAlpha(paramFloat);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(paramFloat);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView != null) && (this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      if ((localContext != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(localContext).inflate(2131561298, null));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView = ((RoundRectUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363496));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380318));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362667));
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378704));
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378707));
        this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378712));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364698));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364695));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364696));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364694));
        d();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HasClockView", 2, "create arg error");
    }
  }
  
  private void d()
  {
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "updateUI checkData error");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI data:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.toString());
      QLog.d("HasClockView", 2, localStringBuilder.toString());
    }
    e();
    f();
    h();
    g();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRoundRectUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    Object localObject1 = ImageUtil.e();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject1 = FaceDrawable.getFaceDrawable((AppInterface)localObject2, 1, ((QQAppInterface)localObject2).getCurrentUin(), 4, (Drawable)localObject1, (Drawable)localObject1);
    localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof FaceDrawable)) && (localObject2 != localObject1)) {
      ((FaceDrawable)localObject2).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
  }
  
  private void g()
  {
    Object localObject = Calendar.getInstance();
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "updateTimeUI : selfClockTime == 0");
      }
      return;
    }
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_Long * 1000L);
    this.jdField_b_of_type_Int = ((Calendar)localObject).get(11);
    this.jdField_c_of_type_Int = ((Calendar)localObject).get(12);
    this.d = ((Calendar)localObject).get(13);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b) {
      i = a(this.jdField_b_of_type_Int, 24);
    } else {
      i = this.jdField_b_of_type_Int;
    }
    localObject = a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b) {
      i = a(this.jdField_c_of_type_Int, 60);
    } else {
      i = this.jdField_c_of_type_Int;
    }
    String str1 = a(i);
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b) {
      i = a(this.d, 60);
    } else {
      i = this.d;
    }
    String str2 = a(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCustomCharacterList(a(this.jdField_b_of_type_Int, 24));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText((String)localObject, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDuration(1000L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setGravity(17);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCustomCharacterList(a(this.jdField_c_of_type_Int, 60));
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(str1, false);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDuration(1000L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDelay(30L);
    this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setGravity(17);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setCustomCharacterList(a(this.d, 60));
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(str2, false);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDuration(1000L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setAnimationDelay(60L);
    this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setGravity(17);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new HasClockView.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.i);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850795);
    this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(Color.parseColor("#FFFFFF"));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k);
  }
  
  private void i()
  {
    TickerView localTickerView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView;
    if ((localTickerView != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView != null) && (this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView != null) && (this.jdField_b_of_type_Int != 0) && (this.jdField_c_of_type_Int != 0) && (this.d != 0))
    {
      localTickerView.setPreferredScrollingDirection(2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(a(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setPreferredScrollingDirection(2);
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(a(this.jdField_c_of_type_Int));
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setPreferredScrollingDirection(2);
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setText(a(this.d));
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerView.setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HasClockView", 2, "smoothUpdateTime error");
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return;
      }
      b(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = new Rotate3dAnimation();
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setFillAfter(true);
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setAnimationListener(new HasClockView.3(this));
      }
      HasClockView.RotateData localRotateData = (HasClockView.RotateData)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
      if (localRotateData != null)
      {
        float f1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2.0F;
        float f2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2.0F;
        float f3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setInterpolator(new LinearInterpolator());
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.a(f3, localRotateData.jdField_a_of_type_Float, localRotateData.b, f1, f2, 0.0F, true);
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setDuration(localRotateData.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation);
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 8) % paramInt2 + 1;
  }
  
  public ArrayList<String> a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, paramInt2);
    ArrayList localArrayList = new ArrayList();
    String str = a(i);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(str.substring(0, 1));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(str.substring(1, 2));
    str = ((StringBuilder)localObject2).toString();
    paramInt1 = 0;
    while (paramInt1 < 7)
    {
      i = (i + 1) % paramInt2;
      localObject2 = a(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(((String)localObject2).substring(0, 1));
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(((String)localObject2).substring(1, 2));
      str = localStringBuilder.toString();
      paramInt1 += 1;
    }
    localArrayList.add(localObject1);
    localArrayList.add(str);
    return localArrayList;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ClockInData)localObject1).l)))
    {
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("op_via", "2");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((QQAppInterface)localObject2).getCurrentAccountUin()))) {
      ((HashMap)localObject1).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
    if ((localObject2 != null) && (!TextUtils.isEmpty(((ClockInData)localObject2).jdField_a_of_type_JavaLangString))) {
      ((HashMap)localObject1).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject1);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation;
    if (localObject != null)
    {
      ((Rotate3dAnimation)localObject).setAnimationListener(null);
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.cancel();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  public void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {
      return;
    }
    paramObservable = (Integer)paramObject;
    if (paramObservable.intValue() == 2)
    {
      d();
      j();
      return;
    }
    if (paramObservable.intValue() == 3)
    {
      paramObservable = this.jdField_a_of_type_AndroidOsHandler;
      if (paramObservable != null)
      {
        paramObject = this.jdField_a_of_type_JavaLangRunnable;
        if (paramObject != null) {
          paramObservable.post(paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView
 * JD-Core Version:    0.7.0.1
 */