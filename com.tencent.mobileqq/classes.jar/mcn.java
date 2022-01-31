import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;

public class mcn
{
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int n = 0;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramInt == 0))
    {
      QLog.e("PCMMixer", 1, "mix, dst == null || inputA == null || inputB == null || size == 0");
      return false;
    }
    if ((paramArrayOfByte2.length < paramInt) || (paramArrayOfByte3.length < paramInt))
    {
      QLog.e("PCMMixer", 1, "mix, inputA.length < size || inputB.length < size");
      return false;
    }
    System.currentTimeMillis();
    int i = paramInt / 2;
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { 2, i });
    i = 0;
    while (i < paramInt / 2)
    {
      arrayOfShort[0][i] = ((short)(paramArrayOfByte2[(i * 2)] & 0xFF | (paramArrayOfByte2[(i * 2 + 1)] & 0xFF) << 8));
      i += 1;
    }
    i = 0;
    while (i < paramInt / 2)
    {
      arrayOfShort[1][i] = ((short)(paramArrayOfByte3[(i * 2)] & 0xFF | (paramArrayOfByte3[(i * 2 + 1)] & 0xFF) << 8));
      i += 1;
    }
    paramArrayOfByte2 = new short[paramInt / 2];
    int k = 0;
    i = n;
    if (k < paramInt / 2)
    {
      int j = 0;
      int m;
      for (i = 0; j < 2; i = m)
      {
        m = i;
        if (arrayOfShort[j].length > k) {
          m = i + arrayOfShort[j][k];
        }
        j += 1;
      }
      if (i > 32767) {
        j = 32767;
      }
      for (;;)
      {
        paramArrayOfByte2[k] = ((short)j);
        k += 1;
        break;
        j = i;
        if (i < -32767) {
          j = -32767;
        }
      }
    }
    while (i < paramInt / 2)
    {
      paramArrayOfByte1[(i * 2)] = ((byte)(paramArrayOfByte2[i] & 0xFF));
      paramArrayOfByte1[(i * 2 + 1)] = ((byte)((paramArrayOfByte2[i] & 0xFF00) >> 8));
      i += 1;
    }
    System.currentTimeMillis();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcn
 * JD-Core Version:    0.7.0.1
 */