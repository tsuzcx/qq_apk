import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class ssg
  extends QQUIEventReceiver<ssf, spu>
{
  public ssg(@NonNull ssf paramssf)
  {
    super(paramssf);
  }
  
  public void a(@NonNull ssf paramssf, @NonNull spu paramspu)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramspu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      veg.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,error! code = %d", Integer.valueOf(paramspu.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode));
      paramssf.d();
      bool1 = bool2;
    }
    for (;;)
    {
      ssf.a(paramssf).a(bool1);
      return;
      veg.a("Q.qqstory.recommendAlbum.ui.AlbumVideoGalleryAdapter", "on receiver scan data ,size = %d", Integer.valueOf(paramspu.jdField_a_of_type_JavaUtilList.size()));
      bool1 = bool2;
      if (paramssf.a(paramspu.jdField_a_of_type_JavaUtilList))
      {
        bool1 = bool2;
        if (paramspu.jdField_a_of_type_JavaUtilList.size() > 0) {
          bool1 = true;
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return spu.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssg
 * JD-Core Version:    0.7.0.1
 */