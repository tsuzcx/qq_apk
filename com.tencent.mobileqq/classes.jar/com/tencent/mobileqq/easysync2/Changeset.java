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
  static HeaderParser jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^\n]*(?:\n|[^\n]$)");
  public static boolean a;
  private static Pattern b;
  public String a;
  public int b;
  public String b;
  public int c;
  
  static
  {
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
    if (Utils.a(paramString2)) {
      paramString2 = b(paramString1);
    }
    return new AText(paramString1, paramString2);
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
    int i = paramAttribPool.a(paramPair, true);
    if (i < 0) {
      return local5;
    }
    paramPair = new StringBuilder();
    paramPair.append("\\*");
    paramPair.append(a(i));
    paramPair.append("(?!\\w)");
    return new Changeset.6(Pattern.compile(paramPair.toString()));
  }
  
  public static Changeset a(String paramString)
  {
    Object localObject1 = new Changeset();
    Object localObject2;
    int i;
    if (jdField_a_of_type_Boolean)
    {
      localObject2 = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser;
      if (localObject2 == null) {
        jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser = new HeaderParser();
      } else {
        ((HeaderParser)localObject2).a();
      }
      jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.a(paramString);
      ((Changeset)localObject1).c = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.c;
      ((Changeset)localObject1).jdField_b_of_type_Int = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.jdField_b_of_type_Int;
      i = jdField_a_of_type_ComTencentMobileqqEasysync2HeaderParser.jdField_a_of_type_Int;
    }
    else
    {
      if (jdField_b_of_type_JavaUtilRegexPattern == null) {
        jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("Z:([0-9a-z]+)([><])([0-9a-z]+)|");
      }
      localObject2 = jdField_b_of_type_JavaUtilRegexPattern.matcher(paramString);
      if ((!((Matcher)localObject2).find()) || (((Matcher)localObject2).group().length() == 0)) {
        break label236;
      }
      ((Changeset)localObject1).jdField_b_of_type_Int = a(((Matcher)localObject2).group(1));
      if (">".equals(((Matcher)localObject2).group(2))) {
        i = 1;
      } else {
        i = -1;
      }
      j = a(((Matcher)localObject2).group(3));
      ((Changeset)localObject1).c = (((Changeset)localObject1).jdField_b_of_type_Int + i * j);
      i = ((Matcher)localObject2).group().length();
    }
    int k = paramString.indexOf("$");
    int j = k;
    if (k < 0) {
      j = paramString.length();
    }
    ((Changeset)localObject1).jdField_a_of_type_JavaLangString = paramString.substring(i, j);
    ((Changeset)localObject1).jdField_b_of_type_JavaLangString = paramString.substring(j + 1);
    return localObject1;
    label236:
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Not a exports: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
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
    return Integer.toString(paramInt, Utils.jdField_a_of_type_Int);
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
    Object localObject1 = a(paramString);
    int m = ((Changeset)localObject1).jdField_b_of_type_Int;
    int n = ((Changeset)localObject1).c;
    Object localObject2 = ((Changeset)localObject1).jdField_a_of_type_JavaLangString;
    localObject1 = ((Changeset)localObject1).jdField_b_of_type_JavaLangString;
    SmartOpAssembler localSmartOpAssembler = new SmartOpAssembler();
    localObject2 = a((String)localObject2);
    int i = 0;
    int j = 0;
    int k = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Operation localOperation = (Operation)((Iterator)localObject2).next();
      int i1 = localOperation.jdField_a_of_type_Char;
      boolean bool;
      if (i1 != 43)
      {
        if (i1 != 45)
        {
          if (i1 == 61)
          {
            j += localOperation.jdField_a_of_type_Int;
            i += localOperation.jdField_a_of_type_Int;
          }
        }
        else
        {
          j += localOperation.jdField_a_of_type_Int;
          if (j <= m) {
            bool = true;
          } else {
            bool = false;
          }
          a(bool, new Object[] { Integer.valueOf(j), " > ", Integer.valueOf(m), " in ", paramString });
        }
      }
      else
      {
        i += localOperation.jdField_a_of_type_Int;
        k += localOperation.jdField_a_of_type_Int;
        if (i <= n) {
          bool = true;
        } else {
          bool = false;
        }
        a(bool, new Object[] { Integer.valueOf(i), " > ", Integer.valueOf(n), " in ", paramString });
      }
      localSmartOpAssembler.a(localOperation);
    }
    for (localObject1 = ((String)localObject1).substring(0, k); ((String)localObject1).length() < k; localObject1 = ((StringBuilder)localObject2).toString())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("?");
    }
    localSmartOpAssembler.a();
    a(a(m, i + (m - j), localSmartOpAssembler.toString(), (String)localObject1).equals(paramString), new Object[] { "Invalid changeset (checkRep failed)" });
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
      if ((paramString2.jdField_a_of_type_Char == 0) && (!localIterator1.hasNext()) && (paramString1.jdField_a_of_type_Char == 0) && (!localIterator2.hasNext()))
      {
        localSmartOpAssembler.a();
        return localSmartOpAssembler.toString();
      }
      Object localObject1 = paramString2;
      if (paramString2.jdField_a_of_type_Char == 0)
      {
        localObject1 = paramString2;
        if (localIterator1.hasNext()) {
          localObject1 = (Operation)localIterator1.next();
        }
      }
      Object localObject2 = paramString1;
      if (paramString1.jdField_a_of_type_Char == 0)
      {
        localObject2 = paramString1;
        if (localIterator2.hasNext()) {
          localObject2 = (Operation)localIterator2.next();
        }
      }
      paramOpZipProcessor.a((Operation)localObject1, (Operation)localObject2, localOperation);
      paramString1 = (String)localObject2;
      paramString2 = (String)localObject1;
      if (localOperation.jdField_a_of_type_Char != 0)
      {
        localSmartOpAssembler.a(localOperation);
        localOperation.jdField_a_of_type_Char = '\000';
        paramString1 = (String)localObject2;
        paramString2 = (String)localObject1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Utils.a(str, "\\*([0-9a-z]+)", new Changeset.7(paramAttribPool1, paramAttribPool2)));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = a(paramString1);
    boolean bool;
    if (paramString2.length() == ((Changeset)localObject).jdField_b_of_type_Int) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, new Object[] { "mismatched apply: ", Integer.valueOf(paramString2.length()), " / ", Integer.valueOf(((Changeset)localObject).jdField_b_of_type_Int) });
    paramString1 = a(((Changeset)localObject).jdField_a_of_type_JavaLangString);
    localObject = new StringIterator(((Changeset)localObject).jdField_b_of_type_JavaLangString);
    paramString2 = new StringIterator(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramString1.hasNext())
    {
      Operation localOperation = (Operation)paramString1.next();
      int i = localOperation.jdField_a_of_type_Char;
      if (i != 43)
      {
        if (i != 45)
        {
          if (i == 61) {
            localStringBuilder.append(paramString2.a(localOperation.jdField_a_of_type_Int));
          }
        }
        else {
          paramString2.a(localOperation.jdField_a_of_type_Int);
        }
      }
      else {
        localStringBuilder.append(((StringIterator)localObject).a(localOperation.jdField_a_of_type_Int));
      }
    }
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
    while (localIterator.hasNext())
    {
      Operation localOperation = (Operation)localIterator.next();
      if (localOperation.jdField_a_of_type_Char == '=')
      {
        j += localOperation.jdField_a_of_type_Int;
        i = 0;
      }
      else
      {
        int k = i;
        if (i == 0)
        {
          paramString.add(new SpliceBean(j, j, ""));
          k = 1;
        }
        Object localObject2;
        if (localOperation.jdField_a_of_type_Char == '-')
        {
          j += localOperation.jdField_a_of_type_Int;
          localObject2 = (SpliceBean)paramString.get(paramString.size() - 1);
          ((SpliceBean)localObject2).jdField_b_of_type_Int += localOperation.jdField_a_of_type_Int;
          i = k;
        }
        else
        {
          i = k;
          if (localOperation.jdField_a_of_type_Char == '+')
          {
            localObject2 = new StringBuilder();
            SpliceBean localSpliceBean = (SpliceBean)paramString.get(paramString.size() - 1);
            ((StringBuilder)localObject2).append(localSpliceBean.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject2).append(((StringIterator)localObject1).a(localOperation.jdField_a_of_type_Int));
            localSpliceBean.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
            i = k;
          }
        }
      }
    }
    return paramString;
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
    if (paramOperation1.jdField_a_of_type_Char == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
      return;
    }
    if (paramOperation1.jdField_a_of_type_Char == 0)
    {
      a(paramOperation2, paramOperation3);
      paramOperation2.jdField_a_of_type_Char = '\000';
      return;
    }
    int i = paramOperation2.jdField_a_of_type_Char;
    if (i != 0)
    {
      if (i != 43)
      {
        if (i != 45)
        {
          if (i != 61) {
            return;
          }
          i = paramOperation2.jdField_a_of_type_Int;
          int j = paramOperation1.jdField_a_of_type_Int;
          boolean bool2 = true;
          boolean bool1 = true;
          String str1;
          String str2;
          if (i <= j)
          {
            paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
            paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
            paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
            str1 = paramOperation1.jdField_a_of_type_JavaLangString;
            str2 = paramOperation2.jdField_a_of_type_JavaLangString;
            if (paramOperation1.jdField_a_of_type_Char != '=') {
              bool1 = false;
            }
            paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
            paramOperation2.jdField_a_of_type_Char = '\000';
            paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
            paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
            if (paramOperation1.jdField_a_of_type_Int == 0) {
              paramOperation1.jdField_a_of_type_Char = '\000';
            }
          }
          else
          {
            paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
            paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
            paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
            str1 = paramOperation1.jdField_a_of_type_JavaLangString;
            str2 = paramOperation2.jdField_a_of_type_JavaLangString;
            if (paramOperation1.jdField_a_of_type_Char == '=') {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
            paramOperation1.jdField_a_of_type_Char = '\000';
            paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
            paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
          }
        }
        else if (paramOperation2.jdField_a_of_type_Int <= paramOperation1.jdField_a_of_type_Int)
        {
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
          if (paramOperation1.jdField_a_of_type_Int == 0) {
            paramOperation1.jdField_a_of_type_Char = '\000';
          }
        }
        else
        {
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
        }
      }
      else
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
    }
    else
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
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
    int i = 0;
    int j = paramInt2;
    paramInt2 = paramInt1;
    while (paramString.hasNext())
    {
      SpliceBean localSpliceBean = (SpliceBean)paramString.next();
      paramInt1 = localSpliceBean.jdField_a_of_type_Int + i;
      int n = localSpliceBean.jdField_b_of_type_Int + i;
      int m = localSpliceBean.jdField_a_of_type_JavaLangString.length();
      int k = m - (n - paramInt1);
      if ((paramInt1 <= paramInt2) && (n >= j))
      {
        if (paramBoolean) {
          paramInt2 = paramInt1;
        } else {
          paramInt2 = paramInt1 + m;
        }
        paramInt1 = paramInt2;
      }
      else
      {
        if (n <= paramInt2) {
          paramInt2 += k;
        }
        do
        {
          paramInt1 = j + k;
          break;
          if (paramInt1 >= j)
          {
            paramInt1 = j;
            break;
          }
        } while ((paramInt1 >= paramInt2) && (n <= j));
        if (n < j)
        {
          j += k;
          paramInt2 = paramInt1 + m;
          paramInt1 = j;
        }
      }
      i += k;
      j = paramInt1;
    }
    return new int[] { paramInt2, j };
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
    boolean bool;
    if (paramString1.c == paramString2.jdField_b_of_type_Int) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, new Object[] { "mismatched composition" });
    int j = paramString2.c;
    StringIterator localStringIterator1 = new StringIterator(paramString1.jdField_b_of_type_JavaLangString);
    StringIterator localStringIterator2 = new StringIterator(paramString2.jdField_b_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    return a(i, j, a(paramString1.jdField_a_of_type_JavaLangString, 0, paramString2.jdField_a_of_type_JavaLangString, 0, new Changeset.4(localStringIterator1, paramAttribPool, localStringBuilder, localStringIterator2)), localStringBuilder.toString());
  }
  
  public static String b(String paramString1, String paramString2, boolean paramBoolean, AttribPool paramAttribPool)
  {
    Changeset localChangeset2 = a(paramString1);
    Changeset localChangeset1 = a(paramString2);
    boolean bool;
    if (localChangeset2.jdField_b_of_type_Int == localChangeset1.jdField_b_of_type_Int) {
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
    localObject = new StringIterator(localChangeset2.jdField_b_of_type_JavaLangString);
    StringIterator localStringIterator = new StringIterator(localChangeset1.jdField_b_of_type_JavaLangString);
    int i = localChangeset2.c;
    paramString1 = new int[1];
    paramString2 = new int[1];
    AttributeTester localAttributeTester = a(new Pair("insertorder", "first"), paramAttribPool);
    paramAttribPool = a(localChangeset2.jdField_a_of_type_JavaLangString, 0, localChangeset1.jdField_a_of_type_JavaLangString, 0, new Changeset.11((StringIterator)localObject, localStringIterator, localAttributeTester, paramBoolean, paramAttribPool, paramString1, paramString2));
    paramString2[0] += i - paramString1[0];
    return a(i, paramString2[0], paramAttribPool, localChangeset1.jdField_b_of_type_JavaLangString);
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    a(paramOperation2, paramOperation3);
    if (paramOperation1.jdField_a_of_type_Char == 0)
    {
      paramOperation2.jdField_a_of_type_Char = '\000';
      return;
    }
    if (paramOperation2.jdField_a_of_type_Int <= paramOperation1.jdField_a_of_type_Int)
    {
      paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
      paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Char = '\000';
      if (paramOperation1.jdField_a_of_type_Int == 0) {
        paramOperation1.jdField_a_of_type_Char = '\000';
      }
    }
    else
    {
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation1.jdField_a_of_type_Char = '\000';
    }
  }
  
  static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, AttribPool paramAttribPool)
  {
    if (paramOperation1.jdField_a_of_type_Char == '-')
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
      return;
    }
    if (paramOperation1.jdField_a_of_type_Char == 0)
    {
      a(paramOperation2, paramOperation3);
      paramOperation2.jdField_a_of_type_Char = '\000';
      return;
    }
    int i = paramOperation2.jdField_a_of_type_Char;
    if (i != 0)
    {
      if (i != 43)
      {
        if (i != 45)
        {
          if (i != 61) {
            return;
          }
          i = paramOperation2.jdField_a_of_type_Int;
          int j = paramOperation1.jdField_a_of_type_Int;
          boolean bool2 = true;
          boolean bool1 = true;
          String str1;
          String str2;
          if (i <= j)
          {
            paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
            paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
            paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
            str1 = paramOperation1.jdField_a_of_type_JavaLangString;
            str2 = paramOperation2.jdField_a_of_type_JavaLangString;
            if (paramOperation1.jdField_a_of_type_Char != '=') {
              bool1 = false;
            }
            paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
            paramOperation2.jdField_a_of_type_Char = '\000';
            paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
            paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
            if (paramOperation1.jdField_a_of_type_Int == 0) {
              paramOperation1.jdField_a_of_type_Char = '\000';
            }
          }
          else
          {
            paramOperation3.jdField_a_of_type_Char = paramOperation1.jdField_a_of_type_Char;
            paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
            paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
            str1 = paramOperation1.jdField_a_of_type_JavaLangString;
            str2 = paramOperation2.jdField_a_of_type_JavaLangString;
            if (paramOperation1.jdField_a_of_type_Char == '=') {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramOperation3.jdField_a_of_type_JavaLangString = a(str1, str2, bool1, paramAttribPool);
            paramOperation1.jdField_a_of_type_Char = '\000';
            paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
            paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
          }
        }
        else if (paramOperation2.jdField_a_of_type_Int <= paramOperation1.jdField_a_of_type_Int)
        {
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
          if (paramOperation1.jdField_a_of_type_Int == 0) {
            paramOperation1.jdField_a_of_type_Char = '\000';
          }
        }
        else
        {
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
        }
      }
      else
      {
        a(paramOperation2, paramOperation3);
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
    }
    else
    {
      a(paramOperation1, paramOperation3);
      paramOperation1.jdField_a_of_type_Char = '\000';
    }
  }
  
  private static void b(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3, StringIterator paramStringIterator1, StringIterator paramStringIterator2, AttributeTester paramAttributeTester, boolean paramBoolean)
  {
    int j = paramOperation2.jdField_a_of_type_Char;
    int i = 2;
    if (j != 43) {}
    String str1;
    String str2;
    boolean bool1;
    boolean bool2;
    do
    {
      i = 1;
      break;
      if (paramOperation1.jdField_a_of_type_Char != '+') {
        break;
      }
      str1 = paramStringIterator1.b(1);
      str2 = paramStringIterator2.b(1);
      bool1 = paramAttributeTester.a(paramOperation1.jdField_a_of_type_JavaLangString);
      bool2 = paramAttributeTester.a(paramOperation2.jdField_a_of_type_JavaLangString);
    } while (((bool1) && (!bool2)) || (((!bool2) || (bool1)) && ((!str1.equals("\n")) || (str2.equals("\n"))) && (((!str1.equals("\n")) && (str2.equals("\n"))) || (!paramBoolean))));
    if (i == 1)
    {
      paramStringIterator1.a(paramOperation1.jdField_a_of_type_Int);
      paramOperation3.jdField_a_of_type_Char = '=';
      paramOperation3.jdField_b_of_type_Int = paramOperation1.jdField_b_of_type_Int;
      paramOperation3.jdField_a_of_type_Int = paramOperation1.jdField_a_of_type_Int;
      paramOperation3.jdField_a_of_type_JavaLangString = "";
      paramOperation1.jdField_a_of_type_Char = '\000';
      return;
    }
    paramStringIterator2.a(paramOperation2.jdField_a_of_type_Int);
    a(paramOperation2, paramOperation3);
    paramOperation2.jdField_a_of_type_Char = '\000';
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
      int i = 0;
      while (i < localArrayList.size())
      {
        paramString1.append('*');
        paramString1.append(a(paramAttribPool.a((Pair)localArrayList.get(i))));
        i += 1;
      }
      return paramString1.toString();
    }
    return "";
  }
  
  private static void c(Operation paramOperation1, Operation paramOperation2)
  {
    if (paramOperation2.jdField_a_of_type_Char == 0)
    {
      paramOperation1.jdField_a_of_type_Char = '\000';
      return;
    }
    if (paramOperation1.jdField_a_of_type_Int <= paramOperation2.jdField_a_of_type_Int)
    {
      paramOperation2.jdField_a_of_type_Int -= paramOperation1.jdField_a_of_type_Int;
      paramOperation2.jdField_b_of_type_Int -= paramOperation1.jdField_b_of_type_Int;
      paramOperation1.jdField_a_of_type_Char = '\000';
      if (paramOperation2.jdField_a_of_type_Int <= 0) {
        paramOperation2.jdField_a_of_type_Char = '\000';
      }
    }
    else
    {
      paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
      paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Char = '\000';
    }
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
    }
    else
    {
      paramOperation3.jdField_a_of_type_Int = paramOperation2.jdField_a_of_type_Int;
      paramOperation3.jdField_b_of_type_Int = paramOperation2.jdField_b_of_type_Int;
      paramOperation1.jdField_a_of_type_Int -= paramOperation2.jdField_a_of_type_Int;
      paramOperation1.jdField_b_of_type_Int -= paramOperation2.jdField_b_of_type_Int;
      paramOperation2.jdField_a_of_type_Char = '\000';
    }
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
    return (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.c == paramObject.c) && (Utils.a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Utils.a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.c), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Changeset@");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("]: oldLen: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", newLen: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ops: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", charBank: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset
 * JD-Core Version:    0.7.0.1
 */