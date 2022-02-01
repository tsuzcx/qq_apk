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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.danmaku.render.ViewDanmakuRender;
import com.tencent.mobileqq.danmaku.render.ViewDanmakuRender.ViewHolder;
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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, List<CommentDanmakuRender.HeadRequestInfo>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b;
  
  public CommentDanmakuRender(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = Color.parseColor("#00CAFC");
    this.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.f();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getChatEmotionSizeWithDP();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, DisplayUtil.a(paramContext, 21.0F));
    b();
  }
  
  private void a(CommentDanmaku paramCommentDanmaku, RoundImageView paramRoundImageView, ViewDanmaku paramViewDanmaku)
  {
    if (paramCommentDanmaku.jdField_a_of_type_Boolean)
    {
      paramCommentDanmaku = ((ICommentDanmakuDepend)QRoute.api(ICommentDanmakuDepend.class)).getAnonymousHeadUrl(paramCommentDanmaku.jdField_a_of_type_Int);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
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
    Object localObject2 = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramCommentDanmaku.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    ((List)localObject1).add(new CommentDanmakuRender.HeadRequestInfo(this, paramRoundImageView, paramViewDanmaku));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramCommentDanmaku.jdField_a_of_type_JavaLangString, localObject1);
    paramRoundImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(paramCommentDanmaku.jdField_a_of_type_JavaLangString, true));
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new CommentDanmakuRender.1(this));
  }
  
  public ViewDanmakuRender.ViewHolder a(int paramInt)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562762, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new CommentDanmakuRender.CommentDanmakuViewHolder(this, localView);
  }
  
  public void a()
  {
    INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
    if (localINonMainProcAvatarLoader != null) {
      localINonMainProcAvatarLoader.b();
    }
  }
  
  public void a(int paramInt, ViewDanmakuRender.ViewHolder paramViewHolder, ViewDanmaku paramViewDanmaku)
  {
    if ((paramViewDanmaku != null) && ((paramViewDanmaku.a() instanceof CommentDanmaku)) && ((paramViewHolder instanceof CommentDanmakuRender.CommentDanmakuViewHolder)))
    {
      CommentDanmaku localCommentDanmaku = (CommentDanmaku)paramViewDanmaku.a();
      paramViewHolder = (CommentDanmakuRender.CommentDanmakuViewHolder)paramViewHolder;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(localCommentDanmaku.a(), 3, this.b));
      TextView localTextView = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (a(localCommentDanmaku.jdField_a_of_type_JavaLangString)) {
        paramInt = this.jdField_a_of_type_Int;
      } else {
        paramInt = -1;
      }
      localTextView.setTextColor(paramInt);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.85F);
      a(localCommentDanmaku, paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramViewDanmaku);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender
 * JD-Core Version:    0.7.0.1
 */