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
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class FileSearchResultPresenter
  extends SearchResultPresenter
{
  private BitmapFactory.Options a = new BitmapFactory.Options();
  
  public FileSearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(paramISearchResultModel.d())))
    {
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel.d());
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.e())))
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.e());
    }
    if ((paramISearchResultView.d() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.a());
    }
    if ((paramISearchResultModel.f() == null) && (paramISearchResultView.e() != null)) {
      paramISearchResultView.e().setVisibility(8);
    }
    if ((paramISearchResultView.e() != null) && (paramISearchResultModel.f() != null))
    {
      paramISearchResultView.e().setVisibility(0);
      paramISearchResultView.e().setText(paramISearchResultModel.f());
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView.b().setMaxWidth(800);
    Object localObject = (FileEntitySearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.g();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((FileEntitySearchResultModel)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((FileEntitySearchResultModel)localObject).a.get(0);
    int i = FileManagerUtil.c(localFileManagerEntity.fileName);
    if ((i != 0) && (i != 2))
    {
      FileManagerUtil.a(localImageView, localFileManagerEntity);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strThumbPath))
    {
      localObject = localFileManagerEntity.strThumbPath;
    }
    else if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))
    {
      localObject = localFileManagerEntity.strLargeThumPath;
    }
    else if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath()))
    {
      localFileManagerEntity.getFilePath();
    }
    else
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity, 7);
      } else if (localFileManagerEntity.getCloudType() == 2) {
        localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
      } else {
        localObject = "";
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130845680));
        return;
      }
      localFileManagerEntity.strThumbPath = ((String)localObject);
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramISearchResultView.g().getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramISearchResultView.g().getWidth();
    paramISearchResultView = paramISearchResultView.e();
    if ((paramISearchResultView != null) && (!TextUtils.isEmpty(paramISearchResultModel.f())))
    {
      paramISearchResultView.setText(paramISearchResultModel.f());
      paramISearchResultView.setVisibility(0);
    }
    paramISearchResultModel = FilePicURLDrawlableHelper.a(localFileManagerEntity);
    if (paramISearchResultModel != null)
    {
      paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, (URLDrawable.URLDrawableOptions)localObject);
      if (paramISearchResultModel == null) {
        localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130845680));
      }
      localImageView.setImageDrawable(paramISearchResultModel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */