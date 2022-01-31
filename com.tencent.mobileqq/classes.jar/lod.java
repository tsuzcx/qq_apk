import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb2d.cmd0xb2d.RspBody;
import tencent.im.oidb.gallery.gallery.GalleryInfo;

public class lod
  extends ProtoUtils.AppProtocolObserver
{
  public lod(ReadInJoyAtlasManager paramReadInJoyAtlasManager, ReadInJoyAtlasManager.AtlasCallback paramAtlasCallback) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasManager.a, 2, "onResult, errorCode=" + paramInt);
    }
    if ((paramInt != -1) && (paramArrayOfByte != null))
    {
      if (paramInt == 0) {
        try
        {
          paramBundle = new cmd0xb2d.RspBody();
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.msg_gallery_info.has())
          {
            paramArrayOfByte = (gallery.GalleryInfo)paramBundle.msg_gallery_info.get();
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback == null) {
              return;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(true, paramArrayOfByte);
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback == null) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, null);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, null);
          }
          QLog.e(ReadInJoyAtlasManager.a, 1, "fetchAtlasList onResult(), exception=" + paramArrayOfByte.toString());
          return;
        }
      }
      switch (paramInt)
      {
      default: 
        paramArrayOfByte = null;
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, paramArrayOfByte);
      return;
      paramArrayOfByte = "阿嘞，内容被外星人带走啦~";
      continue;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback.a(false, "当前网络不可用，请价差你的网络设置\n点击屏幕刷新");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lod
 * JD-Core Version:    0.7.0.1
 */