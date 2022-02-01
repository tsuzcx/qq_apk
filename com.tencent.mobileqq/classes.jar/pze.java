import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.ListView;

public class pze
  implements pyq
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private pvc jdField_a_of_type_Pvc;
  private pyq jdField_a_of_type_Pyq;
  private soh jdField_a_of_type_Soh;
  private pyq b;
  
  public pze(Context paramContext, pes parampes, FaceDecoder paramFaceDecoder, slt paramslt, bjrb parambjrb, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Pyq = new pyz(this.jdField_a_of_type_AndroidContentContext, paramFaceDecoder, paramslt, paramListView, parambjrb);
    this.b = new pyr(this.jdField_a_of_type_AndroidContentContext, parampes, paramslt);
  }
  
  public void a(soh paramsoh, pvc parampvc, int paramInt)
  {
    this.jdField_a_of_type_Soh = paramsoh;
    this.jdField_a_of_type_Pvc = parampvc;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pyq.a(paramsoh, parampvc, paramInt);
    this.b.a(paramsoh, parampvc, paramInt);
    if ((paramsoh != null) && (paramsoh.e != null))
    {
      if (parampvc.h()) {
        paramsoh.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramsoh.e.setVisibility(0);
  }
  
  public void a(soh paramsoh, pvc parampvc, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Pyq.a(paramsoh, parampvc, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pze
 * JD-Core Version:    0.7.0.1
 */