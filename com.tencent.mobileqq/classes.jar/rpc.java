import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.HashSet;
import java.util.Set;

public class rpc
  extends bbck
{
  private bbbg jdField_a_of_type_Bbbg;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  rpc(FaceDecoder paramFaceDecoder, bbbg parambbbg, Set<String> paramSet)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bbbg = parambbbg;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  public void a(bayt parambayt, bbhb parambbhb)
  {
    if ((parambayt instanceof rpf))
    {
      parambayt = ((rpf)parambayt).a().b();
      parambbhb = parambbhb.b();
      Drawable localDrawable = parambbhb.getResources().getDrawable(2130840312);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      parambayt = URLDrawable.getDrawable(parambayt, localURLDrawableOptions);
      parambayt.setTag(bfol.a(140, 140));
      parambayt.setDecodeHandler(bfol.p);
      parambbhb.setImageDrawable(parambayt);
      return;
    }
    super.a(parambayt, parambbhb);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    super.c(parambayt, parambbhb);
    if ((this.jdField_a_of_type_Bbbg != null) && (!this.jdField_a_of_type_JavaUtilSet.contains(parambayt.b()))) {
      parambbhb.a().setOnClickListener(new rpd(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpc
 * JD-Core Version:    0.7.0.1
 */