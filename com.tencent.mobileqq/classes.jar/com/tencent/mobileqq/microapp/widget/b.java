package com.tencent.mobileqq.microapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.style;
import java.lang.reflect.Field;

public final class b
  extends Dialog
  implements View.OnClickListener
{
  private DatePicker a;
  private TextView b;
  private TextView c;
  private b.a d;
  private int e;
  private int f;
  private int g;
  
  public b(@NonNull Context paramContext)
  {
    super(paramContext, R.style.b);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.b, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      ((Window)localObject).setGravity(80);
    }
    localObject = (FrameLayout)paramContext.findViewById(R.id.ao);
    this.a = new DatePicker(new ContextThemeWrapper(getContext(), 16973934));
    this.a.setCalendarViewShown(false);
    ((FrameLayout)localObject).addView(this.a);
    this.c = ((TextView)paramContext.findViewById(R.id.be));
    this.c.setOnClickListener(this);
    this.b = ((TextView)paramContext.findViewById(R.id.bf));
    this.b.setOnClickListener(this);
    a(this.a);
  }
  
  private void a(DatePicker paramDatePicker)
  {
    paramDatePicker = (LinearLayout)((LinearLayout)paramDatePicker.getChildAt(0)).getChildAt(0);
    int i = 0;
    if (i < paramDatePicker.getChildCount())
    {
      NumberPicker localNumberPicker = (NumberPicker)paramDatePicker.getChildAt(i);
      Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
      int k = arrayOfField.length;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          Field localField;
          if (j < k)
          {
            localField = arrayOfField[j];
            if (localField.getName().equals("mSelectionDivider")) {
              localField.setAccessible(true);
            }
          }
          else
          {
            try
            {
              localField.set(localNumberPicker, new ColorDrawable(Color.parseColor("#3CB371")));
              i += 1;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
              }
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              for (;;)
              {
                localNotFoundException.printStackTrace();
              }
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
              }
            }
          }
        }
        j += 1;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, b.a parama)
  {
    this.a.init(paramInt1, paramInt2, paramInt3, new c(this));
    this.d = parama;
  }
  
  public void a(long paramLong)
  {
    this.a.setMinDate(paramLong);
  }
  
  public void b(long paramLong)
  {
    this.a.setMaxDate(paramLong);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.be) {
      dismiss();
    }
    while ((paramView.getId() != R.id.bf) || (this.d == null)) {
      return;
    }
    int i = this.f + 1;
    if (i < 10)
    {
      paramView = "0" + i;
      i = this.g;
      if (i >= 10) {
        break label124;
      }
    }
    label124:
    for (String str = "0" + i;; str = String.valueOf(i))
    {
      this.d.a(this.e, paramView, str);
      dismiss();
      return;
      paramView = String.valueOf(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.b
 * JD-Core Version:    0.7.0.1
 */