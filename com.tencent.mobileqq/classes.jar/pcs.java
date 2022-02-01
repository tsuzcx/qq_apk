import androidx.collection.ArraySet;
import com.tencent.image.AbstractGifImage;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import java.util.Iterator;
import java.util.Set;

public class pcs
  implements QQLifecycleBridge
{
  private Set<QQLifecycleBridge> a;
  
  public void a(QQLifecycleBridge paramQQLifecycleBridge)
  {
    if (this.a == null) {
      this.a = new ArraySet();
    }
    this.a.add(paramQQLifecycleBridge);
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((QQLifecycleBridge)localIterator.next()).onDestroy(paramBoolean);
      }
      this.a.clear();
    }
  }
  
  public void onPause()
  {
    
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((QQLifecycleBridge)localIterator.next()).onPause();
      }
    }
  }
  
  public void onResume()
  {
    
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((QQLifecycleBridge)localIterator.next()).onResume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcs
 * JD-Core Version:    0.7.0.1
 */