import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class qhz
  extends awry
{
  private awqu jdField_a_of_type_Awqu;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  qhz(baxk parambaxk, awqu paramawqu, Set<String> paramSet)
  {
    super(parambaxk);
    this.jdField_a_of_type_Awqu = paramawqu;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(awog paramawog, awwp paramawwp)
  {
    if ((paramawog instanceof qic))
    {
      paramawog = ((qic)paramawog).a().b();
      paramawwp = paramawwp.b();
      Drawable localDrawable = paramawwp.getResources().getDrawable(2130839736);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramawog = URLDrawable.getDrawable(paramawog, localURLDrawableOptions);
      paramawog.setTag(bavi.a(140, 140));
      paramawog.setDecodeHandler(bavi.o);
      paramawwp.setImageDrawable(paramawog);
      return;
    }
    super.a(paramawog, paramawwp);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    super.c(paramawog, paramawwp);
    if ((this.jdField_a_of_type_Awqu != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramawog.b()))) {
      paramawwp.a().setOnClickListener(new qia(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhz
 * JD-Core Version:    0.7.0.1
 */