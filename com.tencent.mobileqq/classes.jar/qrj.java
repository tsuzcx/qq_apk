import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import java.net.URL;

public class qrj
  extends qrg
{
  public TextView a;
  public View b;
  
  public qrj(qrf paramqrf, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramqrf, paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)b(2131378760));
    this.jdField_b_of_type_AndroidViewView = b(2131379279);
  }
  
  protected URL a(String paramString)
  {
    return AsyncImageView.a(paramString, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), false);
  }
  
  public void a(int paramInt, qnz paramqnz)
  {
    super.a(paramInt, paramqnz);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(orc.a((int)(paramqnz.d / 1000L)));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrj
 * JD-Core Version:    0.7.0.1
 */