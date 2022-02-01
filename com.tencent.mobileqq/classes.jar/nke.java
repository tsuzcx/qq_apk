import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.seat.SeatPresenterImp.1;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

public class nke
  implements nju
{
  private Runnable a;
  protected nio a;
  protected njv a;
  
  public nke(njv paramnjv)
  {
    this.jdField_a_of_type_JavaLangRunnable = new SeatPresenterImp.1(this);
    this.jdField_a_of_type_Njv = paramnjv;
  }
  
  public int a(String paramString)
  {
    return nfc.a().a().a(paramString);
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Njv.a();
  }
  
  public RectF a(long paramLong)
  {
    return this.jdField_a_of_type_Njv.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.jdField_a_of_type_Nio.a(paramString);
  }
  
  public List<nkd> a()
  {
    int i4 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Nio.c();
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    int k = 0;
    int j = i4;
    int m;
    if (i1 < localList.size())
    {
      nkd localnkd = new nkd();
      localnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localList.get(i1));
      localArrayList.add(localnkd);
      m = a(localnkd.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      int i3;
      int n;
      if (m > k)
      {
        i3 = m;
        n = k;
        j = i;
      }
      for (;;)
      {
        i1 += 1;
        i2 = j;
        i = n;
        k = i3;
        break;
        if (m > i)
        {
          j = i;
          n = m;
          i3 = k;
        }
        else
        {
          j = i2;
          n = i;
          i3 = k;
          if (m > i2)
          {
            j = m;
            n = i;
            i3 = k;
          }
        }
      }
    }
    if (j < localArrayList.size())
    {
      m = a(((nkd)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m <= 0) {}
      for (;;)
      {
        j += 1;
        break;
        if (m == k) {
          ((nkd)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((nkd)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((nkd)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nio.a();
    AVGameAppInterface localAVGameAppInterface = nfc.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    nfv localnfv = nfc.a().a();
    long l = localnfv.a();
    String str2 = localnfv.a().getNick(str1);
    aojq.a().a(localAVGameAppInterface, localBaseActivity, l, Long.valueOf(str1).longValue(), str2, localnfv.d());
    this.jdField_a_of_type_Nio.a().b(this.jdField_a_of_type_Nio.a().getString(2131690346));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Njv.a(paramLong, paramBoolean);
  }
  
  public void a(Player paramPlayer)
  {
    if ((nfc.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    nfv localnfv = nfc.a().a();
    String str = nfc.a().a().getCurrentAccountUin();
    nfc.a().c(localnfv.a(), str, paramPlayer.uin);
    bdla.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer.uin, "" + localnfv.a(), "", "");
  }
  
  public void a(nfv paramnfv)
  {
    this.jdField_a_of_type_Njv.a(paramnfv);
  }
  
  public void a(nio paramnio)
  {
    this.jdField_a_of_type_Nio = paramnio;
    nom.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Njv.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    nfv localnfv = nfc.a().a();
    RoomInfo localRoomInfo = localnfv.a();
    int i = localnfv.a();
    return (localRoomInfo.getPlayers().size() < 8) && (i == 0);
  }
  
  public List<niq> b()
  {
    return this.jdField_a_of_type_Njv.a();
  }
  
  public void b()
  {
    nom.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(Player paramPlayer)
  {
    int i = 1;
    if ((nfc.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramPlayer = paramPlayer.uin;
        Object localObject = new ProfileActivity.AllInOne(paramPlayer, 118);
        ((ProfileActivity.AllInOne)localObject).h = 999;
        ((ProfileActivity.AllInOne)localObject).d = 1;
        ProfileActivity.b(this.jdField_a_of_type_Nio.a(), (ProfileActivity.AllInOne)localObject);
        localObject = ndl.b(paramPlayer);
        if ((localObject != null) && (((UserInfo)localObject).a))
        {
          bdla.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, "" + nfc.a().a().a(), "", "");
          return;
        }
      }
      catch (Exception paramPlayer)
      {
        paramPlayer.printStackTrace();
        return;
      }
      i = 2;
    }
  }
  
  public void c(Player paramPlayer)
  {
    if ((nfc.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nio.a();
    String str1 = nfc.a().a().getCurrentAccountUin();
    nfv localnfv = nfc.a().a();
    String str2 = "roomid=" + localnfv.a();
    aaqo.a(localBaseActivity, paramPlayer.uin, "", str2, str1, 25031, null);
    bdla.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer.uin, "" + localnfv.a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nke
 * JD-Core Version:    0.7.0.1
 */