import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class stv
{
  public static final String a = alud.a(2131715057);
  public static final String b = alud.a(2131715048);
  public static final String c = alud.a(2131715052);
  public static final String d = alud.a(2131715062);
  public static final String e = alud.a(2131715050);
  public static final String f = alud.a(2131715049);
  public static final String g = alud.a(2131715047);
  public static final String h = alud.a(2131715064);
  public static final String i = alud.a(2131715056);
  public static final String j = alud.a(2131715058);
  public static final String k = alud.a(2131715061);
  public static final String l = alud.a(2131715059);
  public static final String m = alud.a(2131715066);
  public static final String n = alud.a(2131715055);
  public static final String o = alud.a(2131715051);
  public static final String p = alud.a(2131715060);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stv
 * JD-Core Version:    0.7.0.1
 */