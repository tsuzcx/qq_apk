import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ssd
  extends QQUIEventReceiver<ssc, spr>
{
  public ssd(@NonNull ssc paramssc)
  {
    super(paramssc);
  }
  
  public void a(@NonNull ssc paramssc, @NonNull spr paramspr)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramspr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      ved.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramspr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramssc.d();
      bool1 = bool2;
    }
    for (;;)
    {
      ssc.a(paramssc).a(bool1);
      return;
      ved.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramspr.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramssc.a(paramspr.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramspr.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return spr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssd
 * JD-Core Version:    0.7.0.1
 */