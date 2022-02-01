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
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
  private TickerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  private RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ClockInData jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData;
  private Rotate3dAnimation jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation;
  Runnable jdField_a_of_type_JavaLangRunnable = new HasClockView.2(this);
  private List<HasClockView.RotateData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TickerView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TickerView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView;
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
    if (paramInt < 10) {
      return "0" + paramInt;
    }
    return "" + paramInt;
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
      this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(paramFloat);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(paramFloat);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_c_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "create arg error");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561455, null));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363573));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131381053));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362710));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379354));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379357));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView = ((TickerView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379362));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364810));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364807));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364808));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364806));
    d();
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
    if (QLog.isColorLevel()) {
      QLog.d("HasClockView", 2, "updateUI data:" + this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.toString());
    }
    e();
    f();
    h();
    g();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.b(16.0F));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n))
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.n, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    Object localObject = ImageUtil.c();
    localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 4, (Drawable)localObject, (Drawable)localObject);
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof FaceDrawable)) && (localDrawable != localObject)) {
      ((FaceDrawable)localDrawable).cancel();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
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
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b)
    {
      localObject = a(a(this.jdField_b_of_type_Int, 24));
      if (!this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b) {
        break label371;
      }
      str1 = a(a(this.jdField_c_of_type_Int, 60));
      label127:
      if (!this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.b) {
        break label383;
      }
    }
    label371:
    label383:
    for (String str2 = a(a(this.d, 60));; str2 = a(this.d))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCustomCharacterList(a(this.jdField_b_of_type_Int, 24));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText((String)localObject, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setGravity(17);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCustomCharacterList(a(this.jdField_c_of_type_Int, 60));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(str1, false);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDelay(30L);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setGravity(17);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCharacterLists(new String[] { "1234567890" });
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setCustomCharacterList(a(this.d, 60));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(str2, false);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDuration(1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setAnimationDelay(60L);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setGravity(17);
      return;
      localObject = a(this.jdField_b_of_type_Int);
      break;
      str1 = a(this.jdField_c_of_type_Int);
      break label127;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new HasClockView.1(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.j);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.i);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850858);
    this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(Color.parseColor("#FFFFFF"));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.k);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView == null) || (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView == null) || (this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0) || (this.d == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HasClockView", 2, "smoothUpdateTime error");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setPreferredScrollingDirection(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(a(this.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setPreferredScrollingDirection(2);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(a(this.jdField_c_of_type_Int));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setVisibility(0);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setPreferredScrollingDirection(2);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setDigitalAnimWidthSpeedIncrement(false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setIgnoreWidthAnim(true);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setText(a(this.d));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTickerTickerView.setVisibility(0);
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    HasClockView.RotateData localRotateData;
    do
    {
      do
      {
        return;
        b(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringToFront();
      } while (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation = new Rotate3dAnimation();
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setFillAfter(true);
        this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setAnimationListener(new HasClockView.3(this));
      }
      localRotateData = (HasClockView.RotateData)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    } while (localRotateData == null);
    float f1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth() / 2.0F;
    float f2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() / 2.0F;
    float f3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.a(f3, localRotateData.jdField_a_of_type_Float, localRotateData.b, f1, f2, 0.0F, true);
    this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation.setDuration(localRotateData.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinRotate3dAnimation);
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 8) % paramInt2 + 1;
  }
  
  public ArrayList<String> a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, paramInt2);
    ArrayList localArrayList = new ArrayList();
    String str1 = a(i);
    String str2 = "" + str1.substring(0, 1);
    str1 = "" + str1.substring(1, 2);
    paramInt1 = 0;
    while (paramInt1 < 7)
    {
      i = (i + 1) % paramInt2;
      String str3 = a(i);
      str2 = str2 + str3.substring(0, 1);
      str1 = str1 + str3.substring(1, 2);
      paramInt1 += 1;
    }
    localArrayList.add(str2);
    localArrayList.add(str1);
    return localArrayList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l)))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.l);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("op_via", "2");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      ((HashMap)localObject).put("A8", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString))) {
      ((HashMap)localObject).put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqTogetherClockinClockInData.jdField_a_of_type_JavaLangString);
    }
    ClockReportUtil.a("click#aio_front_panel", (HashMap)localObject);
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
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {}
    do
    {
      return;
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() == 2)
      {
        d();
        j();
        return;
      }
    } while ((paramObservable.intValue() != 3) || (this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_JavaLangRunnable == null));
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.HasClockView
 * JD-Core Version:    0.7.0.1
 */