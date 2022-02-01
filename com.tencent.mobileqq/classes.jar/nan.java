import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

class nan
  extends mzp
{
  nan(nah paramnah) {}
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.a;
    paramString.jdField_a_of_type_Int -= 1;
    if (this.a.c) {}
    for (paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);; paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  public void a(String arg1, String paramString2, int paramInt1, int paramInt2, List<bfmo> paramList)
  {
    boolean bool = true;
    int i = 0;
    paramString2 = this.a;
    paramString2.jdField_a_of_type_Int -= 1;
    this.a.jdField_b_of_type_JavaLangString = ???;
    this.a.jdField_b_of_type_Int = paramInt2;
    ??? = this.a;
    if (paramInt1 == 1) {}
    for (;;)
    {
      ???.f = bool;
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        if (this.a.jdField_b_of_type_JavaUtilList != null)
        {
          this.a.jdField_b_of_type_JavaUtilList.clear();
          label86:
          paramInt1 = i;
          label91:
          if (paramInt1 >= paramList.size()) {
            break;
          }
        }
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_b_of_type_JavaUtilList.add(paramList.get(paramInt1));
        paramInt1 += 1;
        break label91;
        bool = false;
        continue;
        this.a.jdField_b_of_type_JavaUtilList = new ArrayList();
        break label86;
        paramString2 = finally;
        throw paramString2;
      }
    }
    ??? = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(???);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nan
 * JD-Core Version:    0.7.0.1
 */