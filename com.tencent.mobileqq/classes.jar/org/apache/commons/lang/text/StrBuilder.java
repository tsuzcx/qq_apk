package org.apache.commons.lang.text;

import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.SystemUtils;

public class StrBuilder
  implements Cloneable
{
  static final int CAPACITY = 32;
  private static final long serialVersionUID = 7628716375283629643L;
  protected char[] buffer;
  private String newLine;
  private String nullText;
  protected int size;
  
  public StrBuilder()
  {
    this(32);
  }
  
  public StrBuilder(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 32;
    }
    this.buffer = new char[i];
  }
  
  public StrBuilder(String paramString)
  {
    if (paramString == null)
    {
      this.buffer = new char[32];
      return;
    }
    this.buffer = new char[paramString.length() + 32];
    append(paramString);
  }
  
  private void deleteImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    char[] arrayOfChar = this.buffer;
    System.arraycopy(arrayOfChar, paramInt2, arrayOfChar, paramInt1, this.size - paramInt2);
    this.size -= paramInt3;
  }
  
  private StrBuilder replaceImpl(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramStrMatcher != null)
    {
      if (this.size == 0) {
        return this;
      }
      int i;
      if (paramString == null) {
        i = 0;
      } else {
        i = paramString.length();
      }
      char[] arrayOfChar = this.buffer;
      int n = paramInt2;
      paramInt2 = paramInt1;
      int j = paramInt3;
      while ((paramInt2 < n) && (j != 0))
      {
        int i1 = paramStrMatcher.isMatch(arrayOfChar, paramInt2, paramInt1, n);
        int k = j;
        int m = paramInt2;
        paramInt3 = n;
        if (i1 > 0)
        {
          replaceImpl(paramInt2, paramInt2 + i1, i1, paramString, i);
          n = n - i1 + i;
          paramInt2 = paramInt2 + i - 1;
          k = j;
          m = paramInt2;
          paramInt3 = n;
          if (j > 0)
          {
            k = j - 1;
            paramInt3 = n;
            m = paramInt2;
          }
        }
        paramInt2 = m + 1;
        j = k;
        n = paramInt3;
      }
    }
    return this;
  }
  
  private void replaceImpl(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    int i = this.size - paramInt3 + paramInt4;
    if (paramInt4 != paramInt3)
    {
      ensureCapacity(i);
      char[] arrayOfChar = this.buffer;
      System.arraycopy(arrayOfChar, paramInt2, arrayOfChar, paramInt1 + paramInt4, this.size - paramInt2);
      this.size = i;
    }
    if (paramInt4 > 0) {
      paramString.getChars(0, paramInt4, this.buffer, paramInt1);
    }
  }
  
  public StrBuilder append(char paramChar)
  {
    ensureCapacity(length() + 1);
    char[] arrayOfChar = this.buffer;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
    return this;
  }
  
  public StrBuilder append(double paramDouble)
  {
    return append(String.valueOf(paramDouble));
  }
  
  public StrBuilder append(float paramFloat)
  {
    return append(String.valueOf(paramFloat));
  }
  
  public StrBuilder append(int paramInt)
  {
    return append(String.valueOf(paramInt));
  }
  
  public StrBuilder append(long paramLong)
  {
    return append(String.valueOf(paramLong));
  }
  
  public StrBuilder append(Object paramObject)
  {
    if (paramObject == null) {
      return appendNull();
    }
    return append(paramObject.toString());
  }
  
  public StrBuilder append(String paramString)
  {
    if (paramString == null) {
      return appendNull();
    }
    int i = paramString.length();
    if (i > 0)
    {
      int j = length();
      ensureCapacity(j + i);
      paramString.getChars(0, i, this.buffer, j);
      this.size += i;
    }
    return this;
  }
  
  public StrBuilder append(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return appendNull();
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramString.length()))
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + paramInt2;
        if (i <= paramString.length())
        {
          if (paramInt2 > 0)
          {
            int j = length();
            ensureCapacity(j + paramInt2);
            paramString.getChars(paramInt1, i, this.buffer, j);
            this.size += paramInt2;
          }
          return this;
        }
      }
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    throw new StringIndexOutOfBoundsException("startIndex must be valid");
  }
  
  public StrBuilder append(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null) {
      return appendNull();
    }
    int i = paramStringBuffer.length();
    if (i > 0)
    {
      int j = length();
      ensureCapacity(j + i);
      paramStringBuffer.getChars(0, i, this.buffer, j);
      this.size += i;
    }
    return this;
  }
  
  public StrBuilder append(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null) {
      return appendNull();
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramStringBuffer.length()))
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + paramInt2;
        if (i <= paramStringBuffer.length())
        {
          if (paramInt2 > 0)
          {
            int j = length();
            ensureCapacity(j + paramInt2);
            paramStringBuffer.getChars(paramInt1, i, this.buffer, j);
            this.size += paramInt2;
          }
          return this;
        }
      }
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    throw new StringIndexOutOfBoundsException("startIndex must be valid");
  }
  
  public StrBuilder append(StrBuilder paramStrBuilder)
  {
    if (paramStrBuilder == null) {
      return appendNull();
    }
    int i = paramStrBuilder.length();
    if (i > 0)
    {
      int j = length();
      ensureCapacity(j + i);
      System.arraycopy(paramStrBuilder.buffer, 0, this.buffer, j, i);
      this.size += i;
    }
    return this;
  }
  
  public StrBuilder append(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    if (paramStrBuilder == null) {
      return appendNull();
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramStrBuilder.length()))
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + paramInt2;
        if (i <= paramStrBuilder.length())
        {
          if (paramInt2 > 0)
          {
            int j = length();
            ensureCapacity(j + paramInt2);
            paramStrBuilder.getChars(paramInt1, i, this.buffer, j);
            this.size += paramInt2;
          }
          return this;
        }
      }
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    throw new StringIndexOutOfBoundsException("startIndex must be valid");
  }
  
  public StrBuilder append(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ensureCapacity(this.size + 4);
      arrayOfChar = this.buffer;
      i = this.size;
      this.size = (i + 1);
      arrayOfChar[i] = 't';
      i = this.size;
      this.size = (i + 1);
      arrayOfChar[i] = 'r';
      i = this.size;
      this.size = (i + 1);
      arrayOfChar[i] = 'u';
      i = this.size;
      this.size = (i + 1);
      arrayOfChar[i] = 'e';
      return this;
    }
    ensureCapacity(this.size + 5);
    char[] arrayOfChar = this.buffer;
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = 'f';
    i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = 'a';
    i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = 'l';
    i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = 's';
    i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = 'e';
    return this;
  }
  
  public StrBuilder append(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return appendNull();
    }
    int i = paramArrayOfChar.length;
    if (i > 0)
    {
      int j = length();
      ensureCapacity(j + i);
      System.arraycopy(paramArrayOfChar, 0, this.buffer, j, i);
      this.size += i;
    }
    return this;
  }
  
  public StrBuilder append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return appendNull();
    }
    if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfChar.length))
    {
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfChar.length))
      {
        if (paramInt2 > 0)
        {
          int i = length();
          ensureCapacity(i + paramInt2);
          System.arraycopy(paramArrayOfChar, paramInt1, this.buffer, i, paramInt2);
          this.size += paramInt2;
        }
        return this;
      }
      paramArrayOfChar = new StringBuffer();
      paramArrayOfChar.append("Invalid length: ");
      paramArrayOfChar.append(paramInt2);
      throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
    }
    paramArrayOfChar = new StringBuffer();
    paramArrayOfChar.append("Invalid startIndex: ");
    paramArrayOfChar.append(paramInt2);
    throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
  }
  
  public StrBuilder appendAll(Collection paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        append(paramCollection.next());
      }
    }
    return this;
  }
  
  public StrBuilder appendAll(Iterator paramIterator)
  {
    if (paramIterator != null) {
      while (paramIterator.hasNext()) {
        append(paramIterator.next());
      }
    }
    return this;
  }
  
  public StrBuilder appendAll(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        append(paramArrayOfObject[i]);
        i += 1;
      }
    }
    return this;
  }
  
  public StrBuilder appendFixedWidthPadLeft(int paramInt1, int paramInt2, char paramChar)
  {
    return appendFixedWidthPadLeft(String.valueOf(paramInt1), paramInt2, paramChar);
  }
  
  public StrBuilder appendFixedWidthPadLeft(Object paramObject, int paramInt, char paramChar)
  {
    if (paramInt > 0)
    {
      ensureCapacity(this.size + paramInt);
      if (paramObject == null) {
        paramObject = getNullText();
      } else {
        paramObject = paramObject.toString();
      }
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "";
      }
      int j = ((String)localObject).length();
      if (j >= paramInt)
      {
        ((String)localObject).getChars(j - paramInt, j, this.buffer, this.size);
      }
      else
      {
        int k = paramInt - j;
        int i = 0;
        while (i < k)
        {
          this.buffer[(this.size + i)] = paramChar;
          i += 1;
        }
        ((String)localObject).getChars(0, j, this.buffer, this.size + k);
      }
      this.size += paramInt;
    }
    return this;
  }
  
  public StrBuilder appendFixedWidthPadRight(int paramInt1, int paramInt2, char paramChar)
  {
    return appendFixedWidthPadRight(String.valueOf(paramInt1), paramInt2, paramChar);
  }
  
  public StrBuilder appendFixedWidthPadRight(Object paramObject, int paramInt, char paramChar)
  {
    if (paramInt > 0)
    {
      ensureCapacity(this.size + paramInt);
      if (paramObject == null) {
        paramObject = getNullText();
      } else {
        paramObject = paramObject.toString();
      }
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "";
      }
      int j = ((String)localObject).length();
      int i = 0;
      if (j >= paramInt)
      {
        ((String)localObject).getChars(0, paramInt, this.buffer, this.size);
      }
      else
      {
        ((String)localObject).getChars(0, j, this.buffer, this.size);
        while (i < paramInt - j)
        {
          this.buffer[(this.size + j + i)] = paramChar;
          i += 1;
        }
      }
      this.size += paramInt;
    }
    return this;
  }
  
  public StrBuilder appendNewLine()
  {
    String str = this.newLine;
    if (str == null)
    {
      append(SystemUtils.LINE_SEPARATOR);
      return this;
    }
    return append(str);
  }
  
  public StrBuilder appendNull()
  {
    String str = this.nullText;
    if (str == null) {
      return this;
    }
    return append(str);
  }
  
  public StrBuilder appendPadding(int paramInt, char paramChar)
  {
    if (paramInt >= 0)
    {
      ensureCapacity(this.size + paramInt);
      int i = 0;
      while (i < paramInt)
      {
        char[] arrayOfChar = this.buffer;
        int j = this.size;
        this.size = (j + 1);
        arrayOfChar[j] = paramChar;
        i += 1;
      }
    }
    return this;
  }
  
  public StrBuilder appendSeparator(char paramChar)
  {
    if (size() > 0) {
      append(paramChar);
    }
    return this;
  }
  
  public StrBuilder appendSeparator(char paramChar1, char paramChar2)
  {
    if (size() > 0)
    {
      append(paramChar1);
      return this;
    }
    append(paramChar2);
    return this;
  }
  
  public StrBuilder appendSeparator(char paramChar, int paramInt)
  {
    if (paramInt > 0) {
      append(paramChar);
    }
    return this;
  }
  
  public StrBuilder appendSeparator(String paramString)
  {
    return appendSeparator(paramString, null);
  }
  
  public StrBuilder appendSeparator(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramInt > 0)) {
      append(paramString);
    }
    return this;
  }
  
  public StrBuilder appendSeparator(String paramString1, String paramString2)
  {
    if (isEmpty()) {
      paramString1 = paramString2;
    }
    if (paramString1 != null) {
      append(paramString1);
    }
    return this;
  }
  
  public StrBuilder appendWithSeparators(Collection paramCollection, String paramString)
  {
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        append(paramCollection.next());
        if (paramCollection.hasNext()) {
          append(str);
        }
      }
    }
    return this;
  }
  
  public StrBuilder appendWithSeparators(Iterator paramIterator, String paramString)
  {
    if (paramIterator != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      while (paramIterator.hasNext())
      {
        append(paramIterator.next());
        if (paramIterator.hasNext()) {
          append(str);
        }
      }
    }
    return this;
  }
  
  public StrBuilder appendWithSeparators(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      append(paramArrayOfObject[0]);
      int i = 1;
      while (i < paramArrayOfObject.length)
      {
        append(str);
        append(paramArrayOfObject[i]);
        i += 1;
      }
    }
    return this;
  }
  
  public StrBuilder appendln(char paramChar)
  {
    return append(paramChar).appendNewLine();
  }
  
  public StrBuilder appendln(double paramDouble)
  {
    return append(paramDouble).appendNewLine();
  }
  
  public StrBuilder appendln(float paramFloat)
  {
    return append(paramFloat).appendNewLine();
  }
  
  public StrBuilder appendln(int paramInt)
  {
    return append(paramInt).appendNewLine();
  }
  
  public StrBuilder appendln(long paramLong)
  {
    return append(paramLong).appendNewLine();
  }
  
  public StrBuilder appendln(Object paramObject)
  {
    return append(paramObject).appendNewLine();
  }
  
  public StrBuilder appendln(String paramString)
  {
    return append(paramString).appendNewLine();
  }
  
  public StrBuilder appendln(String paramString, int paramInt1, int paramInt2)
  {
    return append(paramString, paramInt1, paramInt2).appendNewLine();
  }
  
  public StrBuilder appendln(StringBuffer paramStringBuffer)
  {
    return append(paramStringBuffer).appendNewLine();
  }
  
  public StrBuilder appendln(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    return append(paramStringBuffer, paramInt1, paramInt2).appendNewLine();
  }
  
  public StrBuilder appendln(StrBuilder paramStrBuilder)
  {
    return append(paramStrBuilder).appendNewLine();
  }
  
  public StrBuilder appendln(StrBuilder paramStrBuilder, int paramInt1, int paramInt2)
  {
    return append(paramStrBuilder, paramInt1, paramInt2).appendNewLine();
  }
  
  public StrBuilder appendln(boolean paramBoolean)
  {
    return append(paramBoolean).appendNewLine();
  }
  
  public StrBuilder appendln(char[] paramArrayOfChar)
  {
    return append(paramArrayOfChar).appendNewLine();
  }
  
  public StrBuilder appendln(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return append(paramArrayOfChar, paramInt1, paramInt2).appendNewLine();
  }
  
  public Reader asReader()
  {
    return new StrBuilder.StrBuilderReader(this);
  }
  
  public StrTokenizer asTokenizer()
  {
    return new StrBuilder.StrBuilderTokenizer(this);
  }
  
  public Writer asWriter()
  {
    return new StrBuilder.StrBuilderWriter(this);
  }
  
  public int capacity()
  {
    return this.buffer.length;
  }
  
  public char charAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < length())) {
      return this.buffer[paramInt];
    }
    throw new StringIndexOutOfBoundsException(paramInt);
  }
  
  public StrBuilder clear()
  {
    this.size = 0;
    return this;
  }
  
  public Object clone()
  {
    StrBuilder localStrBuilder = (StrBuilder)super.clone();
    localStrBuilder.buffer = new char[this.buffer.length];
    char[] arrayOfChar = this.buffer;
    System.arraycopy(arrayOfChar, 0, localStrBuilder.buffer, 0, arrayOfChar.length);
    return localStrBuilder;
  }
  
  public boolean contains(char paramChar)
  {
    char[] arrayOfChar = this.buffer;
    int i = 0;
    while (i < this.size)
    {
      if (arrayOfChar[i] == paramChar) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean contains(String paramString)
  {
    boolean bool = false;
    if (indexOf(paramString, 0) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean contains(StrMatcher paramStrMatcher)
  {
    boolean bool = false;
    if (indexOf(paramStrMatcher, 0) >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public StrBuilder delete(int paramInt1, int paramInt2)
  {
    paramInt2 = validateRange(paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if (i > 0) {
      deleteImpl(paramInt1, paramInt2, i);
    }
    return this;
  }
  
  public StrBuilder deleteAll(char paramChar)
  {
    int j;
    for (int i = 0; i < this.size; i = j + 1)
    {
      j = i;
      if (this.buffer[i] == paramChar)
      {
        j = i;
        int k;
        do
        {
          k = j + 1;
          if (k >= this.size) {
            break;
          }
          j = k;
        } while (this.buffer[k] == paramChar);
        j = k - i;
        deleteImpl(i, k, j);
        j = k - j;
      }
    }
    return this;
  }
  
  public StrBuilder deleteAll(String paramString)
  {
    int i;
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.length();
    }
    if (i > 0) {
      for (int j = indexOf(paramString, 0); j >= 0; j = indexOf(paramString, j)) {
        deleteImpl(j, j + i, i);
      }
    }
    return this;
  }
  
  public StrBuilder deleteAll(StrMatcher paramStrMatcher)
  {
    return replace(paramStrMatcher, null, 0, this.size, -1);
  }
  
  public StrBuilder deleteCharAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.size))
    {
      deleteImpl(paramInt, paramInt + 1, 1);
      return this;
    }
    throw new StringIndexOutOfBoundsException(paramInt);
  }
  
  public StrBuilder deleteFirst(char paramChar)
  {
    int i = 0;
    while (i < this.size)
    {
      if (this.buffer[i] == paramChar)
      {
        deleteImpl(i, i + 1, 1);
        return this;
      }
      i += 1;
    }
    return this;
  }
  
  public StrBuilder deleteFirst(String paramString)
  {
    int i;
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.length();
    }
    if (i > 0)
    {
      int j = indexOf(paramString, 0);
      if (j >= 0) {
        deleteImpl(j, j + i, i);
      }
    }
    return this;
  }
  
  public StrBuilder deleteFirst(StrMatcher paramStrMatcher)
  {
    return replace(paramStrMatcher, null, 0, this.size, 1);
  }
  
  public boolean endsWith(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int k = paramString.length();
    if (k == 0) {
      return true;
    }
    int i = this.size;
    if (k > i) {
      return false;
    }
    i -= k;
    int j = 0;
    while (j < k)
    {
      if (this.buffer[i] != paramString.charAt(j)) {
        return false;
      }
      j += 1;
      i += 1;
    }
    return true;
  }
  
  public StrBuilder ensureCapacity(int paramInt)
  {
    char[] arrayOfChar = this.buffer;
    if (paramInt > arrayOfChar.length)
    {
      this.buffer = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
    }
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof StrBuilder)) {
      return equals((StrBuilder)paramObject);
    }
    return false;
  }
  
  public boolean equals(StrBuilder paramStrBuilder)
  {
    if (this == paramStrBuilder) {
      return true;
    }
    int i = this.size;
    if (i != paramStrBuilder.size) {
      return false;
    }
    char[] arrayOfChar = this.buffer;
    paramStrBuilder = paramStrBuilder.buffer;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfChar[i] != paramStrBuilder[i]) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public boolean equalsIgnoreCase(StrBuilder paramStrBuilder)
  {
    if (this == paramStrBuilder) {
      return true;
    }
    int i = this.size;
    if (i != paramStrBuilder.size) {
      return false;
    }
    char[] arrayOfChar = this.buffer;
    paramStrBuilder = paramStrBuilder.buffer;
    i -= 1;
    while (i >= 0)
    {
      char c1 = arrayOfChar[i];
      char c2 = paramStrBuilder[i];
      if ((c1 != c2) && (Character.toUpperCase(c1) != Character.toUpperCase(c2))) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if ((paramInt2 >= 0) && (paramInt2 <= length()))
      {
        if (paramInt1 <= paramInt2)
        {
          System.arraycopy(this.buffer, paramInt1, paramArrayOfChar, paramInt3, paramInt2 - paramInt1);
          return;
        }
        throw new StringIndexOutOfBoundsException("end < start");
      }
      throw new StringIndexOutOfBoundsException(paramInt2);
    }
    throw new StringIndexOutOfBoundsException(paramInt1);
  }
  
  public char[] getChars(char[] paramArrayOfChar)
  {
    int i = length();
    char[] arrayOfChar;
    if (paramArrayOfChar != null)
    {
      arrayOfChar = paramArrayOfChar;
      if (paramArrayOfChar.length >= i) {}
    }
    else
    {
      arrayOfChar = new char[i];
    }
    System.arraycopy(this.buffer, 0, arrayOfChar, 0, i);
    return arrayOfChar;
  }
  
  public String getNewLineText()
  {
    return this.newLine;
  }
  
  public String getNullText()
  {
    return this.nullText;
  }
  
  public int hashCode()
  {
    char[] arrayOfChar = this.buffer;
    int i = this.size - 1;
    int j = 0;
    while (i >= 0)
    {
      j = j * 31 + arrayOfChar[i];
      i -= 1;
    }
    return j;
  }
  
  public int indexOf(char paramChar)
  {
    return indexOf(paramChar, 0);
  }
  
  public int indexOf(char paramChar, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (i >= this.size) {
      return -1;
    }
    char[] arrayOfChar = this.buffer;
    while (i < this.size)
    {
      if (arrayOfChar[i] == paramChar) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int indexOf(String paramString)
  {
    return indexOf(paramString, 0);
  }
  
  public int indexOf(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (paramString != null)
    {
      if (i >= this.size) {
        return -1;
      }
      int j = paramString.length();
      if (j == 1) {
        return indexOf(paramString.charAt(0), i);
      }
      if (j == 0) {
        return i;
      }
      int k = this.size;
      if (j > k) {
        return -1;
      }
      char[] arrayOfChar = this.buffer;
      if (i < k - j + 1)
      {
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= j) {
            break label120;
          }
          if (paramString.charAt(paramInt) != arrayOfChar[(i + paramInt)])
          {
            i += 1;
            break;
          }
          paramInt += 1;
        }
        label120:
        return i;
      }
    }
    return -1;
  }
  
  public int indexOf(StrMatcher paramStrMatcher)
  {
    return indexOf(paramStrMatcher, 0);
  }
  
  public int indexOf(StrMatcher paramStrMatcher, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (paramStrMatcher != null)
    {
      int j = this.size;
      if (i >= j) {
        return -1;
      }
      char[] arrayOfChar = this.buffer;
      paramInt = i;
      while (paramInt < j)
      {
        if (paramStrMatcher.isMatch(arrayOfChar, paramInt, i, j) > 0) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public StrBuilder insert(int paramInt, char paramChar)
  {
    validateIndex(paramInt);
    ensureCapacity(this.size + 1);
    char[] arrayOfChar = this.buffer;
    System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + 1, this.size - paramInt);
    this.buffer[paramInt] = paramChar;
    this.size += 1;
    return this;
  }
  
  public StrBuilder insert(int paramInt, double paramDouble)
  {
    return insert(paramInt, String.valueOf(paramDouble));
  }
  
  public StrBuilder insert(int paramInt, float paramFloat)
  {
    return insert(paramInt, String.valueOf(paramFloat));
  }
  
  public StrBuilder insert(int paramInt1, int paramInt2)
  {
    return insert(paramInt1, String.valueOf(paramInt2));
  }
  
  public StrBuilder insert(int paramInt, long paramLong)
  {
    return insert(paramInt, String.valueOf(paramLong));
  }
  
  public StrBuilder insert(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return insert(paramInt, this.nullText);
    }
    return insert(paramInt, paramObject.toString());
  }
  
  public StrBuilder insert(int paramInt, String paramString)
  {
    validateIndex(paramInt);
    String str = paramString;
    if (paramString == null) {
      str = this.nullText;
    }
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.length();
    }
    if (i > 0)
    {
      int j = this.size + i;
      ensureCapacity(j);
      paramString = this.buffer;
      System.arraycopy(paramString, paramInt, paramString, paramInt + i, this.size - paramInt);
      this.size = j;
      str.getChars(0, i, this.buffer, paramInt);
    }
    return this;
  }
  
  public StrBuilder insert(int paramInt, boolean paramBoolean)
  {
    validateIndex(paramInt);
    if (paramBoolean)
    {
      ensureCapacity(this.size + 4);
      arrayOfChar = this.buffer;
      System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + 4, this.size - paramInt);
      arrayOfChar = this.buffer;
      i = paramInt + 1;
      arrayOfChar[paramInt] = 't';
      paramInt = i + 1;
      arrayOfChar[i] = 'r';
      arrayOfChar[paramInt] = 'u';
      arrayOfChar[(paramInt + 1)] = 'e';
      this.size += 4;
      return this;
    }
    ensureCapacity(this.size + 5);
    char[] arrayOfChar = this.buffer;
    System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + 5, this.size - paramInt);
    arrayOfChar = this.buffer;
    int i = paramInt + 1;
    arrayOfChar[paramInt] = 'f';
    paramInt = i + 1;
    arrayOfChar[i] = 'a';
    i = paramInt + 1;
    arrayOfChar[paramInt] = 'l';
    arrayOfChar[i] = 's';
    arrayOfChar[(i + 1)] = 'e';
    this.size += 5;
    return this;
  }
  
  public StrBuilder insert(int paramInt, char[] paramArrayOfChar)
  {
    validateIndex(paramInt);
    if (paramArrayOfChar == null) {
      return insert(paramInt, this.nullText);
    }
    int i = paramArrayOfChar.length;
    if (i > 0)
    {
      ensureCapacity(this.size + i);
      char[] arrayOfChar = this.buffer;
      System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + i, this.size - paramInt);
      System.arraycopy(paramArrayOfChar, 0, this.buffer, paramInt, i);
      this.size += i;
    }
    return this;
  }
  
  public StrBuilder insert(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    validateIndex(paramInt1);
    if (paramArrayOfChar == null) {
      return insert(paramInt1, this.nullText);
    }
    if ((paramInt2 >= 0) && (paramInt2 <= paramArrayOfChar.length))
    {
      if ((paramInt3 >= 0) && (paramInt2 + paramInt3 <= paramArrayOfChar.length))
      {
        if (paramInt3 > 0)
        {
          ensureCapacity(this.size + paramInt3);
          char[] arrayOfChar = this.buffer;
          System.arraycopy(arrayOfChar, paramInt1, arrayOfChar, paramInt1 + paramInt3, this.size - paramInt1);
          System.arraycopy(paramArrayOfChar, paramInt2, this.buffer, paramInt1, paramInt3);
          this.size += paramInt3;
        }
        return this;
      }
      paramArrayOfChar = new StringBuffer();
      paramArrayOfChar.append("Invalid length: ");
      paramArrayOfChar.append(paramInt3);
      throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
    }
    paramArrayOfChar = new StringBuffer();
    paramArrayOfChar.append("Invalid offset: ");
    paramArrayOfChar.append(paramInt2);
    throw new StringIndexOutOfBoundsException(paramArrayOfChar.toString());
  }
  
  public boolean isEmpty()
  {
    return this.size == 0;
  }
  
  public int lastIndexOf(char paramChar)
  {
    return lastIndexOf(paramChar, this.size - 1);
  }
  
  public int lastIndexOf(char paramChar, int paramInt)
  {
    int j = this.size;
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    paramInt = i;
    if (i < 0) {
      return -1;
    }
    while (paramInt >= 0)
    {
      if (this.buffer[paramInt] == paramChar) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public int lastIndexOf(String paramString)
  {
    return lastIndexOf(paramString, this.size - 1);
  }
  
  public int lastIndexOf(String paramString, int paramInt)
  {
    int j = this.size;
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    if (paramString != null)
    {
      if (i < 0) {
        return -1;
      }
      j = paramString.length();
      if ((j > 0) && (j <= this.size))
      {
        if (j == 1) {
          return lastIndexOf(paramString.charAt(0), i);
        }
        paramInt = i - j + 1;
        if (paramInt >= 0)
        {
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label115;
            }
            if (paramString.charAt(i) != this.buffer[(paramInt + i)])
            {
              paramInt -= 1;
              break;
            }
            i += 1;
          }
          label115:
          return paramInt;
        }
      }
      else if (j == 0)
      {
        return i;
      }
    }
    return -1;
  }
  
  public int lastIndexOf(StrMatcher paramStrMatcher)
  {
    return lastIndexOf(paramStrMatcher, this.size);
  }
  
  public int lastIndexOf(StrMatcher paramStrMatcher, int paramInt)
  {
    int j = this.size;
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    if (paramStrMatcher != null)
    {
      if (i < 0) {
        return -1;
      }
      char[] arrayOfChar = this.buffer;
      paramInt = i;
      while (paramInt >= 0)
      {
        if (paramStrMatcher.isMatch(arrayOfChar, paramInt, 0, i + 1) > 0) {
          return paramInt;
        }
        paramInt -= 1;
      }
    }
    return -1;
  }
  
  public String leftString(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    int i = this.size;
    if (paramInt >= i) {
      return new String(this.buffer, 0, i);
    }
    return new String(this.buffer, 0, paramInt);
  }
  
  public int length()
  {
    return this.size;
  }
  
  public String midString(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (paramInt2 > 0)
    {
      paramInt1 = this.size;
      if (i < paramInt1)
      {
        if (paramInt1 <= i + paramInt2) {
          return new String(this.buffer, i, paramInt1 - i);
        }
        return new String(this.buffer, i, paramInt2);
      }
    }
    return "";
  }
  
  public StrBuilder minimizeCapacity()
  {
    if (this.buffer.length > length())
    {
      char[] arrayOfChar = this.buffer;
      this.buffer = new char[length()];
      System.arraycopy(arrayOfChar, 0, this.buffer, 0, this.size);
    }
    return this;
  }
  
  public StrBuilder replace(int paramInt1, int paramInt2, String paramString)
  {
    int i = validateRange(paramInt1, paramInt2);
    if (paramString == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramString.length();
    }
    replaceImpl(paramInt1, i, i - paramInt1, paramString, paramInt2);
    return this;
  }
  
  public StrBuilder replace(StrMatcher paramStrMatcher, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return replaceImpl(paramStrMatcher, paramString, paramInt1, validateRange(paramInt1, paramInt2), paramInt3);
  }
  
  public StrBuilder replaceAll(char paramChar1, char paramChar2)
  {
    if (paramChar1 != paramChar2)
    {
      int i = 0;
      while (i < this.size)
      {
        char[] arrayOfChar = this.buffer;
        if (arrayOfChar[i] == paramChar1) {
          arrayOfChar[i] = paramChar2;
        }
        i += 1;
      }
    }
    return this;
  }
  
  public StrBuilder replaceAll(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.length();
    }
    if (i > 0)
    {
      int j;
      if (paramString2 == null) {
        j = 0;
      } else {
        j = paramString2.length();
      }
      for (int k = indexOf(paramString1, 0); k >= 0; k = indexOf(paramString1, k + j)) {
        replaceImpl(k, k + i, i, paramString2, j);
      }
    }
    return this;
  }
  
  public StrBuilder replaceAll(StrMatcher paramStrMatcher, String paramString)
  {
    return replace(paramStrMatcher, paramString, 0, this.size, -1);
  }
  
  public StrBuilder replaceFirst(char paramChar1, char paramChar2)
  {
    if (paramChar1 != paramChar2)
    {
      int i = 0;
      while (i < this.size)
      {
        char[] arrayOfChar = this.buffer;
        if (arrayOfChar[i] == paramChar1)
        {
          arrayOfChar[i] = paramChar2;
          return this;
        }
        i += 1;
      }
    }
    return this;
  }
  
  public StrBuilder replaceFirst(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.length();
    }
    if (i > 0)
    {
      int k = indexOf(paramString1, 0);
      if (k >= 0)
      {
        int j;
        if (paramString2 == null) {
          j = 0;
        } else {
          j = paramString2.length();
        }
        replaceImpl(k, k + i, i, paramString2, j);
      }
    }
    return this;
  }
  
  public StrBuilder replaceFirst(StrMatcher paramStrMatcher, String paramString)
  {
    return replace(paramStrMatcher, paramString, 0, this.size, 1);
  }
  
  public StrBuilder reverse()
  {
    int j = this.size;
    if (j == 0) {
      return this;
    }
    int m = j / 2;
    char[] arrayOfChar = this.buffer;
    int k = 0;
    j -= 1;
    while (k < m)
    {
      int i = arrayOfChar[k];
      arrayOfChar[k] = arrayOfChar[j];
      arrayOfChar[j] = i;
      k += 1;
      j -= 1;
    }
    return this;
  }
  
  public String rightString(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    int i = this.size;
    if (paramInt >= i) {
      return new String(this.buffer, 0, i);
    }
    return new String(this.buffer, i - paramInt, paramInt);
  }
  
  public StrBuilder setCharAt(int paramInt, char paramChar)
  {
    if ((paramInt >= 0) && (paramInt < length()))
    {
      this.buffer[paramInt] = paramChar;
      return this;
    }
    throw new StringIndexOutOfBoundsException(paramInt);
  }
  
  public StrBuilder setLength(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.size;
      if (paramInt < i)
      {
        this.size = paramInt;
        return this;
      }
      if (paramInt > i)
      {
        ensureCapacity(paramInt);
        i = this.size;
        this.size = paramInt;
        while (i < paramInt)
        {
          this.buffer[i] = '\000';
          i += 1;
        }
      }
      return this;
    }
    StringIndexOutOfBoundsException localStringIndexOutOfBoundsException = new StringIndexOutOfBoundsException(paramInt);
    for (;;)
    {
      throw localStringIndexOutOfBoundsException;
    }
  }
  
  public StrBuilder setNewLineText(String paramString)
  {
    this.newLine = paramString;
    return this;
  }
  
  public StrBuilder setNullText(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() == 0) {
        str = null;
      }
    }
    this.nullText = str;
    return this;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public boolean startsWith(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    if (j == 0) {
      return true;
    }
    if (j > this.size) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (this.buffer[i] != paramString.charAt(i)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String substring(int paramInt)
  {
    return substring(paramInt, this.size);
  }
  
  public String substring(int paramInt1, int paramInt2)
  {
    paramInt2 = validateRange(paramInt1, paramInt2);
    return new String(this.buffer, paramInt1, paramInt2 - paramInt1);
  }
  
  public char[] toCharArray()
  {
    int i = this.size;
    if (i == 0) {
      return ArrayUtils.EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[i];
    System.arraycopy(this.buffer, 0, arrayOfChar, 0, i);
    return arrayOfChar;
  }
  
  public char[] toCharArray(int paramInt1, int paramInt2)
  {
    paramInt2 = validateRange(paramInt1, paramInt2) - paramInt1;
    if (paramInt2 == 0) {
      return ArrayUtils.EMPTY_CHAR_ARRAY;
    }
    char[] arrayOfChar = new char[paramInt2];
    System.arraycopy(this.buffer, paramInt1, arrayOfChar, 0, paramInt2);
    return arrayOfChar;
  }
  
  public String toString()
  {
    return new String(this.buffer, 0, this.size);
  }
  
  public StringBuffer toStringBuffer()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.size);
    localStringBuffer.append(this.buffer, 0, this.size);
    return localStringBuffer;
  }
  
  public StrBuilder trim()
  {
    int k = this.size;
    if (k == 0) {
      return this;
    }
    char[] arrayOfChar = this.buffer;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= k) {
        break;
      }
      j = k;
      if (arrayOfChar[i] > ' ') {
        break;
      }
      i += 1;
    }
    while ((i < j) && (arrayOfChar[(j - 1)] <= ' ')) {
      j -= 1;
    }
    k = this.size;
    if (j < k) {
      delete(j, k);
    }
    if (i > 0) {
      delete(0, i);
    }
    return this;
  }
  
  protected void validateIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.size)) {
      return;
    }
    throw new StringIndexOutOfBoundsException(paramInt);
  }
  
  protected int validateRange(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int j = this.size;
      int i = paramInt2;
      if (paramInt2 > j) {
        i = j;
      }
      if (paramInt1 <= i) {
        return i;
      }
      throw new StringIndexOutOfBoundsException("end < start");
    }
    throw new StringIndexOutOfBoundsException(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrBuilder
 * JD-Core Version:    0.7.0.1
 */