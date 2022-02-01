import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mzj
  implements anil
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
      mxp localmxp = (mxp)paramObject[4];
      List localList1 = (List)paramObject[5];
      List localList2 = (List)paramObject[6];
      i = ((Integer)paramObject[7]).intValue();
      String str2 = (String)paramObject[8];
      String str3 = (String)paramObject[9];
      a(str1, bool, ((Integer)paramObject[10]).intValue(), (RoomInfo)localObject, localmxp, localList1, localList2, i, str2, str3);
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
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4], (RoomInfo)paramObject[5], ((Integer)paramObject[6]).intValue());
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
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2) {}
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, RoomInfo paramRoomInfo) {}
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(long paramLong, String paramString1, List<myh> paramList, String paramString2, String paramString3) {}
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(RoomInfo paramRoomInfo, int paramInt) {}
  
  public void a(String paramString1, long paramLong, String paramString2) {}
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, mxp parammxp, List<UserScore> paramList, List<myg> paramList1, int paramInt2, String paramString2, String paramString3) {}
  
  public void a(List<myg> paramList, int paramInt, String paramString1, String paramString2, long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void b(long paramLong1, long paramLong2) {}
  
  public void c(long paramLong1, long paramLong2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return;
    case 1: 
      d(paramBoolean, paramObject);
      return;
    case 2: 
      e(paramBoolean, paramObject);
      return;
    case 3: 
      g(paramBoolean, paramObject);
      return;
    case 4: 
      h(paramBoolean, paramObject);
      return;
    case 5: 
      i(paramBoolean, paramObject);
      return;
    case 6: 
      a(paramBoolean, paramObject);
      return;
    case 20: 
      j(paramBoolean, paramObject);
      return;
    case 21: 
      k(paramBoolean, paramObject);
      return;
    case 22: 
      l(paramBoolean, paramObject);
      return;
    case 23: 
      m(paramBoolean, paramObject);
      return;
    case 24: 
      n(paramBoolean, paramObject);
      return;
    case 7: 
      b(paramBoolean, paramObject);
      return;
    case 8: 
      c(paramBoolean, paramObject);
      return;
    }
    f(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzj
 * JD-Core Version:    0.7.0.1
 */