package okhttp3;

import javax.annotation.Nullable;

public final class ConnectionSpec$Builder
{
  @Nullable
  String[] cipherSuites;
  boolean supportsTlsExtensions;
  boolean tls;
  @Nullable
  String[] tlsVersions;
  
  public ConnectionSpec$Builder(ConnectionSpec paramConnectionSpec)
  {
    this.tls = paramConnectionSpec.tls;
    this.cipherSuites = paramConnectionSpec.cipherSuites;
    this.tlsVersions = paramConnectionSpec.tlsVersions;
    this.supportsTlsExtensions = paramConnectionSpec.supportsTlsExtensions;
  }
  
  ConnectionSpec$Builder(boolean paramBoolean)
  {
    this.tls = paramBoolean;
  }
  
  public Builder allEnabledCipherSuites()
  {
    if (this.tls)
    {
      this.cipherSuites = null;
      return this;
    }
    throw new IllegalStateException("no cipher suites for cleartext connections");
  }
  
  public Builder allEnabledTlsVersions()
  {
    if (this.tls)
    {
      this.tlsVersions = null;
      return this;
    }
    throw new IllegalStateException("no TLS versions for cleartext connections");
  }
  
  public ConnectionSpec build()
  {
    return new ConnectionSpec(this);
  }
  
  public Builder cipherSuites(String... paramVarArgs)
  {
    if (this.tls)
    {
      if (paramVarArgs.length != 0)
      {
        this.cipherSuites = ((String[])paramVarArgs.clone());
        return this;
      }
      throw new IllegalArgumentException("At least one cipher suite is required");
    }
    throw new IllegalStateException("no cipher suites for cleartext connections");
  }
  
  public Builder cipherSuites(CipherSuite... paramVarArgs)
  {
    if (this.tls)
    {
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].javaName;
        i += 1;
      }
      return cipherSuites(arrayOfString);
    }
    paramVarArgs = new IllegalStateException("no cipher suites for cleartext connections");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public Builder supportsTlsExtensions(boolean paramBoolean)
  {
    if (this.tls)
    {
      this.supportsTlsExtensions = paramBoolean;
      return this;
    }
    throw new IllegalStateException("no TLS extensions for cleartext connections");
  }
  
  public Builder tlsVersions(String... paramVarArgs)
  {
    if (this.tls)
    {
      if (paramVarArgs.length != 0)
      {
        this.tlsVersions = ((String[])paramVarArgs.clone());
        return this;
      }
      throw new IllegalArgumentException("At least one TLS version is required");
    }
    throw new IllegalStateException("no TLS versions for cleartext connections");
  }
  
  public Builder tlsVersions(TlsVersion... paramVarArgs)
  {
    if (this.tls)
    {
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].javaName;
        i += 1;
      }
      return tlsVersions(arrayOfString);
    }
    paramVarArgs = new IllegalStateException("no TLS versions for cleartext connections");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.ConnectionSpec.Builder
 * JD-Core Version:    0.7.0.1
 */