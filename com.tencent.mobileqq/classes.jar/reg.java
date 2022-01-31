import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class reg
  extends rec
{
  public reg(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167544);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Wpa == null) {
      this.jdField_a_of_type_Wpa = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493891, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_Wpa;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Wpa == null) {
      return;
    }
    this.jdField_a_of_type_Wpa.a(0L);
    this.jdField_a_of_type_Wpa.ar_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Wpa == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Wpa.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wpa.ar_();
      return;
    }
    this.jdField_a_of_type_Wpa.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wpa == null) {
      return;
    }
    this.jdField_a_of_type_Wpa.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Wpa == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Wpa.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Wpa.a(0);
      return;
    }
    this.jdField_a_of_type_Wpa.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     reg
 * JD-Core Version:    0.7.0.1
 */