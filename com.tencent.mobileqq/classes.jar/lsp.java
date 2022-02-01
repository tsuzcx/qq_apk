import com.tencent.av.random.RandomWebProtocol;
import java.util.Random;
import org.json.JSONObject;

public class lsp
  extends lso
{
  int c;
  int d;
  int e;
  String f;
  
  public lsp(RandomWebProtocol paramRandomWebProtocol, lso paramlso, String paramString, int paramInt1, int paramInt2, int paramInt3, String... paramVarArgs)
  {
    super(paramRandomWebProtocol, paramlso);
    this.a = 1;
    this.c = paramString;
    this.d = paramInt1;
    this.c = paramInt2;
    this.e = paramInt3;
    if ((this.e == 2) && (paramVarArgs != null) && (paramVarArgs.length == 1)) {
      this.f = paramVarArgs[0];
    }
    this.d = "[d] RequestDouble";
  }
  
  String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = localJSONObject1;
    for (;;)
    {
      try
      {
        this.a = new JSONObject().put("peer_gender", this.c).put("session_type", this.d).put("reqtype", this.e);
        localObject = localJSONObject1;
        if (this.e == 2)
        {
          localObject = localJSONObject1;
          if (this.f != null)
          {
            localObject = localJSONObject1;
            this.a.put("uniqkey", this.f);
            localObject = localJSONObject1;
            JSONObject localJSONObject2 = new JSONObject(super.a());
            localObject = localJSONObject1;
            if (this.e != 1) {
              break label178;
            }
            localObject = localJSONObject1;
            i = this.b.a;
            localObject = localJSONObject1;
            localJSONObject1 = localJSONObject2.put("rand", i);
            localObject = localJSONObject1;
            return localJSONObject1.toString();
          }
        }
        localObject = localJSONObject1;
        if (this.e != 1) {
          continue;
        }
        localObject = localJSONObject1;
        this.b.a = new Random().nextInt();
        continue;
        localObject = localException;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return ((JSONObject)localObject).toString();
      }
      label178:
      int i = new Random().nextInt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lsp
 * JD-Core Version:    0.7.0.1
 */