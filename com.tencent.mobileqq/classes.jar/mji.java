import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.util.concurrent.ConcurrentHashMap;

public class mji
{
  private atmp jdField_a_of_type_Atmp;
  private atmq jdField_a_of_type_Atmq;
  private ConcurrentHashMap<String, atmo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public mji(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Atmq = paramVideoAppInterface.getEntityManagerFactory(paramVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Atmp = this.jdField_a_of_type_Atmq.createEntityManager();
  }
  
  public ExtensionInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    ??? = localObject2;
    if (paramString != null)
    {
      if (!"".equals(paramString)) {
        break label24;
      }
      ??? = localObject2;
    }
    label24:
    do
    {
      do
      {
        return ???;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          localObject2 = (ExtensionInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        }
        ??? = localObject2;
      } while (localObject2 != null);
      localObject2 = (ExtensionInfo)this.jdField_a_of_type_Atmp.a(ExtensionInfo.class, paramString);
      ??? = localObject2;
    } while (localObject2 == null);
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mji
 * JD-Core Version:    0.7.0.1
 */