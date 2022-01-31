import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import java.util.ArrayList;

public abstract interface tfi<T extends WSSimpleBaseEvent>
{
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
  
  public abstract ArrayList<Class<T>> getEventClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfi
 * JD-Core Version:    0.7.0.1
 */