import android.os.AsyncTask;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class nns
  extends AsyncTask<String, Integer, String>
{
  String jdField_a_of_type_JavaLangString;
  
  protected String a(String... paramVarArgs)
  {
    if (super.isCancelled()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a(paramVarArgs[0], paramVarArgs[1]);
  }
  
  protected void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "{\"r\" : \"-100\"}";
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs("clientCallback", new String[] { nau.a(str), nau.a(this.jdField_a_of_type_JavaLangString) });
  }
  
  protected void a(Integer... paramVarArgs) {}
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
  
  protected void onPreExecute() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nns
 * JD-Core Version:    0.7.0.1
 */