package com.tencent.mobileqq.comment.danmaku.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.common.danmaku.render.ViewDanmakuRender;
import com.tencent.common.danmaku.render.ViewDanmakuRender.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class CommentDanmakuRender
  extends ViewDanmakuRender
{
  private Context a;
  private int b;
  private Bitmap c;
  private BitmapDrawable d;
  private INonMainProcAvatarLoader e;
  private ConcurrentHashMap<String, List<CommentDanmakuRender.HeadRequestInfo>> f;
  private int g;
  private String h;
  private ViewGroup.LayoutParams i;
  
  public CommentDanmakuRender(Context paramContext)
  {
    this.a = paramContext;
    this.b = Color.parseColor("#00CAFC");
    this.c = BaseImageUtil.k();
    if (this.c != null) {
      this.d = new BitmapDrawable(this.a.getResources(), this.c);
    }
    this.g = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getChatEmotionSizeWithDP();
    this.f = new ConcurrentHashMap();
    this.h = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    this.i = new ViewGroup.LayoutParams(-2, DisplayUtil.a(paramContext, 21.0F));
    b();
  }
  
  private void a(CommentDanmaku paramCommentDanmaku, RoundImageView paramRoundImageView, ViewDanmaku paramViewDanmaku)
  {
    if (paramCommentDanmaku.g)
    {
      paramCommentDanmaku = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getAnonymousHeadUrl(paramCommentDanmaku.i);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.d;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable(paramCommentDanmaku, (URLDrawable.URLDrawableOptions)localObject1);
      if (localObject1 != null)
      {
        if (((URLDrawable)localObject1).getStatus() == 1)
        {
          paramRoundImageView.setImageDrawable((Drawable)localObject1);
          return;
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new CommentDanmakuRender.2(this, paramRoundImageView, paramViewDanmaku, paramCommentDanmaku));
        ((URLDrawable)localObject1).startDownload();
      }
      return;
    }
    Object localObject2 = (List)this.f.get(paramCommentDanmaku.b);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    ((List)localObject1).add(new CommentDanmakuRender.HeadRequestInfo(this, paramRoundImageView, paramViewDanmaku));
    this.f.put(paramCommentDanmaku.b, localObject1);
    paramRoundImageView.setImageBitmap(this.e.a(paramCommentDanmaku.b, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.h)) && (paramString.equals(this.h));
  }
  
  private void b()
  {
    this.e = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.a, 1);
    this.e.a();
    this.e.a(new CommentDanmakuRender.1(this));
  }
  
  public ViewDanmakuRender.ViewHolder a(int paramInt)
  {
    View localView = LayoutInflater.from(this.a).inflate(2131629204, null);
    localView.setLayoutParams(this.i);
    return new CommentDanmakuRender.CommentDanmakuViewHolder(this, localView);
  }
  
  public void a()
  {
    INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.e;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.c();
    }
  }
  
  public void a(int paramInt, ViewDanmakuRender.ViewHolder paramViewHolder, ViewDanmaku paramViewDanmaku)
  {
    if ((paramViewDanmaku != null) && ((paramViewDanmaku.r() instanceof CommentDanmaku)) && ((paramViewHolder instanceof CommentDanmakuRender.CommentDanmakuViewHolder)))
    {
      CommentDanmaku localCommentDanmaku = (CommentDanmaku)paramViewDanmaku.r();
      paramViewHolder = (CommentDanmakuRender.CommentDanmakuViewHolder)paramViewHolder;
      paramViewHolder.c.setText(new QQText(localCommentDanmaku.a(), 3, this.g));
      TextView localTextView = paramViewHolder.c;
      if (a(localCommentDanmaku.b)) {
        paramInt = this.b;
      } else {
        paramInt = -1;
      }
      localTextView.setTextColor(paramInt);
      paramViewHolder.c.setAlpha(0.85F);
      a(localCommentDanmaku, paramViewHolder.b, paramViewDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender
 * JD-Core Version:    0.7.0.1
 */