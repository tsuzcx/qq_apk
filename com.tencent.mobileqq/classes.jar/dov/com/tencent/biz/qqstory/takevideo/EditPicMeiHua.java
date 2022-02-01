package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import dov.com.qq.im.capture.view.ProviderContainerView;
import dov.com.qq.im.capture.view.ProviderContainerView.ProviderContainViewListener;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class EditPicMeiHua
  extends EditVideoPart
  implements ProviderContainerView.ProviderContainViewListener
{
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ProviderContainerView jdField_a_of_type_DovComQqImCaptureViewProviderContainerView;
  
  public EditPicMeiHua(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static void a(int paramInt)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilList.isEmpty())
      {
        if (EditVideoPartManager.a(paramInt, 8)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(101));
        }
        if ((EditVideoPartManager.a(paramInt, 64)) && (Build.VERSION.SDK_INT >= 21)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(100));
        }
        if (EditVideoPartManager.a(paramInt, 2048)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(102));
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(int paramInt)
  {
    a(paramInt);
    return (EditVideoPartManager.a(paramInt, 131072)) && (!jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b()) {
      return 3;
    }
    return 1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView = ((ProviderContainerView)a(2131373600));
    if (jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(a(), jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setProviderContainViewListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setEditActivityEntrance(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c());
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(QIMFilterProviderView.class) != null) {
      if (VideoFilterTools.a().b(a()) == null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      paramGenerateContext.c = bool;
      if ((paramGenerateContext.c) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()))
      {
        paramGenerateContext = paramGenerateContext.a;
        paramGenerateContext.a += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setVisibility(4);
    case 22: 
    case 21: 
      do
      {
        return;
        this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a(0);
      } while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
      EditActivityEntranceUtil.a("0X800B3CB", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c());
      EditActivityEntranceUtil.a("0X800B3CC", this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.c());
      this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.b(101);
      return;
    }
    ThreadManager.getUIHandler().post(new EditPicMeiHua.1(this));
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(10, Boolean.valueOf(true));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_DovComQqImCaptureViewProviderContainerView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditPicMeiHua
 * JD-Core Version:    0.7.0.1
 */