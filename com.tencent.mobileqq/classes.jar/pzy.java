import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdGestureView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class pzy
  extends qah
{
  private qab jdField_a_of_type_Qab;
  
  public pzy(pzs parampzs, qab paramqab)
  {
    super(parampzs, paramqab);
    this.jdField_a_of_type_Qab = paramqab;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d) && (npi.g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (npj.b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = aciy.a(0.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
      this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (aciy.a(15.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources()) - 20);
    this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (pzs.a(this.jdField_a_of_type_Pzs) != null) {
      pzs.a(this.jdField_a_of_type_Pzs).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    pzs.g(this.jdField_a_of_type_Pzs, false);
    pzs.b(this.jdField_a_of_type_Pzs, false);
    b(this.jdField_a_of_type_Qab, paramVideoInfo);
    a(this.jdField_a_of_type_Qab, paramVideoInfo);
    Object localObject8 = pzs.a(this.jdField_a_of_type_Pzs).getResources();
    Object localObject1;
    label267:
    label362:
    Object localObject7;
    label423:
    label611:
    Object localObject9;
    Object localObject10;
    Object localObject11;
    if (paramVideoInfo.jdField_a_of_type_Int != 0) {
      if (this.jdField_a_of_type_Qab.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Qab);
        this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Qab);
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Pzs);
        if (!TextUtils.isEmpty(paramVideoInfo.k))
        {
          this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.k);
          this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(this.jdField_a_of_type_Qab);
          this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
        }
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break label821;
        }
        localObject1 = azwp.a(pzs.a(this.jdField_a_of_type_Pzs), 1, paramVideoInfo.j, 3, pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs));
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(this.jdField_a_of_type_Qab);
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_Pzs);
        npj.a(paramVideoInfo, this.jdField_a_of_type_Qab);
        if (this.jdField_a_of_type_Qab.jdField_a_of_type_Int != 4) {
          break label1045;
        }
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Qab);
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject8).getDisplayMetrics().widthPixels * 0.7D));
        if (TextUtils.isEmpty(paramVideoInfo.c)) {
          break label1003;
        }
        this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject8).getDisplayMetrics().widthPixels * 0.224D));
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
          break label1024;
        }
        this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
        if ((pzs.a(this.jdField_a_of_type_Pzs) == this.jdField_a_of_type_Qab) && (this.jdField_a_of_type_Qab.jdField_a_of_type_Int == 4) && (pzs.a(this.jdField_a_of_type_Pzs)))
        {
          if (this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup != null) {
            this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
          }
          if (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup != null) {
            this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup.setVisibility(8);
          }
        }
        this.jdField_a_of_type_Qab.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
        if (!a(paramVideoInfo)) {
          break label3075;
        }
        qcn.b(paramVideoInfo);
        if (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup != null)
        {
          this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup.setVisibility(0);
          localObject1 = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar;
          localObject8 = ((SeekBar)localObject1).getLayoutParams();
          if ((localObject8 instanceof LinearLayout.LayoutParams))
          {
            localObject7 = (ViewGroup)((SeekBar)localObject1).getParent();
            ((ViewGroup)localObject7).removeView((View)localObject1);
            localObject8 = (LinearLayout.LayoutParams)localObject8;
            if (!npi.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
              break label3051;
            }
            ((LinearLayout.LayoutParams)localObject8).topMargin = 0;
            ((ViewGroup)localObject7).addView((View)localObject1, ((ViewGroup)localObject7).getChildCount() - 2, (ViewGroup.LayoutParams)localObject8);
            localObject1 = this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetTextView;
            localObject7 = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidViewView;
            localObject8 = this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidViewView;
            localObject9 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
            localObject10 = (LinearLayout.LayoutParams)((View)localObject7).getLayoutParams();
            localObject11 = (LinearLayout.LayoutParams)((View)localObject8).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject9).topMargin = aciy.a(14.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
            ((LinearLayout.LayoutParams)localObject10).topMargin = aciy.a(14.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
            ((LinearLayout.LayoutParams)localObject11).topMargin = aciy.a(14.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
            ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject9);
            ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject10);
            ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject11);
          }
          a(this.jdField_a_of_type_Qab, paramVideoInfo);
        }
      }
    }
    label821:
    label972:
    label1003:
    label2810:
    do
    {
      return;
      this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
      this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
      break;
      localObject7 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = aciy.a(40.0F, (Resources)localObject8);
      ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = aciy.a(40.0F, (Resources)localObject8);
      ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = pzs.a(this.jdField_a_of_type_Pzs);
      ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = pzs.a(this.jdField_a_of_type_Pzs);
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.E)) {
            break label972;
          }
          localObject1 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject7);
          ((URLDrawable)localObject1).setDecodeHandler(azue.a);
          this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException localMalformedURLException1) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException1.getMessage());
        break;
        localObject2 = new URL(paramVideoInfo.E);
      }
      this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
      break label267;
      this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setText(((Resources)localObject8).getText(2131652784));
      break label362;
      this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetTextView.setText(((Resources)localObject8).getText(2131652782));
      break label423;
      int i;
      try
      {
        localObject2 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
        if (((JSONObject)localObject2).has("down_time"))
        {
          i = ((JSONObject)localObject2).optInt("down_time") * 1000;
          if (i > 0) {
            this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.setDuration(i);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "has downtime!! down_time=" + i);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          localObject7 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = aciy.a(60.0F, (Resources)localObject8);
          ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = aciy.a(60.0F, (Resources)localObject8);
          ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = pzs.a(this.jdField_a_of_type_Pzs);
          ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = pzs.a(this.jdField_a_of_type_Pzs);
          for (;;)
          {
            try
            {
              if (!TextUtils.isEmpty(paramVideoInfo.E)) {
                break label2810;
              }
              localObject3 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
              localObject3 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject7);
              ((URLDrawable)localObject3).setTag(azue.b(aciy.a(60.0F, (Resources)localObject8), aciy.a(60.0F, (Resources)localObject8), aciy.a(12.0F, (Resources)localObject8)));
              ((URLDrawable)localObject3).setDecodeHandler(azue.i);
              this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            }
            catch (MalformedURLException localMalformedURLException2) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException2.getMessage());
            break;
            localObject4 = new URL(paramVideoInfo.E);
          }
          i = 0;
          localObject4 = localObject7;
        }
      }
      if (this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidWidgetTextView != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#FF00CAFC"));
        this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject2);
        pzs.b(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qab);
      }
      if (this.jdField_a_of_type_Qab.j != null)
      {
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(2.0D));
        ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F6"));
        this.jdField_a_of_type_Qab.j.setBackgroundDrawable((Drawable)localObject2);
      }
      if (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Pzs);
          this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qab);
        }
        this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
        this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qab);
      }
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject2).setColor(Color.parseColor("#ffffff"));
      this.jdField_a_of_type_Qab.p.setBackgroundDrawable((Drawable)localObject2);
      this.jdField_a_of_type_Qab.q.setOnClickListener(this.jdField_a_of_type_Pzs);
      this.jdField_a_of_type_Qab.q.setTag(this.jdField_a_of_type_Qab);
      this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidWidgetTextView.setText(pzs.a(this.jdField_a_of_type_Pzs, paramVideoInfo, (Resources)localObject8));
      this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
      this.jdField_a_of_type_Qab.jdField_m_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
      if (this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.k)) {
          this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
        }
        this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
      }
      if (this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.c)) {
          this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        }
        this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
      }
      int j;
      if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          localObject2 = azwp.a(pzs.a(this.jdField_a_of_type_Pzs), 1, paramVideoInfo.j, 1, pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs));
          this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Pzs);
          this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_Qab);
        }
      }
      else
      {
        this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        pzs.a(this.jdField_a_of_type_Pzs, false, this.jdField_a_of_type_Qab);
        localObject9 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(paramVideoInfo.c))
        {
          ((SpannableStringBuilder)localObject9).append(obz.a(paramVideoInfo.c, 72));
          ((SpannableStringBuilder)localObject9).append("  ");
        }
        localObject7 = ajjy.a(2131650443);
        j = 1;
      }
      try
      {
        localObject10 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
        i = j;
        localObject2 = localObject7;
        if (((JSONObject)localObject10).has("AdsIconText"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "detail ad  video in new style adInconText:" + ((JSONObject)localObject10).optString("AdsIconText"));
          }
          if (TextUtils.isEmpty(((JSONObject)localObject10).optString("AdsIconText"))) {
            break label2826;
          }
          localObject2 = ((JSONObject)localObject10).optString("AdsIconText");
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          float f;
          int k;
          RectF localRectF1;
          RectF localRectF2;
          RectF localRectF3;
          localException.printStackTrace();
          i = j;
          localObject5 = localObject7;
        }
        localObject7 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = aciy.a(70.0F, (Resources)localObject8);
        ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = aciy.a(70.0F, (Resources)localObject8);
        ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = pzs.a(this.jdField_a_of_type_Pzs);
        ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = pzs.a(this.jdField_a_of_type_Pzs);
      }
      if (i != 0)
      {
        localObject7 = new Paint();
        ((Paint)localObject7).setAntiAlias(true);
        ((Paint)localObject7).setStyle(Paint.Style.FILL);
        ((Paint)localObject7).setTextSize(aciy.a(10.0F, (Resources)localObject8));
        ((Paint)localObject7).setColor(-1291845633);
        f = ((Paint)localObject7).measureText((String)localObject2);
        i = aciy.a(6.0F, (Resources)localObject8);
        i = (int)f + i;
        j = aciy.a(1.0F, (Resources)localObject8) / 2;
        k = aciy.a(14.0F, (Resources)localObject8);
        localObject10 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
        localObject11 = new Canvas((Bitmap)localObject10);
        ((Canvas)localObject11).drawText((String)localObject2, aciy.a(3.0F, (Resources)localObject8), k / 2 - (((Paint)localObject7).descent() + ((Paint)localObject7).ascent()) / 2.0F, (Paint)localObject7);
        localObject2 = new RectF(j, k, i - j, k - j);
        localRectF1 = new RectF(j, j, i - j, 0.0F);
        localRectF2 = new RectF(0.0F, k - j, j, j);
        localRectF3 = new RectF(i - j, k - j, i, j);
        ((Canvas)localObject11).drawRect((RectF)localObject2, (Paint)localObject7);
        ((Canvas)localObject11).drawRect(localRectF1, (Paint)localObject7);
        ((Canvas)localObject11).drawRect(localRectF2, (Paint)localObject7);
        ((Canvas)localObject11).drawRect(localRectF3, (Paint)localObject7);
        ((SpannableStringBuilder)localObject9).setSpan(new VerticalCenterImageSpan(pzs.a(this.jdField_a_of_type_Pzs), (Bitmap)localObject10), ((SpannableStringBuilder)localObject9).length() - 1, ((SpannableStringBuilder)localObject9).length(), 33);
        localObject2 = this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView;
        ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), aciy.a(1.0F, (Resources)localObject8));
      }
      this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject9);
      this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
      this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
      if (this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qab.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
      }
      if (this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetImageView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.j))
        {
          localObject2 = azwp.a(pzs.a(this.jdField_a_of_type_Pzs), 1, paramVideoInfo.j, 1, pzs.a(this.jdField_a_of_type_Pzs), pzs.a(this.jdField_a_of_type_Pzs));
          this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Pzs);
          this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_Qab);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Qab.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.k)) {
            this.jdField_a_of_type_Qab.jdField_h_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
          }
          this.jdField_a_of_type_Qab.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Pzs);
          this.jdField_a_of_type_Qab.jdField_h_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qab);
        }
        if (this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidWidgetTextView.setText(ajjy.a(2131650359));
          i = aciy.a(12.0F, (Resources)localObject8);
          localObject2 = ((Resources)localObject8).getDrawable(2130842439);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        if (this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Pzs);
          this.jdField_a_of_type_Qab.jdField_i_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qab);
        }
        if (this.jdField_a_of_type_Qab.j == null) {
          break label423;
        }
        this.jdField_a_of_type_Qab.j.setOnClickListener(this.jdField_a_of_type_Pzs);
        this.jdField_a_of_type_Qab.j.setTag(this.jdField_a_of_type_Qab);
        break label423;
      }
      Object localObject6;
      for (;;)
      {
        try
        {
          Object localObject3;
          Object localObject4;
          if (!TextUtils.isEmpty(paramVideoInfo.E)) {
            break label3035;
          }
          Object localObject5 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
          localObject5 = URLDrawable.getDrawable((URL)localObject5, (URLDrawable.URLDrawableOptions)localObject7);
          ((URLDrawable)localObject5).setTag(azue.b(aciy.a(70.0F, (Resources)localObject8), aciy.a(70.0F, (Resources)localObject8), aciy.a(11.0F, (Resources)localObject8)));
          ((URLDrawable)localObject5).setDecodeHandler(azue.i);
          this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject5);
        }
        catch (MalformedURLException localMalformedURLException3) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException3.getMessage());
        break;
        localObject6 = new URL(paramVideoInfo.E);
      }
      ((LinearLayout.LayoutParams)localObject8).topMargin = aciy.a(7.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
      break label611;
      paramVideoInfo = this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar;
      localObject7 = paramVideoInfo.getLayoutParams();
      if ((localObject7 instanceof LinearLayout.LayoutParams))
      {
        localObject6 = (ViewGroup)paramVideoInfo.getParent();
        ((ViewGroup)localObject6).removeView(paramVideoInfo);
        localObject7 = (LinearLayout.LayoutParams)localObject7;
        ((LinearLayout.LayoutParams)localObject7).topMargin = aciy.a(14.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
        ((ViewGroup)localObject6).addView(paramVideoInfo, 3, (ViewGroup.LayoutParams)localObject7);
        paramVideoInfo = this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetTextView;
        localObject6 = this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidViewView;
        localObject7 = this.jdField_a_of_type_Qab.jdField_c_of_type_AndroidViewView;
        localObject8 = (LinearLayout.LayoutParams)paramVideoInfo.getLayoutParams();
        localObject9 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
        localObject10 = (LinearLayout.LayoutParams)((View)localObject7).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject8).topMargin = aciy.a(0.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
        ((LinearLayout.LayoutParams)localObject9).topMargin = aciy.a(7.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
        ((LinearLayout.LayoutParams)localObject10).topMargin = aciy.a(15.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
        paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject8);
        ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject9);
        ((View)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject10);
      }
    } while (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup == null);
    label1024:
    label1045:
    label3035:
    label3051:
    this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewViewGroup.setVisibility(8);
    label2826:
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    pzs.g(this.jdField_a_of_type_Pzs, false);
    if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qab);
      localObject = new GestureDetector(new pzz(this));
      this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setOnTouchListener(new qaa(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    pzs.a(this.jdField_a_of_type_Pzs, false, this.jdField_a_of_type_Qab);
    if (paramVideoInfo.b(pzs.a(this.jdField_a_of_type_Pzs))) {
      this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (paramVideoInfo.a() == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
    paramVideoInfo.setDecodeHandler(azue.w);
    paramVideoInfo.setAlpha(80);
    this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
  }
  
  public void a(qab paramqab, VideoInfo paramVideoInfo)
  {
    if ((paramqab == null) || (paramqab.jdField_b_of_type_AndroidViewViewGroup == null) || (pzs.a(this.jdField_a_of_type_Pzs) == null) || (paramVideoInfo == null)) {}
    int[] arrayOfInt;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        arrayOfInt = qcn.b(pzs.a(this.jdField_a_of_type_Pzs));
      } while (!(paramqab instanceof qab));
      paramqab = paramqab.jdField_b_of_type_AndroidViewViewGroup;
      localLayoutParams = (RelativeLayout.LayoutParams)paramqab.getLayoutParams();
    } while ((!paramVideoInfo.b(pzs.a(this.jdField_a_of_type_Pzs))) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F) || (localLayoutParams == null));
    if (pzs.d(this.jdField_a_of_type_Pzs) != 0) {
      localLayoutParams.topMargin = pzs.d(this.jdField_a_of_type_Pzs);
    }
    if (pzs.e(this.jdField_a_of_type_Pzs) != 0) {
      localLayoutParams.bottomMargin = pzs.e(this.jdField_a_of_type_Pzs);
    }
    paramqab.setLayoutParams(localLayoutParams);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void b(qab paramqab, VideoInfo paramVideoInfo)
  {
    if (paramqab == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramqab = paramqab.jdField_o_of_type_AndroidViewViewGroup;
        if ((pzs.e(this.jdField_a_of_type_Pzs) == 0) && (paramqab != null) && (paramqab.getLayoutParams() != null)) {
          pzs.b(this.jdField_a_of_type_Pzs, paramqab.getLayoutParams().height);
        }
      }
      while ((pzs.d(this.jdField_a_of_type_Pzs) == 0) && (pzs.a(this.jdField_a_of_type_Pzs) != null) && ((pzs.a(this.jdField_a_of_type_Pzs) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)pzs.a(this.jdField_a_of_type_Pzs)).a() != null))
      {
        pzs.c(this.jdField_a_of_type_Pzs, ((VideoFeedsPlayActivity)pzs.a(this.jdField_a_of_type_Pzs)).a().getMeasuredHeight());
        return;
        paramqab = paramqab.jdField_d_of_type_AndroidWidgetTextView;
        if ((pzs.e(this.jdField_a_of_type_Pzs) == 0) && (paramqab != null) && (paramqab.getLayoutParams() != null)) {
          pzs.b(this.jdField_a_of_type_Pzs, paramqab.getLayoutParams().height);
        }
      }
    }
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((pzs.i(this.jdField_a_of_type_Pzs)) && (!pzs.h(this.jdField_a_of_type_Pzs)))
    {
      if (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        pzs.i(this.jdField_a_of_type_Pzs, bool1);
        h(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      h(bool1);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    h(false);
    if (((this.jdField_a_of_type_Qab.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Qab.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      pzs.a(this.jdField_a_of_type_Pzs, false, this.jdField_a_of_type_Qab);
      if (this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Qab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      pzs.j(this.jdField_a_of_type_Pzs, true);
      pzs.g(this.jdField_a_of_type_Pzs, true);
      if (!paramBoolean) {
        break label146;
      }
      if (!this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a.b(pzs.a(this.jdField_a_of_type_Pzs)))
      {
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qcn.b(pzs.a(this.jdField_a_of_type_Pzs)));
        k(true);
      }
      if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label146:
    label235:
    do
    {
      do
      {
        return;
        pzs.j(this.jdField_a_of_type_Pzs, false);
        pzs.g(this.jdField_a_of_type_Pzs, false);
        break;
        if (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a.b(pzs.a(this.jdField_a_of_type_Pzs))) {
          break label235;
        }
        this.jdField_a_of_type_Qab.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        k(false);
      } while ((this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Qab != null) && (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a != null)) {
      this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidWidgetTextView.setText(pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qab.jdField_a_of_type_Qeq.a, pzs.a(this.jdField_a_of_type_Pzs).getResources()));
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView != null)
    {
      boolean bool;
      if (!paramBoolean) {
        if ((pzs.i(this.jdField_a_of_type_Pzs)) && (!pzs.h(this.jdField_a_of_type_Pzs)))
        {
          if ((this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.getVisibility() == 8) && (!pzs.b(this.jdField_a_of_type_Pzs)))
          {
            if (this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView != null)
            {
              pzs.a(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_Qab);
              this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView.setVisibility(0);
            }
            qcn.a(this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (pzs.b(this.jdField_a_of_type_Pzs))
          {
            if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label148;
            }
            bool = true;
            this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        super.h(bool);
        return;
        label148:
        bool = paramBoolean;
        if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
        {
          this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          bool = paramBoolean;
          continue;
          if ((this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.getVisibility() == 8) && (!pzs.b(this.jdField_a_of_type_Pzs))) {
            qcn.a(this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
            bool = paramBoolean;
            continue;
            if ((pzs.i(this.jdField_a_of_type_Pzs)) && (!pzs.h(this.jdField_a_of_type_Pzs)))
            {
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView.getVisibility() == 0)
              {
                if (this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView != null) {
                  this.jdField_a_of_type_Qab.jdField_k_of_type_AndroidViewView.setVisibility(8);
                }
                qcn.a(this.jdField_a_of_type_Qab.jdField_o_of_type_AndroidViewView, 8);
                bool = paramBoolean;
              }
            }
            else
            {
              if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
                qcn.a(this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewView, 8);
              }
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
              {
                this.jdField_a_of_type_Qab.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
                bool = paramBoolean;
              }
            }
          }
        }
      }
    }
    super.h(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qab.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pzy
 * JD-Core Version:    0.7.0.1
 */