import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class rwq
  extends blig<rsv, rwr>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167323));
  private rwt jdField_a_of_type_Rwt;
  
  public rwq(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    rsv localrsv = (rsv)a(paramInt);
    if ((localrsv != null) && (localrsv.a)) {
      return 1;
    }
    return 0;
  }
  
  public rwr a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new rwr(this, paramViewGroup, 2131560036);
    }
    return new rwu(this, paramViewGroup, 2131560037);
  }
  
  public void a(int paramInt)
  {
    rsv localrsv = (rsv)a(paramInt);
    if ((this.jdField_a_of_type_Rwt == null) || (this.jdField_a_of_type_Rwt.a(paramInt, localrsv))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Rwt != null) {
          this.jdField_a_of_type_Rwt.a((rsv)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rwr paramrwr, int paramInt)
  {
    paramrwr.a(paramInt, (rsv)a(paramInt));
    if (this.jdField_a_of_type_Rwt != null) {
      this.jdField_a_of_type_Rwt.a(paramInt);
    }
  }
  
  public void a(rwt paramrwt)
  {
    this.jdField_a_of_type_Rwt = paramrwt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwq
 * JD-Core Version:    0.7.0.1
 */