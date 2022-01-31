import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class pdo
  implements pda
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pax jdField_a_of_type_Pax;
  private pda jdField_a_of_type_Pda;
  private rfn jdField_a_of_type_Rfn;
  private pda b;
  
  public pdo(Context paramContext, rbt paramrbt, baxk parambaxk, rap paramrap, bfsc parambfsc, ListView paramListView)
  {
    this.jdField_a_of_type_Pda = new pdj(paramContext, parambaxk, paramrap, paramListView, parambfsc);
    this.b = new pdb(paramContext, paramrbt, paramrap);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(rfn paramrfn, pax parampax, int paramInt)
  {
    this.jdField_a_of_type_Rfn = paramrfn;
    this.jdField_a_of_type_Pax = parampax;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pda.a(paramrfn, parampax, paramInt);
    this.b.a(paramrfn, parampax, paramInt);
    if ((paramrfn != null) && (paramrfn.e != null))
    {
      if (parampax.h()) {
        paramrfn.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramrfn.e.setVisibility(0);
  }
  
  public void a(rfn paramrfn, pax parampax, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Pda.a(paramrfn, parampax, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdo
 * JD-Core Version:    0.7.0.1
 */