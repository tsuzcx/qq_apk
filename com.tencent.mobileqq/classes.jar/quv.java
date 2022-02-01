import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyApngImageView.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import java.util.Date;

public class quv
  extends ImageBase
{
  private static final Drawable a;
  public NativeReadInjoyImageView a;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
  }
  
  public quv(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = new NativeReadInjoyImageView(paramVafContext.getContext());
  }
  
  private static long a(Date paramDate1, Date paramDate2)
  {
    return Math.abs((paramDate1.getTime() - paramDate2.getTime()) / 86400000L);
  }
  
  private void a(String paramString)
  {
    new Handler(Looper.getMainLooper()).postDelayed(new ReadInjoyApngImageView.1(this, paramString), 1500L);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  }
  
  public void loadImage(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")) && (!DateUtils.isToday(bhhr.b("search_word_prefix_ug_weishi_opt_day_show_time"))))
    {
      bhhr.a("search_word_prefix_ug_weishi_opt_day_show_time", System.currentTimeMillis());
      if (a(new Date(System.currentTimeMillis()), new Date(bhhr.b("search_word_prefix_ug_weishi_opt_week_first_show_time"))) <= 7L) {
        break label87;
      }
      bhhr.a("search_word_prefix_ug_weishi_opt_week_first_show_time", System.currentTimeMillis());
      bhhr.a("search_word_prefix_ug_weishi_opt_week_first_show_count", 1);
      a(paramString);
    }
    label87:
    while (bhhr.a("search_word_prefix_ug_weishi_opt_week_first_show_count") >= 3) {
      return;
    }
    bhhr.a("search_word_prefix_ug_weishi_opt_week_first_show_count", bhhr.a("search_word_prefix_ug_weishi_opt_week_first_show_count") + 1);
    a(paramString);
  }
  
  public void onComDraw(Canvas paramCanvas)
  {
    super.onComDraw(paramCanvas);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     quv
 * JD-Core Version:    0.7.0.1
 */