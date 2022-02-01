package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.ITabBarViewProxy;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavVideoFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileOtherTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTDocFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentTencentDocFileTabView;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.api.impl.QQFileSelectorImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.TabBarView2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileTabBarView
  extends RelativeLayout
  implements View.OnClickListener, QfileBaseFavFileTabView.ITabBarViewProxy
{
  public int a = 0;
  public int b = 0;
  String c;
  boolean d = false;
  HorizontalScrollView e;
  TabBarView2 f;
  RelativeLayout g;
  QfileBaseTabView h = null;
  BaseFileAssistantActivity i = null;
  HeaderScrollView j = null;
  HashMap<Integer, Class<? extends QfileBaseTabView>> k = new HashMap();
  HashMap<Integer, QfileBaseTabView> l = new HashMap();
  HashMap<Integer, Integer> m = new LinkedHashMap();
  boolean n = false;
  private int o;
  private int p;
  private TabBarView.OnTabChangeListener q = new QfileTabBarView.1(this);
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627058, this);
    this.i = ((BaseFileAssistantActivity)paramContext);
    this.e = ((HorizontalScrollView)findViewById(2131435130));
    this.e.getParent().requestDisallowInterceptTouchEvent(true);
    this.f = ((TabBarView2)findViewById(2131446722));
    this.g = ((RelativeLayout)findViewById(2131446724));
    this.f.setOnTabChangeListener(this.q);
    this.f.setBackgroundDrawable(null);
    if (QQTheme.isNowSimpleUI())
    {
      this.f.setPadding(0, 0, 0, 0);
      return;
    }
    this.f.setPadding(ViewUtils.dpToPx(8.0F), 0, ViewUtils.dpToPx(8.0F), 0);
  }
  
  private QfileBaseTabView d(int paramInt)
  {
    Object localObject = this.c;
    int i1;
    if ((localObject != null) && (((String)localObject).trim().length() != 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7)
            {
              if (paramInt != 20)
              {
                if (paramInt != 21) {
                  return null;
                }
                if (i1 != 0) {
                  localObject = new QfileRecentTDocFileTabView(this.i, this.c);
                } else {
                  localObject = new QfileRecentTDocFileTabView(this.i);
                }
                ((QfileBaseTabView)localObject).a();
                return localObject;
              }
              if (i1 != 0) {
                localObject = new QfileRecentTencentDocFileTabView(this.i, this.c);
              } else {
                localObject = new QfileRecentTencentDocFileTabView(this.i);
              }
              ((QfileBaseTabView)localObject).a();
              return localObject;
            }
            if (i1 != 0) {
              localObject = new QfileRecentAppFileTabView(this.i, this.c);
            } else {
              localObject = new QfileRecentAppFileTabView(this.i);
            }
            ((QfileBaseTabView)localObject).a();
            return localObject;
          }
          if (i1 != 0) {
            localObject = new QfileRecentMediaFileTabView(this.i, this.c);
          } else {
            localObject = new QfileRecentMediaFileTabView(this.i);
          }
          ((QfileBaseTabView)localObject).a();
          return localObject;
        }
        if (i1 != 0) {
          localObject = new QfileRecentPicFileTabView(this.i, this.c);
        } else {
          localObject = new QfileRecentPicFileTabView(this.i);
        }
        ((QfileBaseTabView)localObject).a();
        return localObject;
      }
      if (i1 != 0) {
        localObject = new QfileRecentDocFileTabView(this.i, this.c);
      } else {
        localObject = new QfileRecentDocFileTabView(this.i);
      }
      ((QfileBaseTabView)localObject).a();
      return localObject;
    }
    if (i1 != 0) {
      localObject = new QfileRecentAllFileTabView(this.i, this.c);
    } else {
      localObject = new QfileRecentAllFileTabView(this.i);
    }
    ((QfileBaseTabView)localObject).a();
    return localObject;
  }
  
  private QfileBaseTabView e(int paramInt)
  {
    int i1;
    if (this.i.E() == 8) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append("diskcache");
    ((StringBuilder)localObject1).append("/");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    String str = SVUtils.c();
    localObject1 = new ArrayList();
    ((List)localObject1).add(new QfileTabBarView.ScanParams(this, AppConstants.SDCARD_FILE_SAVE_PATH, false, false, true));
    if (paramInt != 110)
    {
      if (paramInt != 111)
      {
        if (paramInt != 114)
        {
          if (paramInt != 118)
          {
            if (paramInt != 119)
            {
              switch (paramInt)
              {
              default: 
                return null;
              case 14: 
                localObject1 = new QfileLocalFileOtherTabView(this.i, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              case 13: 
                localObject1 = new QfileLocalFileMediaTabView(this.i, 2, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              case 12: 
                localObject1 = new QfileLocalFileMediaTabView(this.i, 1, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              case 11: 
                localObject1 = new QfileLocalFileMediaTabView(this.i, 3, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              case 10: 
                localObject1 = new QfileLocalFileDocTabView(this.i, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              case 9: 
                localObject1 = new QfileLocalFilePicTabView(this.i, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).a();
                return localObject1;
              }
              localObject1 = new QfileLocalFileAppTabView(this.i, (List)localObject1, true);
              ((QfileBaseTabView)localObject1).a();
              return localObject1;
            }
            if (i1 != 0) {
              ((List)localObject1).add(new QfileTabBarView.ScanParams(this, (String)localObject2, true, true, true));
            }
            localObject1 = new QfileLocalFileDelPicTabView(this.i, (List)localObject1, true);
            ((QfileBaseTabView)localObject1).a();
            return localObject1;
          }
          localObject1 = new QfileLocalFileDelFileTabView(this.i, (List)localObject1, new Pair(HardCodeUtil.a(2131896087), Integer.valueOf(5)));
          ((QfileBaseTabView)localObject1).a();
          return localObject1;
        }
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, AppConstants.SDCARD_FILE_SAVE_TMP_PATH, true, false, false));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_FILE_SAVE_PATH);
        ((StringBuilder)localObject2).append(".trooptmp");
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, ((StringBuilder)localObject2).toString(), true, false, false));
        localObject1 = new QfileLocalFileDelFileTabView(this.i, (List)localObject1, new Pair(HardCodeUtil.a(2131896090), Integer.valueOf(11)));
        ((QfileBaseTabView)localObject1).a();
        return localObject1;
      }
      if (i1 != 0) {
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, str, false, true, true));
      }
      localObject1 = new QfileLocalFileDelMediaTabView(this.i, (List)localObject1, true);
      ((QfileBaseTabView)localObject1).a();
      return localObject1;
    }
    localObject1 = new QfileLocalFileDelFileTabView(this.i, (List)localObject1, new Pair(HardCodeUtil.a(2131896088), Integer.valueOf(3)));
    ((QfileBaseTabView)localObject1).a();
    return localObject1;
  }
  
  private QfileBaseTabView f(int paramInt)
  {
    Object localObject = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MicroMsg/Download/");
    ((List)localObject).add(new QfileTabBarView.ScanParams(this, localStringBuilder.toString(), false, false, true));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/MicroMsg/WeiXin/");
    ((List)localObject).add(new QfileTabBarView.ScanParams(this, localStringBuilder.toString(), false, false, true));
    if (paramInt != 1110)
    {
      if (paramInt != 1111)
      {
        if (paramInt != 1114)
        {
          if (paramInt != 1118)
          {
            if (paramInt != 1119)
            {
              switch (paramInt)
              {
              default: 
                return null;
              case 19: 
                localObject = new QfileCloudFileTabView(this.i, "other", this.o);
                ((QfileBaseTabView)localObject).a();
                return localObject;
              case 18: 
                localObject = new QfileCloudFileTabView(this.i, "music", this.o);
                ((QfileBaseTabView)localObject).a();
                return localObject;
              case 17: 
                localObject = new QfileCloudFileTabView(this.i, "video", this.o);
                ((QfileBaseTabView)localObject).a();
                return localObject;
              case 16: 
                localObject = new QfileCloudFileTabView(this.i, "document", this.o);
                ((QfileBaseTabView)localObject).a();
                return localObject;
              }
              localObject = new QfileCloudFileTabView(this.i, "picture", this.o);
              ((QfileBaseTabView)localObject).a();
              return localObject;
            }
            localObject = new QfileLocalFilePicTabView(this.i, (List)localObject, false);
            ((QfileBaseTabView)localObject).setFromWeiXin(true);
            ((QfileBaseTabView)localObject).a();
            return localObject;
          }
          localObject = new QfileLocalFileAppTabView(this.i, (List)localObject, false);
          ((QfileBaseTabView)localObject).setFromWeiXin(true);
          ((QfileBaseTabView)localObject).a();
          return localObject;
        }
        localObject = new QfileLocalFileOtherTabView(this.i, (List)localObject, false);
        ((QfileBaseTabView)localObject).setFromWeiXin(true);
        ((QfileBaseTabView)localObject).a();
        return localObject;
      }
      localObject = new QfileLocalFileMediaTabView(this.i, 3, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).a();
      return localObject;
    }
    localObject = new QfileLocalFileDocTabView(this.i, (List)localObject, false);
    ((QfileBaseTabView)localObject).setFromWeiXin(true);
    ((QfileBaseTabView)localObject).a();
    return localObject;
  }
  
  private QfileBaseTabView g(int paramInt)
  {
    Object localObject = ((QQFileSelectorImpl)QRoute.api(IQQFileSelector.class)).getQfileFavFileRecordProvider(this.i.h());
    switch (paramInt)
    {
    default: 
      return null;
    case 1204: 
      localObject = new QfileFavFileTabView(this.i, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).a();
      return localObject;
    case 1203: 
      localObject = new QfileFavAppFileTabView(this.i, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).a();
      return localObject;
    case 1202: 
      localObject = new QfileFavDocFileTabView(this.i, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).a();
      return localObject;
    case 1201: 
      localObject = new QfileFavPicFileTabView(this.i, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).a();
      return localObject;
    }
    localObject = new QfileFavVideoFileTabView(this.i, (QfileFavFileRecordProvider)localObject, this);
    ((QfileBaseTabView)localObject).a();
    return localObject;
  }
  
  private void h(int paramInt)
  {
    if (!this.m.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    paramInt = ((Integer)this.m.get(Integer.valueOf(paramInt))).intValue();
    if (paramInt != 3)
    {
      if (paramInt != 1114)
      {
        if (paramInt != 20)
        {
          if (paramInt != 21)
          {
            if (paramInt != 1110)
            {
              if (paramInt != 1111)
              {
                if (paramInt != 1118)
                {
                  if (paramInt != 1119)
                  {
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 1204: 
                      ReportController.b(this.i.p, "dc00898", "", "", "0X800AFB2", "0X800AFB2", 0, 0, "", "", "", "");
                      return;
                    case 1203: 
                      ReportController.b(this.i.p, "dc00898", "", "", "0X800AFB0", "0X800AFB0", 0, 0, "", "", "", "");
                      return;
                    case 1202: 
                      ReportController.b(this.i.p, "dc00898", "", "", "0X800AFA8", "0X800AFA8", 0, 0, "", "", "", "");
                      return;
                    case 1201: 
                      ReportController.b(this.i.p, "dc00898", "", "", "0X800AFAC", "0X800AFAC", 0, 0, "", "", "", "");
                      return;
                    }
                    ReportController.b(this.i.p, "dc00898", "", "", "0X800AFAA", "0X800AFAA", 0, 0, "", "", "", "");
                    return;
                  }
                  ReportController.b(this.i.p, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
                  return;
                }
                ReportController.b(this.i.p, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
                return;
              }
              ReportController.b(this.i.p, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.i.p, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.i.p, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
          return;
        }
        paramInt = this.p;
        if (paramInt == 1)
        {
          ReportController.b(this.i.p, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt == 2) {
          ReportController.b(this.i.p, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
        }
      }
      else
      {
        ReportController.b(this.i.p, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
      }
    }
    else
    {
      paramInt = this.p;
      if (paramInt == 1)
      {
        ReportController.b(this.i.p, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(this.i.p, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.f.setVisibility(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.f.a(this.a, paramString);
    this.m.put(Integer.valueOf(this.a), Integer.valueOf(paramInt));
    this.a += 1;
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.h.a(paramArrayList);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.l.get(Integer.valueOf(i1))).a(paramSet);
    }
  }
  
  public boolean a()
  {
    return this.n;
  }
  
  QfileBaseTabView b(int paramInt)
  {
    try
    {
      localObject1 = (QfileBaseTabView)this.l.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        return localObject1;
      }
      i1 = ((Integer)this.m.get(Integer.valueOf(paramInt))).intValue();
    }
    catch (Exception localException)
    {
      Object localObject1;
      int i1;
      label42:
      Object localObject2;
      break label42;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tabPos[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("]");
    QLog.e("QfileTabBarView<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    i1 = 3;
    localObject2 = d(i1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e(i1);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = f(i1);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = g(i1);
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTabView return null!,tabPos:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("QfileTabBarView<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    ((QfileBaseTabView)localObject1).setFocusable(false);
    if ((localObject1 instanceof QfileBaseRecentFileTabView)) {
      ((QfileBaseRecentFileTabView)localObject1).setAttribution(this.p);
    }
    localObject2 = this.i;
    if ((localObject2 instanceof FMActivity)) {
      ((FMActivity)localObject2).a().setAttribution(i1);
    }
    this.l.put(Integer.valueOf(paramInt), localObject1);
    return localObject1;
  }
  
  public void b(int paramInt, String paramString)
  {
    this.f.a(this.a, paramString, false, false, true);
    this.m.put(Integer.valueOf(this.a), Integer.valueOf(paramInt));
    this.a += 1;
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.l.get(Integer.valueOf(i1))).c(paramArrayList);
    }
  }
  
  boolean b()
  {
    return true;
  }
  
  public void c()
  {
    QfileBaseTabView localQfileBaseTabView = this.h;
    if (localQfileBaseTabView != null) {
      localQfileBaseTabView.i();
    }
  }
  
  void c(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = b(paramInt);
    if (localQfileBaseTabView == null) {
      return;
    }
    Object localObject = this.h;
    if (localObject != localQfileBaseTabView)
    {
      if (localObject != null)
      {
        if (b()) {
          this.h.u();
        }
        this.h.m();
        this.g.removeView(this.h);
      }
      this.h = localQfileBaseTabView;
      localQfileBaseTabView = this.h;
      if (localQfileBaseTabView != null)
      {
        localObject = this.j;
        if (localObject != null) {
          ((HeaderScrollView)localObject).setCurrentScrollableContainer(localQfileBaseTabView);
        }
        this.h.j();
        this.h.setExpandGroup(true);
        if (b()) {
          this.h.n();
        }
        this.g.addView(this.h, -1, -1);
      }
      h(paramInt);
    }
    this.b = paramInt;
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.h.b(paramArrayList);
  }
  
  public void d()
  {
    int i2 = this.f.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      this.f.a(0);
      i1 += 1;
    }
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      i1 = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.l.get(Integer.valueOf(i1));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.b();
      }
    }
    this.a = 0;
    this.f.setSelected(false);
    this.m.clear();
    this.l.clear();
    this.k.clear();
    this.g.removeView(this.h);
  }
  
  public void e()
  {
    d();
  }
  
  public int getCurrentTabType()
  {
    if (this.m.containsKey(Integer.valueOf(this.b))) {
      return ((Integer)this.m.get(Integer.valueOf(this.b))).intValue();
    }
    return -1;
  }
  
  public int getFootHeight()
  {
    return this.h.getFootHeight();
  }
  
  public ListView getListView()
  {
    QfileBaseTabView localQfileBaseTabView = this.h;
    if (localQfileBaseTabView != null) {
      return localQfileBaseTabView.getListView();
    }
    return null;
  }
  
  public int getSortType()
  {
    QfileBaseTabView localQfileBaseTabView = this.h;
    if (localQfileBaseTabView == null) {
      return -1;
    }
    return localQfileBaseTabView.getSortType();
  }
  
  public int[] getSupprotSortType()
  {
    QfileBaseTabView localQfileBaseTabView = this.h;
    if (localQfileBaseTabView == null) {
      return null;
    }
    return localQfileBaseTabView.getSupportSortType();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAttribution(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setHeaderScrollView(HeaderScrollView paramHeaderScrollView)
  {
    this.j = paramHeaderScrollView;
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setRefreshedFavList(boolean paramBoolean)
  {
    if (paramBoolean == this.n) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FavFileS setRefreshedFavList:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    QLog.i("TabBarView", 1, localStringBuilder.toString());
    this.n = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.m.keySet().iterator();
    int i1 = 0;
    while (localIterator.hasNext())
    {
      int i2 = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.m.get(Integer.valueOf(i2))).intValue() != paramInt)
      {
        i1 += 1;
      }
      else
      {
        this.f.a();
        this.f.setSelectedTab(i1, true);
      }
    }
  }
  
  public void setSortType(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = this.h;
    if (localQfileBaseTabView == null) {
      return;
    }
    localQfileBaseTabView.setSortType(paramInt);
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i1 = paramInt;
    if (this.i.D())
    {
      localObject = this.h;
      i1 = paramInt;
      if ((localObject instanceof QfileBaseCloudFileTabView)) {
        i1 = paramInt + ((QfileBaseTabView)localObject).getFootHeight();
      }
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, i1);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.h.ci_();
  }
  
  public void setTabTitleList(String[] paramArrayOfString)
  {
    this.f.setTabTitleList(paramArrayOfString);
  }
  
  public void setUin(String paramString)
  {
    this.c = paramString;
  }
  
  public void setWYSubAppId(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */