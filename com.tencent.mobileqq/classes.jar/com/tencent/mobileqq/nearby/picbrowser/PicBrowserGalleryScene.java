package com.tencent.mobileqq.nearby.picbrowser;

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
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity = paramPicBrowserActivity;
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel = ((PicBrowserModel)paramAbstractImageListModel);
    paramPicBrowserActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent();
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
    localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity, ForwardRecentActivity.class);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("forward_thumb", paramString);
    localIntent.putExtra("key_flag_from_plugin", true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.startActivityForResult(localIntent, 1001);
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561380, null);
  }
  
  public AbstractImageAdapter a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter = new PicBrowserGalleryAdapter(paramContext);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter;
  }
  
  public void a()
  {
    PicBrowserImage localPicBrowserImage = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
    if (localPicBrowserImage != null)
    {
      localPicBrowserImage.thubmRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND"));
      localPicBrowserImage.isImgCenterCropMode = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.getIntent().getBooleanExtra("extra_is_image_center_crop", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1001)) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      d(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b());
      return true;
    }
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel instanceof PicBrowserModel))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
      this.b = true;
    }
    super.c();
  }
  
  public void d()
  {
    int i = -1;
    int k;
    PicBrowserImage localPicBrowserImage1;
    PicBrowserImage localPicBrowserImage2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b();
      k = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a();
      if (k == 1)
      {
        localPicBrowserImage1 = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b(j);
        j = i;
        localPicBrowserImage2 = localPicBrowserImage1;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter.notifyDataSetChanged();
          localPicBrowserImage2 = localPicBrowserImage1;
        }
      }
    }
    for (int j = i;; j = i)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene$SceneCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene$SceneCallback.a(localPicBrowserImage2, j);
      }
      return;
      if (j == k - 1)
      {
        localPicBrowserImage1 = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b(j);
        i = j - 1;
        this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(i);
        break;
      }
      if ((j >= 0) && (j < k))
      {
        localPicBrowserImage1 = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.b(j);
        this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(j);
        i = j;
        break;
      }
      localPicBrowserImage1 = null;
      break;
      localPicBrowserImage2 = null;
    }
  }
  
  protected void d(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.isFinishing())) {}
    for (;;)
    {
      return;
      Object localObject3 = "";
      Object localObject4 = null;
      Object localObject1 = localObject4;
      Object localObject2 = localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt) != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a != null)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a.c)) {
            break label182;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a.c;
        }
      }
      for (localObject1 = new File(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a.c); localObject1 != null; localObject1 = AbsDownloader.getFile(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a.a))
      {
        localObject3 = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity);
        ((ActionSheet)localObject3).addButton(HardCodeUtil.a(2131708130));
        ((ActionSheet)localObject3).addButton("发送给QQ好友");
        ((ActionSheet)localObject3).addCancelButton(HardCodeUtil.a(2131708131));
        ((ActionSheet)localObject3).setOnButtonClickListener(new PicBrowserGalleryScene.1(this, (ActionSheet)localObject3, (File)localObject1, (String)localObject2));
        ((ActionSheet)localObject3).show();
        return;
        label182:
        localObject2 = AbsDownloader.getFilePath(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel.a(paramInt).a.a);
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h_()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserModel instanceof PicBrowserModel)) && (this.b) && (this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryAdapter.notifyDataSetChanged();
    }
    this.b = false;
    super.h_();
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserActivity.e();
  }
  
  public void j()
  {
    super.j();
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    return super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene
 * JD-Core Version:    0.7.0.1
 */