import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class qvl
  extends ViewBase
{
  private static String jdField_a_of_type_JavaLangString = "UsersCommentsView";
  private NativeUsersCommentsView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView;
  
  public qvl(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView = new NativeUsersCommentsView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.setOrientation(1);
  }
  
  public void clearDynamicData()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.setComments(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.setCommentAllLink(null);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.a();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    if (!super.setAttribute(paramInt, paramObject)) {
      switch (paramInt)
      {
      default: 
        return false;
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.setComments((JSONArray)paramObject);
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "UsersCommentsView", paramObject);
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    if (!super.setAttribute(paramInt, paramString))
    {
      switch (paramInt)
      {
      default: 
        return false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeUsersCommentsView.setCommentAllLink(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvl
 * JD-Core Version:    0.7.0.1
 */