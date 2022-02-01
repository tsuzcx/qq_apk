package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager.Music;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.Pair;
import com.tencent.util.ThrowablesUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.qq.im.capture.music.MusicDownloadListener;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.util.QIMProviderViewBuilder;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.TransitionProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class EditProviderPart
  extends EditVideoPart
  implements ProviderView.ProviderViewListener, EditProviderExport, DoodleLayout.DoodleEventListener
{
  public static String a;
  float jdField_a_of_type_Float;
  public int a;
  protected View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MusicDownloadListener jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener = new EditProviderPart.5(this);
  private QIMProviderViewBuilder jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder;
  private ProviderView jdField_a_of_type_DovComQqImCaptureViewProviderView;
  public ProviderViewEditContainer a;
  private DoodleLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  HorizontalAlumbListLayout jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private HashMap<Integer, ProviderView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
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
  
  private void e(int paramInt)
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    int i;
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
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
        ((TransitionProviderView)localProviderView).jdField_b_of_type_Int = i;
        localObject = localProviderView;
      }
    }
    if (!((ProviderView)localObject).d())
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoDoodle.a();
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramInt = ((ProviderView)localObject).d();
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        ((ProviderView)localObject).d(paramInt + (int)UIUtils.a(a(), i));
      }
      ((ProviderView)localObject).a(a());
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView = ((ProviderView)localObject);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView.getId() != 2131364391) {
      b(false);
    }
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewProviderView.c();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void t()
  {
    Object localObject1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null)
    {
      localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      if (EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16))
      {
        localObject1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
        if (!EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384))
        {
          localObject1 = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
          if (localObject1 != null) {
            break label84;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "comboFilterData null");
          }
        }
      }
    }
    label84:
    do
    {
      return;
      localObject1 = ((VideoFilterTools.ComboFilterData)localObject1).b();
      if ((localObject1 == null) || (((List)localObject1).size() >= 3)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QCombo", 2, "recommend trans less than 3");
    return;
    this.c = a(2131379759);
    Object localObject2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d) {
        break label237;
      }
      localObject2 = (RelativeLayout)a(2131366182);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      ((ViewGroup)this.c.getParent()).removeView(this.c);
      ((RelativeLayout)localObject2).addView(this.c, localLayoutParams);
    }
    for (;;)
    {
      this.c.postDelayed(new EditProviderPart.2(this, (List)localObject1), 1000L);
      return;
      label237:
      localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 0);
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
  }
  
  private void u()
  {
    String str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_default");
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart setDedaultTransition transId=" + str);
    }
    Object localObject = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localObject != null)
    {
      localObject = ((VideoFilterTools.ComboFilterData)localObject).a();
      if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((FilterCategory)((ArrayList)localObject).get(0)).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)((Iterator)localObject).next();
          if (localTransitionCategoryItem.k.equals(str))
          {
            VideoFilterTools.a().a(localTransitionCategoryItem);
            d(Integer.parseInt(localTransitionCategoryItem.jdField_a_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  private void v()
  {
    Object localObject = SlideShowConfigManager.a(a()).a();
    QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      QIMMusicConfigManager localQIMMusicConfigManager = (QIMMusicConfigManager)QIMManager.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SlideShowConfigManager.Music localMusic = (SlideShowConfigManager.Music)((Iterator)localObject).next();
        boolean bool = localQimMusicPlayer.a(localQIMMusicConfigManager.a(localMusic.jdField_a_of_type_Int, localMusic.jdField_b_of_type_Int), this.jdField_a_of_type_DovComQqImCaptureMusicMusicDownloadListener);
        if (QLog.isColorLevel()) {
          QLog.d("EditProviderPart", 2, "EditProviderPart preDownloadMusic needDownload=" + bool + " itemId=" + localMusic.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  public int a()
  {
    return (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a());
  }
  
  public <T extends ProviderView> T a(Class<? extends ProviderView> paramClass)
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
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131373599));
    this.jdField_b_of_type_AndroidViewView = a(2131365269);
    int j;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (j > 0) {
        break label339;
      }
      localLayoutParams.height += LiuHaiUtils.e;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (j > 0) {
        break label352;
      }
    }
    label339:
    label352:
    for (localLayoutParams.height += LiuHaiUtils.e;; localLayoutParams.height = (j + localLayoutParams.height))
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder = new QIMProviderViewBuilder(i);
      this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a();
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)a(2131374441));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setReadyToApply(false);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCaptureScene(this.jdField_a_of_type_Int);
      if (AECameraEntry.c.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.f)) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.jdField_b_of_type_Boolean = true;
      }
      i();
      this.jdField_a_of_type_AndroidViewView = a(2131374442);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new EditProviderPart.1(this));
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi instanceof EditVideoActivity)) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131366141));
      }
      d(true);
      if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer == null)
      {
        ((ViewStub)a(2131374443)).inflate();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)a(2131373595));
        i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.g();
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(i);
        this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.setProviderViewListener(this);
      }
      return;
      localLayoutParams.height += j;
      break;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (1 == paramInt1) {
      QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703723), 0).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInt != -1) {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setCurrentItem(paramInt, false);
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
    super.a(paramInt, paramObject);
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      k();
    }
    for (;;)
    {
      if ((paramInt != -1) && (paramInt != 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsGone();
      }
      return;
      e(103);
      continue;
      e(104);
      if (SlideShowPhotoListManager.a().b() == 22)
      {
        LpReportInfo_pf00064.allReport(680, 3, 1);
        continue;
        e(101);
        continue;
        e(106);
        continue;
        e(108);
        continue;
        this.jdField_a_of_type_Boolean = false;
        k();
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Pair localPair = new Pair(Integer.valueOf(paramInt), paramVarArgs);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(15, localPair);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a(paramInt, paramVarArgs);
    }
  }
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(LocationFacePackage.Item paramItem)
  {
    ((StoryConfigManager)SuperManager.a(10)).b("has_show_add_poi_paster_guide", Boolean.valueOf(true));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString) {}
  
  public void a(String paramString) {}
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject1 = (CaptureComboManager)QIMManager.a(5);
        Object localObject2 = localObject1.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].jdField_a_of_type_DovComQqImCaptureDataComboSet;
        if (localObject2 == null) {
          break label183;
        }
        localObject2 = (QIMFilterCategoryItem)((ComboSet)localObject2).a;
        if (localObject2 == null) {
          break label183;
        }
        localJSONObject.put("comboItem", ((QIMFilterCategoryItem)localObject2).a());
        i = 1;
        localObject1 = localObject1.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].jdField_a_of_type_DovComQqImCaptureDataFilterSet;
        j = i;
        if (localObject1 != null)
        {
          localObject1 = (QIMFilterCategoryItem)((FilterSet)localObject1).a;
          j = i;
          if (localObject1 != null)
          {
            localJSONObject.put("filterItem", ((QIMFilterCategoryItem)localObject1).a());
            j = 1;
          }
        }
        localObject1 = ((QimMusicPlayer)QIMManager.a().c(8)).a();
        if (localObject1 != null)
        {
          localJSONObject.put("musicItem", ((MusicItemInfo)localObject1).convertToJSON());
          i = 1;
          if (i != 0) {
            paramJSONObject.put(jdField_a_of_type_JavaLangString, localJSONObject);
          }
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      int i = j;
      continue;
      label183:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(byte[] paramArrayOfByte) {}
  
  public void aL_()
  {
    Object localObject;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout = ((HorizontalAlumbListLayout)a(2131372196));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131375074));
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setTipsContent(this.jdField_a_of_type_AndroidWidgetTextView);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        break label394;
      }
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.d) {
        break label345;
      }
      localObject = (RelativeLayout)a(2131366182);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(2, 0);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, 0);
      ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getParent();
      localViewGroup.removeView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout, localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetTextView);
      ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setEditVideoUI(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(SlideShowPhotoListManager.a().a());
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(0);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("PhotoConst.IS_FROM_EDIT", false)) {
        SlideShowPhotoListManager.a().b();
      }
      SlideShowPhotoListManager.a().a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity());
      d();
      if (EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16)) {
        u();
      }
      v();
      try
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
        int i = ((EditVideoParams)((Intent)localObject).getParcelableExtra(EditVideoParams.class.getName())).a("extra_slide_entrance", -1);
        StoryReportor.a("video_edit_new", "exp_albumbar", (Intent)localObject, new String[] { i + "" });
        return;
        label345:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131298154));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        continue;
        label394:
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setPadding(0, 0, 0, a().getDimensionPixelOffset(2131298154));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("EditProviderPart", 2, ThrowablesUtils.a(localException));
      }
    }
  }
  
  public void aM_()
  {
    super.aM_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)localIterator.next()).f();
    }
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
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, Object paramObject)
  {
    if (paramInt == 7) {
      k();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {}
    for (;;)
    {
      return;
      MusicProviderView localMusicProviderView = (MusicProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(104));
      MusicItemInfo localMusicItemInfo = ((QimMusicPlayer)QIMManager.a().c(8)).a();
      if ((paramBoolean) && (localMusicProviderView != null) && ((localMusicItemInfo == null) || (!localMusicItemInfo.needPlay())) && (localMusicProviderView.b())) {}
      for (paramBoolean = true; (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi instanceof EditVideoActivity)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null); paramBoolean = false)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().runOnUiThread(new EditProviderPart.4(this, paramBoolean));
        return;
      }
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    t();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(16);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt);
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.a();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 1, 0));
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 3, 2, 0));
  }
  
  public void d()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0)) {
      this.c.setVisibility(8);
    }
  }
  
  public void d(int paramInt)
  {
    ((EditTransferExport)a(EditTransferExport.class)).a(paramInt);
  }
  
  void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a());
    }
    Bundle localBundle = a();
    int i = 0;
    if (i < this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a())
    {
      int j = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(i);
      if ((paramBoolean) && (!this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.b(j))) {}
      label223:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if ((ProviderView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)) == null)
          {
            ProviderView localProviderView = this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.a(a(), j);
            if (localProviderView == null) {
              break label223;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_DovComQqImCaptureUtilQIMProviderViewBuilder.c(i)), localProviderView);
            localProviderView.setProviderViewListener(this);
            localProviderView.setDoodleEventListener(this);
            localProviderView.b(localBundle);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localProviderView);
            localProviderView.setVisibility(8);
            if ((localProviderView instanceof TransitionProviderView))
            {
              j = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_transiton_src_from", -1);
              ((TransitionProviderView)localProviderView).jdField_b_of_type_Int = j;
            }
            if (!paramBoolean) {
              localProviderView.e();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("EditProviderPart", 2, "preloadProviderView failed " + i);
    }
  }
  
  public void f()
  {
    super.f();
    VideoFilterTools.a().a(this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ProviderView)((Iterator)localObject).next()).e();
    }
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].a((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
    if ((EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384)) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.a(SlideShowPhotoListManager.a().a());
    }
    if (!this.jdField_b_of_type_Boolean) {
      ThreadManager.getUIHandler().postDelayed(new EditProviderPart.3(this), 500L);
    }
  }
  
  public void g()
  {
    super.g();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ProviderView)((Map.Entry)localIterator.next()).getValue()).a();
    }
    VideoFilterTools.a().b();
  }
  
  public void i()
  {
    boolean bool2 = true;
    VideoFilterTools.ComboFilterData localComboFilterData = ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if ((localComboFilterData != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null))
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a(localComboFilterData.a(this.jdField_a_of_type_Int).c);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    boolean bool1;
    if (localComboFilterData == null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
        break label111;
      }
    }
    for (;;)
    {
      QLog.d("EditProviderPart", 2, new Object[] { "comboFilterData is null, ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2) });
      return;
      bool1 = false;
      break;
      label111:
      bool2 = false;
    }
  }
  
  public void k()
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
    {
      this.c.setVisibility(8);
      this.c = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.d();
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView = null;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void l()
  {
    super.l();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.b();
    }
    ((CaptureComboManager)QIMManager.a(5)).jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.jdField_a_of_type_Int].c((Activity)this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    r();
  }
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
  
  public void q() {}
  
  public void r()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager != null)
    {
      EditVideoPartManager localEditVideoPartManager = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
      if (EditVideoPartManager.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c, 16384))
      {
        if (SlideShowPhotoListManager.a().a() != 13) {
          break label101;
        }
        SlideShowPhotoListManager.a().f();
        SlideShowPhotoListManager.a().d();
      }
    }
    for (;;)
    {
      ((QimMusicPlayer)QIMManager.a().c(8)).c();
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetHorizontalAlumbListLayout.setVisibility(8);
      }
      return;
      label101:
      SlideShowPhotoListManager.a().f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart
 * JD-Core Version:    0.7.0.1
 */