import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class rqu
  extends rqq
{
  public rqu(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298637);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xed == null) {
      this.jdField_a_of_type_Xed = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559459, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_Xed;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xed == null) {
      return;
    }
    this.jdField_a_of_type_Xed.a(0L);
    this.jdField_a_of_type_Xed.ao_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Xed == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Xed.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xed.ao_();
      return;
    }
    this.jdField_a_of_type_Xed.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xed == null) {
      return;
    }
    this.jdField_a_of_type_Xed.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Xed == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Xed.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xed.a(0);
      return;
    }
    this.jdField_a_of_type_Xed.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqu
 * JD-Core Version:    0.7.0.1
 */