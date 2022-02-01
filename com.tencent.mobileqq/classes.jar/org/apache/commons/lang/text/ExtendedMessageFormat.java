package org.apache.commons.lang.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.Validate;

public class ExtendedMessageFormat
  extends MessageFormat
{
  private static final String DUMMY_PATTERN = "";
  private static final char END_FE = '}';
  private static final String ESCAPED_QUOTE = "''";
  private static final int HASH_SEED = 31;
  private static final char QUOTE = '\'';
  private static final char START_FE = '{';
  private static final char START_FMT = ',';
  private static final long serialVersionUID = -2362048321261811743L;
  private final Map registry;
  private String toPattern;
  
  public ExtendedMessageFormat(String paramString)
  {
    this(paramString, Locale.getDefault());
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale)
  {
    this(paramString, paramLocale, null);
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale, Map paramMap)
  {
    super("");
    setLocale(paramLocale);
    this.registry = paramMap;
    applyPattern(paramString);
  }
  
  public ExtendedMessageFormat(String paramString, Map paramMap)
  {
    this(paramString, Locale.getDefault(), paramMap);
  }
  
  private StrBuilder appendQuotedString(String paramString, ParsePosition paramParsePosition, StrBuilder paramStrBuilder, boolean paramBoolean)
  {
    int k = paramParsePosition.getIndex();
    char[] arrayOfChar = paramString.toCharArray();
    if ((paramBoolean) && (arrayOfChar[k] == '\''))
    {
      next(paramParsePosition);
      if (paramStrBuilder == null) {
        return null;
      }
      return paramStrBuilder.append('\'');
    }
    int i = paramParsePosition.getIndex();
    int j = k;
    while (i < paramString.length())
    {
      if ((paramBoolean) && (paramString.substring(i).startsWith("''")))
      {
        paramStrBuilder.append(arrayOfChar, j, paramParsePosition.getIndex() - j).append('\'');
        paramParsePosition.setIndex(i + 2);
        j = paramParsePosition.getIndex();
      }
      else
      {
        if (arrayOfChar[paramParsePosition.getIndex()] == '\'') {
          break label149;
        }
        next(paramParsePosition);
      }
      i += 1;
      continue;
      label149:
      next(paramParsePosition);
      if (paramStrBuilder == null) {
        return null;
      }
      return paramStrBuilder.append(arrayOfChar, j, paramParsePosition.getIndex() - j);
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated quoted string at position ");
    paramString.append(k);
    paramString = new IllegalArgumentException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  private boolean containsElements(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      if (paramCollection.size() == 0) {
        return false;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (paramCollection.next() != null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private Format getFormat(String paramString)
  {
    if (this.registry != null)
    {
      int i = paramString.indexOf(',');
      String str;
      if (i > 0)
      {
        str = paramString.substring(0, i).trim();
        paramString = paramString.substring(i + 1).trim();
      }
      else
      {
        localFormatFactory = null;
        str = paramString;
        paramString = localFormatFactory;
      }
      FormatFactory localFormatFactory = (FormatFactory)this.registry.get(str);
      if (localFormatFactory != null) {
        return localFormatFactory.getFormat(str, paramString, getLocale());
      }
    }
    return null;
  }
  
  private void getQuotedString(String paramString, ParsePosition paramParsePosition, boolean paramBoolean)
  {
    appendQuotedString(paramString, paramParsePosition, null, paramBoolean);
  }
  
  private String insertFormats(String paramString, ArrayList paramArrayList)
  {
    if (!containsElements(paramArrayList)) {
      return paramString;
    }
    StrBuilder localStrBuilder = new StrBuilder(paramString.length() * 2);
    ParsePosition localParsePosition = new ParsePosition(0);
    int i = 0;
    int j = -1;
    while (localParsePosition.getIndex() < paramString.length())
    {
      char c = paramString.charAt(localParsePosition.getIndex());
      if (c != '\'')
      {
        if (c != '{')
        {
          if (c == '}') {
            i -= 1;
          }
          localStrBuilder.append(c);
          next(localParsePosition);
        }
        else
        {
          int k = i + 1;
          i = k;
          if (k == 1)
          {
            int m = j + 1;
            localStrBuilder.append('{').append(readArgumentIndex(paramString, next(localParsePosition)));
            String str = (String)paramArrayList.get(m);
            i = k;
            j = m;
            if (str != null)
            {
              localStrBuilder.append(',').append(str);
              i = k;
              j = m;
            }
          }
        }
      }
      else {
        appendQuotedString(paramString, localParsePosition, localStrBuilder, false);
      }
    }
    return localStrBuilder.toString();
  }
  
  private ParsePosition next(ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
    return paramParsePosition;
  }
  
  private String parseFormatDescription(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    int m = paramParsePosition.getIndex();
    int i = 1;
    while (paramParsePosition.getIndex() < paramString.length())
    {
      int j = paramString.charAt(paramParsePosition.getIndex());
      if (j != 39)
      {
        if (j != 123)
        {
          if (j == 125)
          {
            j = i - 1;
            i = j;
            if (j == 0) {
              return paramString.substring(m, paramParsePosition.getIndex());
            }
          }
        }
        else {
          i += 1;
        }
      }
      else {
        getQuotedString(paramString, paramParsePosition, false);
      }
      next(paramParsePosition);
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated format element at position ");
    paramString.append(k);
    paramString = new IllegalArgumentException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  private int readArgumentIndex(String paramString, ParsePosition paramParsePosition)
  {
    int j = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    Object localObject = new StrBuilder();
    int i = 0;
    while ((i == 0) && (paramParsePosition.getIndex() < paramString.length()))
    {
      char c2 = paramString.charAt(paramParsePosition.getIndex());
      char c1 = c2;
      if (Character.isWhitespace(c2))
      {
        seekNonWs(paramString, paramParsePosition);
        c2 = paramString.charAt(paramParsePosition.getIndex());
        c1 = c2;
        if (c2 != ',')
        {
          c1 = c2;
          if (c2 != '}')
          {
            i = 1;
            break label155;
          }
        }
      }
      if (((c1 == ',') || (c1 == '}')) && (((StrBuilder)localObject).length() > 0)) {}
      try
      {
        i = Integer.parseInt(((StrBuilder)localObject).toString());
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label136:
        boolean bool;
        label155:
        break label136;
      }
      bool = Character.isDigit(c1);
      ((StrBuilder)localObject).append(c1);
      i = bool ^ true;
      next(paramParsePosition);
    }
    if (i != 0)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("Invalid format argument index at position ");
      ((StringBuffer)localObject).append(j);
      ((StringBuffer)localObject).append(": ");
      ((StringBuffer)localObject).append(paramString.substring(j, paramParsePosition.getIndex()));
      throw new IllegalArgumentException(((StringBuffer)localObject).toString());
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated format element at position ");
    paramString.append(j);
    paramString = new IllegalArgumentException(paramString.toString());
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void seekNonWs(String paramString, ParsePosition paramParsePosition)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i;
    do
    {
      i = StrMatcher.splitMatcher().isMatch(arrayOfChar, paramParsePosition.getIndex());
      paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
    } while ((i > 0) && (paramParsePosition.getIndex() < paramString.length()));
  }
  
  public final void applyPattern(String paramString)
  {
    if (this.registry == null)
    {
      super.applyPattern(paramString);
      this.toPattern = super.toPattern();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StrBuilder localStrBuilder = new StrBuilder(paramString.length());
    int j = 0;
    ParsePosition localParsePosition = new ParsePosition(0);
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    Object localObject1;
    Object localObject2;
    while (localParsePosition.getIndex() < paramString.length())
    {
      int k = arrayOfChar[localParsePosition.getIndex()];
      boolean bool2 = true;
      if (k != 39)
      {
        if (k == 123)
        {
          i += 1;
          seekNonWs(paramString, localParsePosition);
          k = localParsePosition.getIndex();
          int m = readArgumentIndex(paramString, next(localParsePosition));
          localStrBuilder.append('{').append(m);
          seekNonWs(paramString, localParsePosition);
          if (arrayOfChar[localParsePosition.getIndex()] == ',')
          {
            String str = parseFormatDescription(paramString, next(localParsePosition));
            Format localFormat = getFormat(str);
            localObject1 = str;
            localObject2 = localFormat;
            if (localFormat == null)
            {
              localStrBuilder.append(',').append(str);
              localObject1 = str;
              localObject2 = localFormat;
            }
          }
          else
          {
            localObject1 = null;
            localObject2 = localObject1;
          }
          localArrayList1.add(localObject2);
          if (localObject2 == null) {
            localObject1 = null;
          }
          localArrayList2.add(localObject1);
          boolean bool1;
          if (localArrayList1.size() == i) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          Validate.isTrue(bool1);
          if (localArrayList2.size() == i) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          Validate.isTrue(bool1);
          if (arrayOfChar[localParsePosition.getIndex()] != '}') {}
        }
        else
        {
          localStrBuilder.append(arrayOfChar[localParsePosition.getIndex()]);
          next(localParsePosition);
          continue;
        }
        paramString = new StringBuffer();
        paramString.append("Unreadable format element at position ");
        paramString.append(k);
        throw new IllegalArgumentException(paramString.toString());
      }
      else
      {
        appendQuotedString(paramString, localParsePosition, localStrBuilder, true);
      }
    }
    super.applyPattern(localStrBuilder.toString());
    this.toPattern = insertFormats(super.toPattern(), localArrayList2);
    if (containsElements(localArrayList1))
    {
      paramString = getFormats();
      localObject1 = localArrayList1.iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Format)((Iterator)localObject1).next();
        if (localObject2 != null) {
          paramString[i] = localObject2;
        }
        i += 1;
      }
      super.setFormats(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    if (ObjectUtils.notEqual(getClass(), paramObject.getClass())) {
      return false;
    }
    paramObject = (ExtendedMessageFormat)paramObject;
    if (ObjectUtils.notEqual(this.toPattern, paramObject.toPattern)) {
      return false;
    }
    return !ObjectUtils.notEqual(this.registry, paramObject.registry);
  }
  
  public int hashCode()
  {
    return (super.hashCode() * 31 + ObjectUtils.hashCode(this.registry)) * 31 + ObjectUtils.hashCode(this.toPattern);
  }
  
  public void setFormat(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatByArgumentIndex(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormats(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toPattern()
  {
    return this.toPattern;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.ExtendedMessageFormat
 * JD-Core Version:    0.7.0.1
 */