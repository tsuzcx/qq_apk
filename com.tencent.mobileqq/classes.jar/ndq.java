import com.tencent.biz.now.NowVideoView;
import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class ndq
  extends AbsThirdDataSourceAdapter
{
  int jdField_a_of_type_Int = 0;
  AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  String jdField_a_of_type_JavaLangString;
  
  public ndq(NowVideoView paramNowVideoView) {}
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_Ndh.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      String str = (String)this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = str;
      if ((this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback != null) && (this.jdField_a_of_type_ComTencentBizNowNowVideoView.d == 0))
      {
        this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback.onPrepared();
        return true;
      }
    }
    return false;
  }
  
  public int getPlayType()
  {
    return 1;
  }
  
  public int getStaus()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    if (this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramString = (String)this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = paramString;
      paramOnPreparedCallback.onPrepared();
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_Ndh.a(this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizNowNowVideoView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ndq
 * JD-Core Version:    0.7.0.1
 */