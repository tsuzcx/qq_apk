import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.lang.ref.WeakReference;

final class mba
  implements mbh
{
  mba(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, WeakReference paramWeakReference) {}
  
  public Bitmap a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.b, (byte)3, false, false);
  }
  
  public TroopInfoData a()
  {
    TroopInfoData localTroopInfoData = new TroopInfoData();
    localTroopInfoData.troopUin = this.b;
    localTroopInfoData.updateForTroopInfo(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.b), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localTroopInfoData;
  }
  
  public String a()
  {
    return max.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b);
  }
  
  public String a(int paramInt)
  {
    return "0X800A3E4";
  }
  
  public String a(long paramLong, int paramInt)
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      mts.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.b);
    }
    max.a(this.jdField_a_of_type_Long, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
  
  public String b()
  {
    return max.a(this.b);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2) {
      mts.a(paramInt1, paramInt2, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mba
 * JD-Core Version:    0.7.0.1
 */