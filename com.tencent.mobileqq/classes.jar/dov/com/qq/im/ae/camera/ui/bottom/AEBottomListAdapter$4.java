package dov.com.qq.im.ae.camera.ui.bottom;

import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import mqq.os.MqqHandler;

class AEBottomListAdapter$4
  implements AEMaterialDownloader.MaterialDownloadListener
{
  AEBottomListAdapter$4(AEBottomListAdapter paramAEBottomListAdapter) {}
  
  public void onDownloadFinish(AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (AEBottomListAdapter.a(this.a) == null))
    {
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.1(this, paramAEMaterialMetaData));
      if (!paramBoolean) {
        break label146;
      }
    }
    label146:
    for (paramInt = 0;; paramInt = 1)
    {
      VSReporter.a("record_decoration_download", VSReporter.a(paramInt, System.currentTimeMillis() - paramAEMaterialMetaData.jdField_a_of_type_Long, paramAEMaterialMetaData.d, paramAEMaterialMetaData.b, paramAEMaterialMetaData.jdField_a_of_type_JavaLangString));
      return;
      if ((paramAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(AEBottomListAdapter.a(this.a).a())) && (paramAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(AEBottomListAdapter.a(this.a).jdField_a_of_type_JavaLangString)))
      {
        AEBottomListAdapter.a(this.a);
        AEBottomListAdapter.a(this.a, AEBottomListAdapter.a(this.a));
      }
      ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.2(this, paramAEMaterialMetaData));
      break;
    }
  }
  
  public void onProgressUpdate(AEMaterialMetaData paramAEMaterialMetaData, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.4.3(this, paramAEMaterialMetaData, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4
 * JD-Core Version:    0.7.0.1
 */