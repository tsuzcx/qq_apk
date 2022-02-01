package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okio.ByteString;

public final class MultipartBody$Builder
{
  private final ByteString boundary;
  private final List<MultipartBody.Part> parts = new ArrayList();
  private MediaType type = MultipartBody.MIXED;
  
  public MultipartBody$Builder()
  {
    this(UUID.randomUUID().toString());
  }
  
  public MultipartBody$Builder(String paramString)
  {
    this.boundary = ByteString.encodeUtf8(paramString);
  }
  
  public Builder addFormDataPart(String paramString1, String paramString2)
  {
    return addPart(MultipartBody.Part.createFormData(paramString1, paramString2));
  }
  
  public Builder addFormDataPart(String paramString1, @Nullable String paramString2, RequestBody paramRequestBody)
  {
    return addPart(MultipartBody.Part.createFormData(paramString1, paramString2, paramRequestBody));
  }
  
  public Builder addPart(@Nullable Headers paramHeaders, RequestBody paramRequestBody)
  {
    return addPart(MultipartBody.Part.create(paramHeaders, paramRequestBody));
  }
  
  public Builder addPart(MultipartBody.Part paramPart)
  {
    if (paramPart == null) {
      throw new NullPointerException("part == null");
    }
    this.parts.add(paramPart);
    return this;
  }
  
  public Builder addPart(RequestBody paramRequestBody)
  {
    return addPart(MultipartBody.Part.create(paramRequestBody));
  }
  
  public MultipartBody build()
  {
    if (this.parts.isEmpty()) {
      throw new IllegalStateException("Multipart body must have at least one part.");
    }
    return new MultipartBody(this.boundary, this.type, this.parts);
  }
  
  public Builder setType(MediaType paramMediaType)
  {
    if (paramMediaType == null) {
      throw new NullPointerException("type == null");
    }
    if (!paramMediaType.type().equals("multipart")) {
      throw new IllegalArgumentException("multipart != " + paramMediaType);
    }
    this.type = paramMediaType;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.MultipartBody.Builder
 * JD-Core Version:    0.7.0.1
 */