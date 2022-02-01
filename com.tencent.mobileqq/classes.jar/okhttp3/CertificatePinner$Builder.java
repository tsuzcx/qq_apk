package okhttp3;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public final class CertificatePinner$Builder
{
  private final List<CertificatePinner.Pin> pins = new ArrayList();
  
  public Builder add(String paramString, String... paramVarArgs)
  {
    if (paramString != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.pins.add(new CertificatePinner.Pin(paramString, str));
        i += 1;
      }
      return this;
    }
    paramString = new NullPointerException("pattern == null");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public CertificatePinner build()
  {
    return new CertificatePinner(new LinkedHashSet(this.pins), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.CertificatePinner.Builder
 * JD-Core Version:    0.7.0.1
 */