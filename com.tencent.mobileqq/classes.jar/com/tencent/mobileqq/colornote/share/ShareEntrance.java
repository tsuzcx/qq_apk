package com.tencent.mobileqq.colornote.share;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.colornote.ColorNoteConstants;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class ShareEntrance
{
  private View a;
  private ColorNoteCurd b;
  private IServiceInfo c;
  private Context d;
  
  public ShareEntrance(Context paramContext)
  {
    this.d = paramContext;
    this.b = new ColorNoteCurd();
    this.b.a(new OnColorNoteCurdListener());
  }
  
  private ColorNote h()
  {
    IServiceInfo localIServiceInfo = this.c;
    if (localIServiceInfo != null) {
      return localIServiceInfo.getColorNote();
    }
    return null;
  }
  
  public IServiceInfo a()
  {
    return this.c;
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(IServiceInfo paramIServiceInfo)
  {
    this.c = paramIServiceInfo;
  }
  
  public void a(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    this.b.a(paramOnColorNoteCurdListener);
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.b.a(paramColorNote);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return this.b.a(paramInt, paramString);
  }
  
  public void b()
  {
    ColorNote localColorNote = h();
    if (localColorNote != null)
    {
      this.b.a(localColorNote.parseBundle());
      if (localColorNote.getServiceType() != 16973824) {
        ReportController.b(null, "dc00898", "", "", "0X800A743", "0X800A743", ColorNoteConstants.a(this.c.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((IServiceInfo)localObject).getColorNote();
      if (localObject != null)
      {
        this.b.b(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
        ReportController.b(null, "dc00898", "", "", "0X800A748", "0X800A748", ColorNoteConstants.a(((ColorNote)localObject).mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean d()
  {
    return this.b.b();
  }
  
  public boolean e()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((IServiceInfo)localObject).getColorNote();
      if (localObject != null) {
        return this.b.a(((ColorNote)localObject).getServiceType(), ((ColorNote)localObject).getSubType());
      }
    }
    return false;
  }
  
  public void f()
  {
    ColorNoteUtils.a(this.d);
    ReportController.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
  
  public ColorNote g()
  {
    IServiceInfo localIServiceInfo = this.c;
    if (localIServiceInfo != null) {
      return localIServiceInfo.getColorNote();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.share.ShareEntrance
 * JD-Core Version:    0.7.0.1
 */