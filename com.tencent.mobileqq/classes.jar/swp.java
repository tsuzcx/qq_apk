import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;

public class swp
{
  public int a;
  public long a;
  public String a;
  
  public swp(swm paramswm, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    paramswm = ((spt)sqg.a(19)).a(paramString);
    if (paramswm != null) {
      a(paramswm);
    }
  }
  
  public void a(@NonNull MemoryInfoEntry paramMemoryInfoEntry)
  {
    this.jdField_a_of_type_Long = paramMemoryInfoEntry.seq;
    this.jdField_a_of_type_JavaLangString = paramMemoryInfoEntry.cookie;
    this.jdField_a_of_type_Int = paramMemoryInfoEntry.timeZone;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swp
 * JD-Core Version:    0.7.0.1
 */