import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class peh
  extends RichNativeText
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private pan jdField_a_of_type_Pan;
  private pay jdField_a_of_type_Pay;
  private int c = -1;
  
  public peh(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
  }
  
  private void a()
  {
    QLog.d("CommentRichTextView", 2, "showAnchorAniation");
    if ((this.jdField_a_of_type_Pay == null) || (this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.jdField_a_of_type_AndroidViewView;
    } while (localView == null);
    QLog.d("CommentRichTextView", 2, "showAnchorAniation start");
    this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new pej(this, localView));
    localValueAnimator.start();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  public void a(pan parampan, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (parampan == null)) {
      return;
    }
    this.jdField_a_of_type_Pan = parampan;
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public void a(pay parampay)
  {
    this.jdField_a_of_type_Pay = parampay;
    if ((this.jdField_a_of_type_Pay == null) || (this.jdField_a_of_type_Pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.mNative == null)) {
      return;
    }
    this.mNative.setMaxLines(100);
    setText(this.jdField_a_of_type_Pay.jdField_a_of_type_JavaLangCharSequence);
    this.mNative.setOnClickListener(this);
    this.mNative.setOnLongClickListener(this);
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Pan == null) || (this.mNative == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.mNative.getSelectionStart() == -1) && (this.mNative.getSelectionEnd() == -1)) {
        if (this.c == -1)
        {
          this.mNative.setBackgroundResource(2130849353);
          this.jdField_a_of_type_Pan.a(this.jdField_a_of_type_Pay);
        }
        else
        {
          ((ozh)this.jdField_a_of_type_Pan).a(this.jdField_a_of_type_Pay, oyk.a(this.jdField_a_of_type_Pay, this.c), 2);
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Pan == null)) {
      return false;
    }
    if (this.c == -1)
    {
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_a_of_type_Pan.a(this.jdField_a_of_type_Pan.a(), this.mNative, this.jdField_a_of_type_Pay, new pei(this));
    }
    return true;
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setTextSize(0, b);
    this.mNative.setLineSpacing(Utils.rp2px(5.0D), 1.0F);
    this.mNative.setIncludeFontPadding(false);
    this.mNative.setTextColor(jdField_a_of_type_Int);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.setAttribute(paramInt, paramObject);
    } while (!(paramObject instanceof pay));
    a((pay)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */