import android.content.Context;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class lbb
  extends laj
{
  lbb(lba paramlba, Long paramLong, Context paramContext, List paramList, Language paramLanguage, lbm paramlbm) {}
  
  public void a(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    try
    {
      lba.a(this.jdField_a_of_type_Lba).jdField_a_of_type_JavaLangString = paramJSONObject.getString("access_token");
      lba.a(this.jdField_a_of_type_Lba).jdField_a_of_type_Long = (paramJSONObject.getLong("expires_in") * 1000L + this.jdField_a_of_type_JavaLangLong.longValue());
      lba.a(this.jdField_a_of_type_Lba, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComRookeryTranslateTypeLanguage, lba.a(this.jdField_a_of_type_Lba).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangLong, this.jdField_a_of_type_Lbm);
      return;
    }
    catch (JSONException paramArrayOfHeader)
    {
      this.jdField_a_of_type_Lbm.a(new TranslateError(paramArrayOfHeader), this.jdField_a_of_type_JavaLangLong);
    }
  }
  
  public void a(Throwable paramThrowable, String paramString)
  {
    this.jdField_a_of_type_Lbm.a(new TranslateError(paramThrowable), this.jdField_a_of_type_JavaLangLong);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "error:" + paramThrowable + "\trequest_time:" + this.jdField_a_of_type_JavaLangLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     lbb
 * JD-Core Version:    0.7.0.1
 */