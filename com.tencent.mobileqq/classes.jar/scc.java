import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class scc
{
  public static final String a = ajya.a(2131714673);
  public static final String b = ajya.a(2131714664);
  public static final String c = ajya.a(2131714668);
  public static final String d = ajya.a(2131714678);
  public static final String e = ajya.a(2131714666);
  public static final String f = ajya.a(2131714665);
  public static final String g = ajya.a(2131714663);
  public static final String h = ajya.a(2131714680);
  public static final String i = ajya.a(2131714672);
  public static final String j = ajya.a(2131714674);
  public static final String k = ajya.a(2131714677);
  public static final String l = ajya.a(2131714675);
  public static final String m = ajya.a(2131714682);
  public static final String n = ajya.a(2131714671);
  public static final String o = ajya.a(2131714667);
  public static final String p = ajya.a(2131714676);
  
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
 * Qualified Name:     scc
 * JD-Core Version:    0.7.0.1
 */