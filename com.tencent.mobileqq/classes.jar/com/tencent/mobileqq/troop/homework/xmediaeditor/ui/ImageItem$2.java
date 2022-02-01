package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class ImageItem$2
  extends SimpleObserver<ImageInfo>
{
  ImageItem$2(ImageItem paramImageItem, ImageInfo paramImageInfo) {}
  
  public void a(ImageInfo paramImageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(paramImageInfo.g), ", old status=", Integer.valueOf(paramImageInfo.o), ", result=", paramImageInfo });
    }
    paramImageInfo.o = 3;
    paramImageInfo.l = 100;
    this.b.d.remove(paramImageInfo);
    if (this.b.b != null)
    {
      Object localObject = this.b.b.findViewHolderForLayoutPosition(this.a.g);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(paramImageInfo.hashCode()), ", result hash=", Integer.valueOf(paramImageInfo.hashCode()), ", info position=", Integer.valueOf(paramImageInfo.g), ", result position=", Integer.valueOf(paramImageInfo.g), ", vh position=", Integer.valueOf(((ImageItem.ImageViewHolder)localObject).f.g), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramImageInfo.e.equals(((ImageItem.ImageViewHolder)localObject).g.getTag()))
        {
          ((ImageItem.ImageViewHolder)localObject).g.setVisibility(0);
          ((ImageItem.ImageViewHolder)localObject).g.setDrawStatus(1);
          ((ImageItem.ImageViewHolder)localObject).g.setAnimProgress(paramImageInfo.l, paramImageInfo.e);
        }
        this.b.c.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    TroopReportor.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - paramImageInfo.n), "");
    this.b.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.a.g), ", info hash=", Integer.valueOf(this.a.hashCode()), ", info old status=", Integer.valueOf(this.a.o) });
    }
    this.a.o = 2;
    this.b.d.remove(this.a);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.b.b != null)
    {
      Object localObject = this.b.b.findViewHolderForLayoutPosition(this.a.g);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (this.a.e.equals(((ImageItem.ImageViewHolder)localObject).g.getTag())) {
          ((ImageItem)((XMediaEditorAdapter)this.b.b.getAdapter()).a.a(1)).a((ImageItem.ImageViewHolder)localObject, this.a, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      TroopReportor.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.a.n), "");
    }
    if (this.a.e.equals(this.b.e)) {
      this.b.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.2
 * JD-Core Version:    0.7.0.1
 */