import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashSet;
import java.util.Set;

public class qwb
  extends aynd
{
  private aylz jdField_a_of_type_Aylz;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  qwb(bcws parambcws, aylz paramaylz, Set<String> paramSet)
  {
    super(parambcws);
    this.jdField_a_of_type_Aylz = paramaylz;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(ayjl paramayjl, ayru paramayru)
  {
    if ((paramayjl instanceof qwe))
    {
      paramayjl = ((qwe)paramayjl).a().b();
      paramayru = paramayru.b();
      Drawable localDrawable = paramayru.getResources().getDrawable(2130840084);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      paramayjl = URLDrawable.getDrawable(paramayjl, localURLDrawableOptions);
      paramayjl.setTag(bcuq.a(140, 140));
      paramayjl.setDecodeHandler(bcuq.o);
      paramayru.setImageDrawable(paramayjl);
      return;
    }
    super.a(paramayjl, paramayru);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    super.c(paramayjl, paramayru);
    if ((this.jdField_a_of_type_Aylz != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramayjl.b()))) {
      paramayru.a().setOnClickListener(new qwc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwb
 * JD-Core Version:    0.7.0.1
 */