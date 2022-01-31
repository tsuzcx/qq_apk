import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sne
  extends QQUIEventReceiver<smz, sxo>
{
  public sne(@NonNull smz paramsmz)
  {
    super(paramsmz);
  }
  
  public void a(@NonNull smz paramsmz, @NonNull sxo paramsxo)
  {
    if (paramsxo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail()) {}
    CommentEntry localCommentEntry;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramsmz.a.iterator();
      }
      localCommentEntry = (CommentEntry)localIterator.next();
    } while ((paramsxo.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.authorUnionId) == null) && (paramsxo.jdField_a_of_type_JavaUtilHashMap.get(localCommentEntry.replierUnionId) == null));
    paramsmz.f();
    urk.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
  }
  
  public Class acceptEventClass()
  {
    return sxo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sne
 * JD-Core Version:    0.7.0.1
 */