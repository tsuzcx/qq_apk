import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class lys
  implements lzb
{
  lys(lyr paramlyr, long paramLong) {}
  
  public Bitmap a(long paramLong)
  {
    if (this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    return this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Lyr.jdField_a_of_type_JavaLangString, (byte)3, false, false);
  }
  
  public TroopInfoData a()
  {
    return this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  }
  
  public String a()
  {
    return lyr.a(this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Lyr.jdField_a_of_type_JavaLangString);
  }
  
  public String a(int paramInt)
  {
    return null;
  }
  
  public String a(long paramLong, int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_Lyr.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = lyr.a(this.jdField_a_of_type_Lyr, paramInt);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    this.jdField_a_of_type_Lyr.a(paramLong, this.jdField_a_of_type_Lyr.jdField_a_of_type_Long, this.jdField_a_of_type_Lyr.jdField_a_of_type_Int);
    return str;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onFinish, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.jdField_a_of_type_Long + "]");
    mrw.a(paramInt1, paramInt2);
    if (paramInt3 == 2) {
      mrw.a(paramInt1, paramInt2, 99, null);
    }
  }
  
  public String b()
  {
    return lyr.a(this.jdField_a_of_type_Lyr.jdField_a_of_type_JavaLangString);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.w("ShareChat", 1, "onQRForward, choosedChannel[" + paramInt1 + "], choosedLinkType[" + paramInt2 + "], result[" + paramInt3 + "], seq[" + this.jdField_a_of_type_Long + "]");
    if (paramInt3 == 2) {
      mrw.a(paramInt1, paramInt2, 99, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lys
 * JD-Core Version:    0.7.0.1
 */