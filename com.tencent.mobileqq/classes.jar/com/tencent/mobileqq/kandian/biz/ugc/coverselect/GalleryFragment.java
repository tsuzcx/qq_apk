package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.imagecrop.GestureCropImageView;
import com.tencent.mobileqq.kandian.base.imagecrop.UCropView;
import com.tencent.mobileqq.kandian.base.view.widget.AlbumPermissionView;
import com.tencent.mobileqq.kandian.biz.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

public class GalleryFragment
  extends PublicBaseFragment
  implements LocalMediaGridAdapter.OnItemListener, QQPermissionCallback
{
  private int jdField_a_of_type_Int;
  protected Activity a;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private UCropView jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView;
  private AlbumPermissionView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView;
  private PageLoadManager<AlbumUtils.LocalMediaInfo> jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager = new PageLoadManager();
  private LocalMediaGridAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter;
  private String jdField_a_of_type_JavaLangString;
  private List<AlbumUtils.LocalMediaInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public static GalleryFragment a(int paramInt1, int paramInt2, String paramString)
  {
    GalleryFragment localGalleryFragment = new GalleryFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ARG_VIDEO_WIDTH", paramInt1);
    localBundle.putInt("ARG_VIDEO_HEIGHT", paramInt2);
    localBundle.putString("ARG_PLACEHOLDER_URL", paramString);
    localGalleryFragment.setArguments(localBundle);
    return localGalleryFragment;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView.a())
    {
      d();
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      ThreadManager.post(new GalleryFragment.4(this, paramString), 8, null, true);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = localBundle.getString("ARG_PLACEHOLDER_URL");
    this.jdField_a_of_type_Int = localBundle.getInt("ARG_VIDEO_WIDTH");
    this.jdField_b_of_type_Int = localBundle.getInt("ARG_VIDEO_HEIGHT");
  }
  
  private void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new GalleryFragment.5(this, paramBitmap));
  }
  
  private void b(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    a(paramLocalMediaInfo.b);
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView.a();
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView.a();
      ((GestureCropImageView)localObject).setMaxScale(2.0F);
      ((GestureCropImageView)localObject).setIsDoubleTapEnabled(false);
      ((GestureCropImageView)localObject).setMaxResultImageSizeX(this.jdField_a_of_type_Int);
      ((GestureCropImageView)localObject).setMaxResultImageSizeY(this.jdField_b_of_type_Int);
      ((GestureCropImageView)localObject).setTargetAspectRatio(this.jdField_a_of_type_Int / this.jdField_b_of_type_Int);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAspectRatio error mVideoWidth:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("mVideoHeight");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    QLog.e("RIJUGC.GalleryFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter.a() >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i == 0)) {
      b(paramBitmap);
    }
  }
  
  public void a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    e();
    b(paramLocalMediaInfo);
  }
  
  public void a(OutputPicListener paramOutputPicListener)
  {
    UCropView localUCropView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView;
    if ((localUCropView != null) && (localUCropView.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView.a().a(Bitmap.CompressFormat.JPEG, 90, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, new GalleryFragment.3(this, paramOutputPicListener));
    }
  }
  
  public boolean a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.a() >= this.jdField_a_of_type_Int / 2.0F) && (paramLocalMediaInfo.b() >= this.jdField_b_of_type_Int / 2.0F)) {
      return true;
    }
    Toast.makeText(this.jdField_a_of_type_AndroidAppActivity, 2131718060, 0).show();
    return false;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView.setVisibility(8);
      d();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPageLoadManager.a(new GalleryFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131559982, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131367439));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366219);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImagecropUCropView = ((UCropView)paramView.findViewById(2131367436));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362614));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370241);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter = new LocalMediaGridAdapter(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter.a(this);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter.getDataList();
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 4);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new GalleryFragment.2(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectLocalMediaGridAdapter);
    e();
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.GalleryFragment
 * JD-Core Version:    0.7.0.1
 */