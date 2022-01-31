import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class rpn
{
  public static final String a = ajjy.a(2131648873);
  public static final String b = ajjy.a(2131648864);
  public static final String c = ajjy.a(2131648868);
  public static final String d = ajjy.a(2131648878);
  public static final String e = ajjy.a(2131648866);
  public static final String f = ajjy.a(2131648865);
  public static final String g = ajjy.a(2131648863);
  public static final String h = ajjy.a(2131648880);
  public static final String i = ajjy.a(2131648872);
  public static final String j = ajjy.a(2131648874);
  public static final String k = ajjy.a(2131648877);
  public static final String l = ajjy.a(2131648875);
  public static final String m = ajjy.a(2131648882);
  public static final String n = ajjy.a(2131648871);
  public static final String o = ajjy.a(2131648867);
  public static final String p = ajjy.a(2131648876);
  
  public static String a(List<?> paramList)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramList);
    paramList = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
    localObjectOutputStream.close();
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpn
 * JD-Core Version:    0.7.0.1
 */