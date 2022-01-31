package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class ApolloGameModeData
  extends Entity
  implements Serializable
{
  public int mDisableSendMsg;
  @unique
  public int mGameMode;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameModeData
 * JD-Core Version:    0.7.0.1
 */