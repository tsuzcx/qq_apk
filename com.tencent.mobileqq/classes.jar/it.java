import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class it
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  static int a(int paramInt)
  {
    if (paramInt < a.length) {
      return a[paramInt];
    }
    return -1;
  }
  
  private static int a(ii paramii, ErrorCorrectionLevel paramErrorCorrectionLevel, io paramio, is paramis)
  {
    int j = 2147483647;
    int k = -1;
    int i = 0;
    if (i < 8)
    {
      iw.a(paramii, paramErrorCorrectionLevel, paramio, i, paramis);
      int m = a(paramis);
      if (m >= j) {
        break label59;
      }
      k = i;
      j = m;
    }
    label59:
    for (;;)
    {
      i += 1;
      break;
      return k;
    }
  }
  
  private static int a(is paramis)
  {
    return iv.a(paramis) + iv.b(paramis) + iv.c(paramis) + iv.d(paramis);
  }
  
  private static Mode a(String paramString1, String paramString2)
  {
    int i = 0;
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1)) {
        return Mode.KANJI;
      }
      return Mode.BYTE;
    }
    int k = 0;
    int j = 0;
    if (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57)) {
        j = 1;
      }
      for (;;)
      {
        i += 1;
        break;
        if (a(m) == -1) {
          break label84;
        }
        k = 1;
      }
      label84:
      return Mode.BYTE;
    }
    if (k != 0) {
      return Mode.ALPHANUMERIC;
    }
    if (j != 0) {
      return Mode.NUMERIC;
    }
    return Mode.BYTE;
  }
  
  static ii a(ii paramii, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramii.b() != paramInt2) {
      throw new WriterException("Number of bits and data bytes does not match");
    }
    ArrayList localArrayList = new ArrayList(paramInt3);
    int k = 0;
    int i = 0;
    int m = 0;
    Object localObject1;
    int n;
    byte[] arrayOfByte;
    for (int j = 0; k < paramInt3; j = n + j)
    {
      localObject1 = new int[1];
      Object localObject2 = new int[1];
      a(paramInt1, paramInt2, paramInt3, k, (int[])localObject1, (int[])localObject2);
      n = localObject1[0];
      arrayOfByte = new byte[n];
      paramii.a(j * 8, arrayOfByte, 0, n);
      localObject2 = a(arrayOfByte, localObject2[0]);
      localArrayList.add(new ir(arrayOfByte, (byte[])localObject2));
      m = Math.max(m, n);
      i = Math.max(i, localObject2.length);
      n = localObject1[0];
      k += 1;
    }
    if (paramInt2 != j) {
      throw new WriterException("Data bytes does not match offset");
    }
    paramii = new ii();
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = ((ir)((Iterator)localObject1).next()).a();
        if (paramInt2 < arrayOfByte.length) {
          paramii.a(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = ((ir)((Iterator)localObject1).next()).b();
        if (paramInt2 < arrayOfByte.length) {
          paramii.a(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    if (paramInt1 != paramii.b()) {
      throw new WriterException("Interleaving error: " + paramInt1 + " and " + paramii.b() + " differ.");
    }
    return paramii;
  }
  
  private static io a(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    int i = 1;
    while (i <= 40)
    {
      io localio = io.a(i);
      if (localio.b() - localio.a(paramErrorCorrectionLevel).c() >= (paramInt + 7) / 8) {
        return localio;
      }
      i += 1;
    }
    throw new WriterException("Data too big");
  }
  
  public static ix a(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    if (paramMap == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "ISO-8859-1";
      }
      localObject1 = a(paramString, (String)localObject2);
      ii localii = new ii();
      if ((localObject1 == Mode.BYTE) && (!"ISO-8859-1".equals(localObject2)))
      {
        localObject3 = CharacterSetECI.getCharacterSetECIByName((String)localObject2);
        if (localObject3 != null) {
          a((CharacterSetECI)localObject3, localii);
        }
      }
      a((Mode)localObject1, localii);
      localObject3 = new ii();
      a(paramString, (Mode)localObject1, (ii)localObject3, (String)localObject2);
      j = 0;
      i = j;
      if (paramMap != null)
      {
        i = j;
        if (paramMap.containsKey(EncodeHintType.QRCODE_VERSION)) {
          i = ((Integer)paramMap.get(EncodeHintType.QRCODE_VERSION)).intValue();
        }
      }
      int k = localii.a();
      if (i != 0) {
        break label362;
      }
      j = 40;
      label156:
      paramMap = a(((Mode)localObject1).getCharacterCountBits(io.a(j)) + k + ((ii)localObject3).a(), paramErrorCorrectionLevel);
      if (i != 0) {
        break label368;
      }
      label184:
      localObject2 = new ii();
      ((ii)localObject2).a(localii);
      if (localObject1 != Mode.BYTE) {
        break label412;
      }
    }
    label412:
    for (int i = ((ii)localObject3).b();; i = paramString.length())
    {
      a(i, paramMap, (Mode)localObject1, (ii)localObject2);
      ((ii)localObject2).a((ii)localObject3);
      paramString = paramMap.a(paramErrorCorrectionLevel);
      i = paramMap.b() - paramString.c();
      a(i, (ii)localObject2);
      paramString = a((ii)localObject2, paramMap.b(), i, paramString.b());
      localObject2 = new ix();
      ((ix)localObject2).a(paramErrorCorrectionLevel);
      ((ix)localObject2).a((Mode)localObject1);
      ((ix)localObject2).a(paramMap);
      i = paramMap.c();
      localObject1 = new is(i, i);
      i = a(paramString, paramErrorCorrectionLevel, paramMap, (is)localObject1);
      ((ix)localObject2).a(i);
      iw.a(paramString, paramErrorCorrectionLevel, paramMap, i, (is)localObject1);
      ((ix)localObject2).a((is)localObject1);
      return localObject2;
      localObject1 = (String)paramMap.get(EncodeHintType.CHARACTER_SET);
      break;
      label362:
      j = i;
      break label156;
      label368:
      if (i >= paramMap.a())
      {
        paramMap = io.a(i);
        break label184;
      }
      throw new WriterException("Requested version is too small: " + i);
    }
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramInt4 >= paramInt3) {
      throw new WriterException("Block ID too large");
    }
    int i = paramInt1 % paramInt3;
    int j = paramInt3 - i;
    int k = paramInt1 / paramInt3;
    paramInt2 /= paramInt3;
    int m = paramInt2 + 1;
    int n = k - paramInt2;
    k = k + 1 - m;
    if (n != k) {
      throw new WriterException("EC bytes mismatch");
    }
    if (paramInt3 != j + i) {
      throw new WriterException("RS blocks mismatch");
    }
    if (paramInt1 != i * (m + k) + (paramInt2 + n) * j) {
      throw new WriterException("Total bytes mismatch");
    }
    if (paramInt4 < j)
    {
      paramArrayOfInt1[0] = paramInt2;
      paramArrayOfInt2[0] = n;
      return;
    }
    paramArrayOfInt1[0] = m;
    paramArrayOfInt2[0] = k;
  }
  
  static void a(int paramInt, ii paramii)
  {
    int k = paramInt << 3;
    if (paramii.a() > k) {
      throw new WriterException("data bits cannot fit in the QR Code" + paramii.a() + " > " + k);
    }
    int i = 0;
    while ((i < 4) && (paramii.a() < k))
    {
      paramii.a(false);
      i += 1;
    }
    i = paramii.a() & 0x7;
    if (i > 0) {
      while (i < 8)
      {
        paramii.a(false);
        i += 1;
      }
    }
    int m = paramii.b();
    i = 0;
    if (i < paramInt - m)
    {
      if ((i & 0x1) == 0) {}
      for (int j = 236;; j = 17)
      {
        paramii.a(j, 8);
        i += 1;
        break;
      }
    }
    if (paramii.a() != k) {
      throw new WriterException("Bits size does not equal capacity");
    }
  }
  
  static void a(int paramInt, io paramio, Mode paramMode, ii paramii)
  {
    int i = paramMode.getCharacterCountBits(paramio);
    if (paramInt >= 1 << i) {
      throw new WriterException(paramInt + " is bigger than " + ((1 << i) - 1));
    }
    paramii.a(paramInt, i);
  }
  
  private static void a(CharacterSetECI paramCharacterSetECI, ii paramii)
  {
    paramii.a(Mode.ECI.getBits(), 4);
    paramii.a(paramCharacterSetECI.getValue(), 8);
  }
  
  static void a(Mode paramMode, ii paramii)
  {
    paramii.a(paramMode.getBits(), 4);
  }
  
  static void a(CharSequence paramCharSequence, ii paramii)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = paramCharSequence.charAt(i) - '0';
      if (i + 2 < j)
      {
        paramii.a(k * 100 + (paramCharSequence.charAt(i + 1) - '0') * 10 + (paramCharSequence.charAt(i + 2) - '0'), 10);
        i += 3;
      }
      else if (i + 1 < j)
      {
        paramii.a(k * 10 + (paramCharSequence.charAt(i + 1) - '0'), 7);
        i += 2;
      }
      else
      {
        paramii.a(k, 4);
        i += 1;
      }
    }
  }
  
  static void a(String paramString1, Mode paramMode, ii paramii, String paramString2)
  {
    switch (iu.a[paramMode.ordinal()])
    {
    default: 
      throw new WriterException("Invalid mode: " + paramMode);
    case 1: 
      a(paramString1, paramii);
      return;
    case 2: 
      b(paramString1, paramii);
      return;
    case 3: 
      a(paramString1, paramii, paramString2);
      return;
    }
    a(paramString1, paramii);
  }
  
  static void a(String paramString, ii paramii)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramString = paramString.getBytes("Shift_JIS");
        int k = paramString.length;
        j = 0;
        if (j >= k) {
          break label136;
        }
        i = (paramString[j] & 0xFF) << 8 | paramString[(j + 1)] & 0xFF;
        if ((i >= 33088) && (i <= 40956))
        {
          i -= 33088;
          if (i != -1) {
            break label109;
          }
          throw new WriterException("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new WriterException(paramString);
      }
      if ((i >= 57408) && (i <= 60351))
      {
        i -= 49472;
        continue;
        label109:
        paramii.a((i & 0xFF) + (i >> 8) * 192, 13);
        j += 2;
      }
      else
      {
        label136:
        i = -1;
      }
    }
  }
  
  static void a(String paramString1, ii paramii, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes(paramString2);
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramii.a(paramString1[i], 8);
        i += 1;
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new WriterException(paramString1);
    }
  }
  
  private static boolean a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label68;
        }
        int k = paramString[i] & 0xFF;
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235))) {
          break;
        }
        i += 2;
      }
      label68:
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int k = paramArrayOfByte.length;
    int[] arrayOfInt = new int[k + paramInt];
    int i = 0;
    while (i < k)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    new im(ik.a).a(arrayOfInt, paramInt);
    paramArrayOfByte = new byte[paramInt];
    i = j;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt[(k + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  static void b(CharSequence paramCharSequence, ii paramii)
  {
    int j = paramCharSequence.length();
    int i = 0;
    while (i < j)
    {
      int k = a(paramCharSequence.charAt(i));
      if (k == -1) {
        throw new WriterException();
      }
      if (i + 1 < j)
      {
        int m = a(paramCharSequence.charAt(i + 1));
        if (m == -1) {
          throw new WriterException();
        }
        paramii.a(k * 45 + m, 11);
        i += 2;
      }
      else
      {
        paramii.a(k, 6);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     it
 * JD-Core Version:    0.7.0.1
 */