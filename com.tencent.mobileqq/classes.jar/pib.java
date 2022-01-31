import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;

public class pib
  extends phv
{
  public pib(Drawable paramDrawable, ScaleDrawable paramScaleDrawable)
  {
    super(paramDrawable, paramScaleDrawable);
  }
  
  public pib(pib parampib, ScaleDrawable paramScaleDrawable, Resources paramResources)
  {
    super(parampib, paramScaleDrawable, paramResources);
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
 * Qualified Name:     pib
 * JD-Core Version:    0.7.0.1
 */