import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class kkw
  extends SosoInterface.OnLocationListener
{
  public kkw(AddContactTroopHandler paramAddContactTroopHandler, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB1, AddContactTroopHandler.IGetPopClassAndSearchCB paramIGetPopClassAndSearchCB2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0) {}
    try
    {
      paramSosoLbsInfo = AddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo);
      AddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo, this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
      AddContactTroopHandler.b(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler, paramSosoLbsInfo, this.b);
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
      this.b.b();
    }
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB.b();
    this.b.b();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkw
 * JD-Core Version:    0.7.0.1
 */