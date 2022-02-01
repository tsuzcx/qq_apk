import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class ric
  extends bcji
{
  private bcie jdField_a_of_type_Bcie;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  ric(aoof paramaoof, bcie parambcie, Set<String> paramSet)
  {
    super(paramaoof);
    this.jdField_a_of_type_Bcie = parambcie;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    if ((parambcfr instanceof rif))
    {
      parambcfr = ((rif)parambcfr).a().b();
      parambcnz = parambcnz.b();
      Drawable localDrawable = parambcnz.getResources().getDrawable(2130840274);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      parambcfr = URLDrawable.getDrawable(parambcfr, localURLDrawableOptions);
      parambcfr.setTag(bhez.a(140, 140));
      parambcfr.setDecodeHandler(bhez.p);
      parambcnz.setImageDrawable(parambcfr);
      return;
    }
    super.a(parambcfr, parambcnz);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    super.c(parambcfr, parambcnz);
    if ((this.jdField_a_of_type_Bcie != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(parambcfr.b()))) {
      parambcnz.a().setOnClickListener(new rid(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ric
 * JD-Core Version:    0.7.0.1
 */