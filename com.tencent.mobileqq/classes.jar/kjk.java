import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;

public class kjk
  extends TroopObserver
{
  public kjk(JoinGroupHandler paramJoinGroupHandler) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.jdField_a_of_type_Long = 0L;
    JoinGroupHandler.a(this.a);
    if (paramBoolean)
    {
      JoinGroupHandler.a(this.a, paramTroopInfo);
      return;
    }
    JoinGroupHandler.a(this.a, 2131434447, 1);
    this.a.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kjk
 * JD-Core Version:    0.7.0.1
 */