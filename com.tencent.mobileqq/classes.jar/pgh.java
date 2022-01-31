import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;

public class pgh
  extends pgb
{
  public pgh(Drawable paramDrawable, ScaleDrawable paramScaleDrawable)
  {
    super(paramDrawable, paramScaleDrawable);
  }
  
  public pgh(pgh parampgh, ScaleDrawable paramScaleDrawable, Resources paramResources)
  {
    super(parampgh, paramScaleDrawable, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new ScaleDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ScaleDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgh
 * JD-Core Version:    0.7.0.1
 */