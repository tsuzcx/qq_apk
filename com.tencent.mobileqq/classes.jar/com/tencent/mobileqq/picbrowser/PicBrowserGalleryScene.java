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
  protected PicBrowserActivity a;
  protected PicBrowserGalleryAdapter a;
  public PicBrowserGalleryScene.SceneCallback a;
  protected PicBrowserModel a;
  protected boolean a;
  private boolean b = false;
  
  public PicBrowserGalleryScene(PicBrowserActivity paramPicBrowserActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    super(paramPicBrowserActivity, paramAbstractImageListModel);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel = ((PicBrowserModel)paramAbstractImageListModel);
    paramPicBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.getIntent();
    if (paramPicBrowserActivity != null) {
      this.jdField_a_of_type_Boolean = paramPicBrowserActivity.getBooleanExtra("is_forbid_action_sheet", false);
    }
  }
  
  private void a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.startActivityForResult(localIntent, 1001);
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561219, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter = new PicBrowserGalleryAdapter(paramContext);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter;
  }
  
  public void a()
  {
    PicBrowserImage localPicBrowserImage = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a();
    if (localPicBrowserImage != null)
    {
      localPicBrowserImage.thubmRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localPicBrowserImage.isImgCenterCropMode = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      b(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  protected void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.isFinishing()) {
        return;
      }
      String str;
      File localFile;
      if ((this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt) != null) && (this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a != null))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a.c))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a.c;
          localFile = new File(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a.c);
        }
        else
        {
          str = AbsDownloader.getFilePath(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a.a);
          localFile = AbsDownloader.getFile(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(paramInt).a.a);
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
      ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity);
      localActionSheet.addButton(HardCodeUtil.a(2131708148));
      localActionSheet.addButton("发送给QQ好友");
      localActionSheet.addCancelButton(HardCodeUtil.a(2131708149));
      localActionSheet.setOnButtonClickListener(new PicBrowserGalleryScene.1(this, localActionSheet, localFile, str));
      localActionSheet.show();
    }
  }
  
  public void c()
  {
    PicBrowserModel localPicBrowserModel = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel;
    if ((localPicBrowserModel instanceof PicBrowserModel))
    {
      localPicBrowserModel.a();
      this.b = true;
    }
    super.c();
  }
  
  public void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel;
    int j = -1;
    Object localObject2 = null;
    PicBrowserGalleryAdapter localPicBrowserGalleryAdapter = null;
    int k = j;
    if (localObject1 != null)
    {
      k = ((PicBrowserModel)localObject1).b();
      int m = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a();
      int i;
      if (m == 1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b(k);
        i = j;
      }
      else
      {
        if (k == m - 1)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b(k);
          i = k - 1;
          this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(i);
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
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.b(k);
          this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel.a(k);
          i = k;
        }
      }
      localPicBrowserGalleryAdapter = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter;
      k = i;
      localObject2 = localObject1;
      if (localPicBrowserGalleryAdapter != null)
      {
        localPicBrowserGalleryAdapter.notifyDataSetChanged();
        localObject2 = localObject1;
        k = i;
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryScene$SceneCallback;
    if (localObject1 != null) {
      ((PicBrowserGalleryScene.SceneCallback)localObject1).a(localObject2, k);
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h_()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserModel instanceof PicBrowserModel)) && (this.b))
    {
      PicBrowserGalleryAdapter localPicBrowserGalleryAdapter = this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserGalleryAdapter;
      if (localPicBrowserGalleryAdapter != null) {
        localPicBrowserGalleryAdapter.notifyDataSetChanged();
      }
    }
    this.b = false;
    super.h_();
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserActivity.hideImmersTitleBar();
  }
  
  public void j()
  {
    super.j();
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b(paramInt);
    return super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */