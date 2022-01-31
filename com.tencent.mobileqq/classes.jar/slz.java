import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class slz<Respond extends slu>
{
  public int a;
  public long a;
  public sma<Respond> a;
  public int b;
  private int c;
  
  public slz()
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
  
  public abstract slu a(byte[] paramArrayOfByte);
  
  public sma<Respond> a()
  {
    return this.jdField_a_of_type_Sma;
  }
  
  public void a(sma<Respond> paramsma)
  {
    this.jdField_a_of_type_Sma = paramsma;
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
 * Qualified Name:     slz
 * JD-Core Version:    0.7.0.1
 */