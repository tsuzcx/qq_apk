package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class Sqlite
  extends Entity
{
  public String tbl_name;
  
  public String getTableName()
  {
    return "Sqlite_master";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.Sqlite
 * JD-Core Version:    0.7.0.1
 */