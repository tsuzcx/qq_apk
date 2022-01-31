package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.app.SQLiteOpenHelper;

public abstract class EntityManagerFactory
{
  private boolean closed;
  private final SQLiteOpenHelper dbHelper = build(paramString);
  private String mName;
  
  public EntityManagerFactory(String paramString)
  {
    this.mName = paramString;
  }
  
  public abstract SQLiteOpenHelper build(String paramString);
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.a();
  }
  
  public EntityManager createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    OGEntityManager localOGEntityManager = new OGEntityManager(this.dbHelper, this.mName);
    this.closed = false;
    return localOGEntityManager;
  }
  
  public EntityManager createMessageRecordEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    MessageRecordEntityManager localMessageRecordEntityManager = new MessageRecordEntityManager(this.dbHelper, this.mName);
    this.closed = false;
    return localMessageRecordEntityManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */