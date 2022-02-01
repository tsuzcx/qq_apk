package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/MediaType;", "", "(Ljava/lang/String;I)V", "PHOTO", "VIDEO", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public enum MediaType
{
  static
  {
    MediaType localMediaType1 = new MediaType("PHOTO", 0);
    PHOTO = localMediaType1;
    MediaType localMediaType2 = new MediaType("VIDEO", 1);
    VIDEO = localMediaType2;
    $VALUES = new MediaType[] { localMediaType1, localMediaType2 };
  }
  
  private MediaType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.MediaType
 * JD-Core Version:    0.7.0.1
 */