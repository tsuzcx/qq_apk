package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class FormBody$Builder
{
  private final Charset charset;
  private final List<String> names = new ArrayList();
  private final List<String> values = new ArrayList();
  
  public FormBody$Builder()
  {
    this(null);
  }
  
  public FormBody$Builder(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public Builder add(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
        this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
        return this;
      }
      throw new NullPointerException("value == null");
    }
    throw new NullPointerException("name == null");
  }
  
  public Builder addEncoded(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        this.names.add(HttpUrl.canonicalize(paramString1, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
        this.values.add(HttpUrl.canonicalize(paramString2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
        return this;
      }
      throw new NullPointerException("value == null");
    }
    throw new NullPointerException("name == null");
  }
  
  public FormBody build()
  {
    return new FormBody(this.names, this.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.FormBody.Builder
 * JD-Core Version:    0.7.0.1
 */