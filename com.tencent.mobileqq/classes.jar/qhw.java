import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class qhw
  extends awsa
{
  private awqw jdField_a_of_type_Awqw;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  qhw(baxy parambaxy, awqw paramawqw, Set<String> paramSet)
  {
    super(parambaxy);
    this.jdField_a_of_type_Awqw = paramawqw;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(awoi paramawoi, awwr paramawwr)
  {
    if ((paramawoi instanceof qhz))
    {
      paramawoi = ((qhz)paramawoi).a().b();
      paramawwr = paramawwr.b();
      Drawable localDrawable = paramawwr.getResources().getDrawable(2130839736);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramawoi = URLDrawable.getDrawable(paramawoi, localURLDrawableOptions);
      paramawoi.setTag(bavw.a(140, 140));
      paramawoi.setDecodeHandler(bavw.o);
      paramawwr.setImageDrawable(paramawoi);
      return;
    }
    super.a(paramawoi, paramawwr);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    super.c(paramawoi, paramawwr);
    if ((this.jdField_a_of_type_Awqw != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramawoi.b()))) {
      paramawwr.a().setOnClickListener(new qhx(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qhw
 * JD-Core Version:    0.7.0.1
 */