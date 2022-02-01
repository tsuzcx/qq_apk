package cooperation.ilive.lite;

import NS_KING_PUBLIC.stAuth;
import cooperation.ilive.manager.IliveAuthManager.Callback;
import cooperation.ilive.util.ElapseStat;

class IliveLiteHelper$3
  implements IliveAuthManager.Callback
{
  IliveLiteHelper$3(IliveLiteHelper paramIliveLiteHelper) {}
  
  public void onGetAuthInfo(boolean paramBoolean, stAuth paramstAuth)
  {
    ElapseStat.b("Ilive auth");
    IliveLiteHelper.a(this.a, paramBoolean, paramstAuth);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper.3
 * JD-Core Version:    0.7.0.1
 */