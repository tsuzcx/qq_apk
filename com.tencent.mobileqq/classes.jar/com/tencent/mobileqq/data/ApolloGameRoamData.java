package com.tencent.mobileqq.data;

import aukm;
import java.io.Serializable;

public class ApolloGameRoamData
  extends aukm
  implements Serializable
{
  public static final int TYPE_RECOMMEND = 1;
  public static final int TYPE_USER_PLAYED = 2;
  public int gameId;
  public long tagBegTs;
  public long tagEndTs;
  public int tagType;
  public String tagUrl;
  public int type = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameRoamData
 * JD-Core Version:    0.7.0.1
 */