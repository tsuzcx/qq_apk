import android.net.Uri;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;

public final class mwc
  implements Runnable
{
  public mwc(Uri paramUri, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        String str = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
        int i = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int == 0)
        {
          i = 100;
          PublicAccountReportUtils.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", this.b, 0, str, this.jdField_a_of_type_JavaLangString, "" + i, "", false);
          PublicAccountReportUtils.a("0X8006DF8", "", str, this.jdField_a_of_type_JavaLangString, "" + i, "" + this.b);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwc
 * JD-Core Version:    0.7.0.1
 */