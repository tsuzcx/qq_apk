package com.tencent.mobileqq.kandian.biz.userproto;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import mqq.app.AppRuntime;

public class ReadInjoyUserProtocolWidget
  extends Dialog
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713070);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public ReadInjoyUserProtocolWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ReadInjoyUserProtocolWidget(@NonNull Context paramContext, Runnable paramRunnable)
  {
    this(paramContext, 0);
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  private Drawable a()
  {
    float f = AIOUtils.b(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#12B7F5"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private SpannableString a()
  {
    int i = jdField_a_of_type_JavaLangString.indexOf("《QQ看点用户行为规范》");
    SpannableString localSpannableString = new SpannableString(jdField_a_of_type_JavaLangString);
    localSpannableString.setSpan(new ReadInjoyUserProtocolWidget.1(this, Color.parseColor("#12B7F5")), i, i + 12, 33);
    return localSpannableString;
  }
  
  private Drawable b()
  {
    float f = AIOUtils.b(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      dismiss();
      return;
    }
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      paramView = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq_readinjoy_user_protocol_agreed_");
      localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramView.putBoolean(localStringBuilder.toString(), true).apply();
      dismiss();
      paramView = this.jdField_a_of_type_JavaLangRunnable;
      if (paramView != null) {
        paramView.run();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131560176, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131365201));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131362314));
    this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131364719);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(new ReadInjoyUserProtocolWidget.LinkTouchMovementMethod());
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Drawable localDrawable = b();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.findViewById(2131363513).setBackgroundDrawable(localDrawable);
    setContentView(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.width = AIOUtils.b(320.0F, getContext().getResources());
    getWindow().setAttributes(paramBundle);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.userproto.ReadInjoyUserProtocolWidget
 * JD-Core Version:    0.7.0.1
 */