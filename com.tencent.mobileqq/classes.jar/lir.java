import com.tencent.av.random.RandomWebProtocol;
import org.json.JSONObject;

public class lir
  extends lip
{
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public lir(RandomWebProtocol paramRandomWebProtocol, lip paramlip, String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramRandomWebProtocol, paramlip);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lir
 * JD-Core Version:    0.7.0.1
 */