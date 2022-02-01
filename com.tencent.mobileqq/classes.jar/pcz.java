import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQReportBridgeImpl.1;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import mqq.os.MqqHandler;

public class pcz
  implements QQReportBridge
{
  private final pdl a;
  
  public pcz(pdl parampdl)
  {
    this.a = parampdl;
  }
  
  public void asyncReport(Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new QQReportBridgeImpl.1(this, paramBundle));
  }
  
  public int getCommentLevel()
  {
    if ((this.a.e) || ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData))) {
      return 2;
    }
    if ((TextUtils.isEmpty(this.a.c)) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null)) {
      return 0;
    }
    return 1;
  }
  
  public long getConsumeTime()
  {
    return pkn.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L;
  }
  
  public int getEntry()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) {
      i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d();
    }
    pdv localpdv;
    do
    {
      return i;
      localpdv = pdv.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    } while (localpdv == null);
    return localpdv.a();
  }
  
  public int getFolderStatus()
  {
    return prp.a;
  }
  
  public String getReportVersion()
  {
    return omx.a;
  }
  
  public int getScene()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) {
      i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b();
    }
    return i;
  }
  
  public void report(Bundle paramBundle)
  {
    olh.a(null, paramBundle.getString("toUin"), paramBundle.getString("subAction"), paramBundle.getString("actionName"), paramBundle.getInt("fromType", 0), paramBundle.getInt("result", 0), paramBundle.getString("r2", ""), paramBundle.getString("r3", ""), paramBundle.getString("r4", ""), paramBundle.getString("r5", ""), paramBundle.getBoolean("shouldEncode", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcz
 * JD-Core Version:    0.7.0.1
 */