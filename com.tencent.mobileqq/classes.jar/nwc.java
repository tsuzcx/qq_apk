import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.playmode.child.DiscoverPlayMode.PlayVideoEvent;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.storyHome.discover.view.IDiscoverView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class nwc
  extends UIBaseEventReceiver
{
  public nwc(DiscoverPresenter paramDiscoverPresenter)
  {
    super(paramDiscoverPresenter);
  }
  
  public void a(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPlayMode.PlayVideoEvent paramPlayVideoEvent)
  {
    if (DiscoverPresenter.a.size() == 0) {}
    while ((DiscoverPresenter)((WeakReference)DiscoverPresenter.a.get(DiscoverPresenter.a.size() - 1)).get() != paramDiscoverPresenter) {
      return;
    }
    DiscoverPresenter.a(paramDiscoverPresenter).a(paramPlayVideoEvent);
  }
  
  public Class acceptEventClass()
  {
    return DiscoverPlayMode.PlayVideoEvent.class;
  }
  
  public void b(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPlayMode.PlayVideoEvent paramPlayVideoEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwc
 * JD-Core Version:    0.7.0.1
 */