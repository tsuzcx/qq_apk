package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class FavEmosmViewPage$3
  implements MultiEmotionSaveManager.ISaveCallBack
{
  FavEmosmViewPage$3(FavEmosmViewPage paramFavEmosmViewPage, FileSaveDialog paramFileSaveDialog) {}
  
  public void a()
  {
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    FavEmosmViewPage.b(this.b);
    this.b.t.b().b();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(EmotionSaveResult paramEmotionSaveResult)
  {
    if ((paramEmotionSaveResult != null) && (!this.b.s.isFinishing()))
    {
      int i = paramEmotionSaveResult.d;
      if (i != -1)
      {
        if (i == 0) {
          QQToast.makeText(this.b.s.getApplicationContext(), this.b.s.getString(2131915871), 0).show();
        }
      }
      else if (paramEmotionSaveResult.e == 10006) {
        QQToast.makeText(this.b.s.getApplicationContext(), this.b.s.getString(2131915862), 0).show();
      } else {
        QQToast.makeText(this.b.s.getApplicationContext(), this.b.s.getString(2131915866), 0).show();
      }
    }
    else if (QLog.isColorLevel())
    {
      paramEmotionSaveResult = new StringBuilder();
      paramEmotionSaveResult.append("onSaveComplete ");
      paramEmotionSaveResult.append(this.b.s.isFinishing());
      QLog.i("MultiEmotionSaveManager", 2, paramEmotionSaveResult.toString());
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
    FavEmosmViewPage.b(this.b);
    this.b.t.b().b();
  }
  
  public void b()
  {
    if (!this.a.isShowing())
    {
      this.a.a(0);
      this.a.a(new FavEmosmViewPage.3.1(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavEmosmViewPage.3
 * JD-Core Version:    0.7.0.1
 */