package com.tencent.mobileqq.colornote.share;

import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteCurd.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.qphone.base.util.QLog;

public class ColorNoteStateNotice
{
  private ColorNoteCurd jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = new ColorNoteCurd();
  private ColorNoteRecentView jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView;
  private IServiceInfo jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ColorNoteStateNotice()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(new ColorNoteCurd.OnColorNoteCurdListener());
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView = new ColorNoteRecentView();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView.a(this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292) || (paramInt == 16842752) || (paramInt == 16908290);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null))
    {
      localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = ColorNoteUtils.a(localColorNote);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void a(ColorNoteCurd.OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(paramOnColorNoteCurdListener);
    }
  }
  
  public void a(ColorNoteCurd paramColorNoteCurd)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd = paramColorNoteCurd;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo = paramIServiceInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null))
    {
      localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = ColorNoteUtils.a(localColorNote);
        this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView != null))
    {
      localObject = null;
      try
      {
        ColorNote localColorNote = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo.getColorNote();
        localObject = localColorNote;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ColorNoteStateNotice", 1, localException, new Object[0]);
        }
        if (localObject == null) {
          break label141;
        }
        bool2 = true;
        QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] colorNote: ", Boolean.valueOf(bool2), ", allowType: ", Boolean.valueOf(bool1), ", isReady: ", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", recentNote: ", Boolean.valueOf(paramBoolean) });
        return;
      }
      if ((localObject == null) || (!a(localObject.getServiceType()))) {
        break label277;
      }
    }
    label141:
    label277:
    for (bool1 = true;; bool1 = false)
    {
      if ((localObject != null) && (bool1) && (this.jdField_a_of_type_Boolean) && (paramBoolean))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localObject.getServiceType(), localObject.getSubType()))
        {
          ColorNoteUtils.a(localObject);
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView.a(localObject);
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) {
          bool1 = true;
        }
        QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] serviceInfo: ", Boolean.valueOf(paramBoolean), ", colorNoteCurd: ", Boolean.valueOf(bool1), "recentlyViewed: ", this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView });
        return;
      }
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.share.ColorNoteStateNotice
 * JD-Core Version:    0.7.0.1
 */