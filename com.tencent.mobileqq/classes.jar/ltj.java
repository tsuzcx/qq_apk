import com.tencent.av.random.RandomWebProtocol;
import org.json.JSONObject;

public class ltj
  extends ltg
{
  public boolean a;
  public String b;
  public String c;
  public int f = -1;
  public int g = -1;
  
  public ltj(RandomWebProtocol paramRandomWebProtocol) {}
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((2 == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      this.f = this.jdField_a_of_type_OrgJsonJSONObject.optInt("ismask", -1);
      this.b = this.jdField_a_of_type_OrgJsonJSONObject.optString("groupids");
      this.g = this.jdField_a_of_type_OrgJsonJSONObject.optInt("businessid", -1);
      this.c = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("roomowner"));
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("ownerenable", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ltj
 * JD-Core Version:    0.7.0.1
 */