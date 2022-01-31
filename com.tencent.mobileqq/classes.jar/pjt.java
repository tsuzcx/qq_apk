import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.HashMap;

public final class pjt
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public pjt(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Int = i;
  }
  
  public PriorityThreadPool a(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString + "-" + paramString;
    ??? = (PriorityThreadPool)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    if (??? != null) {
      return ???;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      PriorityThreadPool localPriorityThreadPool = (PriorityThreadPool)this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localPriorityThreadPool != null) {
        return localPriorityThreadPool;
      }
    }
    if ((paramString != null) && (paramString.equals(DownloadPreprocessStrategy.DownloadPool.HTTP2.getName()))) {}
    for (paramString = new PriorityThreadPool(str, Config.f());; paramString = new PriorityThreadPool(str, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(str, paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjt
 * JD-Core Version:    0.7.0.1
 */