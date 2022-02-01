package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedItemCellTypeNow
  extends FeedItemCell
  implements View.OnClickListener
{
  private static Drawable T;
  private View G;
  private KandianUrlImageView H;
  private TextView I;
  private TextView J;
  private URLImageView K;
  private TextView L;
  private LinearLayout M;
  private View N;
  private TextView O;
  private FrameLayout P;
  private FrameLayout Q;
  private View R;
  private ImageView S;
  
  public FeedItemCellTypeNow(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  private TextView b(int paramInt)
  {
    TextView localTextView = new TextView(this.e);
    localTextView.setId(2131444261);
    localTextView.setTextSize(2, 11.0F);
    localTextView.setGravity(17);
    localTextView.setText(HardCodeUtil.a(2131902470));
    localTextView.setWidth(DisplayUtil.a(this.e, 30.0F));
    localTextView.setHeight(DisplayUtil.a(this.e, 17.0F));
    if (paramInt == 0)
    {
      localTextView.setTextColor(Color.argb(255, 255, 255, 255));
      localTextView.setBackgroundResource(2130851421);
      return localTextView;
    }
    localTextView.setTextColor(-89258);
    localTextView.setBackgroundResource(2130851422);
    return localTextView;
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return this;
  }
  
  public FeedItemCell e()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    View localView = LayoutInflater.from(this.e).inflate(2131626300, localRelativeLayout, true);
    this.R = localView.findViewById(2131437013);
    this.S = ((ImageView)localView.findViewById(2131440377));
    this.G = localView.findViewById(2131444933);
    this.H = ((KandianUrlImageView)localView.findViewById(2131436334));
    this.I = ((TextView)localView.findViewById(2131448814));
    this.J = ((TextView)localView.findViewById(2131448648));
    this.K = ((URLImageView)localView.findViewById(2131436420));
    this.L = new TextView(this.e);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = DisplayUtil.a(this.e, 5.0F);
    localLayoutParams.gravity = 16;
    this.L.setTextSize(2, 12.0F);
    this.L.setId(2131444254);
    ((FrameLayout)localView.findViewById(2131433268)).addView(this.L, localLayoutParams);
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M = ((LinearLayout)localView.findViewById(2131437400));
    this.N = localView.findViewById(2131449815);
    this.O = ((TextView)localView.findViewById(2131429704));
    this.P = ((FrameLayout)localView.findViewById(2131433274));
    this.Q = ((FrameLayout)localView.findViewById(2131433273));
    a(localRelativeLayout);
    return this;
  }
  
  public FeedItemCell f()
  {
    return this;
  }
  
  public void onClick(View paramView) {}
  
  public FeedItemCell q()
  {
    if ((this.b instanceof IReadInJoyModel))
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.b;
      AbsBaseArticleInfo localAbsBaseArticleInfo = localIReadInJoyModel.k();
      if (localAbsBaseArticleInfo == null) {
        return this;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindData articleId = ");
        ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject1).append("roomId = ");
        ((StringBuilder)localObject1).append(localAbsBaseArticleInfo.mSubscribeID);
        QLog.d("FeedItemCellTypeNow", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = (RelativeLayout.LayoutParams)this.G.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ScreenUtil.SCREEN_WIDTH;
      ((RelativeLayout.LayoutParams)localObject1).height = (((RelativeLayout.LayoutParams)localObject1).width * 9 / 16);
      this.G.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      Object localObject3 = this.H;
      if (localAbsBaseArticleInfo.mVideoCoverUrl != null) {
        localObject1 = localAbsBaseArticleInfo.mVideoCoverUrl;
      } else if (localAbsBaseArticleInfo.mSinglePicture != null) {
        localObject1 = localAbsBaseArticleInfo.mSinglePicture;
      } else {
        localObject1 = RIJConvertString2URL.b(localAbsBaseArticleInfo.mFirstPagePicUrl);
      }
      ReadInJoyDisplayUtils.a((KandianUrlImageView)localObject3, (URL)localObject1, this.e, true);
      if (T == null) {
        T = ImageUtil.j();
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.K.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.K.getHeight();
      localObject1 = T;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
      try
      {
        if (TextUtils.isEmpty(localAbsBaseArticleInfo.thirdIcon)) {
          localObject1 = new URL("https://pub.idqqimg.com/pc/misc/files/20191114/1014c7cfd33e4333b818ceecc0885938.png");
        } else {
          localObject1 = new URL(localAbsBaseArticleInfo.thirdIcon);
        }
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.b);
        this.K.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("configVideoItemUI() ERROR e = ");
          ((StringBuilder)localObject3).append(localMalformedURLException.getMessage());
          QLog.d("FeedItemCellTypeNow", 2, ((StringBuilder)localObject3).toString());
        }
      }
      localObject3 = localAbsBaseArticleInfo.mSubscribeName;
      Object localObject2 = localObject3;
      if (((String)localObject3).length() > 18)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mSubscribeName.substring(0, 17));
        ((StringBuilder)localObject2).append("…");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      this.L.setText((CharSequence)localObject2);
      if (localIReadInJoyModel.m() == 0)
      {
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.O.setVisibility(0);
        this.O.setText(localAbsBaseArticleInfo.mTitle);
        this.P.setVisibility(0);
        this.Q.setVisibility(8);
        this.L.setTextColor(Color.argb(255, 157, 157, 157));
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(this.e, 5.0F), 0, 0, DisplayUtil.a(this.e, 2.0F));
        ((FrameLayout.LayoutParams)localObject2).gravity = 16;
        this.P.removeAllViews();
        this.P.addView(b(0), (ViewGroup.LayoutParams)localObject2);
        localObject2 = this.M;
        ((LinearLayout)localObject2).setPadding(((LinearLayout)localObject2).getPaddingLeft(), 0, this.M.getPaddingRight(), this.M.getPaddingBottom());
        localObject2 = this.M.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = DisplayUtil.a(this.e, 47.0F);
        this.M.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.M;
        ((LinearLayout)localObject2).setBackgroundColor(((LinearLayout)localObject2).getResources().getColor(2131168464));
        return this;
      }
      this.I.setVisibility(0);
      this.I.setText(localAbsBaseArticleInfo.mTitle);
      this.I.getPaint().setFakeBoldText(true);
      this.O.setVisibility(8);
      this.P.setVisibility(8);
      this.Q.setVisibility(0);
      this.L.setTextColor(-8947849);
      this.L.getPaint().setFakeBoldText(true);
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      this.Q.removeAllViews();
      this.Q.addView(b(56), (ViewGroup.LayoutParams)localObject2);
      if (localAbsBaseArticleInfo.mVideoPlayCount == 0)
      {
        this.J.setVisibility(8);
      }
      else
      {
        this.J.setText(VideoFeedsHelper.c(localAbsBaseArticleInfo.mVideoPlayCount));
        this.J.setVisibility(0);
      }
      this.N.setVisibility(8);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNow
 * JD-Core Version:    0.7.0.1
 */