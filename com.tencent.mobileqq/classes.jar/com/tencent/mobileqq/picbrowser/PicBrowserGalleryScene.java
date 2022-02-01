package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import java.io.File;

public class PicBrowserGalleryScene
  extends AbstractGalleryScene
{
  protected PicBrowserGalleryAdapter a;
  protected PicBrowserActivity b;
  protected PicBrowserModel c;
  protected boolean d = false;
  public PicBrowserGalleryScene.SceneCallback e;
  private boolean f = false;
  
  public PicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
    this.b = paramPicBrowserActivity;
    this.c = ((PicBrowserModel)paramAbstractImageListModel);
    paramPicBrowserActivity = this.b.getIntent();
    if (paramPicBrowserActivity != null) {
      this.d = paramPicBrowserActivity.getBooleanExtra("is_forbid_action_sheet", false);
    }
  }
  
  private void a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.b, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.b.startActivityForResult(localIntent, 1001);
  }
  
  public void E()
  {
    Object localObject1 = this.c;
    int j = -1;
    Object localObject2 = null;
    PicBrowserGalleryAdapter localPicBrowserGalleryAdapter = null;
    int k = j;
    if (localObject1 != null)
    {
      k = ((PicBrowserModel)localObject1).b();
      int m = this.c.a();
      int i;
      if (m == 1)
      {
        localObject1 = this.c.d(k);
        i = j;
      }
      else
      {
        if (k == m - 1)
        {
          localObject1 = this.c.d(k);
          i = k - 1;
          this.c.b(i);
        }
        for (;;)
        {
          break;
          i = j;
          localObject1 = localPicBrowserGalleryAdapter;
          if (k < 0) {
            break;
          }
          i = j;
          localObject1 = localPicBrowserGalleryAdapter;
          if (k >= m) {
            break;
          }
          localObject1 = this.c.d(k);
          this.c.b(k);
          i = k;
        }
      }
      localPicBrowserGalleryAdapter = this.a;
      k = i;
      localObject2 = localObject1;
      if (localPicBrowserGalleryAdapter != null)
      {
        localPicBrowserGalleryAdapter.notifyDataSetChanged();
        localObject2 = localObject1;
        k = i;
      }
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((PicBrowserGalleryScene.SceneCallback)localObject1).a(localObject2, k);
    }
  }
  
  public void L_()
  {
    if (((this.c instanceof PicBrowserModel)) && (this.f))
    {
      PicBrowserGalleryAdapter localPicBrowserGalleryAdapter = this.a;
      if (localPicBrowserGalleryAdapter != null) {
        localPicBrowserGalleryAdapter.notifyDataSetChanged();
      }
    }
    this.f = false;
    super.L_();
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.w).inflate(2131627573, null);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      b(this.c.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  protected AbstractImageAdapter b(Context paramContext)
  {
    if (this.a == null) {
      this.a = new PicBrowserGalleryAdapter(paramContext);
    }
    return this.a;
  }
  
  public void b()
  {
    PicBrowserImage localPicBrowserImage = this.c.c();
    if (localPicBrowserImage != null)
    {
      localPicBrowserImage.thubmRect = ((Rect)this.b.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localPicBrowserImage.isImgCenterCropMode = this.b.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  protected void b(int paramInt)
  {
    if (!this.d)
    {
      if (this.b.isFinishing()) {
        return;
      }
      String str;
      File localFile;
      if ((this.c.a(paramInt) != null) && (this.c.a(paramInt).k != null))
      {
        if (!TextUtils.isEmpty(this.c.a(paramInt).k.d))
        {
          str = this.c.a(paramInt).k.d;
          localFile = new File(this.c.a(paramInt).k.d);
        }
        else
        {
          str = AbsDownloader.getFilePath(this.c.a(paramInt).k.b);
          localFile = AbsDownloader.getFile(this.c.a(paramInt).k.b);
        }
      }
      else
      {
        str = "";
        localFile = null;
      }
      if (localFile == null) {
        return;
      }
      ActionSheet localActionSheet = ActionSheet.create(this.b);
      localActionSheet.addButton(HardCodeUtil.a(2131905945));
      localActionSheet.addButton("发送给QQ好友");
      localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
      localActionSheet.setOnButtonClickListener(new PicBrowserGalleryScene.1(this, localActionSheet, localFile, str));
      localActionSheet.show();
    }
  }
  
  public void d()
  {
    PicBrowserModel localPicBrowserModel = this.c;
    if ((localPicBrowserModel instanceof PicBrowserModel))
    {
      localPicBrowserModel.e();
      this.f = true;
    }
    super.d();
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void j()
  {
    super.j();
    this.b.hideImmersTitleBar();
  }
  
  public void k()
  {
    super.k();
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b(paramInt);
    return super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */