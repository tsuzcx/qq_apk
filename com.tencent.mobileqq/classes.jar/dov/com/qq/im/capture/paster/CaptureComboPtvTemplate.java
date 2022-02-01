package dov.com.qq.im.capture.paster;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboBase;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class CaptureComboPtvTemplate
  extends CaptureComboBase
{
  private float jdField_a_of_type_Float = 0.0F;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = QIMManager.a();
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new CaptureComboPtvTemplate.1(this);
  private PtvTemplateManager.PtvTemplateInfo jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(paramString);
  private QIMPtvTemplateManager jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager = (QIMPtvTemplateManager)QIMManager.a(3);
  private int d = 2;
  
  public CaptureComboPtvTemplate(String paramString)
  {
    super(null);
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)) {
      this.d = 3;
    }
    while (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) {
      return;
    }
    this.d = 3;
  }
  
  public float a()
  {
    try
    {
      float f = this.jdField_a_of_type_Float;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo != null) && (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable))
    {
      paramActivity = QIMPtvTemplateManager.a + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, 111);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.categoryId, paramActivity);
      return 0;
    }
    return -1;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a("0", 0, "");
    dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.c = 0;
  }
  
  public int b()
  {
    for (;;)
    {
      try
      {
        int i;
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo == null)
        {
          this.d = 3;
          i = this.d;
          return i;
        }
        if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
        {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
          a();
          this.d = 1;
          i = this.d;
          continue;
        }
        if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading)
        {
          this.d = 1;
          continue;
        }
        this.jdField_a_of_type_Float = 1.0F;
      }
      finally {}
      this.d = 3;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.CaptureComboPtvTemplate
 * JD-Core Version:    0.7.0.1
 */