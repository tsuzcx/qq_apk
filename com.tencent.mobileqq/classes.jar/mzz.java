import android.os.AsyncTask;
import android.text.TextUtils;

final class mzz
  extends AsyncTask<Void, Void, Void>
{
  String jdField_a_of_type_JavaLangString = "";
  
  mzz(naa paramnaa, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = mzy.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Naa.a();
      return;
    }
    this.jdField_a_of_type_Naa.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mzz
 * JD-Core Version:    0.7.0.1
 */