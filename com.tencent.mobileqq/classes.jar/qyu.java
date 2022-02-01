import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct;
import com.tencent.common.app.BaseApplicationImpl;

public class qyu
  implements qyz
{
  public qyu(RIJRedPacketManager paramRIJRedPacketManager, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2, qzc paramqzc) {}
  
  public void a()
  {
    this.jdField_a_of_type_Qzc.a(BaseApplicationImpl.getApplication().getString(2131717129));
  }
  
  public void a(int paramInt, long paramLong, String paramString1, qzh paramqzh, String paramString2, String paramString3, String paramString4)
  {
    if (paramInt == 0)
    {
      paramString4 = ohp.a(this.jdField_a_of_type_AndroidAppActivity, 17);
      RIJRedPacketManager.OpenRedPacketResultStruct localOpenRedPacketResultStruct = new RIJRedPacketManager.OpenRedPacketResultStruct();
      localOpenRedPacketResultStruct.jdField_a_of_type_Long = paramLong;
      localOpenRedPacketResultStruct.jdField_a_of_type_JavaLangString = paramString1;
      if (paramqzh != null)
      {
        localOpenRedPacketResultStruct.jdField_a_of_type_Boolean = true;
        localOpenRedPacketResultStruct.jdField_b_of_type_JavaLangString = paramqzh.jdField_a_of_type_JavaLangString;
        localOpenRedPacketResultStruct.c = paramqzh.jdField_b_of_type_JavaLangString;
        localOpenRedPacketResultStruct.d = paramqzh.c;
      }
      for (;;)
      {
        localOpenRedPacketResultStruct.e = paramString2;
        localOpenRedPacketResultStruct.f = paramString3;
        paramString4.putExtra("key_open_red_packet_result", localOpenRedPacketResultStruct);
        paramString4.putExtra("redpackid", this.jdField_a_of_type_JavaLangString);
        paramString4.putExtra("share_source_from_content", this.jdField_a_of_type_Int);
        paramString4.putExtra("redpack_type", 2);
        paramString4.putExtra("plat_source", this.jdField_b_of_type_Int);
        paramString4.putExtra("roykey", this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString4);
        return;
        localOpenRedPacketResultStruct.jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Qzc.a(paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyu
 * JD-Core Version:    0.7.0.1
 */