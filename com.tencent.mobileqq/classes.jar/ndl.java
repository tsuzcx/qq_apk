import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.DataProviderListener;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Collections;

public class ndl
  extends SimpleObserver
{
  public ndl(MsgTabVideoPreloaderDataProvider paramMsgTabVideoPreloaderDataProvider, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse)
  {
    super.onNext(paramMsgTabNodeVidListResponse);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, Collections.emptyList());
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndl
 * JD-Core Version:    0.7.0.1
 */