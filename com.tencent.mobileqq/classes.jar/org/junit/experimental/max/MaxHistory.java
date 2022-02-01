package org.junit.experimental.max;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class MaxHistory
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Map<String, Long> fDurations = new HashMap();
  private final Map<String, Long> fFailureTimestamps = new HashMap();
  private final File fHistoryStore;
  
  private MaxHistory(File paramFile)
  {
    this.fHistoryStore = paramFile;
  }
  
  public static MaxHistory forFolder(File paramFile)
  {
    if (paramFile.exists()) {
      try
      {
        MaxHistory localMaxHistory = readHistory(paramFile);
        return localMaxHistory;
      }
      catch (CouldNotReadCoreException localCouldNotReadCoreException)
      {
        localCouldNotReadCoreException.printStackTrace();
        paramFile.delete();
      }
    }
    return new MaxHistory(paramFile);
  }
  
  /* Error */
  private static MaxHistory readHistory(File paramFile)
  {
    // Byte code:
    //   0: new 61	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 62	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_0
    //   9: new 64	java/io/ObjectInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 67	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 71	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: checkcast 2	org/junit/experimental/max/MaxHistory
    //   25: astore_2
    //   26: aload_1
    //   27: invokevirtual 74	java/io/ObjectInputStream:close	()V
    //   30: aload_0
    //   31: invokevirtual 75	java/io/FileInputStream:close	()V
    //   34: aload_2
    //   35: areturn
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 74	java/io/ObjectInputStream:close	()V
    //   41: aload_2
    //   42: athrow
    //   43: astore_1
    //   44: aload_0
    //   45: invokevirtual 75	java/io/FileInputStream:close	()V
    //   48: aload_1
    //   49: athrow
    //   50: astore_0
    //   51: new 40	org/junit/experimental/max/CouldNotReadCoreException
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 78	org/junit/experimental/max/CouldNotReadCoreException:<init>	(Ljava/lang/Throwable;)V
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramFile	File
    //   17	21	1	localObjectInputStream	java.io.ObjectInputStream
    //   43	6	1	localObject1	Object
    //   25	10	2	localMaxHistory	MaxHistory
    //   36	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	26	36	finally
    //   9	18	43	finally
    //   26	30	43	finally
    //   37	43	43	finally
    //   0	9	50	java/lang/Exception
    //   30	34	50	java/lang/Exception
    //   44	50	50	java/lang/Exception
  }
  
  private void save()
  {
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
    localObjectOutputStream.writeObject(this);
    localObjectOutputStream.close();
  }
  
  Long getFailureTimestamp(Description paramDescription)
  {
    return (Long)this.fFailureTimestamps.get(paramDescription.toString());
  }
  
  Long getTestDuration(Description paramDescription)
  {
    return (Long)this.fDurations.get(paramDescription.toString());
  }
  
  boolean isNewTest(Description paramDescription)
  {
    return this.fDurations.containsKey(paramDescription.toString()) ^ true;
  }
  
  public RunListener listener()
  {
    return new MaxHistory.RememberingListener(this, null);
  }
  
  void putTestDuration(Description paramDescription, long paramLong)
  {
    this.fDurations.put(paramDescription.toString(), Long.valueOf(paramLong));
  }
  
  void putTestFailureTimestamp(Description paramDescription, long paramLong)
  {
    this.fFailureTimestamps.put(paramDescription.toString(), Long.valueOf(paramLong));
  }
  
  public Comparator<Description> testComparator()
  {
    return new MaxHistory.TestComparator(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.max.MaxHistory
 * JD-Core Version:    0.7.0.1
 */