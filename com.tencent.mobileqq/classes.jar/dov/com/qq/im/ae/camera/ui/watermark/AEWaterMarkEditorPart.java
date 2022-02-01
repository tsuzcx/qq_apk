package dov.com.qq.im.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.ttpic.baseutils.string.StringUtils;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.ui.poi.AESelectLocationFragment;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;
import org.light.bean.WMElement;

public class AEWaterMarkEditorPart
  extends VideoStoryBasePart
{
  private static boolean jdField_a_of_type_Boolean = false;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private WatermarkEditView jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView;
  private WMElement jdField_a_of_type_OrgLightBeanWMElement;
  private boolean b = false;
  
  public AEWaterMarkEditorPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    List localList = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a();
    if ((localList == null) || (localList.isEmpty())) {
      AEQLog.d("AEWaterMarkEditorPart", "showWaterMarkEdit---getEditableWMElements is null");
    }
    do
    {
      return;
      Object localObject;
      if (localList.size() == 1)
      {
        localObject = (WMElement)localList.get(0);
        if ((localObject != null) && ("EDITABLE_LOCATION".equals(((WMElement)localObject).type)))
        {
          AEQLog.a("AEWaterMarkEditorPart", "only jump to poi");
          AESelectLocationFragment.a(this.mActivity, 203);
          this.b = true;
          this.jdField_a_of_type_OrgLightBeanWMElement = ((WMElement)localObject);
          return;
        }
      }
      this.b = false;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)
      {
        localObject = (ViewStub)this.mActivity.findViewById(2131364356);
        if (localObject != null)
        {
          ((ViewStub)localObject).inflate();
          this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView = ((WatermarkEditView)this.mActivity.findViewById(2131364355));
          this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a(this.mActivity, this.mPartManager);
        }
      }
    } while (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null);
    this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.a(localList);
  }
  
  public Object get(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(jdField_a_of_type_Boolean);
  }
  
  public void initView() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 203) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_select_poi");
      AEQLog.a("AEWaterMarkEditorPart", "onActivityResult" + paramIntent);
      if ((this.b) || (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView == null)) {
        break label73;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.setWaterMarkLocation(paramIntent);
    }
    label73:
    while ((!this.b) || (this.jdField_a_of_type_OrgLightBeanWMElement == null)) {
      return;
    }
    paramIntent = StringUtils.removeUTF8Emoji(paramIntent).trim();
    this.jdField_a_of_type_OrgLightBeanWMElement.setLocation(paramIntent);
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 589825: 
      a();
      if (this.b)
      {
        jdField_a_of_type_Boolean = false;
        return;
      }
      jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.getVisibility() == 0)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiWatermarkWatermarkEditView.setVisibility(8);
    }
    jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.watermark.AEWaterMarkEditorPart
 * JD-Core Version:    0.7.0.1
 */