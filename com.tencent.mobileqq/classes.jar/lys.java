import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.share.ShareChat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class lys
  implements lyz
{
  public lys(ShareChat paramShareChat, long paramLong) {}
  
  public int a()
  {
    return 99;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Long;
  }
  
  public Bitmap a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceBitmap(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString, (byte)3, false, false);
  }
  
  public TroopInfoData a()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  }
  
  public String a()
  {
    return ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString);
  }
  
  public String a(int paramInt)
  {
    return null;
  }
  
  public String a(long paramLong, int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat, paramInt);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    this.jdField_a_of_type_ComTencentAvShareShareChat.a(paramLong, this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Int);
    return str;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onFinish, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.jdField_a_of_type_Long + "]");
    msc.a(paramInt1, paramInt2);
    if (paramInt3 == 2) {
      msc.a(paramInt1, paramInt2, 99, null);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ShareChat.a(this.jdField_a_of_type_ComTencentAvShareShareChat.jdField_a_of_type_JavaLangString);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onQRForward, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (paramInt3 == 2) {
      msc.a(paramInt1, paramInt2, 99, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lys
 * JD-Core Version:    0.7.0.1
 */