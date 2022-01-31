import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

public class pav
  extends TextBase
{
  private final int jdField_a_of_type_Int = -11644322;
  private NativeSummaryView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView;
  private final int b = 5;
  
  public pav(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mTextSize = Utils.dp2px(16.0D);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView = new NativeSummaryView(paramVafContext.getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setTextColor(-11644322);
  }
  
  public void a(opw paramopw)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getLayoutParams() == null)
    {
      Object localObject = getComLayoutParams();
      localObject = new ViewGroup.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setModel(paramopw);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setTextSize(0, this.mTextSize);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeSummaryView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof opw)) {
      a((opw)paramObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pav
 * JD-Core Version:    0.7.0.1
 */