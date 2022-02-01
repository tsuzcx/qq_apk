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

public class nlb
  implements nky
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Runnable jdField_a_of_type_JavaLangRunnable = new StagePresenterImp.1(this);
  protected nfv a;
  public nio a;
  protected nkv a;
  public nla a;
  Runnable b;
  protected nkv b;
  protected nkv c;
  protected nkv d;
  protected nkv e;
  protected nkv f;
  
  public nlb(nla paramnla)
  {
    this.jdField_b_of_type_JavaLangRunnable = new StagePresenterImp.2(this);
    this.jdField_a_of_type_Nla = paramnla;
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a() == 10);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 0) && (paramInt2 != 0);
  }
  
  private boolean a(nfv paramnfv)
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a() == 4) && (this.jdField_a_of_type_Nfv.a().a(paramnfv.a()));
  }
  
  private boolean b(nfv paramnfv)
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a() == 3) && (this.jdField_a_of_type_Nfv.a().a(paramnfv.a()));
  }
  
  private boolean c(nfv paramnfv)
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a() == 2) && (this.jdField_a_of_type_Nfv.a().a(paramnfv.a()));
  }
  
  private boolean d(nfv paramnfv)
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a().owner != paramnfv.a().owner) && (nfc.a().a());
  }
  
  private void e(nfv paramnfv)
  {
    if (paramnfv.c() == 1) {
      this.jdField_a_of_type_Nkv = this.jdField_b_of_type_Nkv;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StagePresenterImp", 2, "updateCurGameStagePresenter curGameStagePresenter = " + this.jdField_a_of_type_Nkv);
      }
      return;
      if (paramnfv.c() == 2) {
        this.jdField_a_of_type_Nkv = this.d;
      } else if (paramnfv.c() == 3) {
        this.jdField_a_of_type_Nkv = this.c;
      } else if (paramnfv.c() == 4) {
        this.jdField_a_of_type_Nkv = this.f;
      } else if (paramnfv.c() == 5) {
        this.jdField_a_of_type_Nkv = this.e;
      }
    }
  }
  
  private boolean e(nfv paramnfv)
  {
    return (this.jdField_a_of_type_Nfv != null) && (this.jdField_a_of_type_Nfv.a() == 1) && (this.jdField_a_of_type_Nfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin.equals(paramnfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin));
  }
  
  private void f(nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart buff = " + paramnfv.a().a()[0] + paramnfv.a().a()[1] + paramnfv.a().a()[2]);
    }
    b();
    g(paramnfv);
    if ((this.jdField_a_of_type_Nkv.a()) && (f(paramnfv)))
    {
      l = Long.parseLong(nfc.a().a().getAccount());
      RectF localRectF = this.jdField_a_of_type_Nio.a().a(l);
      this.jdField_a_of_type_Nio.a().b(localRectF);
    }
    long l = paramnfv.a().jdField_a_of_type_Nfz.d * 1000 - paramnfv.a().d();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameStart delayMs = " + l);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l);
  }
  
  private boolean f(nfv paramnfv)
  {
    return nfc.a().a().getAccount().equals(paramnfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
  }
  
  private void g(nfv paramnfv)
  {
    this.jdField_a_of_type_Nio.a().a();
    boolean bool = f(paramnfv);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateUIForGamePrepare isPlayerSelf = " + bool);
    }
    a(this.jdField_a_of_type_Nkv.a(bool), paramnfv.a().jdField_a_of_type_Nfz.d * 1000, paramnfv.a().d());
    this.jdField_a_of_type_Nkv.a(paramnfv);
    b(this.jdField_a_of_type_Nkv.a(this.jdField_a_of_type_Nio.a(), paramnfv));
  }
  
  private void h(nfv paramnfv)
  {
    boolean bool = f(paramnfv);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "updateStageUIForRealStart isPlayerSelf = " + bool);
    }
    this.jdField_a_of_type_Nla.c();
    this.jdField_a_of_type_Nkv.b(paramnfv);
    a(this.jdField_a_of_type_Nkv.a(this.jdField_a_of_type_Nio.a(), bool));
    if ((this.jdField_a_of_type_Nkv.a()) && (!bool))
    {
      long l = Long.parseLong(paramnfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      paramnfv = this.jdField_a_of_type_Nio.a().a(l);
      this.jdField_a_of_type_Nio.a().a(paramnfv);
    }
  }
  
  private void i(nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleSwitchTopic ,topic = " + paramnfv.a().b() + " buff = " + paramnfv.a().a()[0] + paramnfv.a().a()[1] + paramnfv.a().a()[2]);
    }
    this.jdField_a_of_type_Nla.c();
    this.jdField_a_of_type_Nkv.c(paramnfv);
    if (paramnfv.d(nfc.a().a().getAccount())) {
      this.jdField_a_of_type_Nio.a().b(this.jdField_a_of_type_Nla.a());
    }
    if (Build.VERSION.SDK_INT >= 16) {
      lfm.a().a(paramnfv.a().a());
    }
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Nla.a();
  }
  
  public Drawable a()
  {
    nga localnga = nfc.a().a().a();
    if ((localnga == null) || (TextUtils.isEmpty(localnga.h))) {
      return ngl.a("avgame_questions_bg_110_height@2x.png");
    }
    return URLDrawable.getDrawable(localnga.h);
  }
  
  public nio a()
  {
    return this.jdField_a_of_type_Nio;
  }
  
  public void a()
  {
    nfc.a().b();
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nla.a(paramImageView, paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Nio.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = nfc.a().a().getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "showTopicSwitchedTip switcherUin = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(str)))
    {
      if (paramInt != 1) {
        break label75;
      }
      this.jdField_a_of_type_Nla.b("avgame_tips_switch_topic@2x.png");
    }
    label75:
    while (paramInt != 2) {
      return;
    }
    this.jdField_a_of_type_Nla.b("avgame_tips_host_switch_topic@2x.png");
  }
  
  public void a(String paramString, nfv paramnfv)
  {
    paramString = nfc.a().a().getAccount();
    boolean bool = paramString.equals(paramnfv.a().c.uin);
    if ((this.jdField_a_of_type_Nkv.a()) && (bool))
    {
      long l = Long.parseLong(paramString);
      paramString = this.jdField_a_of_type_Nio.a().a(l);
      this.jdField_a_of_type_Nio.a().b(paramString);
    }
  }
  
  public void a(nfv paramnfv)
  {
    this.jdField_a_of_type_Nla.a(paramnfv);
    this.jdField_a_of_type_Nla.b(paramnfv);
    e(paramnfv);
    int i = paramnfv.c();
    int j = paramnfv.a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "refresh gameType = " + i + ",gameStatus = " + j);
    }
    if (this.jdField_a_of_type_Nkv == null)
    {
      QLog.d("StagePresenterImp", 1, "refresh return for null presenter,gameType = " + i + ",gameStatus = " + j);
      return;
    }
    if (!a(i, j))
    {
      a(false);
      this.jdField_a_of_type_Nfv = paramnfv.a();
      return;
    }
    a(true);
    switch (j)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Nfv = paramnfv.a();
      return;
      if (!e(paramnfv))
      {
        f(paramnfv);
        continue;
        if (c(paramnfv))
        {
          if ((d(paramnfv)) && ((this.jdField_a_of_type_Nkv instanceof nlk))) {
            this.jdField_a_of_type_Nkv.a(nfc.a().a(), true);
          }
        }
        else
        {
          i(paramnfv);
          continue;
          if (!b(paramnfv))
          {
            a(paramnfv, paramnfv.a().jdField_a_of_type_Int, paramnfv.a().b);
            continue;
            if (!a(paramnfv))
            {
              d(paramnfv);
              continue;
              if (!a()) {
                c(paramnfv);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(nfv paramnfv, int paramInt1, int paramInt2)
  {
    if (!paramnfv.a()) {
      return;
    }
    int i = paramnfv.a().a(paramnfv.a().d.uin);
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleAnswerRight scoreThisTime = " + paramInt1 + ", actorScoreThisTime = " + paramInt2 + ", combo = " + paramnfv.a().jdField_a_of_type_Long);
    }
    String str2 = paramnfv.a().a();
    Object localObject = (ndl)nfc.a().a().a(2);
    Bitmap localBitmap = ((ndl)localObject).a(String.valueOf(paramnfv.a().d.uin), (byte)1);
    String str3 = paramnfv.a().getNick(paramnfv.a().d.uin);
    long l = paramnfv.a().jdField_a_of_type_Long;
    if ((paramnfv.c() == 1) && (paramnfv.b() != null)) {}
    for (localObject = ((ndl)localObject).a(paramnfv.b().uin, (byte)1);; localObject = null)
    {
      boolean bool = nfc.a().a().getAccount().equals(paramnfv.a().d.uin);
      if (!bool) {
        bdla.b(null, "dc00898", "", "", "0X800B04C", "0X800B04C", paramnfv.d(), 0, "", "", "", "");
      }
      int j = paramnfv.d();
      if (bool) {}
      for (String str1 = "1";; str1 = "2")
      {
        bdla.b(null, "dc00898", "", "", "0X800B04E", "0X800B04E", j, 0, str1, "", String.valueOf(l), "");
        this.jdField_a_of_type_Nio.a().a(str2, localBitmap, str3, paramInt1, i, l, (Bitmap)localObject, paramInt2, bool);
        ngk.a().a(paramnfv.a(), "succeed");
        localObject = this.jdField_a_of_type_Nio.a().a();
        this.jdField_a_of_type_Nio.a().a((View)localObject, this.jdField_a_of_type_Nio.a().a(), true);
        if (paramnfv.c() == 2) {
          this.jdField_a_of_type_Nla.b();
        }
        this.jdField_a_of_type_Nkv.d(paramnfv);
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramnfv.a().jdField_a_of_type_Nfz.f * 1000);
        return;
      }
    }
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nio = paramnio;
  }
  
  public void a(nkv paramnkv)
  {
    this.jdField_b_of_type_Nkv = paramnkv;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onShowGameContent " + paramBoolean + ",curGameStagePresenter = " + this.jdField_a_of_type_Nkv);
    }
    if (this.jdField_a_of_type_Nkv != null) {
      this.jdField_a_of_type_Nkv.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nla.a(paramBoolean, paramLong1, paramLong2);
  }
  
  public Drawable b()
  {
    nga localnga = nfc.a().a().a();
    if ((localnga == null) || (TextUtils.isEmpty(localnga.i))) {
      return ngl.a("avgame_questions_bg_130_height@2x.png");
    }
    return URLDrawable.getDrawable(localnga.i);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "resetGameContent ");
    }
    if (this.jdField_a_of_type_Nkv != null) {
      this.jdField_a_of_type_Nkv.a(null);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nla.a(paramString);
  }
  
  public void b(String paramString, nfv paramnfv)
  {
    if (paramnfv.c())
    {
      if (!f(paramnfv)) {
        break label74;
      }
      a(this.jdField_a_of_type_Nio.a().getResources().getString(2131690278));
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B04B", "0X800B04B", paramnfv.d(), 0, "", "", "", "");
      return;
      label74:
      paramString = paramnfv.a().jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.nick;
      a(String.format(this.jdField_a_of_type_Nio.a().getResources().getString(2131690279), new Object[] { ContactUtils.getFitString(paramString, 8.0F) }));
    }
  }
  
  public void b(nfv paramnfv)
  {
    this.jdField_a_of_type_Nla.b(paramnfv);
  }
  
  public void b(nkv paramnkv)
  {
    this.c = paramnkv;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StagePresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c(nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "handleGameOver");
    }
    this.jdField_a_of_type_Nio.a().a();
    d();
    ngk.a().a(paramnfv.a(), "over");
    if (paramnfv.d(nfc.a().a().getAccount())) {
      this.jdField_a_of_type_Nio.a().b();
    }
    this.jdField_a_of_type_Nio.a().e();
    this.jdField_a_of_type_Nkv.f(paramnfv);
  }
  
  public void c(nkv paramnkv)
  {
    this.d = paramnkv;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nla.a();
  }
  
  public void d(nfv paramnfv)
  {
    Object localObject = paramnfv.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("StagePresenterImp", 2, "onAnswerTimeoutPush answer = " + (String)localObject);
    }
    bdla.b(null, "dc00898", "", "", "0X800B04F", "0X800B04F", paramnfv.d(), 0, "", "", "", "");
    this.jdField_a_of_type_Nio.a().a((String)localObject);
    ngk.a().a(paramnfv.a(), "failed");
    localObject = this.jdField_a_of_type_Nio.a().a();
    this.jdField_a_of_type_Nio.a().a((View)localObject, this.jdField_a_of_type_Nio.a().a(), false);
    if (paramnfv.c() == 2) {
      this.jdField_a_of_type_Nla.b();
    }
    this.jdField_a_of_type_Nkv.e(paramnfv);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramnfv.a().jdField_a_of_type_Nfz.f * 1000);
  }
  
  public void d(nkv paramnkv)
  {
    this.f = paramnkv;
  }
  
  public void e(nkv paramnkv)
  {
    this.e = paramnkv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlb
 * JD-Core Version:    0.7.0.1
 */