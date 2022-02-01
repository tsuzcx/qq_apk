package com.tencent.mobileqq.colornote.share;

import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
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
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(new OnColorNoteCurdListener());
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView = new ColorNoteRecentView();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView.a(this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292) || (paramInt == 16842752) || (paramInt == 16908290);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
      if (localObject != null)
      {
        localObject = ((IServiceInfo)localObject).getColorNote();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType(), true);
          ColorNote localColorNote = ColorNoteUtils.a((ColorNote)localObject);
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
          QLog.d("ColorNoteStateNotice", 1, new Object[] { "[onResume] ColorNote: ", ((ColorNote)localObject).toString() });
          return;
        }
        QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
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
  
  public void a(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    ColorNoteCurd localColorNoteCurd = this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd;
    if (localColorNoteCurd != null) {
      localColorNoteCurd.a(paramOnColorNoteCurdListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
      if (localObject != null)
      {
        localObject = ((IServiceInfo)localObject).getColorNote();
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType(), false);
          ColorNote localColorNote = ColorNoteUtils.a((ColorNote)localObject);
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
          QLog.d("ColorNoteStateNotice", 1, new Object[] { "[onPause] ColorNote: ", ((ColorNote)localObject).toString() });
          return;
        }
        QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) && (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView != null))
    {
      Object localObject1 = null;
      try
      {
        localObject2 = ((IServiceInfo)localObject2).getColorNote();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteStateNotice", 1, localException, new Object[0]);
      }
      if ((localObject1 != null) && (a(localObject1.getServiceType()))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((localObject1 != null) && (bool1) && (this.jdField_a_of_type_Boolean) && (paramBoolean))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd.a(localObject1.getServiceType(), localObject1.getSubType()))
        {
          ColorNoteUtils.a(localObject1);
          this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView.a(localObject1);
        }
      }
      else
      {
        if (localObject1 != null) {
          bool2 = true;
        }
        QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] colorNote: ", Boolean.valueOf(bool2), ", allowType: ", Boolean.valueOf(bool1), ", isReady: ", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", recentNote: ", Boolean.valueOf(paramBoolean) });
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteIServiceInfo != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteCurd != null) {
        bool1 = true;
      }
      QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] serviceInfo: ", Boolean.valueOf(paramBoolean), ", colorNoteCurd: ", Boolean.valueOf(bool1), "recentlyViewed: ", this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteRecentView });
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.share.ColorNoteStateNotice
 * JD-Core Version:    0.7.0.1
 */