package com.tencent.mobileqq.tribe;

import java.io.Serializable;

public class TribeVideoPublishParams
  implements Serializable
{
  public static final String BUNDLE_EXTRA_KEY = TribeVideoPublishParams.class.getName();
  public int beauty;
  public TribeVideoPublishParams.ChangeFace changeFace;
  public TribeVideoPublishParams.Filter filter;
  public boolean hasFace;
  public boolean hasGraffiti;
  public boolean hasPoi;
  public boolean hasText;
  public boolean isSoundOn;
  public TribeVideoPublishParams.Music music;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.TribeVideoPublishParams
 * JD-Core Version:    0.7.0.1
 */