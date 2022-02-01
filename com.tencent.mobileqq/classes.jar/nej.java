import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.stage.StagePresenterImp.1;
import com.tencent.avgame.gameroom.stage.StagePresenterImp.2;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class nej
  implements neg
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Runnable jdField_a_of_type_JavaLangRunnable = new StagePresenterImp.1(this);
  private naf jdField_a_of_type_Naf;
  public ncq a;
  protected ned a;
  public nei a;
  Runnable b;
  protected ned b;
  protected ned c;
  protected ned d;
  protected ned e;
  protected ned f;
  
  public nej(nei paramnei)
  {
    this.jdField_b_of_type_JavaLangRunnable = new StagePresenterImp.2(this);
    this.jdField_a_of_type_Nei = paramnei;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean a(naf paramnaf)
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a() == 4) && (this.jdField_a_of_type_Naf.a().a(paramnaf.a()));
  }
  
  private boolean b(naf paramnaf)
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a() == 3) && (this.jdField_a_of_type_Naf.a().a(paramnaf.a()));
  }
  
  private boolean c(naf paramnaf)
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a() == 2) && (this.jdField_a_of_type_Naf.a().a(paramnaf.a()));
  }
  
  private boolean d(naf paramnaf)
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a().owner != paramnaf.a().owner) && (mzl.a().a());
  }
  
  private void e(naf paramnaf)
  {
    if (paramnaf.c() == 1) {
      this.jdField_a_of_type_Ned = this.jdField_b_of_type_Ned;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "updateCurGameStagePresenter curGameStagePresenter = " + this.jdField_a_of_type_Ned);
      }
      return;
      if (paramnaf.c() == 2) {
        this.jdField_a_of_type_Ned = this.d;
      } else if (paramnaf.c() == 3) {
        this.jdField_a_of_type_Ned = this.c;
      } else if (paramnaf.c() == 4) {
        this.jdField_a_of_type_Ned = this.f;
      } else if (paramnaf.c() == 5) {
        this.jdField_a_of_type_Ned = this.e;
      }
    }
  }
  
  private boolean e(naf paramnaf)
  {
    return (this.jdField_a_of_type_Naf != null) && (this.jdField_a_of_type_Naf.a() == 1) && (this.jdField_a_of_type_Naf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(paramnaf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void f(naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart buff = " + paramnaf.a().a()[0] + paramnaf.a().a()[1] + paramnaf.a().a()[2]);
    }
    g(paramnaf);
    if ((this.jdField_a_of_type_Ned.a()) && (f(paramnaf)))
    {
      l = Long.parseLong(mzl.a().a().getAccount());
      RectF localRectF = this.jdField_a_of_type_Ncq.a().a(l);
      this.jdField_a_of_type_Ncq.a().b(localRectF);
    }
    long l = paramnaf.a().jdField_a_of_type_Naj.d * 1000 - paramnaf.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart delayMs = " + l);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private boolean f(naf paramnaf)
  {
    return mzl.a().a().getAccount().equals(paramnaf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void g(naf paramnaf)
  {
    this.jdField_a_of_type_Ncq.a().a();
    boolean bool = f(paramnaf);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateUIForGamePrepare isPlayerSelf = " + bool);
    }
    a(this.jdField_a_of_type_Ned.a(bool), paramnaf.a().jdField_a_of_type_Naj.d * 1000, paramnaf.a().d());
    this.jdField_a_of_type_Ned.a(paramnaf);
    b(this.jdField_a_of_type_Ned.a(this.jdField_a_of_type_Ncq.a(), paramnaf));
  }
  
  private void h(naf paramnaf)
  {
    boolean bool = f(paramnaf);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateStageUIForRealStart isPlayerSelf = " + bool);
    }
    this.jdField_a_of_type_Nei.c();
    this.jdField_a_of_type_Ned.b(paramnaf);
    a(this.jdField_a_of_type_Ned.a(this.jdField_a_of_type_Ncq.a(), bool));
    if ((this.jdField_a_of_type_Ned.a()) && (!bool))
    {
      long l = Long.parseLong(paramnaf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      paramnaf = this.jdField_a_of_type_Ncq.a().a(l);
      this.jdField_a_of_type_Ncq.a().a(paramnaf);
    }
  }
  
  private void i(naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleSwitchTopic ,topic = " + paramnaf.a().b() + " buff = " + paramnaf.a().a()[0] + paramnaf.a().a()[1] + paramnaf.a().a()[2]);
    }
    this.jdField_a_of_type_Nei.c();
    this.jdField_a_of_type_Ned.c(paramnaf);
    if (paramnaf.d(mzl.a().a().getAccount())) {
      this.jdField_a_of_type_Ncq.a().b(this.jdField_a_of_type_Nei.a());
    }
    if (Build.VERSION.SDK_INT >= 16) {
      mxh.a().a(paramnaf.a().a());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Nei.a();
  }
  
  public Drawable a()
  {
    nak localnak = mzl.a().a().a();
    if ((localnak == null) || (TextUtils.isEmpty(localnak.h))) {
      return nav.a("avgame_questions_bg_110_height@2x.png");
    }
    return URLDrawable.getDrawable(localnak.h);
  }
  
  public ncq a()
  {
    return this.jdField_a_of_type_Ncq;
  }
  
  public void a()
  {
    mzl.a().b();
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nei.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ncq.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = mzl.a().a().getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "showTopicSwitchedTip switcherUin = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str)))
    {
      if (paramInt != 1) {
        break label75;
      }
      this.jdField_a_of_type_Nei.b("avgame_tips_switch_topic@2x.png");
    }
    label75:
    while (paramInt != 2) {
      return;
    }
    this.jdField_a_of_type_Nei.b("avgame_tips_host_switch_topic@2x.png");
  }
  
  public void a(String paramString, naf paramnaf)
  {
    paramString = mzl.a().a().getAccount();
    boolean bool = paramString.equals(paramnaf.a().c.uin);
    if ((this.jdField_a_of_type_Ned.a()) && (bool))
    {
      long l = Long.parseLong(paramString);
      paramString = this.jdField_a_of_type_Ncq.a().a(l);
      this.jdField_a_of_type_Ncq.a().b(paramString);
    }
  }
  
  public void a(naf paramnaf)
  {
    this.jdField_a_of_type_Nei.a(paramnaf);
    this.jdField_a_of_type_Nei.b(paramnaf);
    e(paramnaf);
    int i = paramnaf.c();
    int j = paramnaf.a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "refresh gameType = " + i + ",gameStatus = " + j);
    }
    if (this.jdField_a_of_type_Ned == null)
    {
      QLog.d("StagePresenterImp", 1, "refresh return for null presenter,gameType = " + i + ",gameStatus = " + j);
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_Naf = paramnaf.a();
      return;
    }
    a(true);
    switch (j)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Naf = paramnaf.a();
      return;
      if (!e(paramnaf))
      {
        f(paramnaf);
        continue;
        if (c(paramnaf))
        {
          if ((d(paramnaf)) && ((this.jdField_a_of_type_Ned instanceof nes))) {
            this.jdField_a_of_type_Ned.a(mzl.a().a(), true);
          }
        }
        else
        {
          i(paramnaf);
          continue;
          if (!b(paramnaf))
          {
            a(paramnaf, paramnaf.a().jdField_a_of_type_Int, paramnaf.a().b);
            continue;
            if (!a(paramnaf))
            {
              d(paramnaf);
              continue;
              if (!a()) {
                c(paramnaf);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(naf paramnaf, int paramInt1, int paramInt2)
  {
    if (!paramnaf.a()) {
      return;
    }
    int i = paramnaf.a().a(paramnaf.a().d.uin);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleAnswerRight scoreThisTime = " + paramInt1 + ", actorScoreThisTime = " + paramInt2 + ", combo = " + paramnaf.a().jdField_a_of_type_Long);
    }
    String str2 = paramnaf.a().a();
    Object localObject = (mxz)mzl.a().a().a(2);
    Bitmap localBitmap = ((mxz)localObject).a(String.valueOf(paramnaf.a().d.uin), (byte)1);
    String str3 = paramnaf.a().getNick(paramnaf.a().d.uin);
    long l = paramnaf.a().jdField_a_of_type_Long;
    if ((paramnaf.c() == 1) && (paramnaf.b() != null)) {}
    for (localObject = ((mxz)localObject).a(paramnaf.b().uin, (byte)1);; localObject = null)
    {
      boolean bool = mzl.a().a().getAccount().equals(paramnaf.a().d.uin);
      if (!bool) {
        bcef.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", paramnaf.d(), 0, "", "", "", "");
      }
      int j = paramnaf.d();
      if (bool) {}
      for (String str1 = "1";; str1 = "2")
      {
        bcef.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", j, 0, str1, "", String.valueOf(l), "");
        this.jdField_a_of_type_Ncq.a().a(str2, localBitmap, str3, paramInt1, i, l, (Bitmap)localObject, paramInt2, bool);
        nau.a().a(paramnaf.a(), "succeed");
        localObject = this.jdField_a_of_type_Ncq.a().a();
        this.jdField_a_of_type_Ncq.a().a((View)localObject, this.jdField_a_of_type_Ncq.a().a(), true);
        if (paramnaf.c() == 2) {
          this.jdField_a_of_type_Nei.b();
        }
        this.jdField_a_of_type_Ned.d(paramnaf);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramnaf.a().jdField_a_of_type_Naj.f * 1000);
        return;
      }
    }
  }
  
  public void a(ncq paramncq)
  {
    this.jdField_a_of_type_Ncq = paramncq;
  }
  
  public void a(ned paramned)
  {
    this.jdField_b_of_type_Ned = paramned;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onShowGameContent " + paramBoolean + ",curGameStagePresenter = " + this.jdField_a_of_type_Ned);
    }
    if (this.jdField_a_of_type_Ned != null) {
      this.jdField_a_of_type_Ned.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nei.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public Drawable b()
  {
    nak localnak = mzl.a().a().a();
    if ((localnak == null) || (TextUtils.isEmpty(localnak.i))) {
      return nav.a("avgame_questions_bg_130_height@2x.png");
    }
    return URLDrawable.getDrawable(localnak.i);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    if (this.jdField_a_of_type_Ned != null) {
      this.jdField_a_of_type_Ned.a(null);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nei.a(paramString);
  }
  
  public void b(String paramString, naf paramnaf)
  {
    if (paramnaf.c())
    {
      if (!f(paramnaf)) {
        break label74;
      }
      a(this.jdField_a_of_type_Ncq.a().getResources().getString(2131690240));
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", paramnaf.d(), 0, "", "", "", "");
      return;
      label74:
      paramString = paramnaf.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
      a(String.format(this.jdField_a_of_type_Ncq.a().getResources().getString(2131690241), new Object[] { ContactUtils.getFitString(paramString, 8.0F) }));
    }
  }
  
  public void b(naf paramnaf)
  {
    this.jdField_a_of_type_Nei.b(paramnaf);
  }
  
  public void b(ned paramned)
  {
    this.c = paramned;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c(naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.jdField_a_of_type_Ncq.a().a();
    d();
    nau.a().a(paramnaf.a(), "over");
    if (paramnaf.d(mzl.a().a().getAccount())) {
      this.jdField_a_of_type_Ncq.a().b();
    }
    this.jdField_a_of_type_Ncq.a().e();
    this.jdField_a_of_type_Ned.f(paramnaf);
  }
  
  public void c(ned paramned)
  {
    this.d = paramned;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nei.a();
  }
  
  public void d(naf paramnaf)
  {
    Object localObject = paramnaf.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onAnswerTimeoutPush answer = " + (String)localObject);
    }
    bcef.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", paramnaf.d(), 0, "", "", "", "");
    this.jdField_a_of_type_Ncq.a().a((String)localObject);
    nau.a().a(paramnaf.a(), "failed");
    localObject = this.jdField_a_of_type_Ncq.a().a();
    this.jdField_a_of_type_Ncq.a().a((View)localObject, this.jdField_a_of_type_Ncq.a().a(), false);
    if (paramnaf.c() == 2) {
      this.jdField_a_of_type_Nei.b();
    }
    this.jdField_a_of_type_Ned.e(paramnaf);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramnaf.a().jdField_a_of_type_Naj.f * 1000);
  }
  
  public void d(ned paramned)
  {
    this.f = paramned;
  }
  
  public void e(ned paramned)
  {
    this.e = paramned;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nej
 * JD-Core Version:    0.7.0.1
 */