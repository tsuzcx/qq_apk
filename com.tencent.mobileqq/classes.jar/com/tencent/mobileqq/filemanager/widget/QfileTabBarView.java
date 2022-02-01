package com.tencent.mobileqq.filemanager.widget;

import amtj;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import arxr;
import arxv;
import asdg;
import asyy;
import atcb;
import atcc;
import bcef;
import bhjm;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelFileTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelMediaTabView;
import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavAppFileTabView;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavDocFileTabView;
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
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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
  implements View.OnClickListener, arxr
{
  public int a;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bhjm jdField_a_of_type_Bhjm = new atcb(this);
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = null;
  public BaseFileAssistantActivity a;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  public TabBarView2 a;
  String jdField_a_of_type_JavaLangString;
  HashMap<Integer, Class<? extends QfileBaseTabView>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  public int b;
  HashMap<Integer, QfileBaseTabView> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  private int c;
  public HashMap<Integer, Integer> c;
  private int d;
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
    this.jdField_c_of_type_JavaUtilHashMap = new LinkedHashMap();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560775, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131368151));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131378099));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378101));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this.jdField_a_of_type_Bhjm);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setBackgroundDrawable(null);
  }
  
  private QfileBaseTabView b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0)) {}
    for (int i = 1;; i = 0) {
      switch (paramInt)
      {
      default: 
        return null;
      }
    }
    if (i != 0) {}
    for (Object localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentTDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentTDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {}
    for (localObject = new QfileRecentTencentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);; localObject = new QfileRecentTencentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity))
    {
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
  }
  
  private QfileBaseTabView c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e() == 8) {}
    String str;
    ArrayList localArrayList;
    for (int i = 1;; i = 0)
    {
      localObject = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/" + "diskcache" + "/";
      str = ShortVideoUtils.getShortVideoSaveDir();
      localArrayList = new ArrayList();
      localArrayList.add(new atcc(this, asyy.a().b(), false, false, true));
      switch (paramInt)
      {
      default: 
        return null;
      }
    }
    Object localObject = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, new Pair(amtj.a(2131708811), Integer.valueOf(5)));
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    if (i != 0) {
      localArrayList.add(new atcc(this, (String)localObject, true, true, true));
    }
    localObject = new QfileLocalFileDelPicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, new Pair(amtj.a(2131708810), Integer.valueOf(3)));
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localArrayList.add(new atcc(this, asyy.a().c(), true, false, false));
    localArrayList.add(new atcc(this, asyy.a().b() + ".trooptmp", true, false, false));
    localObject = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, new Pair(amtj.a(2131708812), Integer.valueOf(11)));
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    if (i != 0) {
      localArrayList.add(new atcc(this, str, false, true, true));
    }
    localObject = new QfileLocalFileDelMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 1, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
    localObject = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localArrayList, true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {}
    do
    {
      do
      {
        return;
        switch (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue())
        {
        default: 
          return;
        case 3: 
          if (this.d == 1)
          {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
            return;
          }
          break;
        case 1118: 
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
          return;
        case 1111: 
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
          return;
        case 1119: 
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
          return;
        case 1110: 
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
          return;
        case 1114: 
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
          return;
        }
      } while (this.d != 2);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      return;
      if (this.d == 1)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
        return;
      }
    } while (this.d != 2);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800AFA8", "0X800AFA8", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800AFAC", "0X800AFAC", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800AFAA", "0X800AFAA", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800AFB0", "0X800AFB0", 0, 0, "", "", "", "");
    return;
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, "dc00898", "", "", "0X800AFB2", "0X800AFB2", 0, 0, "", "", "", "");
  }
  
  private QfileBaseTabView d(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(new atcc(this, AppConstants.SDCARD_ROOT + "/Tencent/MicroMsg/Download/", false, false, true));
    ((List)localObject).add(new atcc(this, AppConstants.SDCARD_ROOT + "/Tencent/MicroMsg/WeiXin/", false, false, true));
    switch (paramInt)
    {
    default: 
      return null;
    case 16: 
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "document", this.jdField_c_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 15: 
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "picture", this.jdField_c_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 17: 
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "video", this.jdField_c_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 18: 
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "music", this.jdField_c_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 19: 
      localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "other", this.jdField_c_of_type_Int);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1118: 
      localObject = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1111: 
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1119: 
      localObject = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1110: 
      localObject = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    localObject = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
    ((QfileBaseTabView)localObject).setFromWeiXin(true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
  }
  
  private QfileBaseTabView e(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getFileManagerEngine().a();
    switch (paramInt)
    {
    default: 
      return null;
    case 1202: 
      localObject = new QfileFavDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arxv)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1201: 
      localObject = new QfileFavPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arxv)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1200: 
      localObject = new QfileFavVideoFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arxv)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1203: 
      localObject = new QfileFavAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arxv)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    localObject = new QfileFavFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (arxv)localObject, this);
    ((QfileBaseTabView)localObject).b();
    return localObject;
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(this.jdField_b_of_type_Int))) {
      return ((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_b_of_type_Int))).intValue();
    }
    return -1;
  }
  
  public QfileBaseTabView a(int paramInt)
  {
    try
    {
      localObject1 = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        return localObject1;
      }
      i = ((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        QLog.e("QfileTabBarView<FileAssistant>", 1, "tabPos[" + paramInt + "]");
        i = 3;
      }
      localException.setFocusable(false);
      if (!(localException instanceof QfileBaseRecentFileTabView)) {
        break label183;
      }
      ((QfileBaseRecentFileTabView)localException).setAttribution(this.d);
      label183:
      if (!(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity instanceof FMActivity)) {
        break label207;
      }
      ((FMActivity)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity).a().setAttribution(i);
      label207:
      this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localException);
      return localException;
    }
    localObject2 = b(i);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = c(i);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = d(i);
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e(i);
    }
    if (localObject1 == null)
    {
      QLog.e("QfileTabBarView<FileAssistant>", 1, "getTabView return null!,tabPos:" + paramInt);
      return null;
    }
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.i();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setVisibility(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.jdField_a_of_type_Int, paramString);
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a(paramArrayList);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).a(paramSet);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int[] a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.d();
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(0);
      i += 1;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      i = ((Integer)localIterator.next()).intValue();
      QfileBaseTabView localQfileBaseTabView = (QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if (localQfileBaseTabView != null) {
        localQfileBaseTabView.c();
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelected(false);
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
  }
  
  public void b(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != localQfileBaseTabView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (b()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.t();
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.m();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.j();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setExpandGroup(true);
        if (b()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.n();
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView, -1, -1);
      }
      c(paramInt);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a(this.jdField_a_of_type_Int, paramString, false, false, true);
    this.jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      ((QfileBaseTabView)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).c(paramArrayList);
    }
  }
  
  boolean b()
  {
    return true;
  }
  
  public void c()
  {
    b();
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.b(paramArrayList);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAttribution(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setHeaderScrollView(HeaderScrollView paramHeaderScrollView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = paramHeaderScrollView;
  }
  
  public void setMemory(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshedFavList(boolean paramBoolean)
  {
    if (paramBoolean == this.jdField_b_of_type_Boolean) {
      return;
    }
    QLog.i("TabBarView", 1, "FavFileS setRefreshedFavList:" + this.jdField_b_of_type_Boolean + "->" + paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setSelectedTab(int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(j))).intValue() != paramInt)
      {
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setSelectedTab(i, true);
      }
    }
  }
  
  public void setSortType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setSortType(paramInt);
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      i = paramInt;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.a();
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.an_();
  }
  
  public void setUin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setWYSubAppId(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */