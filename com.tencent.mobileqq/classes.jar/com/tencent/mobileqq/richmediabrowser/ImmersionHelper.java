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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
      return -1;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFilePictureData)) {
      return 2;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData))
    {
      if (!((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData).k) {
        return 1;
      }
      return 5;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (((AIOVideoData)localObject).d == 0) {
        return 4;
      }
      if (((AIOVideoData)localObject).d == 1) {
        return 3;
      }
    }
    else if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData))
    {
      return 5;
    }
    return -1;
  }
  
  private int a(String paramString)
  {
    int k = 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {}
    label89:
    label106:
    do
    {
      return -1;
      if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
      {
        int j;
        int i;
        if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString)))
        {
          j = 1;
          localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
          if (((AIOVideoData)localObject).d != 0) {
            break label106;
          }
          if (j == 0) {
            break label89;
          }
          i = 2;
        }
        for (;;)
        {
          return i;
          j = 0;
          break;
          i = k;
          if (!"0X8009AA6".equals(paramString))
          {
            do
            {
              do
              {
                i = -1;
                break;
              } while (((AIOVideoData)localObject).d != 1);
              i = k;
              if (j != 0) {
                break;
              }
            } while (!"0X8009AA6".equals(paramString));
            i = k;
          }
        }
      }
    } while ((!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData)) || ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString))));
    return 3;
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = null;
  }
  
  public void c()
  {
    this.b = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.a.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserBasePresenter.c()) {}
    for (String str = "1";; str = "2")
    {
      ReportController.b(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", i, 0, str, "", "", "");
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A99B", "0X800A99B", i, 0, "" + a("0X800A99B"), "", "", "");
      return;
    }
  }
  
  public void g()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", a(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ImmersionHelper
 * JD-Core Version:    0.7.0.1
 */