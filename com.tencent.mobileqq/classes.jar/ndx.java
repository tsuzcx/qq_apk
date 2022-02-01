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

public class ndx
  implements ndt
{
  private Runnable a;
  protected ncq a;
  protected ndu a;
  
  public ndx(ndu paramndu)
  {
    this.jdField_a_of_type_JavaLangRunnable = new SeatPresenterImp.1(this);
    this.jdField_a_of_type_Ndu = paramndu;
  }
  
  public int a(String paramString)
  {
    return mzl.a().a().a(paramString);
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Ndu.a();
  }
  
  public RectF a(long paramLong)
  {
    return this.jdField_a_of_type_Ndu.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.jdField_a_of_type_Ncq.a(paramString);
  }
  
  public List<ndw> a()
  {
    int i4 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Ncq.c();
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    int k = 0;
    int j = i4;
    int m;
    if (i1 < localList.size())
    {
      ndw localndw = new ndw();
      localndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localList.get(i1));
      localArrayList.add(localndw);
      m = a(localndw.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
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
      m = a(((ndw)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m <= 0) {}
      for (;;)
      {
        j += 1;
        break;
        if (m == k) {
          ((ndw)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((ndw)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((ndw)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Ncq.a();
    AVGameAppInterface localAVGameAppInterface = mzl.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    naf localnaf = mzl.a().a();
    long l = localnaf.a();
    String str2 = localnaf.a().getNick(str1);
    anha.a().a(localAVGameAppInterface, localBaseActivity, l, Long.valueOf(str1).longValue(), str2, localnaf.d());
    this.jdField_a_of_type_Ncq.a().b(this.jdField_a_of_type_Ncq.a().getString(2131690307));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ndu.a(paramLong, paramBoolean);
  }
  
  public void a(Player paramPlayer)
  {
    if ((mzl.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    naf localnaf = mzl.a().a();
    String str = mzl.a().a().getCurrentAccountUin();
    mzl.a().c(localnaf.a(), str, paramPlayer.uin);
    bcef.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer.uin, "" + localnaf.a(), "", "");
  }
  
  public void a(naf paramnaf)
  {
    this.jdField_a_of_type_Ndu.a(paramnaf);
  }
  
  public void a(ncq paramncq)
  {
    this.jdField_a_of_type_Ncq = paramncq;
    nht.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public boolean a()
  {
    naf localnaf = mzl.a().a();
    RoomInfo localRoomInfo = localnaf.a();
    int i = localnaf.a();
    return (localRoomInfo.getPlayers().size() < 8) && (i == 0);
  }
  
  public List<ncs> b()
  {
    return this.jdField_a_of_type_Ndu.a();
  }
  
  public void b()
  {
    nht.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(Player paramPlayer)
  {
    int i = 1;
    if ((mzl.a().a() == null) || (paramPlayer == null)) {
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
        ProfileActivity.b(this.jdField_a_of_type_Ncq.a(), (ProfileActivity.AllInOne)localObject);
        localObject = mxz.b(paramPlayer);
        if ((localObject != null) && (((UserInfo)localObject).a))
        {
          bcef.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, "" + mzl.a().a().a(), "", "");
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
    if ((mzl.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Ncq.a();
    String str1 = mzl.a().a().getCurrentAccountUin();
    naf localnaf = mzl.a().a();
    String str2 = "roomid=" + localnaf.a();
    aabc.a(localBaseActivity, paramPlayer.uin, "", str2, str1, 25031, null);
    bcef.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer.uin, "" + localnaf.a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndx
 * JD-Core Version:    0.7.0.1
 */