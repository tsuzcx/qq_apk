import android.text.TextUtils;
import com.tencent.av.share.AVSchema;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lxz
  extends andd
{
  public String a;
  
  private lxz(AVSchema paramAVSchema) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema.a("onGetSimpleTroopInfoResult", l)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramTroopInfo == null);
        paramString = paramTroopInfo.troopuin;
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)));
      QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, "onGetSimpleTroopInfoResult, isSuc[" + paramBoolean + "], enum_verify_status[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Lxx.a + "], seq[" + l + "]");
      this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Lxx.b = paramTroopInfo.troopname;
    } while (this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_Lxx.a != 0);
    if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvShareAVSchema.getActivity(), true, new lya(this, l)))
    {
      this.jdField_a_of_type_ComTencentAvShareAVSchema.b(l, this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, "onGetSimpleTroopInfoResult, 等权限确认, seq[" + l + "]");
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.jdField_a_of_type_JavaLangString, 1, "onUpdateTroopList, isSuccess[" + paramBoolean + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxz
 * JD-Core Version:    0.7.0.1
 */