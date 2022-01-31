import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class osm
  implements ory
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private opw jdField_a_of_type_Opw;
  private ory jdField_a_of_type_Ory;
  private qtb jdField_a_of_type_Qtb;
  private ory b;
  
  public osm(Context paramContext, qpi paramqpi, azwg paramazwg, qoe paramqoe, beki parambeki, ListView paramListView)
  {
    this.jdField_a_of_type_Ory = new osh(paramContext, paramazwg, paramqoe, paramListView, parambeki);
    this.b = new orz(paramContext, paramqpi, paramqoe);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(qtb paramqtb, opw paramopw, int paramInt)
  {
    this.jdField_a_of_type_Qtb = paramqtb;
    this.jdField_a_of_type_Opw = paramopw;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ory.a(paramqtb, paramopw, paramInt);
    this.b.a(paramqtb, paramopw, paramInt);
    if ((paramqtb != null) && (paramqtb.e != null))
    {
      if (paramopw.h()) {
        paramqtb.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramqtb.e.setVisibility(0);
  }
  
  public void a(qtb paramqtb, opw paramopw, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Ory.a(paramqtb, paramopw, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osm
 * JD-Core Version:    0.7.0.1
 */