package com.tencent.mobileqq.kandian.repo.atlas;

import java.io.Serializable;

public class AtlasModel
  implements Serializable
{
  public static final int TYPE_IMAGE = 1;
  public static final int TYPE_IMAGE_LIST = 3;
  public static final int TYPE_LOADING_MORE_VIEW = 4;
  public static final int TYPE_LOADING_VIEW = 5;
  public static final int TYPE_RECOMMEND_LIST = 2;
  public static final int TYPE_TOTAL_SIZE = 5;
  public String jumpUrl;
  public int position;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasModel
 * JD-Core Version:    0.7.0.1
 */