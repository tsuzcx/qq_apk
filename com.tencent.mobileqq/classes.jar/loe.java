import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb3e.cmd0xb3e.RspBody;
import tencent.im.oidb.gallery.gallery.GalleryList;

public class loe
  extends ProtoUtils.AppProtocolObserver
{
  public loe(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new cmd0xb3e.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if (paramBundle.msg_gallery_list.has())
      {
        paramArrayOfByte = (gallery.GalleryList)paramBundle.msg_gallery_list.get();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(true, paramArrayOfByte.rpt_msg_gallery_info.get());
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, null);
      }
      QLog.e(ReadInJoyAtlasManager.a, 1, "fetchAtlasList onResult(), exception=" + paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loe
 * JD-Core Version:    0.7.0.1
 */