import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import java.net.URL;

public class rkh
  extends rke
{
  public TextView a;
  public View b;
  
  public rkh(rkd paramrkd, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramrkd, paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379583));
    this.jdField_b_of_type_AndroidViewView = a(2131380116);
  }
  
  protected URL a(String paramString)
  {
    return AsyncImageView.a(paramString, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), false);
  }
  
  public void a(int paramInt, rgo paramrgo)
  {
    super.a(paramInt, paramrgo);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(pai.a((int)(paramrgo.d / 1000L)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkh
 * JD-Core Version:    0.7.0.1
 */