import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.HashSet;
import java.util.Set;

public class sbr
  extends bcjc
{
  private bchy jdField_a_of_type_Bchy;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  sbr(FaceDecoder paramFaceDecoder, bchy parambchy, Set<String> paramSet)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bchy = parambchy;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    if ((parambcfj instanceof sbu))
    {
      parambcfj = ((sbu)parambcfj).a().b();
      parambcnt = parambcnt.b();
      Drawable localDrawable = parambcnt.getResources().getDrawable(2130840348);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      parambcfj = URLDrawable.getDrawable(parambcfj, localURLDrawableOptions);
      parambcfj.setTag(bgxc.a(140, 140));
      parambcfj.setDecodeHandler(bgxc.p);
      parambcnt.setImageDrawable(parambcfj);
      return;
    }
    super.a(parambcfj, parambcnt);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    super.c(parambcfj, parambcnt);
    if ((this.jdField_a_of_type_Bchy != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(parambcfj.b()))) {
      parambcnt.a().setOnClickListener(new sbs(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbr
 * JD-Core Version:    0.7.0.1
 */