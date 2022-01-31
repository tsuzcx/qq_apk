import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class szx
  extends QQUIEventReceiver<szs, tkh>
{
  public szx(@NonNull szs paramszs)
  {
    super(paramszs);
  }
  
  public void a(@NonNull szs paramszs, @NonNull tkh paramtkh)
  {
    if (paramtkh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramszs.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramtkh.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramtkh.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramszs.f();
    ved.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return tkh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szx
 * JD-Core Version:    0.7.0.1
 */