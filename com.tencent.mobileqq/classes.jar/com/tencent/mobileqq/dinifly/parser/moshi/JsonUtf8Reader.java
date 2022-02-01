package com.tencent.mobileqq.dinifly.parser.moshi;

import androidx.annotation.Nullable;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class JsonUtf8Reader
  extends JsonReader
{
  private static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");
  private static final ByteString DOUBLE_QUOTE_OR_SLASH;
  private static final ByteString LINEFEED_OR_CARRIAGE_RETURN;
  private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
  private static final int NUMBER_CHAR_DECIMAL = 3;
  private static final int NUMBER_CHAR_DIGIT = 2;
  private static final int NUMBER_CHAR_EXP_DIGIT = 7;
  private static final int NUMBER_CHAR_EXP_E = 5;
  private static final int NUMBER_CHAR_EXP_SIGN = 6;
  private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
  private static final int NUMBER_CHAR_NONE = 0;
  private static final int NUMBER_CHAR_SIGN = 1;
  private static final int PEEKED_BEGIN_ARRAY = 3;
  private static final int PEEKED_BEGIN_OBJECT = 1;
  private static final int PEEKED_BUFFERED = 11;
  private static final int PEEKED_BUFFERED_NAME = 15;
  private static final int PEEKED_DOUBLE_QUOTED = 9;
  private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
  private static final int PEEKED_END_ARRAY = 4;
  private static final int PEEKED_END_OBJECT = 2;
  private static final int PEEKED_EOF = 18;
  private static final int PEEKED_FALSE = 6;
  private static final int PEEKED_LONG = 16;
  private static final int PEEKED_NONE = 0;
  private static final int PEEKED_NULL = 7;
  private static final int PEEKED_NUMBER = 17;
  private static final int PEEKED_SINGLE_QUOTED = 8;
  private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
  private static final int PEEKED_TRUE = 5;
  private static final int PEEKED_UNQUOTED = 10;
  private static final int PEEKED_UNQUOTED_NAME = 14;
  private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
  private static final ByteString UNQUOTED_STRING_TERMINALS;
  private final Buffer buffer;
  private int peeked = 0;
  private long peekedLong;
  private int peekedNumberLength;
  @Nullable
  private String peekedString;
  private final BufferedSource source;
  
  static
  {
    DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
  }
  
  JsonUtf8Reader(BufferedSource paramBufferedSource)
  {
    if (paramBufferedSource != null)
    {
      this.source = paramBufferedSource;
      this.buffer = paramBufferedSource.buffer();
      pushScope(6);
      return;
    }
    throw new NullPointerException("source == null");
  }
  
  private void checkLenient()
  {
    if (this.lenient) {
      return;
    }
    throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private int doPeek()
  {
    int i = this.scopes[(this.stackSize - 1)];
    if (i == 1)
    {
      this.scopes[(this.stackSize - 1)] = 2;
    }
    else if (i == 2)
    {
      j = nextNonWhitespace(true);
      this.buffer.readByte();
      if (j != 44)
      {
        if (j != 59)
        {
          if (j == 93)
          {
            this.peeked = 4;
            return 4;
          }
          throw syntaxError("Unterminated array");
        }
        checkLenient();
      }
    }
    else
    {
      if ((i == 3) || (i == 5)) {
        break label489;
      }
      if (i == 4)
      {
        this.scopes[(this.stackSize - 1)] = 5;
        j = nextNonWhitespace(true);
        this.buffer.readByte();
        if (j != 58) {
          if (j == 61)
          {
            checkLenient();
            if ((this.source.request(1L)) && (this.buffer.getByte(0L) == 62)) {
              this.buffer.readByte();
            }
          }
          else
          {
            throw syntaxError("Expected ':'");
          }
        }
      }
      else if (i == 6)
      {
        this.scopes[(this.stackSize - 1)] = 7;
      }
      else if (i == 7)
      {
        if (nextNonWhitespace(false) == -1)
        {
          this.peeked = 18;
          return 18;
        }
        checkLenient();
      }
      else
      {
        if (i == 8) {
          break label479;
        }
      }
    }
    int j = nextNonWhitespace(true);
    if (j != 34)
    {
      if (j != 39)
      {
        if ((j != 44) && (j != 59)) {
          if (j != 91)
          {
            if (j != 93)
            {
              if (j != 123)
              {
                i = peekKeyword();
                if (i != 0) {
                  return i;
                }
                i = peekNumber();
                if (i != 0) {
                  return i;
                }
                if (isLiteral(this.buffer.getByte(0L)))
                {
                  checkLenient();
                  this.peeked = 10;
                  return 10;
                }
                throw syntaxError("Expected value");
              }
              this.buffer.readByte();
              this.peeked = 1;
              return 1;
            }
            if (i == 1)
            {
              this.buffer.readByte();
              this.peeked = 4;
              return 4;
            }
          }
          else
          {
            this.buffer.readByte();
            this.peeked = 3;
            return 3;
          }
        }
        if ((i != 1) && (i != 2)) {
          throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.peeked = 7;
        return 7;
      }
      checkLenient();
      this.buffer.readByte();
      this.peeked = 8;
      return 8;
    }
    this.buffer.readByte();
    this.peeked = 9;
    return 9;
    label479:
    throw new IllegalStateException("JsonReader is closed");
    label489:
    this.scopes[(this.stackSize - 1)] = 4;
    if (i == 5)
    {
      j = nextNonWhitespace(true);
      this.buffer.readByte();
      if (j != 44)
      {
        if (j != 59)
        {
          if (j == 125)
          {
            this.peeked = 2;
            return 2;
          }
          throw syntaxError("Unterminated object");
        }
        checkLenient();
      }
    }
    j = nextNonWhitespace(true);
    if (j != 34)
    {
      if (j != 39)
      {
        if (j != 125)
        {
          checkLenient();
          if (isLiteral((char)j))
          {
            this.peeked = 14;
            return 14;
          }
          throw syntaxError("Expected name");
        }
        if (i != 5)
        {
          this.buffer.readByte();
          this.peeked = 2;
          return 2;
        }
        throw syntaxError("Expected name");
      }
      this.buffer.readByte();
      checkLenient();
      this.peeked = 12;
      return 12;
    }
    this.buffer.readByte();
    this.peeked = 13;
    return 13;
  }
  
  private int findName(String paramString, JsonReader.Options paramOptions)
  {
    int j = paramOptions.strings.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramOptions.strings[i]))
      {
        this.peeked = 0;
        this.pathNames[(this.stackSize - 1)] = paramString;
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int findString(String paramString, JsonReader.Options paramOptions)
  {
    int j = paramOptions.strings.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramOptions.strings[i]))
      {
        this.peeked = 0;
        paramString = this.pathIndices;
        j = this.stackSize - 1;
        paramString[j] += 1;
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private boolean isLiteral(int paramInt)
  {
    if ((paramInt != 9) && (paramInt != 10) && (paramInt != 12) && (paramInt != 13) && (paramInt != 32))
    {
      if (paramInt != 35)
      {
        if (paramInt == 44) {
          break label110;
        }
        if ((paramInt != 47) && (paramInt != 61))
        {
          if ((paramInt == 123) || (paramInt == 125) || (paramInt == 58)) {
            break label110;
          }
          if (paramInt == 59) {}
        }
      }
      switch (paramInt)
      {
      default: 
        return true;
      case 92: 
        checkLenient();
      }
    }
    label110:
    return false;
  }
  
  private int nextNonWhitespace(boolean paramBoolean)
  {
    int j;
    for (int i = 0;; i = j)
    {
      localObject = this.source;
      j = i + 1;
      if (!((BufferedSource)localObject).request(j)) {
        break label202;
      }
      i = this.buffer.getByte(i);
      if ((i != 10) && (i != 32) && (i != 13) && (i != 9))
      {
        this.buffer.skip(j - 1);
        if (i == 47)
        {
          if (!this.source.request(2L)) {
            return i;
          }
          checkLenient();
          j = this.buffer.getByte(1L);
          if (j != 42)
          {
            if (j != 47) {
              return i;
            }
            this.buffer.readByte();
            this.buffer.readByte();
            skipToEndOfLine();
            break;
          }
          this.buffer.readByte();
          this.buffer.readByte();
          if (skipToEndOfBlockComment()) {
            break;
          }
          throw syntaxError("Unterminated comment");
        }
        if (i == 35)
        {
          checkLenient();
          skipToEndOfLine();
          break;
        }
        return i;
      }
    }
    label202:
    if (!paramBoolean) {
      return -1;
    }
    Object localObject = new EOFException("End of input");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private String nextQuotedValue(ByteString paramByteString)
  {
    long l;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      l = this.source.indexOfElement(paramByteString);
      if (l == -1L) {
        break label144;
      }
      if (this.buffer.getByte(l) != 92) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(this.buffer.readUtf8(l));
      this.buffer.readByte();
      ((StringBuilder)localObject2).append(readEscapeCharacter());
    }
    if (localObject1 == null)
    {
      paramByteString = this.buffer.readUtf8(l);
      this.buffer.readByte();
      return paramByteString;
    }
    localObject1.append(this.buffer.readUtf8(l));
    this.buffer.readByte();
    return localObject1.toString();
    label144:
    paramByteString = syntaxError("Unterminated string");
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  private String nextUnquotedValue()
  {
    long l = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
    if (l != -1L) {
      return this.buffer.readUtf8(l);
    }
    return this.buffer.readUtf8();
  }
  
  private int peekKeyword()
  {
    int i = this.buffer.getByte(0L);
    String str1;
    String str2;
    if ((i != 116) && (i != 84))
    {
      if ((i != 102) && (i != 70))
      {
        if ((i != 110) && (i != 78)) {
          return 0;
        }
        i = 7;
        str1 = "null";
        str2 = "NULL";
      }
      else
      {
        i = 6;
        str1 = "false";
        str2 = "FALSE";
      }
    }
    else
    {
      i = 5;
      str1 = "true";
      str2 = "TRUE";
    }
    int m = str1.length();
    int k;
    for (int j = 1; j < m; j = k)
    {
      BufferedSource localBufferedSource = this.source;
      k = j + 1;
      if (!localBufferedSource.request(k)) {
        return 0;
      }
      int n = this.buffer.getByte(j);
      if ((n != str1.charAt(j)) && (n != str2.charAt(j))) {
        return 0;
      }
    }
    if ((this.source.request(m + 1)) && (isLiteral(this.buffer.getByte(m)))) {
      return 0;
    }
    this.buffer.skip(m);
    this.peeked = i;
    return i;
  }
  
  private int peekNumber()
  {
    int j = 0;
    long l1 = 0L;
    int m = 0;
    int i = 0;
    int k = 1;
    int n = 0;
    for (;;)
    {
      BufferedSource localBufferedSource = this.source;
      int i1 = m + 1;
      if (localBufferedSource.request(i1))
      {
        int i2 = this.buffer.getByte(m);
        if (i2 == 43) {
          break label435;
        }
        if ((i2 == 69) || (i2 == 101)) {
          break label415;
        }
        if (i2 == 45) {
          break label393;
        }
        if (i2 == 46) {
          break label381;
        }
        if ((i2 >= 48) && (i2 <= 57))
        {
          if ((i != 1) && (i != 0))
          {
            long l2;
            if (i == 2)
            {
              if (l1 == 0L) {
                return j;
              }
              l2 = 10L * l1 - (i2 - 48);
              if ((l1 <= -922337203685477580L) && ((l1 != -922337203685477580L) || (l2 >= l1))) {
                j = 0;
              } else {
                j = 1;
              }
              m = j & k;
            }
            else
            {
              if (i == 3)
              {
                j = 0;
                i = 4;
                break label443;
              }
              if (i == 5) {
                break label237;
              }
              m = k;
              l2 = l1;
              if (i == 6) {
                break label237;
              }
            }
            j = 0;
            k = m;
            l1 = l2;
            break label443;
            label237:
            j = 0;
            i = 7;
            break label443;
          }
          l1 = -(i2 - 48);
          j = 0;
          i = 2;
          break label443;
        }
        if (isLiteral(i2)) {}
      }
      else
      {
        if ((i == 2) && (k != 0) && ((l1 != -9223372036854775808L) || (n != 0)) && ((l1 != 0L) || (n == 0)))
        {
          if (n == 0) {
            l1 = -l1;
          }
          this.peekedLong = l1;
          this.buffer.skip(m);
          this.peeked = 16;
          return 16;
        }
        if ((i != 2) && (i != 4) && (i != 7)) {
          return 0;
        }
        this.peekedNumberLength = m;
        this.peeked = 17;
        return 17;
      }
      return 0;
      label381:
      if (i == 2)
      {
        i = 3;
      }
      else
      {
        return j;
        if (i == 0)
        {
          i = 1;
          n = 1;
        }
        else if (i != 5)
        {
          return j;
          if ((i != 2) && (i != 4)) {
            return j;
          }
          i = 5;
          break label443;
          if (i != 5) {
            break;
          }
        }
        else
        {
          i = 6;
        }
      }
      label393:
      label415:
      label435:
      label443:
      m = i1;
    }
    return j;
  }
  
  private char readEscapeCharacter()
  {
    if (this.source.request(1L))
    {
      int i = this.buffer.readByte();
      if ((i != 10) && (i != 34) && (i != 39) && (i != 47) && (i != 92))
      {
        if (i != 98)
        {
          if (i != 102)
          {
            if (i != 110)
            {
              if (i != 114)
              {
                if (i != 116)
                {
                  if (i != 117)
                  {
                    if (this.lenient) {
                      return (char)i;
                    }
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("Invalid escape sequence: \\");
                    ((StringBuilder)localObject).append((char)i);
                    throw syntaxError(((StringBuilder)localObject).toString());
                  }
                  if (this.source.request(4L))
                  {
                    i = 0;
                    char c = '\000';
                    while (i < 4)
                    {
                      int j = this.buffer.getByte(i);
                      int k = (char)(c << '\004');
                      if ((j >= 48) && (j <= 57))
                      {
                        j -= 48;
                        c = (char)(k + j);
                      }
                      else
                      {
                        if ((j >= 97) && (j <= 102)) {
                          j -= 97;
                        }
                        for (;;)
                        {
                          j += 10;
                          break;
                          if ((j < 65) || (j > 70)) {
                            break label251;
                          }
                          j -= 65;
                        }
                      }
                      i += 1;
                      continue;
                      label251:
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append("\\u");
                      ((StringBuilder)localObject).append(this.buffer.readUtf8(4L));
                      throw syntaxError(((StringBuilder)localObject).toString());
                    }
                    this.buffer.skip(4L);
                    return c;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Unterminated escape sequence at path ");
                  ((StringBuilder)localObject).append(getPath());
                  throw new EOFException(((StringBuilder)localObject).toString());
                }
                return '\t';
              }
              return '\r';
            }
            return '\n';
          }
          return '\f';
        }
        return '\b';
      }
      return (char)i;
    }
    Object localObject = syntaxError("Unterminated escape sequence");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private void skipQuotedValue(ByteString paramByteString)
  {
    long l;
    for (;;)
    {
      l = this.source.indexOfElement(paramByteString);
      if (l == -1L) {
        break label61;
      }
      if (this.buffer.getByte(l) != 92) {
        break;
      }
      this.buffer.skip(l + 1L);
      readEscapeCharacter();
    }
    this.buffer.skip(l + 1L);
    return;
    label61:
    paramByteString = syntaxError("Unterminated string");
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  private boolean skipToEndOfBlockComment()
  {
    long l = this.source.indexOf(CLOSING_BLOCK_COMMENT);
    boolean bool;
    if (l != -1L) {
      bool = true;
    } else {
      bool = false;
    }
    Buffer localBuffer = this.buffer;
    if (bool) {
      l += CLOSING_BLOCK_COMMENT.size();
    } else {
      l = localBuffer.size();
    }
    localBuffer.skip(l);
    return bool;
  }
  
  private void skipToEndOfLine()
  {
    long l = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
    Buffer localBuffer = this.buffer;
    if (l != -1L) {
      l += 1L;
    } else {
      l = localBuffer.size();
    }
    localBuffer.skip(l);
  }
  
  private void skipUnquotedValue()
  {
    long l = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
    Buffer localBuffer = this.buffer;
    if (l == -1L) {
      l = localBuffer.size();
    }
    localBuffer.skip(l);
  }
  
  public void beginArray()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 3)
    {
      pushScope(1);
      this.pathIndices[(this.stackSize - 1)] = 0;
      this.peeked = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(peek());
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new JsonDataException(localStringBuilder.toString());
  }
  
  public void beginObject()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 1)
    {
      pushScope(3);
      this.peeked = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(peek());
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new JsonDataException(localStringBuilder.toString());
  }
  
  public void close()
  {
    this.peeked = 0;
    this.scopes[0] = 8;
    this.stackSize = 1;
    this.buffer.clear();
    this.source.close();
  }
  
  public void endArray()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 4)
    {
      this.stackSize -= 1;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      this.peeked = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public void endObject()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 2)
    {
      this.stackSize -= 1;
      this.pathNames[this.stackSize] = null;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      this.peeked = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public boolean hasNext()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    return (i != 2) && (i != 4) && (i != 18);
  }
  
  public boolean nextBoolean()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 5)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return true;
    }
    if (i == 6)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a boolean but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public double nextDouble()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 16)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return this.peekedLong;
    }
    if (i == 17) {
      this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
    } else if (i == 9) {
      this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
    } else if (i == 8) {
      this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
    } else if (i == 10) {
      this.peekedString = nextUnquotedValue();
    } else {
      if (i != 11) {
        break label337;
      }
    }
    this.peeked = 11;
    try
    {
      double d = Double.parseDouble(this.peekedString);
      if ((!this.lenient) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
        ((StringBuilder)localObject).append(d);
        ((StringBuilder)localObject).append(" at path ");
        ((StringBuilder)localObject).append(getPath());
        throw new JsonEncodingException(((StringBuilder)localObject).toString());
      }
      this.peekedString = null;
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label277:
      break label277;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a double but was ");
    ((StringBuilder)localObject).append(this.peekedString);
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
    label337:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a double but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public int nextInt()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 16)
    {
      long l = this.peekedLong;
      i = (int)l;
      if (l == i)
      {
        this.peeked = 0;
        localObject = this.pathIndices;
        j = this.stackSize - 1;
        localObject[j] += 1;
        return i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.peekedLong);
      ((StringBuilder)localObject).append(" at path ");
      ((StringBuilder)localObject).append(getPath());
      throw new JsonDataException(((StringBuilder)localObject).toString());
    }
    if (i == 17)
    {
      this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
    }
    else if ((i != 9) && (i != 8))
    {
      if (i != 11)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected an int but was ");
        ((StringBuilder)localObject).append(peek());
        ((StringBuilder)localObject).append(" at path ");
        ((StringBuilder)localObject).append(getPath());
        throw new JsonDataException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (i == 9) {
        localObject = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
      } else {
        localObject = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
      }
      this.peekedString = ((String)localObject);
    }
    try
    {
      i = Integer.parseInt(this.peekedString);
      this.peeked = 0;
      localObject = this.pathIndices;
      j = this.stackSize - 1;
      localObject[j] += 1;
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label319:
      break label319;
    }
    this.peeked = 11;
    try
    {
      double d = Double.parseDouble(this.peekedString);
      i = (int)d;
      if (i == d)
      {
        this.peekedString = null;
        this.peeked = 0;
        localObject = this.pathIndices;
        j = this.stackSize - 1;
        localObject[j] += 1;
        return i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.peekedString);
      ((StringBuilder)localObject).append(" at path ");
      ((StringBuilder)localObject).append(getPath());
      throw new JsonDataException(((StringBuilder)localObject).toString());
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label441:
      break label441;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected an int but was ");
    ((StringBuilder)localObject).append(this.peekedString);
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public String nextName()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 14)
    {
      localObject = nextUnquotedValue();
    }
    else if (i == 13)
    {
      localObject = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
    }
    else if (i == 12)
    {
      localObject = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
    }
    else
    {
      if (i != 15) {
        break label94;
      }
      localObject = this.peekedString;
    }
    this.peeked = 0;
    this.pathNames[(this.stackSize - 1)] = localObject;
    return localObject;
    label94:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a name but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public String nextString()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 10)
    {
      localObject = nextUnquotedValue();
    }
    else if (i == 9)
    {
      localObject = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
    }
    else if (i == 8)
    {
      localObject = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
    }
    else if (i == 11)
    {
      localObject = this.peekedString;
      this.peekedString = null;
    }
    else if (i == 16)
    {
      localObject = Long.toString(this.peekedLong);
    }
    else
    {
      if (i != 17) {
        break label149;
      }
      localObject = this.buffer.readUtf8(this.peekedNumberLength);
    }
    this.peeked = 0;
    int[] arrayOfInt = this.pathIndices;
    i = this.stackSize - 1;
    arrayOfInt[i] += 1;
    return localObject;
    label149:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a string but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new JsonDataException(((StringBuilder)localObject).toString());
  }
  
  public JsonReader.Token peek()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    switch (i)
    {
    default: 
      throw new AssertionError();
    case 18: 
      return JsonReader.Token.END_DOCUMENT;
    case 16: 
    case 17: 
      return JsonReader.Token.NUMBER;
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      return JsonReader.Token.NAME;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return JsonReader.Token.STRING;
    case 7: 
      return JsonReader.Token.NULL;
    case 5: 
    case 6: 
      return JsonReader.Token.BOOLEAN;
    case 4: 
      return JsonReader.Token.END_ARRAY;
    case 3: 
      return JsonReader.Token.BEGIN_ARRAY;
    case 2: 
      return JsonReader.Token.END_OBJECT;
    }
    return JsonReader.Token.BEGIN_OBJECT;
  }
  
  public int selectName(JsonReader.Options paramOptions)
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i >= 12)
    {
      if (i > 15) {
        return -1;
      }
      if (i == 15) {
        return findName(this.peekedString, paramOptions);
      }
      i = this.source.select(paramOptions.doubleQuoteSuffix);
      if (i != -1)
      {
        this.peeked = 0;
        this.pathNames[(this.stackSize - 1)] = paramOptions.strings[i];
        return i;
      }
      String str1 = this.pathNames[(this.stackSize - 1)];
      String str2 = nextName();
      i = findName(str2, paramOptions);
      if (i == -1)
      {
        this.peeked = 15;
        this.peekedString = str2;
        this.pathNames[(this.stackSize - 1)] = str1;
      }
      return i;
    }
    return -1;
  }
  
  public void skipName()
  {
    if (!this.failOnUnknown)
    {
      int j = this.peeked;
      int i = j;
      if (j == 0) {
        i = doPeek();
      }
      if (i == 14) {
        skipUnquotedValue();
      } else if (i == 13) {
        skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
      } else if (i == 12) {
        skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
      } else {
        if (i != 15) {
          break label94;
        }
      }
      this.peeked = 0;
      this.pathNames[(this.stackSize - 1)] = "null";
      return;
      label94:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a name but was ");
      localStringBuilder.append(peek());
      localStringBuilder.append(" at path ");
      localStringBuilder.append(getPath());
      throw new JsonDataException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot skip unexpected ");
    localStringBuilder.append(peek());
    localStringBuilder.append(" at ");
    localStringBuilder.append(getPath());
    throw new JsonDataException(localStringBuilder.toString());
  }
  
  public void skipValue()
  {
    if (!this.failOnUnknown)
    {
      int j = 0;
      label396:
      do
      {
        int k = this.peeked;
        i = k;
        if (k == 0) {
          i = doPeek();
        }
        if (i == 3) {
          pushScope(1);
        }
        for (;;)
        {
          i = j + 1;
          break label396;
          if (i != 1) {
            break;
          }
          pushScope(3);
        }
        if (i == 4)
        {
          i = j - 1;
          if (i >= 0)
          {
            this.stackSize -= 1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Expected a value but was ");
            ((StringBuilder)localObject).append(peek());
            ((StringBuilder)localObject).append(" at path ");
            ((StringBuilder)localObject).append(getPath());
            throw new JsonDataException(((StringBuilder)localObject).toString());
          }
        }
        else if (i == 2)
        {
          i = j - 1;
          if (i >= 0)
          {
            this.stackSize -= 1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Expected a value but was ");
            ((StringBuilder)localObject).append(peek());
            ((StringBuilder)localObject).append(" at path ");
            ((StringBuilder)localObject).append(getPath());
            throw new JsonDataException(((StringBuilder)localObject).toString());
          }
        }
        else if ((i != 14) && (i != 10))
        {
          if ((i != 9) && (i != 13))
          {
            if ((i != 8) && (i != 12))
            {
              if (i == 17)
              {
                this.buffer.skip(this.peekedNumberLength);
                i = j;
              }
              else if (i != 18)
              {
                i = j;
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Expected a value but was ");
                ((StringBuilder)localObject).append(peek());
                ((StringBuilder)localObject).append(" at path ");
                ((StringBuilder)localObject).append(getPath());
                throw new JsonDataException(((StringBuilder)localObject).toString());
              }
            }
            else
            {
              skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
              i = j;
            }
          }
          else
          {
            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            i = j;
          }
        }
        else
        {
          skipUnquotedValue();
          i = j;
        }
        this.peeked = 0;
        j = i;
      } while (i != 0);
      localObject = this.pathIndices;
      int i = this.stackSize - 1;
      localObject[i] += 1;
      this.pathNames[(this.stackSize - 1)] = "null";
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot skip unexpected ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(" at ");
    ((StringBuilder)localObject).append(getPath());
    localObject = new JsonDataException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsonReader(");
    localStringBuilder.append(this.source);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.moshi.JsonUtf8Reader
 * JD-Core Version:    0.7.0.1
 */