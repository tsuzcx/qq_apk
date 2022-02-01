package com.tencent.mobileqq.location;

import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.mvvm.BaseRepository;

public class LocationPickRepository
  extends BaseRepository
{
  private LocationPickViewModel a;
  private final OnUpdateUserLocationListener b = new LocationPickRepository.1(this);
  
  public void a()
  {
    LocationHandler.a().a(this.b);
  }
  
  public void a(LocationPickViewModel paramLocationPickViewModel)
  {
    this.a = paramLocationPickViewModel;
  }
  
  public void c()
  {
    LocationHandler.a().b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickRepository
 * JD-Core Version:    0.7.0.1
 */