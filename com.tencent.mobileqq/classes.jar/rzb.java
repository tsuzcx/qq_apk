import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class rzb
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public rzb(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEmoticonMainPanel);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    int i = 0;
    label35:
    int j;
    int k;
    if (i < localStringBuilder.length())
    {
      j = localStringBuilder.codePointAt(i);
      if ((j != 20) || (i >= localStringBuilder.length() - 1)) {
        break label599;
      }
      k = localStringBuilder.charAt(i + 1);
      if ((k >= EmotcationConstants.jdField_a_of_type_Int) && (250 != k)) {
        break label258;
      }
      if (250 != k) {
        break label703;
      }
      k = 10;
    }
    label180:
    label703:
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, k + "", "", "", "");
      Object localObject2;
      if (TextUtils.a(k))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        j = ApolloUtil.b(this.jdField_a_of_type_Int);
        if (ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject1 = "1";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "0X800812E", j, 0, new String[] { String.valueOf(k), localObject1 });
        }
      }
      else
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "report emoji send amount, index:" + k);
          j = i;
        }
      }
      do
      {
        i = j + 1;
        break label35;
        break;
        localObject1 = "0";
        break label180;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length()) {
        break;
      }
      Object localObject1 = new char[4];
      localObject1[0] = localStringBuilder.charAt(i + 4);
      localObject1[1] = localStringBuilder.charAt(i + 3);
      localObject1[2] = localStringBuilder.charAt(i + 2);
      localObject1[3] = localStringBuilder.charAt(i + 1);
      j = 0;
      if (j < 3)
      {
        if (localObject1[j] == 'ú') {
          localObject1[j] = 10;
        }
        for (;;)
        {
          j += 1;
          break;
          if (localObject1[j] == 'þ') {
            localObject1[j] = 13;
          }
        }
      }
      localObject1 = EmosmUtils.a((char[])localObject1);
      if ((localObject1 != null) && (localObject1.length == 2))
      {
        k = localObject1[0];
        j = localObject1[1];
      }
      for (;;)
      {
        int n = -1;
        int m = n;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          m = n;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
            m = ((EmoticonMainPanel)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(Integer.toString(k));
          }
        }
        localObject2 = Integer.toString(m);
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject1 = "0X800588C";; localObject1 = "0X80057AF")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject1, 0, 0, k + "", j + "", (String)localObject2, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "report small emoticon send amount, epId:" + k + ",eId:" + j + ",tabOrder:" + (String)localObject2);
          }
          j = i + 4;
          break;
        }
        label599:
        k = EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(j, -1);
        j = i;
        if (k < 0) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, k + "", "", "", "");
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.aio.BaseChatPie", 2, "report system emoticon send amount, emoIdx:" + k);
        j = i;
        break;
        j = 0;
        k = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzb
 * JD-Core Version:    0.7.0.1
 */