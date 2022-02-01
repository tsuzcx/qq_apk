package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.net.URL;

public class LocalMediaGridAdapter$ImageHolder
  extends BaseViewHolder<AlbumUtils.LocalMediaInfo>
{
  public ImageView a = (ImageView)getView(2131436334);
  public View b = getView(2131437989);
  
  public LocalMediaGridAdapter$ImageHolder(LocalMediaGridAdapter paramLocalMediaGridAdapter, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected URL a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append("FLOW_THUMB");
    try
    {
      paramString = new URL(localStringBuilder.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public void a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool;
    if (LocalMediaGridAdapter.a(this.c) == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    this.a.setOnClickListener(new LocalMediaGridAdapter.ImageHolder.1(this, paramInt));
    a(paramLocalMediaInfo);
  }
  
  protected void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.a.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.a.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = LocalMediaGridAdapter.b(this.c);
      ((URLDrawable.URLDrawableOptions)localObject).mPriority = 2;
      String str = paramLocalMediaInfo.e;
      URL localURL = a(str);
      if ((!TextUtils.isEmpty(str)) && (localURL != null))
      {
        localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
        if (paramLocalMediaInfo.o != null)
        {
          paramLocalMediaInfo.o.thumbWidth = this.a.getWidth();
          paramLocalMediaInfo.o.thumbHeight = this.a.getHeight();
          ((URLDrawable)localObject).setTag(paramLocalMediaInfo.o);
        }
        this.a.setImageDrawable((Drawable)localObject);
        return;
      }
      this.a.setImageDrawable(LocalMediaGridAdapter.b(this.c));
      return;
    }
    catch (Throwable paramLocalMediaInfo)
    {
      QLog.e("RIJUGC.LocalMediaGridAdapter", 1, "load cover failed", paramLocalMediaInfo);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.LocalMediaGridAdapter.ImageHolder
 * JD-Core Version:    0.7.0.1
 */