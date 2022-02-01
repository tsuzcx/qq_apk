import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class ek
  implements Cloneable
{
  public ImageView a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public aqhi a;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private el jdField_a_of_type_El = new el(this);
  private em jdField_a_of_type_Em = new em(this);
  private en jdField_a_of_type_En = new en(this);
  private eo jdField_a_of_type_Eo = new eo(this);
  private ep jdField_a_of_type_Ep = new ep(this);
  private eq jdField_a_of_type_Eq = new eq(this);
  private er jdField_a_of_type_Er = new er(this);
  private Object jdField_a_of_type_JavaLangObject;
  private TextView b;
  
  public ProgressBar a()
  {
    return this.jdField_a_of_type_AndroidWidgetProgressBar;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public DataLineMsgSet a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  }
  
  public el a()
  {
    return this.jdField_a_of_type_El;
  }
  
  public em a()
  {
    return this.jdField_a_of_type_Em;
  }
  
  public en a()
  {
    return this.jdField_a_of_type_En;
  }
  
  public eo a()
  {
    return this.jdField_a_of_type_Eo;
  }
  
  public ep a()
  {
    return this.jdField_a_of_type_Ep;
  }
  
  public eq a()
  {
    return this.jdField_a_of_type_Eq;
  }
  
  public er a()
  {
    return this.jdField_a_of_type_Er;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = paramProgressBar;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(DataLineMsgSet paramDataLineMsgSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public void b(TextView paramTextView)
  {
    this.b = paramTextView;
  }
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isDevelopLevel());
      QLog.w("Dataline.ItemHolder", 4, "ItemHolder clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ek
 * JD-Core Version:    0.7.0.1
 */