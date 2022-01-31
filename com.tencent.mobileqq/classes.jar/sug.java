import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class sug
  implements axez
{
  sug(suf paramsuf, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, axes paramaxes)
  {
    sul localsul;
    if (paramaxes.jdField_a_of_type_Int == 0)
    {
      paramaxes = (aumz)paramaxes.jdField_a_of_type_JavaLangObject;
      localsul = (sul)this.jdField_a_of_type_Suf.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localsul != null)
      {
        if (!new File(paramaxes.b).exists()) {
          break label99;
        }
        localsul.b = (System.currentTimeMillis() - localsul.jdField_a_of_type_Long);
        if (localsul.jdField_a_of_type_Sue != null) {
          localsul.jdField_a_of_type_Sue.a(localsul, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        veg.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        veg.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramaxes.jdField_a_of_type_Int) });
        localsul = (sul)this.jdField_a_of_type_Suf.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localsul == null);
      localsul.b = (System.currentTimeMillis() - localsul.jdField_a_of_type_Long);
    } while (localsul.jdField_a_of_type_Sue == null);
    localsul.jdField_a_of_type_Sue.a(localsul, new ErrorMessage(paramaxes.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<axes> paramArrayList) {}
  
  public void b(int paramInt, axes paramaxes) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sug
 * JD-Core Version:    0.7.0.1
 */