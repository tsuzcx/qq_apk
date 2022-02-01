import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class nbr
{
  private static int d = 48;
  public int a;
  public long a;
  private nbt a;
  public int b;
  public int c;
  
  public nbr()
  {
    this.jdField_a_of_type_Nbt = new nbt();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i + paramInt)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i + paramInt)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public static ArrayList<nbr> a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (ncl.c()) {
        ncl.b("AVInviteAccount", "getListFromBuffer detail is null");
      }
    }
    do
    {
      return null;
      if (paramInt != 0) {
        break;
      }
    } while (!ncl.c());
    ncl.b("AVInviteAccount", "getListFromBuffer buflen == 0");
    return null;
    int i = a(paramArrayOfByte, 0);
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        nbr localnbr = new nbr();
        localnbr.jdField_a_of_type_Int = a(paramArrayOfByte, d * paramInt + 4);
        localnbr.jdField_a_of_type_Long = a(paramArrayOfByte, d * paramInt + 4 + 8);
        try
        {
          localnbr.jdField_a_of_type_Nbt.a = new String(paramArrayOfByte, d * paramInt + 4 + 16, 5, "UTF-8");
          localnbr.jdField_a_of_type_Nbt.b = new String(paramArrayOfByte, d * paramInt + 4 + 21, 5, "UTF-8");
          localnbr.jdField_a_of_type_Nbt.c = new String(paramArrayOfByte, d * paramInt + 4 + 26, 12, "UTF-8");
          localnbr.b = a(paramArrayOfByte, d * paramInt + 4 + 40);
          localnbr.c = a(paramArrayOfByte, d * paramInt + 4 + 44);
          localArrayList.add(localnbr);
          paramInt += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            if (ncl.c()) {
              ncl.a("AVInviteAccount", "getListFromBuffer", localUnsupportedEncodingException);
            }
          }
        }
      }
    }
    i = d * i + 4;
    paramInt = a(paramArrayOfByte, i);
    i += 4;
    int j = a(paramArrayOfByte, i);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, i + 4, j, "UTF-8");
      QLog.d("AVInviteAccount", 1, String.format("getListFromBuffer retCode[%d], tips length[%d], tips[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramArrayOfByte }));
      lwf.a(paramInt, paramArrayOfByte);
      return localArrayList;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbr
 * JD-Core Version:    0.7.0.1
 */