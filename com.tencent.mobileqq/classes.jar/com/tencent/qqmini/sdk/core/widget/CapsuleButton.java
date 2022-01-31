package com.tencent.qqmini.sdk.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bghr;
import bgkk;
import bglq;
import bgmq;
import com.tencent.qqmini.sdk.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.util.HashMap;

public class CapsuleButton
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = bglq.a("qqminiapp", "closebutton", null);
  private static int jdField_b_of_type_Int;
  private static final String jdField_b_of_type_JavaLangString = bglq.a("qqminiapp", "closebuttondark", null);
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgmq jdField_a_of_type_Bgmq;
  public HashMap<String, Integer> a;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private Drawable c;
  private Drawable d;
  
  public CapsuleButton(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    b();
  }
  
  private int a(float paramFloat)
  {
    return DisplayUtil.dip2px(getContext(), paramFloat);
  }
  
  private View a()
  {
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131370574);
    ((ImageView)localObject).setContentDescription("更多");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(40.0F), a(30.0F));
    localLayoutParams.addRule(9, -1);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(2131370572);
    ((ImageView)localObject).setContentDescription("关闭");
    localLayoutParams = new RelativeLayout.LayoutParams(a(40.0F), a(30.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131370574);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new View(getContext());
    ((View)localObject).setId(2131370573);
    localLayoutParams = new RelativeLayout.LayoutParams(a(0.5F), a(18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    addView((View)localObject, localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setId(2131370575);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, a(19.0F));
    localLayoutParams.leftMargin = a(21.5F);
    localLayoutParams.topMargin = a(-9.5F);
    addView((View)localObject, localLayoutParams);
    return this;
  }
  
  private ImageView b()
  {
    ImageView localImageView = ((KingCardProxy)AppLoaderFactory.g().getProxyManager().get(KingCardProxy.class)).getCapsuleButtonMoreView(getContext());
    if (localImageView == null) {
      return (ImageView)findViewById(2131370574);
    }
    addView(localImageView);
    return localImageView;
  }
  
  private void b()
  {
    setClipChildren(false);
    a();
    this.jdField_a_of_type_AndroidWidgetImageView = b();
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370572));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370575));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370573);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840962);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840956);
    this.c = getResources().getDrawable(2130840959);
    this.d = getResources().getDrawable(2130840953);
    if ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
    {
      MiniAppProxy localMiniAppProxy = (MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localMiniAppProxy.getDrawable(getContext(), jdField_b_of_type_JavaLangString, a(40.0F), a(30.0F), this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.d = localMiniAppProxy.getDrawable(getContext(), jdField_a_of_type_JavaLangString, a(40.0F), a(30.0F), this.d);
    }
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public CapsuleButton a(bgmq parambgmq)
  {
    this.jdField_a_of_type_Bgmq = parambgmq;
    return this;
  }
  
  public void a()
  {
    bgkk.a(new CapsuleButton.1(this));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == -1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.c);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.d);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      if (this.jdField_a_of_type_Bgmq != null) {
        this.jdField_a_of_type_Bgmq.b();
      }
    }
    while ((paramView != this.jdField_b_of_type_AndroidWidgetImageView) || (this.jdField_a_of_type_Bgmq == null)) {
      return;
    }
    this.jdField_a_of_type_Bgmq.a();
  }
  
  public void setUnReadCount(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      jdField_b_of_type_Int = paramInt;
      if (QMLog.isColorLevel()) {
        QMLog.d("CapsuleButton", "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
      }
    }
    jdField_b_of_type_Int = paramInt;
    if (QMLog.isColorLevel()) {
      QMLog.d("CapsuleButton", "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CapsuleButton
 * JD-Core Version:    0.7.0.1
 */