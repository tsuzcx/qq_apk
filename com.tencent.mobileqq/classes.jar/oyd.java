import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeCommentView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

public class oyd
  extends TextBase
{
  private final int jdField_a_of_type_Int = -654311424;
  private NativeCommentView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView;
  private final int b = 5;
  
  public oyd(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView = new NativeCommentView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setTextColor(-654311424);
  }
  
  public void a(opw paramopw)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setModel(paramopw);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setTextSize(0, this.mTextSize);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeCommentView.setIncludeFontPadding(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyd
 * JD-Core Version:    0.7.0.1
 */