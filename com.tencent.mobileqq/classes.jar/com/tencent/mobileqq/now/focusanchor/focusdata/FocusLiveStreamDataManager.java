package com.tencent.mobileqq.now.focusanchor.focusdata;

import com.tencent.mobileqq.now.focusanchor.focousinterface.FocusLiveStreamListener;
import java.util.ArrayList;
import java.util.List;

public class FocusLiveStreamDataManager
  implements FocusLiveStreamListener
{
  private static volatile FocusLiveStreamDataManager jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager;
  private FocusLiveStreamListener jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener;
  private List<NowQQLiveAnchorInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static FocusLiveStreamDataManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager == null) {
          jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager = new FocusLiveStreamDataManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager;
  }
  
  public List<NowQQLiveAnchorInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    new FocusLiveStreamDataImpl().a(this);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(FocusLiveStreamListener paramFocusLiveStreamListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener = paramFocusLiveStreamListener;
  }
  
  public void a(List<NowQQLiveAnchorInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    FocusLiveStreamListener localFocusLiveStreamListener = this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener;
    if (localFocusLiveStreamListener != null) {
      localFocusLiveStreamListener.a(paramList);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocousinterfaceFocusLiveStreamListener = null;
    jdField_a_of_type_ComTencentMobileqqNowFocusanchorFocusdataFocusLiveStreamDataManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager
 * JD-Core Version:    0.7.0.1
 */