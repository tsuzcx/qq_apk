import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class scf
{
  public static final String a = ajyc.a(2131714662);
  public static final String b = ajyc.a(2131714653);
  public static final String c = ajyc.a(2131714657);
  public static final String d = ajyc.a(2131714667);
  public static final String e = ajyc.a(2131714655);
  public static final String f = ajyc.a(2131714654);
  public static final String g = ajyc.a(2131714652);
  public static final String h = ajyc.a(2131714669);
  public static final String i = ajyc.a(2131714661);
  public static final String j = ajyc.a(2131714663);
  public static final String k = ajyc.a(2131714666);
  public static final String l = ajyc.a(2131714664);
  public static final String m = ajyc.a(2131714671);
  public static final String n = ajyc.a(2131714660);
  public static final String o = ajyc.a(2131714656);
  public static final String p = ajyc.a(2131714665);
  
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
 * Qualified Name:     scf
 * JD-Core Version:    0.7.0.1
 */