import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class pdl
  implements pcx
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pau jdField_a_of_type_Pau;
  private pcx jdField_a_of_type_Pcx;
  private rfk jdField_a_of_type_Rfk;
  private pcx b;
  
  public pdl(Context paramContext, rbq paramrbq, baxy parambaxy, ram paramram, bfst parambfst, ListView paramListView)
  {
    this.jdField_a_of_type_Pcx = new pdg(paramContext, parambaxy, paramram, paramListView, parambfst);
    this.b = new pcy(paramContext, paramrbq, paramram);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(rfk paramrfk, pau parampau, int paramInt)
  {
    this.jdField_a_of_type_Rfk = paramrfk;
    this.jdField_a_of_type_Pau = parampau;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pcx.a(paramrfk, parampau, paramInt);
    this.b.a(paramrfk, parampau, paramInt);
    if ((paramrfk != null) && (paramrfk.e != null))
    {
      if (parampau.h()) {
        paramrfk.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramrfk.e.setVisibility(0);
  }
  
  public void a(rfk paramrfk, pau parampau, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Pcx.a(paramrfk, parampau, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdl
 * JD-Core Version:    0.7.0.1
 */