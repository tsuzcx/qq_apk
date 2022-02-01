package org.junit.runner;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;

class Result$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final AtomicInteger fCount;
  private final List<Failure> fFailures;
  private final AtomicInteger fIgnoreCount;
  private final long fRunTime;
  private final long fStartTime;
  
  private Result$SerializedForm(ObjectInputStream.GetField paramGetField)
  {
    this.fCount = ((AtomicInteger)paramGetField.get("fCount", null));
    this.fIgnoreCount = ((AtomicInteger)paramGetField.get("fIgnoreCount", null));
    this.fFailures = ((List)paramGetField.get("fFailures", null));
    this.fRunTime = paramGetField.get("fRunTime", 0L);
    this.fStartTime = paramGetField.get("fStartTime", 0L);
  }
  
  public Result$SerializedForm(Result paramResult)
  {
    this.fCount = Result.access$700(paramResult);
    this.fIgnoreCount = Result.access$900(paramResult);
    this.fFailures = Collections.synchronizedList(new ArrayList(Result.access$800(paramResult)));
    this.fRunTime = Result.access$600(paramResult).longValue();
    this.fStartTime = Result.access$500(paramResult).longValue();
  }
  
  public static SerializedForm deserialize(ObjectInputStream paramObjectInputStream)
  {
    return new SerializedForm(paramObjectInputStream.readFields());
  }
  
  public void serialize(ObjectOutputStream paramObjectOutputStream)
  {
    ObjectOutputStream.PutField localPutField = paramObjectOutputStream.putFields();
    localPutField.put("fCount", this.fCount);
    localPutField.put("fIgnoreCount", this.fIgnoreCount);
    localPutField.put("fFailures", this.fFailures);
    localPutField.put("fRunTime", this.fRunTime);
    localPutField.put("fStartTime", this.fStartTime);
    paramObjectOutputStream.writeFields();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.runner.Result.SerializedForm
 * JD-Core Version:    0.7.0.1
 */