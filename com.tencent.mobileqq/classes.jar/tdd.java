import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class tdd
  implements syq<tmj, tml>
{
  tdd(tdc paramtdc) {}
  
  public void a(@NonNull tmj paramtmj, @Nullable tml paramtml, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtmj = paramtmj.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmj.hasNext())
    {
      localObject = (String)paramtmj.next();
      tdc.a(this.a).remove(localObject);
    }
    paramtmj = new tde();
    paramtmj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtml == null))
    {
      ved.d("Q.qqstory:TagManager", "request fail for get tag request");
      stb.a().dispatch(paramtmj);
      return;
    }
    paramErrorMessage = paramtmj.jdField_a_of_type_JavaUtilMap;
    Object localObject = (tdc)tcz.a(27);
    paramtml = paramtml.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtml.hasNext())
    {
      tmk localtmk = (tmk)paramtml.next();
      ((tdc)localObject).a(localtmk.jdField_a_of_type_JavaLangString, localtmk.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localtmk.jdField_a_of_type_JavaLangString, localtmk);
      ved.a("Q.qqstory:TagManager", "save feedId :%s , %s", localtmk.jdField_a_of_type_JavaLangString, localtmk.jdField_a_of_type_JavaUtilList);
    }
    stb.a().dispatch(paramtmj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdd
 * JD-Core Version:    0.7.0.1
 */