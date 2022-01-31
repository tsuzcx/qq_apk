import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.drawable.DrawableContainer;

public abstract class pgb
  extends Drawable.ConstantState
{
  public int a;
  public Drawable a;
  private boolean a;
  private boolean b;
  
  pgb(Drawable paramDrawable, DrawableContainer paramDrawableContainer)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(paramDrawableContainer);
  }
  
  pgb(pgb parampgb, DrawableContainer paramDrawableContainer, Resources paramResources)
  {
    if ((parampgb != null) && (parampgb.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (parampgb.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null)) {
      if (paramResources == null) {
        break label63;
      }
    }
    label63:
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parampgb.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable(paramResources);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parampgb.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable())
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(paramDrawableContainer);
      this.b = true;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() == null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      this.jdField_a_of_type_Boolean = true;
      return this.b;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgb
 * JD-Core Version:    0.7.0.1
 */