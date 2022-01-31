package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class PersonalityStroke
  extends Stroke
{
  private final Drawable a;
  private final Drawable b;
  private final Drawable c;
  private final int h;
  private final int i;
  
  public PersonalityStroke(Context paramContext, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, int paramInt3, int paramInt4)
  {
    super(paramContext, paramInt1, paramInt2);
    this.a = paramDrawable1;
    this.b = paramDrawable2;
    this.c = paramDrawable3;
    this.h = paramInt3;
    this.i = paramInt4;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public Drawable a()
  {
    return this.a;
  }
  
  public Drawable a(float paramFloat1, float paramFloat2)
  {
    return this.b;
  }
  
  public Drawable b(float paramFloat1, float paramFloat2)
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PersonalityStroke
 * JD-Core Version:    0.7.0.1
 */