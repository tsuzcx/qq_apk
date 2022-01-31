import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class syr
  extends swk
  implements slx<taf, tbv>
{
  protected String a;
  protected List<String> a;
  
  public syr(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    taf localtaf = new taf();
    localtaf.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    slv.a().a(localtaf, this);
  }
  
  public void a(@NonNull taf paramtaf, @Nullable tbv paramtbv, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtaf = new sys();
    if ((paramtbv == null) || (paramErrorMessage.isFail()))
    {
      c();
      sgi.a().dispatch(paramtaf);
      return;
    }
    b();
    paramtbv.jdField_a_of_type_JavaUtilList = ((sqd)sqg.a(5)).a(paramtbv.jdField_a_of_type_JavaUtilList);
    paramtaf.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtbv = paramtbv.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtbv.hasNext())
    {
      paramErrorMessage = (StoryVideoItem)paramtbv.next();
      paramErrorMessage = new uhj(paramErrorMessage.mVid, paramErrorMessage);
      paramtaf.jdField_a_of_type_JavaUtilList.add(paramErrorMessage);
    }
    sgi.a().dispatch(paramtaf);
  }
  
  public String toString()
  {
    return "VidToSimpleInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syr
 * JD-Core Version:    0.7.0.1
 */