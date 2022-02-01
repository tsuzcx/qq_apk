import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class rmi
  extends bkrs<riw, rmj>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167249));
  private rml jdField_a_of_type_Rml;
  
  public rmi(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    riw localriw = (riw)a(paramInt);
    if ((localriw != null) && (localriw.a)) {
      return 1;
    }
    return 0;
  }
  
  public rmj a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new rmj(this, paramViewGroup, 2131559982);
    }
    return new rmm(this, paramViewGroup, 2131559983);
  }
  
  public void a(int paramInt)
  {
    riw localriw = (riw)a(paramInt);
    if ((this.jdField_a_of_type_Rml == null) || (this.jdField_a_of_type_Rml.a(paramInt, localriw))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Rml != null) {
          this.jdField_a_of_type_Rml.a((riw)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rmj paramrmj, int paramInt)
  {
    paramrmj.a(paramInt, (riw)a(paramInt));
    if (this.jdField_a_of_type_Rml != null) {
      this.jdField_a_of_type_Rml.a(paramInt);
    }
  }
  
  public void a(rml paramrml)
  {
    this.jdField_a_of_type_Rml = paramrml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmi
 * JD-Core Version:    0.7.0.1
 */