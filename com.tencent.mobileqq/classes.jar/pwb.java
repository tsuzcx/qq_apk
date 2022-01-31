import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class pwb
  extends avsf
{
  private avrb jdField_a_of_type_Avrb;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  pwb(azwg paramazwg, avrb paramavrb, Set<String> paramSet)
  {
    super(paramazwg);
    this.jdField_a_of_type_Avrb = paramavrb;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(avon paramavon, avww paramavww)
  {
    if ((paramavon instanceof pwe))
    {
      paramavon = ((pwe)paramavon).a().b();
      paramavww = paramavww.b();
      Drawable localDrawable = paramavww.getResources().getDrawable(2130839687);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramavon = URLDrawable.getDrawable(paramavon, localURLDrawableOptions);
      paramavon.setTag(azue.a(140, 140));
      paramavon.setDecodeHandler(azue.o);
      paramavww.setImageDrawable(paramavon);
      return;
    }
    super.a(paramavon, paramavww);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    super.c(paramavon, paramavww);
    if ((this.jdField_a_of_type_Avrb != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramavon.b()))) {
      paramavww.a().setOnClickListener(new pwc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwb
 * JD-Core Version:    0.7.0.1
 */