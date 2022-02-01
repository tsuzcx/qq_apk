import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import java.net.URL;

public class rdh
  extends rde
{
  public TextView a;
  public View b;
  
  public rdh(rdd paramrdd, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramrdd, paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379802));
    this.jdField_b_of_type_AndroidViewView = a(2131380392);
  }
  
  protected URL a(String paramString)
  {
    return AsyncImageView.a(paramString, this.jdField_a_of_type_AndroidWidgetImageView.getWidth(), this.jdField_a_of_type_AndroidWidgetImageView.getHeight(), false);
  }
  
  public void a(int paramInt, qzp paramqzp)
  {
    super.a(paramInt, paramqzp);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ozc.a((int)(paramqzp.d / 1000L)));
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
 * Qualified Name:     rdh
 * JD-Core Version:    0.7.0.1
 */