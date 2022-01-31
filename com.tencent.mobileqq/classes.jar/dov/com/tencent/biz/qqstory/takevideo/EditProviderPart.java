package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import aoaf;
import aoag;
import aoak;
import aoal;
import aoam;
import aoan;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.poi.FacePoiManager;
import dov.com.qq.im.capture.poi.FacePoiSearchUI;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.FacePoiSearchUIListener;
import dov.com.qq.im.capture.poi.FacePoiUI;
import dov.com.qq.im.capture.poi.FacePoiUI.FacePoiUIListener;
import dov.com.qq.im.capture.util.QIMProviderViewBuilder;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class EditProviderPart
  extends EditVideoPart
  implements ProviderView.ProviderViewListener, EditProviderExport, DoodleLayout.DoodleEventListener
{
  public static String a;
  public float a;
  public int a;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QimMusicPlayer jdField_a_of_type_DovComQqImCaptureMusicQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
  private FacePoiSearchUI.FacePoiSearchUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener = new aoan(this);
  private FacePoiSearchUI jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI;
  private FacePoiUI.FacePoiUIListener jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener = new aoam(this);
  private FacePoiUI jdField_a_of_type_DovComQqImCapturePoiFacePoiUI;
  private QIMProviderViewBuilder jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  private EditVideoPoiPickerCallback jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback = new aoal(this);
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public float b;
  private View b;
  private View c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "EditProviderPart";
  }
  
  public EditProviderPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Int = -1;
  }
  
  private Bundle a()
  {
    Bundle localBundle = null;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null) {
      localBundle = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.getBundle("container");
    }
    return localBundle;
  }
  
  private void a(int paramInt)
  {
    c(paramInt, null);
  }
  
  private void a(ProviderView paramProviderView, Object paramObject)
  {
    QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)QIMManager.a(2);
    if ((paramObject != null) && (paramObject.equals(Integer.valueOf(1001))) && ((paramProviderView instanceof MusicProviderView)))
    {
      paramProviderView = (MusicProviderView)MusicProviderView.class.cast(paramProviderView);
      paramProviderView.setPreSelectTagIndex(localQIMMusicConfigManager.a() - 1);
    }
    try
    {
      paramProviderView.d();
      return;
    }
    catch (Throwable paramProviderView)
    {
      QLog.d("EditProviderPart", 1, String.format("throwable = %s", new Object[] { paramProviderView }));
    }
  }
  
  private void c(int paramInt, Object paramObject)
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.b();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EditProviderPart", 2, "build provider view failed " + paramInt);
      }
      return;
      ProviderView localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(a(), paramInt);
      if (localProviderView != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localProviderView);
      }
      localObject = localProviderView;
      if ((localProviderView instanceof TransitionProviderView))
      {
        int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    a((ProviderView)localObject, paramObject);
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131362421) {
      d(false);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void s()
  {
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null)
    {
      localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      if (EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b, -2147483648))
      {
        localObject = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
        if (localObject != null) {
          break label63;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "comboFilterData null");
        }
      }
    }
    label63:
    do
    {
      return;
      localObject = ((VideoFilterTools.ComboFilterData)localObject).b();
      if ((localObject == null) || (((List)localObject).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.c = a(2131364501);
    this.c.postDelayed(new aoag(this, (List)localObject), 1000L);
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
  }
  
  public ProviderView a(Class paramClass)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      ProviderView localProviderView = (ProviderView)localIterator.next();
      if (paramClass.isInstance(localProviderView)) {
        return localProviderView;
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    a(EditProviderExport.class, this);
    int i = b();
    this.jdField_a_of_type_Int = i;
    VideoFilterTools.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131364475));
    this.jdField_a_of_type_AndroidViewView = a(2131364474);
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(i);
    this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI = new FacePoiUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI$FacePoiUIListener);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI = new FacePoiSearchUI();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI$FacePoiSearchUIListener);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiSearchUI.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a());
    Object localObject = (CaptureComboManager)QIMManager.a(5);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2131364383));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
    localObject = ((CaptureComboManager)localObject).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localObject != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(((VideoFilterTools.ComboFilterData)localObject).a(i).c);
      i = ((VideoFilterTools.ComboFilterData)localObject).a(i).c.indexOf(VideoFilterTools.a().b(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(i);
    }
    for (;;)
    {
      this.b = a(2131364375);
      this.b.setOnTouchListener(new aoaf(this));
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi instanceof EditVideoActivity)) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364448));
      }
      d();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EditProviderPart", 2, "comboFilterData is null");
      }
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "表情个数已达上限", 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)a(QIMFilterProviderView.class) != null) {
      if (VideoFilterTools.a().b(this.jdField_a_of_type_Int) == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      paramGenerateContext.c = bool;
      if ((paramGenerateContext.c) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()))
      {
        paramGenerateContext = paramGenerateContext.a;
        paramGenerateContext.jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt, paramObject);
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(LocationFacePackage.Item paramItem)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void aA_()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoTag.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
  }
  
  public void aB_()
  {
    s();
  }
  
  public void aF_()
  {
    super.aF_();
    VideoFilterTools.a().a(this.jdField_a_of_type_Int);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).e();
    }
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
  }
  
  public void aG_()
  {
    super.aG_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    super.a_(paramInt, paramObject);
    switch (paramInt)
    {
    default: 
      i();
      return;
    case 6: 
      a(103);
      return;
    case 2: 
      a(104);
      return;
    case 33: 
      c(104, paramObject);
      return;
    case 28: 
      a(107);
      return;
    case 29: 
      a(101);
      return;
    case 30: 
      a(108);
      return;
    }
    a(112);
  }
  
  public void az_()
  {
    super.az_();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.b())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
        return 3;
      }
      return 4;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
      return 1;
    }
    return 2;
  }
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      i();
    }
  }
  
  public void b(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, Object... paramVarArgs)
  {
    paramVarArgs = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(31, paramVarArgs);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a();
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(true);
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiUI.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPoiPickerCallback, paramString);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0)) {
      this.c.setVisibility(8);
    }
  }
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean) {}
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a());
    }
    Bundle localBundle = a();
    int i = 0;
    if (i < this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a())
    {
      int j = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(i);
      ProviderView localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(a(), j);
      if (localProviderView != null)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.d(i)), localProviderView);
        localProviderView.setProviderViewListener(this);
        localProviderView.setDoodleEventListener(this);
        localProviderView.b(localBundle);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
        localProviderView.setVisibility(8);
        if ((localProviderView instanceof TransitionProviderView))
        {
          j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
          ((TransitionProviderView)localProviderView).jdField_a_of_type_Int = j;
        }
      }
      while (!QLog.isColorLevel())
      {
        i += 1;
        break;
      }
      QLog.e("EditProviderPart", 2, "preloadProviderView failed " + i);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(32);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().c(8)).b();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.b())) && (localMusicProviderView.b())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi instanceof EditVideoActivity)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().runOnUiThread(new aoak(this, paramBoolean));
        return;
      }
    }
  }
  
  public void e(int paramInt)
  {
    ((EditTransferExport)a(EditTransferExport.class)).a(paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void f() {}
  
  public void h()
  {
    super.h();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).c();
    }
    VideoFilterTools.a().a();
  }
  
  public void i()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.b();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void j()
  {
    super.j();
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart
 * JD-Core Version:    0.7.0.1
 */