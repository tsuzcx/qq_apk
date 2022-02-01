package com.tencent.mobileqq.easysync2;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.easysync2.utils.StringPairComparator;
import com.tencent.mobileqq.easysync2.utils.Utils;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Changeset
{
  public static int a = 36;
  public static boolean b = true;
  static HeaderParser g;
  private static final Pattern h = Pattern.compile("[^\n]*(?:\n|[^\n]$)");
  private static Pattern i;
  public int c;
  public int d;
  public String e;
  public String f;
  
  public static AText a(AText paramAText)
  {
    return new AText(paramAText.a, paramAText.b);
  }
  
  public static AText a(String paramString, AText paramAText, AttribPool paramAttribPool)
  {
    return new AText(a(paramString, paramAText.a), a(paramString, paramAText.b, paramAttribPool));
  }
  
  public static AText a(String paramString, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localSmartOpAssembler.a('+', paramString, paramList, paramAttribPool);
    return new AText(paramString, localSmartOpAssembler.toString());
  }
  
  static AttributeTester a(Pair<String, String> paramPair, AttribPool paramAttribPool)
  {
    Changeset.5 local5 = new Changeset.5();
    if (paramAttribPool == null) {
      return local5;
    }
    int j = paramAttribPool.a(paramPair, true);
    if (j < 0) {
      return local5;
    }
    paramPair = new StringBuilder();
    paramPair.append("\\*");
    paramPair.append(a(j));
    paramPair.append("(?!\\w)");
    return new Changeset.6(Pattern.compile(paramPair.toString()));
  }
  
  public static CloneResult a(String paramString, AttribPool paramAttribPool)
  {
    AttribPool localAttribPool = new AttribPool();
    return new CloneResult(a(paramString, paramAttribPool, localAttribPool), localAttribPool);
  }
  
  public static Operation a(char paramChar)
  {
    Operation localOperation = new Operation();
    localOperation.a = paramChar;
    return localOperation;
  }
  
  public static String a(char paramChar, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    if ((paramAttribPool != null) && (paramList != null) && (paramList.size() > 0))
    {
      Object localObject = paramList;
      if (paramList.size() > 1)
      {
        localObject = new ArrayList(paramList);
        Collections.sort((List)localObject, new StringPairComparator());
      }
      paramList = new StringBuilder();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if ((paramChar == '=') || ((paramChar == '+') && (!Utils.a((String)localPair.second))))
        {
          paramList.append('*');
          paramList.append(a(paramAttribPool.a(localPair)));
        }
      }
      return paramList.toString();
    }
    return "";
  }
  
  static String a(int paramInt)
  {
    return Integer.toString(paramInt, Utils.a);
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramInt2 -= paramInt1;
    Object localObject;
    if (paramInt2 >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('>');
      ((StringBuilder)localObject).append(a(paramInt2));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('<');
      ((StringBuilder)localObject).append(a(-paramInt2));
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf('Z'));
    localStringBuilder.append(':');
    localStringBuilder.append(a(paramInt1));
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString1);
    localStringBuilder.append("$");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = e(paramString);
    int n = ((Changeset)localObject1).c;
    int i1 = ((Changeset)localObject1).d;
    Object localObject2 = ((Changeset)localObject1).e;
    localObject1 = ((Changeset)localObject1).f;
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localObject2 = d((String)localObject2);
    int j = 0;
    int k = 0;
    int m = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Operation localOperation = (Operation)((Iterator)localObject2).next();
      int i2 = localOperation.a;
      boolean bool;
      if (i2 != 43)
      {
        if (i2 != 45)
        {
          if (i2 == 61)
          {
            k += localOperation.b;
            j += localOperation.b;
          }
        }
        else
        {
          k += localOperation.b;
          if (k <= n) {
            bool = true;
          } else {
            bool = false;
          }
          a(bool, new Object[] { Integer.valueOf(k), " > ", Integer.valueOf(n), " in ", paramString });
        }
      }
      else
      {
        j += localOperation.b;
        m += localOperation.b;
        if (j <= i1) {
          bool = true;
        } else {
          bool = false;
        }
        a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(i1), " in ", paramString });
      }
      localSmartOpAssembler.a(localOperation);
    }
    for (localObject1 = ((String)localObject1).substring(0, m); ((String)localObject1).length() < m; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("?");
    }
    localSmartOpAssembler.a();
    a(a(n, j + (n - k), localSmartOpAssembler.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, OpZipProcessor paramOpZipProcessor)
  {
    Iterator localIterator1 = a(paramString1, paramInt1);
    Iterator localIterator2 = a(paramString2, paramInt2);
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    paramString2 = new Operation();
    paramString1 = new Operation();
    Operation localOperation = new Operation();
    for (;;)
    {
      if ((paramString2.a == 0) && (!localIterator1.hasNext()) && (paramString1.a == 0) && (!localIterator2.hasNext()))
      {
        localSmartOpAssembler.a();
        return localSmartOpAssembler.toString();
      }
      Object localObject1 = paramString2;
      if (paramString2.a == 0)
      {
        localObject1 = paramString2;
        if (localIterator1.hasNext()) {
          localObject1 = (Operation)localIterator1.next();
        }
      }
      Object localObject2 = paramString1;
      if (paramString1.a == 0)
      {
        localObject2 = paramString1;
        if (localIterator2.hasNext()) {
          localObject2 = (Operation)localIterator2.next();
        }
      }
      paramOpZipProcessor.a((Operation)localObject1, (Operation)localObject2, localOperation);
      paramString1 = (String)localObject2;
      paramString2 = (String)localObject1;
      if (localOperation.a != 0)
      {
        localSmartOpAssembler.a(localOperation);
        localOperation.a = '\000';
        paramString1 = (String)localObject2;
        paramString2 = (String)localObject1;
      }
    }
  }
  
  public static String a(String paramString, AttribPool paramAttribPool1, AttribPool paramAttribPool2)
  {
    int k = paramString.indexOf('$');
    int j = k;
    if (k < 0) {
      j = paramString.length();
    }
    String str = paramString.substring(0, j);
    paramString = paramString.substring(j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(str, "\\*([0-9a-z]+)", new Changeset.7(paramAttribPool1, paramAttribPool2)));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = e(paramString1);
    boolean bool;
    if (paramString2.length() == ((Changeset)localObject).c) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((Changeset)localObject).c) });
    paramString1 = d(((Changeset)localObject).e);
    localObject = new StringIterator(((Changeset)localObject).f);
    paramString2 = new StringIterator(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramString1.hasNext())
    {
      Operation localOperation = (Operation)paramString1.next();
      int j = localOperation.a;
      if (j != 43)
      {
        if (j != 45)
        {
          if (j == 61) {
            localStringBuilder.append(paramString2.a(localOperation.b));
          }
        }
        else {
          paramString2.c(localOperation.b);
        }
      }
      else {
        localStringBuilder.append(((StringIterator)localObject).a(localOperation.b));
      }
    }
    localStringBuilder.append(paramString2.a(paramString2.a()));
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    return a(paramString2, 0, e(paramString1).e, 0, new Changeset.3(paramAttribPool));
  }
  
  static String a(String paramString1, String paramString2, boolean paramBoolean, AttribPool paramAttribPool)
  {
    if ((Utils.a(paramString1)) && (paramBoolean)) {
      return paramString2;
    }
    if (Utils.a(paramString2)) {
      return paramString1;
    }
    ArrayList localArrayList = new ArrayList();
    Utils.a(paramString1, "\\*([0-9a-z]+)", new Changeset.1(localArrayList, paramAttribPool));
    Utils.a(paramString2, "\\*([0-9a-z]+)", new Changeset.2(paramAttribPool, localArrayList, paramBoolean));
    Collections.sort(localArrayList, new StringPairComparator());
    paramString1 = new StringBuilder();
    int j = 0;
    while (j < localArrayList.size())
    {
      paramString1.append('*');
      paramString1.append(a(paramAttribPool.a((Pair)localArrayList.get(j))));
      j += 1;
    }
    return paramString1.toString();
  }
  
  public static Iterator<Operation> a(String paramString, int paramInt)
  {
    return new OperationIterator(paramString.substring(paramInt));
  }
  
  public static void a(Operation paramOperation)
  {
    paramOperation.a = '\000';
    paramOperation.b = 0;
    paramOperation.c = 0;
    paramOperation.d = "";
  }
  
  public static void a(Operation paramOperation1, Operation paramOperation2)
  {
    paramOperation2.a = paramOperation1.a;
    paramOperation2.b = paramOperation1.b;
    paramOperation2.c = paramOperation1.c;
    paramOperation2.d = paramOperation1.d;
  }
  
  static void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, @NonNull AttribPool paramAttribPool)
  {
    if (paramOperation1.a == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.a = '\000';
      return;
    }
    if (paramOperation1.a == 0)
    {
      a(paramOperation2, paramOperation3);
      paramOperation2.a = '\000';
      return;
    }
    int j = paramOperation2.a;
    if (j != 0)
    {
      if (j != 43)
      {
        if (j != 45)
        {
          if (j != 61) {
            return;
          }
          j = paramOperation2.b;
          int k = paramOperation1.b;
          boolean bool2 = true;
          boolean bool1 = true;
          String str1;
          String str2;
          if (j <= k)
          {
            paramOperation3.a = paramOperation1.a;
            paramOperation3.b = paramOperation2.b;
            paramOperation3.c = paramOperation2.c;
            str1 = paramOperation1.d;
            str2 = paramOperation2.d;
            if (paramOperation1.a != '=') {
              bool1 = false;
            }
            paramOperation3.d = a(str1, str2, bool1, paramAttribPool);
            paramOperation2.a = '\000';
            paramOperation1.b -= paramOperation2.b;
            paramOperation1.c -= paramOperation2.c;
            if (paramOperation1.b == 0) {
              paramOperation1.a = '\000';
            }
          }
          else
          {
            paramOperation3.a = paramOperation1.a;
            paramOperation3.b = paramOperation1.b;
            paramOperation3.c = paramOperation1.c;
            str1 = paramOperation1.d;
            str2 = paramOperation2.d;
            if (paramOperation1.a == '=') {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramOperation3.d = a(str1, str2, bool1, paramAttribPool);
            paramOperation1.a = '\000';
            paramOperation2.b -= paramOperation1.b;
            paramOperation2.c -= paramOperation1.c;
          }
        }
        else if (paramOperation2.b <= paramOperation1.b)
        {
          if (paramOperation1.a == '=')
          {
            paramOperation3.a = '-';
            paramOperation3.b = paramOperation2.b;
            paramOperation3.c = paramOperation2.c;
            paramOperation3.d = "";
          }
          paramOperation1.b -= paramOperation2.b;
          paramOperation1.c -= paramOperation2.c;
          paramOperation2.a = '\000';
          if (paramOperation1.b == 0) {
            paramOperation1.a = '\000';
          }
        }
        else
        {
          if (paramOperation1.a == '=')
          {
            paramOperation3.a = '-';
            paramOperation3.b = paramOperation1.b;
            paramOperation3.c = paramOperation1.c;
            paramOperation3.d = "";
          }
          paramOperation2.b -= paramOperation1.b;
          paramOperation2.c -= paramOperation1.c;
          paramOperation1.a = '\000';
        }
      }
      else
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.a = '\000';
      }
    }
    else
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.a = '\000';
    }
  }
  
  static void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder("Changeset: ");
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        localStringBuilder.append(paramVarArgs[j]);
        j += 1;
      }
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramString = f(paramString).iterator();
    int j = 0;
    int k = paramInt2;
    paramInt2 = paramInt1;
    while (paramString.hasNext())
    {
      SpliceBean localSpliceBean = (SpliceBean)paramString.next();
      paramInt1 = localSpliceBean.a + j;
      int i1 = localSpliceBean.b + j;
      int n = localSpliceBean.c.length();
      int m = n - (i1 - paramInt1);
      if ((paramInt1 <= paramInt2) && (i1 >= k))
      {
        if (paramBoolean) {
          paramInt2 = paramInt1;
        } else {
          paramInt2 = paramInt1 + n;
        }
        paramInt1 = paramInt2;
      }
      else
      {
        if (i1 <= paramInt2) {
          paramInt2 += m;
        }
        do
        {
          paramInt1 = k + m;
          break;
          if (paramInt1 >= k)
          {
            paramInt1 = k;
            break;
          }
        } while ((paramInt1 >= paramInt2) && (i1 <= k));
        if (i1 < k)
        {
          k += m;
          paramInt2 = paramInt1 + n;
          paramInt1 = k;
        }
      }
      j += m;
      k = paramInt1;
    }
    return new int[] { paramInt2, k };
  }
  
  static int b(String paramString)
  {
    return Integer.parseInt(paramString, Utils.a);
  }
  
  public static AText b(String paramString1, String paramString2)
  {
    if (Utils.a(paramString2)) {
      paramString2 = g(paramString1);
    }
    return new AText(paramString1, paramString2);
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, paramInt, "", "");
  }
  
  public static String b(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    paramString1 = e(paramString1);
    paramString2 = e(paramString2);
    int j = paramString1.c;
    boolean bool;
    if (paramString1.d == paramString2.c) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, new Object[] { "mismatched composition" });
    int k = paramString2.d;
    StringIterator localStringIterator1 = new StringIterator(paramString1.f);
    StringIterator localStringIterator2 = new StringIterator(paramString2.f);
    StringBuilder localStringBuilder = new StringBuilder();
    return a(j, k, a(paramString1.e, 0, paramString2.e, 0, new Changeset.4(localStringIterator1, paramAttribPool, localStringBuilder, localStringIterator2)), localStringBuilder.toString());
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, AttribPool paramAttribPool)
  {
    Changeset localChangeset2 = e(paramString1);
    Changeset localChangeset1 = e(paramString2);
    boolean bool;
    if (localChangeset2.c == localChangeset1.c) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mismatched follow:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString2);
    a(bool, new Object[] { ((StringBuilder)localObject).toString() });
    localObject = new StringIterator(localChangeset2.f);
    StringIterator localStringIterator = new StringIterator(localChangeset1.f);
    int j = localChangeset2.d;
    paramString1 = new int[1];
    paramString2 = new int[1];
    AttributeTester localAttributeTester = a(new Pair("insertorder", "first"), paramAttribPool);
    paramAttribPool = a(localChangeset2.e, 0, localChangeset1.e, 0, new Changeset.11((StringIterator)localObject, localStringIterator, localAttributeTester, paramBoolean, paramAttribPool, paramString1, paramString2));
    paramString2[0] += j - paramString1[0];
    return a(j, paramString2[0], paramAttribPool, localChangeset1.f);
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    a(paramOperation2, paramOperation3);
    if (paramOperation1.a == 0)
    {
      paramOperation2.a = '\000';
      return;
    }
    if (paramOperation2.b <= paramOperation1.b)
    {
      paramOperation1.b -= paramOperation2.b;
      paramOperation1.c -= paramOperation2.c;
      paramOperation2.a = '\000';
      if (paramOperation1.b == 0) {
        paramOperation1.a = '\000';
      }
    }
    else
    {
      paramOperation3.c = paramOperation1.c;
      paramOperation3.b = paramOperation1.b;
      paramOperation2.c -= paramOperation1.c;
      paramOperation2.b -= paramOperation1.b;
      paramOperation1.a = '\000';
    }
  }
  
  static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, AttribPool paramAttribPool)
  {
    if (paramOperation1.a == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.a = '\000';
      return;
    }
    if (paramOperation1.a == 0)
    {
      a(paramOperation2, paramOperation3);
      paramOperation2.a = '\000';
      return;
    }
    int j = paramOperation2.a;
    if (j != 0)
    {
      if (j != 43)
      {
        if (j != 45)
        {
          if (j != 61) {
            return;
          }
          j = paramOperation2.b;
          int k = paramOperation1.b;
          boolean bool2 = true;
          boolean bool1 = true;
          String str1;
          String str2;
          if (j <= k)
          {
            paramOperation3.a = paramOperation1.a;
            paramOperation3.b = paramOperation2.b;
            paramOperation3.c = paramOperation2.c;
            str1 = paramOperation1.d;
            str2 = paramOperation2.d;
            if (paramOperation1.a != '=') {
              bool1 = false;
            }
            paramOperation3.d = a(str1, str2, bool1, paramAttribPool);
            paramOperation2.a = '\000';
            paramOperation1.b -= paramOperation2.b;
            paramOperation1.c -= paramOperation2.c;
            if (paramOperation1.b == 0) {
              paramOperation1.a = '\000';
            }
          }
          else
          {
            paramOperation3.a = paramOperation1.a;
            paramOperation3.b = paramOperation1.b;
            paramOperation3.c = paramOperation1.c;
            str1 = paramOperation1.d;
            str2 = paramOperation2.d;
            if (paramOperation1.a == '=') {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramOperation3.d = a(str1, str2, bool1, paramAttribPool);
            paramOperation1.a = '\000';
            paramOperation2.b -= paramOperation1.b;
            paramOperation2.c -= paramOperation1.c;
          }
        }
        else if (paramOperation2.b <= paramOperation1.b)
        {
          if (paramOperation1.a == '=')
          {
            paramOperation3.a = '-';
            paramOperation3.b = paramOperation2.b;
            paramOperation3.c = paramOperation2.c;
            paramOperation3.d = paramOperation2.d;
          }
          paramOperation1.b -= paramOperation2.b;
          paramOperation1.c -= paramOperation2.c;
          paramOperation2.a = '\000';
          if (paramOperation1.b == 0) {
            paramOperation1.a = '\000';
          }
        }
        else
        {
          if (paramOperation1.a == '=')
          {
            paramOperation3.a = '-';
            paramOperation3.b = paramOperation1.b;
            paramOperation3.c = paramOperation1.c;
            paramOperation3.d = paramOperation2.d;
          }
          paramOperation2.b -= paramOperation1.b;
          paramOperation2.c -= paramOperation1.c;
          paramOperation1.a = '\000';
        }
      }
      else
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.a = '\000';
      }
    }
    else
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.a = '\000';
    }
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, StringIterator paramStringIterator1, StringIterator paramStringIterator2, AttributeTester paramAttributeTester, boolean paramBoolean)
  {
    int k = paramOperation2.a;
    int j = 2;
    if (k != 43) {}
    String str1;
    String str2;
    boolean bool1;
    boolean bool2;
    do
    {
      j = 1;
      break;
      if (paramOperation1.a != '+') {
        break;
      }
      str1 = paramStringIterator1.b(1);
      str2 = paramStringIterator2.b(1);
      bool1 = paramAttributeTester.a(paramOperation1.d);
      bool2 = paramAttributeTester.a(paramOperation2.d);
    } while (((bool1) && (!bool2)) || (((!bool2) || (bool1)) && ((!str1.equals("\n")) || (str2.equals("\n"))) && (((!str1.equals("\n")) && (str2.equals("\n"))) || (!paramBoolean))));
    if (j == 1)
    {
      paramStringIterator1.c(paramOperation1.b);
      paramOperation3.a = '=';
      paramOperation3.c = paramOperation1.c;
      paramOperation3.b = paramOperation1.b;
      paramOperation3.d = "";
      paramOperation1.a = '\000';
      return;
    }
    paramStringIterator2.c(paramOperation2.b);
    a(paramOperation2, paramOperation3);
    paramOperation2.a = '\000';
  }
  
  public static int c(String paramString)
  {
    return e(paramString).d;
  }
  
  public static String c(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    if ((!Utils.a(paramString2)) && (paramAttribPool != null))
    {
      if (Utils.a(paramString1)) {
        return paramString2;
      }
      ArrayList localArrayList = new ArrayList();
      Utils.a(paramString2, "\\*([0-9a-z]+)", new Changeset.12(localArrayList, paramAttribPool));
      Utils.a(paramString1, "\\*([0-9a-z]+)", new Changeset.13(paramAttribPool, localArrayList));
      paramString1 = new StringBuilder();
      int j = 0;
      while (j < localArrayList.size())
      {
        paramString1.append('*');
        paramString1.append(a(paramAttribPool.a((Pair)localArrayList.get(j))));
        j += 1;
      }
      return paramString1.toString();
    }
    return "";
  }
  
  private static void c(Operation paramOperation1, Operation paramOperation2)
  {
    if (paramOperation2.a == 0)
    {
      paramOperation1.a = '\000';
      return;
    }
    if (paramOperation1.b <= paramOperation2.b)
    {
      paramOperation2.b -= paramOperation1.b;
      paramOperation2.c -= paramOperation1.c;
      paramOperation1.a = '\000';
      if (paramOperation2.b <= 0) {
        paramOperation2.a = '\000';
      }
    }
    else
    {
      paramOperation1.b -= paramOperation2.b;
      paramOperation1.c -= paramOperation2.c;
      paramOperation2.a = '\000';
    }
  }
  
  public static Iterator<Operation> d(String paramString)
  {
    return a(paramString, 0);
  }
  
  private static void d(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, AttribPool paramAttribPool)
  {
    paramOperation3.a = '=';
    paramOperation3.d = c(paramOperation1.d, paramOperation2.d, paramAttribPool);
    if (paramOperation1.b <= paramOperation2.b)
    {
      paramOperation3.b = paramOperation1.b;
      paramOperation3.c = paramOperation1.c;
      paramOperation2.b -= paramOperation1.b;
      paramOperation2.c -= paramOperation1.c;
      paramOperation1.a = '\000';
      if (paramOperation2.b == 0) {
        paramOperation2.a = '\000';
      }
    }
    else
    {
      paramOperation3.b = paramOperation2.b;
      paramOperation3.c = paramOperation2.c;
      paramOperation1.b -= paramOperation2.b;
      paramOperation1.c -= paramOperation2.c;
      paramOperation2.a = '\000';
    }
  }
  
  public static Changeset e(String paramString)
  {
    Object localObject1 = new Changeset();
    Object localObject2;
    int j;
    if (b)
    {
      localObject2 = g;
      if (localObject2 == null) {
        g = new HeaderParser();
      } else {
        ((HeaderParser)localObject2).a();
      }
      g.a(paramString);
      ((Changeset)localObject1).d = g.c;
      ((Changeset)localObject1).c = g.b;
      j = g.a;
    }
    else
    {
      if (i == null) {
        i = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
      }
      localObject2 = i.matcher(paramString);
      if ((!((Matcher)localObject2).find()) || (((Matcher)localObject2).group().length() == 0)) {
        break label238;
      }
      ((Changeset)localObject1).c = b(((Matcher)localObject2).group(1));
      if (">".equals(((Matcher)localObject2).group(2))) {
        j = 1;
      } else {
        j = -1;
      }
      k = b(((Matcher)localObject2).group(3));
      ((Changeset)localObject1).d = (((Changeset)localObject1).c + j * k);
      j = ((Matcher)localObject2).group().length();
    }
    int m = paramString.indexOf("$");
    int k = m;
    if (m < 0) {
      k = paramString.length();
    }
    ((Changeset)localObject1).e = paramString.substring(j, k);
    ((Changeset)localObject1).f = paramString.substring(k + 1);
    return localObject1;
    label238:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Not a exports: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public static List<SpliceBean> f(String paramString)
  {
    Object localObject1 = e(paramString);
    paramString = new ArrayList();
    Iterator localIterator = d(((Changeset)localObject1).e);
    localObject1 = new StringIterator(((Changeset)localObject1).f);
    int j = 0;
    int k = 0;
    while (localIterator.hasNext())
    {
      Operation localOperation = (Operation)localIterator.next();
      if (localOperation.a == '=')
      {
        k += localOperation.b;
        j = 0;
      }
      else
      {
        int m = j;
        if (j == 0)
        {
          paramString.add(new SpliceBean(k, k, ""));
          m = 1;
        }
        Object localObject2;
        if (localOperation.a == '-')
        {
          k += localOperation.b;
          localObject2 = (SpliceBean)paramString.get(paramString.size() - 1);
          ((SpliceBean)localObject2).b += localOperation.b;
          j = m;
        }
        else
        {
          j = m;
          if (localOperation.a == '+')
          {
            localObject2 = new StringBuilder();
            SpliceBean localSpliceBean = (SpliceBean)paramString.get(paramString.size() - 1);
            ((StringBuilder)localObject2).append(localSpliceBean.c);
            ((StringBuilder)localObject2).append(((StringIterator)localObject1).a(localOperation.b));
            localSpliceBean.c = ((StringBuilder)localObject2).toString();
            j = m;
          }
        }
      }
    }
    return paramString;
  }
  
  public static String g(String paramString)
  {
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localSmartOpAssembler.a('+', paramString);
    return localSmartOpAssembler.toString();
  }
  
  public static boolean h(String paramString)
  {
    paramString = e(paramString);
    return ("".equals(paramString.e)) && (paramString.c == paramString.d);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Changeset)) {
      return false;
    }
    paramObject = (Changeset)paramObject;
    return (this.c == paramObject.c) && (this.d == paramObject.d) && (Utils.a(this.e, paramObject.e)) && (Utils.a(this.f, paramObject.f));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), this.e, this.f });
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Changeset@");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("]: oldLen: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", newLen: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ops: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", charBank: ");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset
 * JD-Core Version:    0.7.0.1
 */