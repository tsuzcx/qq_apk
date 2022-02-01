import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nap
  implements naf, nau
{
  protected nav a;
  
  public nap(nav paramnav)
  {
    this.a = paramnav;
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
    mze localmze = myk.a().a();
    myk.a().a(localmze.b());
  }
  
  public void a()
  {
    myk.a().a(this);
    GameRecordInfo localGameRecordInfo = myk.a().a().a();
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
    myk.a().a(str1, str2);
    this.a.a(localGameRecordInfo.gameType, str1, str2);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp", 1, "uploadRes:" + paramInt + " " + paramString1 + " " + paramString2);
    }
    this.a.a(paramInt, paramString2, paramString1);
    myk.a().a(paramString2, paramString1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusFailed " + paramString + " and from = " + paramInt2);
    if (paramInt2 == 4) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameResultPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(myk.a().a().getAccount())) && (paramInt == 1)) {
      this.a.b(parammze);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(mze parammze, int paramInt)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusSuccess " + parammze + " and from = " + paramInt);
    if (paramInt == 4) {
      this.a.b(parammze);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, String.format("onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    if ((paramBoolean) && (paramInt == 0)) {
      aono.a().a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    return myk.a().c();
  }
  
  public void b()
  {
    if (this.a != null) {
      mya.a().a(this.a.a(), false, true);
    }
  }
  
  public void c()
  {
    g();
    QLog.i("GameResultPresenterImp", 1, "exitGameRoom from result.");
    myk.a().a(false, 1);
    if (this.a.a() != null) {
      this.a.a().finish();
    }
  }
  
  public void d()
  {
    myk.a().c();
    AVGameAppInterface localAVGameAppInterface = myk.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    mze localmze = myk.a().a();
    long l = localmze.a();
    String str2 = localmze.a().getNick(str1);
    String str3 = localmze.b();
    int i = localmze.c();
    int j = localmze.d();
    if ((i == 2) || (i == 4) || (i == 5))
    {
      this.a.a(localAVGameAppInterface, l, str1, j, str2, str3);
      return;
    }
    aono.a().a(localAVGameAppInterface, this.a.a(), l, Long.valueOf(str1).longValue(), str2, str3, j);
  }
  
  public void e()
  {
    mze localmze = myk.a().a();
    myk.a().a(localmze.a(), myk.a().a().getAccount(), 1, 4);
    g();
    myk.a().a().a(null, null, 0L);
    myk.a().a().a(null);
    AVGameNodeReportUtil.f();
  }
  
  public void f()
  {
    myk.a().b(this);
  }
  
  public void i(mze parammze)
  {
    if (this.a != null) {
      this.a.a(parammze);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nap
 * JD-Core Version:    0.7.0.1
 */