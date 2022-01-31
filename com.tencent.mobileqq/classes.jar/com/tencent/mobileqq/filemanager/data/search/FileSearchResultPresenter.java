package com.tencent.mobileqq.filemanager.data.search;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.List;

public class FileSearchResultPresenter
  extends SearchResultPresenter
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public FileSearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultView.e() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.e().setVisibility(0);
      paramISearchResultView.e().setText(paramISearchResultModel.a());
    }
    if ((paramISearchResultView.f() != null) && (!TextUtils.isEmpty(paramISearchResultModel.b())))
    {
      paramISearchResultView.f().setVisibility(0);
      paramISearchResultView.f().setText(paramISearchResultModel.b());
    }
    if ((paramISearchResultView.g() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.g().setVisibility(0);
      paramISearchResultView.g().setText(paramISearchResultModel.c());
    }
    if ((paramISearchResultModel.d() == null) && (paramISearchResultView.h() != null)) {
      paramISearchResultView.h().setVisibility(8);
    }
    if ((paramISearchResultView.h() != null) && (paramISearchResultModel.d() != null))
    {
      paramISearchResultView.h().setVisibility(0);
      paramISearchResultView.h().setText(paramISearchResultModel.d());
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView.e().setMaxWidth(800);
    Object localObject1 = (FileEntitySearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.a();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((FileEntitySearchResultModel)localObject1).a == null) {
      return;
    }
    Object localObject2 = (FileManagerEntity)((FileEntitySearchResultModel)localObject1).a.get(0);
    localObject1 = ((FileManagerEntity)localObject2).fileName;
    if (FileManagerUtil.a((String)localObject1) == 0)
    {
      if (FileUtils.b(((FileManagerEntity)localObject2).strThumbPath)) {}
      for (localObject1 = ((FileManagerEntity)localObject2).strThumbPath;; localObject1 = ((FileManagerEntity)localObject2).strFilePath)
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramISearchResultView.a().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramISearchResultView.a().getWidth();
        paramISearchResultView = paramISearchResultView.h();
        if (!TextUtils.isEmpty(paramISearchResultModel.d()))
        {
          paramISearchResultView.setText(paramISearchResultModel.d());
          paramISearchResultView.setVisibility(0);
        }
        paramISearchResultModel = AsyncImageView.a((String)localObject1, ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight, new File((String)localObject1), false, false);
        if (paramISearchResultModel == null) {
          break;
        }
        paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, (URLDrawable.URLDrawableOptions)localObject2);
        if (paramISearchResultModel == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130841666));
        }
        localImageView.setImageDrawable(paramISearchResultModel);
        return;
        if (!FileUtils.b(((FileManagerEntity)localObject2).strFilePath)) {
          break label250;
        }
      }
      label250:
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (((FileManagerEntity)localObject2).getCloudType() == 1) {
        localObject1 = ((QQAppInterface)localObject1).a().a((FileManagerEntity)localObject2, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130841666));
        return;
        if (((FileManagerEntity)localObject2).getCloudType() == 2) {
          localObject1 = ((QQAppInterface)localObject1).a().a(((FileManagerEntity)localObject2).WeiYunFileId, ((FileManagerEntity)localObject2).strLargeThumPath, 3, localObject2);
        }
      }
      else
      {
        ((FileManagerEntity)localObject2).strThumbPath = ((String)localObject1);
        break;
        FileManagerUtil.a(localImageView, (String)localObject1);
        return;
      }
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */