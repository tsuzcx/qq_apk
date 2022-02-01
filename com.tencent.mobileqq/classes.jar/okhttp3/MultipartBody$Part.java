package okhttp3;

import javax.annotation.Nullable;

public final class MultipartBody$Part
{
  final RequestBody body;
  @Nullable
  final Headers headers;
  
  private MultipartBody$Part(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
  {
    this.headers = paramHeaders;
    this.body = paramRequestBody;
  }
  
  public static Part create(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
  {
    if (paramRequestBody != null)
    {
      if ((paramHeaders != null) && (paramHeaders.get("Content-Type") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Type");
      }
      if ((paramHeaders != null) && (paramHeaders.get("Content-Length") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Length");
      }
      return new Part(paramHeaders, paramRequestBody);
    }
    throw new NullPointerException("body == null");
  }
  
  public static Part create(RequestBody paramRequestBody)
  {
    return create(null, paramRequestBody);
  }
  
  public static Part createFormData(String paramString1, String paramString2)
  {
    return createFormData(paramString1, null, RequestBody.create(null, paramString2));
  }
  
  public static Part createFormData(String paramString1, @Nullable String paramString2, RequestBody paramRequestBody)
  {
    if (paramString1 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
      MultipartBody.appendQuotedString(localStringBuilder, paramString1);
      if (paramString2 != null)
      {
        localStringBuilder.append("; filename=");
        MultipartBody.appendQuotedString(localStringBuilder, paramString2);
      }
      return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", localStringBuilder.toString()).build(), paramRequestBody);
    }
    throw new NullPointerException("name == null");
  }
  
  public RequestBody body()
  {
    return this.body;
  }
  
  @Nullable
  public Headers headers()
  {
    return this.headers;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.MultipartBody.Part
 * JD-Core Version:    0.7.0.1
 */