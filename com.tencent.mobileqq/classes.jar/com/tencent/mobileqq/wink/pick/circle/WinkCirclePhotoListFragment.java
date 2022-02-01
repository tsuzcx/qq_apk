package com.tencent.mobileqq.wink.pick.circle;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.pick.album.data.AlbumSelectionData;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleClearAllSelectEvent;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleSelectChangeEvent;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleAlbumListPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePreviewPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleSelectPanelPart;
import com.tencent.mobileqq.wink.pick.circle.part.WinkCircleTitleChipPart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WinkCirclePhotoListFragment
  extends BasePartFragment
  implements SimpleEventReceiver
{
  public WinkCirclePhotoListLogic a;
  public PhotoListBaseData b;
  WinkCirclePhotoListPart c;
  WinkCircleAlbumListPart d;
  WinkCirclePreviewPart e;
  WinkCircleSelectPanelPart f;
  WinkCircleTitleChipPart g;
  View h;
  public String i = "";
  private Boolean j = Boolean.valueOf(false);
  
  private void a(Intent paramIntent)
  {
    paramIntent = (ArrayList)paramIntent.getSerializableExtra("key_qcircle_photo_path_image_edit");
    if ((paramIntent != null) && (paramIntent.size() > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set photo list: ");
      ((StringBuilder)localObject).append(paramIntent.size());
      AEQLog.d("WinkCirclePhotoListFragment", ((StringBuilder)localObject).toString());
      localObject = new HashMap();
      Iterator localIterator = paramIntent.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.mMimeType = "image";
        ((HashMap)localObject).put(str, localLocalMediaInfo);
      }
      if (this.a.d.selectedPhotoList.size() == 0)
      {
        this.a.d.selectedPhotoList.addAll(paramIntent);
        this.a.g().initialHasPickedNum = 0;
      }
      if (this.a.d.selectedMediaInfoHashMap == null) {
        this.a.d.selectedMediaInfoHashMap = new HashMap();
      }
      if (this.a.d.selectedMediaInfoHashMap.size() == 0) {
        this.a.d.selectedMediaInfoHashMap.putAll((Map)localObject);
      }
    }
  }
  
  private void k()
  {
    this.a = new WinkCirclePhotoListLogic(this);
    this.b = this.a.e;
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null)
    {
      QLog.d("SelectPhotoTrace", 1, "WinkCirclePhotoListFragment initLogic() intent is null!");
      return;
    }
    this.a.a(localIntent, getActivity());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WinkCirclePhotoListFragment initLogic(),extra is:");
      localStringBuilder.append(localIntent.getExtras());
      QLog.d("SelectPhotoTrace", 2, localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    if ((this.D != null) && (getActivity() != null))
    {
      VideoReport.addToDetectionWhitelist(getActivity());
      if (!TextUtils.isEmpty(i())) {
        localObject = i();
      } else {
        localObject = b();
      }
      VideoReport.setPageId(this.D, (String)localObject);
      VideoReport.setPageParams(this.D, new WinkDTParamBuilder().buildPageParams(null, true));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportDaTongRegister subPage: ");
      localStringBuilder.append(b());
      localStringBuilder.append(", pageId: ");
      localStringBuilder.append((String)localObject);
      QLog.i("WinkCirclePhotoListFragment", 1, localStringBuilder.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportDaTongRegister mContentView == null , subPage: ");
    ((StringBuilder)localObject).append(b());
    QLog.i("WinkCirclePhotoListFragment", 1, ((StringBuilder)localObject).toString());
  }
  
  public Boolean a()
  {
    if ((!getActivity().getIntent().getBooleanExtra("key_qcircle_from_mid_page", false)) && (!this.j.booleanValue())) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public void a(int paramInt)
  {
    View localView = this.h;
    if (localView == null) {
      return;
    }
    localView.setBackgroundColor(paramInt);
  }
  
  public void a(View paramView, String paramString, Map<String, Object> paramMap)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      VideoReport.setElementId(paramView, paramString);
      Map localMap = WinkDTParamBuilder.buildElementParams();
      localMap.putAll(paramMap);
      VideoReport.setElementParams(paramView, localMap);
      paramView = new StringBuilder();
      paramView.append("dtReportBindViewData elementId: ");
      paramView.append(paramString);
      QLog.i("WinkCirclePhotoListFragment", 1, paramView.toString());
      return;
    }
    QLog.i("WinkCirclePhotoListFragment", 1, "dtReportBindViewData view: null");
  }
  
  public void a(Boolean paramBoolean)
  {
    this.d.b(paramBoolean.booleanValue());
  }
  
  public void a(String paramString)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (h() == 0)
    {
      getActivity().finish();
      return;
    }
    paramString = DialogUtil.a(localFragmentActivity, 230).setTitle(getResources().getString(2131913982)).setPositiveButton(getResources().getString(2131913981), new WinkCirclePhotoListFragment.4(this, paramString)).setNegativeButton(getResources().getString(2131913980), new WinkCirclePhotoListFragment.3(this));
    if (paramString != null) {}
    try
    {
      if (!paramString.isShowing()) {
        paramString.show();
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  protected boolean ai()
  {
    return false;
  }
  
  public String b()
  {
    return "WinkCirclePhotoListFragment";
  }
  
  public void b(View paramView, String paramString, Map<String, Object> paramMap)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("WinkCirclePhotoListFragment", 1, "dtReportCustomReport eventId: null");
      return;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = this.D;
    }
    paramView = WinkDTParamBuilder.buildElementParams();
    if (paramMap != null)
    {
      VideoReport.setElementId(localView, (String)paramMap.get("xsj_eid"));
      paramView.putAll(paramMap);
    }
    VideoReport.reportEvent(paramString, this.D, paramView);
    paramView = new StringBuilder();
    paramView.append("dtReportCustomReport eventId: ");
    paramView.append(paramString);
    QLog.i("WinkCirclePhotoListFragment", 1, paramView.toString());
  }
  
  protected int c()
  {
    return 2131629693;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.d = new WinkCircleAlbumListPart(this.a);
    this.c = new WinkCirclePhotoListPart(this.a);
    this.e = new WinkCirclePreviewPart(this.a);
    this.f = new WinkCircleSelectPanelPart(this.a);
    if (this.i.equals("midPageMultiReplace")) {
      this.f.e();
    }
    this.g = new WinkCircleTitleChipPart(this.a);
    this.g.b(false);
    getActivity().getIntent();
    localArrayList.add(this.d);
    localArrayList.add(this.c);
    localArrayList.add(this.e);
    localArrayList.add(this.f);
    localArrayList.add(this.g);
    return localArrayList;
  }
  
  public Boolean e()
  {
    WinkCirclePreviewPart localWinkCirclePreviewPart = this.e;
    boolean bool;
    if (localWinkCirclePreviewPart != null) {
      bool = localWinkCirclePreviewPart.e().booleanValue();
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public void f()
  {
    WinkCirclePreviewPart localWinkCirclePreviewPart = this.e;
    if (localWinkCirclePreviewPart != null) {
      localWinkCirclePreviewPart.f();
    }
  }
  
  public Boolean g()
  {
    return Boolean.valueOf(this.d.d().booleanValue() ^ true);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WinkCircleClearAllSelectEvent.class);
    localArrayList.add(WinkFinishActivityEvent.class);
    return localArrayList;
  }
  
  public int h()
  {
    WinkCirclePhotoListLogic localWinkCirclePhotoListLogic = this.a;
    if ((localWinkCirclePhotoListLogic != null) && (localWinkCirclePhotoListLogic.d != null) && (this.a.d.selectedPhotoList != null)) {
      return this.a.d.selectedPhotoList.size();
    }
    return 0;
  }
  
  public String i()
  {
    return "pg_xsj_choose_media_new_page";
  }
  
  protected int j()
  {
    return 0;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      return;
    }
    a(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    return (p() != null) && (p().a());
  }
  
  public void onCreate(@android.support.annotation.Nullable Bundle paramBundle)
  {
    k();
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getActivity().getWindow().setBackgroundDrawable(null);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("WinkCirclePhotoListFragment,hashCode is:");
      paramBundle.append(System.identityHashCode(this));
      QLog.d("SelectPhotoTrace", 2, paramBundle.toString());
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  @android.support.annotation.Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @android.support.annotation.Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    try
    {
      this.D = paramLayoutInflater.inflate(c(), paramViewGroup, false);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WinkCirclePhotoListFragment", 1, localThrowable, new Object[0]);
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    ViewCompat.setOnApplyWindowInsetsListener(this.D, new WinkCirclePhotoListFragment.1(this));
    if (this.D != null) {
      this.D.post(new WinkCirclePhotoListFragment.2(this));
    }
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("onCreateView cost:");
    paramLayoutInflater.append(System.currentTimeMillis() - l);
    QLog.d("[Performance2]WinkCirclePhotoListFragment", 1, paramLayoutInflater.toString());
    paramLayoutInflater = this.D;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.j();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    AlbumSelectionData.b();
  }
  
  public void onPause()
  {
    AEQLog.b("WinkCirclePhotoListFragment", "onPause---");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof WinkCircleClearAllSelectEvent))
    {
      paramSimpleBaseEvent = this.a;
      if (paramSimpleBaseEvent != null)
      {
        paramSimpleBaseEvent.k();
        paramSimpleBaseEvent = this.c;
        if (paramSimpleBaseEvent != null) {
          paramSimpleBaseEvent.e();
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
      }
    }
    else if (((paramSimpleBaseEvent instanceof WinkFinishActivityEvent)) && (!getActivity().isFinishing()))
    {
      getActivity().finish();
    }
  }
  
  public void onResume()
  {
    AEQLog.b("WinkCirclePhotoListFragment", "onResume---");
    super.onResume();
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleSelectChangeEvent());
  }
  
  public void onViewCreated(@NonNull View paramView, @androidx.annotation.Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    l();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
  
  protected boolean v()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListFragment
 * JD-Core Version:    0.7.0.1
 */