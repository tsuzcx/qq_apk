import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.ListView;

public class qlj
  implements qkv
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private qfw jdField_a_of_type_Qfw;
  private qkv jdField_a_of_type_Qkv;
  private tbs jdField_a_of_type_Tbs;
  private qkv b;
  
  public qlj(Context paramContext, pnv parampnv, FaceDecoder paramFaceDecoder, szd paramszd, blcn paramblcn, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qkv = new qle(this.jdField_a_of_type_AndroidContentContext, paramFaceDecoder, paramszd, paramListView, paramblcn);
    this.b = new qkw(this.jdField_a_of_type_AndroidContentContext, parampnv, paramszd);
  }
  
  public void a(tbs paramtbs, qfw paramqfw, int paramInt)
  {
    this.jdField_a_of_type_Tbs = paramtbs;
    this.jdField_a_of_type_Qfw = paramqfw;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Qkv.a(paramtbs, paramqfw, paramInt);
    this.b.a(paramtbs, paramqfw, paramInt);
    if ((paramtbs != null) && (paramtbs.e != null))
    {
      if (paramqfw.h()) {
        paramtbs.e.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramtbs.e.setVisibility(0);
  }
  
  public void a(tbs paramtbs, qfw paramqfw, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Qkv.a(paramtbs, paramqfw, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlj
 * JD-Core Version:    0.7.0.1
 */