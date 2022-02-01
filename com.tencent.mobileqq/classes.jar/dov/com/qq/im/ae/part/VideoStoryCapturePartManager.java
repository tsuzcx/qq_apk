package dov.com.qq.im.ae.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.AEBaseCameraUnit;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart;
import dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart;
import dov.com.qq.im.ae.camera.ui.bottom.AECircleBottomListPart;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart;
import dov.com.qq.im.ae.camera.ui.watermark.AEWaterMarkEditorPart;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.gif.AEGIFStickerListPart;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart;
import dov.com.qq.im.ae.play.AEPlayShowPart;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class VideoStoryCapturePartManager
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private AEBaseCameraUnit jdField_a_of_type_DovComQqImAeAEBaseCameraUnit;
  private Map<Integer, VideoStoryBasePart> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<Integer> jdField_a_of_type_JavaUtilSet;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public VideoStoryCapturePartManager(Activity paramActivity, View paramView, AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit = paramAEBaseCameraUnit;
    this.jdField_a_of_type_JavaUtilSet = a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt >> 16 == 2) {
      return 786432;
    }
    return 65536;
  }
  
  private Set<Integer> a()
  {
    return b();
  }
  
  private void a(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
      return;
      localObject = new AEGIFStickerListPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AECircleBottomListPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEBottomListPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new VideoStoryAIScenePart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new VideoStoryCapturePart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new VideoStoryPiecesPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEVideoStoryCaptureModePart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEVideoStoryTopBarPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEWaterMarkEditorPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      localObject = new AEPlayShowPart(this.jdField_a_of_type_AndroidAppActivity, (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131362309), this);
      continue;
      localObject = new AEVideoStoryDashboardPart(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidViewView, this);
    }
  }
  
  private int b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (paramInt >> 16 == localInteger.intValue() >> 16) {
        return localInteger.intValue();
      }
    }
    return 65536;
  }
  
  private <T> T b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit;
  }
  
  private Set<Integer> b()
  {
    HashSet localHashSet = new HashSet();
    int j = AECameraEntry.a.a();
    int i = j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = j;
      if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      }
    }
    if ((AECameraEntry.c.a(i)) || (AECameraEntry.t.a(i)) || (AECameraEntry.n.a(i)) || (AECameraEntry.e.a(i)) || (AECameraEntry.d(i)))
    {
      localHashSet.add(Integer.valueOf(458752));
      localHashSet.add(Integer.valueOf(131072));
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      localHashSet.add(Integer.valueOf(655360));
    }
    for (;;)
    {
      if (AECameraEntry.a(this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit) == 204) {
        localHashSet.remove(Integer.valueOf(524288));
      }
      if (AECameraEntry.a(this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit) == 205) {
        localHashSet.remove(Integer.valueOf(655360));
      }
      if (AEDashboardUtil.a())
      {
        boolean bool = AECameraPrefsUtil.a().a("DEBUG_KEY_TEST_LAUNCH_SPEED_MODE", false, 4);
        if ((AEDashboardUtil.a()) && (!bool)) {
          localHashSet.add(Integer.valueOf(720896));
        }
      }
      return localHashSet;
      if (AECameraEntry.e.a(i))
      {
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(196608));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(589824));
      }
      else if ((AECameraEntry.J.a(i)) || (AECameraEntry.I.a(i)))
      {
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(393216));
      }
      else
      {
        if (!AECameraEntry.w.a(i)) {
          break;
        }
        localHashSet.add(Integer.valueOf(458752));
        localHashSet.add(Integer.valueOf(262144));
        localHashSet.add(Integer.valueOf(327680));
        localHashSet.add(Integer.valueOf(524288));
        localHashSet.add(Integer.valueOf(131072));
        localHashSet.add(Integer.valueOf(393216));
      }
    }
    localHashSet.add(Integer.valueOf(458752));
    if (AECameraEntry.h(i)) {
      localHashSet.add(Integer.valueOf(786432));
    }
    for (;;)
    {
      localHashSet.add(Integer.valueOf(196608));
      localHashSet.add(Integer.valueOf(262144));
      localHashSet.add(Integer.valueOf(327680));
      localHashSet.add(Integer.valueOf(393216));
      localHashSet.add(Integer.valueOf(524288));
      localHashSet.add(Integer.valueOf(589824));
      break;
      localHashSet.add(Integer.valueOf(131072));
    }
  }
  
  private void b(int paramInt, Object... paramVarArgs) {}
  
  private void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      a(((Integer)localIterator.next()).intValue());
    }
  }
  
  private void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).initView();
    }
  }
  
  public AEMaterialManager a(int paramInt)
  {
    paramInt = b(paramInt);
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localVideoStoryBasePart instanceof AEBottomListPart)) {
      return ((AEBottomListPart)localVideoStoryBasePart).a();
    }
    return null;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    int i = b(paramInt);
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localVideoStoryBasePart != null) {
      return localVideoStoryBasePart.get(paramInt, paramVarArgs);
    }
    return b(paramInt, paramVarArgs);
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        g();
        h();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = b(paramInt);
    int i = j;
    if (j == 65536) {
      i = a(paramInt);
    }
    VideoStoryBasePart localVideoStoryBasePart = (VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (localVideoStoryBasePart != null)
    {
      localVideoStoryBasePart.send(paramInt, paramVarArgs);
      return;
    }
    b(paramInt, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    return (VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityResume();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityPause();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStart();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onActivityStop();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((VideoStoryBasePart)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.part.VideoStoryCapturePartManager
 * JD-Core Version:    0.7.0.1
 */