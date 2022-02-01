package org.apache.commons.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang.text.StrBuilder;

public class StringEscapeUtils
{
  private static final char CSV_DELIMITER = ',';
  private static final char CSV_QUOTE = '"';
  private static final String CSV_QUOTE_STR = String.valueOf('"');
  private static final char[] CSV_SEARCH_CHARS = { 44, 34, 13, 10 };
  
  public static String escapeCsv(String paramString)
  {
    if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS)) {
      return paramString;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      escapeCsv(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public static void escapeCsv(Writer paramWriter, String paramString)
  {
    if (StringUtils.containsNone(paramString, CSV_SEARCH_CHARS))
    {
      if (paramString != null) {
        paramWriter.write(paramString);
      }
      return;
    }
    paramWriter.write(34);
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if (j == 34) {
        paramWriter.write(34);
      }
      paramWriter.write(j);
      i += 1;
    }
    paramWriter.write(34);
  }
  
  public static String escapeHtml(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      int i = paramString.length();
      double d = i;
      Double.isNaN(d);
      i = (int)(d * 1.5D);
      StringWriter localStringWriter = new StringWriter(i);
      escapeHtml(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public static void escapeHtml(Writer paramWriter, String paramString)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      Entities.HTML40.escape(paramWriter, paramString);
      return;
    }
    throw new IllegalArgumentException("The Writer must not be null.");
  }
  
  public static String escapeJava(String paramString)
  {
    return escapeJavaStyleString(paramString, false, false);
  }
  
  public static void escapeJava(Writer paramWriter, String paramString)
  {
    escapeJavaStyleString(paramWriter, paramString, false, false);
  }
  
  public static String escapeJavaScript(String paramString)
  {
    return escapeJavaStyleString(paramString, true, true);
  }
  
  public static void escapeJavaScript(Writer paramWriter, String paramString)
  {
    escapeJavaStyleString(paramWriter, paramString, true, true);
  }
  
  private static String escapeJavaStyleString(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramString.length() * 2);
      escapeJavaStyleString(localStringWriter, paramString, paramBoolean1, paramBoolean2);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  private static void escapeJavaStyleString(Writer paramWriter, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      int k = paramString.length();
      int j = 0;
      while (j < k)
      {
        int i = paramString.charAt(j);
        StringBuffer localStringBuffer;
        if (i > 4095)
        {
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("\\u");
          localStringBuffer.append(hex(i));
          paramWriter.write(localStringBuffer.toString());
        }
        else if (i > 255)
        {
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("\\u0");
          localStringBuffer.append(hex(i));
          paramWriter.write(localStringBuffer.toString());
        }
        else if (i > 127)
        {
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("\\u00");
          localStringBuffer.append(hex(i));
          paramWriter.write(localStringBuffer.toString());
        }
        else if (i < 32)
        {
          switch (i)
          {
          case 11: 
          default: 
            if (i > 15)
            {
              localStringBuffer = new StringBuffer();
              localStringBuffer.append("\\u00");
              localStringBuffer.append(hex(i));
              paramWriter.write(localStringBuffer.toString());
            }
            break;
          case 13: 
            paramWriter.write(92);
            paramWriter.write(114);
            break;
          case 12: 
            paramWriter.write(92);
            paramWriter.write(102);
            break;
          case 10: 
            paramWriter.write(92);
            paramWriter.write(110);
            break;
          case 9: 
            paramWriter.write(92);
            paramWriter.write(116);
            break;
          case 8: 
            paramWriter.write(92);
            paramWriter.write(98);
            break;
          }
          localStringBuffer = new StringBuffer();
          localStringBuffer.append("\\u000");
          localStringBuffer.append(hex(i));
          paramWriter.write(localStringBuffer.toString());
        }
        else if (i != 34)
        {
          if (i != 39)
          {
            if (i != 47)
            {
              if (i != 92)
              {
                paramWriter.write(i);
              }
              else
              {
                paramWriter.write(92);
                paramWriter.write(92);
              }
            }
            else
            {
              if (paramBoolean2) {
                paramWriter.write(92);
              }
              paramWriter.write(47);
            }
          }
          else
          {
            if (paramBoolean1) {
              paramWriter.write(92);
            }
            paramWriter.write(39);
          }
        }
        else
        {
          paramWriter.write(92);
          paramWriter.write(34);
        }
        j += 1;
      }
      return;
    }
    paramWriter = new IllegalArgumentException("The Writer must not be null");
    for (;;)
    {
      throw paramWriter;
    }
  }
  
  public static String escapeSql(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return StringUtils.replace(paramString, "'", "''");
  }
  
  public static String escapeXml(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Entities.XML.escape(paramString);
  }
  
  public static void escapeXml(Writer paramWriter, String paramString)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      Entities.XML.escape(paramWriter, paramString);
      return;
    }
    throw new IllegalArgumentException("The Writer must not be null.");
  }
  
  private static String hex(char paramChar)
  {
    return Integer.toHexString(paramChar).toUpperCase(Locale.ENGLISH);
  }
  
  public static String unescapeCsv(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      unescapeCsv(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public static void unescapeCsv(Writer paramWriter, String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() < 2)
    {
      paramWriter.write(paramString);
      return;
    }
    if ((paramString.charAt(0) == '"') && (paramString.charAt(paramString.length() - 1) == '"'))
    {
      String str = paramString.substring(1, paramString.length() - 1);
      if (StringUtils.containsAny(str, CSV_SEARCH_CHARS))
      {
        paramString = new StringBuffer();
        paramString.append(CSV_QUOTE_STR);
        paramString.append(CSV_QUOTE_STR);
        paramString = StringUtils.replace(str, paramString.toString(), CSV_QUOTE_STR);
      }
      paramWriter.write(paramString);
      return;
    }
    paramWriter.write(paramString);
  }
  
  public static String unescapeHtml(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      int i = paramString.length();
      double d = i;
      Double.isNaN(d);
      i = (int)(d * 1.5D);
      StringWriter localStringWriter = new StringWriter(i);
      unescapeHtml(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public static void unescapeHtml(Writer paramWriter, String paramString)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      Entities.HTML40.unescape(paramWriter, paramString);
      return;
    }
    throw new IllegalArgumentException("The Writer must not be null.");
  }
  
  public static String unescapeJava(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter(paramString.length());
      unescapeJava(localStringWriter, paramString);
      paramString = localStringWriter.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new UnhandledException(paramString);
    }
  }
  
  public static void unescapeJava(Writer paramWriter, String paramString)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      int m = paramString.length();
      StrBuilder localStrBuilder = new StrBuilder(4);
      int k = 0;
      int i = 0;
      int j = 0;
      while (k < m)
      {
        char c = paramString.charAt(k);
        if (j != 0)
        {
          localStrBuilder.append(c);
          if (localStrBuilder.length() == 4) {
            try
            {
              paramWriter.write((char)Integer.parseInt(localStrBuilder.toString(), 16));
              localStrBuilder.setLength(0);
              i = 0;
              j = 0;
            }
            catch (NumberFormatException paramWriter)
            {
              paramString = new StringBuffer();
              paramString.append("Unable to parse unicode value: ");
              paramString.append(localStrBuilder);
              throw new NestableRuntimeException(paramString.toString(), paramWriter);
            }
          }
        }
        else if (i != 0)
        {
          if (c != '"')
          {
            if (c != '\'')
            {
              if (c != '\\')
              {
                if (c != 'b')
                {
                  if (c != 'f')
                  {
                    if (c != 'n')
                    {
                      if (c != 'r')
                      {
                        if (c != 't')
                        {
                          if (c != 'u')
                          {
                            paramWriter.write(c);
                          }
                          else
                          {
                            i = 0;
                            j = 1;
                            break label298;
                          }
                        }
                        else {
                          paramWriter.write(9);
                        }
                      }
                      else {
                        paramWriter.write(13);
                      }
                    }
                    else {
                      paramWriter.write(10);
                    }
                  }
                  else {
                    paramWriter.write(12);
                  }
                }
                else {
                  paramWriter.write(8);
                }
              }
              else {
                paramWriter.write(92);
              }
            }
            else {
              paramWriter.write(39);
            }
          }
          else {
            paramWriter.write(34);
          }
          i = 0;
        }
        else if (c == '\\')
        {
          i = 1;
        }
        else
        {
          paramWriter.write(c);
        }
        label298:
        k += 1;
      }
      if (i != 0) {
        paramWriter.write(92);
      }
      return;
    }
    paramWriter = new IllegalArgumentException("The Writer must not be null");
    for (;;)
    {
      throw paramWriter;
    }
  }
  
  public static String unescapeJavaScript(String paramString)
  {
    return unescapeJava(paramString);
  }
  
  public static void unescapeJavaScript(Writer paramWriter, String paramString)
  {
    unescapeJava(paramWriter, paramString);
  }
  
  public static String unescapeXml(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Entities.XML.unescape(paramString);
  }
  
  public static void unescapeXml(Writer paramWriter, String paramString)
  {
    if (paramWriter != null)
    {
      if (paramString == null) {
        return;
      }
      Entities.XML.unescape(paramWriter, paramString);
      return;
    }
    throw new IllegalArgumentException("The Writer must not be null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.StringEscapeUtils
 * JD-Core Version:    0.7.0.1
 */