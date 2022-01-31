import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.MatrixDrawable;

public class pgf
  extends pgb
{
  public pgf(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    super(paramDrawable, paramDrawableContainer);
  }
  
  public pgf(pgb parampgb, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    super(parampgb, paramDrawableContainer, paramResources);
  }
  
  public Drawable newDrawable()
  {
    return new MatrixDrawable(this, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */