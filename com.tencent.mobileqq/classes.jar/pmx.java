import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class pmx
  extends pmn
{
  public int b;
  public int c;
  
  public pmx(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public pmx(pmx parampmx, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(parampmx, paramDrawableContainer, paramResources);
    this.b = parampmx.b;
    this.c = parampmx.c;
  }
  
  public Drawable newDrawable()
  {
    return new SpecifiedDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmx
 * JD-Core Version:    0.7.0.1
 */