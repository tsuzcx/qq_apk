package okhttp3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSource;

final class ResponseBody$BomAwareReader
  extends Reader
{
  private final Charset charset;
  private boolean closed;
  @Nullable
  private Reader delegate;
  private final BufferedSource source;
  
  ResponseBody$BomAwareReader(BufferedSource paramBufferedSource, Charset paramCharset)
  {
    this.source = paramBufferedSource;
    this.charset = paramCharset;
  }
  
  public void close()
  {
    this.closed = true;
    Reader localReader = this.delegate;
    if (localReader != null)
    {
      localReader.close();
      return;
    }
    this.source.close();
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.closed)
    {
      Reader localReader = this.delegate;
      Object localObject = localReader;
      if (localReader == null)
      {
        localObject = Util.bomAwareCharset(this.source, this.charset);
        localObject = new InputStreamReader(this.source.inputStream(), (Charset)localObject);
        this.delegate = ((Reader)localObject);
      }
      return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
    }
    throw new IOException("Stream closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.ResponseBody.BomAwareReader
 * JD-Core Version:    0.7.0.1
 */