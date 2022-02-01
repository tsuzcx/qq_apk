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
  private ColorNoteCurd a = new ColorNoteCurd();
  private IServiceInfo b;
  private ColorNoteRecentView c;
  private boolean d = true;
  
  public ColorNoteStateNotice()
  {
    this.a.a(new OnColorNoteCurdListener());
    this.c = new ColorNoteRecentView();
    this.c.a(this.a);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 16908289) || (paramInt == 16908292) || (paramInt == 16842752) || (paramInt == 16908290);
  }
  
  public void a()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((IServiceInfo)localObject).getColorNote();
        if (localObject != null)
        {
          this.a.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType(), true);
          ColorNote localColorNote = ColorNoteUtils.c((ColorNote)localObject);
          this.a.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
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
    this.a = paramColorNoteCurd;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.b = paramIServiceInfo;
  }
  
  public void a(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    ColorNoteCurd localColorNoteCurd = this.a;
    if (localColorNoteCurd != null) {
      localColorNoteCurd.a(paramOnColorNoteCurdListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b()
  {
    if (this.a != null)
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = ((IServiceInfo)localObject).getColorNote();
        if (localObject != null)
        {
          this.a.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType(), false);
          ColorNote localColorNote = ColorNoteUtils.c((ColorNote)localObject);
          this.a.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
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
    Object localObject2 = this.b;
    boolean bool1 = false;
    boolean bool2 = false;
    if ((localObject2 != null) && (this.a != null) && (this.c != null))
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
      if ((localObject1 != null) && (bool1) && (this.d) && (paramBoolean))
      {
        if (!this.a.a(localObject1.getServiceType(), localObject1.getSubType()))
        {
          ColorNoteUtils.a(localObject1);
          this.c.a(localObject1);
        }
      }
      else
      {
        if (localObject1 != null) {
          bool2 = true;
        }
        QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] colorNote: ", Boolean.valueOf(bool2), ", allowType: ", Boolean.valueOf(bool1), ", isReady: ", Boolean.valueOf(this.d), ", recentNote: ", Boolean.valueOf(paramBoolean) });
      }
    }
    else
    {
      if (this.b != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      if (this.a != null) {
        bool1 = true;
      }
      QLog.d("ColorNoteStateNotice", 1, new Object[] { "[noticeRecentColorNote] serviceInfo: ", Boolean.valueOf(paramBoolean), ", colorNoteCurd: ", Boolean.valueOf(bool1), "recentlyViewed: ", this.c });
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