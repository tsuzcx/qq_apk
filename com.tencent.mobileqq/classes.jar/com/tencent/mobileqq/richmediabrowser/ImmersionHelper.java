package com.tencent.mobileqq.richmediabrowser;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;

public class ImmersionHelper
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImmersionHelper.ImmersionTimerRunnable jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable;
  private AIOBrowserBasePresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public ImmersionHelper(AIOBrowserBasePresenter paramAIOBrowserBasePresenter)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter = paramAIOBrowserBasePresenter;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = new ImmersionHelper.ImmersionTimerRunnable(this, null);
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    int j = -1;
    int i = j;
    if (localObject != null)
    {
      if (((RichMediaBrowserInfo)localObject).baseData == null) {
        return -1;
      }
      if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFilePictureData)) {
        return 2;
      }
      if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData))
      {
        if (!((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData).i) {
          return 1;
        }
      }
      else
      {
        if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
        {
          localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
          if (((AIOVideoData)localObject).d == 0) {
            return 4;
          }
          i = j;
          if (((AIOVideoData)localObject).d != 1) {
            return i;
          }
          return 3;
        }
        i = j;
        if (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData)) {
          return i;
        }
      }
      i = 5;
    }
    return i;
  }
  
  private int a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    int k = -1;
    int j = k;
    if (localObject != null)
    {
      if (((RichMediaBrowserInfo)localObject).baseData == null) {
        return -1;
      }
      if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
      {
        int i;
        if ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString))) {
          i = 0;
        } else {
          i = 1;
        }
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        if (((AIOVideoData)localObject).d == 0)
        {
          if (i != 0) {
            return 2;
          }
          j = k;
          if (!"0X8009AA6".equals(paramString)) {
            return j;
          }
        }
        else
        {
          j = k;
          if (((AIOVideoData)localObject).d != 1) {
            return j;
          }
          if (i == 0) {
            break label129;
          }
        }
        for (;;)
        {
          return 1;
          label129:
          j = k;
          if (!"0X8009AA6".equals(paramString)) {
            break;
          }
        }
      }
      else
      {
        j = k;
        if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData)) {
          if (!"0X800A99B".equals(paramString))
          {
            j = k;
            if (!"0X800A9B5".equals(paramString)) {}
          }
          else
          {
            j = 3;
          }
        }
      }
    }
    return j;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.b())
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer, immersion switch is not open");
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = new ImmersionHelper.ImmersionTimerRunnable(this, null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable, 5000L);
  }
  
  public void b()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "removeImmersionTimer");
    ImmersionHelper.ImmersionTimerRunnable localImmersionTimerRunnable = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable;
    if (localImmersionTimerRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localImmersionTimerRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = null;
  }
  
  public void c()
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOBrowserBaseView.a();
    this.c = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.d();
  }
  
  public void d()
  {
    this.b = false;
    this.c = false;
  }
  
  public void e()
  {
    int i = a("0X800A9B5");
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.c()) {
      str = "1";
    } else {
      str = "2";
    }
    ReportController.b(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", i, 0, str, "", "", "");
  }
  
  public void f()
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = 2;
    } else {
      i = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(a("0X800A99B"));
    ReportController.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", i, 0, localStringBuilder.toString(), "", "", "");
  }
  
  public void g()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", a(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ImmersionHelper
 * JD-Core Version:    0.7.0.1
 */