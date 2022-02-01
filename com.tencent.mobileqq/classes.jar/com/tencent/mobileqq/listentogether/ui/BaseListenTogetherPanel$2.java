package com.tencent.mobileqq.listentogether.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class BaseListenTogetherPanel$2
  extends ListenTogetherObserver
{
  BaseListenTogetherPanel$2(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  protected void a(int paramInt, String paramString)
  {
    QLog.d("BaseListenTogetherPanel", 1, String.format("onJoinAndEnter [%d,%s] [%d,%s] resumed=[%b] ", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(this.a.e.a), this.a.e.b, Boolean.valueOf(this.a.i) }));
    if ((this.a.i) && (this.a.e.a == paramInt))
    {
      if (!this.a.e.b.equalsIgnoreCase(paramString)) {
        return;
      }
      paramString = ListenTogetherManager.a(this.a.b.app).e(paramInt, paramString);
      if ((paramString != null) && (this.a.e.c != 3))
      {
        if (this.a.e.d != 2)
        {
          QQToast.makeText(this.a.b, 2131891236, 0).show();
          return;
        }
        if (this.a.e.c == 4)
        {
          QQToast.makeText(this.a.b, 2131891238, 0).show();
          return;
        }
        MusicInfo localMusicInfo = paramString.e();
        ListenTogetherPlayFragment.a(this.a.b, paramString, localMusicInfo, this.a.e.e, null);
        return;
      }
      QQToast.makeText(this.a.b, 2131891234, 0).show();
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    BaseListenTogetherPanel.a(this.a, paramInt, paramString1, paramString2);
  }
  
  protected void a(int paramInt, String paramString, boolean paramBoolean)
  {
    this.a.a(paramInt, paramString, paramBoolean);
  }
  
  protected void a(ListenTogetherSession paramListenTogetherSession)
  {
    this.a.a(paramListenTogetherSession);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    this.a.a(paramString, paramInt1, paramInt2);
  }
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if ((paramInt1 == this.a.e.a) && (paramString1.equals(this.a.e.b)) && (!paramBoolean))
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.b.getResources().getString(2131891240);
      }
      QQToast.makeText(this.a.b, paramString1, 0).show();
    }
  }
  
  protected void b(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
  }
  
  protected void h(int paramInt, String paramString)
  {
    this.a.b(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.2
 * JD-Core Version:    0.7.0.1
 */