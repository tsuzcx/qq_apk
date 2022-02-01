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
  private C2CShortcutBarStoreView a;
  private QQAppInterface b;
  private C2CShortcutBarStoreController.IStoreItemClickListener c;
  
  public C2CShortcutBarStoreController(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<C2CShortcutAppInfo> paramList, C2CShortcutBarStoreController.IStoreItemClickListener paramIStoreItemClickListener, boolean paramBoolean)
  {
    this.b = paramQQAppInterface;
    this.c = paramIStoreItemClickListener;
    a(paramContext, paramQQAppInterface, paramString, paramList, paramBoolean);
  }
  
  private void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, List<C2CShortcutAppInfo> paramList, boolean paramBoolean)
  {
    boolean bool1 = C2CShortcutBarSwitcher.b(paramQQAppInterface);
    boolean bool2 = C2CShortcutBarSwitcher.a(paramQQAppInterface, paramString);
    if (paramBoolean) {
      paramBoolean = false;
    } else {
      paramBoolean = bool1;
    }
    this.a = new C2CShortcutBarStoreView(paramQQAppInterface, paramContext, paramString, paramBoolean, bool2, paramList, this);
  }
  
  public void a()
  {
    this.a.show();
  }
  
  public void a(int paramInt, C2CShortcutAppInfo paramC2CShortcutAppInfo)
  {
    C2CShortcutBarStoreController.IStoreItemClickListener localIStoreItemClickListener = this.c;
    if (localIStoreItemClickListener != null) {
      localIStoreItemClickListener.a(paramInt, paramC2CShortcutAppInfo);
    }
    b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ((C2CShortcutBarManager)this.b.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean, paramString);
  }
  
  public void b()
  {
    this.a.dismiss();
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