import android.os.AsyncTask;
import android.text.TextUtils;

final class nct
  extends AsyncTask<Void, Void, Void>
{
  String jdField_a_of_type_JavaLangString = "";
  
  nct(ncu paramncu, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = ncs.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Ncu.a();
      return;
    }
    this.jdField_a_of_type_Ncu.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nct
 * JD-Core Version:    0.7.0.1
 */