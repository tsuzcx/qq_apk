import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public class ruc
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 2;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private rub jdField_a_of_type_Rub;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ruc(TabLayoutCompat paramTabLayoutCompat, Context paramContext)
  {
    super(paramContext);
    if ((paramTabLayoutCompat.f != 0) && (paramContext != null)) {
      setBackgroundDrawable(paramContext.getResources().getDrawable(paramTabLayoutCompat.f));
    }
    ViewCompat.setPaddingRelative(this, paramTabLayoutCompat.jdField_a_of_type_Int, paramTabLayoutCompat.jdField_b_of_type_Int, paramTabLayoutCompat.c, paramTabLayoutCompat.d);
    setGravity(17);
    setOrientation(1);
    setClickable(true);
  }
  
  private float a(Layout paramLayout, int paramInt, float paramFloat)
  {
    return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
  }
  
  private void a(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
  {
    Drawable localDrawable;
    CharSequence localCharSequence1;
    label32:
    CharSequence localCharSequence2;
    if (this.jdField_a_of_type_Rub != null)
    {
      localDrawable = this.jdField_a_of_type_Rub.a();
      if (this.jdField_a_of_type_Rub == null) {
        break label176;
      }
      localCharSequence1 = this.jdField_a_of_type_Rub.a();
      if (this.jdField_a_of_type_Rub == null) {
        break label182;
      }
      localCharSequence2 = this.jdField_a_of_type_Rub.b();
      label48:
      if (paramImageView != null)
      {
        if (localDrawable == null) {
          break label188;
        }
        paramImageView.setImageDrawable(localDrawable);
        paramImageView.setVisibility(0);
        setVisibility(0);
        label73:
        paramImageView.setContentDescription(localCharSequence2);
      }
      if (TextUtils.isEmpty(localCharSequence1)) {
        break label202;
      }
      i = 1;
      label89:
      if (paramTextView != null)
      {
        if (i == 0) {
          break label207;
        }
        paramTextView.setText(localCharSequence1);
        paramTextView.setVisibility(0);
        setVisibility(0);
        label113:
        paramTextView.setContentDescription(localCharSequence2);
      }
      if (paramImageView != null)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        if ((i == 0) || (paramImageView.getVisibility() != 0)) {
          break label221;
        }
      }
    }
    label176:
    label182:
    label188:
    label202:
    label207:
    label221:
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(8);; i = 0)
    {
      if (i != paramTextView.bottomMargin)
      {
        paramTextView.bottomMargin = i;
        paramImageView.requestLayout();
      }
      return;
      localDrawable = null;
      break;
      localCharSequence1 = null;
      break label32;
      localCharSequence2 = null;
      break label48;
      paramImageView.setVisibility(8);
      paramImageView.setImageDrawable(null);
      break label73;
      i = 0;
      break label89;
      paramTextView.setVisibility(8);
      paramTextView.setText(null);
      break label113;
    }
  }
  
  public void a()
  {
    a(null);
    setSelected(false);
  }
  
  public void a(@Nullable rub paramrub)
  {
    if (paramrub != this.jdField_a_of_type_Rub)
    {
      this.jdField_a_of_type_Rub = paramrub;
      b();
    }
  }
  
  final void b()
  {
    rub localrub = this.jdField_a_of_type_Rub;
    Object localObject;
    if (localrub != null)
    {
      localObject = localrub.a();
      if (localObject == null) {
        break label367;
      }
      ViewParent localViewParent = ((View)localObject).getParent();
      if (localViewParent != this)
      {
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView((View)localObject);
        }
        addView((View)localObject);
      }
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label359;
        }
        this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidWidgetTextView.getMaxLines();
      }
      label133:
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(16908294));
      label146:
      if (this.jdField_a_of_type_AndroidViewView != null) {
        break label408;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        localObject = new ImageView(getContext());
        ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(48, 48));
        addView((View)localObject, 0);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setMaxLines(2);
        ((TextView)localObject).setGravity(1);
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        addView((View)localObject);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        if (Build.VERSION.SDK_INT < 16) {
          break label400;
        }
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getMaxLines();
      }
      label278:
      this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidWidgetTextView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.e);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList);
      }
      a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetImageView);
      label335:
      if ((localrub == null) || (!localrub.a())) {
        break label499;
      }
    }
    label359:
    label367:
    label499:
    for (boolean bool = true;; bool = false)
    {
      setSelected(bool);
      return;
      localObject = null;
      break;
      this.jdField_a_of_type_Int = -1;
      break label133;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
      }
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      this.jdField_b_of_type_AndroidWidgetImageView = null;
      break label146;
      this.jdField_a_of_type_Int = -1;
      break label278;
      if ((TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_b_of_type_AndroidWidgetTextView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.e);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_a_of_type_AndroidContentResColorStateList);
      }
      if ((this.jdField_b_of_type_AndroidWidgetTextView == null) && (this.jdField_b_of_type_AndroidWidgetImageView == null)) {
        break label335;
      }
      a(this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView);
      break label335;
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 1;
    int j = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.c();
    int i = paramInt1;
    if (n > 0) {
      if (m != 0)
      {
        i = paramInt1;
        if (j <= n) {}
      }
      else
      {
        i = View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.g, -2147483648);
      }
    }
    super.onMeasure(i, paramInt2);
    float f2;
    float f1;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      getResources();
      f2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_a_of_type_Float;
      j = this.jdField_a_of_type_Int;
      if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
        break label285;
      }
      paramInt1 = 1;
      f1 = f2;
      f2 = this.jdField_a_of_type_AndroidWidgetTextView.getTextSize();
      m = this.jdField_a_of_type_AndroidWidgetTextView.getLineCount();
      if (Build.VERSION.SDK_INT < 16) {
        break label329;
      }
    }
    label285:
    label329:
    for (j = this.jdField_a_of_type_AndroidWidgetTextView.getMaxLines();; j = -1)
    {
      if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
      {
        j = k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.i == 1)
        {
          j = k;
          if (f1 > f2)
          {
            j = k;
            if (m == 1)
            {
              Layout localLayout = this.jdField_a_of_type_AndroidWidgetTextView.getLayout();
              if (localLayout != null)
              {
                j = k;
                if (a(localLayout, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
              }
              else
              {
                j = 0;
              }
            }
          }
        }
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f1);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(paramInt1);
          super.onMeasure(i, paramInt2);
        }
      }
      return;
      paramInt1 = j;
      f1 = f2;
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break;
      }
      paramInt1 = j;
      f1 = f2;
      if (this.jdField_a_of_type_AndroidWidgetTextView.getLineCount() <= 1) {
        break;
      }
      f1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.jdField_b_of_type_Float;
      paramInt1 = j;
      break;
    }
  }
  
  public boolean performClick()
  {
    int i = 0;
    boolean bool = super.performClick();
    if (this.jdField_a_of_type_Rub != null)
    {
      if (!bool) {
        playSoundEffect(0);
      }
      rub localrub = TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat);
      if (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) == this.jdField_a_of_type_Rub) {
        i = 1;
      }
      this.jdField_a_of_type_Rub.a();
      if ((TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) != null) && (i == 0)) {
        TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat).a(this.jdField_a_of_type_Rub, localrub, 1);
      }
      return true;
    }
    return bool;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (isSelected() != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
        sendAccessibilityEvent(4);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setSelected(paramBoolean);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setSelected(paramBoolean);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ruc
 * JD-Core Version:    0.7.0.1
 */