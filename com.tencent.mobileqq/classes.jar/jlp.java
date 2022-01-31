import com.tencent.av.random.RandomWebProtocol;
import org.json.JSONObject;

public class jlp
  extends jlk
{
  String b;
  
  jlp(RandomWebProtocol paramRandomWebProtocol) {}
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      this.b = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("roomowner"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jlp
 * JD-Core Version:    0.7.0.1
 */