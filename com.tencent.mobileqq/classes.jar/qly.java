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

public class qly
  extends qmj
{
  private qmd jdField_a_of_type_Qmd;
  
  public qly(qls paramqls, qmd paramqmd)
  {
    super(paramqls, paramqmd);
    this.jdField_a_of_type_Qmd = paramqmd;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d) && (oat.g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (oau.b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = actn.a(0.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
      this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (actn.a(15.0F, qls.a(this.jdField_a_of_type_Qls).getResources()) - 20);
    this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (qls.a(this.jdField_a_of_type_Qls) != null) {
      qls.a(this.jdField_a_of_type_Qls).a(paramInt1, paramInt2);
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
        paramImageView.setImageDrawable(baxt.a(qls.a(this.jdField_a_of_type_Qls), 1, paramVideoInfo.j, 1, qls.a(this.jdField_a_of_type_Qls), qls.a(this.jdField_a_of_type_Qls)));
        paramImageView.setOnClickListener(this.jdField_a_of_type_Qls);
        paramImageView.setTag(this.jdField_a_of_type_Qmd);
      }
    }
    else {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = actn.a(paramInt1, qls.a(this.jdField_a_of_type_Qls).getResources());
    localURLDrawableOptions.mRequestHeight = actn.a(paramInt1, qls.a(this.jdField_a_of_type_Qls).getResources());
    localURLDrawableOptions.mLoadingDrawable = qls.a(this.jdField_a_of_type_Qls);
    localURLDrawableOptions.mFailedDrawable = qls.a(this.jdField_a_of_type_Qls);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramVideoInfo.E)) {
          break label369;
        }
        localObject1 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
        Object localObject2 = localObject1;
        if (qls.b(paramVideoInfo))
        {
          String str = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.E;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(str)) {
            localObject2 = new URL(str);
          }
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject1).setTag(bavi.b(actn.a(paramInt1, qls.a(this.jdField_a_of_type_Qls).getResources()), actn.a(paramInt1, qls.a(this.jdField_a_of_type_Qls).getResources()), actn.a(paramInt2, qls.a(this.jdField_a_of_type_Qls).getResources())));
        if ((!qls.b(paramVideoInfo)) || (this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetImageView != paramImageView)) {
          break label385;
        }
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, paramInt2, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bavi.j);
        paramImageView.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException paramVideoInfo) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + paramVideoInfo.getMessage());
      break;
      label369:
      Object localObject1 = new URL(paramVideoInfo.E);
      continue;
      label385:
      ((URLDrawable)localObject1).setDecodeHandler(bavi.i);
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    qls.g(this.jdField_a_of_type_Qls, false);
    qls.b(this.jdField_a_of_type_Qls, false);
    b(this.jdField_a_of_type_Qmd, paramVideoInfo);
    a(this.jdField_a_of_type_Qmd, paramVideoInfo);
    Object localObject6 = qls.a(this.jdField_a_of_type_Qls).getResources();
    Object localObject1;
    if (paramVideoInfo.jdField_a_of_type_Int != 0) {
      if (this.jdField_a_of_type_Qmd.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Qls);
        if (!TextUtils.isEmpty(paramVideoInfo.k))
        {
          this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.k);
          this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(this.jdField_a_of_type_Qmd);
          this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this.jdField_a_of_type_Qls);
        }
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break label904;
        }
        localObject1 = baxt.a(qls.a(this.jdField_a_of_type_Qls), 1, paramVideoInfo.j, 3, qls.a(this.jdField_a_of_type_Qls), qls.a(this.jdField_a_of_type_Qls));
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_Qls);
        label267:
        oau.a(paramVideoInfo, this.jdField_a_of_type_Qmd);
        if (this.jdField_a_of_type_Qmd.jdField_a_of_type_Int != 4) {
          break label1125;
        }
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject6).getDisplayMetrics().widthPixels * 0.7D));
        if (TextUtils.isEmpty(paramVideoInfo.c)) {
          break label1083;
        }
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        label362:
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject6).getDisplayMetrics().widthPixels * 0.224D));
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
          break label1104;
        }
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
      }
    }
    Object localObject5;
    label611:
    Object localObject7;
    Object localObject8;
    Object localObject9;
    for (;;)
    {
      if ((qls.a(this.jdField_a_of_type_Qls) == this.jdField_a_of_type_Qmd) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Int == 4) && (qls.a(this.jdField_a_of_type_Qls)))
      {
        if (this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
        }
        if (this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Qmd.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      if (!a(paramVideoInfo)) {
        break label3507;
      }
      qol.b(paramVideoInfo);
      if (this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar;
        localObject6 = ((SeekBar)localObject1).getLayoutParams();
        if ((localObject6 instanceof LinearLayout.LayoutParams))
        {
          localObject5 = (ViewGroup)((SeekBar)localObject1).getParent();
          ((ViewGroup)localObject5).removeView((View)localObject1);
          localObject6 = (LinearLayout.LayoutParams)localObject6;
          if (!oat.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
            break label3483;
          }
          ((LinearLayout.LayoutParams)localObject6).topMargin = 0;
          ((ViewGroup)localObject5).addView((View)localObject1, ((ViewGroup)localObject5).getChildCount() - 2, (ViewGroup.LayoutParams)localObject6);
          localObject1 = this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetTextView;
          localObject5 = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewView;
          localObject6 = this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidViewView;
          localObject7 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
          localObject9 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject7).topMargin = actn.a(14.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
          ((LinearLayout.LayoutParams)localObject8).topMargin = actn.a(14.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
          ((LinearLayout.LayoutParams)localObject9).topMargin = actn.a(14.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
          ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject9);
        }
        a(this.jdField_a_of_type_Qmd, paramVideoInfo);
      }
      label777:
      if (oat.a())
      {
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
        paramVideoInfo = this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
        if ((paramVideoInfo instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramVideoInfo).leftMargin = actn.a(15.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
        }
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
      break;
      label904:
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = actn.a(40.0F, (Resources)localObject6);
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = actn.a(40.0F, (Resources)localObject6);
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = qls.a(this.jdField_a_of_type_Qls);
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = qls.a(this.jdField_a_of_type_Qls);
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.E)) {
            break label1052;
          }
          localObject1 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject5);
          ((URLDrawable)localObject1).setDecodeHandler(bavi.a);
          this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "initVideoItemContentUI() ERROR e = " + localMalformedURLException.getMessage());
        break;
        label1052:
        localObject2 = new URL(paramVideoInfo.E);
      }
      this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
      break label267;
      label1083:
      this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setText(((Resources)localObject6).getText(2131718609));
      break label362;
      label1104:
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetTextView.setText(((Resources)localObject6).getText(2131718607));
    }
    label1125:
    int i;
    try
    {
      localObject2 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
      if (((JSONObject)localObject2).has("down_time"))
      {
        i = ((JSONObject)localObject2).optInt("down_time") * 1000;
        if (i > 0) {
          this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.setDuration(i);
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
        label1784:
        localJSONException.printStackTrace();
        continue;
        this.jdField_a_of_type_Qmd.m.setText(qls.a(this.jdField_a_of_type_Qls, paramVideoInfo, (Resources)localObject6));
        continue;
        label2030:
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Qmd.jdField_q_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H);
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Qls);
      }
      label2089:
      if ((this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidWidgetTextView == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F))) {
        break label2164;
      }
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
      label2164:
      if (!qls.b(paramVideoInfo)) {
        break label2335;
      }
      this.jdField_a_of_type_Qmd.s.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Qmd.t.setText(qls.a(this.jdField_a_of_type_Qls, paramVideoInfo, 1));
      a(this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetImageView, paramVideoInfo, 32, 6);
      this.jdField_a_of_type_Qmd.s.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.s.setTag(this.jdField_a_of_type_Qmd);
      this.jdField_a_of_type_Qmd.t.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.t.setTag(this.jdField_a_of_type_Qmd);
      this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_Qmd);
      this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Qmd);
      label2335:
      if (!qls.b(paramVideoInfo)) {
        break label3388;
      }
    }
    if (this.jdField_a_of_type_Qmd.m != null)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject2).setColor(Color.parseColor("#FF00CAFC"));
      this.jdField_a_of_type_Qmd.m.setBackgroundDrawable((Drawable)localObject2);
      qls.b(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmd);
    }
    if (this.jdField_a_of_type_Qmd.j != null)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F6"));
      this.jdField_a_of_type_Qmd.j.setBackgroundDrawable((Drawable)localObject2);
    }
    if (this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qmd);
      }
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qmd);
    }
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
    ((GradientDrawable)localObject2).setColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_Qmd.p.setBackgroundDrawable((Drawable)localObject2);
    this.jdField_a_of_type_Qmd.jdField_q_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qls);
    this.jdField_a_of_type_Qmd.jdField_q_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qmd);
    int j;
    int k;
    if (qls.b(paramVideoInfo))
    {
      this.jdField_a_of_type_Qmd.m.setText(qls.a(this.jdField_a_of_type_Qls, paramVideoInfo, 2));
      this.jdField_a_of_type_Qmd.m.setOnClickListener(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qmd.m.setTag(this.jdField_a_of_type_Qmd);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
        break label2164;
      }
      if (this.jdField_a_of_type_Qmd.r != null)
      {
        this.jdField_a_of_type_Qmd.r.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.G);
        this.jdField_a_of_type_Qmd.r.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.r.setOnClickListener(this.jdField_a_of_type_Qls);
      }
      if (this.jdField_a_of_type_Qmd.jdField_q_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H)) {
          break label2030;
        }
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, ((LinearLayout.LayoutParams)localObject2).topMargin, ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
        this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.size() <= 0) || (this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetLinearLayout == null)) {
        break label2089;
      }
      this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      i = this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetLinearLayout.getWidth();
      localObject2 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (String)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject7 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject7).rightMargin = actn.a(6.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
          localObject8 = new TextView(qls.a(this.jdField_a_of_type_Qls));
          ((TextView)localObject8).setTextSize(10.0F);
          ((TextView)localObject8).setTextColor(Color.parseColor("#737373"));
          ((TextView)localObject8).setIncludeFontPadding(false);
          ((TextView)localObject8).setBackgroundResource(2130848343);
          ((TextView)localObject8).setText((CharSequence)localObject5);
          ((TextView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ((TextView)localObject8).setOnClickListener(new qmb(this, paramVideoInfo));
          j = onk.a(qls.a(this.jdField_a_of_type_Qls))[0];
          k = actn.a(125.0F, (Resources)localObject6);
          int m = (int)((TextView)localObject8).getPaint().measureText((String)localObject5);
          if (i + m >= j - k) {
            break label3778;
          }
          this.jdField_a_of_type_Qmd.jdField_e_of_type_AndroidWidgetLinearLayout.addView((View)localObject8);
          i = m + i + 6;
        }
      }
    }
    label2365:
    label3778:
    for (;;)
    {
      break label1784;
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.k)) {
          this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
        }
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
      }
      if (this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.c)) {
          this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        }
        this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
      }
      i = 12;
      if (qls.b(paramVideoInfo)) {
        i = 2;
      }
      a(this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, 60, i);
      this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      qls.a(this.jdField_a_of_type_Qls, false, this.jdField_a_of_type_Qmd);
      localObject7 = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(paramVideoInfo.c))
      {
        ((SpannableStringBuilder)localObject7).append(onk.a(paramVideoInfo.c, 72));
        ((SpannableStringBuilder)localObject7).append("  ");
      }
      localObject5 = ajyc.a(2131716234);
      j = 1;
      for (;;)
      {
        try
        {
          localObject8 = new JSONObject(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v);
          i = j;
          localObject3 = localObject5;
          if (((JSONObject)localObject8).has("AdsIconText"))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "detail ad  video in new style adInconText:" + ((JSONObject)localObject8).optString("AdsIconText"));
            }
            if (TextUtils.isEmpty(((JSONObject)localObject8).optString("AdsIconText"))) {
              continue;
            }
            localObject3 = ((JSONObject)localObject8).optString("AdsIconText");
            i = j;
          }
        }
        catch (Exception localException)
        {
          Object localObject3;
          float f;
          RectF localRectF1;
          RectF localRectF2;
          RectF localRectF3;
          localException.printStackTrace();
          i = j;
          localObject4 = localObject5;
          continue;
          localObject4 = new RectF(0.0F, j, i, k - j);
          ((Paint)localObject5).setColor(452984831);
          ((Canvas)localObject9).drawRoundRect((RectF)localObject4, 2.0F, 2.0F, (Paint)localObject5);
          continue;
        }
        if (i != 0)
        {
          localObject5 = new Paint();
          ((Paint)localObject5).setAntiAlias(true);
          ((Paint)localObject5).setStyle(Paint.Style.FILL);
          ((Paint)localObject5).setTextSize(actn.a(10.0F, (Resources)localObject6));
          ((Paint)localObject5).setColor(-1291845633);
          f = ((Paint)localObject5).measureText((String)localObject3);
          i = actn.a(6.0F, (Resources)localObject6);
          i = (int)f + i;
          j = actn.a(1.0F, (Resources)localObject6) / 2;
          k = actn.a(14.0F, (Resources)localObject6);
          localObject8 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
          localObject9 = new Canvas((Bitmap)localObject8);
          ((Canvas)localObject9).drawText((String)localObject3, actn.a(3.0F, (Resources)localObject6), k / 2 - (((Paint)localObject5).descent() + ((Paint)localObject5).ascent()) / 2.0F, (Paint)localObject5);
          if (oat.a()) {
            continue;
          }
          localObject3 = new RectF(j, k, i - j, k - j);
          localRectF1 = new RectF(j, j, i - j, 0.0F);
          localRectF2 = new RectF(0.0F, k - j, j, j);
          localRectF3 = new RectF(i - j, k - j, i, j);
          ((Canvas)localObject9).drawRect((RectF)localObject3, (Paint)localObject5);
          ((Canvas)localObject9).drawRect(localRectF1, (Paint)localObject5);
          ((Canvas)localObject9).drawRect(localRectF2, (Paint)localObject5);
          ((Canvas)localObject9).drawRect(localRectF3, (Paint)localObject5);
          ((SpannableStringBuilder)localObject7).setSpan(new VerticalCenterImageSpan(qls.a(this.jdField_a_of_type_Qls), (Bitmap)localObject8), ((SpannableStringBuilder)localObject7).length() - 1, ((SpannableStringBuilder)localObject7).length(), 33);
          ((SpannableStringBuilder)localObject7).setSpan(new qmc(this), ((SpannableStringBuilder)localObject7).length() - 1, ((SpannableStringBuilder)localObject7).length(), 33);
          localObject3 = this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView;
          ((TextView)localObject3).setPadding(((TextView)localObject3).getPaddingLeft(), ((TextView)localObject3).getPaddingTop(), ((TextView)localObject3).getPaddingRight(), actn.a(1.0F, (Resources)localObject6));
        }
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject7);
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
        if (this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Qmd.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
        }
        a(this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, 70, 11);
        if (this.jdField_a_of_type_Qmd.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.k)) {
            this.jdField_a_of_type_Qmd.jdField_h_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
          }
          this.jdField_a_of_type_Qmd.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qls);
          this.jdField_a_of_type_Qmd.jdField_h_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qmd);
        }
        if (this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidWidgetTextView.setText(ajyc.a(2131716150));
          i = actn.a(12.0F, (Resources)localObject6);
          localObject3 = ((Resources)localObject6).getDrawable(2130842513);
          ((Drawable)localObject3).setBounds(0, 0, i, i);
          this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, null, null);
        }
        if (this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qls);
          this.jdField_a_of_type_Qmd.jdField_i_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qmd);
        }
        if (this.jdField_a_of_type_Qmd.j == null) {
          break;
        }
        this.jdField_a_of_type_Qmd.j.setOnClickListener(this.jdField_a_of_type_Qls);
        this.jdField_a_of_type_Qmd.j.setTag(this.jdField_a_of_type_Qmd);
        break;
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break label2365;
        i = 0;
        localObject3 = localObject5;
      }
      ((LinearLayout.LayoutParams)localObject6).topMargin = actn.a(7.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
      break label611;
      Object localObject4 = this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar;
      localObject6 = ((SeekBar)localObject4).getLayoutParams();
      if ((localObject6 instanceof LinearLayout.LayoutParams))
      {
        localObject5 = (ViewGroup)((SeekBar)localObject4).getParent();
        ((ViewGroup)localObject5).removeView((View)localObject4);
        localObject6 = (LinearLayout.LayoutParams)localObject6;
        i = 3;
        if (qls.b(paramVideoInfo))
        {
          i = 4;
          ((LinearLayout.LayoutParams)localObject6).bottomMargin = actn.a(0.5F, qls.a(this.jdField_a_of_type_Qls).getResources());
        }
        ((LinearLayout.LayoutParams)localObject6).topMargin = actn.a(10, qls.a(this.jdField_a_of_type_Qls).getResources());
        ((ViewGroup)localObject5).addView((View)localObject4, i, (ViewGroup.LayoutParams)localObject6);
        paramVideoInfo = this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetTextView;
        localObject4 = this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewView;
        localObject5 = this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidViewView;
        localObject6 = (LinearLayout.LayoutParams)paramVideoInfo.getLayoutParams();
        localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
        localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject6).topMargin = actn.a(0.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
        ((LinearLayout.LayoutParams)localObject7).topMargin = actn.a(7.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
        ((LinearLayout.LayoutParams)localObject8).topMargin = actn.a(15.0F, qls.a(this.jdField_a_of_type_Qls).getResources());
        paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
        ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      }
      if (this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup == null) {
        break label777;
      }
      this.jdField_a_of_type_Qmd.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
      break label777;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    qls.g(this.jdField_a_of_type_Qls, false);
    if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qmd);
      localObject = new GestureDetector(new qlz(this));
      this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setOnTouchListener(new qma(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    qls.a(this.jdField_a_of_type_Qls, false, this.jdField_a_of_type_Qmd);
    if (paramVideoInfo.b(qls.a(this.jdField_a_of_type_Qls))) {
      this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (paramVideoInfo.a() == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
    paramVideoInfo.setDecodeHandler(bavi.w);
    paramVideoInfo.setAlpha(80);
    this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
  }
  
  public void a(qmd paramqmd, VideoInfo paramVideoInfo)
  {
    if ((paramqmd == null) || (paramqmd.jdField_b_of_type_AndroidViewViewGroup == null) || (qls.a(this.jdField_a_of_type_Qls) == null) || (paramVideoInfo == null)) {}
    int[] arrayOfInt;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        arrayOfInt = qol.b(qls.a(this.jdField_a_of_type_Qls));
      } while (!(paramqmd instanceof qmd));
      paramqmd = paramqmd.jdField_b_of_type_AndroidViewViewGroup;
      localLayoutParams = (RelativeLayout.LayoutParams)paramqmd.getLayoutParams();
    } while ((!paramVideoInfo.b(qls.a(this.jdField_a_of_type_Qls))) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F) || (localLayoutParams == null));
    if (qls.d(this.jdField_a_of_type_Qls) != 0) {
      localLayoutParams.topMargin = qls.d(this.jdField_a_of_type_Qls);
    }
    if (qls.e(this.jdField_a_of_type_Qls) != 0) {
      localLayoutParams.bottomMargin = qls.e(this.jdField_a_of_type_Qls);
    }
    paramqmd.setLayoutParams(localLayoutParams);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void b(qmd paramqmd, VideoInfo paramVideoInfo)
  {
    if (paramqmd == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramqmd = paramqmd.jdField_l_of_type_AndroidViewViewGroup;
        if ((qls.e(this.jdField_a_of_type_Qls) == 0) && (paramqmd != null) && (paramqmd.getLayoutParams() != null)) {
          qls.b(this.jdField_a_of_type_Qls, paramqmd.getLayoutParams().height);
        }
      }
      while ((qls.d(this.jdField_a_of_type_Qls) == 0) && (qls.a(this.jdField_a_of_type_Qls) != null) && ((qls.a(this.jdField_a_of_type_Qls) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)qls.a(this.jdField_a_of_type_Qls)).a() != null))
      {
        qls.c(this.jdField_a_of_type_Qls, ((VideoFeedsPlayActivity)qls.a(this.jdField_a_of_type_Qls)).a().getMeasuredHeight());
        return;
        paramqmd = paramqmd.jdField_d_of_type_AndroidWidgetTextView;
        if ((qls.e(this.jdField_a_of_type_Qls) == 0) && (paramqmd != null) && (paramqmd.getLayoutParams() != null)) {
          qls.b(this.jdField_a_of_type_Qls, paramqmd.getLayoutParams().height);
        }
      }
    }
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((qls.i(this.jdField_a_of_type_Qls)) && (!qls.h(this.jdField_a_of_type_Qls)))
    {
      if (this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        qls.i(this.jdField_a_of_type_Qls, bool1);
        h(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      h(bool1);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    h(false);
    if (((this.jdField_a_of_type_Qmd.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Qmd.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      qls.a(this.jdField_a_of_type_Qls, false, this.jdField_a_of_type_Qmd);
      if (this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      qls.k(this.jdField_a_of_type_Qls, true);
      qls.g(this.jdField_a_of_type_Qls, true);
      if (!paramBoolean) {
        break label146;
      }
      if (!this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a.b(qls.a(this.jdField_a_of_type_Qls)))
      {
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qol.b(qls.a(this.jdField_a_of_type_Qls)));
        k(true);
      }
      if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label146:
    label235:
    do
    {
      do
      {
        return;
        qls.k(this.jdField_a_of_type_Qls, false);
        qls.g(this.jdField_a_of_type_Qls, false);
        break;
        if (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a.b(qls.a(this.jdField_a_of_type_Qls))) {
          break label235;
        }
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        k(false);
      } while ((this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Qmd != null) && (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a != null))
    {
      if (qls.b(this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a))
      {
        this.jdField_a_of_type_Qmd.t.setText(qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a, 1));
        this.jdField_a_of_type_Qmd.m.setText(qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a, 2));
        this.jdField_a_of_type_Qmd.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Qmd.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidWidgetTextView.setText(qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmd.jdField_a_of_type_Qqo.a, qls.a(this.jdField_a_of_type_Qls).getResources()));
  }
  
  public void e(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView != null)
    {
      boolean bool;
      if (!paramBoolean) {
        if ((qls.i(this.jdField_a_of_type_Qls)) && (!qls.h(this.jdField_a_of_type_Qls)))
        {
          if ((this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.getVisibility() == 8) && (!qls.b(this.jdField_a_of_type_Qls)))
          {
            if (this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView != null)
            {
              qls.a(this.jdField_a_of_type_Qls, this.jdField_a_of_type_Qmd);
              this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView.setVisibility(0);
            }
            qol.a(this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (qls.b(this.jdField_a_of_type_Qls))
          {
            if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label148;
            }
            bool = true;
            this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        super.h(bool);
        return;
        label148:
        bool = paramBoolean;
        if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
        {
          this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          bool = paramBoolean;
          continue;
          if ((this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.getVisibility() == 8) && (!qls.b(this.jdField_a_of_type_Qls))) {
            qol.a(this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
            bool = paramBoolean;
            continue;
            if ((qls.i(this.jdField_a_of_type_Qls)) && (!qls.h(this.jdField_a_of_type_Qls)))
            {
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView.getVisibility() == 0)
              {
                if (this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView != null) {
                  this.jdField_a_of_type_Qmd.jdField_k_of_type_AndroidViewView.setVisibility(8);
                }
                qol.a(this.jdField_a_of_type_Qmd.jdField_o_of_type_AndroidViewView, 8);
                bool = paramBoolean;
              }
            }
            else
            {
              if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
                qol.a(this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewView, 8);
              }
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
              {
                this.jdField_a_of_type_Qmd.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
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
      this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qmd.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qly
 * JD-Core Version:    0.7.0.1
 */