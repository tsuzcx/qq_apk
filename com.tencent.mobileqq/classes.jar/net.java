import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.DataProviderListener;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class net
  extends SimpleObserver
{
  public net(MsgTabVideoPreloaderDataProvider paramMsgTabVideoPreloaderDataProvider, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(List paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    MsgTabVideoData localMsgTabVideoData;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new neu(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localMsgTabVideoData = (MsgTabVideoData)paramList.next();
          if (i < MsgTabVideoPreloaderDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localMsgTabVideoData != null) && (!localMsgTabVideoData.jdField_a_of_type_Boolean) && (localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      i += 1;
    }
    for (;;)
    {
      break;
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
 * Qualified Name:     net
 * JD-Core Version:    0.7.0.1
 */