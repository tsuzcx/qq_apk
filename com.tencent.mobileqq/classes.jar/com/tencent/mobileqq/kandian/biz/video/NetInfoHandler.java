package com.tencent.mobileqq.kandian.biz.video;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class NetInfoHandler
  implements INetInfoHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private final RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  private final ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private final VideoHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler;
  
  public NetInfoHandler(VideoHandler paramVideoHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler = paramVideoHandler;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramVideoHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramVideoHandler.a();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().updateNetworkChange(false);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b()) {
        return;
      }
      VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
      if (localVideoPlayManager.a()) {
        localVideoPlayManager.a();
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() == 70)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.9(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().updateNetworkChange(true);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b()) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.10(this));
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() == 70)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.1(this));
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    int j = 0;
    if (paramString != null) {
      paramString.updateNetworkChange(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b()) {
        return;
      }
      int i = j;
      if (paramString != null)
      {
        i = j;
        if (paramString.canAutoPlayVideo()) {
          i = 1;
        }
      }
      if (i == 0) {
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
      Object localObject = paramString.a();
      if ((!paramString.a()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.2(this));
        return;
      }
      if ((paramString.d()) && (localObject != null) && (paramString.c() == ((VideoPlayParam)localObject).c))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.c());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.c();
        return;
      }
      if ((localObject != null) && (paramString.d()) && (paramString.c() == ((VideoPlayParam)localObject).c))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoPlayParam net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.c());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.c();
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() == 70)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.7(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a().updateNetworkChange(true);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.b()) {
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
      Object localObject = paramString.a();
      if ((!paramString.a()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.8(this));
        return;
      }
      if ((localObject != null) && (paramString.c() == ((VideoPlayParam)localObject).c) && (paramString.d()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.c());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.c();
        return;
      }
      if ((localObject != null) && (paramString.c() == ((VideoPlayParam)localObject).c) && (paramString.d()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoPlayParam net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.c());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.c();
      }
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() == 70)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.5(this));
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    int j = 0;
    paramString.updateNetworkChange(false);
    paramString = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() != null)
      {
        i = j;
        if (paramString.a() != null) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().g()) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.6(this, paramString));
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() == 70)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.3(this));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    int j = 0;
    ((VideoAutoPlayController)localObject).updateNetworkChange(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler.a() != null)
      {
        i = j;
        if (((VideoPlayManager)localObject).a() != null) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().g()) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.4(this, (VideoPlayManager)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */