import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class tdg
  implements syt<tmm, tmo>
{
  tdg(tdf paramtdf) {}
  
  public void a(@NonNull tmm paramtmm, @Nullable tmo paramtmo, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtmm = paramtmm.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmm.hasNext())
    {
      localObject = (String)paramtmm.next();
      tdf.a(this.a).remove(localObject);
    }
    paramtmm = new tdh();
    paramtmm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramtmo == null))
    {
      veg.d("Q.qqstory:TagManager", "request fail for get tag request");
      ste.a().dispatch(paramtmm);
      return;
    }
    paramErrorMessage = paramtmm.jdField_a_of_type_JavaUtilMap;
    Object localObject = (tdf)tdc.a(27);
    paramtmo = paramtmo.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtmo.hasNext())
    {
      tmn localtmn = (tmn)paramtmo.next();
      ((tdf)localObject).a(localtmn.jdField_a_of_type_JavaLangString, localtmn.jdField_a_of_type_JavaUtilList);
      paramErrorMessage.put(localtmn.jdField_a_of_type_JavaLangString, localtmn);
      veg.a("Q.qqstory:TagManager", "save feedId :%s , %s", localtmn.jdField_a_of_type_JavaLangString, localtmn.jdField_a_of_type_JavaUtilList);
    }
    ste.a().dispatch(paramtmm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdg
 * JD-Core Version:    0.7.0.1
 */