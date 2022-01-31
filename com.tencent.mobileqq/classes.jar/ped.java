import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pts.nativemodule.IPTSLoadDailyDBArticles;

public class ped
  implements IPTSLoadDailyDBArticles
{
  private final String jdField_a_of_type_JavaLangString = "PTSLoadDailyDBArticlesModule";
  private pdm jdField_a_of_type_Pdm = new pee(this);
  
  public ped()
  {
    pdl.a().a(this.jdField_a_of_type_Pdm);
  }
  
  public void loadDailyDBArticles(long paramLong1, long paramLong2)
  {
    ohd localohd = (ohd)((QQAppInterface)obz.a()).getManager(163);
    if (localohd != null) {
      localohd.a().a((int)paramLong1, 9223372036854775807L, true, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ped
 * JD-Core Version:    0.7.0.1
 */