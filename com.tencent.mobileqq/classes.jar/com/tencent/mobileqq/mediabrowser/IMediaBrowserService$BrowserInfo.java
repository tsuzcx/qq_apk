package com.tencent.mobileqq.mediabrowser;

import android.graphics.Rect;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.List;

public class IMediaBrowserService$BrowserInfo
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private IMediaBrowserProvider jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProvider;
  private List<RichMediaBrowserInfo> jdField_a_of_type_JavaUtilList;
  
  public IMediaBrowserService$BrowserInfo(IMediaBrowserProvider paramIMediaBrowserProvider, List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProvider = paramIMediaBrowserProvider;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public IMediaBrowserProvider a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMediabrowserIMediaBrowserProvider;
  }
  
  public List<RichMediaBrowserInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mediabrowser.IMediaBrowserService.BrowserInfo
 * JD-Core Version:    0.7.0.1
 */