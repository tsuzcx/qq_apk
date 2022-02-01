package com.tencent.mobileqq.nearby;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class NearbyFragmentEnterAdapter
{
  protected ArrayList<NearbyFragmentEnterAdapter.EnterItem> a = new ArrayList();
  protected int b;
  protected GradientDrawable c;
  protected List<ilive_feeds_near_anchor.NearAnchorInfo> d;
  protected int e = 0;
  protected Handler f;
  protected Drawable g;
  protected float h;
  protected LinearLayout i;
  protected NearbyFragmentEnterAdapter.OnItemClickListener j;
  Runnable k = new NearbyFragmentEnterAdapter.1(this);
  protected View.OnClickListener l = new NearbyFragmentEnterAdapter.3(this);
  
  public NearbyFragmentEnterAdapter(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.i = paramLinearLayout;
    this.h = ((float)(DeviceInfoUtil.D() * 2L / 9L));
    this.f = new Handler(Looper.getMainLooper());
    this.b = ((int)(this.h - DisplayUtil.a(paramContext, 20.0F)));
    int m = DisplayUtil.a(paramContext, 80.0F);
    if (this.b > m) {
      this.b = m;
    }
    this.g = paramContext.getResources().getDrawable(2130841062);
    this.c = new GradientDrawable();
    this.c.setColor(Color.parseColor("#FFDDDFE2"));
    this.c.setCornerRadius(this.b / 2);
    this.c.setShape(0);
    paramContext = this.c;
    m = this.b;
    paramContext.setSize(m, m);
  }
  
  public View a(Context paramContext, int paramInt)
  {
    NearbyFragmentEnterAdapter.EnterItem localEnterItem = (NearbyFragmentEnterAdapter.EnterItem)this.a.get(paramInt);
    View localView = LayoutInflater.from(paramContext).inflate(2131625504, this.i, false);
    NearbyFragmentEnterAdapter.ViewHolder localViewHolder = new NearbyFragmentEnterAdapter.ViewHolder();
    localViewHolder.c = ((URLImageView)localView.findViewById(2131435219));
    localViewHolder.d = ((URLImageView)localView.findViewById(2131435220));
    localViewHolder.b = ((TextView)localView.findViewById(2131448897));
    localViewHolder.e = ((URLImageView)localView.findViewById(2131435245));
    localViewHolder.a = ((LinearLayout)localView.findViewById(2131448941));
    localViewHolder.g = paramInt;
    localView.setTag(localViewHolder);
    localView.setOnClickListener(this.l);
    Object localObject = (RelativeLayout.LayoutParams)localViewHolder.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ((int)this.h);
    localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.c.getLayoutParams();
    paramInt = this.b;
    ((RelativeLayout.LayoutParams)localObject).width = paramInt;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt;
    localViewHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)localViewHolder.d.getLayoutParams();
    paramInt = this.b;
    ((RelativeLayout.LayoutParams)localObject).width = paramInt;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt;
    localViewHolder.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localViewHolder.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewHolder.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localObject = (View)localViewHolder.a.getParent();
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = ((int)this.h);
    ((View)localObject).setLayoutParams(localLayoutParams);
    localView.setTag(2131446778, Integer.valueOf(localEnterItem.d));
    if (localEnterItem.e != 0)
    {
      localViewHolder.f = new RedTouch(paramContext, localViewHolder.c);
      localViewHolder.f.c(53).a();
      localView.setTag(2131444531, Integer.valueOf(localEnterItem.e));
    }
    if (localEnterItem.d == 1)
    {
      paramContext = this.d;
      if (paramContext != null) {
        a(localViewHolder, (ilive_feeds_near_anchor.NearAnchorInfo)paramContext.get(this.e));
      } else {
        a(localViewHolder.d, localEnterItem.b);
      }
      localViewHolder.b.setTextColor(Color.parseColor("#05d380"));
      localViewHolder.e.setVisibility(0);
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif", paramContext);
      localViewHolder.e.setImageDrawable(paramContext);
      localViewHolder.e.setAdjustViewBounds(true);
      localViewHolder.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localViewHolder.c.setVisibility(4);
    }
    else
    {
      localViewHolder.c.setVisibility(0);
      localViewHolder.b.setTextColor(Color.parseColor("#777777"));
      localViewHolder.e.setVisibility(8);
      a(localViewHolder.c, localEnterItem.b);
    }
    localViewHolder.b.setText(localEnterItem.c);
    return localView;
  }
  
  public ilive_feeds_near_anchor.NearAnchorInfo a()
  {
    List localList = this.d;
    if (localList != null) {
      return (ilive_feeds_near_anchor.NearAnchorInfo)localList.get(this.e);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public void a(ImageView paramImageView, String paramString)
  {
    Object localObject2 = null;
    URLDrawable localURLDrawable2 = null;
    URLDrawable localURLDrawable1 = localURLDrawable2;
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.b;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.b;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.c;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.c;
      localURLDrawable1 = localURLDrawable2;
      ((URLDrawable.URLDrawableOptions)localObject1).mMemoryCacheKeySuffix = "nearby_fragment_enter_icon";
      localURLDrawable1 = localURLDrawable2;
      if (!TextUtils.isEmpty(paramString))
      {
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2 = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), (URLDrawable.URLDrawableOptions)localObject1);
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2.setTag(URLDrawableDecodeHandler.a(this.b, this.b));
        localURLDrawable1 = localURLDrawable2;
        localURLDrawable2.setDecodeHandler(URLDrawableDecodeHandler.b);
        localURLDrawable1 = localURLDrawable2;
        if (localURLDrawable2.getStatus() != 2)
        {
          localURLDrawable1 = localURLDrawable2;
          localObject1 = localURLDrawable2;
          if (localURLDrawable2.getStatus() != 3) {}
        }
        else
        {
          localURLDrawable1 = localURLDrawable2;
          localURLDrawable2.restartDownload();
          localURLDrawable1 = localURLDrawable2;
          localObject1 = localURLDrawable2;
          if (QLog.isColorLevel())
          {
            localURLDrawable1 = localURLDrawable2;
            QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage restartDownload");
            localObject1 = localURLDrawable2;
          }
        }
      }
      else
      {
        localURLDrawable1 = localURLDrawable2;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localURLDrawable1 = localURLDrawable2;
          QLog.w("NearbyFragmentEnterAdapter", 2, "loadImage empty url");
          localObject1 = localObject2;
        }
      }
    }
    catch (Exception localException)
    {
      paramImageView.setImageDrawable(this.c);
      localObject1 = localURLDrawable1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("loadImage exp: url=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(localException.toString());
        QLog.w("NearbyFragmentEnterAdapter", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localURLDrawable1;
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = this.c;
    }
    paramImageView.setImageDrawable(paramString);
  }
  
  public void a(NearbyFragmentEnterAdapter.OnItemClickListener paramOnItemClickListener)
  {
    this.j = paramOnItemClickListener;
  }
  
  @RequiresApi(api=11)
  protected void a(NearbyFragmentEnterAdapter.ViewHolder paramViewHolder, ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.g;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    int m = this.b;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = m;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = m;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_fragment_live_avatar";
    paramNearAnchorInfo = URLDrawable.getDrawable(paramNearAnchorInfo.cover_url.get().toStringUtf8(), (URLDrawable.URLDrawableOptions)localObject);
    m = this.b;
    paramNearAnchorInfo.setTag(URLDrawableDecodeHandler.a(m, m));
    paramNearAnchorInfo.setDecodeHandler(URLDrawableDecodeHandler.b);
    if (this.d.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(paramViewHolder.d, "alpha", new float[] { 1.0F, 0.2F });
      ((ObjectAnimator)localObject).setInterpolator(new AccelerateInterpolator());
      ((ObjectAnimator)localObject).addListener(new NearbyFragmentEnterAdapter.2(this, paramViewHolder, paramNearAnchorInfo));
      ((ObjectAnimator)localObject).setDuration(300L).start();
      return;
    }
    paramViewHolder.d.setImageDrawable(paramNearAnchorInfo);
  }
  
  public void a(INearbyAppInterface paramINearbyAppInterface)
  {
    INearbyProcManager localINearbyProcManager = paramINearbyAppInterface.getNearbyProcManager();
    if (localINearbyProcManager == null) {
      return;
    }
    int m = 0;
    while (m < this.i.getChildCount())
    {
      Object localObject2 = this.i.getChildAt(m);
      if ((localObject2 != null) && (((View)localObject2).getTag() != null))
      {
        NearbyFragmentEnterAdapter.ViewHolder localViewHolder = (NearbyFragmentEnterAdapter.ViewHolder)((View)localObject2).getTag();
        Object localObject1 = (Integer)((View)localObject2).getTag(2131444531);
        localObject2 = (Integer)((View)localObject2).getTag(2131446778);
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = localINearbyProcManager.a(((Integer)localObject1).intValue());
          boolean bool1 = localViewHolder.f.h();
          localViewHolder.f.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          boolean bool2 = localViewHolder.f.h();
          if ((bool1) && (!bool2)) {
            NearbyUtils.b((AppInterface)paramINearbyAppInterface, "op_red_clear", ((Integer)localObject2).intValue());
          } else if ((!bool1) && (bool2)) {
            NearbyUtils.b((AppInterface)paramINearbyAppInterface, "op_red_push", ((Integer)localObject2).intValue());
          }
        }
      }
      m += 1;
    }
  }
  
  public void a(List<NearbyFragmentEnterAdapter.EnterItem> paramList)
  {
    this.a.clear();
    if (paramList != null) {
      this.a.addAll(paramList);
    }
    this.i.removeAllViews();
    int n = this.a.size();
    int m = 0;
    while (m < n)
    {
      paramList = a(this.i.getContext(), m);
      this.i.addView(paramList);
      m += 1;
    }
  }
  
  protected NearbyFragmentEnterAdapter.ViewHolder b()
  {
    int m = 0;
    while (m < this.i.getChildCount())
    {
      View localView = this.i.getChildAt(m);
      if ((localView != null) && (((Integer)localView.getTag(2131446778)).intValue() == 1)) {
        return (NearbyFragmentEnterAdapter.ViewHolder)localView.getTag();
      }
      m += 1;
    }
    return null;
  }
  
  public void b(List<ilive_feeds_near_anchor.NearAnchorInfo> paramList)
  {
    this.d = paramList;
    this.f.removeCallbacksAndMessages(null);
    paramList = this.d;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.e = 0;
      this.f.post(this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter
 * JD-Core Version:    0.7.0.1
 */