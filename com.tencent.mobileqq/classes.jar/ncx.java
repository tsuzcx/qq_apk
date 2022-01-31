import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import java.util.Iterator;
import java.util.List;

public class ncx
  implements Runnable
{
  public ncx(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager) {}
  
  public void run()
  {
    ??? = PublicAccountImageCollectionPreloadManager.a(this.a).iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      PublicAccountImageCollectionPreloadManager.a(this.a, str);
    }
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      PublicAccountImageCollectionPreloadManager.a(this.a).clear();
      if (PublicAccountImageCollectionPreloadManager.b(this.a).size() > 0)
      {
        PublicAccountImageCollectionPreloadManager.a(this.a);
        return;
      }
      this.a.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncx
 * JD-Core Version:    0.7.0.1
 */