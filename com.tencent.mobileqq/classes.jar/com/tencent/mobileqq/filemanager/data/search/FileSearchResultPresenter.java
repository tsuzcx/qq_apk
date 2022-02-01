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
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
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
    paramISearchResultView.a().setMaxWidth(800);
    Object localObject = (FileEntitySearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.b();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView.setImageDrawable(null);
    localImageView.setBackgroundDrawable(null);
    if (((FileEntitySearchResultModel)localObject).a == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((FileEntitySearchResultModel)localObject).a.get(0);
    int i = FileManagerUtil.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      if (FileUtils.b(localFileManagerEntity.strThumbPath)) {
        localObject = localFileManagerEntity.strThumbPath;
      }
      for (;;)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramISearchResultView.b().getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramISearchResultView.b().getWidth();
        paramISearchResultView = paramISearchResultView.d();
        if ((paramISearchResultView != null) && (!TextUtils.isEmpty(paramISearchResultModel.d())))
        {
          paramISearchResultView.setText(paramISearchResultModel.d());
          paramISearchResultView.setVisibility(0);
        }
        paramISearchResultModel = FilePicURLDrawlableHelper.a(localFileManagerEntity);
        if (paramISearchResultModel == null) {
          break;
        }
        paramISearchResultModel = URLDrawable.getDrawable(paramISearchResultModel, (URLDrawable.URLDrawableOptions)localObject);
        if (paramISearchResultModel == null) {
          localImageView.setImageDrawable(localImageView.getContext().getResources().getDrawable(2130844458));
        }
        localImageView.setImageDrawable(paramISearchResultModel);
        return;
        if (FileUtils.b(localFileManagerEntity.strLargeThumPath))
        {
          localObject = localFileManagerEntity.strLargeThumPath;
        }
        else
        {
          if (!FileUtils.b(localFileManagerEntity.getFilePath())) {
            break label265;
          }
          localFileManagerEntity.getFilePath();
        }
      }
      label265:
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localFileManagerEntity.getCloudType() == 1) {
        localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity, 7);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localImageView.setImageDrawable(BaseApplicationImpl.getContext().getResources().getDrawable(2130844458));
        return;
        if (localFileManagerEntity.getCloudType() == 2) {
          localObject = ((QQAppInterface)localObject).getFileManagerEngine().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.strLargeThumPath, 3, localFileManagerEntity);
        }
      }
      else
      {
        localFileManagerEntity.strThumbPath = ((String)localObject);
        break;
        FileManagerUtil.a(localImageView, localFileManagerEntity);
        return;
      }
      localObject = "";
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultView.a() != null) && (!TextUtils.isEmpty(paramISearchResultModel.a())))
    {
      paramISearchResultView.a().setVisibility(0);
      paramISearchResultView.a().setText(paramISearchResultModel.a());
    }
    if ((paramISearchResultView.b() != null) && (!TextUtils.isEmpty(paramISearchResultModel.b())))
    {
      paramISearchResultView.b().setVisibility(0);
      paramISearchResultView.b().setText(paramISearchResultModel.b());
    }
    if ((paramISearchResultView.c() != null) && (!TextUtils.isEmpty(paramISearchResultModel.c())))
    {
      paramISearchResultView.c().setVisibility(0);
      paramISearchResultView.c().setText(paramISearchResultModel.c());
    }
    if ((paramISearchResultModel.d() == null) && (paramISearchResultView.d() != null)) {
      paramISearchResultView.d().setVisibility(8);
    }
    if ((paramISearchResultView.d() != null) && (paramISearchResultModel.d() != null))
    {
      paramISearchResultView.d().setVisibility(0);
      paramISearchResultView.d().setText(paramISearchResultModel.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */