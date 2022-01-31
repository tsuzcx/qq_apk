import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class sqk
  implements slx<szq, szs>
{
  sqk(sqj paramsqj) {}
  
  public void a(@NonNull szq paramszq, @Nullable szs paramszs, @NonNull ErrorMessage paramErrorMessage)
  {
    paramszq = paramszq.jdField_a_of_type_JavaUtilList.iterator();
    while (paramszq.hasNext())
    {
      localObject = (String)paramszq.next();
      sqj.a(this.a).remove(localObject);
    }
    paramszq = new sql();
    paramszq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramszs == null))
    {
      urk.d("Q.qqstory:TagManager", "request fail for get tag request");
      sgi.a().dispatch(paramszq);
      return;
    }
    paramErrorMessage = paramszq.jdField_a_of_type_JavaUtilMap;
    Object localObject = (sqj)sqg.a(27);
    paramszs = paramszs.jdField_a_of_type_JavaUtilList.iterator();
    while (paramszs.hasNext())
    {
      szr localszr = (szr)paramszs.next();
      ((sqj)localObject).a(localszr.jdField_a_of_type_JavaLangString, localszr.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localszr.jdField_a_of_type_JavaLangString, localszr);
      urk.a("Q.qqstory:TagManager", "save feedId :%s , %s", localszr.jdField_a_of_type_JavaLangString, localszr.jdField_a_of_type_JavaUtilList);
    }
    sgi.a().dispatch(paramszq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqk
 * JD-Core Version:    0.7.0.1
 */