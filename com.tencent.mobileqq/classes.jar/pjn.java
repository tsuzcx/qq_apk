import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class pjn
  implements piz
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pgd jdField_a_of_type_Pgd;
  private piz jdField_a_of_type_Piz;
  private rvg jdField_a_of_type_Rvg;
  private piz b;
  
  public pjn(Context paramContext, rrn paramrrn, bcws parambcws, rqj paramrqj, bhtq parambhtq, ListView paramListView)
  {
    this.jdField_a_of_type_Piz = new pji(paramContext, parambcws, paramrqj, paramListView, parambhtq);
    this.b = new pja(paramContext, paramrrn, paramrqj);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(rvg paramrvg, pgd parampgd, int paramInt)
  {
    this.jdField_a_of_type_Rvg = paramrvg;
    this.jdField_a_of_type_Pgd = parampgd;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Piz.a(paramrvg, parampgd, paramInt);
    this.b.a(paramrvg, parampgd, paramInt);
    if ((paramrvg != null) && (paramrvg.e != null))
    {
      if (parampgd.h()) {
        paramrvg.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramrvg.e.setVisibility(0);
  }
  
  public void a(rvg paramrvg, pgd parampgd, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Piz.a(paramrvg, parampgd, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */