import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class tdc
  extends ten
{
  private String a;
  
  public tdc()
  {
    a(false, true);
  }
  
  public void a()
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    axvo localaxvo = localQQAppInterface.a();
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_Atqq = new tdd(this);
    localaxvt.i = this.a;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_b_of_type_Int = 196610;
    localaxvt.jdField_b_of_type_JavaLangString = localQQAppInterface.c();
    localaxvt.c = "";
    localaxvt.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localaxvo.a(localaxvt);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("UploadImageJob_in_image_file_path"))) {
      this.a = ((String)a("UploadImageJob_in_image_file_path"));
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdc
 * JD-Core Version:    0.7.0.1
 */