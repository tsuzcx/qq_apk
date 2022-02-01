package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.filemanager.api.IFileAssistantExt;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.qlink.QQProxyForQlink;
import cooperation.vip.manager.FileBannerTianshuManger;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class FileAssistantExt
  implements IFileAssistantExt
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new FileAssistantExt.1(this);
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private FileBannerTianshuManger jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger;
  
  FileAssistantExt()
  {
    TdsReaderGlobal.a();
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getQQProxyForQlink().a("0X800474E", 1);
    QQProxyForQlink.a(paramActivity, 2, null);
  }
  
  private void a(AppRuntime paramAppRuntime, BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fileRedTouch deleteRedTouch path = ");
    localStringBuilder.append(paramString);
    QLog.i("FileAssistantExt", 1, localStringBuilder.toString());
    paramAppRuntime = (IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    if (paramAppInfo == null)
    {
      paramAppRuntime.onRedTouchItemClick(paramString);
      return;
    }
    paramAppRuntime.onRedTouchItemClick(paramAppInfo, null);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getWidth();
  }
  
  public void a(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger = new FileBannerTianshuManger(paramActivity, paramView, 1);
    this.jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger.a();
  }
  
  public void a(Activity paramActivity, BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, BaseQQAppInterface paramBaseQQAppInterface, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      int j = paramArrayOfInt1[i];
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.id = i;
      localMenuItem.title = paramActivity.getString(paramArrayOfInt1[i]);
      localMenuItem.contentDescription = localMenuItem.title;
      if (i == 3)
      {
        TencentDocMyFileNameBean localTencentDocMyFileNameBean = TencentDocMyFileNameProcessor.a();
        if ((localTencentDocMyFileNameBean != null) && (!TextUtils.isEmpty(localTencentDocMyFileNameBean.d)))
        {
          localMenuItem.title = localTencentDocMyFileNameBean.d;
          localMenuItem.contentDescription = localTencentDocMyFileNameBean.d;
        }
      }
      localMenuItem.iconId = paramArrayOfInt2[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.build(paramActivity, localArrayList, new FileAssistantExt.2(this, paramBoolean, paramActivity, paramBaseQQAppInterface, paramAppInfo), null, ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(210, paramActivity.getResources()));
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setTouchInterceptor(new FileAssistantExt.3(this));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void a(AppRuntime paramAppRuntime, Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    paramAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileAssistantExt
 * JD-Core Version:    0.7.0.1
 */