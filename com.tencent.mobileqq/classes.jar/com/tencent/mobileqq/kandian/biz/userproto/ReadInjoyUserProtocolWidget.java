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
  private static final String d = HardCodeUtil.a(2131910631);
  TextView a;
  Button b;
  View c;
  private Runnable e;
  
  public ReadInjoyUserProtocolWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ReadInjoyUserProtocolWidget(@NonNull Context paramContext, Runnable paramRunnable)
  {
    this(paramContext, 0);
    this.e = paramRunnable;
  }
  
  private Drawable a()
  {
    float f = AIOUtils.b(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#12B7F5"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private Drawable b()
  {
    float f = AIOUtils.b(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private SpannableString c()
  {
    int i = d.indexOf("《QQ看点用户行为规范》");
    SpannableString localSpannableString = new SpannableString(d);
    localSpannableString.setSpan(new ReadInjoyUserProtocolWidget.1(this, Color.parseColor("#12B7F5")), i, i + 12, 33);
    return localSpannableString;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.c)
    {
      dismiss();
      return;
    }
    if (paramView == this.b)
    {
      paramView = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qq_readinjoy_user_protocol_agreed_");
      localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      paramView.putBoolean(localStringBuilder.toString(), true).apply();
      dismiss();
      paramView = this.e;
      if (paramView != null) {
        paramView.run();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131626223, null);
    this.a = ((TextView)paramBundle.findViewById(2131431365));
    this.a.setFocusable(false);
    this.b = ((Button)paramBundle.findViewById(2131427913));
    this.c = paramBundle.findViewById(2131430825);
    this.a.setText(c());
    this.a.setMovementMethod(new ReadInjoyUserProtocolWidget.LinkTouchMovementMethod());
    this.b.setOnClickListener(this);
    this.b.setBackgroundDrawable(a());
    this.c.setOnClickListener(this);
    Drawable localDrawable = b();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.findViewById(2131429416).setBackgroundDrawable(localDrawable);
    setContentView(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.width = AIOUtils.b(320.0F, getContext().getResources());
    getWindow().setAttributes(paramBundle);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.userproto.ReadInjoyUserProtocolWidget
 * JD-Core Version:    0.7.0.1
 */