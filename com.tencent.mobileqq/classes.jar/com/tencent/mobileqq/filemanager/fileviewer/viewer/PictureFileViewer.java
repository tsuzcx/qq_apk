package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PictureFileViewer
  extends FileBrowserViewBase
{
  private DragGallery l;
  private LinearLayout m;
  private DragView n;
  private ImageGalleryAdapter o;
  private RelativeLayout p;
  private ImageButton q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private DragView.OnGestureChangeListener u = new PictureFileViewer.1(this);
  
  public PictureFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
    if (this.b == null)
    {
      this.b = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131627097, this.a, false);
      this.p = ((RelativeLayout)this.b.findViewById(2131433122));
      this.l = ((DragGallery)this.b.findViewById(2131433934));
      this.q = ((ImageButton)this.b.findViewById(2131432320));
      this.o = new ImageGalleryAdapter(BaseApplicationImpl.getContext());
      this.l.setAdapter(this.o);
      this.l.setOnNoBlankListener(this.o);
      this.l.setSpacing(this.b.getResources().getDimensionPixelSize(2131297535));
      this.m = ((LinearLayout)this.b.findViewById(2131439596));
      this.n = ((DragView)this.b.findViewById(2131432158));
      Rect localRect = d();
      if (localRect != null)
      {
        localRect.top -= ImmersiveUtils.getStatusBarHeight(this.c);
        localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.c);
      }
      this.n.setOriginRect(localRect);
      this.n.setRatioModify(true);
      this.n.setGestureChangeListener(this.u);
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if (paramOnItemClickListener != null) {
      this.l.setOnItemClickListener(paramOnItemClickListener);
    }
  }
  
  public void a(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (paramOnItemLongClickListener != null) {
      this.l.setOnItemLongClickListener(paramOnItemLongClickListener);
    }
  }
  
  public void a(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if (paramOnItemSelectedListener != null) {
      this.l.setOnItemSelectedListener(paramOnItemSelectedListener);
    }
  }
  
  public void a(List<FileBrowserModelBase.ImageFileInfo> paramList)
  {
    this.o.a(paramList);
    this.o.notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.m != null)
    {
      int j = 0;
      int i;
      if ((paramBoolean) && (!this.t)) {
        i = 1;
      } else {
        i = 0;
      }
      LinearLayout localLinearLayout = this.m;
      if (i != 0) {
        i = j;
      } else {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
    }
    this.r = paramBoolean;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.q.setOnClickListener(paramOnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool;
    if ((paramBoolean) && (!this.t)) {
      bool = true;
    } else {
      bool = false;
    }
    super.b(bool);
    this.s = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    this.l.setSelection(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    ImageButton localImageButton = this.q;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageButton.setVisibility(i);
  }
  
  public void d(boolean paramBoolean)
  {
    DragView localDragView;
    if (paramBoolean)
    {
      localDragView = this.n;
      if (localDragView != null) {
        localDragView.setOriginRect(d());
      }
    }
    else
    {
      localDragView = this.n;
      if (localDragView != null) {
        localDragView.setOriginRect(null);
      }
    }
  }
  
  public void e()
  {
    ImageGalleryAdapter localImageGalleryAdapter = this.o;
    if (localImageGalleryAdapter != null) {
      localImageGalleryAdapter.notifyDataSetChanged();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.n != null)
    {
      Rect localRect = d();
      if (localRect != null)
      {
        int i;
        if (!paramBoolean)
        {
          localRect.top -= ImmersiveUtils.getStatusBarHeight(this.c);
          localRect.bottom -= ImmersiveUtils.getStatusBarHeight(this.c);
          if ((LiuHaiUtils.e) && (LiuHaiUtils.b))
          {
            i = LiuHaiUtils.e(this.c);
            localRect.top += i;
            localRect.bottom += i;
          }
        }
        else
        {
          localRect.top += ImmersiveUtils.getStatusBarHeight(this.c);
          localRect.bottom += ImmersiveUtils.getStatusBarHeight(this.c);
          if ((LiuHaiUtils.e) && (LiuHaiUtils.b))
          {
            i = LiuHaiUtils.e(this.c);
            localRect.top -= i;
            localRect.bottom -= i;
          }
        }
        this.n.setOriginRect(localRect);
      }
    }
  }
  
  public void f()
  {
    this.l.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.PictureFileViewer
 * JD-Core Version:    0.7.0.1
 */