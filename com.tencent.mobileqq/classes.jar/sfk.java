import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class sfk
  extends QQUIEventReceiver<sfj, scy>
{
  public sfk(@NonNull sfj paramsfj)
  {
    super(paramsfj);
  }
  
  public void a(@NonNull sfj paramsfj, @NonNull scy paramscy)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramscy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      urk.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramscy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramsfj.d();
      bool1 = bool2;
    }
    for (;;)
    {
      sfj.a(paramsfj).a(bool1);
      return;
      urk.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramscy.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramsfj.a(paramscy.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramscy.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return scy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfk
 * JD-Core Version:    0.7.0.1
 */