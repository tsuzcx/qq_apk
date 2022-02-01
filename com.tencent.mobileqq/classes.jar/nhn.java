import android.app.Activity;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nhn
  implements ngw, nhs
{
  protected nht a;
  
  public nhn(nht paramnht)
  {
    this.a = paramnht;
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
    nfv localnfv = nfc.a().a();
    nfc.a().a(localnfv.b());
  }
  
  public void a()
  {
    nfc.a().a(this);
    GameRecordInfo localGameRecordInfo = nfc.a().a().a();
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
    nfc.a().a(str1, str2);
    this.a.a(localGameRecordInfo.gameType, str1, str2);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPresenterImp", 1, "uploadRes:" + paramInt + " " + paramString1 + " " + paramString2);
    }
    this.a.a(paramInt, paramString2, paramString1);
    nfc.a().a(paramString2, paramString1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusFailed " + paramString + " and from = " + paramInt2);
    if (paramInt2 == 4) {
      this.a.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameResultPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(nfc.a().a().getAccount())) && (paramInt == 1)) {
      this.a.b(paramnfv);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(nfv paramnfv, int paramInt)
  {
    QLog.i("GameResultPresenterImp", 1, "onChangeUserStatusSuccess " + paramnfv + " and from = " + paramInt);
    if (paramInt == 4) {
      this.a.b(paramnfv);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("GameResultPresenterImp_GameRC", 1, String.format("onGameResultUpload isSucc[%b],playId[%s],fileType[%d],fileUrl[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    if ((paramBoolean) && (paramInt == 0)) {
      aojq.a().a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    return nfc.a().d();
  }
  
  public void b()
  {
    if (this.a != null) {
      ndx.a().a(this.a.a(), false, true);
    }
  }
  
  public void c()
  {
    g();
    QLog.i("GameResultPresenterImp", 1, "exitGameRoom from result.");
    nfc.a().a(false, 1);
    if (this.a.a() != null) {
      this.a.a().finish();
    }
  }
  
  public void d()
  {
    nfc.a().c();
    AVGameAppInterface localAVGameAppInterface = nfc.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    nfv localnfv = nfc.a().a();
    long l = localnfv.a();
    String str2 = localnfv.a().getNick(str1);
    String str3 = localnfv.b();
    int i = localnfv.c();
    int j = localnfv.d();
    if ((i == 2) || (i == 4) || (i == 5))
    {
      this.a.a(localAVGameAppInterface, l, str1, j, str2, str3);
      return;
    }
    aojq.a().a(localAVGameAppInterface, this.a.a(), l, Long.valueOf(str1).longValue(), str2, str3, j);
  }
  
  public void e()
  {
    nfv localnfv = nfc.a().a();
    nfc.a().a(localnfv.a(), nfc.a().a().getAccount(), 1, 4);
    g();
    nfc.a().a().a(null, null, 0L);
    nfc.a().a().a(null);
    AVGameNodeReportUtil.f();
  }
  
  public void f()
  {
    nfc.a().b(this);
  }
  
  public void i(nfv paramnfv)
  {
    if (this.a != null) {
      this.a.a(paramnfv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhn
 * JD-Core Version:    0.7.0.1
 */