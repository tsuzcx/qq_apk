import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nbq
  implements nbg, nbv
{
  protected nbw a;
  
  public nbq(nbw paramnbw)
  {
    this.a = paramnbw;
  }
  
  private void a(GameRecordInfo paramGameRecordInfo)
  {
    Object localObject1 = null;
    if (paramGameRecordInfo.extraJsonData != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramGameRecordInfo.extraJsonData);
        paramGameRecordInfo = ((JSONObject)localObject2).optString("textContent", null);
      }
      catch (JSONException paramGameRecordInfo)
      {
        Object localObject2;
        paramGameRecordInfo = null;
        continue;
      }
      try
      {
        localObject2 = ((JSONObject)localObject2).optString("bgUrl", null);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      this.a.a(paramGameRecordInfo, localObject1);
      return;
      paramGameRecordInfo = null;
    }
  }
  
  private void g()
  {
    naf localnaf = mzl.a().a();
    mzl.a().a(localnaf.b());
  }
  
  public void a()
  {
    mzl.a().a(this);
    GameRecordInfo localGameRecordInfo = mzl.a().a().a();
    if (localGameRecordInfo.gameType == 5)
    {
      a(localGameRecordInfo);
      return;
    }
    String str1 = localGameRecordInfo.photoFilePath;
    String str2 = localGameRecordInfo.videoFilePath;
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, "pic:" + str1 + ",\nvod:" + str2);
    }
    mzl.a().a(str1, str2);
    this.a.a(localGameRecordInfo.gameType, str1, str2);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp", 1, "uploadRes:" + paramInt + " " + paramString1 + " " + paramString2);
    }
    this.a.a(paramInt, paramString2, paramString1);
    mzl.a().a(paramString2, paramString1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusFailed " + paramString + " and from = " + paramInt2);
    if (paramInt2 == 4) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameResultPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(mzl.a().a().getAccount())) && (paramInt == 1)) {
      this.a.b(paramnaf);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(naf paramnaf, int paramInt)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusSuccess " + paramnaf + " and from = " + paramInt);
    if (paramInt == 4) {
      this.a.b(paramnaf);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, String.format("onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    if ((paramBoolean) && (paramInt == 0)) {
      anha.a().a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    return mzl.a().d();
  }
  
  public void b()
  {
    if (this.a != null) {
      myl.a().a(this.a.a(), false, true);
    }
  }
  
  public void c()
  {
    g();
    QLog.i("GameResultPresenterImp", 1, "exitGameRoom from result.");
    mzl.a().a(false, 1);
    if (this.a.a() != null) {
      this.a.a().finish();
    }
  }
  
  public void d()
  {
    mzl.a().c();
    AVGameAppInterface localAVGameAppInterface = mzl.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    naf localnaf = mzl.a().a();
    long l = localnaf.a();
    String str2 = localnaf.a().getNick(str1);
    String str3 = localnaf.b();
    int i = localnaf.c();
    int j = localnaf.d();
    if ((i == 2) || (i == 4) || (i == 5))
    {
      this.a.a(localAVGameAppInterface, l, str1, j, str2, str3);
      return;
    }
    anha.a().a(localAVGameAppInterface, this.a.a(), l, Long.valueOf(str1).longValue(), str2, str3, j);
  }
  
  public void e()
  {
    naf localnaf = mzl.a().a();
    mzl.a().a(localnaf.a(), mzl.a().a().getAccount(), 1, 4);
    g();
    mzl.a().a().a(null, null, 0L);
    mzl.a().a().a(null);
    AVGameNodeReportUtil.f();
  }
  
  public void f()
  {
    mzl.a().b(this);
  }
  
  public void i(naf paramnaf)
  {
    if (this.a != null) {
      this.a.a(paramnaf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nbq
 * JD-Core Version:    0.7.0.1
 */