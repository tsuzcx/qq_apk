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
  public static int a;
  static HeaderParser jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  public static boolean a;
  private static Pattern b;
  public String a;
  public int b;
  public String b;
  public int c;
  
  static
  {
    jdField_a_of_type_Int = 36;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^\n]*(?:\n|[^\n]$)");
    jdField_a_of_type_Boolean = true;
  }
  
  static int a(String paramString)
  {
    return Integer.parseInt(paramString, Utils.jdField_a_of_type_Int);
  }
  
  public static AText a(AText paramAText)
  {
    return new AText(paramAText.jdField_a_of_type_JavaLangString, paramAText.jdField_b_of_type_JavaLangString);
  }
  
  public static AText a(String paramString, AText paramAText, AttribPool paramAttribPool)
  {
    return new AText(a(paramString, paramAText.jdField_a_of_type_JavaLangString), a(paramString, paramAText.jdField_b_of_type_JavaLangString, paramAttribPool));
  }
  
  public static AText a(String paramString1, String paramString2)
  {
    if (!Utils.a(paramString2)) {}
    for (;;)
    {
      return new AText(paramString1, paramString2);
      paramString2 = b(paramString1);
    }
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
    if (paramAttribPool == null) {}
    int i;
    do
    {
      return local5;
      i = paramAttribPool.a(paramPair, true);
    } while (i < 0);
    return new Changeset.6(Pattern.compile("\\*" + a(i) + "(?!\\w)"));
  }
  
  public static Changeset a(String paramString)
  {
    int i = 1;
    Changeset localChangeset = new Changeset();
    if (jdField_a_of_type_Boolean)
    {
      if (jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser == null) {
        jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser = new HeaderParser();
      }
      for (;;)
      {
        jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.a(paramString);
        localChangeset.c = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.c;
        localChangeset.jdField_b_of_type_Int = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.jdField_b_of_type_Int;
        i = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.jdField_a_of_type_Int;
        int k = paramString.indexOf("$");
        int j = k;
        if (k < 0) {
          j = paramString.length();
        }
        localChangeset.jdField_a_of_type_JavaLangString = paramString.substring(i, j);
        localChangeset.jdField_b_of_type_JavaLangString = paramString.substring(j + 1);
        return localChangeset;
        jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.a();
      }
    }
    if (jdField_b_of_type_JavaUtilRegexPattern == null) {
      jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
    }
    Matcher localMatcher = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
    if ((!localMatcher.find()) || (localMatcher.group().length() == 0)) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    localChangeset.jdField_b_of_type_Int = a(localMatcher.group(1));
    if (">".equals(localMatcher.group(2))) {}
    for (;;)
    {
      localChangeset.c = (i * a(localMatcher.group(3)) + localChangeset.jdField_b_of_type_Int);
      i = localMatcher.group().length();
      break;
      i = -1;
    }
  }
  
  public static CloneResult a(String paramString, AttribPool paramAttribPool)
  {
    AttribPool localAttribPool = new AttribPool();
    return new CloneResult(a(paramString, paramAttribPool, localAttribPool), localAttribPool);
  }
  
  public static Operation a(char paramChar)
  {
    Operation localOperation = new Operation();
    localOperation.jdField_a_of_type_Char = paramChar;
    return localOperation;
  }
  
  public static String a(char paramChar, List<Pair<String, String>> paramList, AttribPool paramAttribPool)
  {
    if ((paramAttribPool == null) || (paramList == null) || (paramList.size() <= 0)) {
      return "";
    }
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
      if ((paramChar == '=') || ((paramChar == '+') && (!Utils.a((String)localPair.second)))) {
        paramList.append('*').append(a(paramAttribPool.a(localPair)));
      }
    }
    return paramList.toString();
  }
  
  static String a(int paramInt)
  {
    return Integer.toString(paramInt, Utils.jdField_a_of_type_Int);
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    paramInt2 -= paramInt1;
    if (paramInt2 >= 0) {}
    for (String str = '>' + a(paramInt2);; str = '<' + a(-paramInt2)) {
      return String.valueOf('Z') + ':' + a(paramInt1) + str + paramString1 + "$" + paramString2;
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = a(paramString);
    int m = ((Changeset)localObject1).jdField_b_of_type_Int;
    int n = ((Changeset)localObject1).c;
    Object localObject2 = ((Changeset)localObject1).jdField_a_of_type_JavaLangString;
    localObject1 = ((Changeset)localObject1).jdField_b_of_type_JavaLangString;
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localObject2 = a((String)localObject2);
    int j = 0;
    int i = 0;
    int k = 0;
    if (((Iterator)localObject2).hasNext())
    {
      Operation localOperation = (Operation)((Iterator)localObject2).next();
      switch (localOperation.jdField_a_of_type_Char)
      {
      default: 
      case '=': 
        for (;;)
        {
          localSmartOpAssembler.a(localOperation);
          break;
          j += localOperation.jdField_a_of_type_Int;
          i += localOperation.jdField_a_of_type_Int;
        }
      case '-': 
        j = localOperation.jdField_a_of_type_Int + j;
        if (j <= m) {}
        for (bool = true;; bool = false)
        {
          a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(m), " in ", paramString });
          break;
        }
      }
      i = localOperation.jdField_a_of_type_Int + i;
      int i1 = localOperation.jdField_a_of_type_Int;
      if (i <= n) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, new Object[] { Integer.valueOf(i), " > ", Integer.valueOf(n), " in ", paramString });
        k = i1 + k;
        break;
      }
    }
    for (localObject1 = ((String)localObject1).substring(0, k); ((String)localObject1).length() < k; localObject1 = (String)localObject1 + "?") {}
    localSmartOpAssembler.a();
    a(a(m, i + (m - j), localSmartOpAssembler.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, OpZipProcessor paramOpZipProcessor)
  {
    Iterator localIterator1 = a(paramString1, paramInt1);
    Iterator localIterator2 = a(paramString2, paramInt2);
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    paramString1 = new Operation();
    paramString2 = new Operation();
    Operation localOperation = new Operation();
    if ((paramString1.jdField_a_of_type_Char != 0) || (localIterator1.hasNext()) || (paramString2.jdField_a_of_type_Char != 0) || (localIterator2.hasNext()))
    {
      if ((paramString1.jdField_a_of_type_Char != 0) || (!localIterator1.hasNext())) {
        break label190;
      }
      paramString1 = (Operation)localIterator1.next();
    }
    label190:
    for (;;)
    {
      if ((paramString2.jdField_a_of_type_Char == 0) && (localIterator2.hasNext())) {
        paramString2 = (Operation)localIterator2.next();
      }
      for (;;)
      {
        paramOpZipProcessor.a(paramString1, paramString2, localOperation);
        if (localOperation.jdField_a_of_type_Char != 0)
        {
          localSmartOpAssembler.a(localOperation);
          localOperation.jdField_a_of_type_Char = '\000';
          break;
          localSmartOpAssembler.a();
          return localSmartOpAssembler.toString();
        }
        break;
      }
    }
  }
  
  public static String a(String paramString, AttribPool paramAttribPool1, AttribPool paramAttribPool2)
  {
    int j = paramString.indexOf('$');
    int i = j;
    if (j < 0) {
      i = paramString.length();
    }
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i);
    return Utils.a(str, "\\*([0-9a-z]+)", new Changeset.7(paramAttribPool1, paramAttribPool2)) + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramString2.length() == ((Changeset)localObject).jdField_b_of_type_Int)
    {
      bool = true;
      a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((Changeset)localObject).jdField_b_of_type_Int) });
      paramString1 = a(((Changeset)localObject).jdField_a_of_type_JavaLangString);
      localObject = new StringIterator(((Changeset)localObject).jdField_b_of_type_JavaLangString);
      paramString2 = new StringIterator(paramString2);
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      if (!paramString1.hasNext()) {
        break label212;
      }
      Operation localOperation = (Operation)paramString1.next();
      switch (localOperation.jdField_a_of_type_Char)
      {
      default: 
        break;
      case '+': 
        localStringBuilder.append(((StringIterator)localObject).a(localOperation.jdField_a_of_type_Int));
        continue;
        bool = false;
        break;
      case '-': 
        paramString2.a(localOperation.jdField_a_of_type_Int);
        break;
      case '=': 
        localStringBuilder.append(paramString2.a(localOperation.jdField_a_of_type_Int));
      }
    }
    label212:
    localStringBuilder.append(paramString2.a(paramString2.a()));
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    return a(paramString2, 0, a(paramString1).jdField_a_of_type_JavaLangString, 0, new Changeset.3(paramAttribPool));
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
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString1.append('*');
      paramString1.append(a(paramAttribPool.a((Pair)localArrayList.get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  public static Iterator<Operation> a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static Iterator<Operation> a(String paramString, int paramInt)
  {
    return new OperationIterator(paramString.substring(paramInt));
  }
  
  public static List<SpliceBean> a(String paramString)
  {
    Object localObject1 = a(paramString);
    paramString = new ArrayList();
    Iterator localIterator = a(((Changeset)localObject1).jdField_a_of_type_JavaLangString);
    localObject1 = new StringIterator(((Changeset)localObject1).jdField_b_of_type_JavaLangString);
    int i = 0;
    int j = 0;
    Operation localOperation;
    int k;
    while (localIterator.hasNext())
    {
      localOperation = (Operation)localIterator.next();
      if (localOperation.jdField_a_of_type_Char == '=')
      {
        k = localOperation.jdField_a_of_type_Int;
        i = 0;
        j += k;
      }
      else
      {
        if (i != 0) {
          break label249;
        }
        paramString.add(new SpliceBean(j, j, ""));
        i = 1;
      }
    }
    label249:
    for (;;)
    {
      Object localObject2;
      if (localOperation.jdField_a_of_type_Char == '-')
      {
        k = localOperation.jdField_a_of_type_Int;
        localObject2 = (SpliceBean)paramString.get(paramString.size() - 1);
        int m = ((SpliceBean)localObject2).jdField_b_of_type_Int;
        ((SpliceBean)localObject2).jdField_b_of_type_Int = (localOperation.jdField_a_of_type_Int + m);
        j += k;
        break;
      }
      if (localOperation.jdField_a_of_type_Char == '+')
      {
        localObject2 = new StringBuilder();
        SpliceBean localSpliceBean = (SpliceBean)paramString.get(paramString.size() - 1);
        localSpliceBean.jdField_a_of_type_JavaLangString += ((StringIterator)localObject1).a(localOperation.jdField_a_of_type_Int);
      }
      break;
      return paramString;
    }
  }
  
  public static void a(Operation paramOperation)
  {
    paramOperation.jdField_a_of_type_Char = '\000';
    paramOperation.jdField_a_of_type_Int = 0;
    paramOperation.jdField_b_of_type_Int = 0;
    paramOperation.jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(Operation paramOperation1, Operation paramOperation2)
  {
    paramOperation2.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
    paramOperation2.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
    paramOperation2.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
    paramOperation2.jdField_a_of_type_JavaLangString = paramOperation1.jdField_a_of_type_JavaLangString;
  }
  
  static void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, @NonNull AttribPool paramAttribPool)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramOperation1.jdField_a_of_type_Char == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (paramOperation1.jdField_a_of_type_Char == 0)
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.jdField_a_of_type_Char = '\000';
        return;
      }
      switch (paramOperation2.jdField_a_of_type_Char)
      {
      default: 
        return;
      case '\000': 
        a(paramOperation1, paramOperation3);
        paramOperation1.jdField_a_of_type_Char = '\000';
        return;
      case '-': 
        if (paramOperation2.jdField_a_of_type_Int > paramOperation1.jdField_a_of_type_Int) {
          break label196;
        }
        if (paramOperation1.jdField_a_of_type_Char == '=')
        {
          paramOperation3.jdField_a_of_type_Char = '-';
          paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
          paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
          paramOperation3.jdField_a_of_type_JavaLangString = "";
        }
        paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
        paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
    } while (paramOperation1.jdField_a_of_type_Int != 0);
    paramOperation1.jdField_a_of_type_Char = '\000';
    return;
    label196:
    if (paramOperation1.jdField_a_of_type_Char == '=')
    {
      paramOperation3.jdField_a_of_type_Char = '-';
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation3.jdField_a_of_type_JavaLangString = "";
    }
    paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
    paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
    paramOperation1.jdField_a_of_type_Char = '\000';
    return;
    a(paramOperation2, paramOperation3);
    paramOperation2.jdField_a_of_type_Char = '\000';
    return;
    if (paramOperation2.jdField_a_of_type_Int <= paramOperation1.jdField_a_of_type_Int)
    {
      paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
      paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
      str1 = paramOperation1.jdField_a_of_type_JavaLangString;
      str2 = paramOperation2.jdField_a_of_type_JavaLangString;
      if (paramOperation1.jdField_a_of_type_Char == '=') {}
      for (;;)
      {
        paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
        paramOperation2.jdField_a_of_type_Char = '\000';
        paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
        paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
        if (paramOperation1.jdField_a_of_type_Int != 0) {
          break;
        }
        paramOperation1.jdField_a_of_type_Char = '\000';
        return;
        bool1 = false;
      }
    }
    paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
    paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
    paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
    String str1 = paramOperation1.jdField_a_of_type_JavaLangString;
    String str2 = paramOperation2.jdField_a_of_type_JavaLangString;
    if (paramOperation1.jdField_a_of_type_Char == '=') {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
      paramOperation1.jdField_a_of_type_Char = '\000';
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      return;
    }
  }
  
  static void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder("Changeset: ");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = a(paramString);
    return ("".equals(paramString.jdField_a_of_type_JavaLangString)) && (paramString.jdField_b_of_type_Int == paramString.c);
  }
  
  public static int[] a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramString = a(paramString).iterator();
    int j = 0;
    int k = paramInt2;
    int m = paramInt1;
    if (paramString.hasNext())
    {
      SpliceBean localSpliceBean = (SpliceBean)paramString.next();
      int i = localSpliceBean.jdField_a_of_type_Int + j;
      int i1 = localSpliceBean.jdField_b_of_type_Int + j;
      int i2 = localSpliceBean.jdField_a_of_type_JavaLangString.length();
      int n = i2 - (i1 - i);
      if ((i <= m) && (i1 >= k)) {
        if (paramBoolean)
        {
          paramInt1 = i;
          paramInt2 = i;
        }
      }
      for (;;)
      {
        j += n;
        m = paramInt2;
        k = paramInt1;
        break;
        paramInt1 = i + i2;
        paramInt2 = paramInt1;
        continue;
        if (i1 <= m)
        {
          paramInt2 = m + n;
          paramInt1 = k + n;
        }
        else
        {
          paramInt2 = m;
          paramInt1 = k;
          if (i < k) {
            if ((i >= m) && (i1 <= k))
            {
              paramInt1 = k + n;
              paramInt2 = m;
            }
            else if (i1 < k)
            {
              paramInt2 = i + i2;
              paramInt1 = k + n;
            }
            else
            {
              paramInt1 = i;
              paramInt2 = m;
            }
          }
        }
      }
    }
    return new int[] { m, k };
  }
  
  public static int b(String paramString)
  {
    return a(paramString).c;
  }
  
  public static String b(int paramInt)
  {
    return a(paramInt, paramInt, "", "");
  }
  
  public static String b(String paramString)
  {
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localSmartOpAssembler.a('+', paramString);
    return localSmartOpAssembler.toString();
  }
  
  public static String b(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    paramString1 = a(paramString1);
    paramString2 = a(paramString2);
    int i = paramString1.jdField_b_of_type_Int;
    if (paramString1.c == paramString2.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched composition" });
      int j = paramString2.c;
      StringIterator localStringIterator1 = new StringIterator(paramString1.jdField_b_of_type_JavaLangString);
      StringIterator localStringIterator2 = new StringIterator(paramString2.jdField_b_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      return a(i, j, a(paramString1.jdField_a_of_type_JavaLangString, 0, paramString2.jdField_a_of_type_JavaLangString, 0, new Changeset.4(localStringIterator1, paramAttribPool, localStringBuilder, localStringIterator2)), localStringBuilder.toString());
    }
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, AttribPool paramAttribPool)
  {
    Changeset localChangeset2 = a(paramString1);
    Changeset localChangeset1 = a(paramString2);
    if (localChangeset2.jdField_b_of_type_Int == localChangeset1.jdField_b_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, new Object[] { "mismatched follow:" + paramString1 + " " + paramString2 });
      StringIterator localStringIterator1 = new StringIterator(localChangeset2.jdField_b_of_type_JavaLangString);
      StringIterator localStringIterator2 = new StringIterator(localChangeset1.jdField_b_of_type_JavaLangString);
      int i = localChangeset2.c;
      paramString1 = new int[1];
      paramString2 = new int[1];
      AttributeTester localAttributeTester = a(new Pair("insertorder", "first"), paramAttribPool);
      paramAttribPool = a(localChangeset2.jdField_a_of_type_JavaLangString, 0, localChangeset1.jdField_a_of_type_JavaLangString, 0, new Changeset.11(localStringIterator1, localStringIterator2, localAttributeTester, paramBoolean, paramAttribPool, paramString1, paramString2));
      paramString2[0] += i - paramString1[0];
      return a(i, paramString2[0], paramAttribPool, localChangeset1.jdField_b_of_type_JavaLangString);
    }
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    a(paramOperation2, paramOperation3);
    if (paramOperation1.jdField_a_of_type_Char == 0) {
      paramOperation2.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (paramOperation2.jdField_a_of_type_Int > paramOperation1.jdField_a_of_type_Int) {
        break;
      }
      paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
      paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Char = '\000';
    } while (paramOperation1.jdField_a_of_type_Int != 0);
    paramOperation1.jdField_a_of_type_Char = '\000';
    return;
    paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
    paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
    paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
    paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
    paramOperation1.jdField_a_of_type_Char = '\000';
  }
  
  static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, AttribPool paramAttribPool)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramOperation1.jdField_a_of_type_Char == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (paramOperation1.jdField_a_of_type_Char == 0)
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.jdField_a_of_type_Char = '\000';
        return;
      }
      switch (paramOperation2.jdField_a_of_type_Char)
      {
      default: 
        return;
      case '\000': 
        a(paramOperation1, paramOperation3);
        paramOperation1.jdField_a_of_type_Char = '\000';
        return;
      case '-': 
        if (paramOperation2.jdField_a_of_type_Int > paramOperation1.jdField_a_of_type_Int) {
          break label198;
        }
        if (paramOperation1.jdField_a_of_type_Char == '=')
        {
          paramOperation3.jdField_a_of_type_Char = '-';
          paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
          paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
          paramOperation3.jdField_a_of_type_JavaLangString = paramOperation2.jdField_a_of_type_JavaLangString;
        }
        paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
        paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
    } while (paramOperation1.jdField_a_of_type_Int != 0);
    paramOperation1.jdField_a_of_type_Char = '\000';
    return;
    label198:
    if (paramOperation1.jdField_a_of_type_Char == '=')
    {
      paramOperation3.jdField_a_of_type_Char = '-';
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation3.jdField_a_of_type_JavaLangString = paramOperation2.jdField_a_of_type_JavaLangString;
    }
    paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
    paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
    paramOperation1.jdField_a_of_type_Char = '\000';
    return;
    a(paramOperation2, paramOperation3);
    paramOperation2.jdField_a_of_type_Char = '\000';
    return;
    if (paramOperation2.jdField_a_of_type_Int <= paramOperation1.jdField_a_of_type_Int)
    {
      paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
      paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
      str1 = paramOperation1.jdField_a_of_type_JavaLangString;
      str2 = paramOperation2.jdField_a_of_type_JavaLangString;
      if (paramOperation1.jdField_a_of_type_Char == '=') {}
      for (;;)
      {
        paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
        paramOperation2.jdField_a_of_type_Char = '\000';
        paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
        paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
        if (paramOperation1.jdField_a_of_type_Int != 0) {
          break;
        }
        paramOperation1.jdField_a_of_type_Char = '\000';
        return;
        bool1 = false;
      }
    }
    paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
    paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
    paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
    String str1 = paramOperation1.jdField_a_of_type_JavaLangString;
    String str2 = paramOperation2.jdField_a_of_type_JavaLangString;
    if (paramOperation1.jdField_a_of_type_Char == '=') {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
      paramOperation1.jdField_a_of_type_Char = '\000';
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      return;
    }
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, StringIterator paramStringIterator1, StringIterator paramStringIterator2, AttributeTester paramAttributeTester, boolean paramBoolean)
  {
    int j = 2;
    int i;
    if (paramOperation2.jdField_a_of_type_Char != '+') {
      i = 1;
    }
    while (i == 1)
    {
      paramStringIterator1.a(paramOperation1.jdField_a_of_type_Int);
      paramOperation3.jdField_a_of_type_Char = '=';
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation3.jdField_a_of_type_JavaLangString = "";
      paramOperation1.jdField_a_of_type_Char = '\000';
      return;
      i = j;
      if (paramOperation1.jdField_a_of_type_Char == '+')
      {
        String str1 = paramStringIterator1.b(1);
        String str2 = paramStringIterator2.b(1);
        boolean bool1 = paramAttributeTester.a(paramOperation1.jdField_a_of_type_JavaLangString);
        boolean bool2 = paramAttributeTester.a(paramOperation2.jdField_a_of_type_JavaLangString);
        if ((bool1) && (!bool2))
        {
          i = 1;
        }
        else if (bool2)
        {
          i = j;
          if (!bool1) {}
        }
        else if (str1.equals("\n"))
        {
          i = j;
          if (!str2.equals("\n")) {}
        }
        else if ((!str1.equals("\n")) && (str2.equals("\n")))
        {
          i = 1;
        }
        else
        {
          i = j;
          if (!paramBoolean) {
            i = 1;
          }
        }
      }
    }
    paramStringIterator2.a(paramOperation2.jdField_a_of_type_Int);
    a(paramOperation2, paramOperation3);
    paramOperation2.jdField_a_of_type_Char = '\000';
  }
  
  public static String c(String paramString1, String paramString2, AttribPool paramAttribPool)
  {
    if ((Utils.a(paramString2)) || (paramAttribPool == null)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString2;
    } while (Utils.a(paramString1));
    Object localObject = new ArrayList();
    Utils.a(paramString2, "\\*([0-9a-z]+)", new Changeset.12((List)localObject, paramAttribPool));
    Utils.a(paramString1, "\\*([0-9a-z]+)", new Changeset.13(paramAttribPool, (List)localObject));
    paramString1 = new StringBuilder();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      paramString1.append('*');
      paramString1.append(a(paramAttribPool.a((Pair)((List)localObject).get(i))));
      i += 1;
    }
    return paramString1.toString();
  }
  
  private static void c(Operation paramOperation1, Operation paramOperation2)
  {
    if (paramOperation2.jdField_a_of_type_Char == 0) {
      paramOperation1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (paramOperation1.jdField_a_of_type_Int > paramOperation2.jdField_a_of_type_Int) {
        break;
      }
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      paramOperation1.jdField_a_of_type_Char = '\000';
    } while (paramOperation2.jdField_a_of_type_Int > 0);
    paramOperation2.jdField_a_of_type_Char = '\000';
    return;
    paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
    paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
    paramOperation2.jdField_a_of_type_Char = '\000';
  }
  
  private static void d(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, AttribPool paramAttribPool)
  {
    paramOperation3.jdField_a_of_type_Char = '=';
    paramOperation3.jdField_a_of_type_JavaLangString = c(paramOperation1.jdField_a_of_type_JavaLangString, paramOperation2.jdField_a_of_type_JavaLangString, paramAttribPool);
    if (paramOperation1.jdField_a_of_type_Int <= paramOperation2.jdField_a_of_type_Int)
    {
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      paramOperation1.jdField_a_of_type_Char = '\000';
      if (paramOperation2.jdField_a_of_type_Int == 0) {
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
      return;
    }
    paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
    paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
    paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
    paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
    paramOperation2.jdField_a_of_type_Char = '\000';
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Changeset)) {
        return false;
      }
      paramObject = (Changeset)paramObject;
    } while ((this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (Utils.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Utils.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)));
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
  }
  
  @NonNull
  public String toString()
  {
    return "[Changeset@" + hashCode() + "]: oldLen: " + this.jdField_b_of_type_Int + ", newLen: " + this.c + ", ops: " + this.jdField_a_of_type_JavaLangString + ", charBank: " + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset
 * JD-Core Version:    0.7.0.1
 */