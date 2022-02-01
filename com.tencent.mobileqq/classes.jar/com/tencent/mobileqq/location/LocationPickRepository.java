package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.mvvm.BaseRepository;

public class LocationPickRepository
  extends BaseRepository
{
  private LocationPickViewModel jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel;
  private final OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationPickRepository.1(this);
  
  public void a()
  {
    LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
  }
  
  public void a(LocationPickViewModel paramLocationPickViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel = paramLocationPickViewModel;
  }
  
  public void b()
  {
    LocationHandler.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickRepository
 * JD-Core Version:    0.7.0.1
 */