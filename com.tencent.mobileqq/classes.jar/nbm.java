import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class nbm
  implements View.OnClickListener, View.OnTouchListener
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private myj jdField_a_of_type_Myj;
  private nbn jdField_a_of_type_Nbn;
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.5F, 1.0F, 1.25F, 1.5F, 2.0F };
  private final int[] jdField_a_of_type_ArrayOfInt = { 2131377954, 2131377956, 2131377955, 2131377953, 2131377952 };
  private final TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[this.jdField_a_of_type_ArrayOfInt.length];
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public nbm(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    float f = 17.0F;
    int i = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130842343);
    if (paramBoolean)
    {
      f = 24.0F;
      localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130842342);
      i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    }
    TextView[] arrayOfTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView;
    int k = arrayOfTextView.length;
    int j = 0;
    if (j < k)
    {
      TextView localTextView = arrayOfTextView[j];
      TextPaint localTextPaint = localTextView.getPaint();
      if (paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localTextPaint.setFakeBoldText(bool);
        localTextView.setTextSize(f);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable.getConstantState().newDrawable());
        localTextView.setCompoundDrawablePadding(i);
        j += 1;
        break;
      }
    }
    e();
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      TextView localTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      GradientDrawable localGradientDrawable = (GradientDrawable)localTextView.getCompoundDrawables()[3];
      if (i == paramInt)
      {
        localTextView.setTextColor(-16725252);
        localGradientDrawable.setColor(-16725252);
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(-1);
        localGradientDrawable.setColor(0);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377954));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = this.jdField_a_of_type_AndroidWidgetTextView;
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377956));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = this.b;
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377955));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = this.c;
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377953));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = this.d;
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377952));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[4] = this.e;
    a(false);
    b(this.jdField_a_of_type_Int);
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      TextView localTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      localTextView.setOnClickListener(this);
      localTextView.setOnTouchListener(this);
      i += 1;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.b()))
    {
      float f = this.jdField_a_of_type_Myj.a();
      int i = 0;
      for (;;)
      {
        if (i < this.jdField_a_of_type_ArrayOfFloat.length)
        {
          if (f == this.jdField_a_of_type_ArrayOfFloat[i]) {
            b(i);
          }
        }
        else {
          return;
        }
        i += 1;
      }
    }
    b(-1);
  }
  
  public void a()
  {
    e();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramInt == 2)
    {
      paramInt = (int)(ImmersiveUtils.a() * 400.0F / 1334.0F);
      a(true);
    }
    for (;;)
    {
      localMarginLayoutParams.leftMargin = (paramInt / 2);
      localMarginLayoutParams.rightMargin = (paramInt / 2);
      if (this.jdField_a_of_type_AndroidViewView.isShown()) {
        this.jdField_a_of_type_AndroidViewView.requestLayout();
      }
      return;
      paramInt = AIOUtils.dp2px(100.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(false);
    }
  }
  
  public void a(myj parammyj)
  {
    this.jdField_a_of_type_Myj = parammyj;
  }
  
  public void a(nbn paramnbn)
  {
    this.jdField_a_of_type_Nbn = paramnbn;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Nbn != null) {
        this.jdField_a_of_type_Nbn.g();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_Myj != null)
      {
        this.jdField_a_of_type_Myj.a(0.5F);
        continue;
        this.jdField_a_of_type_Int = 1;
        if (this.jdField_a_of_type_Myj != null)
        {
          this.jdField_a_of_type_Myj.a(1.0F);
          continue;
          this.jdField_a_of_type_Int = 2;
          if (this.jdField_a_of_type_Myj != null)
          {
            this.jdField_a_of_type_Myj.a(1.25F);
            continue;
            this.jdField_a_of_type_Int = 3;
            if (this.jdField_a_of_type_Myj != null)
            {
              this.jdField_a_of_type_Myj.a(1.5F);
              continue;
              this.jdField_a_of_type_Int = 4;
              if (this.jdField_a_of_type_Myj != null) {
                this.jdField_a_of_type_Myj.a(2.0F);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbm
 * JD-Core Version:    0.7.0.1
 */