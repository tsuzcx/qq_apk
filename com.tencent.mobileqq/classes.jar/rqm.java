import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class rqm
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.InterruptedWeishiAd jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private rnu jdField_a_of_type_Rnu;
  private roq jdField_a_of_type_Roq;
  private rro jdField_a_of_type_Rro;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaLangString = rqm.class.getSimpleName();
  }
  
  public rqm(Activity paramActivity, QQAppInterface paramQQAppInterface, rro paramrro, VideoFeedsPlayManager paramVideoFeedsPlayManager, rnu paramrnu, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Rro = paramrro;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rnu = paramrnu;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void c()
  {
    this.g = true;
    switch (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      }
      Object localObject = Boolean.valueOf(bnrf.s(ozs.a()));
      WebViewTitleStyle localWebViewTitleStyle = new WebViewTitleStyle();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
      localBundle.putBoolean("public_account_finish_animation_out_to_bottom", true);
      localBundle.putBoolean("KEY_SLIDE_RIGHT_BACK_ENABLE", false);
      localWebViewTitleStyle.jdField_b_of_type_Int = -16777216;
      localWebViewTitleStyle.jdField_c_of_type_Int = -1;
      localWebViewTitleStyle.jdField_d_of_type_Int = -16777216;
      localWebViewTitleStyle.e = -16777216;
      localBundle.putParcelable("titleStyle", localWebViewTitleStyle);
      if (((Boolean)localObject).booleanValue()) {
        tbz.a(this.jdField_a_of_type_AndroidAppActivity, anzj.a(2131715030), "https://kandian.qq.com/viola/bundle_weishiLeadTo.js?v_bid=3256", null, new rqn(this, localBundle));
      }
      for (;;)
      {
        if (!((Boolean)localObject).booleanValue()) {
          this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130771997, 0);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        try
        {
          int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          localObject = this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a;
          ocd.a(null, null, "0X800933E", "0X800933E", 0, 0, String.valueOf(i), "", "", odr.a(null, null, ((VideoInfo)localObject).jdField_a_of_type_JavaLangString, ((VideoInfo)localObject).g, null), false);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        ozs.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString, localBundle);
      }
    }
    d();
    e();
    this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView == null) && ((this.jdField_a_of_type_Roq.itemView instanceof ViewGroup)))
    {
      View localView = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560322, (ViewGroup)this.jdField_a_of_type_Roq.itemView);
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView = localView.findViewById(2131367789);
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidViewView = localView.findViewById(2131367772);
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367781));
      this.jdField_a_of_type_Roq.b = ((TextView)localView.findViewById(2131367790));
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367793));
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367779));
      this.jdField_a_of_type_Roq.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView = ((CircleCountdownView)localView.findViewById(2131367791));
    }
  }
  
  private boolean d()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) || (this.jdField_a_of_type_Roq == null)) {
      bool = false;
    }
    int i;
    do
    {
      do
      {
        return bool;
        i = this.jdField_a_of_type_Roq.jdField_c_of_type_Int;
        switch (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int)
        {
        default: 
          return false;
        }
      } while ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) && (!this.g));
      return false;
    } while ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.c)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.d)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.e)) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)));
    return false;
  }
  
  private void e()
  {
    Resources localResources;
    Object localObject;
    if ((this.jdField_a_of_type_Roq != null) && (this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView != null))
    {
      localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
      if (this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm != null)
      {
        if (bhny.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_b_of_type_JavaLangString)) {
          break label297;
        }
        this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.d);
        localObject = localResources.getDrawable(2130843059);
      }
    }
    for (;;)
    {
      int i = agej.a(12.0F, localResources);
      ((Drawable)localObject).setBounds(0, 0, i, i);
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new rqo(this));
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new rqp(this));
      this.jdField_a_of_type_Roq.b.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_JavaLangString);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.c, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView.setOnClickListener(null);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        label244:
        ocd.a(null, null, "0X8009BF0", "0X8009BF0", 0, 0, "", "", "", odr.a(null, null, this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm.a.g, (JSONObject)localObject), false);
        return;
        label297:
        this.jdField_a_of_type_Roq.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.e);
        localObject = localResources.getDrawable(2130843062);
      }
      catch (Exception localException)
      {
        break label244;
      }
    }
  }
  
  private boolean e()
  {
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = bnrf.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = bnrf.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool = bnrf.w(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 后台下发原始配置：" + this.jdField_b_of_type_JavaLangString + "\n本地副本配置：" + (String)localObject + "\n本地副本配置是否为当天：" + bool);
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    }
    try
    {
      localObject = new JSONObject(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {}
      for (localObject = ((JSONObject)localObject).getJSONObject("weishi"); localObject == null; localObject = ((JSONObject)localObject).getJSONObject("default"))
      {
        this.jdField_b_of_type_JavaLangString = null;
        return false;
      }
      int i = ((JSONObject)localObject).getInt("display_count_each_entrance");
      this.jdField_a_of_type_Int = i;
      this.jdField_c_of_type_Int = i;
      this.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("display_count_each_day");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 初始剩余次数 mDisplayCountEachEntrance = " + this.jdField_a_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Int > 0))
      {
        this.jdField_b_of_type_Int -= 1;
        this.jdField_a_of_type_Int -= 1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = " + this.jdField_a_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_b_of_type_Int);
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      this.jdField_b_of_type_JavaLangString = null;
    }
    return false;
  }
  
  public void a()
  {
    rro localrro;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int == 0) && (this.f))
    {
      localrro = this.jdField_a_of_type_Rro;
      if (this.jdField_a_of_type_Roq == null) {
        break label55;
      }
    }
    label55:
    for (rrm localrrm = this.jdField_a_of_type_Roq.jdField_a_of_type_Rrm;; localrrm = null)
    {
      localrro.c(localrrm);
      this.g = false;
      this.f = false;
      return;
    }
  }
  
  public void a(VideoInfo.InterruptedWeishiAd paramInterruptedWeishiAd)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramInterruptedWeishiAd;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt != null))
      {
        paramInterruptedWeishiAd = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt;
        int j = paramInterruptedWeishiAd.length;
        int i = 0;
        while (i < j)
        {
          int k = paramInterruptedWeishiAd[i];
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k - 1, true);
          i += 1;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setInterruptedAdInfo() interruptedAdInfo = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.toString());
    }
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public boolean a(int paramInt)
  {
    if (!d()) {}
    while ((this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int < 0) || (paramInt < this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int) || (!e())) {
      return false;
    }
    c();
    this.jdField_c_of_type_Boolean = true;
    return true;
  }
  
  public boolean a(roq paramroq, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Roq != null) {}
    for (int i = this.jdField_a_of_type_Roq.jdField_c_of_type_Int;; i = 0)
    {
      if ((paramroq.jdField_c_of_type_Int > i) && (paramBoolean)) {
        b();
      }
      if ((this.jdField_a_of_type_Roq != null) && (this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView != null)) {
        this.jdField_a_of_type_Roq.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_Roq = paramroq;
      if ((this.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.indexOfKey(this.jdField_d_of_type_Int) >= 0) && ((this.e) || (this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean))) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(this.jdField_d_of_type_Int);
      }
      this.jdField_d_of_type_Int = paramroq.jdField_c_of_type_Int;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setPlayingVideoInfo() itemHolder.position=" + paramroq.jdField_c_of_type_Int);
      }
      return a(0) | false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() mIsConfigInited = " + this.jdField_b_of_type_Boolean);
    }
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.jdField_b_of_type_JavaLangString);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("display_count_each_entrance", this.jdField_c_of_type_Int);
        localJSONObject2.put("display_count_each_day", this.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "weishi";; str = "default")
        {
          localJSONObject1.put(str, localJSONObject2);
          bnrf.E(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localJSONObject1.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新成功，mConfigStr = " + localJSONObject1.toString());
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新失败，error = " + localException.getMessage());
        }
      }
    }
  }
  
  public boolean b()
  {
    if (!d()) {}
    while ((this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int != 0) || (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Boolean) || (!e())) {
      return false;
    }
    c();
    this.jdField_d_of_type_Boolean = true;
    return true;
  }
  
  public boolean c()
  {
    if (!d()) {}
    while ((this.e) || ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Int != 1) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Boolean)) || (!e())) {
      return false;
    }
    c();
    this.e = true;
    this.f = this.g;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqm
 * JD-Core Version:    0.7.0.1
 */