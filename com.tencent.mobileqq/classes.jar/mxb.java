import com.tencent.avcore.jni.data.AVUserInfo;
import java.util.ArrayList;

public class mxb
{
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public static AVUserInfo a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    if ((paramArrayOfByte.length != paramInt) || (paramArrayOfByte.length < 16)) {
      return null;
    }
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 8);
    long l = a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 8, arrayOfByte, 0, 4);
    int i = a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, 4);
    int j = a(arrayOfByte);
    paramInt = 2;
    if (paramArrayOfByte.length > 16)
    {
      arrayOfByte = new byte[1];
      System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, 1);
      paramInt = arrayOfByte[0];
    }
    for (;;)
    {
      paramArrayOfByte = new AVUserInfo();
      paramArrayOfByte.account = l;
      paramArrayOfByte.accountType = i;
      paramArrayOfByte.pstnStatus = j;
      paramArrayOfByte.micAuthByAdmin = paramInt;
      if (mwv.c()) {
        mwv.a("MavJniUtil", "AVUserInfo-->Uin = " + l + " ,isPstn = " + i + " ,pstnState = " + j + " ,micOffByAdmin = " + paramInt);
      }
      return paramArrayOfByte;
      mwv.a("MavJniUtil", "getAVInfoFromByte", new Throwable("打印调用栈"));
    }
  }
  
  public static ArrayList<AVUserInfo> a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (mwv.c()) {
        mwv.b("MavJniUtil", "getAVInfoListFromByte--> buf is null");
      }
    }
    int i;
    ArrayList localArrayList;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return null;
          if (paramInt != 0) {
            break;
          }
        } while (!mwv.c());
        mwv.b("MavJniUtil", "getAVInfoListFromByte--> structLen is 0");
        return null;
        i = paramArrayOfByte.length;
        if (i % paramInt == 0) {
          break;
        }
      } while (!mwv.c());
      mwv.b("MavJniUtil", "getAVInfoListFromByte--> buf len is incorrect");
      return null;
      int j = i / paramInt;
      localArrayList = new ArrayList();
      i = 0;
      if (i >= j) {
        break label162;
      }
      localObject = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, i * paramInt, localObject, 0, paramInt);
      localObject = a((byte[])localObject, paramInt);
      if (localObject != null) {
        break;
      }
    } while (!mwv.c());
    mwv.b("MavJniUtil", "Can not get AVUserInfo...Error");
    return null;
    if ((((AVUserInfo)localObject).accountType == 1) && (((AVUserInfo)localObject).pstnStatus != 3)) {}
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(localObject);
    }
    label162:
    if (mwv.c()) {
      mwv.a("MavJniUtil", "getAVInfoListFromByte --> length = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static long[] a(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong2 = null;
    long[] arrayOfLong1 = arrayOfLong2;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length >= 8) {
        break label25;
      }
      arrayOfLong1 = arrayOfLong2;
    }
    label25:
    int i;
    do
    {
      return arrayOfLong1;
      i = paramArrayOfByte.length;
      arrayOfLong1 = arrayOfLong2;
    } while (i % 8 != 0);
    arrayOfLong2 = new long[i / 8];
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    for (;;)
    {
      arrayOfLong1 = arrayOfLong2;
      if (i < 8) {
        break;
      }
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 8);
      long l = a(arrayOfByte);
      if (l == 0L)
      {
        mwv.c("MavJniUtil", "getUinListFromBuf-->get the wrong uin==0");
        return arrayOfLong2;
      }
      arrayOfLong2[(j / 8)] = l;
      j += 8;
      i -= 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxb
 * JD-Core Version:    0.7.0.1
 */