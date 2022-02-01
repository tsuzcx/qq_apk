package org.junit.runner;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class Result
  implements Serializable
{
  private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(Result.SerializedForm.class).getFields();
  private static final long serialVersionUID = 1L;
  private final AtomicInteger count;
  private final CopyOnWriteArrayList<Failure> failures;
  private final AtomicInteger ignoreCount;
  private final AtomicLong runTime;
  private Result.SerializedForm serializedForm;
  private final AtomicLong startTime;
  
  public Result()
  {
    this.count = new AtomicInteger();
    this.ignoreCount = new AtomicInteger();
    this.failures = new CopyOnWriteArrayList();
    this.runTime = new AtomicLong();
    this.startTime = new AtomicLong();
  }
  
  private Result(Result.SerializedForm paramSerializedForm)
  {
    this.count = Result.SerializedForm.access$000(paramSerializedForm);
    this.ignoreCount = Result.SerializedForm.access$100(paramSerializedForm);
    this.failures = new CopyOnWriteArrayList(Result.SerializedForm.access$200(paramSerializedForm));
    this.runTime = new AtomicLong(Result.SerializedForm.access$300(paramSerializedForm));
    this.startTime = new AtomicLong(Result.SerializedForm.access$400(paramSerializedForm));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    this.serializedForm = Result.SerializedForm.deserialize(paramObjectInputStream);
  }
  
  private Object readResolve()
  {
    return new Result(this.serializedForm);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    new Result.SerializedForm(this).serialize(paramObjectOutputStream);
  }
  
  public RunListener createListener()
  {
    return new Result.Listener(this, null);
  }
  
  public int getFailureCount()
  {
    return this.failures.size();
  }
  
  public List<Failure> getFailures()
  {
    return this.failures;
  }
  
  public int getIgnoreCount()
  {
    return this.ignoreCount.get();
  }
  
  public int getRunCount()
  {
    return this.count.get();
  }
  
  public long getRunTime()
  {
    return this.runTime.get();
  }
  
  public boolean wasSuccessful()
  {
    return getFailureCount() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.runner.Result
 * JD-Core Version:    0.7.0.1
 */