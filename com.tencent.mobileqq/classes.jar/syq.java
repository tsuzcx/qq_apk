import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class syq
  extends swk
  implements slx<tae, tbu>
{
  protected String a;
  protected List<String> a;
  
  public syq(String paramString, List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void a()
  {
    tae localtae = new tae();
    localtae.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    slv.a().a(localtae, this);
  }
  
  public void a(@NonNull tae paramtae, @Nullable tbu paramtbu, @NonNull ErrorMessage paramErrorMessage)
  {
    sys localsys = new sys();
    if ((paramtbu == null) || (paramErrorMessage.isFail()))
    {
      c();
      sgi.a().dispatch(localsys);
      return;
    }
    urk.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: request.count=" + paramtae.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramtae.jdField_a_of_type_JavaUtilList.toString());
    urk.b("Q.qqstory.net:VidToShareGroupVideoInfoHandler", "onCmdRespond: count=" + paramtbu.jdField_a_of_type_JavaUtilList.size() + ",content=" + paramtbu.toString());
    b();
    paramtbu.jdField_a_of_type_JavaUtilList = ((sqd)sqg.a(5)).a(paramtbu.jdField_a_of_type_JavaUtilList);
    localsys.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramtae = paramtbu.jdField_a_of_type_JavaUtilList.iterator();
    while (paramtae.hasNext())
    {
      paramtbu = (StoryVideoItem)paramtae.next();
      paramtbu = new uhj(paramtbu.mVid, paramtbu);
      localsys.jdField_a_of_type_JavaUtilList.add(paramtbu);
    }
    sgi.a().dispatch(localsys);
  }
  
  public String toString()
  {
    return "VidToShareGroupVideoInfoHandler{mVidList=" + this.jdField_a_of_type_JavaUtilList + ", mCollectionId='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syq
 * JD-Core Version:    0.7.0.1
 */