import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

@TargetApi(14)
public class swv
  extends swx
{
  public String a;
  public swb a;
  public String b;
  
  public swv(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Swb = new swb();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  private void c()
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Auoq = new sww(this);
    localaywc.i = this.jdField_b_of_type_JavaLangString;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_b_of_type_Int = 196609;
    QQStoryContext.a();
    localaywc.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaywc.c = "";
    localaywc.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaywc);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vyf.c(this.jdField_b_of_type_JavaLangString)))
    {
      Object localObject = ((swk)tcz.a(14)).a(this.jdField_a_of_type_JavaLangString);
      if (((swn)localObject).a.isSuccess())
      {
        this.jdField_b_of_type_JavaLangString = ((swn)localObject).jdField_b_of_type_JavaLangString;
        if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!vyf.c(this.jdField_b_of_type_JavaLangString)))
        {
          ved.d("Q.qqstory.publish.upload:StoryVideoFileObject  ", "end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString });
          localObject = new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_b_of_type_JavaLangString }));
          ((ErrorMessage)localObject).extraMsg = "composite";
          super.notifyResult(localObject);
        }
      }
      else
      {
        ((swn)localObject).a.extraMsg = "composite";
        super.notifyResult(((swn)localObject).a);
        return;
      }
    }
    svx.a().b(this.jdField_a_of_type_JavaLangString);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swv
 * JD-Core Version:    0.7.0.1
 */