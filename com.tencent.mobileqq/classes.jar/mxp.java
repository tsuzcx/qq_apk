import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mxp
  implements anui
{
  public final String a;
  
  public mxp()
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
      mxq localmxq = new mxq(this);
      localmxq.jdField_a_of_type_JavaLangString = ((String)paramObject[2]);
      localmxq.jdField_a_of_type_JavaUtilList = ((List)paramObject[3]);
      localmxq.jdField_a_of_type_Int = ((Integer)paramObject[4]).intValue();
      localmxq.b = ((Integer)paramObject[5]).intValue();
      localmxq.c = ((Integer)paramObject[6]).intValue();
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], localmxq);
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
  
  public void a(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString, mxq parammxq) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void b(int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong1, long paramLong2) {}
  
  public void b(int paramInt, String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b(paramBoolean, paramObject);
      return;
    case 3: 
      c(paramBoolean, paramObject);
      return;
    case 4: 
      d(paramBoolean, paramObject);
      return;
    case 5: 
      e(paramBoolean, paramObject);
      return;
    case 6: 
      f(paramBoolean, paramObject);
      return;
    }
    g(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxp
 * JD-Core Version:    0.7.0.1
 */