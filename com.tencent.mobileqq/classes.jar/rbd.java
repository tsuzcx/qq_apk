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
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
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
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class rbd
  extends rbo
{
  private rbi jdField_a_of_type_Rbi;
  
  public rbd(raw paramraw, rbi paramrbi)
  {
    super(paramraw, paramrbi);
    this.jdField_a_of_type_Rbi = paramrbi;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d) && (oed.g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (oee.b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = aepi.a(0.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
      this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (aepi.a(15.0F, raw.a(this.jdField_a_of_type_Raw).getResources()) - 20);
    this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (raw.a(this.jdField_a_of_type_Raw) != null) {
      raw.a(this.jdField_a_of_type_Raw).a(paramInt1, paramInt2);
    }
    if (paramBoolean) {
      d();
    }
  }
  
  public void a(ImageView paramImageView, VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (!TextUtils.isEmpty(paramVideoInfo.j))
      {
        paramImageView.setImageDrawable(bdbk.a(raw.a(this.jdField_a_of_type_Raw), 1, paramVideoInfo.j, 1, raw.a(this.jdField_a_of_type_Raw), raw.a(this.jdField_a_of_type_Raw)));
        paramImageView.setOnClickListener(this.jdField_a_of_type_Raw);
        paramImageView.setTag(this.jdField_a_of_type_Rbi);
      }
    }
    else {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = aepi.a(paramInt1, raw.a(this.jdField_a_of_type_Raw).getResources());
    localURLDrawableOptions.mRequestHeight = aepi.a(paramInt1, raw.a(this.jdField_a_of_type_Raw).getResources());
    localURLDrawableOptions.mLoadingDrawable = raw.a(this.jdField_a_of_type_Raw);
    localURLDrawableOptions.mFailedDrawable = raw.a(this.jdField_a_of_type_Raw);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramVideoInfo.n)) {
          break label369;
        }
        localObject1 = new URL("http://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        Object localObject2 = localObject1;
        if (raw.b(paramVideoInfo))
        {
          String str = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.E;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(str)) {
            localObject2 = new URL(str);
          }
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject1).setTag(bcyz.b(aepi.a(paramInt1, raw.a(this.jdField_a_of_type_Raw).getResources()), aepi.a(paramInt1, raw.a(this.jdField_a_of_type_Raw).getResources()), aepi.a(paramInt2, raw.a(this.jdField_a_of_type_Raw).getResources())));
        if ((!raw.b(paramVideoInfo)) || (this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetImageView != paramImageView)) {
          break label385;
        }
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, paramInt2, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bcyz.j);
        paramImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException paramVideoInfo) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + paramVideoInfo.getMessage());
      break;
      label369:
      Object localObject1 = new URL(paramVideoInfo.n);
      continue;
      label385:
      ((URLDrawable)localObject1).setDecodeHandler(bcyz.i);
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    raw.g(this.jdField_a_of_type_Raw, false);
    raw.b(this.jdField_a_of_type_Raw, false);
    b(this.jdField_a_of_type_Rbi, paramVideoInfo);
    a(this.jdField_a_of_type_Rbi, paramVideoInfo);
    Object localObject5 = raw.a(this.jdField_a_of_type_Raw).getResources();
    if (paramVideoInfo.jdField_a_of_type_Int != 0) {
      if (this.jdField_a_of_type_Rbi.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Raw);
        if (!TextUtils.isEmpty(paramVideoInfo.k))
        {
          this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.k);
          this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(this.jdField_a_of_type_Rbi);
          this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this.jdField_a_of_type_Raw);
        }
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(raw.a(this.jdField_a_of_type_Raw));
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break label899;
        }
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(Long.valueOf(paramVideoInfo.j).longValue(), false);
        label234:
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_Raw);
        label262:
        oee.a(paramVideoInfo, this.jdField_a_of_type_Rbi);
        if (this.jdField_a_of_type_Rbi.jdField_a_of_type_Int != 4) {
          break label983;
        }
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject5).getDisplayMetrics().widthPixels * 0.7D));
        if (TextUtils.isEmpty(paramVideoInfo.c)) {
          break label941;
        }
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        label357:
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject5).getDisplayMetrics().widthPixels * 0.224D));
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
          break label962;
        }
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
      }
    }
    Object localObject4;
    label606:
    Object localObject6;
    Object localObject7;
    Object localObject8;
    for (;;)
    {
      if ((raw.a(this.jdField_a_of_type_Raw) == this.jdField_a_of_type_Rbi) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_Int == 4) && (raw.a(this.jdField_a_of_type_Raw)))
      {
        if (this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
        }
        if (this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Rbi.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      if (!a(paramVideoInfo)) {
        break label3365;
      }
      rdm.b(paramVideoInfo);
      if (this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar;
        localObject5 = ((SeekBar)localObject1).getLayoutParams();
        if ((localObject5 instanceof LinearLayout.LayoutParams))
        {
          localObject4 = (ViewGroup)((SeekBar)localObject1).getParent();
          ((ViewGroup)localObject4).removeView((View)localObject1);
          localObject5 = (LinearLayout.LayoutParams)localObject5;
          if (!oed.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
            break label3341;
          }
          ((LinearLayout.LayoutParams)localObject5).topMargin = 0;
          ((ViewGroup)localObject4).addView((View)localObject1, ((ViewGroup)localObject4).getChildCount() - 2, (ViewGroup.LayoutParams)localObject5);
          localObject1 = this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetTextView;
          localObject4 = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewView;
          localObject5 = this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidViewView;
          localObject6 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
          localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject6).topMargin = aepi.a(14.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
          ((LinearLayout.LayoutParams)localObject7).topMargin = aepi.a(14.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
          ((LinearLayout.LayoutParams)localObject8).topMargin = aepi.a(14.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
          ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
        }
        a(this.jdField_a_of_type_Rbi, paramVideoInfo);
      }
      label772:
      if (oed.a())
      {
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
        paramVideoInfo = this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
        if ((paramVideoInfo instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramVideoInfo).leftMargin = aepi.a(15.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
        }
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
      break;
      label899:
      if (TextUtils.isEmpty(paramVideoInfo.n)) {
        break label234;
      }
      this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageSrc(paramVideoInfo.n);
      break label234;
      this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
      break label262;
      label941:
      this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setText(((Resources)localObject5).getText(2131719093));
      break label357;
      label962:
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetTextView.setText(((Resources)localObject5).getText(2131719091));
    }
    label983:
    int i;
    try
    {
      localObject1 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
      if (((JSONObject)localObject1).has("down_time"))
      {
        i = ((JSONObject)localObject1).optInt("down_time") * 1000;
        if (i > 0) {
          this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.setDuration(i);
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
        label1642:
        localJSONException.printStackTrace();
        continue;
        this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setText(raw.a(this.jdField_a_of_type_Raw, paramVideoInfo, (Resources)localObject5));
        continue;
        label1888:
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Rbi.jdField_q_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H);
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Raw);
      }
      label1947:
      if ((this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidWidgetTextView == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F))) {
        break label2022;
      }
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
      label2022:
      if (!raw.b(paramVideoInfo)) {
        break label2193;
      }
      this.jdField_a_of_type_Rbi.s.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Rbi.t.setText(raw.a(this.jdField_a_of_type_Raw, paramVideoInfo, 1));
      a(this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetImageView, paramVideoInfo, 32, 6);
      this.jdField_a_of_type_Rbi.s.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.s.setTag(this.jdField_a_of_type_Rbi);
      this.jdField_a_of_type_Rbi.t.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.t.setTag(this.jdField_a_of_type_Rbi);
      this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_Rbi);
      this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Rbi);
      label2193:
      if (!raw.b(paramVideoInfo)) {
        break label3246;
      }
    }
    if (this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView != null)
    {
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#FF00CAFC"));
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject1);
      raw.b(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbi);
    }
    if (this.jdField_a_of_type_Rbi.j != null)
    {
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject1).setColor(Color.parseColor("#12B7F6"));
      this.jdField_a_of_type_Rbi.j.setBackgroundDrawable((Drawable)localObject1);
    }
    if (this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rbi);
      }
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rbi);
    }
    Object localObject1 = new GradientDrawable();
    ((GradientDrawable)localObject1).setCornerRadius(Utils.dp2px(6.0D));
    ((GradientDrawable)localObject1).setColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_Rbi.p.setBackgroundDrawable((Drawable)localObject1);
    this.jdField_a_of_type_Rbi.jdField_q_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Raw);
    this.jdField_a_of_type_Rbi.jdField_q_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rbi);
    int j;
    int k;
    if (raw.b(paramVideoInfo))
    {
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setText(raw.a(this.jdField_a_of_type_Raw, paramVideoInfo, 2));
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
        break label2022;
      }
      if (this.jdField_a_of_type_Rbi.r != null)
      {
        this.jdField_a_of_type_Rbi.r.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.G);
        this.jdField_a_of_type_Rbi.r.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.r.setOnClickListener(this.jdField_a_of_type_Raw);
      }
      if (this.jdField_a_of_type_Rbi.jdField_q_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H)) {
          break label1888;
        }
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).setMargins(0, ((LinearLayout.LayoutParams)localObject1).topMargin, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.size() <= 0) || (this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetLinearLayout == null)) {
        break label1947;
      }
      this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      i = this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetLinearLayout.getWidth();
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject6 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject6).rightMargin = aepi.a(6.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
          localObject7 = new TextView(raw.a(this.jdField_a_of_type_Raw));
          ((TextView)localObject7).setTextSize(10.0F);
          ((TextView)localObject7).setTextColor(Color.parseColor("#737373"));
          ((TextView)localObject7).setIncludeFontPadding(false);
          ((TextView)localObject7).setBackgroundResource(2130848829);
          ((TextView)localObject7).setText((CharSequence)localObject4);
          ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject6);
          ((TextView)localObject7).setOnClickListener(new rbg(this, paramVideoInfo));
          j = ors.a(raw.a(this.jdField_a_of_type_Raw))[0];
          k = aepi.a(125.0F, (Resources)localObject5);
          int m = (int)((TextView)localObject7).getPaint().measureText((String)localObject4);
          if (i + m >= j - k) {
            break label3636;
          }
          this.jdField_a_of_type_Rbi.jdField_e_of_type_AndroidWidgetLinearLayout.addView((View)localObject7);
          i = m + i + 6;
        }
      }
    }
    label2223:
    label3636:
    for (;;)
    {
      break label1642;
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.k)) {
          this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
        }
        this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
      }
      if (this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.c)) {
          this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        }
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
      }
      i = 12;
      if (raw.b(paramVideoInfo)) {
        i = 2;
      }
      a(this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, 60, i);
      this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      raw.a(this.jdField_a_of_type_Raw, false, this.jdField_a_of_type_Rbi);
      localObject6 = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(paramVideoInfo.c))
      {
        ((SpannableStringBuilder)localObject6).append(ors.a(paramVideoInfo.c, 72));
        ((SpannableStringBuilder)localObject6).append("  ");
      }
      localObject4 = alud.a(2131716629);
      j = 1;
      for (;;)
      {
        try
        {
          localObject7 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
          i = j;
          localObject2 = localObject4;
          if (((JSONObject)localObject7).has("AdsIconText"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "detail ad  video in new style adInconText:" + ((JSONObject)localObject7).optString("AdsIconText"));
            }
            if (TextUtils.isEmpty(((JSONObject)localObject7).optString("AdsIconText"))) {
              continue;
            }
            localObject2 = ((JSONObject)localObject7).optString("AdsIconText");
            i = j;
          }
        }
        catch (Exception localException)
        {
          Object localObject2;
          float f;
          RectF localRectF1;
          RectF localRectF2;
          RectF localRectF3;
          localException.printStackTrace();
          i = j;
          localObject3 = localObject4;
          continue;
          localObject3 = new RectF(0.0F, j, i, k - j);
          ((Paint)localObject4).setColor(452984831);
          ((Canvas)localObject8).drawRoundRect((RectF)localObject3, 2.0F, 2.0F, (Paint)localObject4);
          continue;
        }
        if (i != 0)
        {
          localObject4 = new Paint();
          ((Paint)localObject4).setAntiAlias(true);
          ((Paint)localObject4).setStyle(Paint.Style.FILL);
          ((Paint)localObject4).setTextSize(aepi.a(10.0F, (Resources)localObject5));
          ((Paint)localObject4).setColor(-1291845633);
          f = ((Paint)localObject4).measureText((String)localObject2);
          i = aepi.a(6.0F, (Resources)localObject5);
          i = (int)f + i;
          j = aepi.a(1.0F, (Resources)localObject5) / 2;
          k = aepi.a(14.0F, (Resources)localObject5);
          localObject7 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
          localObject8 = new Canvas((Bitmap)localObject7);
          ((Canvas)localObject8).drawText((String)localObject2, aepi.a(3.0F, (Resources)localObject5), k / 2 - (((Paint)localObject4).descent() + ((Paint)localObject4).ascent()) / 2.0F, (Paint)localObject4);
          if (oed.a()) {
            continue;
          }
          localObject2 = new RectF(j, k, i - j, k - j);
          localRectF1 = new RectF(j, j, i - j, 0.0F);
          localRectF2 = new RectF(0.0F, k - j, j, j);
          localRectF3 = new RectF(i - j, k - j, i, j);
          ((Canvas)localObject8).drawRect((RectF)localObject2, (Paint)localObject4);
          ((Canvas)localObject8).drawRect(localRectF1, (Paint)localObject4);
          ((Canvas)localObject8).drawRect(localRectF2, (Paint)localObject4);
          ((Canvas)localObject8).drawRect(localRectF3, (Paint)localObject4);
          ((SpannableStringBuilder)localObject6).setSpan(new VerticalCenterImageSpan(raw.a(this.jdField_a_of_type_Raw), (Bitmap)localObject7), ((SpannableStringBuilder)localObject6).length() - 1, ((SpannableStringBuilder)localObject6).length(), 33);
          ((SpannableStringBuilder)localObject6).setSpan(new rbh(this), ((SpannableStringBuilder)localObject6).length() - 1, ((SpannableStringBuilder)localObject6).length(), 33);
          localObject2 = this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView;
          ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), aepi.a(1.0F, (Resources)localObject5));
        }
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject6);
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
        if (this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Rbi.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
        }
        a(this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, 70, 11);
        if (this.jdField_a_of_type_Rbi.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.k)) {
            this.jdField_a_of_type_Rbi.jdField_h_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
          }
          this.jdField_a_of_type_Rbi.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Raw);
          this.jdField_a_of_type_Rbi.jdField_h_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Rbi);
        }
        if (this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidWidgetTextView.setText(alud.a(2131716545));
          i = aepi.a(12.0F, (Resources)localObject5);
          localObject2 = ((Resources)localObject5).getDrawable(2130842704);
          ((Drawable)localObject2).setBounds(0, 0, i, i);
          this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        if (this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Raw);
          this.jdField_a_of_type_Rbi.jdField_i_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rbi);
        }
        if (this.jdField_a_of_type_Rbi.j == null) {
          break;
        }
        this.jdField_a_of_type_Rbi.j.setOnClickListener(this.jdField_a_of_type_Raw);
        this.jdField_a_of_type_Rbi.j.setTag(this.jdField_a_of_type_Rbi);
        break;
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break label2223;
        i = 0;
        localObject2 = localObject4;
      }
      ((LinearLayout.LayoutParams)localObject5).topMargin = aepi.a(7.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
      break label606;
      Object localObject3 = this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar;
      localObject5 = ((SeekBar)localObject3).getLayoutParams();
      if ((localObject5 instanceof LinearLayout.LayoutParams))
      {
        localObject4 = (ViewGroup)((SeekBar)localObject3).getParent();
        ((ViewGroup)localObject4).removeView((View)localObject3);
        localObject5 = (LinearLayout.LayoutParams)localObject5;
        i = 3;
        if (raw.b(paramVideoInfo))
        {
          i = 4;
          ((LinearLayout.LayoutParams)localObject5).bottomMargin = aepi.a(0.5F, raw.a(this.jdField_a_of_type_Raw).getResources());
        }
        ((LinearLayout.LayoutParams)localObject5).topMargin = aepi.a(10, raw.a(this.jdField_a_of_type_Raw).getResources());
        ((ViewGroup)localObject4).addView((View)localObject3, i, (ViewGroup.LayoutParams)localObject5);
        paramVideoInfo = this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetTextView;
        localObject3 = this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewView;
        localObject4 = this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidViewView;
        localObject5 = (LinearLayout.LayoutParams)paramVideoInfo.getLayoutParams();
        localObject6 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject5).topMargin = aepi.a(0.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
        ((LinearLayout.LayoutParams)localObject6).topMargin = aepi.a(7.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
        ((LinearLayout.LayoutParams)localObject7).topMargin = aepi.a(15.0F, raw.a(this.jdField_a_of_type_Raw).getResources());
        paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      }
      if (this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup == null) {
        break label772;
      }
      this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidViewViewGroup.setVisibility(8);
      break label772;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    raw.g(this.jdField_a_of_type_Raw, false);
    if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Rbi);
      localObject = new GestureDetector(new rbe(this));
      this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setOnTouchListener(new rbf(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    raw.a(this.jdField_a_of_type_Raw, false, this.jdField_a_of_type_Rbi);
    if (paramVideoInfo.b(raw.a(this.jdField_a_of_type_Raw))) {
      this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (paramVideoInfo.a() == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
    paramVideoInfo.setDecodeHandler(bcyz.w);
    paramVideoInfo.setAlpha(80);
    this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
  }
  
  public void a(rbi paramrbi, VideoInfo paramVideoInfo)
  {
    if ((paramrbi == null) || (paramrbi.jdField_b_of_type_AndroidViewViewGroup == null) || (raw.a(this.jdField_a_of_type_Raw) == null) || (paramVideoInfo == null)) {}
    int[] arrayOfInt;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        arrayOfInt = rdm.b(raw.a(this.jdField_a_of_type_Raw));
      } while (!(paramrbi instanceof rbi));
      paramrbi = paramrbi.jdField_b_of_type_AndroidViewViewGroup;
      localLayoutParams = (RelativeLayout.LayoutParams)paramrbi.getLayoutParams();
    } while ((!paramVideoInfo.b(raw.a(this.jdField_a_of_type_Raw))) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F) || (localLayoutParams == null));
    if (raw.c(this.jdField_a_of_type_Raw) != 0) {
      localLayoutParams.topMargin = raw.c(this.jdField_a_of_type_Raw);
    }
    if (raw.d(this.jdField_a_of_type_Raw) != 0) {
      localLayoutParams.bottomMargin = raw.d(this.jdField_a_of_type_Raw);
    }
    paramrbi.setLayoutParams(localLayoutParams);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void b(rbi paramrbi, VideoInfo paramVideoInfo)
  {
    if (paramrbi == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramrbi = paramrbi.jdField_m_of_type_AndroidViewViewGroup;
        if ((raw.d(this.jdField_a_of_type_Raw) == 0) && (paramrbi != null) && (paramrbi.getLayoutParams() != null)) {
          raw.b(this.jdField_a_of_type_Raw, paramrbi.getLayoutParams().height);
        }
      }
      while ((raw.c(this.jdField_a_of_type_Raw) == 0) && (raw.a(this.jdField_a_of_type_Raw) != null) && ((raw.a(this.jdField_a_of_type_Raw) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)raw.a(this.jdField_a_of_type_Raw)).a() != null))
      {
        raw.c(this.jdField_a_of_type_Raw, ((VideoFeedsPlayActivity)raw.a(this.jdField_a_of_type_Raw)).a().getMeasuredHeight());
        return;
        paramrbi = paramrbi.jdField_d_of_type_AndroidWidgetTextView;
        if ((raw.d(this.jdField_a_of_type_Raw) == 0) && (paramrbi != null) && (paramrbi.getLayoutParams() != null)) {
          raw.b(this.jdField_a_of_type_Raw, paramrbi.getLayoutParams().height);
        }
      }
    }
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((raw.j(this.jdField_a_of_type_Raw)) && (!raw.i(this.jdField_a_of_type_Raw)))
    {
      if (this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        raw.i(this.jdField_a_of_type_Raw, bool1);
        h(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      h(bool1);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    h(false);
    if (((this.jdField_a_of_type_Rbi.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Rbi.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      raw.a(this.jdField_a_of_type_Raw, false, this.jdField_a_of_type_Rbi);
      if (this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      raw.k(this.jdField_a_of_type_Raw, true);
      raw.g(this.jdField_a_of_type_Raw, true);
      if (!paramBoolean) {
        break label146;
      }
      if (!this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a.b(raw.a(this.jdField_a_of_type_Raw)))
      {
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, rdm.b(raw.a(this.jdField_a_of_type_Raw)));
        k(true);
      }
      if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label146:
    label235:
    do
    {
      do
      {
        return;
        raw.k(this.jdField_a_of_type_Raw, false);
        raw.g(this.jdField_a_of_type_Raw, false);
        break;
        if (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a.b(raw.a(this.jdField_a_of_type_Raw))) {
          break label235;
        }
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        k(false);
      } while ((this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rbi != null) && (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a != null))
    {
      if (raw.b(this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a))
      {
        this.jdField_a_of_type_Rbi.t.setText(raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a, 1));
        this.jdField_a_of_type_Rbi.jdField_m_of_type_AndroidWidgetTextView.setText(raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a, 2));
        this.jdField_a_of_type_Rbi.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Rbi.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidWidgetTextView.setText(raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbi.jdField_a_of_type_Rfs.a, raw.a(this.jdField_a_of_type_Raw).getResources()));
  }
  
  public void e(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView != null)
    {
      boolean bool;
      if (!paramBoolean) {
        if ((raw.j(this.jdField_a_of_type_Raw)) && (!raw.i(this.jdField_a_of_type_Raw)))
        {
          if ((this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.getVisibility() == 8) && (!raw.b(this.jdField_a_of_type_Raw)))
          {
            if (this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView != null)
            {
              raw.a(this.jdField_a_of_type_Raw, this.jdField_a_of_type_Rbi);
              this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView.setVisibility(0);
            }
            rdm.a(this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (raw.b(this.jdField_a_of_type_Raw))
          {
            if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label148;
            }
            bool = true;
            this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        super.h(bool);
        return;
        label148:
        bool = paramBoolean;
        if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
        {
          this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          bool = paramBoolean;
          continue;
          if ((this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.getVisibility() == 8) && (!raw.b(this.jdField_a_of_type_Raw))) {
            rdm.a(this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
            bool = paramBoolean;
            continue;
            if ((raw.j(this.jdField_a_of_type_Raw)) && (!raw.i(this.jdField_a_of_type_Raw)))
            {
              bool = paramBoolean;
              if (this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView.getVisibility() == 0)
              {
                if (this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView != null) {
                  this.jdField_a_of_type_Rbi.jdField_k_of_type_AndroidViewView.setVisibility(8);
                }
                rdm.a(this.jdField_a_of_type_Rbi.jdField_o_of_type_AndroidViewView, 8);
                bool = paramBoolean;
              }
            }
            else
            {
              if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
                rdm.a(this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewView, 8);
              }
              bool = paramBoolean;
              if (this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
              {
                this.jdField_a_of_type_Rbi.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
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
      this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Rbi.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbd
 * JD-Core Version:    0.7.0.1
 */