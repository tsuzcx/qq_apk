package com.tencent.mobileqq.vas.wallpaper.presenter;

import android.graphics.Rect;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Presenter;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.View;

public class DrawWallpaperPresenter
  implements DrawWallpaperContract.Presenter
{
  private DrawWallpaperContract.Model jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model;
  private DrawWallpaperContract.View jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View;
  
  public DrawWallpaperPresenter(DrawWallpaperContract.Model paramModel, DrawWallpaperContract.View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model = paramModel;
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View = paramView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model.a(new DrawWallpaperPresenter.1(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model.a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$Model.a(null);
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperContractDrawWallpaperContract$View.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.presenter.DrawWallpaperPresenter
 * JD-Core Version:    0.7.0.1
 */