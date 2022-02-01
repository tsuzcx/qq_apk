package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import java.util.Iterator;
import java.util.List;

class QIMPtvTemplateManager$6
  implements INetEngineListener
{
  QIMPtvTemplateManager$6(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener) {}
  
  public void onResp(NetResp arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + ???.mHttpCode);
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    synchronized (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaLangObject)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      do
      {
        Iterator localIterator = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (TemplateGroupItem)localIterator.next();
          } while (((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList == null);
          localObject2 = ((TemplateGroupItem)localObject2).jdField_a_of_type_JavaUtilList.iterator();
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
      } while (!localPtvTemplateInfo.name.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name));
      localPtvTemplateInfo.usable = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(localPtvTemplateInfo);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.totalLen = paramLong2;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.6
 * JD-Core Version:    0.7.0.1
 */