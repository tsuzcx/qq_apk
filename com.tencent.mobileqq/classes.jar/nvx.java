import android.os.AsyncTask;
import android.text.TextUtils;

final class nvx
  extends AsyncTask<Void, Void, Void>
{
  String jdField_a_of_type_JavaLangString = "";
  
  nvx(nvy paramnvy, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangString = nvw.a(this.b);
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Nvy.a();
      return;
    }
    this.jdField_a_of_type_Nvy.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvx
 * JD-Core Version:    0.7.0.1
 */