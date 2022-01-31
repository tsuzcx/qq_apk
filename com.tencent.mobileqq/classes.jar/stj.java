import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONException;
import org.json.JSONObject;

public class stj
{
  public long a;
  public String a;
  public byte[] a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public stj()
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("t", this.jdField_a_of_type_Long);
      localJSONObject.put("ak", bbea.a(this.jdField_a_of_type_ArrayOfByte));
      ((tcs)tcz.a(10)).b("SP_KEY_AUTHKEY_SERVER_INFO", localJSONObject.toString());
      ved.a("Q.qqstory.publish:VideoServerInfoManager", "save -> %s", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Long > NetConnInfoCenter.getServerTimeMillis())
    {
      ved.b("Q.qqstory.publish:VideoServerInfoManager", "server inf validate %s", this);
      return true;
    }
    ved.d("Q.qqstory.publish:VideoServerInfoManager", "server inf invalidate %s", new Object[] { this });
    return false;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Long <= NetConnInfoCenter.getServerTimeMillis() + 600000L;
  }
  
  public String toString()
  {
    return "ServerInfo{, userIp='" + this.jdField_a_of_type_JavaLangString + '\'' + ", serverIp1='" + this.b + '\'' + ", serverIp2='" + this.c + '\'' + ", backupServerIp1='" + this.d + '\'' + ", backupServerIp2='" + this.e + '\'' + ", expireTime=" + this.jdField_a_of_type_Long + "" + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     stj
 * JD-Core Version:    0.7.0.1
 */