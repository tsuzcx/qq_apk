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

public class ncs
  implements nco
{
  private Runnable a;
  protected nbp a;
  protected ncp a;
  
  public ncs(ncp paramncp)
  {
    this.jdField_a_of_type_JavaLangRunnable = new SeatPresenterImp.1(this);
    this.jdField_a_of_type_Ncp = paramncp;
  }
  
  public int a(String paramString)
  {
    return myk.a().a().a(paramString);
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Ncp.a();
  }
  
  public RectF a(long paramLong)
  {
    return this.jdField_a_of_type_Ncp.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.jdField_a_of_type_Nbp.a(paramString);
  }
  
  public List<ncr> a()
  {
    int i4 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Nbp.c();
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    int k = 0;
    int j = i4;
    int m;
    if (i1 < localList.size())
    {
      ncr localncr = new ncr();
      localncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localList.get(i1));
      localArrayList.add(localncr);
      m = a(localncr.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
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
      m = a(((ncr)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m <= 0) {}
      for (;;)
      {
        j += 1;
        break;
        if (m == k) {
          ((ncr)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((ncr)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((ncr)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nbp.a();
    AVGameAppInterface localAVGameAppInterface = myk.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    mze localmze = myk.a().a();
    long l = localmze.a();
    String str2 = localmze.a().getNick(str1);
    aono.a().a(localAVGameAppInterface, localBaseActivity, l, Long.valueOf(str1).longValue(), str2, localmze.d());
    this.jdField_a_of_type_Nbp.a().b(this.jdField_a_of_type_Nbp.a().getString(2131690282));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ncp.a(paramLong, paramBoolean);
  }
  
  public void a(Player paramPlayer)
  {
    if ((myk.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    mze localmze = myk.a().a();
    String str = myk.a().a().getCurrentAccountUin();
    myk.a().c(localmze.a(), str, paramPlayer.uin);
    bdll.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer.uin, "" + localmze.a(), "", "");
  }
  
  public void a(mze parammze)
  {
    this.jdField_a_of_type_Ncp.a(parammze);
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nbp = paramnbp;
    ngk.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public boolean a()
  {
    mze localmze = myk.a().a();
    RoomInfo localRoomInfo = localmze.a();
    int i = localmze.a();
    if (localmze.a() != null) {
      int j = localmze.a().status;
    }
    return (localRoomInfo.getPlayers().size() < 8) && (i == 0);
  }
  
  public List<nbr> b()
  {
    return this.jdField_a_of_type_Ncp.a();
  }
  
  public void b()
  {
    ngk.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(Player paramPlayer)
  {
    int i = 1;
    if ((myk.a().a() == null) || (paramPlayer == null)) {
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
        ProfileActivity.b(this.jdField_a_of_type_Nbp.a(), (ProfileActivity.AllInOne)localObject);
        localObject = mxo.b(paramPlayer);
        if ((localObject != null) && (((UserInfo)localObject).a))
        {
          bdll.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, "" + myk.a().a().a(), "", "");
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
    if ((myk.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nbp.a();
    String str1 = myk.a().a().getCurrentAccountUin();
    mze localmze = myk.a().a();
    String str2 = "roomid=" + localmze.a();
    aber.a(localBaseActivity, paramPlayer.uin, "", str2, str1, 25031, null);
    bdll.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer.uin, "" + localmze.a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncs
 * JD-Core Version:    0.7.0.1
 */