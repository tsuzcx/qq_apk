import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.EncryptUinInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class nnq
  extends nnr
{
  nnq(nnp paramnnp) {}
  
  protected void a(boolean paramBoolean, List<EncryptUinInfo> paramList, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (EncryptUinInfo)paramList.get(0);
      if ((paramList.jdField_a_of_type_Int != 0) || (paramList.jdField_a_of_type_Long != this.a.mApp.getLongAccountUin()) || (TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString))) {
        break label113;
      }
      nnp.a(this.a, paramList.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: " + nnp.a(this.a));
      }
    }
    label113:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("EncryptUinHandler", 2, "onGetEncryptUin: failed，code=" + paramList.jdField_a_of_type_Int);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      super.onUpdate(paramInt, paramBoolean, paramObject);
      this.a.mApp.removeObserver(nnp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nnq
 * JD-Core Version:    0.7.0.1
 */