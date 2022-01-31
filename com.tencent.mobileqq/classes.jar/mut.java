import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.ImgStruct;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class mut
  implements Runnable
{
  public mut(PreloadManager paramPreloadManager) {}
  
  PreloadManager.ImgStruct a()
  {
    Object localObject1 = this.a.a;
    int i = 3;
    while (i > 0)
    {
      try
      {
        PreloadManager.ImgStruct localImgStruct;
        do
        {
          Iterator localIterator = PreloadManager.a(this.a).values().iterator();
          Object localObject3;
          while (!((Iterator)localObject3).hasNext())
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject3 = (ArrayList)localIterator.next();
            if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0)) {
              return null;
            }
            localObject3 = ((ArrayList)localObject3).iterator();
          }
          localImgStruct = (PreloadManager.ImgStruct)((Iterator)localObject3).next();
          if (localImgStruct == null) {
            return null;
          }
        } while ((PreloadManager.a(localImgStruct.jdField_a_of_type_JavaLangString) != 0) || (localImgStruct.jdField_a_of_type_Int != i));
        return localImgStruct;
      }
      finally {}
      i -= 1;
    }
    return null;
  }
  
  public void run()
  {
    this.a.b = true;
    for (;;)
    {
      PreloadManager.ImgStruct localImgStruct = a();
      if (localImgStruct == null) {
        break;
      }
      if (NetworkState.getNetworkType() != 1) {
        return;
      }
      this.a.b(localImgStruct.jdField_a_of_type_JavaLangString);
    }
    this.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mut
 * JD-Core Version:    0.7.0.1
 */