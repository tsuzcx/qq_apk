package com.tencent.mobileqq.gamecenter.media;

public class GameCenterVideoManager
{
  private static GameCenterVideoManager jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoManager;
  private GameCenterVideoViewController jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  
  public static GameCenterVideoManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoManager == null) {
        jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoManager = new GameCenterVideoManager();
      }
      GameCenterVideoManager localGameCenterVideoManager = jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoManager;
      return localGameCenterVideoManager;
    }
    finally {}
  }
  
  public GameCenterVideoViewController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  }
  
  public void a()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
    if (localGameCenterVideoViewController != null)
    {
      localGameCenterVideoViewController.stop();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.release();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = null;
    }
  }
  
  public void a(GameCenterVideoViewController paramGameCenterVideoViewController)
  {
    GameCenterVideoViewController localGameCenterVideoViewController = this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
    if ((localGameCenterVideoViewController != null) && (localGameCenterVideoViewController != null) && (localGameCenterVideoViewController != paramGameCenterVideoViewController) && (localGameCenterVideoViewController != null))
    {
      localGameCenterVideoViewController.stop();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = paramGameCenterVideoViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager
 * JD-Core Version:    0.7.0.1
 */