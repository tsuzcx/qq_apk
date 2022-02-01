package com.tencent.mobileqq.troop.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TroopAvatarBigPhotoAdapter
  extends BaseAdapter
{
  Context a;
  int b;
  QQAppInterface c;
  String d;
  boolean e = false;
  String f = null;
  Setting g = null;
  boolean h = true;
  boolean i = false;
  WeakReference<TextView> j = null;
  int k;
  int l;
  float m;
  float n;
  boolean o;
  boolean p;
  ArrayList<Integer> q;
  protected List<String> r;
  protected List<String> s;
  
  public TroopAvatarBigPhotoAdapter(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.a = paramContext;
    this.b = ((int)paramContext.getResources().getDimension(2131298203));
  }
  
  private URL a(URL paramURL)
  {
    URL localURL = paramURL;
    if (!TextUtils.isEmpty(this.f))
    {
      localURL = paramURL;
      if ("2000".equals(this.f))
      {
        localURL = paramURL;
        if (paramURL.getProtocol().startsWith("http"))
        {
          paramURL = paramURL.toString();
          localURL = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramURL, 2);
        }
      }
    }
    return localURL;
  }
  
  private boolean b(int paramInt)
  {
    List localList = this.s;
    return (localList != null) && (localList.size() > paramInt) && (!TextUtils.isEmpty((CharSequence)this.s.get(paramInt))) && (AbsDownloader.getFile((String)this.s.get(paramInt)) != null);
  }
  
  public String a(int paramInt)
  {
    if ((this.r != null) && (paramInt < getCount())) {
      return (String)this.r.get(paramInt);
    }
    return null;
  }
  
  void a()
  {
    Object localObject = new int[2];
    int i1 = ((Integer)this.q.get(0)).intValue();
    int i2 = ((Integer)this.q.get(1)).intValue();
    int i3 = ((Integer)this.q.get(2)).intValue();
    int i4 = ((Integer)this.q.get(3)).intValue();
    this.k = (i1 - localObject[0]);
    this.l = (i2 - localObject[1]);
    this.m = (i3 / ViewUtils.getScreenWidth());
    this.n = (i4 / ViewUtils.getScreenHeight());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("calculateScale()   leftLocation = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" topLocation = ");
      ((StringBuilder)localObject).append(i2);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, TroopAvatarBigPhotoAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.c == null) {
        return;
      }
      URLImageView localURLImageView = paramViewHolder.a;
      ImageProgressCircle localImageProgressCircle = paramViewHolder.b;
      paramViewHolder = a(paramInt);
      if ((!this.i) && (!b(paramInt)))
      {
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
      }
      else
      {
        paramViewHolder = (String)this.s.get(paramInt);
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
      }
      if (TextUtils.isEmpty(paramViewHolder)) {
        return;
      }
      if (!this.e)
      {
        localObject2 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        if (((ITroopAvatarUtilApi)localObject2).isNumeric(paramViewHolder))
        {
          if ((paramViewHolder != null) && (paramViewHolder.equals(AvatarInfo.a))) {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.d, 0);
          } else {
            localObject1 = ((ITroopAvatarUtilApi)localObject2).getAvatarAddress(paramViewHolder, this.d, 1);
          }
          localObject1 = ((ITroopAvatarUtilApi)localObject2).getArtWork((String)localObject1);
          break label179;
        }
      }
      Object localObject1 = paramViewHolder;
      label179:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadThumbImage() path = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = Uri.parse((String)localObject1).getScheme();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("http")) || (((String)localObject2).equals("https")))) {
        try
        {
          if (this.p) {
            localObject1 = new URL("qzone_cover", "original", (String)localObject1);
          } else {
            localObject1 = new URL((String)localObject1);
          }
        }
        catch (MalformedURLException paramViewHolder)
        {
          if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
          }
          return;
        }
      }
      try
      {
        localObject1 = new File((String)localObject1).toURL();
        localObject1 = a((URL)localObject1);
        localObject2 = this.g;
        if (((localObject2 == null) || (((Setting)localObject2).bHeadType == 0)) && (paramViewHolder != null) && (paramViewHolder.equals(AvatarInfo.a)))
        {
          localURLImageView.setImageResource(2130843538);
          return;
        }
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mRequestWidth = this.a.getResources().getDisplayMetrics().widthPixels;
        paramViewHolder.mRequestHeight = this.a.getResources().getDisplayMetrics().heightPixels;
        paramViewHolder.mLoadingDrawable = URLDrawableHelperConstants.a;
        if (this.h) {
          paramViewHolder.mPlayGifImage = true;
        }
        localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject1, paramViewHolder));
        if ((!this.o) && (this.p) && (this.q != null))
        {
          a(localURLImageView);
          this.o = true;
        }
        if (QLog.isColorLevel())
        {
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("loadBigMap() mWidthScale = ");
          paramViewHolder.append(this.m);
          paramViewHolder.append(" mHeightScale = ");
          paramViewHolder.append(this.n);
          QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        }
        a(localImageProgressCircle);
        localURLImageView.setURLDrawableDownListener(new TroopAvatarBigPhotoAdapter.1(this, localImageProgressCircle, localURLImageView));
        return;
      }
      catch (MalformedURLException paramViewHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, paramViewHolder.toString());
        }
      }
    }
  }
  
  public void a(TextView paramTextView)
  {
    this.j = new WeakReference(paramTextView);
  }
  
  void a(URLImageView paramURLImageView)
  {
    a();
    paramURLImageView.setPivotX(0.0F);
    paramURLImageView.setPivotY(0.0F);
    paramURLImageView.setScaleX(this.m);
    paramURLImageView.setScaleY(this.n);
    paramURLImageView.setTranslationX(this.k);
    paramURLImageView.setTranslationY(this.l);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterAnimation()   mWidthScale = ");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(" mHeightScale = ");
      ((StringBuilder)localObject).append(this.n);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterAnimation()   mLeftDelta = ");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append(" mTopDelta = ");
      ((StringBuilder)localObject).append(this.l);
      QLog.i("TroopAvatarBigPhotoAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new DecelerateInterpolator();
    paramURLImageView.animate().setDuration(200L).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setInterpolator((TimeInterpolator)localObject);
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {
      return;
    }
    if (paramImageProgressCircle.getVisibility() != 4) {
      paramImageProgressCircle.setVisibility(4);
    }
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, Setting paramSetting)
  {
    this.d = paramString;
    this.g = paramSetting;
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    this.q = paramArrayList;
  }
  
  public void a(List<String> paramList)
  {
    this.r = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b(List<String> paramList)
  {
    this.s = paramList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public int getCount()
  {
    List localList = this.r;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624516, null);
      paramView = new TroopAvatarBigPhotoAdapter.ViewHolder(this);
      paramView.a = ((URLImageView)localView.findViewById(2131435357));
      paramView.b = ((ImageProgressCircle)localView.findViewById(2131435466));
      localView.setTag(paramView);
    }
    else
    {
      TroopAvatarBigPhotoAdapter.ViewHolder localViewHolder = (TroopAvatarBigPhotoAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    a(paramView.b);
    a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter
 * JD-Core Version:    0.7.0.1
 */