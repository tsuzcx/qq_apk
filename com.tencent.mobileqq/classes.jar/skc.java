import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class skc
  extends ske
{
  public String a;
  public sji a;
  public String b;
  
  public skc(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Sji = new sji();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_Atqq = new skd(this);
    localaxvt.i = this.jdField_b_of_type_JavaLangString;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localaxvt.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaxvt.c = "";
    localaxvt.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaxvt);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vlm.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((sjr)sqg.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((sju)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((sju)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vlm.c(this.jdField_b_of_type_JavaLangString)))
        {
          urk.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((sju)localObject).a.extraMsg = "composite";
        super.notifyResult(((sju)localObject).a);
        return;
      }
    }
    sje.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     skc
 * JD-Core Version:    0.7.0.1
 */