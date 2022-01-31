package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import anku;
import ankv;
import ankx;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.util.PasterUtil;
import dov.com.qq.im.capture.util.PasterUtil.Position;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.io.File;

public class NormalFaceAdapter
  extends BaseFaceListAdapter
  implements View.OnClickListener
{
  private NormalFaceAdapter.CacheRefMap a;
  
  public NormalFaceAdapter(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter$CacheRefMap = new NormalFaceAdapter.CacheRefMap();
  }
  
  private void a(View paramView)
  {
    ImageView localImageView = (ImageView)paramView;
    int k = ((Integer)localImageView.getTag(2131362359)).intValue();
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage;
    int j = localNormalFacePackage.a(k);
    paramView = Uri.parse(localNormalFacePackage.a(k)).getPath();
    String str = new File(paramView).getName();
    Object localObject1 = paramView;
    int i = j;
    if (j == 1)
    {
      localObject1 = paramView;
      i = j;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof EditPicActivity))
      {
        localObject2 = localNormalFacePackage.b(k);
        localObject1 = paramView;
        i = j;
        if (localObject2 != null)
        {
          localObject1 = Uri.parse((String)localObject2).getPath();
          i = 0;
        }
      }
    }
    paramView = (Drawable)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter$CacheRefMap.a(localObject1);
    if (paramView == null) {
      if (i != 1)
      {
        try
        {
          localObject2 = Drawable.createFromPath((String)localObject1);
          paramView = (View)localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            SLog.c("NormalFaceAdapter", "createFromPath error", localOutOfMemoryError);
          }
        }
        localObject2 = paramView;
        if (paramView != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter$CacheRefMap.a(localObject1, paramView);
        }
      }
    }
    Object localObject3;
    for (Object localObject2 = paramView;; localObject3 = paramView)
    {
      if (localObject2 == null) {
        break label377;
      }
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      a(localNormalFacePackage, (Drawable)localObject2, localImageView, (String)localObject1, str, i);
      return;
      localObject3 = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, "-Dynamic-", null, new int[] { 13 }, "-Dynamic-", null);
      if (localObject3 != null)
      {
        j = ((URLDrawable)localObject3).getStatus();
        if (j != 1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NormalFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + j);
          }
          if (j == 2)
          {
            ((URLDrawable)localObject3).restartDownload();
            label309:
            ((URLDrawable)localObject3).setURLDrawableListener(new ankv(this, (String)localObject1, localNormalFacePackage, localImageView, str));
          }
        }
        for (;;)
        {
          break;
          ((URLDrawable)localObject3).startDownload();
          break label309;
          paramView = (View)localObject3;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NormalFaceAdapter", 2, "urlDrawable apng error");
      }
      break;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceAdapterNormalFaceAdapter$CacheRefMap.a();
    }
    label377:
    SLog.e("NormalFaceAdapter", "can create drawable from path:" + (String)localObject1);
  }
  
  private void a(NormalFacePackage paramNormalFacePackage, Drawable paramDrawable, ImageView paramImageView, String paramString1, String paramString2, int paramInt)
  {
    int i;
    int k;
    int j;
    if (paramDrawable.getIntrinsicWidth() > paramDrawable.getIntrinsicHeight())
    {
      i = paramDrawable.getIntrinsicWidth();
      k = paramImageView.getWidth();
      if (paramImageView.getPaddingLeft() <= paramImageView.getPaddingTop()) {
        break label136;
      }
      j = paramImageView.getPaddingLeft();
      label40:
      if (k <= i) {
        break label145;
      }
    }
    label136:
    label145:
    for (float f = (((k - i) / 2 - j) * 2 + i) / i;; f = (i - (j + (i - k) / 2) * 2) / i)
    {
      f = (float)(f * paramNormalFacePackage.a);
      paramNormalFacePackage = new SelectedItem(paramNormalFacePackage.b, paramString2, paramDrawable, paramInt);
      paramDrawable = PasterUtil.a();
      this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener.a(paramNormalFacePackage, paramDrawable.a, paramDrawable.b, f, paramString1, null);
      return;
      i = paramDrawable.getIntrinsicHeight();
      break;
      j = paramImageView.getPaddingTop();
      break label40;
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new ankx(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), ((NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage).a(), this);; paramView = (ankx)paramView)
    {
      paramView.a((NormalFacePackage)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceFacePackage, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.postImmediately(new anku(this, paramView), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter
 * JD-Core Version:    0.7.0.1
 */