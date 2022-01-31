import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class sud
  implements axfb
{
  sud(suc paramsuc, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, axeu paramaxeu)
  {
    sui localsui;
    if (paramaxeu.jdField_a_of_type_Int == 0)
    {
      paramaxeu = (aunb)paramaxeu.jdField_a_of_type_JavaLangObject;
      localsui = (sui)this.jdField_a_of_type_Suc.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localsui != null)
      {
        if (!new File(paramaxeu.b).exists()) {
          break label99;
        }
        localsui.b = (System.currentTimeMillis() - localsui.jdField_a_of_type_Long);
        if (localsui.jdField_a_of_type_Sub != null) {
          localsui.jdField_a_of_type_Sub.a(localsui, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        ved.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        ved.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramaxeu.jdField_a_of_type_Int) });
        localsui = (sui)this.jdField_a_of_type_Suc.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localsui == null);
      localsui.b = (System.currentTimeMillis() - localsui.jdField_a_of_type_Long);
    } while (localsui.jdField_a_of_type_Sub == null);
    localsui.jdField_a_of_type_Sub.a(localsui, new ErrorMessage(paramaxeu.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<axeu> paramArrayList) {}
  
  public void b(int paramInt, axeu paramaxeu) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sud
 * JD-Core Version:    0.7.0.1
 */