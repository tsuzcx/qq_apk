package com.tencent.mobileqq.together.clockin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder;
import com.tencent.mobileqq.util.QQAvatarFHDDecoder.OnQQAvatarFHDListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

public class NoClockInView
  extends ClockView
  implements View.OnClickListener, QQAvatarFHDDecoder.OnQQAvatarFHDListener, Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ClockInCallback jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback;
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  private Rotate3dAnimation jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = null;
  private QQAvatarFHDDecoder jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder;
  boolean jdField_a_of_type_Boolean = false;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundRectUrlImageView jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private RoundRectUrlImageView jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  
  public NoClockInView(Context paramContext, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, ClockInData paramClockInData, ClockInCallback paramClockInCallback, ClockAnimController paramClockAnimController)
  {
    super(paramClockAnimController);
    if (paramClockAnimController != null) {
      paramClockAnimController.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData = paramClockInData;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback = paramClockInCallback;
    c();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720081);
    case 2: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720075);
    case 3: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720076);
    case 4: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720077);
    case 5: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720078);
    case 6: 
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720079);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131720080);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView != null) && (this.jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.d != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.e != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.f != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.g != null) && (this.jdField_a_of_type_AndroidWidgetButton != null);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      if (QLog.isColorLevel()) {
        QLog.d("NoClockInView", 2, "init failed");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561456, null));
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363573));
    this.jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363580));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363587));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365560));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365569));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365576));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364811));
    this.d = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364812));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364814);
    this.e = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364813));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367013));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368303));
    this.f = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367012));
    this.g = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367011));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364805));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(2131364805));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    d();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NoClockInView", 2, "updateUI");
    }
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("NoClockInView", 2, "checkData true" + this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.toString());
      }
      e();
      f();
      g();
    }
  }
  
  private void e()
  {
    if (b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder = new QQAvatarFHDDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
      this.jdField_a_of_type_ComTencentMobileqqUtilQQAvatarFHDDecoder.a(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b, false, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e))
      {
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.e, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(8);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(8);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(8);
    }
  }
  
  private void f()
  {
    if (b())
    {
      Object localObject = ImageUtil.c();
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b, 4, (Drawable)localObject, (Drawable)localObject);
      Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable)) && (localDrawable != localObject)) {
        ((FaceDrawable)localDrawable).cancel();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.c)) {
        this.f.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.c);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.d)) {
        this.g.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.d);
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void g()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(2) + 1;
    int j = localCalendar.get(5);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (j < 10)
    {
      str = "0" + j;
      localTextView.setText(str);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (i >= 10) {
        break label203;
      }
    }
    label203:
    for (String str = "0" + i;; str = "" + i)
    {
      localTextView.setText(str);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(localCalendar.get(7)));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.h)) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.h);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g))) {
        break label226;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      str = "" + j;
      break;
    }
    label226:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f)) {
        break label351;
      }
      this.d.setVisibility(0);
      this.d.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.f);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g)) {
        break label363;
      }
      this.e.setVisibility(0);
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.g);
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      label351:
      this.d.setVisibility(8);
    }
    label363:
    this.e.setVisibility(8);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInCallback.a();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation == null)
    {
      float f1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2.0F;
      float f2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2.0F;
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = new Rotate3dAnimation(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density, 0.0F, -90.0F, f1, f2, 0.0F, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setDuration(200L);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setFillAfter(true);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setAnimationListener(new NoClockInView.2(this));
    if (QLog.isColorLevel()) {
      QLog.d("NoClockInView", 2, "startRotateAnim");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation);
  }
  
  public void a(String paramString, boolean paramBoolean, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NoClockInView", 2, "onGetQQAvatarFHD isSuc" + paramBoolean + " ,uin = " + paramString);
    }
    if ((paramBoolean) && (paramDrawable != null)) {
      ThreadManager.post(new NoClockInView.1(this, paramDrawable), 8, null, true);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setAnimationListener(null);
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.cancel();
      this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (((Integer)paramView.getTag()).intValue())
      {
      default: 
        break;
      case 2131364805: 
        h();
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {}
    while ((((Integer)paramObject).intValue() != 1) || (this.jdField_a_of_type_Boolean)) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.NoClockInView
 * JD-Core Version:    0.7.0.1
 */