import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class mwe
{
  private static int d = 48;
  public int a;
  public long a;
  private mwg a;
  public int b;
  public int c;
  
  public mwe()
  {
    this.jdField_a_of_type_Mwg = new mwg();
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
  
  public static ArrayList<mwe> a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (mwv.c()) {
        mwv.b("AVInviteAccount", "getListFromBuffer detail is null");
      }
    }
    do
    {
      return null;
      if (paramInt != 0) {
        break;
      }
    } while (!mwv.c());
    mwv.b("AVInviteAccount", "getListFromBuffer buflen == 0");
    return null;
    int i = a(paramArrayOfByte, 0);
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        mwe localmwe = new mwe();
        localmwe.jdField_a_of_type_Int = a(paramArrayOfByte, d * paramInt + 4);
        localmwe.jdField_a_of_type_Long = a(paramArrayOfByte, d * paramInt + 4 + 8);
        try
        {
          localmwe.jdField_a_of_type_Mwg.a = new String(paramArrayOfByte, d * paramInt + 4 + 16, 5, "UTF-8");
          localmwe.jdField_a_of_type_Mwg.b = new String(paramArrayOfByte, d * paramInt + 4 + 21, 5, "UTF-8");
          localmwe.jdField_a_of_type_Mwg.c = new String(paramArrayOfByte, d * paramInt + 4 + 26, 12, "UTF-8");
          localmwe.b = a(paramArrayOfByte, d * paramInt + 4 + 40);
          localmwe.c = a(paramArrayOfByte, d * paramInt + 4 + 44);
          localArrayList.add(localmwe);
          paramInt += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            if (mwv.c()) {
              mwv.a("AVInviteAccount", "getListFromBuffer", localUnsupportedEncodingException);
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
      lvs.a(paramInt, paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwe
 * JD-Core Version:    0.7.0.1
 */