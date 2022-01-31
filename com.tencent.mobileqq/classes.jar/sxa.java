import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sxa
  extends swk
  implements slx<tac, tbs>
{
  protected String a;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private sxc jdField_a_of_type_Sxc;
  
  public sxa(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public sxa(List<String> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    tac localtac = new tac();
    localtac.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    slv.a().a(localtac, this);
  }
  
  public void a(@NonNull tac paramtac, @Nullable tbs paramtbs, @NonNull ErrorMessage paramErrorMessage)
  {
    paramtac = new sxb();
    paramtac.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramtac.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if ((paramErrorMessage.isSuccess()) && (paramtbs != null))
    {
      paramErrorMessage = new ArrayList();
      uac localuac = (uac)sqg.a(7);
      if ((paramtbs.jdField_a_of_type_JavaUtilList != null) && (!paramtbs.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramtbs = paramtbs.jdField_a_of_type_JavaUtilList.iterator();
        while (paramtbs.hasNext()) {
          paramErrorMessage.add(localuac.a((ShareGroupItem)paramtbs.next()));
        }
      }
      if (!paramErrorMessage.isEmpty()) {
        paramtac.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = ((ShareGroupItem)paramErrorMessage.get(0));
      }
      paramtac.jdField_a_of_type_JavaUtilList = paramErrorMessage;
      b();
    }
    for (;;)
    {
      sgi.a().dispatch(paramtac);
      paramtbs = this.jdField_a_of_type_Sxc;
      if (paramtbs != null) {
        paramtbs.a(paramtac);
      }
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxa
 * JD-Core Version:    0.7.0.1
 */