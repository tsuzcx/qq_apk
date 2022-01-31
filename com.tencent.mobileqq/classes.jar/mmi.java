import java.util.List;

public class mmi
{
  public static final Object a;
  private static mmi jdField_b_of_type_Mmi;
  private static int jdField_c_of_type_Int;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aykk jdField_a_of_type_Aykk;
  private String jdField_a_of_type_JavaLangString;
  private mmi jdField_a_of_type_Mmi;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static mmi a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Mmi != null)
      {
        mmi localmmi = jdField_b_of_type_Mmi;
        jdField_b_of_type_Mmi = localmmi.jdField_a_of_type_Mmi;
        localmmi.jdField_a_of_type_Mmi = null;
        jdField_c_of_type_Int -= 1;
        return localmmi;
      }
      return new mmi();
    }
  }
  
  public static void a(List<mmi> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        mmi localmmi = (mmi)paramList.remove(i);
        if (localmmi != null) {
          localmmi.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_Aykk;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aykk = null;
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
        this.jdField_a_of_type_Mmi = jdField_b_of_type_Mmi;
        jdField_b_of_type_Mmi = this;
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
    this.jdField_a_of_type_Aykk = lks.a(paramString, 16);
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
    return "VideoChatMessage{type=" + this.jdField_a_of_type_Int + ", content='" + this.jdField_a_of_type_Aykk + '\'' + ", filepath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", sendState=" + this.jdField_b_of_type_Int + ", time='" + this.jdField_b_of_type_JavaLangString + '\'' + ", header='" + this.jdField_c_of_type_JavaLangString + '\'' + ", imageUrl='" + this.d + '\'' + ", voiceTime=" + this.jdField_a_of_type_Long + ", msgId='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmi
 * JD-Core Version:    0.7.0.1
 */