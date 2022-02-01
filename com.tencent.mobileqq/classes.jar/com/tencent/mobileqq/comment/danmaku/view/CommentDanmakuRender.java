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
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.danmaku.render.ViewDanmakuRender;
import com.tencent.mobileqq.danmaku.render.ViewDanmakuRender.ViewHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

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
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.b = ChatTextSizeSettingActivity.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, DisplayUtil.a(paramContext, 21.0F));
    b();
  }
  
  private void a(CommentDanmaku paramCommentDanmaku, RoundImageView paramRoundImageView, ViewDanmaku paramViewDanmaku)
  {
    if (paramCommentDanmaku.jdField_a_of_type_Boolean)
    {
      paramCommentDanmaku = AnonymousChatHelper.a(paramCommentDanmaku.jdField_a_of_type_Int);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      localObject = URLDrawable.getDrawable(paramCommentDanmaku, (URLDrawable.URLDrawableOptions)localObject);
      if (localObject != null)
      {
        if (((URLDrawable)localObject).getStatus() == 1) {
          paramRoundImageView.setImageDrawable((Drawable)localObject);
        }
      }
      else {
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new CommentDanmakuRender.2(this, paramRoundImageView, paramViewDanmaku, paramCommentDanmaku));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramCommentDanmaku.jdField_a_of_type_JavaLangString);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new CommentDanmakuRender.HeadRequestInfo(this, paramRoundImageView, paramViewDanmaku));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramCommentDanmaku.jdField_a_of_type_JavaLangString, localObject);
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558999, null);
    localView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    return new CommentDanmakuRender.CommentDanmakuViewHolder(this, localView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    }
  }
  
  public void a(int paramInt, ViewDanmakuRender.ViewHolder paramViewHolder, ViewDanmaku paramViewDanmaku)
  {
    CommentDanmaku localCommentDanmaku;
    TextView localTextView;
    if ((paramViewDanmaku != null) && ((paramViewDanmaku.a() instanceof CommentDanmaku)) && ((paramViewHolder instanceof CommentDanmakuRender.CommentDanmakuViewHolder)))
    {
      localCommentDanmaku = (CommentDanmaku)paramViewDanmaku.a();
      paramViewHolder = (CommentDanmakuRender.CommentDanmakuViewHolder)paramViewHolder;
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(localCommentDanmaku.a(), 3, this.b));
      localTextView = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      if (!a(localCommentDanmaku.jdField_a_of_type_JavaLangString)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.jdField_a_of_type_Int;; paramInt = -1)
    {
      localTextView.setTextColor(paramInt);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.85F);
      a(localCommentDanmaku, paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramViewDanmaku);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender
 * JD-Core Version:    0.7.0.1
 */