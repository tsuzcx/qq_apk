package cooperation.qqreader.host.colornote;

import android.content.Context;
import android.content.ContextWrapper;
import aqcb;
import blpv;

public class ReaderColorNoteController
{
  private aqcb a;
  
  public ReaderColorNoteController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = new aqcb(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static void setCustomNightMode(Context paramContext, boolean paramBoolean)
  {
    aqcb.a(paramContext, paramBoolean);
  }
  
  public void addHistoryNote()
  {
    this.a.p();
  }
  
  public void addToRecentNote()
  {
    this.a.n();
  }
  
  public void attachToActivity(ContextWrapper paramContextWrapper)
  {
    paramContextWrapper = blpv.a(paramContextWrapper);
    if (paramContextWrapper != null) {
      this.a.a(paramContextWrapper);
    }
  }
  
  public boolean canAddColorNote()
  {
    return this.a.b();
  }
  
  public void deleteColorNote()
  {
    this.a.f();
  }
  
  public void exitAnimation()
  {
    this.a.d();
  }
  
  public void insertColorNote()
  {
    this.a.e();
  }
  
  public boolean isColorNoteExist()
  {
    return this.a.c();
  }
  
  public void onCannotAdd()
  {
    this.a.i();
  }
  
  public void onDestroy()
  {
    this.a.c();
  }
  
  public void onPause()
  {
    this.a.b();
  }
  
  public void onResume()
  {
    if (this.a.a()) {
      this.a.a();
    }
  }
  
  public void setColorNoteAnimFinishCallback(OnColorNoteAnimFinishCallback paramOnColorNoteAnimFinishCallback)
  {
    this.a.a(new ReaderColorNoteController.1(this, paramOnColorNoteAnimFinishCallback));
  }
  
  public void setReaderServiceInfo(IReaderServiceInfo paramIReaderServiceInfo)
  {
    this.a.a(new ReaderColorNoteController.2(this, paramIReaderServiceInfo));
  }
  
  public boolean shouldDisplayColorNote()
  {
    return this.a.a();
  }
  
  public void updateColorNote(ReaderColorNote paramReaderColorNote)
  {
    this.a.a(paramReaderColorNote.mColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.colornote.ReaderColorNoteController
 * JD-Core Version:    0.7.0.1
 */