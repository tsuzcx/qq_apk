package com.tencent.sonic.sdk;

import android.text.TextUtils;

class SonicChunkDataHelper$ChunkData
{
  String chunkKey;
  String chunkSha1;
  String eTag;
  String sessionId;
  
  public void reset()
  {
    this.sessionId = "";
    this.eTag = "";
    this.chunkKey = "";
    this.chunkSha1 = "";
  }
  
  public String toHeader()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this.chunkKey).append("=");
    String str2 = this.chunkSha1;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.length() > 12) {
        str1 = str2.substring(0, 12);
      }
    }
    localStringBuilder.append(str1);
    SonicUtils.log("SonicSdk_SonicChunkDataHelper", 4, String.format("Session (%s) send sonic chunk toHeader, key=(%s), X-sonic-chunk=(%s)", new Object[] { this.sessionId, this.chunkKey, str1 }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicChunkDataHelper.ChunkData
 * JD-Core Version:    0.7.0.1
 */