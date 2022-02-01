import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.stage.StagePresenterImp.1;
import com.tencent.avgame.gameroom.stage.StagePresenterImp.2;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class nbq
  implements nbn
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Runnable jdField_a_of_type_JavaLangRunnable = new StagePresenterImp.1(this);
  private myc jdField_a_of_type_Myc;
  public nal a;
  protected nbl a;
  public nbp a;
  Runnable b;
  protected nbl b;
  protected nbl c;
  protected nbl d;
  protected nbl e;
  protected nbl f;
  
  public nbq(nbp paramnbp)
  {
    this.jdField_b_of_type_JavaLangRunnable = new StagePresenterImp.2(this);
    this.jdField_a_of_type_Nbp = paramnbp;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Myc != null) && (this.jdField_a_of_type_Myc.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean a(myc parammyc)
  {
    return (this.jdField_a_of_type_Myc != null) && (this.jdField_a_of_type_Myc.a() == 4) && (this.jdField_a_of_type_Myc.a().a(parammyc.a()));
  }
  
  private boolean b(myc parammyc)
  {
    return (this.jdField_a_of_type_Myc != null) && (this.jdField_a_of_type_Myc.a() == 3) && (this.jdField_a_of_type_Myc.a().a(parammyc.a()));
  }
  
  private boolean c(myc parammyc)
  {
    return (this.jdField_a_of_type_Myc != null) && (this.jdField_a_of_type_Myc.a() == 2) && (this.jdField_a_of_type_Myc.a().a(parammyc.a()));
  }
  
  private boolean d(myc parammyc)
  {
    return (this.jdField_a_of_type_Myc != null) && (this.jdField_a_of_type_Myc.a() == 1) && (this.jdField_a_of_type_Myc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(parammyc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void e(myc parammyc)
  {
    if (parammyc.c() == 1) {
      this.jdField_a_of_type_Nbl = this.jdField_b_of_type_Nbl;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "updateCurGameStagePresenter curGameStagePresenter = " + this.jdField_a_of_type_Nbl);
      }
      return;
      if (parammyc.c() == 2) {
        this.jdField_a_of_type_Nbl = this.d;
      } else if (parammyc.c() == 3) {
        this.jdField_a_of_type_Nbl = this.c;
      } else if (parammyc.c() == 4) {
        this.jdField_a_of_type_Nbl = this.f;
      } else if (parammyc.c() == 5) {
        this.jdField_a_of_type_Nbl = this.e;
      }
    }
  }
  
  private boolean e(myc parammyc)
  {
    return mxl.a().a().getAccount().equals(parammyc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void f(myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart");
    }
    g(parammyc);
    if ((this.jdField_a_of_type_Nbl.a()) && (e(parammyc)))
    {
      l = Long.parseLong(mxl.a().a().getAccount());
      RectF localRectF = this.jdField_a_of_type_Nal.a().a(l);
      this.jdField_a_of_type_Nal.a().b(localRectF);
    }
    long l = parammyc.a().jdField_a_of_type_Myf.d * 1000 - parammyc.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart delayMs = " + l);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private void g(myc parammyc)
  {
    this.jdField_a_of_type_Nal.a().a();
    boolean bool = e(parammyc);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateUIForGamePrepare isPlayerSelf = " + bool);
    }
    a(this.jdField_a_of_type_Nbl.a(bool), parammyc.a().jdField_a_of_type_Myf.d * 1000, parammyc.a().d());
    this.jdField_a_of_type_Nbl.a(parammyc);
    c(this.jdField_a_of_type_Nbl.a(this.jdField_a_of_type_Nal.a(), parammyc));
  }
  
  private void h(myc parammyc)
  {
    boolean bool = e(parammyc);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateStageUIForRealStart isPlayerSelf = " + bool);
    }
    this.jdField_a_of_type_Nbp.c();
    this.jdField_a_of_type_Nbl.b(parammyc);
    b(this.jdField_a_of_type_Nbl.a(this.jdField_a_of_type_Nal.a(), bool));
    if ((this.jdField_a_of_type_Nbl.a()) && (!bool))
    {
      long l = Long.parseLong(parammyc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      parammyc = this.jdField_a_of_type_Nal.a().a(l);
      this.jdField_a_of_type_Nal.a().a(parammyc);
    }
  }
  
  private void i(myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleSwitchTopic ,topic = " + parammyc.a().b());
    }
    this.jdField_a_of_type_Nbp.c();
    this.jdField_a_of_type_Nbl.c(parammyc);
    if (parammyc.d(mxl.a().a().getAccount())) {
      this.jdField_a_of_type_Nal.a().b(this.jdField_a_of_type_Nbp.a());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Nbp.a();
  }
  
  public Drawable a()
  {
    myg localmyg = mxl.a().a().a();
    if ((localmyg == null) || (TextUtils.isEmpty(localmyg.h))) {
      return myr.a("avgame_questions_bg_110_height@2x.png");
    }
    return URLDrawable.getDrawable(localmyg.h);
  }
  
  public nal a()
  {
    return this.jdField_a_of_type_Nal;
  }
  
  public void a()
  {
    mxl.a().b();
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nbp.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    String str = mxl.a().a().getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "showTopicSwitchedTip switcherUin = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str))) {
      this.jdField_a_of_type_Nbp.b("avgame_tips_switch_topic@2x.png");
    }
  }
  
  public void a(String paramString, myc parammyc)
  {
    paramString = mxl.a().a().getAccount();
    boolean bool = paramString.equals(parammyc.a().c.uin);
    if ((this.jdField_a_of_type_Nbl.a()) && (bool))
    {
      long l = Long.parseLong(paramString);
      paramString = this.jdField_a_of_type_Nal.a().a(l);
      this.jdField_a_of_type_Nal.a().b(paramString);
    }
  }
  
  public void a(myc parammyc)
  {
    this.jdField_a_of_type_Nbp.a(parammyc);
    this.jdField_a_of_type_Nbp.b(parammyc);
    e(parammyc);
    int i = parammyc.c();
    int j = parammyc.a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "refresh gameType = " + i + ",gameStatus = " + j);
    }
    if (this.jdField_a_of_type_Nbl == null)
    {
      QLog.d("StagePresenterImp", 1, "refresh return for null presenter,gameType = " + i + ",gameStatus = " + j);
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_Myc = parammyc.a();
      return;
    }
    a(true);
    switch (j)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Myc = parammyc.a();
      return;
      if (!d(parammyc))
      {
        f(parammyc);
        continue;
        if (!c(parammyc))
        {
          i(parammyc);
          continue;
          if (!b(parammyc))
          {
            a(parammyc, parammyc.a().jdField_a_of_type_Int);
            continue;
            if (!a(parammyc))
            {
              d(parammyc);
              continue;
              if (!a()) {
                c(parammyc);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(myc parammyc, int paramInt)
  {
    if (!parammyc.a()) {
      return;
    }
    int i = parammyc.a().a(parammyc.a().d.uin);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleAnswerRight scoreThisTime = " + paramInt);
    }
    String str1 = parammyc.a().a();
    Bitmap localBitmap = ((mwp)mxl.a().a().a(2)).a(String.valueOf(parammyc.a().d.uin), (byte)1);
    String str2 = parammyc.a().d.nick;
    boolean bool = mxl.a().a().getAccount().equals(parammyc.a().d.uin);
    if (!bool) {
      bcst.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", parammyc.d(), 0, "", "", "", "");
    }
    int j = parammyc.d();
    if (bool) {}
    for (Object localObject = "1";; localObject = "2")
    {
      bcst.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", j, 0, (String)localObject, "", "", "");
      this.jdField_a_of_type_Nal.a().a(str1, localBitmap, str2, paramInt, i, bool);
      myq.a().a(parammyc.a(), "succeed");
      localObject = this.jdField_a_of_type_Nal.a().a();
      this.jdField_a_of_type_Nal.a().a((View)localObject, this.jdField_a_of_type_Nal.a().a(), true);
      if (parammyc.c() == 2) {
        this.jdField_a_of_type_Nbp.b();
      }
      this.jdField_a_of_type_Nbl.d(parammyc);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, parammyc.a().jdField_a_of_type_Myf.f * 1000);
      return;
    }
  }
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_Nal = paramnal;
  }
  
  public void a(nbl paramnbl)
  {
    this.jdField_b_of_type_Nbl = paramnbl;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onShowGameContent " + paramBoolean + ",curGameStagePresenter = " + this.jdField_a_of_type_Nbl);
    }
    if (this.jdField_a_of_type_Nbl != null) {
      this.jdField_a_of_type_Nbl.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nbp.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public Drawable b()
  {
    myg localmyg = mxl.a().a().a();
    if ((localmyg == null) || (TextUtils.isEmpty(localmyg.i))) {
      return myr.a("avgame_questions_bg_130_height@2x.png");
    }
    return URLDrawable.getDrawable(localmyg.i);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    if (this.jdField_a_of_type_Nbl != null) {
      this.jdField_a_of_type_Nbl.a(null);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nal.a(paramString);
  }
  
  public void b(String paramString, myc parammyc)
  {
    if (parammyc.c())
    {
      if (!e(parammyc)) {
        break label74;
      }
      b(this.jdField_a_of_type_Nal.a().getResources().getString(2131690204));
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", parammyc.d(), 0, "", "", "", "");
      return;
      label74:
      paramString = parammyc.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
      b(String.format(this.jdField_a_of_type_Nal.a().getResources().getString(2131690205), new Object[] { bglf.a(paramString, 8.0F) }));
    }
  }
  
  public void b(myc parammyc)
  {
    this.jdField_a_of_type_Nbp.b(parammyc);
  }
  
  public void b(nbl paramnbl)
  {
    this.c = paramnbl;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Nbp.a(paramString);
  }
  
  public void c(myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.jdField_a_of_type_Nal.a().a();
    d();
    myq.a().a(parammyc.a(), "over");
    if (parammyc.d(mxl.a().a().getAccount())) {
      this.jdField_a_of_type_Nal.a().b();
    }
    this.jdField_a_of_type_Nal.a().e();
    this.jdField_a_of_type_Nbl.f(parammyc);
  }
  
  public void c(nbl paramnbl)
  {
    this.d = paramnbl;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nbp.a();
  }
  
  public void d(myc parammyc)
  {
    Object localObject = parammyc.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onAnswerTimeoutPush answer = " + (String)localObject);
    }
    bcst.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", parammyc.d(), 0, "", "", "", "");
    this.jdField_a_of_type_Nal.a().a((String)localObject);
    myq.a().a(parammyc.a(), "failed");
    localObject = this.jdField_a_of_type_Nal.a().a();
    this.jdField_a_of_type_Nal.a().a((View)localObject, this.jdField_a_of_type_Nal.a().a(), false);
    if (parammyc.c() == 2) {
      this.jdField_a_of_type_Nbp.b();
    }
    this.jdField_a_of_type_Nbl.e(parammyc);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, parammyc.a().jdField_a_of_type_Myf.f * 1000);
  }
  
  public void d(nbl paramnbl)
  {
    this.f = paramnbl;
  }
  
  public void e(nbl paramnbl)
  {
    this.e = paramnbl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbq
 * JD-Core Version:    0.7.0.1
 */