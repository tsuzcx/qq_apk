import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class he
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b;
  private static final int[][] c;
  private static final int[][] d;
  
  static
  {
    int[] arrayOfInt1 = { 1, 0, 1, 0, 1 };
    int[] arrayOfInt2 = { 1, 1, 1, 1, 1 };
    b = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, arrayOfInt1, { 1, 0, 0, 0, 1 }, arrayOfInt2 };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    int[] arrayOfInt3 = { 6, 22, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 30, -1, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 24, 42, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 28, 50, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 34, 62, -1, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt17 = { 6, 28, 50, 72, 94, -1, -1 };
    int[] arrayOfInt18 = { 6, 26, 50, 74, 98, -1, -1 };
    int[] arrayOfInt19 = { 6, 28, 54, 80, 106, -1, -1 };
    int[] arrayOfInt20 = { 6, 30, 58, 86, 114, -1, -1 };
    int[] arrayOfInt21 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt22 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt23 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt24 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt25 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt26 = { 6, 24, 50, 76, 102, 128, 154 };
    int[] arrayOfInt27 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt28 = { 6, 32, 58, 84, 110, 136, 162 };
    int[] arrayOfInt29 = { 6, 26, 54, 82, 110, 138, 166 };
    int[] arrayOfInt30 = { 6, 30, 58, 86, 114, 142, 170 };
    c = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 6, 34, -1, -1, -1, -1, -1 }, arrayOfInt6, arrayOfInt7, { 6, 26, 46, -1, -1, -1, -1 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, { 6, 26, 50, 74, -1, -1, -1 }, arrayOfInt14, arrayOfInt15, { 6, 30, 58, 86, -1, -1, -1 }, arrayOfInt16, arrayOfInt17, arrayOfInt18, { 6, 30, 54, 78, 102, -1, -1 }, arrayOfInt19, { 6, 32, 58, 84, 110, -1, -1 }, arrayOfInt20, arrayOfInt21, { 6, 26, 50, 74, 98, 122, -1 }, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, arrayOfInt26, arrayOfInt27, arrayOfInt28, arrayOfInt29, arrayOfInt30 };
    arrayOfInt1 = new int[] { 8, 0 };
    arrayOfInt2 = new int[] { 8, 1 };
    arrayOfInt3 = new int[] { 8, 3 };
    arrayOfInt4 = new int[] { 8, 4 };
    arrayOfInt5 = new int[] { 8, 7 };
    arrayOfInt6 = new int[] { 8, 8 };
    arrayOfInt7 = new int[] { 3, 8 };
    arrayOfInt8 = new int[] { 2, 8 };
    arrayOfInt9 = new int[] { 1, 8 };
    arrayOfInt10 = new int[] { 0, 8 };
    d = new int[][] { arrayOfInt1, arrayOfInt2, { 8, 2 }, arrayOfInt3, arrayOfInt4, { 8, 5 }, arrayOfInt5, arrayOfInt6, { 7, 8 }, { 5, 8 }, { 4, 8 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10 };
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
  
  private static void a(int paramInt1, int paramInt2, ha paramha)
  {
    int i = 0;
    while (i < 8)
    {
      if (!a(paramha.a(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramha.a(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, gq paramgq)
  {
    if (!hf.a(paramInt)) {
      throw new WriterException("Invalid mask pattern");
    }
    paramInt = paramErrorCorrectionLevel.getBits() << 3 | paramInt;
    paramgq.a(paramInt, 5);
    paramgq.a(a(paramInt, 1335), 10);
    paramErrorCorrectionLevel = new gq();
    paramErrorCorrectionLevel.a(21522, 15);
    paramgq.b(paramErrorCorrectionLevel);
    if (paramgq.a() != 15) {
      throw new WriterException("should not happen but we got: " + paramgq.a());
    }
  }
  
  static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ha paramha)
  {
    gq localgq = new gq();
    a(paramErrorCorrectionLevel, paramInt, localgq);
    paramInt = 0;
    if (paramInt < localgq.a())
    {
      boolean bool = localgq.a(localgq.a() - 1 - paramInt);
      paramha.a(d[paramInt][0], d[paramInt][1], bool);
      if (paramInt < 8) {
        paramha.a(paramha.b() - paramInt - 1, 8, bool);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramha.a(8, paramha.a() - 7 + (paramInt - 8), bool);
      }
    }
  }
  
  static void a(gq paramgq, int paramInt, ha paramha)
  {
    int k = paramha.b() - 1;
    int j = paramha.a() - 1;
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
      if ((j >= 0) && (j < paramha.a()))
      {
        int n = 0;
        while (n < 2)
        {
          int i1 = k - n;
          if (!a(paramha.a(i1, j)))
          {
            n += 1;
          }
          else
          {
            boolean bool1;
            if (i < paramgq.a())
            {
              bool1 = paramgq.a(i);
              i += 1;
              bool2 = bool1;
              if (paramInt != -1)
              {
                bool2 = bool1;
                if (hd.a(paramInt, i1, j)) {
                  if (bool1) {
                    break label162;
                  }
                }
              }
            }
            for (boolean bool2 = true;; bool2 = false)
            {
              paramha.a(i1, j, bool2);
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
        if (i != paramgq.a()) {
          throw new WriterException("Not all bits consumed: " + i + '/' + paramgq.a());
        }
        return;
      }
    }
  }
  
  static void a(gq paramgq, ErrorCorrectionLevel paramErrorCorrectionLevel, gw paramgw, int paramInt, ha paramha)
  {
    a(paramha);
    a(paramgw, paramha);
    a(paramErrorCorrectionLevel, paramInt, paramha);
    b(paramgw, paramha);
    a(paramgq, paramInt, paramha);
  }
  
  static void a(gw paramgw, gq paramgq)
  {
    paramgq.a(paramgw.a(), 6);
    paramgq.a(a(paramgw.a(), 7973), 12);
    if (paramgq.a() != 18) {
      throw new WriterException("should not happen but we got: " + paramgq.a());
    }
  }
  
  static void a(gw paramgw, ha paramha)
  {
    d(paramha);
    c(paramha);
    c(paramgw, paramha);
    b(paramha);
  }
  
  static void a(ha paramha)
  {
    paramha.a((byte)-1);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void b(int paramInt1, int paramInt2, ha paramha)
  {
    int i = 0;
    while (i < 7)
    {
      if (!a(paramha.a(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramha.a(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  static void b(gw paramgw, ha paramha)
  {
    if (paramgw.a() < 7) {}
    for (;;)
    {
      return;
      gq localgq = new gq();
      a(paramgw, localgq);
      int i = 17;
      int j = 0;
      while (j < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localgq.a(i);
          i -= 1;
          paramha.a(j, paramha.a() - 11 + k, bool);
          paramha.a(paramha.a() - 11 + k, j, bool);
          k += 1;
        }
        j += 1;
      }
    }
  }
  
  private static void b(ha paramha)
  {
    int i = 8;
    while (i < paramha.b() - 8)
    {
      int j = (i + 1) % 2;
      if (a(paramha.a(i, 6))) {
        paramha.a(i, 6, j);
      }
      if (a(paramha.a(6, i))) {
        paramha.a(6, i, j);
      }
      i += 1;
    }
  }
  
  private static void c(int paramInt1, int paramInt2, ha paramha)
  {
    int i = 0;
    while (i < 5)
    {
      int j = 0;
      while (j < 5)
      {
        paramha.a(paramInt1 + j, paramInt2 + i, b[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void c(gw paramgw, ha paramha)
  {
    if (paramgw.a() < 2) {}
    for (;;)
    {
      return;
      int i = paramgw.a() - 1;
      paramgw = c[i];
      int k = c[i].length;
      i = 0;
      while (i < k)
      {
        int j = 0;
        if (j < k)
        {
          int m = paramgw[i];
          int n = paramgw[j];
          if ((n == -1) || (m == -1)) {}
          for (;;)
          {
            j += 1;
            break;
            if (a(paramha.a(n, m))) {
              c(n - 2, m - 2, paramha);
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private static void c(ha paramha)
  {
    if (paramha.a(8, paramha.a() - 8) == 0) {
      throw new WriterException();
    }
    paramha.a(8, paramha.a() - 8, 1);
  }
  
  private static void d(int paramInt1, int paramInt2, ha paramha)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramha.a(paramInt1 + j, paramInt2 + i, a[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void d(ha paramha)
  {
    int i = a[0].length;
    d(0, 0, paramha);
    d(paramha.b() - i, 0, paramha);
    d(0, paramha.b() - i, paramha);
    a(0, 7, paramha);
    a(paramha.b() - 8, 7, paramha);
    a(0, paramha.b() - 8, paramha);
    b(7, 0, paramha);
    b(paramha.a() - 7 - 1, 0, paramha);
    b(7, paramha.a() - 7, paramha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     he
 * JD-Core Version:    0.7.0.1
 */