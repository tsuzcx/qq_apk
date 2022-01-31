import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.List;

public class nqy
  extends SimpleObserver
{
  public nqy(MsgTabVideoDataProvider paramMsgTabVideoDataProvider, MsgTabNodeInfo paramMsgTabNodeInfo1, MsgTabNodeInfo paramMsgTabNodeInfo2, int paramInt, long paramLong) {}
  
  public void a(List paramList)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "requestVideoList first db then network-----onNext(). nodeId=", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a });
    }
    if (paramList.size() > 0) {}
    for (;;)
    {
      MsgTabVideoDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.b, this.jdField_a_of_type_Int, paramList, bool, 0, false, this.jdField_a_of_type_Long);
      return;
      bool = false;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    if ((paramError instanceof ErrorMessage)) {}
    for (int i = ((ErrorMessage)paramError).errorCode;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabVideoDataProvider", 2, new Object[] { "requestVideoList first db then network-----onError(). nodeId=", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.a, ", errCode=", Integer.valueOf(i) });
      }
      MsgTabVideoDataProvider.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.b, this.jdField_a_of_type_Int, null, false, i, false, this.jdField_a_of_type_Long);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqy
 * JD-Core Version:    0.7.0.1
 */