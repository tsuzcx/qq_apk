package com.tencent.mobileqq.msf.core.net;

import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class MsfHttpRespParse
{
  private final CharArrayBuffer lineBuf;
  protected final LineParser lineParser;
  private final int maxHeaderCount;
  private final int maxLineLen;
  private MsfHttpResp msfHttpResp;
  
  public MsfHttpRespParse(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    this(paramMsfSocketInputBuffer, new BasicLineParser(HttpVersion.HTTP_1_1), -1, -1);
  }
  
  public MsfHttpRespParse(MsfSocketInputBuffer paramMsfSocketInputBuffer, LineParser paramLineParser, int paramInt1, int paramInt2)
  {
    this.msfHttpResp = new MsfHttpResp(paramMsfSocketInputBuffer);
    this.maxHeaderCount = paramInt1;
    this.maxLineLen = paramInt2;
    this.lineParser = BasicLineParser.DEFAULT;
    this.lineBuf = new CharArrayBuffer(128);
  }
  
  public static boolean canResponseHaveBody(MsfHttpResp paramMsfHttpResp)
  {
    int i = paramMsfHttpResp.getStatusLine().getStatusCode();
    return (i >= 200) && (i != 204) && (i != 304) && (i != 205);
  }
  
  public static MsfSocketInputBuffer createSesssionBuffer(Socket paramSocket, int paramInt)
  {
    return new MsfSocketInputBuffer(paramSocket, paramInt, "US-ASCII", -1);
  }
  
  private void parseHead()
  {
    this.lineBuf.clear();
    if (this.msfHttpResp.getSessionBuffer().readLine(this.lineBuf) != -1)
    {
      Object localObject = new ParserCursor(0, this.lineBuf.length());
      localObject = this.lineParser.parseStatusLine(this.lineBuf, (ParserCursor)localObject);
      this.msfHttpResp.setStatusline((StatusLine)localObject);
      return;
    }
    throw new NoHttpResponseException("The target server failed to respond");
  }
  
  public boolean isParseHeadFinished()
  {
    return false;
  }
  
  public MsfHttpResp parse()
  {
    try
    {
      parseHead();
      Header[] arrayOfHeader = parseHeaders(this.maxHeaderCount, this.maxLineLen, this.lineParser);
      this.msfHttpResp.setHeaders(arrayOfHeader);
      return this.msfHttpResp;
    }
    catch (ParseException localParseException)
    {
      throw new ProtocolException(localParseException.getMessage(), localParseException);
    }
  }
  
  protected Header[] parseHeaders(int paramInt1, int paramInt2, LineParser paramLineParser)
  {
    Object localObject2 = paramLineParser;
    if (paramLineParser == null) {
      localObject2 = BasicLineParser.DEFAULT;
    }
    ArrayList localArrayList = new ArrayList();
    paramLineParser = null;
    Object localObject3 = paramLineParser;
    int j;
    Object localObject1;
    for (;;)
    {
      if (paramLineParser == null) {
        paramLineParser = new CharArrayBuffer(64);
      } else {
        paramLineParser.clear();
      }
      int k = this.msfHttpResp.getSessionBuffer().readLine(paramLineParser);
      j = 0;
      int i = 0;
      if ((k == -1) || (paramLineParser.length() < 1)) {
        break label272;
      }
      Object localObject4;
      if (((paramLineParser.charAt(0) == ' ') || (paramLineParser.charAt(0) == '\t')) && (localObject3 != null))
      {
        while (i < paramLineParser.length())
        {
          j = paramLineParser.charAt(i);
          if ((j != 32) && (j != 9)) {
            break;
          }
          i += 1;
        }
        if ((paramInt2 > 0) && (((CharArrayBuffer)localObject3).length() + 1 + paramLineParser.length() - i > paramInt2)) {
          throw new IOException("Maximum line length limit exceeded");
        }
        ((CharArrayBuffer)localObject3).append(' ');
        ((CharArrayBuffer)localObject3).append(paramLineParser, i, paramLineParser.length() - i);
        localObject1 = paramLineParser;
        localObject4 = localObject3;
      }
      else
      {
        localArrayList.add(paramLineParser);
        localObject1 = null;
        localObject4 = paramLineParser;
      }
      paramLineParser = (LineParser)localObject1;
      localObject3 = localObject4;
      if (paramInt1 > 0)
      {
        if (localArrayList.size() >= paramInt1) {
          break;
        }
        paramLineParser = (LineParser)localObject1;
        localObject3 = localObject4;
      }
    }
    throw new IOException("Maximum header count exceeded");
    label272:
    paramLineParser = new Header[localArrayList.size()];
    paramInt1 = j;
    while (paramInt1 < localArrayList.size())
    {
      localObject1 = (CharArrayBuffer)localArrayList.get(paramInt1);
      try
      {
        paramLineParser[paramInt1] = ((LineParser)localObject2).parseHeader((CharArrayBuffer)localObject1);
        paramInt1 += 1;
      }
      catch (ParseException paramLineParser)
      {
        throw new ProtocolException(paramLineParser.getMessage());
      }
    }
    return paramLineParser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.MsfHttpRespParse
 * JD-Core Version:    0.7.0.1
 */