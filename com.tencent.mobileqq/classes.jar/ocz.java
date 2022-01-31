import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class ocz
  implements Runnable
{
  public ocz(EditVideoFilterNeo paramEditVideoFilterNeo, AddressDataProvider.AddressInfo paramAddressInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilterNeo.a.a(Message.obtain(null, 5, 0, 0, this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo));
    String str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo.c)) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo.b)) {
        str = this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo.a;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilterNeo.a.a.a.putString("extra_local_address_city_name", str);
      return;
      str = this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo.b;
      continue;
      str = this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocz
 * JD-Core Version:    0.7.0.1
 */