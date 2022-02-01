import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ndm
  implements BusinessObserver
{
  public final String a;
  
  public ndm()
  {
    this.jdField_a_of_type_JavaLangString = "AvGameRoomListObserver";
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 6))
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue(), ((Long)paramObject[5]).longValue());
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateJoinRoom 参数 个数异常");
    a(-1, "", null, null, -1L, 0L);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 6))
    {
      paramObject = (Object[])paramObject;
      b(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (RoomInfo)paramObject[2], (byte[])paramObject[3], ((Long)paramObject[4]).longValue(), ((Long)paramObject[5]).longValue());
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateJoinRoom 参数 个数异常");
    b(-1, "", null, null, -1L, 0L);
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 7))
    {
      paramObject = (Object[])paramObject;
      ndn localndn = new ndn(this);
      localndn.jdField_a_of_type_JavaLangString = ((String)paramObject[2]);
      localndn.jdField_a_of_type_JavaUtilList = ((List)paramObject[3]);
      localndn.jdField_a_of_type_Int = ((Integer)paramObject[4]).intValue();
      localndn.b = ((Integer)paramObject[5]).intValue();
      localndn.c = ((Integer)paramObject[6]).intValue();
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], localndn);
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetGroupRoomList 参数个数异常");
    a(-1, "", null);
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 3))
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateReceiveGroupRoomChangePush 参数个数异常");
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 3))
    {
      paramObject = (Object[])paramObject;
      b(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2]);
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateDestroyAllGameRoom 参数个数异常");
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 2))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue());
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetGameShare 参数个数异常");
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 4))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    }
    QLog.e("AvGameRoomListObserver", 2, "onUpdateGetShareInviteBackflowInfo 参数个数异常");
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString, ndn paramndn) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  protected void a(boolean paramBoolean, long paramLong, List<nph> paramList, npi paramnpi, List<nek> paramList1, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void b(int paramInt, String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          do
          {
            return;
            a(paramBoolean, paramObject);
            return;
            b(paramBoolean, paramObject);
            return;
            c(paramBoolean, paramObject);
            return;
            d(paramBoolean, paramObject);
            return;
            e(paramBoolean, paramObject);
            return;
            f(paramBoolean, paramObject);
            return;
            g(paramBoolean, paramObject);
            return;
            paramObject = (Object[])paramObject;
          } while ((paramObject == null) || (paramObject.length <= 3));
          a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
          return;
          paramObject = (Object[])paramObject;
        } while ((paramObject == null) || (paramObject.length <= 2));
        a(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
        if ((paramObject != null) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 6))
        {
          paramObject = (Object[])paramObject;
          a(paramBoolean, ((Long)paramObject[0]).longValue(), (List)paramObject[1], (npi)paramObject[2], (List)paramObject[3], ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
          return;
        }
        QLog.e("AvGameRoomListObserver", 2, "AvGameRoomListHandler.TYPE_GAME_ENTRY_LOBBY_INFO 参数个数异常");
        return;
        paramObject = (Object[])paramObject;
      } while ((paramObject == null) || (paramObject.length <= 1));
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
      return;
    case 12: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length > 2))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
        return;
      }
      QLog.e("AvGameRoomListObserver", 2, "AvGameRoomListHandler.TYPE_GAME_LOBBY_PK_RESERVE 参数个数异常");
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndm
 * JD-Core Version:    0.7.0.1
 */