import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tgn
  extends QQUIEventReceiver<tgm, tgh>
{
  public tgn(@NonNull tgm paramtgm)
  {
    super(paramtgm);
  }
  
  public void a(@NonNull tgm paramtgm, @NonNull tgh paramtgh)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramtgh.jdField_a_of_type_JavaLangString)) {}
    switch (paramtgh.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    urk.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramtgh.b);
    tgm.a(paramtgm, false);
    paramtgm.a(paramtgm.jdField_a_of_type_AndroidOsBundle, paramtgm.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtgm.jdField_a_of_type_JavaLangString, paramtgh.b);
  }
  
  public Class acceptEventClass()
  {
    return tgh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgn
 * JD-Core Version:    0.7.0.1
 */