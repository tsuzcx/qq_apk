package com.tencent.open.agent.auth.presenter;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.agent.auth.IVirtualCreatorContract.Presenter;
import com.tencent.open.agent.auth.IVirtualCreatorContract.View;
import com.tencent.open.agent.auth.model.IVirtualCreatorDataSource;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import java.io.File;
import mqq.os.MqqHandler;

public class VirtualCreatorPresenter
  implements IVirtualCreatorContract.Presenter
{
  private int jdField_a_of_type_Int = 0;
  private IVirtualCreatorContract.View jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$View;
  private IVirtualCreatorDataSource jdField_a_of_type_ComTencentOpenAgentAuthModelIVirtualCreatorDataSource;
  
  public VirtualCreatorPresenter(IVirtualCreatorContract.View paramView, IVirtualCreatorDataSource paramIVirtualCreatorDataSource)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$View = paramView;
    this.jdField_a_of_type_ComTencentOpenAgentAuthModelIVirtualCreatorDataSource = paramIVirtualCreatorDataSource;
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new VirtualCreatorPresenter.2(this, paramBoolean, paramLong, paramInt));
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new VirtualCreatorPresenter.4(this, paramBoolean, paramString1, paramString2, paramInt));
  }
  
  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
  {
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "OpenVirtual.createVirtual nickName=", paramString1, ", headId=", paramString2 });
    AccountInfo localAccountInfo = AuthMemoryCache.a().a(String.valueOf(paramLong));
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (localAccountInfo != null))
    {
      AuthReporter.a("KEY_CREATE_VIRTUAL_D17");
      this.jdField_a_of_type_ComTencentOpenAgentAuthModelIVirtualCreatorDataSource.a(paramLong, paramString1, paramString2, localAccountInfo, paramBoolean, new VirtualCreatorPresenter.1(this, localAccountInfo));
      return;
    }
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "OpenVirtual.createVirtual.return for params error" });
    a(false, 0L, -1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "decodeAvatarImage path=", paramString });
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new VirtualCreatorPresenter.5(this, paramString, paramInt1, paramInt2));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (new File(paramString3).exists()))
    {
      this.jdField_a_of_type_Int = 0;
      paramString1 = AuthMemoryCache.a().a(paramString1);
      if (!this.jdField_a_of_type_ComTencentOpenAgentAuthModelIVirtualCreatorDataSource.a(paramString2, paramString3, paramString1, paramBoolean, new VirtualCreatorPresenter.3(this, paramString1, paramString2))) {
        a(false, paramString2, null, -2);
      }
      return;
    }
    SSOLog.a("VirtualCreatorPresenter", new Object[] { "OpenVirtual.uploadAvatarImage.error image file not exist" });
    a(false, paramString2, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter
 * JD-Core Version:    0.7.0.1
 */