package com.tencent.mobileqq.microapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.R.style;
import java.lang.reflect.Field;

public final class g
  extends Dialog
  implements View.OnClickListener
{
  private NumberPicker a;
  private TextView b;
  private TextView c;
  private g.a d;
  private int e;
  
  public g(@NonNull Context paramContext)
  {
    super(paramContext, R.style.b);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.d, null);
    setContentView(paramContext);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
    }
    this.a = ((NumberPicker)paramContext.findViewById(R.id.ak));
    this.c = ((TextView)paramContext.findViewById(R.id.be));
    this.c.setOnClickListener(this);
    this.b = ((TextView)paramContext.findViewById(R.id.bf));
    this.b.setOnClickListener(this);
    a(this.a);
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
  
  public void a(int paramInt)
  {
    this.a.setMaxValue(paramInt);
  }
  
  public void a(g.a parama)
  {
    this.a.setOnValueChangedListener(new h(this));
    this.d = parama;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.a.setDisplayedValues(paramArrayOfString);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.be) {
      dismiss();
    }
    while ((paramView.getId() != R.id.bf) || (this.d == null)) {
      return;
    }
    this.d.a(this.e);
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.g
 * JD-Core Version:    0.7.0.1
 */