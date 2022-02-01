package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.MiniProgramSearchResultView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.util.URLUtil;

public class MiniProgramSearchResultPresenter
  extends SearchResultPresenter
{
  protected MiniProgramSearchResultPresenter.OnActionListener a = null;
  
  public MiniProgramSearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    if (paramISearchResultModel.c() == 103)
    {
      if (paramISearchResultView.b() != null) {
        paramISearchResultView.b().setImageDrawable(SearchUtils.a(paramBitmap));
      }
      return;
    }
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultModel instanceof MiniProgramSearchResultModel)) {}
    for (Object localObject1 = (MiniProgramSearchResultModel)paramISearchResultModel;; localObject1 = null)
    {
      if ((paramISearchResultView instanceof MiniProgramSearchResultView)) {}
      for (MiniProgramSearchResultView localMiniProgramSearchResultView = (MiniProgramSearchResultView)paramISearchResultView;; localMiniProgramSearchResultView = null)
      {
        Object localObject2;
        ColorDrawable localColorDrawable;
        if (paramISearchResultModel.c() == null)
        {
          if (localMiniProgramSearchResultView.c() != null) {
            localMiniProgramSearchResultView.c().setVisibility(8);
          }
          if (localMiniProgramSearchResultView.a() != null) {
            localMiniProgramSearchResultView.a().setVisibility(8);
          }
          localObject2 = localMiniProgramSearchResultView.a();
          if (localObject2 != null) {
            ((URLImageView)localObject2).setVisibility(8);
          }
          localObject2 = localMiniProgramSearchResultView.e();
          if (localObject2 != null)
          {
            ((TextView)localObject2).setVisibility(0);
            if (!TextUtils.isEmpty(((MiniProgramSearchResultModel)localObject1).a())) {
              ((TextView)localObject2).setText(((MiniProgramSearchResultModel)localObject1).a());
            }
          }
          if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(((MiniProgramSearchResultModel)localObject1).g())))
          {
            localObject2 = ((MiniProgramSearchResultModel)localObject1).g();
            localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestWidth = DisplayUtil.a(paramISearchResultView.a().getContext(), 50.0F);
            localURLDrawableOptions.mRequestHeight = DisplayUtil.a(paramISearchResultView.a().getContext(), 50.0F);
            localURLDrawableOptions.mFailedDrawable = localColorDrawable;
            localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
            if (!URLUtil.a((String)localObject2)) {
              break label625;
            }
            localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramISearchResultView.a().getContext(), 50.0F), DisplayUtil.a(paramISearchResultView.a().getContext(), 50.0F), DisplayUtil.a(paramISearchResultView.a().getContext(), 3.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.j);
            paramISearchResultView.b().setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
        }
        for (;;)
        {
          c(paramISearchResultModel, paramISearchResultView);
          if ((localMiniProgramSearchResultView.a() != null) && (((MiniProgramSearchResultModel)localObject1).c()))
          {
            paramISearchResultModel = ((MiniProgramSearchResultModel)localObject1).h();
            localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = DisplayUtil.a(paramISearchResultView.a().getContext(), 40.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = DisplayUtil.a(paramISearchResultView.a().getContext(), 12.0F);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
            paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, (URLDrawable.URLDrawableOptions)localObject2);
            paramISearchResultModel.setTag(URLDrawableDecodeHandler.b(DisplayUtil.a(paramISearchResultView.a().getContext(), 38.0F), DisplayUtil.a(paramISearchResultView.a().getContext(), 12.0F), 0));
            paramISearchResultModel.setDecodeHandler(URLDrawableDecodeHandler.j);
            localMiniProgramSearchResultView.a().setImageDrawable(paramISearchResultModel);
            if ((paramISearchResultModel.getStatus() != 1) && (paramISearchResultModel.getStatus() != 0)) {
              paramISearchResultModel.restartDownload();
            }
          }
          return;
          if ((localMiniProgramSearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
          {
            localMiniProgramSearchResultView.c().setVisibility(0);
            localMiniProgramSearchResultView.c().setText(paramISearchResultModel.c());
          }
          for (;;)
          {
            if (localMiniProgramSearchResultView.a() != null) {
              localMiniProgramSearchResultView.a().setVisibility(0);
            }
            localObject2 = localMiniProgramSearchResultView.e();
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(8);
            }
            if (TextUtils.isEmpty(paramISearchResultModel.a())) {
              break;
            }
            localMiniProgramSearchResultView.a().setText(((MiniProgramSearchResultModel)localObject1).a());
            break;
            if (paramISearchResultView.c() != null) {
              localMiniProgramSearchResultView.c().setVisibility(8);
            }
          }
          label625:
          paramISearchResultView.b().setImageDrawable(localColorDrawable);
        }
      }
    }
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.a != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new MiniProgramSearchResultPresenter.1(this));
      }
      return;
    }
    super.c(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MiniProgramSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */