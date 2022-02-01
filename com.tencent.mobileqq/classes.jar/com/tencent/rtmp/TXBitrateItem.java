package com.tencent.rtmp;

public class TXBitrateItem
  implements Comparable<TXBitrateItem>
{
  public int bitrate;
  public int height;
  public int index;
  public int width;
  
  public int compareTo(TXBitrateItem paramTXBitrateItem)
  {
    return this.bitrate - paramTXBitrateItem.bitrate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXBitrateItem
 * JD-Core Version:    0.7.0.1
 */