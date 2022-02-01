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

public class ndd
  implements nda
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Runnable jdField_a_of_type_JavaLangRunnable = new StagePresenterImp.1(this);
  private mze jdField_a_of_type_Mze;
  public nbp a;
  protected ncy a;
  public ndc a;
  Runnable b;
  protected ncy b;
  protected ncy c;
  protected ncy d;
  protected ncy e;
  protected ncy f;
  
  public ndd(ndc paramndc)
  {
    this.jdField_b_of_type_JavaLangRunnable = new StagePresenterImp.2(this);
    this.jdField_a_of_type_Ndc = paramndc;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Mze != null) && (this.jdField_a_of_type_Mze.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean a(mze parammze)
  {
    return (this.jdField_a_of_type_Mze != null) && (this.jdField_a_of_type_Mze.a() == 4) && (this.jdField_a_of_type_Mze.a().a(parammze.a()));
  }
  
  private boolean b(mze parammze)
  {
    return (this.jdField_a_of_type_Mze != null) && (this.jdField_a_of_type_Mze.a() == 3) && (this.jdField_a_of_type_Mze.a().a(parammze.a()));
  }
  
  private boolean c(mze parammze)
  {
    return (this.jdField_a_of_type_Mze != null) && (this.jdField_a_of_type_Mze.a() == 2) && (this.jdField_a_of_type_Mze.a().a(parammze.a()));
  }
  
  private boolean d(mze parammze)
  {
    return (this.jdField_a_of_type_Mze != null) && (this.jdField_a_of_type_Mze.a() == 1) && (this.jdField_a_of_type_Mze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(parammze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void e(mze parammze)
  {
    if (parammze.c() == 1) {
      this.jdField_a_of_type_Ncy = this.jdField_b_of_type_Ncy;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "updateCurGameStagePresenter curGameStagePresenter = " + this.jdField_a_of_type_Ncy);
      }
      return;
      if (parammze.c() == 2) {
        this.jdField_a_of_type_Ncy = this.d;
      } else if (parammze.c() == 3) {
        this.jdField_a_of_type_Ncy = this.c;
      } else if (parammze.c() == 4) {
        this.jdField_a_of_type_Ncy = this.f;
      } else if (parammze.c() == 5) {
        this.jdField_a_of_type_Ncy = this.e;
      }
    }
  }
  
  private boolean e(mze parammze)
  {
    return myk.a().a().getAccount().equals(parammze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void f(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart buff = " + parammze.a().a()[0] + parammze.a().a()[1] + parammze.a().a()[2]);
    }
    g(parammze);
    if ((this.jdField_a_of_type_Ncy.a()) && (e(parammze)))
    {
      l = Long.parseLong(myk.a().a().getAccount());
      RectF localRectF = this.jdField_a_of_type_Nbp.a().a(l);
      this.jdField_a_of_type_Nbp.a().b(localRectF);
    }
    long l = parammze.a().jdField_a_of_type_Mzi.d * 1000 - parammze.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart delayMs = " + l);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private void g(mze parammze)
  {
    this.jdField_a_of_type_Nbp.a().a();
    boolean bool = e(parammze);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateUIForGamePrepare isPlayerSelf = " + bool);
    }
    a(this.jdField_a_of_type_Ncy.a(bool), parammze.a().jdField_a_of_type_Mzi.d * 1000, parammze.a().d());
    this.jdField_a_of_type_Ncy.a(parammze);
    c(this.jdField_a_of_type_Ncy.a(this.jdField_a_of_type_Nbp.a(), parammze));
  }
  
  private void h(mze parammze)
  {
    boolean bool = e(parammze);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateStageUIForRealStart isPlayerSelf = " + bool);
    }
    this.jdField_a_of_type_Ndc.c();
    this.jdField_a_of_type_Ncy.b(parammze);
    b(this.jdField_a_of_type_Ncy.a(this.jdField_a_of_type_Nbp.a(), bool));
    if ((this.jdField_a_of_type_Ncy.a()) && (!bool))
    {
      long l = Long.parseLong(parammze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      parammze = this.jdField_a_of_type_Nbp.a().a(l);
      this.jdField_a_of_type_Nbp.a().a(parammze);
    }
  }
  
  private void i(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleSwitchTopic ,topic = " + parammze.a().b() + " buff = " + parammze.a().a()[0] + parammze.a().a()[1] + parammze.a().a()[2]);
    }
    this.jdField_a_of_type_Ndc.c();
    this.jdField_a_of_type_Ncy.c(parammze);
    if (parammze.d(myk.a().a().getAccount())) {
      this.jdField_a_of_type_Nbp.a().b(this.jdField_a_of_type_Ndc.a());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Ndc.a();
  }
  
  public Drawable a()
  {
    mzj localmzj = myk.a().a().a();
    if ((localmzj == null) || (TextUtils.isEmpty(localmzj.h))) {
      return mzu.a("avgame_questions_bg_110_height@2x.png");
    }
    return URLDrawable.getDrawable(localmzj.h);
  }
  
  public nbp a()
  {
    return this.jdField_a_of_type_Nbp;
  }
  
  public void a()
  {
    myk.a().b();
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ndc.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    String str = myk.a().a().getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "showTopicSwitchedTip switcherUin = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str))) {
      this.jdField_a_of_type_Ndc.b("avgame_tips_switch_topic@2x.png");
    }
  }
  
  public void a(String paramString, mze parammze)
  {
    paramString = myk.a().a().getAccount();
    boolean bool = paramString.equals(parammze.a().c.uin);
    if ((this.jdField_a_of_type_Ncy.a()) && (bool))
    {
      long l = Long.parseLong(paramString);
      paramString = this.jdField_a_of_type_Nbp.a().a(l);
      this.jdField_a_of_type_Nbp.a().b(paramString);
    }
  }
  
  public void a(mze parammze)
  {
    this.jdField_a_of_type_Ndc.a(parammze);
    this.jdField_a_of_type_Ndc.b(parammze);
    e(parammze);
    int i = parammze.c();
    int j = parammze.a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "refresh gameType = " + i + ",gameStatus = " + j);
    }
    if (this.jdField_a_of_type_Ncy == null)
    {
      QLog.d("StagePresenterImp", 1, "refresh return for null presenter,gameType = " + i + ",gameStatus = " + j);
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_Mze = parammze.a();
      return;
    }
    a(true);
    switch (j)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Mze = parammze.a();
      return;
      if (!d(parammze))
      {
        f(parammze);
        continue;
        if (!c(parammze))
        {
          i(parammze);
          continue;
          if (!b(parammze))
          {
            a(parammze, parammze.a().jdField_a_of_type_Int, parammze.a().b);
            continue;
            if (!a(parammze))
            {
              d(parammze);
              continue;
              if (!a()) {
                c(parammze);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(mze parammze, int paramInt1, int paramInt2)
  {
    if (!parammze.a()) {
      return;
    }
    int i = parammze.a().a(parammze.a().d.uin);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleAnswerRight scoreThisTime = " + paramInt1 + ", actorScoreThisTime = " + paramInt2 + ", combo = " + parammze.a().jdField_a_of_type_Long);
    }
    String str2 = parammze.a().a();
    Object localObject = (mxo)myk.a().a().a(2);
    Bitmap localBitmap = ((mxo)localObject).a(String.valueOf(parammze.a().d.uin), (byte)1);
    String str3 = parammze.a().d.nick;
    long l = parammze.a().jdField_a_of_type_Long;
    if ((parammze.c() == 1) && (parammze.b() != null)) {}
    for (localObject = ((mxo)localObject).a(parammze.b().uin, (byte)1);; localObject = null)
    {
      boolean bool = myk.a().a().getAccount().equals(parammze.a().d.uin);
      if (!bool) {
        bdll.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", parammze.d(), 0, "", "", "", "");
      }
      int j = parammze.d();
      if (bool) {}
      for (String str1 = "1";; str1 = "2")
      {
        bdll.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", j, 0, str1, "", String.valueOf(l), "");
        this.jdField_a_of_type_Nbp.a().a(str2, localBitmap, str3, paramInt1, i, l, (Bitmap)localObject, paramInt2, bool);
        mzt.a().a(parammze.a(), "succeed");
        localObject = this.jdField_a_of_type_Nbp.a().a();
        this.jdField_a_of_type_Nbp.a().a((View)localObject, this.jdField_a_of_type_Nbp.a().a(), true);
        if (parammze.c() == 2) {
          this.jdField_a_of_type_Ndc.b();
        }
        this.jdField_a_of_type_Ncy.d(parammze);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, parammze.a().jdField_a_of_type_Mzi.f * 1000);
        return;
      }
    }
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nbp = paramnbp;
  }
  
  public void a(ncy paramncy)
  {
    this.jdField_b_of_type_Ncy = paramncy;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onShowGameContent " + paramBoolean + ",curGameStagePresenter = " + this.jdField_a_of_type_Ncy);
    }
    if (this.jdField_a_of_type_Ncy != null) {
      this.jdField_a_of_type_Ncy.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ndc.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public Drawable b()
  {
    mzj localmzj = myk.a().a().a();
    if ((localmzj == null) || (TextUtils.isEmpty(localmzj.i))) {
      return mzu.a("avgame_questions_bg_130_height@2x.png");
    }
    return URLDrawable.getDrawable(localmzj.i);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    if (this.jdField_a_of_type_Ncy != null) {
      this.jdField_a_of_type_Ncy.a(null);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nbp.a(paramString);
  }
  
  public void b(String paramString, mze parammze)
  {
    if (parammze.c())
    {
      if (!e(parammze)) {
        break label74;
      }
      b(this.jdField_a_of_type_Nbp.a().getResources().getString(2131690215));
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", parammze.d(), 0, "", "", "", "");
      return;
      label74:
      paramString = parammze.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
      b(String.format(this.jdField_a_of_type_Nbp.a().getResources().getString(2131690216), new Object[] { bhlg.a(paramString, 8.0F) }));
    }
  }
  
  public void b(mze parammze)
  {
    this.jdField_a_of_type_Ndc.b(parammze);
  }
  
  public void b(ncy paramncy)
  {
    this.c = paramncy;
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
    this.jdField_a_of_type_Ndc.a(paramString);
  }
  
  public void c(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.jdField_a_of_type_Nbp.a().a();
    d();
    mzt.a().a(parammze.a(), "over");
    if (parammze.d(myk.a().a().getAccount())) {
      this.jdField_a_of_type_Nbp.a().b();
    }
    this.jdField_a_of_type_Nbp.a().e();
    this.jdField_a_of_type_Ncy.f(parammze);
  }
  
  public void c(ncy paramncy)
  {
    this.d = paramncy;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ndc.a();
  }
  
  public void d(mze parammze)
  {
    Object localObject = parammze.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onAnswerTimeoutPush answer = " + (String)localObject);
    }
    bdll.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", parammze.d(), 0, "", "", "", "");
    this.jdField_a_of_type_Nbp.a().a((String)localObject);
    mzt.a().a(parammze.a(), "failed");
    localObject = this.jdField_a_of_type_Nbp.a().a();
    this.jdField_a_of_type_Nbp.a().a((View)localObject, this.jdField_a_of_type_Nbp.a().a(), false);
    if (parammze.c() == 2) {
      this.jdField_a_of_type_Ndc.b();
    }
    this.jdField_a_of_type_Ncy.e(parammze);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, parammze.a().jdField_a_of_type_Mzi.f * 1000);
  }
  
  public void d(ncy paramncy)
  {
    this.f = paramncy;
  }
  
  public void e(ncy paramncy)
  {
    this.e = paramncy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ndd
 * JD-Core Version:    0.7.0.1
 */