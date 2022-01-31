import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class qrf
  extends bhzz<qnz, qrg>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167162));
  private qri jdField_a_of_type_Qri;
  
  public qrf(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    qnz localqnz = (qnz)a(paramInt);
    if ((localqnz != null) && (localqnz.a)) {
      return 1;
    }
    return 0;
  }
  
  public qrg a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new qrg(this, paramViewGroup, 2131559847);
    }
    return new qrj(this, paramViewGroup, 2131559848);
  }
  
  public void a(int paramInt)
  {
    qnz localqnz = (qnz)a(paramInt);
    if ((this.jdField_a_of_type_Qri == null) || (this.jdField_a_of_type_Qri.a(paramInt, localqnz))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Qri != null) {
          this.jdField_a_of_type_Qri.a((qnz)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(qrg paramqrg, int paramInt)
  {
    paramqrg.a(paramInt, (qnz)a(paramInt));
    if (this.jdField_a_of_type_Qri != null) {
      this.jdField_a_of_type_Qri.a(paramInt);
    }
  }
  
  public void a(qri paramqri)
  {
    this.jdField_a_of_type_Qri = paramqri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrf
 * JD-Core Version:    0.7.0.1
 */