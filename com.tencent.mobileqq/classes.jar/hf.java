import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class hf
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 0, 0, 0, 1 };
    int[] arrayOfInt2 = { 1, 0, 0, 0, 1 };
    int[] arrayOfInt3 = { 1, 1, 1, 1, 1 };
    b = new int[][] { { 1, 1, 1, 1, 1 }, arrayOfInt1, { 1, 0, 1, 0, 1 }, arrayOfInt2, arrayOfInt3 };
    arrayOfInt1 = new int[] { 6, 30, 54, 78, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 30, 56, 82, -1, -1, -1 };
    c = new int[][] { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, arrayOfInt1, arrayOfInt2, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
    arrayOfInt1 = new int[] { 8, 1 };
    arrayOfInt2 = new int[] { 7, 8 };
    arrayOfInt3 = new int[] { 4, 8 };
    int[] arrayOfInt4 = { 0, 8 };
    d = new int[][] { { 8, 0 }, arrayOfInt1, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, arrayOfInt2, { 5, 8 }, arrayOfInt3, { 3, 8 }, { 2, 8 }, { 1, 8 }, arrayOfInt4 };
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
  
  private static void a(int paramInt1, int paramInt2, hb paramhb)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramhb.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramhb.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, gr paramgr)
  {
    if (!hg.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramgr.a(paramInt, 5);
    paramgr.a(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new gr();
    paramErrorCorrectionLevel.a(21522, 15);
    paramgr.b(paramErrorCorrectionLevel);
    if (paramgr.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramgr.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, hb paramhb)
  {
    gr localgr = new gr();
    a(paramErrorCorrectionLevel, paramInt, localgr);
    paramInt = 0;
    if (paramInt < localgr.a())
    {
      boolean bool = localgr.a(localgr.a() - 1 - paramInt);
      paramhb.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramhb.a(paramhb.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramhb.a(8, paramhb.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(gr paramgr, int paramInt, hb paramhb)
  {
    int k = paramhb.b() - 1;
    int j = paramhb.a() - 1;
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
      if ((j >= 0) && (j < paramhb.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramhb.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramgr.a())
            {
              bool1 = paramgr.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (he.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramhb.a(i1, j, bool2);
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
        if (i != paramgr.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramgr.a());
        }
        return;
      }
    }
  }
  
  static void a(gr paramgr, ErrorCorrectionLevel paramErrorCorrectionLevel, gx paramgx, int paramInt, hb paramhb)
  {
    a(paramhb);
    a(paramgx, paramhb);
    a(paramErrorCorrectionLevel, paramInt, paramhb);
    b(paramgx, paramhb);
    a(paramgr, paramInt, paramhb);
  }
  
  static void a(gx paramgx, gr paramgr)
  {
    paramgr.a(paramgx.a(), 6);
    paramgr.a(a(paramgx.a(), 7973), 12);
    if (paramgr.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramgr.a());
    }
  }
  
  static void a(gx paramgx, hb paramhb)
  {
    d(paramhb);
    c(paramhb);
    c(paramgx, paramhb);
    b(paramhb);
  }
  
  static void a(hb paramhb)
  {
    paramhb.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, hb paramhb)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramhb.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramhb.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(gx paramgx, hb paramhb)
  {
    if (paramgx.a() < 7) {}
    for (;;)
    {
      return;
      gr localgr = new gr();
      a(paramgx, localgr);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localgr.a(i);
          i -= 1;
          paramhb.a(j, paramhb.a() - 11 + k, bool);
          paramhb.a(paramhb.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(hb paramhb)
  {
    int i = 8;
    while (i < paramhb.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramhb.a(i, 6))) {
        paramhb.a(i, 6, j);
      }
      if (a(paramhb.a(6, i))) {
        paramhb.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, hb paramhb)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramhb.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(gx paramgx, hb paramhb)
  {
    if (paramgx.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramgx.a() - 1;
      paramgx = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramgx[i];
          int n = paramgx[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramhb.a(n, m))) {
              c(n - 2, m - 2, paramhb);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(hb paramhb)
  {
    if (paramhb.a(8, paramhb.a() - 8) == 0) {
      throw new WriterException();
    }
    paramhb.a(8, paramhb.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, hb paramhb)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramhb.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(hb paramhb)
  {
    int i = a[0].length;
    d(0, 0, paramhb);
    d(paramhb.b() - i, 0, paramhb);
    d(0, paramhb.b() - i, paramhb);
    a(0, 7, paramhb);
    a(paramhb.b() - 8, 7, paramhb);
    a(0, paramhb.b() - 8, paramhb);
    b(7, 0, paramhb);
    b(paramhb.a() - 7 - 1, 0, paramhb);
    b(7, paramhb.a() - 7, paramhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     hf
 * JD-Core Version:    0.7.0.1
 */