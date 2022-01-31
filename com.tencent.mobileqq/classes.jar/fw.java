import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;

public class fw
  implements Cloneable
{
  public ambh a;
  public ImageView a;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DataLineMsgSet jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet;
  private fx jdField_a_of_type_Fx = new fx(this);
  private fy jdField_a_of_type_Fy = new fy(this);
  private fz jdField_a_of_type_Fz = new fz(this);
  private ga jdField_a_of_type_Ga = new ga(this);
  private gb jdField_a_of_type_Gb = new gb(this);
  private gc jdField_a_of_type_Gc = new gc(this);
  private gd jdField_a_of_type_Gd = new gd(this);
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
  
  public fx a()
  {
    return this.jdField_a_of_type_Fx;
  }
  
  public fy a()
  {
    return this.jdField_a_of_type_Fy;
  }
  
  public fz a()
  {
    return this.jdField_a_of_type_Fz;
  }
  
  public ga a()
  {
    return this.jdField_a_of_type_Ga;
  }
  
  public gb a()
  {
    return this.jdField_a_of_type_Gb;
  }
  
  public gc a()
  {
    return this.jdField_a_of_type_Gc;
  }
  
  public gd a()
  {
    return this.jdField_a_of_type_Gd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     fw
 * JD-Core Version:    0.7.0.1
 */