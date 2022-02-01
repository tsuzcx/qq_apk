import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.WeishiVideoFeedsLazyLoadDelegate.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class rxx
  extends VideoFeedsLazyLoadDelegate
{
  private static final String jdField_d_of_type_JavaLangString = anzj.a(2131715700);
  private WeishiRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructWeishiRedDotInfo;
  private pgj jdField_a_of_type_Pgj = (pgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(274);
  private boolean c;
  private boolean jdField_d_of_type_Boolean;
  
  public rxx(rlp paramrlp, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramrlp, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private void a(WeishiRedDotInfo paramWeishiRedDotInfo)
  {
    if (paramWeishiRedDotInfo == null)
    {
      super.d();
      return;
    }
    this.c = true;
    int i = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
    String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("VIDEO_SECOND_INDEX_INNER_ID");
    long l3 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("VIDEO_COMMON_DATA");
    String str3 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("VALUE_COOKIE");
    long l2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Odp.a(this.jdField_a_of_type_Odq, l1, a(), i, null, str1, l3, true, 0, str2, str3, paramWeishiRedDotInfo, 0, null, null, 0, null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843151);
      return;
    }
    super.a(paramInt);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    b(paramVideoInfo);
    super.a(paramVideoInfo);
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO"));
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        this.jdField_a_of_type_Pgj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        return true;
      }
    }
    return super.a(paramBundle);
  }
  
  public void b()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bhlo.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)bhlo.l());
    ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165343));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/kan/images/rij_wehishi_bg.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Pgj != null))
    {
      if (paramVideoInfo.a == null) {
        rpt.a(paramVideoInfo);
      }
      long l = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_Pgj.a(tzq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVideoInfo.a), l);
    }
  }
  
  public void d()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      ThreadManager.excute(new WeishiVideoFeedsLazyLoadDelegate.1(this), 32, null, true);
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructWeishiRedDotInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxx
 * JD-Core Version:    0.7.0.1
 */