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
  public int a;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = null;
  QfileBaseTabView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = null;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView = null;
  private TabBarView.OnTabChangeListener jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener = new QfileTabBarView.1(this);
  TabBarView2 jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2;
  String jdField_a_of_type_JavaLangString;
  HashMap<Integer, Class<? extends QfileBaseTabView>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  HashMap<Integer, QfileBaseTabView> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  HashMap<Integer, Integer> jdField_c_of_type_JavaUtilHashMap = new LinkedHashMap();
  private int d;
  
  public QfileTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560800, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)findViewById(2131368259));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2 = ((TabBarView2)findViewById(2131378204));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378206));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setOnTabChangeListener(this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView$OnTabChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView2.setBackgroundDrawable(null);
  }
  
  private QfileBaseTabView b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    if ((localObject != null) && (((String)localObject).trim().length() != 0)) {
      i = 1;
    } else {
      i = 0;
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
                if (i != 0) {
                  localObject = new QfileRecentTDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
                } else {
                  localObject = new QfileRecentTDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
                }
                ((QfileBaseTabView)localObject).b();
                return localObject;
              }
              if (i != 0) {
                localObject = new QfileRecentTencentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
              } else {
                localObject = new QfileRecentTencentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
              }
              ((QfileBaseTabView)localObject).b();
              return localObject;
            }
            if (i != 0) {
              localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
            } else {
              localObject = new QfileRecentAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
            }
            ((QfileBaseTabView)localObject).b();
            return localObject;
          }
          if (i != 0) {
            localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
          } else {
            localObject = new QfileRecentMediaFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
          }
          ((QfileBaseTabView)localObject).b();
          return localObject;
        }
        if (i != 0) {
          localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
        } else {
          localObject = new QfileRecentPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
        }
        ((QfileBaseTabView)localObject).b();
        return localObject;
      }
      if (i != 0) {
        localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
      } else {
        localObject = new QfileRecentDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
      }
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    if (i != 0) {
      localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, this.jdField_a_of_type_JavaLangString);
    } else {
      localObject = new QfileRecentAllFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    }
    ((QfileBaseTabView)localObject).b();
    return localObject;
  }
  
  private QfileBaseTabView c(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.e() == 8) {
      i = 1;
    } else {
      i = 0;
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
                localObject1 = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              case 13: 
                localObject1 = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 2, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              case 12: 
                localObject1 = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 1, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              case 11: 
                localObject1 = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              case 10: 
                localObject1 = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              case 9: 
                localObject1 = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
                ((QfileBaseTabView)localObject1).b();
                return localObject1;
              }
              localObject1 = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
              ((QfileBaseTabView)localObject1).b();
              return localObject1;
            }
            if (i != 0) {
              ((List)localObject1).add(new QfileTabBarView.ScanParams(this, (String)localObject2, true, true, true));
            }
            localObject1 = new QfileLocalFileDelPicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
            ((QfileBaseTabView)localObject1).b();
            return localObject1;
          }
          localObject1 = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, new Pair(HardCodeUtil.a(2131698186), Integer.valueOf(5)));
          ((QfileBaseTabView)localObject1).b();
          return localObject1;
        }
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, AppConstants.SDCARD_FILE_SAVE_TMP_PATH, true, false, false));
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_FILE_SAVE_PATH);
        ((StringBuilder)localObject2).append(".trooptmp");
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, ((StringBuilder)localObject2).toString(), true, false, false));
        localObject1 = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, new Pair(HardCodeUtil.a(2131698189), Integer.valueOf(11)));
        ((QfileBaseTabView)localObject1).b();
        return localObject1;
      }
      if (i != 0) {
        ((List)localObject1).add(new QfileTabBarView.ScanParams(this, str, false, true, true));
      }
      localObject1 = new QfileLocalFileDelMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, true);
      ((QfileBaseTabView)localObject1).b();
      return localObject1;
    }
    localObject1 = new QfileLocalFileDelFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject1, new Pair(HardCodeUtil.a(2131698187), Integer.valueOf(3)));
    ((QfileBaseTabView)localObject1).b();
    return localObject1;
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return;
    }
    paramInt = ((Integer)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
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
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800AFB2", "0X800AFB2", 0, 0, "", "", "", "");
                      return;
                    case 1203: 
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800AFB0", "0X800AFB0", 0, 0, "", "", "", "");
                      return;
                    case 1202: 
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800AFA8", "0X800AFA8", 0, 0, "", "", "", "");
                      return;
                    case 1201: 
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800AFAC", "0X800AFAC", 0, 0, "", "", "", "");
                      return;
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800AFAA", "0X800AFAA", 0, 0, "", "", "", "");
                    return;
                  }
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0x8009DB0", "0x8009DB0", 0, 0, "", "", "", "");
                  return;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0x8009DB4", "0x8009DB4", 0, 0, "", "", "", "");
                return;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0x8009DAE", "0x8009DAE", 0, 0, "", "", "", "");
              return;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0x8009DB2", "0x8009DB2", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
          return;
        }
        paramInt = this.d;
        if (paramInt == 1)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800A079", "0X800A079", 0, 0, "", "", "", "");
          return;
        }
        if (paramInt == 2) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800A08A", "0X800A08A", 0, 0, "", "", "", "");
        }
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0x8009DB6", "0x8009DB6", 0, 0, "", "", "", "");
      }
    }
    else
    {
      paramInt = this.d;
      if (paramInt == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800A071", "0X800A071", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a, "dc00898", "", "", "0X800A081", "0X800A081", 0, 0, "", "", "", "");
      }
    }
  }
  
  private QfileBaseTabView d(int paramInt)
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
                localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "other", this.jdField_c_of_type_Int);
                ((QfileBaseTabView)localObject).b();
                return localObject;
              case 18: 
                localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "music", this.jdField_c_of_type_Int);
                ((QfileBaseTabView)localObject).b();
                return localObject;
              case 17: 
                localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "video", this.jdField_c_of_type_Int);
                ((QfileBaseTabView)localObject).b();
                return localObject;
              case 16: 
                localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "document", this.jdField_c_of_type_Int);
                ((QfileBaseTabView)localObject).b();
                return localObject;
              }
              localObject = new QfileCloudFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, "picture", this.jdField_c_of_type_Int);
              ((QfileBaseTabView)localObject).b();
              return localObject;
            }
            localObject = new QfileLocalFilePicTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
            ((QfileBaseTabView)localObject).setFromWeiXin(true);
            ((QfileBaseTabView)localObject).b();
            return localObject;
          }
          localObject = new QfileLocalFileAppTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
          ((QfileBaseTabView)localObject).setFromWeiXin(true);
          ((QfileBaseTabView)localObject).b();
          return localObject;
        }
        localObject = new QfileLocalFileOtherTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
        ((QfileBaseTabView)localObject).setFromWeiXin(true);
        ((QfileBaseTabView)localObject).b();
        return localObject;
      }
      localObject = new QfileLocalFileMediaTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, 3, (List)localObject, false);
      ((QfileBaseTabView)localObject).setFromWeiXin(true);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    localObject = new QfileLocalFileDocTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (List)localObject, false);
    ((QfileBaseTabView)localObject).setFromWeiXin(true);
    ((QfileBaseTabView)localObject).b();
    return localObject;
  }
  
  private QfileBaseTabView e(int paramInt)
  {
    Object localObject = ((QQFileSelectorImpl)QRoute.api(IQQFileSelector.class)).getQfileFavFileRecordProvider(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a());
    switch (paramInt)
    {
    default: 
      return null;
    case 1204: 
      localObject = new QfileFavFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1203: 
      localObject = new QfileFavAppFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1202: 
      localObject = new QfileFavDocFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    case 1201: 
      localObject = new QfileFavPicFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (QfileFavFileRecordProvider)localObject, this);
      ((QfileBaseTabView)localObject).b();
      return localObject;
    }
    localObject = new QfileFavVideoFileTabView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, (QfileFavFileRecordProvider)localObject, this);
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
  
  QfileBaseTabView a(int paramInt)
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
      Object localObject1;
      int i;
      label42:
      Object localObject2;
      break label42;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("tabPos[");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("]");
    QLog.e("QfileTabBarView<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    i = 3;
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTabView return null!,tabPos:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("QfileTabBarView<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    ((QfileBaseTabView)localObject1).setFocusable(false);
    if ((localObject1 instanceof QfileBaseRecentFileTabView)) {
      ((QfileBaseRecentFileTabView)localObject1).setAttribution(this.d);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
    if ((localObject2 instanceof FMActivity)) {
      ((FMActivity)localObject2).a().setAttribution(i);
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject1);
    return localObject1;
  }
  
  public ListView a()
  {
    QfileBaseTabView localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localQfileBaseTabView != null) {
      return localQfileBaseTabView.a();
    }
    return null;
  }
  
  public void a()
  {
    QfileBaseTabView localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localQfileBaseTabView != null) {
      localQfileBaseTabView.i();
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
    QfileBaseTabView localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localQfileBaseTabView == null) {
      return null;
    }
    return localQfileBaseTabView.a();
  }
  
  public int b()
  {
    QfileBaseTabView localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localQfileBaseTabView == null) {
      return -1;
    }
    return localQfileBaseTabView.d();
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
  
  void b(int paramInt)
  {
    QfileBaseTabView localQfileBaseTabView = a(paramInt);
    if (localQfileBaseTabView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localObject != localQfileBaseTabView)
    {
      if (localObject != null)
      {
        if (b()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.t();
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.m();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView = localQfileBaseTabView;
      localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
      if (localQfileBaseTabView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView;
        if (localObject != null) {
          ((HeaderScrollView)localObject).setCurrentScrollableContainer(localQfileBaseTabView);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHeaderScrollView = paramHeaderScrollView;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FavFileS setRefreshedFavList:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("->");
    localStringBuilder.append(paramBoolean);
    QLog.i("TabBarView", 1, localStringBuilder.toString());
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
    QfileBaseTabView localQfileBaseTabView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
    if (localQfileBaseTabView == null) {
      return;
    }
    localQfileBaseTabView.setSortType(paramInt);
  }
  
  public void setTabFrameHeight(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView;
      i = paramInt;
      if ((localObject instanceof QfileBaseCloudFileTabView)) {
        i = paramInt + ((QfileBaseTabView)localObject).a();
      }
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, i);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileassistantQfileBaseTabView.ak_();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileTabBarView
 * JD-Core Version:    0.7.0.1
 */