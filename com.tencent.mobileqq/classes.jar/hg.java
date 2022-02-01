import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class hg
{
  private static final int[][] a;
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 0, 0, 1 };
    a = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt1, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt2, { 1, 1, 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 1, 1, 1, 1, 1 };
    arrayOfInt2 = new int[] { 1, 0, 1, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 0, 0, 1 };
    int[] arrayOfInt4 = { 1, 1, 1, 1, 1 };
    b = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 1 }, arrayOfInt2, arrayOfInt3, arrayOfInt4 };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    arrayOfInt4 = new int[] { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 30, -1, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 50, 74, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 30, 58, 86, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt17 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt18 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt19 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt20 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt21 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt22 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt23 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt24 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt25 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt26 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt27 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt6, { 6, 24, 42, -1, -1, -1, -1 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, { 6, 34, 62, 90, -1, -1, -1 }, arrayOfInt16, arrayOfInt17, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, arrayOfInt18, arrayOfInt19, arrayOfInt20, { 6, 30, 54, 78, 102, 126, -1 }, arrayOfInt21, { 6, 30, 56, 82, 108, 134, -1 }, arrayOfInt22, arrayOfInt23, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27 };
    arrayOfInt1 = new int[] { 8, 4 };
    d = new int[][] { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, arrayOfInt1, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
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
  
  private static void a(int paramInt1, int paramInt2, hc paramhc)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramhc.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramhc.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, gs paramgs)
  {
    if (!hh.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramgs.a(paramInt, 5);
    paramgs.a(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new gs();
    paramErrorCorrectionLevel.a(21522, 15);
    paramgs.b(paramErrorCorrectionLevel);
    if (paramgs.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramgs.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, hc paramhc)
  {
    gs localgs = new gs();
    a(paramErrorCorrectionLevel, paramInt, localgs);
    paramInt = 0;
    if (paramInt < localgs.a())
    {
      boolean bool = localgs.a(localgs.a() - 1 - paramInt);
      paramhc.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramhc.a(paramhc.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramhc.a(8, paramhc.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(gs paramgs, int paramInt, hc paramhc)
  {
    int k = paramhc.b() - 1;
    int j = paramhc.a() - 1;
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
      if ((j >= 0) && (j < paramhc.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramhc.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramgs.a())
            {
              bool1 = paramgs.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (hf.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramhc.a(i1, j, bool2);
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
        if (i != paramgs.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramgs.a());
        }
        return;
      }
    }
  }
  
  static void a(gs paramgs, ErrorCorrectionLevel paramErrorCorrectionLevel, gy paramgy, int paramInt, hc paramhc)
  {
    a(paramhc);
    a(paramgy, paramhc);
    a(paramErrorCorrectionLevel, paramInt, paramhc);
    b(paramgy, paramhc);
    a(paramgs, paramInt, paramhc);
  }
  
  static void a(gy paramgy, gs paramgs)
  {
    paramgs.a(paramgy.a(), 6);
    paramgs.a(a(paramgy.a(), 7973), 12);
    if (paramgs.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramgs.a());
    }
  }
  
  static void a(gy paramgy, hc paramhc)
  {
    d(paramhc);
    c(paramhc);
    c(paramgy, paramhc);
    b(paramhc);
  }
  
  static void a(hc paramhc)
  {
    paramhc.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, hc paramhc)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramhc.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramhc.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(gy paramgy, hc paramhc)
  {
    if (paramgy.a() < 7) {}
    for (;;)
    {
      return;
      gs localgs = new gs();
      a(paramgy, localgs);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localgs.a(i);
          i -= 1;
          paramhc.a(j, paramhc.a() - 11 + k, bool);
          paramhc.a(paramhc.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(hc paramhc)
  {
    int i = 8;
    while (i < paramhc.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramhc.a(i, 6))) {
        paramhc.a(i, 6, j);
      }
      if (a(paramhc.a(6, i))) {
        paramhc.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, hc paramhc)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramhc.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(gy paramgy, hc paramhc)
  {
    if (paramgy.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramgy.a() - 1;
      paramgy = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramgy[i];
          int n = paramgy[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramhc.a(n, m))) {
              c(n - 2, m - 2, paramhc);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(hc paramhc)
  {
    if (paramhc.a(8, paramhc.a() - 8) == 0) {
      throw new WriterException();
    }
    paramhc.a(8, paramhc.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, hc paramhc)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramhc.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(hc paramhc)
  {
    int i = a[0].length;
    d(0, 0, paramhc);
    d(paramhc.b() - i, 0, paramhc);
    d(0, paramhc.b() - i, paramhc);
    a(0, 7, paramhc);
    a(paramhc.b() - 8, 7, paramhc);
    a(0, paramhc.b() - 8, paramhc);
    b(7, 0, paramhc);
    b(paramhc.a() - 7 - 1, 0, paramhc);
    b(7, paramhc.a() - 7, paramhc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     hg
 * JD-Core Version:    0.7.0.1
 */