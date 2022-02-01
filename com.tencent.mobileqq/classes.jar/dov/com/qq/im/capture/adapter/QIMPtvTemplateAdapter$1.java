package dov.com.qq.im.capture.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import org.json.JSONObject;

class QIMPtvTemplateAdapter$1
  implements QIMPtvTemplateAdapter.IPtvTemplateItemCallback
{
  QIMPtvTemplateAdapter$1(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    } while (localPtvTemplateInfo == null);
    if (localPtvTemplateInfo.isWsBanner())
    {
      WeishiGuideUtils.a(this.a.jdField_a_of_type_AndroidContentContext, localPtvTemplateInfo);
      return;
    }
    if (QIMPtvTemplateAdapter.a(this.a) == paramInt)
    {
      QIMPtvTemplateAdapter.jdField_c_of_type_Boolean = true;
      QIMPtvTemplateAdapter.a(this.a, paramInt);
      QIMPtvTemplateAdapter.jdField_c_of_type_Int = paramInt;
      QIMPtvTemplateAdapter.jdField_b_of_type_Int = localPtvTemplateInfo.categoryId;
      QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.id;
    }
    try
    {
      localJSONObject = new JSONObject();
      if (TextUtils.isEmpty(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString)) {
        break label410;
      }
      if (!"0".equals(QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString)) {
        break label383;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        label163:
        Object localObject;
        QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "report failed");
        continue;
        String str = "empty";
      }
    }
    localJSONObject.put("lens_id", localObject);
    if (QIMPtvTemplateAdapter.jdField_b_of_type_Int != 0) {}
    for (localObject = Integer.valueOf(QIMPtvTemplateAdapter.jdField_b_of_type_Int);; localObject = "empty")
    {
      localJSONObject.put("lens_tab", localObject);
      localJSONObject.put("id_pos", QIMPtvTemplateAdapter.jdField_c_of_type_Int);
      VSReporter.a("mystatus_shoot", "lens_select", 0, 0, new String[] { "", String.valueOf(FlowCameraConstant.a), localJSONObject.toString() });
      QLog.d("Q.videostory.capture", QLog._DEFAULT_REPORTLOG_LEVEL, "change material result:" + localJSONObject.toString());
      ((QIMPredownManager)QIMManager.a(14)).a(localPtvTemplateInfo.id, 3);
      if (!localPtvTemplateInfo.id.equals("0"))
      {
        QIMPtvTemplateAdapter.jdField_b_of_type_Boolean = true;
        if (!QIMPtvTemplateAdapter.jdField_c_of_type_Boolean) {
          QIMPtvTemplateAdapter.jdField_a_of_type_Boolean = false;
        }
        this.a.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(localPtvTemplateInfo, 111);
      }
      this.a.a(null);
      if (!localPtvTemplateInfo.usable) {
        FlowCameraMqqAction.a("", "0X8006A1A");
      }
      ((CaptureComboManager)QIMManager.a(5)).a(this.a.d, (Activity)this.a.jdField_a_of_type_AndroidContentContext);
      return;
      QIMPtvTemplateAdapter.jdField_c_of_type_Boolean = false;
      break;
      label383:
      localObject = QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.1
 * JD-Core Version:    0.7.0.1
 */