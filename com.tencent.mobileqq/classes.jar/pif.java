import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class pif
  extends phv
{
  public int b;
  public int c;
  
  public pif(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public pif(pif parampif, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(parampif, paramDrawableContainer, paramResources);
    this.b = parampif.b;
    this.c = parampif.c;
  }
  
  public Drawable newDrawable()
  {
    return new SpecifiedDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pif
 * JD-Core Version:    0.7.0.1
 */