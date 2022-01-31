import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class swy
  extends sxa
{
  public String a;
  public swe a;
  public String b;
  
  public swy(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Swe = new swe();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Auoo = new swz(this);
    localaywa.i = this.jdField_b_of_type_JavaLangString;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localaywa.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaywa.c = "";
    localaywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaywa);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vyi.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((swn)tdc.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((swq)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((swq)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vyi.c(this.jdField_b_of_type_JavaLangString)))
        {
          veg.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((swq)localObject).a.extraMsg = "composite";
        super.notifyResult(((swq)localObject).a);
        return;
      }
    }
    swa.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swy
 * JD-Core Version:    0.7.0.1
 */