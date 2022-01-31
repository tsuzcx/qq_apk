import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class hd
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt2 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt3 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt12 = { 6, 30, 54, 78, 102, -1, -1 };
    int[] arrayOfInt13 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt14 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt15 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt16 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt17 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt18 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt19 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt20 = { 6, 34, 62, 90, 118, 146, -1 };
    int[] arrayOfInt21 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt22 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt23 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt24 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt1, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, arrayOfInt2, arrayOfInt3, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, arrayOfInt15, arrayOfInt16, { 6, 26, 52, 78, 104, 130, -1 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, arrayOfInt23, arrayOfInt24 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 3 };
    arrayOfInt3 = new int[] { 8, 4 };
    arrayOfInt4 = new int[] { 7, 8 };
    arrayOfInt5 = new int[] { 4, 8 };
    arrayOfInt6 = new int[] { 3, 8 };
    arrayOfInt7 = new int[] { 2, 8 };
    arrayOfInt8 = new int[] { 1, 8 };
    arrayOfInt9 = new int[] { 0, 8 };
    d = new int[][] { arrayOfInt1, { 8, 1 }, { 8, 2 }, arrayOfInt2, arrayOfInt3, { 8, 5 }, { 8, 7 }, { 8, 8 }, arrayOfInt4, { 5, 8 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9 };
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
  
  private static void a(int paramInt1, int paramInt2, gz paramgz)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramgz.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramgz.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, gp paramgp)
  {
    if (!he.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramgp.a(paramInt, 5);
    paramgp.a(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new gp();
    paramErrorCorrectionLevel.a(21522, 15);
    paramgp.b(paramErrorCorrectionLevel);
    if (paramgp.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramgp.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, gz paramgz)
  {
    gp localgp = new gp();
    a(paramErrorCorrectionLevel, paramInt, localgp);
    paramInt = 0;
    if (paramInt < localgp.a())
    {
      boolean bool = localgp.a(localgp.a() - 1 - paramInt);
      paramgz.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramgz.a(paramgz.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramgz.a(8, paramgz.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(gp paramgp, int paramInt, gz paramgz)
  {
    int k = paramgz.b() - 1;
    int j = paramgz.a() - 1;
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
      if ((j >= 0) && (j < paramgz.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramgz.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramgp.a())
            {
              bool1 = paramgp.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (hc.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramgz.a(i1, j, bool2);
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
        if (i != paramgp.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramgp.a());
        }
        return;
      }
    }
  }
  
  static void a(gp paramgp, ErrorCorrectionLevel paramErrorCorrectionLevel, gv paramgv, int paramInt, gz paramgz)
  {
    a(paramgz);
    a(paramgv, paramgz);
    a(paramErrorCorrectionLevel, paramInt, paramgz);
    b(paramgv, paramgz);
    a(paramgp, paramInt, paramgz);
  }
  
  static void a(gv paramgv, gp paramgp)
  {
    paramgp.a(paramgv.a(), 6);
    paramgp.a(a(paramgv.a(), 7973), 12);
    if (paramgp.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramgp.a());
    }
  }
  
  static void a(gv paramgv, gz paramgz)
  {
    d(paramgz);
    c(paramgz);
    c(paramgv, paramgz);
    b(paramgz);
  }
  
  static void a(gz paramgz)
  {
    paramgz.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, gz paramgz)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramgz.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramgz.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(gv paramgv, gz paramgz)
  {
    if (paramgv.a() < 7) {}
    for (;;)
    {
      return;
      gp localgp = new gp();
      a(paramgv, localgp);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localgp.a(i);
          i -= 1;
          paramgz.a(j, paramgz.a() - 11 + k, bool);
          paramgz.a(paramgz.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(gz paramgz)
  {
    int i = 8;
    while (i < paramgz.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramgz.a(i, 6))) {
        paramgz.a(i, 6, j);
      }
      if (a(paramgz.a(6, i))) {
        paramgz.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, gz paramgz)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramgz.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(gv paramgv, gz paramgz)
  {
    if (paramgv.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramgv.a() - 1;
      paramgv = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramgv[i];
          int n = paramgv[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramgz.a(n, m))) {
              c(n - 2, m - 2, paramgz);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(gz paramgz)
  {
    if (paramgz.a(8, paramgz.a() - 8) == 0) {
      throw new WriterException();
    }
    paramgz.a(8, paramgz.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, gz paramgz)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramgz.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(gz paramgz)
  {
    int i = a[0].length;
    d(0, 0, paramgz);
    d(paramgz.b() - i, 0, paramgz);
    d(0, paramgz.b() - i, paramgz);
    a(0, 7, paramgz);
    a(paramgz.b() - 8, 7, paramgz);
    a(0, paramgz.b() - 8, paramgz);
    b(7, 0, paramgz);
    b(paramgz.a() - 7 - 1, 0, paramgz);
    b(7, paramgz.a() - 7, paramgz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     hd
 * JD-Core Version:    0.7.0.1
 */