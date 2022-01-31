import android.os.Handler;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher;
import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Response;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.AddressHelper.AddressCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;

public class nzf
  implements AddressHelper.AddressCallBack
{
  public nzf(LocalVideoPusher paramLocalVideoPusher, ArrayList paramArrayList, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage = new LocalVideoPusher.Response();
    paramErrorMessage.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    paramErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.b.obtainMessage(2, paramErrorMessage);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.b.sendMessage(paramErrorMessage);
  }
  
  public void a(GetLocationResponse paramGetLocationResponse)
  {
    LocalVideoPusher.Response localResponse = new LocalVideoPusher.Response();
    localResponse.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    localResponse.b = (paramGetLocationResponse.d + paramGetLocationResponse.e);
    localResponse.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.addedDate);
    paramGetLocationResponse = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.b.obtainMessage(2, localResponse);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistLocalVideoPusher.b.sendMessage(paramGetLocationResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzf
 * JD-Core Version:    0.7.0.1
 */