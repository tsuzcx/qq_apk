package org.apache.commons.lang.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class StrTokenizer
  implements Cloneable, ListIterator
{
  private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE = new StrTokenizer();
  private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
  private char[] chars;
  private StrMatcher delimMatcher = StrMatcher.splitMatcher();
  private boolean emptyAsNull = false;
  private boolean ignoreEmptyTokens = true;
  private StrMatcher ignoredMatcher = StrMatcher.noneMatcher();
  private StrMatcher quoteMatcher = StrMatcher.noneMatcher();
  private int tokenPos;
  private String[] tokens;
  private StrMatcher trimmerMatcher = StrMatcher.noneMatcher();
  
  static
  {
    CSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.commaMatcher());
    CSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
    CSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
    CSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
    CSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
    CSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
    TSV_TOKENIZER_PROTOTYPE = new StrTokenizer();
    TSV_TOKENIZER_PROTOTYPE.setDelimiterMatcher(StrMatcher.tabMatcher());
    TSV_TOKENIZER_PROTOTYPE.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
    TSV_TOKENIZER_PROTOTYPE.setIgnoredMatcher(StrMatcher.noneMatcher());
    TSV_TOKENIZER_PROTOTYPE.setTrimmerMatcher(StrMatcher.trimMatcher());
    TSV_TOKENIZER_PROTOTYPE.setEmptyTokenAsNull(false);
    TSV_TOKENIZER_PROTOTYPE.setIgnoreEmptyTokens(false);
  }
  
  public StrTokenizer()
  {
    this.chars = null;
  }
  
  public StrTokenizer(String paramString)
  {
    if (paramString != null)
    {
      this.chars = paramString.toCharArray();
      return;
    }
    this.chars = null;
  }
  
  public StrTokenizer(String paramString, char paramChar)
  {
    this(paramString);
    setDelimiterChar(paramChar);
  }
  
  public StrTokenizer(String paramString, char paramChar1, char paramChar2)
  {
    this(paramString, paramChar1);
    setQuoteChar(paramChar2);
  }
  
  public StrTokenizer(String paramString1, String paramString2)
  {
    this(paramString1);
    setDelimiterString(paramString2);
  }
  
  public StrTokenizer(String paramString, StrMatcher paramStrMatcher)
  {
    this(paramString);
    setDelimiterMatcher(paramStrMatcher);
  }
  
  public StrTokenizer(String paramString, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2)
  {
    this(paramString, paramStrMatcher1);
    setQuoteMatcher(paramStrMatcher2);
  }
  
  public StrTokenizer(char[] paramArrayOfChar)
  {
    this.chars = paramArrayOfChar;
  }
  
  public StrTokenizer(char[] paramArrayOfChar, char paramChar)
  {
    this(paramArrayOfChar);
    setDelimiterChar(paramChar);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, char paramChar1, char paramChar2)
  {
    this(paramArrayOfChar, paramChar1);
    setQuoteChar(paramChar2);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, String paramString)
  {
    this(paramArrayOfChar);
    setDelimiterString(paramString);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, StrMatcher paramStrMatcher)
  {
    this(paramArrayOfChar);
    setDelimiterMatcher(paramStrMatcher);
  }
  
  public StrTokenizer(char[] paramArrayOfChar, StrMatcher paramStrMatcher1, StrMatcher paramStrMatcher2)
  {
    this(paramArrayOfChar, paramStrMatcher1);
    setQuoteMatcher(paramStrMatcher2);
  }
  
  private void addToken(List paramList, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      if (isIgnoreEmptyTokens()) {
        return;
      }
      str = paramString;
      if (isEmptyTokenAsNull()) {
        str = null;
      }
    }
    paramList.add(str);
  }
  
  private void checkTokenized()
  {
    if (this.tokens == null)
    {
      Object localObject = this.chars;
      if (localObject == null)
      {
        localObject = tokenize(null, 0, 0);
        this.tokens = ((String[])((List)localObject).toArray(new String[((List)localObject).size()]));
        return;
      }
      localObject = tokenize((char[])localObject, 0, localObject.length);
      this.tokens = ((String[])((List)localObject).toArray(new String[((List)localObject).size()]));
    }
  }
  
  private static StrTokenizer getCSVClone()
  {
    return (StrTokenizer)CSV_TOKENIZER_PROTOTYPE.clone();
  }
  
  public static StrTokenizer getCSVInstance()
  {
    return getCSVClone();
  }
  
  public static StrTokenizer getCSVInstance(String paramString)
  {
    StrTokenizer localStrTokenizer = getCSVClone();
    localStrTokenizer.reset(paramString);
    return localStrTokenizer;
  }
  
  public static StrTokenizer getCSVInstance(char[] paramArrayOfChar)
  {
    StrTokenizer localStrTokenizer = getCSVClone();
    localStrTokenizer.reset(paramArrayOfChar);
    return localStrTokenizer;
  }
  
  private static StrTokenizer getTSVClone()
  {
    return (StrTokenizer)TSV_TOKENIZER_PROTOTYPE.clone();
  }
  
  public static StrTokenizer getTSVInstance()
  {
    return getTSVClone();
  }
  
  public static StrTokenizer getTSVInstance(String paramString)
  {
    StrTokenizer localStrTokenizer = getTSVClone();
    localStrTokenizer.reset(paramString);
    return localStrTokenizer;
  }
  
  public static StrTokenizer getTSVInstance(char[] paramArrayOfChar)
  {
    StrTokenizer localStrTokenizer = getTSVClone();
    localStrTokenizer.reset(paramArrayOfChar);
    return localStrTokenizer;
  }
  
  private boolean isQuote(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    while (i < paramInt4)
    {
      int j = paramInt1 + i;
      if (j < paramInt2)
      {
        if (paramArrayOfChar[j] != paramArrayOfChar[(paramInt3 + i)]) {
          return false;
        }
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  private int readNextToken(char[] paramArrayOfChar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List paramList)
  {
    while (paramInt1 < paramInt2)
    {
      i = Math.max(getIgnoredMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2), getTrimmerMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2));
      if ((i == 0) || (getDelimiterMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2) > 0) || (getQuoteMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2) > 0)) {
        break;
      }
      paramInt1 += i;
    }
    if (paramInt1 >= paramInt2)
    {
      addToken(paramList, "");
      return -1;
    }
    int i = getDelimiterMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2);
    if (i > 0)
    {
      addToken(paramList, "");
      return paramInt1 + i;
    }
    i = getQuoteMatcher().isMatch(paramArrayOfChar, paramInt1, paramInt1, paramInt2);
    if (i > 0) {
      return readWithQuotes(paramArrayOfChar, paramInt1 + i, paramInt2, paramStrBuilder, paramList, paramInt1, i);
    }
    return readWithQuotes(paramArrayOfChar, paramInt1, paramInt2, paramStrBuilder, paramList, 0, 0);
  }
  
  private int readWithQuotes(char[] paramArrayOfChar, int paramInt1, int paramInt2, StrBuilder paramStrBuilder, List paramList, int paramInt3, int paramInt4)
  {
    paramStrBuilder.clear();
    if (paramInt4 > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j = paramInt1;
    int m = 0;
    int k = i;
    int i = m;
    while (j < paramInt2) {
      if (k != 0)
      {
        if (isQuote(paramArrayOfChar, j, paramInt2, paramInt3, paramInt4))
        {
          m = j + paramInt4;
          if (isQuote(paramArrayOfChar, m, paramInt2, paramInt3, paramInt4))
          {
            paramStrBuilder.append(paramArrayOfChar, j, paramInt4);
            j += paramInt4 * 2;
            i = paramStrBuilder.size();
          }
          else
          {
            j = m;
            k = 0;
          }
        }
        else
        {
          m = j + 1;
          paramStrBuilder.append(paramArrayOfChar[j]);
          i = paramStrBuilder.size();
          j = m;
        }
      }
      else {
        for (;;)
        {
          break;
          m = getDelimiterMatcher().isMatch(paramArrayOfChar, j, paramInt1, paramInt2);
          if (m > 0)
          {
            addToken(paramList, paramStrBuilder.substring(0, i));
            return j + m;
          }
          if ((paramInt4 > 0) && (isQuote(paramArrayOfChar, j, paramInt2, paramInt3, paramInt4)))
          {
            j += paramInt4;
            k = 1;
            break;
          }
          m = getIgnoredMatcher().isMatch(paramArrayOfChar, j, paramInt1, paramInt2);
          if (m > 0) {}
          for (;;)
          {
            j += m;
            break;
            m = getTrimmerMatcher().isMatch(paramArrayOfChar, j, paramInt1, paramInt2);
            if (m <= 0) {
              break label286;
            }
            paramStrBuilder.append(paramArrayOfChar, j, m);
          }
          label286:
          i = j + 1;
          paramStrBuilder.append(paramArrayOfChar[j]);
          m = paramStrBuilder.size();
          j = i;
          i = m;
        }
      }
    }
    addToken(paramList, paramStrBuilder.substring(0, i));
    return -1;
  }
  
  public void add(Object paramObject)
  {
    throw new UnsupportedOperationException("add() is unsupported");
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = cloneReset();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  Object cloneReset()
  {
    StrTokenizer localStrTokenizer = (StrTokenizer)super.clone();
    char[] arrayOfChar = localStrTokenizer.chars;
    if (arrayOfChar != null) {
      localStrTokenizer.chars = ((char[])arrayOfChar.clone());
    }
    localStrTokenizer.reset();
    return localStrTokenizer;
  }
  
  public String getContent()
  {
    char[] arrayOfChar = this.chars;
    if (arrayOfChar == null) {
      return null;
    }
    return new String(arrayOfChar);
  }
  
  public StrMatcher getDelimiterMatcher()
  {
    return this.delimMatcher;
  }
  
  public StrMatcher getIgnoredMatcher()
  {
    return this.ignoredMatcher;
  }
  
  public StrMatcher getQuoteMatcher()
  {
    return this.quoteMatcher;
  }
  
  public String[] getTokenArray()
  {
    checkTokenized();
    return (String[])this.tokens.clone();
  }
  
  public List getTokenList()
  {
    checkTokenized();
    ArrayList localArrayList = new ArrayList(this.tokens.length);
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = this.tokens;
      if (i >= arrayOfString.length) {
        break;
      }
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public StrMatcher getTrimmerMatcher()
  {
    return this.trimmerMatcher;
  }
  
  public boolean hasNext()
  {
    checkTokenized();
    return this.tokenPos < this.tokens.length;
  }
  
  public boolean hasPrevious()
  {
    checkTokenized();
    return this.tokenPos > 0;
  }
  
  public boolean isEmptyTokenAsNull()
  {
    return this.emptyAsNull;
  }
  
  public boolean isIgnoreEmptyTokens()
  {
    return this.ignoreEmptyTokens;
  }
  
  public Object next()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos;
      this.tokenPos = (i + 1);
      return arrayOfString[i];
    }
    throw new NoSuchElementException();
  }
  
  public int nextIndex()
  {
    return this.tokenPos;
  }
  
  public String nextToken()
  {
    if (hasNext())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos;
      this.tokenPos = (i + 1);
      return arrayOfString[i];
    }
    return null;
  }
  
  public Object previous()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos - 1;
      this.tokenPos = i;
      return arrayOfString[i];
    }
    throw new NoSuchElementException();
  }
  
  public int previousIndex()
  {
    return this.tokenPos - 1;
  }
  
  public String previousToken()
  {
    if (hasPrevious())
    {
      String[] arrayOfString = this.tokens;
      int i = this.tokenPos - 1;
      this.tokenPos = i;
      return arrayOfString[i];
    }
    return null;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("remove() is unsupported");
  }
  
  public StrTokenizer reset()
  {
    this.tokenPos = 0;
    this.tokens = null;
    return this;
  }
  
  public StrTokenizer reset(String paramString)
  {
    reset();
    if (paramString != null)
    {
      this.chars = paramString.toCharArray();
      return this;
    }
    this.chars = null;
    return this;
  }
  
  public StrTokenizer reset(char[] paramArrayOfChar)
  {
    reset();
    this.chars = paramArrayOfChar;
    return this;
  }
  
  public void set(Object paramObject)
  {
    throw new UnsupportedOperationException("set() is unsupported");
  }
  
  public StrTokenizer setDelimiterChar(char paramChar)
  {
    return setDelimiterMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setDelimiterMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher == null)
    {
      this.delimMatcher = StrMatcher.noneMatcher();
      return this;
    }
    this.delimMatcher = paramStrMatcher;
    return this;
  }
  
  public StrTokenizer setDelimiterString(String paramString)
  {
    return setDelimiterMatcher(StrMatcher.stringMatcher(paramString));
  }
  
  public StrTokenizer setEmptyTokenAsNull(boolean paramBoolean)
  {
    this.emptyAsNull = paramBoolean;
    return this;
  }
  
  public StrTokenizer setIgnoreEmptyTokens(boolean paramBoolean)
  {
    this.ignoreEmptyTokens = paramBoolean;
    return this;
  }
  
  public StrTokenizer setIgnoredChar(char paramChar)
  {
    return setIgnoredMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setIgnoredMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.ignoredMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public StrTokenizer setQuoteChar(char paramChar)
  {
    return setQuoteMatcher(StrMatcher.charMatcher(paramChar));
  }
  
  public StrTokenizer setQuoteMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.quoteMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public StrTokenizer setTrimmerMatcher(StrMatcher paramStrMatcher)
  {
    if (paramStrMatcher != null) {
      this.trimmerMatcher = paramStrMatcher;
    }
    return this;
  }
  
  public int size()
  {
    checkTokenized();
    return this.tokens.length;
  }
  
  public String toString()
  {
    if (this.tokens == null) {
      return "StrTokenizer[not tokenized yet]";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("StrTokenizer");
    localStringBuffer.append(getTokenList());
    return localStringBuffer.toString();
  }
  
  protected List tokenize(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfChar != null) && (paramInt2 != 0))
    {
      StrBuilder localStrBuilder = new StrBuilder();
      ArrayList localArrayList = new ArrayList();
      while ((paramInt1 >= 0) && (paramInt1 < paramInt2))
      {
        int i = readNextToken(paramArrayOfChar, paramInt1, paramInt2, localStrBuilder, localArrayList);
        paramInt1 = i;
        if (i >= paramInt2)
        {
          addToken(localArrayList, "");
          paramInt1 = i;
        }
      }
      return localArrayList;
    }
    return Collections.EMPTY_LIST;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrTokenizer
 * JD-Core Version:    0.7.0.1
 */