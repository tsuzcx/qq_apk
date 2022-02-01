import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.widget.ListView;

public class ptk
  implements psw
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ppu jdField_a_of_type_Ppu;
  private psw jdField_a_of_type_Psw;
  private skg jdField_a_of_type_Skg;
  private psw b;
  
  public ptk(Context paramContext, sge paramsge, aoof paramaoof, sel paramsel, blmm paramblmm, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Psw = new ptf(this.jdField_a_of_type_AndroidContentContext, paramaoof, paramsel, paramListView, paramblmm);
    this.b = new psx(this.jdField_a_of_type_AndroidContentContext, paramsge, paramsel);
  }
  
  public void a(skg paramskg, ppu paramppu, int paramInt)
  {
    this.jdField_a_of_type_Skg = paramskg;
    this.jdField_a_of_type_Ppu = paramppu;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Psw.a(paramskg, paramppu, paramInt);
    this.b.a(paramskg, paramppu, paramInt);
    if ((paramskg != null) && (paramskg.e != null))
    {
      if (paramppu.h()) {
        paramskg.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramskg.e.setVisibility(0);
  }
  
  public void a(skg paramskg, ppu paramppu, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Psw.a(paramskg, paramppu, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptk
 * JD-Core Version:    0.7.0.1
 */