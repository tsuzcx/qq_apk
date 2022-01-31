import android.net.Uri;
import com.tencent.mobileqq.statistics.ReportController;

public final class mwb
  implements Runnable
{
  public mwb(Uri paramUri, String paramString) {}
  
  public void run()
  {
    try
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A68", "0X8006A68", 0, 0, this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id"), this.jdField_a_of_type_JavaLangString, "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwb
 * JD-Core Version:    0.7.0.1
 */