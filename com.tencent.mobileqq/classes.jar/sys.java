import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class sys<Respond extends syn>
{
  public int a;
  public long a;
  public syt<Respond> a;
  public int b;
  private int c;
  
  public sys()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 2;
  }
  
  @NonNull
  public static List<ByteStringMicro> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public abstract String a();
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public abstract syn a(byte[] paramArrayOfByte);
  
  public syt<Respond> a()
  {
    return this.jdField_a_of_type_Syt;
  }
  
  public void a(syt<Respond> paramsyt)
  {
    this.jdField_a_of_type_Syt = paramsyt;
  }
  
  protected abstract byte[] a();
  
  public int b()
  {
    int i = this.c;
    String str = a();
    int j = i;
    if (i == 0)
    {
      j = i;
      if (str.length() > 0)
      {
        j = 0;
        while (j < str.length())
        {
          i = i * 31 + str.charAt(j);
          j += 1;
        }
        this.c = i;
        j = i;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sys
 * JD-Core Version:    0.7.0.1
 */