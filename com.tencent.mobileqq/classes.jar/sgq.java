import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class sgq
  extends sgm
{
  public sgq(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298665);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yxi == null) {
      this.jdField_a_of_type_Yxi = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559510, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_Yxi;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yxi == null) {
      return;
    }
    this.jdField_a_of_type_Yxi.a(0L);
    this.jdField_a_of_type_Yxi.at_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Yxi == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Yxi.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Yxi.at_();
      return;
    }
    this.jdField_a_of_type_Yxi.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yxi == null) {
      return;
    }
    this.jdField_a_of_type_Yxi.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Yxi == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Yxi.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Yxi.a(0);
      return;
    }
    this.jdField_a_of_type_Yxi.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgq
 * JD-Core Version:    0.7.0.1
 */