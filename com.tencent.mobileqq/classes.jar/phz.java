import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.MatrixDrawable;

public class phz
  extends phv
{
  public phz(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public phz(phv paramphv, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(paramphv, paramDrawableContainer, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new MatrixDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phz
 * JD-Core Version:    0.7.0.1
 */