import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class rdd
  extends blsv<qzp, rde>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167272));
  private rdg jdField_a_of_type_Rdg;
  
  public rdd(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    qzp localqzp = (qzp)a(paramInt);
    if ((localqzp != null) && (localqzp.a)) {
      return 1;
    }
    return 0;
  }
  
  public rde a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new rde(this, paramViewGroup, 2131559988);
    }
    return new rdh(this, paramViewGroup, 2131559989);
  }
  
  public void a(int paramInt)
  {
    qzp localqzp = (qzp)a(paramInt);
    if ((this.jdField_a_of_type_Rdg == null) || (this.jdField_a_of_type_Rdg.a(paramInt, localqzp))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Rdg != null) {
          this.jdField_a_of_type_Rdg.a((qzp)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rde paramrde, int paramInt)
  {
    paramrde.a(paramInt, (qzp)a(paramInt));
    if (this.jdField_a_of_type_Rdg != null) {
      this.jdField_a_of_type_Rdg.a(paramInt);
    }
  }
  
  public void a(rdg paramrdg)
  {
    this.jdField_a_of_type_Rdg = paramrdg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdd
 * JD-Core Version:    0.7.0.1
 */