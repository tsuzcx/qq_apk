import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class ldf
  extends lcn
{
  ldf(lde paramlde, Long paramLong, Context paramContext, List paramList, Language paramLanguage, ldq paramldq) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    try
    {
      lde.a(this.jdField_a_of_type_Lde).jdField_a_of_type_JavaLangString = paramJSONObject.getString("access_token");
      lde.a(this.jdField_a_of_type_Lde).jdField_a_of_type_Long = (paramJSONObject.getLong("expires_in") * 1000L + this.jdField_a_of_type_JavaLangLong.longValue());
      lde.a(this.jdField_a_of_type_Lde, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, lde.a(this.jdField_a_of_type_Lde).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Ldq);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      this.jdField_a_of_type_Ldq.a(new TranslateError(paramArrayOfHeader), this.jdField_a_of_type_JavaLangLong);
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_Ldq.a(new TranslateError(paramThrowable), this.jdField_a_of_type_JavaLangLong);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "error:" + paramThrowable + "\trequest_time:" + this.jdField_a_of_type_JavaLangLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ldf
 * JD-Core Version:    0.7.0.1
 */