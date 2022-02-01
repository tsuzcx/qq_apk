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

public class owz
  extends RichNativeText
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#262626");
  private static final int b = Utils.dp2px(16.0D);
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private otd jdField_a_of_type_Otd;
  private otp jdField_a_of_type_Otp;
  private int c = -1;
  
  public owz(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
  }
  
  private void a()
  {
    QLog.d("CommentRichTextView", 2, "showAnchorAniation");
    if ((this.jdField_a_of_type_Otp == null) || (this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    View localView;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-15550475);
      }
      localView = this.jdField_a_of_type_AndroidViewView;
    } while (localView == null);
    QLog.d("CommentRichTextView", 2, "showAnchorAniation start");
    this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26, 0, 26, 0 });
    localValueAnimator.setDuration(2400L);
    localValueAnimator.setStartDelay(600L);
    localValueAnimator.addUpdateListener(new oxb(this, localView));
    localValueAnimator.start();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable.setAlpha(0);
    paramView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  public void a(otd paramotd, View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramotd == null)) {
      return;
    }
    this.jdField_a_of_type_Otd = paramotd;
    this.jdField_a_of_type_AndroidViewView = paramView;
    a();
  }
  
  public void a(otp paramotp)
  {
    this.jdField_a_of_type_Otp = paramotp;
    if ((this.jdField_a_of_type_Otp == null) || (this.jdField_a_of_type_Otp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (this.mNative == null)) {
      return;
    }
    setText(this.jdField_a_of_type_Otp.jdField_a_of_type_JavaLangCharSequence);
    this.mNative.setOnClickListener(this);
    this.mNative.setOnLongClickListener(this);
    a();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Otd == null) || (this.mNative == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.mNative.isHyperLinkClick())
      {
        this.mNative.setHyperLinkClick(false);
      }
      else if (this.c == -1)
      {
        this.mNative.setBackgroundResource(2130849372);
        this.jdField_a_of_type_Otd.a(this.jdField_a_of_type_Otp);
      }
      else
      {
        ((orv)this.jdField_a_of_type_Otd).a(this.jdField_a_of_type_Otp, oqy.a(this.jdField_a_of_type_Otp, this.c), 2);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Otd == null)) {
      return false;
    }
    if (this.c == -1)
    {
      setBackgroundColor(Color.parseColor("#EDEDED"));
      this.jdField_a_of_type_Otd.a(this.jdField_a_of_type_Otd.a(), this.mNative, this.jdField_a_of_type_Otp, new oxa(this));
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
    } while (!(paramObject instanceof otp));
    a((otp)paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owz
 * JD-Core Version:    0.7.0.1
 */