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

public class nbf
  implements nbb
{
  private Runnable a;
  protected nal a;
  protected nbc a;
  
  public nbf(nbc paramnbc)
  {
    this.jdField_a_of_type_JavaLangRunnable = new SeatPresenterImp.1(this);
    this.jdField_a_of_type_Nbc = paramnbc;
  }
  
  public int a(String paramString)
  {
    return mxl.a().a().a(paramString);
  }
  
  public RectF a(long paramLong)
  {
    return this.jdField_a_of_type_Nbc.a(paramLong);
  }
  
  public AVGameUserInfo a(String paramString)
  {
    return this.jdField_a_of_type_Nal.a(paramString);
  }
  
  public List<nbe> a()
  {
    int i4 = 0;
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_Nal.c();
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    int k = 0;
    int j = i4;
    int m;
    if (i1 < localList.size())
    {
      nbe localnbe = new nbe();
      localnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = ((Player)localList.get(i1));
      localArrayList.add(localnbe);
      m = a(localnbe.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
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
      m = a(((nbe)localArrayList.get(j)).jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin);
      if (m <= 0) {}
      for (;;)
      {
        j += 1;
        break;
        if (m == k) {
          ((nbe)localArrayList.get(j)).jdField_a_of_type_Int = 1;
        } else if (m == i) {
          ((nbe)localArrayList.get(j)).jdField_a_of_type_Int = 2;
        } else if (m == i2) {
          ((nbe)localArrayList.get(j)).jdField_a_of_type_Int = 3;
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nal.a();
    AVGameAppInterface localAVGameAppInterface = mxl.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    myc localmyc = mxl.a().a();
    long l = localmyc.a();
    String str2 = localmyc.a().getNick(str1);
    aobd.a().a(localAVGameAppInterface, localBaseActivity, l, Long.valueOf(str1).longValue(), str2, localmyc.d());
    this.jdField_a_of_type_Nal.a().b(this.jdField_a_of_type_Nal.a().getString(2131690277));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Nbc.a(paramLong, paramBoolean);
  }
  
  public void a(Player paramPlayer)
  {
    if ((mxl.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    myc localmyc = mxl.a().a();
    String str = mxl.a().a().getCurrentAccountUin();
    mxl.a().c(localmyc.a(), str, paramPlayer.uin);
    bcst.b(null, "dc00898", "", "", "0X800B02D", "0X800B02D", 0, 0, paramPlayer.uin, "" + localmyc.a(), "", "");
  }
  
  public void a(myc parammyc)
  {
    this.jdField_a_of_type_Nbc.a(parammyc);
  }
  
  public void a(nal paramnal)
  {
    this.jdField_a_of_type_Nal = paramnal;
    neq.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public boolean a()
  {
    myc localmyc = mxl.a().a();
    RoomInfo localRoomInfo = localmyc.a();
    int i = localmyc.a();
    if (localmyc.a() != null) {
      int j = localmyc.a().status;
    }
    return (localRoomInfo.getPlayers().size() < 8) && (i == 0);
  }
  
  public List<nan> b()
  {
    return this.jdField_a_of_type_Nbc.a();
  }
  
  public void b()
  {
    neq.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(Player paramPlayer)
  {
    int i = 1;
    if ((mxl.a().a() == null) || (paramPlayer == null)) {
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
        ProfileActivity.b(this.jdField_a_of_type_Nal.a(), (ProfileActivity.AllInOne)localObject);
        localObject = mwp.b(paramPlayer);
        if ((localObject != null) && (((UserInfo)localObject).a))
        {
          bcst.b(null, "dc00898", "", "", "0X800B02B", "0X800B02B", i, 0, paramPlayer, "" + mxl.a().a().a(), "", "");
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
    if ((mxl.a().a() == null) || (paramPlayer == null)) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Nal.a();
    String str1 = mxl.a().a().getCurrentAccountUin();
    myc localmyc = mxl.a().a();
    String str2 = "roomid=" + localmyc.a();
    abao.a(localBaseActivity, paramPlayer.uin, "", str2, str1, 25031, null);
    bcst.b(null, "dc00898", "", "", "0X800B02C", "0X800B02C", 0, 0, paramPlayer.uin, "" + localmyc.a(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbf
 * JD-Core Version:    0.7.0.1
 */