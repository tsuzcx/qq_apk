import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class nsd
  extends QQUIEventReceiver
{
  public nsd(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.jdField_a_of_type_JavaLangString, paramGetCollectionListEvent.jdField_a_of_type_JavaLangString)) {}
    while ((paramGetCollectionListEvent.b) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onGetShareGroupVideos: 是否来自缓存=" + paramGetCollectionListEvent.b + " groupId=" + paramQQStoryShareGroupProfileActivity.b + ", event=" + paramGetCollectionListEvent.toString());
    }
    QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramGetCollectionListEvent);
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsd
 * JD-Core Version:    0.7.0.1
 */