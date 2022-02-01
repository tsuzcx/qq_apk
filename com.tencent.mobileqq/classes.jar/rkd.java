import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.BaseApplication;

public class rkd
  extends bjwv<rgo, rke>
{
  private int jdField_a_of_type_Int = -1;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167303));
  private rkg jdField_a_of_type_Rkg;
  
  public rkd(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    rgo localrgo = (rgo)a(paramInt);
    if ((localrgo != null) && (localrgo.a)) {
      return 1;
    }
    return 0;
  }
  
  public rke a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new rke(this, paramViewGroup, 2131559992);
    }
    return new rkh(this, paramViewGroup, 2131559993);
  }
  
  public void a(int paramInt)
  {
    rgo localrgo = (rgo)a(paramInt);
    if ((this.jdField_a_of_type_Rkg == null) || (this.jdField_a_of_type_Rkg.a(paramInt, localrgo))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_Int != paramInt) && (i != 0))
      {
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        if (this.jdField_a_of_type_Rkg != null) {
          this.jdField_a_of_type_Rkg.a((rgo)a(this.jdField_a_of_type_Int));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public void a(rke paramrke, int paramInt)
  {
    paramrke.a(paramInt, (rgo)a(paramInt));
    if (this.jdField_a_of_type_Rkg != null) {
      this.jdField_a_of_type_Rkg.a(paramInt);
    }
  }
  
  public void a(rkg paramrkg)
  {
    this.jdField_a_of_type_Rkg = paramrkg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkd
 * JD-Core Version:    0.7.0.1
 */