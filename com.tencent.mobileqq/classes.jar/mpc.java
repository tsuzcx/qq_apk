import java.util.List;

public class mpc
{
  public static final Object a;
  private static mpc jdField_b_of_type_Mpc;
  private static int jdField_c_of_type_Int;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private baig jdField_a_of_type_Baig;
  private String jdField_a_of_type_JavaLangString;
  private mpc jdField_a_of_type_Mpc;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static mpc a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Mpc != null)
      {
        mpc localmpc = jdField_b_of_type_Mpc;
        jdField_b_of_type_Mpc = localmpc.jdField_a_of_type_Mpc;
        localmpc.jdField_a_of_type_Mpc = null;
        jdField_c_of_type_Int -= 1;
        return localmpc;
      }
      return new mpc();
    }
  }
  
  public static void a(List<mpc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        mpc localmpc = (mpc)paramList.remove(i);
        if (localmpc != null) {
          localmpc.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_Baig;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Baig = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.e = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_c_of_type_Int < 200)
      {
        this.jdField_a_of_type_Mpc = jdField_b_of_type_Mpc;
        jdField_b_of_type_Mpc = this;
        jdField_c_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Baig = lmv.a(paramString, 16);
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    return "VideoChatMessage{type=" + this.jdField_a_of_type_Int + ", content='" + this.jdField_a_of_type_Baig + '\'' + ", filepath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", sendState=" + this.jdField_b_of_type_Int + ", time='" + this.jdField_b_of_type_JavaLangString + '\'' + ", header='" + this.jdField_c_of_type_JavaLangString + '\'' + ", imageUrl='" + this.d + '\'' + ", voiceTime=" + this.jdField_a_of_type_Long + ", msgId='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mpc
 * JD-Core Version:    0.7.0.1
 */