import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class stv
{
  public static final String a = alpo.a(2131715045);
  public static final String b = alpo.a(2131715036);
  public static final String c = alpo.a(2131715040);
  public static final String d = alpo.a(2131715050);
  public static final String e = alpo.a(2131715038);
  public static final String f = alpo.a(2131715037);
  public static final String g = alpo.a(2131715035);
  public static final String h = alpo.a(2131715052);
  public static final String i = alpo.a(2131715044);
  public static final String j = alpo.a(2131715046);
  public static final String k = alpo.a(2131715049);
  public static final String l = alpo.a(2131715047);
  public static final String m = alpo.a(2131715054);
  public static final String n = alpo.a(2131715043);
  public static final String o = alpo.a(2131715039);
  public static final String p = alpo.a(2131715048);
  
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