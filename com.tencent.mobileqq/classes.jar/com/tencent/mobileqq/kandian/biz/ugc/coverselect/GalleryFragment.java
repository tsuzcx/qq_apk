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
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.base.view.widget.AlbumPermissionView;
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
  protected Activity a;
  private int b;
  private int c;
  private String d;
  private UCropView e;
  private View f;
  private RecyclerView g;
  private AlbumPermissionView h;
  private View i;
  private LocalMediaGridAdapter j;
  private List<AlbumUtils.LocalMediaInfo> k = new ArrayList();
  private GridLayoutManager l;
  private PageLoadManager<AlbumUtils.LocalMediaInfo> m = new PageLoadManager();
  
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
    if (this.h.a())
    {
      d();
      return;
    }
    this.i.setVisibility(8);
    this.h.setVisibility(0);
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
    this.d = localBundle.getString("ARG_PLACEHOLDER_URL");
    this.b = localBundle.getInt("ARG_VIDEO_WIDTH");
    this.c = localBundle.getInt("ARG_VIDEO_HEIGHT");
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
    a(paramLocalMediaInfo.e);
  }
  
  private void c()
  {
    a(this.d);
  }
  
  private void d()
  {
    this.m.a();
  }
  
  private void e()
  {
    this.e.a();
    if ((this.b != 0) && (this.c != 0))
    {
      localObject = this.e.getCropImageView();
      ((GestureCropImageView)localObject).setMaxScale(2.0F);
      ((GestureCropImageView)localObject).setIsDoubleTapEnabled(false);
      ((GestureCropImageView)localObject).setMaxResultImageSizeX(this.b);
      ((GestureCropImageView)localObject).setMaxResultImageSizeY(this.c);
      ((GestureCropImageView)localObject).setTargetAspectRatio(this.b / this.c);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAspectRatio error mVideoWidth:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("mVideoHeight");
    ((StringBuilder)localObject).append(this.c);
    QLog.e("RIJUGC.GalleryFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    this.m.a(paramInt);
  }
  
  public void a(Bitmap paramBitmap)
  {
    int n;
    if (this.j.a() >= 0) {
      n = 1;
    } else {
      n = 0;
    }
    if ((TextUtils.isEmpty(this.d)) && (n == 0)) {
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
    this.e.getCropImageView().a(Bitmap.CompressFormat.JPEG, 90, this.b, this.c, new GalleryFragment.3(this, paramOutputPicListener));
  }
  
  public boolean a(int paramInt, AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo.a() >= this.b / 2.0F) && (paramLocalMediaInfo.b() >= this.c / 2.0F)) {
      return true;
    }
    Toast.makeText(this.a, 2131915537, 0).show();
    return false;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.i.setVisibility(0);
      this.h.setVisibility(8);
      d();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.a = paramActivity;
    b();
    this.m.a(new GalleryFragment.1(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return View.inflate(this.a, 2131626025, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.g = ((RecyclerView)paramView.findViewById(2131433942));
    this.f = paramView.findViewById(2131432507);
    this.e = ((UCropView)paramView.findViewById(2131433939));
    this.h = ((AlbumPermissionView)paramView.findViewById(2131428229));
    this.i = paramView.findViewById(2131437435);
    this.h.setCallback(this);
    this.j = new LocalMediaGridAdapter(this.a);
    this.j.a(this);
    this.k = this.j.getDataList();
    this.l = new GridLayoutManager(this.a, 4);
    this.g.setLayoutManager(this.l);
    this.g.addItemDecoration(new GalleryFragment.2(this));
    this.g.setAdapter(this.j);
    e();
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.GalleryFragment
 * JD-Core Version:    0.7.0.1
 */