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

public class qlv
  extends qmg
{
  private qma jdField_a_of_type_Qma;
  
  public qlv(qlp paramqlp, qma paramqma)
  {
    super(paramqlp, paramqma);
    this.jdField_a_of_type_Qma = paramqma;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d) && (oaq.g(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (oar.b(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
  }
  
  private void k(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
      localMarginLayoutParams.bottomMargin = actj.a(0.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
      this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewViewGroup.getLayoutParams();
    localMarginLayoutParams.bottomMargin = (actj.a(15.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources()) - 20);
    this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewViewGroup.setLayoutParams(localMarginLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (qlp.a(this.jdField_a_of_type_Qlp) != null) {
      qlp.a(this.jdField_a_of_type_Qlp).a(paramInt1, paramInt2);
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
        paramImageView.setImageDrawable(bayh.a(qlp.a(this.jdField_a_of_type_Qlp), 1, paramVideoInfo.j, 1, qlp.a(this.jdField_a_of_type_Qlp), qlp.a(this.jdField_a_of_type_Qlp)));
        paramImageView.setOnClickListener(this.jdField_a_of_type_Qlp);
        paramImageView.setTag(this.jdField_a_of_type_Qma);
      }
    }
    else {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = actj.a(paramInt1, qlp.a(this.jdField_a_of_type_Qlp).getResources());
    localURLDrawableOptions.mRequestHeight = actj.a(paramInt1, qlp.a(this.jdField_a_of_type_Qlp).getResources());
    localURLDrawableOptions.mLoadingDrawable = qlp.a(this.jdField_a_of_type_Qlp);
    localURLDrawableOptions.mFailedDrawable = qlp.a(this.jdField_a_of_type_Qlp);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramVideoInfo.E)) {
          break label369;
        }
        localObject1 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
        Object localObject2 = localObject1;
        if (qlp.b(paramVideoInfo))
        {
          String str = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.E;
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(str)) {
            localObject2 = new URL(str);
          }
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject1).setTag(bavw.b(actj.a(paramInt1, qlp.a(this.jdField_a_of_type_Qlp).getResources()), actj.a(paramInt1, qlp.a(this.jdField_a_of_type_Qlp).getResources()), actj.a(paramInt2, qlp.a(this.jdField_a_of_type_Qlp).getResources())));
        if ((!qlp.b(paramVideoInfo)) || (this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetImageView != paramImageView)) {
          break label385;
        }
        ((URLDrawable)localObject1).setTag(new int[] { 0, 0, paramInt2, 3 });
        ((URLDrawable)localObject1).setDecodeHandler(bavw.j);
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
      ((URLDrawable)localObject1).setDecodeHandler(bavw.i);
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    qlp.g(this.jdField_a_of_type_Qlp, false);
    qlp.b(this.jdField_a_of_type_Qlp, false);
    b(this.jdField_a_of_type_Qma, paramVideoInfo);
    a(this.jdField_a_of_type_Qma, paramVideoInfo);
    Object localObject6 = qlp.a(this.jdField_a_of_type_Qlp).getResources();
    Object localObject1;
    if (paramVideoInfo.jdField_a_of_type_Int != 0) {
      if (this.jdField_a_of_type_Qma.jdField_a_of_type_Int == 4)
      {
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Qlp);
        if (!TextUtils.isEmpty(paramVideoInfo.k))
        {
          this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(paramVideoInfo.k);
          this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setTag(this.jdField_a_of_type_Qma);
          this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
        }
        if (TextUtils.isEmpty(paramVideoInfo.j)) {
          break label904;
        }
        localObject1 = bayh.a(qlp.a(this.jdField_a_of_type_Qlp), 1, paramVideoInfo.j, 3, qlp.a(this.jdField_a_of_type_Qlp), qlp.a(this.jdField_a_of_type_Qlp));
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this.jdField_a_of_type_Qlp);
        label267:
        oar.a(paramVideoInfo, this.jdField_a_of_type_Qma);
        if (this.jdField_a_of_type_Qma.jdField_a_of_type_Int != 4) {
          break label1125;
        }
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject6).getDisplayMetrics().widthPixels * 0.7D));
        if (TextUtils.isEmpty(paramVideoInfo.c)) {
          break label1083;
        }
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        label362:
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth((int)(((Resources)localObject6).getDisplayMetrics().widthPixels * 0.224D));
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l))) {
          break label1104;
        }
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.l);
      }
    }
    Object localObject5;
    label611:
    Object localObject7;
    Object localObject8;
    Object localObject9;
    for (;;)
    {
      if ((qlp.a(this.jdField_a_of_type_Qlp) == this.jdField_a_of_type_Qma) && (this.jdField_a_of_type_Qma.jdField_a_of_type_Int == 4) && (qlp.a(this.jdField_a_of_type_Qlp)))
      {
        if (this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
        }
        if (this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup != null) {
          this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
        }
      }
      this.jdField_a_of_type_Qma.jdField_h_of_type_AndroidViewViewGroup.setVisibility(8);
      if (!a(paramVideoInfo)) {
        break label3507;
      }
      qoi.b(paramVideoInfo);
      if (this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar;
        localObject6 = ((SeekBar)localObject1).getLayoutParams();
        if ((localObject6 instanceof LinearLayout.LayoutParams))
        {
          localObject5 = (ViewGroup)((SeekBar)localObject1).getParent();
          ((ViewGroup)localObject5).removeView((View)localObject1);
          localObject6 = (LinearLayout.LayoutParams)localObject6;
          if (!oaq.c(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) {
            break label3483;
          }
          ((LinearLayout.LayoutParams)localObject6).topMargin = 0;
          ((ViewGroup)localObject5).addView((View)localObject1, ((ViewGroup)localObject5).getChildCount() - 2, (ViewGroup.LayoutParams)localObject6);
          localObject1 = this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetTextView;
          localObject5 = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewView;
          localObject6 = this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidViewView;
          localObject7 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
          localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
          localObject9 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject7).topMargin = actj.a(14.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
          ((LinearLayout.LayoutParams)localObject8).topMargin = actj.a(14.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
          ((LinearLayout.LayoutParams)localObject9).topMargin = actj.a(14.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
          ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
          ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject9);
        }
        a(this.jdField_a_of_type_Qma, paramVideoInfo);
      }
      label777:
      if (oaq.a())
      {
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
        paramVideoInfo = this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getLayoutParams();
        if ((paramVideoInfo instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramVideoInfo).leftMargin = actj.a(15.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        }
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setTextSize(14.0F);
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
      this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
      break;
      label904:
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = actj.a(40.0F, (Resources)localObject6);
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = actj.a(40.0F, (Resources)localObject6);
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = qlp.a(this.jdField_a_of_type_Qlp);
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = qlp.a(this.jdField_a_of_type_Qlp);
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramVideoInfo.E)) {
            break label1052;
          }
          localObject1 = new URL("http://post.mp.qq.com/kan/video/201197226-1955dc60def689ah-j0032zp3bhx.html?_wv=2281701505&sig=2556997e505f84ff05decf79e0d001af&time=1573267470&iid=MzczOTc1NDQ5OQ==&sourcefrom=0");
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject5);
          ((URLDrawable)localObject1).setDecodeHandler(bavw.a);
          this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable((Drawable)localObject1);
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
      this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewViewGroup.setVisibility(8);
      break label267;
      label1083:
      this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setText(((Resources)localObject6).getText(2131718620));
      break label362;
      label1104:
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetTextView.setText(((Resources)localObject6).getText(2131718618));
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
          this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.setDuration(i);
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
        this.jdField_a_of_type_Qma.m.setText(qlp.a(this.jdField_a_of_type_Qlp, paramVideoInfo, (Resources)localObject6));
        continue;
        label2030:
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Qma.jdField_q_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H);
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetLinearLayout.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_Qlp);
      }
      label2089:
      if ((this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidWidgetTextView == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F))) {
        break label2164;
      }
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidWidgetTextView.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
      label2164:
      if (!qlp.b(paramVideoInfo)) {
        break label2335;
      }
      this.jdField_a_of_type_Qma.s.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.F);
      this.jdField_a_of_type_Qma.t.setText(qlp.a(this.jdField_a_of_type_Qlp, paramVideoInfo, 1));
      a(this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetImageView, paramVideoInfo, 32, 6);
      this.jdField_a_of_type_Qma.s.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.s.setTag(this.jdField_a_of_type_Qma);
      this.jdField_a_of_type_Qma.t.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.t.setTag(this.jdField_a_of_type_Qma);
      this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetImageView.setTag(this.jdField_a_of_type_Qma);
      this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(this.jdField_a_of_type_Qma);
      label2335:
      if (!qlp.b(paramVideoInfo)) {
        break label3388;
      }
    }
    if (this.jdField_a_of_type_Qma.m != null)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
      ((GradientDrawable)localObject2).setColor(Color.parseColor("#FF00CAFC"));
      this.jdField_a_of_type_Qma.m.setBackgroundDrawable((Drawable)localObject2);
      qlp.b(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qma);
    }
    if (this.jdField_a_of_type_Qma.j != null)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(2.0D));
      ((GradientDrawable)localObject2).setColor(Color.parseColor("#12B7F6"));
      this.jdField_a_of_type_Qma.j.setBackgroundDrawable((Drawable)localObject2);
    }
    if (this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qma);
      }
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qma);
    }
    Object localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(Utils.dp2px(6.0D));
    ((GradientDrawable)localObject2).setColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_Qma.p.setBackgroundDrawable((Drawable)localObject2);
    this.jdField_a_of_type_Qma.jdField_q_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qlp);
    this.jdField_a_of_type_Qma.jdField_q_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qma);
    int j;
    int k;
    if (qlp.b(paramVideoInfo))
    {
      this.jdField_a_of_type_Qma.m.setText(qlp.a(this.jdField_a_of_type_Qlp, paramVideoInfo, 2));
      this.jdField_a_of_type_Qma.m.setOnClickListener(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qma.m.setTag(this.jdField_a_of_type_Qma);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
        break label2164;
      }
      if (this.jdField_a_of_type_Qma.r != null)
      {
        this.jdField_a_of_type_Qma.r.setText(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.G);
        this.jdField_a_of_type_Qma.r.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.r.setOnClickListener(this.jdField_a_of_type_Qlp);
      }
      if (this.jdField_a_of_type_Qma.jdField_q_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.H)) {
          break label2030;
        }
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).setMargins(0, ((LinearLayout.LayoutParams)localObject2).topMargin, ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
        this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.size() <= 0) || (this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetLinearLayout == null)) {
        break label2089;
      }
      this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetLinearLayout.removeAllViews();
      i = this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetLinearLayout.getWidth();
      localObject2 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (String)((Iterator)localObject2).next();
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject7 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject7).rightMargin = actj.a(6.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
          localObject8 = new TextView(qlp.a(this.jdField_a_of_type_Qlp));
          ((TextView)localObject8).setTextSize(10.0F);
          ((TextView)localObject8).setTextColor(Color.parseColor("#737373"));
          ((TextView)localObject8).setIncludeFontPadding(false);
          ((TextView)localObject8).setBackgroundResource(2130848349);
          ((TextView)localObject8).setText((CharSequence)localObject5);
          ((TextView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject7);
          ((TextView)localObject8).setOnClickListener(new qly(this, paramVideoInfo));
          j = onh.a(qlp.a(this.jdField_a_of_type_Qlp))[0];
          k = actj.a(125.0F, (Resources)localObject6);
          int m = (int)((TextView)localObject8).getPaint().measureText((String)localObject5);
          if (i + m >= j - k) {
            break label3778;
          }
          this.jdField_a_of_type_Qma.jdField_e_of_type_AndroidWidgetLinearLayout.addView((View)localObject8);
          i = m + i + 6;
        }
      }
    }
    label2365:
    label3778:
    for (;;)
    {
      break label1784;
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.k)) {
          this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
        }
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
      }
      if (this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(paramVideoInfo.c)) {
          this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidWidgetTextView.setText(paramVideoInfo.c);
        }
        this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
      }
      i = 12;
      if (qlp.b(paramVideoInfo)) {
        i = 2;
      }
      a(this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetImageView, paramVideoInfo, 60, i);
      this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      qlp.a(this.jdField_a_of_type_Qlp, false, this.jdField_a_of_type_Qma);
      localObject7 = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(paramVideoInfo.c))
      {
        ((SpannableStringBuilder)localObject7).append(onh.a(paramVideoInfo.c, 72));
        ((SpannableStringBuilder)localObject7).append("  ");
      }
      localObject5 = ajya.a(2131716245);
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
          ((Paint)localObject5).setTextSize(actj.a(10.0F, (Resources)localObject6));
          ((Paint)localObject5).setColor(-1291845633);
          f = ((Paint)localObject5).measureText((String)localObject3);
          i = actj.a(6.0F, (Resources)localObject6);
          i = (int)f + i;
          j = actj.a(1.0F, (Resources)localObject6) / 2;
          k = actj.a(14.0F, (Resources)localObject6);
          localObject8 = Bitmap.createBitmap(i, k, Bitmap.Config.ARGB_8888);
          localObject9 = new Canvas((Bitmap)localObject8);
          ((Canvas)localObject9).drawText((String)localObject3, actj.a(3.0F, (Resources)localObject6), k / 2 - (((Paint)localObject5).descent() + ((Paint)localObject5).ascent()) / 2.0F, (Paint)localObject5);
          if (oaq.a()) {
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
          ((SpannableStringBuilder)localObject7).setSpan(new VerticalCenterImageSpan(qlp.a(this.jdField_a_of_type_Qlp), (Bitmap)localObject8), ((SpannableStringBuilder)localObject7).length() - 1, ((SpannableStringBuilder)localObject7).length(), 33);
          ((SpannableStringBuilder)localObject7).setSpan(new qlz(this), ((SpannableStringBuilder)localObject7).length() - 1, ((SpannableStringBuilder)localObject7).length(), 33);
          localObject3 = this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView;
          ((TextView)localObject3).setPadding(((TextView)localObject3).getPaddingLeft(), ((TextView)localObject3).getPaddingTop(), ((TextView)localObject3).getPaddingRight(), actj.a(1.0F, (Resources)localObject6));
        }
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject7);
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
        if (this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_Qma.jdField_g_of_type_AndroidViewView.setOnClickListener(null);
        }
        a(this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetImageView, paramVideoInfo, 70, 11);
        if (this.jdField_a_of_type_Qma.jdField_h_of_type_AndroidWidgetTextView != null)
        {
          if (!TextUtils.isEmpty(paramVideoInfo.k)) {
            this.jdField_a_of_type_Qma.jdField_h_of_type_AndroidWidgetTextView.setText(paramVideoInfo.k);
          }
          this.jdField_a_of_type_Qma.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_Qlp);
          this.jdField_a_of_type_Qma.jdField_h_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Qma);
        }
        if (this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidWidgetTextView.setText(ajya.a(2131716161));
          i = actj.a(12.0F, (Resources)localObject6);
          localObject3 = ((Resources)localObject6).getDrawable(2130842514);
          ((Drawable)localObject3).setBounds(0, 0, i, i);
          this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject3, null, null, null);
        }
        if (this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Qlp);
          this.jdField_a_of_type_Qma.jdField_i_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qma);
        }
        if (this.jdField_a_of_type_Qma.j == null) {
          break;
        }
        this.jdField_a_of_type_Qma.j.setOnClickListener(this.jdField_a_of_type_Qlp);
        this.jdField_a_of_type_Qma.j.setTag(this.jdField_a_of_type_Qma);
        break;
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        break label2365;
        i = 0;
        localObject3 = localObject5;
      }
      ((LinearLayout.LayoutParams)localObject6).topMargin = actj.a(7.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
      break label611;
      Object localObject4 = this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar;
      localObject6 = ((SeekBar)localObject4).getLayoutParams();
      if ((localObject6 instanceof LinearLayout.LayoutParams))
      {
        localObject5 = (ViewGroup)((SeekBar)localObject4).getParent();
        ((ViewGroup)localObject5).removeView((View)localObject4);
        localObject6 = (LinearLayout.LayoutParams)localObject6;
        i = 3;
        if (qlp.b(paramVideoInfo))
        {
          i = 4;
          ((LinearLayout.LayoutParams)localObject6).bottomMargin = actj.a(0.5F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        }
        ((LinearLayout.LayoutParams)localObject6).topMargin = actj.a(10, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        ((ViewGroup)localObject5).addView((View)localObject4, i, (ViewGroup.LayoutParams)localObject6);
        paramVideoInfo = this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetTextView;
        localObject4 = this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewView;
        localObject5 = this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidViewView;
        localObject6 = (LinearLayout.LayoutParams)paramVideoInfo.getLayoutParams();
        localObject7 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
        localObject8 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject6).topMargin = actj.a(0.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        ((LinearLayout.LayoutParams)localObject7).topMargin = actj.a(7.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        ((LinearLayout.LayoutParams)localObject8).topMargin = actj.a(15.0F, qlp.a(this.jdField_a_of_type_Qlp).getResources());
        paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject7);
        ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      }
      if (this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup == null) {
        break label777;
      }
      this.jdField_a_of_type_Qma.jdField_l_of_type_AndroidViewViewGroup.setVisibility(8);
      break label777;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    qlp.g(this.jdField_a_of_type_Qlp, false);
    if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setTag(this.jdField_a_of_type_Qma);
      localObject = new GestureDetector(new qlw(this));
      this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setOnTouchListener(new qlx(this, (GestureDetector)localObject));
    }
    this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    qlp.a(this.jdField_a_of_type_Qlp, false, this.jdField_a_of_type_Qma);
    if (paramVideoInfo.b(qlp.a(this.jdField_a_of_type_Qlp))) {
      this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    while (paramVideoInfo.a() == null) {
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramVideoInfo = URLDrawable.getDrawable(paramVideoInfo.a(), (URLDrawable.URLDrawableOptions)localObject);
    paramVideoInfo.setDecodeHandler(bavw.w);
    paramVideoInfo.setAlpha(80);
    this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramVideoInfo);
  }
  
  public void a(qma paramqma, VideoInfo paramVideoInfo)
  {
    if ((paramqma == null) || (paramqma.jdField_b_of_type_AndroidViewViewGroup == null) || (qlp.a(this.jdField_a_of_type_Qlp) == null) || (paramVideoInfo == null)) {}
    int[] arrayOfInt;
    RelativeLayout.LayoutParams localLayoutParams;
    do
    {
      do
      {
        return;
        arrayOfInt = qoi.b(qlp.a(this.jdField_a_of_type_Qlp));
      } while (!(paramqma instanceof qma));
      paramqma = paramqma.jdField_b_of_type_AndroidViewViewGroup;
      localLayoutParams = (RelativeLayout.LayoutParams)paramqma.getLayoutParams();
    } while ((!paramVideoInfo.b(qlp.a(this.jdField_a_of_type_Qlp))) || (arrayOfInt[0] == 0) || (arrayOfInt[1] / arrayOfInt[0] <= 1.777778F) || (localLayoutParams == null));
    if (qlp.d(this.jdField_a_of_type_Qlp) != 0) {
      localLayoutParams.topMargin = qlp.d(this.jdField_a_of_type_Qlp);
    }
    if (qlp.e(this.jdField_a_of_type_Qlp) != 0) {
      localLayoutParams.bottomMargin = qlp.e(this.jdField_a_of_type_Qlp);
    }
    paramqma.setLayoutParams(localLayoutParams);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    super.b(paramVideoInfo);
  }
  
  public void b(qma paramqma, VideoInfo paramVideoInfo)
  {
    if (paramqma == null) {}
    for (;;)
    {
      return;
      if (a(paramVideoInfo))
      {
        paramqma = paramqma.jdField_l_of_type_AndroidViewViewGroup;
        if ((qlp.e(this.jdField_a_of_type_Qlp) == 0) && (paramqma != null) && (paramqma.getLayoutParams() != null)) {
          qlp.b(this.jdField_a_of_type_Qlp, paramqma.getLayoutParams().height);
        }
      }
      while ((qlp.d(this.jdField_a_of_type_Qlp) == 0) && (qlp.a(this.jdField_a_of_type_Qlp) != null) && ((qlp.a(this.jdField_a_of_type_Qlp) instanceof VideoFeedsPlayActivity)) && (((VideoFeedsPlayActivity)qlp.a(this.jdField_a_of_type_Qlp)).a() != null))
      {
        qlp.c(this.jdField_a_of_type_Qlp, ((VideoFeedsPlayActivity)qlp.a(this.jdField_a_of_type_Qlp)).a().getMeasuredHeight());
        return;
        paramqma = paramqma.jdField_d_of_type_AndroidWidgetTextView;
        if ((qlp.e(this.jdField_a_of_type_Qlp) == 0) && (paramqma != null) && (paramqma.getLayoutParams() != null)) {
          qlp.b(this.jdField_a_of_type_Qlp, paramqma.getLayoutParams().height);
        }
      }
    }
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((qlp.i(this.jdField_a_of_type_Qlp)) && (!qlp.h(this.jdField_a_of_type_Qlp)))
    {
      if (this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.getVisibility() == 0) {}
      for (;;)
      {
        qlp.i(this.jdField_a_of_type_Qlp, bool1);
        h(bool1);
        return;
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {}
    for (bool1 = bool2;; bool1 = false)
    {
      h(bool1);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    h(false);
    if (((this.jdField_a_of_type_Qma.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Qma.jdField_a_of_type_Int == 7)) && (!paramBoolean))
    {
      qlp.a(this.jdField_a_of_type_Qlp, false, this.jdField_a_of_type_Qma);
      if (this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar != null) {
        this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      }
      if (this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView != null)
      {
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.setVisibility(4);
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.a(false);
        this.jdField_a_of_type_Qma.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyAdGestureView.b();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      qlp.k(this.jdField_a_of_type_Qlp, true);
      qlp.g(this.jdField_a_of_type_Qlp, true);
      if (!paramBoolean) {
        break label146;
      }
      if (!this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a.b(qlp.a(this.jdField_a_of_type_Qlp)))
      {
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, qoi.b(qlp.a(this.jdField_a_of_type_Qlp)));
        k(true);
      }
      if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setVisibility(8);
      }
    }
    label146:
    label235:
    do
    {
      do
      {
        return;
        qlp.k(this.jdField_a_of_type_Qlp, false);
        qlp.g(this.jdField_a_of_type_Qlp, false);
        break;
        if (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a.b(qlp.a(this.jdField_a_of_type_Qlp))) {
          break label235;
        }
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
        k(false);
      } while ((this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView == null));
      this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    } while ((this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) || (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView == null));
    this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Qma != null) && (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a != null))
    {
      if (qlp.b(this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a))
      {
        this.jdField_a_of_type_Qma.t.setText(qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a, 1));
        this.jdField_a_of_type_Qma.m.setText(qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a, 2));
        this.jdField_a_of_type_Qma.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_Qma.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidWidgetTextView.setText(qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qma.jdField_a_of_type_Qql.a, qlp.a(this.jdField_a_of_type_Qlp).getResources()));
  }
  
  public void e(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView != null)
    {
      boolean bool;
      if (!paramBoolean) {
        if ((qlp.i(this.jdField_a_of_type_Qlp)) && (!qlp.h(this.jdField_a_of_type_Qlp)))
        {
          if ((this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.getVisibility() == 8) && (!qlp.b(this.jdField_a_of_type_Qlp)))
          {
            if (this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView != null)
            {
              qlp.a(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_Qma);
              this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView.setVisibility(0);
            }
            qoi.a(this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (qlp.b(this.jdField_a_of_type_Qlp))
          {
            if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8) {
              break label148;
            }
            bool = true;
            this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        super.h(bool);
        return;
        label148:
        bool = paramBoolean;
        if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
        {
          this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
          bool = paramBoolean;
          continue;
          if ((this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.getVisibility() == 8) && (!qlp.b(this.jdField_a_of_type_Qlp))) {
            qoi.a(this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView, 0);
          }
          bool = paramBoolean;
          if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
          {
            this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
            bool = paramBoolean;
            continue;
            if ((qlp.i(this.jdField_a_of_type_Qlp)) && (!qlp.h(this.jdField_a_of_type_Qlp)))
            {
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView.getVisibility() == 0)
              {
                if (this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView != null) {
                  this.jdField_a_of_type_Qma.jdField_k_of_type_AndroidViewView.setVisibility(8);
                }
                qoi.a(this.jdField_a_of_type_Qma.jdField_o_of_type_AndroidViewView, 8);
                bool = paramBoolean;
              }
            }
            else
            {
              if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
                qoi.a(this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewView, 8);
              }
              bool = paramBoolean;
              if (this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8)
              {
                this.jdField_a_of_type_Qma.jdField_d_of_type_AndroidViewViewGroup.setVisibility(0);
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
      this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_Qma.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qlv
 * JD-Core Version:    0.7.0.1
 */