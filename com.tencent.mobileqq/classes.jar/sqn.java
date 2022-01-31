import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.viola.core.dispatch.ComponentAppearEvent;
import com.tencent.viola.core.dispatch.IEvent;
import com.tencent.viola.core.dispatch.IObserver;

public class sqn
  implements IObserver
{
  public sqn(VTopicVideo paramVTopicVideo) {}
  
  public String getRef()
  {
    return this.a.getRef();
  }
  
  public void onReceive(IEvent paramIEvent)
  {
    if ((paramIEvent.getRef().equals(this.a.getRef())) && (this.a.getVideoLifeCycleChangeListener() != null))
    {
      paramIEvent = (ComponentAppearEvent)paramIEvent;
      if (!paramIEvent.event.equals("didDisappear")) {
        break label59;
      }
      this.a.getVideoLifeCycleChangeListener().O_();
    }
    label59:
    do
    {
      return;
      if (paramIEvent.event.equals("willAppear"))
      {
        this.a.getVideoLifeCycleChangeListener().M_();
        return;
      }
    } while (!paramIEvent.event.equals("didAppear"));
    this.a.getVideoLifeCycleChangeListener().N_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sqn
 * JD-Core Version:    0.7.0.1
 */