import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class ef
  implements Cloneable
{
  public ImageView a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public anwo a;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private eg jdField_a_of_type_Eg = new eg(this);
  private eh jdField_a_of_type_Eh = new eh(this);
  private ei jdField_a_of_type_Ei = new ei(this);
  private ej jdField_a_of_type_Ej = new ej(this);
  private ek jdField_a_of_type_Ek = new ek(this);
  private el jdField_a_of_type_El = new el(this);
  private em jdField_a_of_type_Em = new em(this);
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
  
  public eg a()
  {
    return this.jdField_a_of_type_Eg;
  }
  
  public eh a()
  {
    return this.jdField_a_of_type_Eh;
  }
  
  public ei a()
  {
    return this.jdField_a_of_type_Ei;
  }
  
  public ej a()
  {
    return this.jdField_a_of_type_Ej;
  }
  
  public ek a()
  {
    return this.jdField_a_of_type_Ek;
  }
  
  public el a()
  {
    return this.jdField_a_of_type_El;
  }
  
  public em a()
  {
    return this.jdField_a_of_type_Em;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ef
 * JD-Core Version:    0.7.0.1
 */