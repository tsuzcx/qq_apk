import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gameresult.GamePKResultFragment;
import com.tencent.qphone.base.util.QLog;

public class nhk
  implements nhs
{
  private ndr a;
  protected nht a;
  protected nrn a;
  
  public nhk(nht paramnht)
  {
    this.jdField_a_of_type_Ndr = new nhl(this);
    this.jdField_a_of_type_Nrn = new nhm(this);
    this.jdField_a_of_type_Nht = paramnht;
  }
  
  private void g()
  {
    nfv localnfv = nfc.a().a();
    nfc.a().a(localnfv.b());
  }
  
  public void a()
  {
    SurvivalPkResultInfo localSurvivalPkResultInfo = nfc.a().a().a();
    nfc.a().a().addObserver(this.jdField_a_of_type_Ndr, false);
    if ((this.jdField_a_of_type_Nht instanceof GamePKResultFragment)) {
      ((GamePKResultFragment)this.jdField_a_of_type_Nht).a(localSurvivalPkResultInfo);
    }
    nfc.a().a(this.jdField_a_of_type_Nrn);
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public boolean a()
  {
    return nfc.a().d();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Nht != null) {
      ndx.a().a(this.jdField_a_of_type_Nht.a(), false, true);
    }
  }
  
  public void c()
  {
    g();
    QLog.i("GameResultPKPresenterImp", 1, "exitGameRoom from result.");
    nfc.a().a(false, 1);
    if (this.jdField_a_of_type_Nht.a() != null) {
      this.jdField_a_of_type_Nht.a().finish();
    }
  }
  
  public void d()
  {
    nfc.a().c();
    AVGameAppInterface localAVGameAppInterface = nfc.a().a();
    String str = localAVGameAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Nht.a(localAVGameAppInterface, 0L, str, 0, null, null);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 1, "playAgain");
    }
    nfc.a().a().c();
    nfc.a().k();
  }
  
  public void f()
  {
    nfc.a().a().removeObserver(this.jdField_a_of_type_Ndr);
    nfc.a().b(this.jdField_a_of_type_Nrn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhk
 * JD-Core Version:    0.7.0.1
 */