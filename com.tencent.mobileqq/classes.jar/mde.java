import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.av.ui.QavMenuBaseView;

public class mde
  implements mhm
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public mde(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      mrr.a(this.jdField_a_of_type_JavaLangString, 0);
    }
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).b(paramLong, paramBoolean);
    }
  }
  
  public void b(long paramLong, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((paramRelativeLayout instanceof QavMenuBaseView)) {
      ((QavMenuBaseView)paramRelativeLayout).d(paramLong, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mde
 * JD-Core Version:    0.7.0.1
 */