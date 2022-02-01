import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class ruk
{
  private static final String jdField_a_of_type_JavaLangString = ruk.class.getSimpleName();
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SparseIntArray jdField_b_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private String jdField_b_of_type_JavaLangString;
  
  public ruk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = ozs.a();
  }
  
  public void a()
  {
    ThreadManagerV2.executeOnSubThread(new VideoFeedsShuntBarConfigure.1(this));
  }
  
  public boolean a(VideoInfo.ECommerceEntranceInfo paramECommerceEntranceInfo)
  {
    if (paramECommerceEntranceInfo == null) {
      return false;
    }
    try
    {
      boolean bool = bnrf.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!bool) {
        bnrf.a(this.jdField_b_of_type_JavaLangString + paramECommerceEntranceInfo.g, Integer.valueOf(0));
      }
      if (bool) {}
      for (int i = ((Integer)bnrf.a(this.jdField_b_of_type_JavaLangString + paramECommerceEntranceInfo.g, Integer.valueOf(0))).intValue();; i = 0)
      {
        int k = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramECommerceEntranceInfo.g);
        int j = this.jdField_b_of_type_AndroidUtilSparseIntArray.get(paramECommerceEntranceInfo.g);
        if ((i + j >= paramECommerceEntranceInfo.f) || (k >= paramECommerceEntranceInfo.e)) {
          break;
        }
        k += 1;
        j += 1;
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramECommerceEntranceInfo.g, k);
        this.jdField_b_of_type_AndroidUtilSparseIntArray.put(paramECommerceEntranceInfo.g, j);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "video_source_id: " + paramECommerceEntranceInfo.g + ", one_day_display_counts: " + paramECommerceEntranceInfo.f + ", session_display_counts: " + paramECommerceEntranceInfo.e + ", session_has_display_counts: " + k + ", one_day_has_display_counts: " + (i + j));
        }
        return true;
      }
      return false;
    }
    catch (Exception paramECommerceEntranceInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "解析引流条出现的条件出错: " + paramECommerceEntranceInfo.getMessage());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ruk
 * JD-Core Version:    0.7.0.1
 */