import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class qaz
  implements qal
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pxk jdField_a_of_type_Pxk;
  private qal jdField_a_of_type_Qal;
  private stc jdField_a_of_type_Stc;
  private qal b;
  
  public qaz(Context paramContext, spa paramspa, aobu paramaobu, snh paramsnh, bklj parambklj, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qal = new qau(this.jdField_a_of_type_AndroidContentContext, paramaobu, paramsnh, paramListView, parambklj);
    this.b = new qam(this.jdField_a_of_type_AndroidContentContext, paramspa, paramsnh);
  }
  
  public void a(stc paramstc, pxk parampxk, int paramInt)
  {
    this.jdField_a_of_type_Stc = paramstc;
    this.jdField_a_of_type_Pxk = parampxk;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Qal.a(paramstc, parampxk, paramInt);
    this.b.a(paramstc, parampxk, paramInt);
    if ((paramstc != null) && (paramstc.e != null))
    {
      if (parampxk.h()) {
        paramstc.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramstc.e.setVisibility(0);
  }
  
  public void a(stc paramstc, pxk parampxk, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Qal.a(paramstc, parampxk, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qaz
 * JD-Core Version:    0.7.0.1
 */