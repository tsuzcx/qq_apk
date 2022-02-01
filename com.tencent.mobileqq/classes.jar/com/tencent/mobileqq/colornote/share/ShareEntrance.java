package com.tencent.mobileqq.colornote.share;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class ShareEntrance
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
  private IServiceInfo jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
  
  public ShareEntrance(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = new ColorNoteCurd();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(new ColorNoteCurd.OnColorNoteCurdListener());
  }
  
  private ColorNote b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
    }
    return null;
  }
  
  public IServiceInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
  }
  
  public ColorNote a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
    }
    return null;
  }
  
  public void a()
  {
    ColorNote localColorNote = b();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        ReportController.b(null, "dc00898", "", "", "0X800A743", "0X800A743", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ColorNoteCurd.OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramOnColorNoteCurdListener);
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo = paramIServiceInfo;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramInt, paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType());
        ReportController.b(null, "dc00898", "", "", "0X800A748", "0X800A748", ColorNoteConstants.a(this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    ColorNoteUtils.a(this.jdField_a_of_type_AndroidContentContext);
    ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.share.ShareEntrance
 * JD-Core Version:    0.7.0.1
 */