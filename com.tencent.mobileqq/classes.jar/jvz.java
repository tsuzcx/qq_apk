import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class jvz
  implements Runnable
{
  public jvz(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, int paramInt1, String paramString, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_Boolean) {
      return;
    }
    String str2 = null;
    String str1;
    if (this.jdField_a_of_type_Int == 2131428969)
    {
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
        str2 = (String)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {
          break label340;
        }
      }
      str1 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b), this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d);
    }
    label340:
    for (;;)
    {
      float f = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131559833);
      str1 = UITools.a((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.i, f);
      str1 = str1 + this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_AndroidContentResResources.getString(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(63, str1, this.b, this.c);
      }
      QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.c, 1, "showHrMeetingInOrOutWordingWithDelay str=" + str1);
      return;
      str2 = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b), this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d);
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {}
      }
      else
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
          str1 = (String)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jvz
 * JD-Core Version:    0.7.0.1
 */