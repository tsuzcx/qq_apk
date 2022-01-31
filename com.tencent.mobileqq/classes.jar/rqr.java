import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class rqr
  extends rqn
{
  public rqr(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298637);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xea == null) {
      this.jdField_a_of_type_Xea = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559459, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_Xea;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    this.jdField_a_of_type_Xea.a(0L);
    this.jdField_a_of_type_Xea.ao_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Xea.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xea.ao_();
      return;
    }
    this.jdField_a_of_type_Xea.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    this.jdField_a_of_type_Xea.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Xea.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xea.a(0);
      return;
    }
    this.jdField_a_of_type_Xea.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqr
 * JD-Core Version:    0.7.0.1
 */