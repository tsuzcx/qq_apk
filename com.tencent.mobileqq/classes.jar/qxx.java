import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public class qxx
  implements qxt
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private npv jdField_a_of_type_Npv;
  private qxz jdField_a_of_type_Qxz;
  private qyf jdField_a_of_type_Qyf;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public qxx(Activity paramActivity, ArrayList<VideoInfo> paramArrayList, int paramInt, Bundle paramBundle, qyf paramqyf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Qyf = paramqyf;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("VIDEO_COMMON_DATA");
    this.jdField_a_of_type_ArrayOfByte = paramBundle.getByteArray("VIDEO_BUSINESS_INFO");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onk.a());
    this.jdField_a_of_type_Qxz = new qxz(this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Qxz);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (this.jdField_a_of_type_Npv == null) {
      this.jdField_a_of_type_Npv = ((npv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    }
    Object localObject2 = this.jdField_a_of_type_Qyf.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new VideoInfo();
    }
    if (((VideoInfo)localObject1).a != null) {}
    for (int i = ((VideoInfo)localObject1).a.jdField_a_of_type_Int;; i = 0)
    {
      localObject2 = new ArrayList(this.jdField_a_of_type_Qyf.a());
      this.jdField_a_of_type_Npv.a(this.jdField_a_of_type_Qxz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), (VideoInfo)localObject1, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)localObject1).i, -1L, true, i, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, null, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_ArrayOfByte, 1, 1, (ArrayList)localObject2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size() - 5) {
      a();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Qxz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxx
 * JD-Core Version:    0.7.0.1
 */