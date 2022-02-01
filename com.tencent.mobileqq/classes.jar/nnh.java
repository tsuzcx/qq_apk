import android.os.AsyncTask;
import android.text.TextUtils;

final class nnh
  extends AsyncTask<Void, Void, Void>
{
  String jdField_a_of_type_JavaLangString = "";
  
  nnh(nni paramnni, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = nng.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Nni.a();
      return;
    }
    this.jdField_a_of_type_Nni.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnh
 * JD-Core Version:    0.7.0.1
 */