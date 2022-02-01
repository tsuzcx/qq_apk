import java.util.List;

public class mne
{
  public static final Object a;
  private static mne jdField_b_of_type_Mne;
  private static int jdField_c_of_type_Int;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private begp jdField_a_of_type_Begp;
  private String jdField_a_of_type_JavaLangString;
  private mne jdField_a_of_type_Mne;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static mne a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Mne != null)
      {
        mne localmne = jdField_b_of_type_Mne;
        jdField_b_of_type_Mne = localmne.jdField_a_of_type_Mne;
        localmne.jdField_a_of_type_Mne = null;
        jdField_c_of_type_Int -= 1;
        return localmne;
      }
      return new mne();
    }
  }
  
  public static void a(List<mne> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        mne localmne = (mne)paramList.remove(i);
        if (localmne != null) {
          localmne.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_Begp;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Begp = null;
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
        this.jdField_a_of_type_Mne = jdField_b_of_type_Mne;
        jdField_b_of_type_Mne = this;
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
    this.jdField_a_of_type_Begp = lkd.a(paramString, 16);
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
    return "VideoChatMessage{type=" + this.jdField_a_of_type_Int + ", content='" + this.jdField_a_of_type_Begp + '\'' + ", filepath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", sendState=" + this.jdField_b_of_type_Int + ", time='" + this.jdField_b_of_type_JavaLangString + '\'' + ", header='" + this.jdField_c_of_type_JavaLangString + '\'' + ", imageUrl='" + this.d + '\'' + ", voiceTime=" + this.jdField_a_of_type_Long + ", msgId='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mne
 * JD-Core Version:    0.7.0.1
 */