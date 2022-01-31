import android.graphics.Bitmap;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lth
  extends ltg
{
  public Bitmap a;
  public byte[] a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String f;
  int g;
  int h;
  
  public lth()
  {
    this.jdField_f_of_type_Int = -1;
  }
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label205;
      }
      this.jdField_f_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("ismask", -1);
      this.g = this.jdField_a_of_type_OrgJsonJSONObject.optInt("peer_gender");
      this.c = bbea.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_ennick", null));
      this.d = bbea.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("ensessionname", null));
      this.e = this.jdField_a_of_type_OrgJsonJSONObject.optString("headurl", null);
      if (!this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("oldproto", false)) {
        break label164;
      }
      if (QLog.isColorLevel()) {
        QLog.w("RandomWebProtocol", 2, "[1v1] parse method is oldproto");
      }
      this.jdField_b_of_type_JavaLangString = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_enuin", null));
      this.jdField_a_of_type_ArrayOfByte = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("vaskey", null));
    }
    label164:
    label205:
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      this.jdField_b_of_type_JavaLangString = ChatActivityUtils.a(RandomWebProtocol.a(), bbea.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_enuin", null)));
      this.jdField_a_of_type_ArrayOfByte = bbea.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("vaskey", null));
      return;
    }
    this.h = Math.max(this.jdField_a_of_type_OrgJsonJSONObject.optInt("waittime"), 200);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("uniqkey", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lth
 * JD-Core Version:    0.7.0.1
 */