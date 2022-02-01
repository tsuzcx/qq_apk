package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.Map;

public class HttpDataSource
  implements IDataSource
{
  private final Map<String, String> headers;
  private IMediaHTTPConnection mediaHTTPConnection;
  private final IMediaHTTPService service;
  private final Uri uri;
  
  public HttpDataSource(Uri paramUri, Map<String, String> paramMap, IMediaHTTPService paramIMediaHTTPService)
  {
    this.uri = paramUri;
    this.headers = paramMap;
    this.service = paramIMediaHTTPService;
  }
  
  public void close()
  {
    IMediaHTTPConnection localIMediaHTTPConnection = this.mediaHTTPConnection;
    if (localIMediaHTTPConnection != null) {
      localIMediaHTTPConnection.disconnect();
    }
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return FormatDetector.getAudioFormat(this, false);
  }
  
  public long getSize()
  {
    return this.mediaHTTPConnection.getSize();
  }
  
  public void open()
  {
    this.mediaHTTPConnection = this.service.makeHTTPConnection();
    this.mediaHTTPConnection.connect(new URL(this.uri.toString()), this.headers);
  }
  
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j;
    do
    {
      j = paramInt1 + i;
      j = this.mediaHTTPConnection.readAt(i + paramLong, paramArrayOfByte, j, paramInt2 - j);
      if (j < 0) {
        return j;
      }
      if (j == 0) {
        return i;
      }
      j = i + j;
      i = j;
    } while (j < paramInt2);
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */