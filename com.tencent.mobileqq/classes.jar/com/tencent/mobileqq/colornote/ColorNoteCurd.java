package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ColorNoteCurd
{
  private AppRuntime a;
  private OnColorNoteCurdListener b;
  private final Handler c = new ColorNoteDataMsgHandler(this);
  
  private AppRuntime d()
  {
    AppRuntime localAppRuntime = this.a;
    if (localAppRuntime != null) {
      return localAppRuntime;
    }
    localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    this.a = localAppRuntime;
    return localAppRuntime;
  }
  
  private boolean e()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public OnColorNoteCurdListener a()
  {
    return this.b;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (e())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.2(this, paramInt1, paramString, paramInt2), 32, null, true);
      return;
    }
    b(paramInt1, paramString, paramInt2);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (e())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.3(this, paramInt, paramString, paramBoolean), 32, null, true);
      return;
    }
    b(paramInt, paramString, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    if (e())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.1(this, paramBundle), 32, null, true);
      return;
    }
    b(paramBundle);
  }
  
  public void a(OnColorNoteCurdListener paramOnColorNoteCurdListener)
  {
    this.b = paramOnColorNoteCurdListener;
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (e())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.4(this, paramColorNote), 32, null, true);
      return;
    }
    b(paramColorNote);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).isColorNoteExist(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString)
  {
    a(paramInt, paramString, 0);
  }
  
  void b(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = ((IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all")).deleteColorNote(paramInt1, paramString, paramInt2);
    Message localMessage = Message.obtain();
    localMessage.obj = new Pair(Integer.valueOf(paramInt1), paramString);
    if (bool) {
      localMessage.what = 5;
    } else {
      localMessage.what = 6;
    }
    this.c.sendMessage(localMessage);
  }
  
  void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = ((IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all")).updateColorNoteState(paramInt, paramString, paramBoolean);
    if (localBundle == null) {
      return;
    }
    localBundle.putInt("key_service_type", paramInt);
    localBundle.putString("key_sub_type", paramString);
    paramString = Message.obtain();
    paramString.what = 9;
    paramString.obj = localBundle;
    this.c.sendMessage(paramString);
  }
  
  void b(Bundle paramBundle)
  {
    boolean bool = ((IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all")).addColorNote(paramBundle);
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (bool) {
      localMessage.what = 3;
    } else {
      localMessage.what = 4;
    }
    this.c.sendMessage(localMessage);
  }
  
  void b(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return;
    }
    Object localObject = paramColorNote.getUniKey();
    IColorNoteHelper localIColorNoteHelper = (IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all");
    if (paramColorNote.mMainTitle != null) {
      bool2 = localIColorNoteHelper.updateColorNote((String)localObject, "mMainTitle", paramColorNote.mMainTitle);
    } else {
      bool2 = true;
    }
    boolean bool1 = bool2;
    if (paramColorNote.mSubTitle != null) {
      bool1 = bool2 & localIColorNoteHelper.updateColorNote((String)localObject, "mSubTitle", paramColorNote.mSubTitle);
    }
    boolean bool2 = bool1;
    if (paramColorNote.mPicUrl != null) {
      bool2 = bool1 & localIColorNoteHelper.updateColorNote((String)localObject, "mPicUrl", paramColorNote.mPicUrl);
    }
    bool1 = bool2;
    if (paramColorNote.mReserve != null) {
      bool1 = bool2 & localIColorNoteHelper.updateColorNote((String)localObject, "mReserve", paramColorNote.mReserve, 1);
    }
    localObject = Message.obtain();
    if (bool1) {
      ((Message)localObject).what = 10;
    } else {
      ((Message)localObject).what = 11;
    }
    ((Message)localObject).obj = paramColorNote;
    this.c.sendMessage((Message)localObject);
  }
  
  public boolean b()
  {
    if (MobileQQ.sProcessId == 1) {
      return ((IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote();
    }
    return ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).getCanAddColorNote();
  }
  
  public void c(ColorNote paramColorNote)
  {
    if (e())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.5(this, paramColorNote), 32, null, true);
      return;
    }
    d(paramColorNote);
  }
  
  public boolean c()
  {
    return ((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).getSyncState();
  }
  
  void d(ColorNote paramColorNote)
  {
    ((IColorNoteHelper)d().getRuntimeService(IColorNoteHelper.class, "all")).updateRecentNote(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.ColorNoteCurd
 * JD-Core Version:    0.7.0.1
 */