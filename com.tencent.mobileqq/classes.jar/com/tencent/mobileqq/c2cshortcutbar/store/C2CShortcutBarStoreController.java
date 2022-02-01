package com.tencent.mobileqq.c2cshortcutbar.store;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutAppInfo;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarSwitcher;
import java.util.List;

public class C2CShortcutBarStoreController
  implements IC2CShortcutBarStoreUIEvent
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private C2CShortcutBarStoreController.IStoreItemClickListener jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreController$IStoreItemClickListener;
  private C2CShortcutBarStoreView jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView;
  
  public C2CShortcutBarStoreController(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<C2CShortcutAppInfo> paramList, C2CShortcutBarStoreController.IStoreItemClickListener paramIStoreItemClickListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreController$IStoreItemClickListener = paramIStoreItemClickListener;
    a(paramContext, paramQQAppInterface, paramString, paramList, paramBoolean);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<C2CShortcutAppInfo> paramList, boolean paramBoolean)
  {
    boolean bool1 = C2CShortcutBarSwitcher.b(paramQQAppInterface);
    boolean bool2 = C2CShortcutBarSwitcher.a(paramQQAppInterface, paramString);
    if (paramBoolean) {
      bool1 = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView = new C2CShortcutBarStoreView(paramQQAppInterface, paramContext, paramString, bool1, bool2, paramList, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView.show();
  }
  
  public void a(int paramInt, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreController$IStoreItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreController$IStoreItemClickListener.a(paramInt, paramC2CShortcutAppInfo);
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ((C2CShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarStoreC2CShortcutBarStoreView.dismiss();
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreController
 * JD-Core Version:    0.7.0.1
 */