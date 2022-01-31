import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class iw
{
  private static final int[][] a;
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1, 1, 1, 1, 1, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt4 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt5 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt6 = { 1, 1, 1, 1, 1, 1, 1 };
    a = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt4, arrayOfInt5, arrayOfInt6 };
    arrayOfInt1 = new int[] { 1, 1, 1, 1, 1 };
    arrayOfInt2 = new int[] { 1, 0, 0, 0, 1 };
    arrayOfInt3 = new int[] { 1, 0, 0, 0, 1 };
    b = new int[][] { arrayOfInt1, arrayOfInt2, { 1, 0, 1, 0, 1 }, arrayOfInt3, { 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 26, -1, -1, -1, -1, -1 };
    arrayOfInt5 = new int[] { 6, 30, -1, -1, -1, -1, -1 };
    arrayOfInt6 = new int[] { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt17 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt18 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt19 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt20 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt21 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt22 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt23 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt24 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt25 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt26 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt27 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt28 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt29 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt30 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt31 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt32 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt33 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt34 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt35 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 6, 30, 54, -1, -1, -1, -1 }, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 6, 26, 48, 70, -1, -1, -1 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, { 6, 26, 50, 74, 98, -1, -1 }, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, { 6, 26, 52, 78, 104, 130, -1 }, arrayOfInt26, arrayOfInt27, arrayOfInt28, arrayOfInt29, arrayOfInt30, arrayOfInt31, arrayOfInt32, arrayOfInt33, arrayOfInt34, arrayOfInt35 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 2 };
    arrayOfInt3 = new int[] { 8, 5 };
    arrayOfInt4 = new int[] { 8, 7 };
    arrayOfInt5 = new int[] { 4, 8 };
    arrayOfInt6 = new int[] { 2, 8 };
    arrayOfInt7 = new int[] { 1, 8 };
    d = new int[][] { arrayOfInt1, { 8, 1 }, arrayOfInt2, { 8, 3 }, { 8, 4 }, arrayOfInt3, arrayOfInt4, { 8, 8 }, { 7, 8 }, { 5, 8 }, arrayOfInt5, { 3, 8 }, arrayOfInt6, arrayOfInt7, { 0, 8 } };
  }
  
  static int a(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt2);
    paramInt1 <<= i - 1;
    while (a(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << a(paramInt1) - i;
    }
    return paramInt1;
  }
  
  private static void a(int paramInt1, int paramInt2, is paramis)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramis.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramis.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ii paramii)
  {
    if (!ix.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramii.a(paramInt, 5);
    paramii.a(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new ii();
    paramErrorCorrectionLevel.a(21522, 15);
    paramii.b(paramErrorCorrectionLevel);
    if (paramii.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramii.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, is paramis)
  {
    ii localii = new ii();
    a(paramErrorCorrectionLevel, paramInt, localii);
    paramInt = 0;
    if (paramInt < localii.a())
    {
      boolean bool = localii.a(localii.a() - 1 - paramInt);
      paramis.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramis.a(paramis.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramis.a(8, paramis.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(ii paramii, int paramInt, is paramis)
  {
    int k = paramis.b() - 1;
    int j = paramis.a() - 1;
    int m = -1;
    int i = 0;
    if (k > 0)
    {
      if (k != 6) {
        break label247;
      }
      k -= 1;
    }
    label111:
    label247:
    for (;;)
    {
      if ((j >= 0) && (j < paramis.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramis.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramii.a())
            {
              bool1 = paramii.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (iv.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramis.a(i1, j, bool2);
              break;
              bool1 = false;
              break label111;
            }
          }
        }
        j += m;
      }
      else
      {
        m = -m;
        k -= 2;
        j += m;
        break;
        if (i != paramii.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramii.a());
        }
        return;
      }
    }
  }
  
  static void a(ii paramii, ErrorCorrectionLevel paramErrorCorrectionLevel, io paramio, int paramInt, is paramis)
  {
    a(paramis);
    a(paramio, paramis);
    a(paramErrorCorrectionLevel, paramInt, paramis);
    b(paramio, paramis);
    a(paramii, paramInt, paramis);
  }
  
  static void a(io paramio, ii paramii)
  {
    paramii.a(paramio.a(), 6);
    paramii.a(a(paramio.a(), 7973), 12);
    if (paramii.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramii.a());
    }
  }
  
  static void a(io paramio, is paramis)
  {
    d(paramis);
    c(paramis);
    c(paramio, paramis);
    b(paramis);
  }
  
  static void a(is paramis)
  {
    paramis.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, is paramis)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramis.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramis.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(io paramio, is paramis)
  {
    if (paramio.a() < 7) {}
    for (;;)
    {
      return;
      ii localii = new ii();
      a(paramio, localii);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localii.a(i);
          i -= 1;
          paramis.a(j, paramis.a() - 11 + k, bool);
          paramis.a(paramis.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(is paramis)
  {
    int i = 8;
    while (i < paramis.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramis.a(i, 6))) {
        paramis.a(i, 6, j);
      }
      if (a(paramis.a(6, i))) {
        paramis.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, is paramis)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramis.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(io paramio, is paramis)
  {
    if (paramio.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramio.a() - 1;
      paramio = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramio[i];
          int n = paramio[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramis.a(n, m))) {
              c(n - 2, m - 2, paramis);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(is paramis)
  {
    if (paramis.a(8, paramis.a() - 8) == 0) {
      throw new WriterException();
    }
    paramis.a(8, paramis.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, is paramis)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramis.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(is paramis)
  {
    int i = a[0].length;
    d(0, 0, paramis);
    d(paramis.b() - i, 0, paramis);
    d(0, paramis.b() - i, paramis);
    a(0, 7, paramis);
    a(paramis.b() - 8, 7, paramis);
    a(0, paramis.b() - 8, paramis);
    b(7, 0, paramis);
    b(paramis.a() - 7 - 1, 0, paramis);
    b(7, paramis.a() - 7, paramis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     iw
 * JD-Core Version:    0.7.0.1
 */