import android.graphics.Color;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.NativeCommentTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;

public class oki
  extends TextBase
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private NativeCommentTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView;
  private final int b = 5;
  private final int c = Utils.dp2px(16.0D);
  
  public oki(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView = new NativeCommentTextView(paramVafContext.getContext());
  }
  
  public void a(ohs paramohs, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setModel(paramohs, paramView);
  }
  
  public void a(ohs paramohs, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setModel(paramohs, paramView, paramInt);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setTextSize(0, this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setTextColor(jdField_a_of_type_Int);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.setAttribute(paramInt, paramObject);
    } while (!(paramObject instanceof oif));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiNativeCommentTextView.setCommentModel((oif)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oki
 * JD-Core Version:    0.7.0.1
 */