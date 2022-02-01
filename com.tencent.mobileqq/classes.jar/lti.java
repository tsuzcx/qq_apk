import com.tencent.av.random.RandomWebProtocol;
import org.json.JSONObject;

public class lti
  extends ltg
{
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public lti(RandomWebProtocol paramRandomWebProtocol, ltg paramltg, String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramRandomWebProtocol, paramltg);
    this.a = 2;
    this.c = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.c = paramInt;
    this.d = "[m] RequestMulti";
  }
  
  String a()
  {
    this.a = null;
    try
    {
      this.a = new JSONObject().put("session_type", this.c);
      return super.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lti
 * JD-Core Version:    0.7.0.1
 */