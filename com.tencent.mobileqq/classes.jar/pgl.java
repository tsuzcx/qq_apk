import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class pgl
  extends pgb
{
  public int b;
  public int c;
  
  public pgl(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public pgl(pgl parampgl, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(parampgl, paramDrawableContainer, paramResources);
    this.b = parampgl.b;
    this.c = parampgl.c;
  }
  
  public Drawable newDrawable()
  {
    return new SpecifiedDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgl
 * JD-Core Version:    0.7.0.1
 */