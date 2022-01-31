import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class qwb
  extends ayrm
{
  private ayqi jdField_a_of_type_Ayqi;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  qwb(bdbb parambdbb, ayqi paramayqi, Set<String> paramSet)
  {
    super(parambdbb);
    this.jdField_a_of_type_Ayqi = paramayqi;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(aynu paramaynu, aywd paramaywd)
  {
    if ((paramaynu instanceof qwe))
    {
      paramaynu = ((qwe)paramaynu).a().b();
      paramaywd = paramaywd.b();
      Drawable localDrawable = paramaywd.getResources().getDrawable(2130840085);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramaynu = URLDrawable.getDrawable(paramaynu, localURLDrawableOptions);
      paramaynu.setTag(bcyz.a(140, 140));
      paramaynu.setDecodeHandler(bcyz.o);
      paramaywd.setImageDrawable(paramaynu);
      return;
    }
    super.a(paramaynu, paramaywd);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    super.c(paramaynu, paramaywd);
    if ((this.jdField_a_of_type_Ayqi != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramaynu.b()))) {
      paramaywd.a().setOnClickListener(new qwc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwb
 * JD-Core Version:    0.7.0.1
 */