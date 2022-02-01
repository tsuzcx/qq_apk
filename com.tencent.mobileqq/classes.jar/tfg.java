import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class tfg
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final Map<Character, Integer> jdField_a_of_type_JavaUtilMap;
  private final char[] jdField_a_of_type_ArrayOfChar;
  
  tfg(String paramString)
  {
    if (paramString.contains(Character.toString('\000'))) {
      throw new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    paramString = paramString.toCharArray();
    int k = paramString.length;
    this.jdField_a_of_type_Int = k;
    this.jdField_a_of_type_JavaUtilMap = new HashMap(k);
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfChar = new char[k * 2 + 1];
    this.jdField_a_of_type_ArrayOfChar[0] = '\000';
    i = j;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfChar[(i + 1)] = paramString[i];
      this.jdField_a_of_type_ArrayOfChar[(k + 1 + i)] = paramString[i];
      i += 1;
    }
  }
  
  private int a(char paramChar)
  {
    if (paramChar == 0) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Character.valueOf(paramChar))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Character.valueOf(paramChar))).intValue() + 1;
    }
    return -1;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  Set<Character> a()
  {
    return this.jdField_a_of_type_JavaUtilMap.keySet();
  }
  
  tfh a(char paramChar1, char paramChar2, int paramInt)
  {
    int j = a(paramChar1);
    int k = a(paramChar2);
    if ((j < 0) || (k < 0)) {
      return null;
    }
    int i;
    switch (paramInt)
    {
    default: 
      i = j;
      paramInt = k;
    }
    for (;;)
    {
      return new tfh(this, i, paramInt);
      if (paramChar2 == 0)
      {
        paramInt = this.jdField_a_of_type_ArrayOfChar.length;
        i = j;
      }
      else
      {
        paramInt = k;
        i = j;
        if (k < j)
        {
          paramInt = k + this.jdField_a_of_type_Int;
          i = j;
          continue;
          paramInt = k;
          i = j;
          if (j < k)
          {
            i = j + this.jdField_a_of_type_Int;
            paramInt = k;
            continue;
            paramInt = k;
            i = j;
            if (paramChar1 != 0)
            {
              paramInt = k;
              i = j;
              if (paramChar2 != 0) {
                if (k < j)
                {
                  paramInt = k;
                  i = j;
                  if (this.jdField_a_of_type_Int - j + k < j - k)
                  {
                    paramInt = k + this.jdField_a_of_type_Int;
                    i = j;
                  }
                }
                else
                {
                  paramInt = k;
                  i = j;
                  if (j < k)
                  {
                    paramInt = k;
                    i = j;
                    if (this.jdField_a_of_type_Int - k + j < k - j)
                    {
                      i = j + this.jdField_a_of_type_Int;
                      paramInt = k;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  char[] a()
  {
    return this.jdField_a_of_type_ArrayOfChar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfg
 * JD-Core Version:    0.7.0.1
 */