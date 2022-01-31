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

public class rls
  extends VideoFeedsLazyLoadDelegate
{
  private static final String jdField_c_of_type_JavaLangString = alud.a(2131717314);
  private WeishiRedDotInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructWeishiRedDotInfo;
  private oye jdField_a_of_type_Oye = (oye)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(274);
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public rls(qyx paramqyx, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    super(paramqyx, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramBoolean, paramInt);
  }
  
  private void a(WeishiRedDotInfo paramWeishiRedDotInfo)
  {
    if (paramWeishiRedDotInfo == null)
    {
      super.d();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
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
    this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Ntc, l1, a(), i, null, str1, l3, true, 0, str2, str3, paramWeishiRedDotInfo, 0, null, null, 0, null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842790);
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
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO"));
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        rdm.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        this.jdField_a_of_type_Oye.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        return true;
      }
    }
    return super.a(paramBundle);
  }
  
  public void b()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)bdgk.k());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)bdgk.l());
    ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131165307));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/kan/images/rij_wehishi_bg.png", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Oye != null))
    {
      if (paramVideoInfo.a == null) {
        rdm.a(paramVideoInfo);
      }
      long l = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_Oye.a(syb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramVideoInfo.a), l);
    }
  }
  
  public void d()
  {
    if (!this.d)
    {
      this.d = true;
      ThreadManager.excute(new WeishiVideoFeedsLazyLoadDelegate.1(this), 32, null, true);
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructWeishiRedDotInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rls
 * JD-Core Version:    0.7.0.1
 */