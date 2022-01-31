import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class shk
  implements awfr
{
  shk(shj paramshj, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, awfk paramawfk)
  {
    shp localshp;
    if (paramawfk.jdField_a_of_type_Int == 0)
    {
      paramawfk = (atpb)paramawfk.jdField_a_of_type_JavaLangObject;
      localshp = (shp)this.jdField_a_of_type_Shj.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localshp != null)
      {
        if (!new File(paramawfk.b).exists()) {
          break label99;
        }
        localshp.b = (System.currentTimeMillis() - localshp.jdField_a_of_type_Long);
        if (localshp.jdField_a_of_type_Shi != null) {
          localshp.jdField_a_of_type_Shi.a(localshp, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        urk.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        urk.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramawfk.jdField_a_of_type_Int) });
        localshp = (shp)this.jdField_a_of_type_Shj.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localshp == null);
      localshp.b = (System.currentTimeMillis() - localshp.jdField_a_of_type_Long);
    } while (localshp.jdField_a_of_type_Shi == null);
    localshp.jdField_a_of_type_Shi.a(localshp, new ErrorMessage(paramawfk.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<awfk> paramArrayList) {}
  
  public void b(int paramInt, awfk paramawfk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     shk
 * JD-Core Version:    0.7.0.1
 */