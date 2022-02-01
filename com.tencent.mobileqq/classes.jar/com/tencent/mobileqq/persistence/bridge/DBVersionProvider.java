package com.tencent.mobileqq.persistence.bridge;

import com.tencent.mobileqq.data.entitymanager.Provider;

public class DBVersionProvider
  implements Provider<Integer>
{
  private static final int DB_VERSION = 348;
  
  public Integer get()
  {
    return Integer.valueOf(348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.DBVersionProvider
 * JD-Core Version:    0.7.0.1
 */