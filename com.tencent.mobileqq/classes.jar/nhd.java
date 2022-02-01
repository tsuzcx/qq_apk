import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class nhd
  implements BusinessObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
      return;
    }
    b(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 2))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue());
      return;
    }
    QLog.e("GameRoomObserver", 2, "handleGetGameShare 参数个数异常");
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    boolean bool = ((Boolean)paramObject[0]).booleanValue();
    long l = ((Long)paramObject[1]).longValue();
    String str1 = (String)paramObject[2];
    if (paramBoolean)
    {
      localObject = (RoomInfo)paramObject[3];
      nfg localnfg = (nfg)paramObject[4];
      List localList1 = (List)paramObject[5];
      List localList2 = (List)paramObject[6];
      i = ((Integer)paramObject[7]).intValue();
      String str2 = (String)paramObject[8];
      String str3 = (String)paramObject[9];
      a(str1, bool, ((Integer)paramObject[10]).intValue(), (RoomInfo)localObject, localnfg, localList1, localList2, i, str2, str3);
      return;
    }
    Object localObject = (String)paramObject[3];
    int i = ((Integer)paramObject[4]).intValue();
    a(l, str1, bool, ((Integer)paramObject[5]).intValue(), (String)localObject, i);
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a((List)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3], ((Long)paramObject[4]).longValue());
      return;
    }
    a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Object[])) || (((Object[])paramObject).length != 5))
    {
      QLog.e("GameRoomObserver", 2, "handleOnGetGameQuestionClass 参数个数异常");
      return;
    }
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), (String)paramObject[1], (List)paramObject[2], (String)paramObject[3], (String)paramObject[4]);
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    long l = ((Long)paramObject[0]).longValue();
    int i = ((Integer)paramObject[1]).intValue();
    String str = (String)paramObject[2];
    if (paramBoolean)
    {
      a(l, i, str, (RoomInfo)paramObject[3]);
      return;
    }
    a(l, i, str, (String)paramObject[3]);
  }
  
  private void h(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a((RoomInfo)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void i(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), (String)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a((String)paramObject[0], ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
  }
  
  private void j(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (RoomInfo)paramObject[5]);
  }
  
  private void k(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (RoomInfo)paramObject[5], ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8], (String)paramObject[9]);
  }
  
  private void l(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    c(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void m(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (RoomInfo)paramObject[4]);
  }
  
  private void n(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2) {}
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo) {}
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, RoomInfo paramRoomInfo) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2, int paramInt3, String paramString3, String paramString4) {}
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, RoomInfo paramRoomInfo) {}
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, String paramString1, List<ngb> paramList, String paramString2, String paramString3) {}
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(RoomInfo paramRoomInfo, int paramInt) {}
  
  public void a(String paramString1, long paramLong, String paramString2) {}
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, nfg paramnfg, List<UserScore> paramList, List<nga> paramList1, int paramInt2, String paramString2, String paramString3) {}
  
  public void a(List<nga> paramList, int paramInt, String paramString1, String paramString2, long paramLong) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, List<Long> paramList, int paramInt3, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, nfy paramnfy) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo) {}
  
  protected void a(boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  protected void b(long paramLong, int paramInt) {}
  
  public void b(long paramLong1, long paramLong2) {}
  
  protected void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong) {}
  
  public void c(long paramLong1, long paramLong2) {}
  
  protected void d(long paramLong1, long paramLong2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 18: 
    case 19: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 25: 
    case 14: 
    case 17: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                d(paramBoolean, paramObject);
                return;
                e(paramBoolean, paramObject);
                return;
                g(paramBoolean, paramObject);
                return;
                h(paramBoolean, paramObject);
                return;
                i(paramBoolean, paramObject);
                return;
                a(paramBoolean, paramObject);
                return;
                j(paramBoolean, paramObject);
                return;
                k(paramBoolean, paramObject);
                return;
                l(paramBoolean, paramObject);
                return;
                m(paramBoolean, paramObject);
                return;
                n(paramBoolean, paramObject);
                return;
                b(paramBoolean, paramObject);
                return;
                c(paramBoolean, paramObject);
                return;
                f(paramBoolean, paramObject);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (nfy)paramObject[2]);
                return;
                paramObject = (Object[])paramObject;
                a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
                return;
                paramObject = (Object[])paramObject;
              } while ((paramObject == null) || (paramObject.length <= 3));
              a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
              return;
              paramObject = (Object[])paramObject;
            } while ((paramObject == null) || (paramObject.length <= 2));
            a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
            return;
            paramObject = (Object[])paramObject;
          } while ((paramObject == null) || (paramObject.length <= 1));
          b(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
          return;
          paramObject = (Object[])paramObject;
        } while ((paramObject == null) || (paramObject.length <= 4));
        a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
        return;
        paramObject = (Object[])paramObject;
      } while ((paramObject == null) || (paramObject.length <= 3));
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
      return;
    case 26: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), ((Long)paramObject[2]).longValue());
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue());
      return;
    case 16: 
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue());
      return;
    case 27: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue(), (SurvivalPkResultInfo)paramObject[4]);
      return;
    case 28: 
      paramObject = (Object[])paramObject;
      d(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhd
 * JD-Core Version:    0.7.0.1
 */