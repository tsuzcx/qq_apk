import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class szz
  extends szv
{
  public szz(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298826);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Zvb == null) {
      this.jdField_a_of_type_Zvb = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559654, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_Zvb;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zvb == null) {
      return;
    }
    this.jdField_a_of_type_Zvb.a(0L);
    this.jdField_a_of_type_Zvb.ag_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Zvb == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Zvb.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Zvb.ag_();
      return;
    }
    this.jdField_a_of_type_Zvb.c(0L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zvb == null) {
      return;
    }
    this.jdField_a_of_type_Zvb.a(0L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Zvb == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_Zvb.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Zvb.a(0);
      return;
    }
    this.jdField_a_of_type_Zvb.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szz
 * JD-Core Version:    0.7.0.1
 */