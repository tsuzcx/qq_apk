import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class rrg
  extends bbqp
{
  private bbpl jdField_a_of_type_Bbpl;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  rrg(aobu paramaobu, bbpl parambbpl, Set<String> paramSet)
  {
    super(paramaobu);
    this.jdField_a_of_type_Bbpl = parambbpl;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    if ((parambbmy instanceof rrj))
    {
      parambbmy = ((rrj)parambbmy).a().b();
      parambbvg = parambbvg.b();
      Drawable localDrawable = parambbvg.getResources().getDrawable(2130840264);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      parambbmy = URLDrawable.getDrawable(parambbmy, localURLDrawableOptions);
      parambbmy.setTag(bgey.a(140, 140));
      parambbmy.setDecodeHandler(bgey.p);
      parambbvg.setImageDrawable(parambbmy);
      return;
    }
    super.a(parambbmy, parambbvg);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    super.c(parambbmy, parambbvg);
    if ((this.jdField_a_of_type_Bbpl != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(parambbmy.b()))) {
      parambbvg.a().setOnClickListener(new rrh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrg
 * JD-Core Version:    0.7.0.1
 */