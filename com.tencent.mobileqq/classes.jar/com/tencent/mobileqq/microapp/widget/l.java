package com.tencent.mobileqq.microapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
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
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.style;
import java.lang.reflect.Field;

public final class l
  extends Dialog
  implements View.OnClickListener
{
  private TimePicker a;
  private TextView b;
  private TextView c;
  private l.a d;
  private int e;
  private int f;
  
  public l(@NonNull Context paramContext)
  {
    super(paramContext, R.style.b);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.b, null);
    setContentView(paramContext);
    Object localObject1 = getWindow();
    if (localObject1 != null)
    {
      ((Window)localObject1).getDecorView().setPadding(0, 0, 0, 0);
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -2;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
      ((Window)localObject1).setGravity(80);
    }
    localObject1 = (FrameLayout)paramContext.findViewById(R.id.ao);
    this.a = new TimePicker(new ContextThemeWrapper(getContext(), 16973934));
    ((FrameLayout)localObject1).addView(this.a);
    this.c = ((TextView)paramContext.findViewById(R.id.be));
    this.c.setOnClickListener(this);
    this.b = ((TextView)paramContext.findViewById(R.id.bf));
    this.b.setOnClickListener(this);
    int i = Resources.getSystem().getIdentifier("hour", "id", "android");
    int j = Resources.getSystem().getIdentifier("minute", "id", "android");
    int k = Resources.getSystem().getIdentifier("amPm", "id", "android");
    paramContext = (NumberPicker)this.a.findViewById(i);
    localObject1 = (NumberPicker)this.a.findViewById(j);
    Object localObject2 = (NumberPicker)this.a.findViewById(k);
    a(paramContext);
    a((NumberPicker)localObject1);
    a((NumberPicker)localObject2);
  }
  
  private void a(NumberPicker paramNumberPicker)
  {
    Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if (localField.getName().equals("mSelectionDivider")) {
          localField.setAccessible(true);
        }
      }
      else
      {
        try
        {
          localField.set(paramNumberPicker, new ColorDrawable(Color.parseColor("#3CB371")));
          return;
        }
        catch (IllegalArgumentException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (Resources.NotFoundException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, l.a parama)
  {
    this.a.setCurrentHour(Integer.valueOf(paramInt1));
    this.a.setCurrentMinute(Integer.valueOf(paramInt2));
    this.a.setOnTimeChangedListener(new m(this));
    this.d = parama;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.be) {
      dismiss();
    }
    while ((paramView.getId() != R.id.bf) || (this.d == null)) {
      return;
    }
    Object localObject = String.valueOf(this.e);
    paramView = (View)localObject;
    if (this.e < 10) {
      paramView = "0" + (String)localObject;
    }
    String str = String.valueOf(this.f);
    localObject = str;
    if (this.f < 10) {
      localObject = "0" + str;
    }
    this.d.a(paramView, (String)localObject);
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.l
 * JD-Core Version:    0.7.0.1
 */