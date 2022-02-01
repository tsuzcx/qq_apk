package cooperation.vip.jsoninflate.model;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class TextViewModel
  extends ViewModel
{
  private float a;
  private float b;
  private int c;
  private float d;
  
  public TextViewModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ("center".equals(paramString)) {
        return 17;
      }
      if ("left".equals(paramString)) {
        return 3;
      }
      if ("right".equals(paramString)) {
        return 5;
      }
      return 3;
    }
    paramString = new StringBuilder();
    paramString.append(getClass().getName());
    paramString.append(" setGravity value can not be null");
    throw new RuntimeException(paramString.toString());
  }
  
  private void b(String paramString)
  {
    try
    {
      ((TextView)this.h).setTextSize(0, e(paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TextView)this.h).setTextColor(Color.parseColor(paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.h instanceof TextView)) {
      return;
    }
    if ("content".equals(paramString1))
    {
      ((TextView)this.h).setText(paramString2);
      return;
    }
    if ("text_color".equals(paramString1))
    {
      c(paramString2);
      return;
    }
    if ("text_align".equals(paramString1))
    {
      ((TextView)this.h).setGravity(a(paramString2));
      return;
    }
    if ("max_lines".equals(paramString1))
    {
      ((TextView)this.h).setMaxLines(Integer.parseInt(paramString2));
      return;
    }
    if ("shadow_color".equals(paramString1))
    {
      this.c = Color.parseColor(paramString2);
      return;
    }
    if ("shadow_x".equals(paramString1))
    {
      this.a = Float.parseFloat(paramString2);
      return;
    }
    if ("shadow_y".equals(paramString1))
    {
      this.b = Float.parseFloat(paramString2);
      return;
    }
    if ("shadow_radius".equals(paramString1))
    {
      this.d = Float.parseFloat(paramString2);
      return;
    }
    if ("text_size".equals(paramString1)) {
      b(paramString2);
    }
  }
  
  protected void b()
  {
    super.b();
    ((TextView)this.h).setShadowLayer(this.d, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.TextViewModel
 * JD-Core Version:    0.7.0.1
 */