import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.UIBaseEventReceiver;
import com.tencent.biz.qqstory.storyHome.discover.model.DiscoverPagerLoader.GetDiscoverCardsEvent;
import com.tencent.biz.qqstory.storyHome.discover.view.DiscoverPresenter;
import com.tencent.biz.qqstory.storyHome.discover.view.IDiscoverView;

public class oaq
  extends UIBaseEventReceiver
{
  public oaq(DiscoverPresenter paramDiscoverPresenter)
  {
    super(paramDiscoverPresenter);
  }
  
  public void a(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPagerLoader.GetDiscoverCardsEvent paramGetDiscoverCardsEvent)
  {
    if ((paramGetDiscoverCardsEvent.jdField_a_of_type_Int == DiscoverPresenter.a(paramDiscoverPresenter)) && (paramGetDiscoverCardsEvent.jdField_a_of_type_Long == DiscoverPresenter.a(paramDiscoverPresenter))) {
      DiscoverPresenter.a(paramDiscoverPresenter).a(DiscoverPresenter.a(paramDiscoverPresenter, paramGetDiscoverCardsEvent.jdField_a_of_type_JavaUtilList, paramGetDiscoverCardsEvent.c), paramGetDiscoverCardsEvent);
    }
  }
  
  public Class acceptEventClass()
  {
    return DiscoverPagerLoader.GetDiscoverCardsEvent.class;
  }
  
  public void b(@NonNull DiscoverPresenter paramDiscoverPresenter, @NonNull DiscoverPagerLoader.GetDiscoverCardsEvent paramGetDiscoverCardsEvent)
  {
    if ((paramGetDiscoverCardsEvent.jdField_a_of_type_Int == DiscoverPresenter.a(paramDiscoverPresenter)) && (paramGetDiscoverCardsEvent.jdField_a_of_type_Long == DiscoverPresenter.a(paramDiscoverPresenter))) {
      DiscoverPresenter.a(paramDiscoverPresenter).a(null, paramGetDiscoverCardsEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oaq
 * JD-Core Version:    0.7.0.1
 */